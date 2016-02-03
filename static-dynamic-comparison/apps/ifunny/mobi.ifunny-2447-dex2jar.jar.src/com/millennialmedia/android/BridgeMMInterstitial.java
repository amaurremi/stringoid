package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.lang.ref.WeakReference;
import java.util.Map;

class BridgeMMInterstitial
        extends MMJSObject {
    private static final String a = BridgeMMInterstitial.class.getName();

    private Intent a(String paramString, OverlaySettings paramOverlaySettings) {
        Intent localIntent = new Intent();
        if (paramString != null) {
            localIntent.setData(Uri.parse(paramString));
        }
        localIntent.putExtra("settings", paramOverlaySettings);
        localIntent.putExtra("internalId", paramOverlaySettings.n);
        return localIntent;
    }

    private MMJSResponse a(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("allowOrientationChange");
        if (paramMap != null) {
            AdViewOverlayActivity localAdViewOverlayActivity = d();
            if (localAdViewOverlayActivity != null) {
                localAdViewOverlayActivity.a(Boolean.parseBoolean(paramMap));
                return MMJSResponse.a();
            }
        }
        return null;
    }

    private boolean a(MMJSResponse paramMMJSResponse) {
        if ((paramMMJSResponse.c == 1) && ((paramMMJSResponse.d instanceof String))) {
            paramMMJSResponse = (String) paramMMJSResponse.d;
            return (paramMMJSResponse.contains("portrait")) || (paramMMJSResponse.contains("landscape"));
        }
        return false;
    }

    private MMJSResponse b(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("forceOrientation");
        AdViewOverlayActivity localAdViewOverlayActivity = d();
        if (localAdViewOverlayActivity != null) {
            if (!"none".equals(paramMap)) {
                if ("portrait".equals(paramMap)) {
                    localAdViewOverlayActivity.b();
                    return MMJSResponse.a("portrait");
                }
                if ("landscape".equals(paramMap)) {
                    localAdViewOverlayActivity.c();
                    return MMJSResponse.a("landscape");
                }
            } else if ("none".equals(paramMap)) {
                localAdViewOverlayActivity.a(true);
                return MMJSResponse.a("none");
            }
        }
        return null;
    }

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if ("close".equals(paramString)) {
            localMMJSResponse = close(paramMap);
        }
        do {
            return localMMJSResponse;
            if ("expandToExternalBrowser".equals(paramString)) {
                return expandToExternalBrowser(paramMap);
            }
            if ("expandWithProperties".equals(paramString)) {
                return expandWithProperties(paramMap);
            }
            if ("open".equals(paramString)) {
                return open(paramMap);
            }
            if ("setOrientation".equals(paramString)) {
                return setOrientation(paramMap);
            }
        } while (!"useCustomClose".equals(paramString));
        return useCustomClose(paramMap);
    }

    public MMJSResponse close(Map<String, String> paramMap) {
        paramMap = (MMWebView) this.c.get();
        if (paramMap != null) {
            paramMap.h().b();
            return MMJSResponse.a();
        }
        return null;
    }

    public MMJSResponse expandToExternalBrowser(Map<String, String> paramMap) {
        return open(paramMap);
    }

    public MMJSResponse expandWithProperties(Map<String, String> paramMap) {
        String str1 = (String) paramMap.get("PROPERTY_BANNER_TYPE");
        if ((str1 != null) && (!Boolean.parseBoolean(str1))) {
            return MMJSResponse.b("Cannot expand a non banner ad");
        }
        String str2 = (String) paramMap.get("url");
        String str7 = (String) paramMap.get("transparent");
        String str8 = (String) paramMap.get("useCustomClose");
        String str9 = (String) paramMap.get("transition");
        str1 = (String) paramMap.get("orientation");
        String str3 = (String) paramMap.get("transitionDuration");
        String str4 = (String) paramMap.get("height");
        String str5 = (String) paramMap.get("width");
        String str6 = (String) paramMap.get("modal");
        String str10 = (String) paramMap.get("PROPERTY_EXPANDING");
        String str11 = (String) paramMap.get("allowOrientationChange");
        Context localContext = (Context) this.b.get();
        OverlaySettings localOverlaySettings;
        if (localContext != null) {
            localOverlaySettings = new OverlaySettings();
            if (str2 != null) {
                localOverlaySettings.d = str2;
            }
            if (str10 != null) {
                localOverlaySettings.n = ((int) Float.parseFloat(str10));
            }
            if (str7 != null) {
                localOverlaySettings.b(Boolean.parseBoolean(str7));
            }
            if (str8 != null) {
                localOverlaySettings.a(Boolean.parseBoolean(str8));
            }
            if (str9 != null) {
                localOverlaySettings.a(str9);
            }
            if (str11 != null) {
                localOverlaySettings.h = Boolean.parseBoolean(str11);
            }
            if (str1 != null) {
                break label423;
            }
            str1 = (String) paramMap.get("forceOrientation");
        }
        label423:
        for (; ; ) {
            if (str1 != null) {
                localOverlaySettings.c = str1;
            }
            if (str4 != null) {
                localOverlaySettings.e = ((int) Float.parseFloat(str4));
            }
            if (str5 != null) {
                localOverlaySettings.f = ((int) Float.parseFloat(str5));
            }
            if (str6 != null) {
                localOverlaySettings.g = Boolean.parseBoolean(str6);
            }
            if (str3 != null) {
            }
            try {
                localOverlaySettings.a(Long.parseLong(str3) * 1000L);
                Utils.IntentUtils.a(localContext, a(str2, localOverlaySettings));
                MMSDK.Event.a(localContext, b((String) paramMap.get("PROPERTY_EXPANDING")));
                return MMJSResponse.a();
            } catch (Exception localException) {
                for (; ; ) {
                    MMLog.a(a, "Problem converting transitionDuration", localException);
                }
            }
            return null;
        }
    }

    public MMJSResponse open(Map<String, String> paramMap) {
        Object localObject = (String) paramMap.get("url");
        Context localContext = (Context) this.b.get();
        if ((localObject != null) && (localContext != null)) {
            localObject = new Intent("android.intent.action.VIEW", Uri.parse((String) localObject));
            MMSDK.Event.a(localContext, "browser", b((String) paramMap.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.c(localContext, (Intent) localObject);
            return MMJSResponse.a();
        }
        return null;
    }

    public MMJSResponse setOrientation(Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse2 = b(paramMap);
        MMJSResponse localMMJSResponse1;
        if (localMMJSResponse2 != null) {
            localMMJSResponse1 = localMMJSResponse2;
            if (a(localMMJSResponse2)) {
            }
        } else {
            localMMJSResponse1 = a(paramMap);
        }
        return localMMJSResponse1;
    }

    public MMJSResponse useCustomClose(Map<String, String> paramMap) {
        Object localObject = (MMWebView) this.c.get();
        paramMap = (String) paramMap.get("useCustomClose");
        if ((paramMap != null) && (localObject != null)) {
            localObject = ((MMWebView) localObject).j();
            if (localObject != null) {
                ((AdViewOverlayView) localObject).a(Boolean.parseBoolean(paramMap));
                return MMJSResponse.a();
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */