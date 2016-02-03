package com.venticake.a.a;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyVideoAd;
import org.json.JSONArray;

public class b
  extends a
{
  public static String a = null;
  public static String b = null;
  public static String c = null;
  
  public b(JSONArray paramJSONArray)
  {
    super(17, paramJSONArray);
  }
  
  public void a(Activity paramActivity)
  {
    Log.d("spad", "AdColony.resume: " + paramActivity);
    AdColony.resume(paramActivity);
  }
  
  public void a(Activity paramActivity, com.venticake.a.a parama)
  {
    Log.d("spad", "configure.AdColony: " + paramActivity);
    AdColony.configure(paramActivity, a, b, new String[] { c });
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    Log.d("spad", "display.AdColonyVideoAd: " + paramActivity);
    paramActivity = new AdColonyVideoAd();
    if (paramActivity.isReady())
    {
      paramActivity.show();
      return true;
    }
    return false;
  }
  
  public void b(Activity paramActivity)
  {
    Log.d("spad", "AdColony.pause: " + paramActivity);
    AdColony.pause();
  }
  
  public void b(Activity paramActivity, com.venticake.a.a parama) {}
  
  public boolean b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    return false;
  }
  
  public int d()
  {
    return 17;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */