package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ideashower.readitlater.db.operation.action.UiContext;

public class EditTagsActivity
  extends a
{
  public static String z = "edit_tag_frag";
  
  public static Intent a(Context paramContext, UiContext paramUiContext, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, EditTagsActivity.class);
    paramContext.putExtra("uiContext", paramUiContext);
    paramContext.putExtra("isStandAlone", paramBoolean);
    return paramContext;
  }
  
  public static void a(Context paramContext, UiContext paramUiContext)
  {
    paramContext.startActivity(a(paramContext, paramUiContext, false));
  }
  
  public String f()
  {
    return null;
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    bj.a(this, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/EditTagsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */