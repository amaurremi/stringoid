package com.go.weatherex.managegood.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.gau.go.launcherex.gowidget.a.f;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.OnGetjarLicensesReceivedListener;
import com.getjar.sdk.OnGetjarVoucherRedeemedListener;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  private static final ExecutorService a = ;
  private Activity b;
  private GetjarClient c;
  private ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue e = new ConcurrentLinkedQueue();
  private volatile Intent f = null;
  private short g = 0;
  private volatile boolean h = false;
  private String i;
  private String j;
  private String k;
  private volatile boolean l = false;
  private volatile boolean m = false;
  private m n;
  private final com.gau.go.launcherex.gowidget.a.l o = new b(this);
  private final com.gau.go.launcherex.gowidget.a.i p = new c(this);
  private final OnGetjarLicensesReceivedListener q = new e(this);
  private final OnGetjarVoucherRedeemedListener r = new g(this);
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("getjar", false)))
    {
      paramIntent = new f(paramIntent);
      if (!this.d.contains(paramIntent)) {
        this.d.add(paramIntent);
      }
    }
    e();
  }
  
  private void a(String paramString)
  {
    this.b.runOnUiThread(new i(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.b.runOnUiThread(new k(this, paramString1, paramString2));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.n != null) {
      this.n.a(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  private void b()
  {
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "getjar->ensureConnected");
    if (this.f != null)
    {
      this.b.startActivityForResult(this.f, 1);
      return;
    }
    a();
  }
  
  private void b(String paramString)
  {
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "showPurchase()");
    try
    {
      paramString = this.c.getPurchaseIntent(paramString);
      this.b.startActivityForResult(paramString, 2);
      return;
    }
    catch (Exception paramString)
    {
      while (!com.gtp.a.a.b.c.a()) {}
      paramString.printStackTrace();
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if (this.n != null) {
      this.n.a(paramString1, paramString2, paramString3);
    }
  }
  
  private void c()
  {
    this.b.runOnUiThread(new j(this));
  }
  
  private void c(String paramString)
  {
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", paramString + "-> ThreadId: " + Thread.currentThread().getId());
  }
  
  private void d()
  {
    b(this.k, this.i, this.j);
    com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.k, true, this.b);
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntent.putExtra("extra_purchase_theme_package_name", this.k);
    this.b.sendBroadcast(localIntent);
  }
  
  private void e()
  {
    if (this.c.isConnected()) {
      a.execute(new l(this));
    }
  }
  
  public void a()
  {
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "getjar->startConnectGetjar");
    if (this.c.isConnected()) {}
    while (this.h) {
      return;
    }
    this.h = true;
    this.c.connect();
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "onActivityResult" + paramInt1 + ", " + paramInt2);
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a();
      return;
    }
    if (paramInt2 == -1)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: RESULT_OK");
      a(paramIntent);
      return;
    }
    if (paramInt2 == 0)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Purchase cancelled");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 8)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Bad merketplace country key");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 9)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Bad pricing buckets");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 10)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Already licensed");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 11)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Outstanding redeem");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 12)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Marketplace failure");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 13)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Network failure");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 14)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Insufficient funds");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    if (paramInt2 == 7)
    {
      com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: Error: Bad offer lookup key");
      this.m = false;
      a(this.k, this.i, this.j, paramInt2);
      return;
    }
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "REQUEST_CODE_PURCHASE: " + String.format(Locale.US, "Unknown result code [%1$d]", new Object[] { Integer.valueOf(paramInt2) }));
    this.m = false;
    a(this.k, this.i, this.j, paramInt2);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    c("onActivityCreated");
    this.b = paramActivity;
    paramActivity = com.gau.go.launcherex.gowidget.a.g.a(this.b);
    this.c = paramActivity.c();
    paramActivity.a(this.p);
    paramActivity.a(this.o);
    a(this.b.getIntent());
  }
  
  public void a(m paramm)
  {
    this.n = paramm;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "getjar->startLicensePurchase");
    if (this.m) {
      return;
    }
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString1;
    this.l = true;
    this.m = true;
    try
    {
      if (this.c.isConnected())
      {
        this.l = false;
        this.c.getLicense(this.i, this.q);
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (com.gtp.a.a.b.c.a())
      {
        paramString1.printStackTrace();
        com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "getjar->startLicensePurchase: " + paramString1);
      }
      a();
      return;
    }
    b();
  }
  
  public void b(Activity paramActivity) {}
  
  public void c(Activity paramActivity) {}
  
  public void d(Activity paramActivity) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */