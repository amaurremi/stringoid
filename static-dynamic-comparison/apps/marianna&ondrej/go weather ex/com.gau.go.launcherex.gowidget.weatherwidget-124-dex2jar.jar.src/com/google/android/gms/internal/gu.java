package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.h;
import java.util.Arrays;

public class gu
  extends h<DriveId>
{
  public static final gu Gx = new gu();
  
  private gu()
  {
    super("driveId", Arrays.asList(new String[] { "sqlId", "resourceId" }), 4100000);
  }
  
  protected DriveId j(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    long l = paramDataHolder.getMetadata().getLong("dbInstanceId");
    String str2 = paramDataHolder.getString("resourceId", paramInt1, paramInt2);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.startsWith("generated-android-")) {
        str1 = null;
      }
    }
    return new DriveId(str1, Long.valueOf(paramDataHolder.getLong("sqlId", paramInt1, paramInt2)).longValue(), l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */