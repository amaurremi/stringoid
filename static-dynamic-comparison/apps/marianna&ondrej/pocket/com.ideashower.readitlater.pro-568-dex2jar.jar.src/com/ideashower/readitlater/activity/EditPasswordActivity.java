package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pocket.user.UserMeta;

public class EditPasswordActivity
  extends a
{
  public static void a(Context paramContext, UserMeta paramUserMeta)
  {
    paramContext.startActivity(b(paramContext, paramUserMeta));
  }
  
  public static Intent b(Context paramContext, UserMeta paramUserMeta)
  {
    paramContext = new Intent(paramContext, EditPasswordActivity.class);
    paramContext.putExtra("extraMeta", paramUserMeta);
    return paramContext;
  }
  
  public String f()
  {
    return "edit_password";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(q.a((UserMeta)getIntent().getParcelableExtra("extraMeta")));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/EditPasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */