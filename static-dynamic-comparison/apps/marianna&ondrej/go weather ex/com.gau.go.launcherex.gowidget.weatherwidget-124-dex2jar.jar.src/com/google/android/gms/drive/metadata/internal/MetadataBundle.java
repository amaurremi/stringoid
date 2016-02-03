package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new f();
  final Bundle FQ;
  final int xH;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.xH = paramInt;
    this.FQ = ((Bundle)fq.f(paramBundle));
    this.FQ.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = this.FQ.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (c.ax(str) == null)
      {
        paramBundle.add(str);
        Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      this.FQ.remove((String)localObject);
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle a(MetadataField<T> paramMetadataField, T paramT)
  {
    MetadataBundle localMetadataBundle = fT();
    localMetadataBundle.b(paramMetadataField, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle a(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.FQ));
  }
  
  public static MetadataBundle fT()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public <T> T a(MetadataField<T> paramMetadataField)
  {
    return (T)paramMetadataField.d(this.FQ);
  }
  
  public <T> void b(MetadataField<T> paramMetadataField, T paramT)
  {
    if (c.ax(paramMetadataField.getName()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramMetadataField.getName());
    }
    paramMetadataField.a(paramT, this.FQ);
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
    Object localObject = this.FQ.keySet();
    if (!localObject.equals(((MetadataBundle)paramObject).FQ.keySet())) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!fo.equal(this.FQ.get(str), ((MetadataBundle)paramObject).FQ.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public Set<MetadataField<?>> fU()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.FQ.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(c.ax((String)localIterator.next()));
    }
    return localHashSet;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.FQ.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = this.FQ.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.FQ + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/MetadataBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */