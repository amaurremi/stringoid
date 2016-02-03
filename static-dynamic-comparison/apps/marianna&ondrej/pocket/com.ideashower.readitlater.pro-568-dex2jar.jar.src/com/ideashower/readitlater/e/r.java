package com.ideashower.readitlater.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.a.aa;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class r
  extends p
{
  public static e a(int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    return a(a(com.pocket.list.adapter.data.k.a(paramInt), paramSQLiteDatabase, null));
  }
  
  private static e a(h paramh)
  {
    if (paramh.isEmpty()) {}
    for (paramh = null;; paramh = (o)paramh.get(0)) {
      return (e)paramh;
    }
  }
  
  public static e a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    return a(a(com.pocket.list.adapter.data.k.a(paramString), paramSQLiteDatabase, null));
  }
  
  public static h a(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, SQLiteDatabase paramSQLiteDatabase, com.ideashower.readitlater.d.a parama)
  {
    h localh = new h();
    if ((parama != null) && (parama.a_()))
    {
      paramReadOnlyItemQuery = null;
      return paramReadOnlyItemQuery;
    }
    Object localObject1 = null;
    Object localObject5 = new ArrayList();
    Object localObject2;
    label117:
    Object localObject3;
    if (paramReadOnlyItemQuery.H() != null)
    {
      localObject2 = o.h(paramReadOnlyItemQuery.H());
      localObject1 = com.ideashower.readitlater.db.operation.w.a(null, "(i.given_normal_url = ? OR i.url_normal = ?)");
      ((ArrayList)localObject5).add(localObject2);
      ((ArrayList)localObject5).add(localObject2);
      localObject2 = localObject1;
      if (paramReadOnlyItemQuery.F() != null)
      {
        localObject2 = localObject1;
        if (paramReadOnlyItemQuery.F().longValue() != 0L)
        {
          if (paramReadOnlyItemQuery.j() != 1) {
            break label902;
          }
          localObject2 = " < ";
          localObject2 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, "i.time_added" + (String)localObject2 + "? ");
          ((ArrayList)localObject5).add(Long.valueOf(paramReadOnlyItemQuery.F().longValue()));
        }
      }
      localObject3 = localObject2;
      if (!org.apache.a.c.k.c(paramReadOnlyItemQuery.x()))
      {
        localObject1 = "%" + paramReadOnlyItemQuery.x() + "%";
        localObject3 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject2, "i.title LIKE ? OR  i.url LIKE ? OR  i.given_url LIKE ? ");
        ((ArrayList)localObject5).add(localObject1);
        ((ArrayList)localObject5).add(localObject1);
        ((ArrayList)localObject5).add(localObject1);
      }
      localObject1 = localObject3;
      if (paramReadOnlyItemQuery.u() != null)
      {
        localObject2 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject3, "i.favorite = ?");
        if (!paramReadOnlyItemQuery.u().booleanValue()) {
          break label909;
        }
        localObject1 = "1";
        label275:
        ((ArrayList)localObject5).add(localObject1);
        localObject1 = localObject2;
      }
      if (org.apache.a.c.k.c(paramReadOnlyItemQuery.A())) {
        break label1236;
      }
      if (!paramReadOnlyItemQuery.A().equals("_untagged_")) {
        break label916;
      }
      localObject2 = "" + " LEFT JOIN item_tags t ON (t.unique_id = i.unique_id) ";
      localObject1 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, "t.tag IS NULL");
    }
    for (;;)
    {
      label340:
      int i;
      if (paramReadOnlyItemQuery.h())
      {
        i = 1;
        localObject3 = (String)localObject2 + " JOIN shared_items si ON (si.unique_id = i.unique_id) ";
        if (paramReadOnlyItemQuery.i() < 0) {
          if (paramReadOnlyItemQuery.i() == -1)
          {
            localObject1 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, "si.status = ? OR si.status = ?");
            ((ArrayList)localObject5).add(Integer.valueOf(0));
            ((ArrayList)localObject5).add(Integer.valueOf(2));
          }
        }
      }
      for (;;)
      {
        label415:
        Object localObject4 = localObject1;
        if (paramReadOnlyItemQuery.C() != null) {}
        switch (paramReadOnlyItemQuery.C().intValue())
        {
        default: 
          localObject2 = null;
          label463:
          localObject4 = localObject1;
          if (localObject2 != null) {
            localObject4 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, (String)localObject2);
          }
          localObject1 = localObject4;
          if (paramReadOnlyItemQuery.e() != null)
          {
            localObject1 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject4, "  i.status = ?");
            ((ArrayList)localObject5).add(Integer.valueOf(paramReadOnlyItemQuery.e().intValue()));
          }
          if (paramReadOnlyItemQuery.k())
          {
            localObject2 = (String)localObject3 + " JOIN item_carousel ci  ON (ci.unique_id = i.unique_id) ";
            localObject3 = "i.carousel_view_count ASC, ci.sort DESC";
          }
          break;
        }
        for (int j = 1;; j = i)
        {
          if (paramReadOnlyItemQuery.n() != 0)
          {
            localObject3 = (String)localObject2 + " JOIN item_highlights hi  ON (hi.unique_id = i.unique_id) ";
            localObject1 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, "  hi.group_id = ?");
            ((ArrayList)localObject5).add(Integer.valueOf(paramReadOnlyItemQuery.n()));
            localObject2 = "hi.sort DESC";
          }
          for (;;)
          {
            localObject4 = localObject1;
            if (paramReadOnlyItemQuery.I() != null) {
              localObject4 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, paramReadOnlyItemQuery.I());
            }
            int k = 0;
            if (paramReadOnlyItemQuery.s()) {
              k = paramReadOnlyItemQuery.t();
            }
            i = 0;
            if (paramReadOnlyItemQuery.p()) {
              i = paramReadOnlyItemQuery.q();
            }
            localObject1 = localObject2;
            if (localObject2 == null) {}
            switch (paramReadOnlyItemQuery.j())
            {
            default: 
              localObject1 = "i.time_added DESC";
              label712:
              localObject1 = " ORDER BY " + (String)localObject1 + " ";
              localObject2 = ((ArrayList)localObject5).toArray();
              localObject5 = new StringBuilder().append("SELECT ");
              if (j != 0)
              {
                paramReadOnlyItemQuery = " DISTINCT ";
                label768:
                localObject3 = ((StringBuilder)localObject5).append(paramReadOnlyItemQuery).append("i.").append("* ").append(" FROM ").append("items").append(" ").append("i").append(" ").append((String)localObject3);
                if (localObject4 == null) {
                  break label1082;
                }
                paramReadOnlyItemQuery = ((StringBuilder)localObject4).toString();
                label827:
                localObject3 = ((StringBuilder)localObject3).append(paramReadOnlyItemQuery);
                if (localObject1 == null) {
                  break label1088;
                }
              }
              break;
            }
            label902:
            label909:
            label916:
            label1082:
            label1088:
            for (paramReadOnlyItemQuery = (ItemQuery.ReadOnlyItemQuery)localObject1;; paramReadOnlyItemQuery = "")
            {
              paramReadOnlyItemQuery = paramReadOnlyItemQuery;
              if ((parama == null) || (!parama.a_())) {
                break label1094;
              }
              return null;
              if (paramReadOnlyItemQuery.G() == null) {
                break;
              }
              localObject1 = com.ideashower.readitlater.db.operation.w.a(null, "i.unique_id = ?");
              ((ArrayList)localObject5).add(Integer.valueOf(paramReadOnlyItemQuery.G().intValue()));
              break;
              localObject2 = " > ";
              break label117;
              localObject1 = "0";
              break label275;
              localObject2 = "" + " JOIN item_tags t ON (t.unique_id = i.unique_id) ";
              localObject1 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, "t.tag = ?");
              ((ArrayList)localObject5).add(paramReadOnlyItemQuery.A());
              break label340;
              throw new RuntimeException("not a valid status: " + paramReadOnlyItemQuery.i());
              localObject1 = com.ideashower.readitlater.db.operation.w.a((StringBuilder)localObject1, "si.status = ?");
              ((ArrayList)localObject5).add(paramReadOnlyItemQuery.g());
              break label415;
              localObject2 = "i.is_article = 1";
              break label463;
              localObject2 = "i.video != 0";
              break label463;
              localObject2 = "i.image = 2";
              break label463;
              localObject1 = "i.time_added ASC";
              break label712;
              localObject1 = "i.title ASC";
              break label712;
              localObject1 = "i.url ASC";
              break label712;
              localObject1 = "RANDOM()";
              break label712;
              localObject1 = "i.word_count ASC";
              break label712;
              paramReadOnlyItemQuery = "";
              break label768;
              paramReadOnlyItemQuery = "";
              break label827;
            }
            label1094:
            if ((k == 0) || (k > 500)) {}
            while (a(localh, paramSQLiteDatabase, i, 500, paramReadOnlyItemQuery, (Object[])localObject2, parama))
            {
              i += 500;
              continue;
              a(localh, paramSQLiteDatabase, i, k, paramReadOnlyItemQuery, (Object[])localObject2, parama);
            }
            if ((parama != null) && (parama.a_())) {
              return null;
            }
            j = localh.size();
            i = 0;
            for (;;)
            {
              paramReadOnlyItemQuery = localh;
              if (i >= j) {
                break;
              }
              aa.a((e)localh.get(i));
              i += 1;
            }
            localObject4 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
          }
          localObject2 = localObject3;
          localObject3 = null;
        }
        i = 0;
        localObject3 = localObject2;
      }
      label1236:
      localObject2 = "";
    }
  }
  
  public static void a(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM tempGet i JOIN tweet_items im ON (i.unique_id = im.unique_id) ", null);
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        int i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
        y localy = new y();
        if (localObject != null)
        {
          paramSQLiteDatabase = (SQLiteDatabase)localObject;
          if (((e)localObject).f() == i) {}
        }
        else
        {
          paramSQLiteDatabase = (e)paramh.a(i);
        }
        if (paramSQLiteDatabase != null)
        {
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.a()) {
            continue;
          }
        }
        localy.a(i);
        localy.a(localCursor.getLong(localCursor.getColumnIndexOrThrow("tweet_id")));
        localy.a(localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_text")));
        localy.b(localCursor.getLong(localCursor.getColumnIndexOrThrow("tweet_date")));
        localy.b(localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_userhandle")));
        localy.c(localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_username")));
        localy.d(localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_user_image_url")));
        localObject = localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_url_entities"));
        if (org.apache.a.c.k.b((CharSequence)localObject)) {}
        try
        {
          localy.c(new JSONArray((String)localObject));
          localObject = localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_mention_entities"));
          if (!org.apache.a.c.k.b((CharSequence)localObject)) {}
        }
        catch (Exception localException3)
        {
          try
          {
            localy.a(new JSONArray((String)localObject));
            localObject = localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_hashtag_entities"));
            if (!org.apache.a.c.k.b((CharSequence)localObject)) {}
          }
          catch (Exception localException3)
          {
            try
            {
              localy.b(new JSONArray((String)localObject));
              localObject = localCursor.getString(localCursor.getColumnIndexOrThrow("tweet_media_entities"));
              if (!org.apache.a.c.k.b((CharSequence)localObject)) {}
            }
            catch (Exception localException3)
            {
              try
              {
                for (;;)
                {
                  localy.d(new JSONArray((String)localObject));
                  localObject = new ArrayList();
                  ((ArrayList)localObject).add(localy);
                  paramSQLiteDatabase.c((ArrayList)localObject);
                  localObject = paramSQLiteDatabase;
                  break;
                  localException1 = localException1;
                  com.ideashower.readitlater.util.e.a(localException1);
                  continue;
                  localException2 = localException2;
                  com.ideashower.readitlater.util.e.a(localException2);
                }
                localException3 = localException3;
                com.ideashower.readitlater.util.e.a(localException3);
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  com.ideashower.readitlater.util.e.a(localJSONException);
                }
              }
            }
          }
        }
      }
    }
    localCursor.close();
  }
  
  private static boolean a(h paramh, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, String paramString, Object[] paramArrayOfObject, com.ideashower.readitlater.d.a parama)
  {
    String str = "INSERT INTO tempGet " + paramString;
    boolean bool1;
    if (paramInt1 > 0)
    {
      paramString = str + " LIMIT " + paramInt1 + ", " + paramInt2;
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS tempGet");
      paramSQLiteDatabase.execSQL(com.ideashower.readitlater.db.a.a.a("tempGet"));
      paramSQLiteDatabase.execSQL(paramString, paramArrayOfObject);
      if ((parama == null) || (!parama.a_())) {
        break label148;
      }
      bool1 = false;
    }
    label148:
    boolean bool2;
    do
    {
      return bool1;
      paramString = str;
      if (paramInt2 <= 0) {
        break;
      }
      paramString = str + " LIMIT " + paramInt2;
      break;
      bool2 = b(paramh, paramSQLiteDatabase);
      bool1 = bool2;
    } while (!bool2);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    c(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    e(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    f(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    g(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    h(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    i(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    a(paramh, paramSQLiteDatabase);
    if ((parama != null) && (parama.a_())) {
      return false;
    }
    d(paramh, paramSQLiteDatabase);
    return bool2;
  }
  
  private static boolean b(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM tempGet", null);
    r localr = new r();
    int i = 0;
    while (paramSQLiteDatabase.moveToNext())
    {
      i += 1;
      int j = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("unique_id"));
      e locale = aa.a(j);
      if ((locale != null) && (!locale.b()))
      {
        paramh.a(locale);
      }
      else
      {
        localr.a();
        localr.d = j;
        localr.c = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("item_id"));
        localr.e = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("resolved_id"));
        localr.f = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("given_url"));
        localr.g = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("given_normal_url"));
        localr.h = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("url"));
        localr.i = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("url_normal"));
        localr.j = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("title"));
        localr.l = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("excerpt"));
        if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("favorite")) == 1)
        {
          bool = true;
          label271:
          localr.m = bool;
          localr.I = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("badge_group_id"));
          if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("is_article")) != 1) {
            break label530;
          }
        }
        label530:
        for (boolean bool = true;; bool = false)
        {
          localr.p = bool;
          localr.q = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("image"));
          localr.r = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("video"));
          localr.b = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("status"));
          localr.o = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndexOrThrow("time_added"));
          localr.D = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("offline_web"));
          localr.C = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("offline_text"));
          localr.F = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("mime"));
          localr.E = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("encoding"));
          localr.z = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("word_count"));
          paramh.a(new e(localr));
          break;
          bool = false;
          break label271;
        }
      }
    }
    paramSQLiteDatabase.close();
    return i > 0;
  }
  
  private static void c(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT i.unique_id, t.tag FROM tempGet i INNER JOIN item_tags t ON (t.unique_id = i.unique_id)", null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
      if (paramSQLiteDatabase != null)
      {
        localObject = paramSQLiteDatabase;
        if (paramSQLiteDatabase.f() == i) {}
      }
      else
      {
        localObject = (e)paramh.a(i);
      }
      if (localObject != null)
      {
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
        if (((e)localObject).a()) {}
      }
      else
      {
        ((e)localObject).d(localCursor.getString(localCursor.getColumnIndexOrThrow("tag")));
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
      }
    }
    localCursor.close();
  }
  
  private static void d(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT i.unique_id, c.group_id, c.sort FROM tempGet i INNER JOIN item_carousel c ON (c.unique_id = i.unique_id)", null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
      if (paramSQLiteDatabase != null)
      {
        localObject = paramSQLiteDatabase;
        if (paramSQLiteDatabase.f() == i) {}
      }
      else
      {
        localObject = (e)paramh.a(i);
      }
      if (localObject != null)
      {
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
        if (((e)localObject).a()) {}
      }
      else
      {
        ((e)localObject).a(new f(localCursor.getInt(localCursor.getColumnIndexOrThrow("group_id")), localCursor.getDouble(localCursor.getColumnIndexOrThrow("sort"))));
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
      }
    }
    localCursor.close();
  }
  
  private static void e(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT i.unique_id, ia.author_id, ia.url, ia.name FROM tempGet i JOIN item_authors ia ON (i.unique_id = ia.unique_id) ", null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
      if (paramSQLiteDatabase != null)
      {
        localObject = paramSQLiteDatabase;
        if (paramSQLiteDatabase.f() == i) {}
      }
      else
      {
        localObject = (e)paramh.a(i);
      }
      if (localObject != null)
      {
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
        if (((e)localObject).a()) {}
      }
      else
      {
        ((e)localObject).a(new d(localCursor.getInt(localCursor.getColumnIndexOrThrow("author_id")), localCursor.getString(localCursor.getColumnIndexOrThrow("name")), localCursor.getString(localCursor.getColumnIndexOrThrow("url"))));
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
      }
    }
    localCursor.close();
  }
  
  private static void f(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM tempGet i JOIN item_images im ON (i.unique_id = im.unique_id) ", null);
    paramSQLiteDatabase = str1;
    label209:
    label210:
    for (;;)
    {
      int i;
      if (localCursor.moveToNext())
      {
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.f() == i)) {
          break label209;
        }
        paramSQLiteDatabase = (e)paramh.a(i);
      }
      for (;;)
      {
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.a())) {
          break label210;
        }
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("image_id"));
        str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("caption"));
        String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("credit"));
        paramSQLiteDatabase.a(new a(localCursor.getString(localCursor.getColumnIndexOrThrow("src")), i, str1, str2, localCursor.getInt(localCursor.getColumnIndexOrThrow("width")), localCursor.getInt(localCursor.getColumnIndexOrThrow("height"))));
        break;
        localCursor.close();
        return;
      }
    }
  }
  
  private static void g(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    String str = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM tempGet i JOIN items_videos im ON (i.unique_id = im.unique_id) ", null);
    paramSQLiteDatabase = str;
    label211:
    label212:
    for (;;)
    {
      int i;
      if (localCursor.moveToNext())
      {
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.f() == i)) {
          break label211;
        }
        paramSQLiteDatabase = (e)paramh.a(i);
      }
      for (;;)
      {
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.a())) {
          break label212;
        }
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("video_id"));
        int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("type"));
        str = localCursor.getString(localCursor.getColumnIndexOrThrow("vid"));
        paramSQLiteDatabase.a(new b(localCursor.getString(localCursor.getColumnIndexOrThrow("src")), i, str, j, localCursor.getInt(localCursor.getColumnIndexOrThrow("width")), localCursor.getInt(localCursor.getColumnIndexOrThrow("height"))));
        break;
        localCursor.close();
        return;
      }
    }
  }
  
  private static void h(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM tempGet i JOIN scroll im ON (i.unique_id = im.unique_id) ", null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    label220:
    label221:
    for (;;)
    {
      int i;
      if (localCursor.moveToNext())
      {
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.f() == i)) {
          break label220;
        }
        paramSQLiteDatabase = (e)paramh.a(i);
      }
      for (;;)
      {
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.a())) {
          break label221;
        }
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("node_index"));
        int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("page"));
        int k = localCursor.getInt(localCursor.getColumnIndexOrThrow("percent"));
        int m = localCursor.getInt(localCursor.getColumnIndexOrThrow("section"));
        long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("time_updated"));
        paramSQLiteDatabase.a(new v(localCursor.getInt(localCursor.getColumnIndexOrThrow("view")), m, j, i, k, l), true);
        break;
        localCursor.close();
        return;
      }
    }
  }
  
  private static void i(h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM tempGet i JOIN shared_items s ON (i.unique_id = s.unique_id) ", null);
    paramSQLiteDatabase = null;
    label275:
    label276:
    for (;;)
    {
      int i;
      if (localCursor.moveToNext())
      {
        i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.f() == i)) {
          break label275;
        }
        paramSQLiteDatabase = (e)paramh.a(i);
      }
      for (;;)
      {
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.a())) {
          break label276;
        }
        int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("share_id"));
        int k = localCursor.getInt(localCursor.getColumnIndexOrThrow("from_friend_id"));
        long l1 = localCursor.getLong(localCursor.getColumnIndexOrThrow("time_shared"));
        long l2 = localCursor.getLong(localCursor.getColumnIndexOrThrow("time_ignored"));
        String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("comment"));
        String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("quote"));
        int m = localCursor.getInt(localCursor.getColumnIndexOrThrow("status"));
        if (localCursor.getInt(localCursor.getColumnIndexOrThrow("viewed")) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramSQLiteDatabase.a(new w(j, k, str1, str2, l1, l2, m, bool, i));
          break;
        }
        localCursor.close();
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */