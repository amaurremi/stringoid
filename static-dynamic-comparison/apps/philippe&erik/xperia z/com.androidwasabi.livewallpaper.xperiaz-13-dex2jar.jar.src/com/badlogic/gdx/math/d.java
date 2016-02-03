package com.badlogic.gdx.math;

import java.io.Serializable;

public class d
  implements Serializable
{
  private static d e = new d(0.0F, 0.0F, 0.0F, 0.0F);
  private static d f = new d(0.0F, 0.0F, 0.0F, 0.0F);
  public float a;
  public float b;
  public float c;
  public float d;
  
  public d()
  {
    a();
  }
  
  public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public d a()
  {
    return a(0.0F, 0.0F, 0.0F, 1.0F);
  }
  
  public d a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((this.a == ((d)paramObject).a) && (this.b == ((d)paramObject).b) && (this.c == ((d)paramObject).c) && (this.d == ((d)paramObject).d));
    return false;
  }
  
  public String toString()
  {
    return "[" + this.a + "|" + this.b + "|" + this.c + "|" + this.d + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */