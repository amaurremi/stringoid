package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Parser;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;

class AdViewContainer
  extends SpecificRecordBase
  implements SpecificRecord
{
  public static final Schema SCHEMA$ = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdViewContainer\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0}]}");
  public int ai;
  public int aj;
  public int ak;
  public int al;
  
  public static AdViewContainer.Builder A()
  {
    return new AdViewContainer.Builder();
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      return Integer.valueOf(this.ai);
    case 1: 
      return Integer.valueOf(this.aj);
    case 2: 
      return Integer.valueOf(this.ak);
    }
    return Integer.valueOf(this.al);
  }
  
  public Schema getSchema()
  {
    return SCHEMA$;
  }
  
  public void put(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      this.ai = ((Integer)paramObject).intValue();
      return;
    case 1: 
      this.aj = ((Integer)paramObject).intValue();
      return;
    case 2: 
      this.ak = ((Integer)paramObject).intValue();
      return;
    }
    this.al = ((Integer)paramObject).intValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */