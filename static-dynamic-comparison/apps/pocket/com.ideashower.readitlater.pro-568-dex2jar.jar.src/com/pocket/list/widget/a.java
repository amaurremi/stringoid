package com.pocket.list.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.a.c;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.GsfActivity;
import com.ideashower.readitlater.activity.bl;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.EmptyListLayout;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.list.adapter.data.ItemQuery;

public class a
  extends EmptyListLayout
{
  private View c;
  private com.pocket.list.adapter.a d;
  private boolean e = false;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.c == null)
    {
      this.c = LayoutInflater.from(getContext()).inflate(2130903103, null, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j.a(275.0F), -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, 2131230963);
      this.c.setLayoutParams(localLayoutParams);
      this.b.addView(this.c);
      a(2131230782, "see_apps");
      a(2131230953, "browsers");
    }
  }
  
  private void a(int paramInt, final String paramString)
  {
    RilButton localRilButton = (RilButton)this.c.findViewById(paramInt);
    localRilButton.setGravity(19);
    localRilButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramString.equals("see_apps"))
        {
          v.b(2);
          if (i.a(com.ideashower.readitlater.h.a.bE))
          {
            if (c.e())
            {
              GsfActivity.a(a.this.getContext(), 2);
              return;
            }
            bl.a((com.ideashower.readitlater.activity.a)a.this.getContext(), "getstarted", 0, paramString);
            return;
          }
          bl.a((com.ideashower.readitlater.activity.a)a.this.getContext(), "getstarted", 0, paramString);
          return;
        }
        v.a(2);
        bl.a((com.ideashower.readitlater.activity.a)a.this.getContext(), "getstarted", 2, paramString);
      }
    });
  }
  
  public void C()
  {
    this.e = false;
    super.C();
  }
  
  public void D()
  {
    this.e = false;
    super.D();
  }
  
  public void E()
  {
    this.e = true;
    super.E();
  }
  
  public void F()
  {
    this.e = false;
    super.F();
  }
  
  public void a(boolean paramBoolean, ErrorReport paramErrorReport)
  {
    this.e = false;
    super.a(paramBoolean, paramErrorReport);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    int i;
    if ((!paramBoolean3) && (!paramBoolean4) && (paramBoolean2) && (this.e) && (this.d.c().J()))
    {
      i = 1;
      if (i == 0) {
        break label77;
      }
      a();
      this.c.setVisibility(0);
      this.b.setVisibility(0);
    }
    label77:
    while (this.c == null)
    {
      return;
      i = 0;
      break;
    }
    this.c.setVisibility(8);
  }
  
  public void setItemAdapter(com.pocket.list.adapter.a parama)
  {
    this.d = parama;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */