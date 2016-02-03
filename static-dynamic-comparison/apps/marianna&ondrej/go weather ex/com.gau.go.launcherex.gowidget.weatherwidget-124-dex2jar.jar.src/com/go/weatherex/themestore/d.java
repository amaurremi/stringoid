package com.go.weatherex.themestore;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.jiubang.playsdk.adapter.c;
import java.util.List;

public abstract class d
  extends c
  implements View.OnClickListener
{
  protected ListView a = null;
  private final SparseIntArray e = new SparseIntArray();
  private int f = 2;
  private int g = 0;
  private int h = 0;
  
  public d(Context paramContext, List paramList, ListView paramListView)
  {
    super(paramContext, paramList);
    this.a = paramListView;
    this.a.setDividerHeight(0);
    int i = paramContext.getResources().getDimensionPixelSize(2131427897);
    int j = paramContext.getResources().getDimensionPixelSize(2131427898);
    a(i);
    b(j);
  }
  
  private void a(LinearLayout paramLinearLayout, View paramView, int paramInt)
  {
    paramLinearLayout.addView(paramView, paramInt, new LinearLayout.LayoutParams(0, -2, 1.0F));
  }
  
  public int a()
  {
    return this.f;
  }
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  protected void a(FrameLayout paramFrameLayout, LinearLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramFrameLayout.setPadding(this.g / 2, this.h / 2, this.g / 2, this.h / 2);
    paramLayoutParams.gravity = 16;
    if (paramInt1 == 0) {
      paramFrameLayout.setPadding(this.g / 2, 0, this.g / 2, this.h / 2);
    }
    if (paramInt1 == getCount() - 1) {
      paramFrameLayout.setPadding(this.g / 2, this.h / 2, this.g / 2, 0);
    }
    if (paramInt2 == 0) {
      paramFrameLayout.setPadding(0, this.h / 2, this.g / 2, this.h / 2);
    }
    if (paramInt2 == this.f - 1) {
      paramFrameLayout.setPadding(this.g / 2, this.h / 2, 0, this.h / 2);
    }
  }
  
  public void a(List paramList)
  {
    if (this.d != paramList)
    {
      if (this.d != null) {
        this.d.clear();
      }
      if ((paramList != null) && (this.d != null)) {
        this.d.addAll(paramList);
      }
    }
    notifyDataSetChanged();
  }
  
  public int b()
  {
    if (this.d == null) {
      return 0;
    }
    return this.d.size();
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public int getCount()
  {
    int k = b();
    int j = k / this.f;
    int i = j;
    if (k % this.f != 0) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.d == null) {
      return null;
    }
    return this.d.get(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
    {
      paramView = new LinearLayout(this.b);
      paramView.setOrientation(0);
      paramView.setMotionEventSplittingEnabled(false);
      paramView.setFocusable(true);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      i = 0;
      while (i < this.f)
      {
        a(paramView, new FrameLayout(this.b), i);
        i += 1;
      }
    }
    int k;
    FrameLayout localFrameLayout;
    for (paramViewGroup = paramView;; paramViewGroup = (LinearLayout)paramView)
    {
      k = b();
      i = 0;
      if (i >= this.f) {
        return paramView;
      }
      localFrameLayout = (FrameLayout)paramViewGroup.getChildAt(i);
      localFrameLayout.setVisibility(0);
      a(localFrameLayout, (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams(), paramInt, i);
      if (localFrameLayout.getChildCount() <= 1) {
        break;
      }
      throw new IllegalStateException("convertViewContainer can't has more than 1 child...");
    }
    int j = this.f * paramInt + i;
    View localView;
    if (j < k) {
      if (localFrameLayout.getChildCount() == 1)
      {
        localView = localFrameLayout.getChildAt(0);
        label200:
        localView = a(j, localView, localFrameLayout);
        if (localView != null) {
          break label237;
        }
        localFrameLayout.removeAllViews();
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localView = null;
      break label200;
      label237:
      localView.setOnClickListener(this);
      this.e.put(localView.hashCode(), j);
      if (localFrameLayout.getChildCount() == 1) {
        if (localView != localFrameLayout.getChildAt(0)) {}
      }
      for (j = 0;; j = 1)
      {
        if (j == 0) {
          break label304;
        }
        localFrameLayout.addView(localView);
        break;
        localFrameLayout.removeAllViews();
      }
      label304:
      continue;
      localFrameLayout.setVisibility(4);
    }
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int i = this.e.get(paramView.hashCode(), -1);
    if ((this.a != null) && (i != -1))
    {
      AdapterView.OnItemClickListener localOnItemClickListener = this.a.getOnItemClickListener();
      if (localOnItemClickListener != null) {
        localOnItemClickListener.onItemClick(this.a, paramView, i, getItemId(i));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */