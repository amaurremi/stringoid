package com.pocket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.r;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.j;
import com.pocket.b.b;
import com.pocket.gsf.GSFConfiguation;
import com.pocket.gsf.GSFDemoStep;
import java.util.ArrayList;
import java.util.Iterator;

public class f
{
  static Resources a = g.c().getResources();
  private static final GSFDemoStep e;
  protected boolean b;
  protected int c;
  protected int d;
  private final Context f;
  private final GSFConfiguation g;
  private boolean h;
  private boolean i;
  private ViewGroup j;
  private FrameLayout k;
  private View l;
  private View m;
  private WindowManager n;
  private TextView o;
  private final String p;
  private View q;
  private ViewGroup r;
  private com.b.a.p s;
  private final Rect t = new Rect();
  private int u = -1;
  
  static
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a.getString(2131493289));
    localStringBuffer.append(" \"");
    localStringBuffer.append(a.getString(2131493494));
    localStringBuffer.append("\"");
    e = new GSFDemoStep(localStringBuffer.toString(), "ic_launcher_icon");
  }
  
  public f(Context paramContext, GSFConfiguation paramGSFConfiguation, String paramString)
  {
    this.f = paramContext;
    this.g = paramGSFConfiguation;
    this.p = paramString;
    d();
  }
  
  private View a(int paramInt, GSFDemoStep paramGSFDemoStep, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.f).inflate(2130903142, paramViewGroup, false);
    ((TextView)paramViewGroup.findViewById(2131231057)).setText(paramInt + ". ");
    ((TextView)paramViewGroup.findViewById(2131231058)).setText(paramGSFDemoStep.a());
    Drawable localDrawable = paramGSFDemoStep.a(this.f);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131230792);
    if (localDrawable != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(localDrawable);
      if (paramGSFDemoStep.b())
      {
        paramGSFDemoStep = localImageView.getLayoutParams();
        paramGSFDemoStep.width = j.a(45.0F);
        localImageView.setLayoutParams(paramGSFDemoStep);
      }
      return paramViewGroup;
    }
    localImageView.setVisibility(8);
    return paramViewGroup;
  }
  
  private ViewGroup a(GSFConfiguation paramGSFConfiguation)
  {
    ViewGroup localViewGroup1 = (ViewGroup)LayoutInflater.from(this.f).inflate(2130903141, null, false);
    this.r = localViewGroup1;
    this.l = localViewGroup1.findViewById(2131231047);
    this.m = localViewGroup1.findViewById(2131230757);
    this.q = localViewGroup1.findViewById(2131231053);
    this.o = ((TextView)localViewGroup1.findViewById(2131230768));
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.findViewById(2131231049);
    Object localObject1 = localViewGroup1.findViewById(2131231052);
    Object localObject2 = localViewGroup1.findViewById(2131231054);
    ((View)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        f.f(f.this).setVisibility(0);
        if (Build.VERSION.SDK_INT <= 10)
        {
          f.g(f.this).findViewById(2131231048).setVisibility(8);
          f.g(f.this).findViewById(2131230768).setVisibility(8);
          f.g(f.this).findViewById(2131230983).setVisibility(8);
          f.g(f.this).findViewById(2131231049).setVisibility(8);
          f.g(f.this).findViewById(2131231050).setVisibility(8);
          f.g(f.this).findViewById(2131231051).setVisibility(8);
          f.g(f.this).findViewById(2131231052).setVisibility(8);
        }
        f.g(f.this).setVisibility(8);
        if (!f.this.b)
        {
          f.this.b = true;
          paramAnonymousView = (WindowManager.LayoutParams)f.b(f.this).getLayoutParams();
          paramAnonymousView.x = 0;
          paramAnonymousView.y = j.a(80.0F);
          paramAnonymousView.gravity = (f.h(f.this).i() | 0x1);
          f.e(f.this).updateViewLayout(f.b(f.this), paramAnonymousView);
          f.g(f.this).postDelayed(new Runnable()
          {
            public void run()
            {
              f.a(f.this, j.a(7.0F));
            }
          }, 500L);
          return;
        }
        paramAnonymousView = (WindowManager.LayoutParams)f.b(f.this).getLayoutParams();
        paramAnonymousView.x = f.this.c;
        paramAnonymousView.y = f.this.d;
        paramAnonymousView.gravity = 51;
        f.e(f.this).updateViewLayout(f.b(f.this), paramAnonymousView);
      }
    });
    ((View)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        f.g(f.this).setVisibility(0);
        if (Build.VERSION.SDK_INT <= 10)
        {
          f.g(f.this).findViewById(2131231048).setVisibility(0);
          f.g(f.this).findViewById(2131230768).setVisibility(0);
          f.g(f.this).findViewById(2131230983).setVisibility(0);
          f.g(f.this).findViewById(2131231049).setVisibility(0);
          f.g(f.this).findViewById(2131231050).setVisibility(0);
          f.g(f.this).findViewById(2131231051).setVisibility(0);
          f.g(f.this).findViewById(2131231052).setVisibility(0);
        }
        f.f(f.this).setVisibility(8);
        paramAnonymousView = (WindowManager.LayoutParams)f.b(f.this).getLayoutParams();
        f.this.c = paramAnonymousView.x;
        f.this.d = paramAnonymousView.y;
        paramAnonymousView.x = 0;
        paramAnonymousView.y = 0;
        paramAnonymousView.gravity = 17;
        f.e(f.this).updateViewLayout(f.b(f.this), paramAnonymousView);
      }
    });
    this.o.setText(paramGSFConfiguation.b());
    localObject1 = paramGSFConfiguation.d();
    int i2 = 1;
    int i1 = i2;
    if (paramGSFConfiguation.c().equals("browser"))
    {
      i1 = i2;
      if (com.ideashower.readitlater.a.c.c() == null)
      {
        localViewGroup2.addView(a(1, new GSFDemoStep(a.getString(2131493290), null), localViewGroup2));
        i1 = 2;
      }
    }
    paramGSFConfiguation = ((ArrayList)localObject1).iterator();
    while (paramGSFConfiguation.hasNext())
    {
      localViewGroup2.addView(a(i1, (GSFDemoStep)paramGSFConfiguation.next(), localViewGroup2));
      i1 += 1;
    }
    paramGSFConfiguation = a(i1, e, localViewGroup2);
    localObject1 = (ImageView)paramGSFConfiguation.findViewById(2131230792);
    ((ImageView)localObject1).setPadding(0, 0, 0, 0);
    ((ImageView)localObject1).setBackgroundDrawable(null);
    ((ImageView)localObject1).setImageResource(2130837656);
    localObject2 = ((ImageView)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width += j.a(1.5F);
    ((ViewGroup.LayoutParams)localObject2).height += j.a(1.5F);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localViewGroup2.addView(paramGSFConfiguation);
    return localViewGroup1;
  }
  
  private void a(int paramInt)
  {
    final WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.k.getLayoutParams();
    com.b.a.p localp = com.b.a.p.a(new int[] { localLayoutParams.y, localLayoutParams.y - paramInt, localLayoutParams.y + paramInt, localLayoutParams.y }).a(1000L);
    localp.b(1);
    localp.a(new DecelerateInterpolator());
    localp.a(new r()
    {
      public void a(com.b.a.p paramAnonymousp)
      {
        localLayoutParams.y = ((Integer)paramAnonymousp.f()).intValue();
        f.e(f.this).updateViewLayout(f.b(f.this), localLayoutParams);
      }
    });
    this.s = localp;
    localp.a();
  }
  
  private void a(Point paramPoint)
  {
    Display localDisplay = this.n.getDefaultDisplay();
    if (com.ideashower.readitlater.util.a.d())
    {
      paramPoint.x = localDisplay.getWidth();
      paramPoint.y = localDisplay.getHeight();
      return;
    }
    localDisplay.getSize(paramPoint);
  }
  
  private void d()
  {
    this.j = a(this.g);
    this.k = new FrameLayout(this.f);
    com.pocket.i.a.p localp = new com.pocket.i.a.p(0);
    localp.b(Color.argb(220, 0, 0, 0));
    localp.a(true);
    this.k.setBackgroundDrawable(localp);
    this.k.addView(this.j, new FrameLayout.LayoutParams((int)this.f.getResources().getDimension(2131296302), -2, 17));
    this.n = ((WindowManager)this.f.getSystemService("window"));
    this.k.setOnTouchListener(new View.OnTouchListener()
    {
      private boolean b = false;
      private float c;
      private float d;
      private WindowManager.LayoutParams e;
      private final Point f = new Point();
      
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (!f.a(f.this)) {}
        do
        {
          return false;
          switch (paramAnonymousMotionEvent.getAction())
          {
          default: 
            return false;
          case 0: 
            this.b = true;
            this.e = ((WindowManager.LayoutParams)f.b(f.this).getLayoutParams());
            f.a(f.this, this.f);
            this.c = paramAnonymousMotionEvent.getX();
            this.d = (paramAnonymousMotionEvent.getY() + f.c(f.this));
            f.b(f.this).setPressed(true);
            f.b(f.this).invalidate();
          }
        } while (f.d(f.this) == null);
        f.d(f.this).b();
        return false;
        this.e.x = ((int)(paramAnonymousMotionEvent.getRawX() - this.c));
        this.e.y = ((int)(paramAnonymousMotionEvent.getRawY() - this.d));
        this.e.gravity = 51;
        f.b(f.this).invalidate();
        f.e(f.this).updateViewLayout(f.b(f.this), this.e);
        return false;
        this.b = false;
        f.b(f.this).setPressed(false);
        f.b(f.this).invalidate();
        return false;
      }
    });
  }
  
  private int e()
  {
    if (this.u == -1)
    {
      this.l.getWindowVisibleDisplayFrame(this.t);
      this.u = this.t.top;
    }
    return this.u;
  }
  
  public void a()
  {
    this.l.setVisibility(0);
    com.b.c.a.a(this.l, 0.0F);
    com.b.c.c.a(this.m).b(222L).a(333L).k(0.0F);
    com.b.c.c.a(this.l).b(222L).a(333L).k(100.0F).a(new b()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        f.j(f.this).removeView(f.i(f.this));
        f.a(f.this, j.a(15.0F));
        f.a(f.this, true);
      }
    });
  }
  
  public void b()
  {
    WindowManager localWindowManager = (WindowManager)this.f.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    localLayoutParams.flags = 262184;
    localLayoutParams.format = -3;
    localLayoutParams.type = 2002;
    localWindowManager.addView(this.k, localLayoutParams);
    this.h = true;
  }
  
  public void c()
  {
    if (!this.h) {
      return;
    }
    if (this.s != null) {
      this.s.b();
    }
    WindowManager localWindowManager = (WindowManager)this.f.getSystemService("window");
    try
    {
      localWindowManager.removeView(this.k);
      this.h = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.k.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */