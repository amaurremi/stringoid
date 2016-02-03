package com.tapjoy;

public class TJEventRequest
{
  public static final int TYPE_CURRENCY = 3;
  public static final int TYPE_IN_APP_PURCHASE = 1;
  public static final int TYPE_NAVIGATION = 4;
  public static final int TYPE_VIRTUAL_GOOD = 2;
  public TJEventRequestCallback callback;
  public String identifier;
  public int quantity;
  public int type;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJEventRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */