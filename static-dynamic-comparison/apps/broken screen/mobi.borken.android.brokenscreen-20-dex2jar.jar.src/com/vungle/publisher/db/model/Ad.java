package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.vungle.publisher.ap;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.at;
import com.vungle.publisher.at.b;
import com.vungle.publisher.cl;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestAdResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public abstract class Ad<A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
  extends ar<String>
{
  protected String a;
  protected String b;
  protected String c;
  protected Map<EventTracking.a, List<EventTracking>> d;
  protected long e;
  protected a f;
  protected b g;
  protected long h;
  protected V i;
  String j;
  protected boolean k;
  boolean l;
  
  protected Ad()
  {
    this.m = String.class;
  }
  
  private Map<EventTracking.a, List<EventTracking>> q()
  {
    return a().a(this);
  }
  
  protected ContentValues a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    this.h = l1;
    ContentValues localContentValues = new ContentValues();
    if (paramBoolean)
    {
      localContentValues.put("id", (String)this.n);
      this.e = l1;
      localContentValues.put("insert_timestamp_seconds", Long.valueOf(l1));
      localContentValues.put("type", this.g.toString());
    }
    localContentValues.put("advertising_app_vungle_id", this.a);
    localContentValues.put("call_to_action_final_url", this.b);
    localContentValues.put("call_to_action_url", this.c);
    localContentValues.put("status", this.f.toString());
    localContentValues.put("update_timestamp_seconds", Long.valueOf(l1));
    return localContentValues;
  }
  
  public <W extends at<A, V, R>> W a(at.b paramb)
  {
    throw new IllegalArgumentException("unknown viewable type: " + paramb);
  }
  
  protected abstract Factory<A, V, R> a();
  
  public void a(a parama)
  {
    a locala = this.f;
    Logger.v("VunglePrepare", "setting status from " + locala + " to " + parama + " for " + u());
    this.f = parama;
  }
  
  public final String[] a(EventTracking.a parama)
  {
    if (q() != null)
    {
      Object localObject = (List)q().get(parama);
      if (localObject != null)
      {
        int m = ((List)localObject).size();
        if (m > 0)
        {
          parama = new String[m];
          m = 0;
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            parama[m] = ((EventTracking)((Iterator)localObject).next()).c;
            m += 1;
          }
          return parama;
        }
      }
    }
    return null;
  }
  
  protected final String b()
  {
    return "ad";
  }
  
  protected final boolean c()
  {
    return false;
  }
  
  public final String d()
  {
    return (String)this.n;
  }
  
  public final String e()
  {
    return this.a;
  }
  
  public final String f()
  {
    return this.b;
  }
  
  public final String g()
  {
    return this.c;
  }
  
  public final a h()
  {
    return this.f;
  }
  
  public final long i()
  {
    return this.h;
  }
  
  public final V j()
  {
    return a().a(this, false);
  }
  
  public String k()
    throws SQLException
  {
    String str = (String)super.o();
    if (this.d != null)
    {
      Iterator localIterator1 = this.d.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        while (localIterator2.hasNext()) {
          ((EventTracking)localIterator2.next()).o();
        }
      }
    }
    if (this.i != null) {
      this.i.o();
    }
    return str;
  }
  
  public int l()
  {
    int m = super.l();
    if ((m == 1) && (this.i != null)) {
      this.i.l();
    }
    return m;
  }
  
  protected final StringBuilder m()
  {
    StringBuilder localStringBuilder = super.m();
    cl.a(localStringBuilder, "type", this.g);
    return localStringBuilder;
  }
  
  protected StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "advertising_app_vungle_id", this.a);
    cl.a(localStringBuilder, "call_to_action_final_url", this.b);
    cl.a(localStringBuilder, "call_to_action_url", this.c);
    cl.a(localStringBuilder, "insert_timestamp_seconds", Long.valueOf(this.e));
    cl.a(localStringBuilder, "status", this.f);
    cl.a(localStringBuilder, "update_timestamp_seconds", Long.valueOf(this.h));
    if (this.d == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.d.size()))
    {
      cl.a(localStringBuilder, "eventTrackings", localObject);
      return localStringBuilder;
    }
  }
  
  public static abstract class Factory<A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
    extends ar.a<A, String>
  {
    @Inject
    EventTracking.Factory a;
    
    private static A b(A paramA, R paramR)
    {
      paramA.a = paramR.b();
      String str = paramR.c();
      paramR = paramR.e();
      if (TextUtils.isEmpty(str))
      {
        paramA.b = paramR;
        return paramA;
      }
      paramA.b = str;
      paramA.c = paramR;
      return paramA;
    }
    
    public int a(A paramA, R paramR)
    {
      b(paramA, paramR);
      a();
      Video.Factory.a(paramA.i, paramR).l();
      EventTracking.Factory localFactory = this.a;
      String str = paramR.f();
      localFactory.a(str);
      paramR = localFactory.a(str, paramR.j());
      EventTracking.Factory.a(paramR);
      paramA.d = paramR;
      return paramA.l();
    }
    
    protected A a(A paramA, Cursor paramCursor, boolean paramBoolean)
    {
      paramA.a = ap.f(paramCursor, "advertising_app_vungle_id");
      paramA.b = ap.f(paramCursor, "call_to_action_final_url");
      paramA.c = ap.f(paramCursor, "call_to_action_url");
      paramA.n = ap.f(paramCursor, "id");
      paramA.e = ap.e(paramCursor, "insert_timestamp_seconds").longValue();
      paramA.f = ((Ad.a)ap.a(paramCursor, "status", Ad.a.class));
      paramA.g = ((Ad.b)ap.a(paramCursor, "type", Ad.b.class));
      paramA.h = ap.e(paramCursor, "update_timestamp_seconds").longValue();
      if (paramBoolean)
      {
        a(paramA);
        a(paramA, paramBoolean);
      }
      return paramA;
    }
    
    protected A a(R paramR)
    {
      Ad localAd = (Ad)b_();
      String str = paramR.f();
      localAd.n = str;
      localAd.d = this.a.a(str, paramR.j());
      localAd.i = a().b(localAd, paramR);
      b(localAd, paramR);
      return localAd;
    }
    
    protected abstract Video.Factory<A, V, R> a();
    
    protected final V a(A paramA, boolean paramBoolean)
    {
      if (paramA.l) {
        return paramA.i;
      }
      Video localVideo = a().a((String)paramA.n, paramBoolean);
      paramA.i = localVideo;
      paramA.l = true;
      return localVideo;
    }
    
    protected final Map<EventTracking.a, List<EventTracking>> a(A paramA)
    {
      if (!paramA.k)
      {
        paramA.d = this.a.b((String)paramA.n);
        paramA.k = true;
      }
      return paramA.d;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/Ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */