package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;
import java.util.Date;

public final class MetadataChangeSet
{
  public static final MetadataChangeSet Nl = new MetadataChangeSet(MetadataBundle.io());
  private final MetadataBundle Nm;
  
  public MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.Nm = MetadataBundle.a(paramMetadataBundle);
  }
  
  public String getDescription()
  {
    return (String)this.Nm.a(kd.PH);
  }
  
  public String getIndexableText()
  {
    return (String)this.Nm.a(kd.PM);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.Nm.a(kf.Qm);
  }
  
  public String getMimeType()
  {
    return (String)this.Nm.a(kd.PV);
  }
  
  public String getTitle()
  {
    return (String)this.Nm.a(kd.Qe);
  }
  
  public MetadataBundle hS()
  {
    return this.Nm;
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.Nm.a(kd.PQ);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.Nm.a(kd.Qc);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.Nm.a(kd.PU);
  }
  
  public static class Builder
  {
    private final MetadataBundle Nm = MetadataBundle.io();
    private AppVisibleCustomProperties.a Nn;
    
    public MetadataChangeSet build()
    {
      if (this.Nn != null) {
        this.Nm.b(kd.PG, this.Nn.im());
      }
      return new MetadataChangeSet(this.Nm);
    }
    
    public Builder setDescription(String paramString)
    {
      this.Nm.b(kd.PH, paramString);
      return this;
    }
    
    public Builder setIndexableText(String paramString)
    {
      this.Nm.b(kd.PM, paramString);
      return this;
    }
    
    public Builder setLastViewedByMeDate(Date paramDate)
    {
      this.Nm.b(kf.Qm, paramDate);
      return this;
    }
    
    public Builder setMimeType(String paramString)
    {
      this.Nm.b(kd.PV, paramString);
      return this;
    }
    
    public Builder setPinned(boolean paramBoolean)
    {
      this.Nm.b(kd.PQ, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.Nm.b(kd.Qc, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.Nm.b(kd.Qe, paramString);
      return this;
    }
    
    public Builder setViewed(boolean paramBoolean)
    {
      this.Nm.b(kd.PU, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */