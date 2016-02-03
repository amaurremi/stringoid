package com.bfs.papertoss.cpp;

import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.vector.v2f;
import com.bfs.papertoss.vector.v2i;
import com.bfs.papertoss.vector.v3f;
import com.bfs.papertoss.vector.v4f;
import java.lang.reflect.Array;

public class LevelDefs
{
  public static final int AIRPORT = 3;
  public static final int BASEMENT = 4;
  public static final int BATHROOM = 5;
  public static final int EASY = 0;
  public static final int HARD = 2;
  public static final int LEFT = 0;
  public static final int MAX_ANIMS = 8;
  public static final int MAX_FOREGROUNDS = 2;
  public static final int MAX_OFF_SOUNDS = 4;
  public static final int MEDIUM = 1;
  public static final int NUM_DIRS = 2;
  public static int NUM_LEVELS = 6;
  private static final float OVER_BG = 449.88998F;
  public static final int RIGHT = 1;
  static LevelInfo[] level_info = new LevelInfo[NUM_LEVELS];
  static MenuInfo menu_info;
  static ScoreMenuInfo score_menu_info;
  
  static void initializeData()
  {
    if (Globals.HI_RES)
    {
      initializeDataFreeHiRes();
      return;
    }
    initializeDataFree();
  }
  
  static void initializeDataFree()
  {
    menu_info = new MenuInfo();
    menu_info.image = "MMenu.jpg";
    menu_info.score_button.image = "HS_btn_green.png";
    menu_info.score_button.pos = new v2i(63, 343);
    score_menu_info = new ScoreMenuInfo();
    score_menu_info.image = "SBoard_menu.jpg";
    score_menu_info.back_button.pos = new v2i(269, 156);
    score_menu_info.back_button.size = new v2f(103.0F, 42.0F);
    int i = 0;
    while (i < level_info.length)
    {
      level_info[i] = new LevelInfo();
      int j = 0;
      while (j < 2)
      {
        level_info[i].foreground[j] = new ForegroundInfo();
        j += 1;
      }
      j = 0;
      while (j < 2)
      {
        int k = 0;
        while (k < 8)
        {
          level_info[i].wind[j][k] = new WindAnim();
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    level_info[0].menu_info.image = "Easy_button.png";
    level_info[0].menu_info.pos = v3f.iv3f(230.0F, 155.0F, 0.0F);
    level_info[0].score_menu_info.pos = new v2i(84, 397);
    level_info[0].score_menu_info.size = new v2f(121.0F, 38.0F);
    level_info[0].score_menu_info.score_pos = new v2i(280, 397);
    level_info[0].hud.score_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.best_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.submit_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.menu_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.score_pos = new v3f(40.0F, 410.0F, 449.88998F);
    level_info[0].hud.best_pos = new v3f(40.0F, 385.0F, 449.88998F);
    level_info[0].hud.submit_pos = new v3f(40.0F, 360.0F, 449.88998F);
    level_info[0].hud.menu_pos = v3f.iv3f(48.0F, 185.0F, 0.0F);
    level_info[0].basket.image = "CanFront_L1.png";
    level_info[0].basket.pos = new v3f(160.0F, 183.0F, 6.2819996F);
    level_info[0].basket.distance = 8.282F;
    level_info[0].basket.half_width = 37.0F;
    level_info[0].basket.height_offset = 30.0F;
    level_info[0].basket.base_offset = 30.0F;
    level_info[0].foreground[0].image = "Level1_foreground.png";
    level_info[0].foreground[0].pos = new v3f(15.0F, 133.5F, 1.0F);
    level_info[0].wind[0][0].image = "fan_l1l2_left.png";
    level_info[0].wind[0][0].pos = new v3f(31.0F, 58.0F, 0.9F);
    level_info[0].wind[0][0].size = new v2i(121, 198);
    level_info[0].wind[0][0].scale = new v2f(1.0F, 1.0F);
    level_info[0].wind[0][0].duration = 0.1F;
    level_info[0].wind[1][0].image = "fan_l1l2_right.png";
    level_info[0].wind[1][0].pos = new v3f(292.0F, 66.0F, 0.9F);
    level_info[0].wind[1][0].size = new v2i(121, 198);
    level_info[0].wind[1][0].scale = new v2f(1.0F, 1.0F);
    level_info[0].wind[1][0].duration = 0.1F;
    level_info[0].wind_speed.number_pos = new v3f(0.0F, 0.0F, 4.65F);
    level_info[0].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.25F);
    level_info[0].wind_speed.scale = new v2f(0.6F, 0.5F);
    level_info[0].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    level_info[0].sounds.loop = "OfficeNoise.mp3";
    level_info[0].sounds.offscreen_left[0] = "OffScreenLeft0.wav";
    level_info[0].sounds.offscreen_left[1] = "OffScreenLeft1.wav";
    level_info[0].sounds.offscreen_left[2] = "OffScreenLeft2.wav";
    level_info[0].sounds.offscreen_left[3] = "OffScreenLeft3.wav";
    level_info[0].sounds.offscreen_right[0] = "OffScreenRight0.wav";
    level_info[0].sounds.offscreen_right[1] = "OffScreenRight1.wav";
    level_info[0].background_image = "Level1.jpg";
    level_info[0].camera.height = 4.661F;
    level_info[0].camera.fov = 43.357F;
    level_info[1].menu_info.image = "Med_button.png";
    level_info[1].menu_info.pos = level_info[0].menu_info.pos.minus(new v3f(0.0F, 50.0F));
    level_info[1].score_menu_info.pos = level_info[0].score_menu_info.pos.minus(new v2i(0, 42));
    level_info[1].score_menu_info.size = new v2f(155.0F, 38.0F);
    level_info[1].score_menu_info.score_pos = level_info[0].score_menu_info.score_pos.minus(new v2i(0, 42));
    level_info[1].hud.score_rot = new v3f(0.0F, 0.0F, -4.0F);
    level_info[1].hud.best_rot = new v3f(0.0F, 0.0F, -4.0F);
    level_info[1].hud.submit_rot = new v3f(0.0F, 0.0F, -4.0F);
    level_info[1].hud.menu_rot = new v3f(0.0F, 0.0F, -4.0F);
    level_info[1].hud.score_pos = new v3f(64.0F, 415.0F, 449.88998F);
    level_info[1].hud.best_pos = new v3f(64.0F, 397.0F, 449.88998F);
    level_info[1].hud.submit_pos = new v3f(64.0F, 379.0F, 449.88998F);
    level_info[1].hud.menu_pos = v3f.iv3f(162.0F, 76.0F, 0.0F);
    level_info[1].basket.image = "CanFront_L2.png";
    level_info[1].basket.pos = new v3f(162.0F, 271.0F, 10.625F);
    level_info[1].basket.distance = 12.625F;
    level_info[1].basket.half_width = 24.0F;
    level_info[1].basket.height_offset = 30.0F;
    level_info[1].basket.base_offset = 16.0F;
    level_info[1].foreground[0].image = "Level2_foreground.png";
    level_info[1].foreground[0].pos = new v3f(300.0F, 239.0F, 6.5F);
    level_info[1].foreground[1].image = "Level2_Computer.png";
    level_info[1].foreground[1].pos = new v3f(23.0F, 278.0F, 10.625F);
    level_info[1].background_image = "Level2.jpg";
    level_info[1].wind[0][0].image = "fan_l1l2_left.png";
    level_info[1].wind[0][0].pos = new v3f(7.0F, 78.0F, 0.0F);
    level_info[1].wind[0][0].size = new v2i(121, 198);
    level_info[1].wind[0][0].scale = new v2f(1.0F, 1.0F);
    level_info[1].wind[0][0].duration = 0.1F;
    level_info[1].wind[1][0].image = "fan_l1l2_right.png";
    level_info[1].wind[1][0].pos = new v3f(314.0F, 80.0F, 0.0F);
    level_info[1].wind[1][0].size = new v2i(121, 198);
    level_info[1].wind[1][0].scale = new v2f(1.0F, 1.0F);
    level_info[1].wind[1][0].duration = 0.1F;
    level_info[1].wind_speed.number_pos = new v3f(0.0F, 0.0F, 5.0F);
    level_info[1].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.25F);
    level_info[1].wind_speed.scale = new v2f(0.9F, 0.9F);
    level_info[1].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    level_info[1].sounds.loop = "OfficeNoise.mp3";
    level_info[1].sounds.offscreen_left[0] = "OffScreenLeft0.wav";
    level_info[1].sounds.offscreen_left[1] = "OffScreenLeft1.wav";
    level_info[1].sounds.offscreen_left[2] = "OffScreenLeft2.wav";
    level_info[1].sounds.offscreen_left[3] = "OffScreenLeft3.wav";
    level_info[1].sounds.offscreen_right[0] = "OffScreenRight0.wav";
    level_info[1].sounds.offscreen_right[1] = "OffScreenRight1.wav";
    level_info[1].camera.height = 4.276F;
    level_info[1].camera.fov = 43.357F;
    level_info[1].toss_height = 110;
    level_info[2].menu_info.image = "Hard_button.png";
    level_info[2].menu_info.pos = level_info[1].menu_info.pos.minus(new v3f(0.0F, 50.0F));
    level_info[2].score_menu_info.pos = level_info[1].score_menu_info.pos.minus(new v2i(0, 42));
    level_info[2].score_menu_info.size = new v2f(127.0F, 38.0F);
    level_info[2].score_menu_info.score_pos = level_info[1].score_menu_info.score_pos.minus(new v2i(0, 42));
    level_info[2].hud.score_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[2].hud.best_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[2].hud.submit_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[2].hud.menu_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[2].hud.score_pos = new v3f(114.0F, 414.0F, 449.88998F);
    level_info[2].hud.best_pos = new v3f(112.0F, 397.0F, 449.88998F);
    level_info[2].hud.submit_pos = new v3f(114.0F, 380.0F, 449.88998F);
    level_info[2].hud.menu_pos = v3f.iv3f(230.0F, 72.0F, 0.0F);
    level_info[2].basket.image = "CanFront_L3.png";
    level_info[2].basket.pos = new v3f(160.0F, 322.0F, 26.476F);
    level_info[2].basket.distance = 28.476F;
    level_info[2].basket.half_width = 12.0F;
    level_info[2].basket.height_offset = 16.0F;
    level_info[2].basket.base_offset = 6.0F;
    level_info[2].foreground[0].image = "Front_desks_L3.png";
    level_info[2].foreground[0].pos = new v3f(160.0F, 289.5F, 26.576F);
    level_info[2].background_image = "Level3.jpg";
    level_info[2].wind[0][0].image = "Far_fan_Left.png";
    level_info[2].wind[0][0].pos = new v3f(40.0F, 324.0F, 14.238F);
    level_info[2].wind[0][0].size = new v2i(121, 198);
    level_info[2].wind[0][0].scale = new v2f(1.0F, 1.0F);
    level_info[2].wind[0][0].duration = 0.1F;
    level_info[2].wind[1][0].image = "Far_fan_Right.png";
    level_info[2].wind[1][0].pos = new v3f(290.0F, 322.0F, 14.238F);
    level_info[2].wind[1][0].size = new v2i(121, 198);
    level_info[2].wind[1][0].scale = new v2f(1.0F, 1.0F);
    level_info[2].wind[1][0].duration = 0.1F;
    level_info[2].wind_speed.number_pos = new v3f(0.0F, 0.0F, 6.0F);
    level_info[2].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.0F);
    level_info[2].wind_speed.scale = new v2f(2.0F, 2.5F);
    level_info[2].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    level_info[2].sounds.loop = "OfficeNoise.mp3";
    level_info[2].sounds.offscreen_left[0] = "OffScreenLeft0.wav";
    level_info[2].sounds.offscreen_left[1] = "OffScreenLeft1.wav";
    level_info[2].sounds.offscreen_left[2] = "OffScreenLeft2.wav";
    level_info[2].sounds.offscreen_left[3] = "OffScreenLeft3.wav";
    level_info[2].sounds.offscreen_right[0] = "OffScreenRight0.wav";
    level_info[2].sounds.offscreen_right[1] = "OffScreenRight1.wav";
    level_info[2].camera.height = 4.827F;
    level_info[2].camera.fov = 43.357F;
    level_info[2].toss_height = 110;
    level_info[3].menu_info.image = "Airport_button.png";
    level_info[3].menu_info.pos = level_info[2].menu_info.pos.minus(new v3f(0.0F, 50.0F));
    level_info[3].score_menu_info.pos = level_info[2].score_menu_info.pos.minus(new v2i(0, 42));
    level_info[3].score_menu_info.size = new v2f(165.0F, 38.0F);
    level_info[3].score_menu_info.score_pos = level_info[2].score_menu_info.score_pos.minus(new v2i(0, 42));
    level_info[3].hud.score_rot = new v3f(0.0F, 0.0F, 2.0F);
    level_info[3].hud.best_rot = new v3f(0.0F, 0.0F, 2.0F);
    level_info[3].hud.submit_rot = new v3f(0.0F, 0.0F, 2.0F);
    level_info[3].hud.menu_rot = new v3f(0.0F, 0.0F, 2.0F);
    level_info[3].hud.score_pos = v3f.iv3f(268.0F, 78.0F, 449.88998F);
    level_info[3].hud.best_pos = v3f.iv3f(268.0F, 98.0F, 449.88998F);
    level_info[3].hud.submit_pos = v3f.iv3f(268.0F, 118.0F, 449.88998F);
    level_info[3].hud.menu_pos = v3f.iv3f(268.0F, 176.0F, 0.0F);
    level_info[3].basket.image = "Airport_Canfront.png";
    level_info[3].basket.pos = v3f.iv3f(160.0F, 314.0F, 2.5742502F);
    level_info[3].basket.distance = 10.099F;
    level_info[3].basket.half_width = 28.0F;
    level_info[3].basket.height_offset = 36.0F;
    level_info[3].basket.base_offset = 20.0F;
    level_info[3].background_image = "Airport.jpg";
    level_info[3].wind[0][0].image = "fan_l1l2_left.png";
    level_info[3].wind[0][0].pos = v3f.iv3f(24.0F, 445.0F, 0.9F);
    level_info[3].wind[0][0].size = new v2i(121, 198);
    level_info[3].wind[0][0].scale = new v2f(1.0F, 1.0F);
    level_info[3].wind[0][0].duration = 0.1F;
    level_info[3].wind[1][0].image = "fan_l1l2_right.png";
    level_info[3].wind[1][0].pos = v3f.iv3f(304.0F, 445.0F, 0.9F);
    level_info[3].wind[1][0].size = new v2i(121, 198);
    level_info[3].wind[1][0].scale = new v2f(1.0F, 1.0F);
    level_info[3].wind[1][0].duration = 0.1F;
    level_info[3].wind_speed.number_pos = new v3f(0.0F, 0.0F, 4.25F);
    level_info[3].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 3.7F);
    level_info[3].wind_speed.scale = new v2f(0.9F, 0.7F);
    level_info[3].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    level_info[3].sounds.loop = "AirportNoise.mp3";
    level_info[3].sounds.offscreen_left[0] = "AirportLeft0.wav";
    level_info[3].sounds.offscreen_left[1] = "AirportLeft1.wav";
    level_info[3].sounds.offscreen_right[0] = "AirportRight0.wav";
    level_info[3].sounds.offscreen_right[1] = "AirportRight1.wav";
    level_info[3].camera.height = 4.471F;
    level_info[3].camera.fov = 45.0F;
    level_info[4].menu_info.image = "Basement_button.png";
    level_info[4].menu_info.pos = level_info[3].menu_info.pos.minus(new v3f(0.0F, 50.0F));
    level_info[4].score_menu_info.pos = level_info[3].score_menu_info.pos.minus(new v2i(0, 42));
    level_info[4].score_menu_info.size = new v2f(196.0F, 38.0F);
    level_info[4].score_menu_info.score_pos = level_info[3].score_menu_info.score_pos.minus(new v2i(0, 42));
    level_info[4].hud.score_rot = new v3f(0.0F, 0.0F, -10.0F);
    level_info[4].hud.best_rot = new v3f(0.0F, 0.0F, -5.5F);
    level_info[4].hud.submit_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[4].hud.menu_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[4].hud.score_pos = new v3f(91.0F, 365.0F, 449.88998F);
    level_info[4].hud.best_pos = new v3f(89.0F, 342.0F, 449.88998F);
    level_info[4].hud.submit_pos = new v3f(91.0F, 321.0F, 449.88998F);
    level_info[4].hud.menu_pos = v3f.iv3f(284.0F, 440.0F, 0.0F);
    level_info[4].basket.image = "canfront_basement.png";
    level_info[4].basket.pos = new v3f(161.0F, 221.0F, 18.645F);
    level_info[4].basket.distance = 19.483F;
    level_info[4].basket.half_width = 18.0F;
    level_info[4].basket.height_offset = 18.0F;
    level_info[4].basket.base_offset = 13.0F;
    level_info[4].foreground[0].image = "Basement_foreground.png";
    level_info[4].foreground[0].pos = new v3f(160.0F, 284.0F, 12.0F);
    level_info[4].wind[0][0].image = "Fan_Bmt_L.png";
    level_info[4].wind[0][0].pos = new v3f(14.0F, 224.0F, 8.0F);
    level_info[4].wind[0][0].size = new v2i(28, 79);
    level_info[4].wind[0][0].scale = new v2f(1.0F, 1.0F);
    level_info[4].wind[0][0].duration = 0.1F;
    level_info[4].wind[1][0].image = "Fan_Bmt_R.png";
    level_info[4].wind[1][0].pos = new v3f(290.0F, 171.0F, 5.0F);
    level_info[4].wind[1][0].size = new v2i(63, 134);
    level_info[4].wind[1][0].scale = new v2f(1.0F, 1.0F);
    level_info[4].wind[1][0].duration = 0.1F;
    level_info[4].wind_speed.number_pos = new v3f(0.0F, 0.0F, 5.5F);
    level_info[4].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.5F);
    level_info[4].wind_speed.scale = new v2f(1.5F, 1.5F);
    level_info[4].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    level_info[4].sounds.loop = "BasementAmbient.mp3";
    level_info[4].sounds.offscreen_left[0] = "ryan_urinal.wav";
    level_info[4].sounds.offscreen_left[1] = "justin_worldtour.wav";
    level_info[4].sounds.offscreen_right[0] = "MetalClank.wav";
    level_info[4].sounds.offscreen_right[1] = "Rats.wav";
    level_info[4].background_image = "Basement.png";
    level_info[4].camera.height = 6.037F;
    level_info[4].camera.fov = 43.357F;
    level_info[5].menu_info.image = "Restroom_button.png";
    level_info[5].menu_info.pos = level_info[4].menu_info.pos.minus(new v3f(0.0F, 50.0F));
    level_info[5].score_menu_info.pos = level_info[4].score_menu_info.pos.minus(new v2i(0, 42));
    level_info[5].score_menu_info.size = new v2f(226.0F, 38.0F);
    level_info[5].score_menu_info.score_pos = level_info[4].score_menu_info.score_pos.minus(new v2i(0, 42));
    level_info[5].hud.score_rot = new v3f(0.0F, 0.0F, -1.0F);
    level_info[5].hud.best_rot = new v3f(0.0F, 0.0F, -1.0F);
    level_info[5].hud.submit_rot = new v3f(0.0F, 0.0F, -1.0F);
    level_info[5].hud.menu_rot = new v3f(0.0F, 0.0F, 0.0F);
    level_info[5].hud.score_pos = new v3f(150.0F, 311.0F, 449.88998F);
    level_info[5].hud.best_pos = new v3f(148.0F, 293.0F, 449.88998F);
    level_info[5].hud.submit_pos = new v3f(148.0F, 274.0F, 449.88998F);
    level_info[5].hud.menu_pos = v3f.iv3f(281.0F, 228.0F, 0.0F);
    level_info[5].basket.image = "CanFront_RR.png";
    level_info[5].basket.pos = new v3f(160.0F, 215.0F, 27.023998F);
    level_info[5].basket.distance = 28.276F;
    level_info[5].basket.half_width = 11.0F;
    level_info[5].basket.height_offset = 15.5F;
    level_info[5].basket.base_offset = 7.9444447F;
    level_info[5].foreground[0].image = "RR_Fground_Rt.png";
    level_info[5].foreground[0].pos = new v3f(276.0F, 233.0F, 12.0F);
    level_info[5].wind[0][0].image = "Fan_RR_L.png";
    level_info[5].wind[0][0].pos = v3f.iv3f(23.5F, 318.5F, 449.88998F);
    level_info[5].wind[0][0].size = new v2i(47, 109);
    level_info[5].wind[0][0].scale = new v2f(1.0F, 1.0F);
    level_info[5].wind[0][0].duration = 0.0F;
    level_info[5].wind[1][0].image = "Fan_RR_R.png";
    level_info[5].wind[1][0].pos = v3f.iv3f(296.0F, 318.5F, 11.0F);
    level_info[5].wind[1][0].size = new v2i(48, 109);
    level_info[5].wind[1][0].scale = new v2f(1.0F, 1.0F);
    level_info[5].wind[1][0].duration = 0.0F;
    level_info[5].wind_speed.number_pos = new v3f(0.0F, -0.3F, 5.5F);
    level_info[5].wind_speed.arrow_pos = new v3f(0.0F, -1.1F, 4.5F);
    level_info[5].wind_speed.scale = new v2f(3.5F, 3.5F);
    level_info[5].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
    level_info[5].sounds.loop = "Bathroom Background.mp3";
    level_info[5].sounds.offscreen_left[0] = "Washing Hands (LF).wav";
    level_info[5].sounds.offscreen_left[1] = "Urinal Flush (LF).wav";
    level_info[5].sounds.offscreen_left[2] = "Paper Towel Dispensor (LF).wav";
    level_info[5].sounds.offscreen_left[3] = "Cut It Out, I'm Trying to Comb My Hair (LF).wav";
    level_info[5].sounds.offscreen_right[0] = "Hey I'm Trying to Concentrate (RT).wav";
    level_info[5].sounds.offscreen_right[1] = "Why Don't You Throw (RT).wav";
    level_info[5].sounds.offscreen_right[2] = "Toilet Flushing (RT).wav";
    level_info[5].background_image = "restroom.jpg";
    level_info[5].camera.height = 5.973F;
    level_info[5].camera.fov = 45.0F;
  }
  
  static void initializeDataFreeHiRes()
  {
    float f = Globals.SCALE_FACTOR;
    menu_info = new MenuInfo();
    menu_info.image = "MMenu.jpg";
    menu_info.score_button.image = "HS_btn_green.png";
    menu_info.score_button.pos = new v2i(68, 343);
    score_menu_info = new ScoreMenuInfo();
    score_menu_info.image = "SBoard_menu.jpg";
    score_menu_info.back_button.pos = new v2i(269, 156);
    score_menu_info.back_button.size = new v2f(103.0F, 42.0F);
    int i = 0;
    while (i < level_info.length)
    {
      level_info[i] = new LevelInfo();
      int j = 0;
      while (j < 2)
      {
        level_info[i].foreground[j] = new ForegroundInfo();
        j += 1;
      }
      j = 0;
      while (j < 2)
      {
        int k = 0;
        while (k < 8)
        {
          level_info[i].wind[j][k] = new WindAnim();
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    level_info[0].menu_info.image = "Easy_button.png";
    level_info[0].menu_info.pos = v3f.iv3f(225.0F, 162.0F, 0.0F);
    level_info[0].score_menu_info.pos = new v2i(84, 397);
    level_info[0].score_menu_info.size = new v2f(121.0F, 38.0F);
    level_info[0].score_menu_info.score_pos = new v2i(280, 397);
    level_info[0].hud.score_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.best_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.submit_rot = new v3f(0.0F, 0.0F, -3.0F);
    level_info[0].hud.menu_rot = new v3f(0.0F, 0.0F, -3.0F);
    if (Globals.HI_RES)
    {
      level_info[0].hud.score_pos = new v3f(50.0F, 410.0F, 449.88998F);
      level_info[0].hud.best_pos = new v3f(50.0F, 385.0F, 449.88998F);
    }
    for (level_info[0].hud.submit_pos = new v3f(50.0F, 360.0F, 449.88998F);; level_info[0].hud.submit_pos = new v3f(40.0F, 360.0F, 449.88998F))
    {
      level_info[0].hud.menu_pos = v3f.iv3f(48.0F, 185.0F, 0.0F);
      level_info[0].basket.image = "CanFront_L1.png";
      level_info[0].basket.pos = new v3f(160.0F, 183.0F, 6.2819996F);
      level_info[0].basket.distance = 8.282F;
      level_info[0].basket.half_width = 37.0F;
      level_info[0].basket.height_offset = 30.0F;
      level_info[0].basket.base_offset = 30.0F;
      level_info[0].foreground[0].image = "Level1_foreground.png";
      level_info[0].foreground[0].pos = new v3f(160.0F - 227.0F * f, 145.0F * f, 1.0F);
      level_info[0].wind[0][0].image = "fan_l1l2_left.png";
      level_info[0].wind[0][0].pos = new v3f(31.0F, 58.0F, 0.9F);
      level_info[0].wind[0][0].size = new v2i(196, 328);
      level_info[0].wind[0][0].scale = new v2f(1.0F, 1.0F);
      level_info[0].wind[0][0].duration = 0.1F;
      level_info[0].wind[1][0].image = "fan_l1l2_right.png";
      level_info[0].wind[1][0].pos = new v3f(292.0F, 66.0F, 0.9F);
      level_info[0].wind[1][0].size = new v2i(196, 328);
      level_info[0].wind[1][0].scale = new v2f(1.0F, 1.0F);
      level_info[0].wind[1][0].duration = 0.1F;
      level_info[0].wind_speed.number_pos = new v3f(0.0F, 0.0F, 4.65F);
      level_info[0].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.25F);
      level_info[0].wind_speed.scale = new v2f(0.6F / f, 0.5F / f);
      level_info[0].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      level_info[0].sounds.loop = "OfficeNoise.mp3";
      level_info[0].sounds.offscreen_left[0] = "OffScreenLeft0.wav";
      level_info[0].sounds.offscreen_left[1] = "OffScreenLeft1.wav";
      level_info[0].sounds.offscreen_left[2] = "OffScreenLeft2.wav";
      level_info[0].sounds.offscreen_left[3] = "OffScreenLeft3.wav";
      level_info[0].sounds.offscreen_right[0] = "OffScreenRight0.wav";
      level_info[0].sounds.offscreen_right[1] = "OffScreenRight1.wav";
      level_info[0].background_image = "Level1.jpg";
      level_info[0].camera.height = 4.661F;
      level_info[0].camera.fov = 43.357F;
      level_info[1].menu_info.image = "Med_button.png";
      level_info[1].menu_info.pos = level_info[0].menu_info.pos.minus(new v3f(0.0F, 50.0F));
      level_info[1].score_menu_info.pos = level_info[0].score_menu_info.pos.minus(new v2i(0, 42));
      level_info[1].score_menu_info.size = new v2f(155.0F, 38.0F);
      level_info[1].score_menu_info.score_pos = level_info[0].score_menu_info.score_pos.minus(new v2i(0, 42));
      level_info[1].hud.score_rot = new v3f(0.0F, 0.0F, -4.0F);
      level_info[1].hud.best_rot = new v3f(0.0F, 0.0F, -4.0F);
      level_info[1].hud.submit_rot = new v3f(0.0F, 0.0F, -4.0F);
      level_info[1].hud.menu_rot = new v3f(0.0F, 0.0F, -4.0F);
      level_info[1].hud.score_pos = new v3f(64.0F, 415.0F, 449.88998F);
      level_info[1].hud.best_pos = new v3f(64.0F, 397.0F, 449.88998F);
      level_info[1].hud.submit_pos = new v3f(64.0F, 379.0F, 449.88998F);
      level_info[1].hud.menu_pos = v3f.iv3f(162.0F, 76.0F, 0.0F);
      level_info[1].basket.image = "CanFront_L2.png";
      level_info[1].basket.pos = new v3f(162.0F, 271.0F, 10.625F);
      level_info[1].basket.distance = 12.625F;
      level_info[1].basket.half_width = 24.0F;
      level_info[1].basket.height_offset = 30.0F;
      level_info[1].basket.base_offset = 16.0F;
      level_info[1].foreground[0].image = "Level2_foreground.png";
      level_info[1].foreground[0].pos = new v3f(294.0F - f, 214.0F, 6.0F);
      level_info[1].foreground[1].image = "Level2_Computer.png";
      level_info[1].foreground[1].pos = new v3f(30.0F, 280.0F, 10.625F);
      level_info[1].background_image = "Level2.jpg";
      level_info[1].wind[0][0].image = "fan_l1l2_left.png";
      level_info[1].wind[0][0].pos = new v3f(7.0F, 78.0F, 0.0F);
      level_info[1].wind[0][0].size = new v2i(196, 328);
      level_info[1].wind[0][0].scale = new v2f(1.0F, 1.0F);
      level_info[1].wind[0][0].duration = 0.1F;
      level_info[1].wind[1][0].image = "fan_l1l2_right.png";
      level_info[1].wind[1][0].pos = new v3f(314.0F, 80.0F, 0.0F);
      level_info[1].wind[1][0].size = new v2i(196, 328);
      level_info[1].wind[1][0].scale = new v2f(1.0F, 1.0F);
      level_info[1].wind[1][0].duration = 0.1F;
      level_info[1].wind_speed.number_pos = new v3f(0.0F, 0.0F, 5.0F);
      level_info[1].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.25F);
      level_info[1].wind_speed.scale = new v2f(0.9F / f, 0.9F / f);
      level_info[1].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      level_info[1].sounds.loop = "OfficeNoise.mp3";
      level_info[1].sounds.offscreen_left[0] = "OffScreenLeft0.wav";
      level_info[1].sounds.offscreen_left[1] = "OffScreenLeft1.wav";
      level_info[1].sounds.offscreen_left[2] = "OffScreenLeft2.wav";
      level_info[1].sounds.offscreen_left[3] = "OffScreenLeft3.wav";
      level_info[1].sounds.offscreen_right[0] = "OffScreenRight0.wav";
      level_info[1].sounds.offscreen_right[1] = "OffScreenRight1.wav";
      level_info[1].camera.height = 4.276F;
      level_info[1].camera.fov = 43.357F;
      level_info[1].toss_height = 110;
      level_info[2].menu_info.image = "Hard_button.png";
      level_info[2].menu_info.pos = level_info[1].menu_info.pos.minus(new v3f(0.0F, 50.0F));
      level_info[2].score_menu_info.pos = level_info[1].score_menu_info.pos.minus(new v2i(0, 42));
      level_info[2].score_menu_info.size = new v2f(127.0F, 38.0F);
      level_info[2].score_menu_info.score_pos = level_info[1].score_menu_info.score_pos.minus(new v2i(0, 42));
      level_info[2].hud.score_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[2].hud.best_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[2].hud.submit_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[2].hud.menu_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[2].hud.score_pos = new v3f(116.0F, 424.0F, 449.88998F);
      level_info[2].hud.best_pos = new v3f(114.0F, 407.0F, 449.88998F);
      level_info[2].hud.submit_pos = new v3f(116.0F, 390.0F, 449.88998F);
      level_info[2].hud.menu_pos = v3f.iv3f(230.0F, 72.0F, 0.0F);
      level_info[2].basket.image = "CanFront_L3.png";
      level_info[2].basket.pos = new v3f(160.0F, 322.0F, 26.476F);
      level_info[2].basket.distance = 28.476F;
      level_info[2].basket.half_width = 12.0F;
      level_info[2].basket.height_offset = 16.0F;
      level_info[2].basket.base_offset = 6.0F;
      level_info[2].foreground[0].image = "Front_desks_L3.png";
      level_info[2].foreground[0].pos = new v3f(160.0F, 299.0F, 26.576F);
      level_info[2].background_image = "Level3.jpg";
      level_info[2].wind[0][0].image = "Far_fan_Left.png";
      level_info[2].wind[0][0].pos = new v3f(160.0F - 189.0F * f, 585.5F * f, 14.238F);
      level_info[2].wind[0][0].size = new v2i(103, 140);
      level_info[2].wind[0][0].scale = new v2f(1.0F, 1.0F);
      level_info[2].wind[0][0].duration = 0.1F;
      level_info[2].wind[1][0].image = "Far_fan_Right.png";
      level_info[2].wind[1][0].pos = new v3f(293.125F, 357.65625F, 14.238F);
      level_info[2].wind[1][0].size = new v2i(152, 142);
      level_info[2].wind[1][0].scale = new v2f(1.0F, 1.0F);
      level_info[2].wind[1][0].duration = 0.1F;
      level_info[2].wind_speed.number_pos = new v3f(0.0F, 0.0F, 6.0F);
      level_info[2].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.0F);
      level_info[2].wind_speed.scale = new v2f(2.0F / f, 2.5F / f);
      level_info[2].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      level_info[2].sounds.loop = "OfficeNoise.mp3";
      level_info[2].sounds.offscreen_left[0] = "OffScreenLeft0.wav";
      level_info[2].sounds.offscreen_left[1] = "OffScreenLeft1.wav";
      level_info[2].sounds.offscreen_left[2] = "OffScreenLeft2.wav";
      level_info[2].sounds.offscreen_left[3] = "OffScreenLeft3.wav";
      level_info[2].sounds.offscreen_right[0] = "OffScreenRight0.wav";
      level_info[2].sounds.offscreen_right[1] = "OffScreenRight1.wav";
      level_info[2].camera.height = 4.827F;
      level_info[2].camera.fov = 43.357F;
      level_info[2].toss_height = 110;
      level_info[3].menu_info.image = "Airport_button.png";
      level_info[3].menu_info.pos = level_info[2].menu_info.pos.minus(new v3f(0.0F, 50.0F));
      level_info[3].score_menu_info.pos = level_info[2].score_menu_info.pos.minus(new v2i(0, 42));
      level_info[3].score_menu_info.size = new v2f(165.0F, 38.0F);
      level_info[3].score_menu_info.score_pos = level_info[2].score_menu_info.score_pos.minus(new v2i(0, 42));
      level_info[3].hud.score_rot = new v3f(0.0F, 0.0F, 2.0F);
      level_info[3].hud.best_rot = new v3f(0.0F, 0.0F, 2.0F);
      level_info[3].hud.submit_rot = new v3f(0.0F, 0.0F, 2.0F);
      level_info[3].hud.menu_rot = new v3f(0.0F, 0.0F, 2.0F);
      level_info[3].hud.score_pos = v3f.iv3f(268.0F, 78.0F, 449.88998F);
      level_info[3].hud.best_pos = v3f.iv3f(268.0F, 98.0F, 449.88998F);
      level_info[3].hud.submit_pos = v3f.iv3f(268.0F, 118.0F, 449.88998F);
      level_info[3].hud.menu_pos = v3f.iv3f(268.0F, 176.0F, 0.0F);
      level_info[3].basket.image = "Airport_Canfront.png";
      level_info[3].basket.pos = v3f.iv3f(160.0F, 314.0F, 2.5742502F);
      level_info[3].basket.distance = 10.099F;
      level_info[3].basket.half_width = 28.0F;
      level_info[3].basket.height_offset = 36.0F;
      level_info[3].basket.base_offset = 20.0F;
      level_info[3].background_image = "Airport.jpg";
      level_info[3].wind[0][0].image = "fan_l1l2_left.png";
      level_info[3].wind[0][0].pos = v3f.iv3f(24.0F, 445.0F, 0.9F);
      level_info[3].wind[0][0].size = new v2i(196, 328);
      level_info[3].wind[0][0].scale = new v2f(1.0F, 1.0F);
      level_info[3].wind[0][0].duration = 0.1F;
      level_info[3].wind[1][0].image = "fan_l1l2_right.png";
      level_info[3].wind[1][0].pos = v3f.iv3f(304.0F, 445.0F, 0.9F);
      level_info[3].wind[1][0].size = new v2i(196, 328);
      level_info[3].wind[1][0].scale = new v2f(1.0F, 1.0F);
      level_info[3].wind[1][0].duration = 0.1F;
      level_info[3].wind_speed.number_pos = new v3f(0.0F, 0.0F, 4.25F);
      level_info[3].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 3.7F);
      level_info[3].wind_speed.scale = new v2f(0.9F / f, 0.7F / f);
      level_info[3].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      level_info[3].sounds.loop = "AirportNoise.mp3";
      level_info[3].sounds.offscreen_left[0] = "AirportLeft0.wav";
      level_info[3].sounds.offscreen_left[1] = "AirportLeft1.wav";
      level_info[3].sounds.offscreen_right[0] = "AirportRight0.wav";
      level_info[3].sounds.offscreen_right[1] = "AirportRight1.wav";
      level_info[3].camera.height = 4.471F;
      level_info[3].camera.fov = 45.0F;
      level_info[4].menu_info.image = "Basement_button.png";
      level_info[4].menu_info.pos = level_info[3].menu_info.pos.minus(new v3f(0.0F, 50.0F));
      level_info[4].score_menu_info.pos = level_info[3].score_menu_info.pos.minus(new v2i(0, 42));
      level_info[4].score_menu_info.size = new v2f(196.0F, 38.0F);
      level_info[4].score_menu_info.score_pos = level_info[3].score_menu_info.score_pos.minus(new v2i(0, 42));
      level_info[4].hud.score_rot = new v3f(0.0F, 0.0F, -10.0F);
      level_info[4].hud.best_rot = new v3f(0.0F, 0.0F, -5.5F);
      level_info[4].hud.submit_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[4].hud.menu_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[4].hud.score_pos = new v3f(91.0F, 365.0F, 449.88998F);
      level_info[4].hud.best_pos = new v3f(89.0F, 342.0F, 449.88998F);
      level_info[4].hud.submit_pos = new v3f(91.0F, 321.0F, 449.88998F);
      level_info[4].hud.menu_pos = v3f.iv3f(284.0F, 440.0F, 0.0F);
      level_info[4].basket.image = "canfront_basement.png";
      level_info[4].basket.pos = new v3f(161.0F, 221.0F, 18.645F);
      level_info[4].basket.distance = 19.483F;
      level_info[4].basket.half_width = 18.0F;
      level_info[4].basket.height_offset = 18.0F;
      level_info[4].basket.base_offset = 13.0F;
      level_info[4].wind[0][0].image = "Fan_Bmt_L.png";
      level_info[4].wind[0][0].pos = new v3f(14.0F, 224.0F, 8.0F);
      level_info[4].wind[0][0].size = new v2i(81, 142);
      level_info[4].wind[0][0].scale = new v2f(1.0F, 1.0F);
      level_info[4].wind[0][0].duration = 0.1F;
      level_info[4].wind[1][0].image = "Fan_Bmt_R.png";
      level_info[4].wind[1][0].pos = new v3f(290.0F, 171.0F, 5.0F);
      level_info[4].wind[1][0].size = new v2i(138, 237);
      level_info[4].wind[1][0].scale = new v2f(1.0F, 1.0F);
      level_info[4].wind[1][0].duration = 0.1F;
      level_info[4].wind_speed.number_pos = new v3f(0.0F, 0.0F, 5.5F);
      level_info[4].wind_speed.arrow_pos = new v3f(0.0F, 0.0F, 4.5F);
      level_info[4].wind_speed.scale = new v2f(1.5F / f, 1.5F / f);
      level_info[4].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      level_info[4].sounds.loop = "BasementAmbient.mp3";
      level_info[4].sounds.offscreen_left[0] = "ryan_urinal.wav";
      level_info[4].sounds.offscreen_left[1] = "justin_worldtour.wav";
      level_info[4].sounds.offscreen_right[0] = "MetalClank.wav";
      level_info[4].sounds.offscreen_right[1] = "Rats.wav";
      level_info[4].background_image = "Basement.jpg";
      level_info[4].camera.height = 6.037F;
      level_info[4].camera.fov = 43.357F;
      level_info[5].menu_info.image = "Restroom_button.png";
      level_info[5].menu_info.pos = level_info[4].menu_info.pos.minus(new v3f(0.0F, 50.0F));
      level_info[5].score_menu_info.pos = level_info[4].score_menu_info.pos.minus(new v2i(0, 42));
      level_info[5].score_menu_info.size = new v2f(226.0F, 38.0F);
      level_info[5].score_menu_info.score_pos = level_info[4].score_menu_info.score_pos.minus(new v2i(0, 42));
      level_info[5].hud.score_rot = new v3f(0.0F, 0.0F, -1.0F);
      level_info[5].hud.best_rot = new v3f(0.0F, 0.0F, -1.0F);
      level_info[5].hud.submit_rot = new v3f(0.0F, 0.0F, -1.0F);
      level_info[5].hud.menu_rot = new v3f(0.0F, 0.0F, 0.0F);
      level_info[5].hud.score_pos = new v3f(150.0F, 311.0F, 449.88998F);
      level_info[5].hud.best_pos = new v3f(148.0F, 293.0F, 449.88998F);
      level_info[5].hud.submit_pos = new v3f(148.0F, 274.0F, 449.88998F);
      level_info[5].hud.menu_pos = v3f.iv3f(281.0F, 228.0F, 0.0F);
      level_info[5].basket.image = "CanFront_RR.png";
      level_info[5].basket.pos = new v3f(160.0F, 215.0F - 3.0F * f, 27.023998F);
      level_info[5].basket.distance = 28.276F;
      level_info[5].basket.half_width = 11.0F;
      level_info[5].basket.height_offset = 15.5F;
      level_info[5].basket.base_offset = 7.9444447F;
      level_info[5].foreground[0].image = "RR_Fground_Rt.png";
      level_info[5].foreground[0].pos = new v3f(160.0F + 208.5F * f, 381.0F * f, 12.0F);
      level_info[5].wind[0][0].image = "Fan_RR_L.png";
      level_info[5].wind[0][0].pos = new v3f(22.0F, 147.2F, 449.88998F);
      level_info[5].wind[0][0].size = new v2i(137, 162);
      level_info[5].wind[0][0].scale = new v2f(1.0F, 1.0F);
      level_info[5].wind[0][0].duration = 0.0F;
      level_info[5].wind[1][0].image = "Fan_RR_R.png";
      level_info[5].wind[1][0].pos = v3f.iv3f(296.0F + 4.0F * f, 319.0F + 2.5F * f, 11.0F);
      level_info[5].wind[1][0].size = new v2i(138, 184);
      level_info[5].wind[1][0].scale = new v2f(1.0F, 1.0F);
      level_info[5].wind[1][0].duration = 0.0F;
      level_info[5].wind_speed.number_pos = new v3f(0.0F, -0.3F, 5.5F);
      level_info[5].wind_speed.arrow_pos = new v3f(0.0F, -0.8F, 4.5F);
      level_info[5].wind_speed.scale = new v2f(3.5F / Globals.SCALE_FACTOR, 3.5F / Globals.SCALE_FACTOR);
      level_info[5].wind_speed.color = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
      level_info[5].sounds.loop = "Bathroom Background.mp3";
      level_info[5].sounds.offscreen_left[0] = "Washing Hands (LF).wav";
      level_info[5].sounds.offscreen_left[1] = "Urinal Flush (LF).wav";
      level_info[5].sounds.offscreen_left[2] = "Paper Towel Dispensor (LF).wav";
      level_info[5].sounds.offscreen_left[3] = "Cut It Out, I'm Trying to Comb My Hair (LF).wav";
      level_info[5].sounds.offscreen_right[0] = "Hey I'm Trying to Concentrate (RT).wav";
      level_info[5].sounds.offscreen_right[1] = "Why Don't You Throw (RT).wav";
      level_info[5].sounds.offscreen_right[2] = "Toilet Flushing (RT).wav";
      level_info[5].background_image = "restroom.png";
      level_info[5].camera.height = 5.973F;
      level_info[5].camera.fov = 45.0F;
      return;
      level_info[0].hud.score_pos = new v3f(40.0F, 410.0F, 449.88998F);
      level_info[0].hud.best_pos = new v3f(40.0F, 385.0F, 449.88998F);
    }
  }
  
  public static class BasketInfo
  {
    float base_offset;
    float distance;
    float half_width;
    float height_offset;
    public String image;
    v3f pos = new v3f();
    v2i size = new v2i();
  }
  
  public static class ButtonInfo
  {
    public String image;
    v2i pos = new v2i();
    v2f size = new v2f();
  }
  
  public static class CameraInfo
  {
    float fov;
    float height;
  }
  
  public static class ForegroundInfo
  {
    public String image;
    v3f pos = new v3f();
  }
  
  public static class HudInfo
  {
    v3f best_pos = new v3f();
    v3f best_rot = new v3f();
    public String image;
    v3f menu_pos = new v3f();
    v3f menu_rot = new v3f();
    v3f pos = new v3f();
    v3f score_pos = new v3f();
    v3f score_rot = new v3f();
    boolean show_menu;
    v3f submit_pos = new v3f();
    v3f submit_rot = new v3f();
  }
  
  public static class LevelInfo
  {
    public String background_image;
    LevelDefs.BasketInfo basket = new LevelDefs.BasketInfo();
    LevelDefs.CameraInfo camera = new LevelDefs.CameraInfo();
    LevelDefs.ForegroundInfo[] foreground = new LevelDefs.ForegroundInfo[2];
    LevelDefs.HudInfo hud = new LevelDefs.HudInfo();
    LevelDefs.MenuLevelInfo menu_info = new LevelDefs.MenuLevelInfo();
    LevelDefs.ScoreMenuLevelInfo score_menu_info = new LevelDefs.ScoreMenuLevelInfo();
    LevelDefs.SoundInfo sounds = new LevelDefs.SoundInfo();
    LevelDefs.SplashAnimInfo splash = new LevelDefs.SplashAnimInfo();
    int toss_height;
    public String tutorial_image;
    boolean use_fireworks;
    LevelDefs.WindAnim[][] wind = (LevelDefs.WindAnim[][])Array.newInstance(LevelDefs.WindAnim.class, new int[] { 2, 8 });
    LevelDefs.WindSpeedInfo wind_speed = new LevelDefs.WindSpeedInfo();
  }
  
  public static class MenuInfo
  {
    public String image;
    LevelDefs.ButtonInfo score_button = new LevelDefs.ButtonInfo();
  }
  
  public static class MenuLevelInfo
  {
    public String image;
    public String level_name;
    v3f pos = new v3f();
    v3f score_pos = new v3f();
    int score_to_unlock_next;
  }
  
  public static class ScoreMenuInfo
  {
    LevelDefs.ButtonInfo back_button = new LevelDefs.ButtonInfo();
    public String image;
  }
  
  public static class ScoreMenuLevelInfo
  {
    v2i pos = new v2i();
    v2i score_pos = new v2i();
    v2f size = new v2f();
  }
  
  public static class SoundInfo
  {
    public String loop;
    public String[] offscreen_left = new String[4];
    public String[] offscreen_right = new String[4];
    public String splash;
  }
  
  public static class SplashAnimInfo
  {
    float duration;
    public String image;
    LevelDefs.SplashAnimRange range = new LevelDefs.SplashAnimRange();
    float scale;
    v2i size = new v2i();
  }
  
  public static class SplashAnimRange
  {
    boolean inside;
    int left;
    int right;
  }
  
  public static class WindAnim
  {
    v2f alpha_range = new v2f();
    float duration;
    int frame_count;
    public String image;
    v3f pos = new v3f();
    v2f scale = new v2f();
    v2f scroll = new v2f();
    v2i size = new v2i();
  }
  
  public static class WindSpeedInfo
  {
    v3f arrow_pos = new v3f();
    v4f color = new v4f();
    float depth;
    v3f number_pos = new v3f();
    v2f scale = new v2f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/LevelDefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */