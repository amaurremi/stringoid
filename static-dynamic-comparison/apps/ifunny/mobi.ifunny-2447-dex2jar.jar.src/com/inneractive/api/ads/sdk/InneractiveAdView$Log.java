package com.inneractive.api.ads.sdk;

import android.util.Log;

public class InneractiveAdView$Log {
    public static int LEVEL = 4;

    public static void d(String paramString1, String paramString2) {
        try {
            if (LEVEL <= 3) {
                Log.d(paramString1, paramString2);
            }
            return;
        } catch (Exception paramString2) {
            Log.d(paramString1, "LOG CATCH! (short)");
        }
    }

    public static void d(String paramString1, Throwable paramThrowable, String paramString2) {
        try {
            if (LEVEL <= 3) {
                Log.d(paramString1, paramString2, paramThrowable);
            }
            return;
        } catch (Exception paramThrowable) {
            Log.d(paramString1, "LOG CATCH! (long)");
        }
    }

    public static void e(String paramString1, String paramString2) {
        try {
            if (LEVEL <= 6) {
                Log.e(paramString1, paramString2);
            }
            return;
        } catch (Exception paramString2) {
            Log.d(paramString1, "LOG CATCH! (short)");
        }
    }

    public static void e(String paramString1, Throwable paramThrowable, String paramString2) {
        try {
            if (LEVEL <= 6) {
                Log.e(paramString1, paramString2, paramThrowable);
            }
            return;
        } catch (Exception paramThrowable) {
            Log.d(paramString1, "LOG CATCH! (long)");
        }
    }

    public static void i(String paramString1, String paramString2) {
        try {
            if (LEVEL <= 4) {
                Log.i(paramString1, paramString2);
            }
            return;
        } catch (Exception paramString2) {
            Log.d(paramString1, "LOG CATCH! (short)");
        }
    }

    public static void i(String paramString1, Throwable paramThrowable, String paramString2) {
        try {
            if (LEVEL <= 4) {
                Log.i(paramString1, paramString2, paramThrowable);
            }
            return;
        } catch (Exception paramThrowable) {
            Log.d(paramString1, "LOG CATCH! (long)");
        }
    }

    public static void v(String paramString1, String paramString2) {
        try {
            if (LEVEL <= 2) {
                Log.v(paramString1, paramString2);
            }
            return;
        } catch (Exception paramString2) {
            Log.d(paramString1, "LOG CATCH! (short)");
        }
    }

    public static void v(String paramString1, Throwable paramThrowable, String paramString2) {
        try {
            if (LEVEL <= 2) {
                Log.v(paramString1, paramString2, paramThrowable);
            }
            return;
        } catch (Exception paramThrowable) {
            Log.d(paramString1, "LOG CATCH! (long)");
        }
    }

    public static void w(String paramString1, String paramString2) {
        try {
            if (LEVEL <= 5) {
                Log.w(paramString1, paramString2);
            }
            return;
        } catch (Exception paramString2) {
            Log.d(paramString1, "LOG CATCH! (short)");
        }
    }

    public static void w(String paramString1, Throwable paramThrowable, String paramString2) {
        try {
            if (LEVEL <= 5) {
                Log.w(paramString1, paramString2, paramThrowable);
            }
            return;
        } catch (Exception paramThrowable) {
            Log.d(paramString1, "LOG CATCH! (long)");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveAdView$Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */