package com.vungle.publisher.protocol.message;

import android.util.DisplayMetrics;
import com.vungle.publisher.AdConfig;
import com.vungle.publisher.Demographic;
import com.vungle.publisher.Demographic.Gender;
import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import com.vungle.publisher.bp;
import com.vungle.publisher.bq;
import com.vungle.publisher.br;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RequestAd
  extends BaseJsonSerializable
{
  protected Demographic a;
  protected DeviceInfo b;
  protected String c;
  protected String d;
  
  public JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = super.b();
    localJSONObject.putOpt("demo", bp.a(this.a));
    localJSONObject.putOpt("deviceInfo", bp.a(this.b));
    localJSONObject.putOpt("isu", this.c);
    localJSONObject.putOpt("pubAppId", this.d);
    return localJSONObject;
  }
  
  public static final class Demographic
    extends BaseJsonSerializable
  {
    protected Integer a;
    protected Demographic.Gender b;
    protected Location c;
    
    public final JSONObject b()
      throws JSONException
    {
      JSONObject localJSONObject = super.b();
      localJSONObject.putOpt("age", this.a);
      localJSONObject.putOpt("gender", this.b);
      localJSONObject.putOpt("location", bp.a(this.c));
      return localJSONObject;
    }
    
    @Singleton
    public static class Factory
      extends MessageFactory<RequestAd.Demographic>
    {
      @Inject
      protected Demographic a;
      @Inject
      protected RequestAd.Demographic.Location.Factory b;
      
      protected final RequestAd.Demographic b()
      {
        Object localObject = this.a;
        if ((localObject != null) && (!((Demographic)localObject).isEmpty()))
        {
          RequestAd.Demographic localDemographic = new RequestAd.Demographic();
          localDemographic.a = ((Demographic)localObject).getAge();
          localDemographic.b = ((Demographic)localObject).getGender();
          localObject = this.b;
          localDemographic.c = null;
          return localDemographic;
        }
        return null;
      }
    }
    
    public static final class Location
      extends BaseJsonSerializable
    {
      protected Double a;
      protected Double b;
      
      public final JSONObject b()
        throws JSONException
      {
        JSONObject localJSONObject = super.b();
        localJSONObject.putOpt("lat", this.a);
        localJSONObject.putOpt("long", this.b);
        return localJSONObject;
      }
      
      @Singleton
      public static class Factory
        extends MessageFactory<RequestAd.Demographic.Location>
      {}
    }
  }
  
  public static final class DeviceInfo
    extends BaseJsonSerializable
  {
    protected bq a;
    protected DisplayDimension b;
    protected Boolean c;
    protected Boolean d;
    protected String e;
    protected String f;
    protected String g;
    protected a h;
    protected Float i;
    protected String j;
    
    public final JSONObject b()
      throws JSONException
    {
      JSONObject localJSONObject = super.b();
      localJSONObject.putOpt("connection", this.a);
      localJSONObject.putOpt("dim", bp.a(this.b));
      Object localObject = this.c;
      if (localObject == null)
      {
        localObject = null;
        localJSONObject.putOpt("isSdCardAvailable", localObject);
        localJSONObject.putOpt("soundEnabled", this.d);
        localJSONObject.putOpt("model", this.e);
        localJSONObject.putOpt("networkOperator", this.f);
        localJSONObject.putOpt("osVersion", this.g);
        localJSONObject.putOpt("platform", this.h);
        localJSONObject.putOpt("serial", this.j);
        localJSONObject.putOpt("volume", this.i);
        return localJSONObject;
      }
      if (((Boolean)localObject).booleanValue()) {}
      for (int k = 1;; k = 0)
      {
        localObject = Integer.valueOf(k);
        break;
      }
    }
    
    public static final class DisplayDimension
      extends BaseJsonSerializable
    {
      protected Integer a;
      protected Integer b;
      
      public final JSONObject b()
        throws JSONException
      {
        JSONObject localJSONObject = super.b();
        localJSONObject.putOpt("height", this.a);
        localJSONObject.putOpt("width", this.b);
        return localJSONObject;
      }
      
      @Singleton
      public static class Factory
        extends MessageFactory<RequestAd.DeviceInfo.DisplayDimension>
      {
        @Inject
        protected bc a;
        
        protected final RequestAd.DeviceInfo.DisplayDimension b()
        {
          RequestAd.DeviceInfo.DisplayDimension localDisplayDimension = null;
          DisplayMetrics localDisplayMetrics = this.a.c();
          if ((localDisplayMetrics.heightPixels > 0) || (localDisplayMetrics.widthPixels > 0))
          {
            localDisplayDimension = new RequestAd.DeviceInfo.DisplayDimension();
            localDisplayDimension.a = Integer.valueOf(localDisplayMetrics.heightPixels);
            localDisplayDimension.b = Integer.valueOf(localDisplayMetrics.widthPixels);
          }
          return localDisplayDimension;
        }
      }
    }
    
    @Singleton
    public static class Factory
      extends MessageFactory<RequestAd.DeviceInfo>
    {
      @Inject
      protected AdConfig a;
      @Inject
      protected bc b;
      @Inject
      protected RequestAd.DeviceInfo.DisplayDimension.Factory c;
      @Inject
      protected br d;
      @Inject
      protected be e;
      
      protected final RequestAd.DeviceInfo b()
      {
        RequestAd.DeviceInfo localDeviceInfo = new RequestAd.DeviceInfo();
        localDeviceInfo.a = this.d.a();
        localDeviceInfo.b = this.c.b();
        localDeviceInfo.c = Boolean.valueOf(this.b.g());
        localDeviceInfo.d = Boolean.valueOf(this.a.isSoundEnabled());
        localDeviceInfo.e = this.b.d();
        localDeviceInfo.f = this.d.b();
        localDeviceInfo.g = this.b.b();
        localDeviceInfo.h = RequestAd.DeviceInfo.a.a;
        localDeviceInfo.i = this.b.f();
        localDeviceInfo.j = this.b.e();
        return localDeviceInfo;
      }
    }
    
    public static enum a
    {
      private a() {}
    }
  }
  
  public static abstract class a<Q extends RequestAd<Q>>
    extends MessageFactory<Q>
  {
    @Inject
    protected RequestAd.Demographic.Factory a;
    @Inject
    protected RequestAd.DeviceInfo.Factory b;
    @Inject
    protected bc c;
    @Inject
    protected be d;
    
    protected Q b()
    {
      RequestAd localRequestAd = (RequestAd)a();
      localRequestAd.a = this.a.b();
      localRequestAd.b = this.b.b();
      localRequestAd.c = this.c.a();
      localRequestAd.d = this.d.b();
      return localRequestAd;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */