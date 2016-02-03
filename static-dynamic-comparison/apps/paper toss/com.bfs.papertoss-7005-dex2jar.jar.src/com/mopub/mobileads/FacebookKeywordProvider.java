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
    try
    {
      paramContext = paramContext.getContentResolver().query(ID_URL, new String[] { "aid" }, null, null, null);
      if ((paramContext != null) && (paramContext.moveToFirst()))
      {
        paramContext = paramContext.getString(paramContext.getColumnIndex("aid"));
        if ((paramContext == null) || (paramContext.length() == 0)) {
          break label123;
        }
        paramContext = "FBATTRID:" + paramContext;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.d("MoPub", "Unable to retrieve FBATTRID: " + paramContext.toString());
      return null;
    }
    return null;
    label123:
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/FacebookKeywordProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */