package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.a.c;
import java.util.LinkedHashSet;
import java.util.Locale;

public class fg
{
  private static final String TAG = fg.class.getSimpleName();
  private final eq<em> MJ;
  private final Locale PY;
  private final fi PZ;
  private final id Qm;
  private final LinkedHashSet<String> Qn;
  private final Context mContext;
  
  public fg(Context paramContext, Locale paramLocale, eq<em> parameq)
  {
    this.mContext = paramContext;
    this.MJ = parameq;
    this.PY = paramLocale;
    this.Qm = new id(paramContext, paramLocale);
    this.Qn = new LinkedHashSet();
    this.Qn.add(paramContext.getString(a.c.location_client_powered_by_google));
    paramContext = this.mContext.getPackageName();
    try
    {
      i = this.mContext.getPackageManager().getPackageInfo(paramContext, 0).versionCode;
      this.PZ = new fi(this.MJ, paramContext, i);
      return;
    }
    catch (PackageManager.NameNotFoundException paramLocale)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */