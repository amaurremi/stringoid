package com.venticake.retrica.view.album;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.GLUtils;
import javax.microedition.khronos.opengles.GL11;

public abstract class CanvasTexture
{
  private Bitmap mBitmap = null;
  private final Bitmap.Config mBitmapConfig;
  private GL11 mCachedGL = null;
  private final Canvas mCanvas = new Canvas();
  private int mHeight;
  private boolean mNeedsDraw = false;
  private boolean mNeedsResize = false;
  private float mNormalizedHeight;
  private float mNormalizedWidth;
  private int mTextureHeight;
  private int mTextureId;
  private int mTextureWidth;
  private int mWidth;
  
  public CanvasTexture(Bitmap.Config paramConfig)
  {
    this.mBitmapConfig = paramConfig;
  }
  
  public boolean bind(GL11 paramGL11)
  {
    if (this.mCachedGL != paramGL11)
    {
      this.mCachedGL = paramGL11;
      resetTexture();
    }
    int m = this.mWidth;
    int n = this.mHeight;
    int j = this.mTextureId;
    int i = this.mTextureWidth;
    int i3 = this.mTextureHeight;
    Canvas localCanvas = this.mCanvas;
    Object localObject2 = this.mBitmap;
    int k;
    Object localObject1;
    if (!this.mNeedsResize)
    {
      k = j;
      localObject1 = localObject2;
      if (this.mTextureId != 0) {}
    }
    else
    {
      this.mNeedsDraw = true;
      int i1 = Shared.nextPowerOf2(m);
      int i2 = Shared.nextPowerOf2(n);
      if ((i == i1) && (i3 == i2))
      {
        k = j;
        localObject1 = localObject2;
        if (this.mTextureId != 0) {}
      }
      else
      {
        i = j;
        if (j == 0)
        {
          localObject1 = new int[1];
          paramGL11.glGenTextures(1, (int[])localObject1, 0);
          i = localObject1[0];
          this.mNeedsResize = false;
          this.mTextureId = i;
          paramGL11.glBindTexture(3553, i);
          paramGL11.glTexParameteri(3553, 10242, 33071);
          paramGL11.glTexParameteri(3553, 10243, 33071);
          paramGL11.glTexParameterf(3553, 10241, 9729.0F);
          paramGL11.glTexParameterf(3553, 10240, 9729.0F);
        }
        this.mTextureWidth = i1;
        this.mTextureHeight = i2;
        this.mNormalizedWidth = (m / i1);
        this.mNormalizedHeight = (n / i2);
        if (localObject2 != null) {
          ((Bitmap)localObject2).recycle();
        }
        k = i;
        localObject1 = localObject2;
        if (i1 > 0)
        {
          k = i;
          localObject1 = localObject2;
          if (i2 > 0)
          {
            localObject1 = Bitmap.createBitmap(i1, i2, this.mBitmapConfig);
            localCanvas.setBitmap((Bitmap)localObject1);
            this.mBitmap = ((Bitmap)localObject1);
            k = i;
          }
        }
      }
    }
    if (k == 0) {
      return false;
    }
    paramGL11.glBindTexture(3553, k);
    if (this.mNeedsDraw)
    {
      this.mNeedsDraw = false;
      renderCanvas(localCanvas, (Bitmap)localObject1, m, n);
      localObject2 = new int[4];
      localObject2[1] = n;
      localObject2[2] = m;
      localObject2[3] = (-n);
      paramGL11.glTexParameteriv(3553, 35741, (int[])localObject2, 0);
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
    }
    return true;
  }
  
  public void draw(RenderView paramRenderView, GL11 paramGL11, int paramInt1, int paramInt2)
  {
    if (bind(paramGL11)) {
      paramRenderView.draw2D(paramInt1, paramInt2, 0.0F, this.mWidth, this.mHeight);
    }
  }
  
  public void drawWithEffect(RenderView paramRenderView, GL11 paramGL11, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f2;
    float f1;
    if (bind(paramGL11))
    {
      f2 = this.mWidth;
      f1 = this.mHeight;
      if (paramFloat6 == 1.0F) {
        break label118;
      }
      float f3 = f2 * paramFloat6;
      paramFloat6 = f1 * paramFloat6;
      paramFloat1 = paramFloat3 * f2 + paramFloat1 - paramFloat3 * f3;
      paramFloat2 = paramFloat2 + paramFloat4 * f1 - paramFloat4 * paramFloat6;
      paramFloat4 = paramFloat6;
      paramFloat3 = f3;
    }
    for (;;)
    {
      if (paramFloat5 != 1.0F) {
        paramRenderView.setAlpha(paramFloat5);
      }
      paramRenderView.draw2D(paramFloat1, paramFloat2, 0.0F, paramFloat3, paramFloat4);
      if (paramFloat5 != 1.0F) {
        paramRenderView.resetColor();
      }
      return;
      label118:
      paramFloat3 = f2;
      paramFloat4 = f1;
    }
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public final float getNormalizedHeight()
  {
    return this.mNormalizedHeight;
  }
  
  public final float getNormalizedWidth()
  {
    return this.mNormalizedWidth;
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  protected abstract void onSizeChanged();
  
  protected abstract void renderCanvas(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public void resetTexture()
  {
    this.mTextureId = 0;
    this.mNeedsResize = true;
  }
  
  public final void setNeedsDraw()
  {
    this.mNeedsDraw = true;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mNeedsResize = true;
    this.mTextureWidth = -1;
    this.mTextureHeight = -1;
    onSizeChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/CanvasTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */