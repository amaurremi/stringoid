package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.i;
import java.io.Serializable;

public class g
  implements Serializable
{
  public static final g d = new g();
  public static final g e = new g();
  public static final g f = new g();
  public static final g g = new g(1.0F, 0.0F, 0.0F);
  public static final g h = new g(0.0F, 1.0F, 0.0F);
  public static final g i = new g(0.0F, 0.0F, 1.0F);
  public static final g j = new g(0.0F, 0.0F, 0.0F);
  private static final Matrix4 k = new Matrix4();
  public float a;
  public float b;
  public float c;
  
  public g() {}
  
  public g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public g a()
  {
    return d.a(this);
  }
  
  public g a(float paramFloat)
  {
    return a(this.a * paramFloat, this.b * paramFloat, this.c * paramFloat);
  }
  
  public g a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    return this;
  }
  
  public g a(Matrix4 paramMatrix4)
  {
    paramMatrix4 = paramMatrix4.b;
    float f1 = 1.0F / (this.a * paramMatrix4[3] + this.b * paramMatrix4[7] + this.c * paramMatrix4[11] + paramMatrix4[15]);
    float f2 = this.a;
    float f3 = paramMatrix4[0];
    float f4 = this.b;
    float f5 = paramMatrix4[4];
    float f6 = this.c;
    float f7 = paramMatrix4[8];
    float f8 = paramMatrix4[12];
    float f9 = this.a;
    float f10 = paramMatrix4[1];
    float f11 = this.b;
    float f12 = paramMatrix4[5];
    float f13 = this.c;
    float f14 = paramMatrix4[9];
    float f15 = paramMatrix4[13];
    float f16 = this.a;
    float f17 = paramMatrix4[2];
    float f18 = this.b;
    float f19 = paramMatrix4[6];
    float f20 = this.c;
    float f21 = paramMatrix4[10];
    return a((f2 * f3 + f4 * f5 + f6 * f7 + f8) * f1, (f9 * f10 + f11 * f12 + f13 * f14 + f15) * f1, (paramMatrix4[14] + (f16 * f17 + f18 * f19 + f20 * f21)) * f1);
  }
  
  public g a(g paramg)
  {
    return a(paramg.a, paramg.b, paramg.c);
  }
  
  public g b()
  {
    return e.a(this);
  }
  
  public g b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return a(this.a + paramFloat1, this.b + paramFloat2, this.c + paramFloat3);
  }
  
  public g b(g paramg)
  {
    return b(paramg.a, paramg.b, paramg.c);
  }
  
  public float c()
  {
    return this.a * this.a + this.b * this.b + this.c * this.c;
  }
  
  public g c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return a(this.a - paramFloat1, this.b - paramFloat2, this.c - paramFloat3);
  }
  
  public g c(g paramg)
  {
    return c(paramg.a, paramg.b, paramg.c);
  }
  
  public float d(g paramg)
  {
    return this.a * paramg.a + this.b * paramg.b + this.c * paramg.c;
  }
  
  public g d()
  {
    float f1 = c();
    if ((f1 == 0.0F) || (f1 == 1.0F)) {
      return this;
    }
    return a(1.0F / (float)Math.sqrt(f1));
  }
  
  public g e(g paramg)
  {
    return a(this.b * paramg.c - this.c * paramg.b, this.c * paramg.a - this.a * paramg.c, this.a * paramg.b - this.b * paramg.a);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (g)paramObject;
      if (i.a(this.a) != i.a(((g)paramObject).a)) {
        return false;
      }
      if (i.a(this.b) != i.a(((g)paramObject).b)) {
        return false;
      }
    } while (i.a(this.c) == i.a(((g)paramObject).c));
    return false;
  }
  
  public int hashCode()
  {
    return ((i.a(this.a) + 31) * 31 + i.a(this.b)) * 31 + i.a(this.c);
  }
  
  public String toString()
  {
    return this.a + "," + this.b + "," + this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */