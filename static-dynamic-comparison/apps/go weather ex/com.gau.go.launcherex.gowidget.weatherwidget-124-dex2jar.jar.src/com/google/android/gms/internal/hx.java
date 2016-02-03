package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;
import com.google.android.gms.panorama.PanoramaApi.a;

public class hx
  extends ff<hv>
{
  public hx(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }
  
  public void a(a.d<PanoramaApi.PanoramaResult> paramd, Uri paramUri, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Uri localUri = paramUri;; localUri = null)
    {
      a(new b(null, paramd, localUri), paramUri, null, paramBoolean);
      return;
    }
  }
  
  protected void a(fm paramfm, ff.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramfm.a(parame, 4452000, getContext().getPackageName(), localBundle);
  }
  
  public void a(b paramb, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
  {
    bT();
    if (paramBoolean) {
      getContext().grantUriPermission("com.google.android.gms", paramUri, 1);
    }
    try
    {
      ((hv)eM()).a(paramb, paramUri, paramBundle, paramBoolean);
      return;
    }
    catch (RemoteException paramUri)
    {
      paramb.a(8, null, 0, null);
    }
  }
  
  public hv aN(IBinder paramIBinder)
  {
    return hv.a.aM(paramIBinder);
  }
  
  protected String bg()
  {
    return "com.google.android.gms.panorama.service.START";
  }
  
  protected String bh()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
  
  final class a
    extends ff<hv>.b<a.d<PanoramaApi.a>>
    implements PanoramaApi.a
  {
    public final Status TC;
    public final Intent TD;
    public final int type;
    
    public a(Status paramStatus, int paramInt, Intent paramIntent)
    {
      super(paramStatus);
      this.TC = paramInt;
      this.type = paramIntent;
      Intent localIntent;
      this.TD = localIntent;
    }
    
    protected void c(a.d<PanoramaApi.a> paramd)
    {
      paramd.b(this);
    }
    
    protected void dx() {}
    
    public Status getStatus()
    {
      return this.TC;
    }
    
    public Intent getViewerIntent()
    {
      return this.TD;
    }
  }
  
  final class b
    extends hu.a
  {
    private final a.d<PanoramaApi.a> TF;
    private final a.d<PanoramaApi.PanoramaResult> TG;
    private final Uri TH;
    
    public b(a.d<PanoramaApi.PanoramaResult> paramd, Uri paramUri)
    {
      this.TF = paramd;
      this.TG = paramUri;
      Uri localUri;
      this.TH = localUri;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (this.TH != null) {
        hx.this.getContext().revokeUriPermission(this.TH, 1);
      }
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        if (this.TG != null) {
          hx.this.a(new hx.c(hx.this, this.TG, paramBundle, paramIntent));
        }
        while (this.TF == null) {
          return;
        }
        hx.this.a(new hx.a(hx.this, this.TF, paramBundle, paramInt2, paramIntent));
        return;
      }
    }
  }
  
  final class c
    extends ff<hv>.b<a.d<PanoramaApi.PanoramaResult>>
    implements PanoramaApi.PanoramaResult
  {
    private final Status TC;
    private final Intent TD;
    
    public c(Status paramStatus, Intent paramIntent)
    {
      super(paramStatus);
      this.TC = paramIntent;
      Intent localIntent;
      this.TD = localIntent;
    }
    
    protected void c(a.d<PanoramaApi.PanoramaResult> paramd)
    {
      paramd.b(this);
    }
    
    protected void dx() {}
    
    public Status getStatus()
    {
      return this.TC;
    }
    
    public Intent getViewerIntent()
    {
      return this.TD;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */