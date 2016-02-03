package com.magmamobile.game.BubbleBlast;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class modPreferences
{
  public static final int PREF_VOLUME_DEFAULT = 15;
  public static boolean prefAboutAtStart;
  public static boolean prefArcadeUnlocked;
  public static boolean prefAsk4RateNeverAskAgain = false;
  public static int prefAskedMarketCount;
  public static int prefBestArcadeLevel;
  public static int prefBestArcadeScore;
  public static int prefGameCount;
  public static int prefHighestPuzzleLevel;
  public static int prefHighestPuzzleLevel002;
  public static int prefHighestPuzzleLevel003;
  public static int prefHighestPuzzleLevel004;
  public static int prefHighestPuzzleLevel005;
  public static int prefHighestPuzzleLevel006;
  public static int prefHighestPuzzleLevel007;
  public static int prefHighestPuzzleLevel008;
  public static int prefHighestPuzzleLevel009;
  public static int prefHighestPuzzleLevel010;
  public static int prefHighestPuzzleLevel011;
  public static int prefHighestPuzzleLevel012;
  public static int prefHighestPuzzleLevel013;
  public static int prefHighestPuzzleLevel014;
  public static int prefHighestPuzzleLevel015;
  public static int prefHighestPuzzleLevel016;
  public static int prefHighestPuzzleLevel017;
  public static int prefHighestPuzzleLevel018;
  public static int prefHighestPuzzleLevel019;
  public static int prefHighestPuzzleLevel020;
  public static int prefHighestPuzzleLevel021;
  public static int prefHighestPuzzleLevel022;
  public static int prefHighestPuzzleScore;
  public static int prefHighestPuzzleScore002;
  public static int prefHighestPuzzleScore003;
  public static int prefHighestPuzzleScore004;
  public static int prefHighestPuzzleScore005;
  public static int prefHighestPuzzleScore006;
  public static int prefHighestPuzzleScore007;
  public static int prefHighestPuzzleScore008;
  public static int prefHighestPuzzleScore009;
  public static int prefHighestPuzzleScore010;
  public static int prefHighestPuzzleScore011;
  public static int prefHighestPuzzleScore012;
  public static int prefHighestPuzzleScore013;
  public static int prefHighestPuzzleScore014;
  public static int prefHighestPuzzleScore015;
  public static int prefHighestPuzzleScore016;
  public static int prefHighestPuzzleScore017;
  public static int prefHighestPuzzleScore018;
  public static int prefHighestPuzzleScore019;
  public static int prefHighestPuzzleScore020;
  public static int prefHighestPuzzleScore021;
  public static int prefHighestPuzzleScore022;
  public static int prefLastPuzzleLevel;
  public static int prefLastPuzzleLevel002;
  public static int prefLastPuzzleLevel003;
  public static int prefLastPuzzleLevel004;
  public static int prefLastPuzzleLevel005;
  public static int prefLastPuzzleLevel006;
  public static int prefLastPuzzleLevel007;
  public static int prefLastPuzzleLevel008;
  public static int prefLastPuzzleLevel009;
  public static int prefLastPuzzleLevel010;
  public static int prefLastPuzzleLevel011;
  public static int prefLastPuzzleLevel012;
  public static int prefLastPuzzleLevel013;
  public static int prefLastPuzzleLevel014;
  public static int prefLastPuzzleLevel015;
  public static int prefLastPuzzleLevel016;
  public static int prefLastPuzzleLevel017;
  public static int prefLastPuzzleLevel018;
  public static int prefLastPuzzleLevel019;
  public static int prefLastPuzzleLevel020;
  public static int prefLastPuzzleLevel021;
  public static int prefLastPuzzleLevel022;
  public static int prefLastPuzzleScore;
  public static int prefLastPuzzleScore002;
  public static int prefLastPuzzleScore003;
  public static int prefLastPuzzleScore004;
  public static int prefLastPuzzleScore005;
  public static int prefLastPuzzleScore006;
  public static int prefLastPuzzleScore007;
  public static int prefLastPuzzleScore008;
  public static int prefLastPuzzleScore009;
  public static int prefLastPuzzleScore010;
  public static int prefLastPuzzleScore011;
  public static int prefLastPuzzleScore012;
  public static int prefLastPuzzleScore013;
  public static int prefLastPuzzleScore014;
  public static int prefLastPuzzleScore015;
  public static int prefLastPuzzleScore016;
  public static int prefLastPuzzleScore017;
  public static int prefLastPuzzleScore018;
  public static int prefLastPuzzleScore019;
  public static int prefLastPuzzleScore020;
  public static int prefLastPuzzleScore021;
  public static int prefLastPuzzleScore022;
  public static String prefLastVersion = "";
  public static boolean prefPuzzleLevel002Unlocked;
  public static boolean prefPuzzleLevel003Unlocked;
  public static boolean prefPuzzleLevel004Unlocked;
  public static boolean prefPuzzleLevel005Unlocked;
  public static boolean prefPuzzleLevel006Unlocked;
  public static boolean prefPuzzleLevel007Unlocked;
  public static boolean prefPuzzleLevel008Unlocked;
  public static boolean prefPuzzleLevel009Unlocked;
  public static boolean prefPuzzleLevel010Unlocked;
  public static boolean prefPuzzleLevel011Unlocked;
  public static boolean prefPuzzleLevel012Unlocked;
  public static boolean prefPuzzleLevel013Unlocked;
  public static boolean prefPuzzleLevel014Unlocked;
  public static boolean prefPuzzleLevel015Unlocked;
  public static boolean prefPuzzleLevel016Unlocked;
  public static boolean prefPuzzleLevel017Unlocked;
  public static boolean prefPuzzleLevel018Unlocked;
  public static boolean prefPuzzleLevel019Unlocked;
  public static boolean prefPuzzleLevel020Unlocked;
  public static boolean prefPuzzleLevel021Unlocked;
  public static boolean prefPuzzleLevel022Unlocked;
  public static int prefStartCount;
  public static int prefVolumeLevel;
  private static boolean savingPrefs;
  
  static
  {
    prefAboutAtStart = false;
    prefVolumeLevel = 15;
    prefArcadeUnlocked = false;
    prefBestArcadeScore = 0;
    prefBestArcadeLevel = 0;
    prefHighestPuzzleLevel = 0;
    prefHighestPuzzleScore = 0;
    prefLastPuzzleScore = 0;
    prefLastPuzzleLevel = 0;
    prefPuzzleLevel002Unlocked = false;
    prefHighestPuzzleLevel002 = 0;
    prefHighestPuzzleScore002 = 0;
    prefLastPuzzleScore002 = 0;
    prefLastPuzzleLevel002 = 0;
    prefPuzzleLevel003Unlocked = false;
    prefHighestPuzzleLevel003 = 0;
    prefHighestPuzzleScore003 = 0;
    prefLastPuzzleScore003 = 0;
    prefLastPuzzleLevel003 = 0;
    prefPuzzleLevel004Unlocked = false;
    prefHighestPuzzleLevel004 = 0;
    prefHighestPuzzleScore004 = 0;
    prefLastPuzzleScore004 = 0;
    prefLastPuzzleLevel004 = 0;
    prefPuzzleLevel005Unlocked = false;
    prefHighestPuzzleLevel005 = 0;
    prefHighestPuzzleScore005 = 0;
    prefLastPuzzleScore005 = 0;
    prefLastPuzzleLevel005 = 0;
    prefPuzzleLevel006Unlocked = false;
    prefHighestPuzzleLevel006 = 0;
    prefHighestPuzzleScore006 = 0;
    prefLastPuzzleScore006 = 0;
    prefLastPuzzleLevel006 = 0;
    prefPuzzleLevel007Unlocked = false;
    prefHighestPuzzleLevel007 = 0;
    prefHighestPuzzleScore007 = 0;
    prefLastPuzzleScore007 = 0;
    prefLastPuzzleLevel007 = 0;
    prefPuzzleLevel008Unlocked = false;
    prefHighestPuzzleLevel008 = 0;
    prefHighestPuzzleScore008 = 0;
    prefLastPuzzleScore008 = 0;
    prefLastPuzzleLevel008 = 0;
    prefPuzzleLevel009Unlocked = false;
    prefHighestPuzzleLevel009 = 0;
    prefHighestPuzzleScore009 = 0;
    prefLastPuzzleScore009 = 0;
    prefLastPuzzleLevel009 = 0;
    prefPuzzleLevel010Unlocked = false;
    prefHighestPuzzleLevel010 = 0;
    prefHighestPuzzleScore010 = 0;
    prefLastPuzzleScore010 = 0;
    prefLastPuzzleLevel010 = 0;
    prefPuzzleLevel011Unlocked = false;
    prefHighestPuzzleLevel011 = 0;
    prefHighestPuzzleScore011 = 0;
    prefLastPuzzleScore011 = 0;
    prefLastPuzzleLevel011 = 0;
    prefPuzzleLevel012Unlocked = false;
    prefHighestPuzzleLevel012 = 0;
    prefHighestPuzzleScore012 = 0;
    prefLastPuzzleScore012 = 0;
    prefLastPuzzleLevel012 = 0;
    prefPuzzleLevel013Unlocked = false;
    prefHighestPuzzleLevel013 = 0;
    prefHighestPuzzleScore013 = 0;
    prefLastPuzzleScore013 = 0;
    prefLastPuzzleLevel013 = 0;
    prefPuzzleLevel014Unlocked = false;
    prefHighestPuzzleLevel014 = 0;
    prefHighestPuzzleScore014 = 0;
    prefLastPuzzleScore014 = 0;
    prefLastPuzzleLevel014 = 0;
    prefPuzzleLevel015Unlocked = false;
    prefHighestPuzzleLevel015 = 0;
    prefHighestPuzzleScore015 = 0;
    prefLastPuzzleScore015 = 0;
    prefLastPuzzleLevel015 = 0;
    prefPuzzleLevel016Unlocked = false;
    prefHighestPuzzleLevel016 = 0;
    prefHighestPuzzleScore016 = 0;
    prefLastPuzzleScore016 = 0;
    prefLastPuzzleLevel016 = 0;
    prefPuzzleLevel017Unlocked = false;
    prefHighestPuzzleLevel017 = 0;
    prefHighestPuzzleScore017 = 0;
    prefLastPuzzleScore017 = 0;
    prefLastPuzzleLevel017 = 0;
    prefPuzzleLevel018Unlocked = false;
    prefHighestPuzzleLevel018 = 0;
    prefHighestPuzzleScore018 = 0;
    prefLastPuzzleScore018 = 0;
    prefLastPuzzleLevel018 = 0;
    prefPuzzleLevel019Unlocked = false;
    prefHighestPuzzleLevel019 = 0;
    prefHighestPuzzleScore019 = 0;
    prefLastPuzzleScore019 = 0;
    prefLastPuzzleLevel019 = 0;
    prefPuzzleLevel020Unlocked = false;
    prefHighestPuzzleLevel020 = 0;
    prefHighestPuzzleScore020 = 0;
    prefLastPuzzleScore020 = 0;
    prefLastPuzzleLevel020 = 0;
    prefPuzzleLevel021Unlocked = false;
    prefHighestPuzzleLevel021 = 0;
    prefHighestPuzzleScore021 = 0;
    prefLastPuzzleScore021 = 0;
    prefLastPuzzleLevel021 = 0;
    prefPuzzleLevel022Unlocked = false;
    prefHighestPuzzleLevel022 = 0;
    prefHighestPuzzleScore022 = 0;
    prefLastPuzzleScore022 = 0;
    prefLastPuzzleLevel022 = 0;
    prefStartCount = 0;
    prefGameCount = 0;
    prefAskedMarketCount = 0;
  }
  
  public static void LoadPreferences(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    prefLastVersion = localSharedPreferences.getString("LastVersion", "0");
    prefAboutAtStart = localSharedPreferences.getBoolean("AboutAtStart", true);
    prefVolumeLevel = localSharedPreferences.getInt("prefStartupDefault", 15);
    prefArcadeUnlocked = localSharedPreferences.getBoolean("prefArcadeUnlocked", false);
    prefPuzzleLevel002Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel002Unlocked", false);
    prefPuzzleLevel003Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel003Unlocked", false);
    prefPuzzleLevel004Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel004Unlocked", false);
    prefPuzzleLevel005Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel005Unlocked", false);
    prefPuzzleLevel006Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel006Unlocked", false);
    prefPuzzleLevel007Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel007Unlocked", false);
    prefPuzzleLevel008Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel008Unlocked", false);
    prefPuzzleLevel009Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel009Unlocked", false);
    prefPuzzleLevel010Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel010Unlocked", false);
    prefPuzzleLevel011Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel011Unlocked", false);
    prefPuzzleLevel012Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel012Unlocked", false);
    prefPuzzleLevel013Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel013Unlocked", false);
    prefPuzzleLevel014Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel014Unlocked", false);
    prefPuzzleLevel015Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel015Unlocked", false);
    prefPuzzleLevel016Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel016Unlocked", false);
    prefPuzzleLevel017Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel017Unlocked", false);
    prefPuzzleLevel018Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel018Unlocked", false);
    prefPuzzleLevel019Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel019Unlocked", false);
    prefPuzzleLevel020Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel020Unlocked", false);
    prefPuzzleLevel021Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel021Unlocked", false);
    prefPuzzleLevel022Unlocked = localSharedPreferences.getBoolean("prefPuzzleLevel022Unlocked", false);
    prefBestArcadeScore = localSharedPreferences.getInt("prefBestScoreChallenge", 0);
    prefBestArcadeLevel = localSharedPreferences.getInt("prefBestLevelChallenge", 0);
    String str1 = localSharedPreferences.getString("KprefLastPuzzleScore", "");
    String str2 = localSharedPreferences.getString("KprefLastPuzzleLevel", "");
    String str3 = localSharedPreferences.getString("KprefHighestPuzzleScore", "");
    String str4 = localSharedPreferences.getString("KprefHighestPuzzleLevel", "");
    String str5 = localSharedPreferences.getString("KprefLastPuzzleScore002", "");
    String str6 = localSharedPreferences.getString("KprefLastPuzzleLevel002", "");
    String str7 = localSharedPreferences.getString("KprefHighestPuzzleScore002", "");
    String str8 = localSharedPreferences.getString("KprefHighestPuzzleLevel002", "");
    String str9 = localSharedPreferences.getString("KprefLastPuzzleScore003", "");
    String str10 = localSharedPreferences.getString("KprefLastPuzzleLevel003", "");
    String str11 = localSharedPreferences.getString("KprefHighestPuzzleScore003", "");
    String str12 = localSharedPreferences.getString("KprefHighestPuzzleLevel003", "");
    String str13 = localSharedPreferences.getString("KprefLastPuzzleScore004", "");
    String str14 = localSharedPreferences.getString("KprefLastPuzzleLevel004", "");
    String str15 = localSharedPreferences.getString("KprefHighestPuzzleScore004", "");
    String str16 = localSharedPreferences.getString("KprefHighestPuzzleLevel004", "");
    String str17 = localSharedPreferences.getString("KprefLastPuzzleScore005", "");
    String str18 = localSharedPreferences.getString("KprefLastPuzzleLevel005", "");
    String str19 = localSharedPreferences.getString("KprefHighestPuzzleScore005", "");
    String str20 = localSharedPreferences.getString("KprefHighestPuzzleLevel005", "");
    String str21 = localSharedPreferences.getString("KprefLastPuzzleScore006", "");
    String str22 = localSharedPreferences.getString("KprefLastPuzzleLevel006", "");
    String str23 = localSharedPreferences.getString("KprefHighestPuzzleScore006", "");
    String str24 = localSharedPreferences.getString("KprefHighestPuzzleLevel006", "");
    String str25 = localSharedPreferences.getString("KprefLastPuzzleScore007", "");
    String str26 = localSharedPreferences.getString("KprefLastPuzzleLevel007", "");
    String str27 = localSharedPreferences.getString("KprefHighestPuzzleScore007", "");
    String str28 = localSharedPreferences.getString("KprefHighestPuzzleLevel007", "");
    String str29 = localSharedPreferences.getString("KprefLastPuzzleScore008", "");
    String str30 = localSharedPreferences.getString("KprefLastPuzzleLevel008", "");
    String str31 = localSharedPreferences.getString("KprefHighestPuzzleScore008", "");
    String str32 = localSharedPreferences.getString("KprefHighestPuzzleLevel008", "");
    String str33 = localSharedPreferences.getString("KprefLastPuzzleScore009", "");
    String str34 = localSharedPreferences.getString("KprefLastPuzzleLevel009", "");
    String str35 = localSharedPreferences.getString("KprefHighestPuzzleScore009", "");
    String str36 = localSharedPreferences.getString("KprefHighestPuzzleLevel009", "");
    String str37 = localSharedPreferences.getString("KprefLastPuzzleScore010", "");
    String str38 = localSharedPreferences.getString("KprefLastPuzzleLevel010", "");
    String str39 = localSharedPreferences.getString("KprefHighestPuzzleScore010", "");
    String str40 = localSharedPreferences.getString("KprefHighestPuzzleLevel010", "");
    String str41 = localSharedPreferences.getString("KprefLastPuzzleScore011", "");
    String str42 = localSharedPreferences.getString("KprefLastPuzzleLevel011", "");
    String str43 = localSharedPreferences.getString("KprefHighestPuzzleScore011", "");
    String str44 = localSharedPreferences.getString("KprefHighestPuzzleLevel011", "");
    String str45 = localSharedPreferences.getString("KprefLastPuzzleScore012", "");
    String str46 = localSharedPreferences.getString("KprefLastPuzzleLevel012", "");
    String str47 = localSharedPreferences.getString("KprefHighestPuzzleScore012", "");
    String str48 = localSharedPreferences.getString("KprefHighestPuzzleLevel012", "");
    String str49 = localSharedPreferences.getString("KprefLastPuzzleScore013", "");
    String str50 = localSharedPreferences.getString("KprefLastPuzzleLevel013", "");
    String str51 = localSharedPreferences.getString("KprefHighestPuzzleScore013", "");
    String str52 = localSharedPreferences.getString("KprefHighestPuzzleLevel013", "");
    String str53 = localSharedPreferences.getString("KprefLastPuzzleScore014", "");
    String str54 = localSharedPreferences.getString("KprefLastPuzzleLevel014", "");
    String str55 = localSharedPreferences.getString("KprefHighestPuzzleScore014", "");
    String str56 = localSharedPreferences.getString("KprefHighestPuzzleLevel014", "");
    String str57 = localSharedPreferences.getString("KprefLastPuzzleScore015", "");
    String str58 = localSharedPreferences.getString("KprefLastPuzzleLevel015", "");
    String str59 = localSharedPreferences.getString("KprefHighestPuzzleScore015", "");
    String str60 = localSharedPreferences.getString("KprefHighestPuzzleLevel015", "");
    String str61 = localSharedPreferences.getString("KprefLastPuzzleScore016", "");
    String str62 = localSharedPreferences.getString("KprefLastPuzzleLevel016", "");
    String str63 = localSharedPreferences.getString("KprefHighestPuzzleScore016", "");
    String str64 = localSharedPreferences.getString("KprefHighestPuzzleLevel016", "");
    String str65 = localSharedPreferences.getString("KprefLastPuzzleScore017", "");
    String str66 = localSharedPreferences.getString("KprefLastPuzzleLevel017", "");
    String str67 = localSharedPreferences.getString("KprefHighestPuzzleScore017", "");
    String str68 = localSharedPreferences.getString("KprefHighestPuzzleLevel017", "");
    String str69 = localSharedPreferences.getString("KprefLastPuzzleScore018", "");
    String str70 = localSharedPreferences.getString("KprefLastPuzzleLevel018", "");
    String str71 = localSharedPreferences.getString("KprefHighestPuzzleScore018", "");
    String str72 = localSharedPreferences.getString("KprefHighestPuzzleLevel018", "");
    String str73 = localSharedPreferences.getString("KprefLastPuzzleScore019", "");
    String str74 = localSharedPreferences.getString("KprefLastPuzzleLevel019", "");
    String str75 = localSharedPreferences.getString("KprefHighestPuzzleScore019", "");
    String str76 = localSharedPreferences.getString("KprefHighestPuzzleLevel019", "");
    String str77 = localSharedPreferences.getString("KprefLastPuzzleScore020", "");
    String str78 = localSharedPreferences.getString("KprefLastPuzzleLevel020", "");
    String str79 = localSharedPreferences.getString("KprefHighestPuzzleScore020", "");
    String str80 = localSharedPreferences.getString("KprefHighestPuzzleLevel020", "");
    String str81 = localSharedPreferences.getString("KprefLastPuzzleScore021", "");
    String str82 = localSharedPreferences.getString("KprefLastPuzzleLevel021", "");
    String str83 = localSharedPreferences.getString("KprefHighestPuzzleScore021", "");
    String str84 = localSharedPreferences.getString("KprefHighestPuzzleLevel021", "");
    String str85 = localSharedPreferences.getString("KprefLastPuzzleScore022", "");
    String str86 = localSharedPreferences.getString("KprefLastPuzzleLevel022", "");
    String str87 = localSharedPreferences.getString("KprefHighestPuzzleScore022", "");
    String str88 = localSharedPreferences.getString("KprefHighestPuzzleLevel022", "");
    try
    {
      if (!str1.equals("")) {
        prefLastPuzzleScore = Integer.parseInt(modCommon.dkryp(paramContext, str1));
      }
      if (!str2.equals("")) {
        prefLastPuzzleLevel = Integer.parseInt(modCommon.dkryp(paramContext, str2));
      }
      if (!str3.equals("")) {
        prefHighestPuzzleLevel = Integer.parseInt(modCommon.dkryp(paramContext, str4));
      }
      if (!str4.equals("")) {
        prefHighestPuzzleScore = Integer.parseInt(modCommon.dkryp(paramContext, str4));
      }
      if (!str5.equals("")) {
        prefLastPuzzleScore002 = Integer.parseInt(modCommon.dkryp(paramContext, str5));
      }
      if (!str6.equals("")) {
        prefLastPuzzleLevel002 = Integer.parseInt(modCommon.dkryp(paramContext, str6));
      }
      if (!str7.equals("")) {
        prefHighestPuzzleLevel002 = Integer.parseInt(modCommon.dkryp(paramContext, str8));
      }
      if (!str8.equals("")) {
        prefHighestPuzzleScore002 = Integer.parseInt(modCommon.dkryp(paramContext, str8));
      }
      if (!str9.equals("")) {
        prefLastPuzzleScore003 = Integer.parseInt(modCommon.dkryp(paramContext, str9));
      }
      if (!str10.equals("")) {
        prefLastPuzzleLevel003 = Integer.parseInt(modCommon.dkryp(paramContext, str10));
      }
      if (!str11.equals("")) {
        prefHighestPuzzleLevel003 = Integer.parseInt(modCommon.dkryp(paramContext, str12));
      }
      if (!str12.equals("")) {
        prefHighestPuzzleScore003 = Integer.parseInt(modCommon.dkryp(paramContext, str12));
      }
      if (!str13.equals("")) {
        prefLastPuzzleScore004 = Integer.parseInt(modCommon.dkryp(paramContext, str13));
      }
      if (!str14.equals("")) {
        prefLastPuzzleLevel004 = Integer.parseInt(modCommon.dkryp(paramContext, str14));
      }
      if (!str15.equals("")) {
        prefHighestPuzzleLevel004 = Integer.parseInt(modCommon.dkryp(paramContext, str16));
      }
      if (!str16.equals("")) {
        prefHighestPuzzleScore004 = Integer.parseInt(modCommon.dkryp(paramContext, str16));
      }
      if (!str17.equals("")) {
        prefLastPuzzleScore005 = Integer.parseInt(modCommon.dkryp(paramContext, str17));
      }
      if (!str18.equals("")) {
        prefLastPuzzleLevel005 = Integer.parseInt(modCommon.dkryp(paramContext, str18));
      }
      if (!str19.equals("")) {
        prefHighestPuzzleLevel005 = Integer.parseInt(modCommon.dkryp(paramContext, str20));
      }
      if (!str20.equals("")) {
        prefHighestPuzzleScore005 = Integer.parseInt(modCommon.dkryp(paramContext, str20));
      }
      if (!str21.equals("")) {
        prefLastPuzzleScore006 = Integer.parseInt(modCommon.dkryp(paramContext, str21));
      }
      if (!str22.equals("")) {
        prefLastPuzzleLevel006 = Integer.parseInt(modCommon.dkryp(paramContext, str22));
      }
      if (!str23.equals("")) {
        prefHighestPuzzleLevel006 = Integer.parseInt(modCommon.dkryp(paramContext, str24));
      }
      if (!str24.equals("")) {
        prefHighestPuzzleScore006 = Integer.parseInt(modCommon.dkryp(paramContext, str24));
      }
      if (!str25.equals("")) {
        prefLastPuzzleScore007 = Integer.parseInt(modCommon.dkryp(paramContext, str25));
      }
      if (!str26.equals("")) {
        prefLastPuzzleLevel007 = Integer.parseInt(modCommon.dkryp(paramContext, str26));
      }
      if (!str27.equals("")) {
        prefHighestPuzzleLevel007 = Integer.parseInt(modCommon.dkryp(paramContext, str28));
      }
      if (!str28.equals("")) {
        prefHighestPuzzleScore007 = Integer.parseInt(modCommon.dkryp(paramContext, str28));
      }
      if (!str29.equals("")) {
        prefLastPuzzleScore008 = Integer.parseInt(modCommon.dkryp(paramContext, str29));
      }
      if (!str30.equals("")) {
        prefLastPuzzleLevel008 = Integer.parseInt(modCommon.dkryp(paramContext, str30));
      }
      if (!str31.equals("")) {
        prefHighestPuzzleLevel008 = Integer.parseInt(modCommon.dkryp(paramContext, str32));
      }
      if (!str32.equals("")) {
        prefHighestPuzzleScore008 = Integer.parseInt(modCommon.dkryp(paramContext, str32));
      }
      if (!str33.equals("")) {
        prefLastPuzzleScore009 = Integer.parseInt(modCommon.dkryp(paramContext, str33));
      }
      if (!str34.equals("")) {
        prefLastPuzzleLevel009 = Integer.parseInt(modCommon.dkryp(paramContext, str34));
      }
      if (!str35.equals("")) {
        prefHighestPuzzleLevel009 = Integer.parseInt(modCommon.dkryp(paramContext, str36));
      }
      if (!str36.equals("")) {
        prefHighestPuzzleScore009 = Integer.parseInt(modCommon.dkryp(paramContext, str36));
      }
      if (!str37.equals("")) {
        prefLastPuzzleScore010 = Integer.parseInt(modCommon.dkryp(paramContext, str37));
      }
      if (!str38.equals("")) {
        prefLastPuzzleLevel010 = Integer.parseInt(modCommon.dkryp(paramContext, str38));
      }
      if (!str39.equals("")) {
        prefHighestPuzzleLevel010 = Integer.parseInt(modCommon.dkryp(paramContext, str40));
      }
      if (!str40.equals("")) {
        prefHighestPuzzleScore010 = Integer.parseInt(modCommon.dkryp(paramContext, str40));
      }
      if (!str41.equals("")) {
        prefLastPuzzleScore011 = Integer.parseInt(modCommon.dkryp(paramContext, str41));
      }
      if (!str42.equals("")) {
        prefLastPuzzleLevel011 = Integer.parseInt(modCommon.dkryp(paramContext, str42));
      }
      if (!str43.equals("")) {
        prefHighestPuzzleLevel011 = Integer.parseInt(modCommon.dkryp(paramContext, str44));
      }
      if (!str44.equals("")) {
        prefHighestPuzzleScore011 = Integer.parseInt(modCommon.dkryp(paramContext, str44));
      }
      if (!str45.equals("")) {
        prefLastPuzzleScore012 = Integer.parseInt(modCommon.dkryp(paramContext, str45));
      }
      if (!str46.equals("")) {
        prefLastPuzzleLevel012 = Integer.parseInt(modCommon.dkryp(paramContext, str46));
      }
      if (!str47.equals("")) {
        prefHighestPuzzleLevel012 = Integer.parseInt(modCommon.dkryp(paramContext, str48));
      }
      if (!str48.equals("")) {
        prefHighestPuzzleScore012 = Integer.parseInt(modCommon.dkryp(paramContext, str48));
      }
      if (!str49.equals("")) {
        prefLastPuzzleScore013 = Integer.parseInt(modCommon.dkryp(paramContext, str49));
      }
      if (!str50.equals("")) {
        prefLastPuzzleLevel013 = Integer.parseInt(modCommon.dkryp(paramContext, str50));
      }
      if (!str51.equals("")) {
        prefHighestPuzzleLevel013 = Integer.parseInt(modCommon.dkryp(paramContext, str52));
      }
      if (!str52.equals("")) {
        prefHighestPuzzleScore013 = Integer.parseInt(modCommon.dkryp(paramContext, str52));
      }
      if (!str53.equals("")) {
        prefLastPuzzleScore014 = Integer.parseInt(modCommon.dkryp(paramContext, str53));
      }
      if (!str54.equals("")) {
        prefLastPuzzleLevel014 = Integer.parseInt(modCommon.dkryp(paramContext, str54));
      }
      if (!str55.equals("")) {
        prefHighestPuzzleLevel014 = Integer.parseInt(modCommon.dkryp(paramContext, str56));
      }
      if (!str56.equals("")) {
        prefHighestPuzzleScore014 = Integer.parseInt(modCommon.dkryp(paramContext, str56));
      }
      if (!str57.equals("")) {
        prefLastPuzzleScore015 = Integer.parseInt(modCommon.dkryp(paramContext, str57));
      }
      if (!str58.equals("")) {
        prefLastPuzzleLevel015 = Integer.parseInt(modCommon.dkryp(paramContext, str58));
      }
      if (!str59.equals("")) {
        prefHighestPuzzleLevel015 = Integer.parseInt(modCommon.dkryp(paramContext, str60));
      }
      if (!str60.equals("")) {
        prefHighestPuzzleScore015 = Integer.parseInt(modCommon.dkryp(paramContext, str60));
      }
      if (!str61.equals("")) {
        prefLastPuzzleScore016 = Integer.parseInt(modCommon.dkryp(paramContext, str61));
      }
      if (!str62.equals("")) {
        prefLastPuzzleLevel016 = Integer.parseInt(modCommon.dkryp(paramContext, str62));
      }
      if (!str63.equals("")) {
        prefHighestPuzzleLevel016 = Integer.parseInt(modCommon.dkryp(paramContext, str64));
      }
      if (!str64.equals("")) {
        prefHighestPuzzleScore016 = Integer.parseInt(modCommon.dkryp(paramContext, str64));
      }
      if (!str65.equals("")) {
        prefLastPuzzleScore017 = Integer.parseInt(modCommon.dkryp(paramContext, str65));
      }
      if (!str66.equals("")) {
        prefLastPuzzleLevel017 = Integer.parseInt(modCommon.dkryp(paramContext, str66));
      }
      if (!str67.equals("")) {
        prefHighestPuzzleLevel017 = Integer.parseInt(modCommon.dkryp(paramContext, str68));
      }
      if (!str68.equals("")) {
        prefHighestPuzzleScore017 = Integer.parseInt(modCommon.dkryp(paramContext, str68));
      }
      if (!str69.equals("")) {
        prefLastPuzzleScore018 = Integer.parseInt(modCommon.dkryp(paramContext, str69));
      }
      if (!str70.equals("")) {
        prefLastPuzzleLevel018 = Integer.parseInt(modCommon.dkryp(paramContext, str70));
      }
      if (!str71.equals("")) {
        prefHighestPuzzleLevel018 = Integer.parseInt(modCommon.dkryp(paramContext, str72));
      }
      if (!str72.equals("")) {
        prefHighestPuzzleScore018 = Integer.parseInt(modCommon.dkryp(paramContext, str72));
      }
      if (!str73.equals("")) {
        prefLastPuzzleScore019 = Integer.parseInt(modCommon.dkryp(paramContext, str73));
      }
      if (!str74.equals("")) {
        prefLastPuzzleLevel019 = Integer.parseInt(modCommon.dkryp(paramContext, str74));
      }
      if (!str75.equals("")) {
        prefHighestPuzzleLevel019 = Integer.parseInt(modCommon.dkryp(paramContext, str76));
      }
      if (!str76.equals("")) {
        prefHighestPuzzleScore019 = Integer.parseInt(modCommon.dkryp(paramContext, str76));
      }
      if (!str77.equals("")) {
        prefLastPuzzleScore020 = Integer.parseInt(modCommon.dkryp(paramContext, str77));
      }
      if (!str78.equals("")) {
        prefLastPuzzleLevel020 = Integer.parseInt(modCommon.dkryp(paramContext, str78));
      }
      if (!str79.equals("")) {
        prefHighestPuzzleLevel020 = Integer.parseInt(modCommon.dkryp(paramContext, str80));
      }
      if (!str80.equals("")) {
        prefHighestPuzzleScore020 = Integer.parseInt(modCommon.dkryp(paramContext, str80));
      }
      if (!str81.equals("")) {
        prefLastPuzzleScore021 = Integer.parseInt(modCommon.dkryp(paramContext, str81));
      }
      if (!str82.equals("")) {
        prefLastPuzzleLevel021 = Integer.parseInt(modCommon.dkryp(paramContext, str82));
      }
      if (!str83.equals("")) {
        prefHighestPuzzleLevel021 = Integer.parseInt(modCommon.dkryp(paramContext, str84));
      }
      if (!str84.equals("")) {
        prefHighestPuzzleScore021 = Integer.parseInt(modCommon.dkryp(paramContext, str84));
      }
      if (!str85.equals("")) {
        prefLastPuzzleScore022 = Integer.parseInt(modCommon.dkryp(paramContext, str85));
      }
      if (!str86.equals("")) {
        prefLastPuzzleLevel022 = Integer.parseInt(modCommon.dkryp(paramContext, str86));
      }
      if (!str87.equals("")) {
        prefHighestPuzzleLevel022 = Integer.parseInt(modCommon.dkryp(paramContext, str88));
      }
      if (!str88.equals("")) {
        prefHighestPuzzleScore022 = Integer.parseInt(modCommon.dkryp(paramContext, str88));
      }
    }
    catch (NumberFormatException paramContext)
    {
      for (;;)
      {
        modCommon.Log_e(paramContext.getMessage());
        paramContext.printStackTrace();
      }
    }
    prefStartCount = localSharedPreferences.getInt("prefStartCount", 0);
    prefGameCount = localSharedPreferences.getInt("prefGameCount", 0);
    prefAskedMarketCount = localSharedPreferences.getInt("prefAskedMarketCount", 0);
    prefAsk4RateNeverAskAgain = localSharedPreferences.getBoolean("prefAsk4RateNeverAskAgain", false);
  }
  
  public static void savePreferences(Context paramContext)
  {
    if (savingPrefs) {
      return;
    }
    savingPrefs = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putBoolean("AboutAtStart", prefAboutAtStart);
    localEditor.putInt("prefVolumeLevel", prefVolumeLevel);
    localEditor.putInt("prefBestScoreChallenge", prefBestArcadeScore);
    localEditor.putInt("prefBestLevelChallenge", prefBestArcadeLevel);
    localEditor.putBoolean("prefArcadeUnlocked", prefArcadeUnlocked);
    localEditor.putBoolean("prefPuzzleLevel002Unlocked", prefPuzzleLevel002Unlocked);
    localEditor.putBoolean("prefPuzzleLevel003Unlocked", prefPuzzleLevel003Unlocked);
    localEditor.putBoolean("prefPuzzleLevel004Unlocked", prefPuzzleLevel004Unlocked);
    localEditor.putBoolean("prefPuzzleLevel005Unlocked", prefPuzzleLevel005Unlocked);
    localEditor.putBoolean("prefPuzzleLevel006Unlocked", prefPuzzleLevel006Unlocked);
    localEditor.putBoolean("prefPuzzleLevel007Unlocked", prefPuzzleLevel007Unlocked);
    localEditor.putBoolean("prefPuzzleLevel008Unlocked", prefPuzzleLevel008Unlocked);
    localEditor.putBoolean("prefPuzzleLevel009Unlocked", prefPuzzleLevel009Unlocked);
    localEditor.putBoolean("prefPuzzleLevel010Unlocked", prefPuzzleLevel010Unlocked);
    localEditor.putBoolean("prefPuzzleLevel011Unlocked", prefPuzzleLevel011Unlocked);
    localEditor.putBoolean("prefPuzzleLevel012Unlocked", prefPuzzleLevel012Unlocked);
    localEditor.putBoolean("prefPuzzleLevel013Unlocked", prefPuzzleLevel013Unlocked);
    localEditor.putBoolean("prefPuzzleLevel014Unlocked", prefPuzzleLevel014Unlocked);
    localEditor.putBoolean("prefPuzzleLevel015Unlocked", prefPuzzleLevel015Unlocked);
    localEditor.putBoolean("prefPuzzleLevel016Unlocked", prefPuzzleLevel016Unlocked);
    localEditor.putBoolean("prefPuzzleLevel017Unlocked", prefPuzzleLevel017Unlocked);
    localEditor.putBoolean("prefPuzzleLevel018Unlocked", prefPuzzleLevel018Unlocked);
    localEditor.putBoolean("prefPuzzleLevel019Unlocked", prefPuzzleLevel019Unlocked);
    localEditor.putBoolean("prefPuzzleLevel020Unlocked", prefPuzzleLevel020Unlocked);
    localEditor.putBoolean("prefPuzzleLevel021Unlocked", prefPuzzleLevel021Unlocked);
    localEditor.putBoolean("prefPuzzleLevel022Unlocked", prefPuzzleLevel022Unlocked);
    localEditor.putString("KprefLastPuzzleScore", modCommon.kryp(paramContext, prefLastPuzzleScore));
    localEditor.putString("KprefLastPuzzleLevel", modCommon.kryp(paramContext, prefLastPuzzleLevel));
    localEditor.putString("KprefHighestPuzzleLevel", modCommon.kryp(paramContext, prefHighestPuzzleLevel));
    localEditor.putString("KprefHighestPuzzleScore", modCommon.kryp(paramContext, prefHighestPuzzleScore));
    localEditor.putString("KprefLastPuzzleScore002", modCommon.kryp(paramContext, prefLastPuzzleScore002));
    localEditor.putString("KprefLastPuzzleLevel002", modCommon.kryp(paramContext, prefLastPuzzleLevel002));
    localEditor.putString("KprefHighestPuzzleLevel002", modCommon.kryp(paramContext, prefHighestPuzzleLevel002));
    localEditor.putString("KprefHighestPuzzleScore002", modCommon.kryp(paramContext, prefHighestPuzzleScore002));
    localEditor.putString("KprefLastPuzzleScore003", modCommon.kryp(paramContext, prefLastPuzzleScore003));
    localEditor.putString("KprefLastPuzzleLevel003", modCommon.kryp(paramContext, prefLastPuzzleLevel003));
    localEditor.putString("KprefHighestPuzzleLevel003", modCommon.kryp(paramContext, prefHighestPuzzleLevel003));
    localEditor.putString("KprefHighestPuzzleScore003", modCommon.kryp(paramContext, prefHighestPuzzleScore003));
    localEditor.putString("KprefLastPuzzleScore004", modCommon.kryp(paramContext, prefLastPuzzleScore004));
    localEditor.putString("KprefLastPuzzleLevel004", modCommon.kryp(paramContext, prefLastPuzzleLevel004));
    localEditor.putString("KprefHighestPuzzleLevel004", modCommon.kryp(paramContext, prefHighestPuzzleLevel004));
    localEditor.putString("KprefHighestPuzzleScore004", modCommon.kryp(paramContext, prefHighestPuzzleScore004));
    localEditor.putString("KprefLastPuzzleScore005", modCommon.kryp(paramContext, prefLastPuzzleScore005));
    localEditor.putString("KprefLastPuzzleLevel005", modCommon.kryp(paramContext, prefLastPuzzleLevel005));
    localEditor.putString("KprefHighestPuzzleLevel005", modCommon.kryp(paramContext, prefHighestPuzzleLevel005));
    localEditor.putString("KprefHighestPuzzleScore005", modCommon.kryp(paramContext, prefHighestPuzzleScore005));
    localEditor.putString("KprefLastPuzzleScore006", modCommon.kryp(paramContext, prefLastPuzzleScore006));
    localEditor.putString("KprefLastPuzzleLevel006", modCommon.kryp(paramContext, prefLastPuzzleLevel006));
    localEditor.putString("KprefHighestPuzzleLevel006", modCommon.kryp(paramContext, prefHighestPuzzleLevel006));
    localEditor.putString("KprefHighestPuzzleScore006", modCommon.kryp(paramContext, prefHighestPuzzleScore006));
    localEditor.putString("KprefLastPuzzleScore007", modCommon.kryp(paramContext, prefLastPuzzleScore007));
    localEditor.putString("KprefLastPuzzleLevel007", modCommon.kryp(paramContext, prefLastPuzzleLevel007));
    localEditor.putString("KprefHighestPuzzleLevel007", modCommon.kryp(paramContext, prefHighestPuzzleLevel007));
    localEditor.putString("KprefHighestPuzzleScore007", modCommon.kryp(paramContext, prefHighestPuzzleScore007));
    localEditor.putString("KprefLastPuzzleScore008", modCommon.kryp(paramContext, prefLastPuzzleScore008));
    localEditor.putString("KprefLastPuzzleLevel008", modCommon.kryp(paramContext, prefLastPuzzleLevel008));
    localEditor.putString("KprefHighestPuzzleLevel008", modCommon.kryp(paramContext, prefHighestPuzzleLevel008));
    localEditor.putString("KprefHighestPuzzleScore008", modCommon.kryp(paramContext, prefHighestPuzzleScore008));
    localEditor.putString("KprefLastPuzzleScore009", modCommon.kryp(paramContext, prefLastPuzzleScore009));
    localEditor.putString("KprefLastPuzzleLevel009", modCommon.kryp(paramContext, prefLastPuzzleLevel009));
    localEditor.putString("KprefHighestPuzzleLevel009", modCommon.kryp(paramContext, prefHighestPuzzleLevel009));
    localEditor.putString("KprefHighestPuzzleScore009", modCommon.kryp(paramContext, prefHighestPuzzleScore009));
    localEditor.putString("KprefLastPuzzleScore010", modCommon.kryp(paramContext, prefLastPuzzleScore010));
    localEditor.putString("KprefLastPuzzleLevel010", modCommon.kryp(paramContext, prefLastPuzzleLevel010));
    localEditor.putString("KprefHighestPuzzleLevel010", modCommon.kryp(paramContext, prefHighestPuzzleLevel010));
    localEditor.putString("KprefHighestPuzzleScore010", modCommon.kryp(paramContext, prefHighestPuzzleScore010));
    localEditor.putString("KprefLastPuzzleScore011", modCommon.kryp(paramContext, prefLastPuzzleScore011));
    localEditor.putString("KprefLastPuzzleLevel011", modCommon.kryp(paramContext, prefLastPuzzleLevel011));
    localEditor.putString("KprefHighestPuzzleLevel011", modCommon.kryp(paramContext, prefHighestPuzzleLevel011));
    localEditor.putString("KprefHighestPuzzleScore011", modCommon.kryp(paramContext, prefHighestPuzzleScore011));
    localEditor.putString("KprefLastPuzzleScore012", modCommon.kryp(paramContext, prefLastPuzzleScore012));
    localEditor.putString("KprefLastPuzzleLevel012", modCommon.kryp(paramContext, prefLastPuzzleLevel012));
    localEditor.putString("KprefHighestPuzzleLevel012", modCommon.kryp(paramContext, prefHighestPuzzleLevel012));
    localEditor.putString("KprefHighestPuzzleScore012", modCommon.kryp(paramContext, prefHighestPuzzleScore012));
    localEditor.putString("KprefLastPuzzleScore013", modCommon.kryp(paramContext, prefLastPuzzleScore013));
    localEditor.putString("KprefLastPuzzleLevel013", modCommon.kryp(paramContext, prefLastPuzzleLevel013));
    localEditor.putString("KprefHighestPuzzleLevel013", modCommon.kryp(paramContext, prefHighestPuzzleLevel013));
    localEditor.putString("KprefHighestPuzzleScore013", modCommon.kryp(paramContext, prefHighestPuzzleScore013));
    localEditor.putString("KprefLastPuzzleScore014", modCommon.kryp(paramContext, prefLastPuzzleScore014));
    localEditor.putString("KprefLastPuzzleLevel014", modCommon.kryp(paramContext, prefLastPuzzleLevel014));
    localEditor.putString("KprefHighestPuzzleLevel014", modCommon.kryp(paramContext, prefHighestPuzzleLevel014));
    localEditor.putString("KprefHighestPuzzleScore014", modCommon.kryp(paramContext, prefHighestPuzzleScore014));
    localEditor.putString("KprefLastPuzzleScore015", modCommon.kryp(paramContext, prefLastPuzzleScore015));
    localEditor.putString("KprefLastPuzzleLevel015", modCommon.kryp(paramContext, prefLastPuzzleLevel015));
    localEditor.putString("KprefHighestPuzzleLevel015", modCommon.kryp(paramContext, prefHighestPuzzleLevel015));
    localEditor.putString("KprefHighestPuzzleScore015", modCommon.kryp(paramContext, prefHighestPuzzleScore015));
    localEditor.putString("KprefLastPuzzleScore016", modCommon.kryp(paramContext, prefLastPuzzleScore016));
    localEditor.putString("KprefLastPuzzleLevel016", modCommon.kryp(paramContext, prefLastPuzzleLevel016));
    localEditor.putString("KprefHighestPuzzleLevel016", modCommon.kryp(paramContext, prefHighestPuzzleLevel016));
    localEditor.putString("KprefHighestPuzzleScore016", modCommon.kryp(paramContext, prefHighestPuzzleScore016));
    localEditor.putString("KprefLastPuzzleScore017", modCommon.kryp(paramContext, prefLastPuzzleScore017));
    localEditor.putString("KprefLastPuzzleLevel017", modCommon.kryp(paramContext, prefLastPuzzleLevel017));
    localEditor.putString("KprefHighestPuzzleLevel017", modCommon.kryp(paramContext, prefHighestPuzzleLevel017));
    localEditor.putString("KprefHighestPuzzleScore017", modCommon.kryp(paramContext, prefHighestPuzzleScore017));
    localEditor.putString("KprefLastPuzzleScore018", modCommon.kryp(paramContext, prefLastPuzzleScore018));
    localEditor.putString("KprefLastPuzzleLevel018", modCommon.kryp(paramContext, prefLastPuzzleLevel018));
    localEditor.putString("KprefHighestPuzzleLevel018", modCommon.kryp(paramContext, prefHighestPuzzleLevel018));
    localEditor.putString("KprefHighestPuzzleScore018", modCommon.kryp(paramContext, prefHighestPuzzleScore018));
    localEditor.putString("KprefLastPuzzleScore019", modCommon.kryp(paramContext, prefLastPuzzleScore019));
    localEditor.putString("KprefLastPuzzleLevel019", modCommon.kryp(paramContext, prefLastPuzzleLevel019));
    localEditor.putString("KprefHighestPuzzleLevel019", modCommon.kryp(paramContext, prefHighestPuzzleLevel019));
    localEditor.putString("KprefHighestPuzzleScore019", modCommon.kryp(paramContext, prefHighestPuzzleScore019));
    localEditor.putString("KprefLastPuzzleScore020", modCommon.kryp(paramContext, prefLastPuzzleScore020));
    localEditor.putString("KprefLastPuzzleLevel020", modCommon.kryp(paramContext, prefLastPuzzleLevel020));
    localEditor.putString("KprefHighestPuzzleLevel020", modCommon.kryp(paramContext, prefHighestPuzzleLevel020));
    localEditor.putString("KprefHighestPuzzleScore020", modCommon.kryp(paramContext, prefHighestPuzzleScore020));
    localEditor.putString("KprefLastPuzzleScore021", modCommon.kryp(paramContext, prefLastPuzzleScore021));
    localEditor.putString("KprefLastPuzzleLevel021", modCommon.kryp(paramContext, prefLastPuzzleLevel021));
    localEditor.putString("KprefHighestPuzzleLevel021", modCommon.kryp(paramContext, prefHighestPuzzleLevel021));
    localEditor.putString("KprefHighestPuzzleScore021", modCommon.kryp(paramContext, prefHighestPuzzleScore021));
    localEditor.putString("KprefLastPuzzleScore022", modCommon.kryp(paramContext, prefLastPuzzleScore022));
    localEditor.putString("KprefLastPuzzleLevel022", modCommon.kryp(paramContext, prefLastPuzzleLevel022));
    localEditor.putString("KprefHighestPuzzleLevel022", modCommon.kryp(paramContext, prefHighestPuzzleLevel022));
    localEditor.putString("KprefHighestPuzzleScore022", modCommon.kryp(paramContext, prefHighestPuzzleScore022));
    localEditor.putInt("prefStartCount", prefStartCount);
    localEditor.putInt("prefGameCount", prefGameCount);
    localEditor.putInt("prefAskedMarketCount", prefAskedMarketCount);
    localEditor.putBoolean("prefAsk4RateNeverAskAgain", prefAsk4RateNeverAskAgain);
    localEditor.commit();
    savingPrefs = false;
  }
  
  public static void setLevelPuzzleInfos(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    modCommon.Log_d("Save level pref, Level, levelPack:" + paramInt2 + " Score:" + paramInt3 + " levelPack:" + paramInt1);
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      prefLastPuzzleLevel = paramInt2;
      prefLastPuzzleScore = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel)
      {
        prefHighestPuzzleLevel = paramInt2;
        prefHighestPuzzleScore = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 2: 
      prefLastPuzzleLevel002 = paramInt2;
      prefLastPuzzleScore002 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel002)
      {
        prefHighestPuzzleLevel002 = paramInt2;
        prefHighestPuzzleScore002 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 3: 
      prefLastPuzzleLevel003 = paramInt2;
      prefLastPuzzleScore003 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel003)
      {
        prefHighestPuzzleLevel003 = paramInt2;
        prefHighestPuzzleScore003 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 4: 
      prefLastPuzzleLevel004 = paramInt2;
      prefLastPuzzleScore004 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel004)
      {
        prefHighestPuzzleLevel004 = paramInt2;
        prefHighestPuzzleScore004 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 5: 
      prefLastPuzzleLevel005 = paramInt2;
      prefLastPuzzleScore005 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel005)
      {
        prefHighestPuzzleLevel005 = paramInt2;
        prefHighestPuzzleScore005 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 6: 
      prefLastPuzzleLevel006 = paramInt2;
      prefLastPuzzleScore006 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel006)
      {
        prefHighestPuzzleLevel006 = paramInt2;
        prefHighestPuzzleScore006 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 7: 
      prefLastPuzzleLevel007 = paramInt2;
      prefLastPuzzleScore007 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel007)
      {
        prefHighestPuzzleLevel007 = paramInt2;
        prefHighestPuzzleScore007 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 8: 
      prefLastPuzzleLevel008 = paramInt2;
      prefLastPuzzleScore008 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel008)
      {
        prefHighestPuzzleLevel008 = paramInt2;
        prefHighestPuzzleScore008 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 9: 
      prefLastPuzzleLevel009 = paramInt2;
      prefLastPuzzleScore009 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel009)
      {
        prefHighestPuzzleLevel009 = paramInt2;
        prefHighestPuzzleScore009 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 10: 
      prefLastPuzzleLevel010 = paramInt2;
      prefLastPuzzleScore010 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel010)
      {
        prefHighestPuzzleLevel010 = paramInt2;
        prefHighestPuzzleScore010 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 11: 
      prefLastPuzzleLevel011 = paramInt2;
      prefLastPuzzleScore011 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel011)
      {
        prefHighestPuzzleLevel011 = paramInt2;
        prefHighestPuzzleScore011 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 12: 
      prefLastPuzzleLevel012 = paramInt2;
      prefLastPuzzleScore012 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel012)
      {
        prefHighestPuzzleLevel012 = paramInt2;
        prefHighestPuzzleScore012 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 13: 
      prefLastPuzzleLevel013 = paramInt2;
      prefLastPuzzleScore013 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel013)
      {
        prefHighestPuzzleLevel013 = paramInt2;
        prefHighestPuzzleScore013 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 14: 
      prefLastPuzzleLevel014 = paramInt2;
      prefLastPuzzleScore014 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel014)
      {
        prefHighestPuzzleLevel014 = paramInt2;
        prefHighestPuzzleScore014 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 15: 
      prefLastPuzzleLevel015 = paramInt2;
      prefLastPuzzleScore015 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel015)
      {
        prefHighestPuzzleLevel015 = paramInt2;
        prefHighestPuzzleScore015 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 16: 
      prefLastPuzzleLevel016 = paramInt2;
      prefLastPuzzleScore016 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel016)
      {
        prefHighestPuzzleLevel016 = paramInt2;
        prefHighestPuzzleScore016 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 17: 
      prefLastPuzzleLevel017 = paramInt2;
      prefLastPuzzleScore017 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel017)
      {
        prefHighestPuzzleLevel017 = paramInt2;
        prefHighestPuzzleScore017 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 18: 
      prefLastPuzzleLevel018 = paramInt2;
      prefLastPuzzleScore018 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel018)
      {
        prefHighestPuzzleLevel018 = paramInt2;
        prefHighestPuzzleScore018 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 19: 
      prefLastPuzzleLevel019 = paramInt2;
      prefLastPuzzleScore019 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel019)
      {
        prefHighestPuzzleLevel019 = paramInt2;
        prefHighestPuzzleScore019 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 20: 
      prefLastPuzzleLevel020 = paramInt2;
      prefLastPuzzleScore020 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel020)
      {
        prefHighestPuzzleLevel020 = paramInt2;
        prefHighestPuzzleScore020 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    case 21: 
      prefLastPuzzleLevel021 = paramInt2;
      prefLastPuzzleScore021 = paramInt3;
      if (paramInt2 >= prefHighestPuzzleLevel021)
      {
        prefHighestPuzzleLevel021 = paramInt2;
        prefHighestPuzzleScore021 = paramInt3;
      }
      savePreferences(paramContext);
      return;
    }
    prefLastPuzzleLevel022 = paramInt2;
    prefLastPuzzleScore022 = paramInt3;
    if (paramInt2 >= prefHighestPuzzleLevel022)
    {
      prefHighestPuzzleLevel022 = paramInt2;
      prefHighestPuzzleScore022 = paramInt3;
    }
    savePreferences(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/modPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */