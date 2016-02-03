package com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.internal.dt;
import java.util.List;

public final class Drive
{
  public static final Api API = new Api(jO, new Scope[0]);
  public static final DriveApi DriveApi = new h();
  public static final Scope SCOPE_FILE;
  public static final Api.b<j> jO = new Api.b()
  {
    public j d(Context paramAnonymousContext, dt paramAnonymousdt, GoogleApiClient.ApiOptions paramAnonymousApiOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      paramAnonymousApiOptions = paramAnonymousdt.bH();
      return new j(paramAnonymousContext, paramAnonymousdt, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, (String[])paramAnonymousApiOptions.toArray(new String[paramAnonymousApiOptions.size()]));
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
  
  static
  {
    SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/Drive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */