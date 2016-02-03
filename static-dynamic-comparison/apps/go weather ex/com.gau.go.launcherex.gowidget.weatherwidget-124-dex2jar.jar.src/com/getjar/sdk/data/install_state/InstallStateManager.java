package com.getjar.sdk.data.install_state;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.RecordSyncedListener;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InstallStateManager
  implements RecordSyncedListener
{
  private static final int DEFAULT_MAX_INSTALLED = 50;
  private static volatile InstallStateManager _Instance = null;
  private final Context _context;
  private ExecutorService _executorService = Executors.newSingleThreadExecutor();
  private volatile Object _installStateLock = new Object();
  
  private InstallStateManager(Context paramContext)
  {
    this._context = paramContext.getApplicationContext();
    SyncedInstallStateDatabase.initialize(paramContext);
    UnsyncedInstallStateDatabase.initialize(paramContext);
  }
  
  public static InstallStateManager getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'context' cannot be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new InstallStateManager(paramContext);
    }
    paramContext = _Instance;
    return paramContext;
  }
  
  public void clearInstallState()
  {
    synchronized (this._installStateLock)
    {
      UnsyncedInstallStateDatabase.getInstance().deleteAllRecords();
      SyncedInstallStateDatabase.getInstance().deleteAllRecords();
      return;
    }
  }
  
  public List<InstallStateRecord> getUnsyncedRecords(CommContext arg1)
  {
    int i = GetJarConfig.getInstance(???.getApplicationContext()).getIntegerValue("interstitial_scope.usage.request.send.max_installed_count", Integer.valueOf(50), SettingsManager.Scope.CLIENT).intValue();
    synchronized (this._installStateLock)
    {
      List localList = UnsyncedInstallStateDatabase.getInstance().loadRecords(i);
      return localList;
    }
  }
  
  public void moveRecordsToSyncedDB(final CommContext paramCommContext, final List<InstallStateRecord> paramList)
  {
    try
    {
      this._executorService.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            synchronized (InstallStateManager.this._installStateLock)
            {
              SyncedInstallStateDatabase.initialize(paramCommContext.getApplicationContext());
              UnsyncedInstallStateDatabase localUnsyncedInstallStateDatabase = UnsyncedInstallStateDatabase.getInstance();
              SyncedInstallStateDatabase localSyncedInstallStateDatabase = SyncedInstallStateDatabase.getInstance();
              int i = 0;
              while (i < paramList.size())
              {
                InstallStateRecord localInstallStateRecord = localUnsyncedInstallStateDatabase.getInstallRecord(((InstallStateRecord)paramList.get(i)).getId());
                localSyncedInstallStateDatabase.addRecord(localInstallStateRecord);
                localUnsyncedInstallStateDatabase.deleteRecord(localInstallStateRecord.getId());
                i += 1;
              }
              return;
            }
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.USAGE.value() | Area.TRANSACTION.value(), localException, "Failed updating SyncedInstallStateDatabase", new Object[0]);
          }
        }
      });
      return;
    }
    catch (Exception paramCommContext)
    {
      Logger.e(Area.USAGE.value() | Area.TRANSACTION.value(), paramCommContext, "Failed updating SyncedInstallStateDatabase", new Object[0]);
    }
  }
  
  public void onRecordSynced(long paramLong)
  {
    UnsyncedInstallStateDatabase localUnsyncedInstallStateDatabase = UnsyncedInstallStateDatabase.getInstance();
    synchronized (this._installStateLock)
    {
      InstallStateRecord localInstallStateRecord = localUnsyncedInstallStateDatabase.getInstallRecord(paramLong);
      if (localInstallStateRecord != null)
      {
        SyncedInstallStateDatabase.getInstance().addRecord(localInstallStateRecord);
        localUnsyncedInstallStateDatabase.deleteRecord(paramLong);
      }
      return;
    }
  }
  
  public void purgeSyncedRecords()
  {
    Logger.e(Area.USAGE.value(), "'purgeSyncedRecords' not supported for InstallStateManager", new Object[0]);
  }
  
  public void sendCurrentStateDeltas(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    synchronized (this._installStateLock)
    {
      InstallStateReporter.getInstance(paramCommContext).sendUnsyncedData();
      return;
    }
  }
  
  public void updateCurrentState()
  {
    synchronized (this._installStateLock)
    {
      localHashMap = new HashMap();
      localObject1 = null;
      try
      {
        localObject3 = PackageInfo.class.getDeclaredField("firstInstallTime");
        localObject1 = localObject3;
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            Object localObject3;
            l2 = ((Field)localObject1).getLong(localObject6);
            localHashMap.put(((PackageInfo)localObject6).packageName, Long.valueOf(l2));
          }
          localObject2 = finally;
          throw ((Throwable)localObject2);
          localException1 = localException1;
          Logger.e(Area.USAGE.value(), localException1, "InstallStateManager: updateCurrentState: firstInstallTime not supported", new Object[0]);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            long l1;
            Logger.e(Area.USAGE.value(), localException2, "InstallStateManager: updateCurrentState: failed to get firstInstallTime", new Object[0]);
            long l2 = l1;
          }
        }
        Object localObject4 = new HashMap();
        Object localObject6 = new HashMap();
        UnsyncedInstallStateDatabase localUnsyncedInstallStateDatabase = UnsyncedInstallStateDatabase.getInstance();
        Object localObject7 = SyncedInstallStateDatabase.getInstance().loadAllRecords().iterator();
        Object localObject8;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (InstallStateRecord)((Iterator)localObject7).next();
          if (!((Map)localObject4).containsKey(((InstallStateRecord)localObject8).getPackageName())) {
            ((Map)localObject4).put(((InstallStateRecord)localObject8).getPackageName(), localObject8);
          }
        }
        localObject7 = localUnsyncedInstallStateDatabase.loadAllRecords().iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (InstallStateRecord)((Iterator)localObject7).next();
          if (!((Map)localObject6).containsKey(((InstallStateRecord)localObject8).getPackageName())) {
            ((Map)localObject6).put(((InstallStateRecord)localObject8).getPackageName(), localObject8);
          }
        }
        localObject7 = localHashMap.entrySet().iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Map.Entry)((Iterator)localObject7).next();
          if ((!((Map)localObject6).containsKey(((Map.Entry)localObject8).getKey())) && (!((Map)localObject4).containsKey(((Map.Entry)localObject8).getKey()))) {
            localUnsyncedInstallStateDatabase.addRecord((String)((Map.Entry)localObject8).getKey(), ((Long)((Map.Entry)localObject8).getValue()).longValue(), InstallState.FOUND_INSTALLED);
          }
        }
        localObject6 = ((Map)localObject6).values().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (InstallStateRecord)((Iterator)localObject6).next();
          if ((InstallState.FOUND_INSTALLED.equals(((InstallStateRecord)localObject7).getStatus())) && (!localHashMap.containsKey(((InstallStateRecord)localObject7).getPackageName()))) {
            localUnsyncedInstallStateDatabase.updateState(((InstallStateRecord)localObject7).getId(), InstallState.FOUND_UNINSTALLED);
          }
        }
        localObject4 = ((Map)localObject4).values().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = (InstallStateRecord)((Iterator)localObject4).next();
          if ((InstallState.FOUND_INSTALLED.equals(((InstallStateRecord)localObject6).getStatus())) && (!localHashMap.containsKey(((InstallStateRecord)localObject6).getPackageName()))) {
            localUnsyncedInstallStateDatabase.addRecord(((InstallStateRecord)localObject6).getPackageName(), ((InstallStateRecord)localObject6).getTimestamp(), InstallState.FOUND_UNINSTALLED);
          }
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
      }
      localObject3 = this._context.getPackageManager().getInstalledPackages(0).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject6 = (PackageInfo)((Iterator)localObject3).next();
        l1 = System.currentTimeMillis();
        l2 = l1;
        if (localObject1 == null) {}
      }
    }
  }
  
  public static enum InstallState
  {
    FOUND_INSTALLED,  FOUND_UNINSTALLED;
    
    private InstallState() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/install_state/InstallStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */