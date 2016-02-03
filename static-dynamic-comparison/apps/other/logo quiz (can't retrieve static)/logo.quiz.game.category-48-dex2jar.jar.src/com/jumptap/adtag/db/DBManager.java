package com.jumptap.adtag.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import com.jumptap.adtag.events.EventType;
import com.jumptap.adtag.events.JtEvent;
import com.jumptap.adtag.media.VideoCacheItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBManager
{
  private static final String ADID_COLUMN = "adid";
  private static final String CREATE_PENDING_EVENTS_QUERY = "CREATE TABLE IF NOT EXISTS pending_events(id INTEGER PRIMARY KEY, eventType TEXT, date TEXT, url TEXT);";
  private static final String CREATE_VIDEO_CACHE_QUERY = "CREATE TABLE IF NOT EXISTS video_cache(id INTEGER PRIMARY KEY, adid INTEGER,date TEXT);";
  private static final String DATABASE_NAME = "jt_ad_view.db";
  private static final int DATABASE_VERSION = 5;
  private static final String DATE_COLUMN = "date";
  private static final String DROP_QUERY = "DROP TABLE IF EXISTS pending_events; DROP TABLE IF EXISTS video_cache;";
  private static final String EVENT_TYPE_COLUMN = "eventType";
  private static final String ID_COLUMN = "id";
  private static final String INSERT_EVENT_QUERY = "insert into pending_events(eventType,date,url) values (?,?,?)";
  private static final String INSERT_VIDEO_CACHE_QUERY = "insert into video_cache(adid,date) values (?,?)";
  private static final String PENDING_EVENTS_TABLE_NAME = "pending_events";
  private static final String URL_COLUMN = "url";
  private static final String VIDEO_CACHE_TABLE_NAME = "video_cache";
  private static DBManager dbManagerInstance;
  private Context context;
  private SQLiteDatabase db;
  private SQLiteStatement insertStmt;
  
  private DBManager(Context paramContext)
  {
    this.context = paramContext;
    openDB();
  }
  
  public static DBManager getInstance(Context paramContext)
  {
    if (dbManagerInstance == null) {
      dbManagerInstance = new DBManager(paramContext);
    }
    return dbManagerInstance;
  }
  
  private void openDB()
  {
    this.db = new JtSQLiteOpenHelper(this.context).getWritableDatabase();
  }
  
  public void close()
  {
    this.db.close();
  }
  
  public void deleteAllPendingEvents()
  {
    synchronized (dbManagerInstance)
    {
      try
      {
        if (!this.db.isOpen()) {
          openDB();
        }
        this.db.delete("pending_events", null, null);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Log.d("JtAd", "Failed to delete all pending events table", localIllegalStateException);
        }
      }
      return;
    }
  }
  
  public void deleteAllVideoCacheItems()
  {
    synchronized (dbManagerInstance)
    {
      try
      {
        if (!this.db.isOpen()) {
          openDB();
        }
        this.db.delete("video_cache", null, null);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Log.d("JtAd", "Failed to delete all video cache items table", localIllegalStateException);
        }
      }
      return;
    }
  }
  
  public void deleteEventById(int paramInt)
  {
    synchronized (dbManagerInstance)
    {
      try
      {
        if (!this.db.isOpen()) {
          openDB();
        }
        this.db.delete("pending_events", "id=?", new String[] { Integer.toString(paramInt) });
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Log.d("JtAd", "Failed to delete event by id=" + paramInt, localIllegalStateException);
        }
      }
      return;
    }
  }
  
  public void deleteVideoCacheItemByAdId(String paramString)
  {
    synchronized (dbManagerInstance)
    {
      try
      {
        if (!this.db.isOpen()) {
          openDB();
        }
        this.db.delete("video_cache", "adid=?", new String[] { paramString });
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Log.d("JtAd", "Failed to delete video chache item by adid=" + paramString, localIllegalStateException);
        }
      }
      return;
    }
  }
  
  public void deleteVideoCacheItemById(int paramInt)
  {
    synchronized (dbManagerInstance)
    {
      try
      {
        if (!this.db.isOpen()) {
          openDB();
        }
        this.db.delete("video_cache", "id=?", new String[] { Integer.toString(paramInt) });
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Log.d("JtAd", "Failed to delete video chache item by id=" + paramInt, localIllegalStateException);
        }
      }
      return;
    }
  }
  
  public long insertEvent(JtEvent paramJtEvent)
  {
    synchronized (dbManagerInstance)
    {
      if (!this.db.isOpen()) {
        openDB();
      }
      this.insertStmt = this.db.compileStatement("insert into pending_events(eventType,date,url) values (?,?,?)");
      this.insertStmt.bindString(1, paramJtEvent.getEventType().name());
      this.insertStmt.bindString(2, paramJtEvent.getDate());
      this.insertStmt.bindString(3, paramJtEvent.getUrl());
      long l = this.insertStmt.executeInsert();
      return l;
    }
  }
  
  public long insertVideoCacheItem(VideoCacheItem paramVideoCacheItem)
  {
    synchronized (dbManagerInstance)
    {
      if (!this.db.isOpen()) {
        openDB();
      }
      this.insertStmt = this.db.compileStatement("insert into video_cache(adid,date) values (?,?)");
      this.insertStmt.bindString(1, paramVideoCacheItem.getAdID());
      this.insertStmt.bindString(2, paramVideoCacheItem.getDate());
      long l = this.insertStmt.executeInsert();
      return l;
    }
  }
  
  public List<JtEvent> selectAllEvents()
  {
    localDBManager = dbManagerInstance;
    Cursor localCursor = null;
    localObject4 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject1 = localObject10;
    localObject5 = localCursor;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        localObject1 = localObject10;
        localObject5 = localCursor;
        if (!this.db.isOpen())
        {
          localObject1 = localObject10;
          localObject5 = localCursor;
          openDB();
        }
        localObject1 = localObject10;
        localObject5 = localCursor;
        localCursor = this.db.query("pending_events", new String[] { "id", "eventType", "date", "url" }, null, null, null, null, "id asc");
        localObject1 = localObject10;
        localObject5 = localCursor;
        bool = localCursor.moveToFirst();
        if (bool) {
          localObject1 = localObject9;
        }
      }
      finally
      {
        ArrayList localArrayList;
        boolean bool;
        int i;
        localObject4 = localObject3;
        localObject3 = localObject8;
        if ((localObject5 != null) && (!((Cursor)localObject5).isClosed())) {
          ((Cursor)localObject5).close();
        }
        if ((localObject4 != null) && (((List)localObject4).size() > 10))
        {
          localObject4 = ((List)localObject4).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            deleteEventById(((Integer)((Iterator)localObject4).next()).intValue());
            continue;
            return localArrayList;
          }
        }
      }
      try
      {
        i = localCursor.getInt(0);
        if (localCursor.getString(1) != null)
        {
          localObject4 = EventType.valueOf(localCursor.getString(1));
          localObject5 = localCursor.getString(2);
          localArrayList.add(new JtEvent(i, localCursor.getString(3), (EventType)localObject4, (String)localObject5));
          localObject4 = localObject1;
          localObject1 = localObject4;
          localObject5 = localCursor;
          bool = localCursor.moveToNext();
          localObject1 = localObject4;
          if (bool) {
            continue;
          }
          if (localCursor != null) {}
          try
          {
            if (!localCursor.isClosed()) {
              localCursor.close();
            }
            if ((localObject4 == null) || (((List)localObject4).size() <= 10)) {
              continue;
            }
            localObject1 = ((List)localObject4).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            deleteEventById(((Integer)((Iterator)localObject1).next()).intValue());
            continue;
            if (localObject2 != null) {
              break label459;
            }
          }
          finally {}
        }
        localObject4 = new ArrayList();
      }
      finally
      {
        localObject4 = localObject3;
        localObject3 = localObject6;
        Object localObject7 = localObject8;
        continue;
        localObject4 = localObject3;
        continue;
      }
      localObject3 = localObject4;
      localObject5 = localCursor;
      ((List)localObject4).add(new Integer(i));
    }
  }
  
  public List<VideoCacheItem> selectAllVideoCacheItems()
  {
    synchronized (dbManagerInstance)
    {
      ArrayList localArrayList = new ArrayList();
      if (!this.db.isOpen()) {
        openDB();
      }
      Cursor localCursor = this.db.query("video_cache", new String[] { "id", "adid", "date" }, null, null, null, null, "id desc");
      if (localCursor.moveToFirst()) {
        do
        {
          localArrayList.add(new VideoCacheItem(localCursor.getInt(0), localCursor.getString(1), localCursor.getString(2)));
        } while (localCursor.moveToNext());
      }
      if ((localCursor != null) && (!localCursor.isClosed())) {
        localCursor.close();
      }
      return localArrayList;
    }
  }
  
  private static class JtSQLiteOpenHelper
    extends SQLiteOpenHelper
  {
    JtSQLiteOpenHelper(Context paramContext)
    {
      super("jt_ad_view.db", null, 5);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.w("JtAd", "Creating database.");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pending_events(id INTEGER PRIMARY KEY, eventType TEXT, date TEXT, url TEXT);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS video_cache(id INTEGER PRIMARY KEY, adid INTEGER,date TEXT);");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.w("JtAd", "Upgrading database, this will drop tables and recreate.");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS pending_events; DROP TABLE IF EXISTS video_cache;");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/db/DBManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */