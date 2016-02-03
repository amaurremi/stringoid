package com.ideashower.readitlater.db.operation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.q;
import com.ideashower.readitlater.e.u;
import com.ideashower.readitlater.objects.h;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

public class r
  extends b
{
  private static final Comparator e = new Comparator()
  {
    private int a(o paramAnonymouso)
    {
      if (paramAnonymouso.ah() != null) {
        return paramAnonymouso.ah().b().f();
      }
      return 0;
    }
    
    public int a(o paramAnonymouso1, o paramAnonymouso2)
    {
      return Integer.signum(a(paramAnonymouso1) - a(paramAnonymouso2));
    }
  };
  private final InputStream p;
  private final boolean q;
  private final h r = new h();
  private Boolean s;
  
  public r(InputStream paramInputStream, boolean paramBoolean)
  {
    this.p = paramInputStream;
    this.q = paramBoolean;
  }
  
  private void a(h paramh)
  {
    Collections.sort(paramh, e);
  }
  
  protected void c_()
  {
    Object localObject;
    SparseArray localSparseArray;
    if (this.q)
    {
      localObject = this.h.rawQuery("SELECT item_id, unique_id, offline_web, offline_text FROM items", null);
      localSparseArray = new SparseArray();
      while (((Cursor)localObject).moveToNext()) {
        localSparseArray.put(((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("item_id")), new s(this, ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("unique_id")), ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("offline_web")), ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("offline_text")), null));
      }
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      JsonParser localJsonParser = l.d().createJsonParser(this.p);
      localJsonParser.nextToken();
      while ((localJsonParser.nextToken() != JsonToken.END_OBJECT) && (!localJsonParser.isClosed()))
      {
        localObject = localJsonParser.getCurrentName();
        localJsonParser.nextToken();
        if ("friends".equals(localObject))
        {
          k().a(localJsonParser, this.h);
        }
        else if ("list".equals(localObject))
        {
          label216:
          label218:
          o localo;
          if (localJsonParser.getCurrentToken() == JsonToken.START_ARRAY)
          {
            localJsonParser.nextToken();
            continue;
            localObject = null;
            if (localObject == null) {
              break label312;
            }
            localo.a(s.a((s)localObject));
            localo.h(s.b((s)localObject));
            localo.i(s.c((s)localObject));
          }
          for (;;)
          {
            this.r.a(localo);
            if ((localJsonParser.nextToken() == JsonToken.END_OBJECT) || (localJsonParser.isClosed())) {
              break;
            }
            localJsonParser.nextToken();
            localo = com.ideashower.readitlater.e.s.a(localJsonParser, null);
            if (localSparseArray == null) {
              break label216;
            }
            localObject = (s)localSparseArray.get(localo.c());
            break label218;
            label312:
            localo.a(-localo.c());
          }
        }
        else if ("search_meta".equals(localObject))
        {
          localObject = l.a().readTree(localJsonParser);
          if (((JsonNode)localObject).has("has_more"))
          {
            if (!l.a((JsonNode)localObject, "has_more", false)) {}
            for (boolean bool = true;; bool = false)
            {
              this.s = Boolean.valueOf(bool);
              break;
            }
          }
        }
        else
        {
          localJsonParser.skipChildren();
        }
      }
      localJsonParser.close();
      a(this.r);
      return;
      localSparseArray = null;
    }
  }
  
  public h e()
  {
    return this.r;
  }
  
  public Boolean g()
  {
    if ((this.r != null) && (this.r.isEmpty())) {
      return Boolean.valueOf(true);
    }
    return this.s;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */