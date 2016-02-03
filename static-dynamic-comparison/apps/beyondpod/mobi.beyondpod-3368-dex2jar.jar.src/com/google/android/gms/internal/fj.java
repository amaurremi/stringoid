package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.f;
import java.util.Arrays;

public class fj
  extends f<DriveId>
{
  public static final fj rN = new fj();
  
  private fj()
  {
    super("driveId", Arrays.asList(new String[] { "sqlId", "resourceId" }));
  }
  
  protected DriveId g(DataHolder paramDataHolder, int paramInt1, int paramInt2)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */