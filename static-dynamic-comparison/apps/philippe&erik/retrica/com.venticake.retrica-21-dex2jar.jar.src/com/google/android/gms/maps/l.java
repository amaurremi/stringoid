package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class l
  extends a<k>
{
  protected f<k> a;
  private final Fragment b;
  private Activity c;
  
  l(Fragment paramFragment)
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
      this.a.a(new k(this.b, localIMapFragmentDelegate));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
  }
  
  protected void a(f<k> paramf)
  {
    this.a = paramf;
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */