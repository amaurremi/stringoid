package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;

public final class GoogleAuthApiClientImpl
  extends d<IGoogleAuthService>
{
  public static final String ACTION_START_SERVICE = "com.google.android.gms.auth.service.START";
  public static final String SERVICE_DESCRIPTOR = "com.google.android.gms.auth.api.IGoogleAuthService";
  private final String Dd;
  private String[] Ds;
  
  public GoogleAuthApiClientImpl(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Dd = paramString;
    this.Ds = paramArrayOfString;
  }
  
  public GoogleAuthApiClientImpl(Context paramContext, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    this(paramContext, paramContext.getMainLooper(), paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramArrayOfString);
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    paramk.b(parame, 6111000, getContext().getPackageName(), this.Dd, gR());
  }
  
  protected IGoogleAuthService createServiceInterface(IBinder paramIBinder)
  {
    return IGoogleAuthService.Stub.asInterface(paramIBinder);
  }
  
  public String getAccountName()
  {
    return this.Dd;
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.IGoogleAuthService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.auth.service.START";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */