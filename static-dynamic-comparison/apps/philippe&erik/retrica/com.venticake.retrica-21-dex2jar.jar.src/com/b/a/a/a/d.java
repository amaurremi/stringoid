package com.b.a.a.a;

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
import com.a.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class d
{
  boolean a = false;
  String b = "IabHelper";
  boolean c = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  String g = "";
  Context h;
  a i;
  ServiceConnection j;
  int k;
  String l;
  String m = null;
  e n;
  
  public d(Context paramContext, String paramString)
  {
    this.h = paramContext.getApplicationContext();
    this.m = paramString;
    c("IAB helper created.");
  }
  
  public static String a(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= 64536)
    {
      int i1 = 64536 - paramInt;
      if ((i1 >= 0) && (i1 < arrayOfString2.length)) {
        return arrayOfString2[i1];
      }
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length)) {
      return String.valueOf(paramInt) + ":Unknown";
    }
    return arrayOfString1[paramInt];
  }
  
  private void c()
  {
    if (this.d) {
      throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }
  }
  
  int a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      d("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    d("Unexpected type for intent response code.");
    d(paramIntent.getClass().getName());
    throw new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
  }
  
  int a(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      c("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    d("Unexpected type for bundle response code.");
    d(paramBundle.getClass().getName());
    throw new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
  }
  
  int a(i parami, String paramString)
  {
    int i3 = 0;
    c("Querying owned items, item type: " + paramString);
    c("Package name: " + this.h.getPackageName());
    Object localObject1 = null;
    int i1 = 0;
    label484:
    for (;;)
    {
      c("Calling getPurchases with continuation token: " + (String)localObject1);
      localObject1 = this.i.a(3, this.h.getPackageName(), paramString, (String)localObject1);
      int i2 = a((Bundle)localObject1);
      c("Owned items response: " + String.valueOf(i2));
      if (i2 != 0) {
        c("getPurchases() failed: " + a(i2));
      }
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      do
      {
        return i2;
        if ((!((Bundle)localObject1).containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_PURCHASE_DATA_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_DATA_SIGNATURE_LIST")))
        {
          d("Bundle returned from getPurchases() doesn't contain required fields.");
          return 64534;
        }
        localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        localArrayList3 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        i2 = 0;
        if (i2 < localArrayList2.size()) {
          break;
        }
        localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
        c("Continuation token: " + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label484;
        }
        i2 = i3;
      } while (i1 == 0);
      return 64533;
      String str1 = (String)localArrayList2.get(i2);
      Object localObject2 = (String)localArrayList3.get(i2);
      String str2 = (String)localArrayList1.get(i2);
      if (k.a(this.m, str1, (String)localObject2))
      {
        c("Sku is owned: " + str2);
        localObject2 = new j(paramString, str1, (String)localObject2);
        if (TextUtils.isEmpty(((j)localObject2).d()))
        {
          e("BUG: empty/null token!");
          c("Purchase data: " + str1);
        }
        parami.a((j)localObject2);
      }
      for (;;)
      {
        i2 += 1;
        break;
        e("Purchase signature verification **FAILED**. Not adding item.");
        c("   Purchase data: " + str1);
        c("   Signature: " + (String)localObject2);
        i1 = 1;
      }
    }
  }
  
  int a(String paramString, i parami, List<String> paramList)
  {
    c("Querying SKU details.");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(parami.d(paramString));
    if (paramList != null) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext())
      {
        if (((ArrayList)localObject).size() != 0) {
          break;
        }
        c("queryPrices: nothing to do because there are no SKUs.");
        return 0;
      }
      String str = (String)paramList.next();
      if (!((ArrayList)localObject).contains(str)) {
        ((ArrayList)localObject).add(str);
      }
    }
    paramList = new Bundle();
    paramList.putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject);
    paramList = this.i.a(3, this.h.getPackageName(), paramString, paramList);
    if (!paramList.containsKey("DETAILS_LIST"))
    {
      int i1 = a(paramList);
      if (i1 != 0)
      {
        c("getSkuDetails() failed: " + a(i1));
        return i1;
      }
      d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
      return 64534;
    }
    paramList = paramList.getStringArrayList("DETAILS_LIST").iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return 0;
      }
      localObject = new l(paramString, (String)paramList.next());
      c("Got sku details: " + localObject);
      parami.a((l)localObject);
    }
  }
  
  public i a(boolean paramBoolean, List<String> paramList)
  {
    return a(paramBoolean, paramList, null);
  }
  
  public i a(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    c();
    a("queryInventory");
    int i1;
    try
    {
      paramList2 = new i();
      i1 = a(paramList2, "inapp");
      if (i1 != 0) {
        throw new c(i1, "Error refreshing inventory (querying owned items).");
      }
    }
    catch (RemoteException paramList1)
    {
      throw new c(64535, "Remote exception while refreshing inventory.", paramList1);
      if (paramBoolean)
      {
        i1 = a("inapp", paramList2, paramList1);
        if (i1 != 0) {
          throw new c(i1, "Error refreshing inventory (querying prices of items).");
        }
      }
    }
    catch (JSONException paramList1)
    {
      throw new c(64534, "Error parsing JSON response while refreshing inventory.", paramList1);
    }
    if (this.e)
    {
      i1 = a(paramList2, "subs");
      if (i1 != 0) {
        throw new c(i1, "Error refreshing inventory (querying owned subscriptions).");
      }
      if (paramBoolean)
      {
        i1 = a("subs", paramList2, paramList1);
        if (i1 != 0) {
          throw new c(i1, "Error refreshing inventory (querying prices of subscriptions).");
        }
      }
    }
    return paramList2;
  }
  
  public void a()
  {
    c("Disposing.");
    this.c = false;
    if (this.j != null)
    {
      c("Unbinding from service.");
      if (this.h != null) {
        this.h.unbindService(this.j);
      }
    }
    this.d = true;
    this.h = null;
    this.j = null;
    this.i = null;
    this.n = null;
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt, e parame)
  {
    a(paramActivity, paramString, paramInt, parame, "");
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, e parame, String paramString2)
  {
    a(paramActivity, paramString1, "inapp", paramInt, parame, paramString2);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, e parame, String paramString3)
  {
    c();
    a("launchPurchaseFlow");
    b("launchPurchaseFlow");
    if ((paramString2.equals("subs")) && (!this.e))
    {
      paramActivity = new h(64527, "Subscriptions are not available.");
      b();
      if (parame != null) {
        parame.a(paramActivity, null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          c("Constructing buy intent for " + paramString1 + ", item type: " + paramString2);
          paramString3 = this.i.a(3, this.h.getPackageName(), paramString1, paramString2, paramString3);
          int i1 = a(paramString3);
          if (i1 != 0)
          {
            d("Unable to buy item, Error response: " + a(i1));
            b();
            paramActivity = new h(i1, "Unable to buy item");
            if (parame == null) {
              continue;
            }
            parame.a(paramActivity, null);
          }
        }
        catch (IntentSender.SendIntentException paramActivity)
        {
          d("SendIntentException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          b();
          paramActivity = new h(64532, "Failed to send intent.");
          if (parame != null)
          {
            parame.a(paramActivity, null);
            return;
            paramString3 = (PendingIntent)paramString3.getParcelable("BUY_INTENT");
            c("Launching buy intent for " + paramString1 + ". Request code: " + paramInt);
            this.k = paramInt;
            this.n = parame;
            this.l = paramString2;
            paramActivity.startIntentSenderForResult(paramString3.getIntentSender(), paramInt, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
            return;
          }
        }
        catch (RemoteException paramActivity)
        {
          d("RemoteException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          b();
          paramActivity = new h(64535, "Remote exception while starting purchase flow");
        }
      }
    } while (parame == null);
    parame.a(paramActivity, null);
  }
  
  public void a(final f paramf)
  {
    c();
    if (this.c) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    c("Starting in-app billing setup.");
    this.j = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (d.this.d) {
          return;
        }
        d.this.c("Billing service connected.");
        d.this.i = b.a(paramAnonymousIBinder);
        paramAnonymousComponentName = d.this.h.getPackageName();
        try
        {
          d.this.c("Checking for in-app billing 3 support.");
          i = d.this.i.a(3, paramAnonymousComponentName, "inapp");
          if (i != 0)
          {
            if (paramf != null) {
              paramf.a(new h(i, "Error checking for billing v3 support."));
            }
            d.this.e = false;
            return;
          }
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          if (paramf != null) {
            paramf.a(new h(64535, "RemoteException while setting up in-app billing."));
          }
          paramAnonymousComponentName.printStackTrace();
          return;
        }
        d.this.c("In-app billing version 3 supported for " + paramAnonymousComponentName);
        int i = d.this.i.a(3, paramAnonymousComponentName, "subs");
        if (i == 0)
        {
          d.this.c("Subscriptions AVAILABLE.");
          d.this.e = true;
        }
        for (;;)
        {
          d.this.c = true;
          if (paramf == null) {
            break;
          }
          paramf.a(new h(0, "Setup successful."));
          return;
          d.this.c("Subscriptions NOT AVAILABLE. Response: " + i);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        d.this.c("Billing service disconnected.");
        d.this.i = null;
      }
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    if (!this.h.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()) {
      this.h.bindService(localIntent, this.j, 1);
    }
    while (paramf == null) {
      return;
    }
    paramf.a(new h(3, "Billing service unavailable on device."));
  }
  
  void a(String paramString)
  {
    if (!this.c)
    {
      d("Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + paramString);
    }
  }
  
  public void a(final boolean paramBoolean, final List<String> paramList, final g paramg)
  {
    final Handler localHandler = new Handler();
    c();
    a("queryInventory");
    b("refresh inventory");
    new Thread(new Runnable()
    {
      public void run()
      {
        final h localh1 = new h(0, "Inventory refresh successful.");
        final Object localObject = null;
        try
        {
          i locali = d.this.a(paramBoolean, paramList);
          localObject = locali;
        }
        catch (c localc)
        {
          for (;;)
          {
            h localh2 = localc.a();
          }
        }
        d.this.b();
        if ((!d.this.d) && (paramg != null)) {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              this.b.a(localh1, localObject);
            }
          });
        }
      }
    }).start();
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != this.k) {
      return false;
    }
    c();
    a("handleActivityResult");
    b();
    if (paramIntent == null)
    {
      d("Null data in IAB activity result.");
      paramIntent = new h(64534, "Null data in IAB result");
      if (this.n != null) {
        this.n.a(paramIntent, null);
      }
      return true;
    }
    paramInt1 = a(paramIntent);
    Object localObject = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    String str1 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      c("Successful resultcode from purchase activity.");
      c("Purchase data: " + (String)localObject);
      c("Data signature: " + str1);
      c("Extras: " + paramIntent.getExtras());
      c("Expected item type: " + this.l);
      if ((localObject == null) || (str1 == null))
      {
        d("BUG: either purchaseData or dataSignature is null.");
        c("Extras: " + paramIntent.getExtras().toString());
        paramIntent = new h(64528, "IAB returned null purchaseData or dataSignature");
        if (this.n != null) {
          this.n.a(paramIntent, null);
        }
        return true;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new j(this.l, (String)localObject, str1);
        String str2 = paramIntent.b();
        if (!k.a(this.m, (String)localObject, str1))
        {
          d("Purchase signature verification FAILED for sku " + str2);
          localObject = new h(64533, "Signature verification failed for sku " + str2);
          if (this.n == null) {
            break;
          }
          this.n.a((h)localObject, paramIntent);
          break;
        }
        c("Purchase signature successfully verified.");
        if (this.n != null) {
          this.n.a(new h(0, "Success"), paramIntent);
        }
        return true;
      }
      catch (JSONException paramIntent)
      {
        d("Failed to parse purchase data.");
        paramIntent.printStackTrace();
        paramIntent = new h(64534, "Failed to parse purchase data.");
        if (this.n != null) {
          this.n.a(paramIntent, null);
        }
        return true;
      }
      if (paramInt2 == -1)
      {
        c("Result code was OK but in-app billing response was not OK: " + a(paramInt1));
        if (this.n != null)
        {
          paramIntent = new h(paramInt1, "Problem purchashing item.");
          this.n.a(paramIntent, null);
        }
      }
      else if (paramInt2 == 0)
      {
        c("Purchase canceled - Response: " + a(paramInt1));
        paramIntent = new h(64531, "User canceled.");
        if (this.n != null) {
          this.n.a(paramIntent, null);
        }
      }
      else
      {
        d("Purchase failed. Result code: " + Integer.toString(paramInt2) + ". Response: " + a(paramInt1));
        paramIntent = new h(64530, "Unknown purchase response.");
        if (this.n != null) {
          this.n.a(paramIntent, null);
        }
      }
    }
    return true;
  }
  
  void b()
  {
    c("Ending async operation: " + this.g);
    this.g = "";
    this.f = false;
  }
  
  void b(String paramString)
  {
    if (this.f) {
      throw new IllegalStateException("Can't start async operation (" + paramString + ") because another async operation(" + this.g + ") is in progress.");
    }
    this.g = paramString;
    this.f = true;
    c("Starting async operation: " + paramString);
  }
  
  void c(String paramString)
  {
    if (this.a) {
      Log.d(this.b, paramString);
    }
  }
  
  void d(String paramString)
  {
    Log.e(this.b, "In-app billing error: " + paramString);
  }
  
  void e(String paramString)
  {
    Log.w(this.b, "In-app billing warning: " + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/b/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */