package com.humber.photogalleryapplication.ViewHolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.photogalleryapplication.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private ImageView photoImageView;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        photoImageView=itemView.findViewById(R.id.photoImageView);
    }

    public void bindData(Drawable drawable)
    {
        photoImageView.setImageDrawable(drawable);
    }


}
