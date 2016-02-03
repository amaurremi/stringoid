package android.support.v4.b;

public class h<E>
  implements Cloneable
{
  private static final Object af = new Object();
  private int U;
  private boolean ag = false;
  private int[] ah;
  private Object[] ai;
  
  public h()
  {
    this(10);
  }
  
  public h(int paramInt)
  {
    if (paramInt == 0) {
      this.ah = b.F;
    }
    for (this.ai = b.H;; this.ai = new Object[paramInt])
    {
      this.U = 0;
      return;
      paramInt = b.b(paramInt);
      this.ah = new int[paramInt];
    }
  }
  
  private void gc()
  {
    int m = this.U;
    int[] arrayOfInt = this.ah;
    Object[] arrayOfObject = this.ai;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != af)
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
    this.ag = false;
    this.U = j;
  }
  
  public void clear()
  {
    int j = this.U;
    Object[] arrayOfObject = this.ai;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.U = 0;
    this.ag = false;
  }
  
  public void delete(int paramInt)
  {
    paramInt = b.b(this.ah, this.U, paramInt);
    if ((paramInt >= 0) && (this.ai[paramInt] != af))
    {
      this.ai[paramInt] = af;
      this.ag = true;
    }
  }
  
  public E get(int paramInt)
  {
    return (E)get(paramInt, null);
  }
  
  public E get(int paramInt, E paramE)
  {
    paramInt = b.b(this.ah, this.U, paramInt);
    if ((paramInt < 0) || (this.ai[paramInt] == af)) {
      return paramE;
    }
    return (E)this.ai[paramInt];
  }
  
  public int indexOfKey(int paramInt)
  {
    if (this.ag) {
      gc();
    }
    return b.b(this.ah, this.U, paramInt);
  }
  
  public int keyAt(int paramInt)
  {
    if (this.ag) {
      gc();
    }
    return this.ah[paramInt];
  }
  
  public void put(int paramInt, E paramE)
  {
    int i = b.b(this.ah, this.U, paramInt);
    if (i >= 0)
    {
      this.ai[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.U) && (this.ai[j] == af))
    {
      this.ah[j] = paramInt;
      this.ai[j] = paramE;
      return;
    }
    i = j;
    if (this.ag)
    {
      i = j;
      if (this.U >= this.ah.length)
      {
        gc();
        i = b.b(this.ah, this.U, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.U >= this.ah.length)
    {
      j = b.b(this.U + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.ah, 0, arrayOfInt, 0, this.ah.length);
      System.arraycopy(this.ai, 0, arrayOfObject, 0, this.ai.length);
      this.ah = arrayOfInt;
      this.ai = arrayOfObject;
    }
    if (this.U - i != 0)
    {
      System.arraycopy(this.ah, i, this.ah, i + 1, this.U - i);
      System.arraycopy(this.ai, i, this.ai, i + 1, this.U - i);
    }
    this.ah[i] = paramInt;
    this.ai[i] = paramE;
    this.U += 1;
  }
  
  public void remove(int paramInt)
  {
    delete(paramInt);
  }
  
  public void removeAt(int paramInt)
  {
    if (this.ai[paramInt] != af)
    {
      this.ai[paramInt] = af;
      this.ag = true;
    }
  }
  
  public int size()
  {
    if (this.ag) {
      gc();
    }
    return this.U;
  }
  
  public h<E> t()
  {
    try
    {
      h localh = (h)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localh.ah = ((int[])this.ah.clone());
        localh.ai = ((Object[])this.ai.clone());
        return localh;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public String toString()
  {
    if (size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.U * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.U)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
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
  
  public E valueAt(int paramInt)
  {
    if (this.ag) {
      gc();
    }
    return (E)this.ai[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */