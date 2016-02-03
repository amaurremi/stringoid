package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;

public class FrequencyCapInfo
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}");
  @Deprecated
  public CharSequence a;
  @Deprecated
  public long b;
  @Deprecated
  public long c;
  @Deprecated
  public int d;
  @Deprecated
  public int e;
  @Deprecated
  public int f;
  @Deprecated
  public int g;
  
  public static FrequencyCapInfo.Builder b()
  {
    return new FrequencyCapInfo.Builder(null);
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
      return Long.valueOf(this.b);
    case 2: 
      return Long.valueOf(this.c);
    case 3: 
      return Integer.valueOf(this.d);
    case 4: 
      return Integer.valueOf(this.e);
    case 5: 
      return Integer.valueOf(this.f);
    }
    return Integer.valueOf(this.g);
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
      this.b = ((Long)paramObject).longValue();
      return;
    case 2: 
      this.c = ((Long)paramObject).longValue();
      return;
    case 3: 
      this.d = ((Integer)paramObject).intValue();
      return;
    case 4: 
      this.e = ((Integer)paramObject).intValue();
      return;
    case 5: 
      this.f = ((Integer)paramObject).intValue();
      return;
    }
    this.g = ((Integer)paramObject).intValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/FrequencyCapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */