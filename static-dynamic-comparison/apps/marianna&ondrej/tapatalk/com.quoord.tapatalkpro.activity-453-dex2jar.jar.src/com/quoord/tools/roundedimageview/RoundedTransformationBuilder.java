package com.quoord.tools.roundedimageview;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.Transformation;
import android.widget.ImageView.ScaleType;

public final class RoundedTransformationBuilder {
    private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
    private float mBorderWidth = 0.0F;
    private float mCornerRadius = 0.0F;
    private final DisplayMetrics mDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    private boolean mOval = false;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;

    public RoundedTransformationBuilder borderColor(int paramInt) {
        this.mBorderColor = ColorStateList.valueOf(paramInt);
        return this;
    }

    public RoundedTransformationBuilder borderColor(ColorStateList paramColorStateList) {
        this.mBorderColor = paramColorStateList;
        return this;
    }

    public RoundedTransformationBuilder borderWidth(float paramFloat) {
        this.mBorderWidth = paramFloat;
        return this;
    }

    public RoundedTransformationBuilder borderWidthDp(float paramFloat) {
        this.mBorderWidth = TypedValue.applyDimension(1, paramFloat, this.mDisplayMetrics);
        return this;
    }

    public Transformation build() {
        new Transformation() {
            public String key() {
                return "r:" + RoundedTransformationBuilder.this.mCornerRadius + "b:" + RoundedTransformationBuilder.this.mBorderWidth + "c:" + RoundedTransformationBuilder.this.mBorderColor + "o:" + RoundedTransformationBuilder.this.mOval;
            }

            public Bitmap transform(Bitmap paramAnonymousBitmap) {
                Bitmap localBitmap = RoundedDrawable.fromBitmap(paramAnonymousBitmap).setScaleType(RoundedTransformationBuilder.this.mScaleType).setCornerRadius(RoundedTransformationBuilder.this.mCornerRadius).setBorderWidth(RoundedTransformationBuilder.this.mBorderWidth).setBorderColor(RoundedTransformationBuilder.this.mBorderColor).setOval(RoundedTransformationBuilder.this.mOval).toBitmap();
                if (!paramAnonymousBitmap.equals(localBitmap)) {
                    paramAnonymousBitmap.recycle();
                }
                return localBitmap;
            }
        };
    }

    public RoundedTransformationBuilder cornerRadius(float paramFloat) {
        this.mCornerRadius = paramFloat;
        return this;
    }

    public RoundedTransformationBuilder cornerRadiusDp(float paramFloat) {
        this.mCornerRadius = TypedValue.applyDimension(1, paramFloat, this.mDisplayMetrics);
        return this;
    }

    public RoundedTransformationBuilder oval(boolean paramBoolean) {
        this.mOval = paramBoolean;
        return this;
    }

    public RoundedTransformationBuilder scaleType(ImageView.ScaleType paramScaleType) {
        this.mScaleType = paramScaleType;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/roundedimageview/RoundedTransformationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */