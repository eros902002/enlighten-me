package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class ImageSizeDetails implements Parcelable {
    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("file_size")
    @Expose
    private int fileSize;

    @SerializedName("display_name")
    @Expose
    private String displayName;

    @SerializedName("dpi")
    @Expose
    private int dpi;

    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("is_licensable")
    @Expose
    private boolean licensable;

    public ImageSizeDetails() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private ImageSizeDetails(Parcel in) {
        height = in.readInt();
        width = in.readInt();
        fileSize = in.readInt();
        displayName = in.readString();
        dpi = in.readInt();
        format = in.readString();
        licensable = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(height);
        dest.writeInt(width);
        dest.writeInt(fileSize);
        dest.writeString(displayName);
        dest.writeInt(dpi);
        dest.writeString(format);
        dest.writeByte((byte) (licensable ? 1 : 0));
    }

    public static final Parcelable.Creator<ImageSizeDetails> CREATOR
            = new Parcelable.Creator<ImageSizeDetails>() {
        public ImageSizeDetails createFromParcel(Parcel in) {
            return new ImageSizeDetails(in);
        }

        public ImageSizeDetails[] newArray(int size) {
            return new ImageSizeDetails[size];
        }
    };
}
