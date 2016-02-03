package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class an
  implements am
{
  public PendingIntent a(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramArrayOfIntent = new Intent(paramArrayOfIntent[(paramArrayOfIntent.length - 1)]);
    paramArrayOfIntent.addFlags(268435456);
    return PendingIntent.getActivity(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */