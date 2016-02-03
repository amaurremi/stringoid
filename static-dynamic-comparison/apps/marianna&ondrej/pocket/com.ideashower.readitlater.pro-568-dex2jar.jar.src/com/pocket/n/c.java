package com.pocket.n;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ideashower.readitlater.util.j;
import java.util.ArrayList;

public class c
  extends BaseAdapter
{
  ArrayList a = new ArrayList();
  Context b;
  LayoutInflater c;
  d d;
  
  public c(Context paramContext, ArrayList paramArrayList, d paramd)
  {
    this.b = paramContext;
    this.a = paramArrayList;
    this.d = paramd;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
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
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (g)this.a.get(paramInt);
    paramView = this.c.inflate(2130903175, null);
    paramViewGroup = (LinearLayout)paramView.findViewById(2131231131);
    if (j.e()) {
      paramViewGroup.setPadding(j.a(52.0F), 0, 0, 0);
    }
    ((TextView)paramView.findViewById(2131231132)).setText(((g)localObject).b());
    localObject = ((g)localObject).a();
    if (localObject != null)
    {
      localObject = ((e)localObject).a(this.b, null, f.c);
      if (localObject != null) {
        paramViewGroup.addView((View)localObject, 0);
      }
    }
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.this.d != null) {
          c.this.d.d(paramInt);
        }
      }
    });
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/n/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */