package org.osmdroid.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.Scroller;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.views.util.MyMath;
import org.osmdroid.views.util.constants.MapViewConstants;

public class MapController
  implements IMapController, MapViewConstants
{
  private static final String LOG_TAG = MapController.class.getSimpleName();
  private float legacyTargetScale = 1.0F;
  private Animator mCurrentAnimator;
  protected final MapView mMapView;
  private ValueAnimator mZoomInAnimation;
  private ScaleAnimation mZoomInAnimationOld;
  private ValueAnimator mZoomOutAnimation;
  private ScaleAnimation mZoomOutAnimationOld;
  private IGeoPoint zoomAnimationFocusGeoPoint;
  private PointF zoomAnimationFocusPointScreen = new PointF(0.0F, 0.0F);
  
  public MapController(MapView paramMapView)
  {
    this.mMapView = paramMapView;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.mZoomInAnimation = ValueAnimator.ofFloat(new float[] { 1.0F, 2.0F });
      this.mZoomInAnimation.addListener(new MyZoomAnimatorListener());
      this.mZoomInAnimation.addUpdateListener(new MyZoomAnimatorUpdateListener());
      this.mZoomInAnimation.setDuration(500L);
      this.mZoomOutAnimation = ValueAnimator.ofFloat(new float[] { 1.0F, 0.5F });
      this.mZoomOutAnimation.addListener(new MyZoomAnimatorListener());
      this.mZoomOutAnimation.addUpdateListener(new MyZoomAnimatorUpdateListener());
      this.mZoomOutAnimation.setDuration(500L);
      return;
    }
    this.mZoomInAnimationOld = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
    this.mZoomOutAnimationOld = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
    this.mZoomInAnimationOld.setDuration(500L);
    this.mZoomOutAnimationOld.setDuration(500L);
    this.mZoomInAnimationOld.setAnimationListener(new MyZoomAnimationListener());
    this.mZoomOutAnimationOld.setAnimationListener(new MyZoomAnimationListener());
  }
  
  public void animateTo(int paramInt1, int paramInt2)
  {
    if (!this.mMapView.isAnimating())
    {
      this.mMapView.mIsFlinging = false;
      int i = this.mMapView.getScrollX();
      int j = this.mMapView.getScrollY();
      this.mMapView.getScroller().startScroll(i, j, paramInt1 - i, paramInt2 - j, 1000);
      this.mMapView.postInvalidate();
    }
  }
  
  public void animateTo(IGeoPoint paramIGeoPoint)
  {
    paramIGeoPoint = this.mMapView.getProjection().toPixelsScaled(paramIGeoPoint, null);
    animateTo(paramIGeoPoint.x, paramIGeoPoint.y);
  }
  
  protected void onAnimationEnd()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.mCurrentAnimator = null;
    }
    for (;;)
    {
      this.mMapView.updateMapTiles();
      this.mMapView.mIsAnimating.set(false);
      if (Build.VERSION.SDK_INT <= 10)
      {
        this.mMapView.clearAnimation();
        this.mZoomInAnimationOld.reset();
        this.mZoomOutAnimationOld.reset();
      }
      return;
      this.mMapView.setCurrentScale(this.legacyTargetScale, this.zoomAnimationFocusPointScreen, this.zoomAnimationFocusGeoPoint, new PointF(0.0F, 0.0F));
    }
  }
  
  protected void onAnimationStart()
  {
    this.mMapView.mIsAnimating.set(true);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    this.mMapView.scrollBy(paramInt1, paramInt2);
  }
  
  public void setCenter(IGeoPoint paramIGeoPoint)
  {
    paramIGeoPoint = this.mMapView.getProjection().toMapPixels(paramIGeoPoint, null);
    this.mMapView.scrollTo(paramIGeoPoint.x, paramIGeoPoint.y);
  }
  
  public int setZoom(int paramInt)
  {
    return this.mMapView.setZoomLevel(paramInt);
  }
  
  public void stopAnimation(boolean paramBoolean)
  {
    if (!this.mMapView.getScroller().isFinished())
    {
      if (paramBoolean)
      {
        this.mMapView.mIsFlinging = false;
        this.mMapView.getScroller().abortAnimation();
      }
    }
    else
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label73;
      }
      localAnimator = this.mCurrentAnimator;
      if (this.mMapView.mIsAnimating.get()) {
        localAnimator.end();
      }
    }
    label73:
    while (!this.mMapView.mIsAnimating.get())
    {
      Animator localAnimator;
      return;
      stopPanning();
      break;
    }
    this.mMapView.clearAnimation();
  }
  
  public void stopPanning()
  {
    this.mMapView.mIsFlinging = false;
    this.mMapView.getScroller().forceFinished(true);
  }
  
  public boolean zoomIn()
  {
    Point localPoint = this.mMapView.getProjection().toMapPixels(this.mMapView.getMapCenter(), null);
    return zoomInFixing(localPoint.x, localPoint.y);
  }
  
  public boolean zoomInFixing(int paramInt1, int paramInt2)
  {
    this.zoomAnimationFocusPointScreen = this.mMapView.getProjection().internalToScreenPixels(paramInt1, paramInt2);
    this.zoomAnimationFocusGeoPoint = this.mMapView.getProjection().screenToGeoPoint(this.zoomAnimationFocusPointScreen.x, this.zoomAnimationFocusPointScreen.y);
    float f1 = this.mMapView.mMultiTouchScale;
    float f2 = Math.min((float)Math.ceil(1.0E-6F + f1), 2.0F);
    Log.d(LOG_TAG, "Animating zoom-in from " + this.mMapView.mMultiTouchScale + " to " + f2);
    if (this.mMapView.canZoomIn())
    {
      if (this.mMapView.mIsAnimating.getAndSet(true)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.mZoomInAnimation.setFloatValues(new float[] { f1, f2 });
        this.mCurrentAnimator = this.mZoomInAnimation;
        this.mZoomInAnimation.start();
        return true;
      }
      paramInt1 = this.mMapView.getNearestZoomLevelForTotalScale(this.mMapView.getCurrentZoomLevelScale() * f2);
      this.mMapView.mTargetZoomLevel.set(paramInt1);
      this.legacyTargetScale = f2;
      f1 = f2 / f1;
      this.mZoomInAnimationOld = new ScaleAnimation(1.0F, f1, 1.0F, f1, 1, this.zoomAnimationFocusPointScreen.x / this.mMapView.getWidth(), 1, this.zoomAnimationFocusPointScreen.y / this.mMapView.getHeight());
      this.mZoomInAnimationOld.setDuration(500L);
      this.mZoomInAnimationOld.setAnimationListener(new MyZoomAnimationListener());
      this.mMapView.startAnimation(this.mZoomInAnimationOld);
      return true;
    }
    return false;
  }
  
  public boolean zoomOut()
  {
    Point localPoint = this.mMapView.getProjection().toMapPixels(this.mMapView.getMapCenter(), null);
    return zoomOutFixing(localPoint.x, localPoint.y);
  }
  
  public boolean zoomOutFixing(int paramInt1, int paramInt2)
  {
    this.zoomAnimationFocusPointScreen = this.mMapView.getProjection().internalToScreenPixels(paramInt1, paramInt2);
    this.zoomAnimationFocusGeoPoint = this.mMapView.getProjection().screenToGeoPoint(this.zoomAnimationFocusPointScreen.x, this.zoomAnimationFocusPointScreen.y);
    float f1 = this.mMapView.mMultiTouchScale;
    float f2 = Math.max((float)Math.ceil(f1 / 2.0F), 0.5F);
    Log.d(LOG_TAG, "Animating zoom-in from " + this.mMapView.mMultiTouchScale + " to " + f2);
    if (this.mMapView.canZoomOut())
    {
      if (this.mMapView.mIsAnimating.getAndSet(true)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.mZoomInAnimation.setFloatValues(new float[] { f1, f2 });
        this.mCurrentAnimator = this.mZoomOutAnimation;
        this.mZoomOutAnimation.start();
        return true;
      }
      paramInt1 = this.mMapView.getNearestZoomLevelForTotalScale(this.mMapView.getCurrentZoomLevelScale() * f2);
      this.mMapView.mTargetZoomLevel.set(paramInt1);
      this.legacyTargetScale = f2;
      f1 = f2 / f1;
      this.mZoomOutAnimationOld = new ScaleAnimation(1.0F, f1, 1.0F, f1, 1, this.zoomAnimationFocusPointScreen.x / this.mMapView.getWidth(), 1, this.zoomAnimationFocusPointScreen.y / this.mMapView.getHeight());
      this.mZoomOutAnimationOld.setDuration(500L);
      this.mZoomOutAnimationOld.setAnimationListener(new MyZoomAnimationListener());
      this.mMapView.startAnimation(this.mZoomOutAnimationOld);
      return true;
    }
    return false;
  }
  
  public void zoomToSpan(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    int i;
    float f;
    do
    {
      return;
      BoundingBoxE6 localBoundingBoxE6 = this.mMapView.getBoundingBox();
      i = this.mMapView.getZoomLevel();
      int j = localBoundingBoxE6.getLatitudeSpanE6();
      int k = localBoundingBoxE6.getLongitudeSpanE6();
      f = Math.max(paramInt1 / j, paramInt2 / k);
      if (f > 1.0F)
      {
        this.mMapView.setZoomLevel(i - MyMath.getNextSquareNumberAbove(f));
        return;
      }
    } while (f >= 0.5D);
    this.mMapView.setZoomLevel(MyMath.getNextSquareNumberAbove(1.0F / f) + i - 1);
  }
  
  public void zoomToSpan(BoundingBoxE6 paramBoundingBoxE6)
  {
    zoomToSpan(paramBoundingBoxE6.getLatitudeSpanE6(), paramBoundingBoxE6.getLongitudeSpanE6());
  }
  
  protected class MyZoomAnimationListener
    implements Animation.AnimationListener
  {
    protected MyZoomAnimationListener() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      MapController.this.onAnimationEnd();
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      MapController.this.onAnimationStart();
    }
  }
  
  protected class MyZoomAnimatorListener
    extends AnimatorListenerAdapter
  {
    protected MyZoomAnimatorListener() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      MapController.this.onAnimationEnd();
      super.onAnimationEnd(paramAnimator);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      MapController.this.onAnimationStart();
      super.onAnimationStart(paramAnimator);
    }
  }
  
  protected class MyZoomAnimatorUpdateListener
    implements ValueAnimator.AnimatorUpdateListener
  {
    protected MyZoomAnimatorUpdateListener() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = new PointF(0.0F, 0.0F);
      MapController.this.mMapView.setCurrentScale(f, MapController.this.zoomAnimationFocusPointScreen, MapController.this.zoomAnimationFocusGeoPoint, paramValueAnimator);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/MapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */