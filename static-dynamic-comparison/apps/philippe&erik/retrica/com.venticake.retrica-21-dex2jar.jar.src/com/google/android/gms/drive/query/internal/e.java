package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Iterator;
import java.util.Set;

class e
{
  static MetadataField<?> a(MetadataBundle paramMetadataBundle)
  {
    paramMetadataBundle = paramMetadataBundle.gG();
    if (paramMetadataBundle.size() != 1) {
      throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
    return (MetadataField)paramMetadataBundle.iterator().next();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */