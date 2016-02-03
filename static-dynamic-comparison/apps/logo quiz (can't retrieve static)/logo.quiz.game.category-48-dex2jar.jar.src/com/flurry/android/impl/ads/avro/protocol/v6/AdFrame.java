package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.util.List;

public class AdFrame
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"AdFrame\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}");
  @Deprecated
  public int a;
  @Deprecated
  public CharSequence b;
  @Deprecated
  public CharSequence c;
  @Deprecated
  public AdSpaceLayout d;
  @Deprecated
  public List<Callback> e;
  @Deprecated
  public CharSequence f;
  
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
      return this.b;
    case 2: 
      return this.c;
    case 3: 
      return this.d;
    case 4: 
      return this.e;
    }
    return this.f;
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
      this.b = ((CharSequence)paramObject);
      return;
    case 2: 
      this.c = ((CharSequence)paramObject);
      return;
    case 3: 
      this.d = ((AdSpaceLayout)paramObject);
      return;
    case 4: 
      this.e = ((List)paramObject);
      return;
    }
    this.f = ((CharSequence)paramObject);
  }
  
  public Integer b()
  {
    return Integer.valueOf(this.a);
  }
  
  public CharSequence c()
  {
    return this.b;
  }
  
  public CharSequence d()
  {
    return this.c;
  }
  
  public AdSpaceLayout e()
  {
    return this.d;
  }
  
  public List<Callback> f()
  {
    return this.e;
  }
  
  public CharSequence g()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */