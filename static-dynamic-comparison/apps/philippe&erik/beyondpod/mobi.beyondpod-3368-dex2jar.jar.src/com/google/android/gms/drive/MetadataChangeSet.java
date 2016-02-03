package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fh;

public final class MetadataChangeSet
{
  private final MetadataBundle qV;
  
  private MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.qV = MetadataBundle.a(paramMetadataBundle);
  }
  
  public MetadataBundle cM()
  {
    return this.qV;
  }
  
  public String getMimeType()
  {
    return (String)this.qV.a(fh.MIME_TYPE);
  }
  
  public String getTitle()
  {
    return (String)this.qV.a(fh.TITLE);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.qV.a(fh.STARRED);
  }
  
  public static class Builder
  {
    private final MetadataBundle qV = MetadataBundle.cX();
    
    public MetadataChangeSet build()
    {
      return new MetadataChangeSet(this.qV, null);
    }
    
    public Builder setMimeType(String paramString)
    {
      this.qV.b(fh.MIME_TYPE, paramString);
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.qV.b(fh.STARRED, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.qV.b(fh.TITLE, paramString);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */