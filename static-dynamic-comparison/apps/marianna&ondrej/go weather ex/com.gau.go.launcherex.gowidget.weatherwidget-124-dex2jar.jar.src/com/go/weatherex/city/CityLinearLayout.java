package com.go.weatherex.city;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class CityLinearLayout
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater a = LayoutInflater.from(getContext());
  private LinearLayout.LayoutParams b;
  private LinearLayout.LayoutParams c;
  private View d;
  private ArrayList e = new ArrayList();
  private SparseArray f = new SparseArray();
  private b g;
  private boolean h;
  
  public CityLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View a(View paramView)
  {
    View localView = new View(getContext());
    this.f.put(paramView.hashCode(), localView);
    return localView;
  }
  
  private View e()
  {
    return this.a.inflate(2130903098, null, false);
  }
  
  private LinearLayout.LayoutParams f()
  {
    Resources localResources = getResources();
    int i = Math.min(localResources.getDisplayMetrics().widthPixels, localResources.getDisplayMetrics().heightPixels);
    int j = localResources.getDimensionPixelOffset(2131427784);
    return new LinearLayout.LayoutParams((i - (localResources.getDimensionPixelOffset(2131427786) + j) * 2) / 3, -1);
  }
  
  private LinearLayout.LayoutParams g()
  {
    return new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(2131427786), -1);
  }
  
  private boolean h()
  {
    return d() > 9;
  }
  
  private a i()
  {
    int i = this.e.size();
    if (i == 0) {
      return null;
    }
    return (a)this.e.get(i - 1);
  }
  
  public void a(a parama)
  {
    int i = getChildCount();
    addView(parama, i - 1, this.b);
    parama.setOnClickListener(this);
    this.e.add(parama);
    parama = a(parama);
    addView(parama, i, this.c);
    if (h())
    {
      parama.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    parama.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  public void a(b paramb)
  {
    this.g = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      a locala = i();
      Object localObject = null;
      if (locala != null) {
        localObject = (View)this.f.get(locala.hashCode());
      }
      if (this.h)
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        this.d.setVisibility(8);
      }
      for (;;)
      {
        localObject = this.e.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a)((Iterator)localObject).next()).a(this.h);
        }
        if (!h())
        {
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          this.d.setVisibility(0);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public void b()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public void b(a parama)
  {
    if (parama != null)
    {
      this.e.remove(parama);
      removeView(parama);
      parama = (View)this.f.get(parama.hashCode());
      if (parama != null) {
        removeView(parama);
      }
      if ((!h()) && (!this.h)) {
        this.d.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.d.setVisibility(8);
  }
  
  public ArrayList c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public void onClick(View paramView)
  {
    if (this.g != null) {
      this.g.a(paramView);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = f();
    this.c = g();
    this.d = e();
    this.d.setOnClickListener(this);
    addView(this.d, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/city/CityLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */