package com.bfs.papertoss;

import android.opengl.GLSurfaceView.Renderer;
import com.backflipstudios.android.debug.BFSDebug;
import com.bfs.papertoss.cpp.Papertoss;
import com.bfs.papertoss.platform.Evt;
import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.platform.Util;
import com.flurry.android.FlurryAgent;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PapertossRenderer
  implements GLSurfaceView.Renderer
{
  double m_time = Util.getTime();
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      Globals.GL = paramGL10;
      double d1 = Util.getTime();
      double d2 = this.m_time;
      this.m_time = d1;
      Papertoss.update(d1 - d2);
      if (Globals.HI_RES) {
        Globals.GL.glClear(16384);
      }
      Papertoss.render();
      return;
    }
    catch (Exception paramGL10)
    {
      PaperTossApplication.logErrorWithFlurry("onDrawFrame", paramGL10, "PapertossRenderer");
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    BFSDebug.i("PaperTossRenderer.onSurfaceChanged(): " + paramInt1 + "x" + paramInt2);
    Globals.GL = paramGL10;
    Globals.VIEWPORT_W = paramInt1;
    Globals.VIEWPORT_H = paramInt2;
    Globals.VIEWPORT_X = 0;
    Globals.VIEWPORT_Y = 0;
    Globals.SURFACE_H = paramInt2;
    Globals.GL.glViewport(Globals.VIEWPORT_X, Globals.VIEWPORT_Y, Globals.VIEWPORT_W, Globals.VIEWPORT_H);
    Globals.GL.glTexParameterf(3553, 10242, 33071.0F);
    Globals.GL.glTexParameterf(3553, 10243, 33071.0F);
    Globals.GL.glClear(16384);
    Evt.getInstance().publish("sizeGl");
    if (paramInt2 > 480)
    {
      FlurryAgent.onEvent("HiRes");
      return;
    }
    if (paramInt2 < 480)
    {
      FlurryAgent.onEvent("TinyRes");
      return;
    }
    FlurryAgent.onEvent("LoRes");
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    try
    {
      Globals.GL = paramGL10;
      Papertoss.initialize();
      Papertoss.unShutdown();
      Globals.GL.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      if (Globals.first_launch)
      {
        Papertoss.activate();
        Globals.first_launch = false;
      }
      return;
    }
    catch (Exception paramGL10)
    {
      BFSDebug.e("PaperTossRenderer.onSurfaceCreated", paramGL10);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/PapertossRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */