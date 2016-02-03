package com.inmobi.commons.uid;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

class a {
    private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static AdvertisingId b = null;

    static String a() {
        return "1";
    }

    static String a(String paramString) {
        return InternalSDKUtil.getDigested(paramString, "SHA-1");
    }

    protected static void a(Context paramContext) {
        Object localObject2 = FileOperations.getPreferences(paramContext, "impref", "IMID");
        long l = FileOperations.getLongPreferences(paramContext, "impref", "timestamp");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = UUID.randomUUID().toString();
            FileOperations.setPreferences(paramContext, "impref", "IMID", (String) localObject1);
            FileOperations.setPreferences(paramContext, "impref", "AID", DeviceInfo.getAid());
            FileOperations.setPreferences(paramContext, "impref", "AIDL", DeviceInfo.getAid());
        }
        if (l == 0L) {
            FileOperations.setPreferences(paramContext, "impref", "timestamp", new Date().getTime());
        }
        localObject2 = new Intent();
        ((Intent) localObject2).setAction("com.inmobi.share.id");
        ((Intent) localObject2).putExtra("IMID", (String) localObject1);
        ((Intent) localObject2).putExtra("AIDL", FileOperations.getPreferences(paramContext, "impref", "AIDL"));
        ((Intent) localObject2).putExtra("timestamp", FileOperations.getLongPreferences(paramContext, "impref", "timestamp"));
        ((Intent) localObject2).putExtra("AID", DeviceInfo.getAid());
        paramContext.sendBroadcast((Intent) localObject2);
    }

    static String b() {
        return DemogInfo.getIDType(IMIDType.ID_SESSION);
    }

    static String b(Context paramContext) {
        return FileOperations.getPreferences(paramContext, "impref", "IMID");
    }

    static String b(String paramString) {
        return InternalSDKUtil.getDigested(paramString, "MD5");
    }

    static String c() {
        return DemogInfo.getIDType(IMIDType.ID_LOGIN);
    }

    static String c(Context paramContext) {
        try {
            JSONObject localJSONObject = new JSONObject();
            String str = FileOperations.getPreferences(paramContext, "impref", "AID");
            if (str != null) {
                localJSONObject.put("p", str);
            }
            Object localObject = FileOperations.getPreferences(paramContext, "impref", "AIDL");
            paramContext = (Context) localObject;
            if (localObject != null) {
                paramContext = (Context) localObject;
                if (((String) localObject).contains(str)) {
                    paramContext = ((String) localObject).replace(str, "");
                }
            }
            if ((paramContext != null) && (paramContext.trim() != "")) {
                localObject = paramContext;
                if (paramContext.charAt(0) == ',') {
                    localObject = paramContext.substring(1);
                }
                paramContext = new JSONArray();
                paramContext.put(localObject);
                localJSONObject.put("s", paramContext);
            }
            paramContext = localJSONObject.toString();
            return paramContext;
        } catch (Exception paramContext) {
        }
        return null;
    }

    static String d() {
        Object localObject = InternalSDKUtil.getContext();
        try {
            localObject = ((Context) localObject).getContentResolver().query(a, new String[]{"aid"}, null, null, null);
            if ((localObject != null) && (((Cursor) localObject).moveToFirst())) {
                localObject = ((Cursor) localObject).getString(((Cursor) localObject).getColumnIndex("aid"));
                if (localObject != null) {
                    int i = ((String) localObject).length();
                    if (i != 0) {
                        return???;
                    }
                }
                return null;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Unable to retrieve Facebook attrib id: " + localException);
            return null;
        }
        String str = null;
        return str;
    }

    static String e() {
        try {
            String str = (String) Class.forName("com.inmobi.commons.uid.PlatformId").getDeclaredMethod("getAndroidId", new Class[]{Context.class}).invoke(null, new Object[]{InternalSDKUtil.getContext()});
            return str;
        } catch (Exception localException) {
        }
        return null;
    }

    static AdvertisingId f() {
        return b;
    }

    static void g() {
        b = new AdvertisingId();
        b.a(FileOperations.getPreferences(InternalSDKUtil.getContext(), "impref", "gpid"));
        b.a(FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck"));
        new Thread(new a.a()).start();
    }

    static boolean h() {
        boolean bool = false;
        try {
            int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext());
            if (i == 0) {
                bool = true;
            }
            return bool;
        } catch (NoClassDefFoundError localNoClassDefFoundError) {
        }
        return false;
    }

    static boolean i() {
        AdvertisingId localAdvertisingId = f();
        if (localAdvertisingId != null) {
            return localAdvertisingId.isLimitAdTracking();
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/uid/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */