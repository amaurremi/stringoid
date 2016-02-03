package com.magmamobile.tool.debugTool;

import java.io.Serializable;

public final class DebugTool
{
  public static final int ACTION_ATLAS = 11000000;
  public static final int ACTION_ATLAS_HIDE = 11000002;
  public static final int ACTION_ATLAS_NEXT = 11000003;
  public static final int ACTION_ATLAS_PREV = 11000004;
  public static final int ACTION_ATLAS_SHOW = 11000001;
  public static final int ACTION_ENGINE = 10000000;
  public static final int ACTION_ENGINE_QUIT = 10000001;
  public static final int ACTION_RATE = 12000000;
  public static final int ACTION_RATE_ACTION = 12100000;
  public static final int ACTION_RATE_ACTION_FAST = 12100001;
  public static final int ACTION_RATE_ACTION_NORMAL = 12100002;
  public static final int ACTION_RATE_ACTION_SLOW = 12100003;
  public static final int ACTION_RATE_RENDER = 12200000;
  public static final int ACTION_RATE_RENDER_FAST = 12200001;
  public static final int ACTION_RATE_RENDER_NORMAL = 12200002;
  public static final int ACTION_RATE_RENDER_SLOW = 12200003;
  public static final String DEBUG_MESSAGE = "com.magmamobile.debugtool";
  public static final String EXTRA_PARAMS = "params";
  public static final String EXTRA_PNAME = "pname";
  public static final String EXTRA_TAG = "tag";
  
  public static class MenuItem2
    implements Serializable
  {
    public String name;
    public int tag;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/tool/debugTool/DebugTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */