package com.example.mvptask.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.mvptask.R;
import com.example.mvptask.adapters.AccountAdapter;
import com.example.mvptask.model.BankDetails;
import com.example.mvptask.model.BankDetailsChildList;
import com.example.mvptask.ui.base.BaseFragment;
import com.example.mvptask.ui.details.DetailsFragment;
import com.example.mvptask.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment implements MainContract.MainView {

    /**
     * Fragment Callback to communicate with fragment
     */
    private FragmentCallback mCallback;

    /**
     * ExpandableListView to hold the BankAccount Details
     */
    private ExpandableListView expListBank;

    /**
     * Adapter to bind the BankAccount data
     */
    private AccountAdapter mAdapter;

    /**
     * BankAccount List
     */
    private List<BankDetails> bankDetailsList = new ArrayList<>();


    private MainContract.MainPresenter presenter;

    public MainFragment() {
    }

    /**
     * @param context
     */
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
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =  new MainPresenterImpl(this, new MainModelImpl());
        mCallback.setTitle(getString(R.string.bank_list_my_account));
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank_list, container, false);
        expListBank =  view.findViewById(R.id.expListBank);

        setAdapter();
        setExpListListener();

        presenter.loadMyAccountData();

        return view;
    }

    /**
     * Set the adapter
     */
    private void setAdapter() {
        mAdapter = new AccountAdapter(getActivity(),bankDetailsList);
        expListBank.setAdapter(mAdapter);
    }

    /**
     * Child view click listener
     * and open the DetailFragment
     */
    private void setExpListListener() {
        expListBank.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                BankDetailsChildList childData =  bankDetailsList.get(groupPosition).getAccountChildDetails().get(childPosition);
                Bundle bundle = new Bundle();
                bundle.putSerializable(AppConstants.BANK_LIST_DETAILS,childData);
                /*
                ActivityUtils.addFragmentToActivity(getActivity().getSupportFragmentManager(),
                    new DetailsFragment(),bundle,true);
                */
                mCallback.navigateFragment(new DetailsFragment(),bundle,true,MainActivity.FRAGMENT_CONTAINER);
                return false;
            }
        });
    }

    /**
     * @param list
     * Refresh the adapter
     */
    @Override
    public void setMyAccountData(final List<BankDetails> list) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bankDetailsList.clear();
                bankDetailsList.addAll(list);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * @param message
     * Show error message
     */
    @Override
    public void onError(String message) {
        showToast(message);
    }

    /**
     * Show loader
     */
    @Override
    public void showLoading() {
    }

    /**
     * Hide loader
     */
    @Override
    public void hideLoading() {
    }
}
