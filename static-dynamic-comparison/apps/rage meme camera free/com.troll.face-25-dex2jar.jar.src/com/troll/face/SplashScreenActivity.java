package com.troll.face;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.appfireworks.android.track.AppTracker;
import com.jtpgodorncrqoeurl.AdController;

public class SplashScreenActivity
  extends Activity
{
  private AdController ad;
  int flag = 0;
  Intent intent;
  boolean m_bPaused = false;
  boolean m_bSplashActive = true;
  long m_dwSplashTime = 3000L;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903050);
    this.intent = new Intent(getApplicationContext(), MenuActivity.class);
    this.ad = new AdController(this, "620641523");
    this.ad.loadStartAd("734590306", "515446838");
    AppTracker.startSession(this, "TjqKub1GuPtZF4iKtLuftFs4jNRfv7Fi");
    paramBundle = new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   4: iconst_1
        //   5: putfield 26	com/troll/face/SplashScreenActivity:flag	I
        //   8: lconst_0
        //   9: lstore_1
        //   10: aload_0
        //   11: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   14: getfield 30	com/troll/face/SplashScreenActivity:m_bSplashActive	Z
        //   17: ifeq +15 -> 32
        //   20: lload_1
        //   21: aload_0
        //   22: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   25: getfield 34	com/troll/face/SplashScreenActivity:m_dwSplashTime	J
        //   28: lcmp
        //   29: iflt +25 -> 54
        //   32: aload_0
        //   33: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   36: aload_0
        //   37: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   40: getfield 38	com/troll/face/SplashScreenActivity:intent	Landroid/content/Intent;
        //   43: invokevirtual 42	com/troll/face/SplashScreenActivity:startActivity	(Landroid/content/Intent;)V
        //   46: aload_0
        //   47: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   50: invokevirtual 45	com/troll/face/SplashScreenActivity:finish	()V
        //   53: return
        //   54: ldc2_w 46
        //   57: invokestatic 51	com/troll/face/SplashScreenActivity$1:sleep	(J)V
        //   60: aload_0
        //   61: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   64: getfield 54	com/troll/face/SplashScreenActivity:m_bPaused	Z
        //   67: istore_3
        //   68: iload_3
        //   69: ifne -59 -> 10
        //   72: lload_1
        //   73: ldc2_w 46
        //   76: ladd
        //   77: lstore_1
        //   78: goto -68 -> 10
        //   81: astore 4
        //   83: ldc 56
        //   85: aload 4
        //   87: invokevirtual 60	java/lang/Exception:toString	()Ljava/lang/String;
        //   90: invokestatic 66	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   93: pop
        //   94: aload_0
        //   95: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   98: invokevirtual 45	com/troll/face/SplashScreenActivity:finish	()V
        //   101: return
        //   102: astore 4
        //   104: aload_0
        //   105: getfield 15	com/troll/face/SplashScreenActivity$1:this$0	Lcom/troll/face/SplashScreenActivity;
        //   108: invokevirtual 45	com/troll/face/SplashScreenActivity:finish	()V
        //   111: aload 4
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	1
        //   9	69	1	l	long
        //   67	2	3	bool	boolean
        //   81	5	4	localException	Exception
        //   102	10	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	32	81	java/lang/Exception
        //   32	46	81	java/lang/Exception
        //   54	68	81	java/lang/Exception
        //   10	32	102	finally
        //   32	46	102	finally
        //   54	68	102	finally
        //   83	94	102	finally
      }
    };
    if (this.flag == 0) {
      paramBundle.start();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.m_bPaused = true;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.m_bPaused = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/SplashScreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */