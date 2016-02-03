package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public abstract class UMSocialService {
    private static void a(Context paramContext, b paramb, String paramString, UMPlatformData... paramVarArgs) {
        int i = 0;
        if (paramVarArgs != null) {
        }
        try {
            int j = paramVarArgs.length;
            if (i < j) {
                if (!paramVarArgs[i].isValid()) {
                    throw new a("parameter is not valid.");
                }
            }
        } catch (a paramContext) {
            for (; ; ) {
                Log.e("MobclickAgent", "unable send event.", paramContext);
                return;
                i += 1;
            }
            new a(f.a(paramContext, paramString, paramVarArgs), paramb, paramVarArgs).execute(new Void[0]);
            return;
        } catch (Exception paramContext) {
            Log.e("MobclickAgent", "", paramContext);
        }
    }

    public static void share(Context paramContext, String paramString, UMPlatformData... paramVarArgs) {
        a(paramContext, null, paramString, paramVarArgs);
    }

    public static void share(Context paramContext, UMPlatformData... paramVarArgs) {
        a(paramContext, null, null, paramVarArgs);
    }

    private static class a
            extends AsyncTask<Void, Void, d> {
        String a = paramArrayOfString[0];
        String b = paramArrayOfString[1];
        UMSocialService.b c;
        UMPlatformData[] d;

        public a(String[] paramArrayOfString, UMSocialService.b paramb, UMPlatformData[] paramArrayOfUMPlatformData) {
            this.c = paramb;
            this.d = paramArrayOfUMPlatformData;
        }

        protected d a(Void... paramVarArgs) {
            if (TextUtils.isEmpty(this.b)) {
                paramVarArgs = c.a(this.a);
            }
            label121:
            for (; ; ) {
                try {
                    Object localObject = new JSONObject(paramVarArgs);
                    int i = ((JSONObject) localObject).optInt("st");
                    if (i != 0) {
                        break label121;
                    }
                    i = 65132;
                    paramVarArgs = new d(i);
                    String str = ((JSONObject) localObject).optString("msg");
                    if (!TextUtils.isEmpty(str)) {
                        paramVarArgs.a(str);
                    }
                    localObject = ((JSONObject) localObject).optString("data");
                    if (!TextUtils.isEmpty((CharSequence) localObject)) {
                        paramVarArgs.b((String) localObject);
                    }
                    return paramVarArgs;
                } catch (Exception paramVarArgs) {
                    return new d(-99, paramVarArgs);
                }
                paramVarArgs = c.a(this.a, this.b);
            }
        }

        protected void a(d paramd) {
            if (this.c != null) {
                this.c.a(paramd, this.d);
            }
        }

        protected void onPreExecute() {
            if (this.c != null) {
                this.c.a();
            }
        }
    }

    public static abstract interface b {
        public abstract void a();

        public abstract void a(d paramd, UMPlatformData... paramVarArgs);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/social/UMSocialService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */