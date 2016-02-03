package com.pioong.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ViewTouchImage
  extends ImageView
  implements View.OnTouchListener
{
  private static final boolean D = false;
  private static final int DRAG = 1;
  private static final int HEIGHT = 1;
  private static final int NONE = 0;
  private static final String TAG = "ViewTouchImage";
  private static final int WIDTH = 0;
  private static final int ZOOM = 2;
  private boolean isInit = false;
  private Matrix matrix = new Matrix();
  private PointF mid = new PointF();
  private int mode = 0;
  private float oldDist = 1.0F;
  private Matrix savedMatrix = new Matrix();
  private Matrix savedMatrix2 = new Matrix();
  private PointF start = new PointF();
  
  public ViewTouchImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewTouchImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewTouchImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnTouchListener(this);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void matrixTurning(Matrix paramMatrix, ImageView paramImageView)
  {
    float[] arrayOfFloat1 = new float[9];
    paramMatrix.getValues(arrayOfFloat1);
    float[] arrayOfFloat2 = new float[9];
    this.savedMatrix2.getValues(arrayOfFloat2);
    int j = paramImageView.getWidth();
    int k = paramImageView.getHeight();
    paramImageView = paramImageView.getDrawable();
    if (paramImageView == null) {
      return;
    }
    int n = paramImageView.getIntrinsicWidth();
    int m = paramImageView.getIntrinsicHeight();
    int i = (int)(n * arrayOfFloat1[0]);
    int i1 = (int)(m * arrayOfFloat1[4]);
    if (arrayOfFloat1[2] < j - i) {
      arrayOfFloat1[2] = (j - i);
    }
    if (arrayOfFloat1[5] < k - i1) {
      arrayOfFloat1[5] = (k - i1);
    }
    if (arrayOfFloat1[2] > 0.0F) {
      arrayOfFloat1[2] = 0.0F;
    }
    if (arrayOfFloat1[5] > 0.0F) {
      arrayOfFloat1[5] = 0.0F;
    }
    if ((arrayOfFloat1[0] > 10.0F) || (arrayOfFloat1[4] > 10.0F))
    {
      arrayOfFloat1[0] = arrayOfFloat2[0];
      arrayOfFloat1[4] = arrayOfFloat2[4];
      arrayOfFloat1[2] = arrayOfFloat2[2];
      arrayOfFloat1[5] = arrayOfFloat2[5];
    }
    if ((n > j) || (m > k)) {
      if ((i < j) && (i1 < k))
      {
        i = 0;
        if (n < m) {
          i = 1;
        }
        float f;
        if (i == 0)
        {
          f = j / n;
          arrayOfFloat1[4] = f;
          arrayOfFloat1[0] = f;
        }
        if (i == 1)
        {
          f = k / m;
          arrayOfFloat1[4] = f;
          arrayOfFloat1[0] = f;
        }
        i = (int)(n * arrayOfFloat1[0]);
        i1 = (int)(m * arrayOfFloat1[4]);
        if (i > j)
        {
          f = j / n;
          arrayOfFloat1[4] = f;
          arrayOfFloat1[0] = f;
        }
        if (i1 > k)
        {
          f = k / m;
          arrayOfFloat1[4] = f;
          arrayOfFloat1[0] = f;
        }
      }
    }
    for (;;)
    {
      i = (int)(n * arrayOfFloat1[0]);
      m = (int)(m * arrayOfFloat1[4]);
      if (i < j) {
        arrayOfFloat1[2] = (j / 2.0F - i / 2.0F);
      }
      if (m < k) {
        arrayOfFloat1[5] = (k / 2.0F - m / 2.0F);
      }
      paramMatrix.setValues(arrayOfFloat1);
      this.savedMatrix2.set(paramMatrix);
      return;
      if (arrayOfFloat1[0] < 1.0F) {
        arrayOfFloat1[0] = 1.0F;
      }
      if (arrayOfFloat1[4] < 1.0F) {
        arrayOfFloat1[4] = 1.0F;
      }
    }
  }
  
  private void midPoint(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getX(1);
    float f3 = paramMotionEvent.getY(0);
    float f4 = paramMotionEvent.getY(1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
  }
  
  private float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }
  
  protected void init()
  {
    matrixTurning(this.matrix, this);
    setImageMatrix(this.matrix);
    setImagePit();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isInit)
    {
      init();
      this.isInit = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (ImageView)paramView;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      matrixTurning(this.matrix, paramView);
      paramView.setImageMatrix(this.matrix);
      return true;
      this.savedMatrix.set(this.matrix);
      this.start.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.mode = 1;
      continue;
      this.oldDist = spacing(paramMotionEvent);
      if (this.oldDist > 10.0F)
      {
        this.savedMatrix.set(this.matrix);
        midPoint(this.mid, paramMotionEvent);
        this.mode = 2;
        continue;
        this.mode = 0;
        continue;
        if (this.mode == 1)
        {
          this.matrix.set(this.savedMatrix);
          this.matrix.postTranslate(paramMotionEvent.getX() - this.start.x, paramMotionEvent.getY() - this.start.y);
        }
        else if (this.mode == 2)
        {
          float f = spacing(paramMotionEvent);
          if (f > 10.0F)
          {
            this.matrix.set(this.savedMatrix);
            f /= this.oldDist;
            this.matrix.postScale(f, f, this.mid.x, this.mid.y);
          }
        }
      }
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.isInit = false;
    init();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.isInit = false;
    init();
  }
  
  public void setImagePit()
  {
    float[] arrayOfFloat = new float[9];
    this.matrix.getValues(arrayOfFloat);
    int j = getWidth();
    int k = getHeight();
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    int n = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    int i = (int)(n * arrayOfFloat[0]);
    i = (int)(m * arrayOfFloat[4]);
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[5] = 0.0F;
    if ((n > j) || (m > k))
    {
      i = 0;
      if (n < m) {
        i = 1;
      }
      float f;
      if (i == 0)
      {
        f = j / n;
        arrayOfFloat[4] = f;
        arrayOfFloat[0] = f;
      }
      if (i == 1)
      {
        f = k / m;
        arrayOfFloat[4] = f;
        arrayOfFloat[0] = f;
      }
      i = (int)(n * arrayOfFloat[0]);
      int i1 = (int)(m * arrayOfFloat[4]);
      if (i > j)
      {
        f = j / n;
        arrayOfFloat[4] = f;
        arrayOfFloat[0] = f;
      }
      if (i1 > k)
      {
        f = k / m;
        arrayOfFloat[4] = f;
        arrayOfFloat[0] = f;
      }
    }
    i = (int)(n * arrayOfFloat[0]);
    m = (int)(m * arrayOfFloat[4]);
    if (i < j) {
      arrayOfFloat[2] = (j / 2.0F - i / 2.0F);
    }
    if (m < k) {
      arrayOfFloat[5] = (k / 2.0F - m / 2.0F);
    }
    this.matrix.setValues(arrayOfFloat);
    setImageMatrix(this.matrix);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.isInit = false;
    init();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/customview/ViewTouchImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */