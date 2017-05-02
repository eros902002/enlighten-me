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
        smallJPG = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        mediumJPG = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        hugeJPG = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        supersizeJPG = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        hugeTIFF = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        supersizeTIFF = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        vectorEPS = in.readParcelable(ImageSizeDetails.class.getClassLoader());
        smallThumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        largeThumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        preview = in.readParcelable(Thumbnail.class.getClassLoader());
        preview1000 = in.readParcelable(Thumbnail.class.getClassLoader());
        preview1500 = in.readParcelable(Thumbnail.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(smallJPG, flags);
        dest.writeParcelable(mediumJPG, flags);
        dest.writeParcelable(hugeJPG, flags);
        dest.writeParcelable(supersizeJPG, flags);
        dest.writeParcelable(hugeTIFF, flags);
        dest.writeParcelable(supersizeTIFF, flags);
        dest.writeParcelable(vectorEPS, flags);
        dest.writeParcelable(smallThumbnail, flags);
        dest.writeParcelable(largeThumbnail, flags);
        dest.writeParcelable(preview, flags);
        dest.writeParcelable(preview1000, flags);
        dest.writeParcelable(preview1500, flags);
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
