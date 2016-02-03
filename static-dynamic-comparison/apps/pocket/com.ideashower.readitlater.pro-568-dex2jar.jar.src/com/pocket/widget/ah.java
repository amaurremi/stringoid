package com.pocket.widget;

import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aa;
import android.view.View;
import android.view.ViewGroup;

public abstract class ah
  extends aa
{
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  public Object a(View paramView, int paramInt)
  {
    View localView = a(paramInt, (ViewGroup)paramView);
    ((ViewPager)paramView).addView(localView);
    return localView;
  }
  
  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
    b((View)paramObject, paramInt);
  }
  
  public boolean a(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
  
  public Parcelable b()
  {
    return null;
  }
  
  public void b(View paramView) {}
  
  public void b(View paramView, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */