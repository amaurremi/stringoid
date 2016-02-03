package com.appflood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appflood.b.b;
import com.appflood.c.d;
import com.appflood.c.e;
import com.appflood.c.f;
import com.appflood.e.c;
import com.appflood.e.j;
import com.appflood.f.g;
import com.appflood.f.h;
import java.util.TimerTask;

public class AFPanelActivity
  extends Activity
{
  private static int u = 5;
  private RelativeLayout a = null;
  private g b = null;
  private h c = null;
  private ImageView d = null;
  private ImageView e = null;
  private RelativeLayout f = null;
  private RelativeLayout g = null;
  private float h = 480.0F;
  private float i = 800.0F;
  private int j = 58;
  private int k = 70;
  private int l = 16;
  private int m = 16;
  private float n;
  private float o;
  private int p = 58;
  private int q = 25;
  private int r = 0;
  private float s = 1.0F;
  private float t = 1.0F;
  private int v;
  private boolean w = true;
  private boolean x = false;
  
  private void a()
  {
    this.g.setClickable(false);
    if (this.r == 0) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.i - 8.0F);; localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.i + 8.0F))
    {
      localTranslateAnimation.setDuration(500L);
      this.a.startAnimation(localTranslateAnimation);
      f.a(new TimerTask()
      {
        public final void run()
        {
          f.a(new Runnable()
          {
            public final void run()
            {
              try
              {
                AFPanelActivity.b(AFPanelActivity.this).removeAllViews();
                AFPanelActivity.c(AFPanelActivity.this).removeAllViews();
                AFPanelActivity.this.finish();
                return;
              }
              catch (Throwable localThrowable) {}
            }
          });
        }
      }, 500L);
      e.a().a(false, j.a("type", Integer.valueOf(2)));
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    label1301:
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getExtras();
        if (paramBundle != null)
        {
          this.r = paramBundle.getInt("showType");
          this.w = paramBundle.getBoolean("isFull");
          this.x = paramBundle.getBoolean("isPortrait");
          this.v = paramBundle.getInt("titlebar");
        }
        requestWindowFeature(1);
        if (this.x)
        {
          if (c.j >= 9)
          {
            setRequestedOrientation(7);
            if (this.w) {
              getWindow().setFlags(1024, 1024);
            }
            paramBundle = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
            this.h = paramBundle.widthPixels;
            this.i = paramBundle.heightPixels;
            if (!this.w) {
              this.i -= this.v;
            }
            getWindow().setBackgroundDrawableResource(17170445);
            if (!this.x)
            {
              this.t = (this.i / 480.0F);
              this.j = ((int)(61.0F * this.t));
              this.k = ((int)(20.0F * this.t));
              this.o = (391.0F * this.t);
              this.n = (this.o * 722.0F / 391.0F);
              this.s = (this.i / 480.0F);
              if (this.n > this.h)
              {
                this.n = (722.0F * this.h / 800.0F);
                this.o = (this.n * 391.0F / 722.0F);
                this.k = ((int)(this.i - this.j - this.l - this.o));
                this.s = (this.h / 800.0F);
              }
              this.m = ((int)((this.h - this.n) / 2.0F));
              this.l = ((int)((this.i - this.o - this.j) / 2.0F));
              this.p = ((int)(this.t * 58.0F));
              this.q = ((int)(25.0F * this.t));
              this.a = new RelativeLayout(this);
              this.a.setBackgroundColor(-16379600);
              this.c = new h(this, this.s);
              this.c.setId(1);
              paramBundle = new RelativeLayout.LayoutParams(-1, this.j);
              paramBundle.addRule(10);
              this.a.addView(this.c, paramBundle);
              this.f = new RelativeLayout(this);
              this.f.setBackgroundColor(-16379600);
              paramBundle = new RelativeLayout.LayoutParams(-1, -1);
              paramBundle.addRule(3, 1);
              this.a.addView(this.f, paramBundle);
              this.e = new ImageView(this);
              this.g = new RelativeLayout(this);
              paramBundle = new RelativeLayout.LayoutParams(this.q, this.q);
              paramBundle.addRule(13);
              this.g.addView(this.e, paramBundle);
              this.g.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  try
                  {
                    AFPanelActivity.a(AFPanelActivity.this);
                    return;
                  }
                  catch (Throwable paramAnonymousView) {}
                }
              });
              paramBundle = new RelativeLayout.LayoutParams(this.p, this.p);
              paramBundle.addRule(10);
              paramBundle.addRule(11);
              this.a.addView(this.g, paramBundle);
              this.b = new g(this, this.x, this.s, u);
              paramBundle = this.f;
              Object localObject = this.b;
              RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)this.n, (int)this.o);
              localLayoutParams.leftMargin = this.m;
              localLayoutParams.topMargin = this.l;
              paramBundle.addView((View)localObject, localLayoutParams);
              new RelativeLayout.LayoutParams(-2, -2).addRule(13);
              this.d = new ImageView(this);
              paramBundle = new RelativeLayout.LayoutParams((int)this.n, this.k);
              paramBundle.leftMargin = this.m;
              paramBundle.addRule(12);
              this.d.setLayoutParams(paramBundle);
              if (!this.x) {
                this.d.setVisibility(8);
              }
              this.f.addView(this.d, paramBundle);
              setContentView(this.a, new RelativeLayout.LayoutParams(-1, -1));
              if (!j.a(d.x)) {
                new b(d.x).f();
              }
              new b(d.z + "closeBtn2.png", (byte)0).a(this.e);
              new b(d.z + "slogan.png", (byte)0).a(this.d);
              localObject = new StringBuilder().append(d.z);
              if (!this.x) {
                break label1301;
              }
              paramBundle = "14K-STAR.jpg";
              new b(paramBundle, (byte)0).a(this.f);
              if (this.r != 0) {
                continue;
              }
              paramBundle = new TranslateAnimation(0.0F, 0.0F, -this.i, 0.0F);
              paramBundle.setDuration(500L);
              this.a.startAnimation(paramBundle);
            }
          }
          else
          {
            setRequestedOrientation(1);
            continue;
          }
        }
        else
        {
          if (c.j >= 9)
          {
            setRequestedOrientation(6);
            continue;
          }
          setRequestedOrientation(0);
          continue;
        }
        this.t = (this.h / 480.0F);
        this.j = ((int)(this.t * 58.0F));
        this.l = ((int)(16.0F * this.t));
        this.n = ((u * 2 + 448) * this.h / 480.0F);
        this.o = (this.n * 655.0F / 448.0F);
        this.s = (this.h / 480.0F);
        if (this.o + this.j + this.l > this.i)
        {
          this.o = ((u * 2 + 655) * this.i / 800.0F);
          this.n = (this.o * 448.0F / 655.0F);
          this.s = (this.i / 800.0F);
        }
        this.j = ((int)(this.t * 58.0F));
        this.l = ((int)(16.0F * this.t));
        this.m = ((int)((this.h - this.n) / 2.0F));
        this.k = ((int)(this.i - this.j - this.o - this.l));
        this.p = ((int)(this.t * 58.0F));
        this.q = ((int)(25.0F * this.t));
        continue;
        paramBundle = new TranslateAnimation(0.0F, 0.0F, this.i, 0.0F);
        continue;
        paramBundle = "24K-STAR.jpg";
      }
      catch (Throwable paramBundle)
      {
        return;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {}
    try
    {
      a();
      return true;
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    catch (Throwable paramKeyEvent)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AFPanelActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */