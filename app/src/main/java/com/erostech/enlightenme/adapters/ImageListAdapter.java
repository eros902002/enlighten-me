package com.erostech.enlightenme.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.enlightenme.R;
import com.erostech.enlightenme.callbacks.ImageListAdapterCallback;
import com.erostech.enlightenme.callbacks.LoadingViewHolderCallback;
import com.erostech.enlightenme.data.models.Image;
import com.erostech.enlightenme.ui.viewholders.ImageViewHolder;
import com.erostech.enlightenme.ui.viewholders.LoadingViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public class ImageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements LoadingViewHolderCallback {
    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private List<Image> mImages;
    private int totalPages;

    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    private ImageListAdapterCallback mCallback;
    private String errorMessage;

    public ImageListAdapter(ImageListAdapterCallback callback) {
        this.mCallback = callback;
        this.mImages = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                getViewHolder(parent, inflater);
                break;
            case LOADING:
                View view = inflater.inflate(R.layout.item_progress_list, parent, false);
                viewHolder = new LoadingViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View view = inflater.inflate(R.layout.item_image_list, parent, false);
        viewHolder = new ImageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Image image = getItem(position);

        switch (getItemViewType(position)) {
            case ITEM:
                ((ImageViewHolder) holder).bind(image);
                break;
            case LOADING:
                ((LoadingViewHolder) holder).bind(mCallback, this, retryPageLoad, errorMessage);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mImages.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    @Override
    public int getItemCount() {
        return mImages == null ? 0 : mImages.size();
    }

    public void add(Image image) {
        mImages.add(image);
        notifyItemInserted(mImages.size() - 1);
    }

    public void addAll(List<Image> images) {
        for (Image image : images) {
            add(image);
        }
    }

    public void remove(Image image) {
        int position = mImages.indexOf(image);
        if (position > -1) {
            mImages.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Image getItem(int position) {
        return mImages.get(position);
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Image());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = mImages.size() - 1;
        Image image = getItem(position);

        if (image != null) {
            mImages.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public void showRetry(boolean show, @Nullable String errorMessage) {
        retryPageLoad = show;
        notifyItemChanged(mImages.size() - 1);

        if (errorMessage != null) {
            this.errorMessage = errorMessage;
        }
    }
}
