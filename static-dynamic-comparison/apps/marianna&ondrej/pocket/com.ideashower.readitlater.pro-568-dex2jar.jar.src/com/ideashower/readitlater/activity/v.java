package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.service.PocketDemoService;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.q;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.gsf.GSFConfiguation;
import com.pocket.gsf.d;
import com.pocket.p.k;
import com.pocket.widget.ExpandableHeightGridView;

public class v
  extends f
{
  private Button Y;
  private Button Z;
  private RilButton aa;
  private StyledToolbar ab;
  private ToolbarLayout ac;
  private StyledToolbar ad;
  private ViewGroup ae;
  private ViewGroup af;
  private View ag;
  private View ah;
  private ExpandableHeightGridView ai;
  private TextView aj;
  private ScrollView ak;
  private boolean al;
  private boolean am;
  private boolean an;
  private com.pocket.gsf.b ao;
  
  public static com.pocket.p.l Y()
  {
    if (j.g()) {
      return com.pocket.p.l.c;
    }
    return com.pocket.p.l.b;
  }
  
  public static v Z()
  {
    return new v();
  }
  
  private boolean a(ScrollView paramScrollView)
  {
    boolean bool2 = false;
    View localView = paramScrollView.getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int i = localView.getHeight();
      bool1 = bool2;
      if (paramScrollView.getHeight() + j.a(10.0F) < i + paramScrollView.getPaddingTop() + paramScrollView.getPaddingBottom()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int ab()
  {
    return m().getIntent().getIntExtra("extraStartSource", 1);
  }
  
  private void ac()
  {
    if (this.ak.getScrollY() > j.a(10.0F)) {
      this.ak.fullScroll(33);
    }
    this.am = true;
    ae();
    com.ideashower.readitlater.a.v.a(ab(), e(0), e(1), e(2));
    com.b.c.c.a(this.ae).k(0.0F).a(new DecelerateInterpolator()).a(333L);
    float f = -j.a(40.0F);
    Object localObject;
    if (q.b(m()).b(true) <= 480)
    {
      com.b.c.c.a(this.ag).h(0.65F).j(0.65F).d(j.a(2.0F)).a(555L).b(222L);
      this.af.setVisibility(0);
      localObject = c(2131230785);
      ((View)localObject).setVisibility(0);
      com.b.c.a.f((View)localObject, -((View)localObject).getWidth());
      com.b.c.a.e((View)localObject, f);
      com.b.c.c.a((View)localObject).a(com.b.c.a.b(this.ag) - this.ag.getWidth() / 2 - ((View)localObject).getWidth()).a(new DecelerateInterpolator()).a(333L).b(444L);
      localObject = c(2131230786);
      ((View)localObject).setVisibility(0);
      com.b.c.a.f((View)localObject, this.ae.getRootView().getRight() + 1);
      com.b.c.a.e((View)localObject, f);
      com.b.c.c.a((View)localObject).a(com.b.c.a.b(this.ag) + (int)(this.ag.getWidth() * 1.5D)).a(new DecelerateInterpolator()).a(333L).b(444L);
      localObject = this.af.findViewById(2131230776);
      com.b.c.a.a((View)localObject, 0.0F);
      com.b.c.c.a((View)localObject).k(1.0F).a(new DecelerateInterpolator()).a(333L).b(1111L);
      localObject = this.af.findViewById(2131230780);
      com.b.c.a.a((View)localObject, 0.0F);
      com.b.c.c.a((View)localObject).k(1.0F).a(new DecelerateInterpolator()).a(333L).b(2222L).a(new com.b.a.b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          ((ViewGroup)v.d(v.this).getParent()).removeView(v.d(v.this));
        }
        
        public void b(com.b.a.a paramAnonymousa) {}
        
        public void c(com.b.a.a paramAnonymousa) {}
        
        public void d(com.b.a.a paramAnonymousa) {}
      });
      if (this.aj.getVisibility() != 0) {
        break label577;
      }
      localObject = this.aj;
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.b.c.a.a((View)localObject, 0.0F);
        com.b.c.c.a((View)localObject).k(1.0F).a(new DecelerateInterpolator()).a(333L).b(2222L);
      }
      return;
      if (q.b(m()).b(true) < 550)
      {
        com.b.c.c.a(this.ag).h(0.5F).j(0.5F).d(j.a(-10.0F)).a(555L).b(222L);
        break;
      }
      com.b.c.c.a(this.ag).d(f).a(new DecelerateInterpolator()).a(555L).b(222L);
      break;
      label577:
      if ((this.aa.getVisibility() == 0) && (this.ab.getVisibility() == 0)) {
        localObject = this.aa;
      } else {
        localObject = null;
      }
    }
  }
  
  private void ad()
  {
    this.ak.post(new Runnable()
    {
      public void run()
      {
        if (v.e(v.this).getScrollY() > j.a(10.0F)) {
          v.e(v.this).scrollTo(0, 0);
        }
      }
    });
    ((ViewGroup)this.ae.getParent()).removeView(this.ae);
    this.af.setVisibility(0);
    com.b.c.a.e(this.ag, 0.0F);
    Object localObject = (RelativeLayout.LayoutParams)this.ag.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = j.a(60.5F);
    this.ag.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = c(2131230785);
    ((View)localObject).setVisibility(0);
    com.b.c.a.d((View)localObject, 0.0F);
    com.b.c.a.e((View)localObject, 0.0F);
    localObject = c(2131230786);
    ((View)localObject).setVisibility(0);
    com.b.c.a.d((View)localObject, 0.0F);
    com.b.c.a.e((View)localObject, 0.0F);
    ae();
  }
  
  private void ae()
  {
    if (!this.am)
    {
      if (a(this.ak))
      {
        this.Y.setVisibility(4);
        this.ab.setVisibility(0);
        this.Z.setVisibility(0);
      }
      for (;;)
      {
        this.aj.setVisibility(4);
        this.aa.setVisibility(8);
        return;
        this.Y.setVisibility(0);
        this.ab.setVisibility(8);
      }
    }
    if ((this.an) && (!this.al)) {
      if (a(this.ak))
      {
        this.ab.setVisibility(0);
        this.aa.setVisibility(0);
        this.aj.setVisibility(4);
      }
    }
    for (;;)
    {
      this.Y.setVisibility(4);
      this.Z.setVisibility(8);
      return;
      this.ab.setVisibility(8);
      this.aj.setVisibility(0);
      continue;
      this.ab.setVisibility(8);
      this.aj.setVisibility(4);
    }
  }
  
  private int e(int paramInt)
  {
    if (paramInt >= this.ao.getCount()) {
      return 0;
    }
    return this.ao.a(paramInt).a().f();
  }
  
  public String K()
  {
    if (ab() == 1) {
      return "get_started_flow";
    }
    return "how_to_save_from_apps";
  }
  
  public void L()
  {
    super.L();
    if ((this.an) || (i.a(com.ideashower.readitlater.h.a.bS))) {}
    for (boolean bool = true;; bool = false)
    {
      this.an = bool;
      ae();
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (!(paramActivity instanceof GsfActivity)) {
      e.a("GsfFragment is only intended for us in a GsfActivity. It cannot be attached to a " + paramActivity.getClass().getName());
    }
    super.a(paramActivity);
  }
  
  public void aa()
  {
    if ((this.am) && (ab() == 1))
    {
      this.an = true;
      ae();
    }
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903047, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.ak = ((ScrollView)c(2131230730));
    this.Y = ((Button)c(2131230774));
    this.Z = ((Button)c(2131230788));
    this.aa = ((RilButton)c(2131230789));
    this.ab = ((StyledToolbar)c(2131230787));
    this.ag = c(2131230745);
    this.ah = c(2131230767);
    this.ac = ((ToolbarLayout)c(2131230729));
    this.ad = ((StyledToolbar)this.ac.getTopToolbar());
    this.ae = ((ViewGroup)c(2131230766));
    this.af = ((ViewGroup)c(2131230775));
    this.ai = ((ExpandableHeightGridView)c(2131230782));
    this.aj = ((TextView)c(2131230783));
    k.a(this);
    Object localObject;
    boolean bool;
    if (ab() == 1)
    {
      localObject = m();
      if (!j.i())
      {
        bool = true;
        localObject = d.a((Context)localObject, bool);
        this.ac.removeView(this.ad);
        if (!as.t()) {
          break label607;
        }
        if (paramBundle == null) {
          break label597;
        }
        bool = paramBundle.getBoolean("stateOnPageTwo", false);
        label242:
        this.am = bool;
        if ((!i.a(com.ideashower.readitlater.h.a.bS)) && (!com.ideashower.readitlater.a.c.b())) {
          break label602;
        }
        bool = true;
        label264:
        this.an = bool;
        paramBundle = (Bundle)localObject;
        label271:
        if (!this.am)
        {
          if (q.b(m()).b(true) > 480) {
            break label714;
          }
          com.b.c.c.a(this.ag).h(-0.65F).j(-0.65F).c(j.a(55)).a(0L);
          localObject = (RelativeLayout.LayoutParams)this.ah.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = j.a(70.0F);
          this.ah.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        label356:
        localObject = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView.setOnClickListener(null);
            com.ideashower.readitlater.a.v.b();
            v.a(v.this);
          }
        };
        this.Y.setOnClickListener((View.OnClickListener)localObject);
        this.ab.a(StyledToolbar.g, false);
        this.Z.setOnClickListener((View.OnClickListener)localObject);
        localObject = c(2131230765);
        if (localObject != null)
        {
          if (!j.g()) {
            break label797;
          }
          ((View)localObject).setVisibility(4);
        }
      }
    }
    for (;;)
    {
      this.ao = new com.pocket.gsf.b(paramBundle, m());
      this.ai.setAdapter(this.ao);
      this.ai.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (com.pocket.gsf.a)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          paramAnonymousView = paramAnonymousAdapterView.a();
          int i = (int)(Math.floor(paramAnonymousInt / 3.0F) + 1.0D);
          com.ideashower.readitlater.a.v.b(paramAnonymousView.f(), i, paramAnonymousInt - (i - 1) * 3 + 1, v.b(v.this));
          ((GsfActivity)v.this.m()).e(true);
          PocketDemoService.a(v.this.m(), paramAnonymousView, paramAnonymousAdapterView.b(v.this.m()), v.b(v.this));
        }
      });
      this.aj.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          com.ideashower.readitlater.a.v.c();
          a.a(v.this.m()).q();
          v.this.P();
        }
      });
      if (!this.an) {
        this.aj.setVisibility(4);
      }
      if (j.i()) {
        ((ImageView)c(2131230786)).setImageResource(2130837615);
      }
      if (this.am) {
        ad();
      }
      this.ak.fullScroll(33);
      this.ak.pageScroll(33);
      com.ideashower.readitlater.a.v.a(ab(), d.a());
      paramBundle = this.ak.getViewTreeObserver();
      if (!this.al) {
        paramBundle.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            v.c(v.this);
          }
        });
      }
      this.aa.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          com.ideashower.readitlater.a.v.c();
          a.a(v.this.m()).q();
          v.this.P();
        }
      });
      return;
      bool = false;
      break;
      label597:
      bool = false;
      break label242;
      label602:
      bool = false;
      break label264;
      label607:
      this.am = true;
      this.an = true;
      paramBundle = (Bundle)localObject;
      break label271;
      this.al = true;
      this.am = true;
      this.an = false;
      paramBundle = m();
      if (!j.i()) {}
      for (bool = true;; bool = false)
      {
        paramBundle = d.b(paramBundle, bool);
        this.ai.setExpanded(true);
        this.ad.a(true, this);
        this.ad.setTitle(2131493219);
        c(2131230765).setVisibility(8);
        c(2131230784).setVisibility(0);
        break;
      }
      label714:
      if (q.b(m()).b(true) >= 550) {
        break label356;
      }
      com.b.c.c.a(this.ag).h(-0.5F).j(-0.5F).c(100.0F).a(0L);
      localObject = (RelativeLayout.LayoutParams)this.ah.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 140;
      this.ah.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ah.requestLayout();
      break label356;
      label797:
      ((View)localObject).setVisibility(0);
    }
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putBoolean("stateOnPageTwo", this.am);
  }
  
  public void w()
  {
    super.w();
    if (!R())
    {
      if (this.am) {
        com.ideashower.readitlater.a.v.a(ab(), e(0), e(1), e(2));
      }
    }
    else {
      return;
    }
    com.ideashower.readitlater.a.v.a();
  }
  
  public void x()
  {
    super.x();
    i.b().a(com.ideashower.readitlater.h.a.bS, true).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */