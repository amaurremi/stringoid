package com.venticake.retrica.setting;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.amazon.inapp.purchasing.Item;
import com.amazon.inapp.purchasing.PurchasingManager;
import com.venticake.retrica.a.b;
import com.venticake.retrica.a.d;
import com.venticake.retrica.a.k;
import com.venticake.retrica.a.l;
import com.venticake.retrica.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PurchaseActivityForAmazon
  extends c
  implements k
{
  String o;
  Button p = null;
  boolean q = false;
  String r = null;
  private d s;
  private com.venticake.retrica.a.a t;
  private boolean u = true;
  private Handler v;
  private final String w = "PurchaseActivityForAmazon";
  
  private void a(boolean paramBoolean, String paramString)
  {
    a.a().f(paramBoolean);
    p();
  }
  
  private void q()
  {
    getWindow().setFlags(1024, 1024);
    setContentView(2130903067);
    f().a(2130837931);
    this.v = new Handler(Looper.getMainLooper());
    this.p = ((Button)findViewById(2131296396));
    this.p.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PurchaseActivityForAmazon.this.n();
      }
    });
  }
  
  private void r()
  {
    this.s = new d(this);
    this.t = new com.venticake.retrica.a.a(this, this.s);
    this.t.a(this);
    Log.i("PurchaseActivityForAmazon", "onCreate: registering AppPurchasingObserver");
    PurchasingManager.registerObserver(this.t);
    this.u = false;
  }
  
  public void a(String paramString1, String paramString2)
  {
    Log.i("PurchaseActivityForAmazon", "onPurchaseResponseAlreadyEntitled: for userId (" + paramString1 + ") sku (" + paramString2 + ")");
    a(true, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Log.i("PurchaseActivityForAmazon", "onPurchaseResponseSuccess: for userId (" + paramString1 + ") sku (" + paramString2 + ") purchaseToken (" + paramString3 + ")");
    a(true, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Log.i("PurchaseActivityForAmazon", "onGetUserIdResponseSuccessful: update display if userId (" + paramString + ") user changed from previous stored user (" + paramBoolean + ")");
    this.u = false;
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      Object localObject = this.s.a();
      Log.i("PurchaseActivityForAmazon", "onGetUserIdResponseSuccessful: (" + ((Set)localObject).size() + ") saved requestIds");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        b localb = this.s.j(str1);
        if (localb == null)
        {
          Log.i("PurchaseActivityForAmazon", "onGetUserIdResponseSuccessful: could NOT find purchaseData for requestId (" + str1 + "), skipping");
        }
        else if (this.s.g(str1))
        {
          Log.i("PurchaseActivityForAmazon", "onGetUserIdResponseSuccessful: have not received purchase response for requestId still in SENT status: requestId (" + str1 + "), skipping");
        }
        else
        {
          Log.d("PurchaseActivityForAmazon", "onGetUserIdResponseSuccessful: requestId (" + str1 + ") " + localb);
          String str2 = localb.e();
          String str3 = localb.f();
          if (!localb.h())
          {
            Log.i("PurchaseActivityForAmazon", "onGetUserIdResponseSuccess: requestId (" + str1 + ") userId (" + paramString + ") sku (" + str3 + ") purchaseToken (" + str2 + ") was NOT fulfilled, fulfilling purchase now");
            a(paramString, str3, str2);
            this.s.h(str2);
            this.s.f(str1);
          }
          else if (this.s.e(str3))
          {
            Log.i("PurchaseActivityForAmazon", "onGetUserIdResponseSuccess: should fulfill sku (" + str3 + ") is true, so fulfilling purchasing now");
            b(paramString, str3, str2);
          }
        }
      }
    }
  }
  
  public void a(Map<String, Item> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        p();
        return;
      }
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Item)((Map.Entry)localObject).getValue();
      this.o = ((Item)localObject).getPrice();
      Log.i("PurchaseActivityForAmazon", "onItemDataResponseSuccessful: sku (" + str + ") item (" + localObject + ")");
      if (l.a.a().equals(str)) {
        Log.i("PurchaseActivityForAmazon", "This is not revoked sku");
      }
    }
  }
  
  public void a(Set<String> paramSet)
  {
    Log.i("PurchaseActivityForAmazon", "onItemDataResponseSuccessfulWithUnavailableSkus: for (" + paramSet.size() + ") unavailableSkus");
  }
  
  public void a_(String paramString)
  {
    this.u = false;
    d("onGetUserIdResponseFailed for requestId (" + paramString + ")");
  }
  
  public void b(String paramString1, String paramString2)
  {
    d("onPurchaseResponseInvalidSKU: for userId (" + paramString1 + ") sku (" + paramString2 + ")");
    a(false, paramString2);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    Log.i("PurchaseActivityForAmazon", "onPurchaseUpdatesResponseSuccess: for userId (" + paramString1 + ") sku (" + paramString2 + ") purchaseToken (" + paramString3 + ")");
  }
  
  public void b_(String paramString)
  {
    d("onItemDataResponseFailed: for requestId (" + paramString + ")");
  }
  
  public void c(String paramString)
  {
    d("onPurchaseUpdatesResponseFailed: for requestId (" + paramString + ")");
  }
  
  public void c(String paramString1, String paramString2)
  {
    Log.i("PurchaseActivityForAmazon", "User canceled Buying Window, onPurchaseResponseFailed: for requestId (" + paramString1 + ") sku (" + paramString2 + ")");
    d(getResources().getString(2131165297));
  }
  
  protected void d(String paramString)
  {
    this.q = true;
    this.r = paramString;
    this.u = false;
    p();
    e(this.r);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Log.i("PurchaseActivityForAmazon", "onPurchaseUpdatesResponseSuccessRevokedSku: for userId (" + paramString1 + ") revokedSku (" + paramString2 + ")");
    if (!l.a.a().equals(paramString2)) {
      return;
    }
    Log.i("PurchaseActivityForAmazon", "onPurchaseUpdatesResponseSuccessRevokedSku: fulfilledCountDown for revokedSKU (" + paramString2 + ")");
    a(false, "");
    d(getResources().getString(2131165298));
  }
  
  protected void e(final String paramString)
  {
    this.v.post(new Runnable()
    {
      public void run()
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(jdField_this);
        localBuilder.setTitle("Error");
        localBuilder.setMessage(paramString);
        localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        localBuilder.show();
      }
    });
  }
  
  protected void i()
  {
    finish();
  }
  
  protected void n()
  {
    if (this.q) {}
    while (this.u) {
      return;
    }
    String str = PurchasingManager.initiatePurchaseRequest(a.c());
    b localb = this.s.i(str);
    Log.i("PurchaseActivityForAmazon", "onBuyAmazonClicked : requestId (" + str + ") requestState (" + localb.c() + ")");
  }
  
  protected boolean o()
  {
    return a.a().u();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("PurchaseActivityForAmazon", "onActivityResult(" + paramInt1 + "," + paramInt2 + "," + paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    q();
    r();
    p();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    i();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.i("PurchaseActivityForAmazon", "onResume: call initiateGetUserIdRequest");
    PurchasingManager.initiateGetUserIdRequest();
    Log.i("PurchaseActivityForAmazon", "onResume: call initiateItemDataRequest for skus: " + l.b());
    PurchasingManager.initiateItemDataRequest(l.b());
    if (o())
    {
      findViewById(2131296395).setVisibility(8);
      findViewById(2131296399).setVisibility(0);
    }
  }
  
  protected void p()
  {
    this.v.post(new Runnable()
    {
      public void run()
      {
        PurchaseActivityForAmazon.this.findViewById(2131296397).setVisibility(8);
        if (PurchaseActivityForAmazon.this.o())
        {
          PurchaseActivityForAmazon.this.findViewById(2131296395).setVisibility(8);
          PurchaseActivityForAmazon.this.findViewById(2131296399).setVisibility(0);
          return;
        }
        if (PurchaseActivityForAmazon.this.q)
        {
          PurchaseActivityForAmazon.this.p.setText(2131165287);
          PurchaseActivityForAmazon.this.findViewById(2131296395).setVisibility(0);
          PurchaseActivityForAmazon.this.findViewById(2131296399).setVisibility(8);
          return;
        }
        if (PurchaseActivityForAmazon.a(PurchaseActivityForAmazon.this))
        {
          PurchaseActivityForAmazon.this.p.setText(2131165286);
          PurchaseActivityForAmazon.this.findViewById(2131296395).setVisibility(0);
          PurchaseActivityForAmazon.this.findViewById(2131296399).setVisibility(8);
          return;
        }
        String str = PurchaseActivityForAmazon.this.getResources().getString(2131165291);
        if (PurchaseActivityForAmazon.this.o == null) {}
        for (;;)
        {
          PurchaseActivityForAmazon.this.p.setText(str);
          PurchaseActivityForAmazon.this.findViewById(2131296395).setVisibility(0);
          PurchaseActivityForAmazon.this.findViewById(2131296399).setVisibility(8);
          return;
          str = String.format("%s (%s)", new Object[] { str, PurchaseActivityForAmazon.this.o });
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/setting/PurchaseActivityForAmazon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */