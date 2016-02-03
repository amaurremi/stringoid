package com.admob.android.ads;

import android.graphics.PointF;
import android.view.View;

public final class f
{
  public float a = 0.0F;
  public PointF b = new PointF(0.5F, 0.5F);
  
  public static float a(View paramView)
  {
    if (paramView != null) {
      return c(paramView).a;
    }
    return 0.0F;
  }
  
  public static PointF b(View paramView)
  {
    if (paramView != null) {
      return c(paramView).b;
    }
    return null;
  }
  
  public static f c(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof f))) {
      return (f)paramView;
    }
    return new f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */