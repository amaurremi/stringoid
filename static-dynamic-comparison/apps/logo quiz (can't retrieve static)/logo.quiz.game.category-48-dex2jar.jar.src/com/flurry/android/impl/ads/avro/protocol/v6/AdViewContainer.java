package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;

public class AdViewContainer
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"AdViewContainer\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0}]}");
  @Deprecated
  public int a;
  @Deprecated
  public int b;
  @Deprecated
  public int c;
  @Deprecated
  public int d;
  @Deprecated
  public float e;
  
  public static AdViewContainer.Builder b()
  {
    return new AdViewContainer.Builder(null);
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
      return Integer.valueOf(this.a);
    case 1: 
      return Integer.valueOf(this.b);
    case 2: 
      return Integer.valueOf(this.c);
    case 3: 
      return Integer.valueOf(this.d);
    }
    return Float.valueOf(this.e);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new jg("Bad index");
    case 0: 
      this.a = ((Integer)paramObject).intValue();
      return;
    case 1: 
      this.b = ((Integer)paramObject).intValue();
      return;
    case 2: 
      this.c = ((Integer)paramObject).intValue();
      return;
    case 3: 
      this.d = ((Integer)paramObject).intValue();
      return;
    }
    this.e = ((Float)paramObject).floatValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */