package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.panorama.Panorama.PanoramaResult;
import com.google.android.gms.panorama.Panorama.a;

public class hm
  extends dw<hl>
{
  @Deprecated
  public hm(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, new dw.c(paramConnectionCallbacks), new dw.g(paramOnConnectionFailedListener));
  }
  
  public hm(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }
  
  public void a(a.c<Panorama.PanoramaResult> paramc, Uri paramUri, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Uri localUri = paramUri;; localUri = null)
    {
      a(new b(null, paramc, localUri), paramUri, null, paramBoolean);
      return;
    }
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramec.a(parame, 4242000, getContext().getPackageName(), localBundle);
  }
  
  public void a(b paramb, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
  {
    bP();
    if (paramBoolean) {
      getContext().grantUriPermission("com.google.android.gms", paramUri, 1);
    }
    try
    {
      ((hl)bQ()).a(paramb, paramUri, paramBundle, paramBoolean);
      return;
    }
    catch (RemoteException paramUri)
    {
      paramb.a(8, null, 0, null);
    }
  }
  
  protected String am()
  {
    return "com.google.android.gms.panorama.service.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
  
  public hl at(IBinder paramIBinder)
  {
    return hl.a.as(paramIBinder);
  }
  
  final class a
    extends dw<hl>.b<a.c<Panorama.a>>
    implements Panorama.a
  {
    public final Status Dl;
    public final Intent Dm;
    public final int type;
    
    public a(Status paramStatus, int paramInt, Intent paramIntent)
    {
      super(paramStatus);
      this.Dl = paramInt;
      this.type = paramIntent;
      Intent localIntent;
      this.Dm = localIntent;
    }
    
    protected void aL() {}
    
    protected void c(a.c<Panorama.a> paramc)
    {
      paramc.a(this);
    }
    
    public Status getStatus()
    {
      return this.Dl;
    }
    
    public Intent getViewerIntent()
    {
      return this.Dm;
    }
  }
  
  final class b
    extends hk.a
  {
    private final a.c<Panorama.a> Do;
    private final a.c<Panorama.PanoramaResult> Dp;
    private final Uri Dq;
    
    public b(a.c<Panorama.PanoramaResult> paramc, Uri paramUri)
    {
      this.Do = paramc;
      this.Dp = paramUri;
      Uri localUri;
      this.Dq = localUri;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (this.Dq != null) {
        hm.this.getContext().revokeUriPermission(this.Dq, 1);
      }
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        if (this.Dp != null) {
          hm.this.a(new hm.c(hm.this, this.Dp, paramBundle, paramIntent));
        }
        while (this.Do == null) {
          return;
        }
        hm.this.a(new hm.a(hm.this, this.Do, paramBundle, paramInt2, paramIntent));
        return;
      }
    }
  }
  
  final class c
    extends dw<hl>.b<a.c<Panorama.PanoramaResult>>
    implements Panorama.PanoramaResult
  {
    private final Status Dl;
    private final Intent Dm;
    
    public c(Status paramStatus, Intent paramIntent)
    {
      super(paramStatus);
      this.Dl = paramIntent;
      Intent localIntent;
      this.Dm = localIntent;
    }
    
    protected void aL() {}
    
    protected void c(a.c<Panorama.PanoramaResult> paramc)
    {
      paramc.a(this);
    }
    
    public Status getStatus()
    {
      return this.Dl;
    }
    
    public Intent getViewerIntent()
    {
      return this.Dm;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */