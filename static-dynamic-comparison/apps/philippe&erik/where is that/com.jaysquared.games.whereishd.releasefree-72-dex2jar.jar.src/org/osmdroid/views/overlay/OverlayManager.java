package org.osmdroid.views.overlay;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.osmdroid.api.IMapView;
import org.osmdroid.views.MapView;

public class OverlayManager
  extends AbstractList<Overlay>
{
  private final CopyOnWriteArrayList<Overlay> mOverlayList;
  private TilesOverlay mTilesOverlay;
  private boolean mUseSafeCanvas = true;
  
  public OverlayManager(TilesOverlay paramTilesOverlay)
  {
    setTilesOverlay(paramTilesOverlay);
    this.mOverlayList = new CopyOnWriteArrayList();
  }
  
  public void add(int paramInt, Overlay paramOverlay)
  {
    this.mOverlayList.add(paramInt, paramOverlay);
    if ((paramOverlay instanceof SafeDrawOverlay)) {
      ((SafeDrawOverlay)paramOverlay).setUseSafeCanvas(isUsingSafeCanvas());
    }
  }
  
  public Overlay get(int paramInt)
  {
    return (Overlay)this.mOverlayList.get(paramInt);
  }
  
  public TilesOverlay getTilesOverlay()
  {
    return this.mTilesOverlay;
  }
  
  public boolean isUsingSafeCanvas()
  {
    return this.mUseSafeCanvas;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    boolean bool1 = true;
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Overlay)localIterator.next();
      if ((localObject instanceof IOverlayMenuProvider))
      {
        localObject = (IOverlayMenuProvider)localObject;
        if (((IOverlayMenuProvider)localObject).isOptionsMenuEnabled()) {
          bool1 &= ((IOverlayMenuProvider)localObject).onCreateOptionsMenu(paramMenu, paramInt, paramMapView);
        }
      }
    }
    boolean bool2 = bool1;
    if (this.mTilesOverlay != null)
    {
      bool2 = bool1;
      if (this.mTilesOverlay.isOptionsMenuEnabled()) {
        bool2 = bool1 & this.mTilesOverlay.onCreateOptionsMenu(paramMenu, paramInt, paramMapView);
      }
    }
    return bool2;
  }
  
  public void onDetach(MapView paramMapView)
  {
    if (this.mTilesOverlay != null) {
      this.mTilesOverlay.onDetach(paramMapView);
    }
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      ((Overlay)localIterator.next()).onDetach(paramMapView);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onDoubleTap(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onDoubleTapEvent(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onDown(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public void onDraw(Canvas paramCanvas, MapView paramMapView)
  {
    if ((this.mTilesOverlay != null) && (this.mTilesOverlay.isEnabled())) {
      this.mTilesOverlay.draw(paramCanvas, paramMapView, true);
    }
    if ((this.mTilesOverlay != null) && (this.mTilesOverlay.isEnabled())) {
      this.mTilesOverlay.draw(paramCanvas, paramMapView, false);
    }
    Iterator localIterator = this.mOverlayList.iterator();
    Overlay localOverlay;
    while (localIterator.hasNext())
    {
      localOverlay = (Overlay)localIterator.next();
      if (localOverlay.isEnabled()) {
        localOverlay.draw(paramCanvas, paramMapView, true);
      }
    }
    localIterator = this.mOverlayList.iterator();
    while (localIterator.hasNext())
    {
      localOverlay = (Overlay)localIterator.next();
      if (localOverlay.isEnabled()) {
        localOverlay.draw(paramCanvas, paramMapView, false);
      }
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onKeyDown(paramInt, paramKeyEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onKeyUp(paramInt, paramKeyEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onLongPress(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onLongPress(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem, int paramInt, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Overlay)localIterator.next();
      } while (!(localObject instanceof IOverlayMenuProvider));
      localObject = (IOverlayMenuProvider)localObject;
    } while ((!((IOverlayMenuProvider)localObject).isOptionsMenuEnabled()) || (!((IOverlayMenuProvider)localObject).onOptionsItemSelected(paramMenuItem, paramInt, paramMapView)));
    while ((this.mTilesOverlay != null) && (this.mTilesOverlay.isOptionsMenuEnabled()) && (this.mTilesOverlay.onOptionsItemSelected(paramMenuItem, paramInt, paramMapView)))
    {
      Object localObject;
      return true;
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Overlay)localIterator.next();
      if ((localObject instanceof IOverlayMenuProvider))
      {
        localObject = (IOverlayMenuProvider)localObject;
        if (((IOverlayMenuProvider)localObject).isOptionsMenuEnabled()) {
          ((IOverlayMenuProvider)localObject).onPrepareOptionsMenu(paramMenu, paramInt, paramMapView);
        }
      }
    }
    if ((this.mTilesOverlay != null) && (this.mTilesOverlay.isOptionsMenuEnabled())) {
      this.mTilesOverlay.onPrepareOptionsMenu(paramMenu, paramInt, paramMapView);
    }
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      ((Overlay)localIterator.next()).onShowPress(paramMotionEvent, paramMapView);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onSingleTapConfirmed(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onSingleTapUp(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, IMapView paramIMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if (((localOverlay instanceof Overlay.Snappable)) && (((Overlay.Snappable)localOverlay).onSnapToItem(paramInt1, paramInt2, paramPoint, paramIMapView))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onTouchEvent(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    Iterator localIterator = overlaysReversed().iterator();
    while (localIterator.hasNext()) {
      if (((Overlay)localIterator.next()).onTrackballEvent(paramMotionEvent, paramMapView)) {
        return true;
      }
    }
    return false;
  }
  
  public Iterable<Overlay> overlaysReversed()
  {
    new Iterable()
    {
      public Iterator<Overlay> iterator()
      {
        new Iterator()
        {
          public boolean hasNext()
          {
            return this.val$i.hasPrevious();
          }
          
          public Overlay next()
          {
            return (Overlay)this.val$i.previous();
          }
          
          public void remove()
          {
            this.val$i.remove();
          }
        };
      }
    };
  }
  
  public Overlay remove(int paramInt)
  {
    return (Overlay)this.mOverlayList.remove(paramInt);
  }
  
  public Overlay set(int paramInt, Overlay paramOverlay)
  {
    Overlay localOverlay = (Overlay)this.mOverlayList.set(paramInt, paramOverlay);
    if ((paramOverlay instanceof SafeDrawOverlay)) {
      ((SafeDrawOverlay)paramOverlay).setUseSafeCanvas(isUsingSafeCanvas());
    }
    return localOverlay;
  }
  
  public void setOptionsMenusEnabled(boolean paramBoolean)
  {
    Iterator localIterator = this.mOverlayList.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if (((localOverlay instanceof IOverlayMenuProvider)) && (((IOverlayMenuProvider)localOverlay).isOptionsMenuEnabled())) {
        ((IOverlayMenuProvider)localOverlay).setOptionsMenuEnabled(paramBoolean);
      }
    }
  }
  
  public void setTilesOverlay(TilesOverlay paramTilesOverlay)
  {
    this.mTilesOverlay = paramTilesOverlay;
    if (this.mTilesOverlay != null) {
      this.mTilesOverlay.setUseSafeCanvas(isUsingSafeCanvas());
    }
  }
  
  public void setUseSafeCanvas(boolean paramBoolean)
  {
    this.mUseSafeCanvas = paramBoolean;
    Iterator localIterator = this.mOverlayList.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof SafeDrawOverlay)) {
        ((SafeDrawOverlay)localOverlay).setUseSafeCanvas(isUsingSafeCanvas());
      }
    }
    if (this.mTilesOverlay != null) {
      this.mTilesOverlay.setUseSafeCanvas(isUsingSafeCanvas());
    }
  }
  
  public int size()
  {
    return this.mOverlayList.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/OverlayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */