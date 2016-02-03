package org.osmdroid.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Scroller;
import android.widget.ZoomButtonsController;
import android.widget.ZoomButtonsController.OnZoomListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import microsoft.mappoint.TileSystem;
import org.metalev.multitouch.controller.MultiTouchController.MultiTouchObjectCanvas;
import org.metalev.multitouch.controller.MultiTouchController.PointInfo;
import org.metalev.multitouch.controller.MultiTouchController.PositionAndScale;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.api.IMapView;
import org.osmdroid.api.IProjection;
import org.osmdroid.events.MapListener;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.events.ZoomEvent;
import org.osmdroid.tileprovider.MapTileProviderArray;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import org.osmdroid.tileprovider.modules.MapTileModuleProviderBase;
import org.osmdroid.tileprovider.tilesource.IStyledTileSource;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.util.SimpleInvalidationHandler;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.GeometryMath;
import org.osmdroid.util.constants.GeoConstants;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayManager;
import org.osmdroid.views.overlay.TilesOverlay;
import org.osmdroid.views.util.constants.MapViewConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapView
  extends ViewGroup
  implements IMapView, MapViewConstants, MultiTouchController.MultiTouchObjectCanvas<Object>
{
  private static final String LOG_TAG = MapView.class.getSimpleName();
  private static final double ZOOM_LOG_BASE_INV = 1.0D / Math.log(2.0D);
  private static final double ZOOM_SENSITIVITY = 1.0D;
  private static final Logger logger = LoggerFactory.getLogger(MapView.class);
  private static Method sMotionEventTransformMethod;
  private final MapController mController;
  private boolean mEnableZoomController = false;
  private final GestureDetector mGestureDetector;
  private final Rect mInvalidateRect = new Rect();
  protected final AtomicBoolean mIsAnimating = new AtomicBoolean(false);
  protected boolean mIsFlinging;
  protected MapListener mListener;
  private final TilesOverlay mMapOverlay;
  protected Integer mMaximumZoomLevel;
  protected Integer mMinimumZoomLevel;
  public float mMultiTouchScale = 1.0F;
  protected PointF mMultiTouchScalePoint = new PointF();
  private final OverlayManager mOverlayManager;
  private final Point mPoint = new Point();
  private Projection mProjection;
  private final ResourceProxy mResourceProxy;
  private final Matrix mRotateMatrix = new Matrix();
  private final float[] mRotatePoints = new float[2];
  private final ScaleGestureDetector mScaleGestureDetector;
  protected BoundingBoxE6 mScrollableAreaBoundingBox;
  protected Rect mScrollableAreaLimit;
  private final Scroller mScroller;
  public boolean mShouldScrollEndlessVertical = true;
  protected final AtomicInteger mTargetZoomLevel = new AtomicInteger();
  private final MapTileProviderBase mTileProvider;
  private final Handler mTileRequestCompleteHandler;
  private final ZoomButtonsController mZoomController;
  private int mZoomLevel = 0;
  private float mapOrientation = 0.0F;
  public boolean shoudLiveUpdateTiles = true;
  public boolean shouldUseHQScaling = false;
  
  public MapView(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, new DefaultResourceProxyImpl(paramContext));
  }
  
  public MapView(Context paramContext, int paramInt, ResourceProxy paramResourceProxy)
  {
    this(paramContext, paramInt, paramResourceProxy, null);
  }
  
  public MapView(Context paramContext, int paramInt, ResourceProxy paramResourceProxy, MapTileProviderBase paramMapTileProviderBase)
  {
    this(paramContext, paramInt, paramResourceProxy, paramMapTileProviderBase, null);
  }
  
  public MapView(Context paramContext, int paramInt, ResourceProxy paramResourceProxy, MapTileProviderBase paramMapTileProviderBase, Handler paramHandler)
  {
    this(paramContext, paramInt, paramResourceProxy, paramMapTileProviderBase, paramHandler, null);
  }
  
  protected MapView(Context paramContext, int paramInt, ResourceProxy paramResourceProxy, MapTileProviderBase paramMapTileProviderBase, Handler paramHandler, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mResourceProxy = paramResourceProxy;
    this.mController = new MapController(this);
    this.mScroller = new Scroller(paramContext);
    TileSystem.setTileSize(paramInt);
    paramResourceProxy = paramMapTileProviderBase;
    if (paramMapTileProviderBase == null)
    {
      paramResourceProxy = getTileSourceFromAttributes(paramAttributeSet);
      if (isInEditMode()) {
        paramResourceProxy = new MapTileProviderArray(paramResourceProxy, null, new MapTileModuleProviderBase[0]);
      }
    }
    else
    {
      paramMapTileProviderBase = paramHandler;
      if (paramHandler == null) {
        paramMapTileProviderBase = new SimpleInvalidationHandler(this);
      }
      this.mTileRequestCompleteHandler = paramMapTileProviderBase;
      this.mTileProvider = paramResourceProxy;
      this.mTileProvider.setTileRequestCompleteHandler(this.mTileRequestCompleteHandler);
      this.mMapOverlay = new TilesOverlay(this.mTileProvider, this.mResourceProxy);
      this.mOverlayManager = new OverlayManager(this.mMapOverlay);
      if (!isInEditMode()) {
        break label344;
      }
      this.mZoomController = null;
    }
    for (;;)
    {
      this.mGestureDetector = new GestureDetector(paramContext, new MapViewGestureDetectorListener(null));
      this.mGestureDetector.setOnDoubleTapListener(new MapViewDoubleClickListener(null));
      this.mScaleGestureDetector = new ScaleGestureDetector(paramContext, new MapViewScaleGestureListener(null));
      return;
      paramResourceProxy = new MapTileProviderBasic(paramContext, paramResourceProxy);
      break;
      label344:
      this.mZoomController = new ZoomButtonsController(this);
      this.mZoomController.setOnZoomListener(new MapViewZoomListener(null));
    }
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, 256, new DefaultResourceProxyImpl(paramContext), null, null, paramAttributeSet);
  }
  
  private void checkZoomButtons()
  {
    this.mZoomController.setZoomInEnabled(canZoomIn());
    this.mZoomController.setZoomOutEnabled(canZoomOut());
  }
  
  private ITileSource getTileSourceFromAttributes(AttributeSet paramAttributeSet)
  {
    OnlineTileSourceBase localOnlineTileSourceBase2 = TileSourceFactory.DEFAULT_TILE_SOURCE;
    Object localObject = localOnlineTileSourceBase2;
    String str;
    if (paramAttributeSet != null)
    {
      str = paramAttributeSet.getAttributeValue(null, "tilesource");
      localObject = localOnlineTileSourceBase2;
      if (str == null) {}
    }
    try
    {
      localObject = TileSourceFactory.getTileSource(str);
      logger.info("Using tile source specified in layout attributes: " + localObject);
      if ((paramAttributeSet != null) && ((localObject instanceof IStyledTileSource)))
      {
        paramAttributeSet = paramAttributeSet.getAttributeValue(null, "style");
        if (paramAttributeSet == null) {
          logger.info("Using default style: 1");
        }
      }
      else
      {
        logger.info("Using tile source: " + localObject);
        return (ITileSource)localObject;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        logger.warn("Invalid tile source specified in layout attributes: " + localOnlineTileSourceBase2);
        OnlineTileSourceBase localOnlineTileSourceBase1 = localOnlineTileSourceBase2;
        continue;
        logger.info("Using style specified in layout attributes: " + paramAttributeSet);
        ((IStyledTileSource)localOnlineTileSourceBase1).setStyle(paramAttributeSet);
      }
    }
  }
  
  private MotionEvent rotateTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getMapOrientation() == 0.0F) {
      return paramMotionEvent;
    }
    this.mRotateMatrix.setRotate(-getMapOrientation(), getWidth() / 2, getHeight() / 2);
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.mRotatePoints[0] = paramMotionEvent.getX();
      this.mRotatePoints[1] = paramMotionEvent.getY();
      this.mRotateMatrix.mapPoints(this.mRotatePoints);
      localMotionEvent.setLocation(this.mRotatePoints[0], this.mRotatePoints[1]);
    }
    for (;;)
    {
      return localMotionEvent;
      try
      {
        if (sMotionEventTransformMethod == null) {
          sMotionEventTransformMethod = MotionEvent.class.getDeclaredMethod("transform", new Class[] { Matrix.class });
        }
        sMotionEventTransformMethod.invoke(localMotionEvent, new Object[] { this.mRotateMatrix });
      }
      catch (SecurityException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      catch (NoSuchMethodException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
    }
  }
  
  public void addScale(float paramFloat, PointF paramPointF1, IGeoPoint paramIGeoPoint, PointF paramPointF2)
  {
    setTotalScale(getCurrentTotalScale() * paramFloat, paramPointF1, paramIGeoPoint, paramPointF2);
  }
  
  public boolean canZoomIn()
  {
    int j = (int)Math.pow(2.0D, getMaximumTotalScale());
    if (isAnimating()) {}
    for (int i = this.mTargetZoomLevel.get(); i >= j; i = this.mZoomLevel) {
      return false;
    }
    return true;
  }
  
  public boolean canZoomOut()
  {
    int j = getMinZoomLevel();
    if (isAnimating()) {}
    for (int i = this.mTargetZoomLevel.get(); i <= j; i = this.mZoomLevel) {
      return false;
    }
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      if (!this.mScroller.isFinished()) {
        break label48;
      }
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      this.mIsFlinging = false;
    }
    for (;;)
    {
      postInvalidate();
      return;
      label48:
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.mProjection = new Projection(null);
    paramCanvas.save();
    paramCanvas.translate(getWidth() / 2, getHeight() / 2);
    paramCanvas.scale(this.mMultiTouchScale, this.mMultiTouchScale, this.mMultiTouchScalePoint.x, this.mMultiTouchScalePoint.y);
    getOverlayManager().onDraw(paramCanvas, this);
    paramCanvas.restore();
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mZoomController.isVisible()) && (this.mZoomController.onTouch(this, paramMotionEvent))) {}
    for (;;)
    {
      return true;
      MotionEvent localMotionEvent = rotateTouchEvent(paramMotionEvent);
      try
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        if (bool) {
          return true;
        }
        bool = getOverlayManager().onTouchEvent(localMotionEvent, this);
        if (bool) {
          return true;
        }
        if ((this.mScaleGestureDetector != null) && (this.mScaleGestureDetector.onTouchEvent(paramMotionEvent)))
        {
          bool = this.mScaleGestureDetector.isInProgress();
          if (bool) {
            return true;
          }
        }
        bool = this.mGestureDetector.onTouchEvent(localMotionEvent);
        return bool;
      }
      finally
      {
        if (localMotionEvent != paramMotionEvent) {
          localMotionEvent.recycle();
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2, null, 8, 0, 0);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public BoundingBoxE6 getBoundingBox()
  {
    return getBoundingBox(getWidth(), getHeight());
  }
  
  public BoundingBoxE6 getBoundingBox(int paramInt1, int paramInt2)
  {
    paramInt1 = TileSystem.MapSize(this.mZoomLevel) / 2;
    Object localObject = getScreenRect(null);
    ((Rect)localObject).offset(paramInt1, paramInt1);
    GeoPoint localGeoPoint = TileSystem.PixelXYToLatLong(((Rect)localObject).right, ((Rect)localObject).top, this.mZoomLevel, null);
    localObject = TileSystem.PixelXYToLatLong(((Rect)localObject).left, ((Rect)localObject).bottom, this.mZoomLevel, null);
    return new BoundingBoxE6(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6(), ((IGeoPoint)localObject).getLatitudeE6(), ((IGeoPoint)localObject).getLongitudeE6());
  }
  
  public IMapController getController()
  {
    return this.mController;
  }
  
  public float getCurrentTotalScale()
  {
    return (float)(getCurrentZoomLevelScale() * this.mMultiTouchScale);
  }
  
  public float getCurrentZoomLevelScale()
  {
    return getScaleForZoomLevel(this.mZoomLevel);
  }
  
  public Object getDraggableObjectAtPoint(MultiTouchController.PointInfo paramPointInfo)
  {
    if (isAnimating()) {
      return null;
    }
    this.mMultiTouchScalePoint.x = (paramPointInfo.getX() + getScrollX() - getWidth() / 2);
    this.mMultiTouchScalePoint.y = (paramPointInfo.getY() + getScrollY() - getHeight() / 2);
    return this;
  }
  
  public Rect getIntrinsicScreenRect(Rect paramRect)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      paramRect.set(getScrollX() - getWidth() / 2, getScrollY() - getHeight() / 2, getScrollX() + getWidth() / 2, getScrollY() + getHeight() / 2);
      return paramRect;
    }
  }
  
  public int getLatitudeSpan()
  {
    return getBoundingBox().getLatitudeSpanE6();
  }
  
  public int getLongitudeSpan()
  {
    return getBoundingBox().getLongitudeSpanE6();
  }
  
  public IGeoPoint getMapCenter()
  {
    int i = TileSystem.MapSize(this.mZoomLevel) / 2;
    Rect localRect = getScreenRect(null);
    localRect.offset(i, i);
    return TileSystem.PixelXYToLatLong(localRect.centerX(), localRect.centerY(), this.mZoomLevel, null);
  }
  
  public float getMapOrientation()
  {
    return this.mapOrientation;
  }
  
  public int getMaxZoomLevel()
  {
    if (this.mMaximumZoomLevel == null) {
      return this.mMapOverlay.getMaximumZoomLevel();
    }
    return this.mMaximumZoomLevel.intValue();
  }
  
  public float getMaximumTotalScale()
  {
    return (float)(Math.pow(2.0D, getMaxZoomLevel()) * 2.0D);
  }
  
  public int getMinZoomLevel()
  {
    if (this.mMinimumZoomLevel == null) {
      return this.mMapOverlay.getMinimumZoomLevel();
    }
    return this.mMinimumZoomLevel.intValue();
  }
  
  public float getMinimumTotalScale()
  {
    return (float)Math.pow(2.0D, getMinZoomLevel());
  }
  
  public int getNearestZoomLevelForTotalScale(float paramFloat)
  {
    return (int)Math.round(Math.log(paramFloat) / Math.log(2.0D));
  }
  
  public OverlayManager getOverlayManager()
  {
    return this.mOverlayManager;
  }
  
  public List<Overlay> getOverlays()
  {
    return getOverlayManager();
  }
  
  public void getPositionAndScale(Object paramObject, MultiTouchController.PositionAndScale paramPositionAndScale)
  {
    paramPositionAndScale.set(0.0F, 0.0F, true, this.mMultiTouchScale, false, 0.0F, 0.0F, false, 0.0F);
  }
  
  public Projection getProjection()
  {
    if (this.mProjection == null) {
      this.mProjection = new Projection(null);
    }
    return this.mProjection;
  }
  
  public ResourceProxy getResourceProxy()
  {
    return this.mResourceProxy;
  }
  
  public float getScaleForZoomLevel(int paramInt)
  {
    return (float)Math.pow(2.0D, paramInt);
  }
  
  public Rect getScreenRect(Rect paramRect)
  {
    paramRect = getIntrinsicScreenRect(paramRect);
    if ((getMapOrientation() != 0.0F) && (getMapOrientation() != 180.0F)) {
      GeometryMath.getBoundingBoxForRotatatedRectangle(paramRect, getScrollX(), getScrollY(), getMapOrientation(), paramRect);
    }
    return paramRect;
  }
  
  public BoundingBoxE6 getScrollableAreaLimit()
  {
    return this.mScrollableAreaBoundingBox;
  }
  
  public Scroller getScroller()
  {
    return this.mScroller;
  }
  
  public MapTileProviderBase getTileProvider()
  {
    return this.mTileProvider;
  }
  
  public Handler getTileRequestCompleteHandler()
  {
    return this.mTileRequestCompleteHandler;
  }
  
  public int getZoomLevel()
  {
    return getZoomLevel(true);
  }
  
  public int getZoomLevel(boolean paramBoolean)
  {
    if ((paramBoolean) && (isAnimating())) {
      return this.mTargetZoomLevel.get();
    }
    return this.mZoomLevel;
  }
  
  public void invalidateMapCoordinates(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInvalidateRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth() / 2;
    paramInt2 = getHeight() / 2;
    paramInt3 = getScrollX();
    paramInt4 = getScrollY();
    if (getMapOrientation() != 0.0F) {
      GeometryMath.getBoundingBoxForRotatatedRectangle(this.mInvalidateRect, paramInt3, paramInt4, getMapOrientation() + 180.0F, this.mInvalidateRect);
    }
    this.mInvalidateRect.offset(paramInt1, paramInt2);
    super.invalidate(this.mInvalidateRect);
  }
  
  public void invalidateMapCoordinates(Rect paramRect)
  {
    invalidateMapCoordinates(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public boolean isAnimating()
  {
    return this.mIsAnimating.get();
  }
  
  public boolean isUsingSafeCanvas()
  {
    return getOverlayManager().isUsingSafeCanvas();
  }
  
  int loadTilesForZoomLevel(int paramInt)
  {
    paramInt = Math.max(getMinZoomLevel(), Math.min(getMaxZoomLevel(), paramInt));
    int i = this.mZoomLevel;
    if (paramInt != i)
    {
      this.mScroller.forceFinished(true);
      this.mIsFlinging = false;
    }
    this.mZoomLevel = paramInt;
    checkZoomButtons();
    Object localObject;
    if (paramInt > i)
    {
      int j = TileSystem.MapSize(i) / 2;
      int k = TileSystem.MapSize(paramInt) / 2;
      localObject = TileSystem.PixelXYToLatLong(getScrollX() + j, getScrollY() + j, i, null);
      localObject = TileSystem.LatLongToPixelXY(((IGeoPoint)localObject).getLatitude(), ((IGeoPoint)localObject).getLongitude(), paramInt, null);
      scrollTo(((Point)localObject).x - k, ((Point)localObject).y - k);
    }
    for (;;)
    {
      localObject = new Point();
      this.mProjection = new Projection(null);
      if (getOverlayManager().onSnapToItem(getScrollX(), getScrollY(), (Point)localObject, this)) {
        scrollTo(((Point)localObject).x, ((Point)localObject).y);
      }
      localObject = getScreenRect(null);
      this.mTileProvider.rescaleCache(paramInt, i, (Rect)localObject);
      if ((paramInt != i) && (this.mListener != null))
      {
        localObject = new ZoomEvent(this, paramInt);
        this.mListener.onZoom((ZoomEvent)localObject);
      }
      requestLayout();
      return this.mZoomLevel;
      if (paramInt < i) {
        scrollTo(getScrollX() >> i - paramInt, getScrollY() >> i - paramInt);
      }
    }
  }
  
  public void onDetach()
  {
    getOverlayManager().onDetach(this);
    this.mTileProvider.detach();
  }
  
  protected void onDetachedFromWindow()
  {
    this.mZoomController.setVisible(false);
    onDetach();
    super.onDetachedFromWindow();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (getOverlayManager().onKeyDown(paramInt, paramKeyEvent, this)) || (super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (getOverlayManager().onKeyUp(paramInt, paramKeyEvent, this)) || (super.onKeyUp(paramInt, paramKeyEvent));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    paramInt3 = 0;
    if (paramInt3 < j)
    {
      View localView = getChildAt(paramInt3);
      LayoutParams localLayoutParams;
      int k;
      int m;
      int i;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        k = localView.getMeasuredHeight();
        m = localView.getMeasuredWidth();
        getProjection().toMapPixels(localLayoutParams.geoPoint, this.mPoint);
        i = this.mPoint.x + getWidth() / 2;
        paramInt4 = this.mPoint.y + getHeight() / 2;
        paramInt1 = i;
        paramInt2 = paramInt4;
        switch (localLayoutParams.alignment)
        {
        }
      }
      for (;;)
      {
        paramInt1 += localLayoutParams.offsetX;
        paramInt2 += localLayoutParams.offsetY;
        localView.layout(paramInt1, paramInt2, paramInt1 + m, paramInt2 + k);
        paramInt3 += 1;
        break;
        paramInt1 = getPaddingLeft() + i;
        paramInt2 = getPaddingTop() + paramInt4;
        continue;
        paramInt1 = getPaddingLeft() + i - m / 2;
        paramInt2 = getPaddingTop() + paramInt4;
        continue;
        paramInt1 = getPaddingLeft() + i - m;
        paramInt2 = getPaddingTop() + paramInt4;
        continue;
        paramInt1 = getPaddingLeft() + i;
        paramInt2 = getPaddingTop() + paramInt4 - k / 2;
        continue;
        paramInt1 = getPaddingLeft() + i - m / 2;
        paramInt2 = getPaddingTop() + paramInt4 - k / 2;
        continue;
        paramInt1 = getPaddingLeft() + i - m;
        paramInt2 = getPaddingTop() + paramInt4 - k / 2;
        continue;
        paramInt1 = getPaddingLeft() + i;
        paramInt2 = getPaddingTop() + paramInt4 - k;
        continue;
        paramInt1 = getPaddingLeft() + i - m / 2;
        paramInt2 = getPaddingTop() + paramInt4 - k;
        continue;
        paramInt1 = getPaddingLeft() + i - m;
        paramInt2 = getPaddingTop() + paramInt4 - k;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = getChildCount();
    int m = 0;
    int k = 0;
    measureChildren(paramInt1, paramInt2);
    int n = 0;
    if (n < i3)
    {
      View localView = getChildAt(n);
      j = m;
      i = k;
      LayoutParams localLayoutParams;
      int i4;
      int i5;
      int i2;
      int i1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i4 = localView.getMeasuredHeight();
        i5 = localView.getMeasuredWidth();
        getProjection().toMapPixels(localLayoutParams.geoPoint, this.mPoint);
        j = this.mPoint.x + getWidth() / 2;
        i = this.mPoint.y + getHeight() / 2;
        i2 = j;
        i1 = i;
        switch (localLayoutParams.alignment)
        {
        default: 
          j = i2;
          i = i1;
        }
      }
      for (;;)
      {
        i2 = localLayoutParams.offsetX;
        i1 = localLayoutParams.offsetY;
        j = Math.max(k, j + i2);
        k = Math.max(m, i + i1);
        i = j;
        j = k;
        n += 1;
        m = j;
        k = i;
        break;
        j += i5;
        continue;
        j += i5 / 2;
        continue;
        continue;
        j += i5;
        i += i4 / 2;
        continue;
        j += i5 / 2;
        i += i4 / 2;
        continue;
        i += i4 / 2;
        continue;
        j += i5;
        i += i4;
        continue;
        j += i5 / 2;
        i += i4;
        continue;
        i += i4;
      }
    }
    int i = getPaddingLeft();
    int j = getPaddingRight();
    m = Math.max(m + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(k + (i + j), getSuggestedMinimumWidth()), paramInt1), resolveSize(m, paramInt2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (getOverlayManager().onTrackballEvent(paramMotionEvent, this)) {
      return true;
    }
    scrollBy((int)(paramMotionEvent.getX() * 25.0F), (int)(paramMotionEvent.getY() * 25.0F));
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    super.scrollBy((int)(paramInt1 / this.mMultiTouchScale), (int)(paramInt2 / this.mMultiTouchScale));
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mIsFlinging)
    {
      i = paramInt2;
      if (Math.abs(paramInt2 - getScrollY()) > getHeight() / 2) {
        i = getScrollY();
      }
    }
    Object localObject = getProjection();
    PointF localPointF = ((Projection)localObject).mapToScreenPixels(0.0F, 0.0F, paramInt1, i, this.mMultiTouchScale, this.mMultiTouchScalePoint.x, this.mMultiTouchScalePoint.y);
    paramInt2 = i;
    if (localPointF.y > 0.0F)
    {
      paramInt2 = i;
      if (localPointF.y < getHeight())
      {
        if (localPointF.y >= getHeight() / 2) {
          break label356;
        }
        paramInt2 = (int)((Projection)localObject).centerForMapMatchesScreenPixel(0.0F, 0.0F, 0.0F, 0.0F, this.mMultiTouchScale).y;
      }
    }
    i = paramInt1;
    if (!this.mShouldScrollEndlessVertical)
    {
      i = paramInt1;
      if (localPointF.x > 0.0F)
      {
        i = paramInt1;
        if (localPointF.x < getWidth()) {
          if (localPointF.x >= getWidth() / 2) {
            break label381;
          }
        }
      }
    }
    int k;
    int j;
    label356:
    label381:
    for (i = (int)((Projection)localObject).centerForMapMatchesScreenPixel(0.0F, 0.0F, 0.0F, 0.0F, this.mMultiTouchScale).x;; i = (int)((Projection)localObject).centerForMapMatchesScreenPixel(0.0F, 0.0F, getWidth(), 0.0F, this.mMultiTouchScale).x)
    {
      k = TileSystem.MapSize(getZoomLevel(false)) / 2;
      localObject = new PointF((-k - this.mMultiTouchScalePoint.x) * this.mMultiTouchScale + this.mMultiTouchScalePoint.x, (-k - this.mMultiTouchScalePoint.y) * this.mMultiTouchScale + this.mMultiTouchScalePoint.y);
      localPointF = new PointF((k - this.mMultiTouchScalePoint.x) * this.mMultiTouchScale + this.mMultiTouchScalePoint.x, (k - this.mMultiTouchScalePoint.y) * this.mMultiTouchScale + this.mMultiTouchScalePoint.y);
      for (;;)
      {
        j = i;
        if (i >= ((PointF)localObject).x) {
          break;
        }
        i += k * 2;
      }
      paramInt2 = (int)((Projection)localObject).centerForMapMatchesScreenPixel(0.0F, 0.0F, 0.0F, getHeight(), this.mMultiTouchScale).y;
      break;
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (j <= localPointF.x) {
        break;
      }
      j -= k * 2;
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (paramInt1 >= ((PointF)localObject).y) {
        break;
      }
      paramInt1 += k * 2;
    }
    while (paramInt2 > localPointF.y) {
      paramInt2 -= k * 2;
    }
    super.scrollTo(j, paramInt2);
    this.mMultiTouchScalePoint.x = getScrollX();
    this.mMultiTouchScalePoint.y = getScrollY();
    if (this.mListener != null)
    {
      localObject = new ScrollEvent(this, j, paramInt2);
      this.mListener.onScroll((ScrollEvent)localObject);
    }
  }
  
  public void selectObject(Object paramObject, MultiTouchController.PointInfo paramPointInfo)
  {
    if ((paramObject == null) && (this.mMultiTouchScale != 1.0F))
    {
      float f = (float)(Math.log(this.mMultiTouchScale) * ZOOM_LOG_BASE_INV);
      int i = Math.round(f);
      if (i != 0)
      {
        paramObject = new Matrix();
        ((Matrix)paramObject).setScale(1.0F / this.mMultiTouchScale, 1.0F / this.mMultiTouchScale, this.mMultiTouchScalePoint.x, this.mMultiTouchScalePoint.y);
        ((Matrix)paramObject).postRotate(-this.mapOrientation, this.mProjection.getScreenRect().centerX(), this.mProjection.getScreenRect().centerY());
        paramPointInfo = new float[2];
        paramPointInfo[0] = getScrollX();
        paramPointInfo[1] = getScrollY();
        ((Matrix)paramObject).mapPoints(paramPointInfo);
        scrollTo((int)paramPointInfo[0], (int)paramPointInfo[1]);
      }
      setZoomLevel(this.mZoomLevel + i);
      this.mMultiTouchScale -= f;
      invalidate();
    }
    this.mMultiTouchScale = 1.0F;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mMapOverlay.setLoadingBackgroundColor(paramInt);
    invalidate();
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    this.mEnableZoomController = paramBoolean;
    checkZoomButtons();
  }
  
  public void setCurrentScale(float paramFloat, PointF paramPointF1, IGeoPoint paramIGeoPoint, PointF paramPointF2)
  {
    setTotalScale(paramFloat * getCurrentZoomLevelScale(), paramPointF1, paramIGeoPoint, paramPointF2);
  }
  
  @Deprecated
  void setMapCenter(int paramInt1, int paramInt2)
  {
    setMapCenter(new GeoPoint(paramInt1, paramInt2));
  }
  
  void setMapCenter(IGeoPoint paramIGeoPoint)
  {
    getController().animateTo(paramIGeoPoint);
  }
  
  public void setMapListener(MapListener paramMapListener)
  {
    this.mListener = paramMapListener;
  }
  
  public void setMapOrientation(float paramFloat)
  {
    this.mapOrientation = (paramFloat % 360.0F);
    invalidate();
  }
  
  public void setMaxZoomLevel(Integer paramInteger)
  {
    this.mMaximumZoomLevel = paramInteger;
  }
  
  public void setMinZoomLevel(Integer paramInteger)
  {
    this.mMinimumZoomLevel = paramInteger;
  }
  
  public boolean setPositionAndScale(Object paramObject, MultiTouchController.PositionAndScale paramPositionAndScale, MultiTouchController.PointInfo paramPointInfo)
  {
    float f2 = paramPositionAndScale.getScale();
    float f1 = f2;
    if (f2 > 1.0F)
    {
      f1 = f2;
      if (!canZoomIn()) {
        f1 = 1.0F;
      }
    }
    f2 = f1;
    if (f1 < 1.0F)
    {
      f2 = f1;
      if (!canZoomOut()) {
        f2 = 1.0F;
      }
    }
    this.mMultiTouchScale = f2;
    invalidate();
    return true;
  }
  
  public void setScrollableAreaLimit(BoundingBoxE6 paramBoundingBoxE6)
  {
    int i = TileSystem.MapSize(22) / 2;
    this.mScrollableAreaBoundingBox = paramBoundingBoxE6;
    if (paramBoundingBoxE6 == null)
    {
      this.mScrollableAreaLimit = null;
      return;
    }
    Point localPoint = TileSystem.LatLongToPixelXY(paramBoundingBoxE6.getLatNorthE6() / 1000000.0D, paramBoundingBoxE6.getLonWestE6() / 1000000.0D, 22, null);
    localPoint.offset(-i, -i);
    paramBoundingBoxE6 = TileSystem.LatLongToPixelXY(paramBoundingBoxE6.getLatSouthE6() / 1000000.0D, paramBoundingBoxE6.getLonEastE6() / 1000000.0D, 22, null);
    paramBoundingBoxE6.offset(-i, -i);
    this.mScrollableAreaLimit = new Rect(localPoint.x, localPoint.y, paramBoundingBoxE6.x, paramBoundingBoxE6.y);
  }
  
  public void setTileSource(ITileSource paramITileSource)
  {
    this.mTileProvider.setTileSource(paramITileSource);
    TileSystem.setTileSize(paramITileSource.getTileSizePixels());
    checkZoomButtons();
    setZoomLevel(this.mZoomLevel);
    postInvalidate();
  }
  
  public void setTotalScale(float paramFloat, PointF paramPointF1, IGeoPoint paramIGeoPoint, PointF paramPointF2)
  {
    this.mMultiTouchScale = (Math.max(getMinimumTotalScale(), Math.min(getMaximumTotalScale(), paramFloat)) / getCurrentZoomLevelScale());
    paramPointF1 = getProjection().centerForGeoPointMatchesScreenPixel(paramIGeoPoint, paramPointF1.x, paramPointF1.y, this.mMultiTouchScale);
    this.mMultiTouchScalePoint = paramPointF1;
    int i = (int)(paramPointF2.x / this.mMultiTouchScale);
    int j = (int)(paramPointF2.y / this.mMultiTouchScale);
    scrollTo((int)(paramPointF1.x - i), (int)(paramPointF1.y - j));
    j = 0;
    i = j;
    if (this.shoudLiveUpdateTiles)
    {
      i = j;
      if (!isAnimating())
      {
        if ((!this.shouldUseHQScaling) || (this.mMultiTouchScale >= 0.75D)) {
          break label162;
        }
        i = 1;
      }
    }
    while (i != 0)
    {
      if (!updateMapTiles()) {
        invalidate();
      }
      return;
      label162:
      i = j;
      if (this.mMultiTouchScale < 1.0F) {
        i = 1;
      }
    }
    invalidate();
  }
  
  public void setUseDataConnection(boolean paramBoolean)
  {
    this.mMapOverlay.setUseDataConnection(paramBoolean);
  }
  
  public void setUseSafeCanvas(boolean paramBoolean)
  {
    getOverlayManager().setUseSafeCanvas(paramBoolean);
  }
  
  int setZoomLevel(int paramInt)
  {
    float f = getScaleForZoomLevel(paramInt);
    IGeoPoint localIGeoPoint = getProjection().geoPointAtCenter();
    setTotalScale(f, new PointF(0.0F, 0.0F), localIGeoPoint, new PointF(0.0F, 0.0F));
    updateMapTiles();
    return paramInt;
  }
  
  public boolean updateMapTiles()
  {
    boolean bool = false;
    double d = Math.log(getCurrentTotalScale()) / Math.log(2.0D);
    int i;
    if (this.shouldUseHQScaling) {
      if (getCurrentTotalScale() >= getScaleForZoomLevel(getMaxZoomLevel())) {
        i = getMaxZoomLevel();
      }
    }
    for (;;)
    {
      if (i != this.mZoomLevel)
      {
        float f = getCurrentTotalScale();
        Log.d(LOG_TAG, "Changing zoom level from " + this.mZoomLevel + " to " + i + ". With additional scaling applied total scale is " + f);
        Object localObject = getProjection().geoPointAtCenter();
        this.mMultiTouchScale = 1.0F;
        loadTilesForZoomLevel(i);
        this.mMultiTouchScale = (f / getCurrentZoomLevelScale());
        localObject = getProjection().centerForGeoPointMatchesScreenPixel((IGeoPoint)localObject, getWidth() / 2, getHeight() / 2, this.mMultiTouchScale);
        scrollTo((int)((PointF)localObject).x, (int)((PointF)localObject).y);
        bool = true;
      }
      return bool;
      if (this.mMultiTouchScale < 0.75D)
      {
        i = (int)Math.floor(d);
      }
      else if (this.mMultiTouchScale > 1.5D)
      {
        i = (int)Math.ceil(d);
      }
      else
      {
        i = this.mZoomLevel;
        continue;
        i = (int)Math.floor(d);
      }
    }
  }
  
  public boolean useDataConnection()
  {
    return this.mMapOverlay.useDataConnection();
  }
  
  boolean zoomIn()
  {
    return getController().zoomIn();
  }
  
  boolean zoomInFixing(int paramInt1, int paramInt2)
  {
    return getController().zoomInFixing(paramInt1, paramInt2);
  }
  
  boolean zoomInFixing(IGeoPoint paramIGeoPoint)
  {
    paramIGeoPoint = getProjection().geoPointToScreenPixels(paramIGeoPoint);
    paramIGeoPoint = getProjection().screenToInternalPixel(paramIGeoPoint.x, paramIGeoPoint.y);
    return getController().zoomInFixing((int)paramIGeoPoint.x, (int)paramIGeoPoint.y);
  }
  
  boolean zoomOut()
  {
    return getController().zoomOut();
  }
  
  boolean zoomOutFixing(int paramInt1, int paramInt2)
  {
    return getController().zoomOutFixing(paramInt1, paramInt2);
  }
  
  boolean zoomOutFixing(IGeoPoint paramIGeoPoint)
  {
    paramIGeoPoint = getProjection().toMapPixels(paramIGeoPoint, null);
    return zoomOutFixing(paramIGeoPoint.x, paramIGeoPoint.y);
  }
  
  public void zoomToBoundingBox(BoundingBoxE6 paramBoundingBoxE6)
  {
    Object localObject = getBoundingBox();
    double d1;
    if (this.mZoomLevel == getMaxZoomLevel())
    {
      d1 = ((BoundingBoxE6)localObject).getLatitudeSpanE6();
      double d2 = getMaxZoomLevel() - Math.ceil(Math.log(paramBoundingBoxE6.getLatitudeSpanE6() / d1) / Math.log(2.0D));
      if (this.mZoomLevel != getMaxZoomLevel()) {
        break label181;
      }
      d1 = ((BoundingBoxE6)localObject).getLongitudeSpanE6();
      label70:
      d1 = getMaxZoomLevel() - Math.ceil(Math.log(paramBoundingBoxE6.getLongitudeSpanE6() / d1) / Math.log(2.0D));
      localObject = getController();
      if (d2 >= d1) {
        break label208;
      }
      d1 = d2;
    }
    label181:
    label208:
    for (;;)
    {
      ((IMapController)localObject).setZoom((int)d1);
      getController().setCenter(new GeoPoint(paramBoundingBoxE6.getCenter().getLatitudeE6(), paramBoundingBoxE6.getCenter().getLongitudeE6()));
      return;
      d1 = ((BoundingBoxE6)localObject).getLatitudeSpanE6() / Math.pow(2.0D, getMaxZoomLevel() - this.mZoomLevel);
      break;
      d1 = ((BoundingBoxE6)localObject).getLongitudeSpanE6() / Math.pow(2.0D, getMaxZoomLevel() - this.mZoomLevel);
      break label70;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public static final int BOTTOM_CENTER = 8;
    public static final int BOTTOM_LEFT = 7;
    public static final int BOTTOM_RIGHT = 9;
    public static final int CENTER = 5;
    public static final int CENTER_LEFT = 4;
    public static final int CENTER_RIGHT = 6;
    public static final int TOP_CENTER = 2;
    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 3;
    public int alignment;
    public IGeoPoint geoPoint;
    public int offsetX;
    public int offsetY;
    
    public LayoutParams(int paramInt1, int paramInt2, IGeoPoint paramIGeoPoint, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      if (paramIGeoPoint != null) {}
      for (this.geoPoint = paramIGeoPoint;; this.geoPoint = new GeoPoint(0, 0))
      {
        this.alignment = paramInt3;
        this.offsetX = paramInt4;
        this.offsetY = paramInt5;
        return;
      }
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.geoPoint = new GeoPoint(0, 0);
      this.alignment = 8;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  private class MapViewDoubleClickListener
    implements GestureDetector.OnDoubleTapListener
  {
    private MapViewDoubleClickListener() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (MapView.this.getOverlayManager().onDoubleTap(paramMotionEvent, MapView.this)) {
        return true;
      }
      paramMotionEvent = MapView.this.getProjection().screenToGeoPoint(paramMotionEvent.getX(), paramMotionEvent.getY());
      return MapView.this.zoomInFixing(paramMotionEvent);
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return MapView.this.getOverlayManager().onDoubleTapEvent(paramMotionEvent, MapView.this);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return MapView.this.getOverlayManager().onSingleTapConfirmed(paramMotionEvent, MapView.this);
    }
  }
  
  private class MapViewGestureDetectorListener
    implements GestureDetector.OnGestureListener
  {
    private MapViewGestureDetectorListener() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      if (MapView.this.mIsFlinging)
      {
        MapView.this.mScroller.abortAnimation();
        MapView.this.mIsFlinging = false;
      }
      if (MapView.this.getOverlayManager().onDown(paramMotionEvent, MapView.this)) {
        return true;
      }
      MapView.this.mZoomController.setVisible(MapView.this.mEnableZoomController);
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (MapView.this.getOverlayManager().onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2, MapView.this)) {
        return true;
      }
      int i = TileSystem.MapSize(MapView.this.getZoomLevel(false));
      MapView.this.mIsFlinging = true;
      MapView.this.mScroller.fling(MapView.this.getScrollX(), MapView.this.getScrollY(), (int)-paramFloat1, (int)-paramFloat2, -i, i, -i, i);
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      MapView.this.invalidate();
      MapView.this.getOverlayManager().onLongPress(paramMotionEvent, MapView.this);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (MapView.this.getOverlayManager().onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2, MapView.this)) {
        return true;
      }
      MapView.this.scrollBy((int)paramFloat1, (int)paramFloat2);
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      MapView.this.getOverlayManager().onShowPress(paramMotionEvent, MapView.this);
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return MapView.this.getOverlayManager().onSingleTapUp(paramMotionEvent, MapView.this);
    }
  }
  
  private class MapViewScaleGestureListener
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    private final PointF previousFocus = new PointF();
    private IGeoPoint startFocusGeoPoint;
    private final PointF startFocusScreen = new PointF();
    private float timeSinceTileUpdate = 0.0F;
    
    private MapViewScaleGestureListener() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      this.timeSinceTileUpdate += (float)paramScaleGestureDetector.getTimeDelta();
      if ((this.timeSinceTileUpdate > 2000.0F) && (f < 1.01D) && (f > 0.99D))
      {
        MapView.this.updateMapTiles();
        this.timeSinceTileUpdate = 0.0F;
      }
      PointF localPointF = new PointF();
      localPointF.x = (paramScaleGestureDetector.getFocusX() - this.previousFocus.x);
      localPointF.y = (paramScaleGestureDetector.getFocusY() - this.previousFocus.y);
      localPointF = new PointF();
      localPointF.x = (paramScaleGestureDetector.getFocusX() - this.startFocusScreen.x);
      localPointF.y = (paramScaleGestureDetector.getFocusY() - this.startFocusScreen.y);
      MapView.this.addScale(f, this.startFocusScreen, this.startFocusGeoPoint, localPointF);
      this.previousFocus.x = paramScaleGestureDetector.getFocusX();
      this.previousFocus.y = paramScaleGestureDetector.getFocusY();
      return true;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      this.startFocusScreen.x = paramScaleGestureDetector.getFocusX();
      this.startFocusScreen.y = paramScaleGestureDetector.getFocusY();
      this.previousFocus.x = this.startFocusScreen.x;
      this.previousFocus.y = this.startFocusScreen.y;
      this.startFocusGeoPoint = MapView.this.getProjection().screenToGeoPoint(this.startFocusScreen.x, this.startFocusScreen.y);
      this.timeSinceTileUpdate = 0.0F;
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      MapView.this.updateMapTiles();
      this.timeSinceTileUpdate = 0.0F;
    }
  }
  
  private class MapViewZoomListener
    implements ZoomButtonsController.OnZoomListener
  {
    private MapViewZoomListener() {}
    
    public void onVisibilityChanged(boolean paramBoolean) {}
    
    public void onZoom(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        MapView.this.getController().zoomIn();
        return;
      }
      MapView.this.getController().zoomOut();
    }
  }
  
  public class Projection
    implements IProjection, GeoConstants
  {
    private final BoundingBoxE6 mBoundingBoxProjection = MapView.this.getBoundingBox();
    private final Rect mIntrinsicScreenRectProjection = MapView.this.getIntrinsicScreenRect(null);
    private final float mMapOrientation = MapView.this.getMapOrientation();
    private final PointF mMultiTouchScalePointProjection = MapView.this.mMultiTouchScalePoint;
    private final float mMultiTouchScaleProjection = MapView.this.mMultiTouchScale;
    private final Rect mScreenRectProjection = MapView.this.getScreenRect(null);
    private final int mZoomLevelProjection = MapView.this.mZoomLevel;
    private final int viewHeight_2 = MapView.this.getHeight() / 2;
    private final int viewWidth_2 = MapView.this.getWidth() / 2;
    @Deprecated
    private final int worldSizeOffsetX = -this.worldSize_2;
    @Deprecated
    private final int worldSizeOffsetY = -this.worldSize_2;
    private final int worldSize_2 = TileSystem.MapSize(MapView.this.mZoomLevel) / 2;
    
    private Projection() {}
    
    public PointF centerForGeoPointMatchesScreenPixel(IGeoPoint paramIGeoPoint, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      paramIGeoPoint = TileSystem.LatLongToPixelXY(paramIGeoPoint.getLatitude(), paramIGeoPoint.getLongitude(), this.mZoomLevelProjection, null);
      return centerForMapMatchesScreenPixel(paramIGeoPoint.x, paramIGeoPoint.y, paramFloat1, paramFloat2, paramFloat3);
    }
    
    public PointF centerForMapMatchesScreenPixel(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      PointF localPointF = mapToInternalPixels(paramFloat1, paramFloat2);
      return new PointF(localPointF.x - (paramFloat3 - this.viewWidth_2) / paramFloat5, localPointF.y - (paramFloat4 - this.viewHeight_2) / paramFloat5);
    }
    
    @Deprecated
    public Point fromMapPixels(int paramInt1, int paramInt2, Point paramPoint)
    {
      if (paramPoint != null) {}
      for (;;)
      {
        int i = this.viewWidth_2;
        int j = MapView.this.getScrollX();
        int k = this.viewHeight_2;
        int m = MapView.this.getScrollY();
        PointF localPointF = this.mMultiTouchScalePointProjection;
        float f4 = this.mMultiTouchScaleProjection;
        float f1 = localPointF.x;
        float f2 = (paramInt1 - i + j - localPointF.x) / f4;
        float f3 = localPointF.y;
        f4 = (paramInt2 - k + m - localPointF.y) / f4;
        paramPoint.set((int)(f1 + f2), (int)(f3 + f4));
        return paramPoint;
        paramPoint = new Point();
      }
    }
    
    @Deprecated
    public IGeoPoint fromPixels(float paramFloat1, float paramFloat2)
    {
      Point localPoint = fromMapPixels((int)paramFloat1, (int)paramFloat2, null);
      int i = localPoint.x;
      int j = this.worldSize_2;
      int k = localPoint.y;
      int m = this.worldSize_2;
      return TileSystem.PixelXYToLatLong(i + j, k + m, MapView.this.mZoomLevel, null);
    }
    
    public IGeoPoint fromPixels(int paramInt1, int paramInt2)
    {
      return fromPixels(paramInt1, paramInt2);
    }
    
    @Deprecated
    public Rect fromPixelsToProjected(Rect paramRect)
    {
      Rect localRect = new Rect();
      int m = 22 - getZoomLevel();
      int i = paramRect.left - this.worldSizeOffsetX << m;
      int j = paramRect.right - this.worldSizeOffsetX << m;
      int k = paramRect.bottom - this.worldSizeOffsetY << m;
      m = paramRect.top - this.worldSizeOffsetY << m;
      localRect.set(Math.min(i, j), Math.min(k, m), Math.max(i, j), Math.max(k, m));
      return localRect;
    }
    
    public IGeoPoint geoPointAtCenter()
    {
      int i = MapView.this.getWidth() / 2;
      int j = MapView.this.getHeight() / 2;
      return screenToGeoPoint(i, j);
    }
    
    public PointF geoPointToScreenPixels(IGeoPoint paramIGeoPoint)
    {
      paramIGeoPoint = TileSystem.LatLongToPixelXY(paramIGeoPoint.getLatitude(), paramIGeoPoint.getLongitude(), this.mZoomLevelProjection, null);
      return mapToScreenPixels(paramIGeoPoint.x, paramIGeoPoint.y);
    }
    
    public BoundingBoxE6 getBoundingBox()
    {
      return this.mBoundingBoxProjection;
    }
    
    public Rect getIntrinsicScreenRect()
    {
      return this.mIntrinsicScreenRectProjection;
    }
    
    public float getMapOrientation()
    {
      return this.mMapOrientation;
    }
    
    public float getMultiTouchScaleProjection()
    {
      return MapView.this.mMultiTouchScale;
    }
    
    public IGeoPoint getNorthEast()
    {
      return fromPixels(MapView.this.getWidth(), 0);
    }
    
    public Rect getScreenRect()
    {
      return this.mScreenRectProjection;
    }
    
    public IGeoPoint getSouthWest()
    {
      return fromPixels(0, MapView.this.getHeight());
    }
    
    public int getZoomLevel()
    {
      return this.mZoomLevelProjection;
    }
    
    public PointF internalToMapPixel(float paramFloat1, float paramFloat2)
    {
      paramFloat1 += this.worldSize_2;
      float f = paramFloat2 + this.worldSize_2;
      for (;;)
      {
        paramFloat2 = paramFloat1;
        if (paramFloat1 >= 0.0F) {
          break;
        }
        paramFloat1 += this.worldSize_2 * 2;
      }
      for (;;)
      {
        paramFloat1 = f;
        if (paramFloat2 <= this.worldSize_2 * 2) {
          break;
        }
        paramFloat2 -= this.worldSize_2 * 2;
      }
      for (;;)
      {
        f = paramFloat1;
        if (paramFloat1 >= 0.0F) {
          break;
        }
        paramFloat1 += this.worldSize_2 * 2;
      }
      while (f > this.worldSize_2 * 2) {
        f -= this.worldSize_2 * 2;
      }
      return new PointF(paramFloat2, f);
    }
    
    public PointF internalToScreenPixels(float paramFloat1, float paramFloat2)
    {
      return internalToScreenPixels(paramFloat1, paramFloat2, MapView.this.getScrollX(), MapView.this.getScrollY(), this.mMultiTouchScaleProjection, this.mMultiTouchScalePointProjection.x, this.mMultiTouchScalePointProjection.y);
    }
    
    public PointF internalToScreenPixels(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
    {
      return new PointF(this.viewWidth_2 + ((paramFloat1 - paramFloat6) * paramFloat5 + paramFloat6) - paramFloat3, this.viewHeight_2 + ((paramFloat2 - paramFloat7) * paramFloat5 + paramFloat7) - paramFloat4);
    }
    
    public IGeoPoint mapPixelToGeoPoint(float paramFloat1, float paramFloat2)
    {
      return TileSystem.PixelXYToLatLong(paramFloat1, paramFloat2, this.mZoomLevelProjection, null);
    }
    
    public PointF mapToInternalPixels(float paramFloat1, float paramFloat2)
    {
      PointF localPointF = new PointF(paramFloat1, paramFloat2);
      localPointF.offset(this.worldSizeOffsetX, this.worldSizeOffsetY);
      if (Math.abs(localPointF.x - MapView.this.getScrollX()) > Math.abs(localPointF.x - TileSystem.MapSize(getZoomLevel()) - MapView.this.getScrollX())) {
        localPointF.x -= TileSystem.MapSize(getZoomLevel());
      }
      if (Math.abs(localPointF.x - MapView.this.getScrollX()) > Math.abs(localPointF.x + TileSystem.MapSize(getZoomLevel()) - MapView.this.getScrollX())) {
        localPointF.x += TileSystem.MapSize(getZoomLevel());
      }
      if (Math.abs(localPointF.y - MapView.this.getScrollY()) > Math.abs(localPointF.y - TileSystem.MapSize(getZoomLevel()) - MapView.this.getScrollY())) {
        localPointF.y -= TileSystem.MapSize(getZoomLevel());
      }
      if (Math.abs(localPointF.y - MapView.this.getScrollY()) > Math.abs(localPointF.y + TileSystem.MapSize(getZoomLevel()) - MapView.this.getScrollY())) {
        localPointF.y += TileSystem.MapSize(getZoomLevel());
      }
      return localPointF;
    }
    
    public PointF mapToScreenPixels(float paramFloat1, float paramFloat2)
    {
      return mapToScreenPixels(paramFloat1, paramFloat2, MapView.this.getScrollX(), MapView.this.getScrollY(), this.mMultiTouchScaleProjection, this.mMultiTouchScalePointProjection.x, this.mMultiTouchScalePointProjection.y);
    }
    
    public PointF mapToScreenPixels(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
    {
      PointF localPointF = mapToInternalPixels(paramFloat1, paramFloat2);
      return internalToScreenPixels(localPointF.x, localPointF.y, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    }
    
    public float metersToEquatorPixels(float paramFloat)
    {
      return paramFloat / (float)TileSystem.GroundResolution(0.0D, this.mZoomLevelProjection);
    }
    
    public Rect screenRect()
    {
      float f1 = MapView.this.getWidth();
      float f2 = MapView.this.getHeight();
      PointF localPointF1 = screenToInternalPixel(0.0F, 0.0F);
      PointF localPointF2 = screenToInternalPixel(f1, f2);
      return new Rect((int)localPointF1.x, (int)localPointF1.y, (int)localPointF2.x, (int)localPointF2.y);
    }
    
    public IGeoPoint screenToGeoPoint(float paramFloat1, float paramFloat2)
    {
      PointF localPointF = screenToMapPixels(paramFloat1, paramFloat2);
      return mapPixelToGeoPoint(localPointF.x, localPointF.y);
    }
    
    public PointF screenToInternalPixel(float paramFloat1, float paramFloat2)
    {
      float f1 = this.viewWidth_2;
      float f2 = MapView.this.getScrollX();
      float f3 = this.viewHeight_2;
      float f4 = MapView.this.getScrollY();
      float f5 = this.mMultiTouchScaleProjection;
      float f6 = this.mMultiTouchScalePointProjection.x;
      float f7 = this.mMultiTouchScalePointProjection.y;
      return new PointF((paramFloat1 - f1 + f2 - f6) / f5 + f6, (paramFloat2 - f3 + f4 - f7) / f5 + f7);
    }
    
    public PointF screenToMapPixels(float paramFloat1, float paramFloat2)
    {
      PointF localPointF = screenToInternalPixel(paramFloat1, paramFloat2);
      return internalToMapPixel(localPointF.x, localPointF.y);
    }
    
    @Deprecated
    public Point toMapPixels(IGeoPoint paramIGeoPoint, Point paramPoint)
    {
      if (paramPoint != null) {}
      for (;;)
      {
        TileSystem.LatLongToPixelXY(paramIGeoPoint.getLatitude(), paramIGeoPoint.getLongitude(), getZoomLevel(), paramPoint);
        paramIGeoPoint = mapToInternalPixels(paramPoint.x, paramPoint.y);
        paramPoint.set((int)paramIGeoPoint.x, (int)paramIGeoPoint.y);
        return paramPoint;
        paramPoint = new Point();
      }
    }
    
    @Deprecated
    public Point toMapPixelsProjected(int paramInt1, int paramInt2, Point paramPoint)
    {
      if (paramPoint != null) {}
      for (;;)
      {
        TileSystem.LatLongToPixelXY(paramInt1 * 1.0E-6D, paramInt2 * 1.0E-6D, 22, paramPoint);
        return paramPoint;
        paramPoint = new Point();
      }
    }
    
    @Deprecated
    public Point toMapPixelsTranslated(Point paramPoint1, Point paramPoint2)
    {
      if (paramPoint2 != null) {}
      for (;;)
      {
        int i = 22 - getZoomLevel();
        paramPoint2.set((paramPoint1.x >> i) + this.worldSizeOffsetX, (paramPoint1.y >> i) + this.worldSizeOffsetY);
        return paramPoint2;
        paramPoint2 = new Point();
      }
    }
    
    public Point toPixels(IGeoPoint paramIGeoPoint, Point paramPoint)
    {
      return toMapPixels(paramIGeoPoint, paramPoint);
    }
    
    @Deprecated
    public Rect toPixels(BoundingBoxE6 paramBoundingBoxE6)
    {
      Rect localRect = new Rect();
      Point localPoint = new Point();
      toMapPixels(new GeoPoint(paramBoundingBoxE6.getLatNorthE6(), paramBoundingBoxE6.getLonWestE6()), localPoint);
      localRect.left = localPoint.x;
      localRect.top = localPoint.y;
      toMapPixels(new GeoPoint(paramBoundingBoxE6.getLatSouthE6(), paramBoundingBoxE6.getLonEastE6()), localPoint);
      localRect.right = localPoint.x;
      localRect.bottom = localPoint.y;
      return localRect;
    }
    
    @Deprecated
    public Point toPixelsScaled(IGeoPoint paramIGeoPoint, Point paramPoint)
    {
      paramIGeoPoint = toMapPixels(paramIGeoPoint, paramPoint);
      paramPoint = this.mMultiTouchScalePointProjection;
      float f1 = this.mMultiTouchScaleProjection;
      float f2 = paramIGeoPoint.x;
      float f3 = paramPoint.x;
      float f4 = paramPoint.x;
      float f5 = paramIGeoPoint.y;
      float f6 = paramPoint.y;
      float f7 = paramPoint.y;
      return new Point((int)((f2 - f3) * f1 + f4), (int)((f5 - f6) * f1 + f7));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */