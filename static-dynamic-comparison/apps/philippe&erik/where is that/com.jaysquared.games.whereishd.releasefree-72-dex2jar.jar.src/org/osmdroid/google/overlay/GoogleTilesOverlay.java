package org.osmdroid.google.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.util.MyMath;
import org.osmdroid.views.util.Mercator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleTilesOverlay
  extends Overlay
{
  private static final boolean DEBUGMODE = false;
  private static final Logger logger = LoggerFactory.getLogger(GoogleTilesOverlay.class);
  protected final Paint mPaint = new Paint();
  private final Point mTilePos = new Point();
  protected final MapTileProviderBase mTileProvider;
  private final Rect mTileRect = new Rect();
  
  public GoogleTilesOverlay(MapTileProviderBase paramMapTileProviderBase, Context paramContext)
  {
    this(paramMapTileProviderBase, new DefaultResourceProxyImpl(paramContext));
  }
  
  public GoogleTilesOverlay(MapTileProviderBase paramMapTileProviderBase, ResourceProxy paramResourceProxy)
  {
    if (paramMapTileProviderBase == null) {
      throw new IllegalArgumentException("You must pass a valid tile provider to the tiles overlay.");
    }
    this.mTileProvider = paramMapTileProviderBase;
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    Projection localProjection = paramMapView.getProjection();
    int m = paramMapView.getZoomLevel() - 1;
    int n = this.mTileProvider.getTileSource().getTileSizePixels();
    int i4 = paramMapView.getLatitudeSpan();
    int i3 = paramMapView.getLongitudeSpan();
    int i = paramMapView.getMapCenter().getLatitudeE6();
    int j = i4 / 2;
    int k = paramMapView.getMapCenter().getLongitudeE6();
    int i1 = i3 / 2;
    int i2 = paramMapView.getMapCenter().getLatitudeE6();
    i4 /= 2;
    int i5 = paramMapView.getMapCenter().getLongitudeE6();
    i3 /= 2;
    paramMapView = Mercator.projectGeoPoint((i + j) * 1.0E-6D, (k - i1) * 1.0E-6D, m, new Point(0, 0));
    Point localPoint = Mercator.projectGeoPoint((i2 - i4) * 1.0E-6D, (i5 + i3) * 1.0E-6D, m, new Point(0, 0));
    k = paramMapView.x;
    i1 = localPoint.x;
    i = paramMapView.y;
    i2 = localPoint.y;
    i3 = 1 << m;
    this.mTileProvider.ensureCapacity((i2 - i + 1) * (i1 - k + 1));
    if (i > i2) {
      return;
    }
    j = k;
    for (;;)
    {
      if (j > i1)
      {
        i += 1;
        break;
      }
      i4 = MyMath.mod(i, i3);
      paramMapView = new MapTile(m, MyMath.mod(j, i3), i4);
      paramMapView = this.mTileProvider.getMapTile(paramMapView);
      if (paramMapView != null)
      {
        localProjection.toPixels(new GeoPoint((int)(Mercator.tile2lat(i, m) * 1000000.0D), (int)(Mercator.tile2lon(j, m) * 1000000.0D)), this.mTilePos);
        this.mTileRect.set(this.mTilePos.x, this.mTilePos.y, this.mTilePos.x + n, this.mTilePos.y + n);
        paramMapView.setBounds(this.mTileRect);
        paramMapView.draw(paramCanvas);
      }
      j += 1;
    }
  }
  
  public int getMaximumZoomLevel()
  {
    return this.mTileProvider.getMaximumZoomLevel();
  }
  
  public int getMinimumZoomLevel()
  {
    return this.mTileProvider.getMinimumZoomLevel();
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setUseDataConnection(boolean paramBoolean)
  {
    this.mTileProvider.setUseDataConnection(paramBoolean);
  }
  
  public boolean useDataConnection()
  {
    return this.mTileProvider.useDataConnection();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/overlay/GoogleTilesOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */