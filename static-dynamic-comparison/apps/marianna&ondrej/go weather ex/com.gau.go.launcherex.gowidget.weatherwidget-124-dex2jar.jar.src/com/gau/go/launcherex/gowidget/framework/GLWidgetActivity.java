package com.gau.go.launcherex.gowidget.framework;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.go.gl.GLActivity;
import com.go.gl.view.GLLayoutInflater;
import com.go.gowidget.core.IGoWidget3D;

public class GLWidgetActivity
  extends GLActivity
{
  public static IGoWidget3D create3DWidget(Context paramContext, GLLayoutInflater paramGLLayoutInflater, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        int j = paramBundle.getInt("gowidget_type");
        paramBundle = paramContext.getResources().getIntArray(2131558405);
        i = 0;
        if (i < paramBundle.length)
        {
          if (paramBundle[i] == j)
          {
            if (i != -1)
            {
              paramBundle = paramContext.getResources().getStringArray(2131558408);
              if (i < paramBundle.length)
              {
                paramContext = (IGoWidget3D)paramGLLayoutInflater.inflate(paramContext.getResources().getIdentifier(paramBundle[i] + "_3d", "layout", paramContext.getPackageName()), null);
                return paramContext;
              }
            }
          }
          else
          {
            i += 1;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      int i = -1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/GLWidgetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */