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

public class ls
  extends g<ln>
{
  private static ls akN;
  
  protected ls()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  public static lk a(Activity paramActivity, c paramc, WalletFragmentOptions paramWalletFragmentOptions, ll paramll)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      paramActivity = ((ln)nj().G(paramActivity)).a(e.h(paramActivity), paramc, paramWalletFragmentOptions, paramll);
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
  
  private static ls nj()
  {
    if (akN == null) {
      akN = new ls();
    }
    return akN;
  }
  
  protected ln bv(IBinder paramIBinder)
  {
    return ln.a.br(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */