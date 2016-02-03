package com.pocket.gsf;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.b.c.c;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.ai;
import com.ideashower.readitlater.d.f;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.k;
import com.ideashower.readitlater.util.z;
import com.pocket.list.adapter.h;
import com.pocket.widget.ar;
import java.util.ArrayList;
import java.util.Iterator;

public class e
  extends FrameLayout
  implements com.pocket.list.adapter.e
{
  private static final ArrayList b = new ArrayList();
  private static boolean k = true;
  protected int a;
  private c c;
  private View d;
  private int e = 0;
  private String f;
  private final com.pocket.list.adapter.a g;
  private final com.pocket.list.widget.b h;
  private final ai i;
  private boolean j;
  
  public e(Context paramContext, ai paramai, com.pocket.list.adapter.a parama, com.pocket.list.widget.b paramb)
  {
    super(paramContext);
    this.i = paramai;
    this.g = parama;
    this.h = paramb;
    k = com.pocket.p.o.a(paramContext, new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:MoJHYNKmS2U")));
    parama.a(this);
  }
  
  public static void a()
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).d();
    }
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == 2) {
      a();
    }
  }
  
  private void a(View paramView)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131493304);
    localTextView.setTextColor(getResources().getColorStateList(2131165844));
    z.a(localTextView, 10.0F, 13.0F, 10.0F, 2.0F);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        v.b(e.g(e.this));
        k.a(5, (com.ideashower.readitlater.activity.a)e.this.getContext());
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2131230793);
    localLayoutParams.addRule(14);
    ((ViewGroup)paramView).addView(localTextView, localLayoutParams);
  }
  
  public static void a(com.ideashower.readitlater.e.o paramo)
  {
    int m = 1;
    if ((paramo == null) || (!paramo.M())) {}
    for (;;)
    {
      return;
      if (paramo.d(false)) {
        if (i.b(com.ideashower.readitlater.h.a.bM)) {}
      }
      while (m != 0)
      {
        a();
        return;
        m = 0;
        continue;
        if (paramo.L())
        {
          if (i.b(com.ideashower.readitlater.h.a.bL)) {
            m = 0;
          }
        }
        else {
          m = 0;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((!as.l()) || (!v.n()) || (!i.a(com.ideashower.readitlater.h.a.bP)) || (i.a(com.ideashower.readitlater.h.a.bR) != 0)) {}
    int m;
    do
    {
      return;
      m = i.a(com.ideashower.readitlater.h.a.bT);
      if (!paramBoolean)
      {
        i.b().a(com.ideashower.readitlater.h.a.bQ, m).a();
        return;
      }
    } while (i.a(com.ideashower.readitlater.h.a.bQ) != m);
    i.b().a(com.ideashower.readitlater.h.a.bR, m).a();
    a();
  }
  
  private void b(int paramInt)
  {
    this.d = d(paramInt);
    this.f = c(paramInt);
    v.a(this.f);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    float f1;
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.e == 1)
    {
      f1 = 200.0F;
      localLayoutParams.width = j.a(f1);
      localLayoutParams.leftMargin = 0;
      z.a(this, 10.0F, 10.0F, 10.0F, 10.0F);
      com.b.c.a.a(this.d, 0.0F);
      com.b.c.a.b(this.d, 0.8F);
      com.b.c.a.c(this.d, 0.8F);
      addView(this.d, localLayoutParams);
      c.a(this.d).g(1.0F).i(1.0F).k(1.0F).a(444L).b(750L).a(new DecelerateInterpolator()).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          e.d(e.this).notifyDataSetChanged();
        }
      });
      localLayoutParams1 = new RelativeLayout.LayoutParams(getLayoutParams());
      if (paramInt != 1) {
        break label264;
      }
      localLayoutParams1.addRule(10, -1);
      if ((j.c()) && (this.a > 0))
      {
        localLayoutParams.gravity = 51;
        localLayoutParams.leftMargin = (this.a / 2 - localLayoutParams.width / 2);
      }
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams1);
      this.d.setLayoutParams(localLayoutParams);
      ((View)getParent()).requestLayout();
      return;
      f1 = 270.0F;
      break;
      label264:
      localLayoutParams1.addRule(14, -1);
      localLayoutParams1.addRule(10, -1);
    }
  }
  
  private void b(final boolean paramBoolean)
  {
    if (i.a(com.ideashower.readitlater.h.a.bN)) {
      return;
    }
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      com.pocket.c.e.a("pocket_help", "browser-setup-gs-auto", bool, new f()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            i.b(com.ideashower.readitlater.h.a.bN);
          }
          while (!paramBoolean) {
            return;
          }
          e.b(e.this, 2131493202);
        }
      });
      return;
    }
  }
  
  private String c(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
      if (g.y()) {
        throw new RuntimeException("invalid state " + paramInt);
      }
    case 1: 
      localObject1 = "list_tooltip_view_item";
    case 0: 
      return (String)localObject1;
    case 2: 
      return "list_tooltip_save_more";
    case 3: 
      return "list_tooltip_save_article";
    case 4: 
      return "list_tooltip_save_video";
    case 5: 
      return "list_tooltip_keep_saving";
    case -1: 
      return "list_tooltip_need_help";
    }
    return "list_tooltip_other_devices";
  }
  
  private View d(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (this.e)
    {
    default: 
      localObject1 = localObject2;
      if (g.y()) {
        throw new RuntimeException("invalid state " + paramInt);
      }
    case 1: 
      localObject1 = ar.a(getContext(), this, 0, 2131493214, 36);
      ((TextView)((View)localObject1).findViewById(2131230793)).setGravity(1);
    case 0: 
      return (View)localObject1;
    case 2: 
      localObject1 = ar.a(getContext(), this, 2131493210, 2131493209, 0);
      a((View)localObject1);
      i.b(com.ideashower.readitlater.h.a.bP);
      return (View)localObject1;
    case 3: 
      localObject1 = ar.a(getContext(), this, 0, 2131493205, 0);
      a((View)localObject1);
      i.b(com.ideashower.readitlater.h.a.bP);
      return (View)localObject1;
    case 4: 
      localObject1 = ar.a(getContext(), this, 0, 2131493215, 0);
      a((View)localObject1);
      i.b(com.ideashower.readitlater.h.a.bP);
      return (View)localObject1;
    case 5: 
      localObject1 = ar.a(getContext(), this, 0, 2131493208, 0);
      a((View)localObject1);
      i.b(com.ideashower.readitlater.h.a.bP);
      return (View)localObject1;
    case -1: 
      ar.a(getContext(), this, 2131493213, 2131493212, 0, 2131493211, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          v.p();
          i.b().a(com.ideashower.readitlater.h.a.bR, -1).a();
          k.a(5, (com.ideashower.readitlater.activity.a)e.this.getContext());
          e.a();
        }
      });
    }
    b(false);
    ar.a(getContext(), this, 2131493207, 2131493206, 0, 2131492924, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        i.b().a(com.ideashower.readitlater.h.a.bJ, false).a();
        e.a();
        if (!i.a(com.ideashower.readitlater.h.a.bN)) {
          e.b(e.this, 2131493201);
        }
      }
    });
  }
  
  private void e()
  {
    if (this.d != null)
    {
      if (this.c != null) {
        return;
      }
      v.c(this.f);
      this.c = c.a(this.d).g(0.8F).i(0.8F).k(0.0F).a(333L).b(333L).a(new AccelerateDecelerateInterpolator()).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          e.a(e.this, null);
          e.this.removeView(e.a(e.this));
          e.a(e.this, null);
          if (e.b(e.this) != 0) {
            e.c(e.this);
          }
          e.d(e.this).notifyDataSetChanged();
        }
      });
      return;
    }
    if ((j.c()) && (this.e == 1))
    {
      this.g.a(new h()
      {
        public void a()
        {
          e.d(e.this).b(this);
          e.f(e.this).post(new Runnable()
          {
            public void run()
            {
              if ((e.e(e.this).Q()) || (e.b(e.this) != 1) || (e.a(e.this) != null)) {
                return;
              }
              if (e.d(e.this).getCount() != 1) {
                e.this.a = 0;
              }
              for (;;)
              {
                e.a(e.this, e.b(e.this));
                return;
                View localView = e.d(e.this).d(0);
                if (localView == null) {
                  e.this.a = 0;
                } else {
                  e.this.a = localView.getWidth();
                }
              }
            }
          });
        }
      });
      return;
    }
    b(this.e);
  }
  
  private void e(int paramInt)
  {
    new AlertDialog.Builder(getContext()).setTitle(2131493090).setMessage(paramInt).setPositiveButton(2131492932, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        e.a(e.this, true);
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        i.b(com.ideashower.readitlater.h.a.bN);
      }
    }).show();
  }
  
  public static int getListTooltipState()
  {
    int m = 1;
    if (!i.a(com.ideashower.readitlater.h.a.bJ)) {
      m = 0;
    }
    while (!i.a(com.ideashower.readitlater.h.a.bK)) {
      return m;
    }
    m = i.a(com.ideashower.readitlater.h.a.bT);
    if ((m > 0) && (i.a(com.ideashower.readitlater.h.a.bR) == m)) {
      return -1;
    }
    if (m < 4)
    {
      if (m <= 1) {
        return 2;
      }
      if (!i.a(com.ideashower.readitlater.h.a.bM)) {
        return 3;
      }
      if ((k) && (!i.a(com.ideashower.readitlater.h.a.bL))) {
        return 4;
      }
      if (m < 3) {
        return 5;
      }
    }
    return 6;
  }
  
  public void a(com.pocket.list.adapter.a parama)
  {
    if ((this.j) && (parama.getCount() > 0)) {
      g.o().post(new Runnable()
      {
        public void run()
        {
          e.this.d();
        }
      });
    }
  }
  
  public void b()
  {
    if (!b.contains(this))
    {
      b.add(this);
      d();
    }
  }
  
  public void c()
  {
    b.remove(this);
  }
  
  public void d()
  {
    if (b.isEmpty()) {}
    int m;
    do
    {
      return;
      m = getListTooltipState();
    } while ((m == this.e) && (!this.j));
    this.e = m;
    if (this.g.getCount() == 0)
    {
      this.j = true;
      return;
    }
    this.j = false;
    e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/gsf/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */