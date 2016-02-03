package com.google.android.gms.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class hy
{
  private void a(StringBuilder paramStringBuilder, hy.a parama, Object paramObject)
  {
    if (parama.fE() == 11)
    {
      paramStringBuilder.append(((hy)parama.fO().cast(paramObject)).toString());
      return;
    }
    if (parama.fE() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(in.aK((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void a(StringBuilder paramStringBuilder, hy.a parama, ArrayList<Object> paramArrayList)
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
  
  protected <O, I> I a(hy.a<I, O> parama, Object paramObject)
  {
    Object localObject = paramObject;
    if (hy.a.c(parama) != null) {
      localObject = parama.g(paramObject);
    }
    return (I)localObject;
  }
  
  protected boolean a(hy.a parama)
  {
    if (parama.fF() == 11)
    {
      if (parama.fL()) {
        return aI(parama.fM());
      }
      return aH(parama.fM());
    }
    return aG(parama.fM());
  }
  
  protected abstract Object aF(String paramString);
  
  protected abstract boolean aG(String paramString);
  
  protected boolean aH(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean aI(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  protected Object b(hy.a parama)
  {
    String str = parama.fM();
    if (parama.fO() != null)
    {
      boolean bool;
      if (aF(parama.fM()) == null)
      {
        bool = true;
        hm.a(bool, "Concrete field shouldn't be value object: %s", new Object[] { parama.fM() });
        if (!parama.fL()) {
          break label71;
        }
      }
      label71:
      for (parama = fI();; parama = fH())
      {
        if (parama == null) {
          break label79;
        }
        return parama.get(str);
        bool = false;
        break;
      }
      try
      {
        label79:
        parama = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        parama = getClass().getMethod(parama, new Class[0]).invoke(this, new Object[0]);
        return parama;
      }
      catch (Exception parama)
      {
        throw new RuntimeException(parama);
      }
    }
    return aF(parama.fM());
  }
  
  public abstract HashMap<String, hy.a<?, ?>> fG();
  
  public HashMap<String, Object> fH()
  {
    return null;
  }
  
  public HashMap<String, Object> fI()
  {
    return null;
  }
  
  public String toString()
  {
    HashMap localHashMap = fG();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      hy.a locala = (hy.a)localHashMap.get(str);
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
        switch (locala.fF())
        {
        default: 
          if (locala.fK()) {
            a(localStringBuilder, locala, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(ih.d((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(ih.e((byte[])localObject)).append("\"");
          break;
        case 10: 
          io.a(localStringBuilder, (HashMap)localObject);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */