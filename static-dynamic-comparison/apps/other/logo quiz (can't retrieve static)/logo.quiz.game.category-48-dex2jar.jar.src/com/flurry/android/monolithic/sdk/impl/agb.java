package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class agb
  extends pi
{
  protected pc d;
  protected agc e;
  protected int f;
  protected pk g;
  protected boolean h;
  protected transient afq i;
  protected ot j = null;
  
  public agb(agc paramagc, pc parampc)
  {
    super(0);
    this.e = paramagc;
    this.f = -1;
    this.d = parampc;
    this.g = pk.a(-1, -1);
  }
  
  protected final Object A()
  {
    return this.e.b(this.f);
  }
  
  protected final void B()
    throws ov
  {
    if ((this.b == null) || (!this.b.c())) {
      throw a("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
    }
  }
  
  protected void H()
    throws ov
  {
    U();
  }
  
  public pc a()
  {
    return this.d;
  }
  
  public void a(ot paramot)
  {
    this.j = paramot;
  }
  
  public byte[] a(on paramon)
    throws IOException, ov
  {
    if (this.b == pb.g)
    {
      localObject = A();
      if ((localObject instanceof byte[])) {
        return (byte[])localObject;
      }
    }
    if (this.b != pb.h) {
      throw a("Current token (" + this.b + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
    }
    String str = k();
    if (str == null) {
      return null;
    }
    Object localObject = this.i;
    if (localObject == null)
    {
      localObject = new afq(100);
      this.i = ((afq)localObject);
    }
    for (;;)
    {
      a(str, (afq)localObject, paramon);
      return ((afq)localObject).b();
      this.i.a();
    }
  }
  
  public pb b()
    throws IOException, ov
  {
    if ((this.h) || (this.e == null)) {}
    do
    {
      return null;
      int k = this.f + 1;
      this.f = k;
      if (k < 16) {
        break;
      }
      this.f = 0;
      this.e = this.e.a();
    } while (this.e == null);
    this.b = this.e.a(this.f);
    Object localObject;
    if (this.b == pb.f)
    {
      localObject = A();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        this.g.a((String)localObject);
      }
    }
    for (;;)
    {
      return this.b;
      localObject = localObject.toString();
      break;
      if (this.b == pb.b)
      {
        this.g = this.g.c(-1, -1);
      }
      else if (this.b == pb.d)
      {
        this.g = this.g.b(-1, -1);
      }
      else if ((this.b == pb.c) || (this.b == pb.e))
      {
        this.g = this.g.i();
        if (this.g == null) {
          this.g = pk.a(-1, -1);
        }
      }
    }
  }
  
  public void close()
    throws IOException
  {
    if (!this.h) {
      this.h = true;
    }
  }
  
  public String g()
  {
    return this.g.h();
  }
  
  public ot h()
  {
    return i();
  }
  
  public ot i()
  {
    if (this.j == null) {
      return ot.a;
    }
    return this.j;
  }
  
  public String k()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.b == pb.h) || (this.b == pb.f))
    {
      localObject1 = A();
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    Object localObject3;
    do
    {
      do
      {
        return (String)localObject1;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = localObject1.toString()) {
          return (String)localObject1;
        }
        localObject1 = localObject2;
      } while (this.b == null);
      switch (aga.a[this.b.ordinal()])
      {
      default: 
        return this.b.a();
      }
      localObject3 = A();
      localObject1 = localObject2;
    } while (localObject3 == null);
    return localObject3.toString();
  }
  
  public char[] l()
  {
    String str = k();
    if (str == null) {
      return null;
    }
    return str.toCharArray();
  }
  
  public int m()
  {
    String str = k();
    if (str == null) {
      return 0;
    }
    return str.length();
  }
  
  public int n()
  {
    return 0;
  }
  
  public boolean o()
  {
    return false;
  }
  
  public final Number p()
    throws IOException, ov
  {
    B();
    return (Number)A();
  }
  
  public oy q()
    throws IOException, ov
  {
    Number localNumber = p();
    if ((localNumber instanceof Integer)) {
      return oy.a;
    }
    if ((localNumber instanceof Long)) {
      return oy.b;
    }
    if ((localNumber instanceof Double)) {
      return oy.e;
    }
    if ((localNumber instanceof BigDecimal)) {
      return oy.f;
    }
    if ((localNumber instanceof Float)) {
      return oy.d;
    }
    if ((localNumber instanceof BigInteger)) {
      return oy.c;
    }
    return null;
  }
  
  public int t()
    throws IOException, ov
  {
    if (this.b == pb.i) {
      return ((Number)A()).intValue();
    }
    return p().intValue();
  }
  
  public long u()
    throws IOException, ov
  {
    return p().longValue();
  }
  
  public BigInteger v()
    throws IOException, ov
  {
    Number localNumber = p();
    if ((localNumber instanceof BigInteger)) {
      return (BigInteger)localNumber;
    }
    switch (aga.b[q().ordinal()])
    {
    default: 
      return BigInteger.valueOf(localNumber.longValue());
    }
    return ((BigDecimal)localNumber).toBigInteger();
  }
  
  public float w()
    throws IOException, ov
  {
    return p().floatValue();
  }
  
  public double x()
    throws IOException, ov
  {
    return p().doubleValue();
  }
  
  public BigDecimal y()
    throws IOException, ov
  {
    Number localNumber = p();
    if ((localNumber instanceof BigDecimal)) {
      return (BigDecimal)localNumber;
    }
    switch (aga.b[q().ordinal()])
    {
    case 3: 
    case 4: 
    default: 
      return BigDecimal.valueOf(localNumber.doubleValue());
    case 1: 
    case 5: 
      return BigDecimal.valueOf(localNumber.longValue());
    }
    return new BigDecimal((BigInteger)localNumber);
  }
  
  public Object z()
  {
    if (this.b == pb.g) {
      return A();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/agb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */