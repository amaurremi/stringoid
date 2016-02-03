package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import java.util.List;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.api.IMapView;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;

public class ItemizedIconOverlay<Item extends OverlayItem>
  extends ItemizedOverlay<Item>
{
  private int mDrawnItemsLimit = Integer.MAX_VALUE;
  protected final List<Item> mItemList;
  private final Point mItemPoint = new Point();
  protected OnItemGestureListener<Item> mOnItemGestureListener;
  private final Point mTouchScreenPoint = new Point();
  
  public ItemizedIconOverlay(Context paramContext, List<Item> paramList, OnItemGestureListener<Item> paramOnItemGestureListener)
  {
    this(paramList, new DefaultResourceProxyImpl(paramContext).getDrawable(ResourceProxy.bitmap.marker_default), paramOnItemGestureListener, new DefaultResourceProxyImpl(paramContext));
  }
  
  public ItemizedIconOverlay(List<Item> paramList, Drawable paramDrawable, OnItemGestureListener<Item> paramOnItemGestureListener, ResourceProxy paramResourceProxy)
  {
    super(paramDrawable, paramResourceProxy);
    this.mItemList = paramList;
    this.mOnItemGestureListener = paramOnItemGestureListener;
    populate();
  }
  
  public ItemizedIconOverlay(List<Item> paramList, OnItemGestureListener<Item> paramOnItemGestureListener, ResourceProxy paramResourceProxy)
  {
    this(paramList, paramResourceProxy.getDrawable(ResourceProxy.bitmap.marker_default), paramOnItemGestureListener, paramResourceProxy);
  }
  
  private boolean activateSelectedItems(MotionEvent paramMotionEvent, MapView paramMapView, ActiveItem paramActiveItem)
  {
    boolean bool2 = false;
    paramMapView = paramMapView.getProjection();
    paramMapView.fromMapPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.mTouchScreenPoint);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      OverlayItem localOverlayItem;
      if (i < this.mItemList.size())
      {
        localOverlayItem = getItem(i);
        if (localOverlayItem.getMarker(0) != null) {
          break label149;
        }
      }
      label149:
      for (paramMotionEvent = this.mDefaultMarker;; paramMotionEvent = localOverlayItem.getMarker(0))
      {
        paramMapView.toPixels(localOverlayItem.getPoint(), this.mItemPoint);
        if (!hitTest(localOverlayItem, paramMotionEvent, this.mTouchScreenPoint.x - this.mItemPoint.x, this.mTouchScreenPoint.y - this.mItemPoint.y)) {
          break;
        }
        Log.v("OSM", "ItemizedIconOverlay was hit");
        if (!paramActiveItem.run(i)) {
          break;
        }
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public void addItem(int paramInt, Item paramItem)
  {
    this.mItemList.add(paramInt, paramItem);
    populate();
  }
  
  public boolean addItem(Item paramItem)
  {
    boolean bool = this.mItemList.add(paramItem);
    populate();
    return bool;
  }
  
  public boolean addItems(List<Item> paramList)
  {
    boolean bool = this.mItemList.addAll(paramList);
    populate();
    return bool;
  }
  
  protected Item createItem(int paramInt)
  {
    return (OverlayItem)this.mItemList.get(paramInt);
  }
  
  public int getDrawnItemsLimit()
  {
    return this.mDrawnItemsLimit;
  }
  
  public boolean onLongPress(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if (activateSelectedItems(paramMotionEvent, paramMapView, new ActiveItem()
    {
      public boolean run(int paramAnonymousInt)
      {
        if (ItemizedIconOverlay.this.mOnItemGestureListener == null) {
          return false;
        }
        return ItemizedIconOverlay.this.onLongPressHelper(paramAnonymousInt, ItemizedIconOverlay.this.getItem(paramAnonymousInt));
      }
    })) {
      return true;
    }
    return super.onLongPress(paramMotionEvent, paramMapView);
  }
  
  protected boolean onLongPressHelper(int paramInt, Item paramItem)
  {
    return this.mOnItemGestureListener.onItemLongPress(paramInt, paramItem);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent, final MapView paramMapView)
  {
    if (activateSelectedItems(paramMotionEvent, paramMapView, new ActiveItem()
    {
      public boolean run(int paramAnonymousInt)
      {
        ItemizedIconOverlay localItemizedIconOverlay = ItemizedIconOverlay.this;
        if (localItemizedIconOverlay.mOnItemGestureListener == null) {
          return false;
        }
        return ItemizedIconOverlay.this.onSingleTapUpHelper(paramAnonymousInt, (OverlayItem)localItemizedIconOverlay.mItemList.get(paramAnonymousInt), paramMapView);
      }
    })) {
      return true;
    }
    return super.onSingleTapConfirmed(paramMotionEvent, paramMapView);
  }
  
  protected boolean onSingleTapUpHelper(int paramInt, Item paramItem, MapView paramMapView)
  {
    return this.mOnItemGestureListener.onItemSingleTapUp(paramInt, paramItem);
  }
  
  public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, IMapView paramIMapView)
  {
    return false;
  }
  
  public void removeAllItems()
  {
    removeAllItems(true);
  }
  
  public void removeAllItems(boolean paramBoolean)
  {
    this.mItemList.clear();
    if (paramBoolean) {
      populate();
    }
  }
  
  public Item removeItem(int paramInt)
  {
    OverlayItem localOverlayItem = (OverlayItem)this.mItemList.remove(paramInt);
    populate();
    return localOverlayItem;
  }
  
  public boolean removeItem(Item paramItem)
  {
    boolean bool = this.mItemList.remove(paramItem);
    populate();
    return bool;
  }
  
  public void setDrawnItemsLimit(int paramInt)
  {
    this.mDrawnItemsLimit = paramInt;
  }
  
  public int size()
  {
    return Math.min(this.mItemList.size(), this.mDrawnItemsLimit);
  }
  
  public static abstract interface ActiveItem
  {
    public abstract boolean run(int paramInt);
  }
  
  public static abstract interface OnItemGestureListener<T>
  {
    public abstract boolean onItemLongPress(int paramInt, T paramT);
    
    public abstract boolean onItemSingleTapUp(int paramInt, T paramT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/ItemizedIconOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */