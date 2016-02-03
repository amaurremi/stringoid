package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.z;

class ac
{
  private final TextView b;
  private String c;
  
  private ac(aa paramaa, View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131231063));
    paramView = paramView.findViewById(2131231064);
    paramView.setOnClickListener(aa.a(paramaa));
    paramView.setTag(this);
  }
  
  private void a(z paramz)
  {
    this.b.setText(g.c().getResources().getString(2131493797, new Object[] { paramz.b(), paramz.a() }));
    this.c = paramz.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */