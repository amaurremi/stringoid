package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.gz;
import java.util.List;

public final class Drive
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  public static final DriveApi DriveApi = new p();
  public static final Scope HE;
  public static final Scope HF;
  public static final Api<b> HG;
  public static final b HH = new t();
  public static final d HI = new w();
  public static final Scope SCOPE_APPFOLDER;
  public static final Scope SCOPE_FILE;
  public static final Api.c<r> yE = new Api.c();
  
  static
  {
    SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    HE = new Scope("https://www.googleapis.com/auth/drive");
    HF = new Scope("https://www.googleapis.com/auth/drive.apps");
    API = new Api(new a()
    {
      protected Bundle a(Api.ApiOptions.NoOptions paramAnonymousNoOptions)
      {
        return new Bundle();
      }
    }, yE, new Scope[0]);
    HG = new Api(new a()
    {
      protected Bundle a(Drive.b paramAnonymousb)
      {
        if (paramAnonymousb == null) {
          return new Bundle();
        }
        return paramAnonymousb.ge();
      }
    }, yE, new Scope[0]);
  }
  
  public static abstract class a<O extends Api.ApiOptions>
    implements Api.b<r, O>
  {
    protected abstract Bundle a(O paramO);
    
    public r a(Context paramContext, Looper paramLooper, gz paramgz, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      List localList = paramgz.fg();
      return new r(paramContext, paramLooper, paramgz, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])localList.toArray(new String[localList.size()]), a(paramO));
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  }
  
  public static class b
    implements Api.ApiOptions.Optional
  {
    private final Bundle HJ;
    
    private b()
    {
      this(new Bundle());
    }
    
    private b(Bundle paramBundle)
    {
      this.HJ = paramBundle;
    }
    
    public Bundle ge()
    {
      return this.HJ;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/Drive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */