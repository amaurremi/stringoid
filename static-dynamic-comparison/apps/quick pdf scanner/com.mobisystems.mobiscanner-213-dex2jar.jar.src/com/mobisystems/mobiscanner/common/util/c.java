package com.mobisystems.mobiscanner.common.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.a.a.a.a;
import com.a.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class c
{
  boolean awQ = false;
  String awR = "IabHelper";
  boolean awS = false;
  boolean awT = false;
  boolean awU = false;
  boolean awV = false;
  String awW = "";
  a awX;
  ServiceConnection awY;
  int awZ;
  String axa;
  String axb = null;
  a axc;
  Context mContext;
  
  public c(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.axb = paramString;
    dt("IAB helper created.");
  }
  
  private void DT()
  {
    if (this.awT) {
      throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }
  }
  
  public static String gb(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= 64536)
    {
      int i = 64536 - paramInt;
      if ((i >= 0) && (i < arrayOfString2.length)) {
        return arrayOfString2[i];
      }
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length)) {
      return String.valueOf(paramInt) + ":Unknown";
    }
    return arrayOfString1[paramInt];
  }
  
  void DU()
  {
    dt("Ending async operation: " + this.awW);
    this.awW = "";
    this.awV = false;
  }
  
  int a(e parame, String paramString)
  {
    int k = 0;
    dt("Querying owned items, item type: " + paramString);
    dt("Package name: " + this.mContext.getPackageName());
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      dt("Calling getPurchases with continuation token: " + (String)localObject1);
      localObject1 = this.awX.a(3, this.mContext.getPackageName(), paramString, (String)localObject1);
      int j = n((Bundle)localObject1);
      dt("Owned items response: " + String.valueOf(j));
      if (j != 0) {
        dt("getPurchases() failed: " + gb(j));
      }
      do
      {
        return j;
        if ((!((Bundle)localObject1).containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_PURCHASE_DATA_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_DATA_SIGNATURE_LIST")))
        {
          du("Bundle returned from getPurchases() doesn't contain required fields.");
          return 64534;
        }
        ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList3 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        j = 0;
        if (j < localArrayList2.size())
        {
          String str1 = (String)localArrayList2.get(j);
          Object localObject2 = (String)localArrayList3.get(j);
          String str2 = (String)localArrayList1.get(j);
          if (i.b(this.axb, str1, (String)localObject2))
          {
            dt("Sku is owned: " + str2);
            localObject2 = new g(paramString, str1, (String)localObject2);
            if (TextUtils.isEmpty(((g)localObject2).wK()))
            {
              dv("BUG: empty/null token!");
              dt("Purchase data: " + str1);
            }
            parame.b((g)localObject2);
          }
          for (;;)
          {
            j += 1;
            break;
            dv("Purchase signature verification **FAILED**. Not adding item.");
            dt("   Purchase data: " + str1);
            dt("   Signature: " + (String)localObject2);
            i = 1;
          }
        }
        localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
        dt("Continuation token: " + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        j = k;
      } while (i == 0);
      return 64533;
    }
  }
  
  int a(String paramString, e parame, List<String> paramList)
  {
    dt("Querying SKU details.");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(parame.dx(paramString));
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!((ArrayList)localObject).contains(str)) {
          ((ArrayList)localObject).add(str);
        }
      }
    }
    if (((ArrayList)localObject).size() == 0)
    {
      dt("queryPrices: nothing to do because there are no SKUs.");
      return 0;
    }
    paramList = new Bundle();
    paramList.putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject);
    paramList = this.awX.a(3, this.mContext.getPackageName(), paramString, paramList);
    if (!paramList.containsKey("DETAILS_LIST"))
    {
      int i = n(paramList);
      if (i != 0)
      {
        dt("getSkuDetails() failed: " + gb(i));
        return i;
      }
      du("getSkuDetails() returned a bundle with neither an error nor a detail list.");
      return 64534;
    }
    paramList = paramList.getStringArrayList("DETAILS_LIST").iterator();
    while (paramList.hasNext())
    {
      localObject = new j(paramString, (String)paramList.next());
      dt("Got sku details: " + localObject);
      parame.a((j)localObject);
    }
    return 0;
  }
  
  public e a(boolean paramBoolean, List<String> paramList)
  {
    return a(paramBoolean, paramList, null);
  }
  
  public e a(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    DT();
    dr("queryInventory");
    int i;
    try
    {
      paramList2 = new e();
      i = a(paramList2, "inapp");
      if (i != 0) {
        throw new IabException(i, "Error refreshing inventory (querying owned items).");
      }
    }
    catch (RemoteException paramList1)
    {
      throw new IabException(64535, "Remote exception while refreshing inventory.", paramList1);
      if (paramBoolean)
      {
        i = a("inapp", paramList2, paramList1);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of items).");
        }
      }
    }
    catch (JSONException paramList1)
    {
      throw new IabException(64534, "Error parsing JSON response while refreshing inventory.", paramList1);
    }
    if (this.awU)
    {
      i = a(paramList2, "subs");
      if (i != 0) {
        throw new IabException(i, "Error refreshing inventory (querying owned subscriptions).");
      }
      if (paramBoolean)
      {
        i = a("subs", paramList2, paramList1);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of subscriptions).");
        }
      }
    }
    return paramList2;
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, a parama, String paramString2)
  {
    a(paramActivity, paramString1, "inapp", paramInt, parama, paramString2);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, a parama, String paramString3)
  {
    DT();
    dr("launchPurchaseFlow");
    ds("launchPurchaseFlow");
    if ((paramString2.equals("subs")) && (!this.awU))
    {
      paramActivity = new d(64527, "Subscriptions are not available.");
      DU();
      if (parama != null) {
        parama.onIabPurchaseFinished(paramActivity, null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          dt("Constructing buy intent for " + paramString1 + ", item type: " + paramString2);
          paramString3 = this.awX.a(3, this.mContext.getPackageName(), paramString1, paramString2, paramString3);
          int i = n(paramString3);
          if (i != 0)
          {
            du("Unable to buy item, Error response: " + gb(i));
            DU();
            paramActivity = new d(i, "Unable to buy item");
            if (parama == null) {
              continue;
            }
            parama.onIabPurchaseFinished(paramActivity, null);
          }
        }
        catch (IntentSender.SendIntentException paramActivity)
        {
          du("SendIntentException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          DU();
          paramActivity = new d(64532, "Failed to send intent.");
          if (parama != null)
          {
            parama.onIabPurchaseFinished(paramActivity, null);
            return;
            paramString3 = (PendingIntent)paramString3.getParcelable("BUY_INTENT");
            dt("Launching buy intent for " + paramString1 + ". Request code: " + paramInt);
            this.awZ = paramInt;
            this.axc = parama;
            this.axa = paramString2;
            paramActivity.startIntentSenderForResult(paramString3.getIntentSender(), paramInt, new Intent(), 0, 0, 0);
            return;
          }
        }
        catch (RemoteException paramActivity)
        {
          du("RemoteException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          DU();
          paramActivity = new d(64535, "Remote exception while starting purchase flow");
        }
      }
    } while (parama == null);
    parama.onIabPurchaseFinished(paramActivity, null);
  }
  
  public void a(final b paramb)
  {
    DT();
    if (this.awS) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    dt("Starting in-app billing setup.");
    this.awY = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (c.this.awT) {
          return;
        }
        c.this.dt("Billing service connected.");
        c.this.awX = a.a.a(paramAnonymousIBinder);
        paramAnonymousComponentName = c.this.mContext.getPackageName();
        try
        {
          c.this.dt("Checking for in-app billing 3 support.");
          i = c.this.awX.a(3, paramAnonymousComponentName, "inapp");
          if (i != 0)
          {
            if (paramb != null) {
              paramb.onIabSetupFinished(new d(i, "Error checking for billing v3 support."));
            }
            c.this.awU = false;
            return;
          }
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          if (paramb != null) {
            paramb.onIabSetupFinished(new d(64535, "RemoteException while setting up in-app billing."));
          }
          paramAnonymousComponentName.printStackTrace();
          return;
        }
        c.this.dt("In-app billing version 3 supported for " + paramAnonymousComponentName);
        int i = c.this.awX.a(3, paramAnonymousComponentName, "subs");
        if (i == 0)
        {
          c.this.dt("Subscriptions AVAILABLE.");
          c.this.awU = true;
        }
        for (;;)
        {
          c.this.awS = true;
          if (paramb == null) {
            break;
          }
          paramb.onIabSetupFinished(new d(0, "Setup successful."));
          return;
          c.this.dt("Subscriptions NOT AVAILABLE. Response: " + i);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        c.this.dt("Billing service disconnected.");
        c.this.awX = null;
      }
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    if (this.mContext.getPackageManager().queryIntentServices(localIntent, 0) != null) {
      if (!this.mContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()) {
        this.mContext.bindService(localIntent, this.awY, 1);
      }
    }
    while (paramb == null) {
      return;
    }
    paramb.onIabSetupFinished(new d(3, "Billing service unavailable on device."));
  }
  
  public void a(c paramc)
  {
    a(true, null, paramc);
  }
  
  public void a(final boolean paramBoolean, final List<String> paramList, final c paramc)
  {
    final Handler localHandler = new Handler();
    DT();
    dr("queryInventory");
    ds("refresh inventory");
    new Thread(new Runnable()
    {
      public void run()
      {
        final d locald1 = new d(0, "Inventory refresh successful.");
        final Object localObject = null;
        try
        {
          e locale = c.this.a(paramBoolean, paramList);
          localObject = locale;
        }
        catch (IabException localIabException)
        {
          for (;;)
          {
            d locald2 = localIabException.DS();
          }
        }
        c.this.DU();
        if ((!c.this.awT) && (paramc != null)) {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              c.2.this.axh.onQueryInventoryFinished(locald1, localObject);
            }
          });
        }
      }
    }).start();
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != this.awZ) {
      return false;
    }
    DT();
    dr("handleActivityResult");
    DU();
    if (paramIntent == null)
    {
      du("Null data in IAB activity result.");
      paramIntent = new d(64534, "Null data in IAB result");
      if (this.axc != null) {
        this.axc.onIabPurchaseFinished(paramIntent, null);
      }
      return true;
    }
    paramInt1 = c(paramIntent);
    Object localObject = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    String str1 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      dt("Successful resultcode from purchase activity.");
      dt("Purchase data: " + (String)localObject);
      dt("Data signature: " + str1);
      dt("Extras: " + paramIntent.getExtras());
      dt("Expected item type: " + this.axa);
      if ((localObject == null) || (str1 == null))
      {
        du("BUG: either purchaseData or dataSignature is null.");
        dt("Extras: " + paramIntent.getExtras().toString());
        paramIntent = new d(64528, "IAB returned null purchaseData or dataSignature");
        if (this.axc != null) {
          this.axc.onIabPurchaseFinished(paramIntent, null);
        }
        return true;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new g(this.axa, (String)localObject, str1);
        String str2 = paramIntent.DY();
        if (!i.b(this.axb, (String)localObject, str1))
        {
          du("Purchase signature verification FAILED for sku " + str2);
          localObject = new d(64533, "Signature verification failed for sku " + str2);
          if (this.axc == null) {
            break;
          }
          this.axc.onIabPurchaseFinished((d)localObject, paramIntent);
          break;
        }
        dt("Purchase signature successfully verified.");
        if (this.axc != null) {
          this.axc.onIabPurchaseFinished(new d(0, "Success"), paramIntent);
        }
        return true;
      }
      catch (JSONException paramIntent)
      {
        du("Failed to parse purchase data.");
        paramIntent.printStackTrace();
        paramIntent = new d(64534, "Failed to parse purchase data.");
        if (this.axc != null) {
          this.axc.onIabPurchaseFinished(paramIntent, null);
        }
        return true;
      }
      if (paramInt2 == -1)
      {
        dt("Result code was OK but in-app billing response was not OK: " + gb(paramInt1));
        if (this.axc != null)
        {
          paramIntent = new d(paramInt1, "Problem purchashing item.");
          this.axc.onIabPurchaseFinished(paramIntent, null);
        }
      }
      else if (paramInt2 == 0)
      {
        dt("Purchase canceled - Response: " + gb(paramInt1));
        paramIntent = new d(64531, "User canceled.");
        if (this.axc != null) {
          this.axc.onIabPurchaseFinished(paramIntent, null);
        }
      }
      else
      {
        du("Purchase failed. Result code: " + Integer.toString(paramInt2) + ". Response: " + gb(paramInt1));
        paramIntent = new d(64530, "Unknown purchase response.");
        if (this.axc != null) {
          this.axc.onIabPurchaseFinished(paramIntent, null);
        }
      }
    }
    return true;
  }
  
  int c(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      du("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    du("Unexpected type for intent response code.");
    du(paramIntent.getClass().getName());
    throw new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
  }
  
  void dr(String paramString)
  {
    if (!this.awS)
    {
      du("Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + paramString);
    }
  }
  
  void ds(String paramString)
  {
    if (this.awV) {
      throw new IllegalStateException("Can't start async operation (" + paramString + ") because another async operation(" + this.awW + ") is in progress.");
    }
    this.awW = paramString;
    this.awV = true;
    dt("Starting async operation: " + paramString);
  }
  
  void dt(String paramString)
  {
    if (this.awQ) {
      Log.d(this.awR, paramString);
    }
  }
  
  void du(String paramString)
  {
    Log.e(this.awR, "In-app billing error: " + paramString);
  }
  
  void dv(String paramString)
  {
    Log.w(this.awR, "In-app billing warning: " + paramString);
  }
  
  public void enableDebugLogging(boolean paramBoolean)
  {
    DT();
    this.awQ = paramBoolean;
  }
  
  int n(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      dt("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    du("Unexpected type for bundle response code.");
    du(paramBundle.getClass().getName());
    throw new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
  }
  
  public static abstract interface a
  {
    public abstract void onIabPurchaseFinished(d paramd, g paramg);
  }
  
  public static abstract interface b
  {
    public abstract void onIabSetupFinished(d paramd);
  }
  
  public static abstract interface c
  {
    public abstract void onQueryInventoryFinished(d paramd, e parame);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */