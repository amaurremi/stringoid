package com.google.api.client.b.a.a.a.a;

public final class c
{
  public static <T> T a(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static <T> T ad(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static void av(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void aw(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void b(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, paramVarArgs));
    }
  }
  
  public static void c(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, paramVarArgs));
    }
  }
  
  public static void d(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  static String format(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    paramString = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int j = 0;
    for (;;)
    {
      int k;
      if (i < paramVarArgs.length)
      {
        k = paramString.indexOf("%s", j);
        if (k != -1) {}
      }
      else
      {
        localStringBuilder.append(paramString.substring(j));
        if (i >= paramVarArgs.length) {
          break label159;
        }
        localStringBuilder.append(" [");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
        while (i < paramVarArgs.length)
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(paramVarArgs[i]);
          i += 1;
        }
      }
      localStringBuilder.append(paramString.substring(j, k));
      localStringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(']');
    label159:
    return localStringBuilder.toString();
  }
  
  public static <T> T h(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/b/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */