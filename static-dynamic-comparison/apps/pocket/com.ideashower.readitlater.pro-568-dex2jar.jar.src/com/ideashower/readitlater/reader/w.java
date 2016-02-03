package com.ideashower.readitlater.reader;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.b.a.c;
import com.google.android.b.a.d;
import com.google.android.b.a.e;
import com.google.android.b.a.f;
import com.google.android.b.a.h;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.activity.ap;
import com.ideashower.readitlater.activity.aw;
import com.ideashower.readitlater.views.BaseWebView;
import com.pocket.widget.p;

public class w
  implements e, f, com.google.android.b.a.g, h, ap, l, p
{
  protected c a;
  protected boolean b;
  private com.google.android.b.a.j c;
  private FrameLayout d;
  private FrameLayout e;
  private FrameLayout f;
  private final ReaderFragment g;
  private final com.ideashower.readitlater.activity.a h;
  private int i = 1;
  private int j = 1;
  private com.ideashower.readitlater.e.b k;
  private com.ideashower.readitlater.e.b l;
  private boolean m;
  private boolean n;
  private int o;
  
  public w(ReaderFragment paramReaderFragment)
  {
    this.g = paramReaderFragment;
    this.h = com.ideashower.readitlater.activity.a.a(paramReaderFragment.m());
  }
  
  private void a(com.ideashower.readitlater.e.b paramb)
  {
    if ((this.h == null) || (this.h.isFinishing())) {
      return;
    }
    if ((p()) && (this.a != null))
    {
      this.i = 3;
      this.l = paramb;
      this.k = null;
      b(2);
      this.a.a(paramb.c());
      this.g.ad();
    }
    for (;;)
    {
      this.g.aq().a(false);
      this.g.ak().setVisibility(8);
      this.g.Z();
      this.h.u().a(false, false);
      return;
      this.i = 2;
      this.l = null;
      this.k = paramb;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (com.google.android.b.a.a.a(paramContext) != com.google.android.b.a.b.a) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    if (paramInt == 4) {
      throw new RuntimeException("this value may only be set within setMode");
    }
    if (paramInt == 1) {}
    for (;;)
    {
      this.j = paramInt;
      return;
      if (paramInt == 3)
      {
        if (this.j == 4)
        {
          this.j = 3;
        }
        else
        {
          if ((this.a != null) && (this.a.d())) {
            this.a.c();
          }
          for (;;)
          {
            com.ideashower.readitlater.util.z.a(this.d, this.f);
            break;
            this.j = 4;
          }
        }
      }
      else if (paramInt == 2)
      {
        com.ideashower.readitlater.util.z.a(this.d, this.e);
        this.g.aD();
      }
    }
  }
  
  private boolean p()
  {
    if (this.c != null) {
      return true;
    }
    if ((this.h == null) || (this.h.isFinishing())) {
      return false;
    }
    this.c = com.google.android.b.a.j.a();
    Object localObject = this.h.e().a();
    ((android.support.v4.app.n)localObject).a(4097);
    this.d = new FrameLayout(this.h);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.d.setLayoutParams(localLayoutParams);
    this.d.setId(4200);
    ((android.support.v4.app.n)localObject).a(this.d.getId(), this.c, "ytfrag");
    ((android.support.v4.app.n)localObject).a();
    this.e = new FrameLayout(this.h);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)this.h.getResources().getDimension(2131296395));
    this.h.v().addView(this.e, (ViewGroup.LayoutParams)localObject);
    this.f = new FrameLayout(this.h);
    ((ViewGroup)this.g.aw().getContent()).addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
    if (q()) {
      b(3);
    }
    for (;;)
    {
      this.c.a("AIzaSyBzQLRE2abaaJHfdfyJJXWRUUbjk97N3hc", this);
      return false;
      b(2);
    }
  }
  
  private boolean q()
  {
    return (this.g.ay() != null) && ((this.g.ay().g()) || (this.g.ay().h()));
  }
  
  private void r()
  {
    if (this.h.isFinishing()) {
      return;
    }
    this.o += 1;
    if (this.k != null) {}
    for (com.ideashower.readitlater.e.b localb = this.k;; localb = this.l)
    {
      c(true);
      a(localb);
      return;
    }
  }
  
  private void s()
  {
    this.o = 0;
    this.g.ac();
    c(false);
  }
  
  public void a()
  {
    if (this.j == 4)
    {
      this.a.c();
      b(3);
    }
    while (this.j != 3) {
      return;
    }
    b(2);
    this.a.b();
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (this.m == paramBoolean) {}
    do
    {
      return;
      this.m = paramBoolean;
    } while (this.e == null);
    paramView = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    if (paramBoolean) {}
    for (int i1 = this.g.ay().getCollapsedHeight();; i1 = 0)
    {
      paramView.bottomMargin = i1;
      this.e.setLayoutParams(paramView);
      return;
    }
  }
  
  public void a(d paramd) {}
  
  public void a(com.google.android.b.a.i parami, com.google.android.b.a.b paramb)
  {
    if (this.o >= 1)
    {
      s();
      return;
    }
    switch (3.a[paramb.ordinal()])
    {
    default: 
      s();
      return;
    case 1: 
    case 2: 
    case 3: 
      if (com.ideashower.readitlater.a.g.y()) {
        throw new RuntimeException("Youtube player failed with " + paramb.toString());
      }
      s();
      return;
    case 4: 
    case 5: 
      r();
      return;
    case 6: 
      r();
      return;
    case 7: 
    case 8: 
      s();
      return;
    case 9: 
    case 10: 
      s();
      return;
    }
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bZ))
    {
      s();
      return;
    }
    com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.bZ);
    new AlertDialog.Builder(this.h).setTitle(2131493184).setMessage(2131493183).setNegativeButton(2131492923, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        w.b(w.this);
      }
    }).setPositiveButton(2131492958, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        w.this.b = true;
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.youtube")).addFlags(524288);
        w.a(w.this).startActivity(paramAnonymousDialogInterface);
      }
    }).show();
  }
  
  public void a(com.google.android.b.a.i parami, c paramc, boolean paramBoolean)
  {
    this.a = paramc;
    a(this.k);
    paramc.a(8);
    paramc.a(this);
    paramc.a(this);
    paramc.a(this);
    this.g.ay().setOnDrawerOpenListener(this);
    this.g.ay().setOnVisibilityChangedListener(this);
    this.g.a(this);
    parami = this.g.ay();
    if (this.g.ay().getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(parami, paramBoolean);
      return;
    }
  }
  
  public void a(aw paramaw)
  {
    a((com.ideashower.readitlater.e.b)paramaw.a().valueAt(0));
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    Object localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    if (paramBoolean)
    {
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.h.x();
      if (!paramBoolean) {
        break label152;
      }
    }
    label152:
    for (int i1 = 8;; i1 = 0)
    {
      ((View)localObject).setVisibility(i1);
      i1 = this.j;
      b(2);
      if ((paramBoolean) && (i1 != 2))
      {
        this.a.a(false);
        this.a.a(true);
      }
      return;
      ((FrameLayout.LayoutParams)localObject).topMargin = ((int)this.h.getResources().getDimension(2131296395));
      if (this.g.ay().getVisibility() == 0) {}
      for (i1 = this.g.ay().getCollapsedHeight();; i1 = 0)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i1;
        break;
      }
    }
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (this.i == 1) {
      return;
    }
    b(1);
    this.i = 1;
    this.l = null;
    this.k = null;
    if (this.a != null) {
      this.a.a();
    }
    if ((this.c != null) && (!this.h.isFinishing()))
    {
      android.support.v4.app.n localn = this.h.e().a();
      localn.a(this.c);
      localn.b();
    }
    if (!paramBoolean) {
      this.o = 0;
    }
    this.c = null;
    this.a = null;
    this.b = false;
    this.g.aq().a(true);
    this.g.ak().setVisibility(0);
    this.g.ay().setOnDrawerOpenListener(null);
    this.g.ay().setOnVisibilityChangedListener(null);
    this.g.a(null);
    this.h.u().a(true, false);
    this.h.v().removeView(this.e);
    ((ViewGroup)this.g.aw().getContent()).removeView(this.f);
    this.n = false;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    b(3);
  }
  
  public void i()
  {
    b(2);
  }
  
  public void j()
  {
    if (this.b)
    {
      this.b = false;
      r();
    }
  }
  
  public void k()
  {
    b(3);
  }
  
  public void l()
  {
    b(3);
  }
  
  public void m()
  {
    b(2);
  }
  
  public boolean n()
  {
    boolean bool = false;
    if (this.n)
    {
      this.a.a(false);
      bool = true;
    }
    return bool;
  }
  
  public void o()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */