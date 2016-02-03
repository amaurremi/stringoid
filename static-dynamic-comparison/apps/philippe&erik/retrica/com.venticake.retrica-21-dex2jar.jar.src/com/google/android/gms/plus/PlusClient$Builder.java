package com.google.android.gms.plus;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.i;

@Deprecated
public class PlusClient$Builder
{
  private final i abA;
  private final GooglePlayServicesClient.ConnectionCallbacks aby;
  private final GooglePlayServicesClient.OnConnectionFailedListener abz;
  private final Context mContext;
  
  public PlusClient$Builder(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.mContext = paramContext;
    this.aby = paramConnectionCallbacks;
    this.abz = paramOnConnectionFailedListener;
    this.abA = new i(this.mContext);
  }
  
  public PlusClient build()
  {
    return new PlusClient(new e(this.mContext, this.aby, this.abz, this.abA.kj()));
  }
  
  public Builder clearScopes()
  {
    this.abA.ki();
    return this;
  }
  
  public Builder setAccountName(String paramString)
  {
    this.abA.bz(paramString);
    return this;
  }
  
  public Builder setActions(String... paramVarArgs)
  {
    this.abA.f(paramVarArgs);
    return this;
  }
  
  public Builder setScopes(String... paramVarArgs)
  {
    this.abA.e(paramVarArgs);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/PlusClient$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */