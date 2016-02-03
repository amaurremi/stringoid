package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class m
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static a h(Object paramObject)
  {
    return new a(paramObject, null);
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static final class a
  {
    private final List<String> LY;
    private final Object LZ;
    
    private a(Object paramObject)
    {
      this.LZ = n.i(paramObject);
      this.LY = new ArrayList();
    }
    
    public a a(String paramString, Object paramObject)
    {
      this.LY.add((String)n.i(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.LZ.getClass().getSimpleName()).append('{');
      int j = this.LY.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.LY.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return '}';
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */