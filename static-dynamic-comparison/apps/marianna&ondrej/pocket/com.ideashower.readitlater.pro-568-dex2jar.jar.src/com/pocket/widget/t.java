package com.pocket.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;

public class t
  extends RelativeLayout
  implements View.OnClickListener
{
  u a;
  TextView b;
  TextView c;
  View d;
  View e;
  View f;
  View g;
  private int h = 0;
  
  public t(Context paramContext, u paramu)
  {
    super(paramContext);
    a(paramContext);
    this.a = paramu;
  }
  
  private void a()
  {
    switch (this.h)
    {
    default: 
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      return;
    case 0: 
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    this.d.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  private void a(int paramInt)
  {
    if (j.c())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(j.a(getResources().getDimension(2131296388)), -1);
      localLayoutParams.addRule(13);
      this.f.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramInt == 2)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(new ViewGroup.LayoutParams(j.a(getResources().getDimension(2131296388)), -1));
      localLayoutParams.addRule(13);
      this.f.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localLayoutParams.addRule(13);
    this.f.setLayoutParams(localLayoutParams);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903151, this, true);
    this.f = findViewById(2131231067);
    this.b = ((TextView)findViewById(2131231068));
    this.b.setTypeface(i.a(i.a));
    this.b.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131231070));
    this.c.setTypeface(i.a(i.a));
    this.c.setOnClickListener(this);
    this.d = findViewById(2131231069);
    this.e = findViewById(2131231071);
    this.g = findViewById(2131231066);
    a();
    a(paramContext.getResources().getConfiguration().orientation);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.b.invalidate();
    this.c.invalidate();
    invalidate();
  }
  
  public int getStateSelected()
  {
    return this.h;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      if (paramView.getId() != 2131231068) {
        break label35;
      }
      this.a.a();
      this.h = 0;
      a();
    }
    label35:
    while (paramView.getId() != 2131231070) {
      return;
    }
    this.a.b();
    this.h = 1;
    a();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(paramConfiguration.orientation);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.b.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
  }
  
  public void setListener(u paramu)
  {
    this.a = paramu;
  }
  
  public void setStateSelected(int paramInt)
  {
    this.h = paramInt;
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */