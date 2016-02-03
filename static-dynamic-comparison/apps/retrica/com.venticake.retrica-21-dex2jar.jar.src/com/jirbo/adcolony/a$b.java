package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

class a$b
  extends Handler
{
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {}
    for (;;)
    {
      sendMessage(obtainMessage(paramInt, paramString));
      return;
      paramString = null;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    String str = (String)paramMessage.obj;
    int j = paramMessage.what;
    if (str != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessage = str;
      if (!bool) {
        paramMessage = "";
      }
      paramMessage = new AdColonyV4VCReward(bool, paramMessage, j);
      while (i < a.aa.size())
      {
        ((AdColonyV4VCListener)a.aa.get(i)).onAdColonyV4VCReward(paramMessage);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/a$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */