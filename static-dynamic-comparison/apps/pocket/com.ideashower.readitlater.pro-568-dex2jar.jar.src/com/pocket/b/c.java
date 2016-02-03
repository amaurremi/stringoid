package com.pocket.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import com.b.a.p;
import com.b.a.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c
{
  private long a;
  private ListView b;
  private d c;
  private List d = new ArrayList();
  private int e = 0;
  private DecelerateInterpolator f;
  private AccelerateInterpolator g;
  
  public c(ListView paramListView, d paramd)
  {
    this.a = paramListView.getContext().getResources().getInteger(17694720);
    this.b = paramListView;
    this.c = paramd;
    this.f = new DecelerateInterpolator();
    this.g = new AccelerateInterpolator();
  }
  
  private void a(final View paramView, int paramInt)
  {
    final ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    final int i = paramView.getHeight();
    p localp = p.a(new int[] { i, 1 }).a(this.a);
    localp.a(this.f);
    localp.a(new com.b.a.c()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        c.a(c.this);
        if (c.b(c.this) == 0)
        {
          Collections.sort(c.c(c.this));
          paramAnonymousa = new int[c.c(c.this).size()];
          int i = c.c(c.this).size() - 1;
          while (i >= 0)
          {
            paramAnonymousa[i] = i;
            i -= 1;
          }
          c.e(c.this).a(c.d(c.this), paramAnonymousa);
          paramAnonymousa = c.c(c.this).iterator();
          while (paramAnonymousa.hasNext())
          {
            e locale = (e)paramAnonymousa.next();
            com.b.c.a.a(locale.b, 1.0F);
            com.b.c.a.d(locale.b, 0.0F);
            ViewGroup.LayoutParams localLayoutParams = locale.b.getLayoutParams();
            localLayoutParams.height = i;
            locale.b.setLayoutParams(localLayoutParams);
          }
          c.c(c.this).clear();
        }
      }
    });
    localp.a(new r()
    {
      public void a(p paramAnonymousp)
      {
        localLayoutParams.height = ((Integer)paramAnonymousp.f()).intValue();
        paramView.setLayoutParams(localLayoutParams);
      }
    });
    this.d.add(new e(this, paramInt, paramView, null));
    localp.a();
  }
  
  private void a(final View paramView, final int paramInt, boolean paramBoolean, final f paramf)
  {
    int i = paramView.getWidth();
    this.e += 1;
    com.b.c.c localc = com.b.c.c.a(paramView);
    if (paramBoolean) {}
    for (float f1 = i;; f1 = -i)
    {
      localc.e(f1).k(0.0F).a(this.g).a(this.a).a(new com.b.a.c()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          c.a(c.this, paramView, paramInt);
          if (paramf != null) {
            paramf.a();
          }
        }
      });
      return;
    }
  }
  
  public void a(final View paramView, final int paramInt, final f paramf)
  {
    this.e += 1;
    com.b.c.c.a(paramView).k(0.0F).a(this.a).a(this.g).a(new com.b.a.c()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        c.a(c.this, paramView, paramInt);
        if (paramf != null) {
          paramf.a();
        }
      }
    });
  }
  
  public boolean a()
  {
    return this.e > 0;
  }
  
  public void b(View paramView, int paramInt, f paramf)
  {
    a(paramView, paramInt, false, paramf);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */