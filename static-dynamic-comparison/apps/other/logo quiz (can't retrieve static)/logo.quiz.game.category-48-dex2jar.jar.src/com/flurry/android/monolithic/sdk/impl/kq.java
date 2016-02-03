package com.flurry.android.monolithic.sdk.impl;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class kq
{
  private static final kq a = new kq();
  private static final ji b = ji.a(kj.g);
  
  public static kq a()
  {
    return a;
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      int j;
      switch (c)
      {
      default: 
        if (((c >= 0) && (c <= '\037')) || ((c >= '') && (c <= '')) || ((c >= ' ') && (c <= '⃿')))
        {
          Integer.toHexString(c);
          paramStringBuilder.append("\\u");
          j = 0;
        }
        break;
      case '"': 
        while (j < 4 - paramStringBuilder.length())
        {
          paramStringBuilder.append('0');
          j += 1;
          continue;
          paramStringBuilder.append("\\\"");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append("\\\\");
        continue;
        paramStringBuilder.append("\\b");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\/");
        continue;
        paramStringBuilder.append(paramString.toUpperCase());
        continue;
        paramStringBuilder.append(c);
      }
    }
  }
  
  protected int a(int paramInt, Object paramObject, ji paramji)
  {
    return paramInt * 31 + b(paramObject, paramji);
  }
  
  public int a(ji paramji, Object paramObject)
  {
    Integer localInteger = paramji.e(b(paramObject));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new km(paramji, paramObject);
  }
  
  public int a(Object paramObject1, Object paramObject2, ji paramji)
  {
    return a(paramObject1, paramObject2, paramji, false);
  }
  
  protected int a(Object paramObject1, Object paramObject2, ji paramji, boolean paramBoolean)
  {
    int i = 1;
    if (paramObject1 == paramObject2) {}
    do
    {
      return 0;
      switch (kr.a[paramji.a().ordinal()])
      {
      case 14: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return ((Comparable)paramObject1).compareTo(paramObject2);
      case 1: 
        paramji = paramji.b().iterator();
        js localjs;
        do
        {
          do
          {
            if (!paramji.hasNext()) {
              break;
            }
            localjs = (js)paramji.next();
          } while (localjs.f() == jt.c);
          i = localjs.b();
          String str = localjs.a();
          i = a(a(paramObject1, str, i), a(paramObject2, str, i), localjs.c(), paramBoolean);
        } while (i == 0);
        if (localjs.f() == jt.b) {
          i = -i;
        }
        for (;;)
        {
          return i;
        }
      case 2: 
        return paramji.c(paramObject1.toString()) - paramji.c(paramObject2.toString());
      case 3: 
        paramObject1 = (Collection)paramObject1;
        paramObject2 = (Collection)paramObject2;
        paramObject1 = ((Collection)paramObject1).iterator();
        paramObject2 = ((Collection)paramObject2).iterator();
        paramji = paramji.i();
        while ((((Iterator)paramObject1).hasNext()) && (((Iterator)paramObject2).hasNext()))
        {
          j = a(((Iterator)paramObject1).next(), ((Iterator)paramObject2).next(), paramji, paramBoolean);
          if (j != 0) {
            return j;
          }
        }
        if (((Iterator)paramObject1).hasNext()) {}
        for (;;)
        {
          return i;
          if (((Iterator)paramObject2).hasNext()) {
            i = -1;
          } else {
            i = 0;
          }
        }
      case 4: 
        if (!paramBoolean) {
          break label361;
        }
      }
    } while (((Map)paramObject1).equals(paramObject2));
    return 1;
    label361:
    throw new jg("Can't compare maps!");
    i = a(paramji, paramObject1);
    int j = a(paramji, paramObject2);
    if (i == j) {
      i = a(paramObject1, paramObject2, (ji)paramji.k().get(i), paramBoolean);
    }
    for (;;)
    {
      return i;
      i -= j;
    }
    if ((paramObject1 instanceof nw))
    {
      paramObject1 = (nw)paramObject1;
      if (!(paramObject2 instanceof nw)) {
        break label476;
      }
    }
    label476:
    for (paramObject2 = (nw)paramObject2;; paramObject2 = new nw(paramObject2.toString()))
    {
      return ((nw)paramObject1).a((nw)paramObject2);
      paramObject1 = new nw(paramObject1.toString());
      break;
    }
  }
  
  public lw a(ji paramji)
  {
    return new kx(paramji, paramji, this);
  }
  
  protected Object a(Object paramObject, ji paramji)
  {
    return null;
  }
  
  public Object a(Object paramObject, String paramString, int paramInt)
  {
    return ((lf)paramObject).a(paramInt);
  }
  
  public Object a(Object paramObject, byte[] paramArrayOfByte, ji paramji)
  {
    paramObject = (ld)c(paramObject, paramji);
    System.arraycopy(paramArrayOfByte, 0, ((ld)paramObject).b(), 0, paramji.l());
    return paramObject;
  }
  
  public String a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramObject, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void a(Object paramObject1, String paramString, int paramInt, Object paramObject2)
  {
    ((lf)paramObject1).a(paramInt, paramObject2);
  }
  
  protected void a(Object paramObject1, String paramString, int paramInt, Object paramObject2, Object paramObject3)
  {
    a(paramObject1, paramString, paramInt, paramObject2);
  }
  
  protected void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (d(paramObject))
    {
      paramStringBuilder.append("{");
      localObject1 = e(paramObject);
      localObject2 = ((ji)localObject1).b().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        js localjs = (js)((Iterator)localObject2).next();
        a(localjs.a(), paramStringBuilder);
        paramStringBuilder.append(": ");
        a(a(paramObject, localjs.a(), localjs.b()), paramStringBuilder);
        i += 1;
        if (i < ((ji)localObject1).b().size()) {
          paramStringBuilder.append(", ");
        }
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = (Collection)paramObject;
      paramStringBuilder.append("[");
      long l = ((Collection)paramObject).size() - 1;
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext())
      {
        a(((Iterator)paramObject).next(), paramStringBuilder);
        if (i < l) {
          paramStringBuilder.append(", ");
        }
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramStringBuilder.append("{");
      paramObject = (Map)paramObject;
      localObject1 = ((Map)paramObject).entrySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        a(((Map.Entry)localObject2).getKey(), paramStringBuilder);
        paramStringBuilder.append(": ");
        a(((Map.Entry)localObject2).getValue(), paramStringBuilder);
        i += 1;
        if (i < ((Map)paramObject).size()) {
          paramStringBuilder.append(", ");
        }
      }
      paramStringBuilder.append("}");
      return;
    }
    if (((paramObject instanceof CharSequence)) || ((paramObject instanceof lc)))
    {
      paramStringBuilder.append("\"");
      a(paramObject.toString(), paramStringBuilder);
      paramStringBuilder.append("\"");
      return;
    }
    if ((paramObject instanceof ByteBuffer))
    {
      paramStringBuilder.append("{\"bytes\": \"");
      paramObject = (ByteBuffer)paramObject;
      i = ((ByteBuffer)paramObject).position();
      while (i < ((ByteBuffer)paramObject).limit())
      {
        paramStringBuilder.append((char)((ByteBuffer)paramObject).get(i));
        i += 1;
      }
      paramStringBuilder.append("\"}");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  public int b(Object paramObject, ji paramji)
  {
    int j = 0;
    if (paramObject == null) {
      return j;
    }
    int i = 1;
    switch (kr.a[paramji.a().ordinal()])
    {
    case 14: 
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramObject.hashCode();
    case 1: 
      paramji = paramji.b().iterator();
      i = 1;
      for (;;)
      {
        j = i;
        if (!paramji.hasNext()) {
          break;
        }
        js localjs = (js)paramji.next();
        if (localjs.f() != jt.c) {
          i = a(i, a(paramObject, localjs.a(), localjs.b()), localjs.c());
        }
      }
    case 3: 
      paramObject = (Collection)paramObject;
      paramji = paramji.i();
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        i = a(i, ((Iterator)paramObject).next(), paramji);
      }
      return i;
    case 5: 
      return b(paramObject, (ji)paramji.k().get(a(paramji, paramObject)));
    case 2: 
      return paramji.c(paramObject.toString());
    }
    if ((paramObject instanceof nw)) {}
    for (;;)
    {
      return paramObject.hashCode();
      paramObject = new nw(paramObject.toString());
    }
  }
  
  public Object b(ji paramji, Object paramObject)
  {
    Object localObject1;
    if (paramObject == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject1 = paramObject;
      Object localObject2;
      switch (kr.a[paramji.a().ordinal()])
      {
      case 2: 
      default: 
        throw new jg("Deep copy failed for schema \"" + paramji + "\" and value \"" + paramObject + "\"");
      case 3: 
        localObject1 = (List)paramObject;
        paramObject = new ks(((List)localObject1).size(), paramji);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          ((List)paramObject).add(b(paramji.i(), localObject2));
        }
        return paramObject;
      case 13: 
        return new Boolean(((Boolean)paramObject).booleanValue());
      case 8: 
        paramji = (ByteBuffer)paramObject;
        paramObject = new byte[paramji.capacity()];
        paramji.rewind();
        paramji.get((byte[])paramObject);
        paramji.rewind();
        return ByteBuffer.wrap((byte[])paramObject);
      case 12: 
        return new Double(((Double)paramObject).doubleValue());
      case 6: 
        return a(null, ((ld)paramObject).b(), paramji);
      case 11: 
        return new Float(((Float)paramObject).floatValue());
      case 9: 
        return new Integer(((Integer)paramObject).intValue());
      case 10: 
        return new Long(((Long)paramObject).longValue());
      case 4: 
        localObject1 = (Map)paramObject;
        paramObject = new HashMap(((Map)localObject1).size());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          ((Map)paramObject).put((CharSequence)b(b, ((Map.Entry)localObject2).getKey()), b(paramji.j(), ((Map.Entry)localObject2).getValue()));
        }
        return paramObject;
      case 14: 
        return null;
      case 1: 
        paramObject = (lf)paramObject;
        localObject1 = (lf)d(null, paramji);
        paramji = paramji.b().iterator();
        while (paramji.hasNext())
        {
          localObject2 = (js)paramji.next();
          ((lf)localObject1).a(((js)localObject2).b(), b(((js)localObject2).c(), ((lf)paramObject).a(((js)localObject2).b())));
        }
        return localObject1;
      case 7: 
        localObject1 = paramObject;
      }
    } while ((paramObject instanceof String));
    if ((paramObject instanceof nw)) {
      return new nw((nw)paramObject);
    }
    return new nw(paramObject.toString());
    return b((ji)paramji.k().get(a(paramji, paramObject)), paramObject);
  }
  
  protected Object b(Object paramObject1, String paramString, int paramInt, Object paramObject2)
  {
    return a(paramObject1, paramString, paramInt);
  }
  
  protected String b(Object paramObject)
  {
    if (paramObject == null) {
      return kj.n.a();
    }
    if (d(paramObject)) {
      return e(paramObject).g();
    }
    if (f(paramObject)) {
      return g(paramObject).g();
    }
    if (c(paramObject)) {
      return kj.c.a();
    }
    if (h(paramObject)) {
      return kj.d.a();
    }
    if (i(paramObject)) {
      return j(paramObject).g();
    }
    if (k(paramObject)) {
      return kj.g.a();
    }
    if (l(paramObject)) {
      return kj.h.a();
    }
    if ((paramObject instanceof Integer)) {
      return kj.i.a();
    }
    if ((paramObject instanceof Long)) {
      return kj.j.a();
    }
    if ((paramObject instanceof Float)) {
      return kj.k.a();
    }
    if ((paramObject instanceof Double)) {
      return kj.l.a();
    }
    if ((paramObject instanceof Boolean)) {
      return kj.m.a();
    }
    throw new jg("Unknown datum type: " + paramObject);
  }
  
  public Object c(Object paramObject, ji paramji)
  {
    if (((paramObject instanceof ld)) && (((ld)paramObject).b().length == paramji.l())) {
      return paramObject;
    }
    return new kv(paramji);
  }
  
  protected boolean c(Object paramObject)
  {
    return paramObject instanceof Collection;
  }
  
  public Object d(Object paramObject, ji paramji)
  {
    if ((paramObject instanceof lf))
    {
      paramObject = (lf)paramObject;
      if (((lf)paramObject).a() == paramji) {
        return paramObject;
      }
    }
    return new kw(paramji);
  }
  
  protected boolean d(Object paramObject)
  {
    return paramObject instanceof lf;
  }
  
  protected ji e(Object paramObject)
  {
    return ((kp)paramObject).a();
  }
  
  protected boolean f(Object paramObject)
  {
    return paramObject instanceof lc;
  }
  
  protected ji g(Object paramObject)
  {
    return ((kp)paramObject).a();
  }
  
  protected boolean h(Object paramObject)
  {
    return paramObject instanceof Map;
  }
  
  protected boolean i(Object paramObject)
  {
    return paramObject instanceof ld;
  }
  
  protected ji j(Object paramObject)
  {
    return ((kp)paramObject).a();
  }
  
  protected boolean k(Object paramObject)
  {
    return paramObject instanceof CharSequence;
  }
  
  protected boolean l(Object paramObject)
  {
    return paramObject instanceof ByteBuffer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */