package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class cz
{
  public static a M(Object paramObject)
  {
    return new a(paramObject, null);
  }
  
  public static boolean b(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static final class a
  {
    private final List<String> Hx;
    private final Object Hy;
    
    private a(Object paramObject)
    {
      this.Hy = dc.N(paramObject);
      this.Hx = new ArrayList();
    }
    
    public a a(String paramString, Object paramObject)
    {
      this.Hx.add((String)dc.N(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.Hy.getClass().getSimpleName()).append('{');
      int j = this.Hx.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.Hx.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return '}';
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */