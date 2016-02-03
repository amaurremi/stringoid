package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new h();
  final Bundle JS;
  final int xM;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.xM = paramInt;
    this.JS = ((Bundle)hm.f(paramBundle));
    this.JS.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = this.JS.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (e.aN(str) == null)
      {
        paramBundle.add(str);
        Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      this.JS.remove((String)localObject);
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle a(MetadataField<T> paramMetadataField, T paramT)
  {
    MetadataBundle localMetadataBundle = gF();
    localMetadataBundle.b(paramMetadataField, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle a(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.JS));
  }
  
  public static MetadataBundle gF()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public <T> T a(MetadataField<T> paramMetadataField)
  {
    return (T)paramMetadataField.e(this.JS);
  }
  
  public <T> void b(MetadataField<T> paramMetadataField, T paramT)
  {
    if (e.aN(paramMetadataField.getName()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramMetadataField.getName());
    }
    paramMetadataField.a(paramT, this.JS);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MetadataBundle)) {
      return false;
    }
    paramObject = (MetadataBundle)paramObject;
    Object localObject = this.JS.keySet();
    if (!((Set)localObject).equals(((MetadataBundle)paramObject).JS.keySet())) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!hk.equal(this.JS.get(str), ((MetadataBundle)paramObject).JS.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public Set<MetadataField<?>> gG()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.JS.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(e.aN((String)localIterator.next()));
    }
    return localHashSet;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.JS.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = this.JS.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.JS + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/MetadataBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */