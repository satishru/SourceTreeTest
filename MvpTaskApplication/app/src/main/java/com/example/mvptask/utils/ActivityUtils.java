package com.example.mvptask.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.mvptask.R;

public final class ActivityUtils {
    /**
     *
     * @param fragmentManager
     * @param fragment
     * @param args
     * @param addToBackStack
     * Do the fragment transaction
     */
    public static void addFragmentToActivity (FragmentManager fragmentManager, Fragment fragment,
                                              Bundle args, boolean addToBackStack,int fragment_container_id) {
        fragment.setArguments(args);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(fragment_container_id, fragment);
        if(addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    /**
     * Prevent this class publicly instantiable
     */
    private ActivityUtils() {
    }
}
