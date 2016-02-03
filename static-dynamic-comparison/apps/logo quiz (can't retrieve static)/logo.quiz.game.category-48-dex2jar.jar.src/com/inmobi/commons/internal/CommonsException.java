package com.inmobi.commons.internal;

public class CommonsException
  extends Exception
{
  public static final int APPLICATION_NOT_SET = 1;
  public static final int PRODUCT_NOT_FOUND = 2;
  private static final long serialVersionUID = 3805362231723549913L;
  private int a;
  
  public CommonsException(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getCode()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/CommonsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */