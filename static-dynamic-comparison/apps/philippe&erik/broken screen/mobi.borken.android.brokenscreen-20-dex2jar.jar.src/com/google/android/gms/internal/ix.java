package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class ix
  extends hc<iz>
{
  private a UD;
  private final int mTheme;
  private Activity oe;
  private final String yN;
  
  public ix(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, int paramInt)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.yN = paramString;
    this.oe = paramActivity;
    this.mTheme = paramInt;
  }
  
  public void a(UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    iP();
    this.UD = new a(paramInt, this.oe);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
      if (!TextUtils.isEmpty(this.yN)) {
        localBundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.yN, "com.google"));
      }
      localBundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
      iO().a(this.UD, paramUserAddressRequest, localBundle);
      return;
    }
    catch (RemoteException paramUserAddressRequest)
    {
      Log.e("AddressClientImpl", "Exception requesting user address", paramUserAddressRequest);
      paramUserAddressRequest = new Bundle();
      paramUserAddressRequest.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
      this.UD.g(1, paramUserAddressRequest);
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.d(parame, 5077000, getContext().getPackageName());
  }
  
  protected iz an(IBinder paramIBinder)
  {
    return iz.a.ap(paramIBinder);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.identity.service.BIND";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.identity.intents.internal.IAddressService";
  }
  
  public void disconnect()
  {
    super.disconnect();
    if (this.UD != null)
    {
      a.a(this.UD, null);
      this.UD = null;
    }
  }
  
  protected iz iO()
  {
    return (iz)super.fo();
  }
  
  protected void iP()
  {
    super.ci();
  }
  
  public static final class a
    extends iy.a
  {
    private final int FT;
    private Activity oe;
    
    public a(int paramInt, Activity paramActivity)
    {
      this.FT = paramInt;
      this.oe = paramActivity;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.oe = paramActivity;
    }
    
    public void g(int paramInt, Bundle paramBundle)
    {
      Object localObject;
      if (paramInt == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramBundle);
        paramBundle = this.oe.createPendingResult(this.FT, (Intent)localObject, 1073741824);
        if (paramBundle != null) {}
      }
      for (;;)
      {
        return;
        try
        {
          paramBundle.send(1);
          return;
        }
        catch (PendingIntent.CanceledException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception settng pending result", paramBundle);
          return;
        }
        localObject = null;
        if (paramBundle != null) {
          localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        }
        paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
        if (paramBundle.hasResolution()) {
          try
          {
            paramBundle.startResolutionForResult(this.oe, this.FT);
            return;
          }
          catch (IntentSender.SendIntentException paramBundle)
          {
            Log.w("AddressClientImpl", "Exception starting pending intent", paramBundle);
            return;
          }
        }
        try
        {
          paramBundle = this.oe.createPendingResult(this.FT, new Intent(), 1073741824);
          if (paramBundle != null)
          {
            paramBundle.send(1);
            return;
          }
        }
        catch (PendingIntent.CanceledException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception setting pending result", paramBundle);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */