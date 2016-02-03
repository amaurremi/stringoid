package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class jh
  extends g<jc>
{
  private static jh adc;
  
  protected jh()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  public static iz a(Activity paramActivity, c paramc, WalletFragmentOptions paramWalletFragmentOptions, ja paramja)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      paramActivity = ((jc)lY().z(paramActivity)).a(e.h(paramActivity), paramc, paramWalletFragmentOptions, paramja);
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
    catch (g.a paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
  }
  
  private static jh lY()
  {
    if (adc == null) {
      adc = new jh();
    }
    return adc;
  }
  
  protected jc aZ(IBinder paramIBinder)
  {
    return jc.a.aV(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */