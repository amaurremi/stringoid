package com.scoreloop.client.android.core.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NewsItemController
{
  public static final Policy a;
  public static final Policy b;
  public static final Policy c;
  public static final Policy d;
  private static final Set<String> e = new HashSet();
  
  static
  {
    a = new e();
    b = new f();
    c = new g();
    d = new ChainedPolicy(new Policy[] { c, b });
    Collections.addAll(e, new String[] { "image/png", "image/x-png", "image/jpeg" });
  }
  
  public static final class ChainedPolicy
    implements NewsItemController.Policy
  {
    NewsItemController.Policy[] a;
    
    ChainedPolicy(NewsItemController.Policy[] paramArrayOfPolicy)
    {
      this.a = paramArrayOfPolicy;
    }
  }
  
  public static abstract interface Policy {}
  
  public static final class RequestNextItemCanceledException
    extends RuntimeException
  {
    private static final long serialVersionUID = 1L;
  }
  
  public static enum State
  {
    private State() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/NewsItemController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */