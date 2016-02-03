package com.quoord.tools.gallery;

import android.graphics.RectF;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;

public abstract interface IPhotoView {
    public abstract boolean canZoom();

    public abstract RectF getDisplayRect();

    public abstract float getMaxScale();

    public abstract float getMidScale();

    public abstract float getMinScale();

    public abstract float getScale();

    public abstract ImageView.ScaleType getScaleType();

    public abstract void setAllowParentInterceptOnEdge(boolean paramBoolean);

    public abstract void setMaxScale(float paramFloat);

    public abstract void setMidScale(float paramFloat);

    public abstract void setMinScale(float paramFloat);

    public abstract void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener);

    public abstract void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener paramOnMatrixChangedListener);

    public abstract void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener paramOnPhotoTapListener);

    public abstract void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener paramOnViewTapListener);

    public abstract void setScaleType(ImageView.ScaleType paramScaleType);

    public abstract void setZoomable(boolean paramBoolean);

    public abstract void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/gallery/IPhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */