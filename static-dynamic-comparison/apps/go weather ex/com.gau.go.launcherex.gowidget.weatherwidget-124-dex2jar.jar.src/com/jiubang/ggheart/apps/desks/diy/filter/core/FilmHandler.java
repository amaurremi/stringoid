package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.lang.ref.SoftReference;

public class FilmHandler
  extends AbsFilterHandler
{
  public static final String[] EXSIT_FILE_ARRAY = { "film_map.png", "film_vignette_map.png" };
  private SoftReference a;
  private SoftReference b;
  private Context c;
  
  public FilmHandler(Context paramContext)
  {
    this.c = paramContext;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramContext.getAssets().open("film_map.png"));
      paramContext = BitmapFactory.decodeStream(paramContext.getAssets().open("film_vignette_map.png"));
      this.a = new SoftReference(new BitmapInfo(a(localBitmap), localBitmap.getWidth(), localBitmap.getHeight()));
      this.b = new SoftReference(new BitmapInfo(a(paramContext), paramContext.getWidth(), paramContext.getHeight()));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private BitmapInfo a()
  {
    if (this.b != null) {}
    for (BitmapInfo localBitmapInfo = (BitmapInfo)this.b.get();; localBitmapInfo = null)
    {
      Object localObject = localBitmapInfo;
      if (localBitmapInfo == null)
      {
        localObject = this.c;
        if (localObject != null) {
          break label37;
        }
        localObject = null;
      }
      for (;;)
      {
        return (BitmapInfo)localObject;
        try
        {
          label37:
          localObject = BitmapFactory.decodeStream(((Context)localObject).getAssets().open("film_vignette_map.png"));
          localBitmapInfo = new BitmapInfo(a((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          localObject = localBitmapInfo;
          if (localBitmapInfo != null)
          {
            this.b = new SoftReference(localBitmapInfo);
            return localBitmapInfo;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          return null;
        }
      }
    }
  }
  
  private int[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return arrayOfInt;
  }
  
  private BitmapInfo b()
  {
    if (this.a != null) {}
    for (BitmapInfo localBitmapInfo = (BitmapInfo)this.a.get();; localBitmapInfo = null)
    {
      Object localObject = localBitmapInfo;
      if (localBitmapInfo == null)
      {
        localObject = this.c;
        if (localObject != null) {
          break label37;
        }
        localObject = null;
      }
      for (;;)
      {
        return (BitmapInfo)localObject;
        try
        {
          label37:
          localObject = BitmapFactory.decodeStream(((Context)localObject).getAssets().open("film_map.png"));
          localBitmapInfo = new BitmapInfo(a((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          localObject = localBitmapInfo;
          if (localBitmapInfo != null)
          {
            this.a = new SoftReference(localBitmapInfo);
            return localBitmapInfo;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          return null;
        }
      }
    }
  }
  
  public static boolean canHandle(int paramInt)
  {
    return (getHadlerIds() & paramInt) == paramInt;
  }
  
  public static int getHadlerIds()
  {
    return 32768;
  }
  
  public native void doFilt(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt3, int paramInt5, int paramInt6, int[] paramArrayOfInt4);
  
  public Bitmap handler(FilterParameter paramFilterParameter)
  {
    Object localObject1;
    if (paramFilterParameter.mSrcBitmap == null) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return (Bitmap)localObject1;
      int i = paramFilterParameter.mSrcBitmap.getWidth();
      int j = paramFilterParameter.mSrcBitmap.getHeight();
      localObject1 = new int[i * j];
      localObject2 = new int[i * j];
      paramFilterParameter.mSrcBitmap.getPixels((int[])localObject1, 0, i, 0, 0, i, j);
      BitmapInfo localBitmapInfo1 = b();
      BitmapInfo localBitmapInfo2 = a();
      if ((localBitmapInfo1 == null) || (localBitmapInfo2 == null)) {
        return paramFilterParameter.mSrcBitmap;
      }
      doFilt((int[])localObject1, i, j, localBitmapInfo1.mPixels, localBitmapInfo1.mWidth, localBitmapInfo1.mHeight, localBitmapInfo2.mPixels, localBitmapInfo2.mWidth, localBitmapInfo2.mHeight, (int[])localObject2);
      localObject2 = a((int[])localObject2, i, j);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramFilterParameter.mSrcBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/FilmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */