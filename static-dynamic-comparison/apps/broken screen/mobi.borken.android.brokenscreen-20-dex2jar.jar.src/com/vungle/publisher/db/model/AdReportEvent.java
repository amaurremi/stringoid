package com.vungle.publisher.db.model;

import android.content.ContentValues;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.cl;
import com.vungle.publisher.protocol.message.RequestAdResponse;
import java.util.Iterator;
import java.util.List;

public abstract class AdReportEvent<T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
  extends ar<Integer>
{
  P a;
  public a b;
  public long c;
  public String d;
  private String e;
  
  private Integer d()
  {
    if (this.a == null) {
      return null;
    }
    return (Integer)this.a.p();
  }
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      this.c = l;
      localContentValues.put("insert_timestamp_millis", Long.valueOf(l));
      localContentValues.put("play_id", d());
      localContentValues.put("event", cl.a(this.b));
      localContentValues.put("value", this.d);
    }
    return localContentValues;
  }
  
  protected final String b()
  {
    return "ad_report_event";
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "play_id", d());
    cl.a(localStringBuilder, "event", this.b);
    cl.a(localStringBuilder, "insert_timestamp_millis", Long.valueOf(this.c));
    cl.a(localStringBuilder, "value", this.d);
    return localStringBuilder;
  }
  
  public String toString()
  {
    String str2 = this.e;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = super.toString();
      this.e = str1;
    }
    return str1;
  }
  
  public static abstract class Factory<T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
    extends ar.a<E, Integer>
  {
    protected final E a(P paramP, AdReportEvent.a parama, Object paramObject)
    {
      if (paramP == null) {
        throw new IllegalArgumentException("null ad_play");
      }
      if (parama == null) {
        throw new IllegalArgumentException("null event");
      }
      AdReportEvent localAdReportEvent = (AdReportEvent)b_();
      localAdReportEvent.a = paramP;
      localAdReportEvent.b = parama;
      if (paramObject == null) {}
      for (paramP = null;; paramP = paramObject.toString())
      {
        localAdReportEvent.d = paramP;
        return localAdReportEvent;
      }
    }
    
    protected final List<E> a(P paramP)
    {
      if (paramP == null) {
        throw new IllegalArgumentException("null ad_play");
      }
      Object localObject = (Integer)paramP.p();
      if (localObject == null) {
        throw new IllegalArgumentException("null play_id");
      }
      localObject = a("ad_report_event", "play_id = ?", new String[] { ((Integer)localObject).toString() }, "insert_timestamp_millis ASC");
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        ((AdReportEvent)localIterator.next()).a = paramP;
      }
      return (List<E>)localObject;
    }
  }
  
  public static enum a
  {
    private final String n;
    
    private a()
    {
      this(null);
    }
    
    private a(String paramString)
    {
      this.n = paramString;
    }
    
    public final String toString()
    {
      if (this.n == null) {
        return name();
      }
      return this.n;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/AdReportEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */