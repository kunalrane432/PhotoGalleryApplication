package com.humber.photogalleryapplication.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.photogalleryapplication.R;
import com.humber.photogalleryapplication.adapter.PhotoAdapter;
import com.humber.photogalleryapplication.api.FlickrAPI;
import com.humber.photogalleryapplication.response.FlickrResponse;
import com.humber.photogalleryapplication.response.Photo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PhotoGalleryFragment extends Fragment {

    private RecyclerView photoRecyclerView;

    private PhotoAdapter adapter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.framgment_photo_acitivity,container,false);
        photoRecyclerView=(RecyclerView) v.findViewById(R.id.photoRecyclerView);

        photoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        adapter=new PhotoAdapter(getActivity(),new ArrayList<String>());
        photoRecyclerView.setAdapter(adapter);
        fetchPhoto();
        return v;
    }

    private void fetchPhoto()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.flickr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlickrAPI flickrAPI=retrofit.create(FlickrAPI.class);

        Call<FlickrResponse> call=flickrAPI.getRecentPhotos();
        call.enqueue(new Callback<FlickrResponse>() {
            @Override
            public void onResponse(Call<FlickrResponse> call, Response<FlickrResponse> response) {
                if(response.isSuccessful())
                {
                    FlickrResponse flickrResponse= response.body();;
                    if(flickrResponse!=null)
                    {
                        List<Photo> photo=flickrResponse.getPhotos().getPhotos();
                    }
                }
            }

            @Override
            public void onFailure(Call<FlickrResponse> call, Throwable t) {
                Log.d("PhotoGallery",t.getMessage());
            }
        });
    }


    private void downloadAndDisplayPhotos(List<Photo> photos)
    {

    }
}
