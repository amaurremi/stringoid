package com.google.gson.internal.a;

import com.google.gson.d;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.stream.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i
  extends m<Object>
{
  public static final n afz = new n()
  {
    public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.zZ() == Object.class) {
        return new i(paramAnonymousd, null);
      }
      return null;
    }
  };
  private final d afS;
  
  private i(d paramd)
  {
    this.afS = paramd;
  }
  
  public void a(b paramb, Object paramObject)
  {
    if (paramObject == null)
    {
      paramb.zX();
      return;
    }
    m localm = this.afS.n(paramObject.getClass());
    if ((localm instanceof i))
    {
      paramb.zV();
      paramb.zW();
      return;
    }
    localm.a(paramb, paramObject);
  }
  
  public Object b(com.google.gson.stream.a parama)
  {
    Object localObject = parama.zN();
    switch (2.acN[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      localObject = new ArrayList();
      parama.beginArray();
      while (parama.hasNext()) {
        ((List)localObject).add(b(parama));
      }
      parama.endArray();
      return localObject;
    case 2: 
      localObject = new LinkedHashMap();
      parama.beginObject();
      while (parama.hasNext()) {
        ((Map)localObject).put(parama.nextName(), b(parama));
      }
      parama.endObject();
      return localObject;
    case 3: 
      return parama.nextString();
    case 4: 
      return Double.valueOf(parama.nextDouble());
    case 5: 
      return Boolean.valueOf(parama.nextBoolean());
    }
    parama.nextNull();
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */