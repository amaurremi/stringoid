package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

public abstract class f<T extends Parcelable>
  extends MetadataField<T>
{
  public f(String paramString, Collection<String> paramCollection)
  {
    super(paramString, paramCollection);
  }
  
  protected void a(Bundle paramBundle, T paramT)
  {
    paramBundle.putParcelable(getName(), paramT);
  }
  
  protected T j(Bundle paramBundle)
  {
    return paramBundle.getParcelable(getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */