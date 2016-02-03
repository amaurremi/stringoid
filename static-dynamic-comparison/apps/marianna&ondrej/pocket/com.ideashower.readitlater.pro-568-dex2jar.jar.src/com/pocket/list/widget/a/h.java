package com.pocket.list.widget.a;

import android.support.v4.view.bn;
import com.ideashower.readitlater.e.o;

class h
  implements bn
{
  public boolean a;
  private bn c;
  private int d;
  private int e;
  
  private h(c paramc) {}
  
  private void a(bn parambn)
  {
    this.c = parambn;
  }
  
  public void a(int paramInt)
  {
    this.a = true;
    this.e = paramInt;
    this.d = this.b.b(paramInt).f();
    this.c.a(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    this.c.a(paramInt1, paramFloat, paramInt2);
  }
  
  public void b(int paramInt)
  {
    this.c.b(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */