package com.google.gson.internal.a;

import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.f;
import com.google.gson.n;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class d
  implements n
{
  private final com.google.gson.internal.b aeD;
  
  public d(com.google.gson.internal.b paramb)
  {
    this.aeD = paramb;
  }
  
  public <T> com.google.gson.m<T> a(com.google.gson.d paramd, com.google.gson.b.a<T> parama)
  {
    Type localType = parama.Aa();
    Class localClass = parama.zZ();
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = .Gson.Types.b(localType, localClass);
    return new a(paramd, localType, paramd.a(com.google.gson.b.a.p(localType)), this.aeD.b(parama));
  }
  
  private final class a<E>
    extends com.google.gson.m<Collection<E>>
  {
    private final com.google.gson.m<E> afB;
    private final f<? extends Collection<E>> afC;
    
    public a(Type paramType, com.google.gson.m<E> paramm, f<? extends Collection<E>> paramf)
    {
      this.afB = new m(paramType, paramf, paramm);
      f localf;
      this.afC = localf;
    }
    
    public void a(com.google.gson.stream.b paramb, Collection<E> paramCollection)
    {
      if (paramCollection == null)
      {
        paramb.zX();
        return;
      }
      paramb.zT();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        this.afB.a(paramb, localObject);
      }
      paramb.zU();
    }
    
    public Collection<E> h(com.google.gson.stream.a parama)
    {
      if (parama.zN() == JsonToken.ahQ)
      {
        parama.nextNull();
        return null;
      }
      Collection localCollection = (Collection)this.afC.zI();
      parama.beginArray();
      while (parama.hasNext()) {
        localCollection.add(this.afB.b(parama));
      }
      parama.endArray();
      return localCollection;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */