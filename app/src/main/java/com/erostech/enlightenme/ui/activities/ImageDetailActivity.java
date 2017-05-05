package com.erostech.enlightenme.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.erostech.enlightenme.Constants;
import com.erostech.enlightenme.R;
import com.erostech.enlightenme.data.models.Image;

public class ImageDetailActivity extends AppCompatActivity {

    public static void start(@NonNull Context context, @NonNull Image image) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putExtra(Constants.EXTRA_IMAGE, image);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
