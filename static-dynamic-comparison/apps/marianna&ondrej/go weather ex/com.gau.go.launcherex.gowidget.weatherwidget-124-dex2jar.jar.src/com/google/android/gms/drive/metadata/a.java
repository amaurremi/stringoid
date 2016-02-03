package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class a<T>
  implements MetadataField<T>
{
  private final String FM;
  private final Set<String> FN;
  private final int FO;
  
  protected a(String paramString, int paramInt)
  {
    this.FM = ((String)fq.b(paramString, "fieldName"));
    this.FN = Collections.singleton(paramString);
    this.FO = paramInt;
  }
  
  protected a(String paramString, Collection<String> paramCollection, int paramInt)
  {
    this.FM = ((String)fq.b(paramString, "fieldName"));
    this.FN = Collections.unmodifiableSet(new HashSet(paramCollection));
    this.FO = paramInt;
  }
  
  public final T a(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.FN.iterator();
    while (localIterator.hasNext()) {
      if (paramDataHolder.hasNull((String)localIterator.next(), paramInt1, paramInt2)) {
        return null;
      }
    }
    return (T)b(paramDataHolder, paramInt1, paramInt2);
  }
  
  protected abstract void a(Bundle paramBundle, T paramT);
  
  public final void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    fq.b(paramDataHolder, "dataHolder");
    fq.b(paramMetadataBundle, "bundle");
    paramMetadataBundle.b(this, a(paramDataHolder, paramInt1, paramInt2));
  }
  
  public final void a(T paramT, Bundle paramBundle)
  {
    fq.b(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    a(paramBundle, paramT);
  }
  
  protected abstract T b(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public final T d(Bundle paramBundle)
  {
    fq.b(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return (T)e(paramBundle);
    }
    return null;
  }
  
  protected abstract T e(Bundle paramBundle);
  
  public final Collection<String> fR()
  {
    return this.FN;
  }
  
  public final String getName()
  {
    return this.FM;
  }
  
  public String toString()
  {
    return this.FM;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/metadata/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */