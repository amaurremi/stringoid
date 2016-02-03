package com.ideashower.readitlater.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.pocket.widget.BorderedRelativeLayout;
import java.util.ArrayList;

class ai
  extends BaseAdapter
{
  private final ArrayList b;
  private final ArrayList c;
  private boolean d = false;
  
  private ai(ad paramad, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.b = paramArrayList1;
    this.c = paramArrayList2;
  }
  
  public al a(int paramInt)
  {
    int i = this.b.size();
    if (paramInt < i) {
      return (al)this.b.get(paramInt);
    }
    return (al)this.c.get(paramInt - i);
  }
  
  public void a()
  {
    this.d = true;
  }
  
  public int getCount()
  {
    if (this.d) {
      return this.b.size() + this.c.size();
    }
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      aj localaj = (aj)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localaj;
    }
    for (;;)
    {
      aj.a(paramView, a(paramInt), paramInt);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2130903105, null, false);
      paramView = new aj(this.a, (BorderedRelativeLayout)paramViewGroup, null);
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */