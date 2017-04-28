package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class ImageSearchResponse implements Parcelable {
    @SerializedName("data")
    @Expose
    private List<Image> data;

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("per_page")
    @Expose
    private int perPage;

    @SerializedName("total_count")
    @Expose
    private List<Image> totalCount;

    @SerializedName("search_id")
    @Expose
    private String searchId;

    @SerializedName("message")
    @Expose
    private String message;

    public ImageSearchResponse() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private ImageSearchResponse(Parcel in) {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<ImageSearchResponse> CREATOR
            = new Parcelable.Creator<ImageSearchResponse>() {
        public ImageSearchResponse createFromParcel(Parcel in) {
            return new ImageSearchResponse(in);
        }

        public ImageSearchResponse[] newArray(int size) {
            return new ImageSearchResponse[size];
        }
    };
}
