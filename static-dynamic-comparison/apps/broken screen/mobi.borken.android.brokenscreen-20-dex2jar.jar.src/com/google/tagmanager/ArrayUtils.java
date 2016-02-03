package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.EventInfo;
import com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.Debug.ResolvedProperty;
import com.google.analytics.containertag.proto.Debug.ResolvedRule;

class ArrayUtils
{
  public static Debug.EventInfo[] appendToArray(Debug.EventInfo[] paramArrayOfEventInfo, Debug.EventInfo paramEventInfo)
  {
    Debug.EventInfo[] arrayOfEventInfo = new Debug.EventInfo[paramArrayOfEventInfo.length + 1];
    System.arraycopy(paramArrayOfEventInfo, 0, arrayOfEventInfo, 0, paramArrayOfEventInfo.length);
    arrayOfEventInfo[paramArrayOfEventInfo.length] = paramEventInfo;
    return arrayOfEventInfo;
  }
  
  public static Debug.ResolvedFunctionCall[] appendToArray(Debug.ResolvedFunctionCall[] paramArrayOfResolvedFunctionCall, Debug.ResolvedFunctionCall paramResolvedFunctionCall)
  {
    Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[paramArrayOfResolvedFunctionCall.length + 1];
    System.arraycopy(paramArrayOfResolvedFunctionCall, 0, arrayOfResolvedFunctionCall, 0, paramArrayOfResolvedFunctionCall.length);
    arrayOfResolvedFunctionCall[paramArrayOfResolvedFunctionCall.length] = paramResolvedFunctionCall;
    return arrayOfResolvedFunctionCall;
  }
  
  public static Debug.ResolvedProperty[] appendToArray(Debug.ResolvedProperty[] paramArrayOfResolvedProperty, Debug.ResolvedProperty paramResolvedProperty)
  {
    Debug.ResolvedProperty[] arrayOfResolvedProperty = new Debug.ResolvedProperty[paramArrayOfResolvedProperty.length + 1];
    System.arraycopy(paramArrayOfResolvedProperty, 0, arrayOfResolvedProperty, 0, paramArrayOfResolvedProperty.length);
    arrayOfResolvedProperty[paramArrayOfResolvedProperty.length] = paramResolvedProperty;
    return arrayOfResolvedProperty;
  }
  
  public static Debug.ResolvedRule[] appendToArray(Debug.ResolvedRule[] paramArrayOfResolvedRule, Debug.ResolvedRule paramResolvedRule)
  {
    Debug.ResolvedRule[] arrayOfResolvedRule = new Debug.ResolvedRule[paramArrayOfResolvedRule.length + 1];
    System.arraycopy(paramArrayOfResolvedRule, 0, arrayOfResolvedRule, 0, paramArrayOfResolvedRule.length);
    arrayOfResolvedRule[paramArrayOfResolvedRule.length] = paramResolvedRule;
    return arrayOfResolvedRule;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */