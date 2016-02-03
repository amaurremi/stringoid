package com.mobisystems.photoimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class TileCacheView
  extends View
{
  private int aEI = 0;
  private int aHl;
  private int aHm;
  private Rect aLV = new Rect();
  private int aOF = Color.argb(50, 0, 255, 0);
  private int aOG = Color.argb(50, 255, 0, 0);
  private int aOH = Color.argb(50, 255, 255, 255);
  private int aOI = Color.argb(0, 255, 255, 255);
  private Bitmap aOJ;
  private Paint aOm = new Paint();
  private Bitmap bitmap;
  
  public TileCacheView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TileCacheView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public TileCacheView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {}
  
  public void KN()
  {
    int i = 0;
    while (i < this.aHl)
    {
      int j = 0;
      while (j < this.aHm)
      {
        this.aOJ.setPixel(i, j, this.aOI);
        j += 1;
      }
      i += 1;
    }
  }
  
  public void T(int paramInt1, int paramInt2)
  {
    this.aHl = paramInt1;
    this.aHm = paramInt2;
    this.bitmap = Bitmap.createBitmap(this.aHl, this.aHm, Bitmap.Config.ARGB_8888);
    getLayoutParams().height = (this.aHm * 10);
    getLayoutParams().width = (this.aHl * 10);
    this.aOJ = Bitmap.createBitmap(this.aHl, this.aHm, Bitmap.Config.ARGB_8888);
    paramInt1 = 0;
    while (paramInt1 < this.aHl)
    {
      paramInt2 = 0;
      while (paramInt2 < this.aHm)
      {
        this.bitmap.setPixel(paramInt1, paramInt2, this.aOG);
        this.aOJ.setPixel(paramInt1, paramInt2, this.aOI);
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    invalidate();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap = this.bitmap;
    if (paramBoolean) {}
    for (int i = this.aOF;; i = this.aOG)
    {
      localBitmap.setPixel(paramInt1, paramInt2, i);
      invalidate();
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap = this.aOJ;
    if (paramBoolean) {}
    for (int i = this.aOH;; i = this.aOI)
    {
      localBitmap.setPixel(paramInt1, paramInt2, i);
      invalidate();
      return;
    }
  }
  
  public void gJ(int paramInt)
  {
    this.aEI = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.bitmap != null)
    {
      this.aLV.set(0, 0, getWidth(), getHeight());
      paramCanvas.drawBitmap(this.bitmap, null, this.aLV, this.aOm);
      paramCanvas.drawBitmap(this.aOJ, null, this.aLV, this.aOm);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/TileCacheView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */