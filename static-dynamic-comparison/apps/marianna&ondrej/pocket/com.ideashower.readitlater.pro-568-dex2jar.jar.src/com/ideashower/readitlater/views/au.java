package com.ideashower.readitlater.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class au
  extends BaseAdapter
{
  private final ArrayList b = new ArrayList();
  private final LayoutInflater c;
  
  public au(ThemedSpinner paramThemedSpinner)
  {
    this.c = LayoutInflater.from(paramThemedSpinner.getContext());
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i;
    if (paramView == null)
    {
      paramView = this.c;
      if (paramBoolean)
      {
        i = ThemedSpinner.b(this.a);
        paramView = paramView.inflate(i, paramViewGroup, false);
        paramViewGroup = new ax(this.a, paramView);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      paramViewGroup.a(a(paramInt), paramBoolean);
      return paramView;
      i = ThemedSpinner.c(this.a);
      break;
      paramViewGroup = (ax)paramView.getTag();
    }
  }
  
  public aw a(int paramInt)
  {
    return (aw)this.b.get(paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, true);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */