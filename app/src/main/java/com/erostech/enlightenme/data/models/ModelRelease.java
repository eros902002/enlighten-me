package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class ModelRelease implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    public ModelRelease() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private ModelRelease(Parcel in) {
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    public static final Parcelable.Creator<ModelRelease> CREATOR
            = new Parcelable.Creator<ModelRelease>() {
        public ModelRelease createFromParcel(Parcel in) {
            return new ModelRelease(in);
        }

        public ModelRelease[] newArray(int size) {
            return new ModelRelease[size];
        }
    };
}
