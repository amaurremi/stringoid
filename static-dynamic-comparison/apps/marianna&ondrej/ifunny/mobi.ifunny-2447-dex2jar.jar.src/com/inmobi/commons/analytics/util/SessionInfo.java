package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.internal.Log;

import java.util.GregorianCalendar;
import java.util.UUID;

public class SessionInfo {
    private static String a;
    private static long b;
    private static String c;
    private static int d;

    public static String getAppId(Context paramContext) {
        try {
            if (c != null) {
                return c;
            }
            paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsAppId", 0).getString("APP_ID", null);
            c = paramContext;
            return paramContext;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-4.5.1", "Exception getting app id", paramContext);
        }
        return null;
    }

    public static int getFirstTime() {
        try {
            int i = d;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static String getSessionId(Context paramContext) {
        try {
            if (a != null) {
                paramContext = a;
            }
            for (; ; ) {
                return paramContext;
                paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("SESSION_ID", null);
                a = paramContext;
            }
        } catch (Exception paramContext) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "Exception getting session id", paramContext);
                paramContext = null;
            }
        } finally {
        }
    }

    public static long getSessionTime(Context paramContext) {
        try {
            if (b != 0L) {
                l = b;
            }
            for (; ; ) {
                return l;
                l = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).getLong("SESSION_TIME", 0L);
                b = l;
            }
        } catch (Exception paramContext) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "Exception getting session time", paramContext);
                long l = 0L;
            }
        } finally {
        }
    }

    public static boolean isUpdatedFromOldSDK(Context paramContext) {
        try {
            boolean bool = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).getBoolean("UPDATED_FROM_OLD_SDK", false);
            return bool;
        } finally {
            paramContext =finally;
            throw paramContext;
        }
    }

    public static void removeSessionId(Context paramContext) {
        try {
            a = null;
            b = 0L;
            paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
            paramContext.putString("SESSION_ID", null);
            paramContext.putString("SESSION_TIME", null);
            paramContext.commit();
            return;
        } catch (Exception paramContext) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "Exception removing session id", paramContext);
            }
        } finally {
        }
    }

    public static void resetFirstTime() {
        try {
            d = 0;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static void storeAppId(Context paramContext, String paramString) {
        try {
            c = paramString;
            paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsAppId", 0).edit();
            paramContext.putString("APP_ID", paramString);
            paramContext.commit();
            return;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-4.5.1", "Exception storing app id", paramContext);
        }
    }

    public static void storeFirstTime(Context paramContext) {
        int j = 0;
        for (; ; ) {
            try {
                Object localObject = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0);
                paramContext = ((SharedPreferences) localObject).edit();
                l = ((SharedPreferences) localObject).getLong("SESSION_TIMEM", -1L);
                if (l == -1L) {
                    continue;
                }
                localObject = new GregorianCalendar();
                ((GregorianCalendar) localObject).setTimeInMillis(l);
                ((GregorianCalendar) localObject).setFirstDayOfWeek(2);
                GregorianCalendar localGregorianCalendar = new GregorianCalendar();
                l = localGregorianCalendar.getTimeInMillis();
                localGregorianCalendar.setFirstDayOfWeek(2);
                if (((GregorianCalendar) localObject).get(6) != localGregorianCalendar.get(6)) {
                    j = 1;
                }
                i = j;
                if (((GregorianCalendar) localObject).get(3) != localGregorianCalendar.get(3)) {
                    i = j | 0x2;
                }
                j = i;
                if (((GregorianCalendar) localObject).get(2) == localGregorianCalendar.get(2)) {
                    break label209;
                }
                j = i | 0x4;
            } catch (Exception paramContext) {
                long l;
                Log.internal("[InMobi]-4.5.1", "Exception storing session data first time", paramContext);
                continue;
            } finally {
            }
            paramContext.putLong("SESSION_TIMEM", l);
            paramContext.commit();
            d = i;
            return;
            l = new GregorianCalendar().getTimeInMillis();
            int i = 15;
            continue;
            label209:
            i = j;
        }
    }

    public static void storeSessionId(Context paramContext) {
        try {
            a = UUID.randomUUID().toString();
            b = System.currentTimeMillis() / 1000L;
            paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
            paramContext.putString("SESSION_ID", a);
            paramContext.putString("APP_SESSION_ID", a);
            paramContext.putLong("SESSION_TIME", b);
            paramContext.commit();
            return;
        } catch (Exception paramContext) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "Exception putting session id", paramContext);
            }
        } finally {
        }
    }

    public static void updatedFromOldSDK(Context paramContext) {
        try {
            paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
            paramContext.putBoolean("UPDATED_FROM_OLD_SDK", true);
            paramContext.commit();
            return;
        } finally {
            paramContext =finally;
            throw paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/util/SessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */