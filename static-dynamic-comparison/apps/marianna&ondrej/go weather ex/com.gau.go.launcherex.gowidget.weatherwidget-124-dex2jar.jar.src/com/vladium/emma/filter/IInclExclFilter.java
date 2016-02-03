package com.vladium.emma.filter;

import com.vladium.util.WCMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public abstract interface IInclExclFilter
{
  public static final char EXCLUSION_PREFIX = '-';
  public static final String EXCLUSION_PREFIX_STRING = "-";
  public static final char INCLUSION_PREFIX = '+';
  public static final String INCLUSION_PREFIX_STRING = "+";
  
  public abstract boolean included(String paramString);
  
  public static abstract class Factory
  {
    public static IInclExclFilter create(String paramString1, String paramString2, String[] paramArrayOfString)
    {
      if ((paramString1 == null) || (paramString1.trim().length() == 0)) {
        return create(paramArrayOfString);
      }
      ArrayList localArrayList = new ArrayList();
      if (paramArrayOfString != null)
      {
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          localArrayList.add(paramArrayOfString[i]);
          i += 1;
        }
      }
      paramString1 = new StringTokenizer(paramString1, paramString2);
      while (paramString1.hasMoreTokens()) {
        localArrayList.add(paramString1.nextToken());
      }
      paramString1 = new String[localArrayList.size()];
      localArrayList.toArray(paramString1);
      return create(paramString1);
    }
    
    public static IInclExclFilter create(List paramList1, List paramList2)
    {
      return new WCInclExclFilter(paramList1, paramList2);
    }
    
    public static IInclExclFilter create(String[] paramArrayOfString)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
        return new WCInclExclFilter((String[])null, (String[])null);
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      int j = paramArrayOfString.length;
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (str.length() > 0)
        {
          if (str.charAt(0) != '-') {
            break label97;
          }
          localArrayList2.add(str.substring(1));
        }
        for (;;)
        {
          i += 1;
          break;
          label97:
          if (str.charAt(0) == '+') {
            localArrayList1.add(str.substring(1));
          } else {
            localArrayList1.add(str);
          }
        }
      }
      return new WCInclExclFilter(localArrayList1, localArrayList2);
    }
    
    public static IInclExclFilter create(String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      return new WCInclExclFilter(paramArrayOfString1, paramArrayOfString2);
    }
    
    private static final class WCInclExclFilter
      implements IInclExclFilter
    {
      private final WCMatcher[] m_exclusions;
      private final WCMatcher[] m_inclusions;
      
      WCInclExclFilter(List paramList1, List paramList2)
      {
        if ((paramList1 == null) || (paramList1.isEmpty()))
        {
          this.m_inclusions = null;
          if ((paramList2 != null) && (!paramList2.isEmpty())) {
            break label101;
          }
          this.m_exclusions = null;
        }
        for (;;)
        {
          return;
          this.m_inclusions = new WCMatcher[paramList1.size()];
          int i = 0;
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            String str = (String)paramList1.next();
            this.m_inclusions[i] = WCMatcher.compile(str);
            i += 1;
          }
          break;
          label101:
          this.m_exclusions = new WCMatcher[paramList2.size()];
          i = 0;
          paramList1 = paramList2.iterator();
          while (paramList1.hasNext())
          {
            paramList2 = (String)paramList1.next();
            this.m_exclusions[i] = WCMatcher.compile(paramList2);
            i += 1;
          }
        }
      }
      
      WCInclExclFilter(String[] paramArrayOfString1, String[] paramArrayOfString2)
      {
        if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0))
        {
          this.m_inclusions = null;
          if ((paramArrayOfString2 != null) && (paramArrayOfString2.length != 0)) {
            break label69;
          }
          this.m_exclusions = null;
        }
        for (;;)
        {
          return;
          this.m_inclusions = new WCMatcher[paramArrayOfString1.length];
          int i = 0;
          while (i < paramArrayOfString1.length)
          {
            this.m_inclusions[i] = WCMatcher.compile(paramArrayOfString1[i]);
            i += 1;
          }
          break;
          label69:
          this.m_exclusions = new WCMatcher[paramArrayOfString2.length];
          i = 0;
          while (i < paramArrayOfString2.length)
          {
            this.m_exclusions[i] = WCMatcher.compile(paramArrayOfString2[i]);
            i += 1;
          }
        }
      }
      
      public boolean included(String paramString)
      {
        if (paramString == null) {
          return false;
        }
        paramString = paramString.toCharArray();
        WCMatcher[] arrayOfWCMatcher1 = this.m_inclusions;
        WCMatcher[] arrayOfWCMatcher2 = this.m_exclusions;
        int k;
        int i;
        int m;
        if (arrayOfWCMatcher1 != null)
        {
          k = 0;
          i = 0;
          m = arrayOfWCMatcher1.length;
        }
        for (;;)
        {
          int j = k;
          if (i < m)
          {
            if (arrayOfWCMatcher1[i].matches(paramString)) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            if (arrayOfWCMatcher2 == null) {
              break label105;
            }
            i = 0;
            j = arrayOfWCMatcher2.length;
            for (;;)
            {
              if (i >= j) {
                break label105;
              }
              if (arrayOfWCMatcher2[i].matches(paramString)) {
                break;
              }
              i += 1;
            }
          }
          i += 1;
        }
        label105:
        return true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/filter/IInclExclFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */