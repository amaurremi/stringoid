package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class am
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1299), "Maker Note Thumb Offset");
    gb.put(Integer.valueOf(1300), "Maker Note Thumb Length");
    gb.put(Integer.valueOf(1301), "Sony-6-0x0203");
    gb.put(Integer.valueOf(8192), "Maker Note Thumb Version");
  }
  
  public am()
  {
    a(new al(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Sony Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */