package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.util.List;

public class SdkLogResponse
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"SdkLogResponse\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"result\",\"type\":\"string\"},{\"name\":\"errors\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}");
  @Deprecated
  public CharSequence a;
  @Deprecated
  public List<CharSequence> b;
  
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
    }
    return this.b;
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
    }
    this.b = ((List)paramObject);
  }
  
  public CharSequence b()
  {
    return this.a;
  }
  
  public List<CharSequence> c()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/SdkLogResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */