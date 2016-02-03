package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class bk
  extends aj
{
  private static final String ID = a.ad.toString();
  private final Context mContext;
  
  public bk(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  protected String L(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    paramMap = L(this.mContext);
    if (paramMap == null) {
      return dh.mY();
    }
    return dh.r(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */