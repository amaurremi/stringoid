package com.bfs.papertoss.vector;

public class v4f
{
  public float w;
  public float x;
  public float y;
  public float z;
  
  public v4f()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    this.z = 0.0F;
    this.w = 0.0F;
  }
  
  public v4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  public boolean equals(v4f paramv4f)
  {
    return (this.x == paramv4f.x) && (this.y == paramv4f.y) && (this.z == paramv4f.z) && (this.w == paramv4f.w);
  }
  
  public boolean equalsZero()
  {
    return (this.x == 0.0F) && (this.y == 0.0F) && (this.z == 0.0F) && (this.w == 0.0F);
  }
  
  public v4f minus(v4f paramv4f)
  {
    return new v4f(this.x - paramv4f.x, this.y - paramv4f.y, this.z - paramv4f.z, this.w - paramv4f.w);
  }
  
  public v4f plus(v4f paramv4f)
  {
    return new v4f(this.x + paramv4f.x, this.y + paramv4f.y, this.z + paramv4f.z, this.w + paramv4f.w);
  }
  
  public v4f times(float paramFloat)
  {
    return new v4f(this.x * paramFloat, this.y * paramFloat, this.z * paramFloat, this.w * paramFloat);
  }
  
  public v4f times(v4f paramv4f)
  {
    return new v4f(this.x * paramv4f.x, this.y * paramv4f.y, this.z * paramv4f.z, this.w * paramv4f.w);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/vector/v4f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */