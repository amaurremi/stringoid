package com.adfonic.android.view;

import android.content.Context;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adfonic.android.AdListener;
import com.adfonic.android.AdfonicActivity;
import com.adfonic.android.api.ExecutorCallback;
import com.adfonic.android.api.Request;
import com.adfonic.android.api.RequestExecutor;
import com.adfonic.android.api.request.XmlAttributeRequestReader;
import com.adfonic.android.api.response.ApiResponse;
import com.adfonic.android.utils.Log;
import com.adfonic.android.view.task.AmazonMarketUrlOpenerTask;
import com.adfonic.android.view.task.AndroidMarketUrlOpenerTask;
import com.adfonic.android.view.task.TelephoneUrlOpenerTask;
import com.adfonic.android.view.task.UrlOpenerTask;
import java.lang.reflect.Method;

public abstract class BaseAdfonicView
  extends WebView
  implements View.OnClickListener
{
  public static final String VERSION = "1.1.5";
  private AdLifeCycleListenerManager adListenerManager;
  private ExecutorCallback callback = new ExecutorCallback()
  {
    public void onResponse(ApiResponse paramAnonymousApiResponse)
    {
      if (Log.infoLoggingEnabled()) {
        Log.i("receive an ad from server: \n" + paramAnonymousApiResponse);
      }
      if (paramAnonymousApiResponse.isError())
      {
        if (Log.errorLoggingEnabled()) {
          Log.e("Issue while fetching ad: " + paramAnonymousApiResponse.getErrorMessage());
        }
        BaseAdfonicView.this.setVisibility(8);
        BaseAdfonicView.this.adListenerManager.onThrowable(BaseAdfonicView.this.getContext());
      }
      do
      {
        return;
        BaseAdfonicView.this.setResponse(paramAnonymousApiResponse);
        BaseAdfonicView.this.adListenerManager.onAdReceived(BaseAdfonicView.this.getContext());
      } while (BaseAdfonicView.this.isInterstitial());
      BaseAdfonicView.this.loadResponse(paramAnonymousApiResponse);
    }
    
    public void onThrowable(Throwable paramAnonymousThrowable)
    {
      if (Log.errorLoggingEnabled()) {
        Log.e("Can not fetch add", paramAnonymousThrowable);
      }
      BaseAdfonicView.this.adListenerManager.onThrowable(BaseAdfonicView.this.getContext());
    }
  };
  private boolean directLoading;
  private Runnable query = new Runnable()
  {
    public void run()
    {
      Handler localHandler = BaseAdfonicView.this.getHandler();
      if (BaseAdfonicView.this.isRequestInvalid()) {}
      do
      {
        do
        {
          return;
        } while (BaseAdfonicView.this.isInterstitial());
        BaseAdfonicView.this.executeCall(localHandler);
      } while ((!BaseAdfonicView.this.request.isRefreshAd()) || (BaseAdfonicView.this.request.getRefreshTime() <= 0));
      localHandler.postDelayed(BaseAdfonicView.this.query, BaseAdfonicView.this.request.getRefreshTime() * 1000);
    }
  };
  private Request request;
  private RequestExecutor requestExecutor;
  private ApiResponse response;
  
  public BaseAdfonicView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseAdfonicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public BaseAdfonicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null) {
      this.request = new XmlAttributeRequestReader().convertToRequest(paramAttributeSet, getContext());
    }
    if (isNotOnline())
    {
      setVisibility(8);
      return;
    }
    init();
  }
  
  private void executeCall(Handler paramHandler)
  {
    if (this.requestExecutor == null)
    {
      Log.w("Api executor is null");
      return;
    }
    if (isRequestInvalid())
    {
      Log.w("Request is not valid, please be sure to provide the right advert slotId");
      return;
    }
    this.requestExecutor.execute(getContext().getApplicationContext(), this.request, this.callback, paramHandler);
  }
  
  private void executeOpenUrl(String paramString)
  {
    new CustomUrlOpenerTask(null).execute(new String[] { paramString });
  }
  
  private void executeTelephoneCall(String paramString)
  {
    new TelephoneUrlOpenerTask()
    {
      protected Context getContext()
      {
        return BaseAdfonicView.this.getContext();
      }
    }.execute(new String[] { paramString });
  }
  
  private void init()
  {
    this.adListenerManager = new AdLifeCycleListenerManager();
    this.requestExecutor = new RequestExecutor(getContext());
    this.requestExecutor.start();
    setBackgroundToTransparent();
    setWebViewClient();
  }
  
  private boolean isNotOnline()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo == null) || (!localNetworkInfo.isConnectedOrConnecting());
  }
  
  private boolean isRequestInvalid()
  {
    if (this.request == null) {}
    String str;
    do
    {
      return true;
      str = this.request.getSlotId();
    } while ((str == null) || ("null".equals(str)));
    return false;
  }
  
  private void loadResponse(ApiResponse paramApiResponse)
  {
    setVisibility(0);
    loadAdContent(paramApiResponse.getAdContent());
    this.adListenerManager.onPresentScreen(getContext());
  }
  
  private void openAmazonMarket(String paramString)
  {
    new AmazonMarketUrlOpenerTask()
    {
      protected Context getContext()
      {
        return BaseAdfonicView.this.getContext();
      }
      
      protected void openUrl(String paramAnonymousString)
      {
        BaseAdfonicView.this.open(paramAnonymousString);
      }
    }.execute(new String[] { paramString });
  }
  
  private void openAndroidMarket(String paramString)
  {
    new AndroidMarketUrlOpenerTask()
    {
      protected Context getContext()
      {
        return BaseAdfonicView.this.getContext();
      }
    }.execute(new String[] { paramString });
  }
  
  private void playAudio(String paramString)
  {
    Context localContext = getContext();
    localContext.startActivity(AdfonicActivity.getPlayAudioIntent(paramString, localContext));
  }
  
  private void playVideo(String paramString)
  {
    Context localContext = getContext();
    localContext.startActivity(AdfonicActivity.getPlayVideoIntent(paramString, localContext));
  }
  
  private void setResponse(ApiResponse paramApiResponse)
  {
    this.response = paramApiResponse;
  }
  
  private void setWebViewClient()
  {
    setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        BaseAdfonicView.this.startAdClickThread(paramAnonymousString);
        return true;
      }
    });
  }
  
  private void startAdClickThread(final String paramString)
  {
    post(new Runnable()
    {
      public void run()
      {
        BaseAdfonicView.this.adListenerManager.onAdClick(BaseAdfonicView.this.getContext());
        if (BaseAdfonicView.this.isAudioResponse())
        {
          BaseAdfonicView.this.playAudio(paramString);
          return;
        }
        if (BaseAdfonicView.this.isVideoResponse())
        {
          BaseAdfonicView.this.playVideo(paramString);
          return;
        }
        if (BaseAdfonicView.this.isCallResponse())
        {
          BaseAdfonicView.this.executeTelephoneCall(paramString);
          return;
        }
        if (BaseAdfonicView.this.isAndroidMarketResponse())
        {
          BaseAdfonicView.this.openAndroidMarket(paramString);
          return;
        }
        if (BaseAdfonicView.this.isAmazonMarketResponse())
        {
          BaseAdfonicView.this.openAmazonMarket(paramString);
          return;
        }
        BaseAdfonicView.this.executeOpenUrl(paramString);
      }
    });
  }
  
  private void startInterstitial(String paramString)
  {
    Context localContext = getContext();
    localContext.startActivity(AdfonicActivity.getStartInterstitialIntent(paramString, localContext));
  }
  
  private void tryToSetBackgroundTransparentFromApiLevel11On()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      View.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), new Paint() });
      return;
    }
    catch (Exception localException) {}
  }
  
  protected abstract void expand();
  
  public Request getRequest()
  {
    return this.request;
  }
  
  protected boolean isAmazonMarketResponse()
  {
    if (this.response == null) {
      return false;
    }
    return this.response.isAmazonDestinationType();
  }
  
  protected boolean isAndroidMarketResponse()
  {
    if (this.response == null) {
      return false;
    }
    return this.response.isAndroidDestinationType();
  }
  
  protected boolean isAudioResponse()
  {
    if (this.response == null) {
      return false;
    }
    return this.response.isAudioResponse();
  }
  
  protected boolean isCallResponse()
  {
    if (this.response == null) {
      return false;
    }
    return this.response.isCallResponse();
  }
  
  protected boolean isInterstitial()
  {
    if (this.response == null) {
      return false;
    }
    return this.response.isInterstitial();
  }
  
  protected boolean isVideoResponse()
  {
    if (this.response == null) {
      return false;
    }
    return this.response.isVideoResponse();
  }
  
  public void loadAd(Request paramRequest)
  {
    if (paramRequest == null)
    {
      Log.w("Can't load a null request!");
      return;
    }
    this.directLoading = true;
    setRequest(paramRequest);
    executeCall(new Handler());
  }
  
  protected abstract void loadAdContent(String paramString);
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isNotOnline()) {}
    while (this.directLoading) {
      return;
    }
    post(this.query);
  }
  
  public void onClick(View paramView)
  {
    this.adListenerManager.onAdClick(getContext());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getHandler().removeCallbacks(this.query);
    if (this.requestExecutor != null) {
      this.requestExecutor.shutdown();
    }
    this.requestExecutor = null;
    if (this.adListenerManager != null)
    {
      this.adListenerManager.onDismissScreen(getContext());
      this.adListenerManager.setAdListener(null);
    }
  }
  
  protected abstract void open(String paramString);
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.adListenerManager.setAdListener(paramAdListener);
    setOnClickListener(this);
  }
  
  protected void setBackgroundToTransparent()
  {
    setBackgroundColor(0);
    setBackgroundDrawable(null);
    tryToSetBackgroundTransparentFromApiLevel11On();
  }
  
  public void setRequest(Request paramRequest)
  {
    this.request = paramRequest;
  }
  
  public void showInterstitial()
  {
    if (!isInterstitial())
    {
      Log.w("Response received is not an interstitial ad, please verify the settings!");
      return;
    }
    startInterstitial(this.response.getAdContent());
  }
  
  private class CustomUrlOpenerTask
    extends UrlOpenerTask
  {
    private CustomUrlOpenerTask() {}
    
    protected Context getContext()
    {
      return BaseAdfonicView.this.getContext();
    }
    
    protected void openUrl(String paramString)
    {
      BaseAdfonicView.this.open(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/view/BaseAdfonicView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */