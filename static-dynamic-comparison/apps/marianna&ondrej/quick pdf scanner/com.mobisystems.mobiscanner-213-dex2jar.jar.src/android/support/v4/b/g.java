package android.support.v4.b;

import java.util.Map;

public class g<K, V>
{
  static Object[] Z;
  static int aa;
  static Object[] ab;
  static int ac;
  int U = 0;
  int[] ad = b.F;
  Object[] ae = b.H;
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (ac < 10)
        {
          paramArrayOfObject[0] = ab;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          ab = paramArrayOfObject;
          ac += 1;
        }
        return;
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (aa < 10)
        {
          paramArrayOfObject[0] = Z;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          Z = paramArrayOfObject;
          aa += 1;
        }
        return;
      }
      finally {}
      label117:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      return;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (ab != null)
        {
          Object[] arrayOfObject1 = ab;
          this.ae = arrayOfObject1;
          ab = (Object[])arrayOfObject1[0];
          this.ad = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          ac -= 1;
          return;
        }
        this.ad = new int[paramInt];
        this.ae = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (Z != null)
          {
            Object[] arrayOfObject2 = Z;
            this.ae = arrayOfObject2;
            Z = (Object[])arrayOfObject2[0];
            this.ad = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            aa -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public void clear()
  {
    if (this.U != 0)
    {
      a(this.ad, this.ae, this.U);
      this.ad = b.F;
      this.ae = b.H;
      this.U = 0;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    if (paramObject == null) {
      if (s() < 0) {}
    }
    while (indexOf(paramObject, paramObject.hashCode()) >= 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }
  
  public void ensureCapacity(int paramInt)
  {
    if (this.ad.length < paramInt)
    {
      int[] arrayOfInt = this.ad;
      Object[] arrayOfObject = this.ae;
      e(paramInt);
      if (this.U > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.ad, 0, this.U);
        System.arraycopy(arrayOfObject, 0, this.ae, 0, this.U << 1);
      }
      a(arrayOfInt, arrayOfObject, this.U);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        if (size() != ((Map)paramObject).size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < this.U)
          {
            Object localObject1 = keyAt(i);
            Object localObject2 = valueAt(i);
            Object localObject3 = ((Map)paramObject).get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label121;
              }
              if (!((Map)paramObject).containsKey(localObject1)) {
                break label121;
              }
            }
            else
            {
              boolean bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
    label121:
    return false;
  }
  
  public V get(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = s(); i >= 0; i = indexOf(paramObject, paramObject.hashCode())) {
      return (V)this.ae[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.ad;
    Object[] arrayOfObject = this.ae;
    int n = this.U;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null) {}
      for (int m = 0;; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  int indexOf(Object paramObject, int paramInt)
  {
    int m = this.U;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = b.b(this.ad, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.ae[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (this.ad[k] == paramInt))
    {
      if (paramObject.equals(this.ae[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.ad[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.ae[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  int indexOfValue(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.U * 2;
    Object[] arrayOfObject = this.ae;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    do
    {
      i += 2;
      if (i >= k) {
        break;
      }
    } while (!paramObject.equals(arrayOfObject[i]));
    return i >> 1;
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.U <= 0;
  }
  
  public K keyAt(int paramInt)
  {
    return (K)this.ae[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int i;
    int j;
    if (paramK == null)
    {
      i = s();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.ae[i];
      this.ae[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.U >= this.ad.length)
    {
      if (this.U < 8) {
        break label267;
      }
      i = this.U + (this.U >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = this.ad;
      Object[] arrayOfObject = this.ae;
      e(i);
      if (this.ad.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.ad, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.ae, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, this.U);
      if (m < this.U)
      {
        System.arraycopy(this.ad, m, this.ad, m + 1, this.U - m);
        System.arraycopy(this.ae, m << 1, this.ae, m + 1 << 1, this.U - m << 1);
      }
      this.ad[m] = j;
      this.ae[(m << 1)] = paramK;
      this.ae[((m << 1) + 1)] = paramV;
      this.U += 1;
      return null;
      label267:
      i = k;
      if (this.U < 4) {
        i = 4;
      }
    }
  }
  
  public V remove(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = s(); i >= 0; i = indexOf(paramObject, paramObject.hashCode())) {
      return (V)removeAt(i);
    }
    return null;
  }
  
  public V removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.ae[((paramInt << 1) + 1)];
    if (this.U <= 1)
    {
      a(this.ad, this.ae, this.U);
      this.ad = b.F;
      this.ae = b.H;
      this.U = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return (V)localObject;
      if ((this.ad.length <= 8) || (this.U >= this.ad.length / 3)) {
        break;
      }
      if (this.U > 8) {
        i = this.U + (this.U >> 1);
      }
      arrayOfInt = this.ad;
      arrayOfObject = this.ae;
      e(i);
      this.U -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.ad, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.ae, 0, paramInt << 1);
      }
    } while (paramInt >= this.U);
    System.arraycopy(arrayOfInt, paramInt + 1, this.ad, paramInt, this.U - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.ae, paramInt << 1, this.U - paramInt << 1);
    return (V)localObject;
    this.U -= 1;
    if (paramInt < this.U)
    {
      System.arraycopy(this.ad, paramInt + 1, this.ad, paramInt, this.U - paramInt);
      System.arraycopy(this.ae, paramInt + 1 << 1, this.ae, paramInt << 1, this.U - paramInt << 1);
    }
    this.ae[(this.U << 1)] = null;
    this.ae[((this.U << 1) + 1)] = null;
    return (V)localObject;
  }
  
  int s()
  {
    int m = this.U;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = b.b(this.ad, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.ae[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (this.ad[k] == 0))
    {
      if (this.ae[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.ad[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.ae[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
    return k ^ 0xFFFFFFFF;
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object localObject = this.ae[paramInt];
    this.ae[paramInt] = paramV;
    return (V)localObject;
  }
  
  public int size()
  {
    return this.U;
  }
  
  public String toString()
  {
    if (isEmpty()) {
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
      Object localObject = keyAt(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70:
        localStringBuilder.append('=');
        localObject = valueAt(i);
        if (localObject == this) {
          break label111;
        }
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111:
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public V valueAt(int paramInt)
  {
    return (V)this.ae[((paramInt << 1) + 1)];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */