package com.ideashower.readitlater.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ideashower.readitlater.util.z;
import com.pocket.q.a.n;
import com.pocket.q.a.o;
import java.util.ArrayList;
import java.util.Iterator;

public class i
  extends BaseAdapter
{
  private final ArrayList b = new ArrayList();
  
  public i(h paramh) {}
  
  private void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      z.d((View)localIterator.next());
    }
  }
  
  private boolean b(int paramInt)
  {
    paramInt += 1;
    if (paramInt >= getCount()) {}
    while (a(paramInt).d() == 0) {
      return true;
    }
    return false;
  }
  
  public n a(int paramInt)
  {
    return (n)h.a(this.a).get(paramInt);
  }
  
  public void a(n paramn)
  {
    h.a(this.a).remove(paramn);
    this.a.g(true);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return h.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return a(paramInt).d();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = a(paramInt);
    boolean bool;
    if (paramView == null)
    {
      paramView = paramViewGroup.a(this.a.m());
      paramView.setFrag(this.a);
      this.b.add(paramView);
      paramViewGroup.a(paramView);
      if (b(paramInt)) {
        break label96;
      }
      bool = true;
      label55:
      paramView.setBottomDividerEnabled(bool);
      if (!paramViewGroup.c()) {
        break label102;
      }
      paramView.setOnClickListener(paramViewGroup);
      paramView.setClickable(true);
    }
    for (;;)
    {
      paramView.setEnabled(paramViewGroup.b());
      return paramView;
      paramView = (o)paramView;
      break;
      label96:
      bool = false;
      break label55;
      label102:
      paramView.setOnClickListener(null);
      paramView.setClickable(false);
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return a(paramInt).b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */