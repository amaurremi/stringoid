package com.millennialmedia.a.a;

import com.millennialmedia.a.a.b.a.y;
import com.millennialmedia.a.a.b.ah;
import com.millennialmedia.a.a.b.ai;
import com.millennialmedia.a.a.b.f;
import com.millennialmedia.a.a.d.d;

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

public final class j {
    final s a = new k(this);
    final z b = new l(this);
    private final ThreadLocal<Map<com.millennialmedia.a.a.c.a<?>, p<?>>> c = new ThreadLocal();
    private final Map<com.millennialmedia.a.a.c.a<?>, ae<?>> d = Collections.synchronizedMap(new HashMap());
    private final List<af> e;
    private final f f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public j() {
        this(com.millennialmedia.a.a.b.s.a, c.a, Collections.emptyMap(), false, false, false, true, false, false, ab.a, Collections.emptyList());
    }

    j(com.millennialmedia.a.a.b.s params, i parami, Map<Type, q<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ab paramab, List<af> paramList) {
        this.f = new f(paramMap);
        this.g = paramBoolean1;
        this.i = paramBoolean3;
        this.h = paramBoolean4;
        this.j = paramBoolean5;
        paramMap = new ArrayList();
        paramMap.add(y.Q);
        paramMap.add(com.millennialmedia.a.a.b.a.m.a);
        paramMap.add(params);
        paramMap.addAll(paramList);
        paramMap.add(y.x);
        paramMap.add(y.m);
        paramMap.add(y.g);
        paramMap.add(y.i);
        paramMap.add(y.k);
        paramMap.add(y.a(Long.TYPE, Long.class, a(paramab)));
        paramMap.add(y.a(Double.TYPE, Double.class, a(paramBoolean6)));
        paramMap.add(y.a(Float.TYPE, Float.class, b(paramBoolean6)));
        paramMap.add(y.r);
        paramMap.add(y.t);
        paramMap.add(y.z);
        paramMap.add(y.B);
        paramMap.add(y.a(BigDecimal.class, y.v));
        paramMap.add(y.a(BigInteger.class, y.w));
        paramMap.add(y.D);
        paramMap.add(y.F);
        paramMap.add(y.J);
        paramMap.add(y.O);
        paramMap.add(y.H);
        paramMap.add(y.d);
        paramMap.add(com.millennialmedia.a.a.b.a.e.a);
        paramMap.add(y.M);
        paramMap.add(com.millennialmedia.a.a.b.a.v.a);
        paramMap.add(com.millennialmedia.a.a.b.a.t.a);
        paramMap.add(y.K);
        paramMap.add(com.millennialmedia.a.a.b.a.a.a);
        paramMap.add(y.R);
        paramMap.add(y.b);
        paramMap.add(new com.millennialmedia.a.a.b.a.c(this.f));
        paramMap.add(new com.millennialmedia.a.a.b.a.k(this.f, paramBoolean2));
        paramMap.add(new com.millennialmedia.a.a.b.a.p(this.f, parami, params));
        this.e = Collections.unmodifiableList(paramMap);
    }

    private ae<Number> a(ab paramab) {
        if (paramab == ab.a) {
            return y.n;
        }
        return new o(this);
    }

    private ae<Number> a(boolean paramBoolean) {
        if (paramBoolean) {
            return y.p;
        }
        return new m(this);
    }

    private d a(Writer paramWriter) {
        if (this.i) {
            paramWriter.write(")]}'\n");
        }
        paramWriter = new d(paramWriter);
        if (this.j) {
            paramWriter.c("  ");
        }
        paramWriter.d(this.g);
        return paramWriter;
    }

    private void a(double paramDouble) {
        if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
            throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object paramObject, com.millennialmedia.a.a.d.a parama) {
        if (paramObject != null) {
            try {
                if (parama.f() != com.millennialmedia.a.a.d.c.j) {
                    throw new u("JSON document was not fully consumed.");
                }
            } catch (com.millennialmedia.a.a.d.e paramObject) {
                throw new aa((Throwable) paramObject);
            } catch (IOException paramObject) {
                throw new u((Throwable) paramObject);
            }
        }
    }

    private ae<Number> b(boolean paramBoolean) {
        if (paramBoolean) {
            return y.o;
        }
        return new n(this);
    }

    public <T> ae<T> a(af paramaf, com.millennialmedia.a.a.c.a<T> parama) {
        Iterator localIterator = this.e.iterator();
        int k = 0;
        while (localIterator.hasNext()) {
            Object localObject = (af) localIterator.next();
            if (k == 0) {
                if (localObject == paramaf) {
                    k = 1;
                }
            } else {
                localObject = ((af) localObject).a(this, parama);
                if (localObject != null) {
                    return (ae<T>) localObject;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + parama);
    }

    public <T> ae<T> a(com.millennialmedia.a.a.c.a<T> parama) {
        Object localObject1 = (ae) this.d.get(parama);
        if (localObject1 != null) {
            return (ae<T>) localObject1;
        }
        Object localObject3 = (Map) this.c.get();
        int k = 0;
        if (localObject3 == null) {
            localObject3 = new HashMap();
            this.c.set(localObject3);
            k = 1;
        }
        for (; ; ) {
            Object localObject4 = (p) ((Map) localObject3).get(parama);
            localObject1 = localObject4;
            if (localObject4 != null) {
                break;
            }
            try {
                localObject1 = new p();
                ((Map) localObject3).put(parama, localObject1);
                Iterator localIterator = this.e.iterator();
                for (; ; ) {
                    if (localIterator.hasNext()) {
                        localObject4 = ((af) localIterator.next()).a(this, parama);
                        if (localObject4 != null) {
                            ((p) localObject1).a((ae) localObject4);
                            this.d.put(parama, localObject4);
                            ((Map) localObject3).remove(parama);
                            localObject1 = localObject4;
                            if (k == 0) {
                                break;
                            }
                            this.c.remove();
                            return (ae<T>) localObject4;
                        }
                    }
                }
                throw new IllegalArgumentException("GSON cannot handle " + parama);
            } finally {
                ((Map) localObject3).remove(parama);
                if (k != 0) {
                    this.c.remove();
                }
            }
        }
    }

    public <T> ae<T> a(Class<T> paramClass) {
        return a(com.millennialmedia.a.a.c.a.b(paramClass));
    }

    /* Error */
    public <T> T a(com.millennialmedia.a.a.d.a parama, Type paramType) {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: aload_1
        //   3: invokevirtual 421	com/millennialmedia/a/a/d/a:p	()Z
        //   6: istore 4
        //   8: aload_1
        //   9: iconst_1
        //   10: invokevirtual 423	com/millennialmedia/a/a/d/a:a	(Z)V
        //   13: aload_1
        //   14: invokevirtual 324	com/millennialmedia/a/a/d/a:f	()Lcom/millennialmedia/a/a/d/c;
        //   17: pop
        //   18: iconst_0
        //   19: istore_3
        //   20: aload_0
        //   21: aload_2
        //   22: invokestatic 426	com/millennialmedia/a/a/c/a:a	(Ljava/lang/reflect/Type;)Lcom/millennialmedia/a/a/c/a;
        //   25: invokevirtual 413	com/millennialmedia/a/a/j:a	(Lcom/millennialmedia/a/a/c/a;)Lcom/millennialmedia/a/a/ae;
        //   28: aload_1
        //   29: invokevirtual 429	com/millennialmedia/a/a/ae:b	(Lcom/millennialmedia/a/a/d/a;)Ljava/lang/Object;
        //   32: astore_2
        //   33: aload_1
        //   34: iload 4
        //   36: invokevirtual 423	com/millennialmedia/a/a/d/a:a	(Z)V
        //   39: aload_2
        //   40: areturn
        //   41: astore_2
        //   42: iload_3
        //   43: ifeq +8 -> 51
        //   46: aconst_null
        //   47: astore_2
        //   48: goto -15 -> 33
        //   51: new 336	com/millennialmedia/a/a/aa
        //   54: dup
        //   55: aload_2
        //   56: invokespecial 339	com/millennialmedia/a/a/aa:<init>	(Ljava/lang/Throwable;)V
        //   59: athrow
        //   60: astore_2
        //   61: aload_1
        //   62: iload 4
        //   64: invokevirtual 423	com/millennialmedia/a/a/d/a:a	(Z)V
        //   67: aload_2
        //   68: athrow
        //   69: astore_2
        //   70: new 336	com/millennialmedia/a/a/aa
        //   73: dup
        //   74: aload_2
        //   75: invokespecial 339	com/millennialmedia/a/a/aa:<init>	(Ljava/lang/Throwable;)V
        //   78: athrow
        //   79: astore_2
        //   80: new 336	com/millennialmedia/a/a/aa
        //   83: dup
        //   84: aload_2
        //   85: invokespecial 339	com/millennialmedia/a/a/aa:<init>	(Ljava/lang/Throwable;)V
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	j
        //   0	89	1	parama	com.millennialmedia.a.a.d.a
        //   0	89	2	paramType	Type
        //   1	42	3	k	int
        //   6	57	4	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   13	18	41	java/io/EOFException
        //   20	33	41	java/io/EOFException
        //   13	18	60	finally
        //   20	33	60	finally
        //   51	60	60	finally
        //   70	79	60	finally
        //   80	89	60	finally
        //   13	18	69	java/lang/IllegalStateException
        //   20	33	69	java/lang/IllegalStateException
        //   13	18	79	java/io/IOException
        //   20	33	79	java/io/IOException
    }

    public <T> T a(Reader paramReader, Type paramType) {
        paramReader = new com.millennialmedia.a.a.d.a(paramReader);
        paramType = a(paramReader, paramType);
        a(paramType, paramReader);
        return paramType;
    }

    public <T> T a(String paramString, Class<T> paramClass) {
        paramString = a(paramString, paramClass);
        return (T) ah.a(paramClass).cast(paramString);
    }

    public <T> T a(String paramString, Type paramType) {
        if (paramString == null) {
            return null;
        }
        return (T) a(new StringReader(paramString), paramType);
    }

    public String a(t paramt) {
        StringWriter localStringWriter = new StringWriter();
        a(paramt, localStringWriter);
        return localStringWriter.toString();
    }

    public String a(Object paramObject) {
        if (paramObject == null) {
            return a(v.a);
        }
        return a(paramObject, paramObject.getClass());
    }

    public String a(Object paramObject, Type paramType) {
        StringWriter localStringWriter = new StringWriter();
        a(paramObject, paramType, localStringWriter);
        return localStringWriter.toString();
    }

    public void a(t paramt, d paramd) {
        boolean bool1 = paramd.g();
        paramd.b(true);
        boolean bool2 = paramd.h();
        paramd.c(this.h);
        boolean bool3 = paramd.i();
        paramd.d(this.g);
        try {
            ai.a(paramt, paramd);
            return;
        } catch (IOException paramt) {
            throw new u(paramt);
        } finally {
            paramd.b(bool1);
            paramd.c(bool2);
            paramd.d(bool3);
        }
    }

    public void a(t paramt, Appendable paramAppendable) {
        try {
            a(paramt, a(ai.a(paramAppendable)));
            return;
        } catch (IOException paramt) {
            throw new RuntimeException(paramt);
        }
    }

    public void a(Object paramObject, Type paramType, d paramd) {
        paramType = a(com.millennialmedia.a.a.c.a.a(paramType));
        boolean bool1 = paramd.g();
        paramd.b(true);
        boolean bool2 = paramd.h();
        paramd.c(this.h);
        boolean bool3 = paramd.i();
        paramd.d(this.g);
        try {
            paramType.a(paramd, paramObject);
            return;
        } catch (IOException paramObject) {
            throw new u((Throwable) paramObject);
        } finally {
            paramd.b(bool1);
            paramd.c(bool2);
            paramd.d(bool3);
        }
    }

    public void a(Object paramObject, Type paramType, Appendable paramAppendable) {
        try {
            a(paramObject, paramType, a(ai.a(paramAppendable)));
            return;
        } catch (IOException paramObject) {
            throw new u((Throwable) paramObject);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */