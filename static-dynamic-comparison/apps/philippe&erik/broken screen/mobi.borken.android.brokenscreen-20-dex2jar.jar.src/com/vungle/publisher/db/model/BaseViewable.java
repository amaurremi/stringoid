package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.vungle.publisher.ap;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.at;
import com.vungle.publisher.at.a;
import com.vungle.publisher.at.b;
import com.vungle.publisher.cl;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestAdResponse;

public abstract class BaseViewable<A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
  extends ar<Integer>
  implements at<A, V, R>
{
  protected String a;
  protected at.a b;
  protected at.b c;
  protected A d;
  
  protected ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramBoolean)
    {
      localContentValues.put("id", (Integer)this.n);
      localContentValues.put("ad_id", this.a);
      localContentValues.put("type", this.c.toString());
    }
    localContentValues.put("status", this.b.toString());
    return localContentValues;
  }
  
  public final void a(at.a parama)
  {
    Logger.v("VunglePrepare", "setting " + this.c + " status from " + this.b + " to " + parama + " for ad_id: " + this.a);
    this.b = parama;
  }
  
  protected final String b()
  {
    return "viewable";
  }
  
  protected abstract Ad.Factory<A, V, R> d();
  
  public final Integer e()
  {
    return (Integer)this.n;
  }
  
  public final String f()
  {
    return this.a;
  }
  
  public final A g()
  {
    if (this.d == null) {
      this.d = ((Ad)d().a(this.a, false));
    }
    return this.d;
  }
  
  public final at.a h()
  {
    return this.b;
  }
  
  public final at.b i()
  {
    return this.c;
  }
  
  protected StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "ad_id", this.a);
    cl.a(localStringBuilder, "status", this.b);
    cl.a(localStringBuilder, "type", this.c);
    return localStringBuilder;
  }
  
  protected final String v()
  {
    return String.valueOf(this.c);
  }
  
  public static abstract class Factory<A extends Ad<A, V, R>, W extends BaseViewable<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
    extends ar.a<W, Integer>
  {
    private W a(W paramW, boolean paramBoolean)
      throws SQLException
    {
      Object localObject3 = null;
      localObject1 = (Integer)paramW.n;
      at.b localb = paramW.c;
      for (;;)
      {
        try
        {
          localObject2 = paramW.a;
          if (localObject1 != null) {
            continue;
          }
          if (localObject2 != null) {
            continue;
          }
          Logger.w("VungleDatabase", "unable to fetch " + localb + ": no id or ad_id");
          str = null;
          localObject1 = null;
          localObject2 = localObject3;
          if (localObject1 == null) {
            continue;
          }
        }
        finally
        {
          Object localObject2;
          String str;
          int i;
          localObject1 = null;
          continue;
          continue;
        }
        try
        {
          i = ((Cursor)localObject1).getCount();
          switch (i)
          {
          case 0: 
            throw new SQLException(i + " " + localb + " records for " + str);
          }
        }
        finally {}
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        throw paramW;
        str = "ad_id " + (String)localObject2;
        Logger.d("VungleDatabase", "fetching " + localb + " by " + str);
        localObject1 = this.b.getReadableDatabase().query("viewable", null, "ad_id = ? AND type = ?", new String[] { localObject2, String.valueOf(localb) }, null, null, null);
        continue;
        str = "id: " + localObject1;
        Logger.d("VungleDatabase", "fetching " + localb + " by " + str);
        localObject1 = this.b.getReadableDatabase().query("viewable", null, "id = ?", new String[] { String.valueOf(localObject1) }, null, null, null);
      }
      Logger.v("VungleDatabase", "no " + localb + " found for " + str);
      for (localObject2 = localObject3;; localObject2 = a(paramW, (Cursor)localObject1, paramBoolean))
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        Logger.v("VungleDatabase", "fetched " + localObject2);
        return (W)localObject2;
        Logger.d("VungleDatabase", "have " + localb + " for " + str);
        ((Cursor)localObject1).moveToFirst();
      }
    }
    
    protected abstract W a();
    
    protected W a(A paramA, R paramR)
    {
      BaseViewable localBaseViewable = null;
      if (paramR != null)
      {
        localBaseViewable = a();
        localBaseViewable.d = paramA;
        localBaseViewable.a = paramR.f();
        localBaseViewable.b = at.a.a;
      }
      return localBaseViewable;
    }
    
    protected W a(W paramW, Cursor paramCursor, boolean paramBoolean)
    {
      paramW.n = ap.c(paramCursor, "id");
      paramW.a = ap.f(paramCursor, "ad_id");
      paramW.b = ((at.a)ap.a(paramCursor, "status", at.a.class));
      paramW.c = ((at.b)ap.a(paramCursor, "type", at.b.class));
      return paramW;
    }
    
    protected final W a(String paramString, at.b paramb, boolean paramBoolean)
      throws SQLException
    {
      BaseViewable localBaseViewable = a();
      localBaseViewable.a = paramString;
      localBaseViewable.c = paramb;
      return a(localBaseViewable, paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/BaseViewable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */