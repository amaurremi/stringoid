package com.zestadz.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ZestADZAdView
  extends RelativeLayout
{
  private static Timer t;
  private String adClickUrl = null;
  private String adImage = null;
  private Handler handler;
  public ZestADZListener listener;
  private boolean mAdVisibility;
  private Thread mt;
  private String userAgent;
  public final WeakReference<Activity> zestContext;
  
  public ZestADZAdView(Activity paramActivity)
  {
    super(paramActivity);
    this.zestContext = new WeakReference(paramActivity);
  }
  
  public ZestADZAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zestContext = new WeakReference((Activity)paramContext);
  }
  
  public ZestADZAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zestContext = new WeakReference((Activity)paramContext);
    setAdVisibility(true);
    if ((!CheckAdVisibility()) && (t != null)) {
      t.cancel();
    }
  }
  
  private String convertStreamToString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        str = localBufferedReader.readLine();
        if (str != null) {}
      }
      catch (IOException localIOException)
      {
        String str;
        Log.e("ZestADZAdView SDK", "Caught IOException in convertStreamToString()", localIOException);
        try
        {
          paramInputStream.close();
          return null;
        }
        catch (IOException paramInputStream)
        {
          Log.e("ZestADZAdView SDK", "Caught IOException in convertStreamToString()", paramInputStream);
          return null;
        }
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw ((Throwable)localObject);
        }
        catch (IOException paramInputStream)
        {
          Log.e("ZestADZAdView SDK", "Caught IOException in convertStreamToString()", paramInputStream);
          return null;
        }
      }
      try
      {
        paramInputStream.close();
        return localStringBuilder.toString();
      }
      catch (IOException paramInputStream)
      {
        Log.e("ZestADZAdView SDK", "Caught IOException in convertStreamToString()", paramInputStream);
      }
      localStringBuilder.append(str + "\n");
    }
    return null;
  }
  
  private void processAdResponse(String paramString)
  {
    if ((paramString != "") && (paramString != null)) {}
    try
    {
      if (paramString.equals(""))
      {
        this.adImage = "NA";
        return;
      }
      paramString = TextUtils.split(paramString, "~");
      if (paramString.length <= 2)
      {
        this.adImage = "NA";
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.v("ZestADZAdView SDK", "Caught Exception in adResponse", paramString);
      this.adImage = "NA";
      return;
    }
    if ((paramString[1].equals("1")) || (paramString[1].equals("3")))
    {
      this.adImage = paramString[2];
      this.adClickUrl = ("http://a.zestadz.com/waplanding?lm=" + paramString[0] + "~ck");
      return;
    }
    this.adImage = "NA";
  }
  
  public static void stopAdpull()
  {
    t.cancel();
  }
  
  public boolean CheckAdVisibility()
  {
    return this.mAdVisibility;
  }
  
  Drawable ImageOperations(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Log.v("IMAGE IS", paramString1);
      paramContext = Drawable.createFromStream((InputStream)fetch(paramString1), "src");
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      Log.e("IMAGE OPERATION", paramContext.getMessage());
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramContext)
    {
      Log.e("IMAGE OPERATION", paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void displayAd()
  {
    final Activity localActivity = (Activity)this.zestContext.get();
    final RelativeLayout localRelativeLayout = new RelativeLayout(localActivity);
    this.handler = new Handler();
    try
    {
      this.userAgent = AdManager.getUserAgent(localActivity);
      final String str = AdManager.getAdclientId(localActivity);
      str = "http://a.zestadz.com/waphandler/deliverad?ua=" + this.userAgent + "&ip=&cid=" + str + "&meta=game&keyword=All";
      Log.v("Formed URL", str);
      final ImageView localImageView = new ImageView(localActivity);
      TextView localTextView = new TextView(localActivity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localImageView.setLayoutParams(localLayoutParams);
      localTextView.setLayoutParams(localLayoutParams);
      t = new Timer();
      t.schedule(new TimerTask()
      {
        public void run()
        {
          if (localImageView.getVisibility() == 0)
          {
            ZestADZAdView.this.mt = new Thread()
            {
              public void run()
              {
                ZestADZAdView.this.fetchAd(this.val$Url);
                if ((ZestADZAdView.this.adImage == null) || (ZestADZAdView.this.adImage.equals("NA")))
                {
                  ZestADZAdView.this.handler.post(new Runnable()
                  {
                    public void run()
                    {
                      this.val$container.removeAllViews();
                    }
                  });
                  ZestADZAdView.this.listener.AdFailed(ZestADZAdView.this);
                  return;
                }
                final Drawable localDrawable = ZestADZAdView.this.ImageOperations(this.val$context, ZestADZAdView.this.adImage, "image.jpg");
                ZestADZAdView.this.handler.post(new Runnable()
                {
                  public void run()
                  {
                    this.val$imgView.setImageDrawable(localDrawable);
                    this.val$imgView.setAdjustViewBounds(ZestADZAdView.this.mAdVisibility);
                    ZestADZAdView.this.setAdVisibility(true);
                    this.val$imgView.setVisibility(0);
                    this.val$imgView.setAdjustViewBounds(true);
                    this.val$imgView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.val$imgView.setOnClickListener(new View.OnClickListener()
                    {
                      public void onClick(View paramAnonymous4View)
                      {
                        paramAnonymous4View = new Intent("android.intent.action.VIEW", Uri.parse(ZestADZAdView.this.adClickUrl));
                        this.val$context.startActivity(paramAnonymous4View);
                      }
                    });
                    this.val$container.removeAllViews();
                    this.val$container.addView(this.val$imgView);
                    if (this.val$imgView != null)
                    {
                      if (ZestADZAdView.this.listener != null) {
                        try
                        {
                          ZestADZAdView.this.listener.AdReturned(ZestADZAdView.this);
                          return;
                        }
                        catch (Exception localException)
                        {
                          ZestADZAdView.this.listener.AdFailed(ZestADZAdView.this);
                          Log.w("ZestadzSDK", "Exception raised in your ZestadzListener: ", localException);
                          return;
                        }
                      }
                      ZestADZAdView.this.listener.AdFailed(ZestADZAdView.this);
                      return;
                    }
                    ZestADZAdView.this.listener.AdFailed(ZestADZAdView.this);
                  }
                });
              }
            };
            ZestADZAdView.this.mt.start();
            return;
          }
          ZestADZAdView.t.cancel();
          ZestADZAdView.t = null;
          ZestADZAdView.this.listener.AdFailed(ZestADZAdView.this);
        }
      }, 0L);
      addView(localRelativeLayout);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.handler.post(new Runnable()
        {
          public void run()
          {
            localRelativeLayout.removeAllViews();
          }
        });
        Log.e("ZestADZAdView", "Display ZestADZ Ad", localException);
        t.cancel();
        t = null;
        this.listener.AdFailed(this);
      }
    }
  }
  
  public Object fetch(String paramString)
    throws MalformedURLException, IOException
  {
    try
    {
      paramString = new URL(paramString).getContent();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Log.e("FETCH", paramString.toString());
    }
    return null;
  }
  
  public void fetchAd(String paramString)
  {
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 5000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 5000);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    paramString = new HttpGet(paramString);
    try
    {
      paramString = ((HttpClient)localObject).execute(paramString);
      Log.d("Ad Response", paramString.getStatusLine().toString());
      paramString = paramString.getEntity();
      if (paramString != null) {
        processAdResponse(convertStreamToString(paramString.getContent()));
      }
      return;
    }
    catch (ClientProtocolException paramString)
    {
      Log.e("ZestADZAdView SDK", "Caught ClientProtocolException in fetchConfig()", paramString);
      return;
    }
    catch (IOException paramString)
    {
      Log.e("ZestADZAdView SDK", "Caught IOException in fetchConfig()", paramString);
    }
  }
  
  public void setAdVisibility(boolean paramBoolean)
  {
    this.mAdVisibility = paramBoolean;
  }
  
  public void setListener(ZestADZListener paramZestADZListener)
  {
    try
    {
      this.listener = paramZestADZListener;
      return;
    }
    finally {}
  }
  
  public static abstract interface ZestADZListener
  {
    public abstract void AdFailed(ZestADZAdView paramZestADZAdView);
    
    public abstract void AdReturned(ZestADZAdView paramZestADZAdView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/zestadz/android/ZestADZAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */