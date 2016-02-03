package com.millennialmedia.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

final class HttpRedirection
{
  private static final String HEADER_LOCATION = "Location";
  private static final String LOG_URL_FORMAT = "Redirecting to: %s";
  private static final String METHOD_GET = "GET";
  
  static Intent getIntentFromUri(Context paramContext, Uri paramUri, OverlaySettings paramOverlaySettings)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramUri != null)
    {
      localObject1 = localObject2;
      if (paramUri.getScheme() != null)
      {
        if (!paramUri.getScheme().equalsIgnoreCase("market")) {
          break label129;
        }
        MMAdViewSDK.Log.v("Creating Android Market intent.");
        localObject1 = new Intent("android.intent.action.VIEW", paramUri);
        MMAdViewSDK.Event.intentStarted(paramContext, null, "market");
      }
    }
    while (localObject1 != null)
    {
      paramOverlaySettings = "";
      localObject2 = ((Intent)localObject1).getComponent();
      if (localObject2 != null) {
        paramOverlaySettings = ((ComponentName)localObject2).getClassName();
      }
      if ((!paramOverlaySettings.equals("com.millennialmedia.android.MMActivity")) || (!(paramContext instanceof MMActivity))) {
        ((Intent)localObject1).setFlags(603979776);
      }
      MMAdViewSDK.Log.v("%s resolved to Intent: %s", new Object[] { paramUri, localObject1 });
      return (Intent)localObject1;
      label129:
      if (paramUri.getScheme().equalsIgnoreCase("rtsp"))
      {
        MMAdViewSDK.Log.v("Creating streaming video player intent.");
        localObject1 = new Intent(paramContext, MMActivity.class);
        ((Intent)localObject1).setData(paramUri);
        ((Intent)localObject1).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
      }
      else if (paramUri.getScheme().equalsIgnoreCase("tel"))
      {
        MMAdViewSDK.Log.v("Creating telephone intent.");
        localObject1 = new Intent("android.intent.action.DIAL", paramUri);
        MMAdViewSDK.Event.intentStarted(paramContext, null, "tel");
      }
      else if (paramUri.getScheme().equalsIgnoreCase("sms"))
      {
        MMAdViewSDK.Log.v("Creating txt message intent.");
        localObject1 = new Intent("android.intent.action.VIEW");
        localObject2 = paramUri.getSchemeSpecificPart();
        int i = ((String)localObject2).indexOf("?body=");
        paramOverlaySettings = (OverlaySettings)localObject2;
        if (i != -1) {
          paramOverlaySettings = ((String)localObject2).substring(0, i);
        }
        ((Intent)localObject1).putExtra("address", paramOverlaySettings.replace(',', ';'));
        if (i != -1) {
          ((Intent)localObject1).putExtra("sms_body", paramUri.getSchemeSpecificPart().substring(i + 6));
        }
        ((Intent)localObject1).setType("vnd.android-dir/mms-sms");
        MMAdViewSDK.Event.intentStarted(paramContext, null, "sms");
      }
      else if (paramUri.getScheme().equalsIgnoreCase("mailto"))
      {
        localObject1 = new Intent("android.intent.action.VIEW", paramUri);
        MMAdViewSDK.Event.intentStarted(paramContext, null, "email");
      }
      else if (paramUri.getScheme().equalsIgnoreCase("geo"))
      {
        MMAdViewSDK.Log.v("Creating Google Maps intent.");
        localObject1 = new Intent("android.intent.action.VIEW", paramUri);
        MMAdViewSDK.Event.intentStarted(paramContext, null, "geo");
      }
      else if ((paramUri.getScheme().equalsIgnoreCase("http")) && (paramUri.getLastPathSegment() != null) && ((paramUri.getLastPathSegment().endsWith(".mp4")) || (paramUri.getLastPathSegment().endsWith(".3gp"))))
      {
        MMAdViewSDK.Log.v("Creating video player intent.");
        localObject1 = new Intent(paramContext, MMActivity.class);
        ((Intent)localObject1).setData(paramUri);
        ((Intent)localObject1).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
        MMAdViewSDK.Event.intentStarted(paramContext, null, "streamingVideo");
      }
      else if (paramUri.getScheme().equalsIgnoreCase("http"))
      {
        if ((paramOverlaySettings != null) && (paramOverlaySettings.shouldLaunchToOverlay))
        {
          MMAdViewSDK.Log.v("Creating launch overlay intent.");
          localObject1 = new Intent(paramContext, MMActivity.class);
          ((Intent)localObject1).putExtra("settings", paramOverlaySettings);
          ((Intent)localObject1).putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
          ((Intent)localObject1).setData(paramUri);
        }
        else
        {
          MMAdViewSDK.Log.v("Creating launch browser intent.");
          localObject1 = new Intent("android.intent.action.VIEW", paramUri);
          MMAdViewSDK.Event.intentStarted(paramContext, null, "browser");
        }
      }
      else if (paramUri.getScheme().equalsIgnoreCase("https"))
      {
        MMAdViewSDK.Log.v("Creating launch browser intent.");
        localObject1 = new Intent("android.intent.action.VIEW", paramUri);
        MMAdViewSDK.Event.intentStarted(paramContext, null, "browser");
      }
      else if (paramUri.getScheme().equalsIgnoreCase("mmbrowser"))
      {
        String str = paramUri.toString().substring(12);
        localObject1 = localObject2;
        if (str != null)
        {
          paramOverlaySettings = str;
          if (!str.contains("://")) {
            paramOverlaySettings = str.replaceFirst("//", "://");
          }
          MMAdViewSDK.Log.v("Creating launch browser intent.");
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(paramOverlaySettings));
          MMAdViewSDK.Event.intentStarted(paramContext, null, "browser");
        }
      }
      else
      {
        MMAdViewSDK.Log.v("Creating intent for unrecognized URI. %s", new Object[] { paramUri });
        localObject1 = new Intent("android.intent.action.VIEW", paramUri);
      }
    }
    MMAdViewSDK.Log.v("%s", new Object[] { paramUri });
    return (Intent)localObject1;
  }
  
  static final String navigateRedirects(String paramString)
  {
    String str5;
    if (paramString == null)
    {
      str5 = null;
      return str5;
    }
    HttpURLConnection.setFollowRedirects(false);
    String str1;
    String str2;
    String str3;
    String str4;
    for (;;)
    {
      str5 = paramString;
      str1 = paramString;
      str2 = paramString;
      str3 = paramString;
      str4 = paramString;
      try
      {
        if (paramString.startsWith("https")) {
          break;
        }
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        URL localURL = new URL(paramString);
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        Object localObject = (HttpURLConnection)localURL.openConnection();
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        ((HttpURLConnection)localObject).setConnectTimeout(3000);
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        ((HttpURLConnection)localObject).setRequestMethod("GET");
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        ((HttpURLConnection)localObject).connect();
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        int i = ((HttpURLConnection)localObject).getResponseCode();
        str5 = paramString;
        if (i < 300) {
          break;
        }
        str5 = paramString;
        if (i >= 400) {
          break;
        }
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        str5 = ((HttpURLConnection)localObject).getHeaderField("Location");
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        localObject = new URI(str5);
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        if (((URI)localObject).isAbsolute()) {
          break label273;
        }
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        paramString = localURL.toURI().resolve((URI)localObject).toString();
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          return str1;
          if (str5 != null) {
            paramString = str5;
          }
        }
      }
      catch (SocketTimeoutException paramString)
      {
        MMAdViewSDK.Log.d("Connection timeout.");
        return str2;
      }
      catch (URISyntaxException paramString)
      {
        MMAdViewSDK.Log.d("URI Syntax incorrect.");
        return str3;
      }
      catch (IOException paramString) {}
      str1 = paramString;
      str2 = paramString;
      str3 = paramString;
      str4 = paramString;
      MMAdViewSDK.Log.v("Redirecting to: %s", new Object[] { paramString });
    }
    label273:
    return str4;
  }
  
  static void startActivityFromUri(Context paramContext, String paramString1, final OverlaySettings paramOverlaySettings, Listener paramListener, final String paramString2)
  {
    final WeakReference localWeakReference1 = new WeakReference(paramContext);
    final WeakReference localWeakReference2 = new WeakReference(paramListener);
    if ((paramContext == null) || (paramListener == null)) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject3 = HttpRedirection.navigateRedirects(this.val$uri);
        Object localObject1 = Uri.parse((String)localObject3);
        Context localContext = (Context)localWeakReference1.get();
        Object localObject2 = (HttpRedirection.Listener)localWeakReference2.get();
        if ((localObject3 != null) && (localContext != null) && (localObject2 != null)) {
          if ((((Uri)localObject1).getScheme() != null) && (((Uri)localObject1).getScheme().equalsIgnoreCase("mmvideo"))) {
            if (((HttpRedirection.Listener)localObject2).shouldStartActivityForUri((Uri)localObject1))
            {
              localObject1 = ((Uri)localObject1).getHost();
              if (localObject1 != null)
              {
                localObject2 = (VideoAd)AdCache.load(localContext, (String)localObject1);
                if ((localObject2 == null) || (!((VideoAd)localObject2).canShow(localContext, null, false))) {
                  break label150;
                }
                if (paramString2 != null) {
                  HandShake.sharedHandShake(localContext).updateLastVideoViewedTime(localContext, paramString2);
                }
                MMAdViewSDK.Log.v("mmvideo: attempting to play video %s", new Object[] { localObject1 });
                ((VideoAd)localObject2).show(localContext, null);
              }
            }
          }
        }
        label150:
        while (localObject2 == null)
        {
          return;
          MMAdViewSDK.Log.v("mmvideo: Ad %s cannot be shown at this time.", new Object[] { localObject1 });
          return;
          localObject3 = HttpRedirection.getIntentFromUri(localContext, (Uri)localObject1, paramOverlaySettings);
          if ((localObject3 != null) && (((HttpRedirection.Listener)localObject2).shouldStartActivityForUri((Uri)localObject1))) {
            try
            {
              if (!(localContext instanceof Activity)) {
                ((Intent)localObject3).addFlags(268435456);
              }
              localContext.startActivity((Intent)localObject3);
              return;
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              MMAdViewSDK.Log.e("No activity found for %s", new Object[] { localObject1 });
              return;
            }
          }
          MMAdViewSDK.Log.v("Could not start activity for %s", new Object[] { localObject1 });
          ((HttpRedirection.Listener)localObject2).didFailToResolveUri((Uri)localObject1);
          return;
        }
        MMAdViewSDK.Log.v("Could not start activity for %s", new Object[] { localObject1 });
        ((HttpRedirection.Listener)localObject2).didFailToResolveUri(Uri.parse(this.val$uri));
      }
    }).start();
  }
  
  static abstract interface Listener
  {
    public abstract void didFailToResolveUri(Uri paramUri);
    
    public abstract boolean shouldStartActivityForUri(Uri paramUri);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/HttpRedirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */