package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Parser;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;

class AdUnit
  extends SpecificRecordBase
  implements SpecificRecord
{
  public static final Schema SCHEMA$ = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdUnit\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"}]}");
  public CharSequence R;
  public long S;
  public List<AdFrame> T;
  public int U;
  public CharSequence V;
  public CharSequence W;
  public long X;
  public int Y;
  public int Z;
  public int aa;
  public long ab;
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      return this.R;
    case 1: 
      return Long.valueOf(this.S);
    case 2: 
      return this.T;
    case 3: 
      return Integer.valueOf(this.U);
    case 4: 
      return this.V;
    case 5: 
      return this.W;
    case 6: 
      return Long.valueOf(this.X);
    case 7: 
      return Integer.valueOf(this.Y);
    case 8: 
      return Integer.valueOf(this.Z);
    case 9: 
      return Integer.valueOf(this.aa);
    }
    return Long.valueOf(this.ab);
  }
  
  public final List<AdFrame> getAdFrames()
  {
    return this.T;
  }
  
  public final CharSequence getAdSpace()
  {
    return this.R;
  }
  
  public final Integer getCombinable()
  {
    return Integer.valueOf(this.U);
  }
  
  public final Long getExpiration()
  {
    return Long.valueOf(this.S);
  }
  
  public final Long getExpirationTime()
  {
    return Long.valueOf(this.ab);
  }
  
  public final CharSequence getGroupId()
  {
    return this.V;
  }
  
  public final CharSequence getIdHash()
  {
    return this.W;
  }
  
  public final Integer getNewCap()
  {
    return Integer.valueOf(this.Y);
  }
  
  public final Integer getPreviousCap()
  {
    return Integer.valueOf(this.Z);
  }
  
  public final Integer getPreviousCapType()
  {
    return Integer.valueOf(this.aa);
  }
  
  public Schema getSchema()
  {
    return SCHEMA$;
  }
  
  public final Long getServeTime()
  {
    return Long.valueOf(this.X);
  }
  
  public void put(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      this.R = ((CharSequence)paramObject);
      return;
    case 1: 
      this.S = ((Long)paramObject).longValue();
      return;
    case 2: 
      this.T = ((List)paramObject);
      return;
    case 3: 
      this.U = ((Integer)paramObject).intValue();
      return;
    case 4: 
      this.V = ((CharSequence)paramObject);
      return;
    case 5: 
      this.W = ((CharSequence)paramObject);
      return;
    case 6: 
      this.X = ((Long)paramObject).longValue();
      return;
    case 7: 
      this.Y = ((Integer)paramObject).intValue();
      return;
    case 8: 
      this.Z = ((Integer)paramObject).intValue();
      return;
    case 9: 
      this.aa = ((Integer)paramObject).intValue();
      return;
    }
    this.ab = ((Long)paramObject).longValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */