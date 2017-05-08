package com.erostech.enlightenme.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.erostech.enlightenme.data.models.Image;
import com.erostech.enlightenme.ui.fragments.ImageDetailFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erosgarciaponte on 08/05/2017.
 */

public class ImageDetailPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Image> mImages;

    public ImageDetailPagerAdapter(FragmentManager fragmentManager, ArrayList<Image> images) {
        super(fragmentManager);
        this.mImages = images;
    }

    @Override
    public Fragment getItem(int position) {
        Image image = mImages.get(position);
        return ImageDetailFragment.newInstance(image);
    }

    @Override
    public int getCount() {
        return mImages == null ? 0 : mImages.size();
    }
}
