package com.quoord.tapatalkpro.util;

import java.util.HashMap;

public class CategoryStringUtil {
    private static HashMap<Integer, Integer> NAMEMAP;

    public static HashMap<Integer, Integer> getNameMap() {
        initMap();
        return NAMEMAP;
    }

    private static void initMap() {
        if (NAMEMAP == null) {
            NAMEMAP = new HashMap();
            NAMEMAP.put(Integer.valueOf(10), Integer.valueOf(2131100846));
            NAMEMAP.put(Integer.valueOf(430), Integer.valueOf(2131100847));
            NAMEMAP.put(Integer.valueOf(431), Integer.valueOf(2131100834));
            NAMEMAP.put(Integer.valueOf(434), Integer.valueOf(2131100835));
            NAMEMAP.put(Integer.valueOf(438), Integer.valueOf(2131100848));
            NAMEMAP.put(Integer.valueOf(446), Integer.valueOf(2131100849));
            NAMEMAP.put(Integer.valueOf(447), Integer.valueOf(2131100836));
            NAMEMAP.put(Integer.valueOf(448), Integer.valueOf(2131100837));
            NAMEMAP.put(Integer.valueOf(451), Integer.valueOf(2131100850));
            NAMEMAP.put(Integer.valueOf(35), Integer.valueOf(2131100851));
            NAMEMAP.put(Integer.valueOf(457), Integer.valueOf(2131100852));
            NAMEMAP.put(Integer.valueOf(1), Integer.valueOf(2131100853));
            NAMEMAP.put(Integer.valueOf(411), Integer.valueOf(2131100838));
            NAMEMAP.put(Integer.valueOf(110), Integer.valueOf(2131100854));
            NAMEMAP.put(Integer.valueOf(157), Integer.valueOf(2131100855));
            NAMEMAP.put(Integer.valueOf(160), Integer.valueOf(2131100839));
            NAMEMAP.put(Integer.valueOf(421), Integer.valueOf(2131100840));
            NAMEMAP.put(Integer.valueOf(403), Integer.valueOf(2131100856));
            NAMEMAP.put(Integer.valueOf(458), Integer.valueOf(2131100857));
            NAMEMAP.put(Integer.valueOf(424), Integer.valueOf(2131100841));
            NAMEMAP.put(Integer.valueOf(26), Integer.valueOf(2131100858));
            NAMEMAP.put(Integer.valueOf(413), Integer.valueOf(2131100859));
            NAMEMAP.put(Integer.valueOf(460), Integer.valueOf(2131100860));
            NAMEMAP.put(Integer.valueOf(291), Integer.valueOf(2131100842));
            NAMEMAP.put(Integer.valueOf(215), Integer.valueOf(2131100861));
            NAMEMAP.put(Integer.valueOf(247), Integer.valueOf(2131100843));
            NAMEMAP.put(Integer.valueOf(227), Integer.valueOf(2131100862));
            NAMEMAP.put(Integer.valueOf(231), Integer.valueOf(2131100863));
            NAMEMAP.put(Integer.valueOf(233), Integer.valueOf(2131100864));
            NAMEMAP.put(Integer.valueOf(188), Integer.valueOf(2131100845));
            NAMEMAP.put(Integer.valueOf(464), Integer.valueOf(2131100844));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/CategoryStringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */