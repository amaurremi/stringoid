package com.mopub.nativeads;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class ImpressionTrackingManager
{
  private static final int PERIOD = 250;
  private static AtomicBoolean mIsStarted = new AtomicBoolean(false);
  private static WeakHashMap<View, NativeResponseWrapper> sKeptViews = new WeakHashMap(10);
  private static final ScheduledExecutorService sScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  private static final VisibilityCheck sVisibilityCheck = new VisibilityCheck();
  
  static void addView(View paramView, NativeResponse paramNativeResponse, MoPubNative.MoPubNativeListener paramMoPubNativeListener)
  {
    if ((paramView != null) && (paramNativeResponse != null)) {
      sKeptViews.put(paramView, new NativeResponseWrapper(paramNativeResponse, paramMoPubNativeListener));
    }
  }
  
  @Deprecated
  static Map<View, NativeResponseWrapper> getKeptViews()
  {
    return sKeptViews;
  }
  
  @Deprecated
  static void purgeViews()
  {
    sKeptViews.clear();
  }
  
  static void removeView(View paramView)
  {
    sKeptViews.remove(paramView);
  }
  
  static void start()
  {
    if (mIsStarted.compareAndSet(false, true)) {
      sScheduledExecutorService.scheduleWithFixedDelay(sVisibilityCheck, 0L, 250L, TimeUnit.MILLISECONDS);
    }
  }
  
  static void stop()
  {
    if (mIsStarted.compareAndSet(true, false)) {
      sScheduledExecutorService.shutdownNow();
    }
  }
  
  static class NativeResponseWrapper
  {
    long mFirstVisibleTimestamp;
    final MoPubNative.MoPubNativeListener mMoPubNativeListener;
    final NativeResponse mNativeResponse;
    
    NativeResponseWrapper(NativeResponse paramNativeResponse, MoPubNative.MoPubNativeListener paramMoPubNativeListener)
    {
      this.mNativeResponse = paramNativeResponse;
      this.mMoPubNativeListener = paramMoPubNativeListener;
      this.mFirstVisibleTimestamp = 0L;
    }
  }
  
  static class VisibilityCheck
    implements Runnable
  {
    private static final long MINIMUM_IMPRESSION_TIME = 1000L;
    private static final double MINIMUM_PERCENT_VISIBLE = 50.0D;
    
    static boolean isVisible(View paramView)
    {
      if ((paramView == null) || (paramView.getVisibility() != 0)) {}
      int i;
      int j;
      int k;
      do
      {
        return false;
        Rect localRect = new Rect();
        paramView.getGlobalVisibleRect(localRect);
        i = localRect.width();
        j = localRect.height();
        k = paramView.getWidth() * paramView.getHeight();
      } while ((k <= 0) || (i * j * 100 / k < 50.0D));
      return true;
    }
    
    public void run()
    {
      Iterator localIterator1 = ImpressionTrackingManager.sKeptViews.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (Map.Entry)localIterator1.next();
        View localView = (View)((Map.Entry)localObject).getKey();
        localObject = (ImpressionTrackingManager.NativeResponseWrapper)((Map.Entry)localObject).getValue();
        if ((localObject == null) || (((ImpressionTrackingManager.NativeResponseWrapper)localObject).mNativeResponse == null))
        {
          try
          {
            localIterator1.remove();
          }
          catch (ConcurrentModificationException localConcurrentModificationException1) {}
        }
        else if (((ImpressionTrackingManager.NativeResponseWrapper)localObject).mNativeResponse.isDestroyed())
        {
          try
          {
            localIterator1.remove();
          }
          catch (ConcurrentModificationException localConcurrentModificationException2) {}
        }
        else if (((ImpressionTrackingManager.NativeResponseWrapper)localObject).mNativeResponse.getRecordedImpression())
        {
          try
          {
            localIterator1.remove();
          }
          catch (ConcurrentModificationException localConcurrentModificationException3) {}
        }
        else if (!isVisible(localConcurrentModificationException3))
        {
          ((ImpressionTrackingManager.NativeResponseWrapper)localObject).mFirstVisibleTimestamp = 0L;
        }
        else if (((ImpressionTrackingManager.NativeResponseWrapper)localObject).mFirstVisibleTimestamp == 0L)
        {
          ((ImpressionTrackingManager.NativeResponseWrapper)localObject).mFirstVisibleTimestamp = SystemClock.uptimeMillis();
        }
        else if (SystemClock.uptimeMillis() - ((ImpressionTrackingManager.NativeResponseWrapper)localObject).mFirstVisibleTimestamp >= 1000L)
        {
          ((ImpressionTrackingManager.NativeResponseWrapper)localObject).mNativeResponse.recordImpression();
          Iterator localIterator2 = ((ImpressionTrackingManager.NativeResponseWrapper)localObject).mNativeResponse.getImpressionTrackers().iterator();
          while (localIterator2.hasNext()) {
            NativeHttpClient.makeTrackingHttpRequest((String)localIterator2.next());
          }
          if (((ImpressionTrackingManager.NativeResponseWrapper)localObject).mMoPubNativeListener != null)
          {
            ((ImpressionTrackingManager.NativeResponseWrapper)localObject).mMoPubNativeListener.onNativeImpression(localConcurrentModificationException3);
            try
            {
              localIterator1.remove();
            }
            catch (ConcurrentModificationException localConcurrentModificationException4) {}
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/ImpressionTrackingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */