package com.example.mvptask.utils;

import com.example.mvptask.R;
import com.example.mvptask.TaskApplication;
import com.example.mvptask.callback.Callback;
import com.example.mvptask.model.BankDetails;
import com.example.mvptask.model.BankDetailsChildList;
import com.example.mvptask.model.BankDetailsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public final class JsonUtils {

    public static final String JSON_FILE_NAME  =  "data.json";

    /**
     *
     * @param callback
     */
    public static void getBankData(final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BankDetailsList listObject = parseBankData();
                if(listObject==null) {
                    callback.onFailure(TaskApplication.getGlobalContext().getString(R.string.list_error));
                } else {
                    callback.onLoadData(listObject.getAccountData());
                }
            }
        }).start();
    }

    /**
     *
     * @return BankDetailsList
     * Parse JSON and return BankDetailsList
     */
    private static BankDetailsList parseBankData() {
        BankDetailsList listObject = null;

        try {
            JSONObject jsonObject = new JSONObject(CommonUtils.loadJSONFromAsset(JSON_FILE_NAME));
            JSONArray jsonBankListArray =  jsonObject.getJSONArray(AppConstants.BANK_ACCOUNT_LIST);

            List<BankDetails> bankDetailsList = new ArrayList<>();

            listObject = new BankDetailsList();

            for(int i=0; i<jsonBankListArray.length(); i++){
                JSONObject obj = jsonBankListArray.getJSONObject(i);

                BankDetails bankDetails =  new BankDetails();
                bankDetails.setName(obj.getString("name"));
                bankDetails.setAmount(obj.getDouble("amount"));
                bankDetails.setCurrencySymbol(obj.getString("currency_symbol"));

                JSONArray jsonBankChildListArray =  obj.getJSONArray(AppConstants.BANK_ACCOUNT_CHILD_LIST);
                List<BankDetailsChildList> bankDetailsChildList = new ArrayList<>();
                for(int j=0; j<jsonBankChildListArray.length(); j++) {
                    JSONObject childObj = jsonBankChildListArray.getJSONObject(j);

                    BankDetailsChildList bankDetailsChildListObj =  new BankDetailsChildList();
                    bankDetailsChildListObj.setNameChild(childObj.getString("name_child"));
                    bankDetailsChildListObj.setFrostId(childObj.getString("frost_id"));
                    bankDetailsChildListObj.setAmount(childObj.getDouble("amount"));
                    bankDetailsChildListObj.setCurrencySymbol(childObj.getString("currency_symbol"));

                    bankDetailsChildList.add(bankDetailsChildListObj);
                }
                bankDetails.setAccountChildDetails(bankDetailsChildList);

                bankDetailsList.add(bankDetails);
            }
            listObject.setAccountData(bankDetailsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listObject;
    }

    /**
     * Prevent this class publicly instantiable
     */
    private JsonUtils() {
    }
}