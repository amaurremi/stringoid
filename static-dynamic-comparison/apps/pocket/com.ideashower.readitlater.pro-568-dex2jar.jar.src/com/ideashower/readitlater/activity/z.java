package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.p;
import com.pocket.j.b;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;

public class z
  extends Fragment
  implements com.pocket.j.g
{
  private b a;
  private boolean b;
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = new b(m());
    this.a.setHighlightSelectedListener(this);
    return this.a;
  }
  
  public void a(b paramb) {}
  
  public void a(b paramb, com.ideashower.readitlater.e.g paramg, int paramInt)
  {
    if ((!s()) || (com.pocket.p.k.a(this))) {
      return;
    }
    paramb = com.pocket.list.adapter.data.k.a();
    paramb.a().b(paramg.a()).a();
    Intent localIntent = new Intent(m(), PocketActivity.class);
    localIntent.putExtra("extraQuery", paramb);
    localIntent.putExtra("extraTitle", paramg.b(m()));
    a(localIntent);
    new p(UiContext.b(paramg.a(), paramInt)).j();
  }
  
  public void b(b paramb) {}
  
  public void g()
  {
    super.g();
    if (this.b)
    {
      this.b = false;
      this.a.b();
    }
  }
  
  public void x()
  {
    super.x();
    this.b = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */