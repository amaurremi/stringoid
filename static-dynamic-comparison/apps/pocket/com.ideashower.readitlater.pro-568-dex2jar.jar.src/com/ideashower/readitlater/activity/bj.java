package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.o.b;
import com.pocket.o.e;
import com.pocket.p.k;
import com.pocket.p.l;
import com.pocket.widget.navigation.u;
import com.pocket.widget.navigation.w;
import com.pocket.widget.navigation.x;
import java.util.ArrayList;

public class bj
  extends f
{
  private Activity Y;
  private e Z;
  private w aa;
  
  public static l Y()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  public static bj Z()
  {
    return new bj();
  }
  
  public static void a(a parama, e parame)
  {
    bj localbj = Z();
    localbj.b(parama);
    localbj.a(parame);
    if (Y() == l.a)
    {
      k.a(localbj, parama);
      return;
    }
    k.a(localbj, parama, 2131230730, EditTagsActivity.z, false, true);
  }
  
  private void a(ToolbarLayout paramToolbarLayout)
  {
    paramToolbarLayout = (StyledToolbar)paramToolbarLayout.getTopToolbar();
    paramToolbarLayout.a(true, this);
    paramToolbarLayout.setTitle(2131492894);
  }
  
  private void a(e parame)
  {
    this.Z = parame;
  }
  
  public String K()
  {
    return null;
  }
  
  public void b(Activity paramActivity)
  {
    this.Y = paramActivity;
  }
  
  public View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.aa = new w(m(), true, false);
    this.aa.getListView().setCacheColorHint(0);
    this.aa.setVerticalFadingEdgeEnabled(false);
    this.aa.getListView().setChoiceMode(0);
    ((u)this.aa.getListView().getDivider()).a(n().getDimensionPixelSize(2131296291), 0);
    if (Y() == l.a)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2130903064, paramViewGroup, false);
      a((ToolbarLayout)paramLayoutInflater.findViewById(2131230729));
      ((RelativeLayout)paramLayoutInflater.findViewById(2131230730)).addView(this.aa);
      return paramLayoutInflater;
    }
    a((ToolbarLayout)this.Y.findViewById(2131230729));
    return this.aa;
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.aa.setTagSelectedListener(new x()
    {
      public void a(w paramAnonymousw) {}
      
      public void a(w paramAnonymousw, String paramAnonymousString, int paramAnonymousInt) {}
      
      public void a(String paramAnonymousString)
      {
        b.a(bj.this.m(), paramAnonymousString);
      }
      
      public void a(String paramAnonymousString, ArrayList paramAnonymousArrayList)
      {
        b.a(bj.this.m(), paramAnonymousString, paramAnonymousArrayList, bj.a(bj.this));
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */