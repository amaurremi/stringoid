package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.hm;

public final class Panorama
{
  public static final Api API = new Api(jO, new Scope[0]);
  static final Api.b<hm> jO = new Api.b()
  {
    public hm f(Context paramAnonymousContext, dt paramAnonymousdt, GoogleApiClient.ApiOptions paramAnonymousApiOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new hm(paramAnonymousContext, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
  
  public static PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    paramGoogleApiClient.a(new b()
    {
      protected void a(hm paramAnonymoushm)
      {
        paramAnonymoushm.a(this, this.Dg, false);
      }
    });
  }
  
  public static PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    paramGoogleApiClient.a(new b()
    {
      protected void a(hm paramAnonymoushm)
      {
        paramAnonymoushm.a(this, this.Dg, true);
      }
    });
  }
  
  public static abstract interface PanoramaResult
    extends Result
  {
    public abstract Intent getViewerIntent();
  }
  
  public static abstract interface a
    extends Panorama.PanoramaResult
  {}
  
  private static abstract class b
    extends a.a<Panorama.PanoramaResult, hm>
  {
    public b()
    {
      super();
    }
    
    public Panorama.PanoramaResult J(final Status paramStatus)
    {
      new Panorama.PanoramaResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public Intent getViewerIntent()
        {
          return null;
        }
      };
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/panorama/Panorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */