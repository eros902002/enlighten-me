package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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
    private int totalCount;

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
        data = new ArrayList<>();
        in.readList(data, Image.class.getClassLoader());
        page = in.readInt();
        perPage = in.readInt();
        totalCount = in.readInt();
        searchId = in.readString();
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeInt(page);
        dest.writeInt(perPage);
        dest.writeInt(totalCount);
        dest.writeString(searchId);
        dest.writeString(message);
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

    public List<Image> getData() {
        return data;
    }

    public void setData(List<Image> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
