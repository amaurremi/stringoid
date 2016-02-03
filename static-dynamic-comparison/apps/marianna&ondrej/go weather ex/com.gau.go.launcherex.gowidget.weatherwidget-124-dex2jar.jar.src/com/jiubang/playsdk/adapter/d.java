package com.jiubang.playsdk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.jiubang.playsdk.g;
import java.util.List;

public abstract class d
  extends c
  implements View.OnClickListener
{
  protected ListView a = null;
  protected int e = 0;
  protected int f = 0;
  private boolean g = true;
  private int h = 1;
  private int i = 0;
  private int j = 0;
  
  public d(Context paramContext, List paramList, ListView paramListView)
  {
    super(paramContext, paramList);
    this.a = paramListView;
    this.a.setDividerHeight(0);
  }
  
  public int a()
  {
    return this.d.size();
  }
  
  public abstract View a(int paramInt, View paramView);
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int getCount()
  {
    if ((!this.g) || (a() % this.h == 0)) {
      return a() / this.h;
    }
    return a() / this.h + 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k;
    int m;
    label83:
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = (LinearLayout)this.c.inflate(g.s, null);
      paramViewGroup.setPadding(this.e, 0, this.f, 0);
      k = 0;
      if (k < this.h)
      {
        n = this.h * paramInt + k;
        if (n >= this.d.size())
        {
          m = this.d.size() - 1;
          paramView = a(m, null);
          localObject = new LinearLayout.LayoutParams(0, -1, 1.0F);
          if (k != this.h - 1) {
            ((LinearLayout.LayoutParams)localObject).rightMargin = this.i;
          }
          ((LinearLayout.LayoutParams)localObject).bottomMargin = this.j;
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewGroup.addView(paramView);
          if (n >= this.d.size()) {
            break label196;
          }
          paramView.setVisibility(0);
        }
        for (;;)
        {
          paramView.setId(this.h * paramInt + k);
          paramView.setOnClickListener(this);
          k += 1;
          break;
          m = n;
          break label83;
          label196:
          paramView.setVisibility(4);
        }
      }
    }
    do
    {
      do
      {
        return paramViewGroup;
        paramViewGroup = paramView;
      } while (!(paramView instanceof LinearLayout));
      localObject = (LinearLayout)paramView;
      k = 0;
      paramViewGroup = paramView;
    } while (k >= this.h);
    int n = this.h * paramInt + k;
    if (n >= this.d.size())
    {
      m = this.d.size() - 1;
      label273:
      paramViewGroup = ((LinearLayout)localObject).getChildAt(k);
      a(m, paramViewGroup);
      if (n >= this.d.size()) {
        break label342;
      }
      paramViewGroup.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.setId(this.h * paramInt + k);
      paramViewGroup.setOnClickListener(this);
      k += 1;
      break;
      m = n;
      break label273;
      label342:
      paramViewGroup.setVisibility(4);
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (this.a != null)
    {
      AdapterView.OnItemClickListener localOnItemClickListener = this.a.getOnItemClickListener();
      if (localOnItemClickListener != null) {
        localOnItemClickListener.onItemClick(this.a, paramView, k, k);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */