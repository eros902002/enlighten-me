package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class Contributor implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    public Contributor() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Contributor(Parcel in) {
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    public static final Parcelable.Creator<Contributor> CREATOR
            = new Parcelable.Creator<Contributor>() {
        public Contributor createFromParcel(Parcel in) {
            return new Contributor(in);
        }

        public Contributor[] newArray(int size) {
            return new Contributor[size];
        }
    };
}
