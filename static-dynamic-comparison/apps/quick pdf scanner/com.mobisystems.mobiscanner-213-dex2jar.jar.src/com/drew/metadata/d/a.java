package com.drew.metadata.d;

import com.drew.lang.e;
import com.drew.metadata.f;

public class a
  extends f<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String eQ()
  {
    Integer localInteger = ((b)this.ga).Z(276);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "No ObjectData";
    case 1: 
      return "IPTC-NAA Digital Newsphoto Parameter Record";
    case 2: 
      return "IPTC7901 Recommended Message Format";
    case 3: 
      return "Tagged Image File Format (Adobe/Aldus Image data)";
    case 4: 
      return "Illustrator (Adobe Graphics data)";
    case 5: 
      return "AppleSingle (Apple Computer Inc)";
    case 6: 
      return "NAA 89-3 (ANPA 1312)";
    case 7: 
      return "MacBinary II";
    case 8: 
      return "IPTC Unstructured Character Oriented File Format (UCOFF)";
    case 9: 
      return "United Press International ANPA 1312 variant";
    case 10: 
      return "United Press International Down-Load Message";
    case 11: 
      return "JPEG File Interchange (JFIF)";
    case 12: 
      return "Photo-CD Image-Pac (Eastman Kodak)";
    case 13: 
      return "Bit Mapped Graphics File [.BMP] (Microsoft)";
    case 14: 
      return "Digital Audio File [.WAV] (Microsoft & Creative Labs)";
    case 15: 
      return "Audio plus Moving Video [.AVI] (Microsoft)";
    case 16: 
      return "PC DOS/Windows Executable Files [.COM][.EXE]";
    case 17: 
      return "Compressed Binary File [.ZIP] (PKWare Inc)";
    case 18: 
      return "Audio Interchange File Format AIFF (Apple Computer Inc)";
    case 19: 
      return "RIFF Wave (Microsoft Corporation)";
    case 20: 
      return "Freehand (Macromedia/Aldus)";
    case 21: 
      return "Hypertext Markup Language [.HTML] (The Internet Society)";
    case 22: 
      return "MPEG 2 Audio Layer 2 (Musicom), ISO/IEC";
    case 23: 
      return "MPEG 2 Audio Layer 3, ISO/IEC";
    case 24: 
      return "Portable Document File [.PDF] Adobe";
    case 25: 
      return "News Industry Text Format (NITF)";
    case 26: 
      return "Tape Archive [.TAR]";
    case 27: 
      return "Tidningarnas Telegrambyra NITF version (TTNITF DTD)";
    case 28: 
      return "Ritzaus Bureau NITF version (RBNITF DTD)";
    }
    return "Corel Draw [.CDR]";
  }
  
  public String eR()
  {
    String[] arrayOfString = ((b)this.ga).getStringArray(537);
    if (arrayOfString == null) {
      return null;
    }
    return e.a(arrayOfString, ";");
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 276: 
      return eQ();
    }
    return eR();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */