package com.vungle.publisher.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.vungle.publisher.aq;
import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.be;
import com.vungle.publisher.bk;
import com.vungle.publisher.di;
import com.vungle.publisher.inject.annotations.AdTempDirectory;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class DatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String[] e = { "ad", "viewable", "archive_entry", "event_tracking", "ad_report", "ad_play", "ad_report_event" };
  @Inject
  di a;
  @Inject
  be b;
  @Inject
  public ScheduledPriorityExecutor c;
  @AdTempDirectory
  @Inject
  Provider<String> d;
  
  @Inject
  public DatabaseHelper(Context paramContext)
  {
    super(paramContext, "vungle", null, 4);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = e;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Logger.d("VungleDatabase", "dropping table: " + str);
      str = "DROP TABLE  IF EXISTS " + str;
      Logger.v("VungleDatabase", str);
      paramSQLiteDatabase.execSQL(str);
      i += 1;
    }
    bk.a((String)this.d.get());
    onCreate(paramSQLiteDatabase);
  }
  
  final void a(String... paramVarArgs)
  {
    String str = this.b.b();
    Logger.d("VungleDatabaseDump", str + " sdk version VungleDroid/3.0.7, database version 4");
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length > 0) {}
    }
    else
    {
      Logger.d("VungleDatabaseDump", str + " dumping all tables");
      arrayOfString = e;
    }
    paramVarArgs = getReadableDatabase();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      Logger.i("VungleDatabaseDump", str + " dumping table " + (String)localObject);
      localObject = paramVarArgs.query((String)localObject, null, null, new String[0], null, null, null);
      StringBuilder localStringBuilder = new StringBuilder();
      DatabaseUtils.dumpCursor((Cursor)localObject, localStringBuilder);
      Logger.d("VungleDatabaseDump", localStringBuilder.toString());
      i += 1;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Logger.d("VungleDatabase", "creating database: vungle");
    Logger.d("VungleDatabase", "creating table: ad");
    Logger.v("VungleDatabase", "CREATE TABLE ad (id STRING PRIMARY KEY, advertising_app_vungle_id INTEGER, call_to_action_final_url STRING, call_to_action_url STRING, status STRING NOT NULL, type STRING NOT NULL, expiration_timestamp_seconds INTEGER, parent_path STRING, prepare_retry_count INTEGER, delete_local_content_attempts INTEGER, insert_timestamp_seconds INTEGER NOT NULL, update_timestamp_seconds INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("CREATE TABLE ad (id STRING PRIMARY KEY, advertising_app_vungle_id INTEGER, call_to_action_final_url STRING, call_to_action_url STRING, status STRING NOT NULL, type STRING NOT NULL, expiration_timestamp_seconds INTEGER, parent_path STRING, prepare_retry_count INTEGER, delete_local_content_attempts INTEGER, insert_timestamp_seconds INTEGER NOT NULL, update_timestamp_seconds INTEGER NOT NULL);");
    Logger.d("VungleDatabase", "creating table: viewable");
    Logger.v("VungleDatabase", "CREATE TABLE viewable (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_id STRING NOT NULL REFERENCES ad(id) ON DELETE CASCADE ON UPDATE CASCADE, type STRING NOT NULL, url STRING NOT NULL, status STRING NOT NULL, size INTEGER, width INTEGER, height INTEGER, show_close_delay_incentivized_seconds INTEGER, show_close_delay_interstitial_seconds INTEGER, show_countdown_delay_seconds INTEGER, cta_clickable_percent REAL, enable_cta_delay_seconds INTEGER, is_cta_enabled INTEGER, is_cta_shown_on_touch INTEGER, show_cta_delay_seconds INTEGER, checksum STRING, CONSTRAINT viewable_ad_type_uk UNIQUE (ad_id, type));");
    paramSQLiteDatabase.execSQL("CREATE TABLE viewable (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_id STRING NOT NULL REFERENCES ad(id) ON DELETE CASCADE ON UPDATE CASCADE, type STRING NOT NULL, url STRING NOT NULL, status STRING NOT NULL, size INTEGER, width INTEGER, height INTEGER, show_close_delay_incentivized_seconds INTEGER, show_close_delay_interstitial_seconds INTEGER, show_countdown_delay_seconds INTEGER, cta_clickable_percent REAL, enable_cta_delay_seconds INTEGER, is_cta_enabled INTEGER, is_cta_shown_on_touch INTEGER, show_cta_delay_seconds INTEGER, checksum STRING, CONSTRAINT viewable_ad_type_uk UNIQUE (ad_id, type));");
    Logger.d("VungleDatabase", "creating table: archive_entry");
    Logger.v("VungleDatabase", "CREATE TABLE archive_entry (id INTEGER PRIMARY KEY AUTOINCREMENT, viewable_id INTEGER NOT NULL REFERENCES viewable(id) ON DELETE CASCADE ON UPDATE CASCADE, relative_path STRING NOT NULL, size INTEGER, CONSTRAINT archive_entry_viewable_id_path_uk UNIQUE (id, relative_path));");
    paramSQLiteDatabase.execSQL("CREATE TABLE archive_entry (id INTEGER PRIMARY KEY AUTOINCREMENT, viewable_id INTEGER NOT NULL REFERENCES viewable(id) ON DELETE CASCADE ON UPDATE CASCADE, relative_path STRING NOT NULL, size INTEGER, CONSTRAINT archive_entry_viewable_id_path_uk UNIQUE (id, relative_path));");
    Logger.d("VungleDatabase", "creating table: event_tracking");
    Logger.v("VungleDatabase", "CREATE TABLE event_tracking (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_id STRING NOT NULL REFERENCES ad(id) ON DELETE CASCADE ON UPDATE CASCADE, event INTEGER NOT NULL, url INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("CREATE TABLE event_tracking (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_id STRING NOT NULL REFERENCES ad(id) ON DELETE CASCADE ON UPDATE CASCADE, event INTEGER NOT NULL, url INTEGER NOT NULL);");
    Logger.d("VungleDatabase", "creating table: ad_report");
    Logger.v("VungleDatabase", "CREATE TABLE ad_report (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_id STRING NOT NULL REFERENCES ad(id) ON DELETE CASCADE ON UPDATE CASCADE, incentivized_publisher_app_user_id STRING, is_incentivized INTEGER NOT NULL, status STRING NOT NULL, video_duration_millis INTEGER, view_end_millis INTEGER, view_start_millis INTEGER, download_end_millis INTEGER, insert_timestamp_millis INTEGER NOT NULL, update_timestamp_millis INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("CREATE TABLE ad_report (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_id STRING NOT NULL REFERENCES ad(id) ON DELETE CASCADE ON UPDATE CASCADE, incentivized_publisher_app_user_id STRING, is_incentivized INTEGER NOT NULL, status STRING NOT NULL, video_duration_millis INTEGER, view_end_millis INTEGER, view_start_millis INTEGER, download_end_millis INTEGER, insert_timestamp_millis INTEGER NOT NULL, update_timestamp_millis INTEGER NOT NULL);");
    Logger.d("VungleDatabase", "creating table: ad_play");
    Logger.v("VungleDatabase", "CREATE TABLE ad_play (id INTEGER PRIMARY KEY AUTOINCREMENT, report_id INTEGER NOT NULL REFERENCES ad_report(id) ON DELETE CASCADE ON UPDATE CASCADE, start_millis INTEGER, watched_millis INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE ad_play (id INTEGER PRIMARY KEY AUTOINCREMENT, report_id INTEGER NOT NULL REFERENCES ad_report(id) ON DELETE CASCADE ON UPDATE CASCADE, start_millis INTEGER, watched_millis INTEGER);");
    Logger.d("VungleDatabase", "creating table: ad_report_event");
    Logger.v("VungleDatabase", "CREATE TABLE ad_report_event (id INTEGER PRIMARY KEY AUTOINCREMENT, play_id INTEGER NOT NULL REFERENCES ad_play(id) ON DELETE CASCADE ON UPDATE CASCADE, event STRING NOT NULL, insert_timestamp_millis INTEGER NOT NULL, value STRING);");
    paramSQLiteDatabase.execSQL("CREATE TABLE ad_report_event (id INTEGER PRIMARY KEY AUTOINCREMENT, play_id INTEGER NOT NULL REFERENCES ad_play(id) ON DELETE CASCADE ON UPDATE CASCADE, event STRING NOT NULL, insert_timestamp_millis INTEGER NOT NULL, value STRING);");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Logger.d("VungleDatabase", "downgrading databse version " + paramInt1 + " --> " + paramInt2);
    a(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    Logger.d("VungleDatabase", "enabling foreign keys");
    paramSQLiteDatabase.execSQL("PRAGMA foreign_keys = true");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Logger.d("VungleDatabase", "upgrading database version " + paramInt1 + " --> " + paramInt2);
    a(paramSQLiteDatabase);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/DatabaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */