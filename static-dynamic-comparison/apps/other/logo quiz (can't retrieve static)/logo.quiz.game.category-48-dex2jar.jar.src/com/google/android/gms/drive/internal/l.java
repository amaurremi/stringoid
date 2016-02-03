package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class l
  extends Metadata
{
  private final MetadataBundle Oj;
  
  public l(MetadataBundle paramMetadataBundle)
  {
    this.Oj = paramMetadataBundle;
  }
  
  protected <T> T a(MetadataField<T> paramMetadataField)
  {
    return (T)this.Oj.a(paramMetadataField);
  }
  
  public Metadata hR()
  {
    return new l(MetadataBundle.a(this.Oj));
  }
  
  public boolean isDataValid()
  {
    return this.Oj != null;
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.Oj + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */