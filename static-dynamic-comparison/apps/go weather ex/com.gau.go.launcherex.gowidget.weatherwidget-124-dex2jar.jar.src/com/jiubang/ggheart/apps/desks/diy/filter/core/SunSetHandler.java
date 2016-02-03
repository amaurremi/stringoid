package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.lang.ref.SoftReference;

public class SunSetHandler
  extends AbsFilterHandler
{
  public static final String[] EXSIT_FILE_ARRAY = { "blackboard.png", "overlay_map.png", "sunset_map.png" };
  private SoftReference a;
  private SoftReference b;
  private SoftReference c;
  private Context d;
  
  public SunSetHandler(Context paramContext)
  {
    try
    {
      this.d = paramContext;
      if (paramContext == null) {
        return;
      }
      Bitmap localBitmap1 = BitmapFactory.decodeStream(paramContext.getAssets().open("blackboard.png"));
      Bitmap localBitmap2 = BitmapFactory.decodeStream(paramContext.getAssets().open("overlay_map.png"));
      paramContext = BitmapFactory.decodeStream(paramContext.getAssets().open("sunset_map.png"));
      this.a = new SoftReference(new BitmapInfo(a(paramContext), paramContext.getWidth(), paramContext.getHeight()));
      this.b = new SoftReference(new BitmapInfo(a(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight()));
      this.c = new SoftReference(new BitmapInfo(a(localBitmap2), localBitmap2.getWidth(), localBitmap2.getHeight()));
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
    BitmapInfo localBitmapInfo = (BitmapInfo)this.b.get();
    Object localObject = localBitmapInfo;
    if (localBitmapInfo == null)
    {
      localObject = this.d;
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return (BitmapInfo)localObject;
    }
    try
    {
      localObject = BitmapFactory.decodeStream(((Context)localObject).getAssets().open("blackboard.png"));
      return new BitmapInfo(a((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
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
    BitmapInfo localBitmapInfo = (BitmapInfo)this.c.get();
    Object localObject = localBitmapInfo;
    if (localBitmapInfo == null)
    {
      localObject = this.d;
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return (BitmapInfo)localObject;
    }
    try
    {
      localObject = BitmapFactory.decodeStream(((Context)localObject).getAssets().open("overlay_map.png"));
      return new BitmapInfo(a((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  private BitmapInfo c()
  {
    BitmapInfo localBitmapInfo = (BitmapInfo)this.a.get();
    Object localObject = localBitmapInfo;
    if (localBitmapInfo == null)
    {
      localObject = this.d;
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return (BitmapInfo)localObject;
    }
    try
    {
      localObject = BitmapFactory.decodeStream(((Context)localObject).getAssets().open("sunset_map.png"));
      return new BitmapInfo(a((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  public static boolean canHandle(int paramInt)
  {
    return (getHadlerIds() & paramInt) == paramInt;
  }
  
  public static int getHadlerIds()
  {
    return 65536;
  }
  
  public native void doFilt(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt3, int paramInt5, int paramInt6, int[] paramArrayOfInt4, int paramInt7, int paramInt8, int[] paramArrayOfInt5);
  
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
      BitmapInfo localBitmapInfo1 = a();
      BitmapInfo localBitmapInfo2 = b();
      BitmapInfo localBitmapInfo3 = c();
      if ((localBitmapInfo1 == null) || (localBitmapInfo2 == null) || (localBitmapInfo3 == null)) {
        return paramFilterParameter.mSrcBitmap;
      }
      doFilt((int[])localObject1, i, j, localBitmapInfo1.mPixels, localBitmapInfo1.mWidth, localBitmapInfo1.mHeight, localBitmapInfo2.mPixels, localBitmapInfo2.mWidth, localBitmapInfo2.mHeight, localBitmapInfo3.mPixels, localBitmapInfo3.mWidth, localBitmapInfo3.mHeight, (int[])localObject2);
      localObject2 = a((int[])localObject2, i, j);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramFilterParameter.mSrcBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/SunSetHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */