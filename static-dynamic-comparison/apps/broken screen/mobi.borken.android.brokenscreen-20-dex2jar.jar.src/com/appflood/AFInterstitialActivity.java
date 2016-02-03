package com.appflood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.appflood.b.b;
import com.appflood.c.c.a;
import com.appflood.c.d;
import com.appflood.c.e;
import com.appflood.c.f;
import com.appflood.c.g;
import java.util.TimerTask;

public class AFInterstitialActivity
  extends Activity
  implements View.OnClickListener, c.a
{
  private RelativeLayout a;
  private Button b;
  private Button c;
  private ImageView d;
  private LinearLayout e;
  private ProgressBar f;
  private TextView g;
  private com.appflood.c.c h = null;
  private float i = 1.5F;
  private float j = 1.5F;
  private boolean k = false;
  private int l = 418;
  private int m = 250;
  private int n = 3;
  private int o = 202;
  private int p = 217;
  private int q = 116;
  private int r = 490;
  private int s = 196;
  private int t = 43;
  
  private void b()
  {
    if (this.h != null)
    {
      this.h.c = null;
      this.h = null;
    }
    finish();
  }
  
  public final void a()
  {
    this.e.setVisibility(0);
    this.c.setVisibility(8);
    f.a(new TimerTask()
    {
      public final void run()
      {
        f.a(new Runnable()
        {
          public final void run()
          {
            AFInterstitialActivity.a(AFInterstitialActivity.this).setVisibility(8);
            AFInterstitialActivity.b(AFInterstitialActivity.this).setVisibility(0);
          }
        });
      }
    }, g.a().e);
  }
  
  public final void a(boolean paramBoolean)
  {
    e.a().a(paramBoolean, 128);
    if (paramBoolean)
    {
      AnimationSet localAnimationSet = new AnimationSet(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.1F, 1.0F, 0.1F, 1.0F, 1, 0.5F, 1, 0.5F);
      localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.setStartOffset(0L);
      localAnimationSet.setDuration(500L);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      this.a.startAnimation(localAnimationSet);
      this.a.setVisibility(0);
      return;
    }
    b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b) {
      paramView = this.h;
    }
    try
    {
      if ((com.appflood.e.c.s == 1) && (paramView.c != null)) {
        paramView.c.performClick();
      }
      b();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.k = getIntent().getBooleanExtra("isFull", false);
    if (!this.k) {
      this.r -= AFListActivity.1.c(this);
    }
    this.i = (com.appflood.e.c.g / 480.0F);
    this.j = (com.appflood.e.c.h / 800.0F);
    this.a = new RelativeLayout(this);
    this.a.setVisibility(8);
    new b(d.z + "interstitial_inter_bg.jpg", (byte)0).a(this.a);
    setContentView(this.a, new RelativeLayout.LayoutParams(-1, -1));
    this.d = new ImageView(this);
    this.d.setId(101);
    int i1 = (int)(this.n * this.i);
    this.d.setPadding(i1, i1, i1, i1);
    this.d.setBackgroundColor(-1);
    this.d.setScaleType(ImageView.ScaleType.FIT_XY);
    paramBundle = new RelativeLayout.LayoutParams((int)(this.l * this.i), (int)(this.m * this.i));
    paramBundle.addRule(10);
    float f1 = this.o;
    float f2 = this.j;
    if (com.appflood.e.c.g <= 320)
    {
      i1 = 20;
      paramBundle.topMargin = ((int)(f2 * f1 - i1));
      paramBundle.addRule(14);
      this.a.addView(this.d, paramBundle);
      this.b = new Button(this);
      this.b.setId(102);
      AFListActivity.1.a(this.b, "interstitial_download.png", "interstitial_download2.png");
      this.b.setOnClickListener(this);
      paramBundle = new RelativeLayout.LayoutParams((int)(this.p * this.i), (int)(this.q * this.i));
      paramBundle.addRule(10);
      paramBundle.addRule(14);
      f1 = this.r;
      f2 = this.j;
      if (com.appflood.e.c.g > 320) {
        break label708;
      }
    }
    label708:
    for (i1 = 5;; i1 = 0)
    {
      paramBundle.topMargin = ((int)(f2 * f1 - i1));
      this.a.addView(this.b, paramBundle);
      this.c = new Button(this);
      AFListActivity.1.a(this.c, "interstitial_continue_0.png", "interstitial_continue_1.png");
      this.c.setOnClickListener(this);
      this.c.setVisibility(8);
      paramBundle = new RelativeLayout.LayoutParams((int)(this.s * this.i), (int)(this.t * this.i));
      paramBundle.addRule(3, this.b.getId());
      paramBundle.addRule(14);
      this.a.addView(this.c, paramBundle);
      this.e = new LinearLayout(this);
      this.a.addView(this.e, paramBundle);
      this.f = new ProgressBar(this, null, 16842873);
      paramBundle = new LinearLayout.LayoutParams(-2, -2);
      paramBundle.gravity = 16;
      paramBundle.leftMargin = 5;
      this.e.addView(this.f, paramBundle);
      this.g = new TextView(this);
      this.g.setTextColor(-1);
      this.g.setTextSize(18.0F);
      this.g.setText(d.c);
      this.g.setGravity(17);
      paramBundle = new LinearLayout.LayoutParams(-1, -1);
      this.e.addView(this.g, paramBundle);
      this.h = new com.appflood.c.c(this.d, this);
      this.h.g = false;
      return;
      i1 = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 4) || ((this.c.getVisibility() == 8) && (this.a.getVisibility() == 0))) {
      return true;
    }
    b();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AFInterstitialActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */