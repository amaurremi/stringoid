package com.ideashower.readitlater.db.operation;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;

class e
  extends SQLiteOpenHelper
{
  e(Context paramContext)
  {
    super(paramContext, "ril", null, 560);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    a("url_normal", "items", paramSQLiteDatabase, false);
    a("given_url", "items", paramSQLiteDatabase, false);
    a("url", "items", paramSQLiteDatabase, false);
    a("offline_web", "items", paramSQLiteDatabase, false);
    a("offline_text", "items", paramSQLiteDatabase, false);
    a("is_article", "items", paramSQLiteDatabase, false);
    a("image", "items", paramSQLiteDatabase, false);
    a("video", "items", paramSQLiteDatabase, false);
    a("time_added", "items", paramSQLiteDatabase, false);
    a("time_added_to_device", "items", paramSQLiteDatabase, false);
  }
  
  private void a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("CREATE ");
    if (paramBoolean) {}
    for (String str = "UNIQUE ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "INDEX idx_" + paramString1 + " ON " + paramString2 + " (" + paramString1 + " ASC)");
      return;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("CREATE TABLE sync_queue (action VARCHAR, send_asap INTEGER);");
      paramSQLiteDatabase.execSQL("CREATE TABLE items  (unique_id INTEGER NOT NULL, item_id INTEGER NOT NULL, resolved_id INTEGER NOT NULL, given_url VARCHAR NOT NULL, given_normal_url VARCHAR NOT NULL, url VARCHAR, url_normal VARCHAR, domain VARCHAR, title VARCHAR NOT NULL, time_added INTEGER NOT NULL, excerpt VARCHAR, image VARCHAR, video VARCHAR, is_article INTEGER, word_count INTEGER, offline_web INTEGER NOT NULL, offline_text INTEGER NOT NULL, encoding VARCHAR, mime VARCHAR, favorite INTEGER NOT NULL, time_added_to_device INTEGER NOT NULL, status INTEGER, hasPendingShares INTEGER, badge_group_id INTEGER, carousel_view_count INTEGER, time_removed INTEGER );");
      paramSQLiteDatabase.execSQL("CREATE TABLE item_tags (unique_id INTEGER NOT NULL, tag VARCHAR NOT NULL, PRIMARY KEY(unique_id, tag));");
      paramSQLiteDatabase.execSQL("CREATE TABLE tags (tag VARCHAR);");
      paramSQLiteDatabase.execSQL("CREATE TABLE scroll (unique_id INTEGER NOT NULL, view INTEGER NOT NULL, page INTEGER NOT NULL, node_index INTEGER NOT NULL, percent INTEGER NOT NULL, time_updated INTEGER NOT NULL, section INTEGER, PRIMARY KEY (unique_id, view));");
      paramSQLiteDatabase.execSQL("CREATE TABLE assets (asset_id INTEGER PRIMARY KEY,bytes INTEGER NOT NULL,short_path VARCHAR NOT NULL, UNIQUE (short_path) ON CONFLICT IGNORE);");
      paramSQLiteDatabase.execSQL("CREATE TABLE assets_users (asset_id INTEGER NOT NULL, user VARCHAR NOT NULL, time_updated INTEGER, PRIMARY KEY (asset_id, user));");
      paramSQLiteDatabase.execSQL("CREATE TABLE item_authors (unique_id INTEGER, author_id INTEGER, name VARCHAR, url VARCHAR, PRIMARY KEY (unique_id, author_id))");
      paramSQLiteDatabase.execSQL("CREATE TABLE item_images (unique_id INTEGER NOT NULL, image_id INTEGER NOT NULL, src TEXT, caption TEXT, credit TEXT, width INTEGER, height INTEGER, PRIMARY KEY (unique_id, image_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE items_videos (unique_id INTEGER NOT NULL, video_id INTEGER NOT NULL, src TEXT, type INTEGER NOT NULL, width INTEGER NOT NULL, height INTEGER NOT NULL, vid VARCHAR, PRIMARY KEY (unique_id, video_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE item_highlights (unique_id INTEGER NOT NULL, group_id INTEGER NOT NULL, sort REAL NOT NULL, PRIMARY KEY(unique_id, group_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE item_carousel (unique_id INTEGER NOT NULL, group_id INTEGER NOT NULL, sort REAL NOT NULL, PRIMARY KEY(unique_id, group_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE shared_items  (share_id INTEGER NOT NULL, from_friend_id INTEGER, unique_id INTEGER, comment VARCHAR, quote VARCHAR, time_shared INTEGER NOT NULL, time_ignored INTEGER NOT NULL, status INTEGER, viewed INTEGER );");
      paramSQLiteDatabase.execSQL("CREATE TABLE tweet_items  (tweet_id INTEGER NOT NULL, unique_id INTEGER, tweet_text VARCHAR, tweet_date INTEGER, tweet_userhandle VARCHAR, tweet_username VARCHAR, tweet_user_image_url VARCHAR, tweet_url_entities VARCHAR, tweet_mention_entities VARCHAR, tweet_hashtag_entities VARCHAR, tweet_media_entities VARCHAR, PRIMARY KEY (unique_id, tweet_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE unconfirmed_shares (email VARCHAR, friend VARCHAR);");
      paramSQLiteDatabase.execSQL("CREATE TABLE friends  (local_friend_id INTEGER PRIMARY KEY  NOT NULL, friend_id INTEGER, name VARCHAR, username VARCHAR, avatar_url VARCHAR, last_share_time INTEGER );");
      paramSQLiteDatabase.execSQL("CREATE TABLE ac_emails  (local_friend_id INTEGER NOT NULL, email VARCHAR, PRIMARY KEY (local_friend_id, email));");
      paramSQLiteDatabase.execSQL("CREATE TABLE highlights (group_id INTEGER NOT NULL, sort REAL NOT NULL, PRIMARY KEY(group_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE recent_search (search VARCHAR NOT NULL, search_normal VARCHAR NOT NULL, cxt_key VARCHAR NOT NULL, cxt_val VARCHAR NOT NULL, sort_id INTEGER NOT NULL, UNIQUE (search_normal,cxt_key,cxt_val) ON CONFLICT REPLACE);");
      paramSQLiteDatabase.execSQL("CREATE TABLE list_meta (unique_id INTEGER NOT NULL ,meta_id VARCHAR NOT NULL ,value VARCHAR, PRIMARY KEY (unique_id, meta_id));");
      a(paramSQLiteDatabase);
      a("unique_id", "shared_items", paramSQLiteDatabase, false);
      a("tag", "tags", paramSQLiteDatabase, true);
      paramSQLiteDatabase.execSQL("CREATE TABLE vars (var_key VARCHAR NOT NULL UNIQUE, var_value VARCHAR NOT NULL,PRIMARY KEY (var_key));");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      g.s().a(paramSQLiteDatabase);
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 7)
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE items ADD COLUMN status INTEGER");
      paramSQLiteDatabase.execSQL("UPDATE items SET status = 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE items ADD COLUMN hasPendingShares INTEGER");
      paramSQLiteDatabase.execSQL("UPDATE items SET hasPendingShares = 0");
      paramSQLiteDatabase.execSQL("CREATE TABLE shared_items  (share_id INTEGER NOT NULL, from_friend_id INTEGER, unique_id INTEGER, comment VARCHAR, quote VARCHAR, time_shared INTEGER NOT NULL, time_ignored INTEGER NOT NULL, status INTEGER, viewed INTEGER );");
      a("unique_id", "shared_items", paramSQLiteDatabase, false);
      paramSQLiteDatabase.execSQL("CREATE TABLE friends  (local_friend_id INTEGER PRIMARY KEY  NOT NULL, friend_id INTEGER, name VARCHAR, username VARCHAR, avatar_url VARCHAR, last_share_time INTEGER );");
      paramSQLiteDatabase.execSQL("CREATE TABLE ac_emails  (local_friend_id INTEGER NOT NULL, email VARCHAR, PRIMARY KEY (local_friend_id, email));");
      paramSQLiteDatabase.execSQL("CREATE TABLE unconfirmed_shares (email VARCHAR, friend VARCHAR);");
      paramSQLiteDatabase.execSQL("ALTER TABLE sync_queue ADD COLUMN send_asap INTEGER");
    }
    if (paramInt1 < 10) {
      paramSQLiteDatabase.execSQL("CREATE TABLE tweet_items  (tweet_id INTEGER NOT NULL, unique_id INTEGER, tweet_text VARCHAR, tweet_date INTEGER, tweet_userhandle VARCHAR, tweet_username VARCHAR, tweet_user_image_url VARCHAR, tweet_url_entities VARCHAR, tweet_mention_entities VARCHAR, tweet_hashtag_entities VARCHAR, tweet_media_entities VARCHAR, PRIMARY KEY (unique_id, tweet_id));");
    }
    if (paramInt1 < 251)
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE items RENAME TO tmp_items_for_upgrade");
      paramSQLiteDatabase.execSQL("CREATE TABLE items  (unique_id INTEGER NOT NULL, item_id INTEGER NOT NULL, resolved_id INTEGER NOT NULL, given_url VARCHAR NOT NULL, given_normal_url VARCHAR NOT NULL, url VARCHAR, url_normal VARCHAR, domain VARCHAR, title VARCHAR NOT NULL, time_added INTEGER NOT NULL, excerpt VARCHAR, image VARCHAR, video VARCHAR, is_article INTEGER, word_count INTEGER, offline_web INTEGER NOT NULL, offline_text INTEGER NOT NULL, encoding VARCHAR, mime VARCHAR, favorite INTEGER NOT NULL, time_added_to_device INTEGER NOT NULL, status INTEGER, hasPendingShares INTEGER );");
      paramSQLiteDatabase.execSQL("INSERT INTO items SELECT * FROM tmp_items_for_upgrade");
      paramSQLiteDatabase.execSQL("DROP TABLE tmp_items_for_upgrade");
      a(paramSQLiteDatabase);
    }
    if (paramInt1 < 500)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE item_carousel (unique_id INTEGER NOT NULL, group_id INTEGER NOT NULL, sort REAL NOT NULL, PRIMARY KEY(unique_id, group_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE highlights (group_id INTEGER NOT NULL, sort REAL NOT NULL, PRIMARY KEY(group_id));");
      paramSQLiteDatabase.execSQL("CREATE TABLE item_highlights (unique_id INTEGER NOT NULL, group_id INTEGER NOT NULL, sort REAL NOT NULL, PRIMARY KEY(unique_id, group_id));");
      paramSQLiteDatabase.execSQL("ALTER TABLE items ADD COLUMN badge_group_id INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE items ADD COLUMN carousel_view_count INTEGER");
    }
    if (paramInt1 < 550) {
      paramSQLiteDatabase.execSQL("CREATE TABLE recent_search (search VARCHAR NOT NULL, search_normal VARCHAR NOT NULL, cxt_key VARCHAR NOT NULL, cxt_val VARCHAR NOT NULL, sort_id INTEGER NOT NULL, UNIQUE (search_normal,cxt_key,cxt_val) ON CONFLICT REPLACE);");
    }
    if (paramInt1 < 560)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE assets");
      paramSQLiteDatabase.execSQL("DROP TABLE assets_items");
      paramSQLiteDatabase.execSQL("CREATE TABLE assets (asset_id INTEGER PRIMARY KEY,bytes INTEGER NOT NULL,short_path VARCHAR NOT NULL, UNIQUE (short_path) ON CONFLICT IGNORE);");
      paramSQLiteDatabase.execSQL("CREATE TABLE assets_users (asset_id INTEGER NOT NULL, user VARCHAR NOT NULL, time_updated INTEGER, PRIMARY KEY (asset_id, user));");
      paramSQLiteDatabase.execSQL("ALTER TABLE items ADD COLUMN time_removed INTEGER");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */