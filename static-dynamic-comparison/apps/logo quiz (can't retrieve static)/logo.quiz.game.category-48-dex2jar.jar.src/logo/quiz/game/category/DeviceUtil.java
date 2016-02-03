package logo.quiz.game.category;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

public class DeviceUtil
{
  private static final int IMAGE_MAX_SIZE = 70;
  private static final String TAG = "DeviceUtil";
  
  public static int dip(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static Point getDeviceSize(Context paramContext)
  {
    paramContext = getDisplayDevice(paramContext);
    return new Point(paramContext.getWidth(), paramContext.getHeight());
  }
  
  private static Display getDisplayDevice(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public static boolean isOnline(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return (paramContext.getActiveNetworkInfo() != null) && (paramContext.getActiveNetworkInfo().isConnectedOrConnecting());
  }
  
  public static boolean isPackageExists(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public static void playSound(Context paramContext, int paramInt)
  {
    paramContext = MediaPlayer.create(paramContext, paramInt);
    if (paramContext != null) {
      paramContext.start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/game/category/DeviceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */