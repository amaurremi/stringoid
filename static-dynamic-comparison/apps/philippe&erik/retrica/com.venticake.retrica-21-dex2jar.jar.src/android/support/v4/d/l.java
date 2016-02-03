package android.support.v4.d;

public class l<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;
  
  public l()
  {
    this(10);
  }
  
  public l(int paramInt)
  {
    if (paramInt == 0) {
      this.c = b.a;
    }
    for (this.d = b.c;; this.d = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = b.a(paramInt);
      this.c = new int[paramInt];
    }
  }
  
  private void d()
  {
    int m = this.e;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }
  
  public int a(int paramInt)
  {
    if (this.b) {
      d();
    }
    return this.c[paramInt];
  }
  
  public l<E> a()
  {
    try
    {
      l locall = (l)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        locall.c = ((int[])this.c.clone());
        locall.d = ((Object[])this.d.clone());
        return locall;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public int b()
  {
    if (this.b) {
      d();
    }
    return this.e;
  }
  
  public E b(int paramInt)
  {
    if (this.b) {
      d();
    }
    return (E)this.d[paramInt];
  }
  
  public void c()
  {
    int j = this.e;
    Object[] arrayOfObject = this.d;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.e = 0;
    this.b = false;
  }
  
  public String toString()
  {
    if (b() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(a(i));
      localStringBuilder.append('=');
      Object localObject = b(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */