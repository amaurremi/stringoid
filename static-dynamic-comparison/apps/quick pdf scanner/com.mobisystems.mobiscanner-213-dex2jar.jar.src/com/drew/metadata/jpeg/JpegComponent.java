package com.drew.metadata.jpeg;

import java.io.Serializable;

public class JpegComponent
  implements Serializable
{
  private static final long serialVersionUID = 61121257899091914L;
  private final int _componentId;
  private final int _quantizationTableNumber;
  private final int _samplingFactorByte;
  
  public JpegComponent(int paramInt1, int paramInt2, int paramInt3)
  {
    this._componentId = paramInt1;
    this._samplingFactorByte = paramInt2;
    this._quantizationTableNumber = paramInt3;
  }
  
  public String eW()
  {
    switch (this._componentId)
    {
    default: 
      return null;
    case 1: 
      return "Y";
    case 2: 
      return "Cb";
    case 3: 
      return "Cr";
    case 4: 
      return "I";
    }
    return "Q";
  }
  
  public int eX()
  {
    return this._quantizationTableNumber;
  }
  
  public int eY()
  {
    return this._samplingFactorByte & 0xF;
  }
  
  public int eZ()
  {
    return this._samplingFactorByte >> 4 & 0xF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/jpeg/JpegComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */