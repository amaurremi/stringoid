package com.pocket.q.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.h.l;

public class g
  extends a
{
  private final b g;
  private final h i;
  private boolean j;
  
  @Deprecated
  public g(com.ideashower.readitlater.activity.h paramh, b paramb, String paramString, SparseArray paramSparseArray, h paramh1, s params)
  {
    super(paramh, paramString, paramSparseArray, null, params);
    if (paramb == null) {
      throw new NullPointerException("pref cannot be null");
    }
    this.g = paramb;
    this.i = paramh1;
    this.j = com.ideashower.readitlater.h.i.a(paramb);
  }
  
  public o a(Context paramContext)
  {
    return new i(paramContext);
  }
  
  public void a(o paramo)
  {
    paramo = (i)paramo;
    paramo.setLabel(e());
    paramo.setDescription(f());
    if ((b()) && (g())) {}
    for (boolean bool = true;; bool = false)
    {
      paramo.setChecked(bool);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = com.ideashower.readitlater.h.i.a(this.g);
    if (bool != this.j)
    {
      this.j = bool;
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    return 2;
  }
  
  public String f()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (this.e != null)
    {
      if (this.e.size() == 0) {
        localObject2 = localObject1;
      }
    }
    else {
      return (String)localObject2;
    }
    if (b())
    {
      localObject1 = localObject3;
      if (!g()) {}
    }
    for (localObject1 = (String)this.e.get(c);; localObject1 = (String)this.e.get(a))
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return (String)this.e.get(b);
    }
  }
  
  protected boolean g()
  {
    return this.j;
  }
  
  public void onClick(View paramView)
  {
    int k = 0;
    if (!this.j) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.i == null) || (this.i.a(bool))) {
        k = 1;
      }
      if (k != 0)
      {
        this.j = bool;
        com.ideashower.readitlater.h.i.b().a(this.g, bool).a();
        if (this.i != null) {
          this.i.b(bool);
        }
        this.h.g(true);
      }
      if (k != 0) {
        ((i)paramView).setChecked(this.j);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */