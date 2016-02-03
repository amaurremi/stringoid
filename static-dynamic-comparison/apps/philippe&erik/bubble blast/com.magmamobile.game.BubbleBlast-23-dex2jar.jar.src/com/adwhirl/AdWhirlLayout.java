package com.adwhirl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.adwhirl.adapters.AdWhirlAdapter;
import com.adwhirl.obj.Custom;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.adwhirl.util.AdWhirlUtil;
import com.google.ads.AdSenseSpec.AdType;
import com.google.ads.AdView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class AdWhirlLayout
  extends RelativeLayout
{
  public static final String ADWHIRL_KEY = "ADWHIRL_KEY";
  public Ration activeRation;
  public WeakReference<Activity> activityReference;
  public AdWhirlInterface adWhirlInterface;
  public AdWhirlManager adWhirlManager;
  public AdSenseSpec.AdType adsenseAdType = null;
  private ScheduledFuture<?> currentTask;
  public Custom custom;
  public Extra extra;
  public final Handler handler = new Handler();
  private boolean hasWindow;
  private boolean isScheduled;
  private String keyAdWhirl;
  private int maxHeight;
  private int maxWidth;
  public Ration nextRation;
  public final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  public WeakReference<RelativeLayout> superViewReference;
  
  public AdWhirlLayout(Activity paramActivity, String paramString)
  {
    super(paramActivity);
    init(paramActivity, paramString);
  }
  
  public AdWhirlLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getAdWhirlKey(paramContext);
    init((Activity)paramContext, paramAttributeSet);
  }
  
  private void countClick()
  {
    if (this.activeRation != null)
    {
      String str = String.format("http://met.adwhirl.com/exclick.php?appid=%s&nid=%s&type=%d&uuid=%s&country_code=%s&appver=%d&client=2", new Object[] { this.adWhirlManager.keyAdWhirl, this.activeRation.nid, Integer.valueOf(this.activeRation.type), this.adWhirlManager.deviceIDHash, this.adWhirlManager.localeString, Integer.valueOf(300) });
      this.scheduler.schedule(new PingUrlRunnable(str), 0L, TimeUnit.SECONDS);
    }
  }
  
  private void countImpression()
  {
    if (this.activeRation != null)
    {
      String str = String.format("http://met.adwhirl.com/exmet.php?appid=%s&nid=%s&type=%d&uuid=%s&country_code=%s&appver=%d&client=2", new Object[] { this.adWhirlManager.keyAdWhirl, this.activeRation.nid, Integer.valueOf(this.activeRation.type), this.adWhirlManager.deviceIDHash, this.adWhirlManager.localeString, Integer.valueOf(300) });
      this.scheduler.schedule(new PingUrlRunnable(str), 0L, TimeUnit.SECONDS);
    }
  }
  
  private void handleAd()
  {
    if (this.nextRation == null)
    {
      if (Extra2.verboselog) {
        Log.e("AdWhirl SDK", "nextRation is null!");
      }
      rotateThreadedDelayed();
      return;
    }
    try
    {
      String str = String.format("Showing ad:\n\tnid: %s\n\tname: %s\n\ttype: %d\n\tkey: %s\n\tkey2: %s", new Object[] { this.nextRation.nid, this.nextRation.name, Integer.valueOf(this.nextRation.type), this.nextRation.key, this.nextRation.key2 });
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", str);
      }
      AdWhirlAdapter.handle(this, this.nextRation);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (Extra2.verboselog) {
        Log.w("AdWhirl SDK", "Caught an exception in adapter:", localThrowable);
      }
      rollover();
    }
  }
  
  private void rotateAd()
  {
    if (!this.hasWindow)
    {
      this.isScheduled = false;
      return;
    }
    if (Extra2.verboselog) {
      Log.i("AdWhirl SDK", "Rotating Ad");
    }
    this.nextRation = this.adWhirlManager.getRation();
    this.handler.post(new HandleAdRunnable(this));
  }
  
  protected String getAdWhirlKey(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = paramContext.getPackageName();
    Object localObject3 = paramContext.getClass().getName();
    paramContext = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        localObject3 = paramContext.getActivityInfo(new ComponentName((String)localObject2, (String)localObject3), 128).metaData;
        if (localObject3 != null)
        {
          paramContext = ((Bundle)localObject3).getString("ADWHIRL_KEY");
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return null;
      }
      try
      {
        localObject2 = paramContext.getApplicationInfo((String)localObject2, 128).metaData;
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          paramContext = ((Bundle)localObject2).getString("ADWHIRL_KEY");
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return null;
  }
  
  public Future<?> getFuture()
  {
    return this.currentTask;
  }
  
  protected void init(Activity paramActivity, String paramString)
  {
    this.activityReference = new WeakReference(paramActivity);
    this.superViewReference = new WeakReference(this);
    this.keyAdWhirl = paramString;
    this.hasWindow = true;
    this.isScheduled = true;
    this.scheduler.schedule(new InitRunnable(this, paramString), 0L, TimeUnit.SECONDS);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    this.maxWidth = 0;
    this.maxHeight = 0;
  }
  
  public void killAdsenseAndAdmobWebViewOnDestroy(View paramView)
  {
    Object localObject = paramView;
    if (paramView == null) {
      localObject = getChildAt(0);
    }
    for (;;)
    {
      int i;
      try
      {
        if ((localObject instanceof AdView))
        {
          if (Extra2.verboselog) {
            Log.d("AdWhirl SDK", "ADMOB ADSENSE WEBVIEW TO KILL");
          }
          paramView = (AdView)localObject;
          if (paramView != null)
          {
            i = 0;
            if (i >= paramView.getChildCount()) {
              return;
            }
            int j;
            if ((paramView.getChildAt(i) instanceof ViewGroup))
            {
              if (Extra2.verboselog) {
                Log.d("AdWhirl SDK", "ViewGroup Inside Adsense View !");
              }
              localObject = (ViewGroup)paramView.getChildAt(i);
              j = 0;
              if (j < ((ViewGroup)localObject).getChildCount()) {}
            }
            else
            {
              if (!(paramView.getChildAt(i) instanceof WebView)) {
                break label212;
              }
              if (Extra2.verboselog) {
                Log.e("AdWhirl SDK", "Admob Adsense WEBVIEW ! => ON DESTROY !!!");
              }
              ((WebView)paramView.getChildAt(i)).destroy();
              break label212;
            }
            if ((((ViewGroup)localObject).getChildAt(j) instanceof WebView))
            {
              if (Extra2.verboselog) {
                Log.e("AdWhirl SDK", "Admob Adsense WEBVIEW ! => ON DESTROY !!!");
              }
              ((WebView)((ViewGroup)localObject).getChildAt(j)).destroy();
            }
            j += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramView)
      {
        if (Extra2.verboselog) {
          Log.e("AdWhirl SDK", "Adsense WEBVIEW onDestroy Failed !!!");
        }
        paramView.printStackTrace();
      }
      label212:
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    label344:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (Extra2.verboselog) {
            Log.d("AdWhirl SDK", "Intercepted ACTION_DOWN event");
          }
          if (this.activeRation != null)
          {
            countClick();
            Activity localActivity;
            if (this.activeRation.type == 9)
            {
              if ((this.custom != null) && (this.custom.link != null))
              {
                paramMotionEvent = new Intent("android.intent.action.VIEW", Uri.parse(this.custom.link));
                paramMotionEvent.addFlags(268435456);
                try
                {
                  if (this.activityReference == null) {
                    continue;
                  }
                  localActivity = (Activity)this.activityReference.get();
                  if (localActivity == null) {
                    continue;
                  }
                  localActivity.startActivity(paramMotionEvent);
                  return false;
                }
                catch (Exception paramMotionEvent) {}
                if (Extra2.verboselog)
                {
                  Log.w("AdWhirl SDK", "Could not handle click to " + this.custom.link, paramMotionEvent);
                  return false;
                }
              }
              else
              {
                Log.w("AdWhirl SDK", "In onInterceptTouchEvent(), but custom or custom.link is null");
                return false;
              }
            }
            else if ((this.activeRation.type == 17) && (this.activeRation.key.toLowerCase().equals(AdWhirlUtil.KREACTIVE_KEY)))
            {
              if ((this.custom == null) || (this.custom.link == null)) {
                break label344;
              }
              paramMotionEvent = new Intent("android.intent.action.VIEW", Uri.parse(this.custom.link));
              ModCommon.callTracking(this.custom.trackingClick);
              paramMotionEvent.addFlags(268435456);
              try
              {
                if (this.activityReference != null)
                {
                  localActivity = (Activity)this.activityReference.get();
                  if (localActivity != null)
                  {
                    localActivity.startActivity(paramMotionEvent);
                    return false;
                  }
                }
              }
              catch (Exception paramMotionEvent) {}
            }
          }
        }
      } while (!Extra2.verboselog);
      Log.w("AdWhirl SDK", "Could not handle click to " + this.custom.link, paramMotionEvent);
      return false;
    } while (!Extra2.verboselog);
    Log.w("AdWhirl SDK", "In onInterceptTouchEvent(), but custom or custom.link is null");
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i = paramInt1;
    if (this.maxWidth > 0)
    {
      i = paramInt1;
      if (k > this.maxWidth) {
        i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, Integer.MIN_VALUE);
      }
    }
    paramInt1 = paramInt2;
    if (this.maxHeight > 0)
    {
      paramInt1 = paramInt2;
      if (j > this.maxHeight) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
      }
    }
    super.onMeasure(i, paramInt1);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      this.hasWindow = true;
      if (!this.isScheduled)
      {
        this.isScheduled = true;
        if (this.extra != null) {
          rotateThreadedNow();
        }
      }
      else
      {
        return;
      }
      this.currentTask = this.scheduler.schedule(new InitRunnable(this, this.keyAdWhirl), 0L, TimeUnit.SECONDS);
      return;
    }
    this.hasWindow = false;
  }
  
  public void onWindowVisibilityChanged2(int paramInt)
  {
    if ((paramInt == 0) && (this.extra != null) && (getFuture() != null))
    {
      getFuture().cancel(true);
      rotateThreadedNow();
    }
  }
  
  public void pushSubView(ViewGroup paramViewGroup)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "pushSubView Start");
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)this.superViewReference.get();
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "pushSubView superView Getted");
    }
    if (localRelativeLayout == null) {
      return;
    }
    try
    {
      killAdsenseAndAdmobWebViewOnDestroy(localRelativeLayout.getChildAt(0));
    }
    catch (Exception localException2)
    {
      try
      {
        localRelativeLayout.removeAllViews();
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(13);
            localRelativeLayout.addView(paramViewGroup, localLayoutParams);
            if (Extra2.verboselog) {
              Log.d("AdWhirl SDK", "Added subview");
            }
            this.activeRation = this.nextRation;
            countImpression();
            return;
            localException1 = localException1;
            if (Extra2.verboselog) {
              Log.e("AdWhirl SDK", "Adsense WEBVIEW onDestroy Failed !!!");
            }
            localException1.printStackTrace();
            continue;
            localException2 = localException2;
            localException2.printStackTrace();
          }
        }
        catch (Exception paramViewGroup)
        {
          for (;;)
          {
            paramViewGroup.printStackTrace();
          }
        }
      }
    }
  }
  
  public void rollover()
  {
    if (Extra2.verboselog) {
      Log.w("AdWhirl SDK", "ROLLOVER !");
    }
    this.nextRation = this.adWhirlManager.getRollover();
    this.handler.post(new HandleAdRunnable(this));
  }
  
  public void rotateThreadedDelayed()
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Will call rotateAd() in " + this.extra.cycleTime + " seconds");
    }
    this.currentTask = this.scheduler.schedule(new RotateAdRunnable(this), this.extra.cycleTime, TimeUnit.SECONDS);
  }
  
  public void rotateThreadedNow()
  {
    this.currentTask = this.scheduler.schedule(new RotateAdRunnable(this), 0L, TimeUnit.SECONDS);
  }
  
  public void setAdWhirlInterface(AdWhirlInterface paramAdWhirlInterface)
  {
    this.adWhirlInterface = paramAdWhirlInterface;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
  }
  
  public static abstract interface AdWhirlInterface
  {
    public abstract void adWhirlGeneric();
  }
  
  private static class HandleAdRunnable
    implements Runnable
  {
    private WeakReference<AdWhirlLayout> adWhirlLayoutReference;
    
    public HandleAdRunnable(AdWhirlLayout paramAdWhirlLayout)
    {
      this.adWhirlLayoutReference = new WeakReference(paramAdWhirlLayout);
    }
    
    public void run()
    {
      AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
      if (localAdWhirlLayout != null) {
        localAdWhirlLayout.handleAd();
      }
    }
  }
  
  private static class InitRunnable
    implements Runnable
  {
    private WeakReference<AdWhirlLayout> adWhirlLayoutReference;
    private String keyAdWhirl;
    
    public InitRunnable(AdWhirlLayout paramAdWhirlLayout, String paramString)
    {
      this.adWhirlLayoutReference = new WeakReference(paramAdWhirlLayout);
      this.keyAdWhirl = paramString;
    }
    
    public void run()
    {
      AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
      Activity localActivity;
      if (localAdWhirlLayout != null)
      {
        localActivity = (Activity)localAdWhirlLayout.activityReference.get();
        if (localActivity != null) {}
      }
      else
      {
        return;
      }
      if (localAdWhirlLayout.adWhirlManager == null) {
        localAdWhirlLayout.adWhirlManager = new AdWhirlManager(new WeakReference(localActivity.getApplicationContext()), this.keyAdWhirl);
      }
      if (!localAdWhirlLayout.hasWindow)
      {
        localAdWhirlLayout.isScheduled = false;
        return;
      }
      localAdWhirlLayout.adWhirlManager.fetchConfig();
      localAdWhirlLayout.extra = localAdWhirlLayout.adWhirlManager.getExtra();
      if (localAdWhirlLayout.extra == null)
      {
        localAdWhirlLayout.scheduler.schedule(this, 30L, TimeUnit.SECONDS);
        return;
      }
      localAdWhirlLayout.rotateAd();
    }
  }
  
  private static class PingUrlRunnable
    implements Runnable
  {
    private String url;
    
    public PingUrlRunnable(String paramString)
    {
      this.url = paramString;
    }
    
    public void run()
    {
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "Pinging URL: " + this.url);
      }
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      HttpGet localHttpGet = new HttpGet(this.url);
      try
      {
        localDefaultHttpClient.execute(localHttpGet);
        return;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        while (!Extra2.verboselog) {}
        Log.e("AdWhirl SDK", "Caught ClientProtocolException in PingUrlRunnable", localClientProtocolException);
        return;
      }
      catch (IOException localIOException)
      {
        while (!Extra2.verboselog) {}
        Log.e("AdWhirl SDK", "Caught IOException in PingUrlRunnable", localIOException);
        return;
      }
      catch (Exception localException)
      {
        while (!Extra2.verboselog) {}
        Log.e("AdWhirl SDK", "Caught Exception in PingUrlRunnable NIX", localException);
      }
    }
  }
  
  private static class RotateAdRunnable
    implements Runnable
  {
    private WeakReference<AdWhirlLayout> adWhirlLayoutReference;
    
    public RotateAdRunnable(AdWhirlLayout paramAdWhirlLayout)
    {
      this.adWhirlLayoutReference = new WeakReference(paramAdWhirlLayout);
    }
    
    public void run()
    {
      AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
      if (localAdWhirlLayout != null) {
        localAdWhirlLayout.rotateAd();
      }
    }
  }
  
  public static class ViewAdRunnable
    implements Runnable
  {
    private WeakReference<AdWhirlLayout> adWhirlLayoutReference;
    private ViewGroup nextView;
    
    public ViewAdRunnable(AdWhirlLayout paramAdWhirlLayout, ViewGroup paramViewGroup)
    {
      this.adWhirlLayoutReference = new WeakReference(paramAdWhirlLayout);
      this.nextView = paramViewGroup;
    }
    
    public void run()
    {
      AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
      if (localAdWhirlLayout != null) {
        localAdWhirlLayout.pushSubView(this.nextView);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/AdWhirlLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */