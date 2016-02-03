package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class mo
        implements SafeParcelable {
    public static final mo A;
    public static final mo B;
    public static final mo C;
    public static final rg CREATOR = new rg();
    public static final mo D;
    public static final mo E;
    public static final mo F;
    public static final mo G;
    public static final mo H;
    public static final mo I;
    public static final mo J;
    public static final mo K;
    public static final mo L;
    public static final mo M;
    public static final mo N;
    public static final mo O;
    public static final mo P;
    public static final mo Q;
    public static final mo R;
    public static final mo S;
    public static final mo T;
    public static final mo U;
    public static final mo V;
    public static final mo W;
    public static final mo X;
    public static final mo Y;
    public static final mo Z;
    public static final mo a = a("accounting");
    public static final mo aA;
    public static final mo aB;
    public static final mo aC;
    public static final mo aD;
    public static final mo aE;
    public static final mo aF;
    public static final mo aG;
    public static final mo aH;
    public static final mo aI;
    public static final mo aJ;
    public static final mo aK;
    public static final mo aL;
    public static final mo aM;
    public static final mo aN;
    public static final mo aO;
    public static final mo aP;
    public static final mo aQ;
    public static final mo aR;
    public static final mo aS;
    public static final mo aT;
    public static final mo aU;
    public static final mo aV;
    public static final mo aW;
    public static final mo aX;
    public static final mo aY;
    public static final mo aZ;
    public static final mo aa;
    public static final mo ab;
    public static final mo ac;
    public static final mo ad;
    public static final mo ae;
    public static final mo af;
    public static final mo ag;
    public static final mo ah;
    public static final mo ai;
    public static final mo aj;
    public static final mo ak;
    public static final mo al;
    public static final mo am;
    public static final mo an;
    public static final mo ao;
    public static final mo ap;
    public static final mo aq;
    public static final mo ar;
    public static final mo as;
    public static final mo at;
    public static final mo au;
    public static final mo av;
    public static final mo aw;
    public static final mo ax;
    public static final mo ay;
    public static final mo az;
    public static final mo b = a("airport");
    public static final mo ba;
    public static final mo bb;
    public static final mo bc;
    public static final mo bd;
    public static final mo be;
    public static final mo bf;
    public static final mo bg;
    public static final mo bh;
    public static final mo bi;
    public static final mo bj;
    public static final mo bk;
    public static final mo bl;
    public static final mo bm;
    public static final mo bn;
    public static final mo bo;
    public static final mo bp;
    public static final mo bq;
    public static final mo br;
    public static final mo bs;
    public static final mo bt;
    public static final mo bu;
    public static final mo bv;
    public static final mo c = a("amusement_park");
    public static final mo d = a("aquarium");
    public static final mo e = a("art_gallery");
    public static final mo f = a("atm");
    public static final mo g = a("bakery");
    public static final mo h = a("bank");
    public static final mo i = a("bar");
    public static final mo j = a("beauty_salon");
    public static final mo k = a("bicycle_store");
    public static final mo l = a("book_store");
    public static final mo m = a("bowling_alley");
    public static final mo n = a("bus_station");
    public static final mo o = a("cafe");
    public static final mo p = a("campground");
    public static final mo q = a("car_dealer");
    public static final mo r = a("car_rental");
    public static final mo s = a("car_repair");
    public static final mo t = a("car_wash");
    public static final mo u = a("casino");
    public static final mo v = a("cemetery");
    public static final mo w = a("church");
    public static final mo x = a("city_hall");
    public static final mo y = a("clothing_store");
    public static final mo z = a("convenience_store");
    final int bw;
    final String bx;

    static {
        A = a("courthouse");
        B = a("dentist");
        C = a("department_store");
        D = a("doctor");
        E = a("electrician");
        F = a("electronics_store");
        G = a("embassy");
        H = a("establishment");
        I = a("finance");
        J = a("fire_station");
        K = a("florist");
        L = a("food");
        M = a("funeral_home");
        N = a("furniture_store");
        O = a("gas_station");
        P = a("general_contractor");
        Q = a("grocery_or_supermarket");
        R = a("gym");
        S = a("hair_care");
        T = a("hardware_store");
        U = a("health");
        V = a("hindu_temple");
        W = a("home_goods_store");
        X = a("hospital");
        Y = a("insurance_agency");
        Z = a("jewelry_store");
        aa = a("laundry");
        ab = a("lawyer");
        ac = a("library");
        ad = a("liquor_store");
        ae = a("local_government_office");
        af = a("locksmith");
        ag = a("lodging");
        ah = a("meal_delivery");
        ai = a("meal_takeaway");
        aj = a("mosque");
        ak = a("movie_rental");
        al = a("movie_theater");
        am = a("moving_company");
        an = a("museum");
        ao = a("night_club");
        ap = a("painter");
        aq = a("park");
        ar = a("parking");
        as = a("pet_store");
        at = a("pharmacy");
        au = a("physiotherapist");
        av = a("place_of_worship");
        aw = a("plumber");
        ax = a("police");
        ay = a("post_office");
        az = a("real_estate_agency");
        aA = a("restaurant");
        aB = a("roofing_contractor");
        aC = a("rv_park");
        aD = a("school");
        aE = a("shoe_store");
        aF = a("shopping_mall");
        aG = a("spa");
        aH = a("stadium");
        aI = a("storage");
        aJ = a("store");
        aK = a("subway_station");
        aL = a("synagogue");
        aM = a("taxi_stand");
        aN = a("train_station");
        aO = a("travel_agency");
        aP = a("university");
        aQ = a("veterinary_care");
        aR = a("zoo");
        aS = a("administrative_area_level_1");
        aT = a("administrative_area_level_2");
        aU = a("administrative_area_level_3");
        aV = a("colloquial_area");
        aW = a("country");
        aX = a("floor");
        aY = a("geocode");
        aZ = a("intersection");
        ba = a("locality");
        bb = a("natural_feature");
        bc = a("neighborhood");
        bd = a("political");
        be = a("point_of_interest");
        bf = a("post_box");
        bg = a("postal_code");
        bh = a("postal_code_prefix");
        bi = a("postal_town");
        bj = a("premise");
        bk = a("room");
        bl = a("route");
        bm = a("street_address");
        bn = a("sublocality");
        bo = a("sublocality_level_1");
        bp = a("sublocality_level_2");
        bq = a("sublocality_level_3");
        br = a("sublocality_level_4");
        bs = a("sublocality_level_5");
        bt = a("subpremise");
        bu = a("transit_station");
        bv = a("other");
    }

    mo(int paramInt, String paramString) {
        ag.a(paramString);
        this.bw = paramInt;
        this.bx = paramString;
    }

    public static mo a(String paramString) {
        return new mo(0, paramString);
    }

    public int describeContents() {
        rg localrg = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof mo)) && (this.bx.equals(((mo) paramObject).bx));
    }

    public int hashCode() {
        return this.bx.hashCode();
    }

    public String toString() {
        return this.bx;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rg localrg = CREATOR;
        rg.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */