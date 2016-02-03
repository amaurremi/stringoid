package com.flurry.android.monolithic.sdk.impl;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class rk
  extends pc
{
  protected static final qf<? extends qb> a = xr.i;
  protected static final py b = new xx();
  protected static final ye<?> c = yf.a();
  private static final afm n = adh.d(ou.class);
  protected final op d;
  protected yh e;
  protected adk f;
  protected qt g;
  protected rq h;
  protected ru i;
  protected rs j;
  protected qk k;
  protected qq l;
  protected final ConcurrentHashMap<afm, qu<Object>> m = new ConcurrentHashMap(64, 0.6F, 2);
  
  public rk()
  {
    this(null, null, null);
  }
  
  public rk(op paramop)
  {
    this(paramop, null, null);
  }
  
  public rk(op paramop, ru paramru, qq paramqq)
  {
    this(paramop, paramru, paramqq, null, null);
  }
  
  public rk(op paramop, ru paramru, qq paramqq, rq paramrq, qk paramqk)
  {
    if (paramop == null)
    {
      this.d = new rj(this);
      this.f = adk.a();
      if (paramrq == null) {
        break label135;
      }
      label48:
      this.h = paramrq;
      if (paramqk == null) {
        break label163;
      }
    }
    for (;;)
    {
      this.k = paramqk;
      paramop = paramru;
      if (paramru == null) {
        paramop = new zw();
      }
      this.i = paramop;
      paramop = paramqq;
      if (paramqq == null) {
        paramop = new te();
      }
      this.l = paramop;
      this.j = zi.e;
      return;
      this.d = paramop;
      if (paramop.a() != null) {
        break;
      }
      this.d.a(this);
      break;
      label135:
      paramrq = new rq(a, b, c, null, null, this.f, null);
      break label48;
      label163:
      paramqk = new qk(a, b, c, null, null, this.f, null);
    }
  }
  
  /* Error */
  private final void a(or paramor, Object paramObject, rq paramrq)
    throws IOException, oq, qw
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 144	java/io/Closeable
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 107	com/flurry/android/monolithic/sdk/impl/rk:i	Lcom/flurry/android/monolithic/sdk/impl/ru;
    //   10: aload_3
    //   11: aload_1
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 119	com/flurry/android/monolithic/sdk/impl/rk:j	Lcom/flurry/android/monolithic/sdk/impl/rs;
    //   17: invokevirtual 149	com/flurry/android/monolithic/sdk/impl/ru:a	(Lcom/flurry/android/monolithic/sdk/impl/rq;Lcom/flurry/android/monolithic/sdk/impl/or;Ljava/lang/Object;Lcom/flurry/android/monolithic/sdk/impl/rs;)V
    //   20: aload_3
    //   21: getstatic 155	com/flurry/android/monolithic/sdk/impl/rr:p	Lcom/flurry/android/monolithic/sdk/impl/rr;
    //   24: invokevirtual 158	com/flurry/android/monolithic/sdk/impl/rq:a	(Lcom/flurry/android/monolithic/sdk/impl/rr;)Z
    //   27: ifeq +7 -> 34
    //   30: aload_1
    //   31: invokevirtual 162	com/flurry/android/monolithic/sdk/impl/or:g	()V
    //   34: aconst_null
    //   35: astore_2
    //   36: aload 4
    //   38: invokeinterface 165 1 0
    //   43: iconst_0
    //   44: ifeq +11 -> 55
    //   47: new 167	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 168	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: return
    //   56: astore_1
    //   57: aload 4
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +9 -> 70
    //   64: aload_2
    //   65: invokeinterface 165 1 0
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: return
    //   74: astore_2
    //   75: goto -5 -> 70
    //   78: astore_1
    //   79: goto -19 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	rk
    //   0	82	1	paramor	or
    //   0	82	2	paramObject	Object
    //   0	82	3	paramrq	rq
    //   4	54	4	localCloseable	Closeable
    // Exception table:
    //   from	to	target	type
    //   6	34	56	finally
    //   47	55	72	java/io/IOException
    //   64	70	74	java/io/IOException
    //   36	43	78	finally
  }
  
  public ou a(ow paramow)
    throws IOException, oz
  {
    Object localObject = b();
    if ((paramow.e() == null) && (paramow.b() == null)) {
      paramow = null;
    }
    do
    {
      return paramow;
      localObject = (ou)a((qk)localObject, paramow, n);
      paramow = (ow)localObject;
    } while (localObject != null);
    return c().a();
  }
  
  protected qm a(ow paramow, qk paramqk)
  {
    return new td(paramqk, paramow, this.l, this.g);
  }
  
  protected qu<Object> a(qk paramqk, afm paramafm)
    throws qw
  {
    qu localqu = (qu)this.m.get(paramafm);
    if (localqu != null) {
      return localqu;
    }
    paramqk = this.l.b(paramqk, paramafm, null);
    if (paramqk == null) {
      throw new qw("Can not find a deserializer for type " + paramafm);
    }
    this.m.put(paramafm, paramqk);
    return paramqk;
  }
  
  public rq a()
  {
    return this.h.a(this.e);
  }
  
  protected Object a(ow paramow, afm paramafm, qm paramqm, qu<Object> paramqu)
    throws IOException, ov, qw
  {
    pw localpw = this.l.a(paramqm.a(), paramafm);
    if (paramow.e() != pb.b) {
      throw qw.a(paramow, "Current token not START_OBJECT (needed to unwrap root name '" + localpw + "'), but " + paramow.e());
    }
    if (paramow.b() != pb.f) {
      throw qw.a(paramow, "Current token not FIELD_NAME (to contain expected root name '" + localpw + "'), but " + paramow.e());
    }
    String str = paramow.g();
    if (!localpw.a().equals(str)) {
      throw qw.a(paramow, "Root name '" + str + "' does not match expected ('" + localpw + "') for type " + paramafm);
    }
    paramow.b();
    paramafm = paramqu.a(paramow, paramqm);
    if (paramow.b() != pb.c) {
      throw qw.a(paramow, "Current token not END_OBJECT (to match wrapper object with root name '" + localpw + "'), but " + paramow.e());
    }
    return paramafm;
  }
  
  protected Object a(qk paramqk, ow paramow, afm paramafm)
    throws IOException, ov, qw
  {
    Object localObject = b(paramow);
    if (localObject == pb.m) {
      paramqk = a(paramqk, paramafm).b();
    }
    for (;;)
    {
      paramow.f();
      return paramqk;
      if ((localObject == pb.e) || (localObject == pb.c))
      {
        paramqk = null;
      }
      else
      {
        localObject = a(paramow, paramqk);
        qu localqu = a(paramqk, paramafm);
        if (paramqk.a(ql.p)) {
          paramqk = a(paramow, paramafm, (qm)localObject, localqu);
        } else {
          paramqk = localqu.a(paramow, (qm)localObject);
        }
      }
    }
  }
  
  public void a(or paramor, ou paramou)
    throws IOException, oz
  {
    rq localrq = a();
    this.i.a(localrq, paramor, paramou, this.j);
    if (localrq.a(rr.p)) {
      paramor.g();
    }
  }
  
  public void a(or paramor, Object paramObject)
    throws IOException, oq, qw
  {
    rq localrq = a();
    if ((localrq.a(rr.o)) && ((paramObject instanceof Closeable))) {
      a(paramor, paramObject, localrq);
    }
    do
    {
      return;
      this.i.a(localrq, paramor, paramObject, this.j);
    } while (!localrq.a(rr.p));
    paramor.g();
  }
  
  protected pb b(ow paramow)
    throws IOException, ov, qw
  {
    pb localpb = paramow.e();
    Object localObject = localpb;
    if (localpb == null)
    {
      paramow = paramow.b();
      localObject = paramow;
      if (paramow == null) {
        throw new EOFException("No content to map to Object due to end of input");
      }
    }
    return (pb)localObject;
  }
  
  public qk b()
  {
    return this.k.a(this.e).a(this.h.i);
  }
  
  public aez c()
  {
    return this.k.h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/rk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */