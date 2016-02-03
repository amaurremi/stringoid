package com.drew.metadata.b;

import com.drew.metadata.f;

public class v
  extends f<w>
{
  public v(w paramw)
  {
    super(paramw);
  }
  
  public String by()
  {
    byte[] arrayOfByte = ((w)this.ga).aa(3584);
    if (arrayOfByte == null) {
      return null;
    }
    return "(" + arrayOfByte.length + " bytes)";
  }
  
  public String dk()
  {
    byte[] arrayOfByte = ((w)this.ga).aa(1);
    if (arrayOfByte == null) {
      return null;
    }
    return "(" + arrayOfByte.length + " bytes)";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 3584: 
      return by();
    }
    return dk();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */