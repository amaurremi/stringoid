package com.google.android.gms.drive.metadata;

import java.util.Collection;

public abstract class OrderedMetadataField<T extends Comparable<T>>
  extends MetadataField<T>
{
  protected OrderedMetadataField(String paramString)
  {
    super(paramString);
  }
  
  protected OrderedMetadataField(String paramString, Collection<String> paramCollection)
  {
    super(paramString, paramCollection);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/metadata/OrderedMetadataField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */