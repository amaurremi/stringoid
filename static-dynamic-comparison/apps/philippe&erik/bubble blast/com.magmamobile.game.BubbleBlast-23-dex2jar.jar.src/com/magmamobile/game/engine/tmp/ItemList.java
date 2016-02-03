package com.magmamobile.game.engine.tmp;

import com.magmamobile.game.engine.TouchScreen;
import com.magmamobile.game.engine.VelocityTracker;

public abstract class ItemList
{
  private BufferCache cacheBottom = new BufferCache(getLeft(), getTop() + getHeight(), getLeft() + getWidth(), getTop() + getHeight() + getItemHeight());
  private BufferCache cacheTop = new BufferCache(getLeft(), getTop() - getItemHeight(), getLeft() + getWidth(), getTop());
  private float delta;
  private float ly;
  private boolean moving;
  private float scrollY;
  private VelocityTracker tracker = VelocityTracker.obtain();
  private float velocity;
  
  public abstract int getHeight();
  
  public abstract int getItemCount();
  
  public abstract int getItemHeight();
  
  public abstract int getLeft();
  
  public abstract int getTop();
  
  public abstract int getWidth();
  
  public void onAction()
  {
    if (TouchScreen.eventUp) {
      if (this.moving)
      {
        this.moving = false;
        this.tracker.addMovement(TouchScreen.x, TouchScreen.y);
        this.tracker.computeCurrentVelocity(100);
        this.velocity = this.tracker.getYVelocity();
        if (Math.abs(this.delta) < 2.0F)
        {
          int i = (int)((TouchScreen.y - this.scrollY) / getItemHeight()) - 1;
          if ((i >= 0) && (i < getItemCount())) {
            onItemClick(i);
          }
        }
      }
    }
    for (;;)
    {
      this.scrollY += this.velocity;
      if (this.velocity != 0.0F)
      {
        this.velocity *= 0.9F;
        if (Math.abs(this.velocity) < 1.0F) {
          this.velocity = 0.0F;
        }
      }
      return;
      if (TouchScreen.eventDown)
      {
        if (TouchScreen.isInRect(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight()))
        {
          this.tracker.addMovement(TouchScreen.x, TouchScreen.y);
          this.ly = TouchScreen.y;
          this.delta = 0.0F;
          this.velocity = 0.0F;
          this.moving = true;
        }
      }
      else if ((TouchScreen.eventMoving) && (this.moving))
      {
        this.tracker.addMovement(TouchScreen.x, TouchScreen.y);
        this.scrollY += TouchScreen.y - this.ly;
        this.delta += this.ly - TouchScreen.y;
        this.ly = TouchScreen.y;
      }
    }
  }
  
  public abstract void onDrawItem(int paramInt1, int paramInt2, int paramInt3);
  
  protected void onItemClick(int paramInt) {}
  
  public void onRender()
  {
    int k = getItemCount();
    int m;
    int n;
    int i;
    int j;
    if (k != 0)
    {
      this.cacheTop.capture();
      this.cacheBottom.capture();
      m = getTop();
      n = getHeight();
      i = getItemHeight() * k - getHeight();
      if (-this.scrollY > i) {
        this.scrollY = (-i);
      }
      if (-this.scrollY < 0.0F) {
        this.scrollY = 0.0F;
      }
      j = getTop() + (int)this.scrollY;
      i = 0;
    }
    for (;;)
    {
      if (i >= k)
      {
        this.cacheTop.redraw();
        this.cacheBottom.redraw();
        return;
      }
      if ((j > getTop() - getItemHeight()) && (j <= m + n)) {
        onDrawItem(i, getLeft(), j);
      }
      j += getItemHeight();
      i += 1;
    }
  }
  
  public void refresh()
  {
    this.moving = false;
    this.scrollY = 0.0F;
    this.delta = 0.0F;
    this.velocity = 0.0F;
    this.ly = 0.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/ItemList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */