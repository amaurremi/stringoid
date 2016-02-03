package com.gau.go.launcherex.gowidget.framework;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.go.gl.GLActivity;
import com.go.gl.view.GLLayoutInflater;
import com.go.gowidget.core.IGoWidget3D;
import com.gtp.nextlauncher.widget.weatherwidget.Base;

public class GLGoWidgetActivity
  extends GLActivity
{
  public static IGoWidget3D create3DWidget(Context paramContext, GLLayoutInflater paramGLLayoutInflater, Bundle paramBundle)
  {
    if (paramBundle.getInt("gowidget_type") >= 100) {
      return new Base(paramContext);
    }
    if (paramBundle.getInt("NEXT_LAUNCHER_SUPPORT_WIDGET_VERSION") < 1) {
      Toast.makeText(paramContext, 2131165830, 1).show();
    }
    for (;;)
    {
      return null;
      Toast.makeText(paramContext, 2131165831, 1).show();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/GLGoWidgetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */