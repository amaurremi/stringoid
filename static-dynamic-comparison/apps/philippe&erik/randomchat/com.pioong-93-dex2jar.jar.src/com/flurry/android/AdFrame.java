package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Parser;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;

class AdFrame
  extends SpecificRecordBase
  implements SpecificRecord
{
  public static final Schema SCHEMA$ = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdFrame\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}");
  public int p;
  public CharSequence q;
  public CharSequence r;
  public AdSpaceLayout s;
  public List<Callback> t;
  public CharSequence u;
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      return Integer.valueOf(this.p);
    case 1: 
      return this.q;
    case 2: 
      return this.r;
    case 3: 
      return this.s;
    case 4: 
      return this.t;
    }
    return this.u;
  }
  
  public final CharSequence getAdGuid()
  {
    return this.u;
  }
  
  public final AdSpaceLayout getAdSpaceLayout()
  {
    return this.s;
  }
  
  public final Integer getBinding()
  {
    return Integer.valueOf(this.p);
  }
  
  public final List<Callback> getCallbacks()
  {
    return this.t;
  }
  
  public final CharSequence getContent()
  {
    return this.r;
  }
  
  public final CharSequence getDisplay()
  {
    return this.q;
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
      this.p = ((Integer)paramObject).intValue();
      return;
    case 1: 
      this.q = ((CharSequence)paramObject);
      return;
    case 2: 
      this.r = ((CharSequence)paramObject);
      return;
    case 3: 
      this.s = ((AdSpaceLayout)paramObject);
      return;
    case 4: 
      this.t = ((List)paramObject);
      return;
    }
    this.u = ((CharSequence)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */