package mobi.ifunny.social.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class c
        extends g {
    private String j;
    private int k;
    private e l;
    private WebView m;
    private FrameLayout n;

    public static c a(String paramString, int paramInt) {
        c localc = new c();
        Bundle localBundle = new Bundle();
        localBundle.putString("ARG_URL", paramString);
        localBundle.putInt("ARG_THEME", paramInt);
        localc.setArguments(localBundle);
        return localc;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(int paramInt) {
        FrameLayout localFrameLayout = new FrameLayout(getActivity());
        this.m = new WebView(getActivity());
        this.m.setVerticalScrollBarEnabled(false);
        this.m.setHorizontalScrollBarEnabled(false);
        WebSettings localWebSettings = this.m.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setLoadsImagesAutomatically(true);
        localWebSettings.setSupportZoom(false);
        this.m.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.m.setWebViewClient(new f(this, null));
        this.m.loadUrl(this.j);
        this.m.setVisibility(4);
        localFrameLayout.setPadding(paramInt, paramInt, paramInt, paramInt);
        localFrameLayout.addView(this.m, new FrameLayout.LayoutParams(-1, -1, 17));
        this.n.addView(localFrameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new Dialog(getActivity(), this.k);
        paramBundle.getWindow().addFlags(67840);
        paramBundle.requestWindowFeature(1);
        paramBundle.getWindow().setGravity(17);
        this.n = new FrameLayout(getActivity());
        this.n.setBackgroundColor(0);
        a(getResources().getDimensionPixelSize(2131427450));
        paramBundle.addContentView(this.n, new ViewGroup.LayoutParams(-1, -1));
        this.n.setBackgroundColor(0);
        return paramBundle;
    }

    public void a(e parame) {
        this.l = parame;
    }

    public e d() {
        return this.l;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        super.onCancel(paramDialogInterface);
        if (d() != null) {
            d().a();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.j = paramBundle.getString("ARG_URL");
        this.k = paramBundle.getInt("ARG_THEME");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */