package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;
import com.google.android.gms.panorama.PanoramaApi.a;

public class kg
  implements PanoramaApi
{
  private static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void a(Context paramContext, kf paramkf, final ke paramke, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    paramke = new ke.a()
    {
      public void a(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        kg.b(this.qr, paramUri);
        paramke.a(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramkf.a(paramke, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException paramkf)
    {
      a(paramContext, paramUri);
      throw paramkf;
    }
    catch (RuntimeException paramkf)
    {
      a(paramContext, paramUri);
      throw paramkf;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, kf paramAnonymouskf)
        throws RemoteException
      {
        paramAnonymouskf.a(new kg.c(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, kf paramAnonymouskf)
        throws RemoteException
      {
        kg.b(paramAnonymousContext, paramAnonymouskf, new kg.c(this), paramUri, null);
      }
    });
  }
  
  private static final class a
    extends ke.a
  {
    private final a.d<PanoramaApi.a> yO;
    
    public a(a.d<PanoramaApi.a> paramd)
    {
      this.yO = paramd;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        this.yO.a(new kd(paramBundle, paramIntent, paramInt2));
        return;
      }
    }
  }
  
  private static abstract class b
    extends kg.d<PanoramaApi.PanoramaResult>
  {
    protected PanoramaApi.PanoramaResult ak(Status paramStatus)
    {
      return new ki(paramStatus, null);
    }
  }
  
  private static final class c
    extends ke.a
  {
    private final a.d<PanoramaApi.PanoramaResult> yO;
    
    public c(a.d<PanoramaApi.PanoramaResult> paramd)
    {
      this.yO = paramd;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        this.yO.a(new ki(paramBundle, paramIntent));
        return;
      }
    }
  }
  
  private static abstract class d<R extends Result>
    extends a.b<R, kh>
  {
    protected d()
    {
      super();
    }
    
    protected abstract void a(Context paramContext, kf paramkf)
      throws RemoteException;
    
    protected final void a(kh paramkh)
      throws RemoteException
    {
      a(paramkh.getContext(), (kf)paramkh.fo());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/kg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */