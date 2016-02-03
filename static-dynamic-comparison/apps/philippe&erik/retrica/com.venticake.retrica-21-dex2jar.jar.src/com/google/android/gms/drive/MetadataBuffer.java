package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class MetadataBuffer
  extends DataBuffer<Metadata>
{
  private static final String[] HR;
  private final String HS;
  private f HT;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = e.gE().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((MetadataField)localIterator.next()).gC());
    }
    HR = (String[])localArrayList.toArray(new String[0]);
  }
  
  public MetadataBuffer(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.HS = paramString;
    paramDataHolder.eU().setClassLoader(MetadataBuffer.class.getClassLoader());
  }
  
  public Metadata get(int paramInt)
  {
    f localf2 = this.HT;
    f localf1;
    if (localf2 != null)
    {
      localf1 = localf2;
      if (f.a(localf2) == paramInt) {}
    }
    else
    {
      localf1 = new f(this.DG, paramInt);
      this.HT = localf1;
    }
    return localf1;
  }
  
  public String getNextPageToken()
  {
    return this.HS;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */