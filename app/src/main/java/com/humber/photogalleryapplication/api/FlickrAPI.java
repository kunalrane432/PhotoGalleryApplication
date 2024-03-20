package com.humber.photogalleryapplication.api;

import com.humber.photogalleryapplication.response.FlickrResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlickrAPI {

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=d557b69a479f10e4edb480745a938060&format=json&nojsoncallback=1")
    Call<FlickrResponse> getRecentPhotos();


}
