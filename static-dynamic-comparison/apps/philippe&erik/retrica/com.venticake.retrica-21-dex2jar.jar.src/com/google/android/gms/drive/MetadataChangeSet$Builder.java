package com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public class MetadataChangeSet$Builder
{
  private final MetadataBundle HW = MetadataBundle.gF();
  private AppVisibleCustomProperties.a HX;
  private final Context mContext;
  
  public MetadataChangeSet$Builder()
  {
    this(null);
  }
  
  public MetadataChangeSet$Builder(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public MetadataChangeSet build()
  {
    if (this.HX != null) {
      this.HW.b(iq.JV, this.HX.gD());
    }
    return new MetadataChangeSet(this.HW);
  }
  
  public Builder setDescription(String paramString)
  {
    this.HW.b(iq.JW, paramString);
    return this;
  }
  
  public Builder setIndexableText(String paramString)
  {
    this.HW.b(iq.Kb, paramString);
    return this;
  }
  
  public Builder setLastViewedByMeDate(Date paramDate)
  {
    this.HW.b(is.Kx, paramDate);
    return this;
  }
  
  public Builder setMimeType(String paramString)
  {
    this.HW.b(iq.Kk, paramString);
    return this;
  }
  
  public Builder setPinned(boolean paramBoolean)
  {
    this.HW.b(iq.Kf, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public Builder setStarred(boolean paramBoolean)
  {
    this.HW.b(iq.Kp, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public Builder setTitle(String paramString)
  {
    this.HW.b(iq.Kr, paramString);
    return this;
  }
  
  public Builder setViewed(boolean paramBoolean)
  {
    this.HW.b(iq.Kj, Boolean.valueOf(paramBoolean));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/MetadataChangeSet$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */