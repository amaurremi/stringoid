package android.support.v7.internal.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.b.c;
import android.support.v7.b.d;
import android.support.v7.b.e;
import android.support.v7.b.g;
import android.support.v7.b.k;
import android.util.DisplayMetrics;

public class a
{
  private Context a;
  
  private a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public int a()
  {
    return this.a.getResources().getInteger(g.abc_max_action_buttons);
  }
  
  public boolean b()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public int c()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels / 2;
  }
  
  public boolean d()
  {
    return this.a.getResources().getBoolean(d.abc_action_bar_embed_tabs_pre_jb);
  }
  
  public int e()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(null, k.ActionBar, c.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(1, 0);
    Resources localResources = this.a.getResources();
    int i = j;
    if (!d()) {
      i = Math.min(j, localResources.getDimensionPixelSize(e.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    return i;
  }
  
  public boolean f()
  {
    return this.a.getApplicationInfo().targetSdkVersion < 14;
  }
  
  public int g()
  {
    return this.a.getResources().getDimensionPixelSize(e.abc_action_bar_stacked_tab_max_width);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */