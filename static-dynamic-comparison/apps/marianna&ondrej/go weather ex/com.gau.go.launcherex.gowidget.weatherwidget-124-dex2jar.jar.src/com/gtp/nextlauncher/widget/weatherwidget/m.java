package com.gtp.nextlauncher.widget.weatherwidget;

import java.nio.FloatBuffer;

public class m
{
  public float a;
  public float b;
  public float c;
  private final short d;
  private n e = new n(0.0F, 0.0F);
  private n f = new n(0.0F, 0.0F);
  private boolean g = true;
  private float[] h = new float[3];
  
  public m(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = ((short)paramInt);
    this.h[0] = paramFloat1;
    this.h[1] = paramFloat2;
    this.h[2] = paramFloat3;
  }
  
  public short a()
  {
    return this.d;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.e.a = paramFloat1;
    this.e.b = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public void a(FloatBuffer paramFloatBuffer)
  {
    paramFloatBuffer.put(this.a);
    paramFloatBuffer.put(this.b);
    paramFloatBuffer.put(this.c);
  }
  
  public void a(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    paramFloatBuffer1.put(this.a);
    paramFloatBuffer1.put(this.b);
    paramFloatBuffer1.put(this.c);
    paramFloatBuffer2.put(this.e.a);
    paramFloatBuffer2.put(this.e.b);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      bool1 = bool2;
      if (this.a == ((m)paramObject).a)
      {
        bool1 = bool2;
        if (this.b == ((m)paramObject).b)
        {
          bool1 = bool2;
          if (this.c == ((m)paramObject).c) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */