package com.inmobi.commons.uid;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.json.JSONObject;

public class UID {
    public static final String KEY_AID = "AID";
    public static final String KEY_APPENDED_ID = "AIDL";
    public static final String KEY_FACEBOOK_ID = "FBA";
    public static final String KEY_GPID = "GPID";
    public static final String KEY_IMID = "IMID";
    public static final String KEY_LOGIN_ID = "LID";
    public static final String KEY_LTVID = "LTVID";
    public static final String KEY_ODIN1 = "O1";
    public static final String KEY_SESSION_ID = "SID";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_UM5_ID = "UM5";
    private static UID a;
    private Map<String, Boolean> b;
    private Map<String, Boolean> c;
    private Map<String, Boolean> d = new HashMap();
    private String e;
    private String f = null;

    private UID() {
        this.d.put("FBA", Boolean.valueOf(false));
        this.d.put("GPID", Boolean.valueOf(true));
        this.d.put("LID", Boolean.valueOf(true));
        this.d.put("LTVID", Boolean.valueOf(true));
        this.d.put("O1", Boolean.valueOf(true));
        this.d.put("SID", Boolean.valueOf(true));
        this.d.put("UM5", Boolean.valueOf(true));
        this.d.put("IMID", Boolean.valueOf(true));
        this.d.put("AIDL", Boolean.valueOf(true));
    }

    private String a() {
        return this.e;
    }

    private Map<String, Boolean> a(int paramInt) {
        HashMap localHashMap = new HashMap();
        if (((paramInt & 0x4) == 4) || (paramInt == 0)) {
            localHashMap.put("FBA", Boolean.valueOf(false));
        }
        if (((paramInt & 0x2) == 2) || (paramInt == 0)) {
            localHashMap.put("O1", Boolean.valueOf(false));
        }
        if (((paramInt & 0x8) == 8) || (paramInt == 0)) {
            localHashMap.put("UM5", Boolean.valueOf(false));
        }
        return localHashMap;
    }

    private Map<String, Boolean> a(Map<String, Boolean> paramMap) {
        HashMap localHashMap = new HashMap(this.d);
        if ((paramMap == null) && (this.c == null) && (this.b == null)) {
            return localHashMap;
        }
        Object localObject = paramMap;
        if (paramMap == null) {
            localObject = new HashMap();
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (this.b == null) {
            this.b = new HashMap();
        }
        paramMap = this.c.keySet().iterator();
        if (paramMap.hasNext()) {
            String str = (String) paramMap.next();
            boolean bool1;
            label137:
            boolean bool2;
            if (this.c.get(str) == null) {
                bool1 = true;
                if (this.b.get(str) != null) {
                    break label229;
                }
                bool2 = true;
                label153:
                if (((Map) localObject).get(str) != null) {
                    break label250;
                }
            }
            label229:
            label250:
            for (boolean bool3 = true; ; bool3 = ((Boolean) ((Map) localObject).get(str)).booleanValue()) {
                localHashMap.put(str, Boolean.valueOf(Boolean.valueOf(bool3).booleanValue() & Boolean.valueOf(bool1).booleanValue() & Boolean.valueOf(bool2).booleanValue()));
                break;
                bool1 = ((Boolean) this.c.get(str)).booleanValue();
                break label137;
                bool2 = ((Boolean) this.b.get(str)).booleanValue();
                break label153;
            }
        }
        return localHashMap;
    }

    public static UID getInstance() {
        if (a == null) {
            a = new UID();
        }
        return a;
    }

    public String getEncodedJSON(Map<String, Boolean> paramMap) {
        paramMap = getUidMap(paramMap, null, false);
        InternalSDKUtil.getEncodedMap(paramMap);
        return new JSONObject(paramMap).toString();
    }

    public String getEncryptedJSON(Map<String, Boolean> paramMap) {
        return new JSONObject(InternalSDKUtil.getEncodedMap(getMapForEncryption(paramMap))).toString();
    }

    public String getJSON(Map<String, Boolean> paramMap) {
        return new JSONObject(getRawUidMap(paramMap)).toString();
    }

    public Map<String, String> getMapForEncryption(Map<String, Boolean> paramMap) {
        String str = Integer.toString(new Random().nextInt());
        paramMap = InternalSDKUtil.encryptRSA(new JSONObject(getUidMap(paramMap, str, true)).toString());
        HashMap localHashMap = new HashMap();
        localHashMap.put("u-id-map", paramMap);
        localHashMap.put("u-id-key", str);
        localHashMap.put("u-key-ver", a.a());
        return localHashMap;
    }

    public Map<String, String> getRawUidMap(Map<String, Boolean> paramMap) {
        return getUidMap(paramMap, null, false);
    }

    public Map<String, String> getUidMap(Map<String, Boolean> paramMap, String paramString, boolean paramBoolean) {
        Map localMap = a(paramMap);
        HashMap localHashMap = new HashMap();
        if (this.f == null) {
            this.f = a.e();
        }
        String str;
        if ((((Boolean) localMap.get("O1")).booleanValue()) && (!a.h())) {
            str = a.a(this.f);
            paramMap = str;
            if (paramBoolean) {
                paramMap = InternalSDKUtil.xorWithKey(str, paramString);
            }
            localHashMap.put("O1", paramMap);
        }
        if (((Boolean) localMap.get("FBA")).booleanValue()) {
            str = a.d();
            if (str != null) {
                paramMap = str;
                if (paramBoolean) {
                    paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                }
                localHashMap.put("FBA", paramMap);
            }
        }
        if ((((Boolean) localMap.get("UM5")).booleanValue()) && (!a.h())) {
            str = a.b(this.f);
            paramMap = str;
            if (paramBoolean) {
                paramMap = InternalSDKUtil.xorWithKey(str, paramString);
            }
            localHashMap.put("UM5", paramMap);
        }
        if (((Boolean) localMap.get("LID")).booleanValue()) {
            str = a.c();
            if (str != null) {
                paramMap = str;
                if (paramBoolean) {
                    paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                }
                localHashMap.put("LID", paramMap);
            }
        }
        if (((Boolean) localMap.get("SID")).booleanValue()) {
            str = a.b();
            if (str != null) {
                paramMap = str;
                if (paramBoolean) {
                    paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                }
                localHashMap.put("SID", paramMap);
            }
        }
        if (((Boolean) localMap.get("LTVID")).booleanValue()) {
            str = a();
            if (str != null) {
                paramMap = str;
                if (paramBoolean) {
                    paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                }
                localHashMap.put("LTVID", paramMap);
            }
        }
        if (((Boolean) localMap.get("GPID")).booleanValue()) {
            paramMap = a.f();
            if (paramMap != null) {
                str = paramMap.getAdId();
                if (str != null) {
                    paramMap = str;
                    if (paramBoolean) {
                        paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                    }
                    localHashMap.put("GPID", paramMap);
                }
            }
        }
        if (((Boolean) localMap.get("IMID")).booleanValue()) {
            str = a.b(InternalSDKUtil.getContext());
            if (str != null) {
                paramMap = str;
                if (paramBoolean) {
                    paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                }
                localHashMap.put("IMID", paramMap);
            }
        }
        if (((Boolean) localMap.get("AIDL")).booleanValue()) {
            str = a.c(InternalSDKUtil.getContext());
            if (str != null) {
                paramMap = str;
                if (paramBoolean) {
                    paramMap = InternalSDKUtil.xorWithKey(str, paramString);
                }
                localHashMap.put("AIDL", paramMap);
            }
        }
        return localHashMap;
    }

    public void init() {
        a.g();
        printPublisherTestId();
        a.a(InternalSDKUtil.getContext());
    }

    public boolean isLimitAdTrackingEnabled() {
        return a.i();
    }

    public void printPublisherTestId() {
        try {
            Object localObject;
            if (a.h()) {
                localObject = a.f();
                if (localObject != null) {
                    localObject = ((AdvertisingId) localObject).getAdId();
                    if (localObject != null) {
                        Log.debug("[InMobi]-4.5.1", "Publisher device Id is " + (String) localObject);
                    }
                }
            } else {
                localObject = a.e();
                Log.debug("[InMobi]-4.5.1", "Publisher device Id is " + a.a((String) localObject));
                return;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get publisher device id", localException);
        }
    }

    public void refresh() {
    }

    public void setCommonsDeviceIdMaskMap(Map<String, Boolean> paramMap) {
        this.c = paramMap;
    }

    public void setLtvId(String paramString) {
        this.e = paramString;
    }

    public void setPublisherDeviceIdMaskMap(int paramInt) {
        this.b = a(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/uid/UID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */