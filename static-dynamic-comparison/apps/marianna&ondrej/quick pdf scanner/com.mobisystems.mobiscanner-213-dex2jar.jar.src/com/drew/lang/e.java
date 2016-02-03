package com.drew.lang;

import java.util.Iterator;

public class e
{
  public static String a(Iterable<? extends CharSequence> paramIterable, String paramString)
  {
    int i = paramString.length();
    Object localObject = paramIterable.iterator();
    if (((Iterator)localObject).hasNext()) {}
    for (i = ((CharSequence)((Iterator)localObject).next()).length() + i + 0;; i = 0)
    {
      localObject = new StringBuilder(i);
      paramIterable = paramIterable.iterator();
      if (paramIterable.hasNext())
      {
        ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
        while (paramIterable.hasNext())
        {
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
        }
      }
      return ((StringBuilder)localObject).toString();
    }
  }
  
  public static <T extends CharSequence> String a(T[] paramArrayOfT, String paramString)
  {
    int k = paramString.length();
    int m = paramArrayOfT.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += paramArrayOfT[i].length() + k;
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(j);
    j = 1;
    k = paramArrayOfT.length;
    i = 0;
    if (i < k)
    {
      T ? = paramArrayOfT[i];
      if (j == 0) {
        localStringBuilder.append(paramString);
      }
      for (;;)
      {
        localStringBuilder.append(?);
        i += 1;
        break;
        j = 0;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */