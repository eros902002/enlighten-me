package com.erostech.enlightenme.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.erostech.enlightenme.R;
import com.erostech.enlightenme.ui.fragments.MainListingFragment;
import com.erostech.enlightenme.ui.views.CustomSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainListingActivity extends AppCompatActivity {
    private CustomSearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, MainListingFragment.newInstance())
                .commit();
    }
}
