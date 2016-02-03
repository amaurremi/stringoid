package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class j
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1), "Interoperability Index");
    gb.put(Integer.valueOf(2), "Interoperability Version");
    gb.put(Integer.valueOf(4096), "Related Image File Format");
    gb.put(Integer.valueOf(4097), "Related Image Width");
    gb.put(Integer.valueOf(4098), "Related Image Length");
  }
  
  public j()
  {
    a(new i(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Interoperability";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */