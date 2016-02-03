package com.pocket.m.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.a.aa;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.db.operation.n;
import com.ideashower.readitlater.h.a;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.a.b.b;

class h
  extends n
{
  private void J()
  {
    Object[] arrayOfObject = f(2);
    arrayOfObject[0] = d.a().a;
    arrayOfObject[1] = Long.valueOf(System.currentTimeMillis() - 3600000L);
    this.h.execSQL(" DELETE FROM assets_users WHERE user = ? AND (time_updated <= ? OR time_updated IS NULL)", arrayOfObject);
  }
  
  private void K()
  {
    L();
    this.h.execSQL("DROP TABLE IF EXISTS " + "clean_item_temp");
    this.h.execSQL("CREATE TEMPORARY TABLE " + "clean_item_temp" + " (" + "unique_id" + " INTEGER NOT NULL);");
    long l = System.currentTimeMillis();
    this.h.execSQL(" INSERT INTO " + "clean_item_temp" + " SELECT " + "unique_id" + " FROM " + "items" + " WHERE " + " (" + "time_removed" + " IS NULL" + " OR " + "time_removed" + " <= " + (l - 18000000L) + ")" + " AND (" + "items.status" + " == " + 1 + " OR " + "items.status" + " == " + 2 + " OR " + "items.status" + " == " + 4 + ")" + " AND " + "hasPendingShares" + " = 0");
    if (f("clean_item_temp") > 0)
    {
      b("unique_id IN " + "clean_item_temp");
      this.h.execSQL(" DELETE FROM assets_users WHERE user IN " + "clean_item_temp");
      this.d = true;
    }
    this.h.execSQL("DROP TABLE IF EXISTS " + "clean_item_temp");
  }
  
  private void L()
  {
    if (!e.j()) {}
    int i;
    long l;
    do
    {
      return;
      i = 0;
      l = System.currentTimeMillis() - 18000000L;
      Cursor localCursor = this.h.rawQuery(" SELECT COUNT(*) as c  FROM items WHERE time_removed > " + l + " AND (" + "status" + " == " + 1 + " OR " + "status" + " == " + 2 + " OR " + "status" + " == " + 4 + ")", null);
      if (localCursor.moveToNext()) {
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("c"));
      }
      localCursor.close();
    } while (i <= 15L);
    this.h.execSQL(" UPDATE items SET time_removed = 0 WHERE time_removed > " + l + " AND (" + "status" + " == " + 1 + " OR " + "status" + " == " + 2 + " OR " + "status" + " == " + 4 + ")" + " ORDER BY " + "time_removed" + " ASC" + " LIMIT " + (i - 15L), null);
  }
  
  private void M()
  {
    if (g.e()) {
      com.ideashower.readitlater.util.e.a("CacheCleaner", "trimCache removeUnusedAssets start");
    }
    this.h.execSQL("DROP TABLE IF EXISTS " + "temp_remove_unused");
    this.h.execSQL("CREATE TEMPORARY TABLE " + "temp_remove_unused" + " (" + "asset_id" + " INTEGER NOT NULL, " + "short_path" + " VARCHAR NOT NULL);");
    this.h.execSQL("DELETE FROM " + "temp_remove_unused");
    this.h.execSQL("INSERT INTO " + "temp_remove_unused" + " SELECT DISTINCT " + "asset_id" + "," + "short_path" + " FROM " + "assets" + " " + " LEFT OUTER JOIN " + "assets_users" + " USING (" + "asset_id" + ")" + " WHERE " + "assets_users" + "." + "user" + " IS NULL" + " LIMIT " + "400");
    this.h.execSQL(" DELETE FROM assets_users WHERE user IN  (SELECT ('asset'||" + "asset_id" + ")" + " FROM " + "temp_remove_unused" + ")");
    Object localObject1 = this.h.rawQuery(" SELECT " + "short_path" + " FROM " + "temp_remove_unused" + " ORDER BY " + "short_path" + " ASC", null);
    Object localObject2 = new TreeSet(Collections.reverseOrder());
    for (int i = 0; (((Cursor)localObject1).moveToNext()) && (!e()); i = 1)
    {
      Object localObject3 = com.ideashower.readitlater.objects.d.b(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("short_path")));
      try
      {
        localObject3 = new File((String)localObject3);
        String str = ((File)localObject3).getParent();
        b.c((File)localObject3);
        if (str != null) {
          ((TreeSet)localObject2).add(str);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.ideashower.readitlater.util.e.a(localThrowable);
        }
      }
    }
    ((Cursor)localObject1).close();
    localObject1 = ((TreeSet)localObject2).iterator();
    label452:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!e()) {}
    }
    else
    {
      if (!e()) {
        break label507;
      }
    }
    for (;;)
    {
      if (g.e()) {
        com.ideashower.readitlater.util.e.a("CacheCleaner", "trimCache removeUnusedAssets STOP");
      }
      return;
      g.a((String)localObject2);
      break label452;
      label507:
      this.h.execSQL(" DELETE FROM assets WHERE asset_id IN  (SELECT " + "asset_id" + " FROM " + "temp_remove_unused" + ")");
      O();
      if (i != 0) {
        if (!e()) {
          break;
        }
      }
    }
  }
  
  private void N()
  {
    if (!as.l()) {}
    label177:
    for (;;)
    {
      return;
      i locali = P();
      this.h.execSQL("DROP TABLE IF EXISTS temp_trim_items");
      this.h.execSQL("CREATE TEMPORARY TABLE temp_trim_items (unique_id INTEGER NOT NULL);");
      M();
      j();
      if (e()) {}
      for (;;)
      {
        if (!g.e()) {
          break label177;
        }
        com.ideashower.readitlater.util.e.a("CacheCleaner", "trimCache now has free " + com.pocket.p.c.a(e.l() - e.h()));
        return;
        long l = e.f();
        if (l > 0L)
        {
          int i = Math.max((int)(l / com.pocket.p.c.a()) / 4, 1);
          a(i, locali);
          if (g.e()) {
            com.ideashower.readitlater.util.e.a("CacheCleaner", "trimCache removed " + i + " items when needing " + com.pocket.p.c.a(l));
          }
        }
        if (l > 0L) {
          if (!e()) {
            break;
          }
        }
      }
    }
  }
  
  private void O()
  {
    if (e.o()) {
      j();
    }
  }
  
  private i P()
  {
    if (com.ideashower.readitlater.h.i.a(a.P) == 1) {
      return i.b;
    }
    return i.a;
  }
  
  private String a(i parami)
  {
    if (parami == i.a) {
      return "ORDER BY time_added ASC";
    }
    return "ORDER BY time_added DESC";
  }
  
  private void a(int paramInt, i parami)
  {
    this.h.execSQL("DELETE FROM temp_trim_items");
    this.h.execSQL("INSERT INTO temp_trim_items SELECT unique_id FROM " + "items" + " WHERE " + "unique_id" + " IN (" + " SELECT " + "user" + " FROM " + "assets_users" + " )" + " " + a(parami) + " LIMIT " + paramInt);
    this.h.execSQL(" DELETE FROM " + "assets_users" + " WHERE " + "user" + " IN " + "temp_trim_items");
    this.h.execSQL(" UPDATE " + "items" + " SET " + "offline_web" + " = " + 0 + " WHERE " + "unique_id" + " IN " + "temp_trim_items" + " AND " + "offline_web" + " > 0");
    this.h.execSQL(" UPDATE " + "items" + " SET " + "offline_text" + " = " + 0 + " WHERE " + "unique_id" + " IN " + "temp_trim_items" + " AND " + "offline_text" + " > 0");
    parami = this.h.rawQuery(" SELECT unique_id FROM temp_trim_items", null);
    while (parami.moveToNext()) {
      aa.b(parami.getInt(parami.getColumnIndexOrThrow("unique_id")));
    }
    parami.close();
    this.b = true;
  }
  
  protected void A()
  {
    new com.ideashower.readitlater.g.g()
    {
      protected void a()
      {
        l.c().e();
        l.a(com.ideashower.readitlater.a.g.c().getCacheDir());
      }
    }.h();
  }
  
  protected n a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return new h();
    }
    return null;
  }
  
  protected boolean z()
  {
    J();
    if (e()) {}
    do
    {
      do
      {
        return true;
        K();
      } while (e());
      M();
    } while (e());
    N();
    return e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */