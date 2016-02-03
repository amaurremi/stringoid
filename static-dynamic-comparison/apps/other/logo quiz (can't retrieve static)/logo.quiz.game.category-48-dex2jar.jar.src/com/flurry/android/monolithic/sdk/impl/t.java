package com.flurry.android.monolithic.sdk.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.HashMap;
import java.util.Map;

class t
  implements DialogInterface.OnClickListener
{
  t(o paramo, bh parambh, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sourceEvent", this.a.a);
    this.c.a("userCanceled", localHashMap, this.c.d, this.c.c, this.c.e, this.b + 1);
    paramDialogInterface.dismiss();
    if ((o.u(this.c) != null) && (this.c.getCurrentBinding() == 3)) {
      o.u(this.c).start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */