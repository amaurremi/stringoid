package com.inmobi.commons.ads.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AdDatabaseManager
{
  private static AdDatabaseManager c;
  private AdDatabaseHelper a;
  private SQLiteDatabase b;
  private int d = 1000;
  
  public static AdDatabaseManager getInstance()
  {
    try
    {
      if (c == null)
      {
        c = new AdDatabaseManager();
        c.a = new AdDatabaseHelper(InternalSDKUtil.getContext());
      }
      AdDatabaseManager localAdDatabaseManager = c;
      return localAdDatabaseManager;
    }
    finally {}
  }
  
  protected void close()
  {
    try
    {
      this.b.close();
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Failed to close ads db", localException);
    }
  }
  
  public AdData getAd(String paramString)
  {
    try
    {
      open();
      Cursor localCursor = this.b.rawQuery("SELECT * FROM ad WHERE appid = ? Order by timestamp Limit 1;", new String[] { paramString });
      localCursor.moveToFirst();
      paramString = new AdData();
      paramString.setAdId(localCursor.getLong(0));
      paramString.setTimestamp(localCursor.getLong(1));
      paramString.setAppId(localCursor.getString(2));
      paramString.setContent(localCursor.getString(3));
      localCursor.close();
      this.b.delete("ad", "adid = " + paramString.getAdId(), null);
      close();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to get native ads from db", paramString);
        paramString = null;
      }
    }
    finally {}
  }
  
  protected int getDBSize()
  {
    try
    {
      open();
      int i = this.b.rawQuery("SELECT * FROM ad; ", null).getCount();
      close();
      return i;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Failed to get native ads from db", localException);
    }
    return 0;
  }
  
  public int getNoOfAds(String paramString)
  {
    try
    {
      open();
      i = this.b.rawQuery("SELECT * FROM ad WHERE appid = ?; ", new String[] { paramString }).getCount();
      close();
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to get native ads from db", paramString);
        int i = 0;
      }
    }
    finally {}
  }
  
  public void insertAd(AdData paramAdData)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("timestamp", Long.valueOf(paramAdData.getTimestamp()));
      localContentValues.put("appid", paramAdData.getAppId());
      localContentValues.put("content", paramAdData.getContent());
      localContentValues.put("adtype", paramAdData.getAdType());
      if (getDBSize() >= this.d)
      {
        open();
        paramAdData = this.b.rawQuery("SELECT adid FROM ad WHERE timestamp= (SELECT MIN(timestamp) FROM ad Limit 1);", null);
        paramAdData.moveToFirst();
        long l = paramAdData.getLong(0);
        paramAdData.close();
        this.b.delete("ad", "adid = " + l, null);
        close();
      }
      open();
      this.b.insert("ad", null, localContentValues);
      close();
    }
    catch (Exception paramAdData)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to insert native ads to db", paramAdData);
      }
    }
    finally {}
  }
  
  protected void open()
  {
    try
    {
      this.b = this.a.getWritableDatabase();
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Failed to open ads db", localException);
    }
  }
  
  public void setDBLimit(int paramInt)
  {
    if (paramInt > 0) {
      this.d = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/ads/cache/AdDatabaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */