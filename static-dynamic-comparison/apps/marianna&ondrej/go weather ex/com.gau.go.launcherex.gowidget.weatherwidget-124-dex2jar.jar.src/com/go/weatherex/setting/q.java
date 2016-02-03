package com.go.weatherex.setting;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.d.f;

public class q
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener
{
  private TextView a;
  private View b;
  private View c;
  private TextView d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private boolean l = false;
  private ProgressDialog m;
  private boolean n;
  private SharedPreferences o;
  private h p;
  private final v q = new v(this, null);
  
  private void a(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    try
    {
      paramString.setPackage("com.android.vending");
      startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(getActivity().getApplicationContext(), 2131165767, 0).show();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(getActivity());
    localb.b(2131165363);
    localb.d(2131165364);
    localb.b(paramString1);
    localb.a(new s(this, paramString2));
    localb.b();
  }
  
  private void b(String paramString)
  {
    if (paramString.length() > 2) {}
    for (String str = paramString.substring(paramString.lastIndexOf("/") + 1);; str = paramString)
    {
      com.gau.go.launcherex.gowidget.download.b.a(getActivity(), str, paramString, 1L, getActivity().getPackageName());
      return;
    }
  }
  
  private void j()
  {
    if (g.a(getActivity()))
    {
      new u(this, null).execute(new String[0]);
      return;
    }
    n();
  }
  
  private void k()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", getString(2131165766));
    if (y.p(getActivity().getApplicationContext())) {}
    for (String str = "@GO天气EX " + getResources().getString(2131165769);; str = "@GO Weather EX " + getResources().getString(2131165769))
    {
      localIntent.putExtra("android.intent.extra.TEXT", str);
      try
      {
        startActivity(Intent.createChooser(localIntent, getString(2131165347)));
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Toast.makeText(getActivity().getApplicationContext(), 2131165348, 0).show();
      }
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://3g.cn"));
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(getActivity().getApplicationContext(), 2131165768, 0).show();
    }
  }
  
  private void m()
  {
    if (y.p(getActivity())) {}
    for (Object localObject = Uri.parse("http://weibo.com/u/3144676512");; localObject = Uri.parse("http://www.facebook.com/pages/GO-Weather-EX/488274257857852?ref=hl"))
    {
      localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
      try
      {
        startActivity((Intent)localObject);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Toast.makeText(getActivity().getApplicationContext(), 2131165768, 0).show();
      }
    }
  }
  
  private void n()
  {
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(getActivity());
    localb.b(2131165379);
    localb.d(2131165381);
    localb.c(2131165380);
    localb.a(new t(this));
    localb.b();
  }
  
  private void o()
  {
    if (GoWidgetApplication.b(getActivity().getApplicationContext()).b())
    {
      this.f.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.a, 4, true);
  }
  
  /* Error */
  public String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 81	com/go/weatherex/setting/q:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   4: invokevirtual 275	android/support/v4/app/FragmentActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: aload_0
    //   8: invokevirtual 81	com/go/weatherex/setting/q:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   11: invokevirtual 148	android/support/v4/app/FragmentActivity:getPackageName	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 281	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   18: getfield 287	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +12 -> 35
    //   26: aload_1
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 134	java/lang/String:length	()I
    //   32: ifgt +7 -> 39
    //   35: ldc_w 289
    //   38: astore_2
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: ldc_w 289
    //   45: astore_1
    //   46: aload_2
    //   47: invokevirtual 292	java/lang/Exception:printStackTrace	()V
    //   50: aload_1
    //   51: areturn
    //   52: astore_2
    //   53: goto -7 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	q
    //   21	30	1	str1	String
    //   27	13	2	str2	String
    //   41	6	2	localException1	Exception
    //   52	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	41	java/lang/Exception
    //   28	35	52	java/lang/Exception
  }
  
  public int d()
  {
    try
    {
      int i1 = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode;
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 1;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.p = new h();
    this.a = ((TextView)c(2131231145));
    this.a.setText(2131166106);
    this.b = c(2131231196);
    this.b.setOnClickListener(this);
    this.c = c(2131230773);
    this.c.setOnClickListener(this);
    this.d = ((TextView)c(2131230775));
    this.d.setText(c() + " " + getText(2131166290));
    this.e = c(2131230776);
    this.o = GoWidgetApplication.c(getActivity().getApplicationContext()).a();
    if (this.o.getBoolean("key_has_new_version", false)) {
      this.e.setVisibility(0);
    }
    this.f = c(2131231396);
    this.f.setOnClickListener(this);
    o();
    this.g = c(2131230777);
    this.g.setOnClickListener(this);
    this.h = c(2131230780);
    this.h.setOnClickListener(this);
    if (y.p(getActivity())) {
      ((TextView)c(2131230781)).setText(getString(2131166299));
    }
    this.i = c(2131230782);
    this.i.setOnClickListener(this);
    this.j = c(2131231397);
    if (this.o.getBoolean("key_about_rate_go_weather_ex_new", true)) {
      this.j.setVisibility(0);
    }
    this.k = c(2131230785);
    this.k.setOnClickListener(this);
    this.m = new ProgressDialog(getActivity());
    this.m.requestWindowFeature(1);
    this.m.setCancelable(true);
    this.m.setMessage(getString(2131165362));
    this.m.setOnCancelListener(new r(this));
    b();
  }
  
  public void onClick(View paramView)
  {
    if (this.p.a(hashCode())) {}
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        h();
        return;
      }
      if (paramView.equals(this.c))
      {
        j();
        return;
      }
      if (paramView.equals(this.i))
      {
        a("market://details?id=" + getActivity().getPackageName());
        paramView = this.o.edit();
        paramView.putBoolean("key_about_rate_go_weather_ex_new", false);
        paramView.commit();
        this.j.setVisibility(8);
        return;
      }
      if (paramView.equals(this.g))
      {
        k();
        return;
      }
      if (paramView.equals(this.k))
      {
        l();
        return;
      }
      if (paramView.equals(this.h))
      {
        m();
        return;
      }
    } while (!paramView.equals(this.f));
    a(com.go.weatherex.a.a.class, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903150, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.n = true;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b(this.q);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */