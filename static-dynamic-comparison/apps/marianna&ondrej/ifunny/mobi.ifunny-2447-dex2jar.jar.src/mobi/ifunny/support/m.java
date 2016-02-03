package mobi.ifunny.support;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

class m
        extends WebViewClient {
    m(SupportFragment paramSupportFragment, Activity paramActivity) {
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        this.b.d();
        super.onPageFinished(paramWebView, paramString);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        this.b.d();
        Toast.makeText(this.a, "An error occurred: " + paramString1, 0).show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/support/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */