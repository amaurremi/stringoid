package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class j
  implements ab
{
  private ac a;
  private int b;
  protected Context c;
  protected Context d;
  protected o e;
  protected LayoutInflater f;
  protected LayoutInflater g;
  protected ad h;
  private int i;
  private int j;
  
  public j(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.f = LayoutInflater.from(paramContext);
    this.b = paramInt1;
    this.i = paramInt2;
  }
  
  public ad a(ViewGroup paramViewGroup)
  {
    if (this.h == null)
    {
      this.h = ((ad)this.f.inflate(this.b, paramViewGroup, false));
      this.h.a(this.e);
      c(true);
    }
    return this.h;
  }
  
  public View a(s params, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof ae)) {}
    for (paramView = (ae)paramView;; paramView = b(paramViewGroup))
    {
      a(params, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, o paramo)
  {
    this.d = paramContext;
    this.g = LayoutInflater.from(this.d);
    this.e = paramo;
  }
  
  public void a(ac paramac)
  {
    this.a = paramac;
  }
  
  public void a(o paramo, boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramo, paramBoolean);
    }
  }
  
  public abstract void a(s params, ae paramae);
  
  protected void a(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.h).addView(paramView, paramInt);
  }
  
  public boolean a(int paramInt, s params)
  {
    return true;
  }
  
  public boolean a(ah paramah)
  {
    if (this.a != null) {
      return this.a.b(paramah);
    }
    return false;
  }
  
  public boolean a(o paramo, s params)
  {
    return false;
  }
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public ae b(ViewGroup paramViewGroup)
  {
    return (ae)this.f.inflate(this.i, paramViewGroup, false);
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public boolean b(o paramo, s params)
  {
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.h;
    if (localViewGroup == null) {}
    label193:
    label199:
    for (;;)
    {
      return;
      int m;
      if (this.e != null)
      {
        this.e.i();
        ArrayList localArrayList = this.e.h();
        int i1 = localArrayList.size();
        int n = 0;
        int k = 0;
        m = k;
        if (n < i1)
        {
          s locals2 = (s)localArrayList.get(n);
          if (!a(k, locals2)) {
            break label193;
          }
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof ae)) {}
          for (s locals1 = ((ae)localView1).getItemData();; locals1 = null)
          {
            View localView2 = a(locals2, localView1, localViewGroup);
            if (locals2 != locals1) {
              localView2.setPressed(false);
            }
            if (localView2 != localView1) {
              a(localView2, k);
            }
            k += 1;
            n += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (m >= localViewGroup.getChildCount()) {
          break label199;
        }
        if (!a(localViewGroup, m))
        {
          m += 1;
          continue;
          break;
          m = 0;
        }
      }
    }
  }
  
  public boolean g()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */