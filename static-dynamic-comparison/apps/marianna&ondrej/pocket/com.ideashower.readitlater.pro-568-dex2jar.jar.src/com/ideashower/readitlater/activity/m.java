package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.f;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.m.a.a.c;
import com.pocket.m.a.g;
import com.pocket.p.l;
import com.pocket.q.a.p;
import com.pocket.q.a.t;
import java.util.ArrayList;

public class m
  extends h
{
  private boolean ag;
  
  public static void a(f paramf)
  {
    if (ab() == l.a)
    {
      com.pocket.p.k.a(ac(), paramf);
      return;
    }
    CacheSettingsActivity.c(paramf);
  }
  
  public static l ab()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  public static m ac()
  {
    m localm = new m();
    localm.g(new Bundle());
    return localm;
  }
  
  private void ad()
  {
    RilButton localRilButton = this.ab;
    if (ae()) {}
    for (int i = RilButton.c;; i = RilButton.b)
    {
      localRilButton.setStyle(i);
      return;
    }
  }
  
  private boolean ae()
  {
    return (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.Q) != com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.P)) || (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.O) != com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.N));
  }
  
  private void af()
  {
    new AlertDialog.Builder(m()).setTitle(2131493631).setMessage(a(2131493630) + " " + a(2131493638)).setPositiveButton(2131492964, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        m.c(m.this);
      }
    }).setNegativeButton(2131492871, null).show();
  }
  
  private void ag()
  {
    new AlertDialog.Builder(m()).setTitle(2131493060).setMessage(2131493640).setPositiveButton(2131492890, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        m.a(m.this);
      }
    }).setNegativeButton(2131492884, null).show();
  }
  
  private void ah()
  {
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.Q) != com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.P)) {
      com.pocket.stats.a.a(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.Q));
    }
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.O) != com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.N)) {
      com.pocket.stats.a.a(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.O));
    }
    com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.N, com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.O));
    com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.P, com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.Q));
    g.a();
    ai();
    Toast.makeText(m(), 2131493743, 0).show();
  }
  
  private void ai()
  {
    this.ag = true;
    P();
  }
  
  private boolean i(boolean paramBoolean)
  {
    if (this.ag) {}
    while (!ae()) {
      return false;
    }
    if (paramBoolean) {
      af();
    }
    for (;;)
    {
      return true;
      ag();
    }
  }
  
  public String K()
  {
    return "cache_settings";
  }
  
  public void P()
  {
    if (i(false)) {
      return;
    }
    super.P();
  }
  
  public boolean W()
  {
    if (i(false)) {
      return true;
    }
    return super.W();
  }
  
  protected int Y()
  {
    return 0;
  }
  
  protected View Z()
  {
    return null;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    paramArrayList.add(p.a(this, 2131493646));
    paramArrayList.add(new n(this));
    paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.Q, 2131493641).g(2131493644).g(2131493645).a(new com.pocket.q.a.m()
    {
      public void a(int paramAnonymousInt)
      {
        m.this.ac.notifyDataSetChanged();
        m.b(m.this);
      }
      
      public boolean a(int paramAnonymousInt, DialogInterface paramAnonymousDialogInterface)
      {
        return true;
      }
    }).b());
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.O, com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.N));
    com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.Q, com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.P));
    this.ab.setVisibility(0);
    this.ab.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!m.a(m.this, true)) {
          m.a(m.this);
        }
      }
    });
    ad();
    com.pocket.stats.a.a.a();
  }
  
  public void w()
  {
    super.w();
    g.a();
    c.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */