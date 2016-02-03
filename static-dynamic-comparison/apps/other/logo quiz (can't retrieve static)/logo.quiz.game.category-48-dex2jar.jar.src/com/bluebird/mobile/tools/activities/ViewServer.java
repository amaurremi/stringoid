package com.bluebird.mobile.tools.activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ViewServer
  implements Runnable
{
  private static final String BUILD_TYPE_USER = "user";
  private static final String COMMAND_PROTOCOL_VERSION = "PROTOCOL";
  private static final String COMMAND_SERVER_VERSION = "SERVER";
  private static final String COMMAND_WINDOW_MANAGER_AUTOLIST = "AUTOLIST";
  private static final String COMMAND_WINDOW_MANAGER_GET_FOCUS = "GET_FOCUS";
  private static final String COMMAND_WINDOW_MANAGER_LIST = "LIST";
  private static final String LOG_TAG = "ViewServer";
  private static final String VALUE_PROTOCOL_VERSION = "4";
  private static final String VALUE_SERVER_VERSION = "4";
  private static final int VIEW_SERVER_DEFAULT_PORT = 4939;
  private static final int VIEW_SERVER_MAX_CONNECTIONS = 10;
  private static ViewServer sServer;
  private final ReentrantReadWriteLock mFocusLock = new ReentrantReadWriteLock();
  private View mFocusedWindow;
  private final List<WindowListener> mListeners = new CopyOnWriteArrayList();
  private final int mPort;
  private ServerSocket mServer;
  private Thread mThread;
  private ExecutorService mThreadPool;
  private final HashMap<View, String> mWindows = new HashMap();
  private final ReentrantReadWriteLock mWindowsLock = new ReentrantReadWriteLock();
  
  private ViewServer()
  {
    this.mPort = -1;
  }
  
  private ViewServer(int paramInt)
  {
    this.mPort = paramInt;
  }
  
  private void addWindowListener(WindowListener paramWindowListener)
  {
    if (!this.mListeners.contains(paramWindowListener)) {
      this.mListeners.add(paramWindowListener);
    }
  }
  
  private void fireFocusChangedEvent()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((WindowListener)localIterator.next()).focusChanged();
    }
  }
  
  private void fireWindowsChangedEvent()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((WindowListener)localIterator.next()).windowsChanged();
    }
  }
  
  public static ViewServer get(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (("user".equals(Build.TYPE)) && ((paramContext.flags & 0x2) != 0))
    {
      if (sServer == null) {
        sServer = new ViewServer(4939);
      }
      if (sServer.isRunning()) {}
    }
    for (;;)
    {
      try
      {
        sServer.start();
        return sServer;
      }
      catch (IOException paramContext)
      {
        Log.d("ViewServer", "Error:", paramContext);
        continue;
      }
      sServer = new NoopViewServer(null);
    }
  }
  
  private void removeWindowListener(WindowListener paramWindowListener)
  {
    this.mListeners.remove(paramWindowListener);
  }
  
  /* Error */
  private static boolean writeValue(Socket paramSocket, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 205	java/io/BufferedWriter
    //   8: dup
    //   9: new 207	java/io/OutputStreamWriter
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 213	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   17: invokespecial 216	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   20: sipush 8192
    //   23: invokespecial 219	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   26: astore_0
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 223	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: ldc -31
    //   35: invokevirtual 223	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 228	java/io/BufferedWriter:flush	()V
    //   42: iconst_1
    //   43: istore_2
    //   44: aload_0
    //   45: ifnull +60 -> 105
    //   48: aload_0
    //   49: invokevirtual 231	java/io/BufferedWriter:close	()V
    //   52: iload_2
    //   53: ireturn
    //   54: astore_0
    //   55: iconst_0
    //   56: ireturn
    //   57: astore_0
    //   58: aload 4
    //   60: astore_0
    //   61: iconst_0
    //   62: istore_2
    //   63: aload_0
    //   64: ifnull -12 -> 52
    //   67: aload_0
    //   68: invokevirtual 231	java/io/BufferedWriter:close	()V
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_0
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_0
    //   77: aload_3
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 231	java/io/BufferedWriter:close	()V
    //   87: aload_0
    //   88: athrow
    //   89: astore_1
    //   90: goto -3 -> 87
    //   93: astore_3
    //   94: aload_0
    //   95: astore_1
    //   96: aload_3
    //   97: astore_0
    //   98: goto -19 -> 79
    //   101: astore_1
    //   102: goto -41 -> 61
    //   105: iconst_1
    //   106: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramSocket	Socket
    //   0	107	1	paramString	String
    //   43	20	2	bool	boolean
    //   1	77	3	localObject1	Object
    //   93	4	3	localObject2	Object
    //   3	56	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/io/IOException
    //   5	27	57	java/lang/Exception
    //   67	71	73	java/io/IOException
    //   5	27	76	finally
    //   83	87	89	java/io/IOException
    //   27	42	93	finally
    //   27	42	101	java/lang/Exception
  }
  
  public void addWindow(Activity paramActivity)
  {
    String str = paramActivity.getTitle().toString();
    if (TextUtils.isEmpty(str)) {}
    for (str = paramActivity.getClass().getCanonicalName() + "/0x" + System.identityHashCode(paramActivity);; str = str + "(" + paramActivity.getClass().getCanonicalName() + ")")
    {
      addWindow(paramActivity.getWindow().getDecorView(), str);
      return;
    }
  }
  
  public void addWindow(View paramView, String paramString)
  {
    this.mWindowsLock.writeLock().lock();
    try
    {
      this.mWindows.put(paramView.getRootView(), paramString);
      this.mWindowsLock.writeLock().unlock();
      fireWindowsChangedEvent();
      return;
    }
    finally
    {
      this.mWindowsLock.writeLock().unlock();
    }
  }
  
  public boolean isRunning()
  {
    return (this.mThread != null) && (this.mThread.isAlive());
  }
  
  public void removeWindow(Activity paramActivity)
  {
    removeWindow(paramActivity.getWindow().getDecorView());
  }
  
  public void removeWindow(View paramView)
  {
    this.mWindowsLock.writeLock().lock();
    try
    {
      this.mWindows.remove(paramView.getRootView());
      this.mWindowsLock.writeLock().unlock();
      fireWindowsChangedEvent();
      return;
    }
    finally
    {
      this.mWindowsLock.writeLock().unlock();
    }
  }
  
  public void run()
  {
    try
    {
      this.mServer = new ServerSocket(this.mPort, 10, InetAddress.getLocalHost());
      for (;;)
      {
        if ((this.mServer == null) || (Thread.currentThread() != this.mThread)) {
          return;
        }
        try
        {
          Socket localSocket = this.mServer.accept();
          if (this.mThreadPool == null) {
            break;
          }
          this.mThreadPool.submit(new ViewServerWorker(localSocket));
        }
        catch (Exception localException1)
        {
          Log.w("ViewServer", "Connection error: ", localException1);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.w("ViewServer", "Starting ServerSocket error: ", localException2);
        continue;
        try
        {
          localException2.close();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void setFocusedWindow(Activity paramActivity)
  {
    setFocusedWindow(paramActivity.getWindow().getDecorView());
  }
  
  public void setFocusedWindow(View paramView)
  {
    this.mFocusLock.writeLock().lock();
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getRootView()) {
      try
      {
        this.mFocusedWindow = paramView;
        this.mFocusLock.writeLock().unlock();
        fireFocusChangedEvent();
        return;
      }
      finally
      {
        this.mFocusLock.writeLock().unlock();
      }
    }
  }
  
  public boolean start()
    throws IOException
  {
    if (this.mThread != null) {
      return false;
    }
    this.mThread = new Thread(this, "Local View Server [port=" + this.mPort + "]");
    this.mThreadPool = Executors.newFixedThreadPool(10);
    this.mThread.start();
    return true;
  }
  
  /* Error */
  public boolean stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 319	com/bluebird/mobile/tools/activities/ViewServer:mThread	Ljava/lang/Thread;
    //   4: ifnull +74 -> 78
    //   7: aload_0
    //   8: getfield 319	com/bluebird/mobile/tools/activities/ViewServer:mThread	Ljava/lang/Thread;
    //   11: invokevirtual 402	java/lang/Thread:interrupt	()V
    //   14: aload_0
    //   15: getfield 355	com/bluebird/mobile/tools/activities/ViewServer:mThreadPool	Ljava/util/concurrent/ExecutorService;
    //   18: ifnull +13 -> 31
    //   21: aload_0
    //   22: getfield 355	com/bluebird/mobile/tools/activities/ViewServer:mThreadPool	Ljava/util/concurrent/ExecutorService;
    //   25: invokeinterface 406 1 0
    //   30: pop
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 355	com/bluebird/mobile/tools/activities/ViewServer:mThreadPool	Ljava/util/concurrent/ExecutorService;
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 319	com/bluebird/mobile/tools/activities/ViewServer:mThread	Ljava/lang/Thread;
    //   41: aload_0
    //   42: getfield 345	com/bluebird/mobile/tools/activities/ViewServer:mServer	Ljava/net/ServerSocket;
    //   45: invokevirtual 407	java/net/ServerSocket:close	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 345	com/bluebird/mobile/tools/activities/ViewServer:mServer	Ljava/net/ServerSocket;
    //   53: iconst_1
    //   54: ireturn
    //   55: astore_1
    //   56: ldc 42
    //   58: ldc_w 409
    //   61: invokestatic 412	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: goto -34 -> 31
    //   68: astore_1
    //   69: ldc 42
    //   71: ldc_w 414
    //   74: invokestatic 412	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: getfield 90	com/bluebird/mobile/tools/activities/ViewServer:mWindowsLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   82: invokevirtual 298	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   85: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   88: aload_0
    //   89: getfield 85	com/bluebird/mobile/tools/activities/ViewServer:mWindows	Ljava/util/HashMap;
    //   92: invokevirtual 417	java/util/HashMap:clear	()V
    //   95: aload_0
    //   96: getfield 90	com/bluebird/mobile/tools/activities/ViewServer:mWindowsLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   99: invokevirtual 298	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   102: invokevirtual 315	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   105: aload_0
    //   106: getfield 92	com/bluebird/mobile/tools/activities/ViewServer:mFocusLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   109: invokevirtual 298	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   112: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 109	com/bluebird/mobile/tools/activities/ViewServer:mFocusedWindow	Landroid/view/View;
    //   120: aload_0
    //   121: getfield 92	com/bluebird/mobile/tools/activities/ViewServer:mFocusLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   124: invokevirtual 298	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   127: invokevirtual 315	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 90	com/bluebird/mobile/tools/activities/ViewServer:mWindowsLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   137: invokevirtual 298	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   140: invokevirtual 315	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: getfield 92	com/bluebird/mobile/tools/activities/ViewServer:mFocusLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   150: invokevirtual 298	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   153: invokevirtual 315	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	ViewServer
    //   55	1	1	localSecurityException	SecurityException
    //   68	1	1	localIOException	IOException
    //   132	12	1	localObject1	Object
    //   145	12	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	31	55	java/lang/SecurityException
    //   41	53	68	java/io/IOException
    //   88	95	132	finally
    //   115	120	145	finally
  }
  
  private static class NoopViewServer
    extends ViewServer
  {
    private NoopViewServer()
    {
      super();
    }
    
    public void addWindow(Activity paramActivity) {}
    
    public void addWindow(View paramView, String paramString) {}
    
    public boolean isRunning()
    {
      return false;
    }
    
    public void removeWindow(Activity paramActivity) {}
    
    public void removeWindow(View paramView) {}
    
    public void run() {}
    
    public void setFocusedWindow(Activity paramActivity) {}
    
    public void setFocusedWindow(View paramView) {}
    
    public boolean start()
      throws IOException
    {
      return false;
    }
    
    public boolean stop()
    {
      return false;
    }
  }
  
  private static class UncloseableOuputStream
    extends OutputStream
  {
    private final OutputStream mStream;
    
    UncloseableOuputStream(OutputStream paramOutputStream)
    {
      this.mStream = paramOutputStream;
    }
    
    public void close()
      throws IOException
    {}
    
    public boolean equals(Object paramObject)
    {
      return this.mStream.equals(paramObject);
    }
    
    public void flush()
      throws IOException
    {
      this.mStream.flush();
    }
    
    public int hashCode()
    {
      return this.mStream.hashCode();
    }
    
    public String toString()
    {
      return this.mStream.toString();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.mStream.write(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.mStream.write(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.mStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private class ViewServerWorker
    implements Runnable, ViewServer.WindowListener
  {
    private Socket mClient;
    private final Object[] mLock = new Object[0];
    private boolean mNeedFocusedWindowUpdate;
    private boolean mNeedWindowListUpdate;
    
    public ViewServerWorker(Socket paramSocket)
    {
      this.mClient = paramSocket;
      this.mNeedWindowListUpdate = false;
      this.mNeedFocusedWindowUpdate = false;
    }
    
    private View findWindow(int paramInt)
    {
      if (paramInt == -1)
      {
        ViewServer.this.mWindowsLock.readLock().lock();
        try
        {
          View localView = ViewServer.this.mFocusedWindow;
          return localView;
        }
        finally
        {
          ViewServer.this.mWindowsLock.readLock().unlock();
        }
      }
      ViewServer.this.mWindowsLock.readLock().lock();
      try
      {
        Object localObject2 = ViewServer.this.mWindows.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          if (System.identityHashCode(localEntry.getKey()) == paramInt)
          {
            localObject2 = (View)localEntry.getKey();
            return (View)localObject2;
          }
        }
        return null;
      }
      finally
      {
        ViewServer.this.mWindowsLock.readLock().unlock();
      }
    }
    
    /* Error */
    private boolean getFocusedWindow(Socket paramSocket)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aconst_null
      //   3: astore 4
      //   5: aconst_null
      //   6: astore_3
      //   7: new 107	java/io/BufferedWriter
      //   10: dup
      //   11: new 109	java/io/OutputStreamWriter
      //   14: dup
      //   15: aload_1
      //   16: invokevirtual 115	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   19: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   22: sipush 8192
      //   25: invokespecial 121	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
      //   28: astore_1
      //   29: aload_0
      //   30: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   33: invokestatic 124	com/bluebird/mobile/tools/activities/ViewServer:access$600	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   36: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   39: invokevirtual 53	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   42: aload_0
      //   43: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   46: invokestatic 57	com/bluebird/mobile/tools/activities/ViewServer:access$400	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Landroid/view/View;
      //   49: astore_3
      //   50: aload_0
      //   51: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   54: invokestatic 124	com/bluebird/mobile/tools/activities/ViewServer:access$600	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   57: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   60: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   63: aload_3
      //   64: ifnull +75 -> 139
      //   67: aload_0
      //   68: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   71: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   74: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   77: invokevirtual 53	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   80: aload_0
      //   81: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   84: invokestatic 64	com/bluebird/mobile/tools/activities/ViewServer:access$500	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/HashMap;
      //   87: aload_0
      //   88: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   91: invokestatic 57	com/bluebird/mobile/tools/activities/ViewServer:access$400	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Landroid/view/View;
      //   94: invokevirtual 128	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   97: checkcast 130	java/lang/String
      //   100: astore 4
      //   102: aload_0
      //   103: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   106: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   109: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   112: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   115: aload_1
      //   116: aload_3
      //   117: invokestatic 97	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
      //   120: invokestatic 136	java/lang/Integer:toHexString	(I)Ljava/lang/String;
      //   123: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   126: aload_1
      //   127: bipush 32
      //   129: invokevirtual 143	java/io/BufferedWriter:write	(I)V
      //   132: aload_1
      //   133: aload 4
      //   135: invokevirtual 147	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
      //   138: pop
      //   139: aload_1
      //   140: bipush 10
      //   142: invokevirtual 143	java/io/BufferedWriter:write	(I)V
      //   145: aload_1
      //   146: invokevirtual 150	java/io/BufferedWriter:flush	()V
      //   149: aload_1
      //   150: ifnull +94 -> 244
      //   153: aload_1
      //   154: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   157: iload_2
      //   158: ireturn
      //   159: astore_3
      //   160: aload_0
      //   161: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   164: invokestatic 124	com/bluebird/mobile/tools/activities/ViewServer:access$600	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   167: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   170: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   173: aload_3
      //   174: athrow
      //   175: astore_3
      //   176: iconst_0
      //   177: istore_2
      //   178: aload_1
      //   179: ifnull -22 -> 157
      //   182: aload_1
      //   183: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   186: iconst_0
      //   187: ireturn
      //   188: astore_1
      //   189: iconst_0
      //   190: ireturn
      //   191: astore_3
      //   192: aload_0
      //   193: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   196: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   199: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   202: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   205: aload_3
      //   206: athrow
      //   207: astore 4
      //   209: aload_1
      //   210: astore_3
      //   211: aload 4
      //   213: astore_1
      //   214: aload_3
      //   215: ifnull +7 -> 222
      //   218: aload_3
      //   219: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   222: aload_1
      //   223: athrow
      //   224: astore_1
      //   225: iconst_0
      //   226: ireturn
      //   227: astore_3
      //   228: goto -6 -> 222
      //   231: astore_1
      //   232: aload 4
      //   234: astore_3
      //   235: goto -21 -> 214
      //   238: astore_1
      //   239: aload_3
      //   240: astore_1
      //   241: goto -65 -> 176
      //   244: iconst_1
      //   245: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	246	0	this	ViewServerWorker
      //   0	246	1	paramSocket	Socket
      //   1	177	2	bool	boolean
      //   6	111	3	localView	View
      //   159	15	3	localObject1	Object
      //   175	1	3	localException	Exception
      //   191	15	3	localObject2	Object
      //   210	9	3	localSocket	Socket
      //   227	1	3	localIOException	IOException
      //   234	6	3	localObject3	Object
      //   3	131	4	str	String
      //   207	26	4	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   42	50	159	finally
      //   29	42	175	java/lang/Exception
      //   50	63	175	java/lang/Exception
      //   67	80	175	java/lang/Exception
      //   102	139	175	java/lang/Exception
      //   139	149	175	java/lang/Exception
      //   160	175	175	java/lang/Exception
      //   192	207	175	java/lang/Exception
      //   182	186	188	java/io/IOException
      //   80	102	191	finally
      //   29	42	207	finally
      //   50	63	207	finally
      //   67	80	207	finally
      //   102	139	207	finally
      //   139	149	207	finally
      //   160	175	207	finally
      //   192	207	207	finally
      //   153	157	224	java/io/IOException
      //   218	222	227	java/io/IOException
      //   7	29	231	finally
      //   7	29	238	java/lang/Exception
    }
    
    /* Error */
    private boolean listWindows(Socket paramSocket)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: aload_0
      //   5: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   8: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   11: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   14: invokevirtual 53	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   17: new 107	java/io/BufferedWriter
      //   20: dup
      //   21: new 109	java/io/OutputStreamWriter
      //   24: dup
      //   25: aload_1
      //   26: invokevirtual 115	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   29: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   32: sipush 8192
      //   35: invokespecial 121	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   43: invokestatic 64	com/bluebird/mobile/tools/activities/ViewServer:access$500	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/HashMap;
      //   46: invokevirtual 70	java/util/HashMap:entrySet	()Ljava/util/Set;
      //   49: invokeinterface 76 1 0
      //   54: astore_2
      //   55: aload_2
      //   56: invokeinterface 82 1 0
      //   61: ifeq +82 -> 143
      //   64: aload_2
      //   65: invokeinterface 86 1 0
      //   70: checkcast 88	java/util/Map$Entry
      //   73: astore_3
      //   74: aload_1
      //   75: aload_3
      //   76: invokeinterface 91 1 0
      //   81: invokestatic 97	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
      //   84: invokestatic 136	java/lang/Integer:toHexString	(I)Ljava/lang/String;
      //   87: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   90: aload_1
      //   91: bipush 32
      //   93: invokevirtual 143	java/io/BufferedWriter:write	(I)V
      //   96: aload_1
      //   97: aload_3
      //   98: invokeinterface 157 1 0
      //   103: checkcast 159	java/lang/CharSequence
      //   106: invokevirtual 147	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
      //   109: pop
      //   110: aload_1
      //   111: bipush 10
      //   113: invokevirtual 143	java/io/BufferedWriter:write	(I)V
      //   116: goto -61 -> 55
      //   119: astore_2
      //   120: aload_0
      //   121: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   124: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   127: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   130: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   133: aload_1
      //   134: ifnull +7 -> 141
      //   137: aload_1
      //   138: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   141: iconst_0
      //   142: ireturn
      //   143: aload_1
      //   144: ldc -95
      //   146: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   149: aload_1
      //   150: invokevirtual 150	java/io/BufferedWriter:flush	()V
      //   153: aload_0
      //   154: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   157: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   160: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   163: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   166: aload_1
      //   167: ifnull +57 -> 224
      //   170: aload_1
      //   171: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   174: iconst_1
      //   175: ireturn
      //   176: astore_1
      //   177: iconst_0
      //   178: ireturn
      //   179: astore_1
      //   180: iconst_0
      //   181: ireturn
      //   182: astore_1
      //   183: aload_0
      //   184: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   187: invokestatic 42	com/bluebird/mobile/tools/activities/ViewServer:access$300	(Lcom/bluebird/mobile/tools/activities/ViewServer;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   190: invokevirtual 48	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   193: invokevirtual 60	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   196: aload_2
      //   197: ifnull +7 -> 204
      //   200: aload_2
      //   201: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   204: aload_1
      //   205: athrow
      //   206: astore_2
      //   207: goto -3 -> 204
      //   210: astore_3
      //   211: aload_1
      //   212: astore_2
      //   213: aload_3
      //   214: astore_1
      //   215: goto -32 -> 183
      //   218: astore_1
      //   219: aload_3
      //   220: astore_1
      //   221: goto -101 -> 120
      //   224: iconst_1
      //   225: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	226	0	this	ViewServerWorker
      //   0	226	1	paramSocket	Socket
      //   1	64	2	localIterator	Iterator
      //   119	82	2	localException	Exception
      //   206	1	2	localIOException	IOException
      //   212	1	2	localSocket	Socket
      //   3	95	3	localEntry	Map.Entry
      //   210	10	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   39	55	119	java/lang/Exception
      //   55	116	119	java/lang/Exception
      //   143	153	119	java/lang/Exception
      //   170	174	176	java/io/IOException
      //   137	141	179	java/io/IOException
      //   4	39	182	finally
      //   200	204	206	java/io/IOException
      //   39	55	210	finally
      //   55	116	210	finally
      //   143	153	210	finally
      //   4	39	218	java/lang/Exception
    }
    
    /* Error */
    private boolean windowCommand(Socket paramSocket, String paramString1, String paramString2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: aconst_null
      //   4: astore 11
      //   6: aconst_null
      //   7: astore 12
      //   9: aconst_null
      //   10: astore 10
      //   12: aload_3
      //   13: astore 9
      //   15: aload 12
      //   17: astore 8
      //   19: aload_3
      //   20: bipush 32
      //   22: invokevirtual 167	java/lang/String:indexOf	(I)I
      //   25: istore 5
      //   27: iload 5
      //   29: istore 4
      //   31: iload 5
      //   33: iconst_m1
      //   34: if_icmpne +16 -> 50
      //   37: aload_3
      //   38: astore 9
      //   40: aload 12
      //   42: astore 8
      //   44: aload_3
      //   45: invokevirtual 171	java/lang/String:length	()I
      //   48: istore 4
      //   50: aload_3
      //   51: astore 9
      //   53: aload 12
      //   55: astore 8
      //   57: aload_3
      //   58: iconst_0
      //   59: iload 4
      //   61: invokevirtual 175	java/lang/String:substring	(II)Ljava/lang/String;
      //   64: bipush 16
      //   66: invokestatic 181	java/lang/Long:parseLong	(Ljava/lang/String;I)J
      //   69: l2i
      //   70: istore 5
      //   72: aload_3
      //   73: astore 9
      //   75: aload 12
      //   77: astore 8
      //   79: iload 4
      //   81: aload_3
      //   82: invokevirtual 171	java/lang/String:length	()I
      //   85: if_icmpge +53 -> 138
      //   88: aload_3
      //   89: astore 9
      //   91: aload 12
      //   93: astore 8
      //   95: aload_3
      //   96: iload 4
      //   98: iconst_1
      //   99: iadd
      //   100: invokevirtual 183	java/lang/String:substring	(I)Ljava/lang/String;
      //   103: astore_3
      //   104: aload_3
      //   105: astore 9
      //   107: aload 12
      //   109: astore 8
      //   111: aload_0
      //   112: iload 5
      //   114: invokespecial 185	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:findWindow	(I)Landroid/view/View;
      //   117: astore 14
      //   119: aload 14
      //   121: ifnonnull +23 -> 144
      //   124: iconst_0
      //   125: ifeq +11 -> 136
      //   128: new 187	java/lang/NullPointerException
      //   131: dup
      //   132: invokespecial 188	java/lang/NullPointerException:<init>	()V
      //   135: athrow
      //   136: iconst_0
      //   137: ireturn
      //   138: ldc -66
      //   140: astore_3
      //   141: goto -37 -> 104
      //   144: aload_3
      //   145: astore 9
      //   147: aload 12
      //   149: astore 8
      //   151: ldc -64
      //   153: ldc -62
      //   155: iconst_4
      //   156: anewarray 196	java/lang/Class
      //   159: dup
      //   160: iconst_0
      //   161: ldc 99
      //   163: aastore
      //   164: dup
      //   165: iconst_1
      //   166: ldc -126
      //   168: aastore
      //   169: dup
      //   170: iconst_2
      //   171: ldc -126
      //   173: aastore
      //   174: dup
      //   175: iconst_3
      //   176: ldc -58
      //   178: aastore
      //   179: invokevirtual 202	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   182: astore 13
      //   184: aload_3
      //   185: astore 9
      //   187: aload 12
      //   189: astore 8
      //   191: aload 13
      //   193: iconst_1
      //   194: invokevirtual 208	java/lang/reflect/Method:setAccessible	(Z)V
      //   197: aload_3
      //   198: astore 9
      //   200: aload 12
      //   202: astore 8
      //   204: aload 13
      //   206: aconst_null
      //   207: iconst_4
      //   208: anewarray 4	java/lang/Object
      //   211: dup
      //   212: iconst_0
      //   213: aload 14
      //   215: aastore
      //   216: dup
      //   217: iconst_1
      //   218: aload_2
      //   219: aastore
      //   220: dup
      //   221: iconst_2
      //   222: aload_3
      //   223: aastore
      //   224: dup
      //   225: iconst_3
      //   226: new 210	com/bluebird/mobile/tools/activities/ViewServer$UncloseableOuputStream
      //   229: dup
      //   230: aload_1
      //   231: invokevirtual 115	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   234: invokespecial 211	com/bluebird/mobile/tools/activities/ViewServer$UncloseableOuputStream:<init>	(Ljava/io/OutputStream;)V
      //   237: aastore
      //   238: invokevirtual 215	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   241: pop
      //   242: aload_3
      //   243: astore 9
      //   245: aload 12
      //   247: astore 8
      //   249: aload_1
      //   250: invokevirtual 218	java/net/Socket:isOutputShutdown	()Z
      //   253: ifne +42 -> 295
      //   256: aload_3
      //   257: astore 9
      //   259: aload 12
      //   261: astore 8
      //   263: new 107	java/io/BufferedWriter
      //   266: dup
      //   267: new 109	java/io/OutputStreamWriter
      //   270: dup
      //   271: aload_1
      //   272: invokevirtual 115	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   275: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   278: invokespecial 221	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   281: astore_1
      //   282: aload_1
      //   283: ldc -33
      //   285: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   288: aload_1
      //   289: invokevirtual 150	java/io/BufferedWriter:flush	()V
      //   292: aload_1
      //   293: astore 10
      //   295: iload 7
      //   297: istore 6
      //   299: aload 10
      //   301: ifnull +12 -> 313
      //   304: aload 10
      //   306: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   309: iload 7
      //   311: istore 6
      //   313: iload 6
      //   315: ireturn
      //   316: astore_1
      //   317: iconst_0
      //   318: istore 6
      //   320: goto -7 -> 313
      //   323: astore 8
      //   325: aload 9
      //   327: astore_3
      //   328: aload 11
      //   330: astore_1
      //   331: aload 8
      //   333: astore 9
      //   335: aload_1
      //   336: astore 8
      //   338: ldc -31
      //   340: new 227	java/lang/StringBuilder
      //   343: dup
      //   344: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   347: ldc -26
      //   349: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: aload_2
      //   353: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   356: ldc -21
      //   358: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   361: aload_3
      //   362: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   365: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   368: aload 9
      //   370: invokestatic 245	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   373: pop
      //   374: iconst_0
      //   375: istore 7
      //   377: iload 7
      //   379: istore 6
      //   381: aload_1
      //   382: ifnull -69 -> 313
      //   385: aload_1
      //   386: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   389: iload 7
      //   391: istore 6
      //   393: goto -80 -> 313
      //   396: astore_1
      //   397: iconst_0
      //   398: istore 6
      //   400: goto -87 -> 313
      //   403: astore_1
      //   404: aload 8
      //   406: ifnull +8 -> 414
      //   409: aload 8
      //   411: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   414: aload_1
      //   415: athrow
      //   416: astore_2
      //   417: goto -3 -> 414
      //   420: astore_2
      //   421: aload_1
      //   422: astore 8
      //   424: aload_2
      //   425: astore_1
      //   426: goto -22 -> 404
      //   429: astore 9
      //   431: goto -96 -> 335
      //   434: astore_1
      //   435: iconst_0
      //   436: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	437	0	this	ViewServerWorker
      //   0	437	1	paramSocket	Socket
      //   0	437	2	paramString1	String
      //   0	437	3	paramString2	String
      //   29	71	4	i	int
      //   25	88	5	j	int
      //   297	102	6	bool1	boolean
      //   1	389	7	bool2	boolean
      //   17	245	8	localObject1	Object
      //   323	9	8	localException1	Exception
      //   336	87	8	localSocket1	Socket
      //   13	356	9	localObject2	Object
      //   429	1	9	localException2	Exception
      //   10	295	10	localSocket2	Socket
      //   4	325	11	localObject3	Object
      //   7	253	12	localObject4	Object
      //   182	23	13	localMethod	java.lang.reflect.Method
      //   117	97	14	localView	View
      // Exception table:
      //   from	to	target	type
      //   304	309	316	java/io/IOException
      //   19	27	323	java/lang/Exception
      //   44	50	323	java/lang/Exception
      //   57	72	323	java/lang/Exception
      //   79	88	323	java/lang/Exception
      //   95	104	323	java/lang/Exception
      //   111	119	323	java/lang/Exception
      //   151	184	323	java/lang/Exception
      //   191	197	323	java/lang/Exception
      //   204	242	323	java/lang/Exception
      //   249	256	323	java/lang/Exception
      //   263	282	323	java/lang/Exception
      //   385	389	396	java/io/IOException
      //   19	27	403	finally
      //   44	50	403	finally
      //   57	72	403	finally
      //   79	88	403	finally
      //   95	104	403	finally
      //   111	119	403	finally
      //   151	184	403	finally
      //   191	197	403	finally
      //   204	242	403	finally
      //   249	256	403	finally
      //   263	282	403	finally
      //   338	374	403	finally
      //   409	414	416	java/io/IOException
      //   282	292	420	finally
      //   282	292	429	java/lang/Exception
      //   128	136	434	java/io/IOException
    }
    
    /* Error */
    private boolean windowManagerAutolistLoop()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   4: aload_0
      //   5: invokestatic 250	com/bluebird/mobile/tools/activities/ViewServer:access$700	(Lcom/bluebird/mobile/tools/activities/ViewServer;Lcom/bluebird/mobile/tools/activities/ViewServer$WindowListener;)V
      //   8: aconst_null
      //   9: astore_3
      //   10: aconst_null
      //   11: astore 6
      //   13: new 107	java/io/BufferedWriter
      //   16: dup
      //   17: new 109	java/io/OutputStreamWriter
      //   20: dup
      //   21: aload_0
      //   22: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   25: invokevirtual 115	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   28: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   31: invokespecial 221	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   34: astore 4
      //   36: invokestatic 255	java/lang/Thread:interrupted	()Z
      //   39: ifne +169 -> 208
      //   42: iconst_0
      //   43: istore_1
      //   44: iconst_0
      //   45: istore_2
      //   46: aload_0
      //   47: getfield 29	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mLock	[Ljava/lang/Object;
      //   50: astore_3
      //   51: aload_3
      //   52: monitorenter
      //   53: aload_0
      //   54: getfield 33	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mNeedWindowListUpdate	Z
      //   57: ifne +63 -> 120
      //   60: aload_0
      //   61: getfield 35	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mNeedFocusedWindowUpdate	Z
      //   64: ifne +56 -> 120
      //   67: aload_0
      //   68: getfield 29	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mLock	[Ljava/lang/Object;
      //   71: invokevirtual 258	java/lang/Object:wait	()V
      //   74: goto -21 -> 53
      //   77: astore 5
      //   79: aload_3
      //   80: monitorexit
      //   81: aload 5
      //   83: athrow
      //   84: astore 5
      //   86: aload 4
      //   88: astore_3
      //   89: ldc -31
      //   91: ldc_w 260
      //   94: aload 5
      //   96: invokestatic 245	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   99: pop
      //   100: aload 4
      //   102: ifnull +8 -> 110
      //   105: aload 4
      //   107: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   110: aload_0
      //   111: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   114: aload_0
      //   115: invokestatic 263	com/bluebird/mobile/tools/activities/ViewServer:access$800	(Lcom/bluebird/mobile/tools/activities/ViewServer;Lcom/bluebird/mobile/tools/activities/ViewServer$WindowListener;)V
      //   118: iconst_1
      //   119: ireturn
      //   120: aload_0
      //   121: getfield 33	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mNeedWindowListUpdate	Z
      //   124: ifeq +10 -> 134
      //   127: aload_0
      //   128: iconst_0
      //   129: putfield 33	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mNeedWindowListUpdate	Z
      //   132: iconst_1
      //   133: istore_1
      //   134: aload_0
      //   135: getfield 35	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mNeedFocusedWindowUpdate	Z
      //   138: ifeq +10 -> 148
      //   141: aload_0
      //   142: iconst_0
      //   143: putfield 35	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mNeedFocusedWindowUpdate	Z
      //   146: iconst_1
      //   147: istore_2
      //   148: aload_3
      //   149: monitorexit
      //   150: iload_1
      //   151: ifeq +16 -> 167
      //   154: aload 4
      //   156: ldc_w 265
      //   159: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   162: aload 4
      //   164: invokevirtual 150	java/io/BufferedWriter:flush	()V
      //   167: iload_2
      //   168: ifeq -132 -> 36
      //   171: aload 4
      //   173: ldc_w 267
      //   176: invokevirtual 140	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   179: aload 4
      //   181: invokevirtual 150	java/io/BufferedWriter:flush	()V
      //   184: goto -148 -> 36
      //   187: astore_3
      //   188: aload 4
      //   190: ifnull +8 -> 198
      //   193: aload 4
      //   195: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   198: aload_0
      //   199: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   202: aload_0
      //   203: invokestatic 263	com/bluebird/mobile/tools/activities/ViewServer:access$800	(Lcom/bluebird/mobile/tools/activities/ViewServer;Lcom/bluebird/mobile/tools/activities/ViewServer$WindowListener;)V
      //   206: aload_3
      //   207: athrow
      //   208: aload 4
      //   210: ifnull +8 -> 218
      //   213: aload 4
      //   215: invokevirtual 153	java/io/BufferedWriter:close	()V
      //   218: aload_0
      //   219: getfield 24	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:this$0	Lcom/bluebird/mobile/tools/activities/ViewServer;
      //   222: aload_0
      //   223: invokestatic 263	com/bluebird/mobile/tools/activities/ViewServer:access$800	(Lcom/bluebird/mobile/tools/activities/ViewServer;Lcom/bluebird/mobile/tools/activities/ViewServer$WindowListener;)V
      //   226: goto -108 -> 118
      //   229: astore_3
      //   230: goto -12 -> 218
      //   233: astore_3
      //   234: goto -124 -> 110
      //   237: astore 4
      //   239: goto -41 -> 198
      //   242: astore 5
      //   244: aload_3
      //   245: astore 4
      //   247: aload 5
      //   249: astore_3
      //   250: goto -62 -> 188
      //   253: astore 5
      //   255: aload 6
      //   257: astore 4
      //   259: goto -173 -> 86
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	262	0	this	ViewServerWorker
      //   43	108	1	i	int
      //   45	123	2	j	int
      //   187	20	3	localObject2	Object
      //   229	1	3	localIOException1	IOException
      //   233	12	3	localIOException2	IOException
      //   249	1	3	localObject3	Object
      //   34	180	4	localBufferedWriter	java.io.BufferedWriter
      //   237	1	4	localIOException3	IOException
      //   245	13	4	localObject4	Object
      //   77	5	5	localObject5	Object
      //   84	11	5	localException1	Exception
      //   242	6	5	localObject6	Object
      //   253	1	5	localException2	Exception
      //   11	245	6	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   53	74	77	finally
      //   79	81	77	finally
      //   120	132	77	finally
      //   134	146	77	finally
      //   148	150	77	finally
      //   36	42	84	java/lang/Exception
      //   46	53	84	java/lang/Exception
      //   81	84	84	java/lang/Exception
      //   154	167	84	java/lang/Exception
      //   171	184	84	java/lang/Exception
      //   36	42	187	finally
      //   46	53	187	finally
      //   81	84	187	finally
      //   154	167	187	finally
      //   171	184	187	finally
      //   213	218	229	java/io/IOException
      //   105	110	233	java/io/IOException
      //   193	198	237	java/io/IOException
      //   13	36	242	finally
      //   89	100	242	finally
      //   13	36	253	java/lang/Exception
    }
    
    public void focusChanged()
    {
      synchronized (this.mLock)
      {
        this.mNeedFocusedWindowUpdate = true;
        this.mLock.notifyAll();
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 5
      //   5: new 274	java/io/BufferedReader
      //   8: dup
      //   9: new 276	java/io/InputStreamReader
      //   12: dup
      //   13: aload_0
      //   14: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   17: invokevirtual 280	java/net/Socket:getInputStream	()Ljava/io/InputStream;
      //   20: invokespecial 283	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   23: sipush 1024
      //   26: invokespecial 286	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
      //   29: astore 4
      //   31: aload 4
      //   33: invokevirtual 289	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   36: astore 5
      //   38: aload 5
      //   40: bipush 32
      //   42: invokevirtual 167	java/lang/String:indexOf	(I)I
      //   45: istore_1
      //   46: iload_1
      //   47: iconst_m1
      //   48: if_icmpne +86 -> 134
      //   51: aload 5
      //   53: astore_3
      //   54: ldc -66
      //   56: astore 5
      //   58: ldc_w 291
      //   61: aload_3
      //   62: invokevirtual 295	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   65: ifeq +90 -> 155
      //   68: aload_0
      //   69: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   72: ldc_w 297
      //   75: invokestatic 301	com/bluebird/mobile/tools/activities/ViewServer:access$200	(Ljava/net/Socket;Ljava/lang/String;)Z
      //   78: istore_2
      //   79: iload_2
      //   80: ifne +29 -> 109
      //   83: ldc -31
      //   85: new 227	java/lang/StringBuilder
      //   88: dup
      //   89: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   92: ldc_w 303
      //   95: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: aload_3
      //   99: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: invokestatic 306	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   108: pop
      //   109: aload 4
      //   111: ifnull +8 -> 119
      //   114: aload 4
      //   116: invokevirtual 307	java/io/BufferedReader:close	()V
      //   119: aload_0
      //   120: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   123: ifnull +268 -> 391
      //   126: aload_0
      //   127: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   130: invokevirtual 308	java/net/Socket:close	()V
      //   133: return
      //   134: aload 5
      //   136: iconst_0
      //   137: iload_1
      //   138: invokevirtual 175	java/lang/String:substring	(II)Ljava/lang/String;
      //   141: astore_3
      //   142: aload 5
      //   144: iload_1
      //   145: iconst_1
      //   146: iadd
      //   147: invokevirtual 183	java/lang/String:substring	(I)Ljava/lang/String;
      //   150: astore 5
      //   152: goto -94 -> 58
      //   155: ldc_w 310
      //   158: aload_3
      //   159: invokevirtual 295	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   162: ifeq +17 -> 179
      //   165: aload_0
      //   166: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   169: ldc_w 297
      //   172: invokestatic 301	com/bluebird/mobile/tools/activities/ViewServer:access$200	(Ljava/net/Socket;Ljava/lang/String;)Z
      //   175: istore_2
      //   176: goto -97 -> 79
      //   179: ldc_w 312
      //   182: aload_3
      //   183: invokevirtual 295	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   186: ifeq +15 -> 201
      //   189: aload_0
      //   190: aload_0
      //   191: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   194: invokespecial 314	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:listWindows	(Ljava/net/Socket;)Z
      //   197: istore_2
      //   198: goto -119 -> 79
      //   201: ldc_w 316
      //   204: aload_3
      //   205: invokevirtual 295	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   208: ifeq +15 -> 223
      //   211: aload_0
      //   212: aload_0
      //   213: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   216: invokespecial 318	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:getFocusedWindow	(Ljava/net/Socket;)Z
      //   219: istore_2
      //   220: goto -141 -> 79
      //   223: ldc_w 320
      //   226: aload_3
      //   227: invokevirtual 295	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   230: ifeq +11 -> 241
      //   233: aload_0
      //   234: invokespecial 322	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:windowManagerAutolistLoop	()Z
      //   237: istore_2
      //   238: goto -159 -> 79
      //   241: aload_0
      //   242: aload_0
      //   243: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   246: aload_3
      //   247: aload 5
      //   249: invokespecial 324	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:windowCommand	(Ljava/net/Socket;Ljava/lang/String;Ljava/lang/String;)Z
      //   252: istore_2
      //   253: goto -174 -> 79
      //   256: astore_3
      //   257: aload_3
      //   258: invokevirtual 327	java/io/IOException:printStackTrace	()V
      //   261: goto -142 -> 119
      //   264: astore_3
      //   265: aload_3
      //   266: invokevirtual 327	java/io/IOException:printStackTrace	()V
      //   269: return
      //   270: astore_3
      //   271: aload 5
      //   273: astore 4
      //   275: aload_3
      //   276: astore 5
      //   278: aload 4
      //   280: astore_3
      //   281: ldc -31
      //   283: ldc_w 260
      //   286: aload 5
      //   288: invokestatic 245	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   291: pop
      //   292: aload 4
      //   294: ifnull +8 -> 302
      //   297: aload 4
      //   299: invokevirtual 307	java/io/BufferedReader:close	()V
      //   302: aload_0
      //   303: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   306: ifnull -173 -> 133
      //   309: aload_0
      //   310: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   313: invokevirtual 308	java/net/Socket:close	()V
      //   316: return
      //   317: astore_3
      //   318: aload_3
      //   319: invokevirtual 327	java/io/IOException:printStackTrace	()V
      //   322: return
      //   323: astore_3
      //   324: aload_3
      //   325: invokevirtual 327	java/io/IOException:printStackTrace	()V
      //   328: goto -26 -> 302
      //   331: astore 4
      //   333: aload_3
      //   334: ifnull +7 -> 341
      //   337: aload_3
      //   338: invokevirtual 307	java/io/BufferedReader:close	()V
      //   341: aload_0
      //   342: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   345: ifnull +10 -> 355
      //   348: aload_0
      //   349: getfield 31	com/bluebird/mobile/tools/activities/ViewServer$ViewServerWorker:mClient	Ljava/net/Socket;
      //   352: invokevirtual 308	java/net/Socket:close	()V
      //   355: aload 4
      //   357: athrow
      //   358: astore_3
      //   359: aload_3
      //   360: invokevirtual 327	java/io/IOException:printStackTrace	()V
      //   363: goto -22 -> 341
      //   366: astore_3
      //   367: aload_3
      //   368: invokevirtual 327	java/io/IOException:printStackTrace	()V
      //   371: goto -16 -> 355
      //   374: astore 5
      //   376: aload 4
      //   378: astore_3
      //   379: aload 5
      //   381: astore 4
      //   383: goto -50 -> 333
      //   386: astore 5
      //   388: goto -110 -> 278
      //   391: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	392	0	this	ViewServerWorker
      //   45	102	1	i	int
      //   78	175	2	bool	boolean
      //   1	246	3	localObject1	Object
      //   256	2	3	localIOException1	IOException
      //   264	2	3	localIOException2	IOException
      //   270	6	3	localIOException3	IOException
      //   280	1	3	localObject2	Object
      //   317	2	3	localIOException4	IOException
      //   323	15	3	localIOException5	IOException
      //   358	2	3	localIOException6	IOException
      //   366	2	3	localIOException7	IOException
      //   378	1	3	localObject3	Object
      //   29	269	4	localObject4	Object
      //   331	46	4	localObject5	Object
      //   381	1	4	localObject6	Object
      //   3	284	5	localObject7	Object
      //   374	6	5	localObject8	Object
      //   386	1	5	localIOException8	IOException
      // Exception table:
      //   from	to	target	type
      //   114	119	256	java/io/IOException
      //   126	133	264	java/io/IOException
      //   5	31	270	java/io/IOException
      //   309	316	317	java/io/IOException
      //   297	302	323	java/io/IOException
      //   5	31	331	finally
      //   281	292	331	finally
      //   337	341	358	java/io/IOException
      //   348	355	366	java/io/IOException
      //   31	46	374	finally
      //   58	79	374	finally
      //   83	109	374	finally
      //   134	152	374	finally
      //   155	176	374	finally
      //   179	198	374	finally
      //   201	220	374	finally
      //   223	238	374	finally
      //   241	253	374	finally
      //   31	46	386	java/io/IOException
      //   58	79	386	java/io/IOException
      //   83	109	386	java/io/IOException
      //   134	152	386	java/io/IOException
      //   155	176	386	java/io/IOException
      //   179	198	386	java/io/IOException
      //   201	220	386	java/io/IOException
      //   223	238	386	java/io/IOException
      //   241	253	386	java/io/IOException
    }
    
    public void windowsChanged()
    {
      synchronized (this.mLock)
      {
        this.mNeedWindowListUpdate = true;
        this.mLock.notifyAll();
        return;
      }
    }
  }
  
  private static abstract interface WindowListener
  {
    public abstract void focusChanged();
    
    public abstract void windowsChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/ViewServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */