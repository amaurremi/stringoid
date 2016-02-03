package com.mapbar.android.maps;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ItemizedOverlay<Item extends OverlayItem>
  extends Overlay
  implements Overlay.Snappable
{
  private static final int o = ViewConfiguration.getTouchSlop() << 2;
  private int[] a = null;
  private ArrayList<Item> b = null;
  private int c;
  private int d;
  private final Drawable e;
  private OnFocusChangeListener f;
  private boolean g = true;
  private int[] h;
  private int i = -1;
  private Item j = null;
  private int k;
  private int l;
  private int m;
  protected int mLastFocusedIndex = -1;
  private final Rect n = new Rect();
  private final Point p = new Point();
  
  public ItemizedOverlay(Drawable paramDrawable)
  {
    this.e = paramDrawable;
  }
  
  protected static Drawable boundCenter(Drawable paramDrawable)
  {
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = i1 / 2;
    int i3 = paramDrawable.getIntrinsicHeight();
    int i4 = i3 / 2;
    paramDrawable.setBounds(-i2, -i4, i1 - i2, i3 - i4);
    return paramDrawable;
  }
  
  protected static Drawable boundCenterBottom(Drawable paramDrawable)
  {
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = i1 / 2;
    int i3 = paramDrawable.getIntrinsicHeight();
    paramDrawable.setBounds(-i2, 1 - i3, i1 - i2, 1);
    return paramDrawable;
  }
  
  private void drawItem(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, int paramInt)
  {
    OverlayItem localOverlayItem = getItem(paramInt);
    Drawable localDrawable = getDrawable(localOverlayItem, paramInt);
    paramMapView.getProjection().toPixels(localOverlayItem.getPoint(), this.p);
    drawAt(paramCanvas, localDrawable, this.p.x, this.p.y, paramBoolean);
  }
  
  private void focus(int paramInt)
  {
    if (paramInt != -1) {}
    for (OverlayItem localOverlayItem = getItem(paramInt);; localOverlayItem = null)
    {
      setFocus(paramInt, localOverlayItem);
      return;
    }
  }
  
  private Drawable getDrawable(Item paramItem, int paramInt)
  {
    paramInt = this.h[paramInt];
    Drawable localDrawable = paramItem.getMarker(paramInt);
    paramItem = localDrawable;
    if (localDrawable == null)
    {
      paramItem = this.e;
      OverlayItem.setState(paramItem, paramInt);
    }
    return paramItem;
  }
  
  private int getItemAtLocation(int paramInt1, int paramInt2, MapView paramMapView)
  {
    Iterator localIterator = getItemsAtLocation(paramInt1, paramInt2, paramMapView).iterator();
    int i1 = -1;
    int i2 = Integer.MAX_VALUE;
    int i3;
    if (localIterator.hasNext())
    {
      i3 = ((Integer)localIterator.next()).intValue();
      if (i3 >= this.b.size()) {
        break label202;
      }
      Object localObject = (OverlayItem)this.b.get(i3);
      paramMapView.getProjection().toPixels(((OverlayItem)localObject).getPoint(), this.p);
      int i5 = this.p.x;
      int i4 = this.p.y;
      localObject = getTouchableBounds(getDrawable((OverlayItem)localObject, i3).getBounds());
      i5 = ((Rect)localObject).centerX() - (paramInt1 - i5);
      i4 = ((Rect)localObject).centerY() - (paramInt2 - i4);
      i4 = i4 * i4 + i5 * i5;
      if (i4 >= i2) {
        break label202;
      }
      i2 = i3;
      i1 = i4;
    }
    for (;;)
    {
      i3 = i2;
      i2 = i1;
      i1 = i3;
      break;
      this.i = i1;
      return this.i;
      label202:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  private ArrayList<Integer> getItemsAtLocation(int paramInt1, int paramInt2, MapView paramMapView)
  {
    ArrayList localArrayList1 = this.b;
    int[] arrayOfInt = this.a;
    int i1 = arrayOfInt.length;
    ArrayList localArrayList2 = new ArrayList(i1);
    i1 -= 1;
    while (i1 >= 0)
    {
      int i2 = arrayOfInt[i1];
      int i3 = this.h[i2];
      if (((this.g) || ((i3 & 0x4) == 0)) && (i2 < localArrayList1.size()))
      {
        OverlayItem localOverlayItem = (OverlayItem)localArrayList1.get(i2);
        paramMapView.getProjection().toPixels(localOverlayItem.getPoint(), this.p);
        i3 = this.p.x;
        int i4 = this.p.y;
        if (hitTest(localOverlayItem, getDrawable(localOverlayItem, i2), paramInt1 - i3, paramInt2 - i4)) {
          localArrayList2.add(Integer.valueOf(i2));
        }
      }
      i1 -= 1;
    }
    return localArrayList2;
  }
  
  private Rect getTouchableBounds(Rect paramRect)
  {
    int i2 = paramRect.width();
    int i3 = paramRect.height();
    if ((i2 >= o) && (i3 >= o)) {
      return paramRect;
    }
    int i4 = paramRect.centerX();
    int i1 = paramRect.centerY();
    i2 = Math.max(o, i2);
    i4 -= i2 / 2;
    i3 = Math.max(o, i3);
    i1 -= i3 / 2;
    this.n.set(i4, i1, i2 + i4, i3 + i1);
    return this.n;
  }
  
  private boolean handleMotionEvent(boolean paramBoolean, int paramInt1, MotionEvent paramMotionEvent, MapView paramMapView, int paramInt2, int paramInt3)
  {
    int i4 = paramMotionEvent.getAction();
    int i2;
    int i1;
    label28:
    int i3;
    if (i4 == 0)
    {
      i2 = 1;
      if ((i2 == 0) && (i4 != 2)) {
        break label129;
      }
      i1 = 1;
      i3 = getItemAtLocation(paramInt2, paramInt3, paramMapView);
      if (i3 == -1) {
        break label135;
      }
      paramInt2 = 1;
      label49:
      if (!paramBoolean) {
        break label141;
      }
      paramInt3 = i3;
      label57:
      select(paramInt3);
      if (i2 != 0)
      {
        if (paramInt2 == 0) {
          break label147;
        }
        this.m |= paramInt1;
      }
      label83:
      if ((this.m & paramInt1) == 0) {
        break label162;
      }
      paramInt2 = 1;
      label95:
      if (paramInt2 != 0)
      {
        if (i1 == 0) {
          break label168;
        }
        press(i3);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 0) || (paramInt1 == 2)) {
        break label206;
      }
      return true;
      i2 = 0;
      break;
      label129:
      i1 = 0;
      break label28;
      label135:
      paramInt2 = 0;
      break label49;
      label141:
      paramInt3 = -1;
      break label57;
      label147:
      this.m &= (paramInt1 ^ 0xFFFFFFFF);
      break label83;
      label162:
      paramInt2 = 0;
      break label95;
      label168:
      if (i4 == 1)
      {
        press(-1);
        this.m &= (paramInt1 ^ 0xFFFFFFFF);
        if (paramInt1 != 2) {
          onTap(i3);
        }
      }
    }
    label206:
    return false;
  }
  
  private int maskHelper(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == paramInt2) || (paramInt1 != -1)) {}
    try
    {
      arrayOfInt = this.h;
      arrayOfInt[paramInt1] &= (paramInt3 ^ 0xFFFFFFFF);
    }
    catch (Exception localException2)
    {
      int[] arrayOfInt;
      for (;;) {}
    }
    if (paramInt2 != -1) {}
    try
    {
      arrayOfInt = this.h;
      arrayOfInt[paramInt2] |= paramInt3;
      return paramInt2;
    }
    catch (Exception localException1)
    {
      return paramInt2;
    }
  }
  
  private void press(int paramInt)
  {
    this.k = maskHelper(this.k, paramInt, 1);
  }
  
  private void select(int paramInt)
  {
    this.l = maskHelper(this.l, paramInt, 2);
  }
  
  private void setFocus(int paramInt, Item paramItem)
  {
    if ((this.j != paramItem) && (this.f != null)) {}
    for (int i1 = 1;; i1 = 0)
    {
      maskHelper(this.mLastFocusedIndex, paramInt, 4);
      if (paramInt != -1) {
        this.mLastFocusedIndex = paramInt;
      }
      this.j = paramItem;
      if (i1 != 0) {
        this.f.onFocusChanged(this, paramItem);
      }
      return;
    }
  }
  
  protected abstract Item createItem(int paramInt);
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    int i4 = size();
    int i1 = 0;
    int i2 = -1;
    if (i1 < i4)
    {
      int i3 = getIndexToDraw(i1);
      if ((this.h[i3] & 0x4) == 0) {
        drawItem(paramCanvas, paramMapView, paramBoolean, i3);
      }
      for (;;)
      {
        i1 += 1;
        break;
        i2 = i3;
      }
    }
    if ((this.g) && (i2 >= 0)) {
      drawItem(paramCanvas, paramMapView, paramBoolean, i2);
    }
  }
  
  public GeoPoint getCenter()
  {
    if (this.a.length > 0) {
      return getItem(0).getPoint();
    }
    return null;
  }
  
  public Item getFocus()
  {
    return this.j;
  }
  
  protected int getIndexToDraw(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public final Item getItem(int paramInt)
  {
    OverlayItem localOverlayItem = null;
    if (paramInt < this.b.size()) {
      localOverlayItem = (OverlayItem)this.b.get(paramInt);
    }
    return localOverlayItem;
  }
  
  public final int getLastFocusedIndex()
  {
    return this.mLastFocusedIndex;
  }
  
  public int getLatSpanE6()
  {
    return this.c;
  }
  
  public int getLonSpanE6()
  {
    return this.d;
  }
  
  protected boolean hitTest(Item paramItem, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    return getTouchableBounds(paramDrawable.getBounds()).contains(paramInt1, paramInt2);
  }
  
  public Item nextFocus(boolean paramBoolean)
  {
    int i2 = this.mLastFocusedIndex;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      i1 += i2;
      if ((i1 < 0) || (i1 >= this.a.length)) {
        break;
      }
      return getItem(i1);
    }
    return null;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.onKeyUp(paramInt, paramKeyEvent, paramMapView);
    } while (getFocus() == null);
    return onTap(this.mLastFocusedIndex);
  }
  
  public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView)
  {
    paramInt1 = getItemAtLocation(paramInt1, paramInt2, paramMapView);
    if (paramInt1 == -1) {}
    while (paramInt1 >= this.b.size()) {
      return false;
    }
    OverlayItem localOverlayItem = (OverlayItem)this.b.get(paramInt1);
    paramMapView.getProjection().toPixels(localOverlayItem.getPoint(), paramPoint);
    return true;
  }
  
  protected boolean onTap(int paramInt)
  {
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    paramMapView.getProjection().toPixels(paramGeoPoint, this.p);
    int i1 = getItemAtLocation(this.p.x, this.p.y, paramMapView);
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 != -1) {}
    try
    {
      bool1 = onTap(i1);
      bool2 = bool1;
      focus(i1);
      bool2 = bool1;
      select(i1);
      return bool1;
    }
    catch (Exception paramGeoPoint) {}
    return bool2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return handleMotionEvent(false, 2, paramMotionEvent, paramMapView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return handleMotionEvent(true, 1, paramMotionEvent, paramMapView, paramMapView.getWidth() / 2, paramMapView.getHeight() / 2);
  }
  
  protected final void populate()
  {
    int i6 = size();
    ArrayList localArrayList = new ArrayList(i6);
    int i5 = 90000000;
    int i4 = -90000000;
    int i3 = 180000000;
    int i2 = -180000000;
    int i1 = 0;
    while (i1 < i6)
    {
      localObject = createItem(i1);
      localArrayList.add(localObject);
      localObject = ((OverlayItem)localObject).getPoint();
      i5 = Math.min(i5, ((GeoPoint)localObject).getLatitudeE6());
      i4 = Math.max(i4, ((GeoPoint)localObject).getLatitudeE6());
      i3 = Math.min(i3, ((GeoPoint)localObject).getLongitudeE6());
      i2 = Math.max(i2, ((GeoPoint)localObject).getLongitudeE6());
      i1 += 1;
    }
    this.c = (i4 - i5);
    this.d = (i2 - i3);
    Object localObject = new int[i6];
    i1 = 0;
    if (i1 < i6)
    {
      i2 = i1;
      i3 = 0;
      label150:
      if (i3 <= i1)
      {
        OverlayItem localOverlayItem = (OverlayItem)localArrayList.get(localObject[i3]);
        if ((i3 != i1) && (localOverlayItem.getPoint().getLatitudeE6() >= ((OverlayItem)localArrayList.get(i1)).getPoint().getLatitudeE6())) {
          break label264;
        }
        i4 = localObject[i3];
        localObject[i3] = i2;
        i2 = i4;
      }
    }
    label264:
    for (;;)
    {
      i3 += 1;
      break label150;
      i1 += 1;
      break;
      this.a = ((int[])localObject);
      this.b = localArrayList;
      this.h = new int[i6];
      this.l = -1;
      this.k = -1;
      this.m = 0;
      return;
    }
  }
  
  public void setDrawFocusedItem(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setFocus(Item paramItem)
  {
    if (paramItem == null) {
      setFocus(this.mLastFocusedIndex, null);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      int i1 = 0;
      while (localIterator.hasNext())
      {
        if ((OverlayItem)localIterator.next() == paramItem)
        {
          setFocus(i1, paramItem);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  protected void setLastFocusedIndex(int paramInt)
  {
    this.mLastFocusedIndex = paramInt;
  }
  
  public void setOnFocusChangeListener(OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.f = paramOnFocusChangeListener;
  }
  
  public abstract int size();
  
  public static abstract interface OnFocusChangeListener
  {
    public abstract void onFocusChanged(ItemizedOverlay paramItemizedOverlay, OverlayItem paramOverlayItem);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/ItemizedOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */