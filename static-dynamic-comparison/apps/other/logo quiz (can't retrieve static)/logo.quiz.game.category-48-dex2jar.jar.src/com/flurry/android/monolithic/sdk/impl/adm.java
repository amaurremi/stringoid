package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.List;

public class adm
{
  final adk a;
  
  public adm(adk paramadk)
  {
    this.a = paramadk;
  }
  
  protected afm a(adn paramadn)
    throws IllegalArgumentException
  {
    if (!paramadn.hasMoreTokens()) {
      throw a(paramadn, "Unexpected end-of-string");
    }
    Class localClass = a(paramadn.nextToken(), paramadn);
    if (paramadn.hasMoreTokens())
    {
      String str = paramadn.nextToken();
      if ("<".equals(str)) {
        return this.a.a(localClass, b(paramadn));
      }
      paramadn.a(str);
    }
    return this.a.a(localClass, null);
  }
  
  public afm a(String paramString)
    throws IllegalArgumentException
  {
    paramString = new adn(paramString.trim());
    afm localafm = a(paramString);
    if (paramString.hasMoreTokens()) {
      throw a(paramString, "Unexpected tokens after complete type");
    }
    return localafm;
  }
  
  protected Class<?> a(String paramString, adn paramadn)
  {
    try
    {
      Class localClass = Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
      return localClass;
    }
    catch (Exception localException)
    {
      if ((localException instanceof RuntimeException)) {
        throw ((RuntimeException)localException);
      }
      throw a(paramadn, "Can not locate class '" + paramString + "', problem: " + localException.getMessage());
    }
  }
  
  protected IllegalArgumentException a(adn paramadn, String paramString)
  {
    return new IllegalArgumentException("Failed to parse type '" + paramadn.a() + "' (remaining: '" + paramadn.b() + "'): " + paramString);
  }
  
  protected List<afm> b(adn paramadn)
    throws IllegalArgumentException
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    do
    {
      if (paramadn.hasMoreTokens())
      {
        localArrayList.add(a(paramadn));
        if (paramadn.hasMoreTokens()) {}
      }
      else
      {
        throw a(paramadn, "Unexpected end-of-string");
      }
      str = paramadn.nextToken();
      if (">".equals(str)) {
        return localArrayList;
      }
    } while (",".equals(str));
    throw a(paramadn, "Unexpected token '" + str + "', expected ',' or '>')");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */