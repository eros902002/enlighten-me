package com.erostech.enlightenme.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class Image implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("added_date")
    @Expose
    private String addedDate;

    @SerializedName("media_type")
    @Expose
    private String mediaType;

    @SerializedName("contributor")
    @Expose
    private Contributor contributor;

    @SerializedName("aspect")
    @Expose
    private Number aspect;

    @SerializedName("image_type")
    @Expose
    private String imageType;

    @SerializedName("is_editorial")
    @Expose
    private boolean isEditorial;

    @SerializedName("is_adult")
    @Expose
    private boolean isAdult;

    @SerializedName("is_illustration")
    @Expose
    private boolean isIllustration;

    @SerializedName("has_model_release")
    @Expose
    private boolean hasModelRelease;

    @SerializedName("has_property_release")
    @Expose
    private boolean hasPropertyRelease;

    @SerializedName("releases")
    @Expose
    private List<String> releases;

    @SerializedName("model_releases")
    @Expose
    private List<ModelRelease> modelReleases;

    @SerializedName("categories")
    @Expose
    private List<Category> categories;

    @SerializedName("keywords")
    @Expose
    private List<String> keywords;

    @SerializedName("assets")
    @Expose
    private List<ImageAssets> assets;

    @SerializedName("models")
    @Expose
    private List<Model> models;

    public Image() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Image(Parcel in) {
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    public static final Parcelable.Creator<Image> CREATOR
            = new Parcelable.Creator<Image>() {
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
