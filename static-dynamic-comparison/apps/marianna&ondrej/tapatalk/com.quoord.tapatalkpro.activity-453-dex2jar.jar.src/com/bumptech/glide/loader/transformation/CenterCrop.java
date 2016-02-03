package com.bumptech.glide.loader.transformation;

import com.bumptech.glide.resize.load.Transformation;

public class CenterCrop<T>
        implements TransformationLoader<T> {
    public String getId() {
        return Transformation.CENTER_CROP.getId();
    }

    public Transformation getTransformation(T paramT) {
        return Transformation.CENTER_CROP;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/transformation/CenterCrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */