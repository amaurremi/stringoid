package com.millennialmedia.android;

final class HttpGetRequest$1
        implements Runnable {
    HttpGetRequest$1(String[] paramArrayOfString) {
    }

    public void run() {
        String[] arrayOfString = this.a;
        int j = arrayOfString.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                String str = arrayOfString[i];
                MMLog.a("HttpGetRequest", String.format("Logging event to: %s", new Object[]{str}));
                try {
                    new HttpGetRequest().a(str);
                    i += 1;
                } catch (Exception localException) {
                    for (; ; ) {
                        MMLog.a("HttpGetRequest", "Logging request failed.", localException);
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpGetRequest$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */