package com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.it;
import java.util.Date;

public final class MetadataChangeSet
{
  public static final MetadataChangeSet HS = new MetadataChangeSet(MetadataBundle.gA());
  private final MetadataBundle HT;
  
  public MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.HT = MetadataBundle.a(paramMetadataBundle);
  }
  
  public String getDescription()
  {
    return (String)this.HT.a(ir.JT);
  }
  
  public String getIndexableText()
  {
    return (String)this.HT.a(ir.JY);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.HT.a(it.Ku);
  }
  
  public String getMimeType()
  {
    return (String)this.HT.a(ir.Kh);
  }
  
  public String getTitle()
  {
    return (String)this.HT.a(ir.Ko);
  }
  
  public MetadataBundle gh()
  {
    return this.HT;
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.HT.a(ir.Kc);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.HT.a(ir.Km);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.HT.a(ir.Kg);
  }
  
  public static class Builder
  {
    private final MetadataBundle HT = MetadataBundle.gA();
    private AppVisibleCustomProperties.a HU;
    private final Context mContext;
    
    public Builder()
    {
      this(null);
    }
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public MetadataChangeSet build()
    {
      if (this.HU != null) {
        this.HT.b(ir.JS, this.HU.gy());
      }
      return new MetadataChangeSet(this.HT);
    }
    
    public Builder setDescription(String paramString)
    {
      this.HT.b(ir.JT, paramString);
      return this;
    }
    
    public Builder setIndexableText(String paramString)
    {
      this.HT.b(ir.JY, paramString);
      return this;
    }
    
    public Builder setLastViewedByMeDate(Date paramDate)
    {
      this.HT.b(it.Ku, paramDate);
      return this;
    }
    
    public Builder setMimeType(String paramString)
    {
      this.HT.b(ir.Kh, paramString);
      return this;
    }
    
    public Builder setPinned(boolean paramBoolean)
    {
      this.HT.b(ir.Kc, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.HT.b(ir.Km, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.HT.b(ir.Ko, paramString);
      return this;
    }
    
    public Builder setViewed(boolean paramBoolean)
    {
      this.HT.b(ir.Kg, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */