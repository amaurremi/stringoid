package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class a<T>
  implements MetadataField<T>
{
  private final String Pt;
  private final Set<String> Pu;
  private final Set<String> Pv;
  private final int Pw;
  
  protected a(String paramString, int paramInt)
  {
    this.Pt = ((String)n.b(paramString, "fieldName"));
    this.Pu = Collections.singleton(paramString);
    this.Pv = Collections.emptySet();
    this.Pw = paramInt;
  }
  
  protected a(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    this.Pt = ((String)n.b(paramString, "fieldName"));
    this.Pu = Collections.unmodifiableSet(new HashSet(paramCollection1));
    this.Pv = Collections.unmodifiableSet(new HashSet(paramCollection2));
    this.Pw = paramInt;
  }
  
  public final T a(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    if (b(paramDataHolder, paramInt1, paramInt2)) {
      return (T)c(paramDataHolder, paramInt1, paramInt2);
    }
    return null;
  }
  
  protected abstract void a(Bundle paramBundle, T paramT);
  
  public final void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    n.b(paramDataHolder, "dataHolder");
    n.b(paramMetadataBundle, "bundle");
    paramMetadataBundle.b(this, a(paramDataHolder, paramInt1, paramInt2));
  }
  
  public final void a(T paramT, Bundle paramBundle)
  {
    n.b(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    a(paramBundle, paramT);
  }
  
  protected boolean b(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.Pu.iterator();
    while (localIterator.hasNext()) {
      if (paramDataHolder.h((String)localIterator.next(), paramInt1, paramInt2)) {
        return false;
      }
    }
    return true;
  }
  
  protected abstract T c(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public final T f(Bundle paramBundle)
  {
    n.b(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return (T)g(paramBundle);
    }
    return null;
  }
  
  protected abstract T g(Bundle paramBundle);
  
  public final String getName()
  {
    return this.Pt;
  }
  
  public String toString()
  {
    return this.Pt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/metadata/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */