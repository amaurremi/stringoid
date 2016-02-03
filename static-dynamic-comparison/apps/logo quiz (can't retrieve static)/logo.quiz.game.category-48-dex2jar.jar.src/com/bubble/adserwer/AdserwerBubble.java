package com.bubble.adserwer;

import android.app.Activity;
import android.content.res.Resources;
import com.bluebird.bubble.adserwer.tools.Adserwer;
import com.bluebird.bubble.adserwer.tools.ads.Ad;
import com.bluebird.bubble.adserwer.tools.ads.AppAd;
import com.bluebird.mobile.tools.CommonPreferencesName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdserwerBubble
  extends Adserwer
{
  Map<Integer, Ad> ads;
  private AdId yourAppAddId;
  
  public AdserwerBubble(AdId paramAdId, CommonPreferencesName paramCommonPreferencesName, Activity paramActivity)
  {
    super(paramCommonPreferencesName, paramActivity);
    this.yourAppAddId = paramAdId;
    this.ads = getAdsMap();
    setAds(getAdsList());
  }
  
  public AdserwerBubble(List<Ad> paramList, AdId paramAdId, CommonPreferencesName paramCommonPreferencesName, Activity paramActivity)
  {
    super(paramCommonPreferencesName, paramActivity);
    this.yourAppAddId = paramAdId;
    this.ads = new HashMap();
    paramAdId = paramList.iterator();
    while (paramAdId.hasNext())
    {
      paramCommonPreferencesName = (Ad)paramAdId.next();
      this.ads.put(Integer.valueOf(paramCommonPreferencesName.getId()), paramCommonPreferencesName);
    }
    setAds(paramList);
  }
  
  private void addIfNotMyAppAd(Ad paramAd, Map<Integer, Ad> paramMap)
  {
    if (paramAd.getId() != this.yourAppAddId.getId()) {
      paramMap.put(Integer.valueOf(paramAd.getId()), paramAd);
    }
  }
  
  private List<Ad> getAdsList()
  {
    return new ArrayList(getAdsMap().values());
  }
  
  private Map<Integer, Ad> getAdsMap()
  {
    if (this.ads == null)
    {
      this.ads = new HashMap();
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_MINIMALIST_LOSOS_QUIZ.getId(), 70, getDrawableByName("promo96x96_minimalist_logos_quiz"), getDrawableByName("promo320x50_minimalist_logos_quiz"), 3, "Minimalist Logos Quiz", "market://details?id=icomania.guess.word.icon.mania.minimalist.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DIcon%2520Pop%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_GUSS_THE_BRAND_SLOGANS.getId(), 70, getDrawableByName("promo96x96_guess_the_brand_slogans"), getDrawableByName("promo96x96_guess_the_brand_slogans"), 3, "Slogan Logo Quiz", "market://details?id=icomania.guess.word.icon.mania.brand.slogan&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DGuess%2520Slogans%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_ICON_POP.getId(), 120, getDrawableByName("promo96x96_icon_pop"), getDrawableByName("promo320x50_icon_pop"), 3, "Logo Quiz - Guess Pop Icon", "market://details?id=icon.pop.logo.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DIcon%2520Pop%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_GUESS_THE_COUNTRY.getId(), 120, getDrawableByName("promo96x96_guess_the_country"), getDrawableByName("promo320x50_guess_the_country"), 3, "Flags Quiz", "market://details?id=guess.country.flag&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DGuess%2520The%2520Country%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_ALL_WORD_GAMES.getId(), 40, getDrawableByName("promo96x96_all_word_games"), getDrawableByName("promo320x50_all_word_games"), 2, "Icomania", "market://details?id=icomania.guess.word.icon.mania.pop.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DIcon%2520Pop%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ.getId(), 150, getDrawableByName("promo96x96_logo_quiz"), getDrawableByName("promo320x50_logo_quiz"), 3, "Logo Quiz", "market://details?id=logos.quiz.companies.game&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DClassic%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LITTLE_RIDDLES.getId(), 1, getDrawableByName("promo96x96_little_riddles"), getDrawableByName("promo320x50_little_riddles"), 1, "Little Riddles", "market://details?id=little.riddles.word.icon.mania.logo.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DClassic%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_GUESS_THE_BRAND.getId(), 80, getDrawableByName("promo96x96_guess_the_brand"), getDrawableByName("promo320x50_guess_the_brand"), 3, "Guess The Brand", "market://details?id=icomania.guess.word.icon.mania.logo.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DClassic%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_WHAT_THE_RIDDLE.getId(), 70, getDrawableByName("promo96x96_what_the_riddle"), getDrawableByName("promo320x50_what_the_riddle"), 3, "What The Riddle?", "market://details?id=what.the.riddle.word.game.free.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DClassic%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_RIDDLE_ME_THAT.getId(), 70, getDrawableByName("promo96x96_riddle_me_that"), getDrawableByName("promo320x50_riddle_me_that"), 2, "Riddle Me That!", "market://details?id=riddle.me.that.word.game.logo.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DClassic%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_ICOMANIA_CELEBS.getId(), 70, getDrawableByName("promo96x96_icomania_celebs"), getDrawableByName("promo320x50_icomania_celebs"), 2, "Icomania - Guess The Celeb!", "market://details?id=icomania.guess.word.icon.mania.celebs.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DicomaniaCelebs%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_ICOMANIA_CHARACTERS.getId(), 60, getDrawableByName("promo96x96_icomania_characters"), getDrawableByName("promo320x50_icomania_characters"), 2, "Icomania - Characters", "market://details?id=icomania.guess.word.icon.mania.cartoons.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DicomaniaCharacters%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_ICOMANIA_MOVIES.getId(), 60, getDrawableByName("promo96x96_icomania_movies"), getDrawableByName("promo320x50_icomania_movies"), 3, "Icomania - Guess The Movie!", "market://details?id=icomania.guess.word.icon.mania.movie.quiz&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DicomaniaMovies%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ_CARS.getId(), 120, getDrawableByName("promo96x96_logo_quiz_cars"), getDrawableByName("promo320x50_logo_quiz_cars"), 3, "Logo Quiz - Cars", "market://details?id=logo.quiz.car.game&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DCars%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ_MUSIC.getId(), 100, getDrawableByName("promo96x96_logo_quiz_music"), getDrawableByName("promo320x50_logo_quiz_music"), 3, "Logo Quiz - Music Bands", "market://details?id=logo.quiz.music.bands.game&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DMusic%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_CRYPTEX_CHALLENGE.getId(), 90, getDrawableByName("promo96x96_cryptex"), getDrawableByName("promo320x50_cryptex"), 3, "IQ Test - Cryptex Challenge", "market://details?id=brain.teasers.logic.puzzles.riddles&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DIQ%2520test%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ_SPIRITS.getId(), 10, getDrawableByName("promo96x96_logo_quiz_spirits"), getDrawableByName("promo320x50_logo_quiz_spirits"), 1, "Logo Quiz - Spirits, Beers, Wines", "market://details?id=logo.quiz.alcohol.cigarettes&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DSpirits%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ_WORLD_FLAGS.getId(), 2, getDrawableByName("promo96x96_flag_quiz"), getDrawableByName("promo320x50_flag_quiz"), 1, "Logo Quiz - World Flags", "market://details?id=flag.quiz.world.national.names.learn&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DFlags%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ_WORLD_CAPITALS.getId(), 2, getDrawableByName("promo96x96_capitals_quiz"), getDrawableByName("promo320x50_capitals_quiz"), 1, "Logo Quiz - World Capitals", "market://details?id=capitals.quiz.world.national.names.learn&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DCapitals%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_SCARE_YOUR_FRIENDS.getId(), 5, getDrawableByName("promo96x96_scare"), getDrawableByName("promo320x50_scare"), 1, "Scare Your Friends - SHOCK!", "market://details?id=scare.your.friends.prank.maze.halloween&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DScare%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_LOGO_QUIZ_ULTIMATE.getId(), 10, getDrawableByName("promo96x96_logo_quiz_ultimate"), getDrawableByName("promo320x50_logo_quiz_ultimate"), 1, "Ultimate Logo Quiz", "market://details?id=logo.quiz.game.category&referrer=utm_source%3Dcross_promo_source%26utm_medium%3Dclick_from_application%26utm_campaign%3DUltimate%2520-%2520cross%2520promo", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_FINGERPRINT.getId(), 1, getDrawableByName("promo96x96_fingerprint"), getDrawableByName("promo320x50_fingerprint"), 1, "Fingerprint friend detector", "market://details?id=fingerprint.friend.detector", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_GUESS_THE_CHARACTER.getId(), 130, getDrawableByName("promo96x96_guess_the_character"), getDrawableByName("promo96x96_guess_the_character"), 3, "Guess The Character", "market://details?id=logo.quiz.cartoon.characters", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_GUESS_THE_MOVIE.getId(), 130, getDrawableByName("promo96x96_guess_the_movie"), getDrawableByName("promo96x96_guess_the_movie"), 3, "Guess The Movie", "market://details?id=logo.quiz.guess.movie", this.activity), this.ads);
      addIfNotMyAppAd(new AppAd(AdId.AD_ID_GUESS_THE_CELEB.getId(), 130, getDrawableByName("promo96x96_guess_the_celeb"), getDrawableByName("promo96x96_guess_the_celeb"), 3, "Guess The Celeb", "market://details?id=logo.quiz.celebrities.icons", this.activity), this.ads);
    }
    return this.ads;
  }
  
  private int getDrawableByName(String paramString)
  {
    return this.activity.getResources().getIdentifier(paramString, "drawable", this.activity.getPackageName());
  }
  
  public Ad getAd(int paramInt)
  {
    return (Ad)this.ads.get(Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/adserwer/AdserwerBubble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */