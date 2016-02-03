package com.bfs.papertoss.cpp;

import com.bfs.papertoss.platform.Evt;
import com.bfs.papertoss.platform.EvtListener;
import com.bfs.papertoss.platform.Random;
import com.bfs.papertoss.vector.v2f;
import com.bfs.papertoss.vector.v3f;
import com.bfs.papertoss.vector.v4f;

public class Fireworks
{
  static final float FW_DUR = 1.1333333F;
  static final float FW_NO_WAIT = -100000.0F;
  static final float FW_WAIT_DELAY = 0.25F;
  static v4f[] colors = { new v4f(1.0F, 0.0F, 0.0F, 1.0F), new v4f(1.0F, 1.0F, 0.0F, 1.0F), new v4f(0.0F, 1.0F, 0.0F, 1.0F), new v4f(0.0F, 1.0F, 1.0F, 1.0F), new v4f(0.0F, 0.0F, 1.0F, 1.0F), new v4f(1.0F, 0.0F, 1.0F, 1.0F), new v4f(0.5F, 1.0F, 0.0F, 1.0F), new v4f(1.0F, 1.0F, 1.0F, 1.0F) };
  static final Firework default_firework;
  static Firework[] fireworks;
  static boolean fireworks_active = false;
  static Fireworks m_instance = null;
  static final int num_colors = 8;
  DrawFireworks drawFireworks = new DrawFireworks();
  public StartFireworks startFireworks = new StartFireworks();
  public StopFireworks stopFireworks = new StopFireworks();
  UpdateFireworks updateFireworks = new UpdateFireworks();
  
  static
  {
    fireworks_active = false;
    default_firework = new Firework(new v3f(0.0F, 0.0F, 0.0F), new v4f(0.0F, 0.0F, 0.0F, 1.0F), 1.0F, -100000.0F, null);
    fireworks = new Firework[] { default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, default_firework, new Firework(new v3f(0.0F, 0.0F, 0.0F), new v4f(0.0F, 0.0F, 0.0F, 0.0F), 0.0F, -100000.0F, null) };
  }
  
  public static void initializeFireworks()
  {
    if (m_instance == null) {
      m_instance = new Fireworks();
    }
    Evt localEvt = Evt.getInstance();
    localEvt.subscribe("startFireworks", m_instance.startFireworks);
    localEvt.subscribe("stopFireworks", m_instance.stopFireworks);
    localEvt.subscribe("updateFireworks", m_instance.updateFireworks);
    localEvt.subscribe("drawFireworks", m_instance.drawFireworks);
  }
  
  public class DrawFireworks
    implements EvtListener
  {
    public DrawFireworks() {}
    
    public void run(Object paramObject)
    {
      if (Fireworks.fireworks_active)
      {
        int i = 0;
        for (paramObject = Fireworks.fireworks[0]; ((Fireworks.Firework)paramObject).scale != 0.0F; paramObject = paramObject[i])
        {
          if (((Fireworks.Firework)paramObject).sprite != null) {
            ((Fireworks.Firework)paramObject).sprite.draw(((Fireworks.Firework)paramObject).pos, new v2f(((Fireworks.Firework)paramObject).scale, ((Fireworks.Firework)paramObject).scale), new v3f(0.0F, 0.0F, 0.0F), ((Fireworks.Firework)paramObject).color);
          }
          paramObject = Fireworks.fireworks;
          i += 1;
        }
      }
    }
  }
  
  public static class Firework
  {
    v4f color = new v4f();
    v3f pos = new v3f();
    float scale;
    Sprite sprite;
    float wait;
    
    public Firework(v3f paramv3f, v4f paramv4f, float paramFloat1, float paramFloat2, Sprite paramSprite)
    {
      this.pos = paramv3f;
      this.color = paramv4f;
      this.scale = paramFloat1;
      this.wait = paramFloat2;
      this.sprite = paramSprite;
    }
  }
  
  public class StartFireworks
    implements EvtListener
  {
    public StartFireworks() {}
    
    public void run(Object paramObject)
    {
      if (!Fireworks.fireworks_active)
      {
        float f = 0.25F;
        int i = 0;
        for (paramObject = Fireworks.fireworks[0]; ((Fireworks.Firework)paramObject).scale != 0.0F; paramObject = paramObject[i])
        {
          ((Fireworks.Firework)paramObject).pos = new v3f(Random.randomi(20, 300), Random.randomi(290, 460), 0.0F);
          ((Fireworks.Firework)paramObject).color = Fireworks.colors[Random.randomi(0, 7)];
          ((Fireworks.Firework)paramObject).scale = Random.randomf(0.75F, 3.0F);
          ((Fireworks.Firework)paramObject).wait = f;
          f += 0.25F;
          paramObject = Fireworks.fireworks;
          i += 1;
        }
        Fireworks.fireworks_active = true;
      }
    }
  }
  
  public class StopFireworks
    implements EvtListener
  {
    public StopFireworks() {}
    
    public void run(Object paramObject)
    {
      if (Fireworks.fireworks_active)
      {
        int i = 0;
        for (paramObject = Fireworks.fireworks[0]; ((Fireworks.Firework)paramObject).scale != 0.0F; paramObject = paramObject[i])
        {
          ((Fireworks.Firework)paramObject).wait = -100000.0F;
          Sprite.killSprite(((Fireworks.Firework)paramObject).sprite);
          paramObject = Fireworks.fireworks;
          i += 1;
        }
        Fireworks.fireworks_active = false;
      }
    }
  }
  
  public class UpdateFireworks
    implements EvtListener
  {
    public UpdateFireworks() {}
    
    public void run(Object paramObject)
    {
      double d = ((Double)paramObject).doubleValue();
      if (Fireworks.fireworks_active)
      {
        Fireworks.fireworks_active = false;
        int i = 0;
        paramObject = Fireworks.fireworks[0];
        if (((Fireworks.Firework)paramObject).scale != 0.0F)
        {
          label83:
          boolean bool2;
          if (((Fireworks.Firework)paramObject).wait <= 0.0F)
          {
            ((Fireworks.Firework)paramObject).wait = ((float)(((Fireworks.Firework)paramObject).wait - d));
            if (Math.abs(((Fireworks.Firework)paramObject).wait) >= 0.56666666F)
            {
              Sprite.killSprite(((Fireworks.Firework)paramObject).sprite);
              ((Fireworks.Firework)paramObject).wait = -100000.0F;
              bool2 = Fireworks.fireworks_active;
              if (((Fireworks.Firework)paramObject).wait == -100000.0F) {
                break label169;
              }
            }
          }
          label169:
          for (boolean bool1 = true;; bool1 = false)
          {
            Fireworks.fireworks_active = bool1 | bool2;
            paramObject = Fireworks.fireworks;
            i += 1;
            paramObject = paramObject[i];
            break;
            ((Fireworks.Firework)paramObject).sprite.update((float)d);
            break label83;
            ((Fireworks.Firework)paramObject).wait = ((float)(((Fireworks.Firework)paramObject).wait - d));
            if (((Fireworks.Firework)paramObject).wait > 0.0F) {
              break label83;
            }
            ((Fireworks.Firework)paramObject).wait = 0.0F;
            break label83;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/Fireworks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */