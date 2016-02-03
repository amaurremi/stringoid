package com.google.ads.internal;

import android.os.Handler;
import com.google.ads.AdView;
import com.google.ads.m;
import com.google.ads.m.a;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;

public class ActivationOverlay
  extends AdWebView
{
  private volatile boolean b = true;
  private boolean c = true;
  private int d = 0;
  private int e = 0;
  private final i f;
  
  public ActivationOverlay(n paramn)
  {
    super(paramn, null);
    m.a locala = (m.a)((m)paramn.d.a()).b.a();
    if (AdUtil.a < ((Integer)locala.c.a()).intValue())
    {
      b.a("Disabling hardware acceleration for an activation overlay.");
      g();
    }
    this.f = i.a((d)paramn.b.a(), a.c, true, true);
    setWebViewClient(this.f);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return false;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public i e()
  {
    return this.f;
  }
  
  public void setOverlayActivated(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOverlayEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {
      ((Handler)m.a().c.a()).post(new Runnable()
      {
        public void run()
        {
          ((AdView)ActivationOverlay.this.a.j.a()).removeView(jdField_this);
        }
      });
    }
    this.b = paramBoolean;
  }
  
  public void setXPosition(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setYPosition(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/internal/ActivationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */