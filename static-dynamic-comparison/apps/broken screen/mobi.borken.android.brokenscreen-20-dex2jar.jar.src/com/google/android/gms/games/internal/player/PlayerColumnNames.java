package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames
{
  public final String RL;
  public final String RM;
  public final String RN;
  public final String RO;
  public final String RP;
  public final String RQ;
  public final String RR;
  public final String RS;
  public final String RT;
  public final String RU;
  public final String RV;
  public final String RW;
  public final String RX;
  public final String RY;
  public final String RZ;
  public final String Sa;
  public final String Sb;
  public final String Sc;
  public final String Sd;
  public final String Se;
  public final String Sf;
  public final String Sg;
  public final String Sh;
  public final String Si;
  
  public PlayerColumnNames(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.RL = "external_player_id";
      this.RM = "profile_name";
      this.RN = "profile_icon_image_uri";
      this.RO = "profile_icon_image_url";
      this.RP = "profile_hi_res_image_uri";
      this.RQ = "profile_hi_res_image_url";
      this.RR = "last_updated";
      this.RS = "is_in_circles";
      this.RT = "played_with_timestamp";
      this.RU = "current_xp_total";
      this.RV = "current_level";
      this.RW = "current_level_min_xp";
      this.RX = "current_level_max_xp";
      this.RY = "next_level";
      this.RZ = "next_level_max_xp";
      this.Sa = "last_level_up_timestamp";
      this.Sb = "player_title";
      this.Sc = "has_all_public_acls";
      this.Sd = "most_recent_external_game_id";
      this.Se = "most_recent_game_name";
      this.Sf = "most_recent_activity_timestamp";
      this.Sg = "most_recent_game_icon_uri";
      this.Sh = "most_recent_game_hi_res_uri";
      this.Si = "most_recent_game_featured_uri";
      return;
    }
    this.RL = (paramString + "external_player_id");
    this.RM = (paramString + "profile_name");
    this.RN = (paramString + "profile_icon_image_uri");
    this.RO = (paramString + "profile_icon_image_url");
    this.RP = (paramString + "profile_hi_res_image_uri");
    this.RQ = (paramString + "profile_hi_res_image_url");
    this.RR = (paramString + "last_updated");
    this.RS = (paramString + "is_in_circles");
    this.RT = (paramString + "played_with_timestamp");
    this.RU = (paramString + "current_xp_total");
    this.RV = (paramString + "current_level");
    this.RW = (paramString + "current_level_min_xp");
    this.RX = (paramString + "current_level_max_xp");
    this.RY = (paramString + "next_level");
    this.RZ = (paramString + "next_level_max_xp");
    this.Sa = (paramString + "last_level_up_timestamp");
    this.Sb = (paramString + "player_title");
    this.Sc = (paramString + "has_all_public_acls");
    this.Sd = (paramString + "most_recent_external_game_id");
    this.Se = (paramString + "most_recent_game_name");
    this.Sf = (paramString + "most_recent_activity_timestamp");
    this.Sg = (paramString + "most_recent_game_icon_uri");
    this.Sh = (paramString + "most_recent_game_hi_res_uri");
    this.Si = (paramString + "most_recent_game_featured_uri");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/player/PlayerColumnNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */