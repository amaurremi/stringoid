package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

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
  
  public static String getCurrentServingCell(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject1 = a(paramContext.getNetworkOperator());
    Object localObject2 = paramContext.getCellLocation();
    if ((localObject2 == null) || (localObject1[0] == -1)) {
      return null;
    }
    paramContext = String.valueOf(localObject1[0]);
    localObject1 = String.valueOf(localObject1[1]);
    int i;
    int j;
    String str1;
    if ((localObject2 instanceof CdmaCellLocation))
    {
      localObject2 = (CdmaCellLocation)localObject2;
      i = ((CdmaCellLocation)localObject2).getNetworkId();
      j = ((CdmaCellLocation)localObject2).getBaseStationId();
      int k = ((CdmaCellLocation)localObject2).getSystemId();
      if ((i != -1) && (j != -1) && (k != -1))
      {
        localObject2 = Integer.toHexString(i);
        str1 = Integer.toHexString(j);
        String str2 = Integer.toHexString(k);
        return paramContext + "-" + (String)localObject1 + "-" + (String)localObject2 + "-" + str1 + "-" + str2;
      }
    }
    else
    {
      localObject2 = (GsmCellLocation)localObject2;
      i = ((GsmCellLocation)localObject2).getCid();
      j = ((GsmCellLocation)localObject2).getLac();
      if ((i != -1) && (j != -1))
      {
        localObject2 = Integer.toHexString(j);
        str1 = Integer.toHexString(i);
        return paramContext + "-" + (String)localObject1 + "-" + (String)localObject2 + "-" + str1;
      }
    }
    return null;
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/thinICE/cellular/CellUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */