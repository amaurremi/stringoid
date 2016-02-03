package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.internal.n;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.internal.fc;
import java.util.List;

public final class Drive
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(wy, wx, new Scope[0]);
  public static final DriveApi DriveApi = new l();
  public static final Scope EE;
  public static final Scope EF;
  public static final c EG = new p();
  public static final Scope SCOPE_APPFOLDER;
  public static final Scope SCOPE_FILE;
  public static final Api.c<n> wx = new Api.c();
  public static final Api.b<n, Api.ApiOptions.NoOptions> wy = new Api.b()
  {
    public n b(Context paramAnonymousContext, Looper paramAnonymousLooper, fc paramAnonymousfc, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      paramAnonymousNoOptions = paramAnonymousfc.eE();
      return new n(paramAnonymousContext, paramAnonymousLooper, paramAnonymousfc, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, (String[])paramAnonymousNoOptions.toArray(new String[paramAnonymousNoOptions.size()]));
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
  
  static
  {
    SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    EE = new Scope("https://www.googleapis.com/auth/drive");
    EF = new Scope("https://www.googleapis.com/auth/drive.apps");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/Drive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */