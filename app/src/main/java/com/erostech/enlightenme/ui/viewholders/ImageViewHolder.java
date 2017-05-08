package com.erostech.enlightenme.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.erostech.enlightenme.R;
import com.erostech.enlightenme.data.models.Image;
import com.erostech.enlightenme.ui.activities.ImageDetailActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public TextView mDescriptionView;
    public ImageView mImageView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        mDescriptionView = (TextView) itemView.findViewById(R.id.image_description);
        mImageView = (ImageView) itemView.findViewById(R.id.image);
    }

    public void bind(Image image) {
        if (image != null) {
            mDescriptionView.setText(image.getDescription());
            Picasso.with(itemView.getContext())
                    .load(image.getAssets().getPreview().getUrl())
                    .resizeDimen(R.dimen.poster_thumb_size, R.dimen.poster_thumb_size)
                    .centerCrop()
                    .into(mImageView);
        }
    }
}
