package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.util.List;

public class SdkLogRequest
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"SdkLogRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"sdkAdLogs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdLog\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}}},{\"name\":\"agentTimestamp\",\"type\":\"long\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false}]}");
  @Deprecated
  public CharSequence a;
  @Deprecated
  public List<AdReportedId> b;
  @Deprecated
  public List<SdkAdLog> c;
  @Deprecated
  public long d;
  @Deprecated
  public boolean e;
  
  public static SdkLogRequest.Builder b()
  {
    return new SdkLogRequest.Builder(null);
  }
  
  public ji a()
  {
    return SCHEMA$;
  }
  
  public Object a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new jg("Bad index");
    case 0: 
      return this.a;
    case 1: 
      return this.b;
    case 2: 
      return this.c;
    case 3: 
      return Long.valueOf(this.d);
    }
    return Boolean.valueOf(this.e);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new jg("Bad index");
    case 0: 
      this.a = ((CharSequence)paramObject);
      return;
    case 1: 
      this.b = ((List)paramObject);
      return;
    case 2: 
      this.c = ((List)paramObject);
      return;
    case 3: 
      this.d = ((Long)paramObject).longValue();
      return;
    }
    this.e = ((Boolean)paramObject).booleanValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */