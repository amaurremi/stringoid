package com.pocket.q.a;

import android.util.SparseArray;
import com.ideashower.readitlater.activity.h;
import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.h.i;

public abstract class u
{
  protected final h b;
  protected final String c;
  protected final SparseArray d = new SparseArray();
  protected s e;
  
  private u(h paramh, String paramString)
  {
    this.b = paramh;
    this.c = paramString;
  }
  
  public u b(final b paramb, final boolean paramBoolean)
  {
    this.e = new s()
    {
      public boolean a()
      {
        return i.a(paramb) == paramBoolean;
      }
    };
    return this;
  }
  
  public u b(String paramString)
  {
    this.d.put(a.b, paramString);
    return this;
  }
  
  public u c(int paramInt)
  {
    this.d.put(a.a, p.a(paramInt));
    return this;
  }
  
  public u d(int paramInt)
  {
    return b(p.a(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */