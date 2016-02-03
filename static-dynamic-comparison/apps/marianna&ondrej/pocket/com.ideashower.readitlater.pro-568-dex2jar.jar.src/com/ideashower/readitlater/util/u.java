package com.ideashower.readitlater.util;

import com.ideashower.readitlater.a.g;
import java.util.ArrayList;

public class u
{
  private static final ArrayList a = new ArrayList();
  private static final Object b = new Object();
  
  public static String a(int paramInt)
  {
    return a(g.a(paramInt));
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = a();
    localStringBuilder.append("\"").append(paramString).append("\"");
    paramString = localStringBuilder.toString();
    a(localStringBuilder);
    return paramString;
  }
  
  public static StringBuilder a()
  {
    synchronized (b)
    {
      StringBuilder localStringBuilder;
      if (a.isEmpty())
      {
        localStringBuilder = null;
        if (localStringBuilder != null) {
          return localStringBuilder;
        }
      }
      else
      {
        localStringBuilder = (StringBuilder)a.remove(0);
      }
    }
    return new StringBuilder();
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    b(paramStringBuilder);
    synchronized (b)
    {
      a.add(paramStringBuilder);
      return;
    }
  }
  
  public static void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.setLength(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */