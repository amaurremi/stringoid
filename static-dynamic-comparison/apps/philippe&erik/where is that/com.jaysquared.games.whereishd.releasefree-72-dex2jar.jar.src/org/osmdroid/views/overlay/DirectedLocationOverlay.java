package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;

public class DirectedLocationOverlay
  extends Overlay
{
  protected final Bitmap DIRECTION_ARROW = this.mResourceProxy.getBitmap(ResourceProxy.bitmap.direction_arrow);
  private final float DIRECTION_ARROW_CENTER_X = this.DIRECTION_ARROW.getWidth() / 2 - 0.5F;
  private final float DIRECTION_ARROW_CENTER_Y = this.DIRECTION_ARROW.getHeight() / 2 - 0.5F;
  private final int DIRECTION_ARROW_HEIGHT = this.DIRECTION_ARROW.getHeight();
  private final int DIRECTION_ARROW_WIDTH = this.DIRECTION_ARROW.getWidth();
  private final Matrix directionRotater = new Matrix();
  private int mAccuracy = 0;
  protected final Paint mAccuracyPaint = new Paint();
  protected float mBearing;
  protected GeoPoint mLocation;
  protected final Paint mPaint = new Paint();
  private boolean mShowAccuracy = true;
  private final Point screenCoords = new Point();
  
  public DirectedLocationOverlay(Context paramContext)
  {
    this(paramContext, new DefaultResourceProxyImpl(paramContext));
  }
  
  public DirectedLocationOverlay(Context paramContext, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    this.mAccuracyPaint.setStrokeWidth(2.0F);
    this.mAccuracyPaint.setColor(-16776961);
    this.mAccuracyPaint.setAntiAlias(true);
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (this.mLocation == null) {
      return;
    }
    paramMapView = paramMapView.getProjection();
    paramMapView.toMapPixels(this.mLocation, this.screenCoords);
    if ((this.mShowAccuracy) && (this.mAccuracy > 10))
    {
      float f = paramMapView.metersToEquatorPixels(this.mAccuracy);
      if (f > 8.0F)
      {
        this.mAccuracyPaint.setAntiAlias(false);
        this.mAccuracyPaint.setAlpha(30);
        this.mAccuracyPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.screenCoords.x, this.screenCoords.y, f, this.mAccuracyPaint);
        this.mAccuracyPaint.setAntiAlias(true);
        this.mAccuracyPaint.setAlpha(150);
        this.mAccuracyPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawCircle(this.screenCoords.x, this.screenCoords.y, f, this.mAccuracyPaint);
      }
    }
    this.directionRotater.setRotate(this.mBearing, this.DIRECTION_ARROW_CENTER_X, this.DIRECTION_ARROW_CENTER_Y);
    paramMapView = Bitmap.createBitmap(this.DIRECTION_ARROW, 0, 0, this.DIRECTION_ARROW_WIDTH, this.DIRECTION_ARROW_HEIGHT, this.directionRotater, false);
    paramCanvas.drawBitmap(paramMapView, this.screenCoords.x - paramMapView.getWidth() / 2, this.screenCoords.y - paramMapView.getHeight() / 2, this.mPaint);
  }
  
  public GeoPoint getLocation()
  {
    return this.mLocation;
  }
  
  public void setAccuracy(int paramInt)
  {
    this.mAccuracy = paramInt;
  }
  
  public void setBearing(float paramFloat)
  {
    this.mBearing = paramFloat;
  }
  
  public void setLocation(GeoPoint paramGeoPoint)
  {
    this.mLocation = paramGeoPoint;
  }
  
  public void setShowAccuracy(boolean paramBoolean)
  {
    this.mShowAccuracy = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/DirectedLocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */