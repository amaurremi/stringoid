package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

final class PicassoDrawable
  extends BitmapDrawable
{
  private static final Paint DEBUG_PAINT = new Paint();
  private static final float FADE_DURATION = 200.0F;
  int alpha = 255;
  boolean animating;
  private final boolean debugging;
  private final float density;
  private final Picasso.LoadedFrom loadedFrom;
  Drawable placeholder;
  long startTimeMillis;
  
  PicassoDrawable(Context paramContext, Bitmap paramBitmap, Drawable paramDrawable, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext.getResources(), paramBitmap);
    this.debugging = paramBoolean2;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.loadedFrom = paramLoadedFrom;
    if ((paramLoadedFrom != Picasso.LoadedFrom.MEMORY) && (!paramBoolean1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.placeholder = paramDrawable;
        this.animating = true;
        this.startTimeMillis = SystemClock.uptimeMillis();
      }
      return;
    }
  }
  
  private void drawDebugIndicator(Canvas paramCanvas)
  {
    DEBUG_PAINT.setColor(-1);
    paramCanvas.drawPath(getTrianglePath(new Point(0, 0), (int)(16.0F * this.density)), DEBUG_PAINT);
    DEBUG_PAINT.setColor(this.loadedFrom.debugColor);
    paramCanvas.drawPath(getTrianglePath(new Point(0, 0), (int)(15.0F * this.density)), DEBUG_PAINT);
  }
  
  private static Path getTrianglePath(Point paramPoint, int paramInt)
  {
    Point localPoint1 = new Point(paramPoint.x + paramInt, paramPoint.y);
    Point localPoint2 = new Point(paramPoint.x, paramPoint.y + paramInt);
    Path localPath = new Path();
    localPath.moveTo(paramPoint.x, paramPoint.y);
    localPath.lineTo(localPoint1.x, localPoint1.y);
    localPath.lineTo(localPoint2.x, localPoint2.y);
    return localPath;
  }
  
  static void setBitmap(ImageView paramImageView, Context paramContext, Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).stop();
    }
    paramImageView.setImageDrawable(new PicassoDrawable(paramContext, paramBitmap, localDrawable, paramLoadedFrom, paramBoolean1, paramBoolean2));
  }
  
  static void setPlaceholder(ImageView paramImageView, int paramInt, Drawable paramDrawable)
  {
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    for (;;)
    {
      if ((paramImageView.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)paramImageView.getDrawable()).start();
      }
      return;
      paramImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.animating) {
      super.draw(paramCanvas);
    }
    for (;;)
    {
      if (this.debugging) {
        drawDebugIndicator(paramCanvas);
      }
      return;
      float f = (float)(SystemClock.uptimeMillis() - this.startTimeMillis) / 200.0F;
      if (f >= 1.0F)
      {
        this.animating = false;
        this.placeholder = null;
        super.draw(paramCanvas);
      }
      else
      {
        if (this.placeholder != null) {
          this.placeholder.draw(paramCanvas);
        }
        super.setAlpha((int)(this.alpha * f));
        super.draw(paramCanvas);
        super.setAlpha(this.alpha);
        if (Build.VERSION.SDK_INT <= 10) {
          invalidateSelf();
        }
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.placeholder != null) {
      this.placeholder.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
    if (this.placeholder != null) {
      this.placeholder.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.placeholder != null) {
      this.placeholder.setColorFilter(paramColorFilter);
    }
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/PicassoDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */