package com.pocket.o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ideashower.readitlater.views.CheckableTextView;
import com.ideashower.readitlater.views.p;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.pocket.widget.navigation.x;
import java.util.ArrayList;

public class a
  extends BaseAdapter
{
  private Context a;
  private ArrayList b;
  private LayoutInflater c;
  private boolean d;
  private x e;
  private int f = -1;
  
  public a(Context paramContext, ArrayList paramArrayList, boolean paramBoolean, x paramx)
  {
    this.a = paramContext;
    this.b = paramArrayList;
    this.d = paramBoolean;
    this.e = paramx;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      if (this.d) {
        paramViewGroup = this.c.inflate(2130903184, null);
      }
    }
    else
    {
      if (this.f != paramInt) {
        break label147;
      }
      ((CheckableTextView)paramViewGroup.findViewById(2131231142)).setChecked(true);
    }
    for (;;)
    {
      paramView = (String)getItem(paramInt);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131231142);
      localTextView.setText(paramView);
      if (this.d)
      {
        ((StyledIconButton)paramViewGroup.findViewById(2131231141)).setBackgroundResource(2130837589);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, new p(2130837594, this.a), null);
        paramViewGroup.findViewById(2131231141).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            a.a(a.this).a(paramView);
          }
        });
      }
      return paramViewGroup;
      paramViewGroup = this.c.inflate(2130903185, null);
      break;
      label147:
      ((CheckableTextView)paramViewGroup.findViewById(2131231142)).setChecked(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */