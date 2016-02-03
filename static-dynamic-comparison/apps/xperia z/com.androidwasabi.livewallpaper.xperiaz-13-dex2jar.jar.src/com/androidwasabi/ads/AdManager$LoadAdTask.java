package com.androidwasabi.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import java.util.Locale;

class AdManager$LoadAdTask
  extends AsyncTask<String, Void, Boolean>
{
  protected Boolean doInBackground(String... paramVarArgs)
  {
    label392:
    do
    {
      long l2;
      for (;;)
      {
        try
        {
          boolean bool = AdManager.access$0().equals("");
          if (bool) {}
          try
          {
            l1 = AdManager.access$1().getLong("cid_request_time", 0L);
            l2 = System.currentTimeMillis();
            if (l2 < 0L) {
              AdManager.access$2("http://54.83.11.161/getcid.php");
            }
            if (l1 <= l2)
            {
              localObject = AdManager.access$2("http://54.83.11.161/getcid.php");
              if (localObject == null) {
                continue;
              }
              SharedPreferences.Editor localEditor2 = AdManager.access$1().edit();
              localEditor2.putString("cid_cache", ((String)localObject).toUpperCase(Locale.US));
              localEditor2.putLong("cid_request_time", l2 + 86400000L);
              localEditor2.commit();
            }
          }
          catch (Exception localException)
          {
            long l1;
            Object localObject;
            SharedPreferences.Editor localEditor1 = AdManager.access$1().edit();
            localEditor1.putString("cid_cache", "");
            localEditor1.commit();
            continue;
          }
          AdManager.access$3(AdManager.access$1().getString("cid_cache", ""));
          l1 = AdManager.access$1().getLong("ads_request_time", 0L);
          l2 = System.currentTimeMillis();
          if (l2 < 0L) {
            AdManager.access$2(paramVarArgs[0]);
          }
          if (l1 > l2) {
            break label392;
          }
          paramVarArgs = AdManager.access$2(paramVarArgs[0]);
          if (paramVarArgs == null) {
            break;
          }
          localObject = AdManager.access$1().edit();
          ((SharedPreferences.Editor)localObject).putString("ads_cache", paramVarArgs);
          ((SharedPreferences.Editor)localObject).putLong("ads_request_time", l2 + 14400000L);
          ((SharedPreferences.Editor)localObject).commit();
          return Boolean.valueOf(true);
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs = AdManager.access$1().edit();
          paramVarArgs.putString("ads_cache", "");
          paramVarArgs.commit();
          return Boolean.valueOf(false);
        }
        localObject = AdManager.access$1().edit();
        ((SharedPreferences.Editor)localObject).putString("cid_cache", "");
        ((SharedPreferences.Editor)localObject).putLong("cid_request_time", l2 + 86400000L);
        ((SharedPreferences.Editor)localObject).commit();
      }
      paramVarArgs = AdManager.access$1().edit();
      paramVarArgs.putString("ads_cache", "");
      paramVarArgs.putLong("ads_request_time", l2 + 14400000L);
      paramVarArgs.commit();
      return Boolean.valueOf(false);
    } while (!AdManager.access$1().getString("ads_cache", "").equals(""));
    return Boolean.valueOf(false);
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    AdManager.access$4();
    AdManager.access$5(false);
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$LoadAdTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */