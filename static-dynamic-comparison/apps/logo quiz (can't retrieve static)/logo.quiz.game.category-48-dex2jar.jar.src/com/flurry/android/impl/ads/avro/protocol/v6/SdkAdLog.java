package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.util.List;

public class SdkAdLog
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"SdkAdLog\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}");
  @Deprecated
  public long a;
  @Deprecated
  public CharSequence b;
  @Deprecated
  public List<SdkAdEvent> c;
  
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
      return Long.valueOf(this.a);
    case 1: 
      return this.b;
    }
    return this.c;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new jg("Bad index");
    case 0: 
      this.a = ((Long)paramObject).longValue();
      return;
    case 1: 
      this.b = ((CharSequence)paramObject);
      return;
    }
    this.c = ((List)paramObject);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
  }
  
  public void a(Long paramLong)
  {
    this.a = paramLong.longValue();
  }
  
  public void a(List<SdkAdEvent> paramList)
  {
    this.c = paramList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/SdkAdLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */