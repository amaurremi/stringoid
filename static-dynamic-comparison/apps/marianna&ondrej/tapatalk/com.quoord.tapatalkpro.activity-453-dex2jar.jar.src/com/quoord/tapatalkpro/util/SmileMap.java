package com.quoord.tapatalkpro.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class SmileMap {
    public static final int IP = 0;
    public static final int KN = 1;
    public static final int MB = 2;
    public static final int PB = 3;
    public static final int PBS = 8;
    public static final int SMF1 = 4;
    public static final int SMF2 = 5;
    public static final int VB = 7;
    public static final int VB3 = 10;
    public static final int VB4 = 11;
    public static final int VB5 = 12;
    public static final int WBB = 13;
    public static final int XF = 6;
    public static final int YK = 9;
    private HashMap<String, String> _IPMap;
    private HashMap<String, String> _KNMap;
    private HashMap<String, String> _MBMap;
    private HashMap<String, String> _PBMap;
    private HashMap<String, String> _PBSMap;
    private HashMap<String, String> _SMF1Map;
    private HashMap<String, String> _SMF2Map;
    private HashMap<String, String> _VB3Map;
    private HashMap<String, String> _VB4Map;
    private HashMap<String, String> _VB5Map;
    private HashMap<String, String> _VBMap;
    private HashMap<String, String> _WBBMap;
    private HashMap<String, String> _XFMap;
    private HashMap<String, String> _YKMap;
    private HashMap<String, String> _currMap;

    public SmileMap() {
        createIP();
        createKN();
        createMB();
        createPB();
        createSMF1();
        createSMF2();
        createXF();
        createVB();
        createVB3();
        createVB4();
        createVB5();
        createPBS();
        createYK();
        this._currMap = this._IPMap;
    }

    private void createIP() {
        this._IPMap = new HashMap();
        createPublic(this._IPMap);
        this._IPMap.put(":)", "emoji4");
        this._IPMap.put(":(", "emoji20");
        this._IPMap.put(":rolleyes:", "emoji57");
        this._IPMap.put(":mellow:", "emoji52");
        this._IPMap.put(":huh:", "emoji47");
        this._IPMap.put(":D", "emoji3");
        this._IPMap.put("^_^", "emoji5");
        this._IPMap.put(":o", "emoji33");
        this._IPMap.put(":lol:", "emoji1");
        this._IPMap.put(":P", "emoji14");
        this._IPMap.put(";)", "emoji6");
        this._IPMap.put("B)", "emoji41");
        this._IPMap.put("-_-", "emoji42");
        this._IPMap.put(">_>", "emoji19");
        this._IPMap.put(":wub:", "emoji7");
        this._IPMap.put(":angry:", "emoji34");
        this._IPMap.put(":unsure:", "emoji53");
        this._IPMap.put(":wacko:", "emoji37");
        this._IPMap.put(":blink:", "emoji50");
        this._IPMap.put(":ph34r:", "emoji185");
    }

    private void createKN() {
        this._KNMap = new HashMap();
        createPublic(this._KNMap);
        this._KNMap.put(":mrgreen:", "emoji2");
        this._KNMap.put(":arrow:", "emoji666");
        this._KNMap.put(":idea:", "emoji362");
        this._KNMap.put(":)", "emoji4");
        this._KNMap.put(":blush:", "emoji5");
        this._KNMap.put(":oops:", "emoji5");
        this._KNMap.put(";)", "emoji6");
        this._KNMap.put(":cheer:", "emoji3");
        this._KNMap.put(":P", "emoji14");
        this._KNMap.put(":dry:", "emoji19");
        this._KNMap.put(":(", "emoji20");
        this._KNMap.put(":pinch:", "emoji21");
        this._KNMap.put(":ohmy:", "emoji33");
        this._KNMap.put(":angry:", "emoji34");
        this._KNMap.put(":sick:", "emoji40");
        this._KNMap.put("B)", "emoji41");
        this._KNMap.put(":huh:", "emoji47");
        this._KNMap.put(":silly:", "emoji57");
        this._KNMap.put(":kiss:", "emoji8");
        this._KNMap.put(":blink:", "emoji50");
        this._KNMap.put(":woohoo:", "emoji51");
        this._KNMap.put(":unsure:", "emoji53");
        this._KNMap.put(":side:", "emoji78");
        this._KNMap.put(":S", "emoji37");
        this._KNMap.put(":evil:", "emoji48");
        this._KNMap.put(":whistle:", "emoji10");
        this._KNMap.put(":lol:", "emoji1");
        this._KNMap.put(":D", "emoji1");
        this._KNMap.put(":o", "emoji33");
        this._KNMap.put(":|", "emoji58");
        this._KNMap.put(":?:", "emoji780");
        this._KNMap.put(":!:", "emoji779");
    }

    private void createMB() {
        this._MBMap = new HashMap();
        createPublic(this._MBMap);
        this._MBMap.put(":)", "emoji2");
        this._MBMap.put(";)", "emoji6");
        this._MBMap.put(":cool:", "emoji41");
        this._MBMap.put(":D", "emoji1");
        this._MBMap.put(":P", "emoji14");
        this._MBMap.put(":rolleyes:", "emoji57");
        this._MBMap.put(":shy:", "emoji5");
        this._MBMap.put(":(", "emoji20");
        this._MBMap.put(":angel:", "emoji56");
        this._MBMap.put(":@", "emoji35");
        this._MBMap.put(":blush:", "emoji4");
        this._MBMap.put(":sleepy:", "emoji42");
        this._MBMap.put(":s", "emoji53");
        this._MBMap.put(":dodgy:", "emoji19");
        this._MBMap.put(":exclamation:", "emoji779");
        this._MBMap.put(":heart:", "emoji173");
        this._MBMap.put(":huh:", "emoji782");
        this._MBMap.put(":idea:", "emoji362");
        this._MBMap.put(":-/", "emoji47");
    }

    private void createPB() {
        this._PBMap = new HashMap();
        createPublic(this._PBMap);
        this._PBMap.put(":oops:", "emoji15");
        this._PBMap.put(":)", "emoji4");
        this._PBMap.put(";)", "emoji6");
        this._PBMap.put(":D", "emoji1");
        this._PBMap.put(":(", "emoji20");
        this._PBMap.put(":o", "emoji33");
        this._PBMap.put(":shock:", "emoji47");
        this._PBMap.put(":?", "emoji53");
        this._PBMap.put("8-)", "emoji41");
        this._PBMap.put(":lol:", "emoji3");
        this._PBMap.put(":mad:", "emoji34");
        this._PBMap.put(":P", "emoji14");
        this._PBMap.put(":x", "emoji34");
        this._PBMap.put(":cry:", "emoji22");
        this._PBMap.put(":evil:", "emoji49");
        this._PBMap.put(":twisted:", "emoji48");
        this._PBMap.put(":roll:", "emoji57");
        this._PBMap.put(":!:", "emoji779");
        this._PBMap.put(":?:", "emoji780");
        this._PBMap.put(":idea:", "emoji362");
        this._PBMap.put(":arrow:", "emoji666");
        this._PBMap.put(":|", "emoji52");
        this._PBMap.put(":mrgreen:", "emoji2");
        this._PBMap.put(":geek:", "emoji67");
        this._PBMap.put(":ugeek:", "emoji71");
    }

    private void createPBS() {
        this._PBSMap = new HashMap();
        createPublic(this._PBSMap);
        this._PBSMap.put(":))", "emoji2");
        this._PBSMap.put("::)", "emoji3");
        this._PBSMap.put(":)", "emoji4");
        this._PBSMap.put(";)", "emoji6");
        this._PBSMap.put(":D", "emoji1");
        this._PBSMap.put("B-|", "emoji19");
        this._PBSMap.put(":(", "emoji20");
        this._PBSMap.put("x_x", "emoji21");
        this._PBSMap.put(">:(", "emoji34");
        this._PBSMap.put(":o", "emoji33");
        this._PBSMap.put(">:D", "emoji35");
        this._PBSMap.put(";-|", "emoji36");
        this._PBSMap.put(":-S", "emoji37");
        this._PBSMap.put("(puke)", "emoji40");
        this._PBSMap.put("8-)", "emoji41");
        this._PBSMap.put("(zzz)", "emoji42");
        this._PBSMap.put("???", "emoji47");
        this._PBSMap.put("P-)", "emoji48");
        this._PBSMap.put("O_o", "emoji50");
        this._PBSMap.put("8D", "emoji51");
        this._PBSMap.put(":|", "emoji52");
        this._PBSMap.put(":P", "emoji14");
        this._PBSMap.put(":-[", "emoji15");
        this._PBSMap.put(":-X", "emoji55");
        this._PBSMap.put(":8-|", "emoji57");
        this._PBSMap.put(":-/", "emoji53");
        this._PBSMap.put(":-*", "emoji8");
        this._PBSMap.put(":'(", "emoji22");
        this._PBSMap.put("(rofl)", "emoji5");
        this._PBSMap.put("(:))", "emoji85");
    }

    private void createPublic(HashMap<String, String> paramHashMap) {
    }

    private void createSMF1() {
        this._SMF1Map = new HashMap();
        createPublic(this._SMF1Map);
        this._SMF1Map.put("::)", "emoji57");
        this._SMF1Map.put(":)", "emoji4");
        this._SMF1Map.put(":D", "emoji3");
        this._SMF1Map.put(";D", "emoji1");
        this._SMF1Map.put(">:(", "emoji34");
        this._SMF1Map.put(":(", "emoji20");
        this._SMF1Map.put(":o", "emoji50");
        this._SMF1Map.put("8)", "emoji41");
        this._SMF1Map.put("???", "emoji782");
        this._SMF1Map.put(":P", "emoji14");
        this._SMF1Map.put(":-[", "emoji15");
        this._SMF1Map.put(":-X", "emoji55");
        this._SMF1Map.put(":-\\", "emoji47");
        this._SMF1Map.put(":-*", "emoji8");
        this._SMF1Map.put(":'(", "emoji22");
        this._SMF1Map.put(";)", "emoji6");
        this._SMF1Map.put("???", "emoji782");
    }

    private void createSMF2() {
        this._SMF2Map = new HashMap();
        createPublic(this._SMF2Map);
        this._SMF2Map.put("::)", "emoji57");
        this._SMF2Map.put(":)", "emoji4");
        this._SMF2Map.put(":D", "emoji2");
        this._SMF2Map.put(";D", "emoji16");
        this._SMF2Map.put(">:(", "emoji34");
        this._SMF2Map.put("???", "emoji47");
        this._SMF2Map.put(":(", "emoji20");
        this._SMF2Map.put(":o", "emoji50");
        this._SMF2Map.put("8)", "emoji41");
        this._SMF2Map.put(":P", "emoji14");
        this._SMF2Map.put(":-[", "emoji15");
        this._SMF2Map.put(":-X", "emoji55");
        this._SMF2Map.put(":-\\", "emoji47");
        this._SMF2Map.put(":-*", "emoji8");
        this._SMF2Map.put(":'(", "emoji22");
        this._SMF2Map.put(">:D", "emoji48");
        this._SMF2Map.put("^-^", "emoji5");
        this._SMF2Map.put(";)", "emoji6");
    }

    private void createVB() {
        this._VBMap = new HashMap();
        createPublic(this._VBMap);
        this._VBMap.put(":)", "emoji3");
        this._VBMap.put(":(", "emoji20");
        this._VBMap.put(":rolleyes:", "emoji57");
        this._VBMap.put(":cool:", "emoji41");
        this._VBMap.put(":eek:", "emoji33");
        this._VBMap.put(":D", "emoji2");
        this._VBMap.put(":o", "emoji5");
        this._VBMap.put(":confused:", "emoji53");
        this._VBMap.put(":mad:", "emoji35");
        this._VBMap.put(":p", "emoji14");
        this._VBMap.put(";)", "emoji6");
        this._VBMap.put(":thumbup:", "emoji106");
        this._VBMap.put(":thumbdown:", "emoji107");
    }

    private void createVB3() {
        this._VB3Map = new HashMap();
        createPublic(this._VB3Map);
        this._VB3Map.put(":)", "emoji4");
        this._VB3Map.put(":(", "emoji20");
        this._VB3Map.put(":rolleyes:", "emoji57");
        this._VB3Map.put(":cool:", "emoji41");
        this._VB3Map.put(":eek:", "emoji33");
        this._VB3Map.put(":D", "emoji3");
        this._VB3Map.put(":o", "emoji5");
        this._VB3Map.put(":confused:", "emoji782");
        this._VB3Map.put(":mad:", "emoji35");
        this._VB3Map.put(":p", "emoji14");
        this._VB3Map.put(";)", "emoji6");
    }

    private void createVB4() {
        this._VB4Map = new HashMap();
        createPublic(this._VB4Map);
        this._VB4Map.put(":)", "emoji4");
        this._VB4Map.put(":(", "emoji20");
        this._VB4Map.put(":rolleyes:", "emoji57");
        this._VB4Map.put(":cool:", "emoji41");
        this._VB4Map.put(":eek:", "emoji33");
        this._VB4Map.put(":D", "emoji3");
        this._VB4Map.put(":o", "emoji5");
        this._VB4Map.put(":confused:", "emoji782");
        this._VB4Map.put(":mad:", "emoji35");
        this._VB4Map.put(":p", "emoji14");
        this._VB4Map.put(";)", "emoji6");
    }

    private void createVB5() {
        this._VB5Map = new HashMap();
        createPublic(this._VB5Map);
        this._VB5Map.put(":)", "emoji4");
        this._VB5Map.put(":(", "emoji20");
        this._VB5Map.put(":rolleyes:", "emoji57");
        this._VB5Map.put(":cool:", "emoji41");
        this._VB5Map.put(":eek:", "emoji33");
        this._VB5Map.put(":D", "emoji2");
        this._VB5Map.put(":o", "emoji5");
        this._VB5Map.put(":confused:", "emoji53");
        this._VB5Map.put(":mad:", "emoji35");
        this._VB5Map.put(":p", "emoji14");
        this._VB5Map.put(";)", "emoji6");
    }

    private void createWBB() {
        this._WBBMap = new HashMap();
        createPublic(this._WBBMap);
        this._WBBMap.put(":saint:", "emoji56");
        this._WBBMap.put(":rolleyes:", "emoji106");
        this._WBBMap.put(":thumbsup:", "emoji106");
        this._WBBMap.put(":thumbdown:", "emoji107");
        this._WBBMap.put("||", "emoji58");
        this._WBBMap.put("^^", "emoji4");
        this._WBBMap.put(":)", "emoji5");
        this._WBBMap.put(";)", "emoji6");
        this._WBBMap.put(":love:", "emoji7");
        this._WBBMap.put(":*:", "emoji8");
        this._WBBMap.put(":whistling:", "emoji10");
        this._WBBMap.put(":( ", "emoji20");
        this._WBBMap.put("X/ ", "emoji21");
        this._WBBMap.put(";(", "emoji22");
        this._WBBMap.put("X(", "emoji34");
        this._WBBMap.put(":cursing:", "emoji36");
        this._WBBMap.put(">X  X:", "emoji40");
        this._WBBMap.put("8)", "emoji41");
        this._WBBMap.put(":sleeping:", "emoji42");
        this._WBBMap.put(":huh:", "emoji47");
        this._WBBMap.put(":evil:", "emoji48");
        this._WBBMap.put("8|", "emoji50");
        this._WBBMap.put(":|", "emoji52");
        this._WBBMap.put(":/", "emoji53");
        this._WBBMap.put(">3", "emoji173");
        this._WBBMap.put(":!:", "emoji779");
        this._WBBMap.put(":?:", "emoji780");
        this._WBBMap.put("?(", "emoji782");
        this._WBBMap.put(":D", "emoji1");
        this._WBBMap.put("8o", "emoji2");
        this._WBBMap.put(":S", "emoji37");
        this._WBBMap.put(":P", "emoji14");
    }

    private void createXF() {
        this._XFMap = new HashMap();
        createPublic(this._XFMap);
        this._XFMap.put("(:", "emoji4");
        this._XFMap.put(":-)", "emoji4");
        this._XFMap.put(":)", "emoji4");
        this._XFMap.put(";)", "emoji6");
        this._XFMap.put(":(", "emoji20");
        this._XFMap.put(":mad:", "emoji35");
        this._XFMap.put(":confused:", "emoji53");
        this._XFMap.put(":cool:", "emoji41");
        this._XFMap.put("8-)", "emoji41");
        this._XFMap.put(":p", "emoji14");
        this._XFMap.put(":P", "emoji14");
        this._XFMap.put(":-p", "emoji14");
        this._XFMap.put(":-P", "emoji14");
        this._XFMap.put(":D", "emoji1");
        this._XFMap.put(":eek:", "emoji33");
        this._XFMap.put(":oops:", "emoji15");
        this._XFMap.put(":rolleyes:", "emoji57");
        this._XFMap.put("o_O", "emoji50");
        this._XFMap.put("O.o", "emoji50");
        this._XFMap.put("o.O", "emoji50");
        this._XFMap.put("O_o", "emoji50");
    }

    private void createYK() {
        this._YKMap = new HashMap();
        this._YKMap.put(":ashamed:", "ashamed");
        this._YKMap.put(":banana:", "banana");
        this._YKMap.put(":blue_butterfly:", "blue_butterfly");
        this._YKMap.put(":bored:", "bored");
        this._YKMap.put(":bored02:", "bored02");
        this._YKMap.put(":canadian:", "canadian");
        this._YKMap.put(":cancel:", "cancel");
        this._YKMap.put(":censored:", "censored");
        this._YKMap.put(":clap:", "clap");
        this._YKMap.put(":clock:", "clock");
        this._YKMap.put(":clown:", "clown");
        this._YKMap.put(":confused01:", "confused01");
        this._YKMap.put(":confused02:", "confused02");
        this._YKMap.put(":cool01:", "cool01");
        this._YKMap.put(":cool02:", "cool02");
        this._YKMap.put(":cool003:", "cool003");
        this._YKMap.put(":createdomain:", "createdomain");
        this._YKMap.put(":cry:", "cry");
        this._YKMap.put(":cry01:", "cry01");
        this._YKMap.put(":cute:", "cute");
        this._YKMap.put(":dance:", "dance");
        this._YKMap.put(":doggie:", "doggie");
        this._YKMap.put(":eh:", "eh");
        this._YKMap.put(":emotions:", "emotions");
        this._YKMap.put(":evilgrin01:", "evilgrin01");
        this._YKMap.put(":evilgrin02:", "evilgrin02");
        this._YKMap.put(":fighting01gif:", "fighting01gif");
        this._YKMap.put(":fighting02:", "fighting02");
        this._YKMap.put(":fighting003:", "fighting003");
        this._YKMap.put(":fighting004:", "fighting004");
        this._YKMap.put(":fighting05:", "fighting05");
        this._YKMap.put(":fighting06:", "fighting06");
        this._YKMap.put(":finger:", "finger");
        this._YKMap.put(":gotoalpha:", "gotoalpha");
        this._YKMap.put(":grouphug:", "grouphug");
        this._YKMap.put(":headshake:", "headshake");
        this._YKMap.put(":heart:", "heart");
        this._YKMap.put(":help:", "help");
        this._YKMap.put(":horz_left:", "horz_left");
        this._YKMap.put(":horz_line:", "horz_line");
        this._YKMap.put(":horz_right:", "horz_right");
        this._YKMap.put(":kiss_butt:", "kiss_butt");
        this._YKMap.put(":laugh:", "laugh");
        this._YKMap.put(":lol:", "lol");
        this._YKMap.put(":lonely:", "lonely");
        this._YKMap.put(":love:", "love");
        this._YKMap.put(":nono:", "nono");
        this._YKMap.put(":pacman:", "pacman");
        this._YKMap.put(":picknose:", "picknose");
        this._YKMap.put(":piggie:", "piggie");
        this._YKMap.put(":pissedoff:", "pissedoff");
        this._YKMap.put(":po:", "po");
        this._YKMap.put(":pray:", "pray");
        this._YKMap.put(":rockon:", "rockon");
        this._YKMap.put(":rolleyes:", "rolleyes");
        this._YKMap.put(":rule:", "rule");
        this._YKMap.put(":scared:", "scared");
        this._YKMap.put(":scared02:", "scared02");
        this._YKMap.put(":sick:", "sick");
        this._YKMap.put(":sick02:", "sick02");
        this._YKMap.put(":skull:", "skull");
        this._YKMap.put(":skull02:", "skull02");
        this._YKMap.put(":sleep:", "sleep");
        this._YKMap.put(":smile:", "smile");
        this._YKMap.put(":smile_20:", "smile_20");
        this._YKMap.put(":smile_20_angry:", "smile_20_angry");
        this._YKMap.put(":smile_20_angry2:", "smile_20_angry2");
        this._YKMap.put(":smile_20_bbuick:", "smile_20_bbuick");
        this._YKMap.put(":smile_20_blush:", "smile_20_blush");
        this._YKMap.put(":smile_20_cry:", "smile_20_cry");
        this._YKMap.put(":smile_20_evil1:", "smile_20_evil1");
        this._YKMap.put(":smile_20_evil2:", "smile_20_evil2");
        this._YKMap.put(":smile_20_laught:", "smile_20_laught");
        this._YKMap.put(":smile_20_love:", "smile_20_love");
        this._YKMap.put(":smile_20_melong:", "smile_20_melong");
        this._YKMap.put(":smile_20_no:", "smile_20_no");
        this._YKMap.put(":smile_20_sad:", "smile_20_sad");
        this._YKMap.put(":smile_20_wink:", "smile_20_wink");
        this._YKMap.put(":smiley_cool:", "smiley_cool");
        this._YKMap.put(":smiley_cry:", "smiley_cry");
        this._YKMap.put(":smiley_embarassed:", "smiley_embarassed");
        this._YKMap.put(":smiley_foot_in_mouth:", "smiley_foot_in_mouth");
        this._YKMap.put(":smiley_frown:", "smiley_frown");
        this._YKMap.put(":smiley_innocent:", "smiley_innocent");
        this._YKMap.put(":smiley_kiss:", "smiley_kiss");
        this._YKMap.put(":smiley_laughing:", "smiley_laughing");
        this._YKMap.put(":smiley_money_mouth:", "smiley_money_mouth");
        this._YKMap.put(":smiley_sealed:", "smiley_sealed");
        this._YKMap.put(":smiley_smile:", "smiley_smile");
        this._YKMap.put(":smiley_surprised:", "smiley_surprised");
        this._YKMap.put(":smiley_tongue_out:", "smiley_tongue_out");
        this._YKMap.put(":smiley_undecided:", "smiley_undecided");
        this._YKMap.put(":smiley_wink:", "smiley_wink");
        this._YKMap.put(":smiley_yell:", "smiley_yell");
        this._YKMap.put(":submit:", "submit");
        this._YKMap.put(":thumbdown:", "thumbdown");
        this._YKMap.put(":thumbsup:", "thumbsup");
        this._YKMap.put(":tongue:", "tongue");
        this._YKMap.put(":tongue02:", "tongue02");
        this._YKMap.put(":wavehello:", "wavehello");
        this._YKMap.put(":wink:", "wink");
        this._YKMap.put(":wink02:", "wink02");
        this._YKMap.put(":wth:", "wth");
        this._YKMap.put(":yay:", "yay");
        this._YKMap.put(":yellow_butterfly:", "yellow_butterfly");
        this._YKMap.put(":yuku_waiting:", "yuku_waiting");
        this._YKMap.put(":yuku_waiting02:", "yuku_waiting02");
        this._YKMap.put(":\\(", "cry");
        this._YKMap.put(":o", "smiley_embarassed");
        this._YKMap.put(":cool:", "smiley_cool");
        this._YKMap.put(":D", "yay");
        this._YKMap.put(":mad:", "nono");
        this._YKMap.put(":lol:", "laugh");
        this._YKMap.put(":p", "tongue");
        this._YKMap.put(":smokin:", "smiley_cool");
        this._YKMap.put(":frown:", "cry");
        this._YKMap.put(":pimp:", "smiley_cool");
        this._YKMap.put(":yay:", "yay");
        this._YKMap.put(":happy:", "yay");
        this._YKMap.put(":smiley-undecided:", "smiley_undecided");
        this._YKMap.put(":smiley-embarassed:", "smiley_embarassed");
        this._YKMap.put(":smiley-cool:", "smiley_cool");
        this._YKMap.put(":roll:", "laugh");
    }

    public String[] getKeys() {
        Object[] arrayOfObject = this._currMap.keySet().toArray();
        String[] arrayOfString = new String[arrayOfObject.length];
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfObject.length) {
                return arrayOfString;
            }
            arrayOfString[i] = ((String) arrayOfObject[i]);
            i += 1;
        }
    }

    public String[] getValues() {
        Object[] arrayOfObject = this._currMap.values().toArray();
        String[] arrayOfString = new String[arrayOfObject.length];
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfObject.length) {
                return arrayOfString;
            }
            arrayOfString[i] = ((String) arrayOfObject[i]);
            i += 1;
        }
    }

    public void setCurrentForum(int paramInt) {
        switch (paramInt) {
            default:
                this._currMap = this._IPMap;
                return;
            case 0:
                this._currMap = this._IPMap;
                return;
            case 1:
                this._currMap = this._KNMap;
                return;
            case 2:
                this._currMap = this._MBMap;
                return;
            case 3:
                this._currMap = this._PBMap;
                return;
            case 4:
                this._currMap = this._SMF1Map;
                return;
            case 5:
                this._currMap = this._SMF2Map;
                return;
            case 6:
                this._currMap = this._XFMap;
                return;
            case 7:
                this._currMap = this._VBMap;
                return;
            case 10:
                this._currMap = this._VB3Map;
                return;
            case 11:
                this._currMap = this._VB4Map;
                return;
            case 12:
                this._currMap = this._VB5Map;
                return;
            case 8:
                this._currMap = this._PBSMap;
                return;
        }
        this._currMap = this._YKMap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/SmileMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */