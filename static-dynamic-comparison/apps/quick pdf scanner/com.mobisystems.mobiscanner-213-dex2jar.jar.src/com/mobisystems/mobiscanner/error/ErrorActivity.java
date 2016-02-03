package com.mobisystems.mobiscanner.error;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ErrorActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    b.a(this, (Throwable)paramBundle.getSerializableExtra(Throwable.class.getName()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/error/ErrorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */