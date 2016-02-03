package com.pocket.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.i.a.p;

public class ar
{
  private aq a;
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramContext, paramViewGroup, paramInt1, paramInt2, paramInt3, 0, null);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903189, paramViewGroup, false);
    if (paramInt1 == 0)
    {
      paramContext.findViewById(2131230768).setVisibility(8);
      paramContext.findViewById(2131230769).setVisibility(8);
      ((TextView)paramContext.findViewById(2131230793)).setText(paramInt2);
      if (paramInt4 != 0) {
        break label98;
      }
      paramContext.findViewById(2131230774).setVisibility(8);
    }
    for (;;)
    {
      z.a(paramContext, new p(paramInt3));
      return paramContext;
      ((TextView)paramContext.findViewById(2131230768)).setText(paramInt1);
      break;
      label98:
      paramViewGroup = (RilButton)paramContext.findViewById(2131230774);
      paramViewGroup.setText(paramInt4);
      paramViewGroup.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */