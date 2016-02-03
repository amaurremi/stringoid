package com.ideashower.readitlater.db.operation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.e.s;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.objects.UserMessage;
import com.pocket.user.UserMeta;
import java.io.InputStream;
import java.math.BigDecimal;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class p
  extends b
{
  private final com.pocket.c.o e;
  private final boolean p;
  private final InputStream q;
  private final JsonParser r;
  private boolean s = false;
  private long t = 0L;
  private UserMessage u;
  private boolean v = false;
  private com.ideashower.readitlater.e.l w;
  
  public p(com.pocket.c.o paramo, InputStream paramInputStream)
  {
    this.e = paramo;
    this.q = paramInputStream;
    this.r = null;
    this.b = true;
    this.a = false;
    this.p = false;
    if ((paramo.n()) || (!i.a(com.ideashower.readitlater.h.a.aU))) {
      l();
    }
  }
  
  public p(InputStream paramInputStream)
  {
    this.e = null;
    this.q = paramInputStream;
    this.r = null;
    this.b = false;
    this.a = false;
    this.p = true;
    l();
  }
  
  public p(JsonParser paramJsonParser)
  {
    this.e = null;
    this.q = null;
    this.r = paramJsonParser;
    this.b = false;
    this.a = false;
    this.p = true;
    l();
  }
  
  private void a(JsonParser paramJsonParser)
  {
    u();
    while ((paramJsonParser.nextToken() != JsonToken.END_ARRAY) && (!paramJsonParser.isClosed()))
    {
      int i = 0;
      String str3 = null;
      String str2 = null;
      String str1 = null;
      while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
      {
        String str4 = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        if ("search".equals(str4)) {
          str1 = com.ideashower.readitlater.util.l.a(paramJsonParser);
        } else if ("context_key".equals(str4)) {
          str2 = com.ideashower.readitlater.util.l.a(paramJsonParser);
        } else if ("context_value".equals(str4)) {
          str3 = com.ideashower.readitlater.util.l.a(paramJsonParser);
        } else if ("sort_id".equals(str4)) {
          i = (int)b(paramJsonParser);
        } else {
          paramJsonParser.skipChildren();
        }
      }
      a(str1, str2, str3, i);
    }
  }
  
  private void a(JsonParser paramJsonParser, SparseArray paramSparseArray)
  {
    s();
    while ((paramJsonParser.nextToken() != JsonToken.END_ARRAY) && (!paramJsonParser.isClosed()))
    {
      double d = 0.0D;
      int i = 0;
      int j = 0;
      if ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
      {
        String str = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        int k;
        if ("item_id".equals(str))
        {
          k = paramJsonParser.getValueAsInt();
          i = j;
          j = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if ("sort".equals(str))
          {
            d = b(paramJsonParser);
            k = i;
            i = j;
            j = k;
          }
          else if ("group_id".equals(str))
          {
            k = paramJsonParser.getValueAsInt();
            j = i;
            i = k;
          }
          else
          {
            paramJsonParser.skipChildren();
            k = i;
            i = j;
            j = k;
          }
        }
      }
      if ((q)paramSparseArray.get(i) != null) {
        a(((q)paramSparseArray.get(i)).a, d, j);
      }
    }
  }
  
  private static double b(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {}
    for (paramJsonParser = new BigDecimal(com.ideashower.readitlater.util.l.a(paramJsonParser));; paramJsonParser = paramJsonParser.getDecimalValue()) {
      return paramJsonParser.doubleValue();
    }
  }
  
  private void b(JsonParser paramJsonParser, SparseArray paramSparseArray)
  {
    t();
    JsonToken localJsonToken;
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      localJsonToken = JsonToken.END_ARRAY;
    }
    for (;;)
    {
      double d1;
      int i;
      label53:
      Object localObject;
      if ((paramJsonParser.nextToken() != localJsonToken) && (!paramJsonParser.isClosed()))
      {
        if (localJsonToken == JsonToken.END_OBJECT) {
          paramJsonParser.nextToken();
        }
        d1 = 0.0D;
        i = 0;
        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
          break label308;
        }
        localObject = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        if (!"group_id".equals(localObject)) {
          break label124;
        }
        i = paramJsonParser.getValueAsInt();
      }
      label124:
      label284:
      label305:
      for (;;)
      {
        break label53;
        if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
        {
          localJsonToken = JsonToken.END_OBJECT;
          break;
        }
        paramJsonParser.skipChildren();
        return;
        if ("sort".equals(localObject))
        {
          d1 = b(paramJsonParser);
        }
        else
        {
          if ("items".equals(localObject))
          {
            int j;
            if (i == 0)
            {
              throw new JsonParseException("group id cannot be 0, or items were returned first", paramJsonParser.getCurrentLocation());
              localObject = (q)paramSparseArray.get(j);
              if (localObject != null) {
                break label284;
              }
            }
            for (;;)
            {
              if ((paramJsonParser.nextToken() == JsonToken.END_ARRAY) || (paramJsonParser.isClosed())) {
                break label305;
              }
              double d2 = 0.0D;
              j = 0;
              while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
              {
                localObject = paramJsonParser.getCurrentName();
                paramJsonParser.nextToken();
                if ("item_id".equals(localObject)) {
                  j = paramJsonParser.getValueAsInt();
                } else if ("sort".equals(localObject)) {
                  d2 = b(paramJsonParser);
                } else {
                  paramJsonParser.skipChildren();
                }
              }
              break;
              b(((q)localObject).a, d2, i);
            }
          }
          paramJsonParser.skipChildren();
        }
      }
      label308:
      a(i, d1);
    }
  }
  
  private void c(JsonParser paramJsonParser)
  {
    this.h.execSQL("DELETE FROM unconfirmed_shares");
    Object[] arrayOfObject = f(2);
    JsonToken localJsonToken;
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      localJsonToken = JsonToken.END_ARRAY;
    }
    for (;;)
    {
      if ((paramJsonParser.nextToken() != localJsonToken) && (!paramJsonParser.isClosed()))
      {
        if (localJsonToken == JsonToken.END_OBJECT) {
          paramJsonParser.nextToken();
        }
        arrayOfObject[0] = null;
        arrayOfObject[1] = null;
      }
      for (;;)
      {
        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
          break label162;
        }
        String str = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        if ("email".equals(str))
        {
          arrayOfObject[0] = com.ideashower.readitlater.util.l.a(paramJsonParser);
          continue;
          if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
          {
            localJsonToken = JsonToken.END_OBJECT;
            break;
          }
          paramJsonParser.skipChildren();
          return;
        }
        if ("from".equals(str)) {
          arrayOfObject[1] = com.ideashower.readitlater.util.l.a(paramJsonParser);
        } else {
          paramJsonParser.skipChildren();
        }
      }
      label162:
      this.h.execSQL("INSERT INTO unconfirmed_shares ( email, friend ) VALUES (?,?) ", arrayOfObject);
      if (this.c) {
        i.b().a((com.ideashower.readitlater.h.b)com.ideashower.readitlater.h.a.bB.a((String)arrayOfObject[0]), true).a();
      }
    }
  }
  
  private SparseArray g()
  {
    Cursor localCursor = this.h.rawQuery(" SELECT unique_id, item_id, resolved_id, status, time_removed FROM items", null);
    SparseArray localSparseArray = new SparseArray();
    if (localCursor.moveToNext())
    {
      int i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
      int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("resolved_id"));
      int k = localCursor.getInt(localCursor.getColumnIndexOrThrow("item_id"));
      boolean bool;
      if (com.ideashower.readitlater.e.o.l(localCursor.getInt(localCursor.getColumnIndexOrThrow("status")))) {
        if (localCursor.getLong(localCursor.getColumnIndexOrThrow("time_removed")) > 0L) {
          bool = true;
        }
      }
      for (;;)
      {
        localSparseArray.put(k, new q(this, i, j, bool));
        break;
        bool = false;
        continue;
        bool = false;
      }
    }
    localCursor.close();
    return localSparseArray;
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    if ((paramBoolean) && (!a_())) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.w != null)) {
        this.w.b();
      }
      if ((i != 0) && (!this.p)) {
        this.e.a(this.s, this.t, this.u);
      }
      return;
    }
  }
  
  protected void c_()
  {
    if ((!p()) && (!this.p))
    {
      this.v = true;
      D();
      return;
    }
    Object localObject1 = g();
    int i = 0;
    JsonParser localJsonParser;
    boolean bool1;
    long l;
    Object localObject2;
    label60:
    Object localObject3;
    if (this.r != null)
    {
      localJsonParser = this.r;
      localJsonParser.nextToken();
      bool1 = false;
      l = 0L;
      localObject2 = null;
      if ((localJsonParser.nextToken() == JsonToken.END_OBJECT) || (localJsonParser.isClosed())) {
        break label1068;
      }
      localObject3 = localJsonParser.getCurrentName();
      localJsonParser.nextToken();
      if (!"since".equals(localObject3)) {
        break label158;
      }
      l = Long.valueOf(com.ideashower.readitlater.util.l.a(localJsonParser)).longValue();
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label128:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label60;
      localJsonParser = com.ideashower.readitlater.util.l.d().createJsonParser(this.q);
      break;
      label158:
      if ("userMessage".equals(localObject3))
      {
        if (this.p)
        {
          localJsonParser.skipChildren();
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          localObject3 = UserMessage.a(localJsonParser);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      else if ("update_list_info".equals(localObject3))
      {
        if (this.p)
        {
          localJsonParser.skipChildren();
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          this.e.b(Integer.valueOf(com.ideashower.readitlater.util.l.a(localJsonParser)).intValue());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      else if ("lastLoginRuleCheck".equals(localObject3))
      {
        if (this.p)
        {
          localJsonParser.skipChildren();
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          com.ideashower.readitlater.a.a.a.b(Integer.valueOf(com.ideashower.readitlater.util.l.a(localJsonParser)).intValue());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      else if ("account".equals(localObject3))
      {
        localObject3 = UserMeta.a(localJsonParser);
        if (localObject3 != null) {
          as.a((UserMeta)localObject3);
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else if ("tags".equals(localObject3))
      {
        this.h.execSQL("DELETE FROM tags");
        localObject3 = f(1);
        while ((localJsonParser.nextToken() != JsonToken.END_ARRAY) && (!localJsonParser.isClosed()))
        {
          localObject3[0] = com.ideashower.readitlater.util.l.a(localJsonParser);
          this.h.execSQL("INSERT INTO tags ( tag ) VALUES (?)", (Object[])localObject3);
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else if ("groups".equals(localObject3))
      {
        this.w = com.ideashower.readitlater.e.k.a().c().a(localJsonParser).a();
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else if ("friends".equals(localObject3))
      {
        k().a(localJsonParser, this.h);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else if ("auto_complete_emails".equals(localObject3))
      {
        k().b(localJsonParser, this.h);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else if ("unconfirmed_shares".equals(localObject3))
      {
        c(localJsonParser);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        if (!"list".equals(localObject3)) {
          break label921;
        }
        if (localJsonParser.getCurrentToken() == JsonToken.START_ARRAY)
        {
          localJsonParser.nextToken();
          break label60;
        }
        while ((localJsonParser.nextToken() != JsonToken.END_OBJECT) && (!localJsonParser.isClosed()))
        {
          localJsonParser.nextToken();
          localObject3 = s.a(localJsonParser, null);
          q localq = (q)((SparseArray)localObject1).get(((com.ideashower.readitlater.e.o)localObject3).c());
          if (localq != null) {}
          int k;
          for (int j = 1;; j = 0)
          {
            k = ((com.ideashower.readitlater.e.o)localObject3).al();
            if (((k != 1) && (k != 2)) || (((com.ideashower.readitlater.e.o)localObject3).aq()) || ((localq != null) && (localq.c))) {
              break label781;
            }
            if (j == 0) {
              break;
            }
            d(localq.a);
            break;
          }
          label781:
          if ((k != 2) || (j == 0) || (!localq.c)) {
            if (j != 0)
            {
              ((com.ideashower.readitlater.e.o)localObject3).a(localq.a);
              if ((localq.b == 0) && (((com.ideashower.readitlater.e.o)localObject3).M())) {
                b((com.ideashower.readitlater.e.o)localObject3, true);
              } else {
                b((com.ideashower.readitlater.e.o)localObject3, false);
              }
            }
            else if ((k == 0) || (k == 3) || (((com.ideashower.readitlater.e.o)localObject3).aq()))
            {
              a((com.ideashower.readitlater.e.o)localObject3, true);
              boolean bool2 = true;
              bool1 = bool2;
              if (!this.p)
              {
                this.e.a(((com.ideashower.readitlater.e.o)localObject3).p());
                bool1 = bool2;
              }
            }
          }
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    label921:
    if ("carousel".equals(localObject3))
    {
      if ((i != 0) || (!bool1)) {
        break label1111;
      }
      localObject3 = g();
      i = 1;
    }
    for (;;)
    {
      a(localJsonParser, (SparseArray)localObject3);
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label128;
      if ("highlights".equals(localObject3))
      {
        if ((i != 0) || (!bool1)) {
          break label1104;
        }
        localObject3 = g();
        i = 1;
      }
      for (;;)
      {
        b(localJsonParser, (SparseArray)localObject3);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label128;
        if ("recent_searches".equals(localObject3))
        {
          a(localJsonParser);
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break label128;
        }
        localJsonParser.skipChildren();
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label128;
        label1068:
        localJsonParser.close();
        this.s = bool1;
        this.t = l;
        this.u = ((UserMessage)localObject2);
        if (localObject2 == null) {
          break;
        }
        ((UserMessage)localObject2).a(l);
        return;
        label1104:
        localObject3 = localObject1;
      }
      label1111:
      localObject3 = localObject1;
    }
  }
  
  public boolean e()
  {
    return this.v;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */