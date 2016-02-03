package mobi.beyondpod.ui.views.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.List;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;

public class WebViewEx
  extends WebView
{
  private static final String TAG = WebViewEx.class.getSimpleName();
  private static volatile int _InstanceCount;
  private int _CurrInstance;
  GestureDetector _Detector;
  private boolean _EnableDoubleTapClose = false;
  private IWebViewOwner _Owner;
  
  public WebViewEx(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public WebViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WebViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static boolean StartExternalActivityForURLIfNeeded(Activity paramActivity, Uri paramUri)
  {
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.addCategory("android.intent.category.BROWSABLE");
    try
    {
      List localList = paramActivity.getPackageManager().queryIntentActivities(paramUri, 65536);
      if ((localList.size() > 0) && (!((ResolveInfo)localList.get(0)).activityInfo.packageName.equals("com.android.browser")) && (!((ResolveInfo)localList.get(0)).activityInfo.packageName.equals("com.google.android.browser")) && (!((ResolveInfo)localList.get(0)).activityInfo.packageName.equals("com.android.chrome")) && (!((ResolveInfo)localList.get(0)).activityInfo.packageName.equals("com.amazon.cloud9")) && (!((ResolveInfo)localList.get(0)).activityInfo.packageName.equals("com.sec.webbrowserminiapp")))
      {
        boolean bool = paramActivity.startActivityIfNeeded(paramUri, -1);
        if (bool) {
          return true;
        }
      }
    }
    catch (ActivityNotFoundException paramActivity) {}
    return false;
  }
  
  private void init()
  {
    this._CurrInstance = _InstanceCount;
    _InstanceCount += 1;
    CoreHelper.WriteTraceEntry(TAG, "#########== WebViewEX created! Instances: " + _InstanceCount + " #########");
  }
  
  public void Initialize(IWebViewOwner paramIWebViewOwner, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._Owner = paramIWebViewOwner;
    this._EnableDoubleTapClose = paramBoolean1;
    this._Detector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
      
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    this._Detector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener()
    {
      public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        if (WebViewEx.this._EnableDoubleTapClose)
        {
          WebViewEx.this._Owner.OnDoubleTap();
          return true;
        }
        return false;
      }
      
      public boolean onDoubleTapEvent(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
      
      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    if ((!paramBoolean2) && (!Configuration.IsCellularConnectionAllowed()) && (CoreHelper.GetDeviceNetworkConnection().IsConnectionCellular())) {
      setBlockNetworkLoads(true);
    }
  }
  
  public void destroy()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(this);
    }
    CoreHelper.WriteTraceEntry(TAG, "#########=== Destroying WebViewEX instance #: " + this._CurrInstance + " #########");
    super.destroy();
  }
  
  protected void finalize()
    throws Throwable
  {
    _InstanceCount -= 1;
    CoreHelper.WriteTraceEntry(TAG, "#########== WebViewEX finalized! Remaining instances: " + _InstanceCount + " #########");
    super.finalize();
  }
  
  @TargetApi(8)
  public boolean getBlockNetworkLoads()
  {
    WebSettings localWebSettings = getSettings();
    if (CoreHelper.ApiLevel() > 7) {
      return localWebSettings.getBlockNetworkLoads();
    }
    return localWebSettings.getBlockNetworkImage();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      CoreHelper.WriteTraceEntry(TAG, "Exception on Draw: " + paramCanvas.getMessage());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this._Detector.onTouchEvent(paramMotionEvent)) {
        return true;
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      CoreHelper.WriteLogEntry(TAG, "WebView onTouchEvent Failed!");
    }
    return false;
  }
  
  @TargetApi(8)
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    WebSettings localWebSettings = getSettings();
    if (CoreHelper.ApiLevel() > 7)
    {
      localWebSettings.setBlockNetworkLoads(paramBoolean);
      return;
    }
    localWebSettings.setBlockNetworkImage(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/WebViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */