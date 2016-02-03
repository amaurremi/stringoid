package com.mopub.mobileads;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class FacebookKeywordProvider
{
  private static final String ID_COLUMN_NAME = "aid";
  private static final String ID_PREFIX = "FBATTRID:";
  private static final Uri ID_URL = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  
  public static String getKeyword(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      paramContext = paramContext.getContentResolver().query(ID_URL, new String[] { "aid" }, null, null, null);
      if (paramContext != null)
      {
        localObject1 = paramContext;
        localObject2 = paramContext;
        boolean bool = paramContext.moveToFirst();
        if (bool) {}
      }
      else
      {
        if (paramContext != null) {
          paramContext.close();
        }
        localObject1 = null;
      }
      do
      {
        return (String)localObject1;
        localObject1 = paramContext;
        localObject2 = paramContext;
        String str = paramContext.getString(paramContext.getColumnIndex("aid"));
        if (str != null)
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          int i = str.length();
          if (i != 0) {}
        }
        else
        {
          if (paramContext != null) {
            paramContext.close();
          }
          return null;
        }
        localObject1 = paramContext;
        localObject2 = paramContext;
        str = "FBATTRID:" + str;
        localObject2 = str;
        localObject1 = localObject2;
      } while (paramContext == null);
      paramContext.close();
      return (String)localObject2;
    }
    catch (Exception paramContext)
    {
      localObject2 = localObject1;
      Log.d("MoPub", "Unable to retrieve FBATTRID: " + paramContext.toString());
      return null;
    }
    finally
    {
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/FacebookKeywordProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */