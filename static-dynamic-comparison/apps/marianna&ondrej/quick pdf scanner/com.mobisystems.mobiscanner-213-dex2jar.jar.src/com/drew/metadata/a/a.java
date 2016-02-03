package com.drew.metadata.a;

import com.drew.metadata.f;

public class a
  extends f<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  private String aE()
  {
    Integer localInteger = ((b)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 100) {
      return "100";
    }
    return Integer.toString(localInteger.intValue());
  }
  
  private String aF()
  {
    Integer localInteger = ((b)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown transform (%d)", new Object[] { localInteger });
    case 0: 
      return "Unknown (RGB or CMYK)";
    case 1: 
      return "YCbCr";
    }
    return "YCCK";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return super.getDescription(paramInt);
    case 3: 
      return aF();
    }
    return aE();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */