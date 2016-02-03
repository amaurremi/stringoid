package android.support.v4.d;

import java.util.Iterator;

final class f<T>
  implements Iterator<T>
{
  final int a;
  int b;
  int c;
  boolean d = false;
  
  f(e parame, int paramInt)
  {
    this.a = paramInt;
    this.b = parame.a();
  }
  
  public boolean hasNext()
  {
    return this.c < this.b;
  }
  
  public T next()
  {
    Object localObject = this.e.a(this.c, this.a);
    this.c += 1;
    this.d = true;
    return (T)localObject;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */