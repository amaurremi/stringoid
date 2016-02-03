package com.pocket.a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.SplashActivity;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.q;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.LockableViewPager;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.billing.PremiumGiftMessage;
import com.pocket.c.ao;
import com.pocket.c.ap;
import com.pocket.c.t;
import com.pocket.oauth.h;
import com.pocket.widget.AutoScrollOnFocusScrollView;
import com.pocket.widget.DropDownMessageView;
import com.pocket.widget.GoogleSignInButton;
import com.pocket.widget.ValidatedEditText;
import com.pocket.widget.at;
import com.pocket.widget.au;
import com.pocket.widget.av;
import com.pocket.widget.aw;

public class a
  extends com.ideashower.readitlater.activity.f
{
  private static final AccelerateDecelerateInterpolator Z = new AccelerateDecelerateInterpolator();
  protected com.pocket.c.b Y;
  private boolean aA;
  private boolean aB;
  private GoogleSignInButton aC;
  private View aD;
  private View aE;
  private TextView aF;
  private TextView aG;
  private TextView aH;
  private TextView aI;
  private TextView aJ;
  private TextView aK;
  private boolean aL;
  private DropDownMessageView aM;
  private com.pocket.c.m aN;
  private boolean aO;
  private boolean aP;
  private String aQ;
  private com.pocket.oauth.d aa;
  private com.pocket.oauth.c ab;
  private ProgressDialog ac;
  private ViewPager ad;
  private d ae;
  private c af;
  private f ag;
  private View ah;
  private ImageView ai;
  private View aj;
  private ViewGroup ak;
  private ViewGroup al;
  private ViewGroup am;
  private ViewGroup an;
  private View ao;
  private FrameLayout ap;
  private ViewGroup aq;
  private LinearLayout ar;
  private StyledToolbar as;
  private int at;
  private RilButton au;
  private RilButton av;
  private b aw;
  private e ax;
  private AutoScrollOnFocusScrollView ay;
  private au az;
  
  public static com.pocket.p.l Y()
  {
    return com.pocket.p.l.c;
  }
  
  public static a Z()
  {
    return new a();
  }
  
  public static final String a(com.pocket.c.b paramb)
  {
    if (paramb == com.pocket.c.b.a) {}
    for (int i = 2131493161;; i = 2131493110) {
      return com.ideashower.readitlater.a.g.a(i);
    }
  }
  
  private void a(int paramInt1, View.OnClickListener paramOnClickListener1, int paramInt2, View.OnClickListener paramOnClickListener2)
  {
    this.au.setText(paramInt1);
    this.au.setOnClickListener(paramOnClickListener1);
    this.av.setText(paramInt2);
    this.av.setOnClickListener(paramOnClickListener2);
  }
  
  private void a(View paramView, float paramFloat, int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.weight = paramFloat;
    localLayoutParams.width = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(View paramView, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.gravity = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int j = 0;
    if (paramViewGroup == null) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramViewGroup.setVisibility(i);
      if (paramBoolean) {
        break;
      }
      int k = paramViewGroup.getChildCount();
      i = j;
      while (i < k)
      {
        Object localObject = paramViewGroup.getChildAt(i);
        if ((localObject instanceof EditText))
        {
          localObject = (EditText)localObject;
          ((EditText)localObject).setText(null);
          if ((localObject instanceof ValidatedEditText)) {
            ((ValidatedEditText)localObject).setValidity(aw.a);
          }
        }
        i += 1;
      }
      break;
    }
  }
  
  private void a(final b paramb, boolean paramBoolean)
  {
    final int i = 2131492911;
    this.aw = paramb;
    if (this.as == null) {
      return;
    }
    final Object localObject;
    float f;
    final int j;
    switch (15.b[paramb.ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
      k = 2131492871;
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(a.this, e.a);
        }
      };
      if (paramb == b.a)
      {
        localObject = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (paramb == b.b)
            {
              a.d(a.this).b();
              if (a.d(a.this).a()) {
                a.e(a.this).a(a.this.g(false));
              }
              return;
            }
            a.e(a.this).a(a.this.g(true));
          }
        };
        this.ag.b();
        f = 0.0F;
        int m = 1;
        j = i;
        paramb = local2;
        i = k;
        k = m;
        label113:
        if ((!paramBoolean) || (k != 0)) {
          break label259;
        }
      }
      break;
    }
    label259:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        a(i, paramb, j, (View.OnClickListener)localObject);
      }
      if (!paramBoolean) {
        break label265;
      }
      this.au.setOnClickListener(null);
      this.av.setOnClickListener(null);
      com.b.c.c.a(this.as).f(f).a(275L).a(Z).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          a.a(a.this, i, paramb, j, localObject);
        }
      });
      return;
      i = 2131492945;
      break;
      paramb = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(a.this, e.b);
        }
      };
      localObject = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(a.this, e.a);
        }
      };
      this.ag.a();
      f = this.at;
      j = 2131492945;
      i = 2131492911;
      k = 0;
      break label113;
    }
    label265:
    com.b.c.a.e(this.as, f);
  }
  
  private void a(final e parame)
  {
    ViewGroup localViewGroup = null;
    boolean bool2 = true;
    if (parame == this.ax)
    {
      if ((parame == e.a) && (this.ad.getCurrentItem() > 0)) {
        this.ad.a(0, false);
      }
      return;
    }
    e locale = this.ax;
    if (this.ax != null) {
      switch (15.a[this.ax.ordinal()])
      {
      default: 
        localObject = null;
        this.ax = parame;
        if ((localObject != null) && (s()))
        {
          bool1 = true;
          label114:
          switch (15.a[parame.ordinal()])
          {
          default: 
            label148:
            if ((!bool1) || (!com.ideashower.readitlater.util.a.l())) {
              break label502;
            }
            a(localViewGroup, true);
            localObject = new com.pocket.b.i().a((ViewGroup)localObject).b(localViewGroup).a(new com.pocket.b.j()
            {
              public void a()
              {
                a.a(a.this, localObject, false);
                if (parame == e.c)
                {
                  View localView = a.this.c(2131230734);
                  z.a(true, localView);
                  z.b(true, localView);
                }
              }
            });
            if (this.ao != null)
            {
              if (parame != e.a) {
                break label474;
              }
              ((com.pocket.b.i)localObject).b(new View[] { this.ao });
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      ((com.pocket.b.i)localObject).a();
      this.ag.a(0, 0.0F);
      this.az.b();
      z.b(false, this.ak);
      return;
      localObject = this.al;
      break;
      localObject = this.am;
      break;
      localObject = this.an;
      break;
      localObject = null;
      break;
      bool1 = false;
      break label114;
      this.ad.setVisibility(0);
      localViewGroup = this.al;
      z.a(this.ak, this.ap);
      a(b.c, bool1);
      this.ad.a(0, false);
      this.ay.setIdealFocusGroup(null);
      b(com.pocket.c.b.a);
      if (locale == e.c) {
        com.pocket.stats.c.l.b();
      }
      com.pocket.stats.c.a.a(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.cl));
      break label148;
      this.ad.setVisibility(8);
      z.a(this.ak, this.aq);
      if (parame == e.b)
      {
        localViewGroup = this.am;
        b(com.pocket.c.b.b);
        a(b.a, bool1);
      }
      for (;;)
      {
        this.ay.setIdealFocusGroup(localViewGroup);
        break;
        localViewGroup = this.an;
        b(com.pocket.c.b.a);
        a(b.b, bool1);
        com.pocket.stats.c.k.b();
      }
      label474:
      if (locale == e.a) {
        ((com.pocket.b.i)localObject).a(new View[] { this.ao });
      }
    }
    label502:
    a((ViewGroup)localObject, false);
    a(localViewGroup, true);
    final Object localObject = this.ao;
    if (parame == e.a) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      z.c((View)localObject, bool1);
      break;
    }
  }
  
  private void ab()
  {
    if (com.ideashower.readitlater.a.b.b()) {}
    while ((com.pocket.oauth.d.a(m(), true)) && (com.ideashower.readitlater.a.b.a()))
    {
      return;
      ((LockableViewPager)this.ad).g();
      z.c(this.ao);
      this.ao = null;
    }
    this.aA = true;
    z.c(c(2131230818));
    RilButton localRilButton = (RilButton)c(2131230819);
    localRilButton.setStyle(RilButton.g);
    localRilButton.setText(2131492945);
  }
  
  private void ac()
  {
    this.ac = new ProgressDialog(m());
    this.ac.setMessage(a(2131493108));
    this.ac.setCancelable(false);
    this.at = n().getDimensionPixelSize(2131296395);
    this.ap = new FrameLayout(m());
    this.aq = ((ViewGroup)c(2131230812));
    this.ak = ((ViewGroup)c(2131230813));
    this.am = ((ViewGroup)c(2131230823));
    this.an = ((ViewGroup)c(2131230821));
    this.al = ((ViewGroup)c(2131230817));
    this.ah = c(2131230815);
    this.ai = ((ImageView)c(2131230769));
    this.aj = c(2131230816);
    this.ar = ((LinearLayout)c(2131230763));
    this.ao = c(2131230829);
    this.ao.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.a(a.this).a(1, true);
      }
    });
    this.aF = ((TextView)c(2131230734));
    this.aG = ((TextView)c(2131230735));
    this.aH = ((TextView)c(2131230737));
    this.aK = ((TextView)c(2131230822));
    this.aI = ((TextView)c(2131230826));
    this.aJ = ((TextView)c(2131230827));
    this.aK.setTypeface(Typeface.DEFAULT);
    this.aJ.setTypeface(Typeface.DEFAULT);
    this.aC = ((GoogleSignInButton)c(2131230818));
    this.aC.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.a(a.this, com.pocket.c.b.a);
        a.b(a.this).c();
        com.pocket.stats.c.i.b();
      }
    });
    this.aE = c(2131230819);
    this.aE.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.a(a.this, e.c);
        if (a.c(a.this))
        {
          com.pocket.stats.c.g.b();
          return;
        }
        com.pocket.stats.c.h.b();
      }
    });
    c(2131230820).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.a(a.this, e.b);
        com.pocket.stats.c.j.b();
      }
    });
    this.aD = c(2131230824);
    this.aD.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.a(a.this, com.pocket.c.b.b);
        a.b(a.this).c();
        a.d(a.this).b();
      }
    });
    c(2131230828).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.ideashower.readitlater.a.g.a(a.this.m(), "http://getpocket.com/forgot");
      }
    });
    this.ad = ((ViewPager)c(2131230810));
    this.ae = new d(this, null);
    this.ad.setAdapter(this.ae);
    this.af = new c(this, null);
    this.ad.setOnPageChangeListener(this.af);
    this.ag = new f(this, null);
    this.as = ((StyledToolbar)c(2131230830));
    this.as.setIsTopToolbar(false);
    this.au = ((RilButton)c(2131230752));
    this.av = ((RilButton)c(2131230753));
    this.ay = ((AutoScrollOnFocusScrollView)c(2131230814));
    this.ay.a(0, this.at);
    this.az = new au(this, 2131230804);
    this.az.a(2131230734, false, new av()
    {
      public aw a(ValidatedEditText paramAnonymousValidatedEditText, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        if (!org.apache.a.c.k.c(paramAnonymousString)) {}
        for (int i = 1; i != 0; i = 0) {
          return aw.a;
        }
        if (paramAnonymousBoolean) {
          return aw.c;
        }
        a.d(a.this).a(2131493432);
        return aw.b;
      }
    });
    this.az.a(2131230737, true, new com.pocket.widget.as()
    {
      public aw a(ValidatedEditText paramAnonymousValidatedEditText, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        boolean bool = org.apache.a.c.k.c(paramAnonymousString);
        if (paramAnonymousBoolean)
        {
          if (bool) {
            return aw.c;
          }
          return super.a(paramAnonymousValidatedEditText, paramAnonymousString, paramAnonymousBoolean);
        }
        if (!bool) {
          return aw.a;
        }
        a.d(a.this).a(2131493431);
        return aw.b;
      }
      
      public void a(ValidatedEditText paramAnonymousValidatedEditText, String paramAnonymousString, final at paramAnonymousat)
      {
        ao.a(paramAnonymousString, new ap()
        {
          public void a()
          {
            paramAnonymousat.a(aw.a);
          }
          
          public void a(String paramAnonymous2String)
          {
            if (paramAnonymous2String != null)
            {
              if (paramAnonymousat.a(aw.b)) {
                a.d(a.this).a(paramAnonymous2String);
              }
              return;
            }
            paramAnonymousat.a(aw.c);
          }
        });
      }
    });
    this.az.a(2131230822, true, com.ideashower.readitlater.a.as.a(this.az));
    this.aM = ((DropDownMessageView)c(2131230832));
  }
  
  private void ad()
  {
    final Object localObject = new com.pocket.oauth.b()
    {
      private void a(com.pocket.c.a paramAnonymousa)
      {
        a.b(a.this, false);
        if ((paramAnonymousa.n() == com.pocket.c.b.a) && ((paramAnonymousa instanceof com.pocket.c.u)) && (((com.pocket.c.u)paramAnonymousa).w())) {}
        for (com.pocket.c.b localb = com.pocket.c.b.b; paramAnonymousa.u(); localb = paramAnonymousa.n())
        {
          a.this.b(paramAnonymousa, localb);
          return;
        }
        a.this.a(paramAnonymousa, localb);
      }
      
      public void a(final com.pocket.c.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          v.a((SplashActivity)a.this.m());
          new com.ideashower.readitlater.g.m()
          {
            protected void a()
            {
              android.support.v4.app.f localf = a.this.m();
              if (!com.ideashower.readitlater.util.j.i()) {}
              for (boolean bool = true;; bool = false)
              {
                com.pocket.gsf.d.a(localf, bool);
                v.a(1, com.pocket.gsf.d.a());
                if (com.pocket.gsf.d.a() <= 0) {
                  v.k();
                }
                return;
              }
            }
            
            protected void a(boolean paramAnonymous2Boolean, Throwable paramAnonymous2Throwable)
            {
              a.7.a(a.7.this, paramAnonymousa);
            }
          }.h();
          return;
        }
        a(paramAnonymousa);
      }
      
      public void a(com.pocket.oauth.a paramAnonymousa)
      {
        a.a(a.this, true);
        a.b(a.this, true);
      }
      
      public boolean a()
      {
        return a.f(a.this).isShowing();
      }
      
      public void b()
      {
        a.b(a.this, false);
      }
    };
    this.ab = new com.pocket.oauth.c(m(), (com.pocket.oauth.b)localObject);
    this.aa = new com.pocket.oauth.d(m(), new h()
    {
      public void a(com.google.android.gms.common.a paramAnonymousa)
      {
        if (paramAnonymousa.a()) {}
        do
        {
          do
          {
            do
            {
              do
              {
                try
                {
                  a.b(a.this).a(paramAnonymousa, a.this.m(), 3242);
                  return;
                }
                catch (IntentSender.SendIntentException localSendIntentException)
                {
                  com.ideashower.readitlater.util.e.a(localSendIntentException);
                }
                a.b(a.this, false);
                switch (paramAnonymousa.c())
                {
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                default: 
                  d();
                  return;
                case 1: 
                case 9: 
                case 10: 
                case 11: 
                  new AlertDialog.Builder(a.this.m()).setTitle(a.a(a.this.Y)).setMessage(2131493443).setNeutralButton(2131492924, null).show();
                }
              } while (a.this.Y != com.pocket.c.b.a);
              com.pocket.stats.c.q.b();
              return;
              com.google.android.gms.common.g.a(paramAnonymousa.c(), a.this.m(), 3242).show();
            } while (a.this.Y != com.pocket.c.b.a);
            com.pocket.stats.c.r.b();
            return;
            new AlertDialog.Builder(a.this.m()).setTitle(a.a(a.this.Y)).setMessage(2131493441).setNeutralButton(2131492871, null).setPositiveButton(2131492958, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                com.ideashower.readitlater.a.g.a(a.this.m(), "https://play.google.com/store/apps/details?id=com.google.android.gms");
              }
            }).show();
          } while (a.this.Y != com.pocket.c.b.a);
          com.pocket.stats.c.r.b();
          return;
          new AlertDialog.Builder(a.this.m()).setTitle(a.a(a.this.Y)).setMessage(2131493440).setNeutralButton(2131492924, null).show();
        } while (a.this.Y != com.pocket.c.b.a);
        com.pocket.stats.c.r.b();
      }
      
      public void a(com.pocket.c.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        localObject.a(paramAnonymousa, paramAnonymousBoolean);
      }
      
      public void a(com.pocket.oauth.a paramAnonymousa)
      {
        localObject.a(paramAnonymousa);
      }
      
      public boolean a()
      {
        return localObject.a();
      }
      
      public boolean a(int paramAnonymousInt)
      {
        if (a.this.Y == com.pocket.c.b.a) {
          com.pocket.stats.c.q.b();
        }
        return false;
      }
      
      public boolean a(Intent paramAnonymousIntent)
      {
        if (a.this.Y == com.pocket.c.b.a) {
          com.pocket.stats.c.r.b();
        }
        a.this.a(paramAnonymousIntent);
        return true;
      }
      
      public void b()
      {
        localObject.b();
      }
      
      public boolean c()
      {
        a.a(a.this, e.b);
        return true;
      }
      
      public void d()
      {
        a.b(a.this, false);
        new AlertDialog.Builder(a.this.m()).setTitle(a.a(a.this.Y)).setMessage(2131493442).setNeutralButton(2131492924, null).show();
        if (a.this.Y == com.pocket.c.b.a) {
          com.pocket.stats.c.s.b();
        }
      }
    });
    localObject = ae();
    if (localObject != null)
    {
      this.ab.a((String)localObject);
      this.aa.a((String)localObject);
    }
  }
  
  private String ae()
  {
    Bundle localBundle = m().getIntent().getBundleExtra("com.pocket.oauth.extra.app_auth");
    if (localBundle != null) {
      return localBundle.getString("com.pocket.oauth.extra.request_token");
    }
    return null;
  }
  
  private void af()
  {
    if ((n().getConfiguration().orientation == 2) && (com.ideashower.readitlater.util.j.f())) {}
    for (boolean bool = true; bool == this.aB; bool = false) {
      return;
    }
    this.aB = bool;
    if (bool)
    {
      this.ar.setOrientation(0);
      this.ai.setImageResource(2130837841);
      a(this.ah, 1.0F, 0, 16);
      a(this.ai, 0.0F, -2, 16);
      a(this.aj, 1.0F, 0, 16);
      a(this.al, 17);
      a(this.am, 17);
      a(this.an, 17);
      z.a((View)this.ar.getParent(), 0);
    }
    for (;;)
    {
      if (q.b(m()).b(true) < 500)
      {
        int j = n().getDimensionPixelSize(2131296315);
        int i = j;
        if (bool) {
          i = j - com.ideashower.readitlater.util.j.a(30.0F);
        }
        z.b(i, new View[] { this.aC, this.aE, this.aF, this.aG, this.aH, this.aK, this.aD, this.aI, this.aJ });
      }
      this.ae.d();
      return;
      this.ar.setOrientation(1);
      this.ai.setImageResource(2130837840);
      a(this.ah, 0.0F, -2, 1);
      a(this.ai, 0.0F, -2, 1);
      a(this.aj, 0.0F, -2, 1);
      a(this.al, 1);
      a(this.am, 1);
      a(this.an, 1);
      z.a((View)this.ar.getParent(), this.at);
    }
  }
  
  private void ag()
  {
    if (!e()) {}
    do
    {
      return;
      if (this.aN == null) {
        this.aN = new com.pocket.c.m()
        {
          public void a()
          {
            a.c(a.this, false);
          }
          
          public void a(String paramAnonymousString)
          {
            a.c(a.this, false);
            a.d(a.this, true);
            a.a(a.this, paramAnonymousString);
            if (paramAnonymousString != null) {
              a.m(a.this);
            }
          }
        };
      }
    } while ((this.aP) || (this.aO));
    this.aP = true;
    new com.pocket.c.l("splash", this.aN).h();
  }
  
  private void ah()
  {
    if (this.aQ == null) {}
    while ((Q()) || (this.aL)) {
      return;
    }
    this.aM.a(this.aQ, false);
  }
  
  private void b(com.pocket.c.b paramb)
  {
    this.Y = paramb;
    this.aa.a(paramb);
    this.ab.a(paramb);
  }
  
  private String e(int paramInt)
  {
    return ((EditText)c(paramInt)).getText().toString();
  }
  
  private void h(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.ac.isShowing())) {
      this.ac.show();
    }
    while ((paramBoolean) || (!this.ac.isShowing())) {
      return;
    }
    this.ac.dismiss();
  }
  
  public String K()
  {
    return "login";
  }
  
  public boolean W()
  {
    if (this.ax == e.a)
    {
      if (this.ad.getCurrentItem() > 0)
      {
        this.ad.a(this.ad.getCurrentItem() - 1, true);
        return true;
      }
    }
    else
    {
      a(e.a);
      return true;
    }
    return super.W();
  }
  
  protected void a(com.pocket.c.a parama, final com.pocket.c.b paramb)
  {
    if (((parama instanceof com.pocket.c.u)) && (((com.pocket.c.u)parama).y()))
    {
      this.aa.a(false);
      paramb = a(2131493427, new Object[] { parama.f_(), com.ideashower.readitlater.util.u.a(2131492913) });
      Toast.makeText(m(), paramb, 1).show();
    }
    for (;;)
    {
      if (this.Y == com.pocket.c.b.a)
      {
        if (!(parama instanceof t)) {
          break;
        }
        com.pocket.stats.c.n.b();
      }
      return;
      ErrorReport localErrorReport = parama.t();
      if (((parama instanceof com.pocket.c.u)) && (parama.v())) {
        if ((!((com.pocket.c.u)parama).x()) || (this.Y != com.pocket.c.b.b)) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label245;
        }
        paramb = com.ideashower.readitlater.util.u.a(parama.f_());
        new AlertDialog.Builder(m()).setTitle(d(2131493438)).setMessage(a(2131493437, new Object[] { paramb, paramb })).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            a.b(a.this).a(false);
          }
        }).setPositiveButton(2131492965, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            a.a(a.this, com.pocket.c.b.a);
            a.b(a.this).c();
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            a.b(a.this).a(false);
          }
        }).show();
        break;
        this.aa.a(false);
      }
      label245:
      new AlertDialog.Builder(m()).setTitle(a(this.Y)).setMessage(localErrorReport.a(com.ideashower.readitlater.a.g.a(2131493178))).setNegativeButton(d(2131492898), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          com.ideashower.readitlater.util.k.a(paramb, a.this.m());
        }
      }).setPositiveButton(2131492924, null).show();
    }
    com.pocket.stats.c.p.b();
  }
  
  protected void b(com.pocket.c.a parama, com.pocket.c.b paramb)
  {
    if (parama.r() != null) {
      PremiumGiftMessage.a(parama.r());
    }
    if ((parama instanceof com.pocket.c.u)) {
      com.ideashower.readitlater.a.g.a(paramb, parama.p(), parama.o(), (SplashActivity)m(), ((com.pocket.c.u)parama).z(), parama.q());
    }
    for (;;)
    {
      z.b(false, this.ak);
      if (this.Y == com.pocket.c.b.a)
      {
        if (!(parama instanceof com.pocket.c.u)) {
          break;
        }
        com.pocket.stats.c.o.b();
      }
      return;
      com.ideashower.readitlater.a.g.a(paramb, parama.p(), parama.o(), (SplashActivity)m());
    }
    com.pocket.stats.c.m.b();
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903055, paramViewGroup, false);
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3242) {
      this.aa.a(paramInt2, paramIntent);
    }
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    ad();
    ac();
    ab();
    if (paramBundle != null)
    {
      a(e.a("stateScreen", paramBundle));
      this.aa.c(paramBundle);
    }
    for (;;)
    {
      af();
      ag();
      return;
      a(e.a);
    }
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    e.a("stateScreen", this.ax, paramBundle);
    this.aa.b(paramBundle);
  }
  
  protected Bundle g(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      com.pocket.oauth.c.a(localBundle, e(2131230826));
      com.pocket.oauth.c.e(localBundle, e(2131230827));
      return localBundle;
    }
    com.pocket.oauth.c.c(localBundle, e(2131230734));
    com.pocket.oauth.c.d(localBundle, e(2131230735));
    com.pocket.oauth.c.b(localBundle, e(2131230737));
    com.pocket.oauth.c.e(localBundle, e(2131230822));
    return localBundle;
  }
  
  public void g()
  {
    super.g();
    this.aa.a();
  }
  
  public void h()
  {
    super.h();
    this.aa.b();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    af();
    f.a(this.ag);
  }
  
  public void w()
  {
    super.w();
    if (c() != null)
    {
      com.pocket.p.k.a(this);
      c().getWindow().clearFlags(131080);
      c().getWindow().setSoftInputMode(4);
    }
  }
  
  public void x()
  {
    super.x();
    this.az.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */