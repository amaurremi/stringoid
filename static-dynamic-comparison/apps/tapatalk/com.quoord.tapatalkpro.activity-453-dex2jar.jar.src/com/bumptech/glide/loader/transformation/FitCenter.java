package com.bumptech.glide.loader.transformation;

import com.bumptech.glide.resize.load.Transformation;

public class FitCenter<T>
        implements TransformationLoader<T> {
    public String getId() {
        return Transformation.FIT_CENTER.getId();
    }

    public Transformation getTransformation(T paramT) {
        return Transformation.FIT_CENTER;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/transformation/FitCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */