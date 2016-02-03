package com.ideashower.readitlater.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.q;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.u;
import com.ideashower.readitlater.views.x;
import com.pocket.i.a.i;
import com.pocket.p.l;
import com.pocket.widget.CustomScrollView;
import com.pocket.widget.premium.PremiumIconHeart;
import com.pocket.widget.premium.PremiumIntroView;
import com.pocket.widget.premium.PremiumPurchasedView;
import com.pocket.widget.premium.PremiumUpgradeBlockView;
import com.pocket.widget.premium.PremiumUpgradeView;
import com.pocket.widget.premium.PremiumUpgradeWebView;
import com.pocket.widget.premium.b;
import java.util.ArrayList;
import java.util.Iterator;

public class al
  extends f
  implements com.pocket.b.h
{
  private static final boolean Z;
  protected boolean Y;
  private final ArrayList aa = new ArrayList();
  private final int[] ab = new int[3];
  private com.pocket.b.g ac;
  private ValueAnimator ad;
  private boolean ae;
  private boolean af;
  private boolean ag;
  private PremiumIntroView ah;
  private PremiumUpgradeView ai;
  private PremiumUpgradeWebView aj;
  private PremiumPurchasedView ak;
  private View al;
  private View am;
  private b an;
  private b ao;
  private b ap;
  private float aq;
  private float ar;
  private float as;
  private int at;
  private boolean au;
  private StyledToolbar av;
  private CustomScrollView aw;
  private boolean ax = false;
  
  static
  {
    if ((com.ideashower.readitlater.util.a.l()) && (!com.ideashower.readitlater.a.g.x())) {}
    for (boolean bool = true;; bool = false)
    {
      Z = bool;
      return;
    }
  }
  
  public static l Y()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  private void Z()
  {
    if ((Z) && (!this.ae) && (this.af))
    {
      this.ac.a(this);
      ab();
    }
  }
  
  public static al a(int paramInt, String paramString, boolean paramBoolean)
  {
    al localal = new al();
    Bundle localBundle = new Bundle();
    localBundle.putInt("stage", paramInt);
    localBundle.putString("source", paramString);
    localBundle.putBoolean("renew", paramBoolean);
    localal.g(localBundle);
    return localal;
  }
  
  public static void a(android.support.v4.app.f paramf, int paramInt, String paramString)
  {
    a(paramf, paramInt, paramString, false);
  }
  
  public static void a(android.support.v4.app.f paramf, int paramInt, String paramString, boolean paramBoolean)
  {
    if (Y() == l.a)
    {
      com.pocket.p.k.a(a(paramInt, paramString, paramBoolean), paramf);
      return;
    }
    PremiumPurchaseFlowActivity.a(paramf, paramInt, paramString, paramBoolean);
  }
  
  @TargetApi(14)
  private void a(View paramView, PremiumUpgradeBlockView paramPremiumUpgradeBlockView, ViewGroup paramViewGroup)
  {
    int[] arrayOfInt = new int[2];
    z.a(paramViewGroup, paramPremiumUpgradeBlockView.getImageView(), arrayOfInt);
    paramView.setTranslationX(arrayOfInt[0]);
    paramView.setTranslationY(arrayOfInt[1]);
  }
  
  private static void a(View paramView, PremiumUpgradeBlockView paramPremiumUpgradeBlockView, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramPremiumUpgradeBlockView = paramPremiumUpgradeBlockView.getImageView();
    int[] arrayOfInt = new int[2];
    z.a(paramViewGroup, paramPremiumUpgradeBlockView, arrayOfInt);
    paramFloat1 = arrayOfInt[0];
    float f1 = paramPremiumUpgradeBlockView.getWidth() / 2.0F;
    float f2 = arrayOfInt[1];
    float f3 = paramPremiumUpgradeBlockView.getHeight() / 2.0F;
    paramView.setTag(new PointF(paramFloat1 + f1 - (paramView.getLeft() + paramView.getWidth() / 2.0F) + paramFloat2, f3 + f2 - (paramView.getTop() + paramView.getHeight() / 2.0F) + paramFloat3));
  }
  
  @TargetApi(14)
  private void a(ImageView paramImageView, PremiumUpgradeBlockView paramPremiumUpgradeBlockView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    z.a(true, new View[] { paramImageView });
    paramImageView.setImageDrawable(new com.pocket.widget.premium.a());
    a(paramImageView, paramPremiumUpgradeBlockView, paramViewGroup);
    if (paramBoolean)
    {
      paramPremiumUpgradeBlockView = q.b(m());
      float f = Math.max(paramPremiumUpgradeBlockView.b(false), paramPremiumUpgradeBlockView.a(false)) / j.a(60.0F);
      paramImageView.setScaleX(f);
      paramImageView.setScaleY(f);
      paramImageView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(600L).setStartDelay(700L).setInterpolator(com.pocket.i.a.e.a).setListener(new am(this, 2, null));
    }
  }
  
  private void a(PremiumUpgradeBlockView paramPremiumUpgradeBlockView, b paramb, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ImageView localImageView = paramPremiumUpgradeBlockView.getImageView();
    localImageView.setImageDrawable(new com.pocket.widget.premium.a());
    localImageView.setVisibility(0);
    z.a(paramb, (ViewGroup)paramPremiumUpgradeBlockView.findViewById(2131230940));
    paramPremiumUpgradeBlockView = new RelativeLayout.LayoutParams(-2, -2);
    paramPremiumUpgradeBlockView.addRule(15);
    paramb.setLayoutParams(paramPremiumUpgradeBlockView);
    if (paramFloat1 != 1.0F)
    {
      com.b.c.a.b(paramb, paramFloat1);
      com.b.c.a.c(paramb, paramFloat1);
    }
    com.b.c.a.d(paramb, paramFloat2);
    com.b.c.a.e(paramb, paramFloat3);
  }
  
  @TargetApi(14)
  private void a(b paramb, long paramLong1, long paramLong2, float paramFloat)
  {
    PointF localPointF = (PointF)paramb.getTag();
    if (paramLong2 > 0L)
    {
      paramb.animate().setStartDelay(paramLong1).setDuration(paramLong2).setInterpolator(com.pocket.i.a.e.g).translationX(localPointF.x).translationY(localPointF.y).scaleX(paramFloat).scaleY(paramFloat).setListener(null).setListener(new am(this, 2, null));
      paramb.a(paramLong2 / 2L);
      return;
    }
    paramb.setTranslationX(localPointF.x);
    paramb.setTranslationY(localPointF.y);
    paramb.setScaleX(paramFloat);
    paramb.setScaleY(paramFloat);
    paramb.b();
  }
  
  private void aa()
  {
    if (this.at == 2) {
      com.pocket.stats.d.g.a(null, l().getString("source"));
    }
  }
  
  @TargetApi(14)
  private void ab()
  {
    final float f = j.a(2.1F);
    final ValueAnimator localValueAnimator1 = ObjectAnimator.ofFloat(new float[] { -f, f });
    this.ad = localValueAnimator1;
    ValueAnimator.AnimatorUpdateListener local6 = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (al.b(al.this) != localValueAnimator1) {}
        for (;;)
        {
          return;
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = al.c(al.this).iterator();
          while (paramAnonymousValueAnimator.hasNext()) {
            ((b)paramAnonymousValueAnimator.next()).a(f, f);
          }
        }
      }
    };
    this.ad.setInterpolator(new AccelerateDecelerateInterpolator());
    this.ad.setDuration(2557L);
    this.ad.setRepeatCount(-1);
    this.ad.setRepeatMode(2);
    this.ad.addUpdateListener(local6);
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofFloat(new float[] { 0.0F, -f });
    localValueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator2.setDuration(1100L);
    localValueAnimator2.addUpdateListener(local6);
    localValueAnimator2.addListener(new com.pocket.b.a()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (al.b(al.this) != localValueAnimator1) {
          return;
        }
        al.b(al.this).start();
      }
    });
    localValueAnimator2.start();
  }
  
  @TargetApi(14)
  private void ac()
  {
    if (this.ad != null) {
      this.ad.cancel();
    }
    this.ad = null;
    ad();
  }
  
  private void ad()
  {
    if (Z)
    {
      Iterator localIterator = this.aa.iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).a();
      }
    }
  }
  
  private void ae()
  {
    this.at = 1;
    com.pocket.stats.d.d.a(null, "updated");
    Object localObject = c(2131230863);
    ((View)localObject).setVisibility(0);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        al.this.P();
      }
    });
    this.ah.a(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        al.d(al.this);
      }
    });
    this.ah.findViewById(2131230899).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        al.this.P();
      }
    });
    localObject = (RelativeLayout.LayoutParams)this.ap.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(8, this.ah.getId());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = n().getDimensionPixelSize(2131296333);
    this.ap.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((this.au) || (!Z))
    {
      ag();
      return;
    }
    af();
  }
  
  @TargetApi(14)
  private void af()
  {
    this.ae = true;
    com.pocket.widget.premium.d local11 = new com.pocket.widget.premium.d()
    {
      private int b = 3;
      
      public void a()
      {
        this.b -= 1;
        if (this.b <= 0) {
          al.e(al.this);
        }
      }
    };
    this.an.a(local11);
    this.ap.a(local11);
    this.ao.a(local11);
  }
  
  private void ag()
  {
    this.ae = false;
    ((x)c(2131230850)).setOnResizeListener(new u()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        al.f(al.this).b();
        al.g(al.this);
      }
    });
    Z();
  }
  
  private void ah()
  {
    if (this.at == 0) {
      this.av.setTitle(2131493519);
    }
    for (boolean bool = false;; bool = Z)
    {
      this.at = 2;
      String str = l().getString("source");
      com.pocket.stats.d.e.a(null, str);
      this.ai.a(m(), str, new com.pocket.billing.f()
      {
        public void a() {}
        
        public void a(com.pocket.billing.g paramAnonymousg)
        {
          boolean bool2 = true;
          Object localObject = al.this;
          if ((paramAnonymousg == com.pocket.billing.g.a) || (paramAnonymousg == com.pocket.billing.g.c) || (paramAnonymousg == com.pocket.billing.g.b))
          {
            bool1 = true;
            ((al)localObject).Y = bool1;
            z.c(al.i(al.this), al.this.Y);
            localObject = al.j(al.this);
            if (paramAnonymousg != com.pocket.billing.g.c) {
              break label84;
            }
          }
          label84:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            z.c((View)localObject, bool1);
            return;
            bool1 = false;
            break;
          }
        }
        
        public void a(com.pocket.billing.google.g paramAnonymousg) {}
        
        public void a(boolean paramAnonymousBoolean) {}
        
        public void b() {}
        
        public void c()
        {
          al.a(al.this, true);
        }
        
        public void d()
        {
          al.h(al.this);
        }
        
        public void e()
        {
          al.this.P();
        }
      });
      if (!bool) {
        break;
      }
      this.ae = true;
      this.ac.c();
      ac();
      c(this.ah);
      this.ah.a();
      this.ai.setVisibility(4);
      this.ai.getHandler().post(new Runnable()
      {
        public void run()
        {
          al.this.c(2131230850).setBackgroundColor(-1);
          al.k(al.this).setVisibility(0);
          al.b(al.this, true);
          RelativeLayout localRelativeLayout = (RelativeLayout)al.this.c(2131230852);
          al.a(al.this, al.k(al.this).getCircleArchive(), al.k(al.this).getDetailsArchive(), localRelativeLayout, true);
          al.a(al.this, al.k(al.this).getCircleSearch(), al.k(al.this).getDetailsSearch(), localRelativeLayout, true);
          al.a(al.this, al.k(al.this).getCircleTags(), al.k(al.this).getDetailsTags(), localRelativeLayout, true);
        }
      });
      return;
    }
    c(2131230850).setBackgroundColor(-1);
    z.a(false, new View[] { this.ah });
    this.ai.setVisibility(0);
    a(this.ai.getDetailsArchive(), this.an, this.aq, j.a(24.0F, 17.25F), j.a(1.3F, 1.0F));
    a(this.ai.getDetailsSearch(), this.ap, this.ar, j.a(20.3F, 10.0F), j.a(8.0F, 8.75F));
    a(this.ai.getDetailsTags(), this.ao, this.as, j.a(18.0F, 7.0F), j.a(4.0F));
    this.ai.getDetailsArchive().getImageView().setImageDrawable(new com.pocket.widget.premium.a());
    this.ai.getDetailsSearch().getImageView().setImageDrawable(new com.pocket.widget.premium.a());
    this.ai.getDetailsTags().getImageView().setImageDrawable(new com.pocket.widget.premium.a());
    i(false);
  }
  
  private void ai()
  {
    if (this.at == 0) {
      this.av.setTitle(2131493518);
    }
    this.at = 3;
    this.ai.setVisibility(8);
    this.an.setVisibility(8);
    this.ap.setVisibility(8);
    this.ao.setVisibility(8);
    ((x)c(2131230850)).setOnResizeListener(null);
    this.ai.setOnResizeListener(null);
    this.ac.c();
    ac();
    String str2 = a(2131493590);
    String str3;
    if (l().getBoolean("renew", false))
    {
      str1 = a(2131493588);
      str3 = a(2131493589);
    }
    String str4;
    for (String str1 = str1 + "\n\n" + str3;; str1 = str1 + "\n\n" + str3 + "\n\n" + str4)
    {
      this.ak.a(str2, str1, null, null);
      this.aa.add(this.ak.getHeartIconSet());
      c(2131230850).setBackgroundColor(i.c);
      if (!Z) {
        break;
      }
      this.ae = true;
      this.ak.getHeartIconSet().a(new com.pocket.widget.premium.d()
      {
        public void a()
        {
          al.m(al.this);
        }
      });
      return;
      str1 = a(2131493587);
      str3 = a(2131493591);
      str4 = a(2131493589);
    }
    aj();
  }
  
  private void aj()
  {
    this.ae = false;
    Z();
  }
  
  private void ak()
  {
    if (!this.ax)
    {
      com.pocket.stats.d.f.a(null, l().getString("source"));
      this.ax = true;
    }
  }
  
  @TargetApi(14)
  private void c(View paramView)
  {
    paramView.animate().setDuration(333L).setInterpolator(com.pocket.i.a.e.b).alpha(0.0F).setListener(new am(this, 2, null));
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aj.a(m(), new com.pocket.widget.premium.h()
      {
        public void a()
        {
          al.a(al.this, false);
          al.h(al.this);
        }
        
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            al.l(al.this).d();
            return;
          }
          al.l(al.this).e();
        }
        
        public void b()
        {
          al.a(al.this, false);
        }
      });
      c(2131230814).setVisibility(4);
      this.aj.setVisibility(0);
      this.ac.c();
      ac();
      return;
    }
    this.av.e();
    c(2131230814).setVisibility(0);
    this.aj.setVisibility(8);
    Z();
  }
  
  private void h(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)c(2131230852);
    PremiumUpgradeBlockView localPremiumUpgradeBlockView1 = this.ai.getDetailsArchive();
    PremiumUpgradeBlockView localPremiumUpgradeBlockView2 = this.ai.getDetailsSearch();
    PremiumUpgradeBlockView localPremiumUpgradeBlockView3 = this.ai.getDetailsTags();
    float f = this.aq;
    if (paramBoolean)
    {
      l = 1000L;
      a(this.an, localPremiumUpgradeBlockView1, localRelativeLayout, f, 0.0F, 0.0F);
      a(this.an, 0L, l, f);
      f = this.ar;
      if (!paramBoolean) {
        break label192;
      }
      l = 1000L;
      label90:
      a(this.ap, localPremiumUpgradeBlockView2, localRelativeLayout, f, j.a(4.0F), j.a(8.5F));
      a(this.ap, 100L, l, f);
      f = this.as;
      if (!paramBoolean) {
        break label197;
      }
    }
    label192:
    label197:
    for (long l = 1000L;; l = 0L)
    {
      a(this.ao, localPremiumUpgradeBlockView3, localRelativeLayout, f, -j.a(5.0F), j.a(3.0F));
      a(this.ao, 100L + 100L, l, f);
      return;
      l = 0L;
      break;
      l = 0L;
      break label90;
    }
  }
  
  private void i(final boolean paramBoolean)
  {
    this.ae = false;
    ((x)c(2131230850)).setOnResizeListener(null);
    this.ai.setOnResizeListener(new u()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        com.ideashower.readitlater.a.g.o().post(new Runnable()
        {
          public void run()
          {
            al.f(al.this).b();
            al.g(al.this);
            if (al.4.this.a)
            {
              RelativeLayout localRelativeLayout = (RelativeLayout)al.this.c(2131230852);
              al.a(al.this, al.k(al.this).getCircleArchive(), al.k(al.this).getDetailsArchive(), localRelativeLayout);
              al.a(al.this, al.k(al.this).getCircleSearch(), al.k(al.this).getDetailsSearch(), localRelativeLayout);
              al.a(al.this, al.k(al.this).getCircleTags(), al.k(al.this).getDetailsTags(), localRelativeLayout);
              al.b(al.this, false);
            }
          }
        });
      }
    });
    Z();
  }
  
  public String K()
  {
    switch (this.at)
    {
    case 2: 
    default: 
      return "upgrade";
    case 1: 
      return "whats_new";
    }
    return "confirmation";
  }
  
  public void O()
  {
    if ((this.at == 2) && (this.aj.getVisibility() == 0))
    {
      g(false);
      return;
    }
    super.O();
  }
  
  public void P()
  {
    aa();
    super.P();
  }
  
  public boolean W()
  {
    boolean bool1;
    if ((this.at == 2) && (this.aj.getVisibility() == 0))
    {
      g(false);
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = super.W();
      bool1 = bool2;
    } while (bool2);
    aa();
    return bool2;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    Iterator localIterator = this.aa.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramArrayOfFloat);
    }
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.b(paramInt1, paramInt2, paramIntent);
    this.ai.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.ag = j.g();
    if (this.ag)
    {
      f = 0.83F;
      this.aq = f;
      if (!this.ag) {
        break label79;
      }
      f = 0.73F;
      label37:
      this.ar = f;
      if (!this.ag) {
        break label87;
      }
    }
    label79:
    label87:
    for (float f = 0.76F;; f = 1.0F)
    {
      this.as = f;
      return paramLayoutInflater.inflate(2130903059, paramViewGroup, false);
      f = 1.04F;
      break;
      f = 0.92F;
      break label37;
    }
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.av = ((StyledToolbar)c(2131230742));
    this.av.a(true, this);
    this.av.setIsRainbowified(true);
    this.aw = ((CustomScrollView)c(2131230814));
    this.ah = ((PremiumIntroView)c(2131230854));
    this.ai = ((PremiumUpgradeView)c(2131230853));
    this.aj = ((PremiumUpgradeWebView)c(2131230859));
    this.ak = ((PremiumPurchasedView)c(2131230855));
    this.al = c(2131230860);
    this.am = this.al.findViewById(2131230862);
    this.an = ((b)c(2131230856));
    this.ao = ((b)c(2131230857));
    this.ap = ((b)c(2131230806));
    this.aa.add(this.an);
    this.aa.add(this.ao);
    this.aa.add(this.ap);
    this.ac = new com.pocket.b.g(m());
    this.ac.a(n().getDimensionPixelSize(2131296360));
    int i;
    if (paramBundle != null)
    {
      this.au = true;
      int j = paramBundle.getInt("stage");
      i = j;
      if (paramBundle.getBoolean("progress", false))
      {
        this.Y = true;
        z.c(this.al, true);
        z.c(this.am, true);
        i = j;
      }
      switch (i)
      {
      default: 
        com.ideashower.readitlater.util.e.a("unknown stage " + i);
        ah();
      }
    }
    for (;;)
    {
      this.aw.setOnScrollListener(new com.pocket.widget.e()
      {
        public void a(CustomScrollView paramAnonymousCustomScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          if (paramAnonymousCustomScrollView.getHeight() + paramAnonymousInt2 >= paramAnonymousCustomScrollView.getChildAt(0).getHeight()) {
            al.a(al.this);
          }
        }
      });
      return;
      i = l().getInt("stage");
      break;
      ae();
      continue;
      ah();
      continue;
      ai();
    }
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putInt("stage", this.at);
    paramBundle.putBoolean("progress", this.Y);
  }
  
  public void g()
  {
    super.g();
    this.af = true;
    Z();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.ac.a();
    ad();
  }
  
  public void w()
  {
    super.w();
    com.pocket.p.k.a(this);
  }
  
  public void x()
  {
    super.x();
    this.af = false;
    if (Z)
    {
      this.ac.c();
      ac();
    }
  }
  
  public void y()
  {
    super.y();
    this.ai.f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */