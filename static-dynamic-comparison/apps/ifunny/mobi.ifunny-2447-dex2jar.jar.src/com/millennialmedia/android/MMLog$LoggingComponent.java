package com.millennialmedia.android;

import android.util.Log;

class MMLog$LoggingComponent {
    private static int a = 4;
    private MMLog.LogHandler b;

    private void a(String paramString) {
        if (this.b != null) {
            this.b.handleLog(paramString);
        }
    }

    private void f(String paramString1, String paramString2) {
        Log.v("MMSDK-" + paramString1, paramString2);
        a(paramString2);
    }

    private void g(String paramString1, String paramString2) {
        Log.d("MMSDK-" + paramString1, paramString2);
        a(paramString2);
    }

    private void h(String paramString1, String paramString2) {
        Log.i("MMSDK-" + paramString1, paramString2);
        a(paramString2);
    }

    private void i(String paramString1, String paramString2) {
        Log.w("MMSDK-" + paramString1, paramString2);
        a(paramString2);
    }

    private void j(String paramString1, String paramString2) {
        Log.e("MMSDK-" + paramString1, paramString2);
        a(paramString2);
    }

    void a(String paramString1, String paramString2) {
        if (a <= 2) {
            f(paramString1, paramString2);
        }
    }

    void a(String paramString1, String paramString2, Throwable paramThrowable) {
        if (a <= 6) {
            j(paramString1, paramString2 + ": " + Log.getStackTraceString(paramThrowable));
        }
    }

    void b(String paramString1, String paramString2) {
        if (a <= 3) {
            g(paramString1, paramString2);
        }
    }

    void c(String paramString1, String paramString2) {
        if (a <= 4) {
            h(paramString1, paramString2);
        }
    }

    void d(String paramString1, String paramString2) {
        if (a <= 5) {
            i(paramString1, paramString2);
        }
    }

    void e(String paramString1, String paramString2) {
        if (a <= 6) {
            j(paramString1, paramString2);
        }
    }

    public int getLogLevel() {
        return a;
    }

    public void setLogLevel(int paramInt) {
        a = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMLog$LoggingComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */