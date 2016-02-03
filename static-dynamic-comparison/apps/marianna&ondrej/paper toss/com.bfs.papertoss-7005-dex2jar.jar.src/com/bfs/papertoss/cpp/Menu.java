package com.bfs.papertoss.cpp;

import android.content.Intent;
import android.os.Handler;
import com.backflipstudios.android.web.BFSWebViewActivity;
import com.bfs.papertoss.PaperTossActivity;
import com.bfs.papertoss.PaperTossApplication;
import com.bfs.papertoss.platform.Evt;
import com.bfs.papertoss.platform.EvtListener;
import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.vector.v2f;
import com.bfs.papertoss.vector.v3f;
import com.bfs.papertoss.vector.v4f;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

public class Menu
{
  private static final int ACTIVE = 1;
  static v4f EXIT_COLOR;
  static final String EXIT_FILENAME = "Exit.png";
  static v3f EXIT_POS;
  static final v4f GREYED_OUT_COLOR = new v4f(0.33F, 0.33F, 0.33F, 1.0F);
  static float MENU_POPUP_DELAY = 0.0F;
  static float MENU_POPUP_DUR = 0.0F;
  static final float NEW_LEVEL_BLINK_DUR = 1.0F;
  private static final int NONE = 0;
  static v4f PRIVACY_BTN_COLOR = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
  static v3f PRIVACY_BTN_POS = new v3f(76.0F, 65.0F);
  static final String SCORE_FONT = "zerothre";
  public static final int SCORE_FONT_SIZE = 14;
  static final int SCORE_GLYPH_OFFSET = -32;
  static v4f SELECTION_COLOR;
  static v4f SOUND_COLOR;
  static String SOUND_FONT;
  static int SOUND_FONT_SIZE;
  static int SOUND_GLYPH_OFFSET;
  static v3f SOUND_POS;
  static final v4f UNSELECTION_COLOR = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
  Sprite m_background = null;
  String m_background_filename;
  int m_destroy_state;
  Sprite m_exit = null;
  v4f m_exit_color = new v4f();
  Sprite[] m_level_button = new Sprite[LevelDefs.NUM_LEVELS];
  v4f[] m_level_button_color = new v4f[LevelDefs.NUM_LEVELS];
  float[] m_level_button_delay = new float[LevelDefs.NUM_LEVELS];
  String[] m_level_button_filenames = new String[LevelDefs.NUM_LEVELS];
  v3f[] m_level_button_pos = new v3f[LevelDefs.NUM_LEVELS];
  float[] m_level_button_scale = new float[LevelDefs.NUM_LEVELS];
  float[] m_level_button_time = new float[LevelDefs.NUM_LEVELS];
  Sprite[] m_level_score = new Sprite[LevelDefs.NUM_LEVELS];
  String[] m_level_score_filenames = new String[LevelDefs.NUM_LEVELS];
  v3f[] m_level_score_pos = new v3f[LevelDefs.NUM_LEVELS];
  int m_new_level = -1;
  float m_new_level_timer;
  Sprite m_papaya_btn;
  Sprite m_privacy_btn;
  v4f m_privacy_btn_color = new v4f();
  Sprite m_scores = null;
  v4f m_scores_color = new v4f();
  String m_scores_filename;
  v3f m_scores_pos = new v3f();
  int m_selected_level = -1;
  Sprite m_sound = null;
  v4f m_sound_color = new v4f();
  boolean m_sound_on = false;
  int m_state = 0;
  OnPtrDown onPtrDown = new OnPtrDown(null);
  OnPtrUp onPtrUp = new OnPtrUp(null);
  
  public Menu()
  {
    EXIT_COLOR = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    SOUND_COLOR = new v4f(1.0F, 0.0F, 0.0F, 1.0F);
    if (Globals.HI_RES)
    {
      SOUND_POS = new v3f(277.0F, 376.0F);
      SOUND_FONT_SIZE = 18;
    }
    for (EXIT_POS = new v3f(278.0F, 420.0F);; EXIT_POS = new v3f(283.0F, 455.0F))
    {
      SOUND_GLYPH_OFFSET = -29;
      SOUND_FONT = "fawn";
      SELECTION_COLOR = new v4f(0.6F, 0.6F, 0.7F, 1.0F);
      MENU_POPUP_DUR = 0.0F;
      MENU_POPUP_DELAY = 0.0F;
      Evt localEvt = Evt.getInstance();
      localEvt.subscribe("onPtrDown", this.onPtrDown);
      localEvt.subscribe("onPtrUp", this.onPtrUp);
      int i = 0;
      while (i < LevelDefs.NUM_LEVELS)
      {
        this.m_level_button[i] = null;
        this.m_level_button_color[i] = UNSELECTION_COLOR;
        this.m_level_button_pos[i] = new v3f(0.0F, 0.0F, 0.0F);
        this.m_level_button_scale[i] = 0.0F;
        this.m_level_button_time[i] = 0.0F;
        this.m_level_button_delay[i] = (i * MENU_POPUP_DELAY);
        this.m_level_score[i] = null;
        this.m_level_score_pos[i] = new v3f(0.0F, 0.0F, 0.0F);
        i += 1;
      }
      SOUND_POS = new v3f(283.0F, 376.0F);
      SOUND_FONT_SIZE = 20;
    }
  }
  
  void activate()
  {
    if (this.m_state == 0) {
      this.m_state = 1;
    }
  }
  
  void create(String paramString1, String paramString2, v3f paramv3f, boolean paramBoolean)
  {
    destroy();
    this.m_exit_color = EXIT_COLOR;
    this.m_sound_color = SOUND_COLOR;
    this.m_scores_pos = paramv3f;
    this.m_background_filename = paramString1;
    this.m_background = new Sprite(paramString1);
    this.m_scores_filename = paramString2;
    this.m_scores = new Sprite(paramString2);
    this.m_exit = new Sprite("Exit.png");
    setSound(paramBoolean);
    this.m_papaya_btn = new Sprite("papaya_btn_main.png");
    this.m_privacy_btn = new Sprite("privacy_btn_main.png");
  }
  
  void deactivate()
  {
    if (this.m_state == 1)
    {
      this.m_state = 0;
      int i = 0;
      while (i < LevelDefs.NUM_LEVELS)
      {
        this.m_level_button_scale[i] = 0.0F;
        this.m_level_button_time[i] = 0.0F;
        this.m_level_button_delay[i] = (i * MENU_POPUP_DELAY);
        i += 1;
      }
    }
  }
  
  void destroy()
  {
    int i = 0;
    while (i < LevelDefs.NUM_LEVELS)
    {
      Sprite.killSprite(this.m_level_button[i]);
      this.m_level_button[i] = null;
      Sprite.killSprite(this.m_level_score[i]);
      this.m_level_score[i] = null;
      i += 1;
    }
    Sprite.killSprite(this.m_background);
    this.m_background = null;
    Sprite.killSprite(this.m_scores);
    this.m_scores = null;
    Sprite.killSprite(this.m_sound);
    this.m_sound = null;
    Sprite.killSprite(this.m_exit);
    this.m_exit = null;
    Sprite.killSprite(this.m_papaya_btn);
    this.m_papaya_btn = null;
    Sprite.killSprite(this.m_privacy_btn);
    this.m_privacy_btn = null;
    this.m_destroy_state = this.m_state;
  }
  
  void render(v2f paramv2f)
  {
    paramv2f = new v3f(paramv2f.x, paramv2f.y, 0.0F);
    Object localObject = new v2f(1.0F, 1.0F);
    v3f localv3f = new v3f(0.0F, 0.0F, 0.0F);
    for (;;)
    {
      int i;
      try
      {
        this.m_background.draw(new v3f(160.0F, 240.0F, 449.9F).plus(paramv2f));
        this.m_scores.draw(this.m_scores_pos.plus(paramv2f), (v2f)localObject, localv3f, this.m_scores_color);
        this.m_sound.draw(SOUND_POS.plus(paramv2f), (v2f)localObject, localv3f, this.m_sound_color);
        this.m_exit.draw(EXIT_POS.plus(paramv2f), (v2f)localObject, localv3f, this.m_exit_color);
        i = 0;
        if (i < LevelDefs.NUM_LEVELS)
        {
          if (this.m_level_button[i] != null)
          {
            v2f localv2f = new v2f(this.m_level_button_scale[i], this.m_level_button_scale[i]);
            this.m_level_button[i].draw(this.m_level_button_pos[i].plus(paramv2f), localv2f, localv3f, this.m_level_button_color[i]);
          }
          if (this.m_level_score[i] != null) {
            this.m_level_score[i].draw(this.m_level_score_pos[i].plus(paramv2f), (v2f)localObject, localv3f, this.m_scores_color);
          }
        }
        else
        {
          this.m_privacy_btn.draw(PRIVACY_BTN_POS.plus(paramv2f), (v2f)localObject, localv3f, this.m_privacy_btn_color);
          return;
        }
      }
      catch (Exception paramv2f)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("Trace", PaperTossApplication.getFirstLineOfException(paramv2f));
        FlurryAgent.onEvent("MenuRenderError", (Map)localObject);
        return;
      }
      i += 1;
    }
  }
  
  void setBest(int paramInt1, int paramInt2)
  {
    if (!this.m_level_score_pos[paramInt1].equalsZero())
    {
      Sprite.killSprite(this.m_level_score[paramInt1]);
      this.m_level_score[paramInt1] = new Sprite(14, -32, "zerothre", "" + paramInt2, new v4f(0.0F, 1.0F, 0.0F, 1.0F), 0);
    }
  }
  
  public void setMenuButton(int paramInt, String paramString, v3f paramv3f1, v3f paramv3f2, v4f paramv4f)
  {
    Sprite.killSprite(this.m_level_button[paramInt]);
    this.m_level_button[paramInt] = new Sprite(paramString);
    this.m_level_button_filenames[paramInt] = paramString;
    this.m_level_button_pos[paramInt] = paramv3f1;
    this.m_level_button_color[paramInt] = paramv4f;
    if ((paramv3f2 != null) && (!paramv3f2.equalsZero())) {
      this.m_level_score_pos[paramInt] = paramv3f2;
    }
  }
  
  void setNewLevel(int paramInt)
  {
    this.m_new_level = paramInt;
    this.m_new_level_timer = 1.0F;
  }
  
  public void setSound(boolean paramBoolean)
  {
    this.m_sound_on = paramBoolean;
    Sprite.killSprite(this.m_sound);
    int i = SOUND_FONT_SIZE;
    int j = SOUND_GLYPH_OFFSET;
    String str2 = SOUND_FONT;
    if (this.m_sound_on) {}
    for (String str1 = "on";; str1 = "off")
    {
      this.m_sound = new Sprite(i, j, str2, String.format("Sound: %s", new Object[] { str1 }), new v4f(1.0F, 0.0F, 0.0F, 1.0F), 0);
      return;
    }
  }
  
  public void unDestroy()
  {
    int i = 0;
    while (i < LevelDefs.NUM_LEVELS)
    {
      this.m_level_button[i] = new Sprite(this.m_level_button_filenames[i]);
      i += 1;
    }
    this.m_background = new Sprite(this.m_background_filename);
    this.m_scores = new Sprite(this.m_scores_filename);
    setSound(this.m_sound_on);
    this.m_state = this.m_destroy_state;
    this.m_exit = new Sprite("Exit.png");
    this.m_papaya_btn = new Sprite("papaya_btn_main.png");
    this.m_privacy_btn = new Sprite("privacy_btn_main.png");
  }
  
  void update(double paramDouble)
  {
    if (this.m_state == 1)
    {
      int i;
      if (this.m_new_level >= 0)
      {
        if (this.m_new_level != this.m_selected_level)
        {
          for (this.m_new_level_timer = ((float)(this.m_new_level_timer - paramDouble)); this.m_new_level_timer <= 0.0F; this.m_new_level_timer += 1.0F) {}
          f = Math.abs(this.m_new_level_timer / 1.0F - 0.5F);
          this.m_level_button_color[this.m_new_level] = SELECTION_COLOR.times(UNSELECTION_COLOR.minus(SELECTION_COLOR).times(f * 2.0F));
        }
      }
      else
      {
        i = 0;
        label107:
        if (i >= LevelDefs.NUM_LEVELS) {
          return;
        }
        if (this.m_level_button[i] != null)
        {
          float[] arrayOfFloat = this.m_level_button_time;
          arrayOfFloat[i] = ((float)(arrayOfFloat[i] + paramDouble));
          if (MENU_POPUP_DUR == 0.0F) {
            break label218;
          }
        }
      }
      label218:
      for (float f = Math.max(Math.min((this.m_level_button_time[i] - this.m_level_button_delay[i]) / MENU_POPUP_DUR, 1.0F), 0.0F);; f = 1.0F)
      {
        this.m_level_button_scale[i] = ((f - 2.1F) * f * (f - 2.0F));
        i += 1;
        break label107;
        this.m_new_level_timer = 0.5F;
        break;
      }
    }
  }
  
  private class OnPtrDown
    implements EvtListener
  {
    private OnPtrDown() {}
    
    public void run(Object paramObject)
    {
      if (Menu.this.m_state != 1) {}
      label82:
      label126:
      label141:
      do
      {
        do
        {
          return;
          paramObject = (v2f)paramObject;
          Menu.this.m_selected_level = -1;
          int i = 0;
          if (i < LevelDefs.NUM_LEVELS)
          {
            if ((Menu.this.m_level_button[i] != null) && (Menu.this.m_level_button[i].checkPoint(Menu.this.m_level_button_pos[i], (v2f)paramObject, 1.0F))) {
              Menu.this.m_selected_level = i;
            }
          }
          else
          {
            i = 0;
            if (i >= LevelDefs.NUM_LEVELS) {
              break label141;
            }
            if (i != Menu.this.m_selected_level) {
              break label126;
            }
            Menu.this.m_level_button_color[i] = Menu.SELECTION_COLOR;
          }
          for (;;)
          {
            i += 1;
            break label82;
            i += 1;
            break;
            Menu.this.m_level_button_color[i] = Menu.UNSELECTION_COLOR;
          }
          Menu.this.m_scores_color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
          Menu.this.m_sound_color = Menu.SOUND_COLOR;
        } while (Menu.this.m_selected_level != -1);
        if ((Menu.this.m_scores != null) && (Menu.this.m_scores.checkPoint(Menu.this.m_scores_pos, (v2f)paramObject, 1.0F)))
        {
          Menu.this.m_scores_color = new v4f(0.25F, 0.25F, 0.25F, 1.0F);
          return;
        }
        if ((Menu.this.m_sound != null) && (Menu.this.m_sound.checkPoint(Menu.SOUND_POS, (v2f)paramObject, 2.0F)))
        {
          Menu.this.m_sound_color = new v4f(0.5F, 0.5F, 0.5F, 1.0F).times(Menu.SOUND_COLOR);
          return;
        }
        if ((Menu.this.m_exit != null) && (Menu.this.m_exit.checkPoint(Menu.EXIT_POS, (v2f)paramObject, 1.0F)))
        {
          Menu.this.m_exit_color = new v4f(0.5F, 0.5F, 0.5F, 1.0F).times(Menu.EXIT_COLOR);
          return;
        }
      } while ((Menu.this.m_privacy_btn == null) || (!Menu.this.m_privacy_btn.checkPoint(Menu.PRIVACY_BTN_POS, (v2f)paramObject, 1.0F)));
      Menu.this.m_privacy_btn_color = new v4f(0.5F, 0.5F, 0.5F, 1.0F).times(Menu.PRIVACY_BTN_COLOR);
    }
  }
  
  private class OnPtrUp
    implements EvtListener
  {
    private OnPtrUp() {}
    
    public void run(Object paramObject)
    {
      boolean bool = true;
      Evt localEvt = Evt.getInstance();
      int i = 0;
      while (i < LevelDefs.NUM_LEVELS)
      {
        Menu.this.m_level_button_color[i] = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
        i += 1;
      }
      Menu.this.m_scores_color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      Menu.this.m_sound_color = Menu.SOUND_COLOR;
      Menu.this.m_exit_color = Menu.EXIT_COLOR;
      Menu.this.m_privacy_btn_color = Menu.PRIVACY_BTN_COLOR;
      if (Menu.this.m_state != 1) {
        return;
      }
      paramObject = (v2f)paramObject;
      if ((Menu.this.m_selected_level != -1) && (Menu.this.m_level_button[Menu.this.m_selected_level] != null) && (Menu.this.m_level_button[Menu.this.m_selected_level].checkPoint(Menu.this.m_level_button_pos[Menu.this.m_selected_level], (v2f)paramObject, 1.0F)))
      {
        localEvt.publish("paperTossPlaySound", "Crumple.wav");
        localEvt.publish("gotoLevel", Integer.valueOf(Menu.this.m_selected_level));
        if (Menu.this.m_selected_level == Menu.this.m_new_level) {
          Menu.this.m_new_level = -1;
        }
      }
      for (;;)
      {
        Menu.this.m_selected_level = -1;
        return;
        if ((Menu.this.m_scores != null) && (Menu.this.m_scores.checkPoint(Menu.this.m_scores_pos, (v2f)paramObject, 1.0F)))
        {
          localEvt.publish("paperTossPlaySound", "Computer.wav");
          localEvt.publish("gotoScores");
        }
        else
        {
          if ((Menu.this.m_sound != null) && (Menu.this.m_sound.checkPoint(Menu.SOUND_POS, (v2f)paramObject, 2.0F)))
          {
            paramObject = Menu.this;
            if (!Menu.this.m_sound_on) {}
            for (;;)
            {
              ((Menu)paramObject).setSound(bool);
              localEvt.publish("setSound", Boolean.valueOf(Menu.this.m_sound_on));
              localEvt.publish("paperTossPlaySound", "Crumple.wav");
              break;
              bool = false;
            }
          }
          if ((Menu.this.m_exit != null) && (Menu.this.m_exit.checkPoint(Menu.EXIT_POS, (v2f)paramObject, 1.0F))) {
            localEvt.publish("onExitPressed");
          } else if ((Menu.this.m_privacy_btn != null) && (Menu.this.m_privacy_btn.checkPoint(Menu.PRIVACY_BTN_POS, (v2f)paramObject, 1.0F))) {
            Globals.mainHandler.post(new Runnable()
            {
              public void run()
              {
                if (Globals.m_activity != null)
                {
                  Intent localIntent = new Intent(Globals.m_activity, BFSWebViewActivity.class);
                  localIntent.putExtra("__bfs_extra_web_view_page_url", "http://www.backflipstudios.com/support/privacy-policy-3");
                  Globals.m_activity.startActivity(localIntent);
                }
              }
            });
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/Menu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */