package com.google.android.gms.ads.b;

import android.os.RemoteException;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.internal.ap;

public class d
  implements f
{
  private final ap a;
  
  public d(ap paramap)
  {
    this.a = paramap;
  }
  
  public void a()
  {
    aa.f("onAdLoaded must be called on the main UI thread.");
    aa.a("Adapter called onAdLoaded.");
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdLoaded.", localRemoteException);
    }
  }
  
  public void a(int paramInt)
  {
    aa.f("onAdFailedToLoad must be called on the main UI thread.");
    aa.a("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void b()
  {
    aa.f("onAdOpened must be called on the main UI thread.");
    aa.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdOpened.", localRemoteException);
    }
  }
  
  public void b(int paramInt)
  {
    aa.f("onAdFailedToLoad must be called on the main UI thread.");
    aa.a("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void c()
  {
    aa.f("onAdClosed must be called on the main UI thread.");
    aa.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void d()
  {
    aa.f("onAdLeftApplication must be called on the main UI thread.");
    aa.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void e()
  {
    aa.f("onClick must be called on the main UI thread.");
    aa.a("Adapter called onClick.");
    try
    {
      this.a.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdClicked.", localRemoteException);
    }
  }
  
  public void f()
  {
    aa.f("onAdClosed must be called on the main UI thread.");
    aa.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void g()
  {
    aa.f("onAdLeftApplication must be called on the main UI thread.");
    aa.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void h()
  {
    aa.f("onAdOpened must be called on the main UI thread.");
    aa.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdOpened.", localRemoteException);
    }
  }
  
  public void i()
  {
    aa.f("onAdLoaded must be called on the main UI thread.");
    aa.a("Adapter called onAdLoaded.");
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.b("Could not call onAdLoaded.", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/ads/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */