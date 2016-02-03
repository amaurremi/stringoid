package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.at;
import com.ideashower.readitlater.activity.a.d;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.reader.c;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.z;
import com.pocket.p.k;
import com.pocket.q.a.b;
import com.pocket.q.a.n;
import com.pocket.q.a.p;
import com.pocket.q.a.r;
import com.pocket.q.a.s;
import com.pocket.q.a.t;
import com.pocket.q.a.v;
import com.pocket.q.a.w;
import com.pocket.user.UserMeta;
import java.util.ArrayList;

public class ak
  extends h
{
  private com.pocket.q.a.a ag;
  private v ah;
  private com.pocket.q.a.a ai;
  
  private n a(int paramInt, final String paramString, final boolean paramBoolean)
  {
    p.b(this, paramInt).a(new b()
    {
      public void a()
      {
        if (paramBoolean)
        {
          Intent localIntent = new Intent(ak.this.m(), FramedWebViewActivity.class);
          localIntent.putExtra("pathToLoad", paramString);
          ak.this.m().startActivity(localIntent);
          return;
        }
        com.ideashower.readitlater.a.g.a(ak.this.m(), paramString);
      }
    }).a();
  }
  
  public static void a(android.support.v4.app.f paramf)
  {
    if (ab() == com.pocket.p.l.a)
    {
      k.a(ac(), paramf);
      return;
    }
    SettingsActivity.c(paramf);
  }
  
  public static com.pocket.p.l ab()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  public static ak ac()
  {
    return new ak();
  }
  
  private void ae()
  {
    if (as.f()) {}
    for (String str = as.e();; str = as.j())
    {
      if (str != this.ag.f())
      {
        this.ag.a(com.pocket.q.a.a.b, str);
        this.ac.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    if (!com.ideashower.readitlater.a.g.y()) {
      return;
    }
    paramArrayList.add(p.b(this, "Alpha/Beta Testing Tools").a(new b()
    {
      public void a()
      {
        ak.this.a(new Intent(ak.this.m(), com.pocket.app.e.class));
      }
    }).a());
  }
  
  public String K()
  {
    return "settings";
  }
  
  public void M()
  {
    super.M();
    ae();
  }
  
  protected int Y()
  {
    return 2131493476;
  }
  
  protected View Z()
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.ah.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    final a locala = (a)m();
    b(paramArrayList);
    paramArrayList.add(p.a(this, 2131493665));
    Object localObject;
    if (as.f()) {
      localObject = as.e();
    }
    for (;;)
    {
      this.ag = p.b(this, 2131493662).a((String)localObject).a(new b()
      {
        public void a()
        {
          o.a((a)ak.this.m());
        }
      }).a();
      paramArrayList.add(this.ag);
      paramArrayList.add(p.b(this, 2131493677).a(new b()
      {
        public void a()
        {
          com.ideashower.readitlater.activity.a.h.b(2131492914).a(locala);
        }
      }).a());
      paramArrayList.add(p.b(this, 2131493691).a(new b()
      {
        public void a()
        {
          an.a(ak.this.T(), null, null);
        }
      }).a());
      if (as.w())
      {
        this.ai = p.b(this, 2131493713).a(new b()
        {
          public void a()
          {
            ak.this.ad();
          }
        }).a();
        paramArrayList.add(this.ai);
      }
      paramArrayList.add(p.a(this, 2131493666));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.bb, 2131493693).e(2131493694).a(new com.pocket.q.a.h()
      {
        public boolean a(boolean paramAnonymousBoolean)
        {
          return true;
        }
        
        public void b(boolean paramAnonymousBoolean)
        {
          locala.u().e();
        }
      }).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.aw, 2131493650).e(2131493651).a(new com.pocket.q.a.h()
      {
        public boolean a(boolean paramAnonymousBoolean)
        {
          return true;
        }
        
        public void b(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            com.ideashower.readitlater.h.m.b(i);
            ((a)ak.this.m()).a(com.ideashower.readitlater.h.m.a(ak.this.m()));
            return;
          }
        }
      }).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.ax, 2131493624).e(2131493625).f(2131493626).c(com.ideashower.readitlater.h.a.aw, true).a(new com.pocket.q.a.h()
      {
        public boolean a(boolean paramAnonymousBoolean)
        {
          return true;
        }
        
        public void b(boolean paramAnonymousBoolean)
        {
          ((a)ak.this.m()).a(com.ideashower.readitlater.h.m.a(ak.this.m()));
        }
      }).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.bn, 2131493695).e(2131493696).b());
      paramArrayList.add(p.a(this, 2131493671));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.ar, 2131493705).e(2131493706).a(new com.pocket.q.a.h()
      {
        public boolean a(boolean paramAnonymousBoolean)
        {
          return true;
        }
        
        public void b(boolean paramAnonymousBoolean) {}
      }).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.z, 2131493687).e(2131493688).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.K, 2131493719).e(2131493720).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.ay, 2131493689).e(2131493690).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.az, 2131493616).e(2131493617).b());
      paramArrayList.add(new w(this));
      paramArrayList.add(p.a(this, 2131493669));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.B, 2131493656).e(2131493657).g(2131493658).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.C, 2131493653).e(2131493654).f(2131493655).c(com.ideashower.readitlater.h.a.B, false).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.D, 2131493659).e(2131493660).f(2131493661).c(com.ideashower.readitlater.h.a.B, false).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.H, 2131493686).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.I, 2131493678).e(2131493679).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.L, 2131493701).a(new com.pocket.q.a.h()
      {
        public boolean a(boolean paramAnonymousBoolean)
        {
          com.ideashower.readitlater.activity.a.i.a(paramAnonymousBoolean, locala);
          return false;
        }
        
        public void b(boolean paramAnonymousBoolean) {}
      }).b());
      paramArrayList.add(p.b(this, 2131493646).a(new b()
      {
        public void a()
        {
          m.a(ak.this.m());
        }
      }).a());
      paramArrayList.add(p.b(this, 2131493649).a(new b()
      {
        public void a()
        {
          new AlertDialog.Builder(locala).setTitle(2131493064).setMessage(2131493063).setNegativeButton(2131492871, null).setPositiveButton(2131492878, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              com.pocket.m.a.l.a(1, true, null, false);
            }
          }).show();
        }
      }).a());
      paramArrayList.add(p.a(this, 2131493674));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.E, 2131493704).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.J, 2131493623).g(2131493618).g(2131493619).g(2131493620).g(2131493621).g(2131493622).a(new com.pocket.q.a.m()
      {
        public void a(int paramAnonymousInt) {}
        
        public boolean a(int paramAnonymousInt, final DialogInterface paramAnonymousDialogInterface)
        {
          com.ideashower.readitlater.activity.a.i.a(paramAnonymousInt, new com.ideashower.readitlater.d.f()
          {
            public void a(boolean paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Boolean) && (paramAnonymousDialogInterface != null)) {
                paramAnonymousDialogInterface.dismiss();
              }
            }
          }, locala);
          if (paramAnonymousInt == 0) {
            return false;
          }
          paramAnonymousDialogInterface.dismiss();
          return true;
        }
      }).b());
      paramArrayList.add(p.a(this, 2131493667));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.F, 2131493700).g(2131493698).g(2131493699).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.G, 2131493716).e(2131493717).b());
      paramArrayList.add(p.b(this, 2131493702).a(2131493703).a(new b()
      {
        public void a()
        {
          bi.a(ak.this.m());
        }
      }).a());
      paramArrayList.add(p.a(this, 2131493673));
      paramArrayList.add(p.b(this, 2131493697).a(new b()
      {
        public void a()
        {
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(ak.this.m());
          localBuilder.setTitle(2131493115).setMessage(2131493114).setNeutralButton(2131492871, null).setPositiveButton(2131492914, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              new com.ideashower.readitlater.g.g()
              {
                protected void a()
                {
                  com.pocket.oauth.q.d(ak.this.m());
                }
              }.h();
            }
          });
          localBuilder.show();
        }
      }).a());
      paramArrayList.add(p.a(this, 2131493668));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.bj, 2131493680).e(2131493681).b());
      this.ah = new v(this, com.ideashower.readitlater.h.a.bk, a(2131493684), new s()
      {
        public boolean a()
        {
          return com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bj);
        }
      });
      paramArrayList.add(this.ah);
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.bl, 2131493682).e(2131493683).c(com.ideashower.readitlater.h.a.bj, true).b());
      paramArrayList.add(p.a(this, 2131493664));
      int j;
      if (j.c())
      {
        localObject = "tablet";
        paramArrayList.add(a(2131493712, "https://twitter.com/intent/user?screen_name=Pocket", false));
        paramArrayList.add(a(2131493663, "http://facebook.com/readitlater", false));
        paramArrayList.add(a(2131493692, "http://getpocket.com/privacy?type=" + (String)localObject, true));
        paramArrayList.add(a(2131493709, "http://getpocket.com/tos?type=" + (String)localObject, true));
        paramArrayList.add(p.a(this, 2131493675));
        localObject = p.b(this, a(2131493718, new Object[] { com.ideashower.readitlater.a.g.b().i() })).a(2131493707);
        if (com.ideashower.readitlater.a.g.y()) {
          ((com.pocket.q.a.q)localObject).a(new b()
          {
            public void a()
            {
              com.ideashower.readitlater.util.e.a(ak.this.m()).show();
            }
          });
        }
        paramArrayList.add(((com.pocket.q.a.q)localObject).a());
        if (com.ideashower.readitlater.a.g.b().a()) {
          j = com.ideashower.readitlater.a.g.b().j();
        }
      }
      try
      {
        i = m().getPackageManager().getApplicationInfo(locala.getPackageName(), 128).metaData.getInt("buildNumber");
        localObject = "Beta " + j;
        if (i > 0)
        {
          localObject = (String)localObject + " " + i;
          paramArrayList.add(p.b(this, 2131493627).a((String)localObject).a());
          return;
          localObject = as.j();
          continue;
          localObject = "phone";
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
  
  protected void ad()
  {
    if (!as.w())
    {
      this.ac.a(this.ai);
      return;
    }
    if (!com.ideashower.readitlater.a.g.k())
    {
      new AlertDialog.Builder(m()).setTitle(2131493071).setMessage(2131493179).setNegativeButton(2131492924, null).show();
      return;
    }
    String str3 = as.v();
    String str2 = com.ideashower.readitlater.a.g.a(2131493715);
    String str1 = str2;
    if (!as.k().h().a(str3)) {
      str1 = str2 + "\n\n" + com.ideashower.readitlater.a.g.a(2131493714);
    }
    new AlertDialog.Builder(m()).setTitle(2131493069).setMessage(str1).setNegativeButton(2131492871, null).setPositiveButton(2131492957, new DialogInterface.OnClickListener()
    {
      public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new ProgressDialog(ak.this.m());
        paramAnonymousDialogInterface.setMessage(ak.this.a(2131493180));
        paramAnonymousDialogInterface.setCancelable(false);
        paramAnonymousDialogInterface.show();
        as.a(new at()
        {
          public void a()
          {
            paramAnonymousDialogInterface.dismiss();
            ak.this.ac.a(ak.a(ak.this));
            ak.a(ak.this, null);
          }
          
          public void a(ErrorReport paramAnonymous2ErrorReport)
          {
            paramAnonymousDialogInterface.dismiss();
            d.a(0, paramAnonymous2ErrorReport).a(ak.this.m());
          }
        });
      }
    }).show();
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (paramBundle == null) {
      com.pocket.stats.f.a("options", "options", "open", "1");
    }
  }
  
  public void w()
  {
    super.w();
    ae();
    if ((!as.w()) && (this.ai != null))
    {
      this.ac.a(this.ai);
      this.ai = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */