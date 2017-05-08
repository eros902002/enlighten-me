package com.erostech.enlightenme.ui.fragments;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erostech.enlightenme.Constants;
import com.erostech.enlightenme.R;
import com.erostech.enlightenme.data.models.Image;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class ImageDetailFragment extends Fragment {
    private static final String TAG = ImageDetailFragment.class.getSimpleName();

    private TextView mDescriptionView;
    private ImageView mImageView;

    private Image mImage;

    public ImageDetailFragment() {
    }

    public static ImageDetailFragment newInstance(Image image) {

        return newInstance(image, null);
    }

    public static ImageDetailFragment newInstance(Image image, String transitionName) {
        
        Bundle args = new Bundle();
        args.putParcelable(Constants.EXTRA_IMAGE, image);
        if (transitionName != null) {
            args.putString(Constants.EXTRA_IMAGE_TRANSITION_NAME, transitionName);
        }

        ImageDetailFragment fragment = new ImageDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_detail, container, false);

        mDescriptionView = (TextView) view.findViewById(R.id.description);
        mImageView = (ImageView) view.findViewById(R.id.image);

        if (getArguments().containsKey(Constants.EXTRA_IMAGE)) {
            mImage = getArguments().getParcelable(Constants.EXTRA_IMAGE);
        } else {
            getActivity().finish();
        }

        if (getArguments().containsKey(Constants.EXTRA_IMAGE_TRANSITION_NAME) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String transitionName = getArguments().getString(Constants.EXTRA_IMAGE_TRANSITION_NAME);
            mImageView.setTransitionName(transitionName);
        }

        Picasso.with(getContext())
                .load(mImage.getAssets().getPreview().getUrl())
                .into(mImageView);

        mDescriptionView.setText(mImage.getDescription());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
