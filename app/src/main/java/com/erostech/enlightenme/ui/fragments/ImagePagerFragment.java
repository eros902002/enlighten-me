package com.erostech.enlightenme.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.enlightenme.Constants;
import com.erostech.enlightenme.R;
import com.erostech.enlightenme.adapters.ImageDetailPagerAdapter;
import com.erostech.enlightenme.data.models.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erosgarciaponte on 08/05/2017.
 */

public class ImagePagerFragment extends Fragment {

    public static ImagePagerFragment newInstance(int currentPos, ArrayList<Image> images) {

        Bundle args = new Bundle();
        args.putInt(Constants.EXTRA_IMAGE_POSITION, currentPos);
        args.putParcelableArrayList(Constants.EXTRA_IMAGES, images);

        ImagePagerFragment fragment = new ImagePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ImagePagerFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //postponeEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
        setSharedElementReturnTransition(null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int currentItem = getArguments().getInt(Constants.EXTRA_IMAGE_POSITION);
        ArrayList<Image> images = getArguments().getParcelableArrayList(Constants.EXTRA_IMAGES);

        ImageDetailPagerAdapter pagerAdapter = new ImageDetailPagerAdapter(getChildFragmentManager(), images);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.image_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(currentItem);
    }
}
