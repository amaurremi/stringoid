package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.iw;

public final class Address
{
  public static final Api<Address.AddressOptions> API = new Api(yI, yH, new Scope[0]);
  static final Api.c<iw> yH = new Api.c();
  private static final Api.b<iw, Address.AddressOptions> yI = new Api.b()
  {
    public iw a(Context paramAnonymousContext, Looper paramAnonymousLooper, gy paramAnonymousgy, Address.AddressOptions paramAnonymousAddressOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      hm.b(paramAnonymousContext instanceof Activity, "An Activity must be used for Address APIs");
      Address.AddressOptions localAddressOptions = paramAnonymousAddressOptions;
      if (paramAnonymousAddressOptions == null) {
        localAddressOptions = new Address.AddressOptions();
      }
      return new iw((Activity)paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousgy.getAccountName(), localAddressOptions.theme);
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
  
  public static void requestUserAddress(GoogleApiClient paramGoogleApiClient, UserAddressRequest paramUserAddressRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new b()
    {
      protected void a(iw paramAnonymousiw)
      {
        paramAnonymousiw.a(Address.this, paramInt);
        b(Status.En);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/identity/intents/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */