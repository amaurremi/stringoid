package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.an;

public abstract class e
{
  protected final d a;
  protected final int b;
  private final int c;
  
  public e(d paramd, int paramInt)
  {
    this.a = ((d)an.a(paramd));
    if ((paramInt >= 0) && (paramInt < paramd.g())) {}
    for (boolean bool = true;; bool = false)
    {
      an.a(bool);
      this.b = paramInt;
      this.c = paramd.a(this.b);
      return;
    }
  }
  
  protected long a(String paramString)
  {
    return this.a.a(paramString, this.b, this.c);
  }
  
  protected int b(String paramString)
  {
    return this.a.b(paramString, this.b, this.c);
  }
  
  protected boolean c(String paramString)
  {
    return this.a.d(paramString, this.b, this.c);
  }
  
  protected String d(String paramString)
  {
    return this.a.c(paramString, this.b, this.c);
  }
  
  protected Uri e(String paramString)
  {
    return this.a.f(paramString, this.b, this.c);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      bool1 = bool2;
      if (al.a(Integer.valueOf(((e)paramObject).b), Integer.valueOf(this.b)))
      {
        bool1 = bool2;
        if (al.a(Integer.valueOf(((e)paramObject).c), Integer.valueOf(this.c)))
        {
          bool1 = bool2;
          if (((e)paramObject).a == this.a) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean f(String paramString)
  {
    return this.a.g(paramString, this.b, this.c);
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), this.a });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */