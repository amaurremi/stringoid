package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.e.a;

public final class bv
  extends e<av>
{
  private static final bv Dk = new bv();
  
  private bv()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static au d(Activity paramActivity)
  {
    try
    {
      if (e(paramActivity))
      {
        ce.aG("Using AdOverlay from the client jar.");
        return new bo(paramActivity);
      }
      paramActivity = Dk.f(paramActivity);
      return paramActivity;
    }
    catch (a paramActivity)
    {
      ce.D(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean e(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private au f(Activity paramActivity)
  {
    try
    {
      c localc = d.J(paramActivity);
      paramActivity = au.a.r(((av)B(paramActivity)).b(localc));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      ce.c("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (e.a paramActivity)
    {
      ce.c("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected av q(IBinder paramIBinder)
  {
    return av.a.s(paramIBinder);
  }
  
  private static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */