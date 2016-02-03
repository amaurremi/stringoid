package com.venticake.retrica.view.album;

public final class Vector3f
{
  public float x;
  public float y;
  public float z;
  
  public Vector3f() {}
  
  public Vector3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public Vector3f(Vector3f paramVector3f)
  {
    this.x = paramVector3f.x;
    this.y = paramVector3f.y;
    this.z = paramVector3f.z;
  }
  
  public void add(Vector3f paramVector3f)
  {
    this.x += paramVector3f.x;
    this.y += paramVector3f.y;
    this.z += paramVector3f.z;
  }
  
  public boolean equals(Vector3f paramVector3f)
  {
    return (this.x == paramVector3f.x) && (this.y == paramVector3f.y) && (this.z == paramVector3f.z);
  }
  
  public void set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public void set(Vector3f paramVector3f)
  {
    this.x = paramVector3f.x;
    this.y = paramVector3f.y;
    this.z = paramVector3f.z;
  }
  
  public void subtract(Vector3f paramVector3f)
  {
    this.x -= paramVector3f.x;
    this.y -= paramVector3f.y;
    this.z -= paramVector3f.z;
  }
  
  public String toString()
  {
    return new String("(" + this.x + ", " + this.y + ", " + this.z + ")");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Vector3f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */