package com.humber.photogalleryapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.photogalleryapplication.R;
import com.humber.photogalleryapplication.ViewHolder.PhotoViewHolder;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private Context context;

    private List<String> photoPaths;

    public void addPhoto(String path)
    {
        this.photoPaths.add(path);
    }


    public PhotoAdapter(Context context, List<String> photoPaths) {

        this.context = context;
        this.photoPaths = photoPaths;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_photo,parent,false);
        return new PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        String path=photoPaths.get(position);
        Drawable photo=Drawable.createFromPath(path);
        holder.bindData(photo);
    }

    @Override
    public int getItemCount() {
        return photoPaths.size();
    }
}
