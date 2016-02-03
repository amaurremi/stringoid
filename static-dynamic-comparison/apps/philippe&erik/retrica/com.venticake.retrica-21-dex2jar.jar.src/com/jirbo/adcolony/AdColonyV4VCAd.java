package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

public final class AdColonyV4VCAd
  extends AdColonyAd
{
  AdColonyAdListener s;
  boolean t = false;
  boolean u = false;
  
  public AdColonyV4VCAd()
  {
    a.u = false;
    a.e();
    this.j = "v4vc";
    this.k = "fullscreen";
    this.l = ab.b();
  }
  
  public AdColonyV4VCAd(String paramString)
  {
    a.e();
    this.g = paramString;
    this.j = "v4vc";
    this.k = "fullscreen";
    this.l = ab.b();
  }
  
  void a()
  {
    if ((this.f == 4) && (this.u)) {
      a("Result");
    }
    if (this.s != null) {
      this.s.onAdColonyAdAttemptFinished(this);
    }
    a.h();
    if ((!a.u) && (!AdColonyBrowser.B))
    {
      int i = 0;
      while (i < a.Z.size())
      {
        ((Bitmap)a.Z.get(i)).recycle();
        i += 1;
      }
      a.Z.clear();
    }
    a.I = null;
    if (!this.u) {
      a.v = true;
    }
    System.gc();
  }
  
  void a(String paramString)
  {
    String str1 = getRewardName();
    String str2 = "" + getRewardAmount();
    str1 = str2 + " " + str1;
    if (paramString.equals("Confirmation"))
    {
      a.G = new ac(str1, this);
      return;
    }
    a.G = new ad(str1, this);
  }
  
  boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  boolean b()
  {
    return true;
  }
  
  void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (a.l.b(this))
      {
        if (this.s != null) {
          this.s.onAdColonyAdStarted(this);
        }
        this.f = 4;
      }
    }
    for (;;)
    {
      if ((this.f != 4) && (this.s != null)) {
        this.s.onAdColonyAdAttemptFinished(this);
      }
      return;
      this.f = 3;
      continue;
      this.f = 1;
    }
  }
  
  public int getRemainingViewsUntilReward()
  {
    if (!c()) {
      return 0;
    }
    return this.h.j.f - a.l.e(this.h.j.d);
  }
  
  public int getRewardAmount()
  {
    if (!c()) {
      return 0;
    }
    return this.h.j.c;
  }
  
  public String getRewardName()
  {
    if (!c()) {
      return "";
    }
    return this.h.j.d;
  }
  
  public int getViewsPerReward()
  {
    if (!c()) {
      return 0;
    }
    return this.h.j.f;
  }
  
  public boolean isReady()
  {
    if (this.g == null)
    {
      this.g = a.l.f();
      if (this.g == null) {
        return false;
      }
    }
    return a.l.g(this.g);
  }
  
  public void show()
  {
    a.Y = 0;
    if (!isReady())
    {
      new j(a.l)
      {
        void a()
        {
          if (AdColonyV4VCAd.this.g != null) {
            this.n.d.a(AdColonyV4VCAd.this.g, AdColonyV4VCAd.this);
          }
        }
      };
      this.f = 2;
      if (this.s != null) {
        this.s.onAdColonyAdAttemptFinished(this);
      }
    }
    while (!a.v) {
      return;
    }
    new j(a.l)
    {
      void a()
      {
        this.n.d.a(AdColonyV4VCAd.this.g, AdColonyV4VCAd.this);
      }
    };
    a.v = false;
    c();
    a.H = this;
    a.l.a(this);
    if (this.t)
    {
      a("Confirmation");
      return;
    }
    c(true);
  }
  
  public AdColonyV4VCAd withConfirmationDialog()
  {
    return withConfirmationDialog(true);
  }
  
  public AdColonyV4VCAd withConfirmationDialog(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public AdColonyV4VCAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.s = paramAdColonyAdListener;
    return this;
  }
  
  public AdColonyV4VCAd withResultsDialog()
  {
    return withResultsDialog(true);
  }
  
  public AdColonyV4VCAd withResultsDialog(boolean paramBoolean)
  {
    this.u = paramBoolean;
    a.u = this.u;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyV4VCAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */