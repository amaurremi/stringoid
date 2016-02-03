package org.osmdroid.views.overlay;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import java.util.ArrayList;
import org.osmdroid.ResourceProxy;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.safecanvas.ISafeCanvas;
import org.osmdroid.views.safecanvas.ISafeCanvas.UnsafeCanvasHandler;

public abstract class ItemizedOverlay<Item extends OverlayItem>
  extends SafeDrawOverlay
  implements Overlay.Snappable
{
  private final Point mCurScreenCoords = new Point();
  protected final Drawable mDefaultMarker;
  protected boolean mDrawFocusedItem = true;
  private Item mFocusedItem;
  private final ArrayList<Item> mInternalItemList;
  private OnFocusChangeListener mOnFocusChangeListener;
  private boolean mPendingFocusChangedEvent = false;
  private final Rect mRect = new Rect();
  
  public ItemizedOverlay(Drawable paramDrawable, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    if (paramDrawable == null) {
      throw new IllegalArgumentException("You must pass a default marker to ItemizedOverlay.");
    }
    this.mDefaultMarker = paramDrawable;
    this.mInternalItemList = new ArrayList();
  }
  
  protected Drawable boundToHotspot(Drawable paramDrawable, OverlayItem.HotspotPlace paramHotspotPlace)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = paramDrawable.getIntrinsicWidth();
        j = paramDrawable.getIntrinsicHeight();
        this.mRect.set(0, 0, i + 0, j + 0);
        OverlayItem.HotspotPlace localHotspotPlace = paramHotspotPlace;
        if (paramHotspotPlace == null) {
          localHotspotPlace = OverlayItem.HotspotPlace.BOTTOM_CENTER;
        }
        switch (localHotspotPlace)
        {
        case ???: 
          paramDrawable.setBounds(this.mRect);
          return paramDrawable;
        }
      }
      finally {}
      this.mRect.offset(-i / 2, -j / 2);
      continue;
      this.mRect.offset(-i / 2, -j);
      continue;
      this.mRect.offset(-i / 2, 0);
      continue;
      this.mRect.offset(-i, -j / 2);
      continue;
      this.mRect.offset(0, -j / 2);
      continue;
      this.mRect.offset(-i, 0);
      continue;
      this.mRect.offset(-i, -j);
      continue;
      this.mRect.offset(0, 0);
      continue;
      this.mRect.offset(0, -j);
    }
  }
  
  protected abstract Item createItem(int paramInt);
  
  protected void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      return;
      if ((this.mPendingFocusChangedEvent) && (this.mOnFocusChangeListener != null)) {
        this.mOnFocusChangeListener.onFocusChanged(this, this.mFocusedItem);
      }
      this.mPendingFocusChangedEvent = false;
      MapView.Projection localProjection = paramMapView.getProjection();
      int i = this.mInternalItemList.size() - 1;
      while (i >= 0)
      {
        OverlayItem localOverlayItem = getItem(i);
        localProjection.toMapPixels(localOverlayItem.getPoint(), this.mCurScreenCoords);
        onDrawItem(paramISafeCanvas, localOverlayItem, this.mCurScreenCoords, paramMapView.getMapOrientation(), paramMapView.mMultiTouchScale);
        i -= 1;
      }
    }
  }
  
  protected Drawable getDefaultMarker(int paramInt)
  {
    OverlayItem.setState(this.mDefaultMarker, paramInt);
    return this.mDefaultMarker;
  }
  
  public Item getFocus()
  {
    return this.mFocusedItem;
  }
  
  public final Item getItem(int paramInt)
  {
    return (OverlayItem)this.mInternalItemList.get(paramInt);
  }
  
  protected boolean hitTest(Item paramItem, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    return paramDrawable.getBounds().contains(paramInt1, paramInt2);
  }
  
  protected void onDrawItem(ISafeCanvas paramISafeCanvas, Item paramItem, final Point paramPoint, final float paramFloat1, float paramFloat2)
  {
    int i;
    if ((this.mDrawFocusedItem) && (this.mFocusedItem == paramItem))
    {
      i = 4;
      if (paramItem.getMarker(i) != null) {
        break label146;
      }
    }
    label146:
    for (final Drawable localDrawable = getDefaultMarker(i);; localDrawable = paramItem.getMarker(i))
    {
      boundToHotspot(localDrawable, paramItem.getMarkerHotspot());
      paramItem = localDrawable.getBounds();
      paramItem.left = ((int)(paramItem.left / paramFloat2));
      paramItem.top = ((int)(paramItem.top / paramFloat2));
      paramItem.right = ((int)(paramItem.right / paramFloat2));
      paramItem.bottom = ((int)(paramItem.bottom / paramFloat2));
      localDrawable.setBounds(paramItem);
      if (!isUsingSafeCanvas()) {
        break label157;
      }
      Overlay.drawAt(paramISafeCanvas.getSafeCanvas(), localDrawable, paramPoint.x, paramPoint.y, false, paramFloat1);
      return;
      i = 0;
      break;
    }
    label157:
    paramISafeCanvas.getUnsafeCanvas(new ISafeCanvas.UnsafeCanvasHandler()
    {
      public void onUnsafeCanvas(Canvas paramAnonymousCanvas)
      {
        Overlay.drawAt(paramAnonymousCanvas, localDrawable, paramPoint.x, paramPoint.y, false, paramFloat1);
      }
    });
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    MapView.Projection localProjection = paramMapView.getProjection();
    Rect localRect = localProjection.getIntrinsicScreenRect();
    int k = size();
    int i = 0;
    while (i < k)
    {
      OverlayItem localOverlayItem = getItem(i);
      localProjection.toMapPixels(localOverlayItem.getPoint(), this.mCurScreenCoords);
      int j;
      if ((this.mDrawFocusedItem) && (this.mFocusedItem == localOverlayItem))
      {
        j = 4;
        if (localOverlayItem.getMarker(j) != null) {
          break label165;
        }
      }
      label165:
      for (Drawable localDrawable = getDefaultMarker(j);; localDrawable = localOverlayItem.getMarker(j))
      {
        boundToHotspot(localDrawable, localOverlayItem.getMarkerHotspot());
        if ((!hitTest(localOverlayItem, localDrawable, -this.mCurScreenCoords.x + localRect.left + (int)paramMotionEvent.getX(), -this.mCurScreenCoords.y + localRect.top + (int)paramMotionEvent.getY())) || (!onTap(i))) {
          break label177;
        }
        return true;
        j = 0;
        break;
      }
      label177:
      i += 1;
    }
    return super.onSingleTapConfirmed(paramMotionEvent, paramMapView);
  }
  
  protected boolean onTap(int paramInt)
  {
    return false;
  }
  
  protected final void populate()
  {
    int j = size();
    this.mInternalItemList.clear();
    this.mInternalItemList.ensureCapacity(j);
    int i = 0;
    while (i < j)
    {
      this.mInternalItemList.add(createItem(i));
      i += 1;
    }
  }
  
  public void setDrawFocusedItem(boolean paramBoolean)
  {
    this.mDrawFocusedItem = paramBoolean;
  }
  
  public void setFocus(Item paramItem)
  {
    if (paramItem != this.mFocusedItem) {}
    for (boolean bool = true;; bool = false)
    {
      this.mPendingFocusChangedEvent = bool;
      this.mFocusedItem = paramItem;
      return;
    }
  }
  
  public void setOnFocusChangeListener(OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mOnFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public abstract int size();
  
  public static abstract interface OnFocusChangeListener
  {
    public abstract void onFocusChanged(ItemizedOverlay<?> paramItemizedOverlay, OverlayItem paramOverlayItem);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/ItemizedOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */