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
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.drive.internal.o;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.x;
import java.util.List;

public final class Drive
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  public static final Api.c<q> CU = new Api.c();
  public static final DriveApi DriveApi = new o();
  public static final Scope MU;
  public static final Scope MV;
  public static final Api<b> MW;
  public static final b MX = new t();
  public static final e MY = new x();
  public static final Scope SCOPE_APPFOLDER;
  public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
  
  static
  {
    SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    MU = new Scope("https://www.googleapis.com/auth/drive");
    MV = new Scope("https://www.googleapis.com/auth/drive.apps");
    API = new Api(new a()
    {
      protected Bundle a(Api.ApiOptions.NoOptions paramAnonymousNoOptions)
      {
        return new Bundle();
      }
    }, CU, new Scope[0]);
    MW = new Api(new a()
    {
      protected Bundle a(Drive.b paramAnonymousb)
      {
        if (paramAnonymousb == null) {
          return new Bundle();
        }
        return paramAnonymousb.hM();
      }
    }, CU, new Scope[0]);
  }
  
  public static abstract class a<O extends Api.ApiOptions>
    implements Api.b<q, O>
  {
    protected abstract Bundle a(O paramO);
    
    public q a(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      List localList = paramClientSettings.getScopes();
      return new q(paramContext, paramLooper, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])localList.toArray(new String[localList.size()]), a(paramO));
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  }
  
  public static class b
    implements Api.ApiOptions.Optional
  {
    private final Bundle MZ;
    
    private b()
    {
      this(new Bundle());
    }
    
    private b(Bundle paramBundle)
    {
      this.MZ = paramBundle;
    }
    
    public Bundle hM()
    {
      return this.MZ;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/Drive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */