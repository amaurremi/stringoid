package com.venticake.retrica.view.album;

final class RenderView$TextureLoadThread
  extends Thread
{
  public boolean mIsLoading;
  
  public RenderView$TextureLoadThread(RenderView paramRenderView)
  {
    super("TextureLoad");
  }
  
  private void load(Texture paramTexture)
  {
    RenderView localRenderView = this.this$0;
    RenderView.access$6(localRenderView, paramTexture);
    localRenderView.requestRender();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 39	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 43	com/venticake/retrica/view/album/RenderView:access$0	()Lcom/venticake/retrica/view/album/RenderView$TextureLoadThread;
    //   8: aload_0
    //   9: if_acmpne +68 -> 77
    //   12: invokestatic 47	com/venticake/retrica/view/album/RenderView:access$1	()Lcom/venticake/retrica/view/album/Deque;
    //   15: astore_1
    //   16: invokestatic 50	com/venticake/retrica/view/album/RenderView:access$5	()Lcom/venticake/retrica/view/album/Deque;
    //   19: astore_2
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_1
    //   23: invokevirtual 56	com/venticake/retrica/view/album/Deque:pollFirst	()Ljava/lang/Object;
    //   26: checkcast 58	com/venticake/retrica/view/album/Texture
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull +67 -> 98
    //   34: aload_1
    //   35: monitorexit
    //   36: invokestatic 61	com/venticake/retrica/view/album/RenderView:access$2	()Lcom/venticake/retrica/view/album/RenderView$TextureLoadThread;
    //   39: aload_0
    //   40: if_acmpeq +8 -> 48
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 63	com/venticake/retrica/view/album/RenderView$TextureLoadThread:mIsLoading	Z
    //   48: aload_0
    //   49: aload_3
    //   50: invokespecial 65	com/venticake/retrica/view/album/RenderView$TextureLoadThread:load	(Lcom/venticake/retrica/view/album/Texture;)V
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 63	com/venticake/retrica/view/album/RenderView$TextureLoadThread:mIsLoading	Z
    //   58: aload_2
    //   59: monitorenter
    //   60: aload_2
    //   61: aload_3
    //   62: invokevirtual 69	com/venticake/retrica/view/album/Deque:addLast	(Ljava/lang/Object;)V
    //   65: aload_2
    //   66: monitorexit
    //   67: goto -47 -> 20
    //   70: astore_1
    //   71: aload_2
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: return
    //   77: invokestatic 61	com/venticake/retrica/view/album/RenderView:access$2	()Lcom/venticake/retrica/view/album/RenderView$TextureLoadThread;
    //   80: aload_0
    //   81: if_acmpne +10 -> 91
    //   84: invokestatic 72	com/venticake/retrica/view/album/RenderView:access$3	()Lcom/venticake/retrica/view/album/Deque;
    //   87: astore_1
    //   88: goto -72 -> 16
    //   91: invokestatic 75	com/venticake/retrica/view/album/RenderView:access$4	()Lcom/venticake/retrica/view/album/Deque;
    //   94: astore_1
    //   95: goto -79 -> 16
    //   98: aload_1
    //   99: invokevirtual 80	java/lang/Object:wait	()V
    //   102: goto -80 -> 22
    //   105: astore_2
    //   106: aload_1
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	TextureLoadThread
    //   15	20	1	localDeque1	Deque
    //   70	4	1	localObject1	Object
    //   75	1	1	localInterruptedException	InterruptedException
    //   87	20	1	localDeque2	Deque
    //   19	53	2	localDeque3	Deque
    //   105	4	2	localObject2	Object
    //   29	33	3	localTexture	Texture
    // Exception table:
    //   from	to	target	type
    //   60	67	70	finally
    //   71	73	70	finally
    //   20	22	75	java/lang/InterruptedException
    //   36	48	75	java/lang/InterruptedException
    //   48	60	75	java/lang/InterruptedException
    //   73	75	75	java/lang/InterruptedException
    //   108	110	75	java/lang/InterruptedException
    //   22	30	105	finally
    //   34	36	105	finally
    //   98	102	105	finally
    //   106	108	105	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/RenderView$TextureLoadThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */