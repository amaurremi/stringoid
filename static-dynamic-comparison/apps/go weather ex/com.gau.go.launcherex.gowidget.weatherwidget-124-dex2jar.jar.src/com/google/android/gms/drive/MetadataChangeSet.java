package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import java.util.Date;

public final class MetadataChangeSet
{
  private final MetadataBundle EP;
  
  private MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.EP = MetadataBundle.a(paramMetadataBundle);
  }
  
  public MetadataBundle fD()
  {
    return this.EP;
  }
  
  public String getDescription()
  {
    return (String)this.EP.a(gs.FT);
  }
  
  public String getIndexableText()
  {
    return (String)this.EP.a(gs.FY);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.EP.a(gt.Gt);
  }
  
  public String getMimeType()
  {
    return (String)this.EP.a(gs.Gh);
  }
  
  public String getTitle()
  {
    return (String)this.EP.a(gs.Go);
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.EP.a(gs.Gc);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.EP.a(gs.Gm);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.EP.a(gs.Gg);
  }
  
  public static class Builder
  {
    private final MetadataBundle EP = MetadataBundle.fT();
    
    public MetadataChangeSet build()
    {
      return new MetadataChangeSet(this.EP, null);
    }
    
    public Builder setDescription(String paramString)
    {
      this.EP.b(gs.FT, paramString);
      return this;
    }
    
    public Builder setIndexableText(String paramString)
    {
      this.EP.b(gs.FY, paramString);
      return this;
    }
    
    public Builder setLastViewedByMeDate(Date paramDate)
    {
      this.EP.b(gt.Gt, paramDate);
      return this;
    }
    
    public Builder setMimeType(String paramString)
    {
      this.EP.b(gs.Gh, paramString);
      return this;
    }
    
    public Builder setPinned(boolean paramBoolean)
    {
      this.EP.b(gs.Gc, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.EP.b(gs.Gm, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.EP.b(gs.Go, paramString);
      return this;
    }
    
    public Builder setViewed(boolean paramBoolean)
    {
      this.EP.b(gs.Gg, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */