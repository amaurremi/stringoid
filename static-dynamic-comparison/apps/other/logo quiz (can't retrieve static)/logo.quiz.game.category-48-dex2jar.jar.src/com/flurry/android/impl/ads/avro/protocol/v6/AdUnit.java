package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.util.List;

public class AdUnit
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"AdUnit\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"long\",\"default\":0},{\"name\":\"adomain\",\"type\":\"string\",\"default\":\"null\"}]}");
  @Deprecated
  public CharSequence a;
  @Deprecated
  public long b;
  @Deprecated
  public List<AdFrame> c;
  @Deprecated
  public int d;
  @Deprecated
  public CharSequence e;
  @Deprecated
  public CharSequence f;
  @Deprecated
  public long g;
  @Deprecated
  public int h;
  @Deprecated
  public int i;
  @Deprecated
  public int j;
  @Deprecated
  public long k;
  @Deprecated
  public long l;
  @Deprecated
  public CharSequence m;
  
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
      return this.c;
    case 3: 
      return Integer.valueOf(this.d);
    case 4: 
      return this.e;
    case 5: 
      return this.f;
    case 6: 
      return Long.valueOf(this.g);
    case 7: 
      return Integer.valueOf(this.h);
    case 8: 
      return Integer.valueOf(this.i);
    case 9: 
      return Integer.valueOf(this.j);
    case 10: 
      return Long.valueOf(this.k);
    case 11: 
      return Long.valueOf(this.l);
    }
    return this.m;
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
      this.c = ((List)paramObject);
      return;
    case 3: 
      this.d = ((Integer)paramObject).intValue();
      return;
    case 4: 
      this.e = ((CharSequence)paramObject);
      return;
    case 5: 
      this.f = ((CharSequence)paramObject);
      return;
    case 6: 
      this.g = ((Long)paramObject).longValue();
      return;
    case 7: 
      this.h = ((Integer)paramObject).intValue();
      return;
    case 8: 
      this.i = ((Integer)paramObject).intValue();
      return;
    case 9: 
      this.j = ((Integer)paramObject).intValue();
      return;
    case 10: 
      this.k = ((Long)paramObject).longValue();
      return;
    case 11: 
      this.l = ((Long)paramObject).longValue();
      return;
    }
    this.m = ((CharSequence)paramObject);
  }
  
  public CharSequence b()
  {
    return this.a;
  }
  
  public Long c()
  {
    return Long.valueOf(this.b);
  }
  
  public List<AdFrame> d()
  {
    return this.c;
  }
  
  public Integer e()
  {
    return Integer.valueOf(this.d);
  }
  
  public CharSequence f()
  {
    return this.e;
  }
  
  public CharSequence g()
  {
    return this.f;
  }
  
  public Long h()
  {
    return Long.valueOf(this.g);
  }
  
  public Integer i()
  {
    return Integer.valueOf(this.h);
  }
  
  public Integer j()
  {
    return Integer.valueOf(this.i);
  }
  
  public Integer k()
  {
    return Integer.valueOf(this.j);
  }
  
  public Long l()
  {
    return Long.valueOf(this.k);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */