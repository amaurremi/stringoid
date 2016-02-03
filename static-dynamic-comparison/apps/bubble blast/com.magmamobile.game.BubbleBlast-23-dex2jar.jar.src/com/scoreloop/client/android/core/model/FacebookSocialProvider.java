package com.scoreloop.client.android.core.model;

import android.content.Context;
import com.a.a.c;
import com.scoreloop.client.android.core.controller.FacebookSocialProviderController;
import com.scoreloop.client.android.core.controller.SocialProviderController;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSocialProvider
  extends SocialProvider
{
  private static c a;
  
  private void a(User paramUser, JSONObject paramJSONObject, Context paramContext)
  {
    if (paramUser == null) {
      throw new IllegalArgumentException();
    }
    boolean bool1 = isUserConnected(paramUser);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("facebook");
      paramUser.a(paramJSONObject, getIdentifier());
      boolean bool2 = isUserConnected(paramUser);
      if ((bool1 != bool2) && (bool2) && (c().c())) {
        c().b(paramContext);
      }
      return;
    }
    catch (JSONException paramUser)
    {
      throw new IllegalStateException(paramUser);
    }
  }
  
  public static c b()
  {
    if (a == null) {
      a = c.a("95076661cafb5979188d7a687991d339", "f78b158bfc03c4859b7076bd66e9cd3c", null);
    }
    return a;
  }
  
  public Class<? extends SocialProviderController> a()
  {
    return FacebookSocialProviderController.class;
  }
  
  public void a(User paramUser, Long paramLong, Context paramContext)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("uid", paramLong);
      localJSONObject2.put("facebook", localJSONObject1);
      a(paramUser, localJSONObject2, paramContext);
      return;
    }
    catch (JSONException paramUser)
    {
      throw new IllegalStateException(paramUser);
    }
  }
  
  public c c()
  {
    return b();
  }
  
  /* Error */
  protected void d(User paramUser, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +11 -> 16
    //   8: new 16	java/lang/IllegalArgumentException
    //   11: dup
    //   12: invokespecial 17	java/lang/IllegalArgumentException:<init>	()V
    //   15: athrow
    //   16: aload_1
    //   17: invokevirtual 90	com/scoreloop/client/android/core/model/User:h	()Lorg/json/JSONObject;
    //   20: ifnull +46 -> 66
    //   23: new 25	org/json/JSONObject
    //   26: dup
    //   27: invokespecial 72	org/json/JSONObject:<init>	()V
    //   30: astore 5
    //   32: aload_1
    //   33: invokevirtual 90	com/scoreloop/client/android/core/model/User:h	()Lorg/json/JSONObject;
    //   36: ldc 74
    //   38: invokevirtual 94	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   41: lstore_3
    //   42: aload 5
    //   44: ldc 74
    //   46: lload_3
    //   47: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   50: invokevirtual 103	java/lang/Long:toString	()Ljava/lang/String;
    //   53: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   56: pop
    //   57: aload_2
    //   58: ldc 23
    //   60: aload 5
    //   62: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   65: pop
    //   66: return
    //   67: astore_1
    //   68: new 53	java/lang/IllegalStateException
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 56	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   76: athrow
    //   77: astore_1
    //   78: new 53	java/lang/IllegalStateException
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 56	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_1
    //   88: new 53	java/lang/IllegalStateException
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 56	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: astore_1
    //   98: new 53	java/lang/IllegalStateException
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 56	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	FacebookSocialProvider
    //   0	107	1	paramUser	User
    //   0	107	2	paramJSONObject	JSONObject
    //   41	6	3	l	long
    //   30	31	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   32	42	67	org/json/JSONException
    //   42	57	77	java/lang/NullPointerException
    //   42	57	87	org/json/JSONException
    //   57	66	97	org/json/JSONException
  }
  
  public String getIdentifier()
  {
    return "com.facebook.v1";
  }
  
  public boolean isUserConnected(User paramUser)
  {
    return paramUser.h() != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/FacebookSocialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */