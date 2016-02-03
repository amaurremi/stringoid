package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fi;
import java.util.Date;

public class SearchableField
{
  public static final MetadataField<String> MIME_TYPE;
  public static final OrderedMetadataField<Date> MODIFIED_DATE = fi.rJ;
  public static final CollectionMetadataField<DriveId> PARENTS;
  public static final MetadataField<Boolean> STARRED;
  public static final MetadataField<String> TITLE = fh.TITLE;
  public static final MetadataField<Boolean> TRASHED;
  public static final OrderedMetadataField<Date> rM;
  
  static
  {
    MIME_TYPE = fh.MIME_TYPE;
    TRASHED = fh.TRASHED;
    PARENTS = fh.PARENTS;
    rM = fi.rM;
    STARRED = fh.STARRED;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/SearchableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */