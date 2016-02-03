package com.drew.metadata.b;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(7), "Firmware Version");
    gb.put(Integer.valueOf(8), "Image Number");
    gb.put(Integer.valueOf(6), "Image Type");
    gb.put(Integer.valueOf(9), "Owner Name");
    gb.put(Integer.valueOf(12), "Camera Serial Number");
    gb.put(Integer.valueOf(13), "Camera Info Array");
    gb.put(Integer.valueOf(14), "File Length");
    gb.put(Integer.valueOf(15), "Custom Functions");
    gb.put(Integer.valueOf(16), "Canon Model ID");
    gb.put(Integer.valueOf(17), "Movie Info Array");
    gb.put(Integer.valueOf(49427), "AF Point Selected");
    gb.put(Integer.valueOf(49413), "Continuous Drive Mode");
    gb.put(Integer.valueOf(49421), "Contrast");
    gb.put(Integer.valueOf(49419), "Easy Shooting Mode");
    gb.put(Integer.valueOf(49428), "Exposure Mode");
    gb.put(Integer.valueOf(49437), "Flash Details");
    gb.put(Integer.valueOf(49412), "Flash Mode");
    gb.put(Integer.valueOf(49433), "Focal Units per mm");
    gb.put(Integer.valueOf(49415), "Focus Mode");
    gb.put(Integer.valueOf(49440), "Focus Mode");
    gb.put(Integer.valueOf(49418), "Image Size");
    gb.put(Integer.valueOf(49424), "Iso");
    gb.put(Integer.valueOf(49431), "Long Focal Length");
    gb.put(Integer.valueOf(49409), "Macro Mode");
    gb.put(Integer.valueOf(49425), "Metering Mode");
    gb.put(Integer.valueOf(49422), "Saturation");
    gb.put(Integer.valueOf(49410), "Self Timer Delay");
    gb.put(Integer.valueOf(49423), "Sharpness");
    gb.put(Integer.valueOf(49432), "Short Focal Length");
    gb.put(Integer.valueOf(49411), "Quality");
    gb.put(Integer.valueOf(49414), "Unknown Camera Setting 2");
    gb.put(Integer.valueOf(49416), "Unknown Camera Setting 3");
    gb.put(Integer.valueOf(49417), "Unknown Camera Setting 4");
    gb.put(Integer.valueOf(49420), "Digital Zoom");
    gb.put(Integer.valueOf(49426), "Focus Type");
    gb.put(Integer.valueOf(49429), "Unknown Camera Setting 7");
    gb.put(Integer.valueOf(49430), "Unknown Camera Setting 8");
    gb.put(Integer.valueOf(49434), "Unknown Camera Setting 9");
    gb.put(Integer.valueOf(49435), "Unknown Camera Setting 10");
    gb.put(Integer.valueOf(49436), "Flash Activity");
    gb.put(Integer.valueOf(49438), "Unknown Camera Setting 12");
    gb.put(Integer.valueOf(49439), "Unknown Camera Setting 13");
    gb.put(Integer.valueOf(49671), "White Balance");
    gb.put(Integer.valueOf(49673), "Sequence Number");
    gb.put(Integer.valueOf(49678), "AF Point Used");
    gb.put(Integer.valueOf(49679), "Flash Bias");
    gb.put(Integer.valueOf(49680), "Auto Exposure Bracketing");
    gb.put(Integer.valueOf(49681), "AEB Bracket Value");
    gb.put(Integer.valueOf(49683), "Subject Distance");
    gb.put(Integer.valueOf(50177), "Auto ISO");
    gb.put(Integer.valueOf(50178), "Base ISO");
    gb.put(Integer.valueOf(50179), "Measured EV");
    gb.put(Integer.valueOf(50180), "Target Aperture");
    gb.put(Integer.valueOf(50181), "Target Exposure Time");
    gb.put(Integer.valueOf(50182), "Exposure Compensation");
    gb.put(Integer.valueOf(50183), "White Balance");
    gb.put(Integer.valueOf(50184), "Slow Shutter");
    gb.put(Integer.valueOf(50185), "Sequence Number");
    gb.put(Integer.valueOf(50186), "Optical Zoom Code");
    gb.put(Integer.valueOf(50188), "Camera Temperature");
    gb.put(Integer.valueOf(50189), "Flash Guide Number");
    gb.put(Integer.valueOf(50190), "AF Points in Focus");
    gb.put(Integer.valueOf(50191), "Flash Exposure Compensation");
    gb.put(Integer.valueOf(50192), "Auto Exposure Bracketing");
    gb.put(Integer.valueOf(50193), "AEB Bracket Value");
    gb.put(Integer.valueOf(50194), "Control Mode");
    gb.put(Integer.valueOf(50195), "Focus Distance Upper");
    gb.put(Integer.valueOf(50196), "Focus Distance Lower");
    gb.put(Integer.valueOf(50197), "F Number");
    gb.put(Integer.valueOf(50198), "Exposure Time");
    gb.put(Integer.valueOf(50199), "Measured EV 2");
    gb.put(Integer.valueOf(50200), "Bulb Duration");
    gb.put(Integer.valueOf(50202), "Camera Type");
    gb.put(Integer.valueOf(50203), "Auto Rotate");
    gb.put(Integer.valueOf(50204), "ND Filter");
    gb.put(Integer.valueOf(50205), "Self Timer 2");
    gb.put(Integer.valueOf(50209), "Flash Output");
    gb.put(Integer.valueOf(50434), "Panorama Frame Number");
    gb.put(Integer.valueOf(50437), "Panorama Direction");
    gb.put(Integer.valueOf(53760), "AF Point Count");
    gb.put(Integer.valueOf(53761), "Valid AF Point Count");
    gb.put(Integer.valueOf(53762), "Image Width");
    gb.put(Integer.valueOf(53763), "Image Height");
    gb.put(Integer.valueOf(53764), "AF Image Width");
    gb.put(Integer.valueOf(53765), "AF Image Height");
    gb.put(Integer.valueOf(53766), "AF Area Width");
    gb.put(Integer.valueOf(53767), "AF Area Height");
    gb.put(Integer.valueOf(53768), "AF Area X Positions");
    gb.put(Integer.valueOf(53769), "AF Area Y Positions");
    gb.put(Integer.valueOf(53770), "AF Points in Focus Count");
    gb.put(Integer.valueOf(53771), "Primary AF Point 1");
    gb.put(Integer.valueOf(53772), "Primary AF Point 2");
    gb.put(Integer.valueOf(19), "Thumbnail Image Valid Area");
    gb.put(Integer.valueOf(21), "Serial Number Format");
    gb.put(Integer.valueOf(26), "Super Macro");
    gb.put(Integer.valueOf(28), "Date Stamp Mode");
    gb.put(Integer.valueOf(29), "My Colors");
    gb.put(Integer.valueOf(30), "Firmware Revision");
    gb.put(Integer.valueOf(35), "Categories");
    gb.put(Integer.valueOf(36), "Face Detect Array 1");
    gb.put(Integer.valueOf(37), "Face Detect Array 2");
    gb.put(Integer.valueOf(38), "AF Info Array 2");
    gb.put(Integer.valueOf(40), "Image Unique ID");
    gb.put(Integer.valueOf(129), "Raw Data Offset");
    gb.put(Integer.valueOf(131), "Original Decision Data Offset");
    gb.put(Integer.valueOf(144), "Custom Functions (1D) Array");
    gb.put(Integer.valueOf(145), "Personal Functions Array");
    gb.put(Integer.valueOf(146), "Personal Function Values Array");
    gb.put(Integer.valueOf(147), "File Info Array");
    gb.put(Integer.valueOf(148), "AF Points in Focus (1D)");
    gb.put(Integer.valueOf(149), "Lens Model");
    gb.put(Integer.valueOf(150), "Serial Info Array");
    gb.put(Integer.valueOf(151), "Dust Removal Data");
    gb.put(Integer.valueOf(152), "Crop Info");
    gb.put(Integer.valueOf(153), "Custom Functions Array 2");
    gb.put(Integer.valueOf(154), "Aspect Information Array");
    gb.put(Integer.valueOf(160), "Processing Information Array");
    gb.put(Integer.valueOf(161), "Tone Curve Table");
    gb.put(Integer.valueOf(162), "Sharpness Table");
    gb.put(Integer.valueOf(163), "Sharpness Frequency Table");
    gb.put(Integer.valueOf(164), "White Balance Table");
    gb.put(Integer.valueOf(169), "Color Balance Array");
    gb.put(Integer.valueOf(170), "Measured Color Array");
    gb.put(Integer.valueOf(174), "Color Temperature");
    gb.put(Integer.valueOf(176), "Canon Flags Array");
    gb.put(Integer.valueOf(177), "Modified Information Array");
    gb.put(Integer.valueOf(178), "Tone Curve Matching");
    gb.put(Integer.valueOf(179), "White Balance Matching");
    gb.put(Integer.valueOf(180), "Color Space");
    gb.put(Integer.valueOf(182), "Preview Image Info Array");
    gb.put(Integer.valueOf(208), "VRD Offset");
    gb.put(Integer.valueOf(224), "Sensor Information Array");
    gb.put(Integer.valueOf(16385), "Color Data Array 1");
    gb.put(Integer.valueOf(16387), "Color Data Array 2");
    gb.put(Integer.valueOf(16400), "Custom Picture Style File Name");
    gb.put(Integer.valueOf(16403), "Color Info Array");
    gb.put(Integer.valueOf(16405), "Vignetting Correction Array 1");
    gb.put(Integer.valueOf(16406), "Vignetting Correction Array 2");
    gb.put(Integer.valueOf(16408), "Lighting Optimizer Array");
    gb.put(Integer.valueOf(16409), "Lens Info Array");
    gb.put(Integer.valueOf(16416), "Ambiance Info Array");
    gb.put(Integer.valueOf(16420), "Filter Info Array");
  }
  
  public b()
  {
    a(new a(this));
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramArrayOfInt);
    }
    for (;;)
    {
      return;
      while (i < paramArrayOfInt.length)
      {
        setInt(49408 + i, paramArrayOfInt[i]);
        i += 1;
      }
      while (j < paramArrayOfInt.length)
      {
        setInt(49664 + j, paramArrayOfInt[j]);
        j += 1;
      }
      continue;
      while (k < paramArrayOfInt.length)
      {
        setInt(50176 + k, paramArrayOfInt[k]);
        k += 1;
      }
      continue;
      while (m < paramArrayOfInt.length)
      {
        setInt(50432 + m, paramArrayOfInt[m]);
        m += 1;
      }
      continue;
      while (n < paramArrayOfInt.length)
      {
        setInt(53760 + n, paramArrayOfInt[n]);
        n += 1;
      }
    }
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Canon Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */