package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UID
{
  public static final String FACEBOOK_ID = "FBA";
  public static final boolean FBA_DEF = false;
  public static final boolean LID_DEF = true;
  public static final String LOGIN_ID = "LID";
  public static final boolean LTVE_DEF = true;
  public static final String LTV_ID = "LTVID";
  public static final String LTV_ID_ENABLE = "LTVID";
  public static final boolean O1_DEF = true;
  public static final String ODIN1 = "O1";
  public static final String SESSION_ID = "SID";
  public static final boolean SID_DEF = true;
  public static final boolean UM5_DEF = true;
  public static final String UM5_ID = "UM5";
  private static UID a = new UID();
  private boolean b = true;
  private boolean c = true;
  private boolean d = true;
  private boolean e = false;
  private boolean f = true;
  private boolean g = true;
  
  public UID() {}
  
  public UID(Context paramContext)
  {
    InternalSDKUtil.setContext(paramContext);
  }
  
  public UID(Context paramContext, Map<String, Object> paramMap)
  {
    this(paramContext);
    setFromMap(paramMap);
  }
  
  public UID(Map<String, Object> paramMap)
  {
    setFromMap(paramMap);
  }
  
  private Map<String, String> a(int paramInt, String paramString)
  {
    paramInt = UserInfo.getInstance().getDeviceIDMask();
    Object localObject = InternalSDKUtil.getContext();
    HashMap localHashMap = new HashMap();
    String str;
    if (paramInt <= 0)
    {
      if ((this.b) && (a.b)) {
        localHashMap.put("O1", UIDHelper.a(UIDHelper.getODIN1(UIDHelper.getAndroidId((Context)localObject)), paramString));
      }
      if ((this.e) && (a.e))
      {
        str = UIDHelper.getFBId((Context)localObject);
        if (str != null) {
          localHashMap.put("FBA", UIDHelper.a(str, paramString));
        }
      }
      if ((this.f) && (a.f)) {
        localHashMap.put("UM5", UIDHelper.a(UIDHelper.getUM5(UIDHelper.getAndroidId((Context)localObject)), paramString));
      }
    }
    for (;;)
    {
      if ((this.d) && (a.d))
      {
        localObject = UserInfo.getInstance().getIDType(IMIDType.ID_LOGIN);
        if (localObject != null) {
          localHashMap.put("LID", UIDHelper.a((String)localObject, paramString));
        }
      }
      if ((this.c) && (a.c))
      {
        localObject = UserInfo.getInstance().getIDType(IMIDType.ID_SESSION);
        if (localObject != null) {
          localHashMap.put("SID", UIDHelper.a((String)localObject, paramString));
        }
      }
      if ((this.g) && (a.g))
      {
        localObject = AnalyticsInitializer.getRawConfigParams().getLTVId();
        if (localObject != null) {
          localHashMap.put("LTVID", UIDHelper.a(localObject + "", paramString));
        }
      }
      return localHashMap;
      if (((paramInt & 0x2) != 2) && (this.b) && (a.b)) {
        localHashMap.put("O1", UIDHelper.a(UIDHelper.getODIN1(UIDHelper.getAndroidId((Context)localObject)), paramString));
      }
      if (((paramInt & 0x4) != 4) && (this.e) && (a.e))
      {
        str = UIDHelper.getFBId((Context)localObject);
        if (str != null) {
          localHashMap.put("FBA", UIDHelper.a(str, paramString));
        }
      }
      if (((paramInt & 0x8) != 8) && (this.f) && (a.f)) {
        localHashMap.put("UM5", UIDHelper.a(UIDHelper.getUM5(UIDHelper.getAndroidId((Context)localObject)), paramString));
      }
    }
  }
  
  public static UID getCommonsUid()
  {
    return a;
  }
  
  public String getDefaultUidMap(int paramInt, String paramString, Map<String, String> paramMap)
  {
    Map localMap = a(paramInt, paramString);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        if (str2 != null) {
          localMap.put(str1, UIDHelper.a(str2, paramString));
        }
      }
    }
    return UIDUtil.getEncryptedJSON(localMap);
  }
  
  public String getUidMap(int paramInt, String paramString, Map<String, String> paramMap)
  {
    try
    {
      InternalSDKUtil.initialize(InternalSDKUtil.getContext());
      return getDefaultUidMap(paramInt, paramString, paramMap);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("commons", "Unable to initialize commons.");
      }
    }
  }
  
  public boolean isFba()
  {
    return this.e;
  }
  
  public boolean isLid()
  {
    return this.d;
  }
  
  public boolean isLtve()
  {
    return this.g;
  }
  
  public boolean isO1()
  {
    return this.b;
  }
  
  public boolean isSid()
  {
    return this.c;
  }
  
  public boolean isUm5()
  {
    return this.f;
  }
  
  public final void setFromMap(Map<String, Object> paramMap)
  {
    this.b = InternalSDKUtil.getBooleanFromMap(paramMap, "O1");
    this.c = InternalSDKUtil.getBooleanFromMap(paramMap, "SID");
    this.d = InternalSDKUtil.getBooleanFromMap(paramMap, "LID");
    this.e = InternalSDKUtil.getBooleanFromMap(paramMap, "FBA");
    this.f = InternalSDKUtil.getBooleanFromMap(paramMap, "UM5");
    this.g = InternalSDKUtil.getBooleanFromMap(paramMap, "LTVID");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/uid/UID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */