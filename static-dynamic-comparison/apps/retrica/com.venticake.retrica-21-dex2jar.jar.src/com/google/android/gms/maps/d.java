package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class d
  extends a<c>
{
  protected f<c> a;
  private final Fragment b;
  private Activity c;
  
  d(Fragment paramFragment)
  {
    this.b = paramFragment;
  }
  
  private void a(Activity paramActivity)
  {
    this.c = paramActivity;
    a();
  }
  
  public void a()
  {
    if ((this.c != null) && (this.a != null) && (gH() == null)) {}
    try
    {
      MapsInitializer.initialize(this.c);
      IMapFragmentDelegate localIMapFragmentDelegate = u.H(this.c).i(e.h(this.c));
      this.a.a(new c(this.b, localIMapFragmentDelegate));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
  }
  
  protected void a(f<c> paramf)
  {
    this.a = paramf;
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */