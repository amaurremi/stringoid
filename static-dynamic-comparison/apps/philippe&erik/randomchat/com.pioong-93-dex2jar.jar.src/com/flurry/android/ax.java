package com.flurry.android;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseIntArray;

final class ax
{
  private static final String bA = ax.class.getSimpleName();
  private static final SparseArray<SparseIntArray> cp;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    int i = I();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(-1, i);
    localSparseIntArray.put(2, i);
    localSparseIntArray.put(3, i);
    localSparseIntArray.put(4, i);
    localSparseIntArray.put(1, 1);
    localSparseIntArray.put(5, 5);
    localSparseIntArray.put(7, 7);
    localSparseIntArray.put(9, 9);
    localSparseIntArray.put(10, 7);
    localSparseArray.put(1, localSparseIntArray);
    if (l.SDK_INT >= 9) {}
    for (i = 6;; i = 0)
    {
      localSparseIntArray = new SparseIntArray();
      localSparseIntArray.put(-1, i);
      localSparseIntArray.put(2, i);
      localSparseIntArray.put(3, i);
      localSparseIntArray.put(4, i);
      localSparseIntArray.put(0, 0);
      localSparseIntArray.put(5, 5);
      localSparseIntArray.put(6, 6);
      localSparseIntArray.put(8, 8);
      localSparseIntArray.put(10, 6);
      localSparseArray.put(2, localSparseIntArray);
      cp = localSparseArray;
      return;
    }
  }
  
  public static int I()
  {
    int i = 1;
    if (l.SDK_INT >= 9) {
      i = 7;
    }
    return i;
  }
  
  private static ActivityInfo a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    try
    {
      ActivityInfo localActivityInfo = paramActivity.getPackageManager().getActivityInfo(paramActivity.getComponentName(), 0);
      return localActivityInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      new StringBuilder().append("cannot find info for activity: ").append(paramActivity.getComponentName()).toString();
    }
    return null;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(paramInt);
    }
  }
  
  public static boolean a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return false;
    }
    Object localObject = a(paramActivity);
    int i;
    label29:
    int j;
    if (localObject == null)
    {
      i = 0;
      if ((i & 0x80) != 0) {
        break label133;
      }
      i = 0;
      j = paramInt;
      if (i != 0) {
        break label193;
      }
      if (paramActivity != null) {
        break label151;
      }
      i = -1;
    }
    for (;;)
    {
      if (-1 == i)
      {
        new StringBuilder().append("cannot set requested orientation without restarting activity, requestedOrientation = ").append(paramInt).toString();
        db.d(bA, "cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: " + paramActivity.getComponentName().getClassName());
        return false;
        j = ((ActivityInfo)localObject).configChanges;
        i = j;
        if (((ActivityInfo)localObject).applicationInfo.targetSdkVersion >= 13) {
          break;
        }
        i = j | 0xC00;
        break;
        label133:
        if ((i & 0x400) == 0)
        {
          i = 0;
          break label29;
        }
        i = 1;
        break label29;
        label151:
        i = paramActivity.getResources().getConfiguration().orientation;
        localObject = (SparseIntArray)cp.get(i);
        if (localObject == null) {
          break label201;
        }
        i = ((SparseIntArray)localObject).get(paramInt, -1);
        continue;
      }
      j = i;
      label193:
      paramActivity.setRequestedOrientation(j);
      return true;
      label201:
      i = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */