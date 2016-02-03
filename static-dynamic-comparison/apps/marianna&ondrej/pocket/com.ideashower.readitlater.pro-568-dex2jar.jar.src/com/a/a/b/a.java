package com.a.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class a
  extends BaseAdapter
{
  private List a = null;
  
  public a(List paramList)
  {
    this.a = paramList;
  }
  
  protected View a(int paramInt, ViewGroup paramViewGroup)
  {
    throw new RuntimeException("You must override newView()!");
  }
  
  public boolean a(View paramView)
  {
    return this.a.contains(paramView);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = (View)this.a.get(paramInt);
    paramView = localView;
    if (localView == null)
    {
      paramView = a(paramInt, paramViewGroup);
      this.a.set(paramInt, paramView);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return getCount();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */