package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.gau.go.launcherex.gowidget.weatherwidget.R.styleable;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLView;

public class GLTileView
  extends GLView
{
  private Context a;
  private GLDrawable b;
  private Drawable c;
  
  public GLTileView(Context paramContext, BitmapDrawable paramBitmapDrawable)
  {
    super(paramContext);
    a(null, paramBitmapDrawable);
  }
  
  public GLTileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, null);
  }
  
  public GLTileView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, null);
  }
  
  private void a(AttributeSet paramAttributeSet, BitmapDrawable paramBitmapDrawable)
  {
    this.a = getContext();
    this.c = paramBitmapDrawable;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.TileView);
      this.c = paramAttributeSet.getDrawable(0);
      paramAttributeSet.recycle();
    }
  }
  
  public void cleanup()
  {
    super.cleanup();
    if (this.b != null)
    {
      releaseDrawableReference(this.b);
      this.b.clear();
      this.b.setCallback(null);
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.setCallback(null);
      this.c = null;
    }
  }
  
  protected void onDraw(GLCanvas paramGLCanvas)
  {
    if (this.b != null) {
      this.b.draw(paramGLCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || (this.b == null))
    {
      paramInt3 -= paramInt1;
      paramInt4 -= paramInt2;
    }
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      if (localBitmap1 == null) {
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap2;
      for (;;)
      {
        localBitmap2 = null;
      }
      Canvas localCanvas = new Canvas(localBitmap2);
      float f1 = this.c.getIntrinsicWidth();
      float f2 = this.c.getIntrinsicHeight();
      this.c.setBounds(0, 0, (int)f1, (int)f2);
      int i = Math.round(paramInt3 / f1 + 0.5F);
      int j = Math.round(paramInt4 / f2 + 0.5F);
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        localCanvas.save();
        localCanvas.translate(-f1, paramInt1 * f2);
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localCanvas.translate(f1, 0.0F);
          this.c.draw(localCanvas);
          paramInt2 += 1;
        }
        localCanvas.restore();
        paramInt1 += 1;
      }
      if (this.b != null) {
        this.b.clear();
      }
      this.b = GLDrawable.getDrawable(new BitmapDrawable(getResources(), localBitmap2));
      this.b.setBounds(0, 0, paramInt3, paramInt4);
    }
  }
  
  public void setTileBitmapDrawable(BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable != null)
    {
      this.c = paramBitmapDrawable;
      this.b = null;
      requestLayout();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLTileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */