package com.ideashower.readitlater.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.ideashower.readitlater.a.aj;
import com.ideashower.readitlater.e.z;
import com.pocket.c.e;
import java.util.ArrayList;

public class ab
  extends BaseAdapter
  implements View.OnClickListener
{
  private ArrayList b;
  
  public ab(aa paramaa) {}
  
  public z a(int paramInt)
  {
    if (this.b != null) {
      return (z)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(aj paramaj)
  {
    if ((paramaj.g != null) && (!paramaj.g.isEmpty()))
    {
      this.b = paramaj.g;
      notifyDataSetChanged();
    }
    while (this.b == null) {
      return;
    }
    this.b = null;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      ac localac = (ac)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localac;
    }
    for (;;)
    {
      ac.a(paramView, a(paramInt));
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.a.m()).inflate(2130903150, paramViewGroup, false);
      paramView = new ac(this.a, paramViewGroup, null);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = ac.a((ac)paramView.getTag());
    Toast.makeText(this.a.m(), 2131493748, 0).show();
    e.a(paramView, new com.ideashower.readitlater.d.f()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        android.support.v4.app.f localf = ab.this.a.m();
        if (paramAnonymousBoolean) {}
        for (int i = 2131493749;; i = 2131493747)
        {
          Toast.makeText(localf, i, 0).show();
          return;
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */