package logo.quiz.commons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StringUtils
{
  public static boolean almostGood(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    paramString1 = removeDuplicates(paramString1.toLowerCase().replaceAll("[^a-z0-9 ]+", ""));
    paramString2 = removeDuplicates(paramString2.toLowerCase().replaceAll("[^a-z0-9 ]+", ""));
    char[] arrayOfChar1 = paramString1.toCharArray();
    char[] arrayOfChar2 = paramString2.toCharArray();
    Arrays.sort(arrayOfChar1);
    Arrays.sort(arrayOfChar2);
    int j = 0;
    int i = 0;
    int k;
    if (i < arrayOfChar1.length)
    {
      int m = 0;
      for (;;)
      {
        k = j;
        if (m < arrayOfChar2.length)
        {
          if (arrayOfChar1[i] == arrayOfChar2[m]) {
            k = j + 1;
          }
        }
        else
        {
          i += 1;
          j = k;
          break;
        }
        m += 1;
      }
    }
    boolean bool1 = bool2;
    if (j >= Math.round(paramString1.length() / 1.2D))
    {
      j = paramString1.length();
      k = paramString2.length();
      if (paramString1.length() >= 6) {
        break label178;
      }
    }
    label178:
    for (i = 2;; i = 3)
    {
      bool1 = bool2;
      if (j > k - i) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static boolean containSameChars(String paramString1, String paramString2)
  {
    paramString1 = paramString1.toCharArray();
    paramString2 = paramString2.toCharArray();
    Arrays.sort(paramString1);
    Arrays.sort(paramString2);
    return Arrays.equals(paramString1, paramString2);
  }
  
  public static boolean isAlmostGood(String paramString, String[] paramArrayOfString)
  {
    boolean bool1 = false;
    int m = paramArrayOfString.length;
    int i = 0;
    while (i < m)
    {
      Object localObject1 = paramArrayOfString[i];
      if (bool1) {
        break;
      }
      localObject1 = ((String)localObject1).toLowerCase().replaceAll("[^a-z0-9 ]+", "");
      Object localObject2 = paramString.toLowerCase().replaceAll("[^a-z0-9 ]+", "");
      localObject1 = ((String)localObject1).split(" ");
      localObject2 = ((String)localObject2).split(" ");
      int n = localObject1.length;
      int j = 0;
      if (j < n)
      {
        String str2 = localObject1[j];
        if (!bool1)
        {
          String str1 = removeDuplicates(str2);
          boolean bool2 = bool1;
          int i1;
          int k;
          if (str2.length() > 3)
          {
            i1 = localObject2.length;
            k = 0;
          }
          for (;;)
          {
            bool2 = bool1;
            if (k < i1)
            {
              str2 = localObject2[k];
              String str3 = removeDuplicates(str2);
              if ((str2.length() > 3) && (almostGood(str1, str3))) {
                bool2 = true;
              }
            }
            else
            {
              j += 1;
              bool1 = bool2;
              break;
            }
            k += 1;
          }
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public static boolean isLogoNameCorrect(String paramString, String[] paramArrayOfString)
  {
    boolean bool1 = false;
    int m = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool2 = bool1;
      if (i < m)
      {
        localObject1 = paramArrayOfString[i];
        bool2 = bool1;
        if (!bool1)
        {
          if (!((String)localObject1).toLowerCase().replaceAll("[^a-z0-9]+", "").equals(paramString.toLowerCase().replaceAll("[^a-z0-9]+", ""))) {
            break label68;
          }
          bool2 = true;
        }
      }
      return bool2;
      label68:
      Object localObject1 = ((String)localObject1).toLowerCase().replaceAll("[^a-z0-9 ]+", "");
      Object localObject2 = paramString.toLowerCase().replaceAll("[^a-z0-9 ]+", "");
      localObject1 = ((String)localObject1).split(" ");
      localObject2 = ((String)localObject2).split(" ");
      int n = localObject1.length;
      int j = 0;
      if (j < n)
      {
        String str2 = localObject1[j];
        if (!bool1)
        {
          String str1 = removeDuplicates(str2);
          bool2 = bool1;
          int i1;
          int k;
          if (str2.length() > 3)
          {
            i1 = localObject2.length;
            k = 0;
          }
          for (;;)
          {
            bool2 = bool1;
            if (k < i1)
            {
              str2 = localObject2[k];
              String str3 = removeDuplicates(str2);
              if ((str2.length() > 3) && (str1.equals(str3))) {
                bool2 = true;
              }
            }
            else
            {
              j += 1;
              bool1 = bool2;
              break;
            }
            k += 1;
          }
        }
      }
      i += 1;
    }
  }
  
  static String removeDuplicates(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < paramString.length())
    {
      if ((i == 0) && (paramString.length() > 1))
      {
        localLinkedList.add(Character.valueOf(paramString.charAt(i)));
        localLinkedList.add(Character.valueOf(paramString.charAt(i + 1)));
      }
      for (;;)
      {
        char c = paramString.charAt(i);
        if (!((Character)localLinkedList.poll()).equals(localLinkedList.peek())) {
          localStringBuilder.append(String.valueOf(c));
        }
        i += 1;
        break;
        if (paramString.length() > i + 1) {
          localLinkedList.add(Character.valueOf(paramString.charAt(i + 1)));
        } else if (paramString.length() == i + 1) {
          localLinkedList.add(Character.valueOf('#'));
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String removeWhiteSpaces(String paramString)
  {
    return paramString.replaceAll("\\s", "");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */