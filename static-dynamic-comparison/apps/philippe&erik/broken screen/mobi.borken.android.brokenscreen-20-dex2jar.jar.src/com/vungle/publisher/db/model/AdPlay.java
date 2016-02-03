package com.vungle.publisher.db.model;

import android.content.ContentValues;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.cl;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestAdResponse;
import java.util.Iterator;
import java.util.List;

public abstract class AdPlay<T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
  extends ar<Integer>
{
  public T a;
  public Integer b;
  public Long c;
  List<E> d;
  
  private List<E> e()
  {
    List localList2 = this.d;
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = a().a(this);
      this.d = localList1;
    }
    return localList1;
  }
  
  private Integer f()
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
      localContentValues.put("report_id", f());
      localContentValues.put("start_millis", this.c);
      return localContentValues;
    }
    localContentValues.put("watched_millis", this.b);
    return localContentValues;
  }
  
  protected abstract AdReportEvent.Factory<T, P, E, A, V, R> a();
  
  public final E a(AdReportEvent.a parama, Object paramObject)
  {
    List localList = e();
    StringBuilder localStringBuilder = new StringBuilder("adding report event ").append(parama);
    if (paramObject == null) {}
    for (String str = "";; str = ", value " + paramObject + " for " + u())
    {
      Logger.d("VungleReport", str);
      parama = a().a(this, parama, paramObject);
      parama.o();
      localList.add(parama);
      return parama;
    }
  }
  
  protected final String b()
  {
    return "ad_play";
  }
  
  public final E[] d()
  {
    List localList = e();
    return (AdReportEvent[])localList.toArray(a().b(localList.size()));
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "report_id", f());
    cl.a(localStringBuilder, "start_millis", this.c);
    cl.a(localStringBuilder, "watched_millis", this.b);
    return localStringBuilder;
  }
  
  public static abstract class Factory<T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
    extends ar.a<P, Integer>
  {
    protected final P a(T paramT)
    {
      AdPlay localAdPlay = (AdPlay)b_();
      localAdPlay.a = paramT;
      return localAdPlay;
    }
    
    protected abstract AdReportEvent.Factory<T, P, E, A, V, R> a();
    
    protected final List<P> a(T paramT, boolean paramBoolean)
    {
      if (paramT == null) {
        throw new IllegalArgumentException("null ad_report");
      }
      Object localObject = (Integer)paramT.p();
      if (localObject == null) {
        throw new IllegalArgumentException("null report_id");
      }
      localObject = a("ad_play", "report_id = ?", new String[] { ((Integer)localObject).toString() }, "start_millis ASC", paramBoolean);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        ((AdPlay)localIterator.next()).a = paramT;
      }
      return (List<P>)localObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/AdPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */