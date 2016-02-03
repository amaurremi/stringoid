package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kh;
import java.util.Date;

public abstract class Metadata
  implements Freezable<Metadata>
{
  public static final int CONTENT_AVAILABLE_LOCALLY = 1;
  public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;
  
  protected abstract <T> T a(MetadataField<T> paramMetadataField);
  
  public String getAlternateLink()
  {
    return (String)a(kd.PF);
  }
  
  public int getContentAvailability()
  {
    Integer localInteger = (Integer)a(kh.Qr);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public Date getCreatedDate()
  {
    return (Date)a(kf.Ql);
  }
  
  public String getDescription()
  {
    return (String)a(kd.PH);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)a(kd.PE);
  }
  
  public String getEmbedLink()
  {
    return (String)a(kd.PI);
  }
  
  public String getFileExtension()
  {
    return (String)a(kd.PJ);
  }
  
  public long getFileSize()
  {
    return ((Long)a(kd.PK)).longValue();
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)a(kf.Qm);
  }
  
  public String getMimeType()
  {
    return (String)a(kd.PV);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)a(kf.Qo);
  }
  
  public Date getModifiedDate()
  {
    return (Date)a(kf.Qn);
  }
  
  public String getOriginalFilename()
  {
    return (String)a(kd.PW);
  }
  
  public long getQuotaBytesUsed()
  {
    return ((Long)a(kd.Qb)).longValue();
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)a(kf.Qp);
  }
  
  public String getTitle()
  {
    return (String)a(kd.Qe);
  }
  
  public String getWebContentLink()
  {
    return (String)a(kd.Qg);
  }
  
  public String getWebViewLink()
  {
    return (String)a(kd.Qh);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)a(kd.PP);
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
    Boolean localBoolean = (Boolean)a(kd.PN);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinnable()
  {
    Boolean localBoolean = (Boolean)a(kh.Qs);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinned()
  {
    Boolean localBoolean = (Boolean)a(kd.PQ);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isRestricted()
  {
    Boolean localBoolean = (Boolean)a(kd.PR);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isShared()
  {
    Boolean localBoolean = (Boolean)a(kd.PS);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)a(kd.Qc);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)a(kd.Qf);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isViewed()
  {
    Boolean localBoolean = (Boolean)a(kd.PU);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */