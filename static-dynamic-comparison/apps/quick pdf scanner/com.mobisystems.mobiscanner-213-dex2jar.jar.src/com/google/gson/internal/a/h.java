package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.e;
import com.google.gson.internal.f;
import com.google.gson.k;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  implements com.google.gson.n
{
  private final com.google.gson.internal.b aeD;
  private final boolean afO;
  
  public h(com.google.gson.internal.b paramb, boolean paramBoolean)
  {
    this.aeD = paramb;
    this.afO = paramBoolean;
  }
  
  private static <T> com.google.gson.h a(com.google.gson.m<T> paramm, T paramT)
  {
    try
    {
      g localg = new g();
      localg.setLenient(true);
      paramm.a(localg, paramT);
      paramm = localg.zR();
      return paramm;
    }
    catch (IOException paramm)
    {
      throw new JsonIOException(paramm);
    }
  }
  
  private com.google.gson.m<?> a(d paramd, Type paramType)
  {
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {
      return n.agn;
    }
    return paramd.a(com.google.gson.b.a.p(paramType));
  }
  
  public <T> com.google.gson.m<T> a(d paramd, com.google.gson.b.a<T> parama)
  {
    Object localObject = parama.Aa();
    if (!Map.class.isAssignableFrom(parama.zZ())) {
      return null;
    }
    localObject = .Gson.Types.c((Type)localObject, .Gson.Types.l((Type)localObject));
    com.google.gson.m localm1 = a(paramd, localObject[0]);
    com.google.gson.m localm2 = paramd.a(com.google.gson.b.a.p(localObject[1]));
    parama = this.aeD.b(parama);
    return new a(paramd, localObject[0], localm1, localObject[1], localm2, parama);
  }
  
  private final class a<K, V>
    extends com.google.gson.m<Map<K, V>>
  {
    private final f<? extends Map<K, V>> afC;
    private final com.google.gson.m<K> afP;
    private final com.google.gson.m<V> afQ;
    
    public a(Type paramType1, com.google.gson.m<K> paramm, Type paramType2, com.google.gson.m<V> paramm1, f<? extends Map<K, V>> paramf)
    {
      this.afP = new m(paramType1, paramType2, paramm);
      this.afQ = new m(paramType1, paramf, paramm1);
      f localf;
      this.afC = localf;
    }
    
    private String d(com.google.gson.h paramh)
    {
      if (paramh.zw())
      {
        paramh = paramh.zA();
        if (paramh.zD()) {
          return String.valueOf(paramh.zo());
        }
        if (paramh.zC()) {
          return Boolean.toString(paramh.zt());
        }
        if (paramh.zE()) {
          return paramh.zp();
        }
        throw new AssertionError();
      }
      if (paramh.zx()) {
        return "null";
      }
      throw new AssertionError();
    }
    
    public void a(com.google.gson.stream.b paramb, Map<K, V> paramMap)
    {
      int m = 0;
      int k = 0;
      if (paramMap == null)
      {
        paramb.zX();
        return;
      }
      if (!h.a(h.this))
      {
        paramb.zV();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          paramb.cL(String.valueOf(((Map.Entry)localObject).getKey()));
          this.afQ.a(paramb, ((Map.Entry)localObject).getValue());
        }
        paramb.zW();
        return;
      }
      Object localObject = new ArrayList(paramMap.size());
      ArrayList localArrayList = new ArrayList(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      int i = 0;
      if (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        com.google.gson.h localh = h.b(this.afP, localEntry.getKey());
        ((List)localObject).add(localh);
        localArrayList.add(localEntry.getValue());
        if ((localh.zu()) || (localh.zv())) {}
        for (int j = 1;; j = 0)
        {
          i = j | i;
          break;
        }
      }
      if (i != 0)
      {
        paramb.zT();
        i = k;
        while (i < ((List)localObject).size())
        {
          paramb.zT();
          com.google.gson.internal.h.b((com.google.gson.h)((List)localObject).get(i), paramb);
          this.afQ.a(paramb, localArrayList.get(i));
          paramb.zU();
          i += 1;
        }
        paramb.zU();
        return;
      }
      paramb.zV();
      i = m;
      while (i < ((List)localObject).size())
      {
        paramb.cL(d((com.google.gson.h)((List)localObject).get(i)));
        this.afQ.a(paramb, localArrayList.get(i));
        i += 1;
      }
      paramb.zW();
    }
    
    public Map<K, V> j(com.google.gson.stream.a parama)
    {
      Object localObject = parama.zN();
      if (localObject == JsonToken.ahQ)
      {
        parama.nextNull();
        return null;
      }
      Map localMap = (Map)this.afC.zI();
      if (localObject == JsonToken.ahI)
      {
        parama.beginArray();
        while (parama.hasNext())
        {
          parama.beginArray();
          localObject = this.afP.b(parama);
          if (localMap.put(localObject, this.afQ.b(parama)) != null) {
            throw new JsonSyntaxException("duplicate key: " + localObject);
          }
          parama.endArray();
        }
        parama.endArray();
        return localMap;
      }
      parama.beginObject();
      while (parama.hasNext())
      {
        e.afp.e(parama);
        localObject = this.afP.b(parama);
        if (localMap.put(localObject, this.afQ.b(parama)) != null) {
          throw new JsonSyntaxException("duplicate key: " + localObject);
        }
      }
      parama.endObject();
      return localMap;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */