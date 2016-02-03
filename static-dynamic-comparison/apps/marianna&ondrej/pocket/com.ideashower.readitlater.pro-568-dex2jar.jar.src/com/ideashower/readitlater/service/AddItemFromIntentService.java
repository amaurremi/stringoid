package com.ideashower.readitlater.service;

import android.content.Intent;
import android.widget.Toast;
import com.ideashower.readitlater.a.g;

public class AddItemFromIntentService
  extends a
{
  public AddItemFromIntentService()
  {
    super("AddItemService");
  }
  
  protected void b(Intent paramIntent)
  {
    int j = 2131493732;
    if (paramIntent == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = paramIntent.getStringExtra("newItemUrl");
      str2 = paramIntent.getStringExtra("tweetId");
    } while (str1 == null);
    paramIntent = new com.ideashower.readitlater.db.operation.a(str1, str2, paramIntent.getBooleanExtra("isGivenUrlTwitterUrl", false));
    paramIntent.f();
    int k = paramIntent.d_();
    final int i = j;
    if (paramIntent.d() == 4)
    {
      i = j;
      switch (k)
      {
      }
    }
    for (i = 0; i != 0; i = 2131493730)
    {
      g.a(new Runnable()
      {
        public void run()
        {
          Toast localToast = WakefulAppService.a(AddItemFromIntentService.this, i, 1);
          localToast.show();
          AddOverlayService.a = localToast;
        }
      });
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/AddItemFromIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */