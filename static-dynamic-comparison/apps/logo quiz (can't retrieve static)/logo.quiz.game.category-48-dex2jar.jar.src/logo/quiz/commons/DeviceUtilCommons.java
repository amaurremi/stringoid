package logo.quiz.commons;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

public class DeviceUtilCommons
{
  static final String TAG = "DeviceUtilCommons";
  static MediaPlayer mp;
  
  public static void alert(String paramString, Activity paramActivity)
  {
    try
    {
      paramActivity = new AlertDialog.Builder(paramActivity);
      paramActivity.setMessage(paramString);
      paramActivity.setNeutralButton("OK", null);
      Log.d("DeviceUtilCommons", "Showing alert dialog: " + paramString);
      paramActivity.create().show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void checkInfo(Context paramContext)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str = ((SharedPreferences)localObject).getString("info", null);
    if (str != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("info", null);
      ((SharedPreferences.Editor)localObject).commit();
      showLongToast(str, paramContext);
    }
  }
  
  public static void complain(String paramString, Activity paramActivity)
  {
    Log.e("DeviceUtilCommons", "LogoQuiz Error: " + paramString);
  }
  
  public static int dip(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int dp(float paramFloat, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static float dpToPx(int paramInt, Context paramContext)
  {
    return TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int getApplicationVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 0;
  }
  
  public static Class getClassByName(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Class.forName(paramContext.getPackageName() + "." + paramString);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new ClassNotFoundRuntimeException("ActivityName not exist in LogoQuizCommons!");
    }
  }
  
  public static int getColorIdByName(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "color", paramContext.getPackageName());
  }
  
  public static Point getDeviceSize(Context paramContext)
  {
    paramContext = getDisplayDevice(paramContext);
    return new Point(paramContext.getWidth(), paramContext.getHeight());
  }
  
  public static int getDeviceWidthAccountDensity(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getDisplayDevice(paramContext).getMetrics(localDisplayMetrics);
    return (int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density);
  }
  
  private static Display getDisplayDevice(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public static int getDrawableIdByName(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
  }
  
  public static int getIdByName(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
  }
  
  public static int getLayoutIdByName(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
  }
  
  public static int getLogoSize(Context paramContext)
  {
    return getDeviceSize(paramContext).x / paramContext.getResources().getInteger(R.integer.numColumnsLogosList);
  }
  
  public static Uri getUriFromResource(Context paramContext, int paramInt)
  {
    return Uri.parse("android.resource://" + paramContext.getPackageName() + "/" + paramInt);
  }
  
  public static boolean idIdExist(String paramString, Context paramContext)
  {
    return getIdByName(paramString, paramContext) != 0;
  }
  
  public static boolean isOnline(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return (paramContext != null) && (paramContext.getActiveNetworkInfo() != null) && (paramContext.getActiveNetworkInfo().isConnectedOrConnecting());
  }
  
  public static boolean isPackageExist(String paramString, Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = isPackageExists(paramString, paramContext);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isPackageExists(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 128);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isSmallScreen(Context paramContext)
  {
    return getDeviceSize(paramContext).x <= 480;
  }
  
  /* Error */
  public static void playSound(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokestatic 296	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   5: putstatic 298	logo/quiz/commons/DeviceUtilCommons:mp	Landroid/media/MediaPlayer;
    //   8: getstatic 298	logo/quiz/commons/DeviceUtilCommons:mp	Landroid/media/MediaPlayer;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull +28 -> 41
    //   16: getstatic 298	logo/quiz/commons/DeviceUtilCommons:mp	Landroid/media/MediaPlayer;
    //   19: invokevirtual 301	android/media/MediaPlayer:prepare	()V
    //   22: getstatic 298	logo/quiz/commons/DeviceUtilCommons:mp	Landroid/media/MediaPlayer;
    //   25: new 6	logo/quiz/commons/DeviceUtilCommons$1
    //   28: dup
    //   29: invokespecial 302	logo/quiz/commons/DeviceUtilCommons$1:<init>	()V
    //   32: invokevirtual 306	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   35: getstatic 298	logo/quiz/commons/DeviceUtilCommons:mp	Landroid/media/MediaPlayer;
    //   38: invokevirtual 309	android/media/MediaPlayer:start	()V
    //   41: return
    //   42: astore_0
    //   43: ldc_w 311
    //   46: ldc_w 313
    //   49: aload_0
    //   50: invokestatic 316	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   53: pop
    //   54: return
    //   55: astore_0
    //   56: goto -34 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	Context
    //   0	59	1	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   0	12	42	java/lang/IllegalStateException
    //   16	22	42	java/lang/IllegalStateException
    //   22	41	42	java/lang/IllegalStateException
    //   16	22	55	java/lang/Exception
  }
  
  public static int px(float paramFloat, Context paramContext)
  {
    return Math.round(paramFloat * paramContext.getResources().getDisplayMetrics().density);
  }
  
  public static Drawable resize(Drawable paramDrawable, int paramInt1, int paramInt2, Resources paramResources)
  {
    return new BitmapDrawable(paramResources, Bitmap.createScaledBitmap(((BitmapDrawable)paramDrawable).getBitmap(), paramInt1, paramInt2, false));
  }
  
  public static void showLongToast(String paramString, Context paramContext)
  {
    showToast(paramString, 1, paramContext);
  }
  
  public static void showShortToast(String paramString, Context paramContext)
  {
    showToast(paramString, 0, paramContext);
  }
  
  public static void showToast(String paramString, int paramInt, Context paramContext)
  {
    paramString = Toast.makeText(paramContext, paramString, paramInt);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/DeviceUtilCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */