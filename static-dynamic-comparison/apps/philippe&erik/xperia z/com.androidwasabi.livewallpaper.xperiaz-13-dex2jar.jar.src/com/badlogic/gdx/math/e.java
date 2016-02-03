package com.badlogic.gdx.math;

import java.io.Serializable;

public class e
  implements Serializable
{
  public static final e a = new e();
  public static final e b = new e();
  public float c;
  public float d;
  public float e;
  public float f;
  
  public e() {}
  
  public e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramFloat4;
  }
  
  public String toString()
  {
    return this.c + "," + this.d + "," + this.e + "," + this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */