package org.apache.a.c;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class k
{
  private static final Pattern a = Pattern.compile("\\s+");
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramInt < 0) {
        return "";
      }
      str = paramString;
    } while (paramString.length() <= paramInt);
    return paramString.substring(paramString.length() - paramInt);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, 1);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = 64;
    if ((a(paramString1)) || (a(paramString2)) || (paramString3 == null) || (paramInt == 0)) {}
    int k;
    do
    {
      return paramString1;
      k = paramString1.indexOf(paramString2, 0);
    } while (k == -1);
    int n = paramString2.length();
    int m = paramString3.length() - n;
    int j = m;
    if (m < 0) {
      j = 0;
    }
    StringBuilder localStringBuilder;
    if (paramInt < 0)
    {
      i = 16;
      localStringBuilder = new StringBuilder(i * j + paramString1.length());
      m = 0;
      i = paramInt;
      j = k;
      paramInt = m;
    }
    for (;;)
    {
      k = paramInt;
      if (j != -1)
      {
        localStringBuilder.append(paramString1.substring(paramInt, j)).append(paramString3);
        paramInt = j + n;
        i -= 1;
        if (i == 0) {
          k = paramInt;
        }
      }
      else
      {
        localStringBuilder.append(paramString1.substring(k));
        return localStringBuilder.toString();
        if (paramInt > 64) {
          break;
        }
        i = paramInt;
        break;
      }
      j = paramString1.indexOf(paramString2, paramInt);
    }
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == null) {
      return paramCharSequence2 == null;
    }
    return paramCharSequence1.equals(paramCharSequence2);
  }
  
  private static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      bool1 = bool2;
      if (paramCharSequence1 == null)
      {
        bool1 = bool2;
        if (paramCharSequence2 == null) {
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramCharSequence2.length() > paramCharSequence1.length());
    return b.a(paramCharSequence1, paramBoolean, 0, paramCharSequence2, 0, paramCharSequence2.length());
  }
  
  public static boolean a(CharSequence paramCharSequence, char... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((a(paramCharSequence)) || (a.a(paramVarArgs)))
    {
      bool1 = false;
      return bool1;
    }
    int k = paramCharSequence.length();
    int m = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label139;
      }
      char c = paramCharSequence.charAt(i);
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label132;
        }
        if (paramVarArgs[j] == c)
        {
          bool1 = bool2;
          if (!Character.isHighSurrogate(c)) {
            break;
          }
          bool1 = bool2;
          if (j == m - 1) {
            break;
          }
          if (i < k - 1)
          {
            bool1 = bool2;
            if (paramVarArgs[(j + 1)] == paramCharSequence.charAt(i + 1)) {
              break;
            }
          }
        }
        j += 1;
      }
      label132:
      i += 1;
    }
    label139:
    return false;
  }
  
  public static String[] a(String paramString, char paramChar)
  {
    return a(paramString, paramChar, false);
  }
  
  private static String[] a(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    int n = paramString.length();
    if (n == 0) {
      return a.c;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    while (i < n) {
      if (paramString.charAt(i) == paramChar)
      {
        if ((k != 0) || (paramBoolean))
        {
          localArrayList.add(paramString.substring(m, i));
          j = 1;
          k = 0;
        }
        m = i + 1;
        i = m;
      }
      else
      {
        k = 1;
        i += 1;
        j = 0;
      }
    }
    if ((k != 0) || ((paramBoolean) && (j != 0))) {
      localArrayList.add(paramString.substring(m, i));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, -1, true);
  }
  
  private static String[] a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return null;
    }
    int m = paramString1.length();
    if (m == 0) {
      return a.c;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int n;
    int i;
    int i5;
    int i4;
    int i2;
    int i1;
    int i3;
    if (paramString2 == null)
    {
      j = 0;
      k = 0;
      n = 0;
      i = 0;
      i5 = 1;
      i4 = i;
      i2 = j;
      i1 = k;
      i3 = n;
      if (i >= m) {
        break label521;
      }
      if (Character.isWhitespace(paramString1.charAt(i)))
      {
        if ((k == 0) && (!paramBoolean)) {
          break label597;
        }
        if (i5 != paramInt) {
          break label587;
        }
        i = 0;
        j = m;
        label106:
        localArrayList.add(paramString1.substring(n, j));
        i5 += 1;
        n = 0;
        k = j;
        j = n;
      }
    }
    for (;;)
    {
      n = k + 1;
      k = j;
      j = i;
      i = n;
      break;
      i += 1;
      j = 0;
      k = 1;
      break;
      if (paramString2.length() == 1)
      {
        i2 = paramString2.charAt(0);
        j = 0;
        k = 0;
        n = 0;
        i = 0;
        i1 = 1;
        while (i < m) {
          if (paramString1.charAt(i) == i2)
          {
            if ((k == 0) && (!paramBoolean)) {
              break label550;
            }
            if (i1 != paramInt) {
              break label540;
            }
            i = 0;
            j = m;
            localArrayList.add(paramString1.substring(n, j));
            i1 += 1;
            n = 0;
            k = j;
            j = n;
            label278:
            n = k + 1;
            k = j;
            j = i;
            i = n;
          }
          else
          {
            i += 1;
            j = 0;
            k = 1;
          }
        }
        label314:
        if ((k != 0) || ((paramBoolean) && (j != 0))) {
          localArrayList.add(paramString1.substring(n, i));
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      for (;;)
      {
        i4 = i;
        i2 = j;
        i1 = k;
        i3 = n;
        if (i < m)
        {
          if (paramString2.indexOf(paramString1.charAt(i)) >= 0)
          {
            if ((k == 0) && (!paramBoolean)) {
              break label502;
            }
            if (i5 != paramInt) {
              break label492;
            }
            i = 0;
            j = m;
            label423:
            localArrayList.add(paramString1.substring(n, j));
            i5 += 1;
            n = 0;
            k = j;
            j = n;
          }
          for (;;)
          {
            n = k + 1;
            k = j;
            j = i;
            i = n;
            break;
            i += 1;
            j = 0;
            k = 1;
            break;
            label492:
            j = i;
            i = 1;
            break label423;
            label502:
            n = i;
            i = j;
            j = k;
            k = n;
          }
        }
        label521:
        i = i4;
        n = i3;
        j = i2;
        k = i1;
        break label314;
        label540:
        j = i;
        i = 1;
        break;
        label550:
        n = i;
        i = j;
        j = k;
        k = n;
        break label278;
        j = 0;
        k = 0;
        n = 0;
        i = 0;
        i5 = 1;
      }
      label587:
      j = i;
      i = 1;
      break label106;
      label597:
      n = i;
      i = j;
      j = k;
      k = n;
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.trim();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, -1);
  }
  
  public static boolean b(CharSequence paramCharSequence)
  {
    return !a(paramCharSequence);
  }
  
  public static boolean b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return paramCharSequence1 == paramCharSequence2;
    }
    return b.a(paramCharSequence1, true, 0, paramCharSequence2, 0, Math.max(paramCharSequence1.length(), paramCharSequence2.length()));
  }
  
  public static boolean b(CharSequence paramCharSequence, char... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramCharSequence == null) || (paramVarArgs == null))
    {
      bool1 = true;
      return bool1;
    }
    int k = paramCharSequence.length();
    int m = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label133;
      }
      char c = paramCharSequence.charAt(i);
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label126;
        }
        if (paramVarArgs[j] == c)
        {
          bool1 = bool2;
          if (!Character.isHighSurrogate(c)) {
            break;
          }
          bool1 = bool2;
          if (j == m - 1) {
            break;
          }
          if (i < k - 1)
          {
            bool1 = bool2;
            if (paramVarArgs[(j + 1)] == paramCharSequence.charAt(i + 1)) {
              break;
            }
          }
        }
        j += 1;
      }
      label126:
      i += 1;
    }
    label133:
    return true;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean c(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramCharSequence != null)
    {
      j = paramCharSequence.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {}
    for (;;)
    {
      return false;
      int j = paramCharSequence2.length();
      int k = paramCharSequence1.length();
      int i = 0;
      while (i <= k - j)
      {
        if (b.a(paramCharSequence1, true, i, paramCharSequence2, 0, j)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static int d(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int j = 0;
    if ((a(paramCharSequence1)) || (a(paramCharSequence2)))
    {
      j = 0;
      return j;
    }
    int i = 0;
    for (;;)
    {
      int k = b.a(paramCharSequence1, paramCharSequence2, j);
      j = i;
      if (k == -1) {
        break;
      }
      i += 1;
      j = k + paramCharSequence2.length();
    }
  }
  
  public static boolean d(CharSequence paramCharSequence)
  {
    return !c(paramCharSequence);
  }
  
  public static int e(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    return paramCharSequence.length();
  }
  
  public static CharSequence e(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (c(paramCharSequence1)) {
      return paramCharSequence2;
    }
    return paramCharSequence1;
  }
  
  public static CharSequence f(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (a(paramCharSequence1)) {
      return paramCharSequence2;
    }
    return paramCharSequence1;
  }
  
  public static boolean g(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return a(paramCharSequence1, paramCharSequence2, false);
  }
  
  public static boolean h(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return a(paramCharSequence1, paramCharSequence2, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */