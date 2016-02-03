package com.drew.metadata.b;

import com.drew.lang.Rational;
import com.drew.metadata.f;
import java.io.UnsupportedEncodingException;

public class g
  extends f<h>
{
  private final boolean gc = true;
  
  public g(h paramh)
  {
    super(paramh);
  }
  
  private String ag(int paramInt)
  {
    Object localObject = ((h)this.ga).aa(paramInt);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = new String((byte[])localObject, "UTF-16LE").trim();
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  public String bG()
  {
    int[] arrayOfInt = ((h)this.ga).getIntArray(532);
    if (arrayOfInt == null) {
      return null;
    }
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    int n = arrayOfInt[4];
    int i1 = arrayOfInt[5];
    return "[" + i + "," + k + "," + n + "] " + "[" + j + "," + m + "," + i1 + "]";
  }
  
  public String bH()
  {
    Object localObject = ((h)this.ga).ae(283);
    if (localObject == null) {
      return null;
    }
    String str = bL();
    localObject = new StringBuilder().append(((Rational)localObject).g(true)).append(" dots per ");
    if (str == null) {}
    for (str = "unit";; str = str.toLowerCase()) {
      return str;
    }
  }
  
  public String bI()
  {
    Object localObject = ((h)this.ga).ae(282);
    if (localObject == null) {
      return null;
    }
    String str = bL();
    localObject = new StringBuilder().append(((Rational)localObject).g(true)).append(" dots per ");
    if (str == null) {}
    for (str = "unit";; str = str.toLowerCase()) {
      return str;
    }
  }
  
  public String bJ()
  {
    Integer localInteger = ((h)this.ga).Z(531);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.valueOf(localInteger);
    case 1: 
      return "Center of pixel array";
    }
    return "Datum point";
  }
  
  public String bK()
  {
    Integer localInteger = ((h)this.ga).Z(274);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.valueOf(localInteger);
    case 1: 
      return "Top, left side (Horizontal / normal)";
    case 2: 
      return "Top, right side (Mirror horizontal)";
    case 3: 
      return "Bottom, right side (Rotate 180)";
    case 4: 
      return "Bottom, left side (Mirror vertical)";
    case 5: 
      return "Left side, top (Mirror horizontal and rotate 270 CW)";
    case 6: 
      return "Right side, top (Rotate 90 CW)";
    case 7: 
      return "Right side, bottom (Mirror horizontal and rotate 90 CW)";
    }
    return "Left side, bottom (Rotate 270 CW)";
  }
  
  public String bL()
  {
    Integer localInteger = ((h)this.ga).Z(296);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "";
    case 1: 
      return "(No unit)";
    case 2: 
      return "Inch";
    }
    return "cm";
  }
  
  public String bM()
  {
    return ag(40093);
  }
  
  public String bN()
  {
    return ag(40092);
  }
  
  public String bO()
  {
    return ag(40094);
  }
  
  public String bP()
  {
    return ag(40091);
  }
  
  public String bQ()
  {
    return ag(40095);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 296: 
      return bL();
    case 531: 
      return bJ();
    case 282: 
      return bI();
    case 283: 
      return bH();
    case 532: 
      return bG();
    case 274: 
      return bK();
    case 40093: 
      return bM();
    case 40092: 
      return bN();
    case 40094: 
      return bO();
    case 40095: 
      return bQ();
    }
    return bP();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */