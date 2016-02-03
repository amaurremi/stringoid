package com.vungle.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
import java.util.ArrayList;
import java.util.Iterator;

public class VungleAdvert
  extends Activity
{
  v a = null;
  v b = null;
  private boolean c = false;
  private ViewFlipper d = null;
  private int e = 0;
  private Boolean[] f = { Boolean.valueOf(false), Boolean.valueOf(false) };
  private int g;
  private long h = Long.MIN_VALUE;
  private boolean i = false;
  private boolean j = false;
  
  private v a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return null;
    case 1: 
      Object localObject1 = aj.e();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = a(((aj)localObject1).a.c());
      try
      {
        localObject1 = new x(this, (String)localObject1, new r(this));
        return (v)localObject1;
      }
      catch (v.a locala1)
      {
        return null;
      }
    case 2: 
      Object localObject2 = aj.e().a.b();
      paramInt = ay.a().e.l;
      int k = ay.a().e.k;
      try
      {
        localObject2 = new y(this, (String)localObject2, paramInt, k, new s(this));
        ((y)localObject2).a(ak.F);
        return (v)localObject2;
      }
      catch (v.a locala2)
      {
        return null;
      }
    case 3: 
      Object localObject3 = a(aj.e().a.d());
      try
      {
        localObject3 = new w(this, (String)localObject3, new t(this));
        return (v)localObject3;
      }
      catch (v.a locala3)
      {
        return null;
      }
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return "file://" + paramString;
  }
  
  private void b()
  {
    if (c()) {
      return;
    }
    this.g += 1;
  }
  
  private boolean c()
  {
    return this.g >= 4;
  }
  
  private void d()
  {
    v localv;
    for (;;)
    {
      new StringBuilder("Showing stage for: ").append(this.g);
      localv = this.a;
      this.a = a(this.g);
      if (this.a != null) {
        break;
      }
      if (c())
      {
        e();
        finish();
        return;
      }
      b();
    }
    this.b = localv;
    if (this.f[this.e].booleanValue()) {
      this.d.removeViewAt(this.e);
    }
    this.f[this.e] = Boolean.valueOf(true);
    this.d.addView(this.a.a(), this.e);
    this.d.setDisplayedChild(this.e);
    this.e = (1 - this.e);
  }
  
  private void e()
  {
    al localal;
    Object localObject;
    double d2;
    double d1;
    if (!this.c)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.h;
      this.c = true;
      ay.c().b = (l1 - l2);
      ak.a(false);
      ak.k = Boolean.valueOf(true);
      localal = new al(ak.e());
      if (ak.i)
      {
        localObject = e.t;
        ay.a(ay.c().a());
        localObject = ay.c().d;
        Iterator localIterator = ((ArrayList)localObject).iterator();
        d2 = 0.0D;
        d1 = 0.0D;
        if (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          d2 = localj.b;
          if (localj.c <= d1) {
            break label221;
          }
          d1 = localj.c;
        }
      }
    }
    label221:
    for (;;)
    {
      break;
      if (((ArrayList)localObject).size() > 0) {
        e.a(d1 / 1000.0D, d2 / 1000.0D);
      }
      ay.a(new i());
      if (ba.e(localal.b)) {
        localal.a();
      }
      for (;;)
      {
        new al(ak.e()).b();
        return;
        localal.c = 5;
        localal.c();
      }
    }
  }
  
  public void onBackPressed()
  {
    e();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      getWindow().addFlags(128);
      if (paramBundle != null)
      {
        this.g = paramBundle.getInt("stage");
        this.h = paramBundle.getLong("start");
      }
      for (;;)
      {
        ak.a(true);
        this.d = new m(this);
        this.d.setInAnimation(this, 17432578);
        this.d.setOutAnimation(this, 17432577);
        this.d.setAnimateFirstView(true);
        this.d.getInAnimation().setAnimationListener(new u(this));
        requestWindowFeature(1);
        setContentView(this.d);
        if (ba.f(ak.e()) != null) {
          this.g = 4;
        }
        d();
        return;
        this.g = 0;
        this.h = SystemClock.elapsedRealtime();
        b();
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      ay.a(paramBundle);
      this.g = 4;
      e();
      finish();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.g != 2) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((paramInt == 25) || (paramInt == 24) || (paramInt == 91)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (((ak.t) && (!ak.D)) || ((ak.u) && (ak.D))) {}
    for (int k = 1;; k = 0)
    {
      if ((k != 0) && (paramInt == 4))
      {
        paramKeyEvent = (y)this.a;
        ay.c().a("back");
        paramKeyEvent.d();
      }
      return true;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.c();
    }
    this.i = false;
    VunglePub.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.a != null) && (!this.i) && (this.j)) {
      this.a.b();
    }
    this.i = true;
    VunglePub.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("stage", this.g);
    paramBundle.putLong("start", this.h);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    new StringBuilder("onWindowFocusChanged(").append(paramBoolean).append(")");
    if ((this.a != null) && (this.i) && (!this.j) && (paramBoolean)) {
      this.a.b();
    }
    this.j = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/VungleAdvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */