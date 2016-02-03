package com.chartboost.sdk.impl;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class aq
  implements an
{
  protected au a;
  
  private void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    a((byte)5, paramString);
    int j = paramArrayOfByte.length;
    int i = j;
    if (paramInt == 2) {
      i = j + 4;
    }
    this.a.c(i);
    this.a.write(paramInt);
    if (paramInt == 2) {
      this.a.c(i - 4);
    }
    paramInt = this.a.a();
    this.a.write(paramArrayOfByte);
    af.a(this.a.a() - paramInt, paramArrayOfByte.length);
  }
  
  private void a(String paramString, Iterable paramIterable)
  {
    a((byte)4, paramString);
    int j = this.a.a();
    this.a.c(0);
    paramString = paramIterable.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      b(String.valueOf(i), paramString.next());
      i += 1;
    }
    this.a.write(0);
    this.a.a(j, this.a.a() - j);
  }
  
  private void a(String paramString1, String paramString2, byte paramByte)
  {
    a(paramByte, paramString1);
    b(paramString2);
  }
  
  private void a(String paramString, Map paramMap)
  {
    a((byte)3, paramString);
    int i = this.a.a();
    this.a.c(0);
    paramString = paramMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      paramMap = (Map.Entry)paramString.next();
      b(paramMap.getKey().toString(), paramMap.getValue());
    }
    this.a.write(0);
    this.a.a(i, this.a.a() - i);
  }
  
  private void a(String paramString, Pattern paramPattern)
  {
    a((byte)11, paramString);
    c(paramPattern.pattern());
    c(al.a(paramPattern.flags()));
  }
  
  private void c(String paramString, Object paramObject)
  {
    a((byte)4, paramString);
    int j = this.a.a();
    this.a.c(0);
    int k = Array.getLength(paramObject);
    int i = 0;
    while (i < k)
    {
      b(String.valueOf(i), Array.get(paramObject, i));
      i += 1;
    }
    this.a.write(0);
    this.a.a(j, this.a.a() - j);
  }
  
  private void d(String paramString)
  {
    a((byte)-1, paramString);
  }
  
  private void e(String paramString)
  {
    a((byte)Byte.MAX_VALUE, paramString);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  protected void a(byte paramByte, String paramString)
  {
    this.a.write(paramByte);
    c(paramString);
  }
  
  public void a(au paramau)
  {
    if (this.a != null) {
      throw new IllegalStateException("in the middle of something");
    }
    this.a = paramau;
  }
  
  protected void a(String paramString)
  {
    a((byte)10, paramString);
  }
  
  protected void a(String paramString, ax paramax)
  {
    a((byte)17, paramString);
    this.a.c(paramax.b());
    this.a.c(paramax.a());
  }
  
  protected void a(String paramString, ay paramay)
  {
    a(paramString, paramay.a(), paramay.b());
  }
  
  protected void a(String paramString, az paramaz)
  {
    a((byte)13, paramString);
    this.a.a();
    b(paramaz.a());
  }
  
  protected void a(String paramString, ba paramba)
  {
    a((byte)15, paramString);
    int i = this.a.a();
    this.a.c(0);
    b(paramba.a());
    b(paramba.b());
    this.a.a(i, this.a.a() - i);
  }
  
  protected void a(String paramString, bd parambd)
  {
    a((byte)7, paramString);
    this.a.d(parambd.c());
    this.a.d(parambd.d());
    this.a.d(parambd.e());
  }
  
  protected void a(String paramString, be parambe)
  {
    a(paramString, parambe.a(), (byte)14);
  }
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    a((byte)8, paramString);
    paramString = this.a;
    if (paramBoolean.booleanValue()) {}
    for (int i = 1;; i = 0)
    {
      paramString.write(i);
      return;
    }
  }
  
  protected void a(String paramString, Number paramNumber)
  {
    if (((paramNumber instanceof Integer)) || ((paramNumber instanceof Short)) || ((paramNumber instanceof Byte)) || ((paramNumber instanceof AtomicInteger)))
    {
      a((byte)16, paramString);
      this.a.c(paramNumber.intValue());
      return;
    }
    if (((paramNumber instanceof Long)) || ((paramNumber instanceof AtomicLong)))
    {
      a((byte)18, paramString);
      this.a.a(paramNumber.longValue());
      return;
    }
    if (((paramNumber instanceof Float)) || ((paramNumber instanceof Double)))
    {
      a((byte)1, paramString);
      this.a.a(paramNumber.doubleValue());
      return;
    }
    throw new IllegalArgumentException("can't serialize " + paramNumber.getClass());
  }
  
  protected void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, (byte)2);
  }
  
  protected void a(String paramString, Date paramDate)
  {
    a((byte)9, paramString);
    this.a.a(paramDate.getTime());
  }
  
  protected void a(String paramString, UUID paramUUID)
  {
    a((byte)5, paramString);
    this.a.c(16);
    this.a.write(3);
    this.a.a(paramUUID.getMostSignificantBits());
    this.a.a(paramUUID.getLeastSignificantBits());
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte)
  {
    a(paramString, 0, paramArrayOfByte);
  }
  
  protected boolean a(String paramString, ao paramao)
  {
    return false;
  }
  
  protected boolean a(String paramString, Object paramObject)
  {
    return false;
  }
  
  public byte[] a(ao paramao)
  {
    at localat = new at();
    a(localat);
    b(paramao);
    a();
    return localat.c();
  }
  
  public int b(ao paramao)
  {
    return b(null, paramao);
  }
  
  protected int b(String paramString, ao paramao)
  {
    if (paramao == null) {
      throw new NullPointerException("can't save a null object");
    }
    int j = this.a.a();
    if ((paramao instanceof List)) {}
    for (byte b = 4;; b = 3)
    {
      if (a(paramString, paramao)) {
        return this.a.a() - j;
      }
      if (paramString != null) {
        a(b, paramString);
      }
      int k = this.a.a();
      this.a.c(0);
      Object localObject1 = null;
      if ((b == 3) && (paramString == null)) {}
      Object localObject2;
      for (int i = 1;; i = 0)
      {
        paramString = (String)localObject1;
        if (b == 3)
        {
          if ((i != 0) && (paramao.b("_id"))) {
            b("_id", paramao.a("_id"));
          }
          localObject2 = paramao.a("_transientFields");
          paramString = (String)localObject1;
          if ((localObject2 instanceof List)) {
            paramString = (List)localObject2;
          }
        }
        if (!(paramao instanceof Map)) {
          break;
        }
        paramao = ((Map)paramao).entrySet().iterator();
        while (paramao.hasNext())
        {
          localObject1 = (Map.Entry)paramao.next();
          if (((i == 0) || (!((String)((Map.Entry)localObject1).getKey()).equals("_id"))) && ((paramString == null) || (!paramString.contains(((Map.Entry)localObject1).getKey())))) {
            b((String)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
          }
        }
      }
      localObject1 = paramao.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((i == 0) || (!((String)localObject2).equals("_id"))) && ((paramString == null) || (!paramString.contains(localObject2)))) {
          b((String)localObject2, paramao.a((String)localObject2));
        }
      }
      this.a.write(0);
      this.a.a(k, this.a.a() - k);
      return this.a.a() - j;
    }
  }
  
  protected void b(String paramString)
  {
    int i = this.a.a();
    this.a.c(0);
    int j = c(paramString);
    this.a.a(i, j);
  }
  
  protected void b(String paramString, Object paramObject)
  {
    if (paramString.equals("_transientFields")) {}
    do
    {
      return;
      if ((paramString.equals("$where")) && ((paramObject instanceof String)))
      {
        a((byte)13, paramString);
        b(paramObject.toString());
        return;
      }
      paramObject = al.a(paramObject);
      if (paramObject == null)
      {
        a(paramString);
        return;
      }
      if ((paramObject instanceof Date))
      {
        a(paramString, (Date)paramObject);
        return;
      }
      if ((paramObject instanceof Number))
      {
        a(paramString, (Number)paramObject);
        return;
      }
      if ((paramObject instanceof Character))
      {
        a(paramString, paramObject.toString());
        return;
      }
      if ((paramObject instanceof String))
      {
        a(paramString, paramObject.toString());
        return;
      }
      if ((paramObject instanceof bd))
      {
        a(paramString, (bd)paramObject);
        return;
      }
      if ((paramObject instanceof ao))
      {
        b(paramString, (ao)paramObject);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        a(paramString, (Boolean)paramObject);
        return;
      }
      if ((paramObject instanceof Pattern))
      {
        a(paramString, (Pattern)paramObject);
        return;
      }
      if ((paramObject instanceof Map))
      {
        a(paramString, (Map)paramObject);
        return;
      }
      if ((paramObject instanceof Iterable))
      {
        a(paramString, (Iterable)paramObject);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        a(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof ay))
      {
        a(paramString, (ay)paramObject);
        return;
      }
      if ((paramObject instanceof UUID))
      {
        a(paramString, (UUID)paramObject);
        return;
      }
      if (paramObject.getClass().isArray())
      {
        c(paramString, paramObject);
        return;
      }
      if ((paramObject instanceof be))
      {
        a(paramString, (be)paramObject);
        return;
      }
      if ((paramObject instanceof ax))
      {
        a(paramString, (ax)paramObject);
        return;
      }
      if ((paramObject instanceof ba))
      {
        a(paramString, (ba)paramObject);
        return;
      }
      if ((paramObject instanceof az))
      {
        a(paramString, (az)paramObject);
        return;
      }
      if ((paramObject instanceof aa))
      {
        ar localar = new ar();
        localar.a("$ref", ((aa)paramObject).b());
        localar.a("$id", ((aa)paramObject).a());
        b(paramString, localar);
        return;
      }
      if ((paramObject instanceof bc))
      {
        d(paramString);
        return;
      }
      if ((paramObject instanceof bb))
      {
        e(paramString);
        return;
      }
    } while (a(paramString, paramObject));
    throw new IllegalArgumentException("can't serialize " + paramObject.getClass());
  }
  
  protected int c(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      int m = Character.codePointAt(paramString, j);
      if (m < 128)
      {
        this.a.write((byte)m);
        i += 1;
      }
      for (;;)
      {
        j += Character.charCount(m);
        break;
        if (m < 2048)
        {
          this.a.write((byte)((m >> 6) + 192));
          this.a.write((byte)((m & 0x3F) + 128));
          i += 2;
        }
        else if (m < 65536)
        {
          this.a.write((byte)((m >> 12) + 224));
          this.a.write((byte)((m >> 6 & 0x3F) + 128));
          this.a.write((byte)((m & 0x3F) + 128));
          i += 3;
        }
        else
        {
          this.a.write((byte)((m >> 18) + 240));
          this.a.write((byte)((m >> 12 & 0x3F) + 128));
          this.a.write((byte)((m >> 6 & 0x3F) + 128));
          this.a.write((byte)((m & 0x3F) + 128));
          i += 4;
        }
      }
    }
    this.a.write(0);
    return i + 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */