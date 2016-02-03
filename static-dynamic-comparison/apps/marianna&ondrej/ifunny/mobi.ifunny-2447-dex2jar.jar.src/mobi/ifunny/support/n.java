package mobi.ifunny.support;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebView;

class n
        implements Animation.AnimationListener {
    n(SupportFragment paramSupportFragment) {
    }

    public void onAnimationEnd(Animation paramAnimation) {
        this.a.webView.loadUrl("about:blank");
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/support/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */