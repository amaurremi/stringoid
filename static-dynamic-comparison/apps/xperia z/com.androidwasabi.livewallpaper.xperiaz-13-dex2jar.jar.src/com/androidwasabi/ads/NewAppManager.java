package com.androidwasabi.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.io.File;
import java.util.Locale;
import java.util.Random;

public class NewAppManager
{
  public static final String APP_CACHE = "app_cache";
  public static final int APP_FETCHING_TIME = 24;
  public static final int APP_PERCENTAGE_HIGH = 50;
  public static final int APP_PERCENTAGE_LOW = 25;
  public static final int APP_PERCENTAGE_MAX = 100;
  public static final int APP_PERCENTAGE_MEDIUM = 30;
  public static final String APP_REQUEST_TIME = "app_request_time";
  private static final int IMAGE_CACHING_TIME = 14;
  public static final String SHARED_PREFS_NAME = "wasabi_app_settings";
  public static final String TAG = "NewAppManager";
  private static NewAppManager.AppItem[] apps;
  private static String baseUrl = "https://d21aw2xov4zz0i.cloudfront.net/android/new/wasabi/default";
  private static File cacheDir;
  public static final boolean debug = false;
  private static boolean loading = false;
  private static NewAppManager.OnNewAppListener newAppListener;
  private static SharedPreferences prefs;
  private static boolean useCache = false;
  
  public static void load(Context paramContext, int paramInt)
  {
    prefs = paramContext.getSharedPreferences("wasabi_app_settings", 0);
    setCache(true, paramContext.getCacheDir());
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
      {
        paramContext = Boolean.valueOf(false);
        if (!paramContext.booleanValue()) {
          break label66;
        }
      }
      label66:
      do
      {
        return;
        paramContext = Boolean.valueOf(true);
        break;
        paramInt = 100 / paramInt;
      } while ((new Random().nextInt(paramInt) != 0) || (loading));
      loading = true;
      paramContext = Locale.getDefault().getLanguage();
      if (paramContext.equals("da")) {
        paramContext = "/new_da.json";
      }
      for (;;)
      {
        paramContext = baseUrl + paramContext;
        new NewAppManager.LoadNewAppTask().execute(new String[] { paramContext });
        return;
        if (paramContext.equals("de")) {
          paramContext = "/new_de.json";
        } else if (paramContext.equals("es")) {
          paramContext = "/new_es.json";
        } else if (paramContext.equals("fr")) {
          paramContext = "/new_fr.json";
        } else if (paramContext.equals("it")) {
          paramContext = "/new_it.json";
        } else if (paramContext.equals("ja")) {
          paramContext = "/new_ja.json";
        } else if (paramContext.equals("ko")) {
          paramContext = "/new_ko.json";
        } else if (paramContext.equals("nl")) {
          paramContext = "/new_nl.json";
        } else if (paramContext.equals("no")) {
          paramContext = "/new_no.json";
        } else if (paramContext.equals("pl")) {
          paramContext = "/new_pl.json";
        } else if (paramContext.equals("pt")) {
          paramContext = "/new_pt.json";
        } else if (paramContext.equals("ru")) {
          paramContext = "/new_ru.json";
        } else if (paramContext.equals("sv")) {
          paramContext = "/new_sv.json";
        } else if (paramContext.equals("zh")) {
          paramContext = "/new_zh.json";
        } else {
          paramContext = "/new_en.json";
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void setCache(boolean paramBoolean, File paramFile)
  {
    useCache = paramBoolean;
    cacheDir = paramFile;
  }
  
  public static void setListener(NewAppManager.OnNewAppListener paramOnNewAppListener)
  {
    newAppListener = paramOnNewAppListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/NewAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */