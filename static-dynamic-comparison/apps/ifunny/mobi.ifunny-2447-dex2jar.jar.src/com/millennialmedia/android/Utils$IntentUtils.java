package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import java.io.File;
import java.lang.ref.WeakReference;

class Utils$IntentUtils {
    static Intent a(HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl) {
        if (paramRedirectionListenerImpl == null) {
            return null;
        }
        Uri localUri = paramRedirectionListenerImpl.c;
        Context localContext = (Context) paramRedirectionListenerImpl.b.get();
        Object localObject;
        if (localContext != null) {
            if (localUri != null) {
                localObject = localUri.getScheme();
                if (localObject != null) {
                    if (((String) localObject).equalsIgnoreCase("market")) {
                        MMLog.a("Utils", "Creating Android Market intent.");
                        localObject = new Intent("android.intent.action.VIEW", localUri);
                        MMSDK.Event.a(localContext, "market", paramRedirectionListenerImpl.e);
                        paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                        if (paramRedirectionListenerImpl == null) {
                            break label757;
                        }
                        MMLog.a("Utils", String.format("%s resolved to Intent: %s", new Object[]{localUri, paramRedirectionListenerImpl}));
                    }
                }
            }
        }
        for (; ; ) {
            return paramRedirectionListenerImpl;
            if (((String) localObject).equalsIgnoreCase("rtsp")) {
                MMLog.a("Utils", "Creating streaming video player intent.");
                paramRedirectionListenerImpl = new Intent(localContext, MMActivity.class);
                paramRedirectionListenerImpl.setData(localUri);
                paramRedirectionListenerImpl.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                break;
            }
            if (((String) localObject).equalsIgnoreCase("tel")) {
                MMLog.a("Utils", "Creating telephone intent.");
                localObject = new Intent("android.intent.action.DIAL", localUri);
                MMSDK.Event.a(localContext, "tel", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                break;
            }
            String str1;
            if (((String) localObject).equalsIgnoreCase("sms")) {
                MMLog.a("Utils", "Creating txt message intent.");
                String str2 = localUri.getSchemeSpecificPart();
                str1 = "";
                int i = str2.indexOf("?body=");
                localObject = str1;
                if (i != -1) {
                    localObject = str1;
                    if (str2.length() > i) {
                        localObject = str2.substring(0, i).replace(',', ';');
                    }
                }
                localObject = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + (String) localObject));
                if (i == -1) {
                    ((Intent) localObject).putExtra("sms_body", str2.substring(i + 6));
                }
                MMSDK.Event.a(localContext, "sms", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                break;
            }
            if (((String) localObject).equalsIgnoreCase("mailto")) {
                localObject = new Intent("android.intent.action.VIEW", localUri);
                MMSDK.Event.a(localContext, "email", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                break;
            }
            if (((String) localObject).equalsIgnoreCase("geo")) {
                MMLog.a("Utils", "Creating Google Maps intent.");
                localObject = new Intent("android.intent.action.VIEW", localUri);
                MMSDK.Event.a(localContext, "geo", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                break;
            }
            if (((String) localObject).equalsIgnoreCase("https")) {
                MMLog.a("Utils", "Creating launch browser intent.");
                localObject = new Intent("android.intent.action.VIEW", localUri);
                MMSDK.Event.a(localContext, "browser", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                break;
            }
            if (((String) localObject).equalsIgnoreCase("mmbrowser")) {
                str1 = localUri.toString().substring(12);
                localObject = str1;
                if (str1 != null) {
                    localObject = str1;
                    if (!str1.contains("://")) {
                        localObject = str1.replaceFirst("//", "://");
                    }
                }
                MMLog.a("Utils", "MMBrowser - Creating launch browser intent.");
                localObject = new Intent("android.intent.action.VIEW", Uri.parse((String) localObject));
                MMSDK.Event.a(localContext, "browser", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                break;
            }
            if (((String) localObject).equalsIgnoreCase("http")) {
                if ((localUri.getLastPathSegment() != null) && ((localUri.getLastPathSegment().endsWith(".mp4")) || (localUri.getLastPathSegment().endsWith(".3gp")))) {
                    MMLog.a("Utils", "Creating video player intent.");
                    localObject = new Intent(localContext, MMActivity.class);
                    ((Intent) localObject).setData(localUri);
                    ((Intent) localObject).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                    MMSDK.Event.a(localContext, "streamingVideo", paramRedirectionListenerImpl.e);
                    paramRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) localObject;
                    break;
                }
                if (paramRedirectionListenerImpl.canOpenOverlay()) {
                    MMLog.a("Utils", "Creating launch overlay intent.");
                    paramRedirectionListenerImpl = new Intent(localContext, MMActivity.class);
                    paramRedirectionListenerImpl.putExtra("class", AdViewOverlayActivity.class.getCanonicalName());
                    paramRedirectionListenerImpl.setData(localUri);
                    return paramRedirectionListenerImpl;
                }
                MMLog.a("Utils", "Creating launch browser intent.");
                MMSDK.Event.a(localContext, "browser", paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl = new Intent("android.intent.action.VIEW", localUri);
                break;
            }
            MMLog.a("Utils", String.format("Creating intent for unrecognized URI. %s", new Object[]{localUri}));
            paramRedirectionListenerImpl = new Intent("android.intent.action.VIEW", localUri);
            break;
            label757:
            MMLog.a("Utils", String.format("%s", new Object[]{localUri}));
            continue;
            paramRedirectionListenerImpl = null;
            break;
            paramRedirectionListenerImpl = null;
        }
    }

    static void a(Context paramContext, Intent paramIntent) {
        paramIntent.setClass(paramContext, MMActivity.class);
        paramIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
        c(paramContext, paramIntent);
    }

    static void a(Context paramContext, Uri paramUri) {
        Intent localIntent = new Intent(paramContext, MMActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
        c(paramContext, localIntent);
    }

    static void a(Context paramContext, File paramFile) {
        a(paramContext, Uri.fromFile(paramFile));
    }

    static void a(Context paramContext, File paramFile, String paramString) {
        Intent localIntent = new Intent(paramContext, MMActivity.class);
        localIntent.setData(Uri.fromFile(paramFile));
        localIntent.putExtra("type", paramString);
        localIntent.putExtra("class", "com.millennialmedia.android.BridgeMMMedia$PickerActivity");
        c(paramContext, localIntent);
    }

    static void a(Context paramContext, String paramString) {
        a(paramContext, Uri.parse(paramString));
    }

    static void b(Context paramContext, Intent paramIntent) {
        paramIntent.setClass(paramContext, MMActivity.class);
        paramIntent.putExtra("class", "com.millennialmedia.android.CachedVideoPlayerActivity");
        c(paramContext, paramIntent);
    }

    static void c(Context paramContext, Intent paramIntent) {
        if (!(paramContext instanceof Activity)) {
            paramIntent.addFlags(268435456);
        }
        d(paramContext, paramIntent);
        paramContext.startActivity(paramIntent);
    }

    private static void d(Context paramContext, Intent paramIntent) {
        paramContext = paramIntent.getData();
        if (paramContext != null) {
            paramContext = paramContext.getLastPathSegment();
            if ((TextUtils.isEmpty(paramIntent.getStringExtra("class"))) && (!TextUtils.isEmpty(paramContext)) && ((paramContext.endsWith(".mp4")) || (paramContext.endsWith(".3gp")) || (paramContext.endsWith(".mkv")) || (paramContext.endsWith("content.once")))) {
                paramIntent.setDataAndType(paramIntent.getData(), "video/*");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/Utils$IntentUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */