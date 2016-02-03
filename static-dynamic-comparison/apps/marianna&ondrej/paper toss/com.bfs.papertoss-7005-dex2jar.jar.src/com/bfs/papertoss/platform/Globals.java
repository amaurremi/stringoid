package com.bfs.papertoss.platform;

import android.content.Context;
import android.os.Handler;
import com.bfs.papertoss.PaperTossActivity;
import com.bfs.papertoss.cpp.TextureMgr;
import javax.microedition.khronos.opengles.GL10;

public class Globals
{
  public static GL10 GL;
  public static boolean HI_RES;
  public static boolean PAPAYA_SHOW = false;
  public static float SCALE_FACTOR;
  public static int STARTS_ANY_VERSION;
  public static int SURFACE_H;
  public static int VIEWPORT_H;
  public static int VIEWPORT_W;
  public static int VIEWPORT_X;
  public static int VIEWPORT_Y;
  public static boolean first_launch;
  public static PaperTossActivity m_activity = null;
  public static Context m_context = null;
  public static Handler mainHandler;
  public static SoundMgr soundMgr;
  public static TextureMgr texture_mgr;
  
  static
  {
    GL = null;
    texture_mgr = new TextureMgr();
    first_launch = true;
    mainHandler = null;
    soundMgr = null;
    STARTS_ANY_VERSION = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/platform/Globals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */