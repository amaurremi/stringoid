package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.ThemedListView;
import com.ideashower.readitlater.views.ThemedSpinner;
import com.ideashower.readitlater.views.an;
import com.ideashower.readitlater.views.ao;
import com.ideashower.readitlater.views.av;
import com.ideashower.readitlater.views.aw;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.i.a.p;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.n;
import com.pocket.list.adapter.g;
import com.pocket.list.adapter.h;
import com.pocket.list.widget.PocketView;
import com.pocket.p.k;
import com.pocket.widget.DrawerLayoutNoMinMargin;
import com.pocket.widget.al;
import com.pocket.widget.am;
import com.pocket.widget.ar;
import com.pocket.widget.navigation.r;
import com.pocket.widget.t;
import com.pocket.widget.u;
import java.util.ArrayList;

public class ai
  extends f
  implements com.pocket.o.e
{
  private static final Interpolator Z = new AccelerateInterpolator();
  public ResizeDetectRelativeLayout Y;
  private ThemedSpinner aa;
  private an ab;
  private PocketView ac;
  private t ad;
  private com.pocket.list.a ae;
  private StyledToolbar af;
  private ToolbarLayout ag;
  private final aj ah = new aj();
  private ar ai;
  private View aj;
  private com.pocket.gsf.e ak;
  private View al;
  private com.pocket.list.widget.a.j am;
  private boolean an;
  private ItemQuery ao;
  private com.pocket.widget.navigation.v ap;
  private StyledIconButton aq;
  private StyledIconButton ar;
  private StyledIconButton as;
  private boolean at;
  private RelativeLayout au;
  private al av;
  
  public static ai Y()
  {
    return new ai();
  }
  
  private View a(com.pocket.widget.l paraml)
  {
    paraml = LayoutInflater.from(m()).inflate(2130903116, paraml, false);
    RilButton localRilButton = (RilButton)paraml.findViewById(2131230782);
    localRilButton.setGravity(19);
    localRilButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.ideashower.readitlater.a.v.b(2);
        if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bE))
        {
          if (com.ideashower.readitlater.a.c.e())
          {
            GsfActivity.a(ai.this.m(), 2);
            return;
          }
          bl.a(ai.this.m(), "getstarted", 0, "see_apps");
          return;
        }
        bl.a(ai.this.m(), "getstarted", 2, "see_apps");
      }
    });
    localRilButton = (RilButton)paraml.findViewById(2131230953);
    localRilButton.setGravity(19);
    localRilButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.ideashower.readitlater.a.v.a(2);
        bl.a(ai.this.m(), "getstarted", 2, "browsers");
      }
    });
    return paraml;
  }
  
  private void a(Menu paramMenu, boolean paramBoolean)
  {
    if (paramMenu == null) {
      return;
    }
    paramMenu = paramMenu.findItem(3);
    if (paramBoolean) {}
    for (int i = 2131493482;; i = 2131493471)
    {
      paramMenu.setTitle(i).setVisible(this.ah.b);
      return;
    }
  }
  
  private void a(final View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (paramView == null) {}
    do
    {
      return;
      if (!com.ideashower.readitlater.util.a.i()) {
        break label129;
      }
      if (!paramBoolean1) {
        break;
      }
      paramView.setVisibility(0);
    } while (!paramBoolean2);
    com.b.c.a.b(paramView, 0.75F);
    com.b.c.a.c(paramView, 0.75F);
    com.b.c.a.a(paramView, 1.0F);
    com.b.c.c.a(paramView).g(1.0F).i(1.0F).a(400L).a(com.pocket.widget.navigation.o.a).a(null);
    return;
    if (paramBoolean2)
    {
      com.b.c.c.a(paramView).g(0.75F).i(0.75F).k(0.0F).a(190L).a(Z).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          paramView.setVisibility(8);
        }
      });
      return;
    }
    paramView.setVisibility(8);
    return;
    label129:
    if (paramBoolean1) {}
    for (;;)
    {
      paramView.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  private void ag()
  {
    int i = 2;
    if (R()) {}
    PocketActivity localPocketActivity;
    do
    {
      return;
      localPocketActivity = (PocketActivity)m();
    } while (localPocketActivity.C() == 0);
    int j;
    switch (localPocketActivity.C())
    {
    case 2: 
    default: 
      i = 0;
      j = -1;
    }
    Object localObject;
    while (i != 0)
    {
      localPocketActivity.d(i);
      if (j == -1) {
        break label199;
      }
      localObject = bl.a("getstarted", j, null);
      if (!com.ideashower.readitlater.util.j.g()) {
        break label184;
      }
      k.a((android.support.v4.app.d)localObject, localPocketActivity, null, false);
      h(true);
      localPocketActivity.a(false, false, true);
      return;
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.y, true).a();
      localObject = com.ideashower.readitlater.a.a.a("gsf_show", true, false);
      if ((localObject != null) && (((String)localObject).equals("hide")))
      {
        i = 0;
        j = -1;
      }
      else
      {
        j = 2;
        continue;
        j = 5;
        i = 4;
        com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aX, false).a();
      }
    }
    label184:
    localPocketActivity.a((Fragment)localObject, null, true, false);
    localPocketActivity.d(0);
    return;
    label199:
    h(false);
  }
  
  private void ah()
  {
    ((DrawerLayoutNoMinMargin)c(2131230730)).setDrawerLockMode(1);
    com.pocket.widget.navigation.o localo = this.af.b(true);
    localo.a(r.a).a(2130837803);
    localo.a(m().getIntent().getStringExtra("extraTitle"));
    localo.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ai.this.P();
      }
    });
  }
  
  private void ai()
  {
    if (com.ideashower.readitlater.util.j.c()) {
      return;
    }
    this.am = new com.pocket.list.widget.a.j(this);
    this.ac.a(this.am.c(), com.pocket.list.widget.d.a);
  }
  
  private void aj()
  {
    this.ad = new t(m(), new u()
    {
      public void a()
      {
        ai.c(ai.this).getQuery().b().e();
      }
      
      public void b()
      {
        ai.c(ai.this).getQuery().b().d();
      }
    });
    this.ad.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.ac.a(this.ad, com.pocket.list.widget.d.b);
    this.ac.getAdapter().a(new com.pocket.list.adapter.f()
    {
      public void a(com.pocket.list.adapter.a paramAnonymousa)
      {
        paramAnonymousa = paramAnonymousa.c();
        if ((paramAnonymousa.D()) || (paramAnonymousa.h()) || (paramAnonymousa.B()))
        {
          ai.d(ai.this).setVisibility(0);
          return;
        }
        ai.d(ai.this).setVisibility(8);
      }
    });
    this.ae.a(new com.pocket.list.b()
    {
      public void a()
      {
        ai.d(ai.this).setEnabled(false);
      }
      
      public void b()
      {
        ai.d(ai.this).setEnabled(true);
      }
    });
  }
  
  private void ak()
  {
    com.pocket.widget.l locall = new com.pocket.widget.l(m());
    this.au = new RelativeLayout(m());
    this.au.addView(locall, new RelativeLayout.LayoutParams(-1, -2));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    locall.setLayoutParams(localLayoutParams);
    locall.setIsWrappedBy(this.au);
    locall.setListView(this.ac.getListView());
    this.ac.a(this.au);
    if (com.ideashower.readitlater.a.c.d())
    {
      this.ak = new com.pocket.gsf.e(m(), this, this.ac.getAdapter(), this.ac.getListView());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      locall.addView(this.ak, localLayoutParams);
    }
    for (;;)
    {
      this.ac.getAdapter().a(new com.pocket.list.adapter.f()
      {
        public void a(com.pocket.list.adapter.a paramAnonymousa)
        {
          ai.e(ai.this);
        }
      });
      return;
      locall.addView(a(locall));
      this.ac.getAdapter().a(new com.pocket.list.adapter.e()
      {
        public void a(com.pocket.list.adapter.a paramAnonymousa)
        {
          if (paramAnonymousa.h() >= 7)
          {
            com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.bJ, false).a();
            ai.e(ai.this);
          }
        }
      });
    }
  }
  
  private void al()
  {
    if (this.au == null) {
      return;
    }
    RelativeLayout localRelativeLayout = this.au;
    if ((this.ac.getQuery().J()) && (com.ideashower.readitlater.a.v.n())) {}
    for (boolean bool = true;; bool = false)
    {
      z.c(localRelativeLayout, bool);
      return;
    }
  }
  
  private void am()
  {
    com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.bU, 2).a();
    if (this.ap == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)c(2131230805);
    this.al = ar.a(m(), localViewGroup, 2131493411, 2131493410, 20, 2131492924, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ai.f(ai.this);
      }
    });
    this.al.setClickable(true);
    Object localObject = (p)this.al.getBackground();
    ((p)localObject).a(230);
    ((p)localObject).a(true);
    com.b.c.a.b(this.al, 0.85F);
    com.b.c.a.c(this.al, 0.85F);
    com.b.c.a.a(this.al, 0.0F);
    localObject = new RelativeLayout.LayoutParams(com.ideashower.readitlater.util.j.a(270.0F), -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = com.ideashower.readitlater.util.j.a(30.0F);
    ((RelativeLayout.LayoutParams)localObject).topMargin = com.ideashower.readitlater.util.j.a(2.0F);
    localViewGroup.addView(this.al, (ViewGroup.LayoutParams)localObject);
    com.b.c.c.a(this.al).k(1.0F).g(1.0F).i(1.0F).a(new DecelerateInterpolator()).a(444L);
    if (this.ak != null) {
      this.ak.setVisibility(4);
    }
    this.ap.e().a(new android.support.v4.widget.c()
    {
      public void a(View paramAnonymousView)
      {
        ai.f(ai.this);
      }
    });
  }
  
  private void an()
  {
    if (this.al == null) {
      return;
    }
    final View localView = this.al;
    this.al = null;
    com.b.c.c.a(localView).k(0.0F).a(new DecelerateInterpolator()).a(333L).b(0L).a(new com.pocket.b.b()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        ((ViewGroup)ai.this.c(2131230805)).removeView(localView);
        if (ai.g(ai.this) != null)
        {
          com.b.c.a.a(ai.g(ai.this), 0.0F);
          ai.g(ai.this).setVisibility(0);
          com.b.c.c.a(ai.g(ai.this)).k(1.0F).a(new DecelerateInterpolator()).a(444L);
        }
      }
    });
  }
  
  private void ao()
  {
    if (this.ai == null) {
      return;
    }
    this.ai.a();
    this.ai = null;
  }
  
  private void ap()
  {
    this.af.a(StyledToolbar.a, false);
    this.as = ((StyledIconButton)c(2131230806));
    this.as.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchActivity.a(ai.this.m(), ai.c(ai.this).getQuery());
      }
    });
    this.ar = ((StyledIconButton)c(2131230807));
    this.ar.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditTagsActivity.a(ai.this.m(), UiContext.a(UiTrigger.e));
      }
    });
    this.aq = ((StyledIconButton)c(2131230809));
    this.aq.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ai.h(ai.this);
      }
    });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aw(2130837869, a(2131493511), 2130837869, true));
    localArrayList.add(new aw(2130837858, a(2131493507)));
    localArrayList.add(new aw(2130837853, a(2131493498)));
    this.aa = ((ThemedSpinner)c(2131230808));
    if ((com.ideashower.readitlater.util.j.c()) && (com.ideashower.readitlater.util.a.d()))
    {
      this.aa.setOnRebuildListener(new av()
      {
        public void a(ThemedSpinner paramAnonymousThemedSpinner)
        {
          ai.a(ai.this, paramAnonymousThemedSpinner);
        }
      });
      this.aa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = ai.c(ai.this).getAdapter();
          if (paramAnonymousInt == 0) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = 1)
          {
            paramAnonymousAdapterView.a(paramAnonymousInt);
            return;
          }
        }
        
        public void onNothingSelected(AdapterView paramAnonymousAdapterView) {}
      });
      localArrayList = new ArrayList();
      localArrayList.add(new aw(2130837863, "Tile"));
      localArrayList.add(new aw(2130837868, "List"));
      this.aa.setSpinnerStyle(2);
      this.aa.setOptions(localArrayList);
      this.aa.setSelection(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aC));
      return;
    }
    this.af.removeView(this.aa);
    this.aa = null;
  }
  
  private void aq()
  {
    ArrayList localArrayList = new ArrayList();
    if (com.ideashower.readitlater.util.j.c()) {
      if ((this.aa != null) || (!com.ideashower.readitlater.util.j.c())) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      this.at = bool;
      if (this.at) {
        localArrayList.add(new com.pocket.widget.a(4, 2131493484, -1, -1)
        {
          public void a()
          {
            if (ai.c(ai.this).getAdapter().d() == 1)
            {
              ai.c(ai.this).getAdapter().a(0);
              return;
            }
            ai.c(ai.this).getAdapter().a(1);
          }
        });
      }
      localArrayList.add(new com.pocket.widget.a(5, 2131493452, -1, -1)
      {
        public void a()
        {
          ai.i(ai.this).b();
        }
      });
      localArrayList.add(new com.pocket.widget.a(3, 2131493471, -1, -1)
      {
        public void a()
        {
          ai.j(ai.this).a();
        }
      });
      localArrayList.add(new com.pocket.widget.a(-1, 2131493476, -1, -1)
      {
        public void a()
        {
          if (ak.ab() == com.pocket.p.l.a)
          {
            al.a(ak.ac(), ai.k(ai.this).getContext());
            return;
          }
          SettingsActivity.c(ai.k(ai.this).getContext());
        }
      });
      localArrayList.add(new com.pocket.widget.a(-2, 2131493459, -1, -1)
      {
        public void a()
        {
          if (x.ab() == com.pocket.p.l.a)
          {
            al.a(x.ac(), ai.k(ai.this).getContext());
            return;
          }
          HelpListActivity.c(ai.k(ai.this).getContext());
        }
      });
      this.av = new al(m(), localArrayList, false, null);
      this.av.a(new am()
      {
        public void a(ArrayList paramAnonymousArrayList, ThemedListView paramAnonymousThemedListView)
        {
          paramAnonymousArrayList = ai.l(ai.this);
          if (ai.j(ai.this).c())
          {
            i = 2131493482;
            paramAnonymousArrayList.a(3, i);
            if (ai.m(ai.this))
            {
              paramAnonymousArrayList = ai.l(ai.this);
              if (ai.c(ai.this).getAdapter().d() != 0) {
                break label80;
              }
            }
          }
          label80:
          for (int i = 2131493484;; i = 2131493485)
          {
            paramAnonymousArrayList.a(4, i);
            return;
            i = 2131493471;
            break;
          }
        }
      });
      this.ab.a(new ao()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (k.a(ai.this)) {
            return;
          }
          al localal = ai.l(ai.this);
          if (paramAnonymousBoolean) {}
          for (int i = 2131493482;; i = 2131493471)
          {
            localal.a(3, i);
            return;
          }
        }
      });
      return;
    }
  }
  
  private void ar()
  {
    this.av.a(this.aq);
  }
  
  private void as()
  {
    ((a)m()).a(new c()
    {
      public boolean a(Menu paramAnonymousMenu)
      {
        paramAnonymousMenu.add(-2, 3, 0, ai.this.a(2131493471)).setIcon(2130837667);
        paramAnonymousMenu.add(-2, 4, 0, ai.this.a(2131493452)).setIcon(2130837662);
        return true;
      }
      
      public boolean a(MenuItem paramAnonymousMenuItem)
      {
        boolean bool = true;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          bool = false;
        }
        do
        {
          return bool;
          ai.j(ai.this).a();
          return true;
        } while (!ai.n(ai.this).d);
        ai.i(ai.this).b();
        return true;
      }
      
      public boolean b(Menu paramAnonymousMenu)
      {
        paramAnonymousMenu = paramAnonymousMenu.findItem(4);
        if (!ai.i(ai.this).d()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousMenu.setEnabled(bool).setVisible(ai.n(ai.this).d);
          ai.a(ai.this, ((a)ai.this.m()).n(), ai.j(ai.this).c());
          return true;
        }
      }
    });
    this.ab.a(new ao()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (k.a(ai.this)) {
          return;
        }
        ai.a(ai.this, ((a)ai.this.m()).n(), paramAnonymousBoolean);
      }
    });
  }
  
  private void at()
  {
    this.ag.removeView(this.Y);
    if (com.ideashower.readitlater.util.j.c()) {}
    for (this.Y = ((ResizeDetectRelativeLayout)LayoutInflater.from(m()).inflate(2130903077, null, false));; this.Y = ((ResizeDetectRelativeLayout)LayoutInflater.from(m()).inflate(2130903076, null, false)))
    {
      com.ideashower.readitlater.util.i.a(com.ideashower.readitlater.util.i.a, this.Y.findViewById(2131230909));
      com.ideashower.readitlater.util.i.a(com.ideashower.readitlater.util.i.a, this.Y.findViewById(2131230911));
      com.ideashower.readitlater.util.i.a(com.ideashower.readitlater.util.i.a, this.Y.findViewById(2131230913));
      this.Y.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView.setOnClickListener(null);
          ai.this.g(false);
          z.b(ai.this.Y, false);
          ai.this.Y = null;
        }
      });
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131230742);
      localLayoutParams.addRule(2, 2131230751);
      this.Y.setLayoutParams(localLayoutParams);
      this.ag.addView(this.Y);
      return;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.aj == null)
    {
      this.aj = new View(m());
      this.aj.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.aj.setClickable(true);
      this.aj.setBackgroundResource(2130837749);
      ((ViewGroup)X()).addView(this.aj);
    }
    if (paramBoolean)
    {
      this.aj.setVisibility(0);
      return;
    }
    z.b(this.aj, false);
  }
  
  private void l(Bundle paramBundle)
  {
    this.ac.getAdapter().b().a(com.ideashower.readitlater.h.a.F);
    int i;
    boolean bool;
    if ((this.ao != null) && (this.ao.n() != 0))
    {
      i = 1;
      if (i != 0) {
        break label139;
      }
      bool = true;
      label41:
      a(true, true, bool, false, true, false);
      if (paramBundle != null) {
        break label214;
      }
      if (this.ap != null)
      {
        if (!m().getIntent().getBooleanExtra("extraLaunchInbox", false)) {
          break label144;
        }
        this.ap.b(com.pocket.widget.navigation.j.b);
        this.ap.b(com.pocket.widget.navigation.j.j);
      }
    }
    for (;;)
    {
      if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bO))
      {
        com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.bO, false).a();
        com.ideashower.readitlater.a.v.c(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bT) - 1);
      }
      return;
      i = 0;
      break;
      label139:
      bool = false;
      break label41;
      label144:
      if (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.G))
      {
        this.ap.b(com.pocket.widget.navigation.j.b);
      }
      else if (com.ideashower.readitlater.util.j.c())
      {
        this.ac.getQuery().b().a("_untagged_");
        this.ap.b(com.pocket.widget.navigation.j.g);
      }
      else
      {
        this.ap.b(com.pocket.widget.navigation.j.l);
      }
    }
    label214:
    if (this.ap != null) {
      this.ap.b(paramBundle);
    }
    this.ae.b(paramBundle);
    this.ad.setStateSelected(paramBundle.getInt("state_list_archive_tab"));
    if ((this.ad.getStateSelected() == 1) && (paramBundle.getBoolean("state_list_archive_tab_visible"))) {
      this.ac.getQuery().b().d();
    }
    this.ac.getAdapter().b(paramBundle);
    ((a)m()).a(true, false, false);
    this.ac.getAdapter().a(new h()
    {
      public void a()
      {
        if (!ai.this.Q()) {
          ((a)ai.this.m()).a(false, false, true);
        }
      }
    });
  }
  
  private void m(Bundle paramBundle)
  {
    this.ap = new com.pocket.widget.navigation.v(this, paramBundle);
  }
  
  public String K()
  {
    return "list";
  }
  
  public void M()
  {
    if ((!Q()) && (com.ideashower.readitlater.util.j.g()) && (((PocketActivity)m()).C() != 0))
    {
      ((PocketActivity)m()).d(0);
      h(false);
    }
  }
  
  protected boolean S()
  {
    return false;
  }
  
  public boolean W()
  {
    if (aa()) {
      return true;
    }
    if (this.ae.d())
    {
      this.ae.c();
      return true;
    }
    return super.W();
  }
  
  public void Z()
  {
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bU) == 1) {
      am();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str = this.ac.getQuery().A();
    if ((str != null) && (paramString1.equals(str))) {
      this.ap.a(paramString2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    if (this.aa != null) {
      a(this.aa, paramBoolean1, paramBoolean6);
    }
    for (;;)
    {
      a(this.as, paramBoolean3, paramBoolean6);
      a(this.ar, paramBoolean4, paramBoolean6);
      if (this.av != null)
      {
        this.av.a(5, paramBoolean5);
        this.av.a(3, paramBoolean2);
      }
      this.ah.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean5, paramBoolean4);
      return;
      if (this.at) {
        this.av.a(4, paramBoolean1);
      }
    }
  }
  
  public boolean aa()
  {
    boolean bool = false;
    if (z.a(this.Y))
    {
      g(false);
      bool = true;
    }
    return bool;
  }
  
  public com.pocket.list.a ab()
  {
    return this.ae;
  }
  
  public t ac()
  {
    return this.ad;
  }
  
  public StyledToolbar ad()
  {
    return this.af;
  }
  
  public com.pocket.list.adapter.a ae()
  {
    return this.ac.getAdapter();
  }
  
  public PocketView af()
  {
    return this.ac;
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903054, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    this.ao = ((ItemQuery)m().getIntent().getParcelableExtra("extraQuery"));
    if (this.ao != null) {
      this.an = true;
    }
    super.d(paramBundle);
    this.af = ((StyledToolbar)c(2131230742));
    this.ag = ((ToolbarLayout)c(2131230729));
    this.ag.setBackgroundResource(2130837779);
    this.ae = new com.pocket.list.a(this, this.ag);
    this.ab = new an(this.af);
    if (!this.an) {
      m(paramBundle);
    }
    for (;;)
    {
      this.ac = ((PocketView)c(2131230754));
      if (this.ao != null) {
        this.ac.getQuery().a().a(this.ao).a();
      }
      aj();
      if (!this.an) {
        ai();
      }
      if ((com.ideashower.readitlater.a.v.n()) && (!this.an)) {
        ak();
      }
      ap();
      if ((com.ideashower.readitlater.util.j.i()) || (this.av == null))
      {
        this.aq.setVisibility(8);
        as();
      }
      if (com.ideashower.readitlater.util.a.e())
      {
        this.aq.setVisibility(0);
        aq();
      }
      ag();
      l(paramBundle);
      this.ac.getAdapter().b(true);
      this.ab.b();
      this.ac.getAdapter().a(new g()
      {
        public void a(com.ideashower.readitlater.e.o paramAnonymouso)
        {
          ai.this.Z();
        }
        
        public void b(com.ideashower.readitlater.e.o paramAnonymouso)
        {
          if (ai.a(ai.this) != null)
          {
            com.ideashower.readitlater.a.v.e();
            ai.b(ai.this);
          }
        }
      });
      return;
      ah();
    }
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    this.ac.getAdapter().a(paramBundle);
    this.ae.a(paramBundle);
    if (this.ap != null) {
      this.ap.a(paramBundle);
    }
    paramBundle.putInt("state_list_archive_tab", this.ad.getStateSelected());
    if (this.ad.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("state_list_archive_tab_visible", bool);
      return;
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    com.pocket.list.adapter.data.a locala = this.ac.getAdapter().b();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      locala.a(paramBoolean);
      return;
    }
  }
  
  public void g()
  {
    super.g();
    if (this.ak != null) {
      this.ak.b();
    }
    Z();
    al();
  }
  
  public void g(boolean paramBoolean)
  {
    if (z.a(this.Y, paramBoolean)) {
      return;
    }
    if (this.Y == null)
    {
      at();
      z.b(this.Y, paramBoolean);
      return;
    }
    z.b(this.Y, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.Y != null) {
      at();
    }
  }
  
  public void w()
  {
    super.w();
    if (this.am != null) {
      this.am.d();
    }
  }
  
  public void x()
  {
    super.x();
    if (this.ak != null) {
      this.ak.c();
    }
    ao();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */