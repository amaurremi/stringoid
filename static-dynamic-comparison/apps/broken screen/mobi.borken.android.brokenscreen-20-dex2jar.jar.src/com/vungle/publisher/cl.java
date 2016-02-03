package com.vungle.publisher;

public final class cl
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  public static String a(Enum<?> paramEnum)
  {
    if (paramEnum == null) {
      return null;
    }
    return paramEnum.name();
  }
  
  public static String a(Object[] paramArrayOfObject)
  {
    return "[" + b(paramArrayOfObject) + "]";
  }
  
  public static void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append(", ");
    paramStringBuilder.append(paramString).append(": ").append(paramObject);
  }
  
  private static <T> String b(T... paramVarArgs)
  {
    Object localObject = null;
    if (paramVarArgs != null)
    {
      localObject = new StringBuilder();
      int j = 1;
      int k = paramVarArgs.length;
      int i = 0;
      if (i < k)
      {
        T ? = paramVarArgs[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(?);
          i += 1;
          break;
          ((StringBuilder)localObject).append(", ");
        }
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */