package com.jiubang.playsdk.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.detail.a.l;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g.a;
import com.jiubang.playsdk.g.j;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.i;
import com.jiubang.playsdk.views.HorizontalListView;

public class ThemeLocalDetailView
  extends FrameLayout
  implements i
{
  private HorizontalListView a;
  private ListView b;
  private HorizontalListView c;
  private TextView d;
  private View e;
  private int f;
  private View g;
  private TextView h;
  private LinearLayout i;
  private ScrollView j;
  private FrameLayout k;
  private Handler l = new m(this);
  
  public ThemeLocalDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      this.k.removeAllViews();
      a.a(paramView);
      this.k.addView(paramView);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k != null)
    {
      if (!paramBoolean) {
        break label32;
      }
      if (this.k.getVisibility() == 8) {
        this.k.setVisibility(0);
      }
    }
    label32:
    while (this.k.getVisibility() != 0) {
      return;
    }
    this.k.setVisibility(8);
  }
  
  private int d()
  {
    int m = getContext().getResources().getDimensionPixelSize(d.t);
    int n = getContext().getResources().getDimensionPixelSize(d.w);
    return (j.c - m * 2 - n * 2) / 3;
  }
  
  public void a()
  {
    this.h.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.i.setOnClickListener(paramOnClickListener);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ListAdapter localListAdapter = this.c.a();
    if ((localListAdapter instanceof l)) {
      ((l)localListAdapter).a(paramOnItemClickListener);
    }
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.a.a(paramBaseAdapter);
    this.a.getLayoutParams().height = ((int)(this.f * 1.65D));
  }
  
  public void b()
  {
    this.e.setVisibility(8);
  }
  
  public void b(int paramInt)
  {
    this.h.setVisibility(0);
    this.h.setText(paramInt);
  }
  
  public void b(BaseAdapter paramBaseAdapter)
  {
    this.b = ((ListView)((ViewStub)findViewById(f.J)).inflate());
    this.b.setAdapter(paramBaseAdapter);
    this.b.setEmptyView(this.g);
    this.b.getLayoutParams().height = ((int)(this.f * 1.65D));
  }
  
  public void c()
  {
    if (this.k != null) {
      this.k.removeAllViews();
    }
  }
  
  public void c(int paramInt)
  {
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, j.a(22.0F), j.a(21.0F));
    this.h.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void c(BaseAdapter paramBaseAdapter)
  {
    this.c = ((HorizontalListView)((ViewStub)findViewById(f.I)).inflate());
    this.c.a(paramBaseAdapter);
    this.c.getLayoutParams().height = ((int)(this.f * 1.65D));
    this.c.setEmptyView(this.g);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.j = ((ScrollView)findViewById(f.W));
    this.j.setOnTouchListener(new n(this));
    this.a = ((HorizontalListView)this.j.findViewById(f.ay));
    this.d = ((TextView)this.j.findViewById(f.m));
    this.e = this.j.findViewById(f.U);
    this.g = findViewById(f.B);
    this.f = d();
    this.h = ((TextView)this.j.findViewById(f.K));
    this.i = ((LinearLayout)this.j.findViewById(f.n));
    this.k = ((FrameLayout)findViewById(f.V));
    a(aa.a().b().c(getContext(), this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/ThemeLocalDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */