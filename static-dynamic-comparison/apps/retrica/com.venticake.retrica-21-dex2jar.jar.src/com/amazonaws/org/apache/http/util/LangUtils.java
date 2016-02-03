package com.amazonaws.org.apache.http.util;

public final class LangUtils
{
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfObject1 == null)
    {
      bool1 = bool2;
      if (paramArrayOfObject2 == null) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramArrayOfObject2 == null);
      bool1 = bool2;
    } while (paramArrayOfObject1.length != paramArrayOfObject2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfObject1.length) {
        break label65;
      }
      bool1 = bool2;
      if (!equals(paramArrayOfObject1[i], paramArrayOfObject2[i])) {
        break;
      }
      i += 1;
    }
    label65:
    return true;
  }
  
  public static int hashCode(int paramInt1, int paramInt2)
  {
    return paramInt1 * 37 + paramInt2;
  }
  
  public static int hashCode(int paramInt, Object paramObject)
  {
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0) {
      return hashCode(paramInt, i);
    }
  }
  
  public static int hashCode(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return hashCode(paramInt, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/util/LangUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */