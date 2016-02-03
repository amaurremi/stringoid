package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class id
        implements Parcelable.Creator<ic> {
    static void a(ic paramic, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        Set localSet = paramic.ja();
        if (localSet.contains(Integer.valueOf(1))) {
            b.c(paramParcel, 1, paramic.getVersionCode());
        }
        if (localSet.contains(Integer.valueOf(2))) {
            b.a(paramParcel, 2, paramic.jb(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            b.a(paramParcel, 3, paramic.getAdditionalName(), true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            b.a(paramParcel, 4, paramic.jc(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(5))) {
            b.a(paramParcel, 5, paramic.getAddressCountry(), true);
        }
        if (localSet.contains(Integer.valueOf(6))) {
            b.a(paramParcel, 6, paramic.getAddressLocality(), true);
        }
        if (localSet.contains(Integer.valueOf(7))) {
            b.a(paramParcel, 7, paramic.getAddressRegion(), true);
        }
        if (localSet.contains(Integer.valueOf(8))) {
            b.b(paramParcel, 8, paramic.jd(), true);
        }
        if (localSet.contains(Integer.valueOf(9))) {
            b.c(paramParcel, 9, paramic.getAttendeeCount());
        }
        if (localSet.contains(Integer.valueOf(10))) {
            b.b(paramParcel, 10, paramic.je(), true);
        }
        if (localSet.contains(Integer.valueOf(11))) {
            b.a(paramParcel, 11, paramic.jf(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(12))) {
            b.b(paramParcel, 12, paramic.jg(), true);
        }
        if (localSet.contains(Integer.valueOf(13))) {
            b.a(paramParcel, 13, paramic.getBestRating(), true);
        }
        if (localSet.contains(Integer.valueOf(14))) {
            b.a(paramParcel, 14, paramic.getBirthDate(), true);
        }
        if (localSet.contains(Integer.valueOf(15))) {
            b.a(paramParcel, 15, paramic.jh(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(17))) {
            b.a(paramParcel, 17, paramic.getContentSize(), true);
        }
        if (localSet.contains(Integer.valueOf(16))) {
            b.a(paramParcel, 16, paramic.getCaption(), true);
        }
        if (localSet.contains(Integer.valueOf(19))) {
            b.b(paramParcel, 19, paramic.ji(), true);
        }
        if (localSet.contains(Integer.valueOf(18))) {
            b.a(paramParcel, 18, paramic.getContentUrl(), true);
        }
        if (localSet.contains(Integer.valueOf(21))) {
            b.a(paramParcel, 21, paramic.getDateModified(), true);
        }
        if (localSet.contains(Integer.valueOf(20))) {
            b.a(paramParcel, 20, paramic.getDateCreated(), true);
        }
        if (localSet.contains(Integer.valueOf(23))) {
            b.a(paramParcel, 23, paramic.getDescription(), true);
        }
        if (localSet.contains(Integer.valueOf(22))) {
            b.a(paramParcel, 22, paramic.getDatePublished(), true);
        }
        if (localSet.contains(Integer.valueOf(25))) {
            b.a(paramParcel, 25, paramic.getEmbedUrl(), true);
        }
        if (localSet.contains(Integer.valueOf(24))) {
            b.a(paramParcel, 24, paramic.getDuration(), true);
        }
        if (localSet.contains(Integer.valueOf(27))) {
            b.a(paramParcel, 27, paramic.getFamilyName(), true);
        }
        if (localSet.contains(Integer.valueOf(26))) {
            b.a(paramParcel, 26, paramic.getEndDate(), true);
        }
        if (localSet.contains(Integer.valueOf(29))) {
            b.a(paramParcel, 29, paramic.jj(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(28))) {
            b.a(paramParcel, 28, paramic.getGender(), true);
        }
        if (localSet.contains(Integer.valueOf(31))) {
            b.a(paramParcel, 31, paramic.getHeight(), true);
        }
        if (localSet.contains(Integer.valueOf(30))) {
            b.a(paramParcel, 30, paramic.getGivenName(), true);
        }
        if (localSet.contains(Integer.valueOf(34))) {
            b.a(paramParcel, 34, paramic.jk(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(32))) {
            b.a(paramParcel, 32, paramic.getId(), true);
        }
        if (localSet.contains(Integer.valueOf(33))) {
            b.a(paramParcel, 33, paramic.getImage(), true);
        }
        if (localSet.contains(Integer.valueOf(38))) {
            b.a(paramParcel, 38, paramic.getLongitude());
        }
        if (localSet.contains(Integer.valueOf(39))) {
            b.a(paramParcel, 39, paramic.getName(), true);
        }
        if (localSet.contains(Integer.valueOf(36))) {
            b.a(paramParcel, 36, paramic.getLatitude());
        }
        if (localSet.contains(Integer.valueOf(37))) {
            b.a(paramParcel, 37, paramic.jl(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(42))) {
            b.a(paramParcel, 42, paramic.getPlayerType(), true);
        }
        if (localSet.contains(Integer.valueOf(43))) {
            b.a(paramParcel, 43, paramic.getPostOfficeBoxNumber(), true);
        }
        if (localSet.contains(Integer.valueOf(40))) {
            b.a(paramParcel, 40, paramic.jm(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(41))) {
            b.b(paramParcel, 41, paramic.jn(), true);
        }
        if (localSet.contains(Integer.valueOf(46))) {
            b.a(paramParcel, 46, paramic.jo(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(47))) {
            b.a(paramParcel, 47, paramic.getStartDate(), true);
        }
        if (localSet.contains(Integer.valueOf(44))) {
            b.a(paramParcel, 44, paramic.getPostalCode(), true);
        }
        if (localSet.contains(Integer.valueOf(45))) {
            b.a(paramParcel, 45, paramic.getRatingValue(), true);
        }
        if (localSet.contains(Integer.valueOf(51))) {
            b.a(paramParcel, 51, paramic.getThumbnailUrl(), true);
        }
        if (localSet.contains(Integer.valueOf(50))) {
            b.a(paramParcel, 50, paramic.jp(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(49))) {
            b.a(paramParcel, 49, paramic.getText(), true);
        }
        if (localSet.contains(Integer.valueOf(48))) {
            b.a(paramParcel, 48, paramic.getStreetAddress(), true);
        }
        if (localSet.contains(Integer.valueOf(55))) {
            b.a(paramParcel, 55, paramic.getWidth(), true);
        }
        if (localSet.contains(Integer.valueOf(54))) {
            b.a(paramParcel, 54, paramic.getUrl(), true);
        }
        if (localSet.contains(Integer.valueOf(53))) {
            b.a(paramParcel, 53, paramic.getType(), true);
        }
        if (localSet.contains(Integer.valueOf(52))) {
            b.a(paramParcel, 52, paramic.getTickerSymbol(), true);
        }
        if (localSet.contains(Integer.valueOf(56))) {
            b.a(paramParcel, 56, paramic.getWorstRating(), true);
        }
        b.F(paramParcel, i);
    }

    public ic aL(Parcel paramParcel) {
        int k = a.o(paramParcel);
        HashSet localHashSet = new HashSet();
        int j = 0;
        ic localic10 = null;
        ArrayList localArrayList6 = null;
        ic localic9 = null;
        String str35 = null;
        String str34 = null;
        String str33 = null;
        ArrayList localArrayList5 = null;
        int i = 0;
        ArrayList localArrayList4 = null;
        ic localic8 = null;
        ArrayList localArrayList3 = null;
        String str32 = null;
        String str31 = null;
        ic localic7 = null;
        String str30 = null;
        String str29 = null;
        String str28 = null;
        ArrayList localArrayList2 = null;
        String str27 = null;
        String str26 = null;
        String str25 = null;
        String str24 = null;
        String str23 = null;
        String str22 = null;
        String str21 = null;
        String str20 = null;
        String str19 = null;
        ic localic6 = null;
        String str18 = null;
        String str17 = null;
        String str16 = null;
        String str15 = null;
        ic localic5 = null;
        double d2 = 0.0D;
        ic localic4 = null;
        double d1 = 0.0D;
        String str14 = null;
        ic localic3 = null;
        ArrayList localArrayList1 = null;
        String str13 = null;
        String str12 = null;
        String str11 = null;
        String str10 = null;
        ic localic2 = null;
        String str9 = null;
        String str8 = null;
        String str7 = null;
        ic localic1 = null;
        String str6 = null;
        String str5 = null;
        String str4 = null;
        String str3 = null;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < k) {
            int m = a.n(paramParcel);
            switch (a.R(m)) {
                case 35:
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    localic10 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    localArrayList6 = a.A(paramParcel, m);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    localic9 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str35 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str34 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str33 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    localArrayList5 = a.c(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    localArrayList4 = a.c(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    localic8 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    localArrayList3 = a.c(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str32 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str31 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    localic7 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(15));
                    break;
                case 17:
                    str29 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(17));
                    break;
                case 16:
                    str30 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(16));
                    break;
                case 19:
                    localArrayList2 = a.c(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(19));
                    break;
                case 18:
                    str28 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(18));
                    break;
                case 21:
                    str26 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(21));
                    break;
                case 20:
                    str27 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(20));
                    break;
                case 23:
                    str24 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(23));
                    break;
                case 22:
                    str25 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(22));
                    break;
                case 25:
                    str22 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(25));
                    break;
                case 24:
                    str23 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(24));
                    break;
                case 27:
                    str20 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(27));
                    break;
                case 26:
                    str21 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(26));
                    break;
                case 29:
                    localic6 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(29));
                    break;
                case 28:
                    str19 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(28));
                    break;
                case 31:
                    str17 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(31));
                    break;
                case 30:
                    str18 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(30));
                    break;
                case 34:
                    localic5 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(34));
                    break;
                case 32:
                    str16 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str15 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(33));
                    break;
                case 38:
                    d1 = a.l(paramParcel, m);
                    localHashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str14 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(39));
                    break;
                case 36:
                    d2 = a.l(paramParcel, m);
                    localHashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    localic4 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(37));
                    break;
                case 42:
                    str13 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str12 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(43));
                    break;
                case 40:
                    localic3 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(40));
                    break;
                case 41:
                    localArrayList1 = a.c(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(41));
                    break;
                case 46:
                    localic2 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(46));
                    break;
                case 47:
                    str9 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(47));
                    break;
                case 44:
                    str11 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str10 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(45));
                    break;
                case 51:
                    str6 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(51));
                    break;
                case 50:
                    localic1 = (ic) a.a(paramParcel, m, ic.CREATOR);
                    localHashSet.add(Integer.valueOf(50));
                    break;
                case 49:
                    str7 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(49));
                    break;
                case 48:
                    str8 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(48));
                    break;
                case 55:
                    str2 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(55));
                    break;
                case 54:
                    str3 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(54));
                    break;
                case 53:
                    str4 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(53));
                    break;
                case 52:
                    str5 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(52));
                    break;
                case 56:
                    str1 = a.n(paramParcel, m);
                    localHashSet.add(Integer.valueOf(56));
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new a.a("Overread allowed size end=" + k, paramParcel);
        }
        return new ic(localHashSet, j, localic10, localArrayList6, localic9, str35, str34, str33, localArrayList5, i, localArrayList4, localic8, localArrayList3, str32, str31, localic7, str30, str29, str28, localArrayList2, str27, str26, str25, str24, str23, str22, str21, str20, str19, localic6, str18, str17, str16, str15, localic5, d2, localic4, d1, str14, localic3, localArrayList1, str13, str12, str11, str10, localic2, str9, str8, str7, localic1, str6, str5, str4, str3, str2, str1);
    }

    public ic[] bO(int paramInt) {
        return new ic[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */