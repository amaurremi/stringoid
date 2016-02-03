package com.gtp.go.weather.billing.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.goweather.goplay.n;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.OnIabPurchaseFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.OnIabSetupFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.QueryInventoryFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabResult;
import com.gau.go.launcherex.gowidget.googleplay.Inventory;
import com.gau.go.launcherex.gowidget.googleplay.Purchase;
import com.gtp.go.weather.billing.a.l;
import com.gtp.go.weather.sharephoto.award.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PayActivity
  extends Activity
  implements IabHelper.OnIabPurchaseFinishedListener, IabHelper.OnIabSetupFinishedListener, IabHelper.QueryInventoryFinishedListener
{
  private View a;
  private LinearLayout b;
  private View c;
  private TextView d;
  private TextView e;
  private IabHelper f;
  private ArrayList g;
  private HashMap h;
  private ArrayList i;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.a j;
  private boolean k = false;
  private boolean l = false;
  private ArrayList m;
  private Map n;
  private ConnectivityManager o;
  private String p = null;
  private boolean q = false;
  private com.gtp.go.weather.billing.a.a r;
  private String s = "";
  private boolean t = false;
  private boolean u = false;
  private com.gau.go.launcherex.gowidget.weather.globalview.y v;
  
  private View a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    case 4: 
    default: 
      return null;
    case 5: 
      localView = a(this, 2131166059, 2130838384, paramInt2);
      localView.setOnClickListener(new d(this));
      return localView;
    case 2: 
      localView = a(this, 2131166060, 2130838383, paramInt2);
      localView.setOnClickListener(new e(this));
      return localView;
    }
    View localView = a(this, 2131166061, 2130838382, paramInt2);
    localView.setOnClickListener(new f(this));
    return localView;
  }
  
  private View a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = getLayoutInflater().inflate(2130903250, null);
    TextView localTextView = (TextView)paramContext.findViewById(2131231695);
    localTextView.setText(paramInt1);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt2, 0, 0, 0);
    if (paramInt3 == 0) {
      paramContext.findViewById(2131231794).setVisibility(8);
    }
    return paramContext;
  }
  
  private View a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.a parama, int paramInt)
  {
    View localView = getLayoutInflater().inflate(2130903250, null);
    TextView localTextView = (TextView)localView.findViewById(2131231695);
    localTextView.setText(String.format(getString(2131166062), new Object[] { "$" + parama.b() }));
    localTextView.setCompoundDrawablesWithIntrinsicBounds(2130838381, 0, 0, 0);
    if (paramInt == 0) {
      localView.findViewById(2131231794).setVisibility(8);
    }
    localView.setOnClickListener(new b(this, parama));
    return localView;
  }
  
  private String a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.a parama)
  {
    if (parama != null)
    {
      float f2 = h() - parama.b();
      f1 = f2;
      if (f2 > 0.0F) {}
    }
    for (float f1 = i();; f1 = h())
    {
      parama = this.h.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!parama.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)parama.next();
      } while (f1 != ((Float)localEntry.getValue()).floatValue());
      return (String)localEntry.getKey();
    }
    return "";
  }
  
  private String a(String paramString)
  {
    Object localObject;
    if (!paramString.contains("%lang%"))
    {
      localObject = paramString;
      if (!paramString.contains("%region%")) {}
    }
    else
    {
      localObject = Locale.getDefault();
      localObject = paramString.replace("%lang%", ((Locale)localObject).getLanguage().toLowerCase(Locale.US)).replace("%region%", ((Locale)localObject).getCountry().toLowerCase(Locale.US));
    }
    return (String)localObject;
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.u) {
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getString(2131166041)).setIcon(17301642).setMessage(paramString).setPositiveButton(17039370, new g(this, paramBoolean2));
    if (paramBoolean1) {
      localBuilder.setNegativeButton(2131166042, new h(this, paramBoolean2));
    }
    localBuilder.create().show();
  }
  
  private void a(String[] paramArrayOfString)
  {
    this.b.removeAllViews();
    int i3;
    int i2;
    int i1;
    if (this.b.getChildCount() == 0)
    {
      int i4 = paramArrayOfString.length;
      i3 = 0;
      i2 = 0;
      if (i3 < i4)
      {
        Object localObject = paramArrayOfString[i3];
        try
        {
          int i5 = Integer.parseInt((String)localObject);
          localObject = a(i5, i2);
          i1 = i2;
          if (localObject != null)
          {
            this.b.addView((View)localObject);
            i1 = i2 + 1;
          }
          i2 = i1;
          if (5 == i5)
          {
            i2 = i1;
            if (this.i != null)
            {
              localObject = this.i.iterator();
              label146:
              for (;;)
              {
                if (!((Iterator)localObject).hasNext()) {
                  break label186;
                }
                View localView = a((com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)((Iterator)localObject).next(), i1);
                if (localView == null) {
                  break;
                }
                this.b.addView(localView);
                i1 += 1;
              }
            }
          }
          i3 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
    }
    for (;;)
    {
      break;
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      return;
      break label146;
      label186:
      i2 = i1;
    }
  }
  
  private void b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.a parama)
  {
    if (this.j != null)
    {
      parama = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID");
      parama.putExtra("extra_used_coupon_id", this.j.a());
      sendBroadcast(parama);
    }
  }
  
  private void c()
  {
    k localk = new k(this);
    localk.a(new a(this, localk));
    k.a(this, this.p);
  }
  
  private void d()
  {
    this.m = new ArrayList();
    this.n = l.a(this.p, getApplicationContext());
    String str;
    if ((this.n != null) && (this.n.size() > 0))
    {
      str = (String)this.n.get(com.gau.go.launcherex.gowidget.statistics.y.n(getApplicationContext()));
      localObject = str;
      if (str == null) {
        localObject = (String)this.n.get("others");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (((String)localObject).contains("#"))
        {
          localObject = ((String)localObject).split("#");
          int i2 = localObject.length;
          int i1 = 0;
          while (i1 < i2)
          {
            this.m.add(localObject[i1]);
            i1 += 1;
          }
        }
        this.m.add(localObject);
      }
    }
    Object localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      com.gtp.a.a.b.c.a("theme_pay", "readPayWays.payWay = " + str);
    }
    if (this.m.contains(String.valueOf(2))) {
      e();
    }
    if (this.m.contains(String.valueOf(5))) {
      g();
    }
    if (this.m.contains(String.valueOf(6))) {
      f();
    }
  }
  
  private void e()
  {
    this.r = new com.gtp.go.weather.billing.a.a(this);
  }
  
  private void f() {}
  
  private void g()
  {
    this.g = new ArrayList();
    this.h = new HashMap();
    Object localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.d(getApplicationContext(), this.p, "inapp_price_key");
    Object localObject2 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.e(getApplicationContext(), this.p, "inapp_price_value");
    int i1;
    float f1;
    if ((localObject1 != null) && (localObject2 != null) && (localObject1.length == localObject2.length))
    {
      i1 = 0;
      while (i1 < localObject2.length)
      {
        if ((!TextUtils.isEmpty(localObject1[i1])) && (localObject2[i1] > 0))
        {
          this.g.add(localObject1[i1]);
          f1 = Float.valueOf(localObject2[i1]).floatValue() / 100.0F;
          com.gtp.a.a.b.c.a("theme_pay", "priceKeys[i] " + localObject1[i1] + " | priceValue = " + f1);
          this.h.put(localObject1[i1], Float.valueOf(f1));
        }
        i1 += 1;
      }
    }
    localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject2 = ((Intent)localObject1).getStringArrayListExtra("extra_coupon_ids_arraylist");
      if (localObject2 != null)
      {
        this.i = new ArrayList();
        f1 = h();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          i1 = ((Intent)localObject1).getIntExtra(str, -1);
          if (i1 != -1)
          {
            com.gau.go.launcherex.gowidget.weather.globaltheme.b.a locala = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.a();
            locala.a(str);
            locala.b(i1);
            if (i1 < f1) {
              this.i.add(locala);
            }
          }
        }
      }
    }
    this.f = new IabHelper(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjMLLCo3hpiezV/bPOi83lz3DktmKGQpvsxjE10fF1h+L62vnazigqi+P6m4NFO+jOFT5RX0VPM9SzM6vCGOo9Xjjuk219queZr9SQUKoytfMTsgrtcI1YGDy9maP1owggij0hxWfaBsP4375zP+R89Pzz0R9Ap2tmLLlfIzRZPwqPcnONlQ/8ZqfdxWwCiOOOLHQJ4k1aN6jUPx8ipKWFxo7ORI0TmqgiJvhsFJuBr6QCqoN2BF6QgOfz6fMac1e+EaeJD3/pzUsuzzvvEnh70aoq+6mqZyZmyJb4840OddTGUHX8z3Qeoa/Dti+YQiXtSO3T2ANuF9pzkyBIAQQLwIDAQAB");
    this.f.enableDebugLogging(true);
  }
  
  private float h()
  {
    float f2;
    if (this.g != null)
    {
      Iterator localIterator = this.g.iterator();
      float f1 = -1.0F;
      f2 = f1;
      if (!localIterator.hasNext()) {
        break label78;
      }
      Object localObject = (String)localIterator.next();
      localObject = (Float)this.h.get(localObject);
      if (((Float)localObject).floatValue() <= f1) {
        break label80;
      }
      f1 = ((Float)localObject).floatValue();
    }
    label78:
    label80:
    for (;;)
    {
      break;
      f2 = -1.0F;
      return f2;
    }
  }
  
  private float i()
  {
    float f2;
    if (this.g != null)
    {
      Iterator localIterator = this.g.iterator();
      float f1 = Float.MAX_VALUE;
      f2 = f1;
      if (!localIterator.hasNext()) {
        break label78;
      }
      Object localObject = (String)localIterator.next();
      localObject = (Float)this.h.get(localObject);
      if (((Float)localObject).floatValue() >= f1) {
        break label80;
      }
      f1 = ((Float)localObject).floatValue();
    }
    label78:
    label80:
    for (;;)
    {
      break;
      f2 = Float.MAX_VALUE;
      return f2;
    }
  }
  
  private void j()
  {
    if ((this.m != null) && (this.m.size() > 0))
    {
      String[] arrayOfString = new String[this.m.size()];
      this.m.toArray(arrayOfString);
      int i2 = arrayOfString.length;
      int i1 = i2;
      if (this.i != null) {
        i1 = i2 + this.i.size();
      }
      if (i1 > 1)
      {
        this.e.setText(2131166027);
        a(arrayOfString);
      }
      for (;;)
      {
        return;
        if (arrayOfString.length == 1)
        {
          this.e.setText(2131166058);
          try
          {
            i1 = Integer.parseInt(arrayOfString[0]);
            switch (i1)
            {
            case 3: 
            case 4: 
            default: 
              return;
            case 2: 
              p();
              return;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              i1 = 5;
            }
            if (!this.k)
            {
              if (!this.l)
              {
                if ((!this.q) && (this.f != null))
                {
                  this.q = true;
                  this.f.startSetup(this);
                }
                this.l = true;
              }
            }
            else
            {
              q();
              return;
            }
          }
        }
      }
      o();
      return;
    }
    finish();
  }
  
  private void k()
  {
    this.c.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  private boolean l()
  {
    NetworkInfo localNetworkInfo = this.o.getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  private void m()
  {
    Toast.makeText(getApplicationContext(), 2131166063, 1).show();
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this.p, "com.gau.go.weatherex.framework.billing.PayActivity");
    localIntent.putExtra("theme_request_code", 1);
    try
    {
      startActivityForResult(localIntent, 363);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (!com.gtp.a.a.b.c.a()) {}
      localActivityNotFoundException.printStackTrace();
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this.p, "com.gau.go.weatherex.framework.billing.PayActivity");
    localIntent.putExtra("theme_request_code", 2);
    try
    {
      startActivityForResult(localIntent, 370);
      n.a(this).b(this.p, 0, 0.0F);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          localActivityNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  private void p()
  {
    if (this.r != null)
    {
      this.r.a(this.p);
      n.a(this).a(this.p, 0, 0.0F);
    }
  }
  
  private void q()
  {
    if (!com.gau.go.launcherex.gowidget.statistics.y.s(getApplicationContext())) {
      a(getString(2131166044), true, false);
    }
    while (this.l) {
      return;
    }
    this.f.queryInventoryAsync(true, this.g, this);
    this.l = true;
    n.a(this).c(this.p, 0, h());
  }
  
  public void a()
  {
    this.a.setVisibility(4);
    if (this.u) {}
    do
    {
      return;
      if (this.v == null)
      {
        this.v = new com.gau.go.launcherex.gowidget.weather.globalview.y(this);
        this.v.setCancelable(false);
        this.v.b(2131166037);
        this.v.c(2131166038);
        this.v.a(new c(this));
      }
    } while ((this.v.isShowing()) || (isFinishing()));
    this.v.show();
  }
  
  public void b()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntent.putExtra("extra_purchase_theme_package_name", this.p);
    sendBroadcast(localIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = -1;
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return;
      } while (this.r == null);
      this.r.a(paramInt1, paramInt2, paramIntent);
      return;
      this.f.logDebug("onActivityResult(" + paramInt1 + "," + paramInt2 + "," + paramIntent);
      if (!this.f.handleActivityResult(paramInt1, paramInt2, paramIntent))
      {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        finish();
        return;
      }
      this.f.logDebug("onActivityResult handled by IABUtil.");
      return;
      if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.k(this.p, getApplicationContext()))
      {
        a();
        b();
        return;
      }
      paramInt1 = i1;
      if (paramIntent != null) {
        paramInt1 = paramIntent.getIntExtra("theme_request_code", -1);
      }
    } while ((paramInt1 != 1) || (this.q) || (this.f == null));
    this.q = true;
    this.f.startSetup(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.u = false;
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.p = paramBundle.getStringExtra("extra_package_name");
      this.s = paramBundle.getStringExtra("theme_pay_type");
      this.t = paramBundle.getBooleanExtra("key_isApkAward", false);
      if (this.s == null) {
        this.s = "";
      }
    }
    if (!TextUtils.isEmpty(this.p))
    {
      this.o = ((ConnectivityManager)getSystemService("connectivity"));
      setContentView(2130903252);
      this.a = findViewById(2131231301);
      this.b = ((LinearLayout)findViewById(2131231202));
      this.c = findViewById(2131231795);
      this.d = ((TextView)findViewById(2131231796));
      this.e = ((TextView)findViewById(2131230797));
      if (this.t)
      {
        c();
        return;
      }
      d();
      j();
      return;
    }
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.u = true;
    this.q = false;
    if ((this.f != null) && (this.k))
    {
      this.f.dispose();
      this.k = false;
      this.f = null;
    }
    if (this.r != null)
    {
      this.r.c();
      this.r = null;
    }
  }
  
  public void onIabPurchaseFinished(IabResult paramIabResult, Purchase paramPurchase)
  {
    this.l = false;
    if (paramIabResult.isFailure())
    {
      this.f.logDebug("Error purchasing: " + paramIabResult);
      this.f.logDebug("purchase failture");
      finish();
    }
    while (!this.g.contains(paramPurchase.getSku())) {
      return;
    }
    this.f.logDebug("Success purchasing: " + paramIabResult);
    this.f.logDebug("purchase success");
    a();
    com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.p, true, getApplicationContext());
    b();
    b(this.j);
    paramIabResult = (Float)this.h.get(paramPurchase.getSku());
    if (paramIabResult != null) {}
    for (float f1 = paramIabResult.floatValue();; f1 = 0.0F)
    {
      n.a(this).c(this.p, 1, f1);
      return;
    }
  }
  
  public void onIabSetupFinished(IabResult paramIabResult)
  {
    if (!paramIabResult.isSuccess())
    {
      this.l = false;
      this.f.logDebug("Problem setting up In-app Billing: " + paramIabResult);
      a(getString(2131166043), true, true);
    }
    for (;;)
    {
      this.q = false;
      return;
      this.f.logDebug("IAB is fully set up!: " + paramIabResult);
      this.k = true;
      this.l = true;
      this.f.queryInventoryAsync(true, this.g, this);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.r != null) {
      this.r.a();
    }
  }
  
  public void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory)
  {
    if (paramIabResult.isFailure())
    {
      this.l = false;
      this.f.logDebug("onQueryInventoryFinished-->result.isFailure(");
      return;
    }
    paramIabResult = this.g.iterator();
    boolean bool1 = false;
    while (paramIabResult.hasNext())
    {
      boolean bool2 = paramInventory.hasPurchase((String)paramIabResult.next());
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    this.f.logDebug("onQueryInventoryFinished-->result isPremium：" + bool1);
    if (bool1)
    {
      this.l = false;
      a();
      com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.p, true, getApplicationContext());
      b();
      return;
    }
    paramIabResult = a(this.j);
    this.f.launchPurchaseFlow(this, paramIabResult, 101, this, null);
    this.l = true;
    n.a(this).c(this.p, 0, ((Float)this.h.get(paramIabResult)).floatValue());
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.r != null) {
      this.r.b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/view/PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */