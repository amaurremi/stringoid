package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Parser;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;

class AdResponse
  extends SpecificRecordBase
  implements SpecificRecord
{
  public static final Schema SCHEMA$ = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdResponse\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"adUnits\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdUnit\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"}]}}},{\"name\":\"errors\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}");
  public List<AdUnit> bx;
  public List<CharSequence> x;
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      return this.bx;
    }
    return this.x;
  }
  
  public final List<AdUnit> getAdUnits()
  {
    return this.bx;
  }
  
  public final List<CharSequence> getErrors()
  {
    return this.x;
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
      this.bx = ((List)paramObject);
      return;
    }
    this.x = ((List)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */