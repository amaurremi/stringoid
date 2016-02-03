package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.LinkedList;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.LocationListenerProxy;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.SensorEventListenerProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.api.IMapView;
import org.osmdroid.api.IMyLocationOverlay;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.LocationUtils;
import org.osmdroid.util.NetworkLocationIgnorer;
import org.osmdroid.util.TileSystem;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public class MyLocationOverlay
  extends Overlay
  implements IMyLocationOverlay, IOverlayMenuProvider, SensorEventListener, LocationListener, Overlay.Snappable
{
  public static final int MENU_COMPASS = getSafeMenuId();
  public static final int MENU_MY_LOCATION;
  private static final Logger logger = LoggerFactory.getLogger(MyLocationOverlay.class);
  protected final float COMPASS_FRAME_CENTER_X;
  protected final float COMPASS_FRAME_CENTER_Y;
  protected final float COMPASS_ROSE_CENTER_X;
  protected final float COMPASS_ROSE_CENTER_Y;
  protected final Bitmap DIRECTION_ARROW;
  protected final float DIRECTION_ARROW_CENTER_X;
  protected final float DIRECTION_ARROW_CENTER_Y;
  protected final PointF PERSON_HOTSPOT;
  protected final Bitmap PERSON_ICON;
  private final Matrix directionRotater = new Matrix();
  private float mAzimuth = NaN.0F;
  protected final Paint mCirclePaint = new Paint();
  private float mCompassCenterX = 35.0F;
  private float mCompassCenterY = 35.0F;
  protected final Picture mCompassFrame = new Picture();
  private final Matrix mCompassMatrix = new Matrix();
  private final float mCompassRadius = 20.0F;
  protected final Picture mCompassRose = new Picture();
  private final Display mDisplay;
  protected boolean mDrawAccuracyEnabled = true;
  protected boolean mFollow = false;
  private final GeoPoint mGeoPoint = new GeoPoint(0, 0);
  private final NetworkLocationIgnorer mIgnorer = new NetworkLocationIgnorer();
  private Location mLocation;
  public LocationListenerProxy mLocationListener = null;
  private final LocationManager mLocationManager;
  private float mLocationUpdateMinDistance = 0.0F;
  private long mLocationUpdateMinTime = 0L;
  private final IMapController mMapController;
  private final Point mMapCoords = new Point();
  protected final MapView mMapView;
  private final Matrix mMatrix = new Matrix();
  private final float[] mMatrixValues = new float[9];
  private final Rect mMyLocationPreviousRect = new Rect();
  private final Rect mMyLocationRect = new Rect();
  private boolean mOptionsMenuEnabled = true;
  protected final Paint mPaint = new Paint();
  private final LinkedList<Runnable> mRunOnFirstFix = new LinkedList();
  public SensorEventListenerProxy mSensorListener = null;
  private final SensorManager mSensorManager;
  
  static
  {
    MENU_MY_LOCATION = getSafeMenuId();
  }
  
  public MyLocationOverlay(Context paramContext, MapView paramMapView)
  {
    this(paramContext, paramMapView, new DefaultResourceProxyImpl(paramContext));
  }
  
  public MyLocationOverlay(Context paramContext, MapView paramMapView, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    this.mMapView = paramMapView;
    this.mLocationManager = ((LocationManager)paramContext.getSystemService("location"));
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.mMapController = paramMapView.getController();
    this.mCirclePaint.setARGB(0, 100, 100, 255);
    this.mCirclePaint.setAntiAlias(true);
    this.PERSON_ICON = this.mResourceProxy.getBitmap(ResourceProxy.bitmap.person);
    this.DIRECTION_ARROW = this.mResourceProxy.getBitmap(ResourceProxy.bitmap.direction_arrow);
    this.DIRECTION_ARROW_CENTER_X = (this.DIRECTION_ARROW.getWidth() / 2 - 0.5F);
    this.DIRECTION_ARROW_CENTER_Y = (this.DIRECTION_ARROW.getHeight() / 2 - 0.5F);
    this.PERSON_HOTSPOT = new PointF(24.0F * this.mScale + 0.5F, 39.0F * this.mScale + 0.5F);
    createCompassFramePicture();
    createCompassRosePicture();
    this.COMPASS_FRAME_CENTER_X = (this.mCompassFrame.getWidth() / 2 - 0.5F);
    this.COMPASS_FRAME_CENTER_Y = (this.mCompassFrame.getHeight() / 2 - 0.5F);
    this.COMPASS_ROSE_CENTER_X = (this.mCompassRose.getWidth() / 2 - 0.5F);
    this.COMPASS_ROSE_CENTER_Y = (this.mCompassRose.getHeight() / 2 - 0.5F);
  }
  
  private Point calculatePointOnCircle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    double d = Math.toRadians(-paramFloat4 + 90.0F);
    int i = (int)(paramFloat3 * Math.cos(d));
    int j = (int)(paramFloat3 * Math.sin(d));
    return new Point((int)paramFloat1 + i, (int)paramFloat2 - j);
  }
  
  private void createCompassFramePicture()
  {
    Paint localPaint1 = new Paint();
    localPaint1.setColor(-1);
    localPaint1.setAntiAlias(true);
    localPaint1.setStyle(Paint.Style.FILL);
    localPaint1.setAlpha(200);
    Paint localPaint2 = new Paint();
    localPaint2.setColor(-7829368);
    localPaint2.setAntiAlias(true);
    localPaint2.setStyle(Paint.Style.STROKE);
    localPaint2.setStrokeWidth(2.0F);
    localPaint2.setAlpha(200);
    Canvas localCanvas = this.mCompassFrame.beginRecording(50, 50);
    localCanvas.drawCircle(25.0F, 25.0F, this.mScale * 20.0F, localPaint1);
    localCanvas.drawCircle(25.0F, 25.0F, this.mScale * 20.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 0.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 90.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 180.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 270.0F, localPaint2);
    this.mCompassFrame.endRecording();
  }
  
  private void createCompassRosePicture()
  {
    Object localObject = new Paint();
    ((Paint)localObject).setColor(-6291456);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    ((Paint)localObject).setAlpha(220);
    Paint localPaint1 = new Paint();
    localPaint1.setColor(-16777216);
    localPaint1.setAntiAlias(true);
    localPaint1.setStyle(Paint.Style.FILL);
    localPaint1.setAlpha(220);
    Paint localPaint2 = new Paint();
    localPaint2.setColor(-1);
    localPaint2.setAntiAlias(true);
    localPaint2.setStyle(Paint.Style.FILL);
    localPaint2.setAlpha(220);
    Canvas localCanvas = this.mCompassRose.beginRecording(50, 50);
    Path localPath = new Path();
    localPath.moveTo(25.0F, 25.0F - this.mScale * 17.0F);
    localPath.lineTo(this.mScale * 4.0F + 25.0F, 25.0F);
    localPath.lineTo(25.0F - this.mScale * 4.0F, 25.0F);
    localPath.lineTo(25.0F, 25.0F - this.mScale * 17.0F);
    localPath.close();
    localCanvas.drawPath(localPath, (Paint)localObject);
    localObject = new Path();
    ((Path)localObject).moveTo(25.0F, this.mScale * 17.0F + 25.0F);
    ((Path)localObject).lineTo(this.mScale * 4.0F + 25.0F, 25.0F);
    ((Path)localObject).lineTo(25.0F - this.mScale * 4.0F, 25.0F);
    ((Path)localObject).lineTo(25.0F, this.mScale * 17.0F + 25.0F);
    ((Path)localObject).close();
    localCanvas.drawPath((Path)localObject, localPaint1);
    localCanvas.drawCircle(25.0F, 25.0F, 2.0F, localPaint2);
    this.mCompassRose.endRecording();
  }
  
  private void drawTriangle(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    paramCanvas.save();
    Point localPoint = calculatePointOnCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.rotate(paramFloat4, localPoint.x, localPoint.y);
    Path localPath = new Path();
    localPath.moveTo(localPoint.x - this.mScale * 2.0F, localPoint.y);
    localPath.lineTo(localPoint.x + this.mScale * 2.0F, localPoint.y);
    localPath.lineTo(localPoint.x, localPoint.y - 5.0F * this.mScale);
    localPath.close();
    paramCanvas.drawPath(localPath, paramPaint);
    paramCanvas.restore();
  }
  
  private int getDisplayOrientation()
  {
    switch (this.mDisplay.getOrientation())
    {
    default: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  private void invalidateCompass()
  {
    Rect localRect = this.mMapView.getProjection().getScreenRect();
    int i = localRect.left;
    int j = this.mMapView.getWidth() / 2;
    int k = (int)Math.ceil((this.mCompassCenterX - this.COMPASS_FRAME_CENTER_X) * this.mScale);
    int m = localRect.top;
    int n = this.mMapView.getHeight() / 2;
    int i1 = (int)Math.ceil((this.mCompassCenterY - this.COMPASS_FRAME_CENTER_Y) * this.mScale);
    int i2 = localRect.left;
    int i3 = this.mMapView.getWidth() / 2;
    int i4 = (int)Math.ceil((this.mCompassCenterX + this.COMPASS_FRAME_CENTER_X) * this.mScale);
    int i5 = localRect.top;
    int i6 = this.mMapView.getHeight() / 2;
    int i7 = (int)Math.ceil((this.mCompassCenterY + this.COMPASS_FRAME_CENTER_Y) * this.mScale);
    this.mMapView.postInvalidate(i + j + k - 2, m + n + i1 - 2, i2 + i3 + i4 + 2, i5 + i6 + i7 + 2);
  }
  
  public void disableCompass()
  {
    if (this.mSensorListener != null) {
      this.mSensorListener.stopListening();
    }
    this.mSensorListener = null;
    this.mAzimuth = NaN.0F;
    if (this.mMapView != null) {
      invalidateCompass();
    }
  }
  
  public void disableFollowLocation()
  {
    this.mFollow = false;
  }
  
  public void disableMyLocation()
  {
    if (this.mLocationListener != null) {
      this.mLocationListener.stopListening();
    }
    this.mLocationListener = null;
    if (this.mMapView != null) {
      this.mMapView.postInvalidate();
    }
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    do
    {
      return;
      if (this.mLocation != null) {
        drawMyLocation(paramCanvas, paramMapView, this.mLocation);
      }
    } while ((!isCompassEnabled()) || (Float.isNaN(this.mAzimuth)));
    drawCompass(paramCanvas, this.mAzimuth + getDisplayOrientation(), paramMapView.getProjection().getScreenRect());
  }
  
  protected void drawCompass(Canvas paramCanvas, float paramFloat, Rect paramRect)
  {
    float f1 = this.mCompassCenterX * this.mScale;
    float f2 = this.mCompassCenterY * this.mScale + (paramCanvas.getHeight() - this.mMapView.getHeight());
    this.mCompassMatrix.setTranslate(-this.COMPASS_FRAME_CENTER_X, -this.COMPASS_FRAME_CENTER_Y);
    this.mCompassMatrix.postTranslate(f1, f2);
    paramCanvas.save();
    paramCanvas.setMatrix(this.mCompassMatrix);
    paramCanvas.drawPicture(this.mCompassFrame);
    this.mCompassMatrix.setRotate(-paramFloat, this.COMPASS_ROSE_CENTER_X, this.COMPASS_ROSE_CENTER_Y);
    this.mCompassMatrix.postTranslate(-this.COMPASS_ROSE_CENTER_X, -this.COMPASS_ROSE_CENTER_Y);
    this.mCompassMatrix.postTranslate(f1, f2);
    paramCanvas.setMatrix(this.mCompassMatrix);
    paramCanvas.drawPicture(this.mCompassRose);
    paramCanvas.restore();
  }
  
  protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation)
  {
    int i = 22 - paramMapView.getProjection().getZoomLevel();
    if (this.mDrawAccuracyEnabled)
    {
      float f = paramLocation.getAccuracy() / (float)TileSystem.GroundResolution(paramLocation.getLatitude(), paramMapView.getZoomLevel());
      this.mCirclePaint.setAlpha(50);
      this.mCirclePaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(this.mMapCoords.x >> i, this.mMapCoords.y >> i, f, this.mCirclePaint);
      this.mCirclePaint.setAlpha(150);
      this.mCirclePaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(this.mMapCoords.x >> i, this.mMapCoords.y >> i, f, this.mCirclePaint);
    }
    paramCanvas.getMatrix(this.mMatrix);
    this.mMatrix.getValues(this.mMatrixValues);
    if (paramLocation.hasBearing())
    {
      this.directionRotater.setRotate(paramLocation.getBearing(), this.DIRECTION_ARROW_CENTER_X, this.DIRECTION_ARROW_CENTER_Y);
      this.directionRotater.postTranslate(-this.DIRECTION_ARROW_CENTER_X, -this.DIRECTION_ARROW_CENTER_Y);
      this.directionRotater.postScale(1.0F / this.mMatrixValues[0], 1.0F / this.mMatrixValues[4]);
      this.directionRotater.postTranslate(this.mMapCoords.x >> i, this.mMapCoords.y >> i);
      paramCanvas.drawBitmap(this.DIRECTION_ARROW, this.directionRotater, this.mPaint);
      return;
    }
    this.directionRotater.setTranslate(-this.PERSON_HOTSPOT.x, -this.PERSON_HOTSPOT.y);
    this.directionRotater.postScale(1.0F / this.mMatrixValues[0], 1.0F / this.mMatrixValues[4]);
    this.directionRotater.postTranslate(this.mMapCoords.x >> i, this.mMapCoords.y >> i);
    paramCanvas.drawBitmap(this.PERSON_ICON, this.directionRotater, this.mPaint);
  }
  
  public boolean enableCompass()
  {
    boolean bool = true;
    if (this.mSensorListener == null)
    {
      this.mSensorListener = new SensorEventListenerProxy(this.mSensorManager);
      bool = this.mSensorListener.startListening(this, 3, 2);
    }
    if (this.mMapView != null) {
      invalidateCompass();
    }
    return bool;
  }
  
  public void enableFollowLocation()
  {
    this.mFollow = true;
    if (isMyLocationEnabled())
    {
      this.mLocation = LocationUtils.getLastKnownLocation(this.mLocationManager);
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
    boolean bool = true;
    if (this.mLocationListener == null)
    {
      this.mLocationListener = new LocationListenerProxy(this.mLocationManager);
      bool = this.mLocationListener.startListening(this, this.mLocationUpdateMinTime, this.mLocationUpdateMinDistance);
    }
    if (isFollowLocationEnabled())
    {
      this.mLocation = LocationUtils.getLastKnownLocation(this.mLocationManager);
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
  
  @Deprecated
  public void followLocation(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      enableFollowLocation();
      return;
    }
    disableFollowLocation();
  }
  
  public Location getLastFix()
  {
    return this.mLocation;
  }
  
  public float getLocationUpdateMinDistance()
  {
    return this.mLocationUpdateMinDistance;
  }
  
  public long getLocationUpdateMinTime()
  {
    return this.mLocationUpdateMinTime;
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
      int k = (int)Math.ceil(Math.max(this.DIRECTION_ARROW.getWidth(), this.DIRECTION_ARROW.getHeight()) * Math.sqrt(2.0D));
      localRect.set(i, j, i + k, j + k);
      localRect.offset(-k / 2, -k / 2);
      if (this.mDrawAccuracyEnabled)
      {
        paramInt = (int)Math.ceil(paramLocation.getAccuracy() / (float)TileSystem.GroundResolution(paramLocation.getLatitude(), paramInt));
        localRect.union(i - paramInt, j - paramInt, i + paramInt, j + paramInt);
        if (this.mCirclePaint.getStrokeWidth() != 0.0F) {
          break label278;
        }
      }
    }
    label278:
    for (double d = 1.0D;; d = this.mCirclePaint.getStrokeWidth())
    {
      paramInt = (int)Math.ceil(d);
      localRect.inset(-paramInt, -paramInt);
      localRect.offset(this.mMapView.getWidth() / 2, this.mMapView.getHeight() / 2);
      return localRect;
      localRect.set(i, j, this.PERSON_ICON.getWidth() + i, this.PERSON_ICON.getHeight() + j);
      localRect.offset((int)-this.PERSON_HOTSPOT.x, (int)-this.PERSON_HOTSPOT.y);
      break;
    }
  }
  
  public float getOrientation()
  {
    return this.mAzimuth;
  }
  
  public boolean isCompassEnabled()
  {
    return this.mSensorListener != null;
  }
  
  public boolean isDrawAccuracyEnabled()
  {
    return this.mDrawAccuracyEnabled;
  }
  
  public boolean isFollowLocationEnabled()
  {
    return this.mFollow;
  }
  
  public boolean isMyLocationEnabled()
  {
    return this.mLocationListener != null;
  }
  
  public boolean isOptionsMenuEnabled()
  {
    return this.mOptionsMenuEnabled;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    paramMenu.add(0, MENU_MY_LOCATION + paramInt, 0, this.mResourceProxy.getString(ResourceProxy.string.my_location)).setIcon(this.mResourceProxy.getDrawable(ResourceProxy.bitmap.ic_menu_mylocation));
    paramMenu.add(0, MENU_COMPASS + paramInt, 0, this.mResourceProxy.getString(ResourceProxy.string.compass)).setIcon(this.mResourceProxy.getDrawable(ResourceProxy.bitmap.ic_menu_compass));
    return true;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (this.mIgnorer.shouldIgnore(paramLocation.getProvider(), System.currentTimeMillis()))
    {
      logger.debug("Ignore temporary non-gps location");
      return;
    }
    Location localLocation = this.mLocation;
    if (localLocation != null) {
      getMyLocationDrawingBounds(this.mMapView.getZoomLevel(), localLocation, this.mMyLocationPreviousRect);
    }
    this.mLocation = paramLocation;
    TileSystem.LatLongToPixelXY(paramLocation.getLatitude(), paramLocation.getLongitude(), 22, this.mMapCoords);
    int i = TileSystem.MapSize(22) / 2;
    this.mMapCoords.offset(-i, -i);
    if (this.mFollow)
    {
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
      if (this.mLocation != null)
      {
        getMyLocationDrawingBounds(this.mMapView.getZoomLevel(), this.mLocation, this.mMyLocationRect);
        if (localLocation != null) {
          this.mMyLocationRect.union(this.mMyLocationPreviousRect);
        }
        this.mMapView.postInvalidate(this.mMyLocationRect.left, this.mMyLocationRect.top, this.mMyLocationRect.right, this.mMyLocationRect.bottom);
      }
    }
    this.mRunOnFirstFix.clear();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem, int paramInt, MapView paramMapView)
  {
    paramInt = paramMenuItem.getItemId() - paramInt;
    if (paramInt == MENU_MY_LOCATION)
    {
      if (isMyLocationEnabled())
      {
        disableFollowLocation();
        disableMyLocation();
        return true;
      }
      enableFollowLocation();
      enableMyLocation();
      return true;
    }
    if (paramInt == MENU_COMPASS)
    {
      if (isCompassEnabled())
      {
        disableCompass();
        return true;
      }
      enableCompass();
      return true;
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    return false;
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.sensor.getType() == 3) && (paramSensorEvent.values != null))
    {
      this.mAzimuth = paramSensorEvent.values[0];
      invalidateCompass();
    }
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
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if (paramMotionEvent.getAction() == 2) {
      disableFollowLocation();
    }
    return super.onTouchEvent(paramMotionEvent, paramMapView);
  }
  
  public boolean runOnFirstFix(Runnable paramRunnable)
  {
    if ((this.mLocationListener != null) && (this.mLocation != null))
    {
      new Thread(paramRunnable).start();
      return true;
    }
    this.mRunOnFirstFix.addLast(paramRunnable);
    return false;
  }
  
  public void setCompassCenter(float paramFloat1, float paramFloat2)
  {
    this.mCompassCenterX = paramFloat1;
    this.mCompassCenterY = paramFloat2;
  }
  
  public void setDrawAccuracyEnabled(boolean paramBoolean)
  {
    this.mDrawAccuracyEnabled = paramBoolean;
  }
  
  public void setLocationUpdateMinDistance(float paramFloat)
  {
    this.mLocationUpdateMinDistance = paramFloat;
  }
  
  public void setLocationUpdateMinTime(long paramLong)
  {
    this.mLocationUpdateMinTime = paramLong;
  }
  
  public void setOptionsMenuEnabled(boolean paramBoolean)
  {
    this.mOptionsMenuEnabled = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/MyLocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */