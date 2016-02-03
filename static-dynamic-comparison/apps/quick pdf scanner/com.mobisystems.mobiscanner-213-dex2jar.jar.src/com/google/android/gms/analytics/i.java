package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.a.a;
import com.google.android.gms.ads.a.a.a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

class i
  implements af
{
  private static Object mL = new Object();
  private static i mM;
  private Context mContext;
  private a.a mN;
  private long mO;
  
  private i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private a.a kN()
  {
    try
    {
      a.a locala = a.n(this.mContext);
      return locala;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      j.D("IllegalStateException getting Ad Id Info");
      return null;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      j.D("GooglePlayServicesRepairableException getting Ad Id Info");
      return null;
    }
    catch (IOException localIOException)
    {
      j.D("IOException getting Ad Id Info");
      return null;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      j.D("GooglePlayServicesNotAvailableException getting Ad Id Info");
      return null;
    }
    catch (Exception localException)
    {
      j.D("Unknown exception. Could not get the ad Id.");
    }
    return null;
  }
  
  public static af p(Context paramContext)
  {
    if (mM == null) {}
    synchronized (mL)
    {
      if (mM == null) {
        mM = new i(paramContext);
      }
      return mM;
    }
  }
  
  public String getValue(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.mO > 1000L)
    {
      this.mN = kN();
      this.mO = l;
    }
    if (this.mN != null)
    {
      if ("&adid".equals(paramString)) {
        return this.mN.getId();
      }
      if ("&ate".equals(paramString))
      {
        if (this.mN.kv()) {
          return "1";
        }
        return "0";
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */