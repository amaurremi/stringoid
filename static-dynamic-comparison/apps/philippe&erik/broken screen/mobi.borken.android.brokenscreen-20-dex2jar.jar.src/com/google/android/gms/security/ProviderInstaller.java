package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hn;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static Method adX = null;
  private static final Object qm = new Object();
  
  private static void I(Context paramContext)
    throws ClassNotFoundException, NoSuchMethodException
  {
    adX = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
  }
  
  public static void installIfNeeded(Context arg0)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    hn.b(???, "Context must not be null");
    GooglePlayServicesUtil.w(???);
    Context localContext = GooglePlayServicesUtil.getRemoteContext(???);
    if (localContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    synchronized (qm)
    {
      try
      {
        if (adX == null) {
          I(localContext);
        }
        adX.invoke(null, new Object[] { localContext });
        return;
      }
      catch (Exception localException)
      {
        Log.e("ProviderInstaller", "Failed to install provider: " + localException.getMessage());
        throw new GooglePlayServicesNotAvailableException(8);
      }
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, final ProviderInstallListener paramProviderInstallListener)
  {
    hn.b(paramContext, "Context must not be null");
    hn.b(paramProviderInstallListener, "Listener must not be null");
    hn.ay("Must be called on the UI thread");
    new AsyncTask()
    {
      protected Integer b(Void... paramAnonymousVarArgs)
      {
        try
        {
          ProviderInstaller.installIfNeeded(this.qr);
          return Integer.valueOf(0);
        }
        catch (GooglePlayServicesRepairableException paramAnonymousVarArgs)
        {
          return Integer.valueOf(paramAnonymousVarArgs.getConnectionStatusCode());
        }
        catch (GooglePlayServicesNotAvailableException paramAnonymousVarArgs) {}
        return Integer.valueOf(paramAnonymousVarArgs.errorCode);
      }
      
      protected void d(Integer paramAnonymousInteger)
      {
        if (paramAnonymousInteger.intValue() == 0)
        {
          paramProviderInstallListener.onProviderInstalled();
          return;
        }
        Intent localIntent = GooglePlayServicesUtil.Z(paramAnonymousInteger.intValue());
        paramProviderInstallListener.onProviderInstallFailed(paramAnonymousInteger.intValue(), localIntent);
      }
    }.execute(new Void[0]);
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/security/ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */