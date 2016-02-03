package com.drew.metadata.b;

import com.drew.metadata.f;

public class aj
  extends f<ak>
{
  public aj(ak paramak)
  {
    super(paramak);
  }
  
  public String aP()
  {
    Integer localInteger = ((ak)this.ga).Z(45121);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Auto";
    case 5: 
      return "Landscape";
    case 6: 
      return "Program";
    case 7: 
      return "Aperture Priority";
    case 8: 
      return "Shutter Priority";
    case 9: 
      return "Night Scene";
    case 15: 
      return "Manual";
    }
    return "N/A";
  }
  
  public String bd()
  {
    Integer localInteger = ((ak)this.ga).Z(45127);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Normal";
    case 1: 
      return "Fine";
    }
    return "N/A";
  }
  
  public String cQ()
  {
    Integer localInteger = ((ak)this.ga).Z(45120);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On";
    case 2: 
      return "Magnifying Glass/Super Macro";
    }
    return "N/A";
  }
  
  public String dR()
  {
    Integer localInteger = ((ak)this.ga).Z(45094);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Off";
    }
    return "On";
  }
  
  public String jdMethod_do()
  {
    Integer localInteger = ((ak)this.ga).Z(45097);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Standard";
    case 1: 
      return "Vivid";
    case 2: 
      return "Portrait";
    case 3: 
      return "Landscape";
    case 4: 
      return "Sunset";
    case 5: 
      return "Night Portrait";
    case 6: 
      return "Black & White";
    case 7: 
      return "Adobe RGB";
    case 12: 
    case 100: 
      return "Neutral";
    case 101: 
      return "Clear";
    case 102: 
      return "Deep";
    case 103: 
      return "Light";
    case 104: 
      return "Night View";
    }
    return "Autumn Leaves";
  }
  
  public String eG()
  {
    Integer localInteger = ((ak)this.ga).Z(45089);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Auto";
    }
    int i = localInteger.intValue();
    return String.format("%d K", new Object[] { Integer.valueOf((localInteger.intValue() & 0xFF000000) >> 24 | (i & 0xFF0000) >> 8) });
  }
  
  public String eH()
  {
    Integer localInteger = ((ak)this.ga).Z(45092);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "ISO Setting Used";
    case 1: 
      return "High Key";
    }
    return "Low Key";
  }
  
  public String eI()
  {
    Integer localInteger = ((ak)this.ga).Z(45093);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "Standard";
    case 2: 
      return "Advanced Auto";
    case 8: 
      return "Advanced LV1";
    case 9: 
      return "Advanced LV2";
    case 10: 
      return "Advanced LV3";
    case 11: 
      return "Advanced LV4";
    }
    return "Advanced LV5";
  }
  
  public String eJ()
  {
    Integer localInteger = ((ak)this.ga).Z(45131);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On (Continuous)";
    case 2: 
      return "On (Shooting)";
    }
    return "N/A";
  }
  
  public String eK()
  {
    Integer localInteger = ((ak)this.ga).Z(45134);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On";
    }
    return "N/A";
  }
  
  public String et()
  {
    Integer localInteger = ((ak)this.ga).Z(45091);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Standard";
    case 1: 
      return "Portrait";
    case 2: 
      return "Text";
    case 3: 
      return "Night Scene";
    case 4: 
      return "Sunset";
    case 5: 
      return "Sports";
    case 6: 
      return "Landscape";
    case 7: 
      return "Night Portrait";
    case 8: 
      return "Macro";
    case 9: 
      return "Super Macro";
    case 16: 
      return "Auto";
    }
    return "Night View/Portrait";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 45089: 
      return eG();
    case 45091: 
      return et();
    case 45092: 
      return eH();
    case 45093: 
      return eI();
    case 45094: 
      return dR();
    case 45097: 
      return jdMethod_do();
    case 45120: 
      return cQ();
    case 45121: 
      return aP();
    case 45127: 
      return bd();
    case 45131: 
      return eJ();
    }
    return eK();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */