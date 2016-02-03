package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class f
  extends a<e>
{
  protected com.google.android.gms.dynamic.f<e> a;
  private final ViewGroup b;
  private final Context c;
  private final GoogleMapOptions d;
  
  f(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    this.b = paramViewGroup;
    this.c = paramContext;
    this.d = paramGoogleMapOptions;
  }
  
  public void a()
  {
    if ((this.a != null) && (gH() == null)) {}
    try
    {
      IMapViewDelegate localIMapViewDelegate = u.H(this.c).a(com.google.android.gms.dynamic.e.h(this.c), this.d);
      this.a.a(new e(this.b, localIMapViewDelegate));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
  }
  
  protected void a(com.google.android.gms.dynamic.f<e> paramf)
  {
    this.a = paramf;
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */