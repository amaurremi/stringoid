package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames
{
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
  public final String Sj;
  public final String Sk;
  public final String Sl;
  
  public PlayerColumnNames(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.RO = "external_player_id";
      this.RP = "profile_name";
      this.RQ = "profile_icon_image_uri";
      this.RR = "profile_icon_image_url";
      this.RS = "profile_hi_res_image_uri";
      this.RT = "profile_hi_res_image_url";
      this.RU = "last_updated";
      this.RV = "is_in_circles";
      this.RW = "played_with_timestamp";
      this.RX = "current_xp_total";
      this.RY = "current_level";
      this.RZ = "current_level_min_xp";
      this.Sa = "current_level_max_xp";
      this.Sb = "next_level";
      this.Sc = "next_level_max_xp";
      this.Sd = "last_level_up_timestamp";
      this.Se = "player_title";
      this.Sf = "has_all_public_acls";
      this.Sg = "most_recent_external_game_id";
      this.Sh = "most_recent_game_name";
      this.Si = "most_recent_activity_timestamp";
      this.Sj = "most_recent_game_icon_uri";
      this.Sk = "most_recent_game_hi_res_uri";
      this.Sl = "most_recent_game_featured_uri";
      return;
    }
    this.RO = (paramString + "external_player_id");
    this.RP = (paramString + "profile_name");
    this.RQ = (paramString + "profile_icon_image_uri");
    this.RR = (paramString + "profile_icon_image_url");
    this.RS = (paramString + "profile_hi_res_image_uri");
    this.RT = (paramString + "profile_hi_res_image_url");
    this.RU = (paramString + "last_updated");
    this.RV = (paramString + "is_in_circles");
    this.RW = (paramString + "played_with_timestamp");
    this.RX = (paramString + "current_xp_total");
    this.RY = (paramString + "current_level");
    this.RZ = (paramString + "current_level_min_xp");
    this.Sa = (paramString + "current_level_max_xp");
    this.Sb = (paramString + "next_level");
    this.Sc = (paramString + "next_level_max_xp");
    this.Sd = (paramString + "last_level_up_timestamp");
    this.Se = (paramString + "player_title");
    this.Sf = (paramString + "has_all_public_acls");
    this.Sg = (paramString + "most_recent_external_game_id");
    this.Sh = (paramString + "most_recent_game_name");
    this.Si = (paramString + "most_recent_activity_timestamp");
    this.Sj = (paramString + "most_recent_game_icon_uri");
    this.Sk = (paramString + "most_recent_game_hi_res_uri");
    this.Sl = (paramString + "most_recent_game_featured_uri");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/player/PlayerColumnNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */