package com.magmamobile.game.engine.ex;

public class Vector2D
{
  public float x;
  public float y;
  
  public Vector2D() {}
  
  public Vector2D(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void add(Vector2D paramVector2D)
  {
    this.x += paramVector2D.x;
    this.y += paramVector2D.y;
  }
  
  public void div(Vector2D paramVector2D)
  {
    this.x /= paramVector2D.x;
    this.y /= paramVector2D.y;
  }
  
  public float dot()
  {
    return this.x * this.x + this.y * this.y;
  }
  
  public float dot(Vector2D paramVector2D)
  {
    return this.x * paramVector2D.x + this.y * paramVector2D.y;
  }
  
  public float length()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y);
  }
  
  public void mul(Vector2D paramVector2D)
  {
    this.x *= paramVector2D.x;
    this.y *= paramVector2D.y;
  }
  
  public void normalize()
  {
    float f = (float)Math.sqrt(this.x * this.x + this.y * this.y);
    if (f != 0.0F)
    {
      this.x /= f;
      this.y /= f;
    }
  }
  
  public void set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void sub(Vector2D paramVector2D)
  {
    this.x -= paramVector2D.x;
    this.y -= paramVector2D.y;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ex/Vector2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */