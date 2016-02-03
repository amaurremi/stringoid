package com.drew.metadata.jpeg;

import com.drew.metadata.f;

public class d
  extends f<e>
{
  public d(e parame)
  {
    super(parame);
  }
  
  public String ap(int paramInt)
  {
    JpegComponent localJpegComponent = ((e)this.ga).aq(paramInt);
    if (localJpegComponent == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localJpegComponent.eW());
    localStringBuilder.append(" component: Quantization table ");
    localStringBuilder.append(localJpegComponent.eX());
    localStringBuilder.append(", Sampling factors ");
    localStringBuilder.append(localJpegComponent.eY());
    localStringBuilder.append(" horiz/");
    localStringBuilder.append(localJpegComponent.eZ());
    localStringBuilder.append(" vert");
    return localStringBuilder.toString();
  }
  
  public String fa()
  {
    Integer localInteger = ((e)this.ga).Z(-3);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 4: 
    case 12: 
    default: 
      return "Unknown type: " + localInteger;
    case 0: 
      return "Baseline";
    case 1: 
      return "Extended sequential, Huffman";
    case 2: 
      return "Progressive, Huffman";
    case 3: 
      return "Lossless, Huffman";
    case 5: 
      return "Differential sequential, Huffman";
    case 6: 
      return "Differential progressive, Huffman";
    case 7: 
      return "Differential lossless, Huffman";
    case 8: 
      return "Reserved for JPEG extensions";
    case 9: 
      return "Extended sequential, arithmetic";
    case 10: 
      return "Progressive, arithmetic";
    case 11: 
      return "Lossless, arithmetic";
    case 13: 
      return "Differential sequential, arithmetic";
    case 14: 
      return "Differential progressive, arithmetic";
    }
    return "Differential lossless, arithmetic";
  }
  
  public String fb()
  {
    String str = ((e)this.ga).getString(3);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String fc()
  {
    String str = ((e)this.ga).getString(1);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String fd()
  {
    String str = ((e)this.ga).getString(0);
    if (str == null) {
      return null;
    }
    return str + " bits";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case -2: 
    case -1: 
    case 2: 
    case 4: 
    case 5: 
    default: 
      return super.getDescription(paramInt);
    case -3: 
      return fa();
    case 6: 
      return ap(0);
    case 7: 
      return ap(1);
    case 8: 
      return ap(2);
    case 9: 
      return ap(3);
    case 0: 
      return fd();
    case 1: 
      return fc();
    }
    return fb();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/jpeg/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */