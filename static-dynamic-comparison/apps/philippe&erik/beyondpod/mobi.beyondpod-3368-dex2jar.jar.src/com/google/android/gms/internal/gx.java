package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class gx
  implements SafeParcelable
{
  public static final gx AA = aq("sublocality");
  public static final gx AB = aq("sublocality_level_1");
  public static final gx AC = aq("sublocality_level_2");
  public static final gx AD = aq("sublocality_level_3");
  public static final gx AE = aq("sublocality_level_4");
  public static final gx AF = aq("sublocality_level_5");
  public static final gx AG = aq("subpremise");
  public static final gx AH = aq("transit_station");
  public static final gx Aa;
  public static final gx Ab;
  public static final gx Ac;
  public static final gx Ad;
  public static final gx Ae;
  public static final gx Af;
  public static final gx Ag;
  public static final gx Ah;
  public static final gx Ai;
  public static final gx Aj;
  public static final gx Ak;
  public static final gx Al;
  public static final gx Am;
  public static final gx An;
  public static final gx Ao;
  public static final gx Ap;
  public static final gx Aq;
  public static final gx Ar;
  public static final gx As;
  public static final gx At;
  public static final gx Au;
  public static final gx Av;
  public static final gx Aw;
  public static final gx Ax;
  public static final gx Ay;
  public static final gx Az;
  public static final gy CREATOR = new gy();
  public static final gx yA;
  public static final gx yB;
  public static final gx yC;
  public static final gx yD;
  public static final gx yE;
  public static final gx yF;
  public static final gx yG;
  public static final gx yH;
  public static final gx yI;
  public static final gx yJ;
  public static final gx yK;
  public static final gx yL;
  public static final gx yM;
  public static final gx yN;
  public static final gx yO;
  public static final gx yP;
  public static final gx yQ;
  public static final gx yR;
  public static final gx yS;
  public static final gx yT;
  public static final gx yU;
  public static final gx yV;
  public static final gx yW;
  public static final gx yX;
  public static final gx yY;
  public static final gx yZ;
  public static final gx yn = aq("accounting");
  public static final gx yo = aq("airport");
  public static final gx yp = aq("amusement_park");
  public static final gx yq = aq("aquarium");
  public static final gx yr = aq("art_gallery");
  public static final gx ys = aq("atm");
  public static final gx yt = aq("bakery");
  public static final gx yu = aq("bank");
  public static final gx yv = aq("bar");
  public static final gx yw = aq("beauty_salon");
  public static final gx yx = aq("bicycle_store");
  public static final gx yy = aq("book_store");
  public static final gx yz = aq("bowling_alley");
  public static final gx zA;
  public static final gx zB;
  public static final gx zC;
  public static final gx zD;
  public static final gx zE;
  public static final gx zF;
  public static final gx zG;
  public static final gx zH;
  public static final gx zI;
  public static final gx zJ;
  public static final gx zK;
  public static final gx zL;
  public static final gx zM;
  public static final gx zN;
  public static final gx zO;
  public static final gx zP;
  public static final gx zQ;
  public static final gx zR;
  public static final gx zS;
  public static final gx zT;
  public static final gx zU;
  public static final gx zV;
  public static final gx zW;
  public static final gx zX;
  public static final gx zY;
  public static final gx zZ;
  public static final gx za;
  public static final gx zb;
  public static final gx zc;
  public static final gx zd;
  public static final gx ze;
  public static final gx zf;
  public static final gx zg;
  public static final gx zh;
  public static final gx zi;
  public static final gx zj;
  public static final gx zk;
  public static final gx zl;
  public static final gx zm;
  public static final gx zn;
  public static final gx zo;
  public static final gx zp;
  public static final gx zq;
  public static final gx zr;
  public static final gx zs;
  public static final gx zt;
  public static final gx zu;
  public static final gx zv;
  public static final gx zw;
  public static final gx zx;
  public static final gx zy;
  public static final gx zz;
  final String AI;
  final int kg;
  
  static
  {
    yA = aq("bus_station");
    yB = aq("cafe");
    yC = aq("campground");
    yD = aq("car_dealer");
    yE = aq("car_rental");
    yF = aq("car_repair");
    yG = aq("car_wash");
    yH = aq("casino");
    yI = aq("cemetary");
    yJ = aq("church");
    yK = aq("city_hall");
    yL = aq("clothing_store");
    yM = aq("convenience_store");
    yN = aq("courthouse");
    yO = aq("dentist");
    yP = aq("department_store");
    yQ = aq("doctor");
    yR = aq("electrician");
    yS = aq("electronics_store");
    yT = aq("embassy");
    yU = aq("establishment");
    yV = aq("finance");
    yW = aq("fire_station");
    yX = aq("florist");
    yY = aq("food");
    yZ = aq("funeral_home");
    za = aq("furniture_store");
    zb = aq("gas_station");
    zc = aq("general_contractor");
    zd = aq("grocery_or_supermarket");
    ze = aq("gym");
    zf = aq("hair_care");
    zg = aq("hardware_store");
    zh = aq("health");
    zi = aq("hindu_temple");
    zj = aq("home_goods_store");
    zk = aq("hospital");
    zl = aq("insurance_agency");
    zm = aq("jewelry_store");
    zn = aq("laundry");
    zo = aq("lawyer");
    zp = aq("library");
    zq = aq("liquor_store");
    zr = aq("local_government_office");
    zs = aq("locksmith");
    zt = aq("lodging");
    zu = aq("meal_delivery");
    zv = aq("meal_takeaway");
    zw = aq("mosque");
    zx = aq("movie_rental");
    zy = aq("movie_theater");
    zz = aq("moving_company");
    zA = aq("museum");
    zB = aq("night_club");
    zC = aq("painter");
    zD = aq("park");
    zE = aq("parking");
    zF = aq("pet_store");
    zG = aq("pharmacy");
    zH = aq("physiotherapist");
    zI = aq("place_of_worship");
    zJ = aq("plumber");
    zK = aq("police");
    zL = aq("post_office");
    zM = aq("real_estate_agency");
    zN = aq("restaurant");
    zO = aq("roofing_contractor");
    zP = aq("rv_park");
    zQ = aq("school");
    zR = aq("shoe_store");
    zS = aq("shopping_mall");
    zT = aq("spa");
    zU = aq("stadium");
    zV = aq("storage");
    zW = aq("store");
    zX = aq("subway_station");
    zY = aq("synagogue");
    zZ = aq("taxi_stand");
    Aa = aq("train_station");
    Ab = aq("travel_agency");
    Ac = aq("university");
    Ad = aq("veterinary_care");
    Ae = aq("zoo");
    Af = aq("administrative_area_level_1");
    Ag = aq("administrative_area_level_2");
    Ah = aq("administrative_area_level_3");
    Ai = aq("colloquial_area");
    Aj = aq("country");
    Ak = aq("floor");
    Al = aq("geocode");
    Am = aq("intersection");
    An = aq("locality");
    Ao = aq("natural_feature");
    Ap = aq("neighborhood");
    Aq = aq("political");
    Ar = aq("point_of_interest");
    As = aq("post_box");
    At = aq("postal_code");
    Au = aq("postal_code_prefix");
    Av = aq("postal_town");
    Aw = aq("premise");
    Ax = aq("room");
    Ay = aq("route");
    Az = aq("street_address");
  }
  
  gx(int paramInt, String paramString)
  {
    eg.U(paramString);
    this.kg = paramInt;
    this.AI = paramString;
  }
  
  public static gx aq(String paramString)
  {
    return new gx(0, paramString);
  }
  
  public int describeContents()
  {
    gy localgy = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof gx)) && (this.AI.equals(((gx)paramObject).AI));
  }
  
  public int hashCode()
  {
    return this.AI.hashCode();
  }
  
  public String toString()
  {
    return this.AI;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gy localgy = CREATOR;
    gy.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */