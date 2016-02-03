package com.pioong.global;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.pioong.asynchttp.HttpConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public final class Network
{
  public static final int FINDING = 1;
  public static final int MATCHING_FAIL = 3;
  public static final int MATCHING_OK = 2;
  public static final int QUIT = 4;
  public static String URL_AUTH = "http://chat.mocoplex.com:20001/login.jsp";
  public static String URL_EXITROOM = "http://chat.mocoplex.com:20001/out.jsp";
  public static String URL_FINDROOM = "http://chat.mocoplex.com:20001/match.jsp";
  public static String URL_RECEIVE;
  public static String URL_SENDMSG = "http://chat.mocoplex.com:20001/sendm.jsp";
  public static String URL_UPLOAD_IMAGE;
  private static Network _instance = null;
  private boolean isFinding = false;
  private String mUDID = null;
  private ProgressDialog progDialog = null;
  
  static
  {
    URL_RECEIVE = "http://chat.mocoplex.com:20001/rcv.jsp";
    URL_UPLOAD_IMAGE = "http://chat.mocoplex.com:20001/sendi.jsp";
  }
  
  public static Network getInstance()
  {
    try
    {
      if (_instance == null) {
        _instance = new Network();
      }
      Network localNetwork = _instance;
      return localNetwork;
    }
    finally {}
  }
  
  public void exitChatting()
  {
    this.isFinding = false;
    String str = URL_EXITROOM;
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(new BasicNameValuePair("sid", Value.getInstance().getSID()));
    ((List)localObject2).add(new BasicNameValuePair("room", Value.getInstance().getRoomNo()));
    Object localObject1 = null;
    try
    {
      localObject2 = new UrlEncodedFormEntity((List)localObject2, "UTF-8");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    new HttpConnection(new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
      }
    }).post(str, (UrlEncodedFormEntity)localObject1);
    Value.getInstance().exitRoom();
    Value.getInstance().mArrChatting.clear();
  }
  
  public void exitRoom(Context paramContext, Handler paramHandler)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while (!Value.getInstance().isChatting());
      String str = URL_EXITROOM;
      Object localObject = new ArrayList();
      ((List)localObject).add(new BasicNameValuePair("sid", Value.getInstance().getSID()));
      ((List)localObject).add(new BasicNameValuePair("room", Value.getInstance().getRoomNo()));
      paramContext = null;
      try
      {
        localObject = new UrlEncodedFormEntity((List)localObject, "UTF-8");
        paramContext = (Context)localObject;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    } while ((HttpConnection.post2(str, paramContext) == null) || (paramHandler == null));
    paramHandler.sendEmptyMessage(4);
  }
  
  public void findRoom(final Context paramContext, final Handler paramHandler)
  {
    if (!Value.getInstance().isLogin()) {
      login(paramContext);
    }
    if (!Value.getInstance().isLogin()) {}
    while ((paramContext == null) || (this.isFinding)) {
      return;
    }
    this.isFinding = true;
    if (paramHandler != null) {
      paramHandler.sendEmptyMessage(1);
    }
    String str = URL_FINDROOM;
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(new BasicNameValuePair("sid", Value.getInstance().getSID()));
    ((List)localObject2).add(new BasicNameValuePair("lat", Value.getInstance().getLat()));
    ((List)localObject2).add(new BasicNameValuePair("lon", Value.getInstance().getLon()));
    ((List)localObject2).add(new BasicNameValuePair("ty", "com.pioong"));
    Object localObject1 = null;
    try
    {
      localObject2 = new UrlEncodedFormEntity((List)localObject2, "UTF-8");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    new HttpConnection(new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        case 0: 
        default: 
          return;
        case 2: 
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          Network.this.network_succeed_find_room(paramContext, paramAnonymousMessage, paramHandler);
          return;
        }
        Network.this.network_failed_find_room(paramContext, paramHandler);
      }
    }).post(str, (UrlEncodedFormEntity)localObject1);
  }
  
  public void login(Context paramContext)
  {
    if (Value.getInstance().isLogin()) {}
    while (paramContext == null) {
      return;
    }
    if (this.mUDID == null)
    {
      MayakUDID.syncContext(paramContext);
      this.mUDID = MayakUDID.getOpenUDIDInContext();
    }
    this.progDialog = new ProgressDialog(paramContext);
    this.progDialog.setProgressStyle(0);
    this.progDialog.setMessage(paramContext.getString(2131034123));
    this.progDialog.show();
    String str = URL_AUTH;
    Object localObject = new ArrayList();
    ((List)localObject).add(new BasicNameValuePair("udid", this.mUDID));
    try
    {
      localObject = new UrlEncodedFormEntity((List)localObject, "UTF-8");
      try
      {
        str = HttpConnection.post2(str, (UrlEncodedFormEntity)localObject);
        if (str != null) {
          break label140;
        }
        throw new Exception();
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    network_failed_login(paramContext);
    return;
    label140:
    network_succeed_login(paramContext, localException1);
  }
  
  public void network_failed_find_room(Context paramContext, Handler paramHandler)
  {
    try
    {
      Value.getInstance().setFindRoomFAIL();
      if (paramHandler != null) {
        paramHandler.sendEmptyMessage(3);
      }
      this.isFinding = false;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void network_failed_login(Context paramContext)
  {
    Value.getInstance().setLoginFAIL();
    this.progDialog.dismiss();
    this.progDialog = null;
    Toast.makeText(paramContext, paramContext.getString(2131034130), 0).show();
  }
  
  /* Error */
  public void network_succeed_find_room(Context paramContext, String paramString, Handler paramHandler)
  {
    // Byte code:
    //   0: new 236	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 237	org/json/JSONObject:<init>	()V
    //   7: pop
    //   8: new 236	org/json/JSONObject
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 240	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: ldc -14
    //   20: invokevirtual 246	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   23: invokestatic 251	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   26: astore 4
    //   28: aload 4
    //   30: ldc -3
    //   32: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +24 -> 59
    //   38: aload_1
    //   39: aload_1
    //   40: ldc_w 259
    //   43: invokevirtual 197	android/content/Context:getString	(I)Ljava/lang/String;
    //   46: iconst_0
    //   47: invokestatic 231	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   50: invokevirtual 232	android/widget/Toast:show	()V
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 69	com/pioong/global/Network:isFinding	Z
    //   58: return
    //   59: aload 4
    //   61: ldc_w 261
    //   64: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne +23 -> 90
    //   70: new 75	java/lang/Exception
    //   73: dup
    //   74: invokespecial 207	java/lang/Exception:<init>	()V
    //   77: athrow
    //   78: astore_2
    //   79: aload_3
    //   80: ifnull +161 -> 241
    //   83: aload_0
    //   84: aload_1
    //   85: aload_3
    //   86: invokevirtual 263	com/pioong/global/Network:network_failed_find_room	(Landroid/content/Context;Landroid/os/Handler;)V
    //   89: return
    //   90: aload_2
    //   91: ldc 102
    //   93: invokevirtual 266	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload_2
    //   99: ldc_w 268
    //   102: invokevirtual 266	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_2
    //   106: invokestatic 87	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
    //   109: aload 4
    //   111: invokevirtual 271	com/pioong/global/Value:setFindRoomOK	(Ljava/lang/String;)V
    //   114: aload_2
    //   115: ldc_w 261
    //   118: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifeq +32 -> 153
    //   124: aload_1
    //   125: ldc_w 272
    //   128: invokevirtual 197	android/content/Context:getString	(I)Ljava/lang/String;
    //   131: astore_2
    //   132: aload_3
    //   133: ifnull +14 -> 147
    //   136: aload_3
    //   137: aload_3
    //   138: iconst_2
    //   139: aload_2
    //   140: invokestatic 278	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   143: invokevirtual 282	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   146: pop
    //   147: aload_0
    //   148: iconst_0
    //   149: putfield 69	com/pioong/global/Network:isFinding	Z
    //   152: return
    //   153: aload_1
    //   154: ldc_w 283
    //   157: invokevirtual 197	android/content/Context:getString	(I)Ljava/lang/String;
    //   160: astore 4
    //   162: aload 4
    //   164: ldc_w 285
    //   167: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   170: ifeq +38 -> 208
    //   173: new 291	java/lang/StringBuilder
    //   176: dup
    //   177: aload 4
    //   179: invokestatic 295	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   182: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: ldc_w 298
    //   188: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 304
    //   198: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore_2
    //   205: goto -73 -> 132
    //   208: new 291	java/lang/StringBuilder
    //   211: dup
    //   212: aload_2
    //   213: invokestatic 295	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: ldc_w 308
    //   222: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 4
    //   227: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_2
    //   234: goto -102 -> 132
    //   237: astore_2
    //   238: goto -159 -> 79
    //   241: return
    //   242: astore_2
    //   243: ldc_w 261
    //   246: astore_2
    //   247: goto -141 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	Network
    //   0	250	1	paramContext	Context
    //   0	250	2	paramString	String
    //   0	250	3	paramHandler	Handler
    //   26	200	4	str	String
    // Exception table:
    //   from	to	target	type
    //   17	58	78	java/lang/Exception
    //   59	78	78	java/lang/Exception
    //   90	98	78	java/lang/Exception
    //   106	132	78	java/lang/Exception
    //   136	147	78	java/lang/Exception
    //   147	152	78	java/lang/Exception
    //   153	205	78	java/lang/Exception
    //   208	234	78	java/lang/Exception
    //   8	17	237	java/lang/Exception
    //   98	106	242	java/lang/Exception
  }
  
  public void network_succeed_login(Context paramContext, String paramString)
  {
    new JSONObject();
    try
    {
      localObject = new JSONObject(paramString);
      try
      {
        if (Integer.toString(((JSONObject)localObject).getInt("res")).equals("0")) {
          break label50;
        }
        throw new Exception();
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      Object localObject;
      for (;;) {}
    }
    network_failed_login(paramContext);
    return;
    label50:
    paramString = ((JSONObject)localObject).getString("sid");
    localObject = ((JSONObject)localObject).getString("hb");
    Value.getInstance().setLoginOK(paramString, (String)localObject);
    this.progDialog.dismiss();
    this.progDialog = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/global/Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */