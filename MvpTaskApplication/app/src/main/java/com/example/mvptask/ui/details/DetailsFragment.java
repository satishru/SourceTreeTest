package com.example.mvptask.ui.details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvptask.R;
import com.example.mvptask.model.BankDetailsChildList;
import com.example.mvptask.ui.base.BaseFragment;
import com.example.mvptask.utils.AppConstants;
import com.example.mvptask.utils.CommonUtils;

public class DetailsFragment extends BaseFragment {

    /**
     * Fragment Callback to communicate with fragment
     */
    private FragmentCallback mCallback;

    /**
     * TextView for account details name
     */
    private TextView account_details_name;
    /**
     * TextView for account details amount
     */
    private TextView account_details_amount;
    /**
     * TextView for account details frost id
     */
    private TextView account_details_frost_id;

    private BankDetailsChildList bankDetailsChildList;

    public DetailsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    /**
     * @param savedInstanceState
     * Get the argument bundle sent from BankListFragment
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bankDetailsChildList = (BankDetailsChildList) getArguments().getSerializable(AppConstants.BANK_LIST_DETAILS);
        }
        mCallback.setTitle(getString(R.string.bank_list_my_account_details));
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return inflated view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank_list_details, container, false);
        account_details_name     =  view.findViewById(R.id.account_details_name);
        account_details_amount   =  view.findViewById(R.id.account_details_amount);
        account_details_frost_id =  view.findViewById(R.id.account_details_frost_id);

        setData();
        return view;
    }

    /**
     * Sets the data
     */
    public void setData() {
        if (bankDetailsChildList != null) {
            account_details_name.setText(bankDetailsChildList.getNameChild());
            account_details_amount.setText(bankDetailsChildList.getCurrencySymbol()+ ""+
                    CommonUtils.formatDecimal(bankDetailsChildList.getAmount()));
            account_details_frost_id.setText(bankDetailsChildList.getFrostId());
        }
    }
}
