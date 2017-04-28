package com.erostech.enlightenme.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.enlightenme.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainListingFragment extends Fragment {

    public MainListingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_listing, container, false);

        return view;
    }
}
