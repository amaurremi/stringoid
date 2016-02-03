package com.gtp.nextlauncher.widget.nextpanel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.go.gl.view.GLLayoutInflater;
import com.go.gowidget.core.IFullScreenNextWidget;

public class MainActivity
  extends Activity
{
  public static IFullScreenNextWidget create3DWidget(Context paramContext, GLLayoutInflater paramGLLayoutInflater, Bundle paramBundle)
  {
    a.a = paramBundle.getString("next_launcher_package");
    return new PanelMain(paramContext);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */