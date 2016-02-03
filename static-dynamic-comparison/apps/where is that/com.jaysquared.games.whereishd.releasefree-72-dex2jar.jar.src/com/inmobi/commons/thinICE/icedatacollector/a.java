package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.location.LocationUtil;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.thinICE.wifi.WifiScanListener;
import com.inmobi.commons.thinICE.wifi.WifiScanner;
import com.inmobi.commons.thinICE.wifi.WifiUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  implements Runnable
{
  public void run()
  {
    final boolean bool1 = false;
    if (BuildSettings.DEBUG) {
      Log.d("IceDataCollector", "** sample runnable");
    }
    if (IceDataCollector.c() == null)
    {
      if (BuildSettings.DEBUG) {
        Log.w("IceDataCollector", "sampling when looper is null, exiting");
      }
      return;
    }
    if ((Build.VERSION.SDK_INT < 14) && (!IceDataCollector.d().hasWindowFocus()))
    {
      if (BuildSettings.DEBUG) {
        Log.d("IceDataCollector", "activity no longer has focus, terminating");
      }
      IceDataCollector.b();
      localObject1 = IceDataCollector.e();
      IceDataCollector.flush();
      IceDataCollector.a(null);
      IceDataCollector.a(null);
      if (IceDataCollector.f() != null) {
        IceDataCollector.f().onSamplingTerminated((List)localObject1);
      }
      IceDataCollector.a(null);
      return;
    }
    IceDataCollector.i().postDelayed(IceDataCollector.g(), IceDataCollector.h().getSampleInterval());
    if (BuildSettings.DEBUG) {
      Log.d("IceDataCollector", "next sample in " + IceDataCollector.h().getSampleInterval() + " ms");
    }
    Object localObject1 = new Sample();
    int i = IceDataCollector.h().getWifiFlags();
    if (!ThinICEConfigSettings.bitTest(i, 2)) {
      bool1 = true;
    }
    final boolean bool2 = ThinICEConfigSettings.bitTest(i, 1);
    i = IceDataCollector.h().getCellOpFlags();
    boolean bool3 = ThinICEConfigSettings.bitTest(i, 1);
    boolean bool4 = ThinICEConfigSettings.bitTest(i, 2);
    if (IceDataCollector.h().isSampleCellOperatorEnabled()) {}
    try
    {
      localObject3 = CellUtil.getCellNetworkInfo(IceDataCollector.j());
      if (bool3)
      {
        ((CellOperatorInfo)localObject3).simMcc = -1;
        ((CellOperatorInfo)localObject3).simMnc = -1;
      }
      if (bool4)
      {
        ((CellOperatorInfo)localObject3).currentMcc = -1;
        ((CellOperatorInfo)localObject3).currentMnc = -1;
      }
      if (BuildSettings.DEBUG) {
        Log.d("IceDataCollector", "-- cell operator: " + localObject3);
      }
      ((Sample)localObject1).cellOperator = ((CellOperatorInfo)localObject3);
    }
    catch (Exception localException3)
    {
      try
      {
        Object localObject3;
        if (!CellUtil.hasGetCurrentServingCellPermission(IceDataCollector.j())) {
          break label630;
        }
        ((Sample)localObject1).connectedCellTowerInfo = CellUtil.getCurrentCellTower(IceDataCollector.j());
        if (!BuildSettings.DEBUG) {
          break label378;
        }
        Log.d("IceDataCollector", "-- current serving cell: " + ((Sample)localObject1).connectedCellTowerInfo.id);
        label378:
        ((Sample)localObject1).connectedWifiAp = IceDataCollector.getConnectedWifiInfo(IceDataCollector.j());
        if (!IceDataCollector.h().isSampleLocationEnabled()) {
          break label510;
        }
        try
        {
          if (!LocationUtil.hasLocationPermission(IceDataCollector.j())) {
            break label680;
          }
          localObject3 = LocationUtil.getLastKnownLocations(IceDataCollector.j());
          if (!BuildSettings.DEBUG) {
            break label670;
          }
          Log.d("IceDataCollector", "-- locations:");
          Iterator localIterator = ((HashMap)localObject3).values().iterator();
          while (localIterator.hasNext())
          {
            LocationInfo localLocationInfo = (LocationInfo)localIterator.next();
            Log.d("IceDataCollector", "   + " + localLocationInfo);
          }
          if (!IceDataCollector.h().isSampleVisibleWifiEnabled()) {
            break label546;
          }
        }
        catch (Exception localException1)
        {
          if (!BuildSettings.DEBUG) {
            break label510;
          }
          Log.e("IceDataCollector", "Error getting location data", localException1);
        }
      }
      catch (Exception localException3)
      {
        label510:
        label546:
        label630:
        label670:
        label680:
        label698:
        label738:
        try
        {
          if (!WifiUtil.hasWifiScanPermission(IceDataCollector.j(), false)) {
            break label698;
          }
          WifiScanner.requestScan(IceDataCollector.j(), new a(bool1, bool2));
          for (;;)
          {
            synchronized (IceDataCollector.k())
            {
              IceDataCollector.a((Sample)localObject1);
              if (IceDataCollector.e() == null) {
                break label738;
              }
              IceDataCollector.e().add(localObject1);
              if (IceDataCollector.e().size() <= IceDataCollector.h().getSampleHistorySize()) {
                break label738;
              }
              IceDataCollector.e().removeFirst();
            }
            localException2 = localException2;
            if (!BuildSettings.DEBUG) {
              break;
            }
            Log.e("IceDataCollector", "Error getting cell operator data", localException2);
            break;
            if (!BuildSettings.DEBUG) {
              break label378;
            }
            Log.w("IceDataCollector", "application does not have permission to access current serving cell");
            break label378;
            localException3 = localException3;
            if (!BuildSettings.DEBUG) {
              break label378;
            }
            Log.e("IceDataCollector", "Error getting cell data", localException3);
            break label378;
            ((Sample)localObject2).lastKnownLocations = localException3;
            break label510;
            if (!BuildSettings.DEBUG) {
              break label510;
            }
            Log.w("IceDataCollector", "application does not have permission to access location");
            break label510;
            if (BuildSettings.DEBUG) {
              Log.w("IceDataCollector", "application does not have permission to scan for wifi access points");
            }
          }
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            if (BuildSettings.DEBUG) {
              Log.e("IceDataCollector", "Error scanning for wifi", localException4);
            }
          }
        }
      }
    }
    if (IceDataCollector.h().isSampleCellEnabled()) {}
  }
  
  class a
    implements WifiScanListener
  {
    a(boolean paramBoolean1, boolean paramBoolean2) {}
    
    public void onResultsReceived(List<ScanResult> paramList)
    {
      if (BuildSettings.DEBUG) {
        Log.d("IceDataCollector", "Received Wi-Fi scan results " + paramList.size());
      }
      paramList = WifiUtil.scanResultsToWifiInfos(paramList, bool1, bool2);
      if (BuildSettings.DEBUG)
      {
        Log.d("IceDataCollector", "-- wifi scan:");
        ??? = paramList.iterator();
        while (((Iterator)???).hasNext())
        {
          WifiInfo localWifiInfo = (WifiInfo)((Iterator)???).next();
          Log.d("IceDataCollector", "   + " + localWifiInfo);
        }
      }
      synchronized (IceDataCollector.k())
      {
        if (IceDataCollector.l() != null) {
          IceDataCollector.l().visibleWifiAp = paramList;
        }
        return;
      }
    }
    
    public void onTimeout()
    {
      if (BuildSettings.DEBUG) {
        Log.w("IceDataCollector", "Received Wi-Fi scan timeout");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */