package com.erostech.enlightenme.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.erostech.enlightenme.Constants;
import com.erostech.enlightenme.R;
import com.erostech.enlightenme.data.models.Image;
import com.erostech.enlightenme.ui.fragments.ImageDetailFragment;
import com.erostech.enlightenme.ui.fragments.ImagePagerFragment;

import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity {

    public static void start(@NonNull Activity context, @NonNull ArrayList<Image> images, int position) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putExtra(Constants.EXTRA_IMAGES, images);
        intent.putExtra(Constants.EXTRA_IMAGE_POSITION, position);
        //intent.putExtra(Constants.EXTRA_IMAGE, image);
        //intent.putExtra(Constants.EXTRA_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(sharedImageView));

        /*ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context,
                sharedImageView,
                ViewCompat.getTransitionName(sharedImageView)
        );

        context.startActivity(intent, options.toBundle());*/
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*if (getIntent().hasExtra(Constants.EXTRA_IMAGE) && getIntent().hasExtra(Constants.EXTRA_IMAGE_TRANSITION_NAME)) {
            Image image = getIntent().getParcelableExtra(Constants.EXTRA_IMAGE);
            String transitionName = getIntent().getStringExtra(Constants.EXTRA_IMAGE_TRANSITION_NAME);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, ImageDetailFragment.newInstance(image, transitionName))
                    .commit();
        }*/
        if (getIntent().hasExtra(Constants.EXTRA_IMAGES) && getIntent().hasExtra(Constants.EXTRA_IMAGE_POSITION)) {
            ArrayList<Image> images = getIntent().getParcelableArrayListExtra(Constants.EXTRA_IMAGES);
            int position = getIntent().getIntExtra(Constants.EXTRA_IMAGE_POSITION, 0);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, ImagePagerFragment.newInstance(position, images))
                    .commit();
        }
    }

}
