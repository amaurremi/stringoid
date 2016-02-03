package com.pocket.q.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.ideashower.readitlater.activity.h;

public class a
  extends n
{
  public static int a = -1;
  public static int b = 0;
  public static int c = 1;
  protected final String d;
  protected final SparseArray e;
  protected final s f;
  private final b g;
  
  @Deprecated
  public a(h paramh, String paramString, SparseArray paramSparseArray, b paramb, s params)
  {
    super(paramh);
    if (paramString == null) {
      throw new NullPointerException("label cannot be null");
    }
    this.d = paramString;
    this.e = paramSparseArray;
    this.f = params;
    this.g = paramb;
  }
  
  public o a(Context paramContext)
  {
    return new c(paramContext);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.e.put(paramInt, paramString);
  }
  
  public void a(o paramo)
  {
    paramo = (c)paramo;
    paramo.setLabel(this.d);
    paramo.setDescription(f());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    if (!c()) {
      return false;
    }
    if (this.f != null) {
      return this.f.a();
    }
    return true;
  }
  
  public boolean c()
  {
    return this.g != null;
  }
  
  public int d()
  {
    return 1;
  }
  
  protected String e()
  {
    return this.d;
  }
  
  public String f()
  {
    Object localObject;
    if ((this.e == null) || (this.e.size() == 0)) {
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      if (b()) {
        return (String)this.e.get(b);
      }
      str = (String)this.e.get(a);
      localObject = str;
    } while (str != null);
    return (String)this.e.get(b);
  }
  
  public void onClick(View paramView)
  {
    if (this.g != null) {
      this.g.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */