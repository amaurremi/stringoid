package org.osmdroid.views.overlay.mylocation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.util.FloatMath;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.LinkedList;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.api.IMapController;
import org.osmdroid.api.IMapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.TileSystem;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.overlay.IOverlayMenuProvider;
import org.osmdroid.views.overlay.Overlay.Snappable;
import org.osmdroid.views.overlay.SafeDrawOverlay;
import org.osmdroid.views.safecanvas.ISafeCanvas;
import org.osmdroid.views.safecanvas.SafePaint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLocationNewOverlay
  extends SafeDrawOverlay
  implements IMyLocationConsumer, IOverlayMenuProvider, Overlay.Snappable
{
  public static final int MENU_MY_LOCATION = getSafeMenuId();
  private static final Logger logger = LoggerFactory.getLogger(MyLocationNewOverlay.class);
  protected final SafePaint mCirclePaint = new SafePaint();
  protected final Bitmap mDirectionArrowBitmap;
  protected final double mDirectionArrowCenterX;
  protected final double mDirectionArrowCenterY;
  protected boolean mDrawAccuracyEnabled = true;
  private final GeoPoint mGeoPoint = new GeoPoint(0, 0);
  protected boolean mIsFollowing = false;
  private boolean mIsLocationEnabled = false;
  private Location mLocation;
  private final IMapController mMapController;
  private final Point mMapCoords = new Point();
  protected final MapView mMapView;
  private final Matrix mMatrix = new Matrix();
  private final float[] mMatrixValues = new float[9];
  private final Rect mMyLocationPreviousRect = new Rect();
  public IMyLocationProvider mMyLocationProvider;
  private final Rect mMyLocationRect = new Rect();
  private boolean mOptionsMenuEnabled = true;
  protected final SafePaint mPaint = new SafePaint();
  protected final Bitmap mPersonBitmap;
  protected final PointF mPersonHotspot;
  private final LinkedList<Runnable> mRunOnFirstFix = new LinkedList();
  
  public MyLocationNewOverlay(Context paramContext, MapView paramMapView)
  {
    this(paramContext, new GpsMyLocationProvider(paramContext), paramMapView);
  }
  
  public MyLocationNewOverlay(Context paramContext, IMyLocationProvider paramIMyLocationProvider, MapView paramMapView)
  {
    this(paramIMyLocationProvider, paramMapView, new DefaultResourceProxyImpl(paramContext));
  }
  
  public MyLocationNewOverlay(IMyLocationProvider paramIMyLocationProvider, MapView paramMapView, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    this.mMapView = paramMapView;
    this.mMapController = paramMapView.getController();
    this.mCirclePaint.setARGB(0, 100, 100, 255);
    this.mCirclePaint.setAntiAlias(true);
    this.mPersonBitmap = this.mResourceProxy.getBitmap(ResourceProxy.bitmap.person);
    this.mDirectionArrowBitmap = this.mResourceProxy.getBitmap(ResourceProxy.bitmap.direction_arrow);
    this.mDirectionArrowCenterX = (this.mDirectionArrowBitmap.getWidth() / 2.0D - 0.5D);
    this.mDirectionArrowCenterY = (this.mDirectionArrowBitmap.getHeight() / 2.0D - 0.5D);
    this.mPersonHotspot = new PointF(24.0F * this.mScale + 0.5F, 39.0F * this.mScale + 0.5F);
    setMyLocationProvider(paramIMyLocationProvider);
  }
  
  public void disableFollowLocation()
  {
    this.mIsFollowing = false;
  }
  
  public void disableMyLocation()
  {
    this.mIsLocationEnabled = false;
    if (this.mMyLocationProvider != null) {
      this.mMyLocationProvider.stopLocationProvider();
    }
    if (this.mMapView != null) {
      this.mMapView.postInvalidate();
    }
  }
  
  protected void drawMyLocation(ISafeCanvas paramISafeCanvas, MapView paramMapView, Location paramLocation)
  {
    int i = 22 - paramMapView.getProjection().getZoomLevel();
    if (this.mDrawAccuracyEnabled)
    {
      f1 = paramLocation.getAccuracy() / (float)TileSystem.GroundResolution(paramLocation.getLatitude(), paramMapView.getZoomLevel());
      this.mCirclePaint.setAlpha(50);
      this.mCirclePaint.setStyle(Paint.Style.FILL);
      paramISafeCanvas.drawCircle(this.mMapCoords.x >> i, this.mMapCoords.y >> i, f1, this.mCirclePaint);
      this.mCirclePaint.setAlpha(150);
      this.mCirclePaint.setStyle(Paint.Style.STROKE);
      paramISafeCanvas.drawCircle(this.mMapCoords.x >> i, this.mMapCoords.y >> i, f1, this.mCirclePaint);
    }
    paramISafeCanvas.getMatrix(this.mMatrix);
    this.mMatrix.getValues(this.mMatrixValues);
    float f1 = (float)Math.sqrt(this.mMatrixValues[0] * this.mMatrixValues[0] + this.mMatrixValues[3] * this.mMatrixValues[3]);
    float f2 = (float)Math.sqrt(this.mMatrixValues[4] * this.mMatrixValues[4] + this.mMatrixValues[1] * this.mMatrixValues[1]);
    double d1 = this.mMapCoords.x >> i;
    double d2 = this.mMapCoords.y >> i;
    if (paramLocation.hasBearing())
    {
      paramISafeCanvas.save();
      paramISafeCanvas.rotate(paramLocation.getBearing(), d1, d2);
      paramISafeCanvas.scale(1.0F / f1, 1.0F / f2, d1, d2);
      paramISafeCanvas.drawBitmap(this.mDirectionArrowBitmap, d1 - this.mDirectionArrowCenterX, d2 - this.mDirectionArrowCenterY, this.mPaint);
      paramISafeCanvas.restore();
      return;
    }
    paramISafeCanvas.save();
    paramISafeCanvas.rotate(-this.mMapView.getMapOrientation(), d1, d2);
    paramISafeCanvas.scale(1.0F / f1, 1.0F / f2, d1, d2);
    paramISafeCanvas.drawBitmap(this.mPersonBitmap, d1 - this.mPersonHotspot.x, d2 - this.mPersonHotspot.y, this.mPaint);
    paramISafeCanvas.restore();
  }
  
  protected void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((this.mLocation == null) || (!isMyLocationEnabled())) {
      return;
    }
    drawMyLocation(paramISafeCanvas, paramMapView, this.mLocation);
  }
  
  public void enableFollowLocation()
  {
    this.mIsFollowing = true;
    if (isMyLocationEnabled())
    {
      this.mLocation = this.mMyLocationProvider.getLastKnownLocation();
      if (this.mLocation != null)
      {
        TileSystem.LatLongToPixelXY(this.mLocation.getLatitude(), this.mLocation.getLongitude(), 22, this.mMapCoords);
        int i = TileSystem.MapSize(22) / 2;
        this.mMapCoords.offset(-i, -i);
        this.mMapController.animateTo(new GeoPoint(this.mLocation));
      }
    }
    if (this.mMapView != null) {
      this.mMapView.postInvalidate();
    }
  }
  
  public boolean enableMyLocation()
  {
    if (this.mIsLocationEnabled) {
      this.mMyLocationProvider.stopLocationProvider();
    }
    boolean bool = this.mMyLocationProvider.startLocationProvider(this);
    this.mIsLocationEnabled = bool;
    if ((bool) && (isFollowLocationEnabled()))
    {
      this.mLocation = this.mMyLocationProvider.getLastKnownLocation();
      if (this.mLocation != null)
      {
        TileSystem.LatLongToPixelXY(this.mLocation.getLatitude(), this.mLocation.getLongitude(), 22, this.mMapCoords);
        int i = TileSystem.MapSize(22) / 2;
        this.mMapCoords.offset(-i, -i);
        this.mMapController.animateTo(new GeoPoint(this.mLocation));
      }
    }
    if (this.mMapView != null) {
      this.mMapView.postInvalidate();
    }
    return bool;
  }
  
  public boolean enableMyLocation(IMyLocationProvider paramIMyLocationProvider)
  {
    setMyLocationProvider(paramIMyLocationProvider);
    this.mIsLocationEnabled = false;
    return enableMyLocation();
  }
  
  public Location getLastFix()
  {
    return this.mLocation;
  }
  
  public GeoPoint getMyLocation()
  {
    if (this.mLocation == null) {
      return null;
    }
    return new GeoPoint(this.mLocation);
  }
  
  protected Rect getMyLocationDrawingBounds(int paramInt, Location paramLocation, Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    int j = 22 - paramInt;
    int i = this.mMapCoords.x >> j;
    j = this.mMapCoords.y >> j;
    if (paramLocation.hasBearing())
    {
      int k = (int)Math.ceil(Math.max(this.mDirectionArrowBitmap.getWidth(), this.mDirectionArrowBitmap.getHeight()) * Math.sqrt(2.0D));
      localRect.set(i, j, i + k, j + k);
      localRect.offset(-k / 2, -k / 2);
      if (this.mDrawAccuracyEnabled)
      {
        paramInt = (int)FloatMath.ceil(paramLocation.getAccuracy() / (float)TileSystem.GroundResolution(paramLocation.getLatitude(), paramInt));
        localRect.union(i - paramInt, j - paramInt, i + paramInt, j + paramInt);
        if (this.mCirclePaint.getStrokeWidth() != 0.0F) {
          break label260;
        }
      }
    }
    label260:
    for (float f = 1.0F;; f = this.mCirclePaint.getStrokeWidth())
    {
      paramInt = (int)FloatMath.ceil(f);
      localRect.inset(-paramInt, -paramInt);
      return localRect;
      localRect.set(i, j, this.mPersonBitmap.getWidth() + i, this.mPersonBitmap.getHeight() + j);
      localRect.offset((int)(-this.mPersonHotspot.x + 0.5F), (int)(-this.mPersonHotspot.y + 0.5F));
      break;
    }
  }
  
  public IMyLocationProvider getMyLocationProvider()
  {
    return this.mMyLocationProvider;
  }
  
  public boolean isDrawAccuracyEnabled()
  {
    return this.mDrawAccuracyEnabled;
  }
  
  public boolean isFollowLocationEnabled()
  {
    return this.mIsFollowing;
  }
  
  public boolean isMyLocationEnabled()
  {
    return this.mIsLocationEnabled;
  }
  
  public boolean isOptionsMenuEnabled()
  {
    return this.mOptionsMenuEnabled;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    paramMenu.add(0, MENU_MY_LOCATION + paramInt, 0, this.mResourceProxy.getString(ResourceProxy.string.my_location)).setIcon(this.mResourceProxy.getDrawable(ResourceProxy.bitmap.ic_menu_mylocation)).setCheckable(true);
    return true;
  }
  
  public void onDetach(MapView paramMapView)
  {
    disableMyLocation();
    super.onDetach(paramMapView);
  }
  
  public void onLocationChanged(Location paramLocation, IMyLocationProvider paramIMyLocationProvider)
  {
    paramIMyLocationProvider = this.mLocation;
    if (paramIMyLocationProvider != null) {
      getMyLocationDrawingBounds(this.mMapView.getZoomLevel(), paramIMyLocationProvider, this.mMyLocationPreviousRect);
    }
    this.mLocation = paramLocation;
    this.mMapCoords.set(0, 0);
    final int i;
    if (this.mLocation != null)
    {
      TileSystem.LatLongToPixelXY(this.mLocation.getLatitude(), this.mLocation.getLongitude(), 22, this.mMapCoords);
      i = TileSystem.MapSize(22) / 2;
      this.mMapCoords.offset(-i, -i);
      if (!this.mIsFollowing) {
        break label187;
      }
      this.mGeoPoint.setLatitudeE6((int)(this.mLocation.getLatitude() * 1000000.0D));
      this.mGeoPoint.setLongitudeE6((int)(this.mLocation.getLongitude() * 1000000.0D));
      this.mMapController.animateTo(this.mGeoPoint);
    }
    for (;;)
    {
      paramLocation = this.mRunOnFirstFix.iterator();
      while (paramLocation.hasNext()) {
        new Thread((Runnable)paramLocation.next()).start();
      }
      label187:
      getMyLocationDrawingBounds(this.mMapView.getZoomLevel(), this.mLocation, this.mMyLocationRect);
      if (paramIMyLocationProvider != null) {
        this.mMyLocationRect.union(this.mMyLocationPreviousRect);
      }
      i = this.mMyLocationRect.left;
      final int j = this.mMyLocationRect.top;
      final int k = this.mMyLocationRect.right;
      final int m = this.mMyLocationRect.bottom;
      this.mMapView.post(new Runnable()
      {
        public void run()
        {
          MyLocationNewOverlay.this.mMapView.invalidateMapCoordinates(i, j, k, m);
        }
      });
    }
    this.mRunOnFirstFix.clear();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem, int paramInt, MapView paramMapView)
  {
    if (paramMenuItem.getItemId() - paramInt == MENU_MY_LOCATION)
    {
      if (isMyLocationEnabled())
      {
        disableFollowLocation();
        disableMyLocation();
      }
      for (;;)
      {
        return true;
        enableFollowLocation();
        enableMyLocation();
      }
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    paramMenu.findItem(MENU_MY_LOCATION + paramInt).setChecked(isMyLocationEnabled());
    return false;
  }
  
  public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, IMapView paramIMapView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLocation != null)
    {
      paramPoint.x = this.mMapCoords.x;
      paramPoint.y = this.mMapCoords.y;
      double d1 = paramInt1 - this.mMapCoords.x;
      double d2 = paramInt2 - this.mMapCoords.y;
      bool1 = bool2;
      if (d1 * d1 + d2 * d2 < 64.0D) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if (paramMotionEvent.getAction() == 2) {
      disableFollowLocation();
    }
    return super.onTouchEvent(paramMotionEvent, paramMapView);
  }
  
  public boolean runOnFirstFix(Runnable paramRunnable)
  {
    if ((this.mMyLocationProvider != null) && (this.mLocation != null))
    {
      new Thread(paramRunnable).start();
      return true;
    }
    this.mRunOnFirstFix.addLast(paramRunnable);
    return false;
  }
  
  public void setDrawAccuracyEnabled(boolean paramBoolean)
  {
    this.mDrawAccuracyEnabled = paramBoolean;
  }
  
  protected void setMyLocationProvider(IMyLocationProvider paramIMyLocationProvider)
  {
    if (paramIMyLocationProvider == null) {
      throw new RuntimeException("You must pass an IMyLocationProvider to setMyLocationProvider()");
    }
    if (this.mMyLocationProvider != null) {
      this.mMyLocationProvider.stopLocationProvider();
    }
    this.mMyLocationProvider = paramIMyLocationProvider;
  }
  
  public void setOptionsMenuEnabled(boolean paramBoolean)
  {
    this.mOptionsMenuEnabled = paramBoolean;
  }
  
  public void setPersonHotspot(float paramFloat1, float paramFloat2)
  {
    this.mPersonHotspot.set(paramFloat1, paramFloat2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/mylocation/MyLocationNewOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */