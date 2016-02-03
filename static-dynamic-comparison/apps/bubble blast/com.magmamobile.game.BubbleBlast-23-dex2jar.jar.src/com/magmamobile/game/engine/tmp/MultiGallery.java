package com.magmamobile.game.engine.tmp;

import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.MathUtils;
import com.magmamobile.game.engine.TouchScreen;

public abstract class MultiGallery
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
  
  protected abstract int getColCount();
  
  public int getFriction()
  {
    return 16;
  }
  
  protected abstract int getItemCount();
  
  protected abstract int getItemHeight();
  
  protected abstract int getItemWidth();
  
  public int getItemsPerPage()
  {
    return getColCount() * getRowCount();
  }
  
  public int getPageCount()
  {
    return MathUtils.maxi((getItemCount() - 1) / getItemsPerPage(), 0) + 1;
  }
  
  public int getPageHeight()
  {
    return getRowCount() * getItemHeight();
  }
  
  public int getPageTopPadding()
  {
    return this.pageTopPadding;
  }
  
  public int getPageWidth()
  {
    return getColCount() * getItemWidth();
  }
  
  protected abstract int getRowCount();
  
  protected abstract int getSelectorWidth();
  
  public int getTop()
  {
    return this.top;
  }
  
  public void onAction()
  {
    if (TouchScreen.eventDown) {
      if (TouchScreen.isInRect(0, getTop(), Game.mBufferWidth, getPageHeight() + getPageTopPadding()))
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
            this.index = MathUtils.minmaxi(-MathUtils.Int((this.currX + (getPageWidth() >> 1)) / getPageWidth()), 0, getPageCount() - 1);
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
        this.lastPos = (-this.index * getPageWidth());
        this.hook = false;
        this.factor = 0.0F;
        if (!this.moving)
        {
          if ((Math.abs(this.lastPos - this.delta) < 10) && (TouchScreen.isIn(160, 240, getPageWidth() >> 1, getPageHeight() >> 1)))
          {
            int i = MathUtils.minmaxi((TouchScreen.x - (320 - getPageWidth()) / 2) / getItemWidth(), 0, getColCount() - 1);
            int j = MathUtils.minmaxi((TouchScreen.y - (480 - getPageHeight()) / 2) / getItemHeight(), 0, getRowCount() - 1);
            onItemSelected(MathUtils.minmaxi(getColCount() * j + i + this.index * getItemsPerPage(), 0, getItemCount() - 1));
          }
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
    int j = 0;
    int n = getPageCount();
    int i1 = (320 - getPageWidth()) / 2;
    int i2 = getTop();
    int i3 = getTop();
    int i4 = getPageHeight();
    int i5 = getPageTopPadding();
    int i = 0;
    if (i >= n) {
      return;
    }
    int k = 0;
    int m;
    if (k >= getRowCount())
    {
      k = getSelectorWidth() * n / 2;
      m = getSelectorWidth();
      if (i != this.index) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      onDrawSelector(i, m * i + (160 - k), i3 + i4 + i5, bool);
      i += 1;
      break;
      m = 0;
      for (;;)
      {
        if (m >= getColCount())
        {
          k += 1;
          break;
        }
        if (j < getItemCount()) {
          onDrawItem(j, getItemWidth() * m + (getItemWidth() >> 1) + i1 + this.currX + getPageWidth() * i, getItemHeight() * k + (getItemHeight() >> 1) + i2, false);
        }
        j += 1;
        m += 1;
      }
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
  
  public void setPageTopPadding(int paramInt)
  {
    this.pageTopPadding = paramInt;
  }
  
  public void setTop(int paramInt)
  {
    this.top = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/MultiGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */