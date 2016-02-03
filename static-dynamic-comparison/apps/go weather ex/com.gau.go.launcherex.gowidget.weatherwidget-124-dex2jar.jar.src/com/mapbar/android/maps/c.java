package com.mapbar.android.maps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import java.io.File;
import java.io.InputStream;

public abstract class c<K, V>
  extends d<K, V>
{
  protected static Bitmap a = null;
  
  static
  {
    try
    {
      InputStream localInputStream = c.class.getResourceAsStream("/res/Trans.png");
      a = BitmapFactory.decodeStream(localInputStream);
      localInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public c(File paramFile, d.b paramb, int paramInt)
  {
    super(paramFile, paramb, paramInt);
  }
  
  protected abstract V a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, K paramK, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, q paramq, Bitmap paramBitmap);
  
  public final V a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, K paramK, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, q paramq, Bitmap paramBitmap)
  {
    Object localObject2 = super.a(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramView, paramCanvas, paramInt1, paramInt2, paramK, 1, paramInt3, paramInt4, paramInt5, paramBoolean, paramq, paramBitmap);
    }
    return (V)localObject1;
  }
  
  public final V a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, K paramK, Bitmap paramBitmap)
  {
    return (V)a(paramView, paramCanvas, paramInt1, paramInt2, paramK, 0, 0, 0, false, null, paramBitmap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */