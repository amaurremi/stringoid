package com.drew.metadata;

import java.lang.reflect.Array;

public abstract class f<T extends b>
{
  protected final T ga;
  
  public f(T paramT)
  {
    this.ga = paramT;
  }
  
  public static String a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if ((i < 4) && (i < paramArrayOfInt.length))
    {
      if (i == paramInt) {
        localStringBuilder.append('.');
      }
      char c2 = (char)paramArrayOfInt[i];
      char c1 = c2;
      if (c2 < '0') {
        c1 = (char)(c2 + '0');
      }
      if ((i == 0) && (c1 == '0')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
  
  public String getDescription(int paramInt)
  {
    Object localObject = this.ga.getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if (localObject.getClass().isArray())
    {
      int i = Array.getLength(localObject);
      if (i > 16)
      {
        String str = localObject.getClass().getComponentType().getName();
        if (i == 1) {}
        for (localObject = "";; localObject = "s") {
          return String.format("[%d %s%s]", new Object[] { Integer.valueOf(i), str, localObject });
        }
      }
    }
    return this.ga.getString(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */