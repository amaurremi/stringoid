package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class Utils
{
  static class HttpUtils
  {
    static void executeUrl(String paramString)
    {
      Utils.ThreadUtils.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            new DefaultHttpClient().execute(new HttpGet(this.val$url));
            MMSDK.Log.d("Executed Url :\"" + this.val$url + "\"");
            return;
          }
          catch (IOException localIOException)
          {
            MMSDK.Log.e(localIOException);
          }
        }
      });
    }
  }
  
  static class IntentUtils
  {
    private static void fixDataAndTypeForVideo(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getData();
      if (paramContext != null)
      {
        paramContext = paramContext.getLastPathSegment();
        if ((TextUtils.isEmpty(paramIntent.getStringExtra("class"))) && (!TextUtils.isEmpty(paramContext)) && ((paramContext.endsWith(".mp4")) || (paramContext.endsWith(".3gp")) || (paramContext.endsWith(".mkv")) || (paramContext.endsWith("content.once")))) {
          paramIntent.setDataAndType(paramIntent.getData(), "video/*");
        }
      }
    }
    
    static Intent getIntentForUri(HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl)
    {
      if (paramRedirectionListenerImpl == null) {}
      Object localObject2;
      Uri localUri;
      Context localContext;
      do
      {
        return null;
        localObject2 = null;
        localUri = paramRedirectionListenerImpl.destinationUri;
        localContext = (Context)paramRedirectionListenerImpl.weakContext.get();
      } while (localContext == null);
      Object localObject1 = localObject2;
      String str;
      if (localUri != null)
      {
        str = localUri.getScheme();
        localObject1 = localObject2;
        if (str != null)
        {
          if (!str.equalsIgnoreCase("market")) {
            break label114;
          }
          MMSDK.Log.v("Creating Android Market intent.");
          localObject1 = new Intent("android.intent.action.VIEW", localUri);
          MMSDK.Event.intentStarted(localContext, "market", paramRedirectionListenerImpl.creatorAdImplInternalId);
        }
      }
      while (localObject1 != null)
      {
        MMSDK.Log.v("%s resolved to Intent: %s", new Object[] { localUri, localObject1 });
        return (Intent)localObject1;
        label114:
        if (str.equalsIgnoreCase("rtsp"))
        {
          MMSDK.Log.v("Creating streaming video player intent.");
          localObject1 = new Intent(localContext, MMActivity.class);
          ((Intent)localObject1).setData(localUri);
          ((Intent)localObject1).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
        }
        else if (str.equalsIgnoreCase("tel"))
        {
          MMSDK.Log.v("Creating telephone intent.");
          localObject1 = new Intent("android.intent.action.DIAL", localUri);
          MMSDK.Event.intentStarted(localContext, "tel", paramRedirectionListenerImpl.creatorAdImplInternalId);
        }
        else if (str.equalsIgnoreCase("sms"))
        {
          MMSDK.Log.v("Creating txt message intent.");
          localObject2 = new Intent("android.intent.action.VIEW");
          str = localUri.getSchemeSpecificPart();
          int i = str.indexOf("?body=");
          localObject1 = str;
          if (i != -1) {
            localObject1 = str.substring(0, i);
          }
          ((Intent)localObject2).putExtra("address", ((String)localObject1).replace(',', ';'));
          if (i != -1) {
            ((Intent)localObject2).putExtra("sms_body", localUri.getSchemeSpecificPart().substring(i + 6));
          }
          ((Intent)localObject2).setType("vnd.android-dir/mms-sms");
          MMSDK.Event.intentStarted(localContext, "sms", paramRedirectionListenerImpl.creatorAdImplInternalId);
          localObject1 = localObject2;
        }
        else if (str.equalsIgnoreCase("mailto"))
        {
          localObject1 = new Intent("android.intent.action.VIEW", localUri);
          MMSDK.Event.intentStarted(localContext, "email", paramRedirectionListenerImpl.creatorAdImplInternalId);
        }
        else if (str.equalsIgnoreCase("geo"))
        {
          MMSDK.Log.v("Creating Google Maps intent.");
          localObject1 = new Intent("android.intent.action.VIEW", localUri);
          MMSDK.Event.intentStarted(localContext, "geo", paramRedirectionListenerImpl.creatorAdImplInternalId);
        }
        else if (str.equalsIgnoreCase("https"))
        {
          MMSDK.Log.v("Creating launch browser intent.");
          localObject1 = new Intent("android.intent.action.VIEW", localUri);
          MMSDK.Event.intentStarted(localContext, "browser", paramRedirectionListenerImpl.creatorAdImplInternalId);
        }
        else if (str.equalsIgnoreCase("mmbrowser"))
        {
          localObject2 = localUri.toString().substring(12);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((String)localObject2).contains("://")) {
              localObject1 = ((String)localObject2).replaceFirst("//", "://");
            }
          }
          MMSDK.Log.v("MMBrowser - Creating launch browser intent.");
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
          MMSDK.Event.intentStarted(localContext, "browser", paramRedirectionListenerImpl.creatorAdImplInternalId);
        }
        else if (str.equalsIgnoreCase("http"))
        {
          if ((localUri.getLastPathSegment() != null) && ((localUri.getLastPathSegment().endsWith(".mp4")) || (localUri.getLastPathSegment().endsWith(".3gp"))))
          {
            MMSDK.Log.v("Creating video player intent.");
            localObject1 = new Intent(localContext, MMActivity.class);
            ((Intent)localObject1).setData(localUri);
            ((Intent)localObject1).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
            MMSDK.Event.intentStarted(localContext, "streamingVideo", paramRedirectionListenerImpl.creatorAdImplInternalId);
          }
          else
          {
            if (paramRedirectionListenerImpl.canOpenOverlay())
            {
              MMSDK.Log.v("Creating launch overlay intent.");
              paramRedirectionListenerImpl = new Intent(localContext, MMActivity.class);
              paramRedirectionListenerImpl.putExtra("class", AdViewOverlayActivity.class.getCanonicalName());
              paramRedirectionListenerImpl.setData(localUri);
              return paramRedirectionListenerImpl;
            }
            MMSDK.Log.v("Creating launch browser intent.");
            MMSDK.Event.intentStarted(localContext, "browser", paramRedirectionListenerImpl.creatorAdImplInternalId);
            localObject1 = new Intent("android.intent.action.VIEW", localUri);
          }
        }
        else
        {
          MMSDK.Log.v("Creating intent for unrecognized URI. %s", new Object[] { localUri });
          localObject1 = new Intent("android.intent.action.VIEW", localUri);
        }
      }
      MMSDK.Log.v("%s", new Object[] { localUri });
      return (Intent)localObject1;
    }
    
    static void startActionView(Context paramContext, String paramString)
    {
      startActivity(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    }
    
    static void startActivity(Context paramContext, Intent paramIntent)
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      fixDataAndTypeForVideo(paramContext, paramIntent);
      paramContext.startActivity(paramIntent);
    }
    
    static void startAdViewOverlayActivity(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, MMActivity.class);
      localIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      startActivity(paramContext, localIntent);
    }
    
    static void startAdViewOverlayActivity(Context paramContext, Intent paramIntent)
    {
      paramIntent.setClass(paramContext, MMActivity.class);
      paramIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      startActivity(paramContext, paramIntent);
    }
    
    static void startAdViewOverlayActivityWithData(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, MMActivity.class);
      localIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      localIntent.setData(Uri.parse(paramString));
      startActivity(paramContext, localIntent);
    }
    
    static void startCachedVideoPlayerActivity(Context paramContext, Intent paramIntent)
    {
      paramIntent.setClass(paramContext, MMActivity.class);
      paramIntent.putExtra("class", "com.millennialmedia.android.CachedVideoPlayerActivity");
      startActivity(paramContext, paramIntent);
    }
    
    static void startPickerActivity(Context paramContext, File paramFile, String paramString)
    {
      Intent localIntent = new Intent(paramContext, MMActivity.class);
      localIntent.setData(Uri.fromFile(paramFile));
      localIntent.putExtra("type", paramString);
      localIntent.putExtra("class", "com.millennialmedia.android.BridgeMMMedia$PickerActivity");
      startActivity(paramContext, localIntent);
    }
    
    static void startVideoPlayerActivityWithData(Context paramContext, Uri paramUri)
    {
      Intent localIntent = new Intent(paramContext, MMActivity.class);
      localIntent.setData(paramUri);
      localIntent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
      startActivity(paramContext, localIntent);
    }
    
    static void startVideoPlayerActivityWithData(Context paramContext, File paramFile)
    {
      startVideoPlayerActivityWithData(paramContext, Uri.fromFile(paramFile));
    }
    
    static void startVideoPlayerActivityWithData(Context paramContext, String paramString)
    {
      startVideoPlayerActivityWithData(paramContext, Uri.parse(paramString));
    }
  }
  
  static class ThreadUtils
  {
    private static final ExecutorService cachedThreadExecutor = ;
    
    static void execute(Runnable paramRunnable)
    {
      cachedThreadExecutor.execute(paramRunnable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */