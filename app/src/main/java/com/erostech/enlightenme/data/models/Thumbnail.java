package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class Thumbnail implements Parcelable {
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("width")
    @Expose
    private int width;

    public Thumbnail() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Thumbnail(Parcel in) {
        url = in.readString();
        height = in.readInt();
        width = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeInt(height);
        dest.writeInt(width);
    }

    public static final Parcelable.Creator<Thumbnail> CREATOR
            = new Parcelable.Creator<Thumbnail>() {
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
