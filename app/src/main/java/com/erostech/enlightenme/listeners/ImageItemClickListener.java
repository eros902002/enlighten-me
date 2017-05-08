package com.erostech.enlightenme.listeners;

import android.widget.ImageView;

import com.erostech.enlightenme.data.models.Image;

/**
 * Created by erosgarciaponte on 08/05/2017.
 */

public interface ImageItemClickListener {
    void onImageItemClick(int position, Image image, ImageView imageView);
}
