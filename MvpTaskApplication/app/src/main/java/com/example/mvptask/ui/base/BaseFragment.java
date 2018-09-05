package com.example.mvptask.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment {

    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public interface FragmentCallback {

        void setTitle(String title);

        void navigateFragment(Fragment fragment, Bundle bundle, boolean addToBackStack,int fragment_container_id);
    }
}
