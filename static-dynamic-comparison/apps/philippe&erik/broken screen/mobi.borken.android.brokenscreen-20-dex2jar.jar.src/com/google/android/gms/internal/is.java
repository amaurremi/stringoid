package com.google.android.gms.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collections;

public class is
  extends j<AppVisibleCustomProperties>
{
  public is(int paramInt)
  {
    super("customFileProperties", Collections.emptyList(), Arrays.asList(new String[] { "customPropertiesExtra" }), paramInt);
  }
  
  protected AppVisibleCustomProperties j(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return (AppVisibleCustomProperties)paramDataHolder.eP().getSparseParcelableArray("customPropertiesExtra").get(paramInt1, AppVisibleCustomProperties.JK);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */