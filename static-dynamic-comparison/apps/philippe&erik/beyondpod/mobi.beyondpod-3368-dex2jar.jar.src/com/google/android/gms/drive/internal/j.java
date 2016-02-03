package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dw.e;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.eg;

public class j
  extends dw<o>
{
  private final String jG;
  private DriveId rg;
  
  public j(Context paramContext, dt paramdt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.jG = ((String)eg.b(paramdt.bF(), "Must call Api.ClientBuilder.setAccountName()"));
  }
  
  protected o B(IBinder paramIBinder)
  {
    return o.a.C(paramIBinder);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.rg = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    String str = getContext().getPackageName();
    eg.f(parame);
    eg.f(str);
    eg.f(bO());
    paramec.a(parame, 4242000, str, bO(), this.jG, new Bundle());
  }
  
  protected String am()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public o cN()
  {
    return (o)bQ();
  }
  
  public DriveId cO()
  {
    return this.rg;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */