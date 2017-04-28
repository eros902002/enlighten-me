package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class ImageAssets implements Parcelable {
    @SerializedName("small_jpg")
    @Expose
    private ImageSizeDetails smallJPG;

    @SerializedName("medium_jpg")
    @Expose
    private ImageSizeDetails mediumJPG;

    @SerializedName("huge_jpg")
    @Expose
    private ImageSizeDetails hugeJPG;

    @SerializedName("supersize_jpg")
    @Expose
    private ImageSizeDetails supersizeJPG;

    @SerializedName("huge_tiff")
    @Expose
    private ImageSizeDetails hugeTIFF;

    @SerializedName("supersize_tiff")
    @Expose
    private ImageSizeDetails supersizeTIFF;

    @SerializedName("vector_eps")
    @Expose
    private ImageSizeDetails vectorEPS;

    @SerializedName("small_thumb")
    @Expose
    private Thumbnail smallThumbnail;

    @SerializedName("large_thumb")
    @Expose
    private Thumbnail largeThumbnail;

    @SerializedName("preview")
    @Expose
    private Thumbnail preview;

    @SerializedName("preview_1000")
    @Expose
    private Thumbnail preview1000;

    @SerializedName("preview_1500")
    @Expose
    private Thumbnail preview1500;

    public ImageAssets() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private ImageAssets(Parcel in) {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<ImageAssets> CREATOR
            = new Parcelable.Creator<ImageAssets>() {
        public ImageAssets createFromParcel(Parcel in) {
            return new ImageAssets(in);
        }

        public ImageAssets[] newArray(int size) {
            return new ImageAssets[size];
        }
    };
}
