package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.StringMetadataField;
import com.google.android.gms.drive.metadata.internal.a;
import com.google.android.gms.drive.metadata.internal.e;

public class fh
{
  public static final MetadataField<String> MIME_TYPE;
  public static final CollectionMetadataField<DriveId> PARENTS = new e("parents");
  public static final MetadataField<Boolean> STARRED;
  public static final MetadataField<String> TITLE;
  public static final MetadataField<Boolean> TRASHED;
  public static final MetadataField<DriveId> rG = fj.rN;
  public static final MetadataField<Boolean> rH;
  public static final MetadataField<Boolean> rI;
  
  static
  {
    TITLE = new StringMetadataField("title");
    MIME_TYPE = new StringMetadataField("mimeType");
    STARRED = new a("starred");
    TRASHED = new a("trashed")
    {
      protected Boolean e(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousDataHolder.getInteger(getName(), paramAnonymousInt1, paramAnonymousInt2) != 0) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    };
    rH = new a("isEditable");
    rI = new a("isPinned");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */