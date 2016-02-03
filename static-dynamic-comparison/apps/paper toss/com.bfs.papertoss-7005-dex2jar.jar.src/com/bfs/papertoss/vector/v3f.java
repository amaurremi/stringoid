package com.bfs.papertoss.vector;

public class v3f
{
  public float x;
  public float y;
  public float z;
  
  public v3f()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    this.z = 0.0F;
  }
  
  public v3f(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = 0.0F;
  }
  
  public v3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public v3f(v3f paramv3f)
  {
    this.x = paramv3f.x;
    this.y = paramv3f.y;
    this.z = paramv3f.z;
  }
  
  public static v3f iv3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new v3f(paramFloat1, 480.0F - paramFloat2, paramFloat3);
  }
  
  public boolean equals(v3f paramv3f)
  {
    return (this.x == paramv3f.x) && (this.y == paramv3f.y) && (this.z == paramv3f.z);
  }
  
  public boolean equalsZero()
  {
    return (this.x == 0.0F) && (this.y == 0.0F) && (this.z == 0.0F);
  }
  
  public v3f minus(v3f paramv3f)
  {
    return new v3f(this.x - paramv3f.x, this.y - paramv3f.y, this.z - paramv3f.z);
  }
  
  public v3f plus(v3f paramv3f)
  {
    return new v3f(this.x + paramv3f.x, this.y + paramv3f.y, this.z + paramv3f.z);
  }
  
  public v3f times(float paramFloat)
  {
    return new v3f(this.x * paramFloat, this.y * paramFloat, this.z * paramFloat);
  }
  
  public v3f times(v3f paramv3f)
  {
    return new v3f(this.x * paramv3f.x, this.y * paramv3f.y, this.z * paramv3f.z);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/vector/v3f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */