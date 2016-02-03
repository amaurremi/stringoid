package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.iq;
import java.util.Collection;
import java.util.Iterator;

class f
  extends Metadata
{
  private final DataHolder a;
  private final int b;
  private final int c;
  
  public f(DataHolder paramDataHolder, int paramInt)
  {
    this.a = paramDataHolder;
    this.b = paramInt;
    this.c = paramDataHolder.ae(paramInt);
  }
  
  public Metadata a()
  {
    MetadataBundle localMetadataBundle = MetadataBundle.gF();
    Iterator localIterator = e.gE().iterator();
    while (localIterator.hasNext())
    {
      MetadataField localMetadataField = (MetadataField)localIterator.next();
      if ((!(localMetadataField instanceof b)) && (localMetadataField != iq.Kq)) {
        localMetadataField.a(this.a, localMetadataBundle, this.b, this.c);
      }
    }
    return new l(localMetadataBundle);
  }
  
  protected <T> T a(MetadataField<T> paramMetadataField)
  {
    return (T)paramMetadataField.a(this.a, this.b, this.c);
  }
  
  public boolean isDataValid()
  {
    return !this.a.isClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */