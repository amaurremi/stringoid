package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class PhotoEditorActivity
  extends a
{
  public static Intent a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = new Intent(paramContext, PhotoEditorActivity.class);
    paramContext.putExtra("requestType", paramInt);
    paramContext.putExtra("tempPath", paramString);
    return paramContext;
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    paramContext.startActivity(a(paramContext, paramInt, paramString));
  }
  
  public String f()
  {
    return "edit_avatar_photo";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(ag.a(getIntent().getIntExtra("requestType", 0), getIntent().getStringExtra("tempPath")));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/PhotoEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */