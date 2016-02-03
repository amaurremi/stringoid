package com.millennialmedia.android;

class MMCommand$1
        implements Runnable {
    MMCommand$1(MMCommand paramMMCommand, MMWebView paramMMWebView, MMJSResponse paramMMJSResponse) {
    }

    public void run() {
        if (MMCommand.a(this.c).equals("expandWithProperties")) {
            this.a.b = true;
        }
        String str = String.format("javascript:%s(%s);", new Object[]{MMCommand.b(this.c), this.b.c()});
        this.a.loadUrl(str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMCommand$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */