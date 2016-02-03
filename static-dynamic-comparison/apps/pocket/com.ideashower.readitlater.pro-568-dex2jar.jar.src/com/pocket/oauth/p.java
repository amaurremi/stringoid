package com.pocket.oauth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.b.c.c;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a.l;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.m;
import com.ideashower.readitlater.views.ThemedTextView;
import com.ideashower.readitlater.views.UrlImageView;
import com.pocket.c.x;
import com.pocket.c.z;
import com.pocket.text.CustomTypefaceSpan;
import com.pocket.widget.RainbowProgressCircleView;
import org.apache.a.c.k;

public class p
  extends com.ideashower.readitlater.activity.f
  implements x, z
{
  private String Y;
  private TextView Z;
  private TextView aa;
  private TextView ab;
  private UrlImageView ac;
  private TextView ad;
  private LinearLayout ae;
  private TextView af;
  private LinearLayout ag;
  private View ah;
  private View ai;
  private String aj;
  private View ak;
  private View al;
  private l am;
  private TextView an;
  private View ao;
  private RainbowProgressCircleView ap;
  private long aq;
  
  public static p Y()
  {
    return new p();
  }
  
  private void Z()
  {
    final Runnable local4 = new Runnable()
    {
      public void run()
      {
        p.a(p.this, 1);
      }
    };
    long l = 2000L - m.a(this.aq);
    if (l <= 0L)
    {
      g.o().post(local4);
      return;
    }
    g.o().postDelayed(new Runnable()
    {
      public void run()
      {
        g.o().post(local4);
      }
    }, l);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ThemedTextView localThemedTextView = new ThemedTextView(m());
    localThemedTextView.setText("• " + a(paramInt));
    i.a(i.c, localThemedTextView);
    localThemedTextView.setTextSize(0, n().getDimension(2131296322));
    if (paramBoolean) {}
    for (ColorStateList localColorStateList = this.ad.getTextColors();; localColorStateList = this.af.getTextColors())
    {
      localThemedTextView.setTextColor(localColorStateList);
      if (!paramBoolean) {
        break;
      }
      this.ae.addView(localThemedTextView);
      return;
    }
    this.ag.addView(localThemedTextView);
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = a(paramInt1) + " ";
    Object localObject = a(paramInt2);
    localObject = new SpannableStringBuilder(str + (String)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramInt3), str.length(), ((SpannableStringBuilder)localObject).length() - 1, 18);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private boolean aa()
  {
    if (!as.l()) {
      return false;
    }
    String str = String.format(a(2131493542), new Object[] { as.g() });
    Object localObject = a(2131493544);
    localObject = new SpannableStringBuilder(str + (String)localObject);
    int i = str.indexOf(as.g());
    int j = as.g().length();
    ((SpannableStringBuilder)localObject).setSpan(new CustomTypefaceSpan("", i.a(i.a)), i, j + i, 18);
    this.Z.setText((CharSequence)localObject);
    return true;
  }
  
  private void e(int paramInt)
  {
    
    if ((m() != null) && (!m().isFinishing())) {
      P();
    }
  }
  
  public String K()
  {
    return getClass().getName();
  }
  
  public void a(Activity paramActivity)
  {
    if (!(paramActivity instanceof PocketAuthorizeAppActivity)) {
      com.ideashower.readitlater.util.e.c("not allowed for use in " + paramActivity);
    }
    super.a(paramActivity);
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      e(-2);
      return;
    }
    if (paramBoolean2)
    {
      Z();
      return;
    }
    this.aa.setText(paramString1);
    this.ab.setText(paramString2);
    this.ac.setImageUrl(paramString3);
    this.aj = paramString4;
    paramBoolean1 = k.c(paramString4, "a");
    paramBoolean2 = k.c(paramString4, "m");
    boolean bool = k.c(paramString4, "d");
    if ((paramBoolean1) || (paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(2131493547, paramBoolean1);
      a(2131493548, paramBoolean2);
      a(2131493550, bool);
      a(2131493549, false);
      c.a(this.al).a(333L).a(new DecelerateInterpolator()).k(0.0F);
      com.b.c.a.a(this.ak, 0.0F);
      this.ak.setVisibility(0);
      c.a(this.ak).a(333L).a(new DecelerateInterpolator()).k(1.0F);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.am != null)
    {
      this.am.a();
      this.am = null;
    }
    if (!paramBoolean1) {}
    do
    {
      return;
      if ((m() == null) || (m().isFinishing()))
      {
        e(-3);
        return;
      }
    } while (!paramBoolean2);
    Intent localIntent = new Intent();
    localIntent.setAction("com.ideashower.readitlater.ACTION_LOGIN");
    m().sendBroadcast(localIntent);
    if (as.t()) {
      a(new Intent(m(), g.b().l()).addFlags(268435456));
    }
    Z();
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903057, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Y = m().getIntent().getStringExtra("com.pocket.oauth.extra.request_token");
    if (this.Y == null)
    {
      Log.w("Pocket", "Cannot start Activity, missing request token");
      e(-1);
      return;
    }
    if (com.ideashower.readitlater.activity.a.a(m()).y() == null)
    {
      e(-5);
      return;
    }
    this.aq = System.currentTimeMillis();
    this.Z = ((TextView)c(2131230836));
    this.aa = ((TextView)c(2131230839));
    this.ab = ((TextView)c(2131230840));
    this.ac = ((UrlImageView)c(2131230838));
    this.ad = ((TextView)c(2131230841));
    this.ae = ((LinearLayout)c(2131230842));
    this.af = ((TextView)c(2131230844));
    this.ag = ((LinearLayout)c(2131230845));
    this.ah = c(2131231072);
    this.ai = c(2131231073);
    this.ak = c(2131230835);
    this.al = c(2131230757);
    this.ap = ((RainbowProgressCircleView)c(2131230758));
    this.an = ((TextView)c(2131230759));
    this.ao = c(2131230846);
    if (e())
    {
      c().setCanceledOnTouchOutside(false);
      c(2131230765).setVisibility(8);
    }
    a(this.ad, 2131493543, 2131493545, Color.rgb(80, 187, 182));
    a(this.af, 2131493543, 2131493546, Color.rgb(237, 66, 85));
    aa();
    this.ah.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        p.a(p.this, l.a("Authorizing " + p.a(p.this).getText(), null, true));
        p.b(p.this).N();
        com.pocket.c.e.a(true, p.c(p.this), p.d(p.this), p.this, true);
      }
    });
    this.ai.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.pocket.c.e.a(false, p.c(p.this), p.d(p.this), p.this, false);
        p.a(p.this, -4);
      }
    });
    if (!as.l())
    {
      PocketAuthorizeAppActivity.a((PocketAuthorizeAppActivity)m(), this.Y);
      P();
      return;
    }
    com.pocket.c.e.a(this.Y, this);
  }
  
  public void g_()
  {
    final CharSequence localCharSequence = this.an.getText();
    this.an.setText(2131493043);
    this.ap.setVisibility(8);
    this.ao.setVisibility(0);
    this.ao.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        p.e(p.this).setVisibility(8);
        p.f(p.this).setVisibility(0);
        p.g(p.this).setText(localCharSequence);
        com.pocket.c.e.a(p.c(p.this), p.this);
      }
    });
  }
  
  public void x()
  {
    super.x();
    if (!m().isFinishing()) {
      m().finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */