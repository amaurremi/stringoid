package android.support.v8.renderscript;

import android.content.res.Resources;

public class ScriptC
  extends Script
{
  private static final String TAG = "ScriptC";
  
  protected ScriptC(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  protected ScriptC(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    super(0, paramRenderScript);
    if (RenderScript.isNative)
    {
      this.mT = new ScriptCThunker((RenderScriptThunker)paramRenderScript, paramResources, paramInt);
      return;
    }
    paramInt = internalCreate(paramRenderScript, paramResources, paramInt);
    if (paramInt == 0) {
      throw new RSRuntimeException("Loading of ScriptC script failed.");
    }
    setID(paramInt);
  }
  
  /* Error */
  private static int internalCreate(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: iload_2
    //   5: invokevirtual 54	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore 8
    //   10: sipush 1024
    //   13: newarray <illegal type>
    //   15: astore 6
    //   17: iconst_0
    //   18: istore_3
    //   19: aload 6
    //   21: arraylength
    //   22: iload_3
    //   23: isub
    //   24: istore 5
    //   26: iload 5
    //   28: istore 4
    //   30: aload 6
    //   32: astore 7
    //   34: iload 5
    //   36: ifne +31 -> 67
    //   39: aload 6
    //   41: arraylength
    //   42: iconst_2
    //   43: imul
    //   44: newarray <illegal type>
    //   46: astore 7
    //   48: aload 6
    //   50: iconst_0
    //   51: aload 7
    //   53: iconst_0
    //   54: aload 6
    //   56: arraylength
    //   57: invokestatic 60	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   60: aload 7
    //   62: arraylength
    //   63: iload_3
    //   64: isub
    //   65: istore 4
    //   67: aload 8
    //   69: aload 7
    //   71: iload_3
    //   72: iload 4
    //   74: invokevirtual 66	java/io/InputStream:read	([BII)I
    //   77: istore 4
    //   79: iload 4
    //   81: ifgt +36 -> 117
    //   84: aload 8
    //   86: invokevirtual 70	java/io/InputStream:close	()V
    //   89: aload_0
    //   90: aload_1
    //   91: iload_2
    //   92: invokevirtual 74	android/content/res/Resources:getResourceEntryName	(I)Ljava/lang/String;
    //   95: aload_0
    //   96: invokevirtual 78	android/support/v8/renderscript/RenderScript:getApplicationContext	()Landroid/content/Context;
    //   99: invokevirtual 84	android/content/Context:getCacheDir	()Ljava/io/File;
    //   102: invokevirtual 90	java/io/File:toString	()Ljava/lang/String;
    //   105: aload 7
    //   107: iload_3
    //   108: invokevirtual 94	android/support/v8/renderscript/RenderScript:nScriptCCreate	(Ljava/lang/String;Ljava/lang/String;[BI)I
    //   111: istore_2
    //   112: ldc 2
    //   114: monitorexit
    //   115: iload_2
    //   116: ireturn
    //   117: iload_3
    //   118: iload 4
    //   120: iadd
    //   121: istore_3
    //   122: aload 7
    //   124: astore 6
    //   126: goto -107 -> 19
    //   129: astore_0
    //   130: aload 8
    //   132: invokevirtual 70	java/io/InputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: new 96	android/content/res/Resources$NotFoundException
    //   141: dup
    //   142: invokespecial 98	android/content/res/Resources$NotFoundException:<init>	()V
    //   145: athrow
    //   146: astore_0
    //   147: ldc 2
    //   149: monitorexit
    //   150: aload_0
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramRenderScript	RenderScript
    //   0	152	1	paramResources	Resources
    //   0	152	2	paramInt	int
    //   18	104	3	i	int
    //   28	93	4	j	int
    //   24	11	5	k	int
    //   15	110	6	localObject1	Object
    //   32	91	7	localObject2	Object
    //   8	123	8	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   10	17	129	finally
    //   19	26	129	finally
    //   39	60	129	finally
    //   60	67	129	finally
    //   67	79	129	finally
    //   84	89	137	java/io/IOException
    //   130	137	137	java/io/IOException
    //   3	10	146	finally
    //   84	89	146	finally
    //   89	112	146	finally
    //   130	137	146	finally
    //   138	146	146	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */