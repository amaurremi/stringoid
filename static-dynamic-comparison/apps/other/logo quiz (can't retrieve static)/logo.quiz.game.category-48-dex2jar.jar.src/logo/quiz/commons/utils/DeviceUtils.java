package logo.quiz.commons.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;
import logo.quiz.commons.R.bool;

public class DeviceUtils
{
  public static int deviceScale(int paramInt, Context paramContext)
  {
    int i = paramInt;
    if (isTablet(paramContext)) {
      i = (int)(paramInt * 1.3F);
    }
    return i;
  }
  
  public static String getStringResourceByName(String paramString, Context paramContext)
  {
    Object localObject = null;
    int i = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    paramString = (String)localObject;
    if (i != 0) {}
    try
    {
      paramString = paramContext.getString(i);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String getStringResourceByNameForLocale(String paramString1, String paramString2, Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    Configuration localConfiguration = localResources.getConfiguration();
    String str1 = localConfiguration.locale.getLanguage();
    String str2 = localConfiguration.locale.getCountry();
    localConfiguration.locale = new Locale(paramString2);
    localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
    paramString1 = getStringResourceByName(paramString1, paramContext);
    localConfiguration.locale = new Locale(str1, str2);
    localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
    return paramString1;
  }
  
  public static boolean isFirstRun(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("FIRST_RUN", true);
  }
  
  public static boolean isSmallScreen(Context paramContext)
  {
    return paramContext.getResources().getBoolean(R.bool.is_small_screen);
  }
  
  public static boolean isTablet(Context paramContext)
  {
    boolean bool1 = false;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    int j = localSharedPreferences.getInt("IS_TABLET", 1);
    int i = j;
    if (j == 1)
    {
      i = 1;
      if (((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType() == 0) {
        i = 0;
      }
      boolean bool2 = paramContext.getResources().getBoolean(R.bool.isTablet);
      if ((i != 0) && (!bool2)) {
        break label104;
      }
    }
    label104:
    for (i = 10;; i = 0)
    {
      paramContext = localSharedPreferences.edit();
      paramContext.putInt("IS_TABLET", i);
      paramContext.commit();
      if (i == 10) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static void turnOffFirstRun(Context paramContext)
  {
    if (isFirstRun(paramContext))
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putBoolean("FIRST_RUN", false);
      paramContext.commit();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */