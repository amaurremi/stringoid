package com.skplanet.tad.videoplayer.activity.core;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.skplanet.tad.videoplayer.util.b;

public class a
{
  public static int a = 300;
  public static int b = 80;
  public static int c = 142;
  public static int d = 60;
  public static int e = 72;
  public static int f = 72;
  public static int g = 10;
  public static int h = 20;
  public static int i = 25;
  public static int j = 50;
  public static int k = 50;
  public static int l = 50;
  public static int m = 21;
  public static int n = 14;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static float s = 1280.0F;
  public static float t = 560.0F;
  public static boolean u = false;
  
  public static void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    int i2 = paramActivity.getWidth();
    int i3 = paramActivity.getHeight();
    b.a("WidthxHeight=" + i2 + "x" + i3);
    if (paramActivity.getWidth() > paramActivity.getHeight())
    {
      i1 = paramActivity.getWidth();
      q = i1;
      if (paramActivity.getWidth() >= paramActivity.getHeight()) {
        break label787;
      }
    }
    label787:
    for (int i1 = paramActivity.getWidth();; i1 = paramActivity.getHeight())
    {
      r = i1;
      a = r * 2 / 3;
      o = q / 100;
      p = r / 100;
      float f1 = i2 + i3;
      b.a("STANDARD_SCREEN_VALUE=" + s + ",currentValue=" + f1);
      if (s != f1)
      {
        float f2 = f1 / s;
        b.a("diffRatio=" + f2);
        b = (int)(80.0F * f2);
        d = (int)(60.0F * f2);
        e = (int)(72.0F * f2);
        f = (int)(72.0F * f2);
        g = (int)(10.0F * f2);
        h = (int)(20.0F * f2);
        i = (int)(25.0F * f2);
        j = (int)(40.0F * f2);
        k = (int)(50.0F * f2) + 10;
        l = (int)(f2 * 50.0F) + 10;
      }
      if (Build.VERSION.RELEASE.startsWith("3."))
      {
        m = 36;
        n = 29;
      }
      if (50 > f)
      {
        f = 50;
        e = 50;
      }
      if (f1 == t)
      {
        a = r * 2 / 3;
        b.a("STANDARD_SCREEN_VALUE_QVGA diffRatio=" + 0.5F);
        b = (int)(80.0F * 0.5F);
        d = (int)(60.0F * 0.5F);
        e = (int)(72.0F * 0.5F);
        f = (int)(72.0F * 0.5F);
        g = (int)(10.0F * 0.5F);
        h = (int)(20.0F * 0.5F);
        i = (int)(25.0F * 0.5F);
        j = (int)(40.0F * 0.5F);
        k = (int)(50.0F * 0.5F) + 10;
        l = (int)(0.5F * 50.0F) + 10;
      }
      c = d + o + e;
      b.a("public static int PORT_HEIGHT = " + a);
      b.a("public static int LAND_TOP_HEIGHT = " + b);
      b.a("public static int LAND_BOT_HEIGHT = " + c);
      b.a("public static int LAND_BOT_SEEK_HEIGHT = " + d);
      b.a("public static int LAND_BOT_BTNS_HEIGHT = " + e);
      b.a("public static int BTN_HEIGHT = " + f);
      b.a("public static int MARGIN_S = " + g);
      b.a("public static int MARGIN_M = " + h);
      b.a("public static int MARGIN_L = " + i);
      b.a("public static int BTN_CLOSE_SIZE = " + j);
      b.a("public static int BTN_REPLAY_SIZE = " + k);
      b.a("public static int BTN_RESUME_SIZE = " + l);
      b.a("public static int MARGIN_GAP = " + o);
      b.a("public static int TITLE_FONTSIZE = " + m);
      b.a("public static int FONTSIZE = " + n);
      return;
      i1 = paramActivity.getHeight();
      break;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    u = paramBoolean;
  }
  
  public static boolean a()
  {
    return u;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/activity/core/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */