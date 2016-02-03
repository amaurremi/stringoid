package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public final class MetadataChangeSet
{
  public static final MetadataChangeSet HV = new MetadataChangeSet(MetadataBundle.gF());
  private final MetadataBundle HW;
  
  public MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.HW = MetadataBundle.a(paramMetadataBundle);
  }
  
  public String getDescription()
  {
    return (String)this.HW.a(iq.JW);
  }
  
  public String getIndexableText()
  {
    return (String)this.HW.a(iq.Kb);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.HW.a(is.Kx);
  }
  
  public String getMimeType()
  {
    return (String)this.HW.a(iq.Kk);
  }
  
  public String getTitle()
  {
    return (String)this.HW.a(iq.Kr);
  }
  
  public MetadataBundle gm()
  {
    return this.HW;
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.HW.a(iq.Kf);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.HW.a(iq.Kp);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.HW.a(iq.Kj);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */