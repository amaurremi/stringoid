package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class mo
  implements SafeParcelable
{
  public static final mp CREATOR = new mp();
  public static final mo afA;
  public static final mo afB;
  public static final mo afC;
  public static final mo afD;
  public static final mo afE;
  public static final mo afF;
  public static final mo afG;
  public static final mo afH;
  public static final mo afI;
  public static final mo afJ;
  public static final mo afK;
  public static final mo afL;
  public static final mo afM;
  public static final mo afN;
  public static final mo afO;
  public static final mo afP;
  public static final mo afQ;
  public static final mo afR;
  public static final mo afS;
  public static final mo afT;
  public static final mo afU;
  public static final mo afV;
  public static final mo afW;
  public static final mo afX;
  public static final mo afY;
  public static final mo afZ;
  public static final mo afr = bW("accounting");
  public static final mo afs = bW("airport");
  public static final mo aft = bW("amusement_park");
  public static final mo afu = bW("aquarium");
  public static final mo afv = bW("art_gallery");
  public static final mo afw = bW("atm");
  public static final mo afx = bW("bakery");
  public static final mo afy = bW("bank");
  public static final mo afz = bW("bar");
  public static final mo agA;
  public static final mo agB;
  public static final mo agC;
  public static final mo agD;
  public static final mo agE;
  public static final mo agF;
  public static final mo agG;
  public static final mo agH;
  public static final mo agI;
  public static final mo agJ;
  public static final mo agK;
  public static final mo agL;
  public static final mo agM;
  public static final mo agN;
  public static final mo agO;
  public static final mo agP;
  public static final mo agQ;
  public static final mo agR;
  public static final mo agS;
  public static final mo agT;
  public static final mo agU;
  public static final mo agV;
  public static final mo agW;
  public static final mo agX;
  public static final mo agY;
  public static final mo agZ;
  public static final mo aga;
  public static final mo agb;
  public static final mo agc;
  public static final mo agd;
  public static final mo age;
  public static final mo agf;
  public static final mo agg;
  public static final mo agh;
  public static final mo agi;
  public static final mo agj;
  public static final mo agk;
  public static final mo agl;
  public static final mo agm;
  public static final mo agn;
  public static final mo ago;
  public static final mo agp;
  public static final mo agq;
  public static final mo agr;
  public static final mo ags;
  public static final mo agt;
  public static final mo agu;
  public static final mo agv;
  public static final mo agw;
  public static final mo agx;
  public static final mo agy;
  public static final mo agz;
  public static final mo ahA;
  public static final mo ahB;
  public static final mo ahC;
  public static final mo ahD;
  public static final mo ahE;
  public static final mo ahF;
  public static final mo ahG;
  public static final mo ahH;
  public static final mo ahI;
  public static final mo ahJ;
  public static final mo ahK;
  public static final mo ahL;
  public static final mo ahM;
  public static final mo aha;
  public static final mo ahb;
  public static final mo ahc;
  public static final mo ahd;
  public static final mo ahe;
  public static final mo ahf;
  public static final mo ahg;
  public static final mo ahh;
  public static final mo ahi;
  public static final mo ahj;
  public static final mo ahk;
  public static final mo ahl;
  public static final mo ahm;
  public static final mo ahn;
  public static final mo aho;
  public static final mo ahp;
  public static final mo ahq;
  public static final mo ahr;
  public static final mo ahs;
  public static final mo aht;
  public static final mo ahu;
  public static final mo ahv;
  public static final mo ahw;
  public static final mo ahx;
  public static final mo ahy;
  public static final mo ahz;
  final int BR;
  final String uO;
  
  static
  {
    afA = bW("beauty_salon");
    afB = bW("bicycle_store");
    afC = bW("book_store");
    afD = bW("bowling_alley");
    afE = bW("bus_station");
    afF = bW("cafe");
    afG = bW("campground");
    afH = bW("car_dealer");
    afI = bW("car_rental");
    afJ = bW("car_repair");
    afK = bW("car_wash");
    afL = bW("casino");
    afM = bW("cemetery");
    afN = bW("church");
    afO = bW("city_hall");
    afP = bW("clothing_store");
    afQ = bW("convenience_store");
    afR = bW("courthouse");
    afS = bW("dentist");
    afT = bW("department_store");
    afU = bW("doctor");
    afV = bW("electrician");
    afW = bW("electronics_store");
    afX = bW("embassy");
    afY = bW("establishment");
    afZ = bW("finance");
    aga = bW("fire_station");
    agb = bW("florist");
    agc = bW("food");
    agd = bW("funeral_home");
    age = bW("furniture_store");
    agf = bW("gas_station");
    agg = bW("general_contractor");
    agh = bW("grocery_or_supermarket");
    agi = bW("gym");
    agj = bW("hair_care");
    agk = bW("hardware_store");
    agl = bW("health");
    agm = bW("hindu_temple");
    agn = bW("home_goods_store");
    ago = bW("hospital");
    agp = bW("insurance_agency");
    agq = bW("jewelry_store");
    agr = bW("laundry");
    ags = bW("lawyer");
    agt = bW("library");
    agu = bW("liquor_store");
    agv = bW("local_government_office");
    agw = bW("locksmith");
    agx = bW("lodging");
    agy = bW("meal_delivery");
    agz = bW("meal_takeaway");
    agA = bW("mosque");
    agB = bW("movie_rental");
    agC = bW("movie_theater");
    agD = bW("moving_company");
    agE = bW("museum");
    agF = bW("night_club");
    agG = bW("painter");
    agH = bW("park");
    agI = bW("parking");
    agJ = bW("pet_store");
    agK = bW("pharmacy");
    agL = bW("physiotherapist");
    agM = bW("place_of_worship");
    agN = bW("plumber");
    agO = bW("police");
    agP = bW("post_office");
    agQ = bW("real_estate_agency");
    agR = bW("restaurant");
    agS = bW("roofing_contractor");
    agT = bW("rv_park");
    agU = bW("school");
    agV = bW("shoe_store");
    agW = bW("shopping_mall");
    agX = bW("spa");
    agY = bW("stadium");
    agZ = bW("storage");
    aha = bW("store");
    ahb = bW("subway_station");
    ahc = bW("synagogue");
    ahd = bW("taxi_stand");
    ahe = bW("train_station");
    ahf = bW("travel_agency");
    ahg = bW("university");
    ahh = bW("veterinary_care");
    ahi = bW("zoo");
    ahj = bW("administrative_area_level_1");
    ahk = bW("administrative_area_level_2");
    ahl = bW("administrative_area_level_3");
    ahm = bW("colloquial_area");
    ahn = bW("country");
    aho = bW("floor");
    ahp = bW("geocode");
    ahq = bW("intersection");
    ahr = bW("locality");
    ahs = bW("natural_feature");
    aht = bW("neighborhood");
    ahu = bW("political");
    ahv = bW("point_of_interest");
    ahw = bW("post_box");
    ahx = bW("postal_code");
    ahy = bW("postal_code_prefix");
    ahz = bW("postal_town");
    ahA = bW("premise");
    ahB = bW("room");
    ahC = bW("route");
    ahD = bW("street_address");
    ahE = bW("sublocality");
    ahF = bW("sublocality_level_1");
    ahG = bW("sublocality_level_2");
    ahH = bW("sublocality_level_3");
    ahI = bW("sublocality_level_4");
    ahJ = bW("sublocality_level_5");
    ahK = bW("subpremise");
    ahL = bW("transit_station");
    ahM = bW("other");
  }
  
  mo(int paramInt, String paramString)
  {
    n.aZ(paramString);
    this.BR = paramInt;
    this.uO = paramString;
  }
  
  public static mo bW(String paramString)
  {
    return new mo(0, paramString);
  }
  
  public int describeContents()
  {
    mp localmp = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof mo)) && (this.uO.equals(((mo)paramObject).uO));
  }
  
  public int hashCode()
  {
    return this.uO.hashCode();
  }
  
  public String toString()
  {
    return this.uO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mp localmp = CREATOR;
    mp.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */