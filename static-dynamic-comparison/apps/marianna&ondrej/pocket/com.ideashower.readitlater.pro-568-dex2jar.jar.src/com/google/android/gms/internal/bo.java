package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.b.a.b.a;
import com.google.android.gms.common.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class bo
  extends s
  implements b
{
  private a f;
  private fn g;
  
  public bo(Context paramContext, fn paramfn, com.google.android.gms.common.c paramc, com.google.android.gms.common.d paramd)
  {
    super(paramContext, paramc, paramd, paramfn.c());
    this.g = paramfn;
  }
  
  protected String a()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.f = fv.a(paramBundle.getByteArray("loaded_person"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(com.google.android.gms.b.c paramc)
  {
    k();
    n();
    paramc = new br(this, paramc);
    try
    {
      ((bl)l()).b(paramc);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramc.a(8, null);
    }
  }
  
  public void a(com.google.android.gms.b.d paramd, Collection paramCollection)
  {
    k();
    paramd = new bp(this, paramd);
    try
    {
      ((bl)l()).a(paramd, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException paramCollection)
    {
      paramd.a(com.google.android.gms.common.data.d.b(8), null);
    }
  }
  
  public void a(com.google.android.gms.b.d paramd, String[] paramArrayOfString)
  {
    a(paramd, Arrays.asList(paramArrayOfString));
  }
  
  protected void a(ai paramai, y paramy)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", this.g.i());
    localBundle.putStringArray("request_visible_actions", this.g.d());
    paramai.a(paramy, 4030500, this.g.g(), this.g.f(), g(), this.g.b(), localBundle);
  }
  
  protected String b()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  protected bl c(IBinder paramIBinder)
  {
    return bm.a(paramIBinder);
  }
  
  public String m()
  {
    k();
    try
    {
      String str = ((bl)l()).a();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void n()
  {
    k();
    try
    {
      this.f = null;
      ((bl)l()).b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */