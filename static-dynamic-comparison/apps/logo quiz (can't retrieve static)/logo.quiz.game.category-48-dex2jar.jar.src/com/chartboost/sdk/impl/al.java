package com.chartboost.sdk.impl;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class al
{
  private static boolean a = false;
  private static boolean b = false;
  static final Logger f = Logger.getLogger("org.bson.BSON");
  static bi<List<as>> g = new bi();
  static bi<List<as>> h = new bi();
  protected static Charset i = Charset.forName("UTF-8");
  static ThreadLocal<an> j = new ThreadLocal()
  {
    protected an a()
    {
      return new aq();
    }
  };
  static ThreadLocal<am> k = new ThreadLocal()
  {
    protected am a()
    {
      return new ap();
    }
  };
  
  public static Object a(Object paramObject)
  {
    Object localObject1;
    if (!a()) {
      localObject1 = paramObject;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = paramObject;
        } while (g.a() == 0);
        localObject1 = paramObject;
      } while (paramObject == null);
      localObject2 = (List)g.a(paramObject.getClass());
      localObject1 = paramObject;
    } while (localObject2 == null);
    Object localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      localObject1 = paramObject;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramObject = ((as)((Iterator)localObject2).next()).a(paramObject);
    }
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a[] arrayOfa = a.values();
    int i1 = arrayOfa.length;
    int n = 0;
    int m = paramInt;
    paramInt = n;
    while (paramInt < i1)
    {
      a locala = arrayOfa[paramInt];
      n = m;
      if ((locala.j & m) > 0)
      {
        localStringBuilder.append(locala.k);
        n = m - locala.j;
      }
      paramInt += 1;
      m = n;
    }
    if (m > 0) {
      throw new IllegalArgumentException("some flags could not be recognized.");
    }
    return localStringBuilder.toString();
  }
  
  private static boolean a()
  {
    return (a) || (b);
  }
  
  private static enum a
  {
    private static final Map<Character, a> m;
    public final int j;
    public final char k;
    public final String l;
    
    static
    {
      int i1 = 0;
      a = new a("CANON_EQ", 0, 128, 'c', "Pattern.CANON_EQ");
      b = new a("UNIX_LINES", 1, 1, 'd', "Pattern.UNIX_LINES");
      c = new a("GLOBAL", 2, 256, 'g', null);
      d = new a("CASE_INSENSITIVE", 3, 2, 'i', null);
      e = new a("MULTILINE", 4, 8, 'm', null);
      f = new a("DOTALL", 5, 32, 's', "Pattern.DOTALL");
      g = new a("LITERAL", 6, 16, 't', "Pattern.LITERAL");
      h = new a("UNICODE_CASE", 7, 64, 'u', "Pattern.UNICODE_CASE");
      i = new a("COMMENTS", 8, 4, 'x', null);
      n = new a[] { a, b, c, d, e, f, g, h, i };
      m = new HashMap();
      a[] arrayOfa = values();
      int i2 = arrayOfa.length;
      while (i1 < i2)
      {
        a locala = arrayOfa[i1];
        m.put(Character.valueOf(locala.k), locala);
        i1 += 1;
      }
    }
    
    private a(int paramInt, char paramChar, String paramString)
    {
      this.j = paramInt;
      this.k = paramChar;
      this.l = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */