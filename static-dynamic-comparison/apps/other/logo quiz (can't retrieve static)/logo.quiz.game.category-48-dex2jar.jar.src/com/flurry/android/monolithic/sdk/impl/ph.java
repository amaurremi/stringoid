package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ph
  extends pi
{
  static final BigDecimal u = new BigDecimal(Long.MIN_VALUE);
  static final BigDecimal v = new BigDecimal(Long.MAX_VALUE);
  static final BigDecimal w = new BigDecimal(Long.MIN_VALUE);
  static final BigDecimal x = new BigDecimal(Long.MAX_VALUE);
  protected long A;
  protected double B;
  protected BigInteger C;
  protected BigDecimal D;
  protected boolean E;
  protected int F;
  protected int G;
  protected int H;
  protected final pq d;
  protected boolean e;
  protected int f = 0;
  protected int g = 0;
  protected long h = 0L;
  protected int i = 1;
  protected int j = 0;
  protected long k = 0L;
  protected int l = 1;
  protected int m = 0;
  protected pk n;
  protected pb o;
  protected final afy p;
  protected char[] q = null;
  protected boolean r = false;
  protected afq s = null;
  protected byte[] t;
  protected int y = 0;
  protected int z;
  
  protected ph(pq parampq, int paramInt)
  {
    this.a = paramInt;
    this.d = parampq;
    this.p = parampq.c();
    this.n = pk.g();
  }
  
  private final void a(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException, ov
  {
    String str = this.p.f();
    try
    {
      if (pt.a(paramArrayOfChar, paramInt2, paramInt3, this.E))
      {
        this.A = Long.parseLong(str);
        this.y = 2;
        return;
      }
      this.C = new BigInteger(str);
      this.y = 4;
      return;
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      a("Malformed numeric value '" + str + "'", paramArrayOfChar);
    }
  }
  
  private final void d(int paramInt)
    throws IOException, ov
  {
    if (paramInt == 16) {}
    try
    {
      this.D = this.p.h();
      this.y = 16;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      a("Malformed numeric value '" + this.p.f() + "'", localNumberFormatException);
    }
    this.B = this.p.i();
    this.y = 8;
    return;
  }
  
  public final long A()
  {
    return this.k;
  }
  
  public final int B()
  {
    return this.l;
  }
  
  public final int C()
  {
    int i1 = this.m;
    if (i1 < 0) {
      return i1;
    }
    return i1 + 1;
  }
  
  protected final void D()
    throws IOException
  {
    if (!E()) {
      S();
    }
  }
  
  protected abstract boolean E()
    throws IOException;
  
  protected abstract void F()
    throws IOException;
  
  protected void G()
    throws IOException
  {
    this.p.a();
    char[] arrayOfChar = this.q;
    if (arrayOfChar != null)
    {
      this.q = null;
      this.d.c(arrayOfChar);
    }
  }
  
  protected void H()
    throws ov
  {
    if (!this.n.b()) {
      c(": expected close marker for " + this.n.d() + " (from " + this.n.a(this.d.a()) + ")");
    }
  }
  
  public afq I()
  {
    if (this.s == null) {
      this.s = new afq();
    }
    for (;;)
    {
      return this.s;
      this.s.a();
    }
  }
  
  protected void J()
    throws IOException, ov
  {
    if ((this.y & 0x2) != 0)
    {
      int i1 = (int)this.A;
      if (i1 != this.A) {
        d("Numeric value (" + k() + ") out of range of int");
      }
      this.z = i1;
    }
    for (;;)
    {
      this.y |= 0x1;
      return;
      if ((this.y & 0x4) != 0)
      {
        this.z = this.C.intValue();
      }
      else if ((this.y & 0x8) != 0)
      {
        if ((this.B < -2.147483648E9D) || (this.B > 2.147483647E9D)) {
          O();
        }
        this.z = ((int)this.B);
      }
      else if ((this.y & 0x10) != 0)
      {
        if ((w.compareTo(this.D) > 0) || (x.compareTo(this.D) < 0)) {
          O();
        }
        this.z = this.D.intValue();
      }
      else
      {
        U();
      }
    }
  }
  
  protected void K()
    throws IOException, ov
  {
    if ((this.y & 0x1) != 0) {
      this.A = this.z;
    }
    for (;;)
    {
      this.y |= 0x2;
      return;
      if ((this.y & 0x4) != 0)
      {
        this.A = this.C.longValue();
      }
      else if ((this.y & 0x8) != 0)
      {
        if ((this.B < -9.223372036854776E18D) || (this.B > 9.223372036854776E18D)) {
          P();
        }
        this.A = (this.B);
      }
      else if ((this.y & 0x10) != 0)
      {
        if ((u.compareTo(this.D) > 0) || (v.compareTo(this.D) < 0)) {
          P();
        }
        this.A = this.D.longValue();
      }
      else
      {
        U();
      }
    }
  }
  
  protected void L()
    throws IOException, ov
  {
    if ((this.y & 0x10) != 0) {
      this.C = this.D.toBigInteger();
    }
    for (;;)
    {
      this.y |= 0x4;
      return;
      if ((this.y & 0x2) != 0) {
        this.C = BigInteger.valueOf(this.A);
      } else if ((this.y & 0x1) != 0) {
        this.C = BigInteger.valueOf(this.z);
      } else if ((this.y & 0x8) != 0) {
        this.C = BigDecimal.valueOf(this.B).toBigInteger();
      } else {
        U();
      }
    }
  }
  
  protected void M()
    throws IOException, ov
  {
    if ((this.y & 0x10) != 0) {
      this.B = this.D.doubleValue();
    }
    for (;;)
    {
      this.y |= 0x8;
      return;
      if ((this.y & 0x4) != 0) {
        this.B = this.C.doubleValue();
      } else if ((this.y & 0x2) != 0) {
        this.B = this.A;
      } else if ((this.y & 0x1) != 0) {
        this.B = this.z;
      } else {
        U();
      }
    }
  }
  
  protected void N()
    throws IOException, ov
  {
    if ((this.y & 0x8) != 0) {
      this.D = new BigDecimal(k());
    }
    for (;;)
    {
      this.y |= 0x10;
      return;
      if ((this.y & 0x4) != 0) {
        this.D = new BigDecimal(this.C);
      } else if ((this.y & 0x2) != 0) {
        this.D = BigDecimal.valueOf(this.A);
      } else if ((this.y & 0x1) != 0) {
        this.D = BigDecimal.valueOf(this.z);
      } else {
        U();
      }
    }
  }
  
  protected void O()
    throws IOException, ov
  {
    d("Numeric value (" + k() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
  }
  
  protected void P()
    throws IOException, ov
  {
    d("Numeric value (" + k() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
  }
  
  protected char Q()
    throws IOException, ov
  {
    throw new UnsupportedOperationException();
  }
  
  protected final int a(on paramon, char paramChar, int paramInt)
    throws IOException, ov
  {
    if (paramChar != '\\') {
      throw a(paramon, paramChar, paramInt);
    }
    char c1 = Q();
    if ((c1 <= ' ') && (paramInt == 0)) {
      paramChar = '￿';
    }
    char c2;
    do
    {
      return paramChar;
      c2 = paramon.b(c1);
      paramChar = c2;
    } while (c2 >= 0);
    throw a(paramon, c1, paramInt);
  }
  
  protected final pb a(String paramString, double paramDouble)
  {
    this.p.a(paramString);
    this.B = paramDouble;
    this.y = 8;
    return pb.j;
  }
  
  protected final pb a(boolean paramBoolean, int paramInt)
  {
    this.E = paramBoolean;
    this.F = paramInt;
    this.G = 0;
    this.H = 0;
    this.y = 0;
    return pb.i;
  }
  
  protected final pb a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 1) && (paramInt3 < 1)) {
      return a(paramBoolean, paramInt1);
    }
    return b(paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  protected IllegalArgumentException a(on paramon, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return a(paramon, paramInt1, paramInt2, null);
  }
  
  protected IllegalArgumentException a(on paramon, int paramInt1, int paramInt2, String paramString)
    throws IllegalArgumentException
  {
    if (paramInt1 <= 32) {
      paramon = "Illegal white space character (code 0x" + Integer.toHexString(paramInt1) + ") as character #" + (paramInt2 + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramon;
      if (paramString != null) {
        localObject = paramon + ": " + paramString;
      }
      return new IllegalArgumentException((String)localObject);
      if (paramon.a(paramInt1)) {
        paramon = "Unexpected padding character ('" + paramon.b() + "') as character #" + (paramInt2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramInt1)) || (Character.isISOControl(paramInt1))) {
        paramon = "Illegal character (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      } else {
        paramon = "Illegal character '" + (char)paramInt1 + "' (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      }
    }
  }
  
  protected void a(int paramInt)
    throws IOException, ov
  {
    if (this.b == pb.i)
    {
      char[] arrayOfChar = this.p.e();
      int i2 = this.p.d();
      int i3 = this.F;
      int i1 = i2;
      if (this.E) {
        i1 = i2 + 1;
      }
      if (i3 <= 9)
      {
        i1 = pt.a(arrayOfChar, i1, i3);
        paramInt = i1;
        if (this.E) {
          paramInt = -i1;
        }
        this.z = paramInt;
        this.y = 1;
        return;
      }
      if (i3 <= 18)
      {
        long l2 = pt.b(arrayOfChar, i1, i3);
        long l1 = l2;
        if (this.E) {
          l1 = -l2;
        }
        if (i3 == 10) {
          if (this.E)
          {
            if (l1 >= -2147483648L)
            {
              this.z = ((int)l1);
              this.y = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            this.z = ((int)l1);
            this.y = 1;
            return;
          }
        }
        this.A = l1;
        this.y = 2;
        return;
      }
      a(paramInt, arrayOfChar, i1, i3);
      return;
    }
    if (this.b == pb.j)
    {
      d(paramInt);
      return;
    }
    d("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
  }
  
  protected void a(int paramInt, char paramChar)
    throws ov
  {
    String str = "" + this.n.a(this.d.a());
    d("Unexpected close marker '" + (char)paramInt + "': expected '" + paramChar + "' (for " + this.n.d() + " starting at " + str + ")");
  }
  
  protected void a(int paramInt, String paramString)
    throws ov
  {
    String str2 = "Unexpected character (" + c(paramInt) + ") in numeric value";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    d(str1);
  }
  
  protected final pb b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.E = paramBoolean;
    this.F = paramInt1;
    this.G = paramInt2;
    this.H = paramInt3;
    this.y = 0;
    return pb.j;
  }
  
  protected void b(String paramString)
    throws ov
  {
    d("Invalid numeric value: " + paramString);
  }
  
  public void close()
    throws IOException
  {
    if (!this.e) {
      this.e = true;
    }
    try
    {
      F();
      return;
    }
    finally
    {
      G();
    }
  }
  
  public String g()
    throws IOException, ov
  {
    if ((this.b == pb.b) || (this.b == pb.d)) {
      return this.n.i().h();
    }
    return this.n.h();
  }
  
  public ot h()
  {
    return new ot(this.d.a(), A(), B(), C());
  }
  
  public ot i()
  {
    int i1 = this.f;
    int i2 = this.j;
    return new ot(this.d.a(), this.h + this.f - 1L, this.i, i1 - i2 + 1);
  }
  
  public boolean o()
  {
    if (this.b == pb.h) {
      return true;
    }
    if (this.b == pb.f) {
      return this.r;
    }
    return false;
  }
  
  public Number p()
    throws IOException, ov
  {
    if (this.y == 0) {
      a(0);
    }
    if (this.b == pb.i)
    {
      if ((this.y & 0x1) != 0) {
        return Integer.valueOf(this.z);
      }
      if ((this.y & 0x2) != 0) {
        return Long.valueOf(this.A);
      }
      if ((this.y & 0x4) != 0) {
        return this.C;
      }
      return this.D;
    }
    if ((this.y & 0x10) != 0) {
      return this.D;
    }
    if ((this.y & 0x8) == 0) {
      U();
    }
    return Double.valueOf(this.B);
  }
  
  public oy q()
    throws IOException, ov
  {
    if (this.y == 0) {
      a(0);
    }
    if (this.b == pb.i)
    {
      if ((this.y & 0x1) != 0) {
        return oy.a;
      }
      if ((this.y & 0x2) != 0) {
        return oy.b;
      }
      return oy.c;
    }
    if ((this.y & 0x10) != 0) {
      return oy.f;
    }
    return oy.e;
  }
  
  public int t()
    throws IOException, ov
  {
    if ((this.y & 0x1) == 0)
    {
      if (this.y == 0) {
        a(1);
      }
      if ((this.y & 0x1) == 0) {
        J();
      }
    }
    return this.z;
  }
  
  public long u()
    throws IOException, ov
  {
    if ((this.y & 0x2) == 0)
    {
      if (this.y == 0) {
        a(2);
      }
      if ((this.y & 0x2) == 0) {
        K();
      }
    }
    return this.A;
  }
  
  public BigInteger v()
    throws IOException, ov
  {
    if ((this.y & 0x4) == 0)
    {
      if (this.y == 0) {
        a(4);
      }
      if ((this.y & 0x4) == 0) {
        L();
      }
    }
    return this.C;
  }
  
  public float w()
    throws IOException, ov
  {
    return (float)x();
  }
  
  public double x()
    throws IOException, ov
  {
    if ((this.y & 0x8) == 0)
    {
      if (this.y == 0) {
        a(8);
      }
      if ((this.y & 0x8) == 0) {
        M();
      }
    }
    return this.B;
  }
  
  public BigDecimal y()
    throws IOException, ov
  {
    if ((this.y & 0x10) == 0)
    {
      if (this.y == 0) {
        a(16);
      }
      if ((this.y & 0x10) == 0) {
        N();
      }
    }
    return this.D;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */