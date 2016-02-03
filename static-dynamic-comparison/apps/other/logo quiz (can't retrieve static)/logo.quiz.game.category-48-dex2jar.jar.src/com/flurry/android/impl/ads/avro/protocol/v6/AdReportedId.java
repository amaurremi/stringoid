package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.jg;
import com.flurry.android.monolithic.sdk.impl.ji;
import com.flurry.android.monolithic.sdk.impl.ke;
import com.flurry.android.monolithic.sdk.impl.nt;
import com.flurry.android.monolithic.sdk.impl.nu;
import java.nio.ByteBuffer;

public class AdReportedId
  extends nu
  implements nt
{
  public static final ji SCHEMA$ = new ke().a("{\"type\":\"record\",\"name\":\"AdReportedId\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v6\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}");
  @Deprecated
  public int a;
  @Deprecated
  public ByteBuffer b;
  
  public static AdReportedId.Builder b()
  {
    return new AdReportedId.Builder(null);
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
      this.a = ((Integer)paramObject).intValue();
      return;
    }
    this.b = ((ByteBuffer)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */