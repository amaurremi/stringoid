package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class l
  extends Metadata
{
  private final MetadataBundle II;
  
  public l(MetadataBundle paramMetadataBundle)
  {
    this.II = paramMetadataBundle;
  }
  
  protected <T> T a(MetadataField<T> paramMetadataField)
  {
    return (T)this.II.a(paramMetadataField);
  }
  
  public Metadata gl()
  {
    return new l(MetadataBundle.a(this.II));
  }
  
  public boolean isDataValid()
  {
    return this.II != null;
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.II + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */