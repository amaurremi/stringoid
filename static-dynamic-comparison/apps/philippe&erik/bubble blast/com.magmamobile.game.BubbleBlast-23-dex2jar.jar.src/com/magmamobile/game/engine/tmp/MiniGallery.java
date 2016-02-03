package com.magmamobile.game.engine.tmp;

import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.MathUtils;
import com.magmamobile.game.engine.TouchScreen;

public abstract class MiniGallery
{
  private int currX;
  private int delta;
  private float factor;
  private boolean hook;
  private int index;
  private int lastPos;
  private int lastX;
  private boolean moving;
  private int pageTopPadding = 10;
  private int top;
  
  public int getFriction()
  {
    return 16;
  }
  
  protected abstract int getItemCount();
  
  protected abstract int getItemHeight();
  
  protected abstract int getItemWidth();
  
  public int getPage()
  {
    return this.index;
  }
  
  public int getPageTopPadding()
  {
    return this.pageTopPadding;
  }
  
  protected abstract int getSelectorWidth();
  
  public int getTop()
  {
    return this.top;
  }
  
  public void onAction()
  {
    if (TouchScreen.eventDown) {
      if (TouchScreen.isInRect(0, getTop(), Game.mBufferWidth, getItemHeight() + getPageTopPadding()))
      {
        this.hook = true;
        this.lastX = TouchScreen.x;
      }
    }
    for (;;)
    {
      if ((!this.hook) && (this.factor < 1.0F))
      {
        this.factor += 0.1F;
        this.currX = ((int)MathUtils.lerpDecelerate(this.delta, this.lastPos, this.factor));
      }
      return;
      if (TouchScreen.eventMoving)
      {
        if (this.hook) {
          if (this.moving)
          {
            this.currX += TouchScreen.x - this.lastX;
            this.index = MathUtils.minmaxi(-MathUtils.Int((this.currX + (getItemWidth() >> 1)) / getItemWidth()), 0, getItemCount() - 1);
            this.lastX = TouchScreen.x;
            this.delta = this.currX;
          }
          else if (Math.abs(TouchScreen.x - this.lastX) > getFriction())
          {
            this.moving = true;
          }
        }
      }
      else if ((TouchScreen.eventUp) && (this.hook))
      {
        this.lastPos = (-this.index * getItemWidth());
        this.hook = false;
        this.factor = 0.0F;
        if (!this.moving)
        {
          onItemSelected(this.index);
          this.delta = this.lastPos;
        }
        else
        {
          this.moving = false;
        }
      }
    }
  }
  
  protected abstract void onDrawItem(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  protected abstract void onDrawSelector(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  protected abstract void onItemSelected(int paramInt);
  
  public void onRender()
  {
    int j = getTop();
    int k = getTop();
    int m = getItemHeight();
    int n = getPageTopPadding();
    int i = 0;
    if (i >= getItemCount()) {
      return;
    }
    int i1 = getItemWidth() / 2;
    int i2 = getItemWidth();
    int i3 = this.currX;
    if (i == this.index)
    {
      bool = true;
      label64:
      onDrawItem(i, i3 + (160 - i1 + i2 * i), j, bool);
      i1 = getItemCount() * getSelectorWidth() / 2;
      i2 = getSelectorWidth();
      if (i != this.index) {
        break label154;
      }
    }
    label154:
    for (boolean bool = true;; bool = false)
    {
      onDrawSelector(i, i2 * i + (160 - i1), k + m + n, bool);
      i += 1;
      break;
      bool = false;
      break label64;
    }
  }
  
  public void reset()
  {
    this.hook = false;
    this.factor = 0.0F;
    this.lastPos = 0;
    this.index = 0;
    this.lastX = 0;
    this.delta = 0;
    this.currX = 0;
  }
  
  public void setPage(int paramInt)
  {
    this.delta = 0;
    this.lastPos = (-MathUtils.minmaxi(paramInt, 0, getItemCount() - 1) * getItemWidth());
  }
  
  public void setPageTopPadding(int paramInt)
  {
    this.pageTopPadding = paramInt;
  }
  
  public void setTop(int paramInt)
  {
    this.top = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/MiniGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */