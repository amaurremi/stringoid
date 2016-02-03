package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;

public class TestAds
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"TestAds\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]}");
  @Deprecated
  public int a;
  
  public static TestAds.Builder b()
  {
    return new TestAds.Builder(null);
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
    }
    return Integer.valueOf(this.a);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new jg("Bad index");
    }
    this.a = ((Integer)paramObject).intValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/TestAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */