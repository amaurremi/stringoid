package com.gtp.go.weather.coupon.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gtp.go.weather.sharephoto.photo.b;
import java.util.ArrayList;

class d
  implements View.OnClickListener, View.OnLongClickListener
{
  private View b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private CheckBox h;
  private ImageView i;
  private View j;
  private RelativeLayout k;
  private RelativeLayout l;
  private com.gtp.go.weather.coupon.b.a m;
  
  d(c paramc)
  {
    this.b = paramc.a.getLayoutInflater().inflate(2130903103, null);
    this.c = ((ImageView)this.b.findViewById(2131231225));
    this.d = ((TextView)this.b.findViewById(2131231226));
    this.e = ((TextView)this.b.findViewById(2131231229));
    this.f = ((TextView)this.b.findViewById(2131231232));
    this.g = ((LinearLayout)this.b.findViewById(2131231233));
    this.h = ((CheckBox)this.b.findViewById(2131231234));
    this.i = ((ImageView)this.b.findViewById(2131231235));
    this.k = ((RelativeLayout)this.b.findViewById(2131231227));
    this.l = ((RelativeLayout)this.b.findViewById(2131231230));
    this.j = this.b.findViewById(2131231224);
    this.b.setOnLongClickListener(this);
    this.g.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void a()
  {
    c();
    this.d.setText(this.m.d());
    b();
    this.f.setText(this.m.e());
    this.h.setChecked(this.m.a());
    this.m.f();
    if (com.gtp.go.weather.coupon.c.a.c(this.m.g())) {
      this.i.setVisibility(0);
    }
    while (CouponCollectActivity.b(this.a.a))
    {
      this.g.setVisibility(0);
      return;
      this.i.setVisibility(8);
    }
    this.g.setVisibility(8);
  }
  
  private void b()
  {
    switch (this.m.f())
    {
    default: 
      return;
    case 1: 
      this.k.setVisibility(0);
      this.l.setVisibility(8);
      this.e.setText(this.m.h());
      return;
    }
    this.k.setVisibility(8);
    this.l.setVisibility(0);
  }
  
  private void c()
  {
    Object localObject = this.m.j();
    String str = String.valueOf(this.m.b());
    this.c.setTag(str);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = CouponCollectActivity.d(this.a.a).a(this.a.a.getApplicationContext(), (String)localObject, str, "", new e(this));
      if (localObject != null) {
        this.c.setImageDrawable((Drawable)localObject);
      }
    }
    else
    {
      return;
    }
    this.c.setImageResource(2130838889);
  }
  
  void a(int paramInt)
  {
    this.m = ((com.gtp.go.weather.coupon.b.a)CouponCollectActivity.a(this.a.a).get(paramInt));
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.g)) {
      if (!this.h.isChecked())
      {
        bool = true;
        this.h.setChecked(bool);
        this.m.a(bool);
      }
    }
    while (!paramView.equals(this.j)) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    CouponCollectActivity.a(this.a.a, this.m);
  }
  
  public boolean onLongClick(View paramView)
  {
    CouponCollectActivity.e(this.a.a).setVisibility(0);
    CouponCollectActivity.a(this.a.a, true);
    this.m.a(true);
    CouponCollectActivity.f(this.a.a).notifyDataSetChanged();
    CouponCollectActivity.g(this.a.a).setVisibility(0);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */