package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class h
{
  private static final Map<Class<?>, h> adc = new WeakHashMap();
  private static final Map<Class<?>, h> add = new WeakHashMap();
  private final Class<?> ade;
  private final boolean adf;
  private final IdentityHashMap<String, l> adg = new IdentityHashMap();
  final List<String> adh;
  
  private h(Class<?> paramClass, boolean paramBoolean)
  {
    this.ade = paramClass;
    this.adf = paramBoolean;
    if ((!paramBoolean) || (!paramClass.isEnum())) {}
    TreeSet localTreeSet;
    Field localField;
    l locall;
    for (boolean bool = true;; bool = false)
    {
      x.d(bool, "cannot ignore case on an enum: " + paramClass);
      localTreeSet = new TreeSet(new Comparator()
      {
        public int compare(String paramAnonymousString1, String paramAnonymousString2)
        {
          if (paramAnonymousString1 == paramAnonymousString2) {
            return 0;
          }
          if (paramAnonymousString1 == null) {
            return -1;
          }
          if (paramAnonymousString2 == null) {
            return 1;
          }
          return paramAnonymousString1.compareTo(paramAnonymousString2);
        }
      });
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label266;
        }
        localField = arrayOfField[i];
        locall = l.a(localField);
        if (locall != null) {
          break;
        }
        i += 1;
      }
    }
    Object localObject1 = locall.getName();
    if (paramBoolean) {
      localObject1 = ((String)localObject1).toLowerCase().intern();
    }
    for (;;)
    {
      Object localObject2 = (l)this.adg.get(localObject1);
      label173:
      String str;
      if (localObject2 == null)
      {
        bool = true;
        if (!paramBoolean) {
          break label249;
        }
        str = "case-insensitive ";
        label181:
        if (localObject2 != null) {
          break label256;
        }
      }
      label249:
      label256:
      for (localObject2 = null;; localObject2 = ((l)localObject2).yP())
      {
        x.b(bool, "two fields have the same %sname <%s>: %s and %s", new Object[] { str, localObject1, localField, localObject2 });
        this.adg.put(localObject1, locall);
        localTreeSet.add(localObject1);
        break;
        bool = false;
        break label173;
        str = "";
        break label181;
      }
      label266:
      paramClass = paramClass.getSuperclass();
      if (paramClass != null)
      {
        paramClass = a(paramClass, paramBoolean);
        localTreeSet.addAll(paramClass.adh);
        paramClass = paramClass.adg.entrySet().iterator();
        while (paramClass.hasNext())
        {
          localObject1 = (Map.Entry)paramClass.next();
          str = (String)((Map.Entry)localObject1).getKey();
          if (!this.adg.containsKey(str)) {
            this.adg.put(str, ((Map.Entry)localObject1).getValue());
          }
        }
      }
      if (localTreeSet.isEmpty()) {}
      for (paramClass = Collections.emptyList();; paramClass = Collections.unmodifiableList(new ArrayList(localTreeSet)))
      {
        this.adh = paramClass;
        return;
      }
    }
  }
  
  public static h a(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramClass == null) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (add)
      {
        h localh2 = (h)???.get(paramClass);
        h localh1 = localh2;
        if (localh2 == null)
        {
          localh1 = new h(paramClass, paramBoolean);
          ???.put(paramClass, localh1);
        }
        return localh1;
      }
      ??? = adc;
    }
  }
  
  public static h i(Class<?> paramClass)
  {
    return a(paramClass, false);
  }
  
  public l cs(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (this.adf) {
        str = paramString.toLowerCase();
      }
      str = str.intern();
    }
    return (l)this.adg.get(str);
  }
  
  public Field getField(String paramString)
  {
    paramString = cs(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.yP();
  }
  
  public boolean isEnum()
  {
    return this.ade.isEnum();
  }
  
  public final boolean yH()
  {
    return this.adf;
  }
  
  public Collection<l> yI()
  {
    return Collections.unmodifiableCollection(this.adg.values());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */