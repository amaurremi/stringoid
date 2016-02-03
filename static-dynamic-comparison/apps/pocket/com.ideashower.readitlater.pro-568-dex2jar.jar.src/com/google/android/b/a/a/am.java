package com.google.android.b.a.a;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

public final class am
  extends ao
  implements f
{
  private final String b;
  private final String c;
  private final String d;
  private boolean e;
  
  public am(Context paramContext, String paramString1, String paramString2, String paramString3, aw paramaw, ax paramax)
  {
    super(paramContext, paramaw, paramax);
    this.b = ((String)d.a(paramString1, "developerKey cannot be null"));
    this.c = d.a(paramString2, "callingPackage cannot be null or empty");
    this.d = d.a(paramString3, "callingAppVersion cannot be null or empty");
  }
  
  private final void k()
  {
    i();
    if (this.e) {
      throw new IllegalStateException("Connection client has been released");
    }
  }
  
  public final IBinder a()
  {
    k();
    try
    {
      IBinder localIBinder = ((ah)j()).a();
      return localIBinder;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  protected final void a(y paramy, as paramas)
  {
    paramy.a(paramas, 1000, this.c, this.d, this.b, null);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (f()) {}
    try
    {
      ((ah)j()).a(paramBoolean);
      this.e = true;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected final String b()
  {
    return "com.google.android.youtube.player.internal.IYouTubeService";
  }
  
  protected final String c()
  {
    return "com.google.android.youtube.api.service.START";
  }
  
  public final void d()
  {
    if (!this.e) {
      a(true);
    }
    super.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */