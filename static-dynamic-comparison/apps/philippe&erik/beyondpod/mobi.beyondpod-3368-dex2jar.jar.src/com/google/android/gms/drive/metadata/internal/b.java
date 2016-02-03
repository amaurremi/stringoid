package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import java.util.Date;

public class b
  extends OrderedMetadataField<Date>
{
  public b(String paramString)
  {
    super(paramString);
  }
  
  protected void a(Bundle paramBundle, Date paramDate)
  {
    paramBundle.putLong(getName(), paramDate.getTime());
  }
  
  protected Date f(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return new Date(paramDataHolder.getLong(getName(), paramInt1, paramInt2));
  }
  
  protected Date h(Bundle paramBundle)
  {
    return new Date(paramBundle.getLong(getName()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */