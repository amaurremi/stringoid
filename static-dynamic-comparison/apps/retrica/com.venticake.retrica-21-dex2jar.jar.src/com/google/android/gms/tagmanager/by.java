package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class by
  extends t
{
  private static final String a = a.Q.toString();
  private final Context b;
  
  public by(Context paramContext)
  {
    super(a, new String[0]);
    this.b = paramContext;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    paramMap = new DisplayMetrics();
    ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay().getMetrics(paramMap);
    int i = paramMap.widthPixels;
    int j = paramMap.heightPixels;
    return de.f(i + "x" + j);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */