package com.ideashower.readitlater.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.au;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.billing.PremiumStatus;
import com.pocket.billing.e;
import com.pocket.billing.google.i;
import com.pocket.q.a.b;
import com.pocket.q.a.p;
import com.pocket.q.a.q;
import java.util.ArrayList;
import java.util.Iterator;

public class an
  extends h
  implements au
{
  private Bundle ag;
  private e ah;
  private View ai;
  private TextView aj;
  
  public static an a(PremiumStatus paramPremiumStatus)
  {
    an localan = new an();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("info", paramPremiumStatus);
    localan.g(localBundle);
    return localan;
  }
  
  public static void a(android.support.v4.app.f paramf, com.pocket.p.l paraml, ao paramao)
  {
    if (!com.ideashower.readitlater.a.g.k())
    {
      paramf = new AlertDialog.Builder(paramf).setTitle(2131493071).setMessage(2131493037).setPositiveButton(2131492924, null).create();
      paramf.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          if (an.this != null) {
            an.this.b();
          }
        }
      });
      paramf.show();
      return;
    }
    com.ideashower.readitlater.activity.a.l locall = com.ideashower.readitlater.activity.a.l.a(2131493102, true);
    locall.a(paramf);
    b(paramf, paraml, paramao, locall);
  }
  
  public static void a(android.support.v4.app.f paramf, com.pocket.p.l paraml, PremiumStatus paramPremiumStatus)
  {
    com.pocket.p.l locall = paraml;
    if (paraml == null) {
      locall = ab();
    }
    if (locall == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(a(paramPremiumStatus), paramf);
      return;
    }
    PremiumSettingsActivity.a(paramf, paramPremiumStatus);
  }
  
  public static com.pocket.p.l ab()
  {
    if (com.ideashower.readitlater.util.j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  private void ac()
  {
    if (this.ai != null) {
      this.ai.setVisibility(8);
    }
    if (this.ah != null)
    {
      this.ah.f();
      this.ah = null;
    }
  }
  
  private void ad()
  {
    z.c(this.ai, false);
  }
  
  private void ae()
  {
    if (this.ah == null) {
      this.ah = new e(m(), new com.pocket.billing.f()
      {
        public void a() {}
        
        public void a(com.pocket.billing.g paramAnonymousg)
        {
          if ((paramAnonymousg == com.pocket.billing.g.a) || (paramAnonymousg == com.pocket.billing.g.c) || (paramAnonymousg == com.pocket.billing.g.b))
          {
            an.a(an.this, 2131493581);
            return;
          }
          an.b(an.this);
        }
        
        public void a(com.pocket.billing.google.g paramAnonymousg) {}
        
        public void a(boolean paramAnonymousBoolean) {}
        
        public void b() {}
        
        public void c() {}
        
        public void d()
        {
          Toast.makeText(an.this.m(), 2131493586, 1).show();
          al.a(an.this.m(), 3, "premium_settings");
        }
        
        public void e() {}
      }, this.ag);
    }
  }
  
  private static void b(Context paramContext, ErrorReport paramErrorReport)
  {
    com.ideashower.readitlater.util.k.a(paramContext, com.ideashower.readitlater.util.k.a(), "", null, true, paramErrorReport, null);
  }
  
  private static void b(android.support.v4.app.f paramf, final ErrorReport paramErrorReport, ao paramao, boolean paramBoolean)
  {
    if (paramErrorReport != null) {}
    for (Object localObject = paramErrorReport.b();; localObject = com.ideashower.readitlater.a.g.a(2131493043))
    {
      localObject = new AlertDialog.Builder(paramf).setTitle(2131493090).setMessage((CharSequence)localObject).setPositiveButton(2131492924, null);
      if (paramBoolean) {
        ((AlertDialog.Builder)localObject).setNeutralButton(2131492898, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            an.a(an.this, paramErrorReport);
          }
        });
      }
      paramf = ((AlertDialog.Builder)localObject).create();
      if (paramao != null) {
        paramf.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            if (an.this != null) {
              an.this.b();
            }
          }
        });
      }
      paramf.show();
      return;
    }
  }
  
  private static void b(final android.support.v4.app.f paramf, final com.pocket.p.l paraml, final ao paramao, com.ideashower.readitlater.activity.a.l paraml1)
  {
    if (com.pocket.billing.google.h.a()) {
      com.pocket.billing.google.h.a(new i()
      {
        public void a()
        {
          if (an.this.r()) {
            return;
          }
          an.a(paramf, paraml, paramao, an.this);
        }
        
        public void a(ErrorReport paramAnonymousErrorReport)
        {
          if (an.this.r()) {
            return;
          }
          an.this.a();
          an.a(paramf, paramAnonymousErrorReport, paramao, true);
        }
      });
    }
    do
    {
      return;
      if (as.m())
      {
        new com.pocket.c.j(new com.pocket.c.k()
        {
          public void a(PremiumStatus paramAnonymousPremiumStatus, boolean paramAnonymousBoolean1, ErrorReport paramAnonymousErrorReport, boolean paramAnonymousBoolean2)
          {
            if (an.this.r()) {}
            do
            {
              return;
              an.this.a();
              if (!paramAnonymousBoolean1) {
                break;
              }
              an.a(paramf, paraml, paramAnonymousPremiumStatus);
            } while (paramao == null);
            paramao.a();
            return;
            an.a(paramf, paramAnonymousErrorReport, paramao, paramAnonymousBoolean2);
          }
        }).h();
        return;
      }
      paraml1.a();
      a(paramf, paraml, null);
    } while (paramao == null);
    paramao.a();
  }
  
  private void e(int paramInt)
  {
    if (this.ai == null)
    {
      this.ai = LayoutInflater.from(m()).inflate(2130903169, this.Y, false);
      this.Y.addView(this.ai);
      this.ai.setClickable(true);
      this.aj = ((TextView)this.ai.findViewById(2131231125));
    }
    this.ai.setVisibility(0);
    if (paramInt != 0)
    {
      this.aj.setText(paramInt);
      this.aj.setVisibility(0);
      return;
    }
    this.aj.setVisibility(8);
  }
  
  public String K()
  {
    return "premium_settings";
  }
  
  protected int Y()
  {
    return 2131493466;
  }
  
  protected View Z()
  {
    return ((LayoutInflater)m().getSystemService("layout_inflater")).inflate(2130903160, null);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    final PremiumStatus localPremiumStatus = (PremiumStatus)l().getParcelable("info");
    if (((as.m()) || (as.n() >= 1)) && (localPremiumStatus != null))
    {
      paramArrayList.add(p.a(this, 2131493565));
      final Object localObject2 = p.b(this, 2131493566);
      Object localObject1;
      int i;
      if (localPremiumStatus.h())
      {
        localObject1 = localPremiumStatus.g();
        paramArrayList.add(((q)localObject2).a((String)localObject1).a());
        paramArrayList.add(p.b(this, 2131493555).a(localPremiumStatus.a()).a());
        if (!localPremiumStatus.h()) {
          break label336;
        }
        i = 2131493563;
        label116:
        paramArrayList.add(p.b(this, i).a(localPremiumStatus.b()).a());
        if (!localPremiumStatus.h()) {
          break label343;
        }
        if (localPremiumStatus.d() != null) {
          paramArrayList.add(p.b(this, 2131493560).a(localPremiumStatus.d()).a());
        }
      }
      for (;;)
      {
        paramArrayList.add(p.a(this, 2131493573));
        paramArrayList.add(p.b(this, 2131493558).a(new b()
        {
          public void a()
          {
            if ((localPremiumStatus.e()) && (com.ideashower.readitlater.a.g.a(an.this.m(), "market://details?id=com.ideashower.readitlater.pro"))) {
              return;
            }
            if (localPremiumStatus.f())
            {
              com.ideashower.readitlater.a.g.a(an.this.m(), "https://getpocket.com/premium_settings");
              return;
            }
            com.ideashower.readitlater.a.g.a(an.this.m(), "http://help.getpocket.com/customer/portal/articles/1545683");
          }
        }).a());
        ac();
        paramArrayList.add(p.a(this, 2131493572));
        if (localPremiumStatus.c() == null) {
          break label378;
        }
        localObject1 = localPremiumStatus.c().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.pocket.billing.h)((Iterator)localObject1).next();
          q localq = p.b(this, ((com.pocket.billing.h)localObject2).a).a(new b()
          {
            public void a()
            {
              com.ideashower.readitlater.a.g.a(an.this.m(), localObject2.d);
            }
          });
          if (((com.pocket.billing.h)localObject2).b == 0) {
            localq.a(((com.pocket.billing.h)localObject2).c);
          }
          paramArrayList.add(localq.a());
        }
        localObject1 = a(2131493557);
        break;
        label336:
        i = 2131493554;
        break label116;
        label343:
        paramArrayList.add(p.b(this, 2131493562).a(2131493567).a(new b()
        {
          public void a()
          {
            al.a(an.this.m(), 2, "premium_settings", true);
          }
        }).a());
      }
      label378:
      if (localPremiumStatus.h()) {
        h(true);
      }
    }
    for (;;)
    {
      paramArrayList.add(p.a(this, 2131493561));
      paramArrayList.add(p.b(this, 2131493556).a(new b()
      {
        public void a()
        {
          com.ideashower.readitlater.a.g.a(an.this.m(), "http://help.getpocket.com/customer/portal/articles/1545683");
        }
      }).a());
      paramArrayList.add(p.b(this, 2131493553).a(new b()
      {
        public void a()
        {
          an.a(an.this.m(), null);
        }
      }).a());
      return;
      h(false);
      continue;
      ae();
      paramArrayList.add(p.a(this, 2131493559));
      paramArrayList.add(p.b(this, 2131493571).a(new b()
      {
        public void a()
        {
          al.a(an.this.m(), 2, "premium_settings");
        }
      }).a());
      paramArrayList.add(p.b(this, 2131493564).a(new b()
      {
        public void a()
        {
          an.a(an.this).d();
        }
      }).a());
      h(false);
    }
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.b(paramInt1, paramInt2, paramIntent);
    if (this.ah != null) {
      this.ah.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.ag = paramBundle;
    as.a(this);
    paramBundle = (PremiumStatus)l().getParcelable("info");
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.ah != null) {
      this.ah.a(paramBundle);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(2131493102);
      new com.pocket.c.j(new com.pocket.c.k()
      {
        public void a(PremiumStatus paramAnonymousPremiumStatus, boolean paramAnonymousBoolean1, ErrorReport paramAnonymousErrorReport, boolean paramAnonymousBoolean2)
        {
          if (an.this.Q()) {
            return;
          }
          if (paramAnonymousBoolean1)
          {
            an.this.aa();
            an.b(an.this);
          }
          while ((paramAnonymousPremiumStatus != null) && (paramAnonymousPremiumStatus.h()))
          {
            an.this.h(true);
            return;
            paramAnonymousErrorReport = new AlertDialog.Builder(an.this.m()).setTitle(2131493071).setMessage(2131493037).setPositiveButton(2131492924, null).create();
            paramAnonymousErrorReport.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                an.this.P();
              }
            });
            paramAnonymousErrorReport.show();
          }
          an.this.h(false);
        }
      }).h();
      return;
    }
    aa();
  }
  
  public void x()
  {
    super.x();
    as.b(this);
  }
  
  public void y()
  {
    super.y();
    if (this.ah != null) {
      this.ah.f();
    }
    as.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */