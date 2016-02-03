package com.magmamobile.game.engine.ui;

import com.magmamobile.game.engine.IGameEvents;
import com.magmamobile.game.engine.MathUtils;
import com.magmamobile.game.engine.TouchScreen;

public class Component
  implements IGameEvents
{
  protected boolean _clickable;
  protected boolean _dirty = true;
  protected boolean _enabled = true;
  protected int _height;
  protected float _left;
  protected int _measuredHeight;
  protected int _measuredWidth;
  protected boolean _pressed;
  protected float _top;
  protected boolean _visible = true;
  protected int _width;
  
  public int getHeight()
  {
    return this._height;
  }
  
  public float getLeft()
  {
    return this._left;
  }
  
  public final int getMeasuredHeight()
  {
    return this._measuredHeight;
  }
  
  public final int getMeasuredWidth()
  {
    return this._measuredWidth;
  }
  
  public float getTop()
  {
    return this._top;
  }
  
  public int getWidth()
  {
    return this._width;
  }
  
  public void invalidate()
  {
    this._dirty = true;
  }
  
  public boolean isClickable()
  {
    return this._clickable;
  }
  
  public boolean isDirty()
  {
    return this._dirty;
  }
  
  public boolean isPressed()
  {
    return this._pressed;
  }
  
  public void onAction()
  {
    if ((!this._visible) || (!this._enabled)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!this._clickable);
        if (!this._pressed) {
          break;
        }
      } while (TouchScreen.pressed);
      this._pressed = false;
      onTouchUp();
      return;
    } while ((!TouchScreen.eventDown) || (!MathUtils.PtInRect((int)this._left, (int)this._top, (int)this._left + this._width, (int)this._top + this._height, TouchScreen.x, TouchScreen.y)));
    this._pressed = true;
    onTouchDown();
  }
  
  protected void onDraw() {}
  
  public void onRender()
  {
    if (!this._visible) {
      return;
    }
    onDraw();
  }
  
  protected void onTouchDown() {}
  
  protected void onTouchUp() {}
  
  public void setClickable(boolean paramBoolean)
  {
    this._clickable = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    if (paramInt == this._height) {
      return;
    }
    this._dirty = true;
    this._height = paramInt;
  }
  
  public void setLeft(float paramFloat)
  {
    if (paramFloat == this._left) {
      return;
    }
    this._dirty = true;
    this._left = paramFloat;
  }
  
  public void setTop(float paramFloat)
  {
    if (paramFloat == this._top) {
      return;
    }
    this._dirty = true;
    this._top = paramFloat;
  }
  
  public void setWidth(int paramInt)
  {
    if (paramInt == this._width) {
      return;
    }
    this._dirty = true;
    this._width = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ui/Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */