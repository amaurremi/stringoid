package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class CellUtil
{
  private static final String[] a = { "android.permission.ACCESS_COARSE_LOCATION" };
  
  private static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = -1;
    arrayOfInt[1] = -1;
    if ((paramString == null) || (paramString.equals(""))) {
      return arrayOfInt;
    }
    try
    {
      int i = Integer.parseInt(paramString.substring(0, 3));
      int j = Integer.parseInt(paramString.substring(3));
      arrayOfInt[0] = i;
      arrayOfInt[1] = j;
      return arrayOfInt;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      return arrayOfInt;
    }
    catch (NumberFormatException paramString) {}
    return arrayOfInt;
  }
  
  public static CellOperatorInfo getCellNetworkInfo(Context paramContext)
  {
    CellOperatorInfo localCellOperatorInfo = new CellOperatorInfo();
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    int[] arrayOfInt = a(paramContext.getNetworkOperator());
    localCellOperatorInfo.currentMcc = arrayOfInt[0];
    localCellOperatorInfo.currentMnc = arrayOfInt[1];
    paramContext = a(paramContext.getSimOperator());
    localCellOperatorInfo.simMcc = paramContext[0];
    localCellOperatorInfo.simMnc = paramContext[1];
    return localCellOperatorInfo;
  }
  
  public static CellTowerInfo getCurrentCellTower(Context paramContext)
  {
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject2 = a(((TelephonyManager)localObject1).getNetworkOperator());
    Object localObject3 = ((TelephonyManager)localObject1).getCellLocation();
    if ((localObject3 == null) || (localObject2[0] == -1)) {
      return null;
    }
    localObject1 = new CellTowerInfo();
    String str1 = String.valueOf(localObject2[0]);
    localObject2 = String.valueOf(localObject2[1]);
    int i;
    int j;
    String str2;
    if ((localObject3 instanceof CdmaCellLocation))
    {
      localObject3 = (CdmaCellLocation)localObject3;
      i = ((CdmaCellLocation)localObject3).getNetworkId();
      j = ((CdmaCellLocation)localObject3).getBaseStationId();
      int k = ((CdmaCellLocation)localObject3).getSystemId();
      ((CellTowerInfo)localObject1).signalStrength = a.b(paramContext);
      if ((i != -1) && (j != -1) && (k != -1))
      {
        paramContext = Integer.toHexString(i);
        localObject3 = Integer.toHexString(j);
        str2 = Integer.toHexString(k);
      }
    }
    for (((CellTowerInfo)localObject1).id = (str1 + "-" + (String)localObject2 + "-" + paramContext + "-" + (String)localObject3 + "-" + str2);; ((CellTowerInfo)localObject1).id = (str1 + "-" + (String)localObject2 + "-" + paramContext + "-" + (String)localObject3))
    {
      do
      {
        return (CellTowerInfo)localObject1;
        localObject3 = (GsmCellLocation)localObject3;
        i = ((GsmCellLocation)localObject3).getCid();
        j = ((GsmCellLocation)localObject3).getLac();
        ((CellTowerInfo)localObject1).signalStrength = a.a(paramContext);
      } while ((i == -1) || (j == -1));
      paramContext = Integer.toHexString(j);
      localObject3 = Integer.toHexString(i);
    }
  }
  
  public static boolean hasGetCurrentServingCellPermission(Context paramContext)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramContext.checkCallingOrSelfPermission(arrayOfString[i]) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static class a
  {
    static int a(Context paramContext)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        paramContext = (ArrayList)TelephonyManager.class.getMethod("getAllCellInfo", (Class[])null).invoke(paramContext, (Object[])null);
        if (paramContext != null)
        {
          paramContext = paramContext.get(0);
          paramContext = Class.forName("android.telephony.CellInfoGsm").getMethod("getCellSignalStrength", (Class[])null).invoke(paramContext, (Object[])null);
          int i = ((Integer)Class.forName("android.telephony.CellSignalStrengthGsm").getMethod("getDbm", (Class[])null).invoke(paramContext, (Object[])null)).intValue();
          return i;
        }
      }
      catch (Exception paramContext)
      {
        if (BuildSettings.DEBUG) {
          Log.e("IceDataCollector", "Error getting cell tower signal strength", paramContext);
        }
      }
      return 0;
    }
    
    static int b(Context paramContext)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        paramContext = (ArrayList)TelephonyManager.class.getMethod("getAllCellInfo", (Class[])null).invoke(paramContext, (Object[])null);
        if (paramContext != null)
        {
          paramContext = paramContext.get(0);
          paramContext = Class.forName("android.telephony.CellInfoCdma").getMethod("getCellSignalStrength", (Class[])null).invoke(paramContext, (Object[])null);
          int i = ((Integer)Class.forName("android.telephony.CellSignalStrengthCdma").getMethod("getDbm", (Class[])null).invoke(paramContext, (Object[])null)).intValue();
          return i;
        }
      }
      catch (Exception paramContext)
      {
        if (BuildSettings.DEBUG) {
          Log.e("IceDataCollector", "Error getting cell tower signal strength", paramContext);
        }
      }
      return 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/cellular/CellUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */