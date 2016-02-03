package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CellUtil {
    private static final String[] a = {"android.permission.ACCESS_COARSE_LOCATION"};
    private static final String[] b = {"android.permission.ACCESS_FINE_LOCATION"};
    private static final String[] c = {"android.permission.ACCESS_COARSE_LOCATION"};

    private static int[] a(String paramString) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = -1;
        arrayOfInt[1] = -1;
        if ((paramString == null) || (paramString.equals(""))) {
            return arrayOfInt;
        }
        try {
            int i = Integer.parseInt(paramString.substring(0, 3));
            int j = Integer.parseInt(paramString.substring(3));
            arrayOfInt[0] = i;
            arrayOfInt[1] = j;
            return arrayOfInt;
        } catch (IndexOutOfBoundsException paramString) {
            return arrayOfInt;
        } catch (NumberFormatException paramString) {
        }
        return arrayOfInt;
    }

    public static CellOperatorInfo getCellNetworkInfo(Context paramContext) {
        CellOperatorInfo localCellOperatorInfo = new CellOperatorInfo();
        paramContext = (TelephonyManager) paramContext.getSystemService("phone");
        int[] arrayOfInt = a(paramContext.getNetworkOperator());
        localCellOperatorInfo.currentMcc = arrayOfInt[0];
        localCellOperatorInfo.currentMnc = arrayOfInt[1];
        paramContext = a(paramContext.getSimOperator());
        localCellOperatorInfo.simMcc = paramContext[0];
        localCellOperatorInfo.simMnc = paramContext[1];
        return localCellOperatorInfo;
    }

    public static CellTowerInfo getCurrentCellTower(Context paramContext) {
        Object localObject1 = (TelephonyManager) paramContext.getSystemService("phone");
        Object localObject2 = a(((TelephonyManager) localObject1).getNetworkOperator());
        Object localObject3 = ((TelephonyManager) localObject1).getCellLocation();
        if ((localObject3 == null) || (localObject2[0] == -1)) {
            return null;
        }
        localObject1 = new CellTowerInfo();
        String str1 = String.valueOf(localObject2[0]);
        localObject2 = String.valueOf(localObject2[1]);
        int i;
        int j;
        String str2;
        if ((localObject3 instanceof CdmaCellLocation)) {
            localObject3 = (CdmaCellLocation) localObject3;
            i = ((CdmaCellLocation) localObject3).getNetworkId();
            j = ((CdmaCellLocation) localObject3).getBaseStationId();
            int k = ((CdmaCellLocation) localObject3).getSystemId();
            ((CellTowerInfo) localObject1).signalStrength = CellUtil.a.a(paramContext);
            if ((i != -1) && (j != -1) && (k != -1)) {
                paramContext = Integer.toHexString(i);
                localObject3 = Integer.toHexString(j);
                str2 = Integer.toHexString(k);
            }
        }
        for (((CellTowerInfo) localObject1).id = (str1 + "-" + (String) localObject2 + "-" + paramContext + "-" + (String) localObject3 + "-" + str2); ; ((CellTowerInfo) localObject1).id = (str1 + "-" + (String) localObject2 + "-" + paramContext + "-" + (String) localObject3)) {
            do {
                return (CellTowerInfo) localObject1;
                localObject3 = (GsmCellLocation) localObject3;
                i = ((GsmCellLocation) localObject3).getCid();
                j = ((GsmCellLocation) localObject3).getLac();
                ((CellTowerInfo) localObject1).signalStrength = CellUtil.a.a(paramContext);
            } while ((i == -1) || (j == -1));
            paramContext = Integer.toHexString(j);
            localObject3 = Integer.toHexString(i);
        }
    }

    public static List<NeighboringCellInfo> getVisibleCellTower(Context paramContext) {
        List localList = ((TelephonyManager) paramContext.getSystemService("phone")).getNeighboringCellInfo();
        if (localList != null) {
            paramContext = localList;
            if (localList.size() == 0) {
                paramContext = null;
            }
            return paramContext;
        }
        return null;
    }

    public static List<Integer> getVisibleCellTowerIds(Context paramContext) {
        Object localObject = getVisibleCellTower(paramContext);
        if ((localObject == null) || (((List) localObject).size() == 0)) {
            return null;
        }
        paramContext = new ArrayList();
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            paramContext.add(Integer.valueOf(((NeighboringCellInfo) ((Iterator) localObject).next()).getCid()));
        }
        return paramContext;
    }

    public static boolean hasGetCurrentServingCellPermission(Context paramContext) {
        String[] arrayOfString = a;
        int k = arrayOfString.length;
        int j = 0;
        int i = 1;
        while (j < k) {
            if (paramContext.checkCallingOrSelfPermission(arrayOfString[j]) != 0) {
                i = 0;
            }
            j += 1;
        }
        arrayOfString = b;
        int m = arrayOfString.length;
        j = 0;
        k = 1;
        while (j < m) {
            if (paramContext.checkCallingOrSelfPermission(arrayOfString[j]) != 0) {
                k = 0;
            }
            j += 1;
        }
        return (i != 0) || (k != 0);
    }

    public static boolean hasGetVisibleCellTowerPermission(Context paramContext) {
        String[] arrayOfString = c;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j) {
            if (paramContext.checkCallingOrSelfPermission(arrayOfString[i]) != 0) {
                return false;
            }
            i += 1;
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/cellular/CellUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */