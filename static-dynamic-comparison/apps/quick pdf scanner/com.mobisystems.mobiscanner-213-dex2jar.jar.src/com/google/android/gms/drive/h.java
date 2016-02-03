package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.dz;

public final class h
{
  private final MetadataBundle sX;
  
  private h(MetadataBundle paramMetadataBundle)
  {
    this.sX = MetadataBundle.a(paramMetadataBundle);
  }
  
  public String getMimeType()
  {
    return (String)this.sX.a(dz.uh);
  }
  
  public MetadataBundle na()
  {
    return this.sX;
  }
  
  public static class a
  {
    private final MetadataBundle sX = MetadataBundle.ns();
    
    public a ar(String paramString)
    {
      this.sX.b(dz.ug, paramString);
      return this;
    }
    
    public a as(String paramString)
    {
      this.sX.b(dz.uh, paramString);
      return this;
    }
    
    public h nb()
    {
      return new h(this.sX, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */