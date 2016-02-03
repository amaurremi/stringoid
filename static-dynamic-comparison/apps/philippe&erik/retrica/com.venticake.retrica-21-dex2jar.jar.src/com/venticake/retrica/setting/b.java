package com.venticake.retrica.setting;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.venticake.retrica.i;
import java.io.IOException;

public class b
{
  private static float a = 0.25F;
  
  private static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 90;
    int j = -90;
    if (paramInt2 == 0)
    {
      paramInt2 = j;
      switch (paramInt1)
      {
      default: 
        paramInt2 = 0;
      }
    }
    do
    {
      return paramInt2;
      return 180;
      return 0;
      return 90;
      switch (paramInt1)
      {
      default: 
        break;
      case 0: 
        return 180;
      case 1: 
        paramInt2 = j;
      }
    } while (paramBoolean);
    return 90;
    if (paramBoolean) {}
    for (paramInt1 = i;; paramInt1 = -90) {
      return paramInt1;
    }
    return 0;
  }
  
  public static Bitmap a(Context paramContext)
  {
    return a(paramContext.getAssets());
  }
  
  public static Bitmap a(Context paramContext, int paramInt, c paramc)
  {
    paramContext = paramContext.getAssets();
    paramc = a(paramInt, paramc);
    try
    {
      paramContext = paramContext.open(paramc);
      if (paramContext == null) {
        return null;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    return BitmapFactory.decodeStream(paramContext);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 1;
    int k = 0;
    int m = 0;
    int j = 0;
    int n = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    boolean bool;
    float f1;
    if (n > 1600)
    {
      bool = true;
      paramContext = a(paramContext.getAssets(), bool);
      f1 = n / 3200.0F;
      if (bool) {
        break label612;
      }
      f1 = 2.0F * f1;
    }
    label167:
    label612:
    for (;;)
    {
      float f2 = f1;
      if (f1 < a) {
        f2 = a;
      }
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(a(paramInt1, paramInt2, paramBoolean));
      if (paramBoolean) {
        i = -1;
      }
      localMatrix.postScale(i * f2, f2);
      paramContext = Bitmap.createBitmap(paramContext, 0, 0, paramContext.getWidth(), paramContext.getHeight(), localMatrix, false);
      if (a.a().j())
      {
        i = i.a(paramBitmap.getWidth(), paramBitmap.getHeight());
        switch (paramInt2)
        {
        default: 
          i = 0;
          paramInt1 = j;
        }
      }
      for (;;)
      {
        new Canvas(paramBitmap).drawBitmap(paramContext, i, paramInt1, null);
        return paramBitmap;
        bool = false;
        break;
        i = 0;
        break label167;
        switch (paramInt1)
        {
        default: 
          paramInt2 = 0;
        }
        for (paramInt1 = k;; paramInt1 = i)
        {
          i = paramInt1;
          paramInt1 = paramInt2;
          break;
          paramInt2 = paramBitmap.getWidth();
          j = paramContext.getWidth();
          paramInt1 = i;
          i = paramInt2 - j - i;
          break;
          paramInt1 = i;
          break;
          paramInt1 = paramBitmap.getHeight() - paramContext.getHeight() - i;
          i = paramBitmap.getWidth() - paramContext.getWidth() - i;
          break;
          paramInt2 = paramBitmap.getHeight() - paramContext.getHeight() - i;
        }
        switch (paramInt1)
        {
        default: 
          paramInt2 = 0;
          paramInt1 = m;
        }
        for (;;)
        {
          i = paramInt1;
          paramInt1 = paramInt2;
          break;
          if (paramBoolean)
          {
            paramInt2 = paramBitmap.getWidth();
            j = paramContext.getWidth();
            paramInt1 = i;
            i = paramInt2 - j - i;
            break;
          }
          paramInt1 = i;
          break;
          if (paramBoolean)
          {
            paramInt1 = i;
            break;
          }
          paramInt1 = paramBitmap.getHeight() - paramContext.getHeight() - i;
          break;
          if (paramBoolean)
          {
            paramInt1 = paramBitmap.getHeight() - paramContext.getHeight() - i;
            i = paramBitmap.getWidth() - paramContext.getWidth() - i;
            break;
          }
          paramInt2 = paramBitmap.getWidth();
          j = paramContext.getWidth();
          paramInt1 = i;
          i = paramInt2 - j - i;
          break;
          if (paramBoolean)
          {
            paramInt1 = paramBitmap.getHeight() - paramContext.getHeight() - i;
            break;
          }
          paramInt2 = paramBitmap.getHeight();
          j = paramContext.getHeight();
          paramInt1 = paramBitmap.getWidth() - paramContext.getWidth() - i;
          paramInt2 = paramInt2 - j - i;
        }
        paramInt1 = paramBitmap.getHeight() - paramContext.getHeight() - i;
        i = paramBitmap.getWidth() - paramContext.getWidth() - i;
      }
    }
  }
  
  public static Bitmap a(AssetManager paramAssetManager)
  {
    String str = a(a.a().p(), c.d);
    try
    {
      paramAssetManager = paramAssetManager.open(str);
      if (paramAssetManager == null) {
        return null;
      }
    }
    catch (IOException paramAssetManager)
    {
      for (;;)
      {
        paramAssetManager.printStackTrace();
        paramAssetManager = null;
      }
    }
    return BitmapFactory.decodeStream(paramAssetManager);
  }
  
  public static Bitmap a(AssetManager paramAssetManager, boolean paramBoolean)
  {
    int i = a.a().p();
    Object localObject;
    if (paramBoolean) {
      localObject = c.c;
    }
    for (;;)
    {
      localObject = a(i, (c)localObject);
      try
      {
        paramAssetManager = paramAssetManager.open((String)localObject);
        if (paramAssetManager == null)
        {
          return null;
          localObject = c.a;
        }
      }
      catch (IOException paramAssetManager)
      {
        for (;;)
        {
          paramAssetManager.printStackTrace();
          paramAssetManager = null;
        }
      }
    }
    return BitmapFactory.decodeStream(paramAssetManager);
  }
  
  private static String a(int paramInt, c paramc)
  {
    int i = 0;
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      paramInt = i;
    }
    for (;;)
    {
      c localc = paramc;
      if (paramInt != 0)
      {
        localc = paramc;
        if (paramc == c.d) {
          localc = c.a;
        }
      }
      if (0 == 0) {}
      switch (a()[localc.ordinal()])
      {
      default: 
        return null;
        str = "new10";
        paramInt = i;
        continue;
        str = "new11";
        paramInt = i;
        continue;
        str = "new12";
        paramInt = i;
        continue;
        str = "new2";
        paramInt = i;
        continue;
        str = "new4";
        paramInt = i;
        continue;
        str = "new6";
        paramInt = i;
        continue;
        str = "new9";
        paramInt = i;
        continue;
        str = "pop2";
        paramInt = i;
        continue;
        str = "renewal2";
        paramInt = i;
        continue;
        str = "rb";
        paramInt = 1;
        continue;
        str = "stamp3";
        paramInt = i;
        continue;
        str = "stamp";
        paramInt = i;
        continue;
        str = "ver1";
        paramInt = i;
        continue;
        str = "stamp2";
        paramInt = i;
        continue;
        str = "simple";
        paramInt = i;
        continue;
        str = "vintage";
        paramInt = i;
      }
    }
    return "watermarks/png/wm_" + str + ".png";
    return "watermarks/png/wm_HALF" + str + "_half.png";
    return "watermarks/png_HD/wm_" + str + "_2x.png";
    return "watermarks/title/wm_" + str + "_title.png";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/setting/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */