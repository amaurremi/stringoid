package com.go.weatherex.home.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

public class e
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    Allocation localAllocation2 = null;
    Allocation localAllocation1 = null;
    Object localObject = localAllocation1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = localAllocation1;
      if (paramBitmap != null) {
        localObject = localAllocation2;
      }
    }
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 3, paramBitmap.getHeight() / 3, false);
      localObject = paramBitmap;
      paramContext = RenderScript.create(paramContext);
      localObject = paramBitmap;
      localAllocation1 = Allocation.createFromBitmap(paramContext, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
      localObject = paramBitmap;
      localAllocation2 = Allocation.createTyped(paramContext, localAllocation1.getType());
      localObject = paramBitmap;
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
      localObject = paramBitmap;
      localScriptIntrinsicBlur.setRadius(paramInt);
      localObject = paramBitmap;
      localScriptIntrinsicBlur.setInput(localAllocation1);
      localObject = paramBitmap;
      localScriptIntrinsicBlur.forEach(localAllocation2);
      localObject = paramBitmap;
      localAllocation2.copyTo(paramBitmap);
      localObject = paramBitmap;
      paramContext.destroy();
      localObject = paramBitmap;
      localAllocation1.destroy();
      localObject = paramBitmap;
      localAllocation2.destroy();
      localObject = paramBitmap;
      localScriptIntrinsicBlur.destroy();
      localObject = paramBitmap;
      return (Bitmap)localObject;
    }
    catch (Throwable paramContext) {}
    return (Bitmap)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */