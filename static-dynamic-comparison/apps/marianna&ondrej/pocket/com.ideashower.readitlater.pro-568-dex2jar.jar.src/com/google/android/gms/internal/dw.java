package com.google.android.gms.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class dw
{
  private void a(StringBuilder paramStringBuilder, dw.a parama, Object paramObject)
  {
    if (parama.b() == 11)
    {
      paramStringBuilder.append(((dw)parama.h().cast(paramObject)).toString());
      return;
    }
    if (parama.b() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(bb.a((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void a(StringBuilder paramStringBuilder, dw.a parama, ArrayList paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        a(paramStringBuilder, parama, localObject);
      }
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  protected Object a(dw.a parama, Object paramObject)
  {
    Object localObject = paramObject;
    if (dw.a.a(parama) != null) {
      localObject = parama.a(paramObject);
    }
    return localObject;
  }
  
  protected abstract Object a(String paramString);
  
  protected boolean a(dw.a parama)
  {
    if (parama.d() == 11)
    {
      if (parama.e()) {
        return d(parama.f());
      }
      return c(parama.f());
    }
    return b(parama.f());
  }
  
  protected Object b(dw.a parama)
  {
    boolean bool = true;
    String str = parama.f();
    if (parama.h() != null)
    {
      if (a(parama.f()) == null)
      {
        an.a(bool, "Concrete field shouldn't be value object: " + parama.f());
        if (!parama.e()) {
          break label80;
        }
      }
      label80:
      for (parama = d();; parama = c())
      {
        if (parama == null) {
          break label88;
        }
        return parama.get(str);
        bool = false;
        break;
      }
      try
      {
        label88:
        parama = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        parama = getClass().getMethod(parama, new Class[0]).invoke(this, new Object[0]);
        return parama;
      }
      catch (Exception parama)
      {
        throw new RuntimeException(parama);
      }
    }
    return a(parama.f());
  }
  
  public abstract HashMap b();
  
  protected abstract boolean b(String paramString);
  
  public HashMap c()
  {
    return null;
  }
  
  protected boolean c(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  public HashMap d()
  {
    return null;
  }
  
  protected boolean d(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  public String toString()
  {
    HashMap localHashMap = b();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      dw.a locala = (dw.a)localHashMap.get(str);
      if (a(locala))
      {
        Object localObject = a(locala, b(locala));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null) {
            break label135;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label135:
        switch (locala.d())
        {
        default: 
          if (locala.c()) {
            a(localStringBuilder, locala, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(az.a((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(az.b((byte[])localObject)).append("\"");
          break;
        case 10: 
          bc.a(localStringBuilder, (HashMap)localObject);
          continue;
          a(localStringBuilder, locala, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */