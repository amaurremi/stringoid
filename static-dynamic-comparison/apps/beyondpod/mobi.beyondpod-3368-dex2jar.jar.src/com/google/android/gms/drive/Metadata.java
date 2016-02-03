package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fi;
import java.util.Date;

public abstract class Metadata
  implements Freezable<Metadata>
{
  protected abstract <T> T a(MetadataField<T> paramMetadataField);
  
  public Date getCreatedDate()
  {
    return (Date)a(fi.rL);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)a(fh.rG);
  }
  
  public String getMimeType()
  {
    return (String)a(fh.MIME_TYPE);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)a(fi.rK);
  }
  
  public Date getModifiedDate()
  {
    return (Date)a(fi.rJ);
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)a(fi.rM);
  }
  
  public String getTitle()
  {
    return (String)a(fh.TITLE);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)a(fh.rH);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isFolder()
  {
    return "application/vnd.google-apps.folder".equals(getMimeType());
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)a(fh.STARRED);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)a(fh.TRASHED);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */