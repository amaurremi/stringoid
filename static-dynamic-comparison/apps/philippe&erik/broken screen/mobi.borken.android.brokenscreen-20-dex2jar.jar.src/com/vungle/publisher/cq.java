package com.vungle.publisher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cq
{
  public static cq a(Object... paramVarArgs)
  {
    return a.a(new cv(), paramVarArgs);
  }
  
  public abstract <T> T a(Class<T> paramClass);
  
  public abstract <T> T a(T paramT);
  
  static final class a
    extends cq
  {
    private final a a = null;
    private final cy b;
    private final cz c;
    private final Map d;
    private final Map<String, Class<?>> e;
    private final List f;
    
    private a(cy paramcy, cz paramcz, Map paramMap1, Map paramMap2, List paramList)
    {
      this.b = ((cy)a(paramcy, "linker"));
      this.c = ((cz)a(paramcz, "plugin"));
      this.d = ((Map)a(paramMap1, "staticInjections"));
      this.e = ((Map)a(paramMap2, "injectableTypes"));
      this.f = ((List)a(paramList, "setBindings"));
    }
    
    static cq a(cz paramcz, Object... paramVarArgs)
    {
      LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
      LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
      cq.c localc = new cq.c();
      cq.b localb = new cq.b();
      Iterator localIterator = dc.a(paramcz, paramVarArgs).entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        db localdb = (db)localEntry.getKey();
        int i = 0;
        while (i < localdb.b.length)
        {
          localLinkedHashMap1.put(localdb.b[i], localdb.a);
          i += 1;
        }
        i = 0;
        while (i < localdb.c.length)
        {
          localLinkedHashMap2.put(localdb.c[i], null);
          i += 1;
        }
        for (;;)
        {
          try
          {
            if (localdb.d)
            {
              paramVarArgs = localb;
              localdb.a(paramVarArgs, localEntry.getValue());
            }
          }
          catch (IllegalArgumentException paramcz)
          {
            throw new IllegalArgumentException(localdb.a.getSimpleName() + ": " + paramcz.getMessage(), paramcz);
          }
          paramVarArgs = localc;
        }
      }
      paramVarArgs = new cy(paramcz, new de());
      paramVarArgs.a(localc);
      paramVarArgs.a(localb);
      return new a(paramVarArgs, paramcz, localLinkedHashMap2, localLinkedHashMap1, localc.a);
    }
    
    private cs<?> a(ClassLoader paramClassLoader, String paramString1, String paramString2)
    {
      Object localObject1 = null;
      Object localObject2 = this;
      while (localObject2 != null)
      {
        ??? = (Class)((a)localObject2).e.get(paramString1);
        localObject1 = ???;
        if (??? != null) {
          break;
        }
        localObject2 = ((a)localObject2).a;
        localObject1 = ???;
      }
      if (localObject1 == null) {
        throw new IllegalArgumentException("No inject registered for " + paramString1 + ". You must explicitly add it to the 'injects' option in one of your modules.");
      }
      synchronized (this.b)
      {
        localObject2 = this.b.a(paramString2, localObject1, paramClassLoader, false);
        if (localObject2 != null)
        {
          paramString1 = (String)localObject2;
          if (((cs)localObject2).isLinked()) {}
        }
        else
        {
          this.b.a();
          paramString1 = this.b.a(paramString2, localObject1, paramClassLoader, false);
        }
        return paramString1;
      }
    }
    
    private static <T> T a(T paramT, String paramString)
    {
      if (paramT == null) {
        throw new NullPointerException(paramString);
      }
      return paramT;
    }
    
    public final <T> T a(Class<T> paramClass)
    {
      String str2 = cw.a(paramClass);
      if (paramClass.isInterface()) {}
      for (String str1 = str2;; str1 = cw.a(paramClass)) {
        return (T)a(paramClass.getClassLoader(), str1, str2).get();
      }
    }
    
    public final <T> T a(T paramT)
    {
      String str = cw.a(paramT.getClass());
      a(paramT.getClass().getClassLoader(), str, str).injectMembers(paramT);
      return paramT;
    }
  }
  
  static final class b
    extends ct
  {}
  
  static final class c
    extends ct
  {
    final List a = new ArrayList();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */