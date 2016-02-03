package com.chartboost.sdk.impl;

import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class y
  extends al
{
  static final Logger a = Logger.getLogger("com.mongodb");
  static final boolean b = Boolean.getBoolean("DEBUG.MONGO");
  public static final ByteOrder c;
  static final int d;
  static final bd e;
  
  static
  {
    if (a.getLevel() == null)
    {
      if (!b) {
        break label73;
      }
      a.setLevel(Level.ALL);
    }
    for (;;)
    {
      c = ByteOrder.LITTLE_ENDIAN;
      d = Integer.parseInt(System.getProperty("MONGO.POOLSIZE", "10"));
      e = new bd(-1, -1, -1);
      return;
      label73:
      a.setLevel(Level.WARNING);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */