package com.ideashower.readitlater.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.service.WakefulAppService;
import com.ideashower.readitlater.util.y;
import com.ideashower.readitlater.views.RainbowBar;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.u;
import com.pocket.p.s;
import com.pocket.widget.RainbowProgressCircleView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends android.support.v4.app.f
  implements com.pocket.p.t
{
  private BroadcastReceiver A;
  private BroadcastReceiver B;
  private final String C = "killApp";
  private RelativeLayout D;
  private int E;
  private ResizeDetectRelativeLayout F;
  private int G;
  private boolean H;
  private Toast I;
  private String J;
  private String K;
  private c L;
  private Menu M;
  private final com.pocket.app.b N = new com.pocket.app.b(super.e(), this);
  private boolean O;
  protected ViewGroup n = null;
  protected RelativeLayout o;
  protected RainbowProgressCircleView p;
  protected ImageView q;
  protected boolean r = false;
  protected boolean s = false;
  protected boolean t = false;
  protected com.ideashower.readitlater.views.z u = null;
  protected Handler v;
  protected FrameLayout w;
  protected boolean x = true;
  protected ArrayList y = new ArrayList();
  private final ArrayList z = new ArrayList();
  
  private void C()
  {
    Drawable localDrawable = m();
    if (localDrawable != null) {
      a(localDrawable);
    }
  }
  
  private void D()
  {
    if ((this.F == null) || (this.F.getVisibility() == 8) || (!this.H)) {
      return;
    }
    this.H = false;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.F.getHeight());
    localTranslateAnimation.setDuration(333L);
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        a.a(a.this).setVisibility(8);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.F.startAnimation(localTranslateAnimation);
  }
  
  private void E()
  {
    if (this.A != null)
    {
      unregisterReceiver(this.A);
      this.A = null;
    }
    if (this.B != null)
    {
      unregisterReceiver(this.B);
      this.B = null;
    }
  }
  
  @SuppressLint({"ShowToast"})
  public static Toast a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    a locala = (a)paramContext;
    if (locala.I == null)
    {
      if (paramString != null) {
        locala.I = Toast.makeText(paramContext, paramString, paramInt2);
      }
    }
    else
    {
      locala.I.setDuration(paramInt2);
      if (paramString == null) {
        break label71;
      }
      locala.I.setText(paramString);
    }
    for (;;)
    {
      return locala.I;
      locala.I = Toast.makeText(paramContext, paramInt1, paramInt2);
      break;
      label71:
      locala.I.setText(paramInt1);
    }
  }
  
  public static a a(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof a))) {
      return (a)paramContext;
    }
    return null;
  }
  
  private void a(b paramb)
  {
    IntentFilter localIntentFilter;
    if (paramb != b.d)
    {
      localIntentFilter = null;
      if (paramb != b.a) {
        break label131;
      }
      if ((as.l()) || (this.t)) {
        break label125;
      }
      finish();
      paramb = localIntentFilter;
    }
    for (;;)
    {
      if ((paramb != null) && (this.A == null))
      {
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(paramb);
        this.A = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            a.this.finish();
          }
        };
        registerReceiver(this.A, localIntentFilter);
      }
      if (this.B == null)
      {
        paramb = new IntentFilter();
        paramb.addAction("com.ideashower.readitlater.ACTION_SHUTDOWN");
        this.B = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            a.this.finish();
            if (paramAnonymousIntent.getBooleanExtra("killApp", false)) {
              Process.killProcess(Process.myPid());
            }
          }
        };
        registerReceiver(this.B, paramb);
      }
      return;
      label125:
      paramb = "com.ideashower.readitlater.ACTION_LOGOUT";
      continue;
      label131:
      if (as.l())
      {
        if (paramb == b.c) {
          q();
        }
        finish();
        paramb = localIntentFilter;
      }
      else
      {
        paramb = "com.ideashower.readitlater.ACTION_LOGIN";
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, g.b().l()));
  }
  
  private void b(final String paramString)
  {
    if (this.F == null)
    {
      this.F = ((ResizeDetectRelativeLayout)((ViewStub)findViewById(2131230947)).inflate());
      localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      this.F.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.b(a.this);
        }
      });
      this.F.setPadding(com.ideashower.readitlater.util.j.a(11.0F), com.ideashower.readitlater.util.j.a(16.0F), com.ideashower.readitlater.util.j.a(11.0F), com.ideashower.readitlater.util.j.a(16.0F));
      this.F.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (RilButton)this.F.findViewById(2131230774);
    ((RilButton)localObject).setStyle(RilButton.f);
    ((RilButton)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new com.ideashower.readitlater.db.operation.action.d(false, paramString, null, UiContext.a(UiTrigger.a));
        paramAnonymousView.a(true);
        int i;
        switch (paramAnonymousView.k())
        {
        default: 
          i = 2131493729;
        }
        for (;;)
        {
          Toast.makeText(a.this, i, 0).show();
          a.b(a.this);
          return;
          i = 2131493731;
          continue;
          i = 2131493730;
        }
      }
    });
    ((TextView)this.F.findViewById(2131230903)).setText(paramString.replaceAll("https?:\\/\\/(www.)?", ""));
    this.F.setVisibility(4);
    if (this.F.getHeight() == 0)
    {
      this.F.setOnResizeListener(new u()
      {
        public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          a.a(a.this, paramString);
          a.a(a.this).setOnResizeListener(null);
        }
      });
      return;
    }
    this.H = true;
    paramString = new TranslateAnimation(0.0F, 0.0F, this.F.getHeight(), 0.0F);
    paramString.setDuration(333L);
    this.F.setVisibility(0);
    this.F.startAnimation(paramString);
    this.v.postDelayed(new Runnable()
    {
      public void run()
      {
        a.b(a.this);
      }
    }, 10000L);
  }
  
  private void d(int paramInt)
  {
    if (m.a(paramInt)) {}
    for (paramInt = 2131558455;; paramInt = 2131558454)
    {
      setTheme(paramInt);
      return;
    }
  }
  
  public void A() {}
  
  public void B() {}
  
  public Fragment a(View paramView)
  {
    Iterator localIterator = k().f().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (!com.pocket.p.k.a(localFragment))
      {
        View localView = com.pocket.p.k.c(localFragment);
        if ((localView != null) && (com.ideashower.readitlater.util.z.b(localView, paramView))) {
          return localFragment;
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    d(paramInt);
    com.ideashower.readitlater.util.z.d(this.w.getRootView());
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      com.ideashower.readitlater.views.t localt = (com.ideashower.readitlater.views.t)((WeakReference)localIterator.next()).get();
      if (localt != null) {
        localt.c();
      }
    }
    C();
    this.E = paramInt;
    this.N.a(paramInt);
  }
  
  protected void a(Drawable paramDrawable)
  {
    getWindow().setBackgroundDrawable(paramDrawable);
  }
  
  public final void a(Fragment paramFragment, String paramString)
  {
    this.O = true;
    com.pocket.p.k.a(paramFragment, this, 2131230763, paramString, false);
  }
  
  public final void a(Fragment paramFragment, String paramString, com.pocket.p.l paraml)
  {
    if (paraml == com.pocket.p.l.b)
    {
      b(paramFragment);
      return;
    }
    if ((paraml == com.pocket.p.l.c) || (paraml == com.pocket.p.l.a))
    {
      if (com.ideashower.readitlater.util.j.g())
      {
        paraml = new RainbowBar(this);
        paraml.getRainbow().a(false);
        paraml.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(paraml);
        com.pocket.p.k.a((android.support.v4.app.d)paramFragment, this, paramString);
        k().a(new android.support.v4.app.k()
        {
          public void e()
          {
            com.pocket.app.b localb = a.this.k();
            if ((localb.c() == 0) || (localb.d().isEmpty())) {
              a.this.finish();
            }
          }
        });
        return;
      }
      a(paramFragment, paramString);
      return;
    }
    throw new RuntimeException("unexpected mode");
  }
  
  public final void a(Fragment paramFragment, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.O = true;
    com.pocket.p.k.a(paramFragment, this, 2131230763, paramString, paramBoolean1, paramBoolean2);
  }
  
  protected void a(Menu paramMenu)
  {
    paramMenu.add(-1, 1, 1, getString(2131493476)).setIcon(2130837671);
    if (!this.t) {
      paramMenu.add(-1, 2, 2, getString(2131493459)).setIcon(2130837663);
    }
  }
  
  public void a(c paramc)
  {
    this.L = paramc;
  }
  
  public void a(d paramd)
  {
    this.z.add(paramd);
  }
  
  public void a(com.ideashower.readitlater.views.t paramt)
  {
    this.y.add(new WeakReference(paramt));
  }
  
  public void a(s params)
  {
    Iterator localIterator = k().g().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof com.pocket.p.t)) {
        ((com.pocket.p.t)localFragment).a(params);
      }
    }
  }
  
  protected void a(final Runnable paramRunnable)
  {
    ((com.ideashower.readitlater.views.x)this.n).setOnResizeListener(new u()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousView.getWidth() > 0)
        {
          paramRunnable.run();
          ((com.ideashower.readitlater.views.x)a.this.n).setOnResizeListener(null);
        }
      }
    });
  }
  
  public void a(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    int j = 0;
    if (!paramBoolean1) {
      i();
    }
    if ((this.o == null) && (!paramBoolean1)) {}
    label255:
    do
    {
      return;
      if (this.o == null)
      {
        if (!h())
        {
          a(new Runnable()
          {
            public void run()
            {
              a.this.a(paramBoolean1, paramBoolean2, paramBoolean3);
            }
          });
          return;
        }
        this.o = ((RelativeLayout)((ViewStub)findViewById(2131230951)).inflate());
        this.p = ((RainbowProgressCircleView)this.o.findViewById(2131230758));
        this.q = ((ImageView)this.o.findViewById(2131230815));
        localObject = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        i = ((Rect)localObject).top;
        int k = (int)getResources().getDimension(2131296383);
        localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, k + i);
        this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.q.setVisibility(0);
      }
      Object localObject = this.p;
      if (paramBoolean2)
      {
        i = 0;
        ((RainbowProgressCircleView)localObject).setVisibility(i);
        if (paramBoolean3) {
          continue;
        }
        localObject = this.o;
        if (!paramBoolean1) {
          break label255;
        }
      }
      for (int i = j;; i = 8)
      {
        ((RelativeLayout)localObject).setVisibility(i);
        return;
        i = 8;
        break;
      }
    } while ((paramBoolean1) || (this.o.getVisibility() != 0));
    com.ideashower.readitlater.util.z.b(this.o, paramBoolean1);
  }
  
  protected boolean a(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 1: 
      ak.a(this);
      return true;
    }
    x.a(this);
    return true;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.O = true;
    this.n.addView(paramView, paramLayoutParams);
  }
  
  public void b(int paramInt) {}
  
  public final void b(Fragment paramFragment)
  {
    a(paramFragment, null);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("killApp", paramBoolean);
    localIntent.setAction("com.ideashower.readitlater.ACTION_SHUTDOWN");
    sendBroadcast(localIntent);
  }
  
  public void c(int paramInt)
  {
    int i = m.a(this);
    this.G = paramInt;
    paramInt = m.a(this);
    if (paramInt != i) {
      this.N.a(paramInt);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!as.l()) {}
    String str;
    int i;
    do
    {
      do
      {
        return;
        str = y.b(com.ideashower.readitlater.objects.e.a(this).a());
      } while (str == null);
      i = str.hashCode();
    } while (i == com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ba));
    if (!paramBoolean) {
      b(str);
    }
    com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.ba, i).a();
  }
  
  protected Drawable d(boolean paramBoolean)
  {
    Object localObject = getWindowManager().getDefaultDisplay();
    int i = ((Display)localObject).getWidth();
    int j = ((Display)localObject).getHeight();
    float f2 = i / 2;
    float f3 = j / 2;
    float f1;
    ShapeDrawable localShapeDrawable;
    if (f2 > f3)
    {
      f1 = f2;
      f1 = (float)(f1 * 0.86D);
      localShapeDrawable = new ShapeDrawable(new RectShape());
      localShapeDrawable.setDither(true);
      if (!paramBoolean) {
        break label129;
      }
    }
    label129:
    for (localObject = "#464545";; localObject = "#424141")
    {
      localShapeDrawable.getPaint().setShader(new RadialGradient(f2, f3, f1, Color.parseColor((String)localObject), Color.parseColor("#313131"), Shader.TileMode.CLAMP));
      return localShapeDrawable;
      f1 = f3;
      break;
    }
  }
  
  public android.support.v4.app.j e()
  {
    return this.N;
  }
  
  public abstract String f();
  
  public void finish()
  {
    E();
    super.finish();
  }
  
  protected int g()
  {
    return 1;
  }
  
  protected boolean h()
  {
    return this.n.getWidth() > 0;
  }
  
  protected void i()
  {
    ((com.ideashower.readitlater.views.x)this.n).setOnResizeListener(null);
  }
  
  protected void j()
  {
    com.ideashower.readitlater.a.k.a(this);
  }
  
  public com.pocket.app.b k()
  {
    return this.N;
  }
  
  protected abstract b l();
  
  protected Drawable m()
  {
    return new ColorDrawable(m.c(this));
  }
  
  protected Menu n()
  {
    return this.M;
  }
  
  protected boolean o()
  {
    return (this.x) && (!p());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = k().f().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof f)) {
        ((f)localFragment).b(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.H) {
      D();
    }
    while (this.N.h()) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.u.a(paramConfiguration);
    C();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (g.y()) {
      com.ideashower.readitlater.util.e.a(getResources());
    }
    g.b(this);
    com.ideashower.readitlater.util.j.b();
    this.u = new com.ideashower.readitlater.views.z(this);
    super.onCreate(paramBundle);
    this.G = g();
    this.E = m.a(this);
    this.v = new Handler();
    d(m.a(this));
    if (this.O) {
      com.ideashower.readitlater.util.e.a("You must call the super.onCreate() of AbsPocketActivity before calling setContentView");
    }
    super.setContentView(2130903100);
    this.w = ((FrameLayout)findViewById(2131230918));
    this.n = ((ViewGroup)findViewById(2131230763));
    C();
    if (this.u != null) {
      this.u.a(this.v);
    }
    if (!isFinishing()) {
      a(l());
    }
    if (paramBundle != null) {
      k().b(paramBundle);
    }
    j();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(paramBundle);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.M = paramMenu;
    if (this.L != null) {
      this.L.a(paramMenu);
    }
    a(paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    E();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).f();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((this.L != null) && (this.L.a(paramMenuItem))) {}
    while ((a(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem))) {
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    if (this.u != null) {
      this.u.c();
    }
    g.d(null);
    super.onPause();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).d();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.M = paramMenu;
    boolean bool = o();
    paramMenu.setGroupVisible(-1, bool);
    paramMenu.setGroupVisible(-2, bool);
    if (this.L != null) {
      this.L.b(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onRestart()
  {
    a(l());
    if (this.u != null) {
      this.u.a();
    }
    super.onRestart();
    int i = m.a(this);
    if (this.E != i)
    {
      this.E = i;
      this.N.a(i);
    }
    j();
    this.N.i();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  public void onResume()
  {
    g.d(this);
    super.onResume();
    if (this.u != null) {
      this.u.b();
    }
    c(false);
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).c();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    k().a(paramBundle);
  }
  
  public boolean onSearchRequested()
  {
    if (!o()) {}
    return false;
  }
  
  protected void onStart()
  {
    super.onStart();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).b();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (g.n() == null)
    {
      g.a(false);
      WakefulAppService.c();
    }
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).e();
    }
  }
  
  protected boolean p()
  {
    return ((this.D != null) && (this.D.getVisibility() == 0)) || ((this.o != null) && (this.o.getVisibility() == 0));
  }
  
  public void q()
  {
    b(this);
  }
  
  public void r()
  {
    this.n.setVisibility(4);
  }
  
  public int s()
  {
    return this.G;
  }
  
  public final void setContentView(int paramInt)
  {
    this.O = true;
    getLayoutInflater().inflate(paramInt, this.n);
  }
  
  public final void setContentView(View paramView)
  {
    this.O = true;
    this.n.addView(paramView);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.O = true;
    this.n.addView(paramView, paramLayoutParams);
  }
  
  public boolean t()
  {
    return false;
  }
  
  public com.ideashower.readitlater.views.z u()
  {
    return this.u;
  }
  
  public ViewGroup v()
  {
    return this.w;
  }
  
  public int w()
  {
    return m.a(this);
  }
  
  public View x()
  {
    return this.n;
  }
  
  public UiContext y()
  {
    Object localObject = getIntent();
    this.J = ((Intent)localObject).getStringExtra("com.pocket.external.extra.package");
    this.K = ((Intent)localObject).getStringExtra("com.pocket.external.extra.view");
    if (this.J == null)
    {
      Log.w("Pocket", "Missing intent extra which declares the package name of the application that wants to launch Pocket.");
      return null;
    }
    if (this.K == null)
    {
      Log.w("Pocket", "Missing intent extra which declares the description of the view/trigger which caused your app to start Pocket.");
      return null;
    }
    String str = this.J;
    localObject = str;
    if (str.equalsIgnoreCase("com.kobo.launcher")) {
      localObject = "Kobo";
    }
    localObject = org.apache.a.c.k.a((String)localObject, 10) + "|";
    return UiContext.a(UiTrigger.a((String)localObject + org.apache.a.c.k.a(this.K, 20 - ((String)localObject).length())));
  }
  
  public UiContext z()
  {
    UiContext localUiContext = y();
    if (localUiContext != null) {
      return localUiContext;
    }
    if (getIntent() != null) {
      return (UiContext)getIntent().getParcelableExtra("com.pocket.extra.uiContext");
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */