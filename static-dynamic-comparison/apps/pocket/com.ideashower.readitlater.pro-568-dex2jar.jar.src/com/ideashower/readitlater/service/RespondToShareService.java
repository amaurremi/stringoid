package com.ideashower.readitlater.service;

import android.app.NotificationManager;
import android.content.Intent;
import com.ideashower.readitlater.a.ai;
import com.ideashower.readitlater.db.operation.j;

public class RespondToShareService
  extends a
{
  public RespondToShareService()
  {
    super("RespondToShareService");
  }
  
  protected void b(Intent paramIntent)
  {
    int i = 0;
    if (paramIntent == null) {}
    label259:
    for (;;)
    {
      return;
      Object localObject = paramIntent.getAction();
      if (localObject != null)
      {
        if ((((String)localObject).equals("actionAcceptShare")) || (((String)localObject).equals("actionIgnoreShare")))
        {
          localObject = paramIntent.getStringExtra("actionName");
          int j = paramIntent.getIntExtra("shareId", 0);
          int k = paramIntent.getIntExtra("uniqueId", 0);
          int m = paramIntent.getIntExtra("noteId", 0);
          if (m != 0) {
            ((NotificationManager)getSystemService("notification")).cancel(m);
          }
          if ((!"share_added".equals(localObject)) && (!"share_ignored".equals(localObject))) {
            throw new RuntimeException("Unexpected action " + (String)localObject);
          }
          if ((("share_added".equals(localObject)) || ("share_ignored".equals(localObject))) && (new c(this, (String)localObject, j, k).d() == 4))
          {
            if ("share_added".equals(localObject)) {
              i = 2131493734;
            }
            if (i != 0)
            {
              com.ideashower.readitlater.i.c.a();
              WakefulAppService.a(i, 1);
            }
          }
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label259;
          }
          localObject = paramIntent.getIntArrayExtra("shareIds");
          paramIntent = paramIntent.getIntArrayExtra("uniqueIds");
          if ((localObject == null) || (paramIntent == null)) {
            break;
          }
          ai.a((int[])localObject, paramIntent);
          return;
          if (((String)localObject).equals("actionOnDismiss")) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/RespondToShareService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */