package mobi.ifunny.social.b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class f
        extends WebViewClient {
    private f(c paramc) {
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        super.onPageFinished(paramWebView, paramString);
        if (paramString.startsWith(a.a)) {
            this.a.a();
            paramWebView = Uri.parse(paramString);
            c.a(this.a).a(paramWebView.getQueryParameter("oauth_verifier"));
        }
        c.b(this.a).setVisibility(0);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
        super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        this.a.a();
        c.a(this.a).a(new mobi.ifunny.i.a(paramString1, paramInt));
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        if (paramString.startsWith(a.a)) {
            CookieSyncManager.getInstance().sync();
            this.a.a();
            paramWebView = Uri.parse(paramString);
            c.a(this.a).a(paramWebView.getQueryParameter("oauth_verifier"));
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */