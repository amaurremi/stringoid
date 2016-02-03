package com.jaysquared.games.whereishd;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.jaysquared.games.whereishd.utils.SystemHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.osmdroid.tileprovider.BitmapPool;

public class WhereIsApplication
  extends Application
{
  private final String LOG_TAG = WhereIsApplication.class.getSimpleName();
  
  private void injectPrepopulatedDatabase()
    throws IOException
  {
    Object localObject5 = getDatabasePath("jaysquared.sqlite");
    if (((File)localObject5).exists()) {
      Log.v(this.LOG_TAG, "Not injecting database as it already exists.");
    }
    label140:
    do
    {
      return;
      Log.d(this.LOG_TAG, "Injecting database to: " + ((File)localObject5).toString());
      ((File)localObject5).getParentFile().mkdirs();
      Object localObject1 = null;
      Object localObject4 = null;
      try
      {
        localInputStream = getResources().openRawResource(2131034115);
        localObject1 = localInputStream;
        localObject5 = new FileOutputStream((File)localObject5);
        try
        {
          localObject1 = new byte['Ѐ'];
          for (;;)
          {
            int i = localInputStream.read((byte[])localObject1);
            if (i <= 0) {
              break;
            }
            ((OutputStream)localObject5).write((byte[])localObject1, 0, i);
          }
          if (localObject3 == null) {
            break label140;
          }
        }
        finally
        {
          localObject4 = localObject5;
          localObject5 = localObject2;
          localObject3 = localInputStream;
        }
      }
      finally
      {
        InputStream localInputStream;
        Object localObject3;
        for (;;) {}
      }
      ((InputStream)localObject3).close();
      if (localObject4 != null) {
        ((OutputStream)localObject4).close();
      }
      throw ((Throwable)localObject5);
      if (localInputStream != null) {
        localInputStream.close();
      }
    } while (localObject5 == null);
    ((OutputStream)localObject5).close();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    SLog.d(this.LOG_TAG, "Configuration has changed...");
  }
  
  @TargetApi(11)
  public void onCreate()
  {
    super.onCreate();
    boolean bool;
    if (!ReleaseConfiguration.isDebug(this)) {
      bool = true;
    }
    for (;;)
    {
      SLog.isRelease = bool;
      int i = SystemHelper.getVersionCode(this);
      SLog.i(this.LOG_TAG, "============================================================");
      SLog.i(this.LOG_TAG, "Starting Where is that? Android App with version code " + i);
      SLog.i(this.LOG_TAG, "============================================================");
      i = SystemHelper.getMaxHeapSize(this);
      SLog.i(this.LOG_TAG, "Max available memory is: " + i + "MB");
      try
      {
        injectPrepopulatedDatabase();
        PersistantSettings localPersistantSettings = new PersistantSettings(getApplicationContext());
        GameManager localGameManager = new GameManager(getApplicationContext(), localPersistantSettings);
        ApplicationManager.getInstance().initialize(localGameManager, localPersistantSettings);
        return;
        bool = false;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e(this.LOG_TAG, "Error prepopulating database: " + localIOException.getLocalizedMessage());
        }
      }
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    SLog.w(this.LOG_TAG, "Low memory warning has been issued. Releasing caches...");
    BitmapPool.getInstance().clearBitmapPool();
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    SLog.i(this.LOG_TAG, "Terminating application...");
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt == 15) || (paramInt >= 60))
    {
      SLog.w(this.LOG_TAG, "Trimming memory, releasing caches...");
      BitmapPool.getInstance().clearBitmapPool();
    }
    if (Build.VERSION.SDK_INT >= 14) {
      super.onTrimMemory(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/WhereIsApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */