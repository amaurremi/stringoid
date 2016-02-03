package com.gtp.go.weather.billing.a;

import android.app.Dialog;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.goplay.n;
import com.gau.go.launcherex.gowidget.a.j;
import com.gau.go.launcherex.gowidget.a.l;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.GetjarLicense.State;
import com.gtp.go.weather.billing.view.PayActivity;
import com.gtp.go.weather.sharephoto.d.m;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class a
{
  private PayActivity a;
  private LayoutInflater b;
  private String c;
  private com.gau.go.launcherex.gowidget.a.g d;
  private GetjarClient e;
  private Intent f = null;
  private ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
  private Dialog h;
  private k i;
  private int j = 75;
  private boolean k = false;
  private boolean l;
  private boolean m = false;
  private l n = new b(this);
  private com.gau.go.launcherex.gowidget.a.i o = new c(this);
  private com.gau.go.launcherex.gowidget.a.k p = new d(this);
  private j q = new f(this);
  
  public a(PayActivity paramPayActivity)
  {
    this.a = paramPayActivity;
    this.b = LayoutInflater.from(this.a);
    this.d = com.gau.go.launcherex.gowidget.a.g.a(this.a);
    this.e = this.d.c();
    this.d.a(this.a.getIntent());
    this.d.a(this.n);
    this.d.a(this.o);
    this.d.a(this.q);
    this.d.a(this.p);
  }
  
  private void a(int paramInt)
  {
    this.m = true;
    Intent localIntent = this.e.getPurchaseIntent(b(this.c), this.a.getString(2131165319), this.a.getString(2131166033), paramInt, GetjarLicense.Scope.USER);
    this.a.startActivityForResult(localIntent, 908);
    n.a(this.a).a(this.c, 0, paramInt, d());
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.i == null)
    {
      Object localObject = this.b.inflate(2130903251, null);
      this.i = new k(this, null);
      this.i.a = ((TextView)((View)localObject).findViewById(2131230797));
      this.i.b = ((TextView)((View)localObject).findViewById(2131231796));
      this.h = new Dialog(this.a, 2131492872);
      this.h.setContentView((View)localObject);
      localObject = this.h.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).height = -1;
      ((WindowManager.LayoutParams)localObject).width = -1;
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.i.a.setText(paramString1);
    }
    this.i.b.setText(paramString2);
    if ((!this.a.isFinishing()) && (!this.h.isShowing())) {
      this.h.show();
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("developer_product_id"))) {
      this.d.a();
    }
  }
  
  public static String b(String paramString)
  {
    return m.a(paramString);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      this.a.runOnUiThread(new g(this, paramString1, paramString2));
      return;
    }
    a(paramString1, paramString2);
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool3 = GetjarLicense.State.ACQUIRED.name().equals(paramJSONObject.getString("license_state"));
    paramJSONObject = paramJSONObject.getString("developer_product_id");
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      bool1 = bool2;
      if (paramJSONObject.equals(b(this.c)))
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private String d()
  {
    Account localAccount = this.d.c().getCurrentAccount();
    String str = "0";
    if (localAccount != null) {
      str = localAccount.getName();
    }
    return str;
  }
  
  private void e()
  {
    if ((this.h != null) && (this.h.isShowing()))
    {
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        break label45;
      }
      this.a.runOnUiThread(new h(this));
    }
    label45:
    while (this.a.isFinishing()) {
      return;
    }
    this.h.dismiss();
  }
  
  private void f()
  {
    this.l = false;
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      this.a.runOnUiThread(new i(this));
      return;
    }
    g();
  }
  
  private void g()
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.c, true, this.a))
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
      localIntent.putExtra("extra_purchase_theme_package_name", this.c);
      this.a.sendBroadcast(localIntent);
      this.a.a();
      if (this.m) {
        n.a(this.a).a(this.c, 1, this.j, d());
      }
    }
  }
  
  public void a()
  {
    if (this.e != null)
    {
      this.d.b(this.o);
      this.d.b(this.n);
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.l = true;
      this.c = paramString;
      b(null, this.a.getString(2131166055));
      this.e.connect();
      return;
    }
    throw new IllegalArgumentException("PackageName is empty!!!");
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 909: 
      if (paramInt2 == -1)
      {
        b(null, this.a.getString(2131166055));
        this.e.connect();
        return true;
      }
      this.a.finish();
      return true;
    }
    if (paramInt2 == -1)
    {
      this.d.a(paramIntent);
      return true;
    }
    this.a.finish();
    return true;
  }
  
  public void b()
  {
    if (this.e != null)
    {
      this.d.b(this.o);
      this.d.a(this.o);
      this.d.b(this.n);
      this.d.a(this.n);
    }
  }
  
  public void c()
  {
    this.d.b(this.o);
    this.d.b(this.n);
    this.d.b(this.p);
    this.d.b(this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */