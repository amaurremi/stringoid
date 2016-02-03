package com.bfs.papertoss.vector;

public class v2f
{
  public float x;
  public float y;
  
  public v2f()
  {
    this.x = 0.0F;
    this.y = 0.0F;
  }
  
  public v2f(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public v2f(v2i paramv2i)
  {
    this.x = paramv2i.x;
    this.y = paramv2i.y;
  }
  
  public static float dot(v2f paramv2f1, v2f paramv2f2)
  {
    return paramv2f1.x * paramv2f2.x + paramv2f1.y * paramv2f2.y;
  }
  
  public static float getNegativeRotation(v2f paramv2f)
  {
    float f = (float)Math.acos(dot(paramv2f.normalized(), new v2f(1.0F, 0.0F)));
    if (paramv2f.y < 0.0F) {}
    for (int i = -1;; i = 1) {
      return i * (f * -1.0F);
    }
  }
  
  public v2f dividedBy(float paramFloat)
  {
    return new v2f(this.x / paramFloat, this.y / paramFloat);
  }
  
  public v2f dividedBy(v2f paramv2f)
  {
    return new v2f(this.x / paramv2f.x, this.y / paramv2f.y);
  }
  
  public boolean equals(v2f paramv2f)
  {
    return (this.x == paramv2f.x) && (this.y == paramv2f.y);
  }
  
  public boolean equalsZero()
  {
    return (this.x == 0.0F) && (this.y == 0.0F);
  }
  
  public float length()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y);
  }
  
  public v2f minus(v2f paramv2f)
  {
    return new v2f(this.x - paramv2f.x, this.y - paramv2f.y);
  }
  
  public void normalize()
  {
    float f = length();
    this.x /= f;
    this.y /= f;
  }
  
  public v2f normalized()
  {
    v2f localv2f = new v2f(this.x, this.y);
    localv2f.normalize();
    return localv2f;
  }
  
  public v2f plus(v2f paramv2f)
  {
    return new v2f(this.x + paramv2f.x, this.y + paramv2f.y);
  }
  
  public void plusEquals(v2f paramv2f)
  {
    this.x += paramv2f.x;
    this.y += paramv2f.y;
  }
  
  public v2f rotated(double paramDouble)
  {
    return new v2f(this.x * (float)Math.cos(paramDouble) - this.y * (float)Math.sin(paramDouble), this.y * (float)Math.cos(paramDouble) + this.x * (float)Math.sin(paramDouble));
  }
  
  public v2f times(float paramFloat)
  {
    return new v2f(this.x * paramFloat, this.y * paramFloat);
  }
  
  public v2f times(v2f paramv2f)
  {
    return new v2f(this.x * paramv2f.x, this.y * paramv2f.y);
  }
  
  public void timesEquals(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
  }
  
  public void timesEquals(v2f paramv2f)
  {
    this.x *= paramv2f.x;
    this.y *= paramv2f.y;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/vector/v2f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */