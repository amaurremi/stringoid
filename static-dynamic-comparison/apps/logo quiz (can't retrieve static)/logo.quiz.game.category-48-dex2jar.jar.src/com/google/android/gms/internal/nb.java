package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;
import com.google.android.gms.panorama.PanoramaApi.a;

public class nb
  implements PanoramaApi
{
  private static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void a(Context paramContext, na paramna, final mz parammz, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    parammz = new mz.a()
    {
      public void a(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        nb.b(this.mV, paramUri);
        parammz.a(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramna.a(parammz, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException paramna)
    {
      a(paramContext, paramUri);
      throw paramna;
    }
    catch (RuntimeException paramna)
    {
      a(paramContext, paramUri);
      throw paramna;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, na paramAnonymousna)
        throws RemoteException
      {
        paramAnonymousna.a(new nb.c(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, na paramAnonymousna)
        throws RemoteException
      {
        nb.b(paramAnonymousContext, paramAnonymousna, new nb.c(this), paramUri, null);
      }
    });
  }
  
  private static final class a
    extends mz.a
  {
    private final BaseImplementation.b<PanoramaApi.a> De;
    
    public a(BaseImplementation.b<PanoramaApi.a> paramb)
    {
      this.De = paramb;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        this.De.b(new my(paramBundle, paramIntent, paramInt2));
        return;
      }
    }
  }
  
  private static abstract class b
    extends nb.d<PanoramaApi.PanoramaResult>
  {
    protected PanoramaApi.PanoramaResult az(Status paramStatus)
    {
      return new nd(paramStatus, null);
    }
  }
  
  private static final class c
    extends mz.a
  {
    private final BaseImplementation.b<PanoramaApi.PanoramaResult> De;
    
    public c(BaseImplementation.b<PanoramaApi.PanoramaResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        this.De.b(new nd(paramBundle, paramIntent));
        return;
      }
    }
  }
  
  private static abstract class d<R extends Result>
    extends BaseImplementation.a<R, nc>
  {
    protected d()
    {
      super();
    }
    
    protected abstract void a(Context paramContext, na paramna)
      throws RemoteException;
    
    protected final void a(nc paramnc)
      throws RemoteException
    {
      a(paramnc.getContext(), (na)paramnc.gS());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */