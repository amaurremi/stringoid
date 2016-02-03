package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.ap;
import com.vungle.publisher.cl;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalAdReport
  extends AdReport<LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo, RequestLocalAdResponse>
{
  Long l;
  @Inject
  Factory p;
  @Inject
  LocalAdPlay.Factory q;
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = super.a(paramBoolean);
    localContentValues.put("download_end_millis", this.l);
    return localContentValues;
  }
  
  public final void c(Long paramLong)
  {
    this.l = paramLong;
    Logger.d("VungleReport", "setting ad download end millis " + paramLong + " (duration " + w() + " ms) for " + u());
    t();
  }
  
  public final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "download_end_millis", this.l);
    return localStringBuilder;
  }
  
  public final int w()
  {
    if (this.l == null)
    {
      Logger.w("VungleReport", "download end millis null for " + u());
      return -1;
    }
    if (this.l.longValue() < 0L) {
      return 0;
    }
    if (this.d == null)
    {
      Logger.w("VungleReport", "insert timestamp millis null for " + u());
      return -1;
    }
    return (int)(this.l.longValue() - this.d.longValue());
  }
  
  @Singleton
  public static class Factory
    extends AdReport.Factory<LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo, RequestLocalAdResponse>
  {
    @Inject
    LocalAd.Factory a;
    @Inject
    LocalAdPlay.Factory c;
    @Inject
    Provider<LocalAdReport> d;
    
    private LocalAdReport a(LocalAdReport paramLocalAdReport, Cursor paramCursor, boolean paramBoolean)
    {
      super.a(paramLocalAdReport, paramCursor, paramBoolean);
      paramLocalAdReport.l = ap.e(paramCursor, "download_end_millis");
      return paramLocalAdReport;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */