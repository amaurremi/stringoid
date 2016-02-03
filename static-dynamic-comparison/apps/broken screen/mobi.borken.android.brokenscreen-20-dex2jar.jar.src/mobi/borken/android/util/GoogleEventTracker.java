package mobi.borken.android.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.MapBuilder;

public class GoogleEventTracker
{
  private final EasyTracker easyTracker;
  
  public GoogleEventTracker(Context paramContext)
  {
    this.easyTracker = EasyTracker.getInstance(paramContext);
  }
  
  public void activityStart(Activity paramActivity)
  {
    this.easyTracker.activityStart(paramActivity);
  }
  
  public void activityStop(Activity paramActivity)
  {
    this.easyTracker.activityStop(paramActivity);
  }
  
  public void event(String paramString1, String paramString2)
  {
    this.easyTracker.send(MapBuilder.createEvent(paramString1, paramString2, null, null).build());
  }
  
  public void event(String paramString1, String paramString2, String paramString3)
  {
    this.easyTracker.send(MapBuilder.createEvent(paramString1, paramString2, paramString3, null).build());
  }
  
  public void event(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    this.easyTracker.send(MapBuilder.createEvent(paramString1, paramString2, paramString3, paramLong).build());
  }
  
  public void screenView(String paramString1, String paramString2)
  {
    EasyTracker localEasyTracker = this.easyTracker;
    MapBuilder localMapBuilder = MapBuilder.createAppView().set("&cd", paramString2);
    String str = Fields.customDimension(1);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = "unknown";
    }
    localEasyTracker.send(localMapBuilder.set(str, paramString2).build());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/util/GoogleEventTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */