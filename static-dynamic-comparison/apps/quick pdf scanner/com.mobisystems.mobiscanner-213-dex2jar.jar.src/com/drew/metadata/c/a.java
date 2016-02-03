package com.drew.metadata.c;

import com.drew.lang.BufferBoundsException;
import com.drew.metadata.f;
import java.io.UnsupportedEncodingException;

public class a
  extends f<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public static String a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      return "" + Math.round(paramDouble);
    }
    long l3 = Math.abs(paramDouble);
    long l2 = (int)Math.round((Math.abs(paramDouble) - l3) * Math.pow(10.0D, paramInt));
    Object localObject1 = "";
    long l1 = l2;
    while (paramInt > 0)
    {
      int i = (byte)(int)Math.abs(l1 % 10L);
      l1 /= 10L;
      if ((((String)localObject1).length() <= 0) && (!paramBoolean) && (i == 0))
      {
        localObject2 = localObject1;
        if (paramInt != 1) {}
      }
      else
      {
        localObject2 = i + (String)localObject1;
      }
      paramInt -= 1;
      localObject1 = localObject2;
    }
    l1 = l3 + l1;
    StringBuilder localStringBuilder;
    if ((paramDouble < 0.0D) && ((l1 != 0L) || (l2 != 0L)))
    {
      paramInt = 1;
      localStringBuilder = new StringBuilder();
      if (paramInt == 0) {
        break label228;
      }
    }
    label228:
    for (Object localObject2 = "-";; localObject2 = "")
    {
      return (String)localObject2 + l1 + "." + (String)localObject1;
      paramInt = 0;
      break;
    }
  }
  
  private String an(int paramInt)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      try
      {
        localObject3 = ((b)this.ga).aa(paramInt);
        localObject4 = new com.drew.lang.b((byte[])localObject3);
        paramInt = ((com.drew.lang.a)localObject4).S(0);
        float f1;
        float f2;
        float f3;
        label374:
        Object localObject1;
        Object localObject2;
        switch (paramInt)
        {
        case 1952807028: 
          String str1 = String.format("%s(0x%08X): %d bytes", new Object[] { c.ao(paramInt), Integer.valueOf(paramInt), Integer.valueOf(localObject3.length) });
          return str1;
          try
          {
            str1 = new String((byte[])localObject3, 8, localObject3.length - 8 - 1, "ASCII");
            return str1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            return new String((byte[])localObject3, 8, localObject3.length - 8 - 1);
          }
        case 1684370275: 
          return new String((byte[])localObject3, 12, ((com.drew.lang.a)localObject4).S(8) - 1);
        case 1936287520: 
          return c.ao(((com.drew.lang.a)localObject4).S(8));
        case 1835360627: 
          paramInt = ((com.drew.lang.a)localObject4).S(8);
          f1 = ((com.drew.lang.a)localObject4).U(12);
          f2 = ((com.drew.lang.a)localObject4).U(16);
          f3 = ((com.drew.lang.a)localObject4).U(20);
          i = ((com.drew.lang.a)localObject4).S(24);
          float f4 = ((com.drew.lang.a)localObject4).U(28);
          j = ((com.drew.lang.a)localObject4).S(32);
          switch (paramInt)
          {
          default: 
            localObject3 = String.format("Unknown %d", new Object[] { Integer.valueOf(paramInt) });
            break label866;
            localObject4 = String.format("Unknown %d", new Object[] { Integer.valueOf(paramInt) });
            break label899;
            localObject1 = String.format("Unknown %d", new Object[] { Integer.valueOf(j) });
            return String.format("%s Observer, Backing (%s, %s, %s), Geometry %s, Flare %d%%, Illuminant %s", new Object[] { localObject3, Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), localObject4, Integer.valueOf(Math.round(100.0F * f4)), localObject1 });
          }
        case 1482250784: 
          localObject1 = new StringBuilder();
          j = (localObject3.length - 8) / 12;
          paramInt = i;
          if (paramInt < j)
          {
            f1 = ((com.drew.lang.a)localObject4).U(paramInt * 12 + 8);
            f2 = ((com.drew.lang.a)localObject4).U(paramInt * 12 + 8 + 4);
            f3 = ((com.drew.lang.a)localObject4).U(paramInt * 12 + 8 + 8);
            if (paramInt > 0) {
              ((StringBuilder)localObject1).append(", ");
            }
            ((StringBuilder)localObject1).append("(").append(f1).append(", ").append(f2).append(", ").append(f3).append(")");
            paramInt += 1;
            continue;
          }
          return ((StringBuilder)localObject1).toString();
        case 1835824483: 
          i = ((com.drew.lang.a)localObject4).S(8);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          paramInt = j;
          if (paramInt < i)
          {
            String str3 = c.ao(((com.drew.lang.a)localObject4).S(paramInt * 12 + 16));
            j = ((com.drew.lang.a)localObject4).S(paramInt * 12 + 16 + 4);
            int k = ((com.drew.lang.a)localObject4).S(paramInt * 12 + 16 + 8);
            try
            {
              localObject1 = new String((byte[])localObject3, k, j, "UTF-16BE");
              localStringBuilder.append(" ").append(str3).append("(").append((String)localObject1).append(")");
              paramInt += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException2)
            {
              localObject2 = new String((byte[])localObject3, k, j);
              continue;
            }
          }
          return localStringBuilder.toString();
        case 1668641398: 
          i = ((com.drew.lang.a)localObject4).S(8);
          localObject2 = new StringBuilder();
          paramInt = 0;
          if (paramInt < i)
          {
            if (paramInt != 0) {
              ((StringBuilder)localObject2).append(", ");
            }
            ((StringBuilder)localObject2).append(a(((com.drew.lang.a)localObject4).P(paramInt * 2 + 12) / 65535.0D, 7, false));
            paramInt += 1;
            continue;
          }
          localObject2 = ((StringBuilder)localObject2).toString();
          return (String)localObject2;
        }
        continue;
        continue;
      }
      catch (BufferBoundsException localBufferBoundsException)
      {
        return null;
      }
      switch (i)
      {
      default: 
        break;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          label866:
          switch (j)
          {
          default: 
            label899:
            break label374;
            localObject3 = "Unknown";
            break label866;
            localObject3 = "1931 2°";
            break label866;
            localObject3 = "1964 10°";
            break label866;
            localObject4 = "Unknown";
            continue;
            localObject4 = "0/45 or 45/0";
            continue;
            localObject4 = "0/d or d/0";
          }
        }
        String str2 = "unknown";
        continue;
        str2 = "D50";
        continue;
        str2 = "D65";
        continue;
        str2 = "D93";
        continue;
        str2 = "F2";
        continue;
        str2 = "D55";
        continue;
        str2 = "A";
        continue;
        str2 = "Equi-Power (E)";
        continue;
        str2 = "F8";
      }
    }
  }
  
  private String eM()
  {
    Integer localInteger = ((b)this.ga).Z(64);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Perceptual";
    case 1: 
      return "Media-Relative Colorimetric";
    case 2: 
      return "Saturation";
    }
    return "ICC-Absolute Colorimetric";
  }
  
  private String eN()
  {
    String str = ((b)this.ga).getString(40);
    if (str == null) {
      return null;
    }
    try
    {
      int i = f(str);
      switch (i)
      {
      default: 
        return String.format("Unknown (%s)", new Object[] { str });
      case 1095782476: 
        return "Apple Computer, Inc.";
      case 1297303124: 
        return "Microsoft Corporation";
      case 1397180704: 
        return "Silicon Graphics, Inc.";
      case 1398099543: 
        return "Sun Microsystems, Inc.";
      }
      return "Taligent, Inc.";
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return str;
  }
  
  private String eO()
  {
    String str = ((b)this.ga).getString(12);
    if (str == null) {
      return null;
    }
    try
    {
      int i = f(str);
      switch (i)
      {
      default: 
        return String.format("Unknown (%s)", new Object[] { str });
      case 1935896178: 
        return "Input Device";
      case 1835955314: 
        return "Display Device";
      case 1886549106: 
        return "Output Device";
      case 1818848875: 
        return "DeviceLink";
      case 1936744803: 
        return "ColorSpace Conversion";
      case 1633842036: 
        return "Abstract";
      }
      return "Named Color";
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return str;
  }
  
  private String eP()
  {
    Integer localInteger = ((b)this.ga).Z(8);
    if (localInteger == null) {
      return null;
    }
    return String.format("%d.%d.%d", new Object[] { Integer.valueOf((localInteger.intValue() & 0xFF000000) >> 24), Integer.valueOf((localInteger.intValue() & 0xF00000) >> 20), Integer.valueOf((localInteger.intValue() & 0xF0000) >> 16) });
  }
  
  private static int f(String paramString)
  {
    return new com.drew.lang.b(paramString.getBytes()).S(0);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if ((paramInt > 538976288) && (paramInt < 2054847098)) {
        return an(paramInt);
      }
      break;
    case 8: 
      return eP();
    case 12: 
      return eO();
    case 40: 
      return eN();
    case 64: 
      return eM();
    }
    return super.getDescription(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */