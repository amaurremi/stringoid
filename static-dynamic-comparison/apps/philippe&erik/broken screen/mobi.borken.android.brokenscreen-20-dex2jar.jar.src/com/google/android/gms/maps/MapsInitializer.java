package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer
{
  public static void a(c paramc)
  {
    try
    {
      CameraUpdateFactory.a(paramc.jC());
      BitmapDescriptorFactory.a(paramc.jD());
      return;
    }
    catch (RemoteException paramc)
    {
      throw new RuntimeRemoteException(paramc);
    }
  }
  
  public static int initialize(Context paramContext)
  {
    hn.f(paramContext);
    try
    {
      paramContext = u.E(paramContext);
      a(paramContext);
      return 0;
    }
    catch (GooglePlayServicesNotAvailableException paramContext) {}
    return paramContext.errorCode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/MapsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */