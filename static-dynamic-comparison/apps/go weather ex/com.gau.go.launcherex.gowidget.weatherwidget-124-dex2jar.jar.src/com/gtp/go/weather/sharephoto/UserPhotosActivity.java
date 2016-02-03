package com.gtp.go.weather.sharephoto;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.globalview.s;
import com.gtp.go.weather.sharephoto.award.MyAwardsActivity;
import com.gtp.go.weather.sharephoto.award.k;
import com.gtp.go.weather.sharephoto.d.c;
import com.gtp.go.weather.sharephoto.photo.ad;
import com.gtp.go.weather.sharephoto.photo.aj;
import com.gtp.go.weather.sharephoto.view.UserPhotoItem;
import com.gtp.go.weather.sharephoto.view.e;
import com.gtp.go.weather.sharephoto.view.f;
import com.gtp.go.weather.sharephoto.view.g;
import com.gtp.go.weather.sharephoto.view.n;
import java.util.ArrayList;

public class UserPhotosActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, aj, f, n
{
  private ad a;
  private ViewGroup b;
  private g c;
  private ListView d;
  private View e;
  private View f;
  private View g;
  private com.gtp.go.weather.sharephoto.takephoto.aa h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  private View o;
  private TextView p;
  private boolean q;
  private int r;
  private ImageView s;
  private k t;
  private com.gtp.go.weather.sharephoto.award.r u;
  private ac v;
  private c w;
  private s x;
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.x == null) {
      this.x = new s(this);
    }
    this.x.setCancelable(paramBoolean);
    this.x.a(paramString);
    if (!this.x.isShowing()) {
      this.x.show();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.setVisibility(8);
      this.p.setVisibility(0);
      return;
    }
    this.o.setVisibility(0);
    this.p.setVisibility(8);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.i.setVisibility(8);
      this.l.setVisibility(0);
      if (paramBoolean2)
      {
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        return;
      }
      this.m.setVisibility(8);
      this.n.setVisibility(0);
      return;
    }
    this.i.setVisibility(0);
    this.l.setVisibility(8);
    if (paramBoolean2)
    {
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      return;
    }
    this.j.setVisibility(8);
    this.k.setVisibility(0);
  }
  
  private void b()
  {
    if (this.r > 1)
    {
      this.q = true;
      Toast.makeText(this, 2131166387, 0).show();
      if (this.c.a() != 1) {
        break label55;
      }
      a(true, true);
    }
    for (;;)
    {
      this.a.a(this.r - 1, this);
      return;
      label55:
      a(false, true);
    }
  }
  
  private void f()
  {
    if (this.x == null) {}
    while (!this.x.isShowing()) {
      return;
    }
    this.x.dismiss();
  }
  
  public void a()
  {
    int i1 = this.c.a();
    if (i1 == 0)
    {
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    }
    if (i1 == 1)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    this.r = paramInt;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.c.a(paramArrayList);
    }
    this.c.notifyDataSetChanged();
    f();
    paramInt = this.c.a();
    if (this.r == 1) {
      if (paramInt == 1) {
        a(true, false);
      }
    }
    for (;;)
    {
      this.q = false;
      return;
      a(false, false);
      continue;
      if (this.i.getVisibility() == 0)
      {
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
      }
      else if (this.l.getVisibility() == 0)
      {
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
      }
    }
  }
  
  public void a(long paramLong, View paramView, UserPhotoItem paramUserPhotoItem)
  {
    if (com.gau.go.launcherex.gowidget.weather.util.r.c(this))
    {
      a(getString(2131166388), false);
      this.a.b(paramLong, new ab(this, paramLong, paramView, paramUserPhotoItem));
      paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117, "delete_confirm");
      paramView.a(String.valueOf(paramLong));
      paramView.d("2");
      com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(paramView);
      return;
    }
    Toast.makeText(getApplicationContext(), 2131166392, 0).show();
  }
  
  public void a(long paramLong, boolean paramBoolean, UserPhotoItem paramUserPhotoItem)
  {
    if (paramBoolean)
    {
      e.a(this, this.b);
      return;
    }
    e.b(this, this.b);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.c.a(paramArrayList);
      this.c.notifyDataSetChanged();
      f();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.h.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.e)) {
      finish();
    }
    do
    {
      return;
      if (paramView.equals(this.g))
      {
        this.h.a();
        return;
      }
      if (paramView.equals(this.s))
      {
        startActivity(new Intent(this, MyAwardsActivity.class));
        this.s.postDelayed(new aa(this), 200L);
        return;
      }
    } while ((!paramView.equals(this.o)) && (!paramView.equals(this.p)));
    TermsAndPrivacyActivity.a(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this);
    getWindow().setBackgroundDrawable(null);
    this.b = ((ViewGroup)paramBundle.inflate(2130903044, null));
    setContentView(this.b);
    this.w = new c(this);
    this.e = findViewById(2131230796);
    this.e.setOnClickListener(this);
    this.s = ((ImageView)findViewById(2131230808));
    this.s.setOnClickListener(this);
    this.o = paramBundle.inflate(2130903259, null);
    this.o.setOnClickListener(this);
    this.p = ((TextView)findViewById(2131230813));
    this.p.setOnClickListener(this);
    this.p.getPaint().setFlags(8);
    ((TextView)this.o.findViewById(2131230813)).getPaint().setFlags(8);
    this.t = new k(getApplicationContext());
    this.u = new com.gtp.go.weather.sharephoto.award.r(this, this.t);
    this.v = new ac(this, null);
    this.t.a(this.v);
    this.f = findViewById(2131230810);
    this.g = findViewById(2131230811);
    this.g.setOnClickListener(this);
    this.l = findViewById(2131230812);
    this.m = this.l.findViewById(2131231820);
    this.n = this.l.findViewById(2131231821);
    this.c = new g(this);
    this.c.a(this);
    this.c.a(this);
    this.c.a(this.w);
    this.d = ((ListView)findViewById(2131230809));
    this.d.setCacheColorHint(0);
    this.d.setDivider(null);
    this.d.setSelector(new ColorDrawable(0));
    this.d.setEmptyView(this.f);
    this.i = paramBundle.inflate(2130903257, null);
    this.j = this.i.findViewById(2131231820);
    this.k = this.i.findViewById(2131231821);
    this.i.setVisibility(8);
    this.d.addFooterView(this.i);
    this.d.addFooterView(this.o);
    this.d.setAdapter(this.c);
    this.d.setOnScrollListener(new z(this));
    this.f.setVisibility(8);
    this.h = new com.gtp.go.weather.sharephoto.takephoto.aa(this);
    this.a = new ad(this);
    a(getString(2131166389), true);
    this.a.a(0, this);
    this.q = true;
    this.t.a(false);
    this.t.b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.u.a();
    this.t.b(this.v);
    this.t.a();
    this.c.b();
    com.gtp.go.weather.sharephoto.d.a.a();
    this.w.a();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.a.a(0, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.u.b();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.u.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/UserPhotosActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */