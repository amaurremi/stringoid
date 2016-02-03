package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.nativeads.util.Utils;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public final class MoPubNative
{
  private final String mAdUnitId;
  private final Context mContext;
  private MoPubNativeListener mMoPubNativeListener;
  private NativeResponse mNativeResponse;
  
  public MoPubNative(Context paramContext, String paramString, MoPubNativeListener paramMoPubNativeListener)
  {
    ImpressionTrackingManager.start();
    if (paramContext == null) {
      throw new IllegalArgumentException("Context may not be null.");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("AdUnitId may not be null.");
    }
    if (paramMoPubNativeListener == null) {
      throw new IllegalArgumentException("MoPubNativeListener may not be null.");
    }
    this.mContext = paramContext.getApplicationContext();
    this.mAdUnitId = paramString;
    this.mMoPubNativeListener = paramMoPubNativeListener;
    GpsHelper.asyncFetchAdvertisingInfo(this.mContext);
  }
  
  private void downloadImages()
  {
    ImageService.get(this.mContext, this.mNativeResponse.getAllImageUrls(), new ImageService.ImageServiceListener()
    {
      public void onFail()
      {
        MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
      }
      
      public void onSuccess(Map<String, Bitmap> paramAnonymousMap)
      {
        MoPubNative.this.mMoPubNativeListener.onNativeLoad(MoPubNative.this.mNativeResponse);
      }
    });
  }
  
  private void downloadJson(HttpUriRequest paramHttpUriRequest)
  {
    AsyncTasks.safeExecuteOnExecutor(new DownloadTask(new DownloadTask.DownloadTaskListener()
    {
      public void onComplete(String paramAnonymousString, DownloadResponse paramAnonymousDownloadResponse)
      {
        if (paramAnonymousDownloadResponse == null)
        {
          MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
          return;
        }
        if ((paramAnonymousDownloadResponse.getStatusCode() >= 500) && (paramAnonymousDownloadResponse.getStatusCode() < 600))
        {
          MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
          return;
        }
        if (paramAnonymousDownloadResponse.getStatusCode() != 200)
        {
          MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.UNEXPECTED_RESPONSE_CODE);
          return;
        }
        if (paramAnonymousDownloadResponse.getContentLength() == 0L)
        {
          MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
          return;
        }
        paramAnonymousString = HttpResponses.asJsonObject(paramAnonymousDownloadResponse);
        if (paramAnonymousString == null)
        {
          MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.INVALID_JSON);
          return;
        }
        try
        {
          MoPubNative.access$102(MoPubNative.this, new NativeResponse(paramAnonymousString));
          MoPubNative.this.downloadImages();
          return;
        }
        catch (IllegalArgumentException paramAnonymousString)
        {
          MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.INVALID_JSON);
        }
      }
    }), new HttpUriRequest[] { paramHttpUriRequest });
  }
  
  private void loadNativeAd(RequestParameters paramRequestParameters)
  {
    paramRequestParameters = new NativeUrlGenerator(this.mContext).withAdUnitId(this.mAdUnitId).withRequest(paramRequestParameters).generateUrlString("ads.mopub.com");
    if (paramRequestParameters != null) {
      Utils.MoPubLog("Loading ad from: " + paramRequestParameters);
    }
    try
    {
      paramRequestParameters = new HttpGet(paramRequestParameters);
      downloadJson(paramRequestParameters);
      return;
    }
    catch (IllegalArgumentException paramRequestParameters)
    {
      this.mMoPubNativeListener.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
    }
  }
  
  public void destroy()
  {
    this.mMoPubNativeListener = MoPubNativeListener.EMPTY_MOPUB_NATIVE_LISTENER;
  }
  
  public void makeRequest()
  {
    makeRequest(null);
  }
  
  public void makeRequest(RequestParameters paramRequestParameters)
  {
    makeRequest(paramRequestParameters, new NativeGpsHelperListener(paramRequestParameters));
  }
  
  void makeRequest(RequestParameters paramRequestParameters, NativeGpsHelperListener paramNativeGpsHelperListener)
  {
    if (!DeviceUtils.isNetworkAvailable(this.mContext))
    {
      this.mMoPubNativeListener.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
      return;
    }
    GpsHelper.asyncFetchAdvertisingInfoIfNotCached(this.mContext, paramNativeGpsHelperListener);
  }
  
  public static abstract interface MoPubNativeListener
  {
    public static final MoPubNativeListener EMPTY_MOPUB_NATIVE_LISTENER = new MoPubNativeListener()
    {
      public void onNativeClick(View paramAnonymousView) {}
      
      public void onNativeFail(NativeErrorCode paramAnonymousNativeErrorCode) {}
      
      public void onNativeImpression(View paramAnonymousView) {}
      
      public void onNativeLoad(NativeResponse paramAnonymousNativeResponse) {}
    };
    
    public abstract void onNativeClick(View paramView);
    
    public abstract void onNativeFail(NativeErrorCode paramNativeErrorCode);
    
    public abstract void onNativeImpression(View paramView);
    
    public abstract void onNativeLoad(NativeResponse paramNativeResponse);
  }
  
  class NativeGpsHelperListener
    implements GpsHelper.GpsHelperListener
  {
    private RequestParameters mRequestParameters;
    
    NativeGpsHelperListener(RequestParameters paramRequestParameters)
    {
      this.mRequestParameters = paramRequestParameters;
    }
    
    public void onFetchAdInfoCompleted()
    {
      MoPubNative.this.loadNativeAd(this.mRequestParameters);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/MoPubNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */