package com.magmamobile.game.engine;

import android.graphics.Bitmap;

public class Paddle
  extends GameObject
{
  private int _dir;
  private int _dirX;
  private int _dirY;
  private boolean _down;
  private Bitmap _image;
  private int _paddingBottom;
  private int _paddingLeft;
  private int _paddingRight;
  private int _paddingTop;
  
  public Paddle()
  {
    this.visible = true;
    this.enabled = true;
  }
  
  private void update()
  {
    if (this._image != null)
    {
      setSize(this._image.getWidth() + this._paddingLeft + this._paddingRight, this._image.getHeight() + this._paddingTop + this._paddingBottom);
      return;
    }
    setSize(this._paddingLeft + this._paddingRight, this._paddingTop + this._paddingBottom);
  }
  
  public int dir()
  {
    return this._dir;
  }
  
  public int dirX()
  {
    return this._dirX;
  }
  
  public int dirY()
  {
    return this._dirY;
  }
  
  public boolean hit()
  {
    return intersectPoint(TouchScreen.x, TouchScreen.y);
  }
  
  public boolean isDown()
  {
    return this._down;
  }
  
  public void onAction()
  {
    this._down = false;
    int j;
    if ((TouchScreen.eventDown) && (hit()))
    {
      this._down = true;
      int i = TouchScreen.x - ((int)this.x + this.cw);
      j = TouchScreen.y - ((int)this.y + this.ch);
      if (Math.abs(i) <= Math.abs(j)) {
        break label91;
      }
      this._dirX = MathUtils.sgni(i);
      this._dirY = 0;
      if (this._dirY != -1) {
        break label107;
      }
      this._dir = 0;
    }
    label91:
    label107:
    do
    {
      return;
      this._dirX = 0;
      this._dirY = MathUtils.sgni(j);
      break;
      if (this._dirX == 1)
      {
        this._dir = 1;
        return;
      }
      if (this._dirY == 1)
      {
        this._dir = 2;
        return;
      }
    } while (this._dirX != -1);
    this._dir = 3;
  }
  
  public void onRender()
  {
    if ((!this.visible) || (!this.enabled)) {}
    while (this._image == null) {
      return;
    }
    Game.drawBitmap(this._image, (int)this.x + this._paddingLeft, (int)this.y + this._paddingTop);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this._image = paramBitmap;
    update();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._paddingLeft = paramInt1;
    this._paddingTop = paramInt2;
    this._paddingRight = paramInt3;
    this._paddingBottom = paramInt4;
    update();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Paddle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */