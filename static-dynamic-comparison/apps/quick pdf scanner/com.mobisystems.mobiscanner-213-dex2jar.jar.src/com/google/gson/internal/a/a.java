package com.google.gson.internal.a;

import com.google.gson.d;
import com.google.gson.internal..Gson.Types;
import com.google.gson.n;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class a<E>
  extends com.google.gson.m<Object>
{
  public static final n afz = new n()
  {
    public <T> com.google.gson.m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.Aa();
      if ((!(paramAnonymousa instanceof GenericArrayType)) && ((!(paramAnonymousa instanceof Class)) || (!((Class)paramAnonymousa).isArray()))) {
        return null;
      }
      paramAnonymousa = .Gson.Types.d(paramAnonymousa);
      return new a(paramAnonymousd, paramAnonymousd.a(com.google.gson.b.a.p(paramAnonymousa)), .Gson.Types.l(paramAnonymousa));
    }
  };
  private final Class<E> acV;
  private final com.google.gson.m<E> afA;
  
  public a(d paramd, com.google.gson.m<E> paramm, Class<E> paramClass)
  {
    this.afA = new m(paramd, paramm, paramClass);
    this.acV = paramClass;
  }
  
  public void a(b paramb, Object paramObject)
  {
    if (paramObject == null)
    {
      paramb.zX();
      return;
    }
    paramb.zT();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.afA.a(paramb, localObject);
      i += 1;
    }
    paramb.zU();
  }
  
  public Object b(com.google.gson.stream.a parama)
  {
    if (parama.zN() == JsonToken.ahQ)
    {
      parama.nextNull();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.beginArray();
    while (parama.hasNext()) {
      localArrayList.add(this.afA.b(parama));
    }
    parama.endArray();
    parama = Array.newInstance(this.acV, localArrayList.size());
    int i = 0;
    while (i < localArrayList.size())
    {
      Array.set(parama, i, localArrayList.get(i));
      i += 1;
    }
    return parama;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */