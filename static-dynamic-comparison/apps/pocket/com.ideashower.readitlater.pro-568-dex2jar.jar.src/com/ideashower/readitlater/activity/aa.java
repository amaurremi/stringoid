package com.ideashower.readitlater.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.a.a.a.a;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.views.EmptyListLayout;
import com.ideashower.readitlater.views.k;
import com.ideashower.readitlater.views.l;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.widget.r;

public class aa
  extends f
{
  private ListView Y;
  private r Z;
  private ab aa;
  
  public static aa Y()
  {
    return new aa();
  }
  
  public String K()
  {
    return "inbox";
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903052, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (paramBundle == null) {
      x.k();
    }
    paramBundle = (ToolbarLayout)c(2131230729);
    Object localObject = (StyledToolbar)paramBundle.getTopToolbar();
    if (!e()) {
      paramBundle.removeView((View)localObject);
    }
    for (;;)
    {
      this.Y = ((ListView)c(2131230754));
      paramBundle = (EmptyListLayout)c(2131230800);
      paramBundle.setEmptyStateHandler(new l()
      {
        public void a(k paramAnonymousk)
        {
          paramAnonymousk.a(g.a(2131493418), g.a(2131493412) + "<br><br>" + g.a(2131493415), null, 0, null);
        }
        
        public void a(k paramAnonymousk, boolean paramAnonymousBoolean, ErrorReport paramAnonymousErrorReport) {}
      });
      this.aa = new ab(this);
      this.Z = new r(this, paramBundle, this.Y, m(), this.aa);
      localObject = new a();
      ((a)localObject).a(this.aa);
      ((a)localObject).a(this.Z);
      this.Y.setAdapter((ListAdapter)localObject);
      this.Y.setCacheColorHint(0);
      this.Y.setVerticalFadingEdgeEnabled(false);
      this.Y.setDividerHeight(0);
      this.Y.setEmptyView(paramBundle);
      return;
      ((StyledToolbar)localObject).a(true, this);
    }
  }
  
  public void w()
  {
    super.w();
    this.Z.e();
  }
  
  public void y()
  {
    super.y();
    this.Z.f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */