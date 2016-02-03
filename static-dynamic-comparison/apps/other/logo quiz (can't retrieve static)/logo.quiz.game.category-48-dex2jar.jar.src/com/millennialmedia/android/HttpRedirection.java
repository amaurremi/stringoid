package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONObject;

final class HttpRedirection
{
  private static final String HEADER_LOCATION = "Location";
  private static final String HTTPS = "https";
  private static final String LOG_URL_FORMAT = "Redirecting to: %s";
  private static final String METHOD_GET = "GET";
  
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
        ((HttpURLConnection)localObject).setConnectTimeout(10000);
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
        MMSDK.Log.d("Connection timeout.");
        return str2;
      }
      catch (URISyntaxException paramString)
      {
        MMSDK.Log.d("URI Syntax incorrect.");
        return str3;
      }
      catch (IOException paramString) {}
      str1 = paramString;
      str2 = paramString;
      str3 = paramString;
      str4 = paramString;
      MMSDK.Log.v("Redirecting to: %s", new Object[] { paramString });
    }
    label273:
    return str4;
  }
  
  static void startActivityFromUri(RedirectionListenerImpl paramRedirectionListenerImpl)
  {
    if ((paramRedirectionListenerImpl == null) || (paramRedirectionListenerImpl.url == null) || (paramRedirectionListenerImpl.weakContext == null)) {
      return;
    }
    Utils.ThreadUtils.execute(new Runnable()
    {
      private void handleDestinationUri(HttpRedirection.RedirectionListenerImpl paramAnonymousRedirectionListenerImpl)
      {
        Object localObject2 = null;
        Context localContext = (Context)paramAnonymousRedirectionListenerImpl.weakContext.get();
        Object localObject1;
        if (localContext != null)
        {
          String str = paramAnonymousRedirectionListenerImpl.destinationUri.getScheme();
          localObject1 = localObject2;
          if (str != null)
          {
            if (str.equalsIgnoreCase("mmvideo")) {
              break label139;
            }
            localObject1 = Utils.IntentUtils.getIntentForUri(paramAnonymousRedirectionListenerImpl);
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousRedirectionListenerImpl.getOverlaySettings();
            if ((localObject1 != null) && (localObject2 != null))
            {
              if (paramAnonymousRedirectionListenerImpl.orientation != null) {
                ((OverlaySettings)localObject2).orientation = paramAnonymousRedirectionListenerImpl.orientation;
              }
              ((Intent)localObject1).putExtra("settings", (Parcelable)localObject2);
            }
            localObject2 = ((Intent)localObject1).getStringExtra("class");
            if ((localObject2 != null) && (((String)localObject2).equals(AdViewOverlayActivity.class.getCanonicalName()))) {}
          }
          try
          {
            if (paramAnonymousRedirectionListenerImpl.isActivityStartable(paramAnonymousRedirectionListenerImpl.destinationUri))
            {
              Utils.IntentUtils.startActivity(localContext, (Intent)localObject1);
              paramAnonymousRedirectionListenerImpl.startingActivity(paramAnonymousRedirectionListenerImpl.destinationUri);
            }
            return;
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            label139:
            MMSDK.Log.e("No activity found for %s", new Object[] { paramAnonymousRedirectionListenerImpl.destinationUri });
          }
          localObject1 = localObject2;
          if (!paramAnonymousRedirectionListenerImpl.isHandlingMMVideo(paramAnonymousRedirectionListenerImpl.destinationUri))
          {
            VideoAd.playAd(localContext, paramAnonymousRedirectionListenerImpl.destinationUri.getHost(), paramAnonymousRedirectionListenerImpl);
            localObject1 = localObject2;
          }
        }
      }
      
      public void run()
      {
        HttpRedirection.RedirectionListenerImpl localRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl)this.val$listenerReference.get();
        String str;
        if (localRedirectionListenerImpl != null)
        {
          str = HttpRedirection.navigateRedirects(localRedirectionListenerImpl.url);
          if (str != null)
          {
            localRedirectionListenerImpl.destinationUri = Uri.parse(str);
            if (localRedirectionListenerImpl.destinationUri == null) {
              break label48;
            }
            handleDestinationUri(localRedirectionListenerImpl);
          }
        }
        return;
        label48:
        MMSDK.Log.v("Could not start activity for %s", new Object[] { str });
      }
    });
  }
  
  private static abstract interface Listener
  {
    public abstract boolean canOpenOverlay();
    
    public abstract OverlaySettings getOverlaySettings();
    
    public abstract boolean isActivityStartable(Uri paramUri);
    
    public abstract boolean isExpandingToUrl();
    
    public abstract boolean isHandlingMMVideo(Uri paramUri);
    
    public abstract void startingActivity(Uri paramUri);
    
    public abstract void startingVideo();
    
    public abstract void updateLastVideoViewedTime();
  }
  
  static class RedirectionListenerImpl
    implements HttpRedirection.Listener
  {
    long creatorAdImplInternalId;
    Uri destinationUri;
    String orientation;
    String url;
    WeakReference<Context> weakContext;
    
    public boolean canOpenOverlay()
    {
      return false;
    }
    
    public JSONObject getAdProperties()
    {
      return null;
    }
    
    public OverlaySettings getOverlaySettings()
    {
      return null;
    }
    
    public boolean isActivityStartable(Uri paramUri)
    {
      return true;
    }
    
    public boolean isExpandingToUrl()
    {
      return false;
    }
    
    public boolean isHandlingMMVideo(Uri paramUri)
    {
      return false;
    }
    
    public void startingActivity(Uri paramUri)
    {
      MMSDK.Log.d("Starting activity for %s", new Object[] { paramUri });
    }
    
    public void startingVideo() {}
    
    public void updateLastVideoViewedTime() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/HttpRedirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */