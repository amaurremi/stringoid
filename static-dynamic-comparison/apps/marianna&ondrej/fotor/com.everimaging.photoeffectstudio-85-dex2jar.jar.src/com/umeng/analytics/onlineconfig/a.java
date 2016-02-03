package com.umeng.analytics.onlineconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.f;
import com.umeng.common.Log;
import com.umeng.common.net.k;
import com.umeng.common.net.l;
import com.umeng.common.util.h;

import java.util.Iterator;

import org.json.JSONObject;

public class a {
    private final String a = "last_config_time";
    private final String b = "report_policy";
    private final String c = "online_config";
    private UmengOnlineConfigureListener d = null;
    private c e = null;

    private void a(Context paramContext, b paramb) {
        SharedPreferences.Editor localEditor = f.a(paramContext).g().edit();
        if (!TextUtils.isEmpty(paramb.e)) {
            localEditor.putString("umeng_last_config_time", paramb.e);
            localEditor.commit();
        }
        if (paramb.c != -1) {
            f.a(paramContext).a(paramb.c, paramb.d);
        }
    }

    private void a(JSONObject paramJSONObject) {
        if (this.d != null) {
            this.d.onDataReceived(paramJSONObject);
        }
    }

    private JSONObject b(Context paramContext) {
        JSONObject localJSONObject = new JSONObject();
        try {
            getClass();
            localJSONObject.put("type", "online_config");
            localJSONObject.put("appkey", AnalyticsConfig.getAppkey(paramContext));
            localJSONObject.put("version_code", com.umeng.common.b.c(paramContext));
            localJSONObject.put("package", com.umeng.common.b.u(paramContext));
            localJSONObject.put("sdk_version", "5.2.2");
            localJSONObject.put("idmd5", h.b(com.umeng.common.b.f(paramContext)));
            localJSONObject.put("channel", AnalyticsConfig.getChannel(paramContext));
            localJSONObject.put("report_policy", f.a(paramContext).a()[0]);
            localJSONObject.put("last_config_time", c(paramContext));
            return localJSONObject;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "exception in onlineConfigInternal");
        }
        return null;
    }

    private void b(Context paramContext, b paramb) {
        if ((paramb.a == null) || (paramb.a.length() == 0)) {
            return;
        }
        paramContext = f.a(paramContext).g().edit();
        try {
            paramb = paramb.a;
            Iterator localIterator = paramb.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                paramContext.putString(str, paramb.getString(str));
            }
            paramContext.commit();
        } catch (Exception paramContext) {
            Log.c("MobclickAgent", "save online config params", paramContext);
            return;
        }
        Log.a("MobclickAgent", "get online setting params: " + paramb);
    }

    private String c(Context paramContext) {
        return f.a(paramContext).g().getString("umeng_last_config_time", "");
    }

    public void a() {
        this.d = null;
    }

    public void a(Context paramContext) {
        if (paramContext == null) {
        }
        try {
            Log.b("MobclickAgent", "unexpected null context in updateOnlineConfig");
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "exception in updateOnlineConfig");
        }
        new Thread(new b(paramContext)).start();
        return;
    }

    public void a(UmengOnlineConfigureListener paramUmengOnlineConfigureListener) {
        this.d = paramUmengOnlineConfigureListener;
    }

    public void a(c paramc) {
        this.e = paramc;
    }

    public void b() {
        this.e = null;
    }

    public class a
            extends l {
        private JSONObject e;

        public a(JSONObject paramJSONObject) {
            super();
            this.e = paramJSONObject;
        }

        public JSONObject a() {
            return this.e;
        }

        public String b() {
            return this.d;
        }
    }

    public class b
            extends k
            implements Runnable {
        Context a;

        public b(Context paramContext) {
            this.a = paramContext.getApplicationContext();
        }

        private void a() {
            Object localObject = a.a(a.this, this.a);
            a.a locala = new a.a(a.this, (JSONObject) localObject);
            String[] arrayOfString = com.umeng.analytics.a.g;
            int i = 0;
            localObject = null;
            for (; ; ) {
                if (i < arrayOfString.length) {
                    locala.a(arrayOfString[i]);
                    localObject = (b) execute(locala, b.class);
                    if (localObject == null) {
                    }
                } else {
                    if (localObject != null) {
                        break;
                    }
                    a.a(a.this, null);
                    return;
                }
                i += 1;
            }
            Log.a("MobclickAgent", "response : " + ((b) localObject).b);
            if (((b) localObject).b) {
                if (a.a(a.this) != null) {
                    a.a(a.this).a(((b) localObject).c, ((b) localObject).d);
                }
                a.a(a.this, this.a, (b) localObject);
                a.b(a.this, this.a, (b) localObject);
                a.a(a.this, ((b) localObject).a);
                return;
            }
            a.a(a.this, null);
        }

        public void run() {
            try {
                a();
                return;
            } catch (Exception localException) {
                a.a(a.this, null);
                Log.c("MobclickAgent", "reques update error", localException);
            }
        }

        public boolean shouldCompressData() {
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/onlineconfig/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */