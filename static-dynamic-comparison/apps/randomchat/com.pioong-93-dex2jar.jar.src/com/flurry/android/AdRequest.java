package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Parser;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;
import java.util.Map;

class AdRequest
  extends SpecificRecordBase
  implements SpecificRecord
{
  public static final Schema SCHEMA$ = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdRequest\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"agentVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"adSpaceName\",\"type\":\"string\"},{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]},\"default\":\"null\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false},{\"name\":\"bindings\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"adViewContainer\",\"type\":{\"type\":\"record\",\"name\":\"AdViewContainer\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0}]},\"default\":\"null\"},{\"name\":\"locale\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"timezone\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"osVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"devicePlatform\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"testAds\",\"type\":{\"type\":\"record\",\"name\":\"TestAds\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]},\"default\":\"null\"},{\"name\":\"keywords\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"refresh\",\"type\":\"boolean\",\"default\":false},{\"name\":\"networkStatus\",\"type\":\"int\",\"default\":1},{\"name\":\"canDoSKAppStore\",\"type\":\"boolean\",\"default\":false},{\"name\":\"frequencyCapInfos\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}}}]}");
  public long bU;
  public CharSequence bX;
  public CharSequence bY;
  public CharSequence bZ;
  public List<AdReportedId> ca;
  public Location cb;
  public boolean cc;
  public List<Integer> cd;
  public AdViewContainer ce;
  public CharSequence cf;
  public CharSequence cg;
  public CharSequence ch;
  public CharSequence ci;
  public TestAds cj;
  public Map<CharSequence, CharSequence> ck;
  public boolean cl;
  public int cm;
  public boolean cn;
  public List<FrequencyCapInfo> co;
  
  public static AdRequest.Builder ab()
  {
    return new AdRequest.Builder();
  }
  
  public final void a(TestAds paramTestAds)
  {
    this.cj = paramTestAds;
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.cl = paramBoolean.booleanValue();
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.bZ = paramCharSequence;
  }
  
  public final void c(Map<CharSequence, CharSequence> paramMap)
  {
    this.ck = paramMap;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AvroRuntimeException("Bad index");
    case 0: 
      return this.bX;
    case 1: 
      return this.bY;
    case 2: 
      return this.bZ;
    case 3: 
      return Long.valueOf(this.bU);
    case 4: 
      return this.ca;
    case 5: 
      return this.cb;
    case 6: 
      return Boolean.valueOf(this.cc);
    case 7: 
      return this.cd;
    case 8: 
      return this.ce;
    case 9: 
      return this.cf;
    case 10: 
      return this.cg;
    case 11: 
      return this.ch;
    case 12: 
      return this.ci;
    case 13: 
      return this.cj;
    case 14: 
      return this.ck;
    case 15: 
      return Boolean.valueOf(this.cl);
    case 16: 
      return Integer.valueOf(this.cm);
    case 17: 
      return Boolean.valueOf(this.cn);
    }
    return this.co;
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
      this.bX = ((CharSequence)paramObject);
      return;
    case 1: 
      this.bY = ((CharSequence)paramObject);
      return;
    case 2: 
      this.bZ = ((CharSequence)paramObject);
      return;
    case 3: 
      this.bU = ((Long)paramObject).longValue();
      return;
    case 4: 
      this.ca = ((List)paramObject);
      return;
    case 5: 
      this.cb = ((Location)paramObject);
      return;
    case 6: 
      this.cc = ((Boolean)paramObject).booleanValue();
      return;
    case 7: 
      this.cd = ((List)paramObject);
      return;
    case 8: 
      this.ce = ((AdViewContainer)paramObject);
      return;
    case 9: 
      this.cf = ((CharSequence)paramObject);
      return;
    case 10: 
      this.cg = ((CharSequence)paramObject);
      return;
    case 11: 
      this.ch = ((CharSequence)paramObject);
      return;
    case 12: 
      this.ci = ((CharSequence)paramObject);
      return;
    case 13: 
      this.cj = ((TestAds)paramObject);
      return;
    case 14: 
      this.ck = ((Map)paramObject);
      return;
    case 15: 
      this.cl = ((Boolean)paramObject).booleanValue();
      return;
    case 16: 
      this.cm = ((Integer)paramObject).intValue();
      return;
    case 17: 
      this.cn = ((Boolean)paramObject).booleanValue();
      return;
    }
    this.co = ((List)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */