package com.quoord.tools.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.quoord.tapatalkpro.activity.R.styleable;

public class RoundedImageView
        extends ImageView {
    public static final float DEFAULT_BORDER_WIDTH = 0.0F;
    public static final float DEFAULT_RADIUS = 0.0F;
    private static final ImageView.ScaleType[] SCALE_TYPES;
    public static final String TAG = "RoundedImageView";
    private ColorStateList borderColor = ColorStateList.valueOf(-16777216);
    private float borderWidth = 0.0F;
    private float cornerRadius = 0.0F;
    private boolean isOval = false;
    private Drawable mBackgroundDrawable;
    private Drawable mDrawable;
    private int mResource;
    private ImageView.ScaleType mScaleType;
    private boolean mutateBackground = false;

    static {
        if (!RoundedImageView.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            SCALE_TYPES = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
            return;
        }
    }

    public RoundedImageView(Context paramContext) {
        super(paramContext);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
        paramInt = paramContext.getInt(0, -1);
        if (paramInt >= 0) {
            setScaleType(SCALE_TYPES[paramInt]);
        }
        for (; ; ) {
            this.cornerRadius = paramContext.getDimensionPixelSize(1, -1);
            this.borderWidth = paramContext.getDimensionPixelSize(2, -1);
            if (this.cornerRadius < 0.0F) {
                this.cornerRadius = 0.0F;
            }
            if (this.borderWidth < 0.0F) {
                this.borderWidth = 0.0F;
            }
            this.borderColor = paramContext.getColorStateList(3);
            if (this.borderColor == null) {
                this.borderColor = ColorStateList.valueOf(-16777216);
            }
            this.mutateBackground = paramContext.getBoolean(4, false);
            this.isOval = paramContext.getBoolean(5, false);
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(true);
            paramContext.recycle();
            return;
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private Drawable resolveResource() {
        Resources localResources = getResources();
        if (localResources == null) {
            return null;
        }
        Object localObject3 = null;
        Object localObject1 = localObject3;
        if (this.mResource != 0) {
        }
        try {
            localObject1 = localResources.getDrawable(this.mResource);
            return RoundedDrawable.fromDrawable((Drawable) localObject1);
        } catch (Exception localException) {
            for (; ; ) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.mResource, localException);
                this.mResource = 0;
                Object localObject2 = localObject3;
            }
        }
    }

    private void updateAttrs(Drawable paramDrawable) {
        if (paramDrawable == null) {
        }
        for (; ; ) {
            return;
            if ((paramDrawable instanceof RoundedDrawable)) {
                ((RoundedDrawable) paramDrawable).setScaleType(this.mScaleType).setCornerRadius(this.cornerRadius).setBorderWidth(this.borderWidth).setBorderColor(this.borderColor).setOval(this.isOval);
                return;
            }
            if ((paramDrawable instanceof LayerDrawable)) {
                paramDrawable = (LayerDrawable) paramDrawable;
                int i = 0;
                int j = paramDrawable.getNumberOfLayers();
                while (i < j) {
                    updateAttrs(paramDrawable.getDrawable(i));
                    i += 1;
                }
            }
        }
    }

    private void updateBackgroundDrawableAttrs(boolean paramBoolean) {
        if (this.mutateBackground) {
            if (paramBoolean) {
                this.mBackgroundDrawable = RoundedDrawable.fromDrawable(this.mBackgroundDrawable);
            }
            updateAttrs(this.mBackgroundDrawable);
        }
    }

    private void updateDrawableAttrs() {
        updateAttrs(this.mDrawable);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.borderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.borderColor;
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public boolean isMutateBackground() {
        return this.mutateBackground;
    }

    public boolean isOval() {
        return this.isOval;
    }

    public void setBackground(Drawable paramDrawable) {
        setBackgroundDrawable(paramDrawable);
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable paramDrawable) {
        this.mBackgroundDrawable = paramDrawable;
        updateBackgroundDrawableAttrs(true);
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public void setBorderColor(int paramInt) {
        setBorderColor(ColorStateList.valueOf(paramInt));
    }

    public void setBorderColor(ColorStateList paramColorStateList) {
        if (this.borderColor.equals(paramColorStateList)) {
            return;
        }
        if (paramColorStateList != null) {
        }
        for (; ; ) {
            this.borderColor = paramColorStateList;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            if (this.borderWidth <= 0.0F) {
                break;
            }
            invalidate();
            return;
            paramColorStateList = ColorStateList.valueOf(-16777216);
        }
    }

    public void setBorderWidth(float paramFloat) {
        if (this.borderWidth == paramFloat) {
            return;
        }
        this.borderWidth = paramFloat;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public void setBorderWidth(int paramInt) {
        setBorderWidth(getResources().getDimension(paramInt));
    }

    public void setCornerRadius(float paramFloat) {
        if (this.cornerRadius == paramFloat) {
            return;
        }
        this.cornerRadius = paramFloat;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
    }

    public void setCornerRadius(int paramInt) {
        setCornerRadius(getResources().getDimension(paramInt));
    }

    public void setImageBitmap(Bitmap paramBitmap) {
        this.mResource = 0;
        this.mDrawable = RoundedDrawable.fromBitmap(paramBitmap);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageDrawable(Drawable paramDrawable) {
        this.mResource = 0;
        this.mDrawable = RoundedDrawable.fromDrawable(paramDrawable);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageResource(int paramInt) {
        if (this.mResource != paramInt) {
            this.mResource = paramInt;
            this.mDrawable = resolveResource();
            updateDrawableAttrs();
            super.setImageDrawable(this.mDrawable);
        }
    }

    public void setImageURI(Uri paramUri) {
        super.setImageURI(paramUri);
        setImageDrawable(getDrawable());
    }

    public void setMutateBackground(boolean paramBoolean) {
        if (this.mutateBackground == paramBoolean) {
            return;
        }
        this.mutateBackground = paramBoolean;
        updateBackgroundDrawableAttrs(true);
        invalidate();
    }

    public void setOval(boolean paramBoolean) {
        this.isOval = paramBoolean;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public void setScaleType(ImageView.ScaleType paramScaleType) {
        assert (paramScaleType != null);
        if (this.mScaleType != paramScaleType) {
            this.mScaleType = paramScaleType;
            switch (paramScaleType) {
                default:
                    super.setScaleType(paramScaleType);
            }
        }
        for (; ; ) {
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
            return;
            super.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/roundedimageview/RoundedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */