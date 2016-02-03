package com.parse.gdata;

public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, paramVarArgs));
    }
  }
  
  public static void checkElementIndex(int paramInt1, int paramInt2)
  {
    checkElementIndex(paramInt1, paramInt2, "index");
  }
  
  public static void checkElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      checkArgument(bool, "negative size: %s", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt1 >= 0) {
        break;
      }
      throw new IndexOutOfBoundsException(format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }));
    }
    if (paramInt1 >= paramInt2) {
      throw new IndexOutOfBoundsException(format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static void checkPositionIndex(int paramInt1, int paramInt2)
  {
    checkPositionIndex(paramInt1, paramInt2, "index");
  }
  
  public static void checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      checkArgument(bool, "negative size: %s", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt1 >= 0) {
        break;
      }
      throw new IndexOutOfBoundsException(format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }));
    }
    if (paramInt1 > paramInt2) {
      throw new IndexOutOfBoundsException(format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    checkPositionIndex(paramInt1, paramInt3, "start index");
    checkPositionIndex(paramInt2, paramInt3, "end index");
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, paramVarArgs));
    }
  }
  
  static String format(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int j = 0;
    int i = 0;
    if (i >= paramVarArgs.length)
    {
      label29:
      localStringBuilder.append(paramString.substring(j));
      if (i < paramVarArgs.length)
      {
        localStringBuilder.append(" [");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
    }
    for (;;)
    {
      if (i >= paramVarArgs.length)
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
        int k = paramString.indexOf("%s", j);
        if (k == -1) {
          break label29;
        }
        localStringBuilder.append(paramString.substring(j, k));
        localStringBuilder.append(paramVarArgs[i]);
        j = k + 2;
        i += 1;
        break;
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/gdata/Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */