package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.ap;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.cl;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestAdResponse;
import java.util.Iterator;
import java.util.List;

public abstract class AdReport<T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
  extends ar<Integer>
{
  protected A a;
  protected String b;
  protected String c;
  protected Long d;
  protected boolean e;
  protected a f;
  protected Long g;
  protected Integer h;
  protected Long i;
  protected Long j;
  protected List<P> k;
  
  private List<P> w()
  {
    List localList2 = this.k;
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = a().a(this, false);
      this.k = localList1;
    }
    return localList1;
  }
  
  protected ContentValues a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues();
    Long localLong;
    if (paramBoolean)
    {
      localContentValues.put("ad_id", d());
      localLong = Long.valueOf(l);
      this.d = localLong;
      localContentValues.put("insert_timestamp_millis", localLong);
    }
    for (;;)
    {
      localContentValues.put("is_incentivized", Boolean.valueOf(this.e));
      localContentValues.put("status", cl.a(this.f));
      localLong = Long.valueOf(l);
      this.g = localLong;
      localContentValues.put("update_timestamp_millis", localLong);
      return localContentValues;
      localContentValues.put("incentivized_publisher_app_user_id", this.c);
      localContentValues.put("video_duration_millis", this.h);
      localContentValues.put("view_end_millis", this.i);
      localContentValues.put("view_start_millis", this.j);
    }
  }
  
  protected abstract AdPlay.Factory<T, P, E, A, V, R> a();
  
  public final void a(a parama)
  {
    Logger.d("VungleReport", "setting ad_report status " + parama + " for " + u());
    this.f = parama;
  }
  
  public final void a(Integer paramInteger)
  {
    Logger.d("VungleReport", "setting video duration millis " + paramInteger + " for " + u());
    this.h = paramInteger;
    l();
  }
  
  public final void a(Long paramLong)
  {
    Logger.d("VungleReport", "setting ad end millis " + paramLong + " for " + u());
    this.i = paramLong;
    l();
  }
  
  protected final void a(String paramString)
  {
    this.b = paramString;
  }
  
  protected final String b()
  {
    return "ad_report";
  }
  
  public final void b(Long paramLong)
  {
    Logger.d("VungleReport", "setting ad start millis " + paramLong + " for " + u());
    this.j = paramLong;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected final String d()
  {
    if (this.a == null) {
      return this.b;
    }
    return this.a.d();
  }
  
  public final A e()
  {
    return this.a;
  }
  
  public final boolean f()
  {
    return this.e;
  }
  
  public final String g()
  {
    return this.c;
  }
  
  public final Integer h()
  {
    return this.h;
  }
  
  public final int i()
  {
    if ((this.j == null) || (this.i == null)) {
      return -1;
    }
    return (int)(this.i.longValue() - this.j.longValue());
  }
  
  public final Long j()
  {
    return this.j;
  }
  
  public final P k()
  {
    List localList = w();
    AdPlay localAdPlay = a().a(this);
    localAdPlay.o();
    localList.add(localAdPlay);
    return localAdPlay;
  }
  
  public StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "ad_id", d());
    cl.a(localStringBuilder, "insert_timestamp_millis", this.d);
    cl.a(localStringBuilder, "incentivized_publisher_app_user_id", this.c);
    cl.a(localStringBuilder, "is_incentivized", Boolean.valueOf(this.e));
    cl.a(localStringBuilder, "status", this.f);
    cl.a(localStringBuilder, "update_timestamp_millis", this.g);
    cl.a(localStringBuilder, "video_duration_millis", this.h);
    cl.a(localStringBuilder, "view_end_millis", this.i);
    cl.a(localStringBuilder, "view_start_millis", this.j);
    if (this.k == null) {}
    for (Object localObject = "not fetched";; localObject = Integer.valueOf(this.k.size()))
    {
      cl.a(localStringBuilder, "plays", localObject);
      return localStringBuilder;
    }
  }
  
  public final P[] q()
  {
    List localList = w();
    return (AdPlay[])localList.toArray(a().b(localList.size()));
  }
  
  public static abstract class Factory<T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
    extends ar.a<T, Integer>
  {
    private T a(T paramT, A paramA, boolean paramBoolean)
    {
      if (paramA == null) {}
      for (paramT.a = ((Ad)a().a(paramT.d(), false));; paramT.a = paramA)
      {
        if (paramBoolean) {
          paramT.k = b().a(paramT, paramBoolean);
        }
        return paramT;
      }
    }
    
    private T c(A paramA)
    {
      if (paramA == null) {
        throw new IllegalArgumentException("null ad");
      }
      String str = paramA.d();
      if (str == null) {
        throw new IllegalArgumentException("null ad_id");
      }
      List localList = a("ad_report", "ad_id = ? AND status = ?", new String[] { str, AdReport.a.a.toString() }, "insert_timestamp_millis DESC");
      str = "ad_id " + str + ", status " + AdReport.a.a;
      int i = localList.size();
      switch (i)
      {
      default: 
        Logger.w("VungleDatabase", i + " ad_report records for " + str);
      case 0: 
        return null;
      }
      return a((AdReport)localList.get(0), paramA, false);
    }
    
    protected abstract Ad.Factory<A, V, R> a();
    
    public final T a(A paramA)
    {
      AdReport localAdReport2 = c(paramA);
      AdReport localAdReport1 = localAdReport2;
      if (localAdReport2 == null)
      {
        localAdReport1 = (AdReport)b_();
        localAdReport1.a = paramA;
        localAdReport1.f = AdReport.a.a;
        Logger.d("VungleDatabase", "creating new " + localAdReport1.u());
        localAdReport1.o();
      }
      return localAdReport1;
    }
    
    protected T a(T paramT, Cursor paramCursor, boolean paramBoolean)
    {
      paramT.n = ap.c(paramCursor, "id");
      paramT.a(ap.f(paramCursor, "ad_id"));
      paramT.c = ap.f(paramCursor, "incentivized_publisher_app_user_id");
      paramT.e = ap.a(paramCursor, "is_incentivized").booleanValue();
      paramT.d = ap.e(paramCursor, "insert_timestamp_millis");
      paramT.f = ((AdReport.a)ap.a(paramCursor, "status", AdReport.a.class));
      paramT.g = ap.e(paramCursor, "update_timestamp_millis");
      paramT.h = ap.c(paramCursor, "video_duration_millis");
      paramT.i = ap.e(paramCursor, "view_end_millis");
      paramT.j = ap.e(paramCursor, "view_start_millis");
      return paramT;
    }
    
    protected abstract AdPlay.Factory<T, P, E, A, V, R> b();
    
    public final T b(A paramA)
    {
      return c(paramA);
    }
    
    public final List<T> c()
    {
      List localList = a("ad_report", "status = ?", new String[] { AdReport.a.c.toString() }, "insert_timestamp_millis ASC");
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        a((AdReport)localIterator.next(), null, true);
      }
      return localList;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/AdReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */