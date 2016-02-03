package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.f;
import com.google.gson.internal.g;
import com.google.gson.n;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class j
  implements n
{
  private final com.google.gson.internal.b aeD;
  private final com.google.gson.c afT;
  private final com.google.gson.internal.c afU;
  
  public j(com.google.gson.internal.b paramb, com.google.gson.c paramc, com.google.gson.internal.c paramc1)
  {
    this.aeD = paramb;
    this.afT = paramc;
    this.afU = paramc1;
  }
  
  private b a(final d paramd, final Field paramField, String paramString, final com.google.gson.b.a<?> parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    new b(paramString, paramBoolean1, paramBoolean2)
    {
      final com.google.gson.m<?> afV = paramd.a(parama);
      
      void a(com.google.gson.stream.a paramAnonymousa, Object paramAnonymousObject)
      {
        paramAnonymousa = this.afV.b(paramAnonymousa);
        if ((paramAnonymousa != null) || (!this.afZ)) {
          paramField.set(paramAnonymousObject, paramAnonymousa);
        }
      }
      
      void a(com.google.gson.stream.b paramAnonymousb, Object paramAnonymousObject)
      {
        paramAnonymousObject = paramField.get(paramAnonymousObject);
        new m(paramd, this.afV, parama.Aa()).a(paramAnonymousb, paramAnonymousObject);
      }
    };
  }
  
  private Map<String, b> a(d paramd, com.google.gson.b.a<?> parama, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = parama.Aa();
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        boolean bool1 = a((Field)localObject, true);
        boolean bool2 = a((Field)localObject, false);
        if ((!bool1) && (!bool2)) {}
        do
        {
          i += 1;
          break;
          ((Field)localObject).setAccessible(true);
          Type localType2 = .Gson.Types.a(parama.Aa(), paramClass, ((Field)localObject).getGenericType());
          localObject = a(paramd, (Field)localObject, c((Field)localObject), com.google.gson.b.a.p(localType2), bool1, bool2);
          localObject = (b)localLinkedHashMap.put(((b)localObject).name, localObject);
        } while (localObject == null);
        throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + ((b)localObject).name);
      }
      parama = com.google.gson.b.a.p(.Gson.Types.a(parama.Aa(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = parama.zZ();
    }
    return localLinkedHashMap;
  }
  
  private String c(Field paramField)
  {
    com.google.gson.a.b localb = (com.google.gson.a.b)paramField.getAnnotation(com.google.gson.a.b.class);
    if (localb == null) {
      return this.afT.b(paramField);
    }
    return localb.yS();
  }
  
  public <T> com.google.gson.m<T> a(d paramd, com.google.gson.b.a<T> parama)
  {
    Class localClass = parama.zZ();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new a(this.aeD.b(parama), a(paramd, parama, localClass), null);
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    return (!this.afU.b(paramField.getType(), paramBoolean)) && (!this.afU.a(paramField, paramBoolean));
  }
  
  public final class a<T>
    extends com.google.gson.m<T>
  {
    private final f<T> afC;
    private final Map<String, j.b> agb;
    
    private a(Map<String, j.b> paramMap)
    {
      this.afC = paramMap;
      Map localMap;
      this.agb = localMap;
    }
    
    public void a(com.google.gson.stream.b paramb, T paramT)
    {
      if (paramT == null)
      {
        paramb.zX();
        return;
      }
      paramb.zV();
      try
      {
        Iterator localIterator = this.agb.values().iterator();
        while (localIterator.hasNext())
        {
          j.b localb = (j.b)localIterator.next();
          if (localb.agc)
          {
            paramb.cL(localb.name);
            localb.a(paramb, paramT);
          }
        }
        paramb.zW();
      }
      catch (IllegalAccessException paramb)
      {
        throw new AssertionError();
      }
    }
    
    public T b(com.google.gson.stream.a parama)
    {
      if (parama.zN() == JsonToken.ahQ)
      {
        parama.nextNull();
        return null;
      }
      Object localObject1 = this.afC.zI();
      try
      {
        parama.beginObject();
        for (;;)
        {
          if (!parama.hasNext()) {
            break label103;
          }
          localObject2 = parama.nextName();
          localObject2 = (j.b)this.agb.get(localObject2);
          if ((localObject2 != null) && (((j.b)localObject2).agd)) {
            break;
          }
          parama.skipValue();
        }
      }
      catch (IllegalStateException parama)
      {
        for (;;)
        {
          Object localObject2;
          throw new JsonSyntaxException(parama);
          ((j.b)localObject2).a(parama, localObject1);
        }
      }
      catch (IllegalAccessException parama)
      {
        throw new AssertionError(parama);
      }
      label103:
      parama.endObject();
      return (T)localObject1;
    }
  }
  
  static abstract class b
  {
    final boolean agc;
    final boolean agd;
    final String name;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.agc = paramBoolean1;
      this.agd = paramBoolean2;
    }
    
    abstract void a(com.google.gson.stream.a parama, Object paramObject);
    
    abstract void a(com.google.gson.stream.b paramb, Object paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */