package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class Model implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    public Model() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Model(Parcel in) {
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    public static final Parcelable.Creator<Model> CREATOR
            = new Parcelable.Creator<Model>() {
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
