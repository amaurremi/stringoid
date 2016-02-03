package com.google.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class SharedPreferencesUtil
{
  @SuppressLint({"CommitPrefEdits"})
  static void saveAsync(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    saveEditorAsync(paramContext);
  }
  
  static void saveEditorAsync(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramEditor.apply();
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        this.val$editor.commit();
      }
    }).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/SharedPreferencesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */