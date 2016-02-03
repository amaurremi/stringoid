package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class iy
  extends ImageView
{
  private Uri Lc;
  private int Ld;
  private int Le;
  private a Lf;
  private int Lg;
  private float Lh;
  
  public void ay(int paramInt)
  {
    this.Ld = paramInt;
  }
  
  public void g(Uri paramUri)
  {
    this.Lc = paramUri;
  }
  
  public int gN()
  {
    return this.Ld;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.Lf != null) {
      paramCanvas.clipPath(this.Lf.g(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.Le != 0) {
      paramCanvas.drawColor(this.Le);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    switch (this.Lg)
    {
    default: 
      return;
    case 1: 
      paramInt1 = getMeasuredHeight();
      paramInt2 = (int)(paramInt1 * this.Lh);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = (int)(paramInt2 / this.Lh);
    }
  }
  
  public static abstract interface a
  {
    public abstract Path g(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */