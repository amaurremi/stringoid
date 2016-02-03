package com.google.gson.internal.a;

import com.google.gson.d;
import com.google.gson.stream.b;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T>
  extends com.google.gson.m<T>
{
  private final com.google.gson.m<T> aeL;
  private final d agg;
  private final Type agh;
  
  m(d paramd, com.google.gson.m<T> paramm, Type paramType)
  {
    this.agg = paramd;
    this.aeL = paramm;
    this.agh = paramType;
  }
  
  private Type a(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    return (Type)localObject;
  }
  
  public void a(b paramb, T paramT)
  {
    com.google.gson.m localm = this.aeL;
    Type localType = a(this.agh, paramT);
    if (localType != this.agh)
    {
      localm = this.agg.a(com.google.gson.b.a.p(localType));
      if ((localm instanceof j.a)) {
        break label52;
      }
    }
    for (;;)
    {
      localm.a(paramb, paramT);
      return;
      label52:
      if (!(this.aeL instanceof j.a)) {
        localm = this.aeL;
      }
    }
  }
  
  public T b(com.google.gson.stream.a parama)
  {
    return (T)this.aeL.b(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */