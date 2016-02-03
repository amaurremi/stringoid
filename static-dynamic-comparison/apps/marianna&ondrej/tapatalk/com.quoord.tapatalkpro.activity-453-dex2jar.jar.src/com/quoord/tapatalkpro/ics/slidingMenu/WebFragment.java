package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebFragment
        extends QuoordFragment {
    private String mUrl = null;
    public WebView mWebView;
    private String title;

    public static WebFragment newInstance(String paramString1, String paramString2) {
        WebFragment localWebFragment = new WebFragment();
        localWebFragment.mUrl = paramString1;
        localWebFragment.title = paramString2;
        return localWebFragment;
    }

    public void loadUrl(String paramString) {
        this.mWebView.loadUrl(paramString);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = getActivity().getActionBar();
        paramBundle.setTitle(this.title);
        paramBundle.setDisplayShowHomeEnabled(true);
        paramBundle.setDisplayShowTitleEnabled(true);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = (ScrollView) ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(2130903432, null);
        this.mWebView = ((WebView) paramLayoutInflater.findViewById(2131231731));
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                paramAnonymousString = paramAnonymousString.replace("mailto:", "");
                if (Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$").matcher(paramAnonymousString).matches()) {
                    paramAnonymousWebView = new Intent("android.intent.action.SEND");
                    paramAnonymousWebView.setType("plain/text");
                    paramAnonymousWebView.putExtra("android.intent.extra.EMAIL", new String[]{paramAnonymousString});
                    paramAnonymousWebView.putExtra("android.intent.extra.SUBJECT", "");
                    paramAnonymousWebView.putExtra("android.intent.extra.TEXT", "");
                    WebFragment.this.startActivity(Intent.createChooser(paramAnonymousWebView, ""));
                    return true;
                }
                paramAnonymousWebView.loadUrl(paramAnonymousString);
                return false;
            }
        });
        this.mWebView.loadUrl(this.mUrl);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        return paramLayoutInflater;
    }

    public void setQuoordBackGround(Context paramContext) {
        if (SettingsFragment.isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165281);
            return;
        }
        getView().setBackgroundResource(2131165282);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/WebFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */