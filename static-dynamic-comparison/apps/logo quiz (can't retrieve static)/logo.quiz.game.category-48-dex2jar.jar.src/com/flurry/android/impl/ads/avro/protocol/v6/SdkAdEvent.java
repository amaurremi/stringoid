package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.util.Map;

public class SdkAdEvent
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}");
  @Deprecated
  public CharSequence a;
  @Deprecated
  public Map<CharSequence, CharSequence> b;
  @Deprecated
  public long c;
  
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
    }
    return Long.valueOf(this.c);
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
      this.b = ((Map)paramObject);
      return;
    }
    this.c = ((Long)paramObject).longValue();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
  }
  
  public void a(Long paramLong)
  {
    this.c = paramLong.longValue();
  }
  
  public void a(Map<CharSequence, CharSequence> paramMap)
  {
    this.b = paramMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/SdkAdEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */