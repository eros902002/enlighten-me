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
        description = in.readString();
        addedDate = in.readString();
        mediaType = in.readString();
        contributor = in.readParcelable(Contributor.class.getClassLoader());
        aspect = in.readDouble();
        imageType = in.readString();
        isEditorial = in.readByte() != 0;
        isAdult = in.readByte() != 0;
        isIllustration = in.readByte() != 0;
        hasModelRelease = in.readByte() != 0;
        hasPropertyRelease = in.readByte() != 0;

        releases = new ArrayList<>();
        in.readStringList(releases);

        modelReleases = new ArrayList<>();
        in.readList(modelReleases, ModelRelease.class.getClassLoader());

        categories = new ArrayList<>();
        in.readList(categories, Category.class.getClassLoader());

        keywords = new ArrayList<>();
        in.readStringList(keywords);

        assets = new ArrayList<>();
        in.readList(assets, ImageAssets.class.getClassLoader());

        models = new ArrayList<>();
        in.readList(models, Model.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(description);
        dest.writeString(addedDate);
        dest.writeString(mediaType);
        dest.writeParcelable(contributor, flags);
        dest.writeDouble(aspect.doubleValue());
        dest.writeString(imageType);
        dest.writeByte((byte) (isEditorial ? 1 : 0));
        dest.writeByte((byte) (isAdult ? 1 : 0));
        dest.writeByte((byte) (isIllustration ? 1 : 0));
        dest.writeByte((byte) (hasModelRelease ? 1 : 0));
        dest.writeByte((byte) (hasPropertyRelease ? 1 : 0));

        dest.writeList(releases);
        dest.writeList(modelReleases);
        dest.writeList(categories);
        dest.writeList(keywords);
        dest.writeList(assets);
        dest.writeList(models);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public Number getAspect() {
        return aspect;
    }

    public void setAspect(Number aspect) {
        this.aspect = aspect;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public boolean isEditorial() {
        return isEditorial;
    }

    public void setEditorial(boolean editorial) {
        isEditorial = editorial;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public boolean isIllustration() {
        return isIllustration;
    }

    public void setIllustration(boolean illustration) {
        isIllustration = illustration;
    }

    public boolean isHasModelRelease() {
        return hasModelRelease;
    }

    public void setHasModelRelease(boolean hasModelRelease) {
        this.hasModelRelease = hasModelRelease;
    }

    public boolean isHasPropertyRelease() {
        return hasPropertyRelease;
    }

    public void setHasPropertyRelease(boolean hasPropertyRelease) {
        this.hasPropertyRelease = hasPropertyRelease;
    }

    public List<String> getReleases() {
        return releases;
    }

    public void setReleases(List<String> releases) {
        this.releases = releases;
    }

    public List<ModelRelease> getModelReleases() {
        return modelReleases;
    }

    public void setModelReleases(List<ModelRelease> modelReleases) {
        this.modelReleases = modelReleases;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<ImageAssets> getAssets() {
        return assets;
    }

    public void setAssets(List<ImageAssets> assets) {
        this.assets = assets;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
