package com.ideashower.readitlater.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.IBinder;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.b.a.b;
import com.b.c.c;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.ItemsTaggingActivity;
import com.ideashower.readitlater.activity.PocketActivity;
import com.ideashower.readitlater.activity.SendToFriendActivity;
import com.ideashower.readitlater.activity.ad;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ak;
import com.pocket.i.a.p;

public class AddOverlayService
  extends Service
  implements View.OnClickListener
{
  public static Toast a;
  private static final int b = j.a(6.0F);
  private static final int c = j.a(220.0F);
  private static final int d = j.a(65.0F);
  private static int e;
  private final Paint f = new Paint();
  private final Paint g;
  private final Interpolator h = new OvershootInterpolator();
  private final Interpolator i = new AccelerateInterpolator();
  private final Runnable j = new Runnable()
  {
    public void run()
    {
      AddOverlayService.a(AddOverlayService.this, true);
    }
  };
  private final Handler k = g.o();
  private final Object l = new Object();
  private View m;
  private View n;
  private View o;
  private View p;
  private View q;
  private boolean r = false;
  private View s;
  private boolean t;
  private String u;
  private o v;
  private com.ideashower.readitlater.db.operation.a w;
  private FrameLayout x;
  
  public AddOverlayService()
  {
    this.f.setColor(Color.rgb(0, 192, 255));
    this.f.setMaskFilter(new BlurMaskFilter(b * 2, BlurMaskFilter.Blur.OUTER));
    this.g = new Paint();
    this.g.setColor(Color.rgb(60, 60, 60));
    this.g.setMaskFilter(new BlurMaskFilter(b, BlurMaskFilter.Blur.OUTER));
    e = (int)g.c().getResources().getDimension(2131296256);
  }
  
  private BitmapDrawable a(BitmapDrawable paramBitmapDrawable, boolean paramBoolean)
  {
    Bitmap localBitmap1 = paramBitmapDrawable.getBitmap();
    Bitmap localBitmap2 = localBitmap1.extractAlpha();
    Bitmap localBitmap3 = Bitmap.createBitmap(localBitmap1.getWidth() + b * 2, localBitmap1.getHeight() + b * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap3);
    if (paramBoolean) {}
    for (paramBitmapDrawable = this.f;; paramBitmapDrawable = this.g)
    {
      localCanvas.drawBitmap(localBitmap2, b, b, paramBitmapDrawable);
      localCanvas.drawBitmap(localBitmap1, b, b, null);
      return new BitmapDrawable(getResources(), localBitmap3);
    }
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    View localView = this.n.findViewById(paramInt1);
    com.b.c.a.b(localView, 0.0F);
    com.b.c.a.c(localView, 0.0F);
    Object localObject = new RelativeLayout.LayoutParams(localView.getLayoutParams());
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (BitmapDrawable)localView.getBackground();
    StateListDrawable localStateListDrawable = new StateListDrawable();
    BitmapDrawable localBitmapDrawable = a((BitmapDrawable)localObject, true);
    localStateListDrawable.addState(new int[] { 16842919 }, localBitmapDrawable);
    localStateListDrawable.addState(StateSet.WILD_CARD, a((BitmapDrawable)localObject, false));
    localView.setBackgroundDrawable(localStateListDrawable);
    if ((localView instanceof ImageView)) {
      ((ImageView)localView).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    return localView;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, AddOverlayService.class);
    localIntent.setAction("com.pocket.service.AddOverlayService.save");
    localIntent.putExtra("newItemUrl", paramString1);
    if (paramString2 != null)
    {
      localIntent.putExtra("tweetId", paramString2);
      localIntent.putExtra("isGivenUrlTwitterUrl", paramBoolean);
    }
    paramContext.startService(localIntent);
  }
  
  private void a(View paramView)
  {
    this.m.setVisibility(0);
    this.s = paramView;
  }
  
  private void a(final View paramView, float paramFloat, long paramLong)
  {
    c.a(paramView).g(1.0F).i(1.0F).b(paramFloat).f(0.0F).a(this.h).a(300L).b(paramLong).a(new b()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        if (com.ideashower.readitlater.util.a.d())
        {
          paramView.clearAnimation();
          paramView.setVisibility(0);
          if (paramView != AddOverlayService.e(AddOverlayService.this)) {
            break label70;
          }
          paramAnonymousa = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          paramAnonymousa.addRule(0, AddOverlayService.d(AddOverlayService.this).getId());
          paramView.setLayoutParams(paramAnonymousa);
        }
        label70:
        while (paramView != AddOverlayService.f(AddOverlayService.this)) {
          return;
        }
        paramAnonymousa = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        paramAnonymousa.addRule(1, AddOverlayService.d(AddOverlayService.this).getId());
        paramView.setLayoutParams(paramAnonymousa);
      }
      
      public void b(com.b.a.a paramAnonymousa)
      {
        paramView.setVisibility(0);
      }
      
      public void c(com.b.a.a paramAnonymousa) {}
      
      public void d(com.b.a.a paramAnonymousa) {}
    });
  }
  
  private void a(o paramo)
  {
    paramo = SendToFriendActivity.b(this, new ak(paramo, null), 0, UiContext.a(UiTrigger.c));
    paramo.addFlags(880902144);
    startActivity(paramo);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.u = paramString1;
    a(paramString1, paramString2, paramBoolean, true);
    this.t = true;
    this.n = LayoutInflater.from(this).inflate(2130903041, null);
    this.m = new View(this);
    paramString1 = new p(0);
    paramString1.b(Color.argb(190, 53, 53, 53));
    paramString1.a(true);
    this.m = LayoutInflater.from(this).inflate(2130903141, null, false);
    this.m.setBackgroundDrawable(paramString1);
    ((TextView)this.m.findViewById(2131231056)).setText(2131493141);
    this.m.setVisibility(4);
    this.o = a(2131230745, 0);
    this.p = a(2131230744, d);
    this.q = a(2131230746, -d);
    this.o.setEnabled(true);
    this.p.setEnabled(true);
    this.q.setEnabled(true);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    paramString1 = new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          AddOverlayService.b(AddOverlayService.this).removeCallbacks(AddOverlayService.a(AddOverlayService.this));
        }
        for (;;)
        {
          return false;
          if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
            AddOverlayService.b(AddOverlayService.this).postDelayed(AddOverlayService.a(AddOverlayService.this), 2500L);
          }
        }
      }
    };
    this.o.setOnTouchListener(paramString1);
    this.p.setOnTouchListener(paramString1);
    this.q.setOnTouchListener(paramString1);
    this.n.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (AddOverlayService.c(AddOverlayService.this) != null) {}
        while (paramAnonymousMotionEvent.getAction() != 4) {
          return false;
        }
        AddOverlayService.a(AddOverlayService.this, true);
        return false;
      }
    });
    paramString1 = (WindowManager)getSystemService("window");
    paramString2 = new WindowManager.LayoutParams();
    paramString2.width = c;
    paramString2.height = (e - 2);
    paramString2.gravity = 81;
    paramString2.flags = 262184;
    paramString2.format = -3;
    paramString2.type = 2002;
    paramString2.windowAnimations = 16973826;
    paramString1.addView(this.n, paramString2);
    paramString2.type = 2005;
    paramString2.gravity = 17;
    paramString1.addView(this.m, paramString2);
    this.k.post(new Runnable()
    {
      public void run()
      {
        AddOverlayService.a(AddOverlayService.this, AddOverlayService.d(AddOverlayService.this), 0.0F, 200L);
        AddOverlayService.a(AddOverlayService.this, AddOverlayService.e(AddOverlayService.this), -AddOverlayService.a(), 750L);
        AddOverlayService.a(AddOverlayService.this, AddOverlayService.f(AddOverlayService.this), AddOverlayService.a(), 750L);
        AddOverlayService.b(AddOverlayService.this).postDelayed(AddOverlayService.a(AddOverlayService.this), 6500L);
      }
    });
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, final boolean paramBoolean2)
  {
    this.w = new com.ideashower.readitlater.db.operation.a(paramString1, paramString2, paramBoolean1);
    this.w.c(paramString1);
    if (paramBoolean1) {
      this.r = true;
    }
    this.w.a(new l()
    {
      public void a() {}
      
      public void a(k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        AddOverlayService.b(AddOverlayService.this, false);
        AddOverlayService.g(AddOverlayService.this);
        AddOverlayService.a(AddOverlayService.this, paramAnonymousBoolean, paramBoolean2);
      }
    }, true);
    this.w.f();
  }
  
  private void a(final boolean paramBoolean)
  {
    if (this.n == null) {
      return;
    }
    if (this.x != null)
    {
      a(this, this.x);
      this.x = null;
    }
    this.k.removeCallbacks(this.j);
    this.t = false;
    b(this.o, 0.0F, 0L);
    b(this.p, j.a(25.0F), 0L);
    b(this.q, -j.a(25.0F), 0L).a(new b()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        if (paramBoolean) {
          AddOverlayService.h(AddOverlayService.this);
        }
      }
      
      public void b(com.b.a.a paramAnonymousa) {}
      
      public void c(com.b.a.a paramAnonymousa) {}
      
      public void d(com.b.a.a paramAnonymousa) {}
    });
  }
  
  private void a(boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i3 = 2131493732;
    int i4 = 0;
    final int i1 = i3;
    int i2 = i4;
    if (paramBoolean1)
    {
      i1 = i3;
      i2 = i4;
      switch (this.w.e())
      {
      default: 
        i1 = 0;
        i2 = 1;
      }
    }
    while (i2 != 0) {
      synchronized (this.l)
      {
        this.v = this.w.n();
        if (i1 != 0)
        {
          a = WakefulAppService.a(this, i1, 1);
          a.show();
        }
        return;
        i1 = 2131493730;
        i2 = 1;
      }
    }
    g.a(new Runnable()
    {
      public void run()
      {
        AddOverlayService.a(AddOverlayService.this, true);
        if (!paramBoolean2) {}
        AddOverlayService.a = WakefulAppService.a(AddOverlayService.this, i1, 1);
        AddOverlayService.a.show();
      }
    });
  }
  
  public static boolean a(Context paramContext, View paramView)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    try
    {
      paramContext.removeView(paramView);
      return true;
    }
    catch (Exception paramContext)
    {
      paramView.setVisibility(8);
    }
    return false;
  }
  
  private c b(View paramView, float paramFloat, long paramLong)
  {
    return c.a(paramView).k(0.0F).a(this.i).a(600L).b(paramLong);
  }
  
  private o b()
  {
    synchronized (this.l)
    {
      o localo = this.v;
      if (localo != null) {
        return localo;
      }
    }
    if (this.w.d() == 4) {
      synchronized (this.l)
      {
        this.v = this.w.n();
        if (this.v == null) {}
        return this.v;
      }
    }
    return null;
  }
  
  private void b(o paramo)
  {
    paramo = new Intent(this, PocketActivity.class);
    paramo.putExtra("com.pocket.extra.uiContext", UiContext.a(UiTrigger.c));
    paramo.addFlags(872513536);
    startActivity(paramo);
  }
  
  private void c()
  {
    if (this.n == null) {
      return;
    }
    a(this, this.n);
    this.n = null;
    stopSelf();
  }
  
  private void c(o paramo)
  {
    paramo = ItemsTaggingActivity.b(this, ad.a(paramo, UiContext.a(UiTrigger.c)), true);
    paramo.addFlags(880902144);
    startActivity(paramo);
  }
  
  private void d()
  {
    if (this.m != null) {
      this.m.setVisibility(8);
    }
    if (this.s != null)
    {
      if (this.s != this.p) {
        break label43;
      }
      c(b());
    }
    label43:
    do
    {
      return;
      if (this.s == this.q)
      {
        a(b());
        return;
      }
    } while (this.s != this.o);
    b(b());
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (!this.t) {
      return;
    }
    if (a != null) {
      a.cancel();
    }
    o localo;
    if (!this.r)
    {
      localo = b();
      if (paramView == this.p)
      {
        c(localo);
        if (this.r) {
          break label100;
        }
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
      if (paramView == this.q)
      {
        a(localo);
        break;
      }
      if (paramView != this.o) {
        break;
      }
      b(localo);
      break;
      a(paramView);
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return 1;
      str = paramIntent.getAction();
      if ("com.pocket.service.AddOverlayService.save".equals(str))
      {
        a(paramIntent.getStringExtra("newItemUrl"), paramIntent.getStringExtra("tweetId"), paramIntent.getBooleanExtra("isGivenUrlTwitterUrl", false));
        return 1;
      }
    } while (!"com.pocket.service.AddOverlayService.dismiss".equals(str));
    a(true);
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/AddOverlayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */