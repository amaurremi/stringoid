package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public final class r
{
  private ScrollView a;
  private HorizontalScrollView b;
  private ViewGroup c;
  private LinearLayout d;
  private BaseAdapter e;
  private List<List<View>> f;
  private List<List<View>> g;
  private List<Integer> h;
  private int i;
  private DataSetObserver j = new DataSetObserver()
  {
    public void onChanged()
    {
      int j = r.a(r.this).getChildCount();
      int i = 0;
      Object localObject1;
      List localList;
      Object localObject2;
      while (i < j)
      {
        localObject1 = (List)r.c(r.this).get(((Integer)r.b(r.this).get(i)).intValue());
        localList = (List)r.d(r.this).get(((Integer)r.b(r.this).get(i)).intValue());
        localObject2 = r.a(r.this).getChildAt(i);
        ((List)localObject1).remove(localObject2);
        localList.add(localObject2);
        i += 1;
      }
      r.b(r.this).clear();
      r.a(r.this).removeAllViews();
      j = r.e(r.this).getCount();
      i = 0;
      if (i < j)
      {
        int k = r.e(r.this).getItemViewType(i);
        localList = (List)r.c(r.this).get(k);
        localObject2 = (List)r.d(r.this).get(k);
        r.b(r.this).add(Integer.valueOf(k));
        localObject1 = null;
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = (View)((List)localObject2).get(0);
          ((List)localObject2).remove(0);
        }
        localObject2 = r.e(r.this).getView(i, (View)localObject1, r.a(r.this));
        localList.add(localObject2);
        if (r.f(r.this) == 0) {}
        for (localObject1 = new LinearLayout.LayoutParams(-2, -1);; localObject1 = new LinearLayout.LayoutParams(-1, -2))
        {
          if (i < j - 1) {
            ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 1);
          }
          r.a(r.this).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
          i += 1;
          break;
        }
      }
      r.a(r.this).requestLayout();
    }
  };
  
  public r(Context paramContext, int paramInt)
  {
    this.d = new LinearLayout(paramContext);
    this.i = paramInt;
    this.d.setOrientation(paramInt);
    if (paramInt == 0) {}
    for (this.c = a(paramContext);; this.c = b(paramContext))
    {
      this.c.addView(this.d);
      this.f = new ArrayList();
      this.g = new ArrayList();
      this.h = new ArrayList();
      this.d.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          try
          {
            paramAnonymousView = ((Activity)r.a(r.this).getContext()).getCurrentFocus();
            if (paramAnonymousView != null) {
              ((InputMethodManager)r.a(r.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getApplicationWindowToken(), 0);
            }
            return false;
          }
          catch (Exception paramAnonymousView) {}
          return false;
        }
      });
      return;
    }
  }
  
  private HorizontalScrollView a(Context paramContext)
  {
    if (this.b == null)
    {
      this.b = new HorizontalScrollView(paramContext);
      this.b.setFillViewport(true);
    }
    return this.b;
  }
  
  private ScrollView b(Context paramContext)
  {
    if (this.a == null)
    {
      this.a = new ScrollView(paramContext);
      this.a.setFillViewport(true);
    }
    return this.a;
  }
  
  private Context d()
  {
    return this.d.getContext();
  }
  
  public ViewGroup a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.i)
    {
      this.i = paramInt;
      this.d.setOrientation(paramInt);
      this.c.removeView(this.d);
      if (paramInt != 0) {
        break label60;
      }
    }
    label60:
    for (this.c = a(d());; this.c = b(d()))
    {
      this.c.addView(this.d);
      return;
    }
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    if (this.e != null) {
      this.e.unregisterDataSetObserver(this.j);
    }
    this.e = paramBaseAdapter;
    this.e.registerDataSetObserver(this.j);
    this.d.removeAllViews();
    this.f.clear();
    this.g.clear();
    int k = 0;
    while (k < this.e.getViewTypeCount())
    {
      this.f.add(new ArrayList());
      this.g.add(new ArrayList());
      k += 1;
    }
    this.h.clear();
    this.e.notifyDataSetChanged();
  }
  
  public LinearLayout b()
  {
    return this.d;
  }
  
  public void c()
  {
    if ((this.c == this.a) && (this.a != null)) {
      this.a.fullScroll(130);
    }
    while ((this.c != this.b) || (this.b == null)) {
      return;
    }
    this.b.fullScroll(66);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */