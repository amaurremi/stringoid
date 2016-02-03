package com.getjar.sdk.remote.implementation;

import android.app.PendingIntent;
import android.app.Service;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.OnAdAvailableListener;
import com.getjar.sdk.OnGetjarLicensesReceivedListener;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.data.LicenseEngine;
import com.getjar.sdk.data.cache.AdManager;
import com.getjar.sdk.internal.ConsumableProduct;
import com.getjar.sdk.internal.LicensableProduct;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.IntentsUtility;
import com.getjar.sdk.utilities.ManualResetEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RemoteServer
  extends IRemoteService.Stub
{
  private volatile CommContext _commContext = null;
  private final Object _commContextLock = new Object();
  private final Service _parentService;
  
  public RemoteServer(Service paramService)
  {
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer() [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
    this._parentService = paramService;
  }
  
  private void ensureValidCaller()
  {
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.ensureValidCaller() [PID:%1$d CallingPID:%2$d]", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Binder.getCallingPid()) });
    if (Process.myPid() == Binder.getCallingPid()) {
      throw new IllegalStateException("The server and client of AIDL process-to-process operations must be in different processes");
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.ensureValidCaller() [PackageName:%1$s]", new Object[] { this._parentService.getPackageName() });
    int k = 0;
    int i = Binder.getCallingUid();
    String[] arrayOfString = this._parentService.getPackageManager().getPackagesForUid(i);
    int m = arrayOfString.length;
    i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        String str = arrayOfString[i];
        if (this._parentService.getPackageName().equalsIgnoreCase(str))
        {
          Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.ensureValidCaller() [CallingPackageName:%1$s]", new Object[] { str });
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        throw new IllegalStateException("AIDL process-to-process operations are only supported within the same application (under the same package name)");
      }
      i += 1;
    }
  }
  
  private CommContext getCommContext()
  {
    if (this._commContext == null) {}
    synchronized (this._commContextLock)
    {
      if (this._commContext == null) {
        this._commContext = CommManager.createContext(this._parentService);
      }
      return this._commContext;
    }
  }
  
  public Bundle getInterstitialIntent(String paramString1, String paramString2)
    throws RemoteException
  {
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getInterstitialIntent() START", new Object[0]);
    Bundle localBundle = new Bundle();
    localBundle.putInt("getjar.response_code", 1);
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new IllegalArgumentException("'placementTag' cannot be null or empty");
      }
    }
    catch (Exception paramString1)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString1, "RemoteServer.getInterstitialIntent() failed", new Object[0]);
      return localBundle;
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
      }
    }
    finally
    {
      Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getInterstitialIntent() FINISHED", new Object[0]);
    }
    ensureValidCaller();
    paramString1 = IntentsUtility.getInterstitialIntent(this._parentService, paramString1, paramString2);
    localBundle.putParcelable("getjar.interstitial_intent", PendingIntent.getActivity(this._parentService, 179330591, paramString1, 268435456));
    localBundle.putInt("getjar.response_code", 0);
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getInterstitialIntent() FINISHED", new Object[0]);
    return localBundle;
  }
  
  public Bundle getLicense(final String paramString)
    throws RemoteException
  {
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getLicense() START", new Object[0]);
    final Bundle localBundle = new Bundle();
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("'productId' can not be NULL");
      }
    }
    catch (Exception paramString)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString, "RemoteServer.getLicense() failed", new Object[0]);
      return localBundle;
      ensureValidCaller();
      AuthManager.initialize(this._parentService);
      if (!AuthManager.getInstance().getClaimsManager(this._parentService).canUseUnmanagedLicenses()) {
        throw new IllegalStateException("The provided Application Token is not allowed to use Licensing features");
      }
    }
    finally
    {
      Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getLicense() FINISHED", new Object[0]);
    }
    final ManualResetEvent localManualResetEvent = new ManualResetEvent(false);
    LicenseEngine.getInstance().getLicenses(Arrays.asList(new String[] { paramString }), new OnGetjarLicensesReceivedListener()
    {
      public void onLicensesReceived(int paramAnonymousInt, List<GetjarLicense> paramAnonymousList)
      {
        if ((paramAnonymousInt == 0) && (paramAnonymousList != null)) {}
        try
        {
          if (paramAnonymousList.size() > 0)
          {
            paramAnonymousList = (GetjarLicense)paramAnonymousList.get(0);
            if ((paramAnonymousList != null) && (paramString.equalsIgnoreCase(paramAnonymousList.getItemId())))
            {
              localBundle.putInt("getjar.key_index", paramAnonymousList.getKeyIndex());
              localBundle.putString("getjar.signed_license_data", paramAnonymousList.getSignedLicenseData());
              localBundle.putString("getjar.license_signature", paramAnonymousList.getLicenseSignature());
              localBundle.putLong("getjar.last_server_sync_time", paramAnonymousList.getLastCheckedTime().getTime());
              localBundle.putLong("getjar.creation_time", paramAnonymousList.getCreationTime().getTime());
              localBundle.putLong("getjar.modification_time", paramAnonymousList.getModificationTime().getTime());
              Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getLicense() LicenseEngine.getInstance() onLicensesReceived() license added to result", new Object[0]);
            }
          }
          return;
        }
        catch (Exception paramAnonymousList)
        {
          Logger.d(Area.DEVELOPER_API.value(), paramAnonymousList, "RemoteServer.getLicense() LicenseEngine.getInstance() onLicensesReceived() failed", new Object[0]);
          return;
        }
        finally
        {
          localManualResetEvent.open();
        }
      }
    });
    localManualResetEvent.waitForOpen(120000L);
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getLicense() FINISHED", new Object[0]);
    return localBundle;
  }
  
  public Bundle getPurchaseIntent(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
    throws RemoteException
  {
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getPurchaseIntent() START", new Object[0]);
    Bundle localBundle = new Bundle();
    localBundle.putInt("getjar.response_code", 1);
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
      }
    }
    catch (Exception paramString1)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString1, "RemoteServer.getPurchaseIntent() failed", new Object[0]);
      return localBundle;
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("'productName' cannot be null or empty");
      }
    }
    finally
    {
      Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getPurchaseIntent() FINISHED", new Object[0]);
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("'productDesc' cannot be null or empty");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'amount' needs to be greater than or equal to zero");
    }
    GetjarLicense.Scope localScope = null;
    boolean bool = TextUtils.isEmpty(paramString4);
    if (!bool) {}
    for (;;)
    {
      try
      {
        localScope = GetjarLicense.Scope.valueOf(paramString4);
        ensureValidCaller();
        if (localScope == null)
        {
          paramString1 = new ConsumableProduct(paramString1, paramString2, paramString3, paramLong);
          paramString2 = new ArrayList(1);
          paramString2.add(paramString1);
          paramString1 = IntentsUtility.getPurchaseIntent(this._parentService, paramString2);
          localBundle.putParcelable("getjar.purchase_intent", PendingIntent.getActivity(this._parentService, 32103290, paramString1, 268435456));
          localBundle.putInt("getjar.response_code", 0);
          Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.getPurchaseIntent() FINISHED", new Object[0]);
          return localBundle;
        }
      }
      catch (Exception paramString1)
      {
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid 'licenseScope' value [%1$s]", new Object[] { paramString4 }));
      }
      paramString1 = new LicensableProduct(paramString1, paramString2, paramString3, paramLong, localScope);
    }
  }
  
  public Bundle prepareAd(String paramString)
    throws RemoteException
  {
    Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.prepareAd() START", new Object[0]);
    final Bundle localBundle = new Bundle();
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
      }
    }
    catch (Exception paramString)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString, "RemoteServer.prepareAd() failed", new Object[0]);
      return localBundle;
      ensureValidCaller();
      AdManager.initialize(getCommContext());
      final ManualResetEvent localManualResetEvent = new ManualResetEvent(false);
      AdManager.getInstance().fetchAds(paramString, new OnAdAvailableListener()
      {
        public void onAdAvailable(boolean paramAnonymousBoolean)
        {
          try
          {
            localBundle.putBoolean("getjar.is_ad_available", paramAnonymousBoolean);
            return;
          }
          catch (Exception localException)
          {
            Logger.d(Area.DEVELOPER_API.value(), localException, "RemoteServer.prepareAd() OnAdAvailableListener.onAdAvailable() failed", new Object[0]);
            return;
          }
          finally
          {
            localManualResetEvent.open();
          }
        }
      });
      localManualResetEvent.waitForOpen(120000L);
      return localBundle;
    }
    finally
    {
      Logger.d(Area.DEVELOPER_API.value(), "RemoteServer.prepareAd() FINISHED", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/remote/implementation/RemoteServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */