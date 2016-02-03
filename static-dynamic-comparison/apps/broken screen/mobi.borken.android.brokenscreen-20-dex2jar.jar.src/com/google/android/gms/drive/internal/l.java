package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class l
  extends Metadata
{
  private final MetadataBundle IF;
  
  public l(MetadataBundle paramMetadataBundle)
  {
    this.IF = paramMetadataBundle;
  }
  
  protected <T> T a(MetadataField<T> paramMetadataField)
  {
    return (T)this.IF.a(paramMetadataField);
  }
  
  public Metadata gg()
  {
    return new l(MetadataBundle.a(this.IF));
  }
  
  public boolean isDataValid()
  {
    return this.IF != null;
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.IF + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */