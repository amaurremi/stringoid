package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.location.LocationUtil;
import com.inmobi.commons.thinICE.wifi.WifiScanner;
import com.inmobi.commons.thinICE.wifi.WifiUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
        implements Runnable {
    private void a() {
        if (IceDataCollector.m() != null) {
            IceDataCollector.m().onDataCollected();
        }
    }

    public void run() {
        boolean bool1 = false;
        if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "** sample runnable");
        }
        if (IceDataCollector.c() == null) {
            if (BuildSettings.DEBUG) {
                Log.w("IceDataCollector", "sampling when looper is null, exiting");
            }
        }
        for (; ; ) {
            return;
            if ((Build.VERSION.SDK_INT < 14) && (!IceDataCollector.d().hasWindowFocus())) {
                if (BuildSettings.DEBUG) {
                    Log.d("IceDataCollector", "activity no longer has focus, terminating");
                }
                IceDataCollector.b();
                localObject1 = IceDataCollector.e();
                IceDataCollector.flush();
                IceDataCollector.a(null);
                IceDataCollector.a(null);
                if (IceDataCollector.f() != null) {
                    IceDataCollector.f().onSamplingTerminated((List) localObject1);
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
            boolean bool2 = ThinICEConfigSettings.bitTest(i, 1);
            i = IceDataCollector.h().getCellOpFlags();
            boolean bool3 = ThinICEConfigSettings.bitTest(i, 1);
            boolean bool4 = ThinICEConfigSettings.bitTest(i, 2);
            if (IceDataCollector.h().isSampleCellOperatorEnabled()) {
            }
            try {
                localObject3 = CellUtil.getCellNetworkInfo(IceDataCollector.j());
                if (bool3) {
                    ((CellOperatorInfo) localObject3).simMcc = -1;
                    ((CellOperatorInfo) localObject3).simMnc = -1;
                }
                if (bool4) {
                    ((CellOperatorInfo) localObject3).currentMcc = -1;
                    ((CellOperatorInfo) localObject3).currentMnc = -1;
                }
                if (BuildSettings.DEBUG) {
                    Log.d("IceDataCollector", "-- cell operator: " + localObject3);
                }
                ((Sample) localObject1).cellOperator = ((CellOperatorInfo) localObject3);
                if (!IceDataCollector.h().isSampleCellEnabled()) {
                }
            } catch (Exception localException4) {
                try {
                    if (CellUtil.hasGetCurrentServingCellPermission(IceDataCollector.j())) {
                        ((Sample) localObject1).connectedCellTowerInfo = CellUtil.getCurrentCellTower(IceDataCollector.j());
                        if (BuildSettings.DEBUG) {
                            Log.d("IceDataCollector", "-- current serving cell: " + ((Sample) localObject1).connectedCellTowerInfo.id);
                        }
                        label378:
                        if (!IceDataCollector.h().isSampleVisibleCellTowerEnabled()) {
                        }
                    }
                } catch (Exception localException4) {
                    try {
                        Object localObject3;
                        if (CellUtil.hasGetVisibleCellTowerPermission(IceDataCollector.j())) {
                            ((Sample) localObject1).visibleCellTowerInfo = CellUtil.getVisibleCellTower(IceDataCollector.j());
                        }
                        for (; ; ) {
                            ((Sample) localObject1).connectedWifiAp = IceDataCollector.getConnectedWifiInfo(IceDataCollector.j());
                            if (IceDataCollector.h().isSampleLocationEnabled()) {
                                try {
                                    if (!LocationUtil.hasLocationPermission(IceDataCollector.j())) {
                                        break label715;
                                    }
                                    localObject3 = LocationUtil.getLastKnownLocations(IceDataCollector.j());
                                    if (!BuildSettings.DEBUG) {
                                        break label705;
                                    }
                                    Log.d("IceDataCollector", "-- locations:");
                                    Iterator localIterator = ((HashMap) localObject3).values().iterator();
                                    while (localIterator.hasNext()) {
                                        LocationInfo localLocationInfo = (LocationInfo) localIterator.next();
                                        Log.d("IceDataCollector", "   + " + localLocationInfo);
                                    }
                                    synchronized (IceDataCollector.k()) {
                                        IceDataCollector.a((Sample) localObject1);
                                        if (IceDataCollector.e() == null) {
                                            break label733;
                                        }
                                        IceDataCollector.e().add(localObject1);
                                        if (IceDataCollector.e().size() <= IceDataCollector.h().getSampleHistorySize()) {
                                            break label733;
                                        }
                                        IceDataCollector.e().removeFirst();
                                    }
                                } catch (Exception localException2) {
                                    if (BuildSettings.DEBUG) {
                                        Log.e("IceDataCollector", "Error getting location data", localException2);
                                    }
                                }
                            }
                            localException3 = localException3;
                            if (!BuildSettings.DEBUG) {
                                break;
                            }
                            Log.e("IceDataCollector", "Error getting cell operator data", localException3);
                            break;
                            if (!BuildSettings.DEBUG) {
                                break label378;
                            }
                            Log.w("IceDataCollector", "application does not have permission to access current serving cell");
                            break label378;
                            localException4 = localException4;
                            if (!BuildSettings.DEBUG) {
                                break label378;
                            }
                            Log.e("IceDataCollector", "Error getting cell data", localException4);
                            break label378;
                            if (BuildSettings.DEBUG) {
                                Log.w("IceDataCollector", "application does not have permission to access current serving cell");
                            }
                        }
                    } catch (Exception localException5) {
                        for (; ; ) {
                            if (BuildSettings.DEBUG) {
                                Log.e("IceDataCollector", "Error getting cell data", localException5);
                                continue;
                                label705:
                                ((Sample) localObject2).lastKnownLocations = localException5;
                                continue;
                                label715:
                                if (BuildSettings.DEBUG) {
                                    Log.w("IceDataCollector", "application does not have permission to access location");
                                }
                            }
                        }
                        label733:
                        if (IceDataCollector.h().isSampleVisibleWifiEnabled()) {
                            try {
                                if (!WifiUtil.hasWifiScanPermission(IceDataCollector.j(), false)) {
                                    break label803;
                                }
                                a.a locala = new a.a(this, bool1, bool2);
                                if (WifiScanner.requestScan(IceDataCollector.j(), locala)) {
                                    continue;
                                }
                                a();
                                return;
                            } catch (Exception localException1) {
                            }
                            if (BuildSettings.DEBUG) {
                                Log.e("IceDataCollector", "Error scanning for wifi", localException1);
                                return;
                                label803:
                                a();
                                if (BuildSettings.DEBUG) {
                                    Log.w("IceDataCollector", "application does not have permission to scan for wifi access points");
                                }
                            }
                        } else {
                            a();
                        }
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */