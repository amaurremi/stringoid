package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.ideashower.readitlater.a.g;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;
import com.pocket.o.b;
import com.pocket.widget.navigation.u;
import com.pocket.widget.navigation.w;
import com.pocket.widget.navigation.x;
import java.util.ArrayList;

public class az
  extends f
{
  private w Y;
  
  private void Y()
  {
    this.Y.setTagSelectedListener(new x()
    {
      public void a(w paramAnonymousw) {}
      
      public void a(w paramAnonymousw, String paramAnonymousString, int paramAnonymousInt)
      {
        if ((!az.this.s()) || (com.pocket.p.k.a(az.this))) {
          return;
        }
        ItemQuery localItemQuery = com.pocket.list.adapter.data.k.a();
        localItemQuery.a().c(paramAnonymousString).a();
        paramAnonymousw = paramAnonymousString;
        if ("_untagged_".equals(paramAnonymousString)) {
          paramAnonymousw = g.a(2131493488);
        }
        paramAnonymousString = new Intent(az.this.m(), PocketActivity.class);
        paramAnonymousString.putExtra("extraQuery", localItemQuery);
        paramAnonymousString.putExtra("extraTitle", paramAnonymousw);
        az.this.a(paramAnonymousString);
      }
      
      public void a(String paramAnonymousString)
      {
        b.a(az.this.m(), paramAnonymousString);
      }
      
      public void a(String paramAnonymousString, ArrayList paramAnonymousArrayList)
      {
        b.a(az.this.m(), paramAnonymousString, paramAnonymousArrayList, null);
      }
    });
  }
  
  public String K()
  {
    return null;
  }
  
  public View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.Y = new w(m(), false, false);
    this.Y.getListView().setCacheColorHint(0);
    this.Y.setVerticalFadingEdgeEnabled(false);
    this.Y.getListView().setChoiceMode(0);
    ((u)this.Y.getListView().getDivider()).a(n().getDimensionPixelSize(2131296291), 0);
    return this.Y;
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    Y();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */