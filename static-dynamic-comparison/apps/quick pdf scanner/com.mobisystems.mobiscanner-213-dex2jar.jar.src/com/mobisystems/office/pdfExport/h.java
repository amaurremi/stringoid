package com.mobisystems.office.pdfExport;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class h
{
  private Map<String, d> aNb = new HashMap();
  private int aNc;
  private Map<String, EmbeddedFont> aNd = new HashMap(64);
  private Map<d, ImagePattern> aNe = new IdentityHashMap();
  
  private String KD()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Img");
    int i = this.aNc;
    this.aNc = (i + 1);
    return i;
  }
  
  public d a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = String.valueOf(System.identityHashCode(paramBitmap)) + String.valueOf(paramInt);
    }
    d locald = (d)this.aNb.get(str);
    paramString = locald;
    if (locald == null)
    {
      paramString = new d(KD(), paramBitmap, paramInt);
      this.aNb.put(str, paramString);
    }
    return paramString;
  }
  
  public d a(InputStream paramInputStream, int paramInt1, int paramInt2, String paramString)
  {
    d locald = (d)this.aNb.get(paramString);
    Object localObject = locald;
    if (locald == null)
    {
      localObject = new c(KD(), paramInputStream, paramInt1, paramInt2);
      this.aNb.put(paramString, localObject);
    }
    return (d)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */