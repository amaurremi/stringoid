package com.bfs.papertoss;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import com.bfs.papertoss.platform.Evt;
import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.vector.v2f;

public class PapertossGLSurfaceView
  extends GLSurfaceView
{
  private Evt evt;
  private PapertossRenderer renderer = new PapertossRenderer();
  
  public PapertossGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    setRenderer(this.renderer);
    this.evt = Evt.getInstance();
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        f1 = paramMotionEvent.getX();
        float f2 = Globals.SURFACE_H;
        float f3 = paramMotionEvent.getY();
        if (Globals.HI_RES)
        {
          f1 = Globals.VIEWPORT_X + 12.873565F + 294.25287F / Globals.VIEWPORT_W * f1;
          final v2f localv2f = new v2f(f1, Globals.VIEWPORT_Y + 480.0F / Globals.VIEWPORT_H * (f2 - f3));
          String str = "";
          int i = paramMotionEvent.getAction();
          switch (i)
          {
          case 1: 
            Log.e("BFS", String.format("Something very weird is up with touch events: %X", new Object[] { Integer.valueOf(i) }));
            paramMotionEvent = str;
            queueEvent(new Runnable()
            {
              public void run()
              {
                try
                {
                  PapertossGLSurfaceView.this.evt.publish(paramMotionEvent, localv2f);
                  return;
                }
                catch (Exception localException)
                {
                  PaperTossApplication.logErrorWithFlurry("onTouchEvent", localException, "PapertossGLSurfaceView");
                }
              }
            });
          }
        }
      }
      catch (Exception paramMotionEvent)
      {
        float f1;
        PaperTossApplication.logErrorWithFlurry("onTouchEvent", paramMotionEvent, "PapertossGLSurfaceView");
        continue;
      }
      try
      {
        Thread.sleep(20L);
        return true;
      }
      catch (InterruptedException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
        return true;
      }
      f1 = Globals.VIEWPORT_X + 320.0F / Globals.VIEWPORT_W * f1;
      continue;
      paramMotionEvent = "onPtrUp";
      continue;
      continue;
      paramMotionEvent = "onPtrDown";
      continue;
      paramMotionEvent = "onPtrMove";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/PapertossGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */