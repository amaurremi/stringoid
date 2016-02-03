package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hm
        implements SafeParcelable {
    public static final hn CREATOR = new hn();
    public static final hm OH = aZ("accounting");
    public static final hm OI = aZ("airport");
    public static final hm OJ = aZ("amusement_park");
    public static final hm OK = aZ("aquarium");
    public static final hm OL = aZ("art_gallery");
    public static final hm OM = aZ("atm");
    public static final hm ON = aZ("bakery");
    public static final hm OO = aZ("bank");
    public static final hm OP = aZ("bar");
    public static final hm OQ = aZ("beauty_salon");
    public static final hm OR = aZ("bicycle_store");
    public static final hm OS = aZ("book_store");
    public static final hm OT = aZ("bowling_alley");
    public static final hm OU = aZ("bus_station");
    public static final hm OV = aZ("cafe");
    public static final hm OW = aZ("campground");
    public static final hm OX = aZ("car_dealer");
    public static final hm OY = aZ("car_rental");
    public static final hm OZ = aZ("car_repair");
    public static final hm PA;
    public static final hm PB;
    public static final hm PC;
    public static final hm PD;
    public static final hm PE;
    public static final hm PF;
    public static final hm PG;
    public static final hm PH;
    public static final hm PI;
    public static final hm PJ;
    public static final hm PK;
    public static final hm PL;
    public static final hm PM;
    public static final hm PN;
    public static final hm PO;
    public static final hm PP;
    public static final hm PQ;
    public static final hm PR;
    public static final hm PS;
    public static final hm PT;
    public static final hm PU;
    public static final hm PV;
    public static final hm PW;
    public static final hm PX;
    public static final hm PY;
    public static final hm PZ;
    public static final hm Pa = aZ("car_wash");
    public static final hm Pb = aZ("casino");
    public static final hm Pc = aZ("cemetery");
    public static final hm Pd = aZ("church");
    public static final hm Pe = aZ("city_hall");
    public static final hm Pf = aZ("clothing_store");
    public static final hm Pg = aZ("convenience_store");
    public static final hm Ph = aZ("courthouse");
    public static final hm Pi = aZ("dentist");
    public static final hm Pj = aZ("department_store");
    public static final hm Pk = aZ("doctor");
    public static final hm Pl = aZ("electrician");
    public static final hm Pm = aZ("electronics_store");
    public static final hm Pn = aZ("embassy");
    public static final hm Po = aZ("establishment");
    public static final hm Pp = aZ("finance");
    public static final hm Pq = aZ("fire_station");
    public static final hm Pr = aZ("florist");
    public static final hm Ps = aZ("food");
    public static final hm Pt = aZ("funeral_home");
    public static final hm Pu = aZ("furniture_store");
    public static final hm Pv = aZ("gas_station");
    public static final hm Pw = aZ("general_contractor");
    public static final hm Px = aZ("grocery_or_supermarket");
    public static final hm Py = aZ("gym");
    public static final hm Pz = aZ("hair_care");
    public static final hm QA;
    public static final hm QB;
    public static final hm QC;
    public static final hm QD;
    public static final hm QE;
    public static final hm QF;
    public static final hm QG;
    public static final hm QH;
    public static final hm QI;
    public static final hm QJ;
    public static final hm QK;
    public static final hm QL;
    public static final hm QM;
    public static final hm QN;
    public static final hm QO;
    public static final hm QP;
    public static final hm QQ;
    public static final hm QR;
    public static final hm QS;
    public static final hm QT;
    public static final hm QU;
    public static final hm QV;
    public static final hm QW;
    public static final hm QX;
    public static final hm QY;
    public static final hm QZ;
    public static final hm Qa;
    public static final hm Qb;
    public static final hm Qc;
    public static final hm Qd;
    public static final hm Qe;
    public static final hm Qf;
    public static final hm Qg;
    public static final hm Qh;
    public static final hm Qi;
    public static final hm Qj;
    public static final hm Qk;
    public static final hm Ql;
    public static final hm Qm;
    public static final hm Qn;
    public static final hm Qo;
    public static final hm Qp;
    public static final hm Qq;
    public static final hm Qr;
    public static final hm Qs;
    public static final hm Qt;
    public static final hm Qu;
    public static final hm Qv;
    public static final hm Qw;
    public static final hm Qx;
    public static final hm Qy;
    public static final hm Qz;
    public static final hm Ra;
    public static final hm Rb;
    public static final hm Rc;
    final String Rd;
    final int xH;

    static {
        PA = aZ("hardware_store");
        PB = aZ("health");
        PC = aZ("hindu_temple");
        PD = aZ("home_goods_store");
        PE = aZ("hospital");
        PF = aZ("insurance_agency");
        PG = aZ("jewelry_store");
        PH = aZ("laundry");
        PI = aZ("lawyer");
        PJ = aZ("library");
        PK = aZ("liquor_store");
        PL = aZ("local_government_office");
        PM = aZ("locksmith");
        PN = aZ("lodging");
        PO = aZ("meal_delivery");
        PP = aZ("meal_takeaway");
        PQ = aZ("mosque");
        PR = aZ("movie_rental");
        PS = aZ("movie_theater");
        PT = aZ("moving_company");
        PU = aZ("museum");
        PV = aZ("night_club");
        PW = aZ("painter");
        PX = aZ("park");
        PY = aZ("parking");
        PZ = aZ("pet_store");
        Qa = aZ("pharmacy");
        Qb = aZ("physiotherapist");
        Qc = aZ("place_of_worship");
        Qd = aZ("plumber");
        Qe = aZ("police");
        Qf = aZ("post_office");
        Qg = aZ("real_estate_agency");
        Qh = aZ("restaurant");
        Qi = aZ("roofing_contractor");
        Qj = aZ("rv_park");
        Qk = aZ("school");
        Ql = aZ("shoe_store");
        Qm = aZ("shopping_mall");
        Qn = aZ("spa");
        Qo = aZ("stadium");
        Qp = aZ("storage");
        Qq = aZ("store");
        Qr = aZ("subway_station");
        Qs = aZ("synagogue");
        Qt = aZ("taxi_stand");
        Qu = aZ("train_station");
        Qv = aZ("travel_agency");
        Qw = aZ("university");
        Qx = aZ("veterinary_care");
        Qy = aZ("zoo");
        Qz = aZ("administrative_area_level_1");
        QA = aZ("administrative_area_level_2");
        QB = aZ("administrative_area_level_3");
        QC = aZ("colloquial_area");
        QD = aZ("country");
        QE = aZ("floor");
        QF = aZ("geocode");
        QG = aZ("intersection");
        QH = aZ("locality");
        QI = aZ("natural_feature");
        QJ = aZ("neighborhood");
        QK = aZ("political");
        QL = aZ("point_of_interest");
        QM = aZ("post_box");
        QN = aZ("postal_code");
        QO = aZ("postal_code_prefix");
        QP = aZ("postal_town");
        QQ = aZ("premise");
        QR = aZ("room");
        QS = aZ("route");
        QT = aZ("street_address");
        QU = aZ("sublocality");
        QV = aZ("sublocality_level_1");
        QW = aZ("sublocality_level_2");
        QX = aZ("sublocality_level_3");
        QY = aZ("sublocality_level_4");
        QZ = aZ("sublocality_level_5");
        Ra = aZ("subpremise");
        Rb = aZ("transit_station");
        Rc = aZ("other");
    }

    hm(int paramInt, String paramString) {
        fq.ap(paramString);
        this.xH = paramInt;
        this.Rd = paramString;
    }

    public static hm aZ(String paramString) {
        return new hm(0, paramString);
    }

    public int describeContents() {
        hn localhn = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof hm)) && (this.Rd.equals(((hm) paramObject).Rd));
    }

    public int hashCode() {
        return this.Rd.hashCode();
    }

    public String toString() {
        return this.Rd;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        hn localhn = CREATOR;
        hn.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */