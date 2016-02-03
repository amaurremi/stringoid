package com.drew.metadata.f;

import com.drew.lang.BufferBoundsException;
import com.drew.metadata.f;

public class a
  extends f<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  private String as(int paramInt)
  {
    byte[] arrayOfByte = ((b)this.ga).aa(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    if (arrayOfByte[0] == 0) {
      return "No";
    }
    return "Yes";
  }
  
  private String at(int paramInt)
  {
    Object localObject = ((b)this.ga).aa(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = new com.drew.lang.b((byte[])localObject);
    try
    {
      localObject = String.format("%d", new Object[] { Integer.valueOf(((com.drew.lang.a)localObject).S(0)) });
      return (String)localObject;
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return null;
  }
  
  private String au(int paramInt)
  {
    byte[] arrayOfByte = ((b)this.ga).aa(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    return new String(arrayOfByte);
  }
  
  private String av(int paramInt)
  {
    byte[] arrayOfByte = ((b)this.ga).aa(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    return String.format("%d bytes binary data", new Object[] { Integer.valueOf(arrayOfByte.length) });
  }
  
  public String ar(int paramInt)
  {
    try
    {
      Object localObject = ((b)this.ga).aa(paramInt);
      if (localObject == null) {
        return null;
      }
      localObject = new com.drew.lang.b((byte[])localObject);
      paramInt = ((com.drew.lang.a)localObject).S(0);
      int i = ((com.drew.lang.a)localObject).S(4);
      int j = ((com.drew.lang.a)localObject).S(8);
      int k = ((com.drew.lang.a)localObject).S(16);
      int m = ((com.drew.lang.a)localObject).S(20);
      int n = ((com.drew.lang.a)localObject).S(24);
      if (paramInt == 1) {}
      for (localObject = "JpegRGB";; localObject = "RawRGB") {
        return String.format("%s, %dx%d, Decomp %d bytes, %d bpp, %d bytes", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
      }
      return null;
    }
    catch (BufferBoundsException localBufferBoundsException) {}
  }
  
  public String ev()
  {
    try
    {
      Object localObject = ((b)this.ga).aa(1057);
      if (localObject == null) {
        return null;
      }
      localObject = new com.drew.lang.b((byte[])localObject);
      int i = ((com.drew.lang.a)localObject).S(0);
      int j = ((com.drew.lang.a)localObject).S(5);
      String str = ((com.drew.lang.a)localObject).a(9, j * 2, "UTF-16");
      int k = j * 2 + 9;
      j = ((com.drew.lang.a)localObject).S(k);
      k += 4;
      localObject = String.format("%d (%s, %s) %d", new Object[] { Integer.valueOf(i), str, ((com.drew.lang.a)localObject).a(k, j * 2, "UTF-16"), Integer.valueOf(((com.drew.lang.a)localObject).S(k + j * 2)) });
      return (String)localObject;
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return null;
  }
  
  public String fe()
  {
    int j;
    int k;
    int i;
    try
    {
      localb = new com.drew.lang.b(((b)this.ga).aa(1030));
      j = localb.P(0);
      k = localb.P(2);
      m = localb.P(4);
      if ((j > 65535) || (j < 65533)) {
        break label331;
      }
      i = j - 65532;
    }
    catch (BufferBoundsException localBufferBoundsException)
    {
      com.drew.lang.b localb;
      int m;
      label70:
      return null;
    }
    String str2 = String.format("Unknown 0x%04X", new Object[] { Integer.valueOf(k) });
    for (;;)
    {
      if ((m >= 1) && (m <= 3)) {}
      for (String str3 = String.format("%d", new Object[] { Integer.valueOf(m + 2) });; str3 = String.format("Unknown 0x%04X", new Object[] { Integer.valueOf(m) })) {
        return String.format("%d (%s), %s format, %s scans", new Object[] { Integer.valueOf(i), localb, str2, str3 });
      }
      label179:
      String str1;
      switch (j)
      {
      default: 
        str1 = "Unknown";
      }
      for (;;)
      {
        switch (k)
        {
        default: 
          break label70;
          label331:
          if (j <= 8)
          {
            i = j + 4;
            break label179;
          }
          i = j;
          break label179;
          str1 = "Low";
          continue;
          str1 = "Medium";
          continue;
          str1 = "High";
          continue;
          str1 = "Maximum";
        }
      }
      str2 = "Standard";
      continue;
      str2 = "Optimised";
      continue;
      str2 = "Progressive ";
    }
  }
  
  public String ff()
  {
    try
    {
      Object localObject = ((b)this.ga).aa(1064);
      if (localObject == null) {
        return null;
      }
      localObject = Double.toString(new com.drew.lang.b((byte[])localObject).W(4));
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String fg()
  {
    for (;;)
    {
      try
      {
        localObject = ((b)this.ga).aa(1062);
        if (localObject == null) {
          return null;
        }
        localObject = new com.drew.lang.b((byte[])localObject);
        int i = ((com.drew.lang.a)localObject).S(0);
        f1 = ((com.drew.lang.a)localObject).V(2);
        f2 = ((com.drew.lang.a)localObject).V(6);
        f3 = ((com.drew.lang.a)localObject).V(10);
        switch (i)
        {
        case 0: 
          return String.format("Unknown %04X, X:%s Y:%s, Scale:%s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        float f1;
        float f2;
        float f3;
        return null;
      }
      return "Centered, Scale " + f3;
      localObject = String.format("User defined, X:%s Y:%s, Scale:%s", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      return (String)localObject;
    }
    return "Size to fit";
  }
  
  public String fh()
  {
    try
    {
      Object localObject = ((b)this.ga).aa(1005);
      if (localObject == null) {
        return null;
      }
      localObject = new com.drew.lang.b((byte[])localObject);
      float f1 = ((com.drew.lang.a)localObject).U(0);
      float f2 = ((com.drew.lang.a)localObject).U(8);
      localObject = f1 + "x" + f2 + " DPI";
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String fi()
  {
    try
    {
      Object localObject = ((b)this.ga).aa(1050);
      if (localObject == null) {
        return null;
      }
      localObject = new com.drew.lang.b((byte[])localObject);
      int i = ((com.drew.lang.a)localObject).S(20);
      String str = ((com.drew.lang.a)localObject).a(24, i * 2, "UTF-16");
      i = ((com.drew.lang.a)localObject).S(i * 2 + 24);
      localObject = String.format("%s (%d,%d,%d,%d) %d Slices", new Object[] { str, Integer.valueOf(((com.drew.lang.a)localObject).S(4)), Integer.valueOf(((com.drew.lang.a)localObject).S(8)), Integer.valueOf(((com.drew.lang.a)localObject).S(12)), Integer.valueOf(((com.drew.lang.a)localObject).S(16)), Integer.valueOf(i) });
      return (String)localObject;
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1033: 
    case 1036: 
      return ar(paramInt);
    case 1002: 
    case 1035: 
      return au(paramInt);
    case 1028: 
      return av(paramInt);
    case 1050: 
      return fi();
    case 1057: 
      return ev();
    case 1034: 
      return as(paramInt);
    case 1005: 
      return fh();
    case 1037: 
    case 1044: 
    case 1049: 
    case 1054: 
      return at(paramInt);
    case 1030: 
      return fe();
    case 1062: 
      return fg();
    }
    return ff();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */