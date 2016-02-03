package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class CodedOutputStream
{
  private final int ahp;
  private int ajx = 0;
  private final OutputStream ajy;
  private final byte[] buffer;
  private int position;
  
  private CodedOutputStream(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.ajy = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.ahp = paramArrayOfByte.length;
  }
  
  private CodedOutputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.ajy = null;
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.ahp = (paramInt1 + paramInt2);
  }
  
  public static int A(int paramInt1, int paramInt2)
  {
    return fm(paramInt1) + fi(paramInt2);
  }
  
  private void Br()
  {
    if (this.ajy == null) {
      throw new OutOfSpaceException();
    }
    this.ajy.write(this.buffer, 0, this.position);
    this.position = 0;
  }
  
  public static int K(long paramLong)
  {
    return Q(paramLong);
  }
  
  public static int L(long paramLong)
  {
    return Q(paramLong);
  }
  
  public static int M(long paramLong)
  {
    return 8;
  }
  
  public static int N(long paramLong)
  {
    return 8;
  }
  
  public static int O(long paramLong)
  {
    return Q(S(paramLong));
  }
  
  public static int Q(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static long S(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int a(j paramj)
  {
    int i = paramj.fI();
    return i + fo(i);
  }
  
  public static CodedOutputStream a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }
  
  public static CodedOutputStream a(OutputStream paramOutputStream, int paramInt)
  {
    return new CodedOutputStream(paramOutputStream, new byte[paramInt]);
  }
  
  public static int aJ(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int b(int paramInt, float paramFloat)
  {
    return fm(paramInt) + u(paramFloat);
  }
  
  public static int b(int paramInt, e parame)
  {
    return fm(paramInt) + c(parame);
  }
  
  public static int c(e parame)
  {
    return fo(parame.size()) + parame.size();
  }
  
  public static int cW(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = fo(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.", paramString);
    }
  }
  
  public static int d(int paramInt, n paramn)
  {
    return fm(paramInt) + f(paramn);
  }
  
  public static int e(int paramInt, boolean paramBoolean)
  {
    return fm(paramInt) + aJ(paramBoolean);
  }
  
  public static int e(n paramn)
  {
    return paramn.fI();
  }
  
  public static int f(n paramn)
  {
    int i = paramn.fI();
    return i + fo(i);
  }
  
  public static int ff(int paramInt)
  {
    if (paramInt >= 0) {
      return fo(paramInt);
    }
    return 10;
  }
  
  public static int fg(int paramInt)
  {
    return 4;
  }
  
  public static int fh(int paramInt)
  {
    return fo(paramInt);
  }
  
  public static int fi(int paramInt)
  {
    return ff(paramInt);
  }
  
  public static int fj(int paramInt)
  {
    return 4;
  }
  
  public static int fk(int paramInt)
  {
    return fo(fq(paramInt));
  }
  
  public static int fm(int paramInt)
  {
    return fo(WireFormat.D(paramInt, 0));
  }
  
  public static int fo(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int fq(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int g(int paramInt, long paramLong)
  {
    return fm(paramInt) + L(paramLong);
  }
  
  public static CodedOutputStream g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedOutputStream(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static CodedOutputStream m(byte[] paramArrayOfByte)
  {
    return g(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int n(double paramDouble)
  {
    return 8;
  }
  
  public static int o(byte[] paramArrayOfByte)
  {
    return fo(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int u(float paramFloat)
  {
    return 4;
  }
  
  public static int z(int paramInt1, int paramInt2)
  {
    return fm(paramInt1) + ff(paramInt2);
  }
  
  public void B(int paramInt1, int paramInt2)
  {
    fn(WireFormat.D(paramInt1, paramInt2));
  }
  
  public int Bs()
  {
    if (this.ajy == null) {
      return this.ahp - this.position;
    }
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }
  
  public void Bt()
  {
    if (Bs() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void F(long paramLong)
  {
    P(paramLong);
  }
  
  public void G(long paramLong)
  {
    P(paramLong);
  }
  
  public void H(long paramLong)
  {
    R(paramLong);
  }
  
  public void I(long paramLong)
  {
    R(paramLong);
  }
  
  public void J(long paramLong)
  {
    P(S(paramLong));
  }
  
  public void P(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        fl((int)paramLong);
        return;
      }
      fl((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void R(long paramLong)
  {
    fl((int)paramLong & 0xFF);
    fl((int)(paramLong >> 8) & 0xFF);
    fl((int)(paramLong >> 16) & 0xFF);
    fl((int)(paramLong >> 24) & 0xFF);
    fl((int)(paramLong >> 32) & 0xFF);
    fl((int)(paramLong >> 40) & 0xFF);
    fl((int)(paramLong >> 48) & 0xFF);
    fl((int)(paramLong >> 56) & 0xFF);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    B(paramInt, 5);
    t(paramFloat);
  }
  
  public void a(int paramInt, e parame)
  {
    B(paramInt, 2);
    b(parame);
  }
  
  public void a(int paramInt, n paramn)
  {
    B(paramInt, 3);
    c(paramn);
    B(paramInt, 4);
  }
  
  public void a(e parame, int paramInt1, int paramInt2)
  {
    if (this.ahp - this.position >= paramInt2)
    {
      parame.b(this.buffer, paramInt1, this.position, paramInt2);
      this.position += paramInt2;
      this.ajx += paramInt2;
      return;
    }
    int i = this.ahp - this.position;
    parame.b(this.buffer, paramInt1, this.position, i);
    paramInt1 += i;
    paramInt2 -= i;
    this.position = this.ahp;
    this.ajx = (i + this.ajx);
    Br();
    if (paramInt2 <= this.ahp)
    {
      parame.b(this.buffer, paramInt1, 0, paramInt2);
      this.position = paramInt2;
    }
    for (;;)
    {
      this.ajx += paramInt2;
      return;
      parame.a(this.ajy, paramInt1, paramInt2);
    }
  }
  
  public void aI(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      fl(i);
      return;
    }
  }
  
  public void b(int paramInt, n paramn)
  {
    B(paramInt, 2);
    d(paramn);
  }
  
  public void b(e parame)
  {
    fn(parame.size());
    d(parame);
  }
  
  public void c(int paramInt, n paramn)
  {
    B(1, 3);
    x(2, paramInt);
    b(3, paramn);
    B(1, 4);
  }
  
  public void c(n paramn)
  {
    paramn.a(this);
  }
  
  public void cV(String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    fn(paramString.length);
    p(paramString);
  }
  
  public void d(int paramInt, boolean paramBoolean)
  {
    B(paramInt, 0);
    aI(paramBoolean);
  }
  
  public void d(e parame)
  {
    a(parame, 0, parame.size());
  }
  
  public void d(n paramn)
  {
    fn(paramn.fI());
    paramn.a(this);
  }
  
  public void eZ(int paramInt)
  {
    if (paramInt >= 0)
    {
      fn(paramInt);
      return;
    }
    P(paramInt);
  }
  
  public void f(int paramInt, long paramLong)
  {
    B(paramInt, 0);
    G(paramLong);
  }
  
  public void fa(int paramInt)
  {
    fp(paramInt);
  }
  
  public void fb(int paramInt)
  {
    fn(paramInt);
  }
  
  public void fc(int paramInt)
  {
    eZ(paramInt);
  }
  
  public void fd(int paramInt)
  {
    fp(paramInt);
  }
  
  public void fe(int paramInt)
  {
    fn(fq(paramInt));
  }
  
  public void fl(int paramInt)
  {
    g((byte)paramInt);
  }
  
  public void flush()
  {
    if (this.ajy != null) {
      Br();
    }
  }
  
  public void fn(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        fl(paramInt);
        return;
      }
      fl(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void fp(int paramInt)
  {
    fl(paramInt & 0xFF);
    fl(paramInt >> 8 & 0xFF);
    fl(paramInt >> 16 & 0xFF);
    fl(paramInt >> 24 & 0xFF);
  }
  
  public void g(byte paramByte)
  {
    if (this.position == this.ahp) {
      Br();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
    this.ajx += 1;
  }
  
  public void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.ahp - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      this.ajx += paramInt2;
      return;
    }
    int i = this.ahp - this.position;
    System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, i);
    paramInt1 += i;
    paramInt2 -= i;
    this.position = this.ahp;
    this.ajx = (i + this.ajx);
    Br();
    if (paramInt2 <= this.ahp)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, 0, paramInt2);
      this.position = paramInt2;
    }
    for (;;)
    {
      this.ajx += paramInt2;
      return;
      this.ajy.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void m(double paramDouble)
  {
    R(Double.doubleToRawLongBits(paramDouble));
  }
  
  public void n(byte[] paramArrayOfByte)
  {
    fn(paramArrayOfByte.length);
    p(paramArrayOfByte);
  }
  
  public void p(byte[] paramArrayOfByte)
  {
    h(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void t(float paramFloat)
  {
    fp(Float.floatToRawIntBits(paramFloat));
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    B(paramInt1, 0);
    eZ(paramInt2);
  }
  
  public void x(int paramInt1, int paramInt2)
  {
    B(paramInt1, 0);
    fb(paramInt2);
  }
  
  public void y(int paramInt1, int paramInt2)
  {
    B(paramInt1, 0);
    fc(paramInt2);
  }
  
  public static class OutOfSpaceException
    extends IOException
  {
    private static final long serialVersionUID = -6947486886997889499L;
    
    OutOfSpaceException()
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/CodedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */