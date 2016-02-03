package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ci
  extends aj
{
  private static final String ID = a.Q.toString();
  private final Context mContext;
  
  public ci(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean jX()
  {
    return true;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    paramMap = new DisplayMetrics();
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramMap);
    int i = paramMap.widthPixels;
    int j = paramMap.heightPixels;
    return dh.r(i + "x" + j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */