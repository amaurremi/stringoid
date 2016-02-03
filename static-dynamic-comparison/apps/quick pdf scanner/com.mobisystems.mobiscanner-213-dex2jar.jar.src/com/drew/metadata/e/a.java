package com.drew.metadata.e;

import com.drew.metadata.f;

public class a
  extends f<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String eS()
  {
    Integer localInteger = ((b)this.ga).Z(5);
    if (localInteger == null) {
      return null;
    }
    return String.format("%d.%d", new Object[] { Integer.valueOf((localInteger.intValue() & 0xFF00) >> 8), Integer.valueOf(localInteger.intValue() & 0xFF) });
  }
  
  public String eT()
  {
    Integer localInteger = ((b)this.ga).Z(10);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {}
    for (String str = "";; str = "s") {
      return String.format("%d dot%s", new Object[] { localInteger, str });
    }
  }
  
  public String eU()
  {
    Integer localInteger = ((b)this.ga).Z(8);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {}
    for (String str = "";; str = "s") {
      return String.format("%d dot%s", new Object[] { localInteger, str });
    }
  }
  
  public String eV()
  {
    Integer localInteger = ((b)this.ga).Z(7);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "unit";
    case 0: 
      return "none";
    case 1: 
      return "inch";
    }
    return "centimetre";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 9: 
    default: 
      return super.getDescription(paramInt);
    case 8: 
      return eU();
    case 10: 
      return eT();
    case 5: 
      return eS();
    }
    return eV();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */