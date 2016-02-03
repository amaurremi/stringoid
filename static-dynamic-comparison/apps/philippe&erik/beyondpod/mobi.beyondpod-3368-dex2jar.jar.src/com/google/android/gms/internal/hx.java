package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus.a;

public final class hx
  implements Account
{
  private final Api.b<hs> Ea;
  
  public hx(Api.b<hs> paramb)
  {
    this.Ea = paramb;
  }
  
  private static hs a(GoogleApiClient paramGoogleApiClient, Api.b<hs> paramb)
  {
    boolean bool2 = true;
    if (paramGoogleApiClient != null)
    {
      bool1 = true;
      eg.b(bool1, "GoogleApiClient parameter is required.");
      eg.a(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
      paramGoogleApiClient = (hs)paramGoogleApiClient.a(paramb);
      if (paramGoogleApiClient == null) {
        break label51;
      }
    }
    label51:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eg.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return paramGoogleApiClient;
      bool1 = false;
      break;
    }
  }
  
  public void clearDefaultAccount(GoogleApiClient paramGoogleApiClient)
  {
    a(paramGoogleApiClient, this.Ea).clearDefaultAccount();
  }
  
  public String getAccountName(GoogleApiClient paramGoogleApiClient)
  {
    return a(paramGoogleApiClient, this.Ea).getAccountName();
  }
  
  public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.l(this);
      }
    });
  }
  
  private static abstract class a
    extends Plus.a<Status>
  {
    a(Api.b<hs> paramb)
    {
      super();
    }
    
    public Status g(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */