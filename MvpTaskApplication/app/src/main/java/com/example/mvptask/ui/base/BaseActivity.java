package com.example.mvptask.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public abstract class BaseActivity extends AppCompatActivity  implements BaseFragment.FragmentCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void setDrawerMenu();

    protected void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
