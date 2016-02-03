package com.jaysquared.games.whereishd.ui;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.google.analytics.tracking.android.EasyTracker;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.db.DatabaseHelper;
import com.jaysquared.games.whereishd.db.DatabaseManager;
import com.jaysquared.games.whereishd.utils.SLog;
import com.jaysquared.games.whereishd.utils.SystemHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import microsoft.mappoint.TileSystem;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.BitmapPool;
import org.osmdroid.tileprovider.IRegisterReceiver;
import org.osmdroid.tileprovider.MapTileProviderArray;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.tileprovider.modules.IArchiveFile;
import org.osmdroid.tileprovider.modules.MBTilesFileArchive;
import org.osmdroid.tileprovider.modules.MapTileFileArchiveProvider;
import org.osmdroid.tileprovider.modules.MapTileModuleProviderBase;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.tileprovider.util.SimpleRegisterReceiver;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.OverlayManager;
import org.osmdroid.views.overlay.TilesOverlay;

public class MapDbBaseActivity
  extends OrmLiteBaseActivity<DatabaseHelper>
{
  private static final String LOG_TAG = MapDbBaseActivity.class.getSimpleName();
  public static final String PREFS_NAME = "JaysquaredPrefsFile";
  public boolean created = false;
  public FrameLayout frameLayout;
  final Handler handler = new Handler();
  public boolean mVisible;
  public IMapController mapController;
  public MapView mapView;
  public final XYTileSource mbtilesSource = new XYTileSource("mbtiles", ResourceProxy.string.offline_mode, 2, 6, 256, ".png", new String[] { "http://i.dont.care.org/" });
  public ResourceProxy resourceProxy;
  public boolean sem = true;
  public MapTileProviderArray tileProvider;
  public String tilesName = "easy.mbtiles";
  
  public static boolean hasStorage(boolean paramBoolean)
  {
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str)) {}
    while ((!paramBoolean) && ("mounted_ro".equals(str))) {
      return true;
    }
    return false;
  }
  
  private void noStorageAlert()
  {
    if (!this.sem) {
      return;
    }
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.setCancelable(false);
    localAlertDialog.setMessage(str(2131427400));
    localAlertDialog.setButton(str(2131427404), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MapDbBaseActivity.this.sem = true;
        paramAnonymousDialogInterface.dismiss();
      }
    });
    localAlertDialog.setButton2(str(2131427361), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        System.exit(0);
      }
    });
    localAlertDialog.show();
    this.sem = false;
  }
  
  private void releaseAllCaches()
  {
    this.mapView.getTileProvider().clearTileCache();
    BitmapPool.getInstance().clearBitmapPool();
  }
  
  void deleteExternalStoragePrivateFile()
  {
    File localFile = new File(getExternalFilesDir(null), this.tilesName);
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public int dip2px(int paramInt)
  {
    return (int)TypedValue.applyDimension(2, paramInt, getResources().getDisplayMetrics());
  }
  
  boolean hasExternalStoragePrivateFile()
  {
    File localFile = new File(getExternalFilesDir(null), this.tilesName);
    if (localFile != null) {
      return localFile.exists();
    }
    return false;
  }
  
  public boolean isOnline()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      return true;
    }
    Toast.makeText(getApplicationContext(), str(2131427401), 1).show();
    return false;
  }
  
  public void loadUI()
  {
    this.mapView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.frameLayout.addView(this.mapView, 0);
    mapEndConfig();
  }
  
  public void loadView() {}
  
  public void mapBeginConfig()
  {
    SLog.d(LOG_TAG, "MapDbBaseActivity.mapBeginConfig()");
    this.resourceProxy = new DefaultResourceProxyImpl(getApplicationContext());
    Object localObject1 = new SimpleRegisterReceiver(this);
    Object localObject2 = provideMapFile();
    SLog.d(LOG_TAG, "file dir" + localObject2);
    if (localObject2 == null)
    {
      SLog.e(LOG_TAG, "Couldn't find map file: " + localObject2);
      return;
    }
    localObject2 = MBTilesFileArchive.getDatabaseFileArchive((File)localObject2);
    localObject1 = new MapTileFileArchiveProvider((IRegisterReceiver)localObject1, this.mbtilesSource, new IArchiveFile[] { localObject2 });
    SLog.d(LOG_TAG, "Minimum zoom level of tile source:" + this.mbtilesSource.getMinimumZoomLevel());
    SLog.d(LOG_TAG, "Maximum zoom level of tile source:" + this.mbtilesSource.getMaximumZoomLevel());
    SLog.d(LOG_TAG, "Size of tiles in pixel:" + this.mbtilesSource.getTileSizePixels());
    this.tileProvider = new MapTileProviderArray(this.mbtilesSource, null, new MapTileModuleProviderBase[] { localObject1 });
    this.mapView = new MapView(this, this.mbtilesSource.getTileSizePixels(), this.resourceProxy, this.tileProvider);
    localObject1 = ApplicationManager.getInstance().getGameManager().getDisplayResolution();
    int j = this.mbtilesSource.getMinimumZoomLevel();
    for (int i = TileSystem.MapSize(j); i < ((Point)localObject1).y; i = TileSystem.MapSize(j))
    {
      SLog.d(LOG_TAG, "Minimum zoom level has been increased to " + j + " due to high resolution display (Map size: " + i + ")");
      j += 1;
    }
    this.mapView.setMinZoomLevel(Integer.valueOf(j));
    i = SystemHelper.getMaxHeapSize(this);
    if (i <= 32)
    {
      SLog.d(LOG_TAG, "Very small max heap detected. Using minimal tile cache...");
      this.mapView.getOverlayManager().getTilesOverlay().setOvershootTileCache(0);
    }
    for (;;)
    {
      loadUI();
      return;
      if ((i > 32) && (i < 64))
      {
        SLog.d(LOG_TAG, "Small max heap detected. Using small tile cache...");
        this.mapView.getOverlayManager().getTilesOverlay().setOvershootTileCache(10);
      }
      else if ((i >= 64) && (i <= 128))
      {
        SLog.d(LOG_TAG, "Medium max heap detected. Using medium tile cache...");
        this.mapView.getOverlayManager().getTilesOverlay().setOvershootTileCache(75);
      }
      else if ((i > 128) && (i <= 256))
      {
        SLog.d(LOG_TAG, "Large max heap detected. Using large tile cache...");
        this.mapView.getOverlayManager().getTilesOverlay().setOvershootTileCache(150);
      }
      else if (i > 256)
      {
        SLog.d(LOG_TAG, "Very Large max heap detected. Using very large tile cache for improved drawing performance.");
        this.mapView.getOverlayManager().getTilesOverlay().setOvershootTileCache(250);
      }
    }
  }
  
  public void mapEndConfig()
  {
    this.mapView.shoudLiveUpdateTiles = true;
    this.mapView.shouldUseHQScaling = false;
    this.mapController = this.mapView.getController();
    GeoPoint localGeoPoint = new GeoPoint(34.137352D, 11.92539D);
    this.mapView.getController().setCenter(localGeoPoint);
    SLog.d(LOG_TAG, "finished");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SLog.d(LOG_TAG, "Creating activity...");
    DatabaseManager.getInstance().init(this);
    this.mVisible = true;
    switch (ApplicationManager.getInstance().getSettings().getGameDifficulty())
    {
    }
    while (hasStorage(true))
    {
      this.created = true;
      mapBeginConfig();
      return;
      this.tilesName = "easy.mbtiles";
      continue;
      this.tilesName = "hard.mbtiles";
      continue;
      this.tilesName = "hdedition.mbtiles";
    }
    SLog.i(LOG_TAG, "no storage found");
    paramBundle = new Runnable()
    {
      public void run()
      {
        if (MapDbBaseActivity.hasStorage(true))
        {
          MapDbBaseActivity.this.mapBeginConfig();
          MapDbBaseActivity.this.created = true;
          SLog.d(MapDbBaseActivity.LOG_TAG, "storage found");
          return;
        }
        SLog.d(MapDbBaseActivity.LOG_TAG, "still no storage found");
        MapDbBaseActivity.this.noStorageAlert();
        MapDbBaseActivity.this.handler.postDelayed(this, 100L);
      }
    };
    this.handler.postDelayed(paramBundle, 100L);
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
    if (hasStorage(true)) {
      SLog.d(LOG_TAG, "normal on destroy");
    }
    for (;;)
    {
      SLog.d(LOG_TAG, "mVisible on destroy");
      this.mVisible = false;
      super.onDestroy();
      return;
      SLog.d(LOG_TAG, "unmount on destroy");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    SLog.w(LOG_TAG, "Low memory: releasing all caches...");
    releaseAllCaches();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (hasStorage(true)) {
      SLog.d(LOG_TAG, "normal on pause");
    }
    for (;;)
    {
      SLog.d(LOG_TAG, "mVisible on pause");
      this.mVisible = false;
      if (this.mapView != null) {
        this.mapView.getTileProvider().clearTileCache();
      }
      return;
      SLog.d(LOG_TAG, "unmount on pause");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    SLog.d(LOG_TAG, "mVisible on resume");
    this.mVisible = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance(this).activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance(this).activityStop(this);
    SLog.d(LOG_TAG, "mVisible on stop");
    this.mVisible = false;
    if (hasStorage(true)) {
      SLog.d(LOG_TAG, "normal on stop");
    }
    for (;;)
    {
      if (this.mapView != null) {
        this.mapView.getTileProvider().clearTileCache();
      }
      System.gc();
      return;
      SLog.d(LOG_TAG, "unmount on stop");
    }
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if ((paramInt == 15) || (paramInt >= 60))
    {
      SLog.w(LOG_TAG, "Memory trimming with level " + paramInt + " received, releasing all caches...");
      releaseAllCaches();
    }
  }
  
  public File provideMapFile()
  {
    SLog.d(LOG_TAG, "get  level " + this.tilesName);
    File localFile = new File(getExternalFilesDir(null), this.tilesName);
    SLog.d(LOG_TAG, "Tiles file: " + localFile);
    if (hasExternalStoragePrivateFile()) {
      return localFile;
    }
    for (;;)
    {
      FileOutputStream localFileOutputStream;
      byte[] arrayOfByte;
      try
      {
        if (this.tilesName == "hdedition.mbtiles")
        {
          InputStream localInputStream1 = getResources().openRawResource(2131034114);
          localFileOutputStream = new FileOutputStream(localFile);
          arrayOfByte = new byte[65536];
          if (localInputStream1.read(arrayOfByte) >= 0) {
            break label190;
          }
          localInputStream1.close();
          localFileOutputStream.close();
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        SLog.e(LOG_TAG, "Error writing " + localFile + ": " + localIOException);
        return null;
      }
      InputStream localInputStream2 = getResources().openRawResource(2131034113);
      continue;
      label190:
      localFileOutputStream.write(arrayOfByte);
    }
  }
  
  public String str(int paramInt)
  {
    return getResources().getString(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/MapDbBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */