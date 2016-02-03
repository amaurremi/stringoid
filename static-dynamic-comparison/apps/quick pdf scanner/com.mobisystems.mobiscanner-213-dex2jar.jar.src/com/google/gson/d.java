package com.google.gson;

import com.google.gson.internal.a.j;
import com.google.gson.internal.a.k;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> aeA = new ThreadLocal()
  {
    protected Map<com.google.gson.b.a<?>, d.a<?>> zn()
    {
      return new HashMap();
    }
  };
  private final Map<com.google.gson.b.a<?>, m<?>> aeB = Collections.synchronizedMap(new HashMap());
  private final List<n> aeC;
  private final com.google.gson.internal.b aeD;
  private final boolean aeE;
  private final boolean aeF;
  private final boolean aeG;
  private final boolean aeH;
  final g aeI = new g() {};
  final l aeJ = new l() {};
  
  static
  {
    com.google.gson.internal.d.afo = new com.google.gson.internal.d()
    {
      public <T> m<T> a(d paramAnonymousd, n paramAnonymousn, com.google.gson.b.a<T> paramAnonymousa)
      {
        Iterator localIterator = d.a(paramAnonymousd).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject = (n)localIterator.next();
          if (i == 0)
          {
            if (localObject == paramAnonymousn) {
              i = 1;
            }
          }
          else
          {
            localObject = ((n)localObject).a(paramAnonymousd, paramAnonymousa);
            if (localObject != null) {
              return (m<T>)localObject;
            }
          }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + paramAnonymousa);
      }
    };
  }
  
  public d()
  {
    this(com.google.gson.internal.c.afc, FieldNamingPolicy.aeu, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.aeR, Collections.emptyList());
  }
  
  d(com.google.gson.internal.c paramc, c paramc1, Map<Type, e<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, LongSerializationPolicy paramLongSerializationPolicy, List<n> paramList)
  {
    this.aeD = new com.google.gson.internal.b(paramMap);
    this.aeE = paramBoolean1;
    this.aeG = paramBoolean3;
    this.aeF = paramBoolean4;
    this.aeH = paramBoolean5;
    paramc1 = new j(this.aeD, paramc1, paramc);
    paramMap = new com.google.gson.internal.b();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(com.google.gson.internal.a.n.agD);
    localArrayList.add(com.google.gson.internal.a.n.agu);
    localArrayList.add(com.google.gson.internal.a.n.ago);
    localArrayList.add(com.google.gson.internal.a.n.agq);
    localArrayList.add(com.google.gson.internal.a.n.ags);
    localArrayList.add(com.google.gson.internal.a.n.a(Long.TYPE, Long.class, a(paramLongSerializationPolicy)));
    localArrayList.add(com.google.gson.internal.a.n.a(Double.TYPE, Double.class, ax(paramBoolean6)));
    localArrayList.add(com.google.gson.internal.a.n.a(Float.TYPE, Float.class, ay(paramBoolean6)));
    localArrayList.add(paramc);
    localArrayList.add(com.google.gson.internal.a.n.agz);
    localArrayList.add(com.google.gson.internal.a.n.agB);
    localArrayList.add(com.google.gson.internal.a.n.agF);
    localArrayList.add(com.google.gson.internal.a.n.agH);
    localArrayList.add(com.google.gson.internal.a.n.a(BigDecimal.class, new com.google.gson.internal.a.b()));
    localArrayList.add(com.google.gson.internal.a.n.a(BigInteger.class, new com.google.gson.internal.a.c()));
    localArrayList.add(com.google.gson.internal.a.n.agW);
    localArrayList.add(com.google.gson.internal.a.i.afz);
    localArrayList.addAll(paramList);
    localArrayList.add(new com.google.gson.internal.a.d(paramMap));
    localArrayList.add(com.google.gson.internal.a.n.agJ);
    localArrayList.add(com.google.gson.internal.a.n.agL);
    localArrayList.add(com.google.gson.internal.a.n.agP);
    localArrayList.add(com.google.gson.internal.a.n.agU);
    localArrayList.add(com.google.gson.internal.a.n.agN);
    localArrayList.add(com.google.gson.internal.a.n.agl);
    localArrayList.add(com.google.gson.internal.a.e.afz);
    localArrayList.add(com.google.gson.internal.a.n.agS);
    localArrayList.add(com.google.gson.internal.a.l.afz);
    localArrayList.add(k.afz);
    localArrayList.add(com.google.gson.internal.a.n.agQ);
    localArrayList.add(new com.google.gson.internal.a.h(paramMap, paramBoolean2));
    localArrayList.add(com.google.gson.internal.a.a.afz);
    localArrayList.add(com.google.gson.internal.a.n.agX);
    localArrayList.add(com.google.gson.internal.a.n.agj);
    localArrayList.add(paramc1);
    this.aeC = Collections.unmodifiableList(localArrayList);
  }
  
  private m<Number> a(LongSerializationPolicy paramLongSerializationPolicy)
  {
    if (paramLongSerializationPolicy == LongSerializationPolicy.aeR) {
      return com.google.gson.internal.a.n.agv;
    }
    new m()
    {
      public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousb.zX();
          return;
        }
        paramAnonymousb.cM(paramAnonymousNumber.toString());
      }
      
      public Number d(com.google.gson.stream.a paramAnonymousa)
      {
        if (paramAnonymousa.zN() == JsonToken.ahQ)
        {
          paramAnonymousa.nextNull();
          return null;
        }
        return Long.valueOf(paramAnonymousa.nextLong());
      }
    };
  }
  
  private static void a(Object paramObject, com.google.gson.stream.a parama)
  {
    if (paramObject != null) {
      try
      {
        if (parama.zN() != JsonToken.ahR) {
          throw new JsonIOException("JSON document was not fully consumed.");
        }
      }
      catch (MalformedJsonException paramObject)
      {
        throw new JsonSyntaxException((Throwable)paramObject);
      }
      catch (IOException paramObject)
      {
        throw new JsonIOException((Throwable)paramObject);
      }
    }
  }
  
  private m<Number> ax(boolean paramBoolean)
  {
    if (paramBoolean) {
      return com.google.gson.internal.a.n.agx;
    }
    new m()
    {
      public Double a(com.google.gson.stream.a paramAnonymousa)
      {
        if (paramAnonymousa.zN() == JsonToken.ahQ)
        {
          paramAnonymousa.nextNull();
          return null;
        }
        return Double.valueOf(paramAnonymousa.nextDouble());
      }
      
      public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousb.zX();
          return;
        }
        double d = paramAnonymousNumber.doubleValue();
        d.a(d.this, d);
        paramAnonymousb.a(paramAnonymousNumber);
      }
    };
  }
  
  private m<Number> ay(boolean paramBoolean)
  {
    if (paramBoolean) {
      return com.google.gson.internal.a.n.agw;
    }
    new m()
    {
      public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousb.zX();
          return;
        }
        float f = paramAnonymousNumber.floatValue();
        d.a(d.this, f);
        paramAnonymousb.a(paramAnonymousNumber);
      }
      
      public Float c(com.google.gson.stream.a paramAnonymousa)
      {
        if (paramAnonymousa.zN() == JsonToken.ahQ)
        {
          paramAnonymousa.nextNull();
          return null;
        }
        return Float.valueOf((float)paramAnonymousa.nextDouble());
      }
    };
  }
  
  private com.google.gson.stream.b b(Writer paramWriter)
  {
    if (this.aeG) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new com.google.gson.stream.b(paramWriter);
    if (this.aeH) {
      paramWriter.setIndent("  ");
    }
    paramWriter.aF(this.aeE);
    return paramWriter;
  }
  
  private void k(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
    }
  }
  
  public <T> m<T> a(com.google.gson.b.a<T> parama)
  {
    Object localObject1 = (m)this.aeB.get(parama);
    if (localObject1 != null) {
      return (m<T>)localObject1;
    }
    localObject1 = (Map)this.aeA.get();
    a locala = (a)((Map)localObject1).get(parama);
    if (locala != null) {
      return locala;
    }
    locala = new a();
    ((Map)localObject1).put(parama, locala);
    try
    {
      Iterator localIterator = this.aeC.iterator();
      while (localIterator.hasNext())
      {
        m localm = ((n)localIterator.next()).a(this, parama);
        if (localm != null)
        {
          locala.a(localm);
          this.aeB.put(parama, localm);
          return localm;
        }
      }
      throw new IllegalArgumentException("GSON cannot handle " + parama);
    }
    finally
    {
      ((Map)localObject1).remove(parama);
    }
  }
  
  /* Error */
  public <T> T a(com.google.gson.stream.a parama, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 434	com/google/gson/stream/a:isLenient	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 437	com/google/gson/stream/a:setLenient	(Z)V
    //   13: aload_1
    //   14: invokevirtual 298	com/google/gson/stream/a:zN	()Lcom/google/gson/stream/JsonToken;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 443	com/google/gson/b/a:p	(Ljava/lang/reflect/Type;)Lcom/google/gson/b/a;
    //   25: invokevirtual 445	com/google/gson/d:a	(Lcom/google/gson/b/a;)Lcom/google/gson/m;
    //   28: aload_1
    //   29: invokevirtual 448	com/google/gson/m:b	(Lcom/google/gson/stream/a;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: invokevirtual 437	com/google/gson/stream/a:setLenient	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: iload_3
    //   43: ifeq +11 -> 54
    //   46: aload_1
    //   47: iload 4
    //   49: invokevirtual 437	com/google/gson/stream/a:setLenient	(Z)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 313	com/google/gson/JsonSyntaxException
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 316	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_2
    //   64: aload_1
    //   65: iload 4
    //   67: invokevirtual 437	com/google/gson/stream/a:setLenient	(Z)V
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: new 313	com/google/gson/JsonSyntaxException
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 316	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   81: athrow
    //   82: astore_2
    //   83: new 313	com/google/gson/JsonSyntaxException
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 316	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	d
    //   0	92	1	parama	com.google.gson.stream.a
    //   0	92	2	paramType	Type
    //   1	42	3	i	int
    //   6	60	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	18	41	java/io/EOFException
    //   20	33	41	java/io/EOFException
    //   13	18	63	finally
    //   20	33	63	finally
    //   54	63	63	finally
    //   73	82	63	finally
    //   83	92	63	finally
    //   13	18	72	java/lang/IllegalStateException
    //   20	33	72	java/lang/IllegalStateException
    //   13	18	82	java/io/IOException
    //   20	33	82	java/io/IOException
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    paramString = a(paramString, paramClass);
    return (T)com.google.gson.internal.g.t(paramClass).cast(paramString);
  }
  
  public <T> T a(String paramString, Type paramType)
  {
    if (paramString == null) {
      return null;
    }
    return (T)b(new StringReader(paramString), paramType);
  }
  
  public String a(h paramh)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramh, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String a(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  public void a(h paramh, com.google.gson.stream.b paramb)
  {
    boolean bool1 = paramb.isLenient();
    paramb.setLenient(true);
    boolean bool2 = paramb.Al();
    paramb.aE(this.aeF);
    boolean bool3 = paramb.Am();
    paramb.aF(this.aeE);
    try
    {
      com.google.gson.internal.h.b(paramh, paramb);
      return;
    }
    catch (IOException paramh)
    {
      throw new JsonIOException(paramh);
    }
    finally
    {
      paramb.setLenient(bool1);
      paramb.aE(bool2);
      paramb.aF(bool3);
    }
  }
  
  public void a(h paramh, Appendable paramAppendable)
  {
    try
    {
      a(paramh, b(com.google.gson.internal.h.a(paramAppendable)));
      return;
    }
    catch (IOException paramh)
    {
      throw new RuntimeException(paramh);
    }
  }
  
  public void a(Object paramObject, Type paramType, com.google.gson.stream.b paramb)
  {
    paramType = a(com.google.gson.b.a.p(paramType));
    boolean bool1 = paramb.isLenient();
    paramb.setLenient(true);
    boolean bool2 = paramb.Al();
    paramb.aE(this.aeF);
    boolean bool3 = paramb.Am();
    paramb.aF(this.aeE);
    try
    {
      paramType.a(paramb, paramObject);
      return;
    }
    catch (IOException paramObject)
    {
      throw new JsonIOException((Throwable)paramObject);
    }
    finally
    {
      paramb.setLenient(bool1);
      paramb.aE(bool2);
      paramb.aF(bool3);
    }
  }
  
  public void a(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      a(paramObject, paramType, b(com.google.gson.internal.h.a(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new JsonIOException((Throwable)paramObject);
    }
  }
  
  public String al(Object paramObject)
  {
    if (paramObject == null) {
      return a(i.aeN);
    }
    return a(paramObject, paramObject.getClass());
  }
  
  public <T> T b(Reader paramReader, Type paramType)
  {
    paramReader = new com.google.gson.stream.a(paramReader);
    paramType = a(paramReader, paramType);
    a(paramType, paramReader);
    return paramType;
  }
  
  public <T> m<T> n(Class<T> paramClass)
  {
    return a(com.google.gson.b.a.v(paramClass));
  }
  
  public String toString()
  {
    return "{" + "serializeNulls:" + this.aeE + "factories:" + this.aeC + ",instanceCreators:" + this.aeD + "}";
  }
  
  static class a<T>
    extends m<T>
  {
    private m<T> aeL;
    
    public void a(m<T> paramm)
    {
      if (this.aeL != null) {
        throw new AssertionError();
      }
      this.aeL = paramm;
    }
    
    public void a(com.google.gson.stream.b paramb, T paramT)
    {
      if (this.aeL == null) {
        throw new IllegalStateException();
      }
      this.aeL.a(paramb, paramT);
    }
    
    public T b(com.google.gson.stream.a parama)
    {
      if (this.aeL == null) {
        throw new IllegalStateException();
      }
      return (T)this.aeL.b(parama);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */