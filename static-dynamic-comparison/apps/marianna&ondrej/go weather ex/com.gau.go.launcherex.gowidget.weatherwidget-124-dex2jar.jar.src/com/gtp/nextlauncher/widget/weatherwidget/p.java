package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import com.go.gl.graphics.BitmapGLDrawable;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.graphics.NinePatchGLDrawable;

public class p
{
  public static GLDrawable a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDrawable(paramInt);
    if ((paramContext instanceof BitmapDrawable)) {
      return new BitmapGLDrawable((BitmapDrawable)paramContext);
    }
    if ((paramContext instanceof NinePatchDrawable)) {
      return new NinePatchGLDrawable((NinePatchDrawable)paramContext);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */