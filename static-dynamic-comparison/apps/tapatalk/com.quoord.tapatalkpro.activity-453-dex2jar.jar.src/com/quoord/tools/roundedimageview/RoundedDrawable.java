package com.quoord.tools.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;

public class RoundedDrawable
        extends Drawable {
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final String TAG = "RoundedDrawable";
    private final int mBitmapHeight;
    private final Paint mBitmapPaint;
    private final RectF mBitmapRect = new RectF();
    private final BitmapShader mBitmapShader;
    private final int mBitmapWidth;
    private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
    private final Paint mBorderPaint;
    private final RectF mBorderRect = new RectF();
    private float mBorderWidth = 0.0F;
    private final RectF mBounds = new RectF();
    private float mCornerRadius = 0.0F;
    private final RectF mDrawableRect = new RectF();
    private boolean mOval = false;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
    private final Matrix mShaderMatrix = new Matrix();

    public RoundedDrawable(Bitmap paramBitmap) {
        this.mBitmapWidth = paramBitmap.getWidth();
        this.mBitmapHeight = paramBitmap.getHeight();
        this.mBitmapRect.set(0.0F, 0.0F, this.mBitmapWidth, this.mBitmapHeight);
        this.mBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setStyle(Paint.Style.FILL);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), -16777216));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }

    public static Bitmap drawableToBitmap(Drawable paramDrawable) {
        if ((paramDrawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) paramDrawable).getBitmap();
        }
        int i = Math.max(paramDrawable.getIntrinsicWidth(), 1);
        int j = Math.max(paramDrawable.getIntrinsicHeight(), 1);
        try {
            Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
            Canvas localCanvas = new Canvas(localBitmap);
            paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
            paramDrawable.draw(localCanvas);
            return localBitmap;
        } catch (Exception paramDrawable) {
            paramDrawable.printStackTrace();
        }
        return null;
    }

    public static RoundedDrawable fromBitmap(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            return new RoundedDrawable(paramBitmap);
        }
        return null;
    }

    public static Drawable fromDrawable(Drawable paramDrawable) {
        if ((paramDrawable == null) || ((paramDrawable instanceof RoundedDrawable))) {
            return paramDrawable;
        }
        if ((paramDrawable instanceof LayerDrawable)) {
            paramDrawable = (LayerDrawable) paramDrawable;
            int j = paramDrawable.getNumberOfLayers();
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    return paramDrawable;
                }
                localObject = paramDrawable.getDrawable(i);
                paramDrawable.setDrawableByLayerId(paramDrawable.getId(i), fromDrawable((Drawable) localObject));
                i += 1;
            }
        }
        Object localObject = drawableToBitmap(paramDrawable);
        if (localObject != null) {
            return new RoundedDrawable((Bitmap) localObject);
        }
        Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
        return paramDrawable;
    }

    private void updateShaderMatrix() {
        switch (this.mScaleType) {
            case FIT_CENTER:
            default:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        }
        for (; ; ) {
            this.mDrawableRect.set(this.mBorderRect);
            this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
            return;
            this.mBorderRect.set(this.mBounds);
            this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
            this.mShaderMatrix.set(null);
            this.mShaderMatrix.setTranslate((int) ((this.mBorderRect.width() - this.mBitmapWidth) * 0.5F + 0.5F), (int) ((this.mBorderRect.height() - this.mBitmapHeight) * 0.5F + 0.5F));
            continue;
            this.mBorderRect.set(this.mBounds);
            this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
            this.mShaderMatrix.set(null);
            float f1 = 0.0F;
            float f2 = 0.0F;
            float f3;
            if (this.mBitmapWidth * this.mBorderRect.height() > this.mBorderRect.width() * this.mBitmapHeight) {
                f3 = this.mBorderRect.height() / this.mBitmapHeight;
                f1 = (this.mBorderRect.width() - this.mBitmapWidth * f3) * 0.5F;
            }
            for (; ; ) {
                this.mShaderMatrix.setScale(f3, f3);
                this.mShaderMatrix.postTranslate((int) (f1 + 0.5F) + this.mBorderWidth, (int) (f2 + 0.5F) + this.mBorderWidth);
                break;
                f3 = this.mBorderRect.width() / this.mBitmapWidth;
                f2 = (this.mBorderRect.height() - this.mBitmapHeight * f3) * 0.5F;
            }
            this.mShaderMatrix.set(null);
            if ((this.mBitmapWidth <= this.mBounds.width()) && (this.mBitmapHeight <= this.mBounds.height())) {
            }
            for (f1 = 1.0F; ; f1 = Math.min(this.mBounds.width() / this.mBitmapWidth, this.mBounds.height() / this.mBitmapHeight)) {
                f2 = (int) ((this.mBounds.width() - this.mBitmapWidth * f1) * 0.5F + 0.5F);
                f3 = (int) ((this.mBounds.height() - this.mBitmapHeight * f1) * 0.5F + 0.5F);
                this.mShaderMatrix.setScale(f1, f1);
                this.mShaderMatrix.postTranslate(f2, f3);
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
                break;
            }
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
            continue;
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
            continue;
            this.mBorderRect.set(this.mBounds);
            this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
            this.mShaderMatrix.set(null);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        }
    }

    public void draw(Canvas paramCanvas) {
        if (this.mOval) {
            if (this.mBorderWidth > 0.0F) {
                paramCanvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
                paramCanvas.drawOval(this.mBorderRect, this.mBorderPaint);
                return;
            }
            paramCanvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
            return;
        }
        if (this.mBorderWidth > 0.0F) {
            paramCanvas.drawRoundRect(this.mDrawableRect, Math.max(this.mCornerRadius, 0.0F), Math.max(this.mCornerRadius, 0.0F), this.mBitmapPaint);
            paramCanvas.drawRoundRect(this.mBorderRect, this.mCornerRadius, this.mCornerRadius, this.mBorderPaint);
            return;
        }
        paramCanvas.drawRoundRect(this.mDrawableRect, this.mCornerRadius, this.mCornerRadius, this.mBitmapPaint);
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public boolean isOval() {
        return this.mOval;
    }

    public boolean isStateful() {
        return this.mBorderColor.isStateful();
    }

    protected void onBoundsChange(Rect paramRect) {
        super.onBoundsChange(paramRect);
        this.mBounds.set(paramRect);
        updateShaderMatrix();
    }

    protected boolean onStateChange(int[] paramArrayOfInt) {
        int i = this.mBorderColor.getColorForState(paramArrayOfInt, 0);
        if (this.mBorderPaint.getColor() != i) {
            this.mBorderPaint.setColor(i);
            return true;
        }
        return super.onStateChange(paramArrayOfInt);
    }

    public void setAlpha(int paramInt) {
        this.mBitmapPaint.setAlpha(paramInt);
        invalidateSelf();
    }

    public RoundedDrawable setBorderColor(int paramInt) {
        return setBorderColor(ColorStateList.valueOf(paramInt));
    }

    public RoundedDrawable setBorderColor(ColorStateList paramColorStateList) {
        if (paramColorStateList != null) {
        }
        for (; ; ) {
            this.mBorderColor = paramColorStateList;
            this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), -16777216));
            return this;
            paramColorStateList = ColorStateList.valueOf(0);
        }
    }

    public RoundedDrawable setBorderWidth(float paramFloat) {
        this.mBorderWidth = paramFloat;
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        return this;
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.mBitmapPaint.setColorFilter(paramColorFilter);
        invalidateSelf();
    }

    public RoundedDrawable setCornerRadius(float paramFloat) {
        this.mCornerRadius = paramFloat;
        return this;
    }

    public void setDither(boolean paramBoolean) {
        this.mBitmapPaint.setDither(paramBoolean);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean paramBoolean) {
        this.mBitmapPaint.setFilterBitmap(paramBoolean);
        invalidateSelf();
    }

    public RoundedDrawable setOval(boolean paramBoolean) {
        this.mOval = paramBoolean;
        return this;
    }

    public RoundedDrawable setScaleType(ImageView.ScaleType paramScaleType) {
        ImageView.ScaleType localScaleType = paramScaleType;
        if (paramScaleType == null) {
            localScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.mScaleType != localScaleType) {
            this.mScaleType = localScaleType;
            updateShaderMatrix();
        }
        return this;
    }

    public Bitmap toBitmap() {
        return drawableToBitmap(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/roundedimageview/RoundedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */