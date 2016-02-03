package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.tileprovider.ReusableBitmapDrawable;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.TileLooper;
import org.osmdroid.util.TileSystem;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.safecanvas.ISafeCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TilesOverlay
  extends SafeDrawOverlay
  implements IOverlayMenuProvider
{
  public static final int MENU_MAP_MODE;
  public static final int MENU_OFFLINE = getSafeMenuId();
  public static final int MENU_TILE_SOURCE_STARTING_ID;
  private static final Logger logger = LoggerFactory.getLogger(TilesOverlay.class);
  protected final Paint mDebugPaint = new Paint();
  private int mLoadingBackgroundColor = Color.rgb(216, 208, 208);
  private int mLoadingLineColor = Color.rgb(200, 192, 192);
  private BitmapDrawable mLoadingTile = null;
  private boolean mOptionsMenuEnabled = true;
  private int mOvershootTileCache = 0;
  private final TileLooper mTileLooper = new TileLooper()
  {
    public void finaliseLoop() {}
    
    public void handleTile(Canvas paramAnonymousCanvas, int paramAnonymousInt1, MapTile paramAnonymousMapTile, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      Object localObject = TilesOverlay.this.mTileProvider.getMapTile(paramAnonymousMapTile);
      boolean bool2 = localObject instanceof ReusableBitmapDrawable;
      if (bool2) {}
      for (localReusableBitmapDrawable = (ReusableBitmapDrawable)localObject;; localReusableBitmapDrawable = null)
      {
        paramAnonymousMapTile = (MapTile)localObject;
        if (localObject == null) {
          paramAnonymousMapTile = TilesOverlay.this.getLoadingTile();
        }
        boolean bool1;
        boolean bool3;
        if (paramAnonymousMapTile != null)
        {
          TilesOverlay.this.mTileRect.set(paramAnonymousInt2 * paramAnonymousInt1, paramAnonymousInt3 * paramAnonymousInt1, paramAnonymousInt2 * paramAnonymousInt1 + paramAnonymousInt1, paramAnonymousInt3 * paramAnonymousInt1 + paramAnonymousInt1);
          if (bool2) {
            localReusableBitmapDrawable.beginUsingDrawable();
          }
          localObject = paramAnonymousMapTile;
          bool1 = bool2;
          if (bool2)
          {
            localObject = paramAnonymousMapTile;
            bool1 = bool2;
            bool3 = bool2;
          }
        }
        try
        {
          if (!((ReusableBitmapDrawable)paramAnonymousMapTile).isBitmapValid())
          {
            bool3 = bool2;
            localObject = TilesOverlay.this.getLoadingTile();
            bool1 = false;
          }
          bool3 = bool1;
          TilesOverlay.this.onTileReadyToDraw(paramAnonymousCanvas, (Drawable)localObject, TilesOverlay.this.mTileRect);
          return;
        }
        finally
        {
          if (!bool3) {
            break;
          }
          localReusableBitmapDrawable.finishUsingDrawable();
        }
      }
    }
    
    public void initialiseLoop(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      paramAnonymousInt1 = this.mLowerRight.y;
      paramAnonymousInt2 = this.mUpperLeft.y;
      int i = this.mLowerRight.x;
      int j = this.mUpperLeft.x;
      TilesOverlay.this.mTileProvider.ensureCapacity(TilesOverlay.this.mOvershootTileCache + (paramAnonymousInt1 - paramAnonymousInt2 + 1) * (i - j + 1));
    }
  };
  protected final MapTileProviderBase mTileProvider;
  private final Rect mTileRect = new Rect();
  private final Rect mViewPort = new Rect();
  private int mWorldSize_2;
  
  static
  {
    MENU_MAP_MODE = getSafeMenuId();
    MENU_TILE_SOURCE_STARTING_ID = getSafeMenuIdSequence(TileSourceFactory.getTileSources().size());
  }
  
  public TilesOverlay(MapTileProviderBase paramMapTileProviderBase, Context paramContext)
  {
    this(paramMapTileProviderBase, new DefaultResourceProxyImpl(paramContext));
  }
  
  public TilesOverlay(MapTileProviderBase paramMapTileProviderBase, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    if (paramMapTileProviderBase == null) {
      throw new IllegalArgumentException("You must pass a valid tile provider to the tiles overlay.");
    }
    this.mTileProvider = paramMapTileProviderBase;
  }
  
  private void clearLoadingTile()
  {
    BitmapDrawable localBitmapDrawable = this.mLoadingTile;
    this.mLoadingTile = null;
    if ((Build.VERSION.SDK_INT < 9) && (localBitmapDrawable != null)) {
      localBitmapDrawable.getBitmap().recycle();
    }
  }
  
  private Drawable getLoadingTile()
  {
    if ((this.mLoadingTile == null) && (this.mLoadingBackgroundColor != 0)) {}
    try
    {
      if (this.mTileProvider.getTileSource() != null)
      {
        i = this.mTileProvider.getTileSource().getTileSizePixels();
        Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localCanvas.drawColor(this.mLoadingBackgroundColor);
        localPaint.setColor(this.mLoadingLineColor);
        localPaint.setStrokeWidth(0.0F);
        int k = i / 16;
        int j = 0;
        while (j < i)
        {
          localCanvas.drawLine(0.0F, j, i, j, localPaint);
          localCanvas.drawLine(j, 0.0F, j, i, localPaint);
          j += k;
        }
        this.mLoadingTile = new BitmapDrawable(localBitmap);
        return this.mLoadingTile;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        logger.error("OutOfMemoryError getting loading tile");
        System.gc();
        continue;
        int i = 256;
      }
    }
  }
  
  protected void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    MapView.Projection localProjection = paramMapView.getProjection();
    this.mWorldSize_2 = (TileSystem.MapSize(localProjection.getZoomLevel()) >> 1);
    if (paramMapView.shouldUseHQScaling) {}
    for (paramMapView = localProjection.screenRect();; paramMapView = localProjection.getScreenRect())
    {
      this.mViewPort.set(paramMapView);
      this.mViewPort.offset(this.mWorldSize_2, this.mWorldSize_2);
      drawTiles(paramISafeCanvas.getSafeCanvas(), localProjection.getZoomLevel(), TileSystem.getTileSize(), this.mViewPort);
      return;
    }
  }
  
  public void drawTiles(Canvas paramCanvas, int paramInt1, int paramInt2, Rect paramRect)
  {
    this.mTileLooper.loop(paramCanvas, paramInt1, paramInt2, paramRect);
  }
  
  public int getLoadingBackgroundColor()
  {
    return this.mLoadingBackgroundColor;
  }
  
  public int getLoadingLineColor()
  {
    return this.mLoadingLineColor;
  }
  
  public int getMaximumZoomLevel()
  {
    return this.mTileProvider.getMaximumZoomLevel();
  }
  
  public int getMinimumZoomLevel()
  {
    return this.mTileProvider.getMinimumZoomLevel();
  }
  
  public int getOvershootTileCache()
  {
    return this.mOvershootTileCache;
  }
  
  public boolean isOptionsMenuEnabled()
  {
    return this.mOptionsMenuEnabled;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    Object localObject1 = paramMenu.addSubMenu(0, MENU_MAP_MODE + paramInt, 0, this.mResourceProxy.getString(ResourceProxy.string.map_mode)).setIcon(this.mResourceProxy.getDrawable(ResourceProxy.bitmap.ic_menu_mapmode));
    int i = 0;
    while (i < TileSourceFactory.getTileSources().size())
    {
      localObject2 = (ITileSource)TileSourceFactory.getTileSources().get(i);
      ((SubMenu)localObject1).add(MENU_MAP_MODE + paramInt, MENU_TILE_SOURCE_STARTING_ID + i + paramInt, 0, ((ITileSource)localObject2).localizedName(this.mResourceProxy));
      i += 1;
    }
    ((SubMenu)localObject1).setGroupCheckable(MENU_MAP_MODE + paramInt, true, true);
    Object localObject2 = paramMapView.getResourceProxy();
    if (paramMapView.useDataConnection()) {}
    for (localObject1 = ResourceProxy.string.offline_mode;; localObject1 = ResourceProxy.string.online_mode)
    {
      localObject1 = ((ResourceProxy)localObject2).getString((ResourceProxy.string)localObject1);
      paramMapView = paramMapView.getResourceProxy().getDrawable(ResourceProxy.bitmap.ic_menu_offline);
      paramMenu.add(0, MENU_OFFLINE + paramInt, 0, (CharSequence)localObject1).setIcon(paramMapView);
      return true;
    }
  }
  
  public void onDetach(MapView paramMapView)
  {
    this.mTileProvider.detach();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem, int paramInt, MapView paramMapView)
  {
    boolean bool = false;
    paramInt = paramMenuItem.getItemId() - paramInt;
    if ((paramInt >= MENU_TILE_SOURCE_STARTING_ID) && (paramInt < MENU_TILE_SOURCE_STARTING_ID + TileSourceFactory.getTileSources().size()))
    {
      paramMapView.setTileSource((ITileSource)TileSourceFactory.getTileSources().get(paramInt - MENU_TILE_SOURCE_STARTING_ID));
      return true;
    }
    if (paramInt == MENU_OFFLINE)
    {
      if (!paramMapView.useDataConnection()) {
        bool = true;
      }
      paramMapView.setUseDataConnection(bool);
      return true;
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    int i = TileSourceFactory.getTileSources().indexOf(paramMapView.getTileProvider().getTileSource());
    if (i >= 0) {
      paramMenu.findItem(MENU_TILE_SOURCE_STARTING_ID + i + paramInt).setChecked(true);
    }
    MenuItem localMenuItem = paramMenu.findItem(MENU_OFFLINE + paramInt);
    ResourceProxy localResourceProxy = paramMapView.getResourceProxy();
    if (paramMapView.useDataConnection()) {}
    for (paramMenu = ResourceProxy.string.offline_mode;; paramMenu = ResourceProxy.string.online_mode)
    {
      localMenuItem.setTitle(localResourceProxy.getString(paramMenu));
      return true;
    }
  }
  
  protected void onTileReadyToDraw(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect)
  {
    paramRect.offset(-this.mWorldSize_2, -this.mWorldSize_2);
    paramDrawable.setBounds(paramRect);
    paramDrawable.draw(paramCanvas);
  }
  
  public void setLoadingBackgroundColor(int paramInt)
  {
    if (this.mLoadingBackgroundColor != paramInt)
    {
      this.mLoadingBackgroundColor = paramInt;
      clearLoadingTile();
    }
  }
  
  public void setLoadingLineColor(int paramInt)
  {
    if (this.mLoadingLineColor != paramInt)
    {
      this.mLoadingLineColor = paramInt;
      clearLoadingTile();
    }
  }
  
  public void setOptionsMenuEnabled(boolean paramBoolean)
  {
    this.mOptionsMenuEnabled = paramBoolean;
  }
  
  public void setOvershootTileCache(int paramInt)
  {
    this.mOvershootTileCache = paramInt;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/TilesOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */