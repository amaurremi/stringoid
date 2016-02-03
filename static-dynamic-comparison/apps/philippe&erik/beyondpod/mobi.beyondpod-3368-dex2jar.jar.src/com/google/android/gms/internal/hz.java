package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class hz
  implements Moments
{
  private final Api.b<hs> Ea;
  
  public hz(Api.b<hs> paramb)
  {
    this.Ea = paramb;
  }
  
  public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.j(this);
      }
    });
  }
  
  public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient, final int paramInt, final String paramString1, final Uri paramUri, final String paramString2, final String paramString3)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.a(this, paramInt, paramString1, paramUri, paramString2, paramString3);
      }
    });
  }
  
  public PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.removeMoment(paramString);
        a(Status.nA);
      }
    });
  }
  
  public PendingResult<Status> write(GoogleApiClient paramGoogleApiClient, final Moment paramMoment)
  {
    paramGoogleApiClient.b(new c(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.writeMoment(paramMoment);
        a(Status.nA);
      }
    });
  }
  
  private static abstract class a
    extends Plus.a<Moments.LoadMomentsResult>
  {
    a(Api.b<hs> paramb)
    {
      super();
    }
    
    public Moments.LoadMomentsResult K(final Status paramStatus)
    {
      new Moments.LoadMomentsResult()
      {
        public MomentBuffer getMomentBuffer()
        {
          return null;
        }
        
        public String getNextPageToken()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public String getUpdated()
        {
          return null;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class b
    extends Plus.a<Status>
  {
    b(Api.b<hs> paramb)
    {
      super();
    }
    
    public Status g(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static abstract class c
    extends Plus.a<Status>
  {
    c(Api.b<hs> paramb)
    {
      super();
    }
    
    public Status g(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */