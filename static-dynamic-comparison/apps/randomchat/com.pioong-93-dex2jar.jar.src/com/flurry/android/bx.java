package com.flurry.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.HashMap;
import java.util.Map;

final class bx
  implements DialogInterface.OnClickListener
{
  bx(bn parambn, cw paramcw, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sourceEvent", this.dU.eW);
    this.dW.a("userConfirmed", localHashMap, this.dW.M, this.dW.L, this.dW.N, this.dV + 1);
    paramDialogInterface.dismiss();
    if ((bn.s(this.dW) != null) && (this.dW.ad() == 3)) {
      bn.s(this.dW).start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */