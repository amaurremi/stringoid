package com.ideashower.readitlater.reader;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.j;
import com.pocket.b.b;
import com.pocket.i.a.p;
import com.pocket.widget.ar;

public class t
{
  private final ReaderFragment a;
  private final ViewGroup b;
  private final boolean c;
  private View d;
  private String e;
  
  public t(ReaderFragment paramReaderFragment, ViewGroup paramViewGroup)
  {
    this.a = paramReaderFragment;
    this.b = paramViewGroup;
    this.c = com.ideashower.readitlater.a.c.a(paramReaderFragment.m());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j.a(280.0F), -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    float f;
    if (j.c())
    {
      f = 100.0F;
      localLayoutParams.bottomMargin = j.a(f);
      if (!i.a(com.ideashower.readitlater.h.a.bX)) {
        break label83;
      }
    }
    label83:
    for (Object localObject = null;; localObject = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            t.b(t.this);
          }
        })
    {
      a(paramInt1, paramInt2, 2131492924, 0, (View.OnClickListener)localObject, localLayoutParams, 444L);
      return;
      f = 33.0F;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, final View.OnClickListener paramOnClickListener, RelativeLayout.LayoutParams paramLayoutParams, long paramLong)
  {
    paramOnClickListener = ar.a(this.a.m(), this.b, paramInt1, paramInt2, paramInt4, paramInt3, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        t.a(t.this, true);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(paramAnonymousView);
        }
      }
    });
    paramOnClickListener.setClickable(true);
    p localp = (p)paramOnClickListener.getBackground();
    localp.a(230);
    localp.a(true);
    com.b.c.a.b(paramOnClickListener, 0.85F);
    com.b.c.a.c(paramOnClickListener, 0.85F);
    com.b.c.a.a(paramOnClickListener, 0.0F);
    this.b.addView(paramOnClickListener, paramLayoutParams);
    this.d = paramOnClickListener;
    com.b.c.c.a(paramOnClickListener).k(1.0F).g(1.0F).i(1.0F).a(new DecelerateInterpolator()).a(444L).b(paramLong);
  }
  
  private void a(String paramString)
  {
    this.e = paramString;
    v.d(paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    v.e(this.e);
    this.e = null;
    final View localView = this.d;
    this.d = null;
    if (paramBoolean)
    {
      com.b.c.c.a(localView).k(0.0F).a(new DecelerateInterpolator()).a(333L).b(0L).a(new b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          t.a(t.this).removeView(localView);
        }
      });
      return;
    }
    this.b.removeView(localView);
  }
  
  private void b()
  {
    i.b(com.ideashower.readitlater.h.a.bX);
    this.a.aw().a(false, true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j.a(280.0F), -2);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    localLayoutParams.topMargin = j.a(60.0F);
    localLayoutParams.rightMargin = j.a(10.0F);
    a(2131493609, 2131493607, 2131492924, 36, null, localLayoutParams, 0L);
    a("reader_tooltip_organize_article");
  }
  
  public void a()
  {
    if (!this.c) {
      return;
    }
    a(true);
  }
  
  public void a(int paramInt)
  {
    if (!this.c) {}
    do
    {
      return;
      if ((paramInt == 1) && (!i.a(com.ideashower.readitlater.h.a.bV))) {
        break;
      }
    } while ((paramInt != 2) || (i.a(com.ideashower.readitlater.h.a.bW)));
    i.b(com.ideashower.readitlater.h.a.bW);
    a(2131493614, 2131493613);
    a("reader_tooltip_intro_web");
    return;
    i.b(com.ideashower.readitlater.h.a.bV);
    if (j.c()) {}
    for (paramInt = 2131493612;; paramInt = 2131493610)
    {
      a(2131493611, paramInt);
      a("reader_tooltip_intro_article");
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */