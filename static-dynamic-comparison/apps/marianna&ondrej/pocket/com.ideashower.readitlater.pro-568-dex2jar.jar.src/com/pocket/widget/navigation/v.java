package com.pocket.widget.navigation;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.activity.aa;
import com.ideashower.readitlater.activity.ai;
import com.ideashower.readitlater.activity.aj;
import com.ideashower.readitlater.activity.al;
import com.ideashower.readitlater.activity.an;
import com.ideashower.readitlater.activity.az;
import com.ideashower.readitlater.activity.bj;
import com.ideashower.readitlater.activity.z;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.p;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.widget.PocketView;
import com.pocket.widget.DrawerLayoutNoMinMargin;
import com.pocket.widget.t;
import java.util.ArrayList;

public class v
  implements AdapterView.OnItemClickListener, d, e, i, k
{
  private final o a;
  private final DrawerLayoutNoMinMargin b;
  private final h c;
  private final f d = new f();
  private final ai e;
  private final Drawable f;
  private ListView g;
  private View h;
  private b i;
  private final j j;
  private Fragment k;
  private m l;
  private final aj m;
  private m n;
  private final g o;
  private c p;
  
  public v(ai paramai, Bundle paramBundle)
  {
    this.e = paramai;
    this.a = paramai.ad().b(true);
    this.b = ((DrawerLayoutNoMinMargin)paramai.c(2131230730));
    this.m = new aj();
    this.f = paramai.n().getDrawable(2130837869);
    this.b.setDrawerListener(this.d);
    this.d.a(new a()
    {
      protected void a()
      {
        super.a();
        v.a(v.this).a(false, false, false, false, false, true);
      }
      
      protected void b()
      {
        super.b();
        v.a(v.this).a(v.b(v.this).a, v.b(v.this).b, v.b(v.this).c, v.b(v.this).e, v.b(v.this).d, true);
      }
    });
    paramai.ab().a(new com.pocket.list.b()
    {
      public void a()
      {
        v.c(v.this).setDrawerLockMode(1);
      }
      
      public void b()
      {
        v.c(v.this).setDrawerLockMode(0);
      }
    });
    this.o = new g(this.e, this.a, paramBundle);
    if (com.ideashower.readitlater.util.j.c()) {}
    for (this.h = g();; this.h = f())
    {
      this.b.addView(this.h);
      this.j = new j(this.e.m(), this);
      this.g.setDivider(null);
      this.g.setDividerHeight(0);
      this.g.setAdapter(this.j);
      this.g.setOnItemClickListener(this);
      this.a.a(2130837912).d(this.f).a(r.b).a(this.d, this);
      this.c = new h(this);
      paramai.a(this.c);
      return;
    }
  }
  
  private void a(Fragment paramFragment)
  {
    android.support.v4.app.n localn = this.e.m().e().a();
    localn.a(2131230805, paramFragment, "nonListFragment");
    this.k = paramFragment;
    localn.a();
  }
  
  private void a(m paramm, final com.pocket.list.adapter.a parama)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)LayoutInflater.from(this.e.m()).inflate(2130903087, null);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)localRelativeLayout1.findViewById(2131230924);
    final w localw = new w(this.e.m(), false, true);
    localw.getEditActionHeader().setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        bj.a((com.ideashower.readitlater.activity.a)v.a(v.this).m(), v.a(v.this));
      }
    });
    localw.setTagSelectedListener(new x()
    {
      public void a(w paramAnonymousw)
      {
        String str = parama.c().A();
        if (str != null)
        {
          if (!str.equals("_untagged_")) {
            break label62;
          }
          v.d(v.this).a(com.ideashower.readitlater.a.g.a(2131493488));
        }
        for (;;)
        {
          v.e(v.this).b();
          v.b(v.this).a(true);
          return;
          label62:
          int i = ((ArrayAdapter)paramAnonymousw.getListView().getAdapter()).getPosition(str);
          paramAnonymousw.getListView().setItemChecked(i, true);
          v.d(v.this).a(str);
        }
      }
      
      public void a(w paramAnonymousw, String paramAnonymousString, int paramAnonymousInt)
      {
        localw.getListView().setItemChecked(paramAnonymousInt, true);
        parama.c().b().a(paramAnonymousString);
        paramAnonymousw = v.d(v.this);
        if (paramAnonymousString != "_untagged_") {}
        for (;;)
        {
          paramAnonymousw.a(paramAnonymousString);
          v.e(v.this).b();
          return;
          paramAnonymousString = com.ideashower.readitlater.a.g.a(2131493488);
        }
      }
      
      public void a(String paramAnonymousString) {}
      
      public void a(String paramAnonymousString, ArrayList paramAnonymousArrayList) {}
    });
    ((u)localw.getListView().getDivider()).a(this.e.n().getDimensionPixelSize(2131296291), 0);
    localRelativeLayout2.addView(localw);
    this.i.a(localRelativeLayout1, paramm, this);
  }
  
  protected static Drawable b(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { com.pocket.p.e.a(0.18F, 0), 0 });
    localGradientDrawable.setSize(paramInt, 1);
    return localGradientDrawable;
  }
  
  private void b(m paramm, final com.pocket.list.adapter.a parama)
  {
    final com.pocket.j.b localb = new com.pocket.j.b(this.e.m());
    localb.setHighlightSelectedListener(new com.pocket.j.g()
    {
      private void a(com.ideashower.readitlater.e.g paramAnonymousg, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          parama.c().b().a(paramAnonymousg.a());
        }
        v.d(v.this).a(paramAnonymousg.b(v.a(v.this).m()));
        v.e(v.this).b();
        v.b(v.this).a(true, true, false, false, false);
      }
      
      public void a(com.pocket.j.b paramAnonymousb)
      {
        int i = parama.b().j().n();
        if (i != 0) {
          a(com.ideashower.readitlater.e.k.a().a(i), false);
        }
      }
      
      public void a(com.pocket.j.b paramAnonymousb, com.ideashower.readitlater.e.g paramAnonymousg, int paramAnonymousInt)
      {
        a(paramAnonymousg, true);
        new p(UiContext.b(paramAnonymousg.a(), paramAnonymousInt)).j();
      }
      
      public void b(com.pocket.j.b paramAnonymousb)
      {
        v.e(v.this).b();
      }
    });
    this.p = new c()
    {
      public void a(View paramAnonymousView)
      {
        if (v.f(v.this) != this) {
          return;
        }
        localb.b();
      }
    };
    this.d.a(this.p);
    this.i.a(localb, paramm, this);
  }
  
  private boolean c(m paramm)
  {
    boolean bool2 = true;
    this.g.setItemChecked(this.j.a(paramm), true);
    boolean bool1;
    if ((paramm == j.b) || (paramm == j.c) || (paramm == j.e) || (paramm == j.d) || (paramm == j.f) || (paramm == j.i) || (paramm == j.h) || (paramm == j.l))
    {
      this.m.a(true, true, true, true, false);
      this.l = paramm;
      if (paramm == j.b)
      {
        this.a.c(this.f);
        if (this.i == null) {
          break label446;
        }
        this.i.c();
        bool1 = false;
      }
    }
    for (;;)
    {
      this.n = this.j.a(this.g.getCheckedItemPosition());
      if (!this.b.j(this.h)) {
        this.e.a(this.m.a, this.m.b, this.m.c, this.m.e, this.m.d, false);
      }
      return bool1;
      this.a.b(paramm.b);
      break;
      if ((paramm == j.j) || (paramm == j.a) || (paramm == j.g))
      {
        if (!com.ideashower.readitlater.util.j.c())
        {
          if (paramm == j.g) {
            this.m.a(false, false, false, false, true);
          }
          for (;;)
          {
            this.l = paramm;
            this.a.b(paramm.b);
            if (this.i == null) {
              break label446;
            }
            this.i.c();
            bool1 = false;
            break;
            this.m.a(false, false, false, false, false);
          }
        }
        if (paramm == j.j)
        {
          this.g.setItemChecked(this.j.a(this.n), true);
          bool1 = false;
          continue;
        }
        if (paramm == j.a)
        {
          bool1 = bool2;
          if (this.i.a() == paramm) {
            continue;
          }
          b(paramm, this.e.ae());
          bool1 = bool2;
          continue;
        }
        if (paramm == j.g)
        {
          bool1 = bool2;
          if (this.i.a() == paramm) {
            continue;
          }
          a(paramm, this.e.ae());
          bool1 = bool2;
        }
      }
      else if (paramm == j.k)
      {
        this.g.setItemChecked(this.j.a(this.n), true);
      }
      label446:
      bool1 = false;
    }
  }
  
  private void d(m paramm)
  {
    com.pocket.list.adapter.data.n localn = this.e.af().getQuery().b();
    if (this.k != null)
    {
      android.support.v4.app.n localn1 = this.e.m().e().a();
      localn1.a(this.k);
      this.k = null;
      localn1.a();
    }
    this.e.ac().setStateSelected(0);
    if (paramm == j.b) {
      localn.a(false);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramm == j.c)
          {
            localn.b(false);
            return;
          }
          if (paramm == j.e)
          {
            localn.c(false);
            return;
          }
          if (paramm == j.d)
          {
            localn.d(false);
            return;
          }
          if (paramm == j.f)
          {
            localn.e(false);
            return;
          }
          if (paramm == j.i)
          {
            localn.a();
            return;
          }
          if (paramm == j.h)
          {
            localn.b();
            return;
          }
          if (paramm == j.l)
          {
            localn.c();
            return;
          }
          if (paramm == j.j)
          {
            if (com.ideashower.readitlater.util.j.c())
            {
              com.pocket.p.k.a(aa.Y(), this.e.m());
              d();
            }
            for (;;)
            {
              this.o.a();
              return;
              a(aa.Y());
            }
          }
          if (paramm != j.a) {
            break;
          }
        } while (this.i != null);
        a(new z());
        return;
        if (paramm != j.g) {
          break;
        }
      } while (this.i != null);
      a(new az());
      return;
    } while (paramm != j.k);
    d();
    if (as.m())
    {
      an.a(this.e.T(), null, null);
      return;
    }
    al.a(this.e.m(), 2, "nav");
  }
  
  private View f()
  {
    this.g = ((ListView)LayoutInflater.from(this.e.m()).inflate(2130903133, this.b, false));
    this.b.a(b(this.e.n().getDimensionPixelSize(2131296290)), 3);
    return this.g;
  }
  
  private View g()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.e.m()).inflate(2130903134, this.b, false);
    this.g = ((ListView)localViewGroup.findViewById(2131231025));
    this.i = new b(this.e.m(), localViewGroup, this.d, this);
    return localViewGroup;
  }
  
  private void h()
  {
    this.g.setItemChecked(this.j.a(this.l), true);
  }
  
  public int a(m paramm)
  {
    if ((paramm == j.j) && (this.c != null)) {
      return this.c.b();
    }
    return 0;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt)
  {
    if (this.j != null) {
      this.j.notifyDataSetChanged();
    }
    this.o.a(paramInt);
  }
  
  public void a(Bundle paramBundle)
  {
    ItemQuery localItemQuery = this.e.af().getQuery();
    Bundle localBundle = new Bundle();
    localBundle.putInt("nav_state_selection", this.j.a(this.n));
    if (this.n == j.a) {
      localBundle.putInt("nav_state_highlight", localItemQuery.n());
    }
    for (;;)
    {
      paramBundle.putBundle("nav_state", localBundle);
      this.o.a(paramBundle);
      return;
      if (this.n == j.g) {
        localBundle.putString("nav_state_tag", localItemQuery.A());
      }
    }
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void b()
  {
    if (this.p != null)
    {
      final c localc = this.p;
      com.ideashower.readitlater.a.g.o().post(new Runnable()
      {
        public void run()
        {
          v.g(v.this).b(localc);
        }
      });
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.k = this.e.m().e().a("nonListFragment");
    paramBundle = paramBundle.getBundle("nav_state");
    if (paramBundle.containsKey("nav_state_highlight"))
    {
      this.e.af().getQuery().b().a(paramBundle.getInt("nav_state_highlight"));
      c(j.a);
    }
    do
    {
      return;
      if (paramBundle.containsKey("nav_state_tag"))
      {
        this.e.af().getQuery().b().a(paramBundle.getString("nav_state_tag"));
        c(j.g);
        return;
      }
      paramBundle = this.j.a(paramBundle.getInt("nav_state_selection"));
    } while (paramBundle == j.k);
    b(paramBundle);
  }
  
  public void b(m paramm)
  {
    c(paramm);
    d(paramm);
  }
  
  public void c()
  {
    this.b.c(3);
  }
  
  public void d()
  {
    this.b.d(3);
  }
  
  public f e()
  {
    return this.d;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.j.a(paramInt);
    boolean bool = c(paramAdapterView);
    d(paramAdapterView);
    com.pocket.stats.f.a(paramAdapterView.e, "", "open", "1", 9, 0, 0, 0);
    if (!bool) {
      d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */