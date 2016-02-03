package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class AdWebViewClient
        extends WebViewClient {
    public static final String AMAZON_MOBILE = "amazonmobile";
    public static final String GEO = "geo";
    public static final String GOOGLE_STREETVIEW = "google.streetview";
    private static final String LOG_TAG = AdWebViewClient.class.getSimpleName();
    public static final String MAILTO = "mailto";
    public static final String MOPUB = "mopub";
    public static final String MRAID = "mraid";
    public static final String SMS = "sms";
    public static final String TELEPHONE = "tel";
    public static final String VOICEMAIL = "voicemail";
    protected static final HashSet<String> intentSchemes = new HashSet();
    protected static Set<String> redirectHosts;
    private final AdView adView;
    private final Context context;
    private final HashMap<String, UrlExecutor> urlExecutors;

    static {
        intentSchemes.add("tel");
        intentSchemes.add("voicemail");
        intentSchemes.add("sms");
        intentSchemes.add("mailto");
        intentSchemes.add("geo");
        intentSchemes.add("google.streetview");
        redirectHosts = new HashSet();
        redirectHosts.add("aax-us-east.amazon-adsystem.com");
        redirectHosts.add("aax-us-east.amazon-adsystem.com");
        redirectHosts.add("aax-beta.integ.amazon.com");
        redirectHosts.add("pda-bes.amazon.com");
        redirectHosts.add("d16g-cornerstone-bes.integ.amazon.com");
    }

    public AdWebViewClient(AdView paramAdView, Context paramContext) {
        this.context = paramContext;
        this.adView = paramAdView;
        this.urlExecutors = new HashMap();
        setupUrlExecutors();
    }

    private static boolean isHoneycombVersion() {
        return (Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT <= 13);
    }

    private void setupUrlExecutors() {
        this.urlExecutors.put("mopub", new MopubExecutor());
        this.urlExecutors.put("amazonmobile", new AmazonMobileExecutor(this.adView, this.context));
        IntentExecutor localIntentExecutor = new IntentExecutor();
        Iterator localIterator = intentSchemes.iterator();
        while (localIterator.hasNext()) {
            putUrlExecutor((String) localIterator.next(), localIntentExecutor);
        }
    }

    protected String getScheme(String paramString) {
        return Uri.parse(paramString).getScheme();
    }

    protected boolean interpretScheme(String paramString1, String paramString2) {
        boolean bool = false;
        if (paramString2 != null) {
            if (this.urlExecutors.containsKey(paramString2)) {
                bool = ((UrlExecutor) this.urlExecutors.get(paramString2)).execute(paramString1);
            }
        } else {
            return bool;
        }
        Log.d(LOG_TAG, "Scheme %s unrecognized. Launching external browser.", new Object[]{paramString2});
        return this.adView.launchExternalBrowserForLink(paramString1);
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        Log.d(LOG_TAG, "Loaded resource: %s", new Object[]{paramString});
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        if (this.adView == null) {
            Log.w(LOG_TAG, "Call to onPageFinished() ignored because view is null.");
            return;
        }
        this.adView.onPageFinished();
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        Log.e(LOG_TAG, "Error: %s", new Object[]{paramString1});
        super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public void putUrlExecutor(String paramString, UrlExecutor paramUrlExecutor) {
        this.urlExecutors.put(paramString, paramUrlExecutor);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        boolean bool1;
        if (this.adView == null) {
            bool1 = false;
        }
        do {
            return bool1;
            if (!this.adView.isAdViewRenderable()) {
                return true;
            }
            paramWebView = Uri.parse(paramString);
            boolean bool2 = true;
            bool1 = bool2;
            if (redirectHosts.contains(paramWebView.getHost())) {
                bool1 = bool2;
                if (!isHoneycombVersion()) {
                    bool1 = false;
                }
            }
        } while (!interpretScheme(paramString, getScheme(paramString)));
        return true;
    }

    static class AmazonMobileExecutor
            implements AdWebViewClient.UrlExecutor {
        private final AdView adView;
        private final Context context;

        AmazonMobileExecutor(AdView paramAdView, Context paramContext) {
            this.adView = paramAdView;
            this.context = paramContext;
        }

        public boolean execute(String paramString) {
            specialUrlClicked(paramString);
            return true;
        }

        protected void handleApplicationDefinedSpecialURL(String paramString) {
            Log.i(AdWebViewClient.LOG_TAG, "Special url clicked, but was not handled by SDK. Url: %s", new Object[]{paramString});
        }

        protected boolean launchExternalActivity(String paramString) {
            Intent localIntent = new Intent();
            if (paramString.startsWith("intent:")) {
            }
            for (; ; ) {
                try {
                    paramString = Intent.parseUri(paramString, 1);
                    localIntent.setData(Uri.parse(paramString));
                } catch (URISyntaxException paramString) {
                    try {
                        paramString.setAction("android.intent.action.VIEW");
                        paramString.addFlags(268435456);
                        this.context.startActivity(paramString);
                        return true;
                    } catch (ActivityNotFoundException paramString) {
                    }
                    paramString = paramString;
                    return false;
                }
                paramString = localIntent;
            }
            return false;
        }

        public void specialUrlClicked(String paramString) {
            if ((this.adView == null) || (!this.adView.isAdViewRenderable())) {
                Log.d(AdWebViewClient.LOG_TAG, "AdView is Null");
            }
            String str;
            do {
                do {
                    Uri localUri;
                    do {
                        do {
                            do {
                                return;
                                Log.d(AdWebViewClient.LOG_TAG, "Executing AmazonMobile Intent");
                                localUri = Uri.parse(paramString);
                                try {
                                    Object localObject = localUri.getQueryParameters("intent");
                                    if ((localObject != null) && (((List) localObject).size() > 0)) {
                                        localObject = ((List) localObject).iterator();
                                        while (((Iterator) localObject).hasNext()) {
                                            if (launchExternalActivity((String) ((Iterator) localObject).next())) {
                                                return;
                                            }
                                        }
                                    }
                                } catch (UnsupportedOperationException localUnsupportedOperationException) {
                                    for (; ; ) {
                                        str = null;
                                    }
                                    handleApplicationDefinedSpecialURL(paramString);
                                    return;
                                }
                                if (!AmazonDeviceLauncher.isWindowshopPresent(this.context)) {
                                    break;
                                }
                            } while (!localUri.getHost().equals("shopping"));
                            str = localUri.getQueryParameter("app-action");
                        } while ((str == null) || (str.length() == 0));
                        if (!str.equals("detail")) {
                            break;
                        }
                        paramString = localUri.getQueryParameter("asin");
                    } while ((paramString == null) || (paramString.length() == 0));
                    AmazonDeviceLauncher.launchWindowshopDetailPage(this.context, paramString);
                    return;
                    if (!str.equals("search")) {
                        break;
                    }
                    paramString = localUri.getQueryParameter("keyword");
                } while ((paramString == null) || (paramString.length() == 0));
                AmazonDeviceLauncher.launchWindowshopSearchPage(this.context, paramString);
                return;
            } while (!str.equals("webview"));
            handleApplicationDefinedSpecialURL(paramString);
            return;
            handleApplicationDefinedSpecialURL(paramString);
        }
    }

    class DefaultExecutor
            implements AdWebViewClient.UrlExecutor {
        DefaultExecutor() {
        }

        public boolean execute(String paramString) {
            AdWebViewClient.this.adView.launchExternalBrowserForLink(paramString);
            return true;
        }
    }

    class IntentExecutor
            implements AdWebViewClient.UrlExecutor {
        IntentExecutor() {
        }

        public boolean execute(String paramString) {
            Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            localIntent.addFlags(268435456);
            try {
                AdWebViewClient.this.context.startActivity(localIntent);
                return true;
            } catch (ActivityNotFoundException localActivityNotFoundException) {
                Log.w(AdWebViewClient.LOG_TAG, "Could not handle intent with URI: %s", new Object[]{paramString});
            }
            return true;
        }
    }

    class MopubExecutor
            implements AdWebViewClient.UrlExecutor {
        MopubExecutor() {
        }

        public boolean execute(String paramString) {
            return true;
        }
    }

    static abstract interface UrlExecutor {
        public abstract boolean execute(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */