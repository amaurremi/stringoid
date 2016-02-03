package com.troll.canvas;

public class Vector2D
{
  private float x;
  private float y;
  
  public Vector2D() {}
  
  public Vector2D(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public Vector2D(Vector2D paramVector2D)
  {
    this.x = paramVector2D.x;
    this.y = paramVector2D.y;
  }
  
  public static float getDistance(Vector2D paramVector2D1, Vector2D paramVector2D2)
  {
    return subtract(paramVector2D1, paramVector2D2).getLength();
  }
  
  public static Vector2D getNormalized(Vector2D paramVector2D)
  {
    float f = paramVector2D.getLength();
    if (f == 0.0F) {
      return new Vector2D();
    }
    return new Vector2D(paramVector2D.x / f, paramVector2D.y / f);
  }
  
  public static float getSignedAngleBetween(Vector2D paramVector2D1, Vector2D paramVector2D2)
  {
    paramVector2D1 = getNormalized(paramVector2D1);
    paramVector2D2 = getNormalized(paramVector2D2);
    return (float)(Math.atan2(paramVector2D2.y, paramVector2D2.x) - Math.atan2(paramVector2D1.y, paramVector2D1.x));
  }
  
  public static Vector2D subtract(Vector2D paramVector2D1, Vector2D paramVector2D2)
  {
    return new Vector2D(paramVector2D1.x - paramVector2D2.x, paramVector2D1.y - paramVector2D2.y);
  }
  
  public Vector2D add(Vector2D paramVector2D)
  {
    this.x += paramVector2D.getX();
    this.y += paramVector2D.getY();
    return this;
  }
  
  public float getLength()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y);
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public Vector2D set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }
  
  public Vector2D set(Vector2D paramVector2D)
  {
    this.x = paramVector2D.getX();
    this.y = paramVector2D.getY();
    return this;
  }
  
  public String toString()
  {
    return String.format("(%.4f, %.4f)", new Object[] { Float.valueOf(this.x), Float.valueOf(this.y) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/canvas/Vector2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */