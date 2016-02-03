package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Date;

public abstract class Metadata
  implements Freezable<Metadata>
{
  public static final int CONTENT_AVAILABLE_LOCALLY = 1;
  public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;
  
  protected abstract <T> T a(MetadataField<T> paramMetadataField);
  
  public String getAlternateLink()
  {
    return (String)a(iq.JU);
  }
  
  public int getContentAvailability()
  {
    Integer localInteger = (Integer)a(iu.KC);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public Date getCreatedDate()
  {
    return (Date)a(is.Kw);
  }
  
  public String getDescription()
  {
    return (String)a(iq.JW);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)a(iq.JT);
  }
  
  public String getEmbedLink()
  {
    return (String)a(iq.JX);
  }
  
  public String getFileExtension()
  {
    return (String)a(iq.JY);
  }
  
  public long getFileSize()
  {
    return ((Long)a(iq.JZ)).longValue();
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)a(is.Kx);
  }
  
  public String getMimeType()
  {
    return (String)a(iq.Kk);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)a(is.Kz);
  }
  
  public Date getModifiedDate()
  {
    return (Date)a(is.Ky);
  }
  
  public String getOriginalFilename()
  {
    return (String)a(iq.Kl);
  }
  
  public long getQuotaBytesUsed()
  {
    return ((Long)a(iq.Ko)).longValue();
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)a(is.KA);
  }
  
  public String getTitle()
  {
    return (String)a(iq.Kr);
  }
  
  public String getWebContentLink()
  {
    return (String)a(iq.Kt);
  }
  
  public String getWebViewLink()
  {
    return (String)a(iq.Ku);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)a(iq.Ke);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isFolder()
  {
    return "application/vnd.google-apps.folder".equals(getMimeType());
  }
  
  public boolean isInAppFolder()
  {
    Boolean localBoolean = (Boolean)a(iq.Kc);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinnable()
  {
    Boolean localBoolean = (Boolean)a(iu.KD);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinned()
  {
    Boolean localBoolean = (Boolean)a(iq.Kf);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isRestricted()
  {
    Boolean localBoolean = (Boolean)a(iq.Kg);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isShared()
  {
    Boolean localBoolean = (Boolean)a(iq.Kh);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)a(iq.Kp);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)a(iq.Ks);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isViewed()
  {
    Boolean localBoolean = (Boolean)a(iq.Kj);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */