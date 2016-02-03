package com.drew.metadata.b;

import com.drew.lang.Rational;
import com.drew.metadata.f;

public class p
  extends f<q>
{
  public p(q paramq)
  {
    super(paramq);
  }
  
  private String ah(int paramInt)
  {
    Integer localInteger = ((q)this.ga).Z(paramInt);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    }
    return "On";
  }
  
  public String aJ()
  {
    Integer localInteger = ((q)this.ga).Z(4098);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 256: 
      return "Daylight";
    case 512: 
      return "Cloudy";
    case 768: 
      return "DaylightColor-fluorescence";
    case 769: 
      return "DaywhiteColor-fluorescence";
    case 770: 
      return "White-fluorescence";
    case 1024: 
      return "Incandescence";
    }
    return "Custom white balance";
  }
  
  public String aT()
  {
    Integer localInteger = ((q)this.ga).Z(4097);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Softest";
    case 2: 
      return "Soft";
    case 3: 
      return "Normal";
    case 4: 
      return "Hard";
    }
    return "Hardest";
  }
  
  public String ba()
  {
    Integer localInteger = ((q)this.ga).Z(4112);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 1: 
      return "On";
    case 2: 
      return "Off";
    }
    return "Red-eye reduction";
  }
  
  public String cN()
  {
    Integer localInteger = ((q)this.ga).Z(4099);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal (STD)";
    case 256: 
      return "High (HARD)";
    }
    return "Low (ORG)";
  }
  
  public String cO()
  {
    Integer localInteger = ((q)this.ga).Z(4100);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal (STD)";
    case 256: 
      return "High (HARD)";
    }
    return "Low (ORG)";
  }
  
  public String cP()
  {
    Rational localRational = ((q)this.ga).ae(4113);
    if (localRational == null) {
      return null;
    }
    return localRational.g(false) + " EV (Apex)";
  }
  
  public String cQ()
  {
    return ah(4128);
  }
  
  public String cR()
  {
    Integer localInteger = ((q)this.ga).Z(4129);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto focus";
    }
    return "Manual focus";
  }
  
  public String cS()
  {
    return ah(4144);
  }
  
  public String cT()
  {
    Integer localInteger = ((q)this.ga).Z(4145);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 1: 
      return "Portrait scene";
    case 2: 
      return "Landscape scene";
    case 4: 
      return "Sports scene";
    case 5: 
      return "Night scene";
    case 6: 
      return "Program AE";
    case 256: 
      return "Aperture priority AE";
    case 512: 
      return "Shutter priority AE";
    }
    return "Manual exposure";
  }
  
  public String cU()
  {
    return ah(4352);
  }
  
  public String cV()
  {
    Integer localInteger = ((q)this.ga).Z(4864);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "No blur warning";
    }
    return "Blur warning";
  }
  
  public String cW()
  {
    Integer localInteger = ((q)this.ga).Z(4865);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto focus good";
    }
    return "Out of focus";
  }
  
  public String cX()
  {
    Integer localInteger = ((q)this.ga).Z(4866);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "AE good";
    }
    return "Over exposed (>1/1000s @ F11)";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 4097: 
      return aT();
    case 4098: 
      return aJ();
    case 4099: 
      return cN();
    case 4100: 
      return cO();
    case 4112: 
      return ba();
    case 4113: 
      return cP();
    case 4128: 
      return cQ();
    case 4129: 
      return cR();
    case 4144: 
      return cS();
    case 4145: 
      return cT();
    case 4352: 
      return cU();
    case 4864: 
      return cV();
    case 4865: 
      return cW();
    }
    return cX();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */