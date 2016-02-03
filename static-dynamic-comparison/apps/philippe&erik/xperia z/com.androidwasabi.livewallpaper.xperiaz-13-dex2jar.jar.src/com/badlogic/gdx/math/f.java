package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.i;
import java.io.Serializable;

public class f
  implements Serializable
{
  public static final f a = new f(1.0F, 0.0F);
  public static final f b = new f(0.0F, 1.0F);
  public static final f c = new f(0.0F, 0.0F);
  public float d;
  public float e;
  
  public f() {}
  
  public f(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  public f a(float paramFloat)
  {
    this.d *= paramFloat;
    this.e *= paramFloat;
    return this;
  }
  
  public f a(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
    return this;
  }
  
  public f a(f paramf)
  {
    this.d = paramf.d;
    this.e = paramf.e;
    return this;
  }
  
  public float b(f paramf)
  {
    float f1 = paramf.d - this.d;
    float f2 = paramf.e - this.e;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public f b(float paramFloat)
  {
    return a(paramFloat);
  }
  
  public f b(float paramFloat1, float paramFloat2)
  {
    this.d += paramFloat1;
    this.e += paramFloat2;
    return this;
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
      paramObject = (f)paramObject;
      if (i.a(this.d) != i.a(((f)paramObject).d)) {
        return false;
      }
    } while (i.a(this.e) == i.a(((f)paramObject).e));
    return false;
  }
  
  public int hashCode()
  {
    return (i.a(this.d) + 31) * 31 + i.a(this.e);
  }
  
  public String toString()
  {
    return "[" + this.d + ":" + this.e + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */