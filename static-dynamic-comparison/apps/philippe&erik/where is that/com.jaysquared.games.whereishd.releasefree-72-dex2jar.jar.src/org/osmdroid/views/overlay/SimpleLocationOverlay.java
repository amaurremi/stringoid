package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;

public class SimpleLocationOverlay
  extends Overlay
{
  protected final Point PERSON_HOTSPOT = new Point(24, 39);
  protected final Bitmap PERSON_ICON = this.mResourceProxy.getBitmap(ResourceProxy.bitmap.person);
  protected GeoPoint mLocation;
  protected final Paint mPaint = new Paint();
  private final Point screenCoords = new Point();
  
  public SimpleLocationOverlay(Context paramContext)
  {
    this(paramContext, new DefaultResourceProxyImpl(paramContext));
  }
  
  public SimpleLocationOverlay(Context paramContext, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mLocation != null))
    {
      paramMapView.getProjection().toMapPixels(this.mLocation, this.screenCoords);
      paramCanvas.drawBitmap(this.PERSON_ICON, this.screenCoords.x - this.PERSON_HOTSPOT.x, this.screenCoords.y - this.PERSON_HOTSPOT.y, this.mPaint);
    }
  }
  
  public GeoPoint getMyLocation()
  {
    return this.mLocation;
  }
  
  public void setLocation(GeoPoint paramGeoPoint)
  {
    this.mLocation = paramGeoPoint;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/SimpleLocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */