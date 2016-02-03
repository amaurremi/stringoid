package com.ideashower.readitlater.db.a;

public class a
{
  public static String a(String paramString)
  {
    return "CREATE TEMPORARY TABLE " + paramString + " " + " (unique_id INTEGER NOT NULL, item_id INTEGER NOT NULL, resolved_id INTEGER NOT NULL, given_url VARCHAR NOT NULL, given_normal_url VARCHAR NOT NULL, url VARCHAR, url_normal VARCHAR, domain VARCHAR, title VARCHAR NOT NULL, time_added INTEGER NOT NULL, excerpt VARCHAR, image VARCHAR, video VARCHAR, is_article INTEGER, word_count INTEGER, offline_web INTEGER NOT NULL, offline_text INTEGER NOT NULL, encoding VARCHAR, mime VARCHAR, favorite INTEGER NOT NULL, time_added_to_device INTEGER NOT NULL, status INTEGER, hasPendingShares INTEGER, badge_group_id INTEGER, carousel_view_count INTEGER, time_removed INTEGER );";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */