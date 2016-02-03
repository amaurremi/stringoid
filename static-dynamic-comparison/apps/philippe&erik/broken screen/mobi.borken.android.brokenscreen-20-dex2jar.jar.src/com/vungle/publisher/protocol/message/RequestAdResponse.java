package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bp;
import java.util.Comparator;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RequestAdResponse
{
  protected Integer a;
  protected Integer b;
  protected Integer c;
  protected String d;
  protected String e;
  protected CallToActionOverlay f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected Integer k;
  protected Integer l;
  protected Integer m;
  protected ThirdPartyAdTracking n;
  protected Integer o;
  protected String p;
  protected Integer q;
  
  public final Integer a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final CallToActionOverlay d()
  {
    return this.f;
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final String f()
  {
    return this.h;
  }
  
  public final Integer g()
  {
    return this.k;
  }
  
  public final Integer h()
  {
    return this.l;
  }
  
  public final Integer i()
  {
    return this.m;
  }
  
  public final ThirdPartyAdTracking j()
  {
    return this.n;
  }
  
  public final Integer k()
  {
    return this.o;
  }
  
  public final String l()
  {
    return this.p;
  }
  
  public final Integer m()
  {
    return this.q;
  }
  
  public static final class CallToActionOverlay
    extends BaseJsonSerializable
  {
    protected Float a;
    protected Integer b;
    protected Boolean c;
    protected Boolean d;
    protected Integer e;
    
    public final JSONObject b()
      throws JSONException
    {
      JSONObject localJSONObject = super.b();
      localJSONObject.putOpt("click_area", this.a);
      localJSONObject.putOpt("enabled", this.c);
      localJSONObject.putOpt("show_onclick", this.d);
      localJSONObject.putOpt("time_show", this.e);
      localJSONObject.putOpt("time_enabled", this.b);
      return localJSONObject;
    }
    
    public final Float c()
    {
      return this.a;
    }
    
    public final Boolean d()
    {
      return this.c;
    }
    
    public final Boolean e()
    {
      return this.d;
    }
    
    public final Integer f()
    {
      return this.e;
    }
    
    public final Integer g()
    {
      return this.b;
    }
    
    @Singleton
    public static class Factory
      extends JsonDeserializationFactory<RequestAdResponse.CallToActionOverlay>
    {
      protected static RequestAdResponse.CallToActionOverlay b(JSONObject paramJSONObject)
        throws JSONException
      {
        RequestAdResponse.CallToActionOverlay localCallToActionOverlay = null;
        if (paramJSONObject != null)
        {
          localCallToActionOverlay = new RequestAdResponse.CallToActionOverlay();
          localCallToActionOverlay.a = bp.b(paramJSONObject, "click_area");
          localCallToActionOverlay.c = bp.a(paramJSONObject, "enabled");
          localCallToActionOverlay.d = bp.a(paramJSONObject, "show_onclick");
          localCallToActionOverlay.e = bp.c(paramJSONObject, "time_show");
          localCallToActionOverlay.b = bp.c(paramJSONObject, "time_enabled");
        }
        return localCallToActionOverlay;
      }
    }
  }
  
  public static final class ThirdPartyAdTracking
    extends BaseJsonSerializable
  {
    protected String[] a;
    protected String[] b;
    protected String[] c;
    protected String[] d;
    protected String[] e;
    protected String[] f;
    protected PlayCheckpoint[] g;
    protected String[] h;
    protected String[] i;
    protected String[] j;
    
    public final JSONObject b()
      throws JSONException
    {
      JSONObject localJSONObject = super.b();
      localJSONObject.putOpt("postroll_click", this.a);
      localJSONObject.putOpt("video_click", this.b);
      localJSONObject.putOpt("video_close", this.c);
      localJSONObject.putOpt("error", this.d);
      localJSONObject.putOpt("mute", this.e);
      localJSONObject.putOpt("pause", this.f);
      localJSONObject.putOpt("play_percentage", bp.a(this.g));
      localJSONObject.putOpt("postroll_view", this.h);
      localJSONObject.putOpt("resume", this.i);
      localJSONObject.putOpt("unmute", this.j);
      return localJSONObject;
    }
    
    public final String[] c()
    {
      return this.a;
    }
    
    public final String[] d()
    {
      return this.b;
    }
    
    public final String[] e()
    {
      return this.c;
    }
    
    public final String[] f()
    {
      return this.d;
    }
    
    public final String[] g()
    {
      return this.e;
    }
    
    public final String[] h()
    {
      return this.f;
    }
    
    public final PlayCheckpoint[] i()
    {
      return this.g;
    }
    
    public final String[] j()
    {
      return this.h;
    }
    
    public final String[] k()
    {
      return this.i;
    }
    
    public final String[] l()
    {
      return this.j;
    }
    
    @Singleton
    public static class Factory
      extends JsonDeserializationFactory<RequestAdResponse.ThirdPartyAdTracking>
    {
      @Inject
      protected RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory a;
      
      protected final RequestAdResponse.ThirdPartyAdTracking b(JSONObject paramJSONObject)
        throws JSONException
      {
        RequestAdResponse.ThirdPartyAdTracking localThirdPartyAdTracking = null;
        if (paramJSONObject != null)
        {
          localThirdPartyAdTracking = new RequestAdResponse.ThirdPartyAdTracking();
          localThirdPartyAdTracking.a = bp.e(paramJSONObject, "postroll_click");
          localThirdPartyAdTracking.b = bp.e(paramJSONObject, "video_click");
          localThirdPartyAdTracking.c = bp.e(paramJSONObject, "video_close");
          localThirdPartyAdTracking.d = bp.e(paramJSONObject, "error");
          localThirdPartyAdTracking.e = bp.e(paramJSONObject, "mute");
          localThirdPartyAdTracking.f = bp.e(paramJSONObject, "pause");
          localThirdPartyAdTracking.g = ((RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint[])this.a.a(paramJSONObject.optJSONArray("play_percentage")));
          localThirdPartyAdTracking.h = bp.e(paramJSONObject, "postroll_view");
          localThirdPartyAdTracking.i = bp.e(paramJSONObject, "resume");
          localThirdPartyAdTracking.j = bp.e(paramJSONObject, "unmute");
        }
        return localThirdPartyAdTracking;
      }
    }
    
    public static final class PlayCheckpoint
      extends BaseJsonSerializable
    {
      public Float a;
      public String[] b;
      
      public final JSONObject b()
        throws JSONException
      {
        JSONObject localJSONObject = super.b();
        localJSONObject.putOpt("checkpoint", this.a);
        localJSONObject.putOpt("urls", this.b);
        return localJSONObject;
      }
      
      @Singleton
      public static class Factory
        extends JsonDeserializationFactory<RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint>
      {}
      
      @Singleton
      public static class PlayPercentAscendingComparator
        implements Comparator<RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint>
      {}
    }
  }
  
  public static abstract class a<T extends RequestAdResponse>
    extends JsonDeserializationFactory<T>
  {
    @Inject
    protected RequestAdResponse.CallToActionOverlay.Factory a;
    @Inject
    protected RequestAdResponse.ThirdPartyAdTracking.Factory b;
    
    public T b(JSONObject paramJSONObject)
      throws JSONException
    {
      RequestAdResponse localRequestAdResponse = null;
      if (paramJSONObject != null)
      {
        localRequestAdResponse = (RequestAdResponse)a();
        localRequestAdResponse.a = bp.c(paramJSONObject, "delay");
        localRequestAdResponse.c = bp.c(paramJSONObject, "asyncThreshold");
        localRequestAdResponse.b = bp.c(paramJSONObject, "retryCount");
        localRequestAdResponse.d = bp.d(paramJSONObject, "app_id");
        localRequestAdResponse.e = bp.d(paramJSONObject, "callToActionDest");
        RequestAdResponse.CallToActionOverlay.Factory localFactory = this.a;
        localRequestAdResponse.f = RequestAdResponse.CallToActionOverlay.Factory.b(paramJSONObject.optJSONObject("cta_overlay"));
        localRequestAdResponse.g = bp.d(paramJSONObject, "callToActionUrl");
        localRequestAdResponse.h = bp.d(paramJSONObject, "campaign");
        a(paramJSONObject, "campaign", localRequestAdResponse.h);
        localRequestAdResponse.i = bp.d(paramJSONObject, "chk");
        localRequestAdResponse.j = bp.d(paramJSONObject, "id");
        localRequestAdResponse.k = bp.c(paramJSONObject, "showCloseIncentivized");
        localRequestAdResponse.l = bp.c(paramJSONObject, "showClose");
        localRequestAdResponse.m = bp.c(paramJSONObject, "countdown");
        localRequestAdResponse.n = this.b.b(paramJSONObject.optJSONObject("tpat"));
        localRequestAdResponse.o = bp.c(paramJSONObject, "videoHeight");
        a(paramJSONObject, "videoHeight", localRequestAdResponse.o);
        localRequestAdResponse.p = bp.d(paramJSONObject, "url");
        a(paramJSONObject, "url", localRequestAdResponse.p);
        localRequestAdResponse.q = bp.c(paramJSONObject, "videoWidth");
        a(paramJSONObject, "videoWidth", localRequestAdResponse.q);
      }
      return localRequestAdResponse;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */