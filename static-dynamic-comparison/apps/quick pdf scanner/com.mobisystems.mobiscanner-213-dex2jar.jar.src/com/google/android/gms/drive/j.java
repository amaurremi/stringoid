package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class j
  extends f
{
  private final MetadataBundle sY;
  
  public j(MetadataBundle paramMetadataBundle)
  {
    this.sY = paramMetadataBundle;
  }
  
  protected <T> T a(b<T> paramb)
  {
    return (T)this.sY.a(paramb);
  }
  
  public f mZ()
  {
    return new j(MetadataBundle.a(this.sY));
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.sY + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */