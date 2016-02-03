package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b;

public class bb
  extends b
{
  public View a = this.e.findViewById(2131230879);
  public View b = this.e.findViewById(2131230883);
  public View c = this.e.findViewById(2131230889);
  public View d = this.e.findViewById(2131230896);
  private View g = this.e.findViewById(2131230880);
  private View h = this.e.findViewById(2131230893);
  private View i = this.e.findViewById(2131230900);
  private TextView j = (TextView)this.e.findViewById(2131230881);
  private View k = this.e.findViewById(2131230882);
  private TextView l = (TextView)this.e.findViewById(2131230887);
  private View m = this.e.findViewById(2131230888);
  private View n = this.e.findViewById(2131230895);
  private ImageView o = (ImageView)this.e.findViewById(2131230894);
  private ImageView p = (ImageView)this.e.findViewById(2131230886);
  private ImageView q = (ImageView)this.e.findViewById(2131230892);
  private ImageView r = (ImageView)this.e.findViewById(2131230899);
  private ImageView s = (ImageView)this.e.findViewById(2131230884);
  private ImageView t = (ImageView)this.e.findViewById(2131230890);
  private ImageView u = (ImageView)this.e.findViewById(2131230897);
  private TextView v = (TextView)this.e.findViewById(2131230901);
  private View w = this.e.findViewById(2131230902);
  
  public bb(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.g.setVisibility(0);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      return;
    case 1: 
      this.g.setVisibility(8);
      this.h.setVisibility(0);
      this.i.setVisibility(8);
      return;
    }
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(0);
  }
  
  public void a() {}
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
    this.b.setOnClickListener(paramOnClickListener);
    this.c.setOnClickListener(paramOnClickListener);
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838955, 0);
      this.k.setVisibility(0);
      this.n.setVisibility(0);
      this.l.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838959, 0);
      this.m.setVisibility(0);
      this.o.setImageResource(2130838956);
      this.p.setVisibility(0);
      this.q.setVisibility(0);
      this.r.setVisibility(0);
      this.s.setVisibility(0);
      this.t.setVisibility(0);
      this.u.setVisibility(0);
      return;
    }
    this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838953, 0);
    this.k.setVisibility(8);
    this.n.setVisibility(8);
    this.l.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838958, 0);
    this.m.setVisibility(8);
    this.o.setImageResource(2130838954);
    this.p.setVisibility(8);
    this.q.setVisibility(8);
    this.r.setVisibility(8);
    this.s.setVisibility(0);
    this.t.setVisibility(0);
    this.u.setVisibility(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      c(2);
      if (paramBoolean2)
      {
        this.v.setText(2131166088);
        this.w.setVisibility(0);
        return;
      }
      this.v.setText(2131166089);
      this.w.setVisibility(8);
      return;
    }
    if (paramBoolean2)
    {
      c(1);
      return;
    }
    c(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */