package com.drew.metadata.f;

import com.drew.metadata.f;

public class d
  extends f<e>
{
  public d(e parame)
  {
    super(parame);
  }
  
  public String jdMethod_do()
  {
    for (;;)
    {
      try
      {
        Integer localInteger = Integer.valueOf(((e)this.ga).getInt(5));
        if (localInteger == null) {
          return null;
        }
        switch (localInteger.intValue())
        {
        case 5: 
        case 6: 
          return "Unknown color mode (" + localInteger + ")";
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      return "Lab";
    }
    return "Bitmap";
    return "Grayscale";
    return "Indexed";
    return "RGB";
    return "CMYK";
    return "Multichannel";
    return "Duotone";
  }
  
  public String fb()
  {
    try
    {
      Object localObject = Integer.valueOf(((e)this.ga).getInt(3));
      if (localObject == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" pixel");
      if (((Integer)localObject).intValue() == 1) {}
      for (localObject = "";; localObject = "s") {
        return (String)localObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public String fc()
  {
    try
    {
      Object localObject = Integer.valueOf(((e)this.ga).getInt(2));
      if (localObject == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" pixel");
      if (((Integer)localObject).intValue() == 1) {}
      for (localObject = "";; localObject = "s") {
        return (String)localObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public String fj()
  {
    try
    {
      Object localObject = Integer.valueOf(((e)this.ga).getInt(1));
      if (localObject == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" channel");
      if (((Integer)localObject).intValue() == 1) {}
      for (localObject = "";; localObject = "s") {
        return (String)localObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public String fk()
  {
    try
    {
      Object localObject = Integer.valueOf(((e)this.ga).getInt(4));
      if (localObject == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" bit");
      if (((Integer)localObject).intValue() == 1) {}
      for (localObject = "";; localObject = "s") {
        return (String)localObject + " per channel";
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return fj();
    case 4: 
      return fk();
    case 5: 
      return jdMethod_do();
    case 2: 
      return fc();
    }
    return fb();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */