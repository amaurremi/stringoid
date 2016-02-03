package com.inmobi.re.container;

class IMWebView$b
        implements Runnable {
    IMWebView$b(IMWebView paramIMWebView, String paramString1, String paramString2) {
    }

    public void run() {
        if (this.a != null) {
            this.c.injectJavaScript("window.imraid.broadcastEvent('" + this.b + "','" + this.a + "');");
            return;
        }
        this.c.injectJavaScript("window.imraid.broadcastEvent('" + this.b + "');");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */