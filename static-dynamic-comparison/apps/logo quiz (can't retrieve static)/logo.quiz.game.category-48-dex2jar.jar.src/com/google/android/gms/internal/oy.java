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

public class oy
  extends g<ot>
{
  private static oy aum;
  
  protected oy()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  public static oq a(Activity paramActivity, c paramc, WalletFragmentOptions paramWalletFragmentOptions, or paramor)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      paramActivity = ((ot)pN().L(paramActivity)).a(e.k(paramActivity), paramc, paramWalletFragmentOptions, paramor);
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
  
  private static oy pN()
  {
    if (aum == null) {
      aum = new oy();
    }
    return aum;
  }
  
  protected ot bQ(IBinder paramIBinder)
  {
    return ot.a.bM(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/oy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */