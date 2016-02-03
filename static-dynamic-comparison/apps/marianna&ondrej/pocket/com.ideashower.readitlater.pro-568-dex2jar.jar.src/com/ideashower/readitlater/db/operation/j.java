package com.ideashower.readitlater.db.operation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.webkit.URLUtil;
import com.ideashower.readitlater.a.aa;
import com.ideashower.readitlater.a.ab;
import com.ideashower.readitlater.a.ar;
import com.ideashower.readitlater.db.operation.action.s;
import com.ideashower.readitlater.e.n;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.e.v;
import com.ideashower.readitlater.e.y;
import com.ideashower.readitlater.e.z;
import com.ideashower.readitlater.h.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public abstract class j
  extends w
{
  private static final ArrayList e = new ArrayList();
  private static k p;
  private static l q;
  protected boolean a = true;
  protected boolean b = false;
  protected boolean c;
  protected boolean d;
  private boolean r = false;
  private HashMap s;
  private String t;
  private o u;
  private boolean v;
  private boolean w;
  private boolean x;
  
  private long A()
  {
    try
    {
      long l = org.apache.a.b.b.h(com.ideashower.readitlater.a.g.c().getDatabasePath("ril"));
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.ideashower.readitlater.util.e.a(localThrowable);
    }
    return 0L;
  }
  
  private void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt1 == 0) {
      return;
    }
    if (paramBoolean) {
      a(paramInt1, paramInt2);
    }
    for (;;)
    {
      com.pocket.m.a.b(paramInt1);
      this.d = true;
      return;
      com.pocket.m.a.e.a(com.pocket.m.a.d.a(paramInt1), this);
      b("unique_id = " + paramInt1);
    }
  }
  
  private void a(s params)
  {
    String str = params.l();
    int j = params.n();
    int k = params.m();
    int i = j;
    if (j < 0)
    {
      params.e().remove("unique_id");
      i = 0;
    }
    j = k;
    if (i > 0)
    {
      j = k;
      if (k == 0)
      {
        Integer localInteger = a("SELECT item_id FROM items WHERE unique_id = ?", new String[] { String.valueOf(i) }, "item_id");
        j = k;
        if (localInteger != null)
        {
          j = k;
          if (localInteger.intValue() != 0)
          {
            j = localInteger.intValue();
            params.a(j);
          }
        }
      }
    }
    if ((j <= 0) && (str == null))
    {
      str = b("SELECT given_url FROM items WHERE unique_id = ?", new String[] { String.valueOf(i) }, "item_id");
      if (str == null) {
        throw new NullPointerException("Action has no item_id or url. There is no way to identify it when syncing.");
      }
      params.b(str);
    }
  }
  
  public static void a(m paramm)
  {
    e.add(paramm);
  }
  
  private void a(o paramo, com.ideashower.readitlater.e.x paramx)
  {
    int i = 1;
    if (paramx.l()) {
      return;
    }
    Object[] arrayOfObject = f(9);
    arrayOfObject[0] = Integer.valueOf(paramx.b());
    arrayOfObject[1] = Integer.valueOf(paramo.f());
    arrayOfObject[2] = Integer.valueOf(paramx.c());
    arrayOfObject[3] = paramx.d();
    arrayOfObject[4] = paramx.e();
    arrayOfObject[5] = Long.valueOf(paramx.f());
    arrayOfObject[6] = Long.valueOf(paramx.j());
    arrayOfObject[7] = Integer.valueOf(paramx.g());
    if (this.c) {}
    for (;;)
    {
      arrayOfObject[8] = Integer.valueOf(i);
      this.h.execSQL("INSERT INTO shared_items (share_id, unique_id, from_friend_id, comment, quote, time_shared, time_ignored, status, viewed) VALUES (?,?,?,?,?,?,?,?,?) ", arrayOfObject);
      return;
      if (!paramx.i()) {
        i = 0;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return;
    }
    if (j(paramInt1))
    {
      a(paramInt1, paramInt2);
      return;
    }
    a(paramInt1, true, paramInt2);
  }
  
  public static void b(m paramm)
  {
    e.remove(paramm);
  }
  
  private void c(String paramString1, String paramString2)
  {
    this.h.execSQL(" DELETE FROM " + paramString1 + " WHERE " + paramString2);
  }
  
  private void e()
  {
    this.v = true;
  }
  
  private int g()
  {
    int i = 0;
    Cursor localCursor = this.h.rawQuery("SELECT sort_id FROM recent_search ORDER BY sort_id DESC LIMIT 1", null);
    if (localCursor.moveToNext()) {
      i = localCursor.getInt(localCursor.getColumnIndexOrThrow("sort_id"));
    }
    localCursor.close();
    return i;
  }
  
  private void h(String paramString)
  {
    if (!this.a) {
      return;
    }
    if (this.s == null) {
      this.s = new HashMap();
    }
    this.s.put(paramString, paramString);
  }
  
  private void i(int paramInt)
  {
    Object[] arrayOfObject = f(2);
    if (j(paramInt)) {}
    for (int i = 1;; i = 0)
    {
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Integer.valueOf(paramInt);
      this.h.execSQL("UPDATE items SET hasPendingShares = ? WHERE unique_id = ?", arrayOfObject);
      return;
    }
  }
  
  private boolean j(int paramInt)
  {
    boolean bool = true;
    Object localObject = g(2);
    localObject[0] = String.valueOf(paramInt);
    localObject[1] = String.valueOf(0);
    localObject = this.h.rawQuery("SELECT 1 FROM shared_items WHERE unique_id = ? AND status = ?", (String[])localObject);
    if (((Cursor)localObject).getCount() > 0) {}
    for (;;)
    {
      ((Cursor)localObject).close();
      return bool;
      bool = false;
    }
  }
  
  public static com.ideashower.readitlater.a.ag r()
  {
    new com.ideashower.readitlater.a.ag()
    {
      public void a() {}
      
      public void b()
      {
        j.a(null);
        j.a(null);
      }
      
      public void c() {}
    };
  }
  
  private long z()
  {
    long l = 0L;
    Cursor localCursor = this.h.rawQuery(" SELECT SUM(bytes) as total  FROM assets", null);
    if (localCursor.moveToNext()) {
      l = localCursor.getLong(localCursor.getColumnIndexOrThrow("total"));
    }
    localCursor.close();
    return l;
  }
  
  protected int a(o paramo)
  {
    int i = 0;
    paramo = b(paramo);
    if (paramo == null) {
      return 0;
    }
    if (paramo.moveToFirst()) {
      i = paramo.getInt(0);
    }
    paramo.close();
    return i;
  }
  
  public int a(o paramo, boolean paramBoolean)
  {
    if (!paramo.h()) {
      paramo.a(h().b(this.h).a());
    }
    if (!paramo.g()) {
      return -3;
    }
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      j = 0;
    }
    Object localObject;
    for (;;)
    {
      if (i == 0) {
        if (!URLUtil.isValidUrl(paramo.i()))
        {
          return -3;
          localObject = b(paramo);
          if (localObject == null)
          {
            i = 0;
            j = 0;
          }
          else
          {
            if (((Cursor)localObject).moveToFirst())
            {
              int k = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("unique_id"));
              if (((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("status")) == 0)
              {
                i = 1;
                label131:
                j = i;
                i = k;
              }
            }
            for (;;)
            {
              ((Cursor)localObject).close();
              break;
              i = 0;
              break label131;
              i = 0;
              j = 0;
            }
          }
        }
        else
        {
          if (paramo.u() == 0L) {
            paramo.a(this.f);
          }
          x localx = g("INSERT INTO items (unique_id, item_id, resolved_id, status, given_url, given_normal_url, url, url_normal, domain, title, excerpt, time_added, favorite, badge_group_id, is_article, word_count, image, video, offline_web, offline_text, time_added_to_device) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ").a(paramo.f()).a(paramo.c()).a(paramo.d()).a(paramo.al()).a(paramo.i()).a(paramo.j()).a(paramo.l()).a(paramo.m()).a(paramo.n()).a(org.apache.a.c.k.c(paramo.q())).a(paramo.r()).a(paramo.u());
          if (paramo.ae())
          {
            localObject = "1";
            localx = localx.a((String)localObject).a(paramo.y());
            if (!paramo.d(false)) {
              break label400;
            }
            localObject = "1";
            label314:
            localx.a((String)localObject).a(paramo.H()).a(paramo.I()).a(paramo.K()).a(paramo.O()).a(paramo.P()).a(this.f * 1000L).c();
            d(paramo, true);
            c(paramo, true);
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        break label456;
      }
      return paramo.f();
      localObject = "0";
      break;
      label400:
      localObject = "0";
      break label314;
      com.ideashower.readitlater.util.e.a(this.f);
      g("UPDATE items SET time_added = ?, status = ? WHERE unique_id = ?").a(this.f).a(paramo.al()).a(i).c();
      aa.b(i);
      i(paramo, false);
    }
    label456:
    return -2;
  }
  
  public Integer a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    paramArrayOfString = this.h.rawQuery(paramString1, paramArrayOfString);
    if (paramArrayOfString.moveToNext()) {}
    for (paramString1 = Integer.valueOf(paramArrayOfString.getInt(paramArrayOfString.getColumnIndexOrThrow(paramString2)));; paramString1 = null)
    {
      paramArrayOfString.close();
      return paramString1;
    }
  }
  
  public void a(int paramInt)
  {
    Object[] arrayOfObject = f(1);
    arrayOfObject[0] = Integer.valueOf(paramInt);
    this.h.execSQL("DELETE FROM item_tags WHERE unique_id = ?", arrayOfObject);
    aa.b(paramInt);
  }
  
  protected void a(int paramInt, double paramDouble)
  {
    Object[] arrayOfObject = f(2);
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Double.valueOf(paramDouble);
    this.h.execSQL("INSERT OR REPLACE INTO highlights (group_id, sort) VALUES (?,?) ", arrayOfObject);
  }
  
  protected void a(int paramInt1, double paramDouble, int paramInt2)
  {
    Object[] arrayOfObject = f(3);
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Double.valueOf(paramDouble);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    this.h.execSQL("INSERT OR REPLACE INTO item_carousel (unique_id, sort, group_id) VALUES (?,?,?) ", arrayOfObject);
    aa.b(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = f(3);
    arrayOfObject[0] = Integer.valueOf(paramInt2);
    if (o.l(paramInt2)) {
      arrayOfObject[1] = Long.valueOf(System.currentTimeMillis());
    }
    for (;;)
    {
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      this.h.execSQL(" UPDATE items SET status = ?, time_removed = ?  WHERE unique_id = ?", arrayOfObject);
      aa.b(paramInt1);
      return;
      arrayOfObject[1] = Integer.valueOf(0);
    }
  }
  
  public void a(int paramInt, v paramv)
  {
    Object[] arrayOfObject = f(7);
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(paramv.a());
    arrayOfObject[2] = Integer.valueOf(paramv.b());
    arrayOfObject[3] = Integer.valueOf(paramv.c());
    arrayOfObject[4] = Integer.valueOf(paramv.d());
    arrayOfObject[5] = Integer.valueOf(paramv.e());
    arrayOfObject[6] = Long.valueOf(paramv.f());
    this.h.execSQL("REPLACE INTO scroll (unique_id, view, section, page, node_index, percent, time_updated) VALUES (?,?,?,?,?,?,?)", arrayOfObject);
    aa.b(paramInt);
  }
  
  public void a(com.ideashower.readitlater.db.operation.action.ag paramag)
  {
    long l = System.currentTimeMillis();
    ArrayNode localArrayNode = paramag.k();
    int j = localArrayNode.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (ObjectNode)localArrayNode.get(i);
      String str = com.ideashower.readitlater.util.l.a((JsonNode)localObject, "email", null);
      int k = com.ideashower.readitlater.util.l.a((JsonNode)localObject, "friend_id", 0);
      if (k != 0) {}
      for (localObject = k().a(k);; localObject = k().b(str, this.h))
      {
        paramag.a(i, ((f)localObject).a());
        k.a(k(), (f)localObject, l, this.h);
        i += 1;
        break;
        if (str == null) {
          break label128;
        }
      }
      label128:
      throw new RuntimeException("to field not formed correctly");
    }
  }
  
  protected void a(com.ideashower.readitlater.db.operation.action.c paramc)
  {
    if (!paramc.g()) {
      throw new RuntimeException("action has not been committed");
    }
    if ((paramc instanceof s)) {
      a((s)paramc);
    }
    paramc.b(this.f);
    paramc.c(ar.b());
    paramc.a(this);
    if ((paramc instanceof s))
    {
      s locals = (s)paramc;
      aa.b(locals.n());
      if ((locals.q()) && ((!i.a(com.ideashower.readitlater.h.a.H)) || (com.ideashower.readitlater.a.g.l()))) {
        com.pocket.m.a.a(r.a(locals.l(), this.h), 0, false, false, com.pocket.m.a.e.q(), false);
      }
    }
    a(paramc, paramc.i());
  }
  
  protected void a(com.ideashower.readitlater.db.operation.action.c paramc, boolean paramBoolean)
  {
    com.pocket.c.e.a(this.h, paramc, paramBoolean, f(2));
    this.r = paramBoolean;
  }
  
  protected void a(com.ideashower.readitlater.e.x paramx)
  {
    Object[] arrayOfObject;
    if ((paramx instanceof com.ideashower.readitlater.e.c))
    {
      if (!paramx.l()) {
        break label45;
      }
      arrayOfObject = f(1);
      arrayOfObject[0] = Integer.valueOf(paramx.b());
      this.h.execSQL("DELETE FROM shared_items WHERE share_id = ?", arrayOfObject);
    }
    for (;;)
    {
      e();
      return;
      label45:
      arrayOfObject = f(3);
      arrayOfObject[0] = Integer.valueOf(paramx.g());
      arrayOfObject[1] = Long.valueOf(paramx.j());
      arrayOfObject[2] = Integer.valueOf(paramx.b());
      this.h.execSQL("UPDATE shared_items SET status = ?, time_ignored = ? WHERE share_id = ?", arrayOfObject);
    }
  }
  
  public void a(com.ideashower.readitlater.e.x paramx, o paramo)
  {
    a(paramx);
    i(paramo.f());
    aa.b(paramo.f());
  }
  
  public void a(y paramy)
  {
    Object[] arrayOfObject = f(11);
    arrayOfObject[0] = Long.valueOf(paramy.m());
    arrayOfObject[1] = Integer.valueOf(paramy.a());
    arrayOfObject[2] = paramy.c();
    arrayOfObject[3] = Long.valueOf(paramy.d());
    arrayOfObject[4] = paramy.f();
    arrayOfObject[5] = paramy.g();
    arrayOfObject[6] = paramy.h();
    arrayOfObject[7] = paramy.l();
    arrayOfObject[8] = paramy.i();
    arrayOfObject[9] = paramy.j();
    arrayOfObject[10] = paramy.p();
    this.h.execSQL("INSERT OR REPLACE INTO tweet_items (tweet_id, unique_id, tweet_text, tweet_date, tweet_userhandle, tweet_username, tweet_user_image_url, tweet_url_entities, tweet_mention_entities, tweet_hashtag_entities, tweet_media_entities) VALUES (?,?,?,?,?,?,?,?,?,?,?) ", arrayOfObject);
    aa.b(paramy.a());
  }
  
  public void a(com.pocket.m.a.d paramd)
  {
    g("DELETE FROM assets_users WHERE user = ?").a(paramd.a).c();
  }
  
  public void a(final String paramString)
  {
    Object[] arrayOfObject = f(1);
    arrayOfObject[0] = paramString;
    this.h.execSQL("DELETE FROM item_tags WHERE tag = ?", arrayOfObject);
    this.h.execSQL("DELETE FROM tags WHERE tag = ?", arrayOfObject);
    aa.a(new ab()
    {
      public boolean a(o paramAnonymouso)
      {
        return paramAnonymouso.e(paramString);
      }
    });
    this.b = true;
  }
  
  public void a(String paramString, long paramLong)
  {
    g("UPDATE assets SET bytes = ? WHERE short_path = ?").a(paramLong).a(paramString).c();
    w();
  }
  
  public void a(String paramString, com.pocket.m.a.d paramd)
  {
    Object localObject;
    if (paramd.b)
    {
      localObject = "'asset'||(SELECT asset_id FROM assets WHERE short_path = ?)";
      localObject = g(" REPLACE INTO assets_users (asset_id, user, time_updated )  VALUES  ( (SELECT asset_id FROM assets WHERE short_path = ?)," + (String)localObject + "," + " ?" + " )").a(paramString).a(paramd.a);
      if (!paramd.c()) {
        break label95;
      }
    }
    label95:
    for (paramString = Long.valueOf(System.currentTimeMillis());; paramString = null)
    {
      ((x)localObject).a(paramString).c();
      return;
      localObject = "?";
      break;
    }
  }
  
  public void a(final String paramString1, final String paramString2)
  {
    Object[] arrayOfObject1 = f(2);
    arrayOfObject1[0] = paramString2;
    arrayOfObject1[1] = paramString1;
    Object[] arrayOfObject2 = f(1);
    arrayOfObject2[0] = paramString1;
    this.h.execSQL("UPDATE OR IGNORE item_tags SET tag = ? WHERE tag = ?", arrayOfObject1);
    this.h.execSQL("DELETE FROM item_tags WHERE tag = ?", arrayOfObject2);
    this.h.execSQL("UPDATE OR IGNORE tags SET tag = ? WHERE tag = ?", arrayOfObject1);
    this.h.execSQL("DELETE FROM tags WHERE tag = ?", arrayOfObject2);
    h(paramString2);
    aa.a(new ab()
    {
      public boolean a(o paramAnonymouso)
      {
        return paramAnonymouso.a(paramString1, paramString2);
      }
    });
    this.b = true;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, g() + 1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object[] arrayOfObject = f(5);
    arrayOfObject[0] = paramString1.toLowerCase();
    arrayOfObject[1] = paramString1;
    arrayOfObject[2] = org.apache.a.c.k.e(paramString2, "");
    arrayOfObject[3] = org.apache.a.c.k.e(paramString3, "");
    arrayOfObject[4] = Integer.valueOf(paramInt);
    this.h.execSQL("INSERT OR REPLACE INTO recent_search (search_normal, search, cxt_key, cxt_val, sort_id) VALUES (?,?,?,?,?) ", arrayOfObject);
    this.w = true;
  }
  
  public void a(ArrayNode paramArrayNode)
  {
    paramArrayNode = paramArrayNode.getElements();
    while (paramArrayNode.hasNext()) {
      h(((JsonNode)paramArrayNode.next()).asText());
    }
  }
  
  public void a(ArrayNode paramArrayNode, int paramInt)
  {
    paramArrayNode = paramArrayNode.getElements();
    Object[] arrayOfObject = f(2);
    while (paramArrayNode.hasNext())
    {
      String str = ((JsonNode)paramArrayNode.next()).asText();
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = str;
      this.h.execSQL("REPLACE INTO item_tags (unique_id, tag) VALUES (?,?)", arrayOfObject);
      h(str);
    }
    aa.b(paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object[] arrayOfObject = f(2);
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      arrayOfObject[0] = str;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      this.h.execSQL("UPDATE items SET favorite = ? WHERE unique_id = ?", arrayOfObject);
      aa.b(paramInt);
      return;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String... paramVarArgs)
  {
    SQLiteDatabase localSQLiteDatabase = this.h;
    paramString1 = " SELECT 1 FROM " + paramString1 + " WHERE " + paramString2;
    if (paramVarArgs.length > 0) {}
    for (;;)
    {
      paramString1 = localSQLiteDatabase.rawQuery(paramString1, paramVarArgs);
      boolean bool = paramString1.moveToNext();
      paramString1.close();
      return bool;
      paramVarArgs = null;
    }
  }
  
  public int b(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.h;
    StringBuilder localStringBuilder = new StringBuilder().append(" SELECT COUNT(*) as c FROM ").append(paramString1);
    if (paramString2 != null)
    {
      paramString1 = " WHERE " + paramString2;
      paramString1 = localSQLiteDatabase.rawQuery(paramString1, null);
      if (!paramString1.moveToNext()) {
        break label105;
      }
    }
    label105:
    for (int i = paramString1.getInt(paramString1.getColumnIndexOrThrow("c"));; i = 0)
    {
      paramString1.close();
      return i;
      paramString1 = "";
      break;
    }
  }
  
  protected Cursor b(o paramo)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = paramo.c();
    if (i != 0)
    {
      ((ArrayList)localObject).add("item_id");
      localArrayList.add(String.valueOf(i));
    }
    i = paramo.d();
    if (i != 0)
    {
      ((ArrayList)localObject).add("resolved_id");
      localArrayList.add(String.valueOf(i));
    }
    String str = paramo.j();
    if (str != null)
    {
      ((ArrayList)localObject).add("given_normal_url");
      localArrayList.add(str);
      ((ArrayList)localObject).add("url_normal");
      localArrayList.add(str);
    }
    paramo = paramo.m();
    if (paramo != null)
    {
      ((ArrayList)localObject).add("given_normal_url");
      localArrayList.add(paramo);
      ((ArrayList)localObject).add("url_normal");
      localArrayList.add(paramo);
    }
    if (((ArrayList)localObject).size() == 0) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    paramo = null;
    if (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (paramo != null) {}
      for (paramo = paramo.concat(" OR ");; paramo = " ")
      {
        paramo = paramo + " " + str + " = ? ";
        break;
      }
    }
    paramo = "SELECT unique_id, status FROM items WHERE " + paramo;
    return this.h.rawQuery(paramo, (String[])localArrayList.toArray(g(localArrayList.size())));
  }
  
  public String b(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    paramArrayOfString = this.h.rawQuery(paramString1, paramArrayOfString);
    if (paramArrayOfString.moveToNext()) {}
    for (paramString1 = paramArrayOfString.getString(paramArrayOfString.getColumnIndexOrThrow(paramString2));; paramString1 = null)
    {
      paramArrayOfString.close();
      return paramString1;
    }
  }
  
  public void b(int paramInt)
  {
    b(paramInt, 1);
  }
  
  protected void b(int paramInt1, double paramDouble, int paramInt2)
  {
    Object[] arrayOfObject = f(3);
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Double.valueOf(paramDouble);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    this.h.execSQL("INSERT OR REPLACE INTO item_highlights (unique_id, sort, group_id) VALUES (?,?,?) ", arrayOfObject);
  }
  
  public void b(com.ideashower.readitlater.db.operation.action.c paramc)
  {
    a(paramc);
  }
  
  protected void b(o paramo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      arrayOfObject = f(17);
      arrayOfObject[0] = Integer.valueOf(paramo.d());
      arrayOfObject[1] = Integer.valueOf(paramo.al());
      arrayOfObject[2] = paramo.i();
      arrayOfObject[3] = paramo.j();
      arrayOfObject[4] = paramo.l();
      arrayOfObject[5] = paramo.m();
      arrayOfObject[6] = paramo.n();
      arrayOfObject[7] = org.apache.a.c.k.c(paramo.q());
      arrayOfObject[8] = paramo.r();
      arrayOfObject[9] = Long.valueOf(paramo.u());
      if (paramo.ae())
      {
        str = "1";
        arrayOfObject[10] = str;
        arrayOfObject[11] = Integer.valueOf(paramo.y());
        if (!paramo.d(false)) {
          break label234;
        }
      }
      label234:
      for (str = "1";; str = "0")
      {
        arrayOfObject[12] = str;
        arrayOfObject[13] = Integer.valueOf(paramo.H());
        arrayOfObject[14] = Integer.valueOf(paramo.I());
        arrayOfObject[15] = Integer.valueOf(paramo.K());
        arrayOfObject[16] = Integer.valueOf(paramo.f());
        this.h.execSQL("UPDATE items SET resolved_id = ?, status = ?, given_url = ?, given_normal_url = ?, url = ?, url_normal = ?, domain = ?, title = ?, excerpt = ?, time_added = ?, favorite = ?, badge_group_id = ?, is_article = ?, word_count = ?, image = ?, video = ?  WHERE unique_id = ?", arrayOfObject);
        c(paramo, false);
        d(paramo, false);
        return;
        str = "0";
        break;
      }
    }
    Object[] arrayOfObject = f(5);
    arrayOfObject[0] = Integer.valueOf(paramo.al());
    arrayOfObject[1] = Long.valueOf(paramo.u());
    if (paramo.ae()) {}
    for (String str = "1";; str = "0")
    {
      arrayOfObject[2] = str;
      arrayOfObject[3] = Integer.valueOf(paramo.y());
      arrayOfObject[4] = Integer.valueOf(paramo.f());
      this.h.execSQL("UPDATE items SET status = ?, time_added = ?, favorite = ?, badge_group_id = ?  WHERE unique_id = ?", arrayOfObject);
      break;
    }
  }
  
  protected void b(String paramString)
  {
    c("items", paramString);
    c("scroll", paramString);
    c("item_tags", paramString);
    c("tweet_items", paramString);
    c("item_images", paramString);
    c("items_videos", paramString);
    c("shared_items", paramString);
    c("item_carousel", paramString);
    c("item_highlights", paramString);
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    if (!paramBoolean) {}
    do
    {
      return;
      if (this.r) {
        com.pocket.c.e.m();
      }
    } while (!this.b);
    com.ideashower.readitlater.i.c.a();
  }
  
  public void c(int paramInt)
  {
    b(paramInt, 2);
  }
  
  protected void c(o paramo, boolean paramBoolean)
  {
    j(paramo, paramBoolean);
    k(paramo, paramBoolean);
    l(paramo, paramBoolean);
    aa.b(paramo.f());
    com.pocket.gsf.e.a(paramo);
  }
  
  public void c(String paramString)
  {
    this.t = paramString;
  }
  
  protected void d(int paramInt)
  {
    a(paramInt, false, 0);
  }
  
  protected void d(o paramo, boolean paramBoolean)
  {
    f(paramo, paramBoolean);
    g(paramo, paramBoolean);
    i(paramo, paramBoolean);
    h(paramo, paramBoolean);
    aa.b(paramo.f());
  }
  
  public void d(String paramString)
  {
    g("INSERT INTO assets (short_path, bytes) VALUES (?,?)").a(paramString).a(0).c();
  }
  
  public o e(String paramString)
  {
    return r.a(paramString, this.h);
  }
  
  public void e(int paramInt)
  {
    Object localObject = g(1);
    localObject[0] = String.valueOf(paramInt);
    localObject = this.h.rawQuery("SELECT carousel_view_count FROM items WHERE unique_id = ?", (String[])localObject);
    if (((Cursor)localObject).moveToNext()) {}
    for (int i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("carousel_view_count"));; i = 0)
    {
      ((Cursor)localObject).close();
      localObject = f(2);
      localObject[0] = Integer.valueOf(i + 1);
      localObject[1] = Integer.valueOf(paramInt);
      this.h.execSQL("UPDATE items SET carousel_view_count = ? WHERE unique_id = ?", (Object[])localObject);
      return;
    }
  }
  
  protected void e(o paramo, boolean paramBoolean)
  {
    int j = a(paramo);
    if (j == 0) {
      return;
    }
    paramo.a(j);
    int i;
    Object[] arrayOfObject;
    label99:
    label170:
    SQLiteDatabase localSQLiteDatabase;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 12;
      arrayOfObject = f(i);
      arrayOfObject[0] = Integer.valueOf(paramo.d());
      arrayOfObject[1] = paramo.l();
      arrayOfObject[2] = paramo.m();
      arrayOfObject[3] = paramo.n();
      arrayOfObject[4] = org.apache.a.c.k.c(paramo.q());
      arrayOfObject[5] = paramo.r();
      if (!paramo.d(false)) {
        break label265;
      }
      str = "1";
      arrayOfObject[6] = str;
      arrayOfObject[7] = Integer.valueOf(paramo.H());
      arrayOfObject[8] = Integer.valueOf(paramo.I());
      arrayOfObject[9] = Integer.valueOf(paramo.K());
      if (!paramBoolean) {
        break label273;
      }
      arrayOfObject[10] = Integer.valueOf(paramo.c());
      arrayOfObject[11] = Integer.valueOf(paramo.f());
      localSQLiteDatabase = this.h;
      localStringBuilder = new StringBuilder().append("UPDATE items SET resolved_id = ?, url = ?, url_normal = ?, domain = ?, title = ?, excerpt = ?, is_article = ?, word_count = ?, image = ?, video = ? ");
      if (!paramBoolean) {
        break label288;
      }
    }
    label265:
    label273:
    label288:
    for (String str = ", item_id = ? ";; str = "")
    {
      localSQLiteDatabase.execSQL(str + " WHERE " + "unique_id" + " = ?", arrayOfObject);
      c(paramo, false);
      k().a();
      com.ideashower.readitlater.i.c.a(r.a(j, this.h));
      return;
      i = 11;
      break;
      str = "0";
      break label99;
      arrayOfObject[10] = Integer.valueOf(paramo.f());
      break label170;
    }
  }
  
  public int f(String paramString)
  {
    return b(paramString, null);
  }
  
  protected void f(o paramo, boolean paramBoolean)
  {
    Object[] arrayOfObject = f(1);
    if (!paramBoolean)
    {
      arrayOfObject[0] = Integer.valueOf(paramo.f());
      this.h.execSQL("DELETE FROM item_tags WHERE unique_id = ?", arrayOfObject);
    }
    arrayOfObject = f(2);
    Iterator localIterator = paramo.w().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      arrayOfObject[0] = Integer.valueOf(paramo.f());
      arrayOfObject[1] = str;
      this.h.execSQL("REPLACE INTO item_tags (unique_id, tag) VALUES (?,?)", arrayOfObject);
      h(str);
    }
  }
  
  protected void g(o paramo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = f(1);
      localObject[0] = Integer.valueOf(paramo.f());
      this.h.execSQL("DELETE FROM scroll WHERE unique_id = ?", (Object[])localObject);
    }
    Object localObject = paramo.C();
    int j = ((SparseArray)localObject).size();
    int i = 0;
    while (i < j)
    {
      a(paramo.f(), (v)((SparseArray)localObject).valueAt(i));
      i += 1;
    }
  }
  
  protected l h()
  {
    if (q == null) {
      q = new l(this);
    }
    return q;
  }
  
  protected void h(o paramo, boolean paramBoolean)
  {
    Object localObject = paramo.ag();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        y localy = (y)((Iterator)localObject).next();
        localy.a(paramo.f());
        a(localy);
      }
    }
  }
  
  protected void i()
  {
    h().a(this.h);
    Object localObject2;
    Object localObject1;
    if ((this.a) && (this.s != null))
    {
      localObject2 = this.s.values();
      localObject1 = f(1);
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[0] = ((String)((Iterator)localObject2).next());
        this.h.execSQL("INSERT OR IGNORE INTO tags (tag) VALUES (?)", (Object[])localObject1);
      }
    }
    if (this.v) {}
    k().a();
    aa.a(this.h);
    if (this.t != null) {
      this.u = r.a(this.t, this.h);
    }
    if ((this.w) && (!e.isEmpty()))
    {
      localObject1 = v();
      localObject2 = e.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((m)((Iterator)localObject2).next()).a((ArrayList)localObject1);
      }
    }
    if (this.d) {
      com.pocket.m.a.e.p();
    }
    if (this.x) {
      j();
    }
  }
  
  protected void i(o paramo, boolean paramBoolean)
  {
    Object localObject = paramo.T();
    String[] arrayOfString = g(1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.ideashower.readitlater.e.x localx = (com.ideashower.readitlater.e.x)localIterator.next();
      if (paramBoolean)
      {
        a(paramo, localx);
      }
      else
      {
        arrayOfString[0] = String.valueOf(localx.b());
        int i;
        if ((localx instanceof com.ideashower.readitlater.e.w)) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            a(localx);
            break;
            if ((localx.g() == 2) && (localx.j() == 0L))
            {
              Cursor localCursor = this.h.rawQuery("SELECT time_ignored FROM shared_items WHERE share_id = ?", arrayOfString);
              boolean bool = localCursor.moveToNext();
              localObject = localCursor;
              i = bool;
              if (bool)
              {
                localx.a(localCursor.getLong(localCursor.getColumnIndexOrThrow("time_ignored")));
                i = bool;
                localObject = localCursor;
              }
              ((Cursor)localObject).close();
            }
            else
            {
              localObject = this.h.rawQuery("SELECT 1 FROM shared_items WHERE share_id = ?", arrayOfString);
              if (((Cursor)localObject).getCount() > 0) {}
              for (i = 1;; i = 0) {
                break;
              }
            }
          }
        }
        a(paramo, localx);
      }
    }
    i(paramo.f());
  }
  
  public void j()
  {
    com.pocket.m.a.e.a(z(), A());
    this.x = false;
  }
  
  protected void j(o paramo, boolean paramBoolean)
  {
    Object[] arrayOfObject = f(1);
    arrayOfObject[0] = Integer.valueOf(paramo.f());
    if (!paramBoolean) {
      this.h.execSQL("DELETE FROM item_authors WHERE unique_id = ?", arrayOfObject);
    }
    arrayOfObject = f(4);
    Iterator localIterator = paramo.af().iterator();
    while (localIterator.hasNext())
    {
      com.ideashower.readitlater.e.d locald = (com.ideashower.readitlater.e.d)localIterator.next();
      arrayOfObject[0] = Integer.valueOf(locald.a());
      arrayOfObject[1] = Integer.valueOf(paramo.f());
      arrayOfObject[2] = locald.b();
      arrayOfObject[3] = locald.c();
      this.h.execSQL("INSERT INTO item_authors ( author_id, unique_id, name, url ) VALUES (?,?,?,?) ", arrayOfObject);
    }
  }
  
  protected k k()
  {
    if (p == null) {
      p = new k(this.h, h().c(this.h));
    }
    return p;
  }
  
  protected void k(o paramo, boolean paramBoolean)
  {
    Object localObject = f(1);
    localObject[0] = Integer.valueOf(paramo.f());
    if (!paramBoolean) {
      this.h.execSQL("DELETE FROM item_images WHERE unique_id = ?", (Object[])localObject);
    }
    localObject = paramo.W();
    if ((localObject == null) || (((SparseArray)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      Object[] arrayOfObject = f(7);
      int j = ((SparseArray)localObject).size();
      int i = 0;
      while (i < j)
      {
        com.ideashower.readitlater.e.a locala = (com.ideashower.readitlater.e.a)((SparseArray)localObject).valueAt(i);
        arrayOfObject[0] = Integer.valueOf(paramo.f());
        arrayOfObject[1] = Integer.valueOf(locala.b());
        arrayOfObject[2] = locala.a();
        arrayOfObject[3] = Integer.valueOf(locala.e());
        arrayOfObject[4] = Integer.valueOf(locala.f());
        arrayOfObject[5] = locala.d();
        arrayOfObject[6] = locala.c();
        this.h.execSQL("INSERT INTO item_images (unique_id, image_id, src, width, height, caption, credit) VALUES (?,?,?,?,?,?,?) ", arrayOfObject);
        i += 1;
      }
    }
  }
  
  protected void l()
  {
    this.c = true;
  }
  
  protected void l(o paramo, boolean paramBoolean)
  {
    Object localObject = f(1);
    if (!paramBoolean)
    {
      localObject[0] = Integer.valueOf(paramo.f());
      this.h.execSQL("DELETE FROM items_videos WHERE unique_id = ?", (Object[])localObject);
    }
    localObject = paramo.V();
    if ((localObject == null) || (((SparseArray)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      Object[] arrayOfObject = f(7);
      int j = ((SparseArray)localObject).size();
      int i = 0;
      while (i < j)
      {
        com.ideashower.readitlater.e.b localb = (com.ideashower.readitlater.e.b)((SparseArray)localObject).valueAt(i);
        arrayOfObject[0] = Integer.valueOf(paramo.f());
        arrayOfObject[1] = Integer.valueOf(localb.b());
        arrayOfObject[2] = localb.a();
        arrayOfObject[3] = Integer.valueOf(localb.e());
        arrayOfObject[4] = Integer.valueOf(localb.f());
        arrayOfObject[5] = Integer.valueOf(localb.d());
        arrayOfObject[6] = localb.c();
        this.h.execSQL("INSERT INTO items_videos (unique_id, video_id, src, width, height, type, vid) VALUES (?,?,?,?,?,?,?) ", arrayOfObject);
        i += 1;
      }
    }
  }
  
  protected int m()
  {
    int j = 1;
    Object localObject = g(1);
    localObject[0] = "1";
    localObject = this.h.rawQuery("SELECT 1 FROM sync_queue WHERE send_asap = ?", (String[])localObject);
    if (((Cursor)localObject).getCount() > 0) {}
    for (int i = 1;; i = 0)
    {
      ((Cursor)localObject).close();
      if (i == 0) {
        break;
      }
      j = 2;
      return j;
    }
    localObject = this.h.rawQuery("SELECT 1 FROM sync_queue", null);
    if (((Cursor)localObject).getCount() > 0) {}
    for (i = 1;; i = 0)
    {
      ((Cursor)localObject).close();
      if (i != 0) {
        break;
      }
      return 0;
    }
  }
  
  public o n()
  {
    return this.u;
  }
  
  protected Cursor o()
  {
    return this.h.query("sync_queue", new String[] { "rowid", "action", "send_asap" }, null, null, null, null, null);
  }
  
  protected boolean p()
  {
    Cursor localCursor = o();
    if (!localCursor.moveToNext()) {}
    for (boolean bool = true;; bool = false)
    {
      localCursor.close();
      return bool;
    }
  }
  
  protected ArrayList q()
  {
    Object localObject1 = null;
    Cursor localCursor = this.h.rawQuery("SELECT * FROM unconfirmed_shares", null);
    while (localCursor.moveToNext())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject2).add(new z(localCursor.getString(localCursor.getColumnIndexOrThrow("email")), localCursor.getString(localCursor.getColumnIndexOrThrow("friend"))));
      localObject1 = localObject2;
    }
    localCursor.close();
    return (ArrayList)localObject1;
  }
  
  protected void s()
  {
    this.h.execSQL("DELETE FROM item_carousel");
  }
  
  protected void t()
  {
    this.h.execSQL("DELETE FROM highlights");
    this.h.execSQL("DELETE FROM item_highlights");
  }
  
  protected void u()
  {
    this.h.execSQL("DELETE FROM recent_search");
    this.w = true;
  }
  
  public ArrayList v()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.h.rawQuery("SELECT *  FROM recent_search ORDER BY sort_id DESC", null);
    while (localCursor.moveToNext()) {
      localArrayList.add(new com.pocket.n.g(localCursor.getString(localCursor.getColumnIndexOrThrow("search")), localCursor.getString(localCursor.getColumnIndexOrThrow("cxt_key")), localCursor.getString(localCursor.getColumnIndexOrThrow("cxt_val"))));
    }
    localCursor.close();
    return localArrayList;
  }
  
  protected void w()
  {
    this.x = true;
  }
  
  protected ArrayList x()
  {
    Cursor localCursor = this.h.rawQuery("SELECT tag  FROM tags ORDER BY tag COLLATE NOCASE", null);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(localCursor.getColumnIndexOrThrow("tag")));
    }
    localCursor.close();
    return localArrayList;
  }
  
  protected void y()
  {
    this.b = true;
    aa.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */