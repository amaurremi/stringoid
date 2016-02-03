package com.drew.imaging.jpeg;

import com.drew.metadata.b.k;
import com.drew.metadata.d;
import com.drew.metadata.jpeg.e;
import com.drew.metadata.jpeg.f;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

public class a
{
  public static d a(JpegSegmentData paramJpegSegmentData)
  {
    d locald = new d();
    int i = 0;
    if (i < 16)
    {
      if ((i == 4) || (i == 12)) {}
      do
      {
        i = (byte)(i + 1);
        break;
        localObject = paramJpegSegmentData.a((byte)(i - 64));
      } while (localObject == null);
      ((e)locald.a(e.class)).setInt(-3, i);
      new f().a(new com.drew.lang.b((byte[])localObject), locald);
    }
    Object localObject = paramJpegSegmentData.a((byte)-2);
    if (localObject != null) {
      new com.drew.metadata.jpeg.c().a(new com.drew.lang.b((byte[])localObject), locald);
    }
    localObject = paramJpegSegmentData.b((byte)-32).iterator();
    byte[] arrayOfByte1;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfByte1 = (byte[])((Iterator)localObject).next();
      if ((arrayOfByte1.length > 3) && (new String(arrayOfByte1, 0, 4).equals("JFIF"))) {
        new com.drew.metadata.e.c().a(new com.drew.lang.b(arrayOfByte1), locald);
      }
    }
    localObject = paramJpegSegmentData.b((byte)-31).iterator();
    while (((Iterator)localObject).hasNext())
    {
      arrayOfByte1 = (byte[])((Iterator)localObject).next();
      if ((arrayOfByte1.length > 3) && ("EXIF".equalsIgnoreCase(new String(arrayOfByte1, 0, 4)))) {
        new k().a(new com.drew.lang.b(arrayOfByte1), locald);
      }
    }
    localObject = paramJpegSegmentData.b((byte)-30).iterator();
    while (((Iterator)localObject).hasNext())
    {
      arrayOfByte1 = (byte[])((Iterator)localObject).next();
      if ((arrayOfByte1.length > 10) && (new String(arrayOfByte1, 0, 11).equalsIgnoreCase("ICC_PROFILE")))
      {
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 14];
        System.arraycopy(arrayOfByte1, 14, arrayOfByte2, 0, arrayOfByte1.length - 14);
        new com.drew.metadata.c.c().a(new com.drew.lang.b(arrayOfByte2), locald);
      }
    }
    localObject = paramJpegSegmentData.b((byte)-19).iterator();
    while (((Iterator)localObject).hasNext())
    {
      arrayOfByte1 = (byte[])((Iterator)localObject).next();
      if ((arrayOfByte1.length > 12) && ("Photoshop 3.0".compareTo(new String(arrayOfByte1, 0, 13)) == 0)) {
        new com.drew.metadata.f.c().a(new com.drew.lang.b(arrayOfByte1), locald);
      } else {
        new com.drew.metadata.d.c().a(new com.drew.lang.b(arrayOfByte1), locald);
      }
    }
    paramJpegSegmentData = paramJpegSegmentData.b((byte)-18).iterator();
    while (paramJpegSegmentData.hasNext())
    {
      localObject = (byte[])paramJpegSegmentData.next();
      if ((localObject.length == 12) && ("Adobe".compareTo(new String((byte[])localObject, 0, 5)) == 0)) {
        new com.drew.metadata.a.c().a(new com.drew.lang.b((byte[])localObject), locald);
      }
    }
    return locald;
  }
  
  public static d a(File paramFile)
  {
    return a(new b(paramFile).aq());
  }
  
  public static d a(InputStream paramInputStream, boolean paramBoolean)
  {
    return a(new b(paramInputStream, paramBoolean).aq());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/jpeg/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */