package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Parser;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;

class AdSpaceLayout
  extends SpecificRecordBase
  implements SpecificRecord
{
  public static final Schema SCHEMA$ = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}");
  public int jdField_do;
  public int dp;
  public CharSequence dq;
  public CharSequence dr;
  public CharSequence ds;
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      return Integer.valueOf(this.jdField_do);
    case 1: 
      return Integer.valueOf(this.dp);
    case 2: 
      return this.dq;
    case 3: 
      return this.dr;
    }
    return this.ds;
  }
  
  public final Integer getAdHeight()
  {
    return Integer.valueOf(this.dp);
  }
  
  public final Integer getAdWidth()
  {
    return Integer.valueOf(this.jdField_do);
  }
  
  public final CharSequence getAlignment()
  {
    return this.ds;
  }
  
  public final CharSequence getFix()
  {
    return this.dq;
  }
  
  public final CharSequence getFormat()
  {
    return this.dr;
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
      this.jdField_do = ((Integer)paramObject).intValue();
      return;
    case 1: 
      this.dp = ((Integer)paramObject).intValue();
      return;
    case 2: 
      this.dq = ((CharSequence)paramObject);
      return;
    case 3: 
      this.dr = ((CharSequence)paramObject);
      return;
    }
    this.ds = ((CharSequence)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdSpaceLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */