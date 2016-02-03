package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;
import com.google.android.gms.panorama.PanoramaApi.a;

public class kf
  implements PanoramaApi
{
  private static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void a(Context paramContext, ke paramke, final kd paramkd, final Uri paramUri, Bundle paramBundle)
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    paramkd = new kd.a()
    {
      public void a(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        kf.b(kf.this, paramUri);
        paramkd.a(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramke.a(paramkd, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException paramke)
    {
      a(paramContext, paramUri);
      throw paramke;
    }
    catch (RuntimeException paramke)
    {
      a(paramContext, paramUri);
      throw paramke;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new pp(paramUri)
    {
      protected void a(Context paramAnonymousContext, ke paramAnonymouske)
      {
        paramAnonymouske.a(new pq(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new pp(paramUri)
    {
      protected void a(Context paramAnonymousContext, ke paramAnonymouske)
      {
        kf.b(paramAnonymousContext, paramAnonymouske, new pq(this), paramUri, null);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/kf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */