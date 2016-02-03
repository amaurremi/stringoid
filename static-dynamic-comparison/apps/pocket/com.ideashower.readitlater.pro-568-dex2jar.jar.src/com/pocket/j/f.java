package com.pocket.j;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.b.c.c;
import com.ideashower.readitlater.e.g;
import com.pocket.p.w;
import java.util.ArrayList;

class f
  extends BaseAdapter
{
  private final int b;
  
  private f(b paramb)
  {
    this.b = paramb.getResources().getDimensionPixelSize(2131296305);
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() instanceof c))
    {
      ((c)paramView.getTag()).a();
      if (!com.ideashower.readitlater.util.a.h()) {}
    }
  }
  
  private void a(ViewGroup paramViewGroup, a parama, long paramLong)
  {
    a(parama);
    a(paramViewGroup);
    com.b.c.a.b(paramViewGroup, 0.75F);
    com.b.c.a.c(paramViewGroup, 0.75F);
    if (com.ideashower.readitlater.util.a.i())
    {
      paramViewGroup.setTag(c.a(paramViewGroup).a(333L).b(paramLong).a(new OvershootInterpolator()).g(1.0F).i(1.0F));
      com.b.c.a.a(parama, 0.0F);
      parama.setTag(c.a(parama).a(166L).b(paramLong).a(new AccelerateInterpolator()).k(1.0F));
      return;
    }
    paramViewGroup.setTag(c.a(paramViewGroup).a(333L).b(paramLong).a(new AccelerateDecelerateInterpolator()).g(1.0F).i(1.0F).k(1.0F));
  }
  
  public e a(int paramInt)
  {
    return (e)b.d(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return b.d(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    g localg;
    com.pocket.m.a.a locala;
    int i;
    if (paramView != null)
    {
      paramViewGroup = (ViewGroup)paramView;
      paramView = (a)paramViewGroup.getChildAt(0);
      e locale = (e)b.d(this.a).get(paramInt);
      localg = locale.a();
      locala = e.b(locale);
      i = e.c(locale);
      if (paramInt != 0) {
        break label216;
      }
    }
    long l3;
    label216:
    for (boolean bool = true;; bool = false)
    {
      paramView.a(localg, locala, i, bool);
      if ((b.c()) && (b.e(this.a).a(paramInt) == 0L))
      {
        l3 = System.currentTimeMillis();
        l1 = b.e(this.a).a(paramInt - 1, 0L);
        if ((l1 <= 0L) || (333L + l1 >= l3)) {
          break label222;
        }
        b.e(this.a).b(paramInt, l1);
        a(paramView);
        a(paramViewGroup);
      }
      return paramViewGroup;
      paramViewGroup = new FrameLayout(this.a.getContext());
      paramViewGroup.setPadding(this.b, 0, this.b, this.b);
      paramView = new a(this.a.getContext());
      paramViewGroup.addView(paramView);
      break;
    }
    label222:
    long l2 = l1 + 190L - l3;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    b.e(this.a).b(paramInt, l3 + l1);
    a(paramViewGroup, paramView, l1);
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/j/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */