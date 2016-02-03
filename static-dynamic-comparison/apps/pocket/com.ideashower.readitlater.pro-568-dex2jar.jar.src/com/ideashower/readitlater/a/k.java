package com.ideashower.readitlater.a;

import android.app.Activity;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.util.e;

public class k
{
  private static int a = 90;
  private static boolean b = false;
  private static float c;
  private static int d;
  
  public static float a()
  {
    return c;
  }
  
  public static float a(Activity paramActivity)
  {
    float f2 = paramActivity.getWindow().getAttributes().screenBrightness;
    float f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
      f1 = i / 255.0F;
      return f1;
    }
    catch (Settings.SettingNotFoundException paramActivity)
    {
      e.a(paramActivity);
    }
    return f2;
  }
  
  public static void a(float paramFloat)
  {
    b = true;
    c = Math.max(Math.min(paramFloat, 1.0F), 0.02F);
  }
  
  public static void a(a parama)
  {
    if (!b) {
      return;
    }
    a(parama, c, d);
  }
  
  private static void a(a parama, float paramFloat, int paramInt)
  {
    Window localWindow = parama.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.screenBrightness = c;
    localWindow.setAttributes(localLayoutParams);
    parama.b(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */