package com.drew.metadata.b;

import com.drew.metadata.f;

public class ab
  extends f<ac>
{
  public ab(ac paramac)
  {
    super(paramac);
  }
  
  public String bc()
  {
    Integer localInteger = ((ac)this.ga).Z(514);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal (no macro)";
    }
    return "Macro";
  }
  
  public String dJ()
  {
    Integer localInteger = ((ac)this.ga).Z(516);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 1: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    }
    return "Digital 2x Zoom";
  }
  
  public String dK()
  {
    Integer localInteger = ((ac)this.ga).Z(513);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "SQ";
    case 2: 
      return "HQ";
    }
    return "SHQ";
  }
  
  public String dL()
  {
    int[] arrayOfInt = ((ac)this.ga).getIntArray(512);
    if (arrayOfInt == null) {
      return null;
    }
    if (arrayOfInt.length < 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (arrayOfInt[0])
    {
    default: 
      localStringBuilder.append("Unknown picture taking mode");
    }
    while (arrayOfInt.length < 2)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("Normal picture taking mode");
      continue;
      localStringBuilder.append("Unknown picture taking mode");
      continue;
      localStringBuilder.append("Fast picture taking mode");
      continue;
      localStringBuilder.append("Panorama picture taking mode");
    }
    localStringBuilder.append(" - ");
    switch (arrayOfInt[1])
    {
    default: 
      localStringBuilder.append(arrayOfInt[1]);
      localStringBuilder.append("th in a sequence");
    }
    while (arrayOfInt.length < 3)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("Unknown sequence number");
      continue;
      localStringBuilder.append("1st in a sequence");
      continue;
      localStringBuilder.append("2nd in a sequence");
      continue;
      localStringBuilder.append("3rd in a sequence");
    }
    localStringBuilder.append(" - ");
    switch (arrayOfInt[2])
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("Left to right panorama direction");
      continue;
      localStringBuilder.append("Right to left panorama direction");
      continue;
      localStringBuilder.append("Bottom to top panorama direction");
      continue;
      localStringBuilder.append("Top to bottom panorama direction");
    }
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 515: 
    default: 
      return super.getDescription(paramInt);
    case 512: 
      return dL();
    case 513: 
      return dK();
    case 514: 
      return bc();
    }
    return dJ();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */