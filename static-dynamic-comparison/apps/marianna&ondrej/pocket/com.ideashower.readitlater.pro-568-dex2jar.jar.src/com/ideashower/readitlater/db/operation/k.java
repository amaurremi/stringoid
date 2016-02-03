package com.ideashower.readitlater.db.operation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.e.m;
import com.ideashower.readitlater.e.n;
import com.ideashower.readitlater.util.l;
import com.ideashower.readitlater.util.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class k
{
  private final n a;
  private final SparseArray b = new SparseArray();
  private final SparseArray c = new SparseArray();
  private final HashMap d = new HashMap();
  private boolean e = true;
  
  protected k(SQLiteDatabase paramSQLiteDatabase, n paramn)
  {
    this.a = paramn;
    paramn = paramSQLiteDatabase.rawQuery("SELECT * FROM friends", null);
    while (paramn.moveToNext()) {
      a(new f(new m(paramn.getInt(paramn.getColumnIndexOrThrow("local_friend_id")), paramn.getInt(paramn.getColumnIndexOrThrow("friend_id"))), paramn.getString(paramn.getColumnIndexOrThrow("username")), paramn.getString(paramn.getColumnIndexOrThrow("name")), paramn.getString(paramn.getColumnIndexOrThrow("avatar_url")), paramn.getLong(paramn.getColumnIndexOrThrow("last_share_time"))));
    }
    paramn.close();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM ac_emails", null);
    while (paramSQLiteDatabase.moveToNext())
    {
      paramn = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndexOrThrow("email"));
      int i = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndexOrThrow("local_friend_id"));
      this.d.put(paramn.toLowerCase(), Integer.valueOf(i));
      ((f)this.c.get(i)).a(paramn);
    }
    paramSQLiteDatabase.close();
    this.e = true;
  }
  
  private int a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase, int paramInt3)
  {
    f localf2 = null;
    if (paramInt1 != 0) {
      localf2 = (f)this.b.get(paramInt1);
    }
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = localf2;
      if (paramInt2 != 0) {
        localf1 = (f)this.c.get(paramInt2);
      }
    }
    if (localf1 != null)
    {
      if (localf1.b(paramInt1, paramString1, paramString3, paramString2)) {
        return localf1.a();
      }
      localf1.a(paramInt1, paramString1, paramString3, paramString2);
      paramString1 = w.f(5);
      paramString1[0] = localf1.c();
      paramString1[1] = localf1.g();
      paramString1[2] = localf1.d();
      paramString1[3] = Integer.valueOf(localf1.b());
      paramString1[4] = Integer.valueOf(localf1.a());
      paramSQLiteDatabase.execSQL("UPDATE friends SET name = ?,  avatar_url = ?,  username = ?,  friend_id = ?  WHERE local_friend_id = ?", paramString1);
      a(localf1);
      this.e = true;
      return localf1.a();
    }
    if (paramInt3 != 0) {}
    for (;;)
    {
      localf1 = new f(new m(paramInt3, paramInt1), paramString3, paramString1, paramString2, 0L);
      paramString1 = w.f(5);
      paramString1[0] = Integer.valueOf(localf1.a());
      paramString1[1] = Integer.valueOf(localf1.b());
      paramString1[2] = localf1.g();
      paramString1[3] = localf1.c();
      paramString1[4] = localf1.d();
      paramSQLiteDatabase.execSQL("INSERT INTO friends (local_friend_id, friend_id, avatar_url, name, username) VALUES (?,?,?,?,?) ", paramString1);
      break;
      paramInt3 = this.a.a();
    }
  }
  
  private int a(int paramInt1, g paramg, SQLiteDatabase paramSQLiteDatabase, int paramInt2)
  {
    return a(paramg.a, paramInt1, paramg.c, paramg.e, paramg.d, paramSQLiteDatabase, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, SQLiteDatabase paramSQLiteDatabase)
  {
    Object[] arrayOfObject = w.f(1);
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    paramSQLiteDatabase.execSQL("DELETE FROM friends WHERE local_friend_id = ?", arrayOfObject);
    if (paramInt2 != 0) {
      this.b.delete(paramInt2);
    }
    this.c.delete(paramInt1);
  }
  
  private void a(f paramf, long paramLong, SQLiteDatabase paramSQLiteDatabase)
  {
    paramf.a(paramLong);
    Object[] arrayOfObject = w.f(2);
    arrayOfObject[0] = Long.valueOf(paramf.l());
    arrayOfObject[1] = Integer.valueOf(paramf.a());
    paramSQLiteDatabase.execSQL("UPDATE friends SET last_share_time = ?  WHERE local_friend_id = ?", arrayOfObject);
    this.e = true;
  }
  
  private void a(String paramString, int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    Object[] arrayOfObject = w.f(2);
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = paramString;
    paramSQLiteDatabase.execSQL("INSERT OR REPLACE INTO ac_emails (local_friend_id, email) VALUES (?,?) ", arrayOfObject);
    this.d.put(paramString.toLowerCase(), Integer.valueOf(paramInt));
    this.e = true;
  }
  
  public f a(int paramInt)
  {
    return (f)this.b.get(paramInt);
  }
  
  public f a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    paramString = (Integer)this.d.get(paramString.toLowerCase());
    if (paramString != null) {
      return (f)this.c.get(paramString.intValue());
    }
    return null;
  }
  
  protected void a()
  {
    if (!this.e) {}
    for (;;)
    {
      this.e = false;
      return;
      SparseArray localSparseArray1 = new SparseArray(this.b.size());
      t.a(localSparseArray1, this.b);
      SparseArray localSparseArray2 = new SparseArray(this.c.size());
      t.a(localSparseArray2, this.c);
      o.a(localSparseArray1, localSparseArray2, new HashMap(this.d));
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramInt1 == 0) {
      throw new RuntimeException("Cannot resolve without a local id");
    }
    if (paramInt2 == 0) {
      throw new RuntimeException("Cannot resolve without an id");
    }
    f localf1 = (f)this.b.get(paramInt2);
    if ((localf1 != null) && (localf1.a() != paramInt1))
    {
      f localf2 = (f)this.c.get(paramInt1);
      a(paramInt2, localf1.a(), paramString1, paramString2, paramString3, paramSQLiteDatabase, 0);
      paramString1 = w.f(2);
      paramString1[0] = Integer.valueOf(localf1.a());
      paramString1[1] = Integer.valueOf(localf2.a());
      paramSQLiteDatabase.execSQL("UPDATE ac_emails SET local_friend_id = ?  WHERE local_friend_id = ?", paramString1);
      paramString1 = localf2.i().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramString3 = paramString2.toLowerCase();
        this.d.remove(paramString3);
        this.d.put(paramString3, Integer.valueOf(localf1.a()));
        localf1.a(paramString2);
      }
      a(localf2.a(), 0, paramSQLiteDatabase);
      this.e = true;
      return;
    }
    a(paramInt2, paramInt1, paramString1, paramString2, paramString3, paramSQLiteDatabase, 0);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramInt, 0, paramString1, paramString2, paramString3, paramSQLiteDatabase, 1);
  }
  
  protected void a(f paramf)
  {
    if (paramf.b() != 0) {
      this.b.put(paramf.b(), paramf);
    }
    this.c.put(paramf.a(), paramf);
    this.e = true;
  }
  
  public void a(JsonParser paramJsonParser, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {}
    for (JsonToken localJsonToken = JsonToken.END_ARRAY;; localJsonToken = JsonToken.END_OBJECT)
    {
      g localg = new g();
      while ((paramJsonParser.nextToken() != localJsonToken) && (!paramJsonParser.isClosed()))
      {
        if (localJsonToken == JsonToken.END_OBJECT) {
          paramJsonParser.nextToken();
        }
        if (localg.a(paramJsonParser)) {
          a(0, localg, paramSQLiteDatabase, 0);
        }
      }
    }
    a();
  }
  
  public f b(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    f localf = a(paramString, paramSQLiteDatabase);
    if (localf != null) {
      return localf;
    }
    int i = a(0, 0, paramString, null, null, paramSQLiteDatabase, 0);
    localf = (f)this.c.get(i);
    a(paramString, i, paramSQLiteDatabase);
    localf.a(paramString);
    return localf;
  }
  
  public void b()
  {
    this.e = true;
  }
  
  public void b(JsonParser paramJsonParser, SQLiteDatabase paramSQLiteDatabase)
  {
    JsonToken localJsonToken;
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      localJsonToken = JsonToken.END_ARRAY;
    }
    while ((paramJsonParser.nextToken() != localJsonToken) && (!paramJsonParser.isClosed()))
    {
      if (localJsonToken == JsonToken.END_OBJECT) {
        paramJsonParser.nextToken();
      }
      String str = null;
      int i = 0;
      for (;;)
      {
        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
          break label130;
        }
        localObject = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        if ("friend_id".equals(localObject))
        {
          i = paramJsonParser.getValueAsInt();
          continue;
          localJsonToken = JsonToken.END_OBJECT;
          break;
        }
        if ("email".equals(localObject)) {
          str = l.a(paramJsonParser);
        } else {
          paramJsonParser.skipChildren();
        }
      }
      label130:
      Object localObject = a(str, paramSQLiteDatabase);
      f localf;
      if (localObject != null)
      {
        if ((i != 0) && (((f)localObject).b() == 0))
        {
          localf = (f)this.b.get(i);
          if (localf == null) {
            throw new RuntimeException("Missing friend with id of " + i);
          }
          if (((f)localObject).a() < localf.a())
          {
            a(localf.a(), i, paramSQLiteDatabase);
            a(((f)localObject).a(), i, localf.c(), localf.g(), localf.d(), paramSQLiteDatabase);
          }
          for (;;)
          {
            this.e = true;
            break;
            Object[] arrayOfObject = w.f(2);
            arrayOfObject[0] = Integer.valueOf(localf.a());
            arrayOfObject[1] = Integer.valueOf(((f)localObject).a());
            paramSQLiteDatabase.execSQL("UPDATE ac_emails SET local_friend_id = ?  WHERE local_friend_id = ?", arrayOfObject);
            a(((f)localObject).a(), 0, paramSQLiteDatabase);
            if (!localf.b(str))
            {
              localf.a(str);
              a(str, localf.a(), paramSQLiteDatabase);
            }
          }
        }
      }
      else
      {
        if (i != 0)
        {
          localf = a(i);
          localObject = localf;
          if (localf == null) {
            throw new RuntimeException("Missing friend with id of " + i);
          }
        }
        else
        {
          i = a(0, 0, str, null, null, paramSQLiteDatabase, 0);
          localObject = (f)this.c.get(i);
        }
        ((f)localObject).a(str);
        a(str, ((f)localObject).a(), paramSQLiteDatabase);
        this.e = true;
      }
    }
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */