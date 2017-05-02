package com.erostech.enlightenme.api;

import com.erostech.enlightenme.data.models.ImageSearchResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by erosgarciaponte on 02/05/2017.
 */

public interface ImageSearchService {

    @GET("images/search")
    Observable<ImageSearchResponse> search(
            @Query("query") String query,
            @Query("page") int page,
            @Query("language") String language);
}
