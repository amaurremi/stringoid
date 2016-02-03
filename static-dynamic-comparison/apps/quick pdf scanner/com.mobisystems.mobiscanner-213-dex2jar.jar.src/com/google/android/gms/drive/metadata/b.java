package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.dc;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class b<T>
{
  private final String tY;
  private final Set<String> tZ;
  private final int ua;
  
  protected b(String paramString, int paramInt)
  {
    this.tY = ((String)dc.e(paramString, "fieldName"));
    this.tZ = Collections.singleton(paramString);
    this.ua = paramInt;
  }
  
  protected b(String paramString, Collection<String> paramCollection, int paramInt)
  {
    this.tY = ((String)dc.e(paramString, "fieldName"));
    this.tZ = Collections.unmodifiableSet(new HashSet(paramCollection));
    this.ua = paramInt;
  }
  
  protected abstract void a(Bundle paramBundle, T paramT);
  
  public final void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    dc.e(paramDataHolder, "dataHolder");
    dc.e(paramMetadataBundle, "bundle");
    paramMetadataBundle.b(this, c(paramDataHolder, paramInt1, paramInt2));
  }
  
  public final void a(T paramT, Bundle paramBundle)
  {
    dc.e(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    a(paramBundle, paramT);
  }
  
  public final T b(Bundle paramBundle)
  {
    dc.e(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return (T)c(paramBundle);
    }
    return null;
  }
  
  protected abstract T b(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  protected abstract T c(Bundle paramBundle);
  
  public final T c(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.tZ.iterator();
    while (localIterator.hasNext()) {
      if (paramDataHolder.g((String)localIterator.next(), paramInt1, paramInt2)) {
        return null;
      }
    }
    return (T)b(paramDataHolder, paramInt1, paramInt2);
  }
  
  public final String getName()
  {
    return this.tY;
  }
  
  public final Collection<String> nr()
  {
    return this.tZ;
  }
  
  public String toString()
  {
    return this.tY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/metadata/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */