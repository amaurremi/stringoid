package com.pocket.list.widget.b.c;

import android.content.res.Resources;
import com.ideashower.readitlater.util.e;
import com.pocket.p.n;

class b
{
  private final String b;
  private final int c;
  private final String d;
  private final String e;
  private String f;
  private int g;
  private int h;
  private int i;
  private int j;
  private boolean k;
  
  private b(a parama, Resources paramResources)
  {
    if (a.a(parama) == 0) {
      e.a("mNumberWidth must be setup first");
    }
    this.b = paramResources.getString(2131493727);
    this.c = (a.a(parama, this.b) + a.a(parama));
    this.d = paramResources.getString(2131493725);
    this.e = paramResources.getString(2131493726);
  }
  
  public void a()
  {
    this.f = null;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4)
  {
    a();
    int n = paramInt2;
    int m = 0;
    int i1 = paramInt3;
    paramInt3 = n;
    if (paramInt3 > 0)
    {
      if (this.c + a.a(this.a) * n.a(paramInt1 - paramInt3) < paramInt4)
      {
        this.h = (paramInt1 - paramInt3);
        this.f = String.format(this.b, new Object[] { Integer.valueOf(this.h) });
        this.g = a.a(this.a, this.f);
        this.j = (paramInt4 - this.g);
        this.i = m;
        label108:
        return;
      }
      i1 -= 1;
      int i2 = paramArrayOfInt[(paramInt3 - 1)];
      n = i2;
      if (i1 > 0) {
        n = i2 + a.e();
      }
      if (i1 >= 0) {}
    }
    else
    {
      this.h = (paramInt1 - (paramInt2 - m));
      if (this.h != 1) {
        break label238;
      }
    }
    label238:
    for (this.f = this.e;; this.f = String.format(this.d, new Object[] { Integer.valueOf(this.h) }))
    {
      this.g = a.a(this.a, this.f);
      this.j = (paramInt4 - this.g);
      this.i = m;
      if (this.g < paramInt4) {
        break label108;
      }
      this.k = true;
      return;
      paramInt4 += n;
      m += 1;
      paramInt3 -= 1;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */