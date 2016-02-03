package com.pioong.global;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.Settings.Secure;
import com.pioong.msgadapter.ChatMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Value
{
  private static Value _instance = null;
  private boolean bChatting = false;
  private boolean bLogin = false;
  public ArrayList<ChatMessage> mArrChatting = new ArrayList();
  private String mLat = "";
  private String mLon = "";
  private String mRoomNo = "";
  private String mSID = "";
  private String pcip = "";
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = (byte[])null;
    try
    {
      Class localClass = Class.forName("org.apache.commons.codec.binary.Base64");
      paramArrayOfByte = (byte[])localClass.getMethod("encodeBase64", new Class[] { byte[].class }).invoke(localClass, new Object[] { paramArrayOfByte });
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return arrayOfByte;
  }
  
  public static Value getInstance()
  {
    try
    {
      if (_instance == null) {
        _instance = new Value();
      }
      Value localValue = _instance;
      return localValue;
    }
    finally {}
  }
  
  public void chkLocService(final Context paramContext)
  {
    Object localObject = Settings.Secure.getString(paramContext.getContentResolver(), "location_providers_allowed");
    if (localObject == null) {}
    while (((String)localObject).indexOf("network", 0) >= 0) {
      return;
    }
    localObject = new AlertDialog.Builder(paramContext);
    ((AlertDialog.Builder)localObject).setMessage(paramContext.getString(2131034115)).setCancelable(false).setPositiveButton(paramContext.getString(2131034116), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        paramAnonymousDialogInterface.addCategory("android.intent.category.DEFAULT");
        paramContext.startActivity(paramAnonymousDialogInterface);
      }
    });
    ((AlertDialog.Builder)localObject).create().show();
  }
  
  public void exitRoom()
  {
    this.mRoomNo = "";
    this.bChatting = false;
  }
  
  public String getIP()
  {
    return this.pcip;
  }
  
  public String getLat()
  {
    return this.mLat;
  }
  
  public String getLon()
  {
    return this.mLon;
  }
  
  public String getRoomNo()
  {
    return this.mRoomNo;
  }
  
  public String getSID()
  {
    return this.mSID;
  }
  
  public boolean isChatting()
  {
    return this.bChatting;
  }
  
  public boolean isLogin()
  {
    return this.bLogin;
  }
  
  public void setFindRoomFAIL()
  {
    this.mRoomNo = "";
    this.bChatting = false;
  }
  
  public void setFindRoomOK(String paramString)
  {
    this.mRoomNo = paramString;
    this.bChatting = true;
  }
  
  public void setIP(String paramString)
  {
    this.pcip = paramString;
  }
  
  /* Error */
  public void setLocation(android.location.Location arg1)
  {
    // Byte code:
    //   0: ldc -99
    //   2: astore_3
    //   3: ldc -99
    //   5: astore_2
    //   6: aload_1
    //   7: ifnull +25 -> 32
    //   10: aload_1
    //   11: invokevirtual 163	android/location/Location:getLatitude	()D
    //   14: invokestatic 169	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   17: invokevirtual 172	java/lang/Double:toString	()Ljava/lang/String;
    //   20: astore_3
    //   21: aload_1
    //   22: invokevirtual 175	android/location/Location:getLongitude	()D
    //   25: invokestatic 169	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   28: invokevirtual 172	java/lang/Double:toString	()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 42	com/pioong/global/Value:mLat	Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: aload_0
    //   40: new 100	java/lang/String
    //   43: dup
    //   44: aload_3
    //   45: ldc -79
    //   47: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   50: invokestatic 183	com/pioong/global/Value:encodeBase64	([B)[B
    //   53: invokespecial 186	java/lang/String:<init>	([B)V
    //   56: putfield 42	com/pioong/global/Value:mLat	Ljava/lang/String;
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_0
    //   62: getfield 44	com/pioong/global/Value:mLon	Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: new 100	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: ldc -79
    //   76: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   79: invokestatic 183	com/pioong/global/Value:encodeBase64	([B)[B
    //   82: invokespecial 186	java/lang/String:<init>	([B)V
    //   85: putfield 44	com/pioong/global/Value:mLon	Ljava/lang/String;
    //   88: aload_1
    //   89: monitorexit
    //   90: return
    //   91: astore_2
    //   92: aload_1
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    //   96: astore_1
    //   97: return
    //   98: astore_2
    //   99: aload_1
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	Value
    //   5	69	2	str1	String
    //   91	4	2	localObject1	Object
    //   98	4	2	localObject2	Object
    //   2	43	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   39	61	91	finally
    //   92	94	91	finally
    //   32	39	96	java/io/UnsupportedEncodingException
    //   61	68	96	java/io/UnsupportedEncodingException
    //   94	96	96	java/io/UnsupportedEncodingException
    //   101	103	96	java/io/UnsupportedEncodingException
    //   68	90	98	finally
    //   99	101	98	finally
  }
  
  public void setLoginFAIL()
  {
    this.mSID = "";
    this.pcip = "";
    this.bLogin = false;
  }
  
  public void setLoginOK(String paramString1, String paramString2)
  {
    this.mSID = paramString1;
    this.pcip = paramString2;
    this.bLogin = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/global/Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */