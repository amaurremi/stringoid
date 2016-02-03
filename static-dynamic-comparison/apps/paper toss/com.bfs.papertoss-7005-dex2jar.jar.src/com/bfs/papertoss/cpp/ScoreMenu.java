package com.bfs.papertoss.cpp;

import com.bfs.papertoss.PaperTossApplication;
import com.bfs.papertoss.platform.Evt;
import com.bfs.papertoss.platform.EvtListener;
import com.bfs.papertoss.vector.v2f;
import com.bfs.papertoss.vector.v2i;
import com.bfs.papertoss.vector.v3f;
import com.bfs.papertoss.vector.v4f;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

public class ScoreMenu
{
  static v4f SCORE_COLOR = null;
  static final String SCORE_FONT = "zerothre";
  static final int SCORE_FONT_SIZE = 24;
  static final int SCORE_GLYPH_OFFSET = -32;
  private final int ACTIVE = 1;
  private final int NONE = 0;
  v2i m_back_pos = new v2i();
  v2f m_back_size = new v2f();
  Sprite m_background = null;
  private String m_background_filename;
  v2i[] m_name_pos = new v2i[LevelDefs.NUM_LEVELS];
  v2f[] m_name_size = new v2f[LevelDefs.NUM_LEVELS];
  Sprite[] m_score = new Sprite[LevelDefs.NUM_LEVELS];
  v2i[] m_score_pos = new v2i[LevelDefs.NUM_LEVELS];
  int m_state = 0;
  OnPtrUp onPtrUp = new OnPtrUp(null);
  
  public ScoreMenu()
  {
    SCORE_COLOR = new v4f(0.0F, 1.0F, 0.0F, 1.0F);
    Evt.getInstance().subscribe("onPtrUp", this.onPtrUp);
    int i = 0;
    while (i < LevelDefs.NUM_LEVELS)
    {
      this.m_score[i] = null;
      this.m_name_pos[i] = new v2i(0, 0);
      this.m_name_size[i] = new v2f(0.0F, 0.0F);
      this.m_score_pos[i] = new v2i(0, 0);
      i += 1;
    }
  }
  
  void activate()
  {
    if (this.m_state == 0) {
      this.m_state = 1;
    }
  }
  
  void create(String paramString, v2i paramv2i, v2f paramv2f)
  {
    this.m_background = new Sprite(paramString, new v2i(), 0.0F, false, 0);
    this.m_background_filename = paramString;
    this.m_back_pos = paramv2i;
    this.m_back_size = paramv2f;
  }
  
  void deactivate()
  {
    if (this.m_state == 1) {
      this.m_state = 0;
    }
  }
  
  void destroy()
  {
    Sprite.killSprite(this.m_background);
    this.m_background = null;
    int i = 0;
    while (i < LevelDefs.NUM_LEVELS)
    {
      Sprite.killSprite(this.m_score[i]);
      this.m_score[i] = null;
      i += 1;
    }
  }
  
  void render(v2f paramv2f)
  {
    try
    {
      paramv2f = new v3f(paramv2f.x, paramv2f.y, 0.0F);
      this.m_background.draw(new v3f(160.0F, 240.0F, 449.9F).plus(paramv2f), new v2f(1.0F, 1.0F), new v3f(0.0F, 0.0F, 0.0F), new v4f(1.0F, 1.0F, 1.0F, 1.0F));
      int i = 0;
      Object localObject;
      while (i < LevelDefs.NUM_LEVELS)
      {
        if (this.m_score[i] != null)
        {
          int j = (int)paramv2f.x;
          int k = (int)paramv2f.y;
          localObject = this.m_score_pos[i].plus(new v2i(j, k));
          localObject = new v3f(((v2i)localObject).x, ((v2i)localObject).y);
          this.m_score[i].draw((v3f)localObject, new v2f(1.0F, 1.0F), new v3f(0.0F, 0.0F, 0.0F), new v4f(1.0F, 1.0F, 1.0F, 1.0F));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramv2f)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("Trace", PaperTossApplication.getFirstLineOfException(paramv2f));
      FlurryAgent.onEvent("ScoreMenuRenderError", (Map)localObject);
    }
  }
  
  void setBest(int paramInt1, int paramInt2)
  {
    if (!this.m_score_pos[paramInt1].equals(new v3f(0.0F, 0.0F, 0.0F)))
    {
      Sprite.killSprite(this.m_score[paramInt1]);
      this.m_score[paramInt1] = new Sprite(24, -32, "zerothre", "" + paramInt2, SCORE_COLOR, 0);
    }
  }
  
  void setLevel(int paramInt, v2i paramv2i1, v2f paramv2f, v2i paramv2i2)
  {
    this.m_name_pos[paramInt] = paramv2i1;
    this.m_name_size[paramInt] = paramv2f;
    this.m_score_pos[paramInt] = paramv2i2;
  }
  
  public void unDestroy()
  {
    this.m_background = new Sprite(this.m_background_filename);
    int i = 0;
    while (i < LevelDefs.NUM_LEVELS)
    {
      this.m_score[i] = new Sprite(24, -32, "zerothre", "" + Scores.readBest(i), SCORE_COLOR, 0);
      i += 1;
    }
  }
  
  void update(float paramFloat) {}
  
  private class OnPtrUp
    implements EvtListener
  {
    private OnPtrUp() {}
    
    public void run(Object paramObject)
    {
      Evt localEvt;
      if (ScoreMenu.this.m_state == 1)
      {
        paramObject = (v2f)paramObject;
        localEvt = Evt.getInstance();
        if (!Sprite.pointInRect((v2f)paramObject, new v2f(ScoreMenu.this.m_back_pos), ScoreMenu.this.m_back_size)) {
          break label63;
        }
        localEvt.publish("paperTossPlaySound", "Computer.wav");
        localEvt.publish("gotoMenu");
      }
      for (;;)
      {
        return;
        label63:
        int i = 0;
        while (i < LevelDefs.NUM_LEVELS)
        {
          if ((!ScoreMenu.this.m_name_pos[i].equalsZero()) && (Sprite.pointInRect((v2f)paramObject, new v2f(ScoreMenu.this.m_name_pos[i]), ScoreMenu.this.m_name_size[i])))
          {
            localEvt.publish("paperTossPlaySound", "Computer.wav");
            localEvt.publish("showScores", Integer.valueOf(i));
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/ScoreMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */