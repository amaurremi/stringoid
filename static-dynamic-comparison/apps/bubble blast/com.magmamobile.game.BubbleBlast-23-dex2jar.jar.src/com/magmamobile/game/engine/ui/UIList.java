package com.magmamobile.game.engine.ui;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.SparseArray;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;
import com.magmamobile.game.engine.TouchScreen;
import com.magmamobile.game.engine.VelocityTracker;

public class UIList
  extends GameObject
{
  private SparseArray<GameObject> _cache = new SparseArray();
  private float _friction;
  private boolean _hook;
  private UIAdapter _list;
  private float _ly;
  private OnItemClickListener _onItemClicklistener;
  private OnScrollListener _onScrolllistener;
  private GameObject _scrollBar = new UISlideBar();
  private float _scrollY;
  private boolean _scrolling;
  private GameObject _selected;
  private VelocityTracker _tracker = VelocityTracker.obtain();
  private int _units;
  private float _velocity;
  
  public UIList()
  {
    this._scrollBar.setW(10);
    this._scrollBar.setH(50);
    this._friction = 0.9F;
    this._units = 25;
    this.visible = true;
    this.enabled = true;
  }
  
  public void clearScroll()
  {
    this._scrolling = false;
    this._scrollY = 0.0F;
    this._velocity = 0.0F;
    this._ly = 0.0F;
  }
  
  public float getFriction()
  {
    return this._friction;
  }
  
  public UIAdapter getList()
  {
    return this._list;
  }
  
  public OnItemClickListener getOnItemClickListener()
  {
    return this._onItemClicklistener;
  }
  
  public OnScrollListener getOnScrollListener()
  {
    return this._onScrolllistener;
  }
  
  public float getScroll()
  {
    return this._scrollY;
  }
  
  public GameObject getSlideBar()
  {
    return this._scrollBar;
  }
  
  public int getUnits()
  {
    return this._units;
  }
  
  public void onAction()
  {
    if (!this.enabled) {}
    label7:
    label39:
    label105:
    label237:
    label481:
    label587:
    label622:
    label624:
    do
    {
      break label7;
      for (;;)
      {
        return;
        if (this._list != null)
        {
          int k = this._list.getMaxHeight();
          int m = getHeight();
          int i;
          if (k > m)
          {
            i = 1;
            if (!TouchScreen.eventDown) {
              break label237;
            }
            if (TouchScreen.isInRect((int)getX(), (int)getY(), getWidth(), getHeight()))
            {
              this._tracker.addMovement(TouchScreen.x, TouchScreen.y);
              this._ly = TouchScreen.y;
              this._scrolling = false;
              this._hook = true;
              this._velocity = 0.0F;
            }
            if (i == 0) {
              break label624;
            }
            if (this._scrollBar != null) {
              this._scrollBar.setVisible(true);
            }
            this._scrollY += this._velocity;
            i = k - m;
            if (this._scrollY >= 0.0F) {
              break label587;
            }
            this._scrollY = 0.0F;
            if (this._onScrolllistener != null) {
              this._onScrolllistener.onScrollStateChanged(this, 0);
            }
          }
          for (;;)
          {
            if (this._velocity == 0.0F) {
              break label622;
            }
            this._velocity *= this._friction;
            if (Math.abs(this._velocity) >= 1.0F) {
              break;
            }
            this._velocity = 0.0F;
            if (this._onScrolllistener == null) {
              break;
            }
            this._onScrolllistener.onScrollStateChanged(this, 0);
            return;
            i = 0;
            break label39;
            if (TouchScreen.eventUp)
            {
              if (!this._hook) {
                break label105;
              }
              this._tracker.addMovement(TouchScreen.x, TouchScreen.y);
              this._tracker.computeCurrentVelocity(this._units);
              this._hook = false;
              if (this._scrolling)
              {
                this._scrolling = false;
                this._velocity = (-this._tracker.getYVelocity());
                if ((this._onScrolllistener == null) || (this._velocity != 0.0F)) {
                  break label105;
                }
                this._onScrolllistener.onScrollStateChanged(this, 0);
                break label105;
              }
              if (this._selected != null) {
                this._selected.selected = false;
              }
              int n = this._list.getCount();
              int j = 0;
              for (;;)
              {
                if (j >= n) {
                  break label481;
                }
                GameObject localGameObject = (GameObject)this._cache.get(j);
                localGameObject = this._list.getItemUI(j, localGameObject, this);
                if (TouchScreen.isInRect((int)localGameObject.getX(), (int)localGameObject.getY(), localGameObject.getWidth(), localGameObject.getHeight() - 1))
                {
                  localGameObject.selected = true;
                  this._selected = localGameObject;
                  if (this._onScrolllistener != null) {
                    this._onScrolllistener.onScrollStateChanged(this, 1);
                  }
                  if (this._onItemClicklistener == null) {
                    break;
                  }
                  this._onItemClicklistener.onItemClick(j, this);
                  break;
                }
                j += 1;
              }
              break label105;
            }
            if ((!TouchScreen.eventMoving) || (!this._hook)) {
              break label105;
            }
            this._tracker.addMovement(TouchScreen.x, TouchScreen.y);
            if ((Math.abs(this._ly - TouchScreen.y) > 10.0F) && (!this._scrolling))
            {
              this._ly = TouchScreen.y;
              this._scrolling = true;
            }
            if ((!this._scrolling) || (i == 0)) {
              break label105;
            }
            this._scrollY += this._ly - TouchScreen.y;
            this._ly = TouchScreen.y;
            break label105;
            if (this._scrollY > i)
            {
              this._scrollY = i;
              if (this._onScrolllistener != null) {
                this._onScrolllistener.onScrollStateChanged(this, 0);
              }
            }
          }
        }
      }
    } while (this._scrollBar == null);
    this._scrollBar.setVisible(false);
  }
  
  public void onRender()
  {
    if (!this.visible) {
      return;
    }
    Game.clipRect((int)this.x, (int)this.y, (int)this.x + this.w, (int)this.y + this.h);
    int m;
    int n;
    int j;
    int i;
    if (this._list != null)
    {
      int k = this._list.getCount();
      m = (int)this.y;
      n = getHeight();
      j = (int)(this.y - this._scrollY);
      i = 0;
      if (i < k) {
        break label188;
      }
      label89:
      if (this._scrollBar != null)
      {
        i = this._list.getMaxHeight();
        j = getHeight();
        i = (int)(this._scrollY / (i - j) * (getHeight() - this._scrollBar.getHeight()));
        this._scrollBar.setX((int)this.x + getWidth() - this._scrollBar.getWidth());
        this._scrollBar.setY((int)this.y + i);
        this._scrollBar.onRender();
      }
    }
    Game.clipClear();
    return;
    label188:
    GameObject localGameObject3 = (GameObject)this._cache.get(i);
    GameObject localGameObject1;
    if (localGameObject3 != null)
    {
      GameObject localGameObject2 = this._list.getItemUI(i, localGameObject3, this);
      localGameObject1 = localGameObject2;
      if (localGameObject2 != localGameObject3)
      {
        this._cache.setValueAt(this._cache.indexOfKey(i), localGameObject2);
        localGameObject1 = localGameObject2;
      }
    }
    for (;;)
    {
      localGameObject1.setX(this.x);
      localGameObject1.setY(j);
      localGameObject1.setWidth(this._list.getItemWidth(i));
      localGameObject1.setHeight(this._list.getItemHeight(i));
      localGameObject1.onRender();
      j += this._list.getItemHeight(i);
      if (j > m + n) {
        break label89;
      }
      i += 1;
      break;
      localGameObject1 = this._list.getItemUI(i, null, this);
      this._cache.put(i, localGameObject1);
    }
  }
  
  public void setFriction(float paramFloat)
  {
    this._friction = paramFloat;
  }
  
  public void setList(UIAdapter paramUIAdapter)
  {
    this._list = paramUIAdapter;
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
  {
    this._onItemClicklistener = paramOnItemClickListener;
  }
  
  public void setOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    this._onScrolllistener = paramOnScrollListener;
  }
  
  public void setPosition(int paramInt)
  {
    if (this._selected != null) {
      this._selected.selected = false;
    }
    int j;
    int i;
    if (this._list != null)
    {
      int k = this._list.getCount();
      j = 0;
      i = 0;
      if (i < k) {}
    }
    else
    {
      return;
    }
    GameObject localGameObject3 = (GameObject)this._cache.get(i);
    GameObject localGameObject1;
    if (i == paramInt) {
      if (localGameObject3 != null)
      {
        GameObject localGameObject2 = this._list.getItemUI(i, localGameObject3, this);
        localGameObject1 = localGameObject2;
        if (localGameObject2 != localGameObject3)
        {
          this._cache.setValueAt(this._cache.indexOfKey(i), localGameObject2);
          localGameObject1 = localGameObject2;
        }
        label114:
        localGameObject1.selected = true;
        this._selected = localGameObject1;
        this._scrollY = j;
      }
    }
    for (;;)
    {
      j += this._list.getItemHeight(i);
      i += 1;
      break;
      localGameObject1 = this._list.getItemUI(i, null, this);
      this._cache.put(i, localGameObject1);
      break label114;
      if (localGameObject3 != null) {
        localGameObject3.selected = false;
      }
    }
  }
  
  public void setPosition(int paramInt, boolean paramBoolean)
  {
    int j;
    int i;
    if (this._list != null)
    {
      int k = this._list.getCount();
      j = 0;
      i = 0;
      if (i < k) {}
    }
    else
    {
      return;
    }
    GameObject localGameObject3 = (GameObject)this._cache.get(i);
    GameObject localGameObject1;
    if (i == paramInt) {
      if (localGameObject3 != null)
      {
        GameObject localGameObject2 = this._list.getItemUI(i, localGameObject3, this);
        localGameObject1 = localGameObject2;
        if (localGameObject2 != localGameObject3)
        {
          this._cache.setValueAt(this._cache.indexOfKey(i), localGameObject2);
          localGameObject1 = localGameObject2;
        }
        label100:
        if (!paramBoolean) {
          break label166;
        }
        localGameObject1.selected = true;
        label110:
        this._scrollY = j;
      }
    }
    for (;;)
    {
      j += this._list.getItemHeight(i);
      i += 1;
      break;
      localGameObject1 = this._list.getItemUI(i, null, this);
      this._cache.put(i, localGameObject1);
      break label100;
      label166:
      localGameObject1.selected = false;
      break label110;
      if (localGameObject3 != null) {
        if (paramBoolean) {
          localGameObject3.selected = false;
        } else {
          localGameObject3.selected = false;
        }
      }
    }
  }
  
  public void setScroll(float paramFloat)
  {
    this._velocity = 0.0F;
    this._scrollY = paramFloat;
  }
  
  public void setSlideBar(GameObject paramGameObject)
  {
    this._scrollBar = paramGameObject;
  }
  
  public void setUnits(int paramInt)
  {
    this._units = paramInt;
  }
  
  public void stopScrolling()
  {
    this._scrolling = false;
    this._velocity = 0.0F;
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(int paramInt, UIList paramUIList);
  }
  
  public static abstract interface OnScrollListener
  {
    public abstract void onScrollStateChanged(UIList paramUIList, int paramInt);
  }
  
  public static abstract interface UIAdapter
  {
    public abstract int getCount();
    
    public abstract Object getItem(int paramInt);
    
    public abstract int getItemHeight(int paramInt);
    
    public abstract long getItemId(int paramInt);
    
    public abstract GameObject getItemUI(int paramInt, GameObject paramGameObject, UIList paramUIList);
    
    public abstract int getItemWidth(int paramInt);
    
    public abstract int getMaxHeight();
  }
  
  public static class UISlideBar
    extends GameObject
  {
    private int c;
    private Paint p;
    
    public UISlideBar()
    {
      this.c = 0;
      this.p = new Paint();
      this.p.setColor(-1);
    }
    
    public UISlideBar(int paramInt)
    {
      this.p = new Paint();
      this.p.setColor(0);
    }
    
    public int getColor()
    {
      return this.p.getColor();
    }
    
    public int getCorner()
    {
      return this.c;
    }
    
    public void onAction() {}
    
    public void onRender()
    {
      if (!this.visible) {
        return;
      }
      if (this.c != 0)
      {
        Game.drawRoundRect((int)this.x, (int)this.y, this.w, this.h, this.c, this.p);
        return;
      }
      Game.drawBox((int)this.x, (int)this.y, (int)this.x + this.w, (int)this.y + this.h, this.p);
    }
    
    public void setColor(int paramInt)
    {
      this.p.setColor(paramInt);
    }
    
    public void setCorner(int paramInt)
    {
      this.c = paramInt;
    }
  }
  
  public static class UISlideBarBitmap
    extends GameObject
  {
    private Bitmap b;
    
    public UISlideBarBitmap()
    {
      this.b = null;
    }
    
    public UISlideBarBitmap(int paramInt)
    {
      this.b = Game.getBitmap(paramInt);
      if (this.b != null)
      {
        this.w = this.b.getWidth();
        this.h = this.b.getHeight();
      }
    }
    
    public UISlideBarBitmap(Bitmap paramBitmap)
    {
      this.b = paramBitmap;
      if (paramBitmap != null)
      {
        this.w = paramBitmap.getWidth();
        this.h = paramBitmap.getHeight();
      }
    }
    
    public Bitmap getBitmap()
    {
      return this.b;
    }
    
    public void onAction() {}
    
    public void onRender()
    {
      if ((!this.visible) || (this.b == null)) {
        return;
      }
      Game.drawBitmap(this.b, this.x, this.y);
    }
    
    public void setBitmap(Bitmap paramBitmap)
    {
      this.b = paramBitmap;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ui/UIList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */