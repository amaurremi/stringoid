package com.ideashower.readitlater.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ToggleButton;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.p;

public class z
{
  private static int e;
  protected Activity a;
  protected FrameLayout b;
  protected ToggleButton c;
  protected Handler d;
  private OrientationEventListener f;
  private aa g;
  private final p h;
  private boolean i = true;
  
  public z(Activity paramActivity)
  {
    this.a = paramActivity;
    this.h = p.a();
    d();
  }
  
  private void a(long paramLong)
  {
    if (this.g == null) {
      this.g = new aa(this, null);
    }
    this.d.removeCallbacks(this.g);
    this.d.postDelayed(this.g, paramLong);
  }
  
  private int b(int paramInt)
  {
    int j = Math.round(paramInt / 90.0F) * 90;
    paramInt = j;
    if (j >= 360) {
      paramInt = j - 360;
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 90: 
      return 1;
    case 180: 
      return 2;
    }
    return 3;
  }
  
  private void b(boolean paramBoolean)
  {
    this.h.a(paramBoolean, this.a);
    c(paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.enable();
    }
    for (;;)
    {
      this.f.enable();
      return;
      this.f.disable();
    }
  }
  
  private void f()
  {
    e = this.a.getWindowManager().getDefaultDisplay().getRotation();
  }
  
  private void g()
  {
    this.b = ((FrameLayout)((ViewStub)this.a.findViewById(2131230949)).inflate());
    this.b.setVisibility(0);
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        z.a(z.this, 0L);
        return false;
      }
    });
    this.c = ((ToggleButton)this.a.findViewById(2131230952));
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        z.a(z.this, ((ToggleButton)paramAnonymousView).isChecked());
        z.b(z.this);
        z.a(z.this);
      }
    });
  }
  
  private void h()
  {
    if (!j()) {
      return;
    }
    if (this.c == null) {
      g();
    }
    this.c.clearAnimation();
    this.b.setVisibility(0);
    this.c.setEnabled(true);
    this.c.setChecked(this.h.b());
    this.c.setVisibility(0);
    i();
  }
  
  private void i()
  {
    a(1000L);
  }
  
  private boolean j()
  {
    if (this.h.b()) {}
    while ((this.i) && (i.a(a.bb))) {
      return true;
    }
    return false;
  }
  
  public void a()
  {
    d();
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    f();
  }
  
  protected void a(int paramInt)
  {
    int j = 0;
    int k = 1;
    if (paramInt == -1) {
      return;
    }
    switch (e)
    {
    default: 
      j = k;
    }
    while (j == 0)
    {
      e = b(paramInt);
      h();
      return;
      if ((paramInt < 80) || (paramInt > 280)) {
        j = 1;
      }
      continue;
      if (paramInt < 170)
      {
        j = k;
        if (paramInt > 10) {}
      }
      else
      {
        j = 0;
        continue;
        if (paramInt < 260)
        {
          j = k;
          if (paramInt > 100) {}
        }
        else
        {
          j = 0;
          continue;
          if (paramInt < 350)
          {
            j = k;
            if (paramInt > 190) {}
          }
          else
          {
            j = 0;
          }
        }
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        z.a(z.this);
      }
    });
  }
  
  public void a(Handler paramHandler)
  {
    this.d = paramHandler;
    this.f = new OrientationEventListener(this.a)
    {
      public void onOrientationChanged(int paramAnonymousInt)
      {
        z.this.a(paramAnonymousInt);
      }
    };
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1);
    b(false);
  }
  
  public void b()
  {
    c(this.h.b());
  }
  
  public void c()
  {
    this.f.disable();
  }
  
  protected void d()
  {
    int j = this.a.getRequestedOrientation();
    if (j == this.h.c()) {}
    while ((!this.h.b()) && (j == -1)) {
      return;
    }
    this.a.setRequestedOrientation(this.h.c());
  }
  
  public void e()
  {
    if ((!i.a(a.bb)) && (this.h.b())) {
      this.h.a(false, this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */