package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class i
  extends a<j>
{
  protected f<j> a;
  private final ViewGroup b;
  private final Context c;
  private final StreetViewPanoramaOptions d;
  
  i(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    this.b = paramViewGroup;
    this.c = paramContext;
    this.d = paramStreetViewPanoramaOptions;
  }
  
  public void a()
  {
    if ((this.a != null) && (gH() == null)) {}
    try
    {
      IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = u.H(this.c).a(e.h(this.c), this.d);
      this.a.a(new j(this.b, localIStreetViewPanoramaViewDelegate));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
  }
  
  protected void a(f<j> paramf)
  {
    this.a = paramf;
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */