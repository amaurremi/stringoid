package com.scoreloop.client.android.core.model;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AwardList
{
  private String a;
  private List<Award> b = new ArrayList();
  private Map<String, Award> c = new HashMap();
  
  public static AwardList a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      throw new IllegalArgumentException("you have to provide context and a game");
    }
    return new a(paramContext).a(paramString);
  }
  
  public Award a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("identifier argument must not be null");
    }
    Award localAward = (Award)this.c.get(paramString);
    if (localAward == null) {
      throw new IllegalArgumentException("invalid identifier: " + paramString);
    }
    return localAward;
  }
  
  public String a()
  {
    return this.a;
  }
  
  void a(Award paramAward)
  {
    String str = paramAward.a();
    if (this.c.containsKey(str)) {
      throw new IllegalStateException("award with same identifier already added");
    }
    this.b.add(paramAward);
    this.c.put(str, paramAward);
  }
  
  public List<Award> b()
  {
    return this.b;
  }
  
  void b(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/AwardList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */