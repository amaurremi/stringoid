package com.google.android.gms.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collections;

public class ke
  extends j<AppVisibleCustomProperties>
{
  public ke(int paramInt)
  {
    super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[] { "customPropertiesExtra" }), paramInt);
  }
  
  protected AppVisibleCustomProperties l(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return (AppVisibleCustomProperties)paramDataHolder.gz().getSparseParcelableArray("customPropertiesExtra").get(paramInt1, AppVisibleCustomProperties.Py);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */