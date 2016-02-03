package twitter4j.internal.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class z_T4JInternalStringUtil
{
  private z_T4JInternalStringUtil()
  {
    throw new AssertionError();
  }
  
  public static String join(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 11);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public static String join(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfInt.length * 11);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(k);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String join(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfLong.length * 11);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String join(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfString.length * 11);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String maskString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    while (i < paramString.length())
    {
      localStringBuilder.append("*");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String[] split(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf(paramString2);
    if (j == -1) {
      return new String[] { paramString1 };
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (j != -1)
    {
      localArrayList.add(paramString1.substring(i, j));
      i = paramString2.length() + j;
      j = paramString1.indexOf(paramString2, i);
    }
    if (i != paramString1.length()) {
      localArrayList.add(paramString1.substring(i));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/util/z_T4JInternalStringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */