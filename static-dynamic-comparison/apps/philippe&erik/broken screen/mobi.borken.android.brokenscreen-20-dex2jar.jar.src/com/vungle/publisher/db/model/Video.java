package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import com.vungle.publisher.ap;
import com.vungle.publisher.at.b;
import com.vungle.publisher.cl;
import com.vungle.publisher.protocol.message.RequestAdResponse;
import com.vungle.publisher.protocol.message.RequestAdResponse.CallToActionOverlay;

public abstract class Video<A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
  extends BaseViewable<A, V, R>
{
  public Float i;
  public Integer j;
  public Integer k;
  public Boolean l;
  public Boolean p;
  public Integer q;
  public Integer r;
  public Integer s;
  public Integer t;
  public Integer u;
  
  protected ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = super.a(paramBoolean);
    localContentValues.put("cta_clickable_percent", this.i);
    localContentValues.put("enable_cta_delay_seconds", this.j);
    localContentValues.put("height", this.k);
    localContentValues.put("is_cta_enabled", this.l);
    localContentValues.put("is_cta_shown_on_touch", this.p);
    localContentValues.put("show_cta_delay_seconds", this.q);
    localContentValues.put("show_close_delay_incentivized_seconds", this.r);
    localContentValues.put("show_close_delay_interstitial_seconds", this.s);
    localContentValues.put("show_countdown_delay_seconds", this.t);
    localContentValues.put("width", this.u);
    return localContentValues;
  }
  
  protected StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "cta_clickable_percent", this.i);
    cl.a(localStringBuilder, "enable_cta_delay_seconds", this.j);
    cl.a(localStringBuilder, "height", this.k);
    cl.a(localStringBuilder, "is_cta_enabled", this.l);
    cl.a(localStringBuilder, "is_cta_shown_on_touch", this.p);
    cl.a(localStringBuilder, "show_cta_delay_seconds", this.q);
    cl.a(localStringBuilder, "show_close_delay_incentivized_seconds", this.r);
    cl.a(localStringBuilder, "show_close_delay_interstitial_seconds", this.s);
    cl.a(localStringBuilder, "show_countdown_delay_seconds", this.t);
    cl.a(localStringBuilder, "width", this.u);
    return localStringBuilder;
  }
  
  public abstract Uri q();
  
  public static abstract class Factory<A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
    extends BaseViewable.Factory<A, V, V, R>
  {
    static V a(V paramV, RequestAdResponse paramRequestAdResponse)
    {
      paramV.k = paramRequestAdResponse.k();
      paramV.r = paramRequestAdResponse.g();
      paramV.s = paramRequestAdResponse.h();
      paramV.t = paramRequestAdResponse.i();
      paramV.u = paramRequestAdResponse.m();
      paramRequestAdResponse = paramRequestAdResponse.d();
      if (paramRequestAdResponse != null)
      {
        paramV.i = paramRequestAdResponse.c();
        paramV.j = paramRequestAdResponse.g();
        paramV.l = paramRequestAdResponse.d();
        paramV.p = paramRequestAdResponse.e();
        paramV.q = paramRequestAdResponse.f();
      }
      return paramV;
    }
    
    protected V a(V paramV, Cursor paramCursor, boolean paramBoolean)
    {
      super.a(paramV, paramCursor, paramBoolean);
      paramV.i = ap.b(paramCursor, "cta_clickable_percent");
      paramV.j = ap.c(paramCursor, "enable_cta_delay_seconds");
      paramV.k = ap.c(paramCursor, "height");
      paramV.l = ap.a(paramCursor, "is_cta_enabled");
      paramV.p = ap.a(paramCursor, "is_cta_shown_on_touch");
      paramV.q = ap.c(paramCursor, "show_cta_delay_seconds");
      paramV.r = ap.c(paramCursor, "show_close_delay_incentivized_seconds");
      paramV.s = ap.c(paramCursor, "show_close_delay_interstitial_seconds");
      paramV.t = ap.c(paramCursor, "show_countdown_delay_seconds");
      paramV.u = ap.c(paramCursor, "width");
      return paramV;
    }
    
    protected final V a(String paramString, boolean paramBoolean)
      throws SQLException
    {
      return (Video)a(paramString, c(), paramBoolean);
    }
    
    protected V b(A paramA, R paramR)
    {
      paramA = (Video)super.a(paramA, paramR);
      if (paramA != null) {
        a(paramA, paramR);
      }
      return paramA;
    }
    
    protected abstract at.b c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/Video.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */