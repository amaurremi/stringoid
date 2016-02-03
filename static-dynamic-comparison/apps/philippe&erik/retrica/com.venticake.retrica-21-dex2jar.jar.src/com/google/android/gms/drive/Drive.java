package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.w;

public final class Drive
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  public static final DriveApi DriveApi = new p();
  public static final Scope HH;
  public static final Scope HI;
  public static final Api<Drive.b> HJ;
  public static final b HK = new t();
  public static final d HL = new w();
  public static final Scope SCOPE_APPFOLDER;
  public static final Scope SCOPE_FILE;
  public static final Api.c<r> yH = new Api.c();
  
  static
  {
    SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    HH = new Scope("https://www.googleapis.com/auth/drive");
    HI = new Scope("https://www.googleapis.com/auth/drive.apps");
    API = new Api(new Drive.a()
    {
      protected Bundle a(Api.ApiOptions.NoOptions paramAnonymousNoOptions)
      {
        return new Bundle();
      }
    }, yH, new Scope[0]);
    HJ = new Api(new Drive.a()
    {
      protected Bundle a(Drive.b paramAnonymousb)
      {
        if (paramAnonymousb == null) {
          return new Bundle();
        }
        return paramAnonymousb.gj();
      }
    }, yH, new Scope[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/Drive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */