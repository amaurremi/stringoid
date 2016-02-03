package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hn;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class a<T>
  implements MetadataField<T>
{
  private final String JE;
  private final Set<String> JF;
  private final Set<String> JG;
  private final int JH;
  
  protected a(String paramString, int paramInt)
  {
    this.JE = ((String)hn.b(paramString, "fieldName"));
    this.JF = Collections.singleton(paramString);
    this.JG = Collections.emptySet();
    this.JH = paramInt;
  }
  
  protected a(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    this.JE = ((String)hn.b(paramString, "fieldName"));
    this.JF = Collections.unmodifiableSet(new HashSet(paramCollection1));
    this.JG = Collections.unmodifiableSet(new HashSet(paramCollection2));
    this.JH = paramInt;
  }
  
  public final T a(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.JF.iterator();
    while (localIterator.hasNext()) {
      if (paramDataHolder.h((String)localIterator.next(), paramInt1, paramInt2)) {
        return null;
      }
    }
    return (T)b(paramDataHolder, paramInt1, paramInt2);
  }
  
  protected abstract void a(Bundle paramBundle, T paramT);
  
  public final void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    hn.b(paramDataHolder, "dataHolder");
    hn.b(paramMetadataBundle, "bundle");
    paramMetadataBundle.b(this, a(paramDataHolder, paramInt1, paramInt2));
  }
  
  public final void a(T paramT, Bundle paramBundle)
  {
    hn.b(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    a(paramBundle, paramT);
  }
  
  protected abstract T b(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public final T e(Bundle paramBundle)
  {
    hn.b(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return (T)f(paramBundle);
    }
    return null;
  }
  
  protected abstract T f(Bundle paramBundle);
  
  public final String getName()
  {
    return this.JE;
  }
  
  public final Collection<String> gx()
  {
    return this.JF;
  }
  
  public String toString()
  {
    return this.JE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/metadata/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */