package android.support.v4.c;

import java.util.Iterator;

final class g
  implements Iterator
{
  final int a;
  int b;
  int c;
  boolean d = false;
  
  g(f paramf, int paramInt)
  {
    this.a = paramInt;
    this.b = paramf.a();
  }
  
  public boolean hasNext()
  {
    return this.c < this.b;
  }
  
  public Object next()
  {
    Object localObject = this.e.a(this.c, this.a);
    this.c += 1;
    this.d = true;
    return localObject;
  }
  
  public void remove()
  {
    if (!this.d) {
      throw new IllegalStateException();
    }
    this.c -= 1;
    this.b -= 1;
    this.d = false;
    this.e.a(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */