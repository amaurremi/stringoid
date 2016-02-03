package com.badlogic.gdx.math;

import java.io.Serializable;

public class Matrix4
  implements Serializable
{
  static d c = new d();
  static final g d = new g();
  static final g e = new g();
  static final g f = new g();
  static final g g = new g();
  static final Matrix4 h = new Matrix4();
  static final g i = new g();
  static final g j = new g();
  static final g k = new g();
  public final float[] a = new float[16];
  public final float[] b = new float[16];
  
  public Matrix4()
  {
    this.b[0] = 1.0F;
    this.b[5] = 1.0F;
    this.b[10] = 1.0F;
    this.b[15] = 1.0F;
  }
  
  public static native boolean inv(float[] paramArrayOfFloat);
  
  public static native void mul(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public static native void prj(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3);
  
  public Matrix4 a()
  {
    this.b[0] = 1.0F;
    this.b[4] = 0.0F;
    this.b[8] = 0.0F;
    this.b[12] = 0.0F;
    this.b[1] = 0.0F;
    this.b[5] = 1.0F;
    this.b[9] = 0.0F;
    this.b[13] = 0.0F;
    this.b[2] = 0.0F;
    this.b[6] = 0.0F;
    this.b[10] = 1.0F;
    this.b[14] = 0.0F;
    this.b[3] = 0.0F;
    this.b[7] = 0.0F;
    this.b[11] = 0.0F;
    this.b[15] = 1.0F;
    return this;
  }
  
  public Matrix4 a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, 0.0F, 1.0F);
    return this;
  }
  
  public Matrix4 a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a();
    float f1 = 2.0F / (paramFloat2 - paramFloat1);
    float f2 = 2.0F / (paramFloat4 - paramFloat3);
    float f3 = -2.0F / (paramFloat6 - paramFloat5);
    paramFloat1 = -(paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1);
    paramFloat2 = -(paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3);
    paramFloat3 = -(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5);
    this.b[0] = f1;
    this.b[1] = 0.0F;
    this.b[2] = 0.0F;
    this.b[3] = 0.0F;
    this.b[4] = 0.0F;
    this.b[5] = f2;
    this.b[6] = 0.0F;
    this.b[7] = 0.0F;
    this.b[8] = 0.0F;
    this.b[9] = 0.0F;
    this.b[10] = f3;
    this.b[11] = 0.0F;
    this.b[12] = paramFloat1;
    this.b[13] = paramFloat2;
    this.b[14] = paramFloat3;
    this.b[15] = 1.0F;
    return this;
  }
  
  public Matrix4 a(Matrix4 paramMatrix4)
  {
    return a(paramMatrix4.b);
  }
  
  public Matrix4 a(g paramg)
  {
    a();
    this.b[12] = paramg.a;
    this.b[13] = paramg.b;
    this.b[14] = paramg.c;
    return this;
  }
  
  public Matrix4 a(g paramg1, g paramg2)
  {
    d.a(paramg1).d();
    e.a(paramg1).d();
    e.e(paramg2).d();
    f.a(e).e(d).d();
    a();
    this.b[0] = e.a;
    this.b[4] = e.b;
    this.b[8] = e.c;
    this.b[1] = f.a;
    this.b[5] = f.b;
    this.b[9] = f.c;
    this.b[2] = (-d.a);
    this.b[6] = (-d.b);
    this.b[10] = (-d.c);
    return this;
  }
  
  public Matrix4 a(g paramg1, g paramg2, g paramg3)
  {
    g.a(paramg2).c(paramg1);
    a(g, paramg3);
    b(h.a(paramg1.a().a(-1.0F)));
    return this;
  }
  
  public Matrix4 a(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.b, 0, this.b.length);
    return this;
  }
  
  public Matrix4 b(Matrix4 paramMatrix4)
  {
    mul(this.b, paramMatrix4.b);
    return this;
  }
  
  public String toString()
  {
    return "[" + this.b[0] + "|" + this.b[4] + "|" + this.b[8] + "|" + this.b[12] + "]\n" + "[" + this.b[1] + "|" + this.b[5] + "|" + this.b[9] + "|" + this.b[13] + "]\n" + "[" + this.b[2] + "|" + this.b[6] + "|" + this.b[10] + "|" + this.b[14] + "]\n" + "[" + this.b[3] + "|" + this.b[7] + "|" + this.b[11] + "|" + this.b[15] + "]\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/Matrix4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */