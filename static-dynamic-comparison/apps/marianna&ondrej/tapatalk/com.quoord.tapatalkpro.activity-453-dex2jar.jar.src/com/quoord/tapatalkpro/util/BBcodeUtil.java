package com.quoord.tapatalkpro.util;

import android.graphics.Bitmap;
import com.quoord.tapatalkpro.bean.ForumStatus;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

public class BBcodeUtil {
    static String closeCodeTag;
    static int closeCodeTagGroup;
    static String closeEmailTag;
    static int closeEmailTagGroup = 6;
    static String closeImgTag;
    static int closeImgTagGroup;
    static String closeQuoteTag;
    static int closeQuoteTagGroup;
    static String closeSpoilerTag;
    static String closeSpoilerTag1;
    static String closeSpoilerTag2;
    static int closeSpoilerTagGroup;
    static int closeSpoilerTagGroup1;
    static int closeSpoilerTagGroup2;
    static String closeUrlTag;
    static int closeUrlTagGroup;
    static String layoutPatternString;
    static String openCodeTag;
    static int openCodeTagGroup;
    static String openEmailTag;
    static int openEmailTagGroup;
    static String openImgTag;
    static int openImgTagGroup;
    static String openQuoteTag = "\\[QUOTE.*?\\]";
    static int openQuoteTagGroup;
    static String openSpoilerTag;
    static String openSpoilerTag1;
    static String openSpoilerTag2;
    static int openSpoilerTagGroup;
    static int openSpoilerTagGroup1;
    static int openSpoilerTagGroup2;
    static String openUrlTag;
    static int openUrlTagGroup;
    static String patternString;

    static {
        closeQuoteTag = "\\[\\/QUOTE\\]";
        openSpoilerTag = "\\[SPOILER\\]";
        closeSpoilerTag = "\\[\\/SPOILER\\]";
        openSpoilerTag1 = "\\[SPOIL\\]";
        closeSpoilerTag1 = "\\[\\/SPOIL\\]";
        openSpoilerTag2 = "\\[HIDE\\]";
        closeSpoilerTag2 = "\\[\\/HIDE\\]";
        openImgTag = "\\[IMG\\]";
        closeImgTag = "\\[\\/IMG\\]";
        openUrlTag = "\\[URL";
        closeUrlTag = "\\[\\/URL\\]";
        openEmailTag = "\\[EMAIL";
        closeEmailTag = "\\[\\/EMAIL\\]";
        openCodeTag = "\\[CODE.*?\\]";
        closeCodeTag = "\\[\\/CODE\\]";
        layoutPatternString = '(' + openQuoteTag + ")|(" + closeQuoteTag + ")|(" + openSpoilerTag + ")|(" + closeSpoilerTag + ")|(" + openSpoilerTag1 + ")|(" + closeSpoilerTag1 + ")|(" + openSpoilerTag2 + ")|(" + closeSpoilerTag2 + ")|(" + openCodeTag + ")|(" + closeCodeTag + ')';
        patternString = '(' + openImgTag + ")|(" + closeImgTag + ')' + "|(" + openUrlTag + ")|(" + closeUrlTag + ')' + "|(" + openEmailTag + ")|(" + closeEmailTag + ')';
        openQuoteTagGroup = 1;
        closeQuoteTagGroup = 2;
        openSpoilerTagGroup = 3;
        closeSpoilerTagGroup = 4;
        openSpoilerTagGroup1 = 5;
        closeSpoilerTagGroup1 = 6;
        openSpoilerTagGroup2 = 7;
        closeSpoilerTagGroup2 = 8;
        openCodeTagGroup = 9;
        closeCodeTagGroup = 10;
        openImgTagGroup = 1;
        closeImgTagGroup = 2;
        openUrlTagGroup = 3;
        closeUrlTagGroup = 4;
        openEmailTagGroup = 5;
    }

    public static String parseAllEmoji(String paramString) {
        return paramString.replaceAll("(?i)\\[emoji(.*?)\\]", "<img src=emoji$1>");
    }

    public static String parseAllForumPublicSmileToEmoji(String paramString) {
        return paramString.replaceAll(":heart", "<img src=emoji813>").replaceAll(":heart:", "<img src=emoji813>").replaceAll(":beer:", "<img src=emoji481>").replaceAll(":thumbdown:", "<img src=emoji107>").replaceAll(":apple:", "<img src=emoji519>").replaceAll(":thumbup:", "<img src=emoji106>").replaceAll(":thumbup", "<img src=emoji106>").replaceAll(":biggrin:", "<img src=emoji3>").replaceAll(":smile:", "<img src=emoji2>").replaceAll(":LOL:", "<img src=emoji38>").replaceAll(":LOL", "<img src=emoji38>").replaceAll(":bow:", "<img src=emoji144>").replaceAll(":sleep:", "<img src=emoji99>").replaceAll(":roflmao:", "<img src=emoji23>").replaceAll(":goodnight:", "<img src=emoji561>").replaceAll(":club", "<img src=emoji814>").replaceAll(":diamond", "<img src=emoji815>").replaceAll(":spade", "<img src=emoji812>").replaceAll(":heart", "<img src=emoji813>").replaceAll(":darkbeer:", "<img src=emoji481>");
    }

    public static String parseAllForumPublicSmileToEmojiBBCode(String paramString) {
        return paramString.replaceAll(":heart:", "[emoji813]").replaceAll(":beer:", "[emoji481]").replaceAll(":thumbdown:", "[emoji107]").replaceAll(":apple:", "[emoji519]").replaceAll(":thumbup:", "[emoji106]").replaceAll(":thumbup", "[emoji106]").replaceAll(":biggrin:", "[emoji3]").replaceAll(":smile:", "[emoji2]").replaceAll(":LOL:", "[emoji38]").replaceAll(":LOL", "[emoji38]").replaceAll(":bow:", "[emoji144]").replaceAll(":sleep:", "[emoji99]").replaceAll(":roflmao:", "[emoji23]").replaceAll(":goodnight:", "[emoji561]").replaceAll(":club", "[emoji814]").replaceAll(":diamond", "[emoji815]").replaceAll(":spade", "[emoji812]").replaceAll(":heart", "[emoji813]").replaceAll(":darkbeer:", "[emoji481]");
    }

    public static String parseIPSmileToEmoji(String paramString) {
        return paramString.replaceAll("&lt;_&lt;", "<img src=emoji19>").replaceAll("<_<", "<img src=emoji19>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":mellow:", "<img src=emoji52>").replaceAll(":huh:", "<img src=emoji47>").replaceAll(":wub:", "<img src=emoji7>").replaceAll(":angry:", "<img src=emoji34>").replaceAll(":unsure:", "<img src=emoji53>").replaceAll(":wacko:", "<img src=emoji37>").replaceAll(":blink:", "<img src=emoji50>").replaceAll(":ph34r:", "<img src=emoji185>").replaceAll(":\\)", "<img src=emoji4>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":D", "<img src=emoji3>").replaceAll("\\^_\\^", "<img src=emoji5>").replaceAll(":o", "<img src=emoji33>").replaceAll(":lol:", "<img src=emoji1>").replaceAll(":p", "<img src=emoji14>").replaceAll(":P", "<img src=emoji14>").replaceAll(";\\)", "<img src=emoji6>").replaceAll("B\\)", "<img src=emoji41>").replaceAll("-_-", "<img src=emoji42>");
    }

    public static String parseKNSmileToEmoji(String paramString) {
        return paramString.replaceAll(":blush:", "<img src=emoji5>").replaceAll(":oops:", "<img src=emoji5>").replaceAll(":pinch:", "<img src=emoji21>").replaceAll("B\\)", "<img src=emoji41>").replaceAll(":-\\(", "<img src=emoji20>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":\\)", "<img src=emoji4>").replaceAll(":cheer:", "<img src=emoji3>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":P", "<img src=emoji14>").replaceAll(":angry:", "<img src=emoji34>").replaceAll(":ohmy:", "<img src=emoji33>").replaceAll(":dry:", "<img src=emoji19>").replaceAll(":sick:", "<img src=emoji40>").replaceAll(":huh:", "<img src=emoji47>").replaceAll(":silly:", "<img src=emoji57>").replaceAll(":kiss:", "<img src=emoji8>").replaceAll(":blink:", "<img src=emoji50>").replaceAll(":woohoo:", "<img src=emoji51>").replaceAll(":unsure:", "<img src=emoji53>").replaceAll(":side:", "<img src=emoji78>").replaceAll(":S", "<img src=emoji37>").replaceAll(":evil:", "<img src=emoji48>").replaceAll(":whistle:", "<img src=emoji10>").replaceAll(":D", "<img src=emoji1>").replaceAll(":\\|", "<img src=emoji58>").replaceAll(":mrgreen:", "<img src=emoji2>").replaceAll(":\\?:", "<img src=emoji780>").replaceAll(":!:", "<img src=emoji779>").replaceAll(":arrow:", "<img src=emoji666>").replaceAll(":idea:", "<img src=emoji362>").replaceAll(":lol:", "<img src=emoji362>").replaceAll(":o", "<img src=emoji33>");
    }

    public static String parseMBSmileToEmoji(String paramString) {
        return paramString.replaceAll(":cool:", "<img src=emoji41>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":shy:", "<img src=emoji5>").replaceAll(":angel:", "<img src=emoji56>").replaceAll(":blush:", "<img src=emoji4>").replaceAll(":sleepy:", "<img src=emoji42>").replaceAll(":dodgy:", "<img src=emoji19>").replaceAll(":exclamation:", "<img src=emoji779>").replaceAll(":heart:", "<img src=emoji173>").replaceAll(":huh:", "<img src=emoji782>").replaceAll(":idea:", "<img src=emoji362>").replaceAll(":\\)", "<img src=emoji2>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":D", "<img src=emoji1>").replaceAll(":P", "<img src=emoji14>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":@", "<img src=emoji35>").replaceAll(":s", "<img src=emoji53>").replaceAll(":-\\/", "<img src=emoji47>");
    }

    public static String parsePBSSmileToEmoji(String paramString) {
        return paramString.replaceAll("&gt;:\\(", "<img src=emoji34>").replaceAll(">:\\(", "<img src=emoji34>").replaceAll("\\(:\\)\\)", "<img src=emoji185>").replaceAll("&gt;:D", "<img src=emoji35>").replaceAll(">:D", "<img src=emoji35>").replaceAll(":\\)\\)", "<img src=emoji2>").replaceAll("::\\)", "<img src=emoji3>").replaceAll(":\\)", "<img src=emoji4>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":D", "<img src=emoji1>").replaceAll("B-\\|", "<img src=emoji19>").replaceAll(":\\(", "<img src=emoji20>").replaceAll("x_x", "<img src=emoji21>").replaceAll(":o", "<img src=emoji33>").replaceAll(";-\\|", "<img src=emoji36>").replaceAll(":-S", "<img src=emoji37>").replaceAll("\\(puke\\)", "<img src=emoji40>").replaceAll("8-\\)", "<img src=emoji41>").replaceAll("\\(zzz\\)", "<img src=emoji42>").replaceAll("\\?\\?\\?", "<img src=emoji47>").replaceAll("P-\\)", "<img src=emoji48>").replaceAll("O_o", "<img src=emoji50>").replaceAll("8D", "<img src=emoji51>").replaceAll(":\\|", "<img src=emoji52>").replaceAll(":P", "<img src=emoji14>").replaceAll(":-\\[", "<img src=emoji15>").replaceAll(":-X", "<img src=emoji55>").replaceAll("8-\\|", "<img src=emoji57>").replaceAll(":-\\/", "<img src=emoji53>").replaceAll(":-\\*", "<img src=emoji8>").replaceAll(":'\\(", "<img src=emoji22>").replaceAll("\\(rofl\\)", "<img src=emoji5>");
    }

    public static String parsePBSmileToEmoji(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=emoji4>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":D", "<img src=emoji1>").replaceAll(":oops:", "<img src=emoji15>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":o", "<img src=emoji33>").replaceAll(":shock:", "<img src=emoji47>").replaceAll(":\\?:", "<img src=emoji780>").replaceAll(":\\?", "<img src=emoji53>").replaceAll(":cool:", "<img src=emoji41>").replaceAll(":lol:", "<img src=emoji3>").replaceAll(":P", "<img src=emoji14>").replaceAll(":cry:", "<img src=emoji22>").replaceAll(":evil:", "<img src=emoji49>").replaceAll(":twisted:", "<img src=emoji48>").replaceAll(":roll:", "<img src=emoji57>").replaceAll(":!:", "<img src=emoji779>").replaceAll(":idea:", "<img src=emoji362>").replaceAll(":arrow:", "<img src=emoji666>").replaceAll(":\\|", "<img src=emoji52>").replaceAll(":mrgreen:", "<img src=emoji2>").replaceAll(":geek:", "<img src=emoji67>").replaceAll(":ugeek:", "<img src=emoji71>").replaceAll("8-\\)", "<img src=emoji41>").replaceAll(":x", "<img src=emoji34>");
    }

    public static String parseSMF1SmileToEmoji(String paramString) {
        return paramString.replaceAll("::\\)", "<img src=emoji57>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":\\)", "<img src=emoji4>").replaceAll(":D", "<img src=emoji3>").replaceAll(";D", "<img src=emoji1>").replaceAll("&gt;:\\(", "<img src=emoji34>").replaceAll(">:\\(", "<img src=emoji34>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":o", "<img src=emoji50>").replaceAll("8\\)", "<img src=emoji41>").replaceAll("\\?\\?\\?", "<img src=emoji782>").replaceAll(":P", "<img src=emoji14>").replaceAll(":-\\[", "<img src=emoji15>").replaceAll(":-X", "<img src=emoji55>").replaceAll(":-\\\\", "<img src=emoji47>").replaceAll(":-\\*", "<img src=emoji8>").replaceAll(":'\\(", "<img src=emoji22>");
    }

    public static String parseSMF2SmileToEmoji(String paramString) {
        return paramString.replaceAll("&gt;:D", "<img src=emoji48>").replaceAll(">:D", "<img src=emoji48>").replaceAll("::\\)", "<img src=emoji57>").replaceAll(":\\)", "<img src=emoji4>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":D", "<img src=emoji2>").replaceAll(";D", "<img src=emoji16>").replaceAll("&gt;:\\(", "<img src=emoji34>").replaceAll(">:\\(", "<img src=emoji34>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":o", "<img src=emoji50>").replaceAll("8\\)", "<img src=emoji41>").replaceAll("\\?\\?\\?", "<img src=emoji47>").replaceAll(":P", "<img src=emoji14>").replaceAll(":-\\[", "<img src=emoji15>").replaceAll(":-X", "<img src=emoji55>").replaceAll(":-\\\\", "<img src=emoji47>").replaceAll(":-\\*", "<img src=emoji8>").replaceAll(":'\\(", "<img src=emoji22>").replaceAll("\\^-\\^", "<img src=emoji5>");
    }

    public static String parseSmile(String paramString, ForumStatus paramForumStatus) {
        String str = paramString;
        if (paramForumStatus != null) {
            str = paramString;
            if (paramForumStatus.tapatalkForum != null) {
                str = paramString;
                if (paramForumStatus.isSupportEmoji()) {
                    str = parseAllForumPublicSmileToEmoji(paramString);
                }
                if (!paramForumStatus.isIP()) {
                    break label57;
                }
                paramString = parseIPSmileToEmoji(str);
            }
        }
        for (; ; ) {
            str = paramString;
            if (paramForumStatus.isSupportEmoji()) {
                str = parseAllEmoji(paramString);
            }
            return str;
            label57:
            if (paramForumStatus.isVB3()) {
                paramString = parseVB3SmileToEmoji(str);
            } else if (paramForumStatus.isVB4()) {
                paramString = parseVB4SmileToEmoji(str);
            } else if (paramForumStatus.isVB5()) {
                paramString = parseVB5SmileToEmoji(str);
            } else if (paramForumStatus.isMB()) {
                paramString = parseMBSmileToEmoji(str);
            } else if (paramForumStatus.isPBS()) {
                paramString = parsePBSSmileToEmoji(str);
            } else if (paramForumStatus.isPB()) {
                paramString = parsePBSmileToEmoji(str);
            } else if ((paramForumStatus.isKN1()) || (paramForumStatus.isKN2())) {
                paramString = parseKNSmileToEmoji(str);
            } else if (paramForumStatus.isXF()) {
                paramString = parseXFSmileToEmoji(str);
            } else if (paramForumStatus.isSMF1()) {
                paramString = parseSMF1SmileToEmoji(str);
            } else if (paramForumStatus.isSMF2()) {
                paramString = parseSMF2SmileToEmoji(str);
            } else {
                paramString = parseVBSmileToEmoji(str);
            }
        }
    }

    public static String parseSmileForIP(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=tap_smile>").replaceAll(":\\(", "<img src=tap_frown>").replaceAll(":rolleyes:", "<img src=tap_rolleyes>").replaceAll(":mellow:", "<img src=tap_mellow>").replaceAll(":huh:", "<img src=tap_huh>").replaceAll(":D", "<img src=tap_biggrin>").replaceAll("\\^_\\^", "<img src=tap_happy>").replaceAll(":o", "<img src=tap_shocked>").replaceAll(":lol:", "<img src=tap_laugh>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll("B\\)", "<img src=tap_cool>").replaceAll("-_-", "<img src=tap_sleep>").replaceAll(">_>", "<img src=tap_dry>").replaceAll(":wub:", "<img src=tap_heart>").replaceAll(":angry:", "<img src=tap_angry>").replaceAll(":unsure:", "<img src=tap_undecided>").replaceAll(":wacko:", "<img src=tap_sick>").replaceAll(":blink:", "<img src=tap_blink>");
    }

    public static String parseSmileForKN(String paramString) {
        return paramString.replaceAll(":oops:", "<img src=tap_blush>").replaceAll(":pinch:", "<img src=tap_pinch>").replaceAll("B\\)", "<img src=tap_cool>").replaceAll(":-\\(", "<img src=tap_sad>").replaceAll(":\\)", "<img src=tap_shocked>").replaceAll(":cheer:", "<img src=tap_cheerful>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(":angry:", "<img src=tap_angry>").replaceAll(":o", "<img src=tap_shocked>").replaceAll(":\\?", "<img src=tap_confused>").replaceAll(":dry:", "<img src=tap_ermm>").replaceAll(":X", "<img src=tap_sick>").replaceAll(":silly:", "<img src=tap_silly>").replaceAll(":kiss:", "<img src=tap_kissing>").replaceAll(":rolleyes:", "<img src=tap_blink>").replaceAll(":woohoo:", "<img src=tap_lol>").replaceAll(":side:", "<img src=tap_sideways>").replaceAll(":S", "<img src=tap_dizzy>").replaceAll(":evil:", "<img src=tap_evil>").replaceAll(":whistle:", "<img src=tap_whistling>").replaceAll(":D", "<img src=tap_laugh>").replaceAll(":\\|", "<img src=tap_neutral>").replaceAll(":mrgreen:", "<img src=tap_mrgreen>").replaceAll(":\\?:", "<img src=tap_huh>").replaceAll(":!:", "<img src=tap_exclamation>").replaceAll(":arrow:", "<img src=tap_arrow>").replaceAll(":idea:", "<img src=tap_idea>");
    }

    public static String parseSmileForMB(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=tap_smile>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":cool:", "<img src=tap_cool>").replaceAll(":D", "<img src=tap_biggrin>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(":rolleyes:", "<img src=tap_rolleyes>").replaceAll(":shy:", "<img src=tap_blush>").replaceAll(":\\(", "<img src=tap_frown>").replaceAll(":angel:", "<img src=tap_angel>").replaceAll(":@", "<img src=tap_angry>").replaceAll(":blush:", "<img src=tap_blush>").replaceAll(":sleepy:", "<img src=tap_sleep>").replaceAll(":s", "<img src=tap_huh>").replaceAll(":dodgy:", "<img src=tap_dodgy>").replaceAll(":exclamation:", "<img src=tap_exclamation>").replaceAll(":heart:", "<img src=tap_heart>").replaceAll(":huh:", "<img src=tap_huh>").replaceAll(":idea:", "<img src=tap_idea>").replaceAll(":-\\/", "<img src=tap_undecided>");
    }

    public static String parseSmileForPB(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=tap_smile>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":D", "<img src=tap_biggrin>").replaceAll(":\\(", "<img src=tap_frown>").replaceAll(":o", "<img src=tap_shocked>").replaceAll(":shock:", "<img src=tap_eek>").replaceAll(":\\?", "<img src=tap_huh>").replaceAll(":cool:", "<img src=tap_cool>").replaceAll(":lol:", "<img src=tap_lol>").replaceAll(":mad:", "<img src=tap_angry>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":cry:", "<img src=tap_cry>").replaceAll(":evil:", "<img src=tap_evil>").replaceAll(":twisted:", "<img src=tap_twisted>").replaceAll(":roll:", "<img src=tap_rolleyes>").replaceAll(":!:", "<img src=tap_exclamation>").replaceAll(":idea:", "<img src=tap_idea>").replaceAll(":arrow:", "<img src=tap_arrow>").replaceAll(":\\|", "<img src=tap_neutral>").replaceAll(":mrgreen:", "<img src=tap_mrgreen>").replaceAll(":geek:", "<img src=tap_geek>").replaceAll(":ugeek:", "<img src=tap_ugeek>");
    }

    public static String parseSmileForPBS(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=tap_smiley>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":D", "<img src=tap_laugh>").replaceAll(";D", "<img src=tap_grin>").replaceAll(">:\\( ", "<img src=tap_angry>").replaceAll(":o", "<img src=tap_shocked>").replaceAll("8-\\)", "<img src=tap_cool>").replaceAll("\\?\\?\\?", "<img src=tap_huh>").replaceAll("::\\)", "<img src=tap_rolleyes>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":-[", "<img src=tap_embarassed>").replaceAll(":-X", "<img src=tap_lipsrsealed>").replaceAll(":-\\/", "<img src=tap_undecided>").replaceAll(":-\\*", "<img src=tap_kissing>").replaceAll(":'\\(", "<img src=tap_cry>");
    }

    public static String parseSmileForSMF1(String paramString) {
        return paramString.replaceAll(">:D", "<img src=tap_evil>").replaceAll("::\\)", "<img src=tap_rolleyes>").replaceAll(":\\)", "<img src=tap_smile>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":D", "<img src=tap_biggrin>").replaceAll(";D", "<img src=tap_wink>").replaceAll(">:\\(", "<img src=tap_angry>").replaceAll(":\\(", "<img src=tap_frown>").replaceAll(":o", "<img src=tap_shocked>").replaceAll("8\\)", "<img src=tap_cool>").replaceAll("\\?\\?\\?", "<img src=tap_huh>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":-\\[", "<img src=tap_blush>").replaceAll(":-X", "<img src=tap_lipsrsealed>").replaceAll(":-\\\\", "<img src=tap_undecided>").replaceAll(":-\\*", "<img src=tap_kissing>").replaceAll(":'\\(", "<img src=tap_cry>");
    }

    public static String parseSmileForVB(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=tap_smile>").replaceAll(":\\(", "<img src=tap_frown>").replaceAll(":rolleyes:", "<img src=tap_rolleyes>").replaceAll(":cool:", "<img src=tap_cool>").replaceAll(":D", "<img src=tap_biggrin>").replaceAll(":eek:", "<img src=tap_eek>").replaceAll(":confused:", "<img src=tap_undecided>").replaceAll(":mad:", "<img src=tap_angry>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":sly:", "<img src=tap_silly>").replaceAll(":banghead:", "<img src=tap_banghead>").replaceAll(":beer:", "<img src=tap_embeer>").replaceAll(":what:", "<img src=tap_huh>").replaceAll(":thumbup:", "<img src=tap_thumbup>").replaceAll(":thumbdown:", "<img src=tap_thumbdown>").replaceAll(":good:", "<img src=tap_thumbup>");
    }

    public static String parseSmileForXF(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=tap_smile>").replaceAll(";\\)", "<img src=tap_wink>").replaceAll(":\\(", "<img src=tap_frown>").replaceAll(":mad:", "<img src=tap_angry>").replaceAll(":confused:", "<img src=tap_undecided>").replaceAll(":cool:", "<img src=tap_cool>").replaceAll(":p", "<img src=tap_tongue>").replaceAll(":P", "<img src=tap_tongue>").replaceAll(":D", "<img src=tap_biggrin>").replaceAll(":eek:", "<img src=tap_eek>").replaceAll(":oops:", "<img src=tap_shocked>").replaceAll(":rolleyes:", "<img src=tap_rolleyes>").replaceAll("o_O", "<img src=tap_afro>").replaceAll("O.o", "<img src=tap_afro>").replaceAll("o.O", "<img src=tap_afro>").replaceAll("O_o", "<img src=tap_afro>");
    }

    public static String parseVB3SmileToEmoji(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=emoji4>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":cool:", "<img src=emoji41>").replaceAll(":eek:", "<img src=emoji33>").replaceAll(":D", "<img src=emoji3>").replaceAll(":o", "<img src=emoji5>").replaceAll(":confused:", "<img src=emoji782>").replaceAll(":mad:", "<img src=emoji35>").replaceAll(":p", "<img src=emoji14>").replaceAll(";\\)", "<img src=emoji6>");
    }

    public static String parseVB4SmileToEmoji(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=emoji4>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":cool:", "<img src=emoji41>").replaceAll(":eek:", "<img src=emoji33>").replaceAll(":D", "<img src=emoji3>").replaceAll(":o", "<img src=emoji5>").replaceAll(":confused:", "<img src=emoji782>").replaceAll(":mad:", "<img src=emoji35>").replaceAll(":p", "<img src=emoji14>").replaceAll(";\\)", "<img src=emoji6>");
    }

    public static String parseVB5SmileToEmoji(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=emoji4>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":cool:", "<img src=emoji41>").replaceAll(":eek:", "<img src=emoji33>").replaceAll(":D", "<img src=emoji2>").replaceAll(":o", "<img src=emoji5>").replaceAll(":confused:", "<img src=emoji53>").replaceAll(":mad:", "<img src=emoji35>").replaceAll(":p", "<img src=emoji14>").replaceAll(";\\)", "<img src=emoji6>");
    }

    public static String parseVBSmileToEmoji(String paramString) {
        return paramString.replaceAll(":\\)", "<img src=emoji3>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":cool:", "<img src=emoji41>").replaceAll(":D", "<img src=emoji2>").replaceAll(":eek:", "<img src=emoji33>").replaceAll(":o", "<img src=emoji5>").replaceAll(":confused:", "<img src=emoji53>").replaceAll(":mad:", "<img src=emoji35>").replaceAll(":p", "<img src=emoji14>").replaceAll(":P", "<img src=emoji14>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":thumbup:", "<img src=emoji106>").replaceAll(":thumbdown:", "<img src=emoji107>");
    }

    public static String parseWBBSmileToEmoji(String paramString) {
        return paramString.replaceAll(":saint:", "<img src=emoji56>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":thumbup:", "<img src=emoji106>").replaceAll(":thumbsup:", "<img src=emoji106>").replaceAll(":thumbdown:", "<img src=emoji107>").replaceAll("\\|\\|", "<img src=emoji58>").replaceAll("\\^\\^", "<img src=emoji4>").replaceAll(":\\)", "<img src=emoji5>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":love:", "<img src=emoji7>").replaceAll(":\\*:", "<img src=emoji8>").replaceAll(":whistling:", "<img src=emoji10>").replaceAll(":\\( ", "<img src=emoji20>").replaceAll("X\\/ ", "<img src=emoji21>").replaceAll(";\\(", "<img src=emoji22>").replaceAll("X\\(", "<img src=emoji34>").replaceAll(":cursing:", "<img src=emoji36>").replaceAll("&gt;X  X:", "<img src=emoji40>").replaceAll(">X  X:", "<img src=emoji40>").replaceAll("8\\)", "<img src=emoji41>").replaceAll(":sleeping:", "<img src=emoji42>").replaceAll(":huh:", "<img src=emoji47>").replaceAll(":evil:", "<img src=emoji48>").replaceAll("8\\|", "<img src=emoji50>").replaceAll(":\\|", "<img src=emoji52>").replaceAll(":\\/", "<img src=emoji53>").replaceAll("&gt;3", "<img src=emoji173>").replaceAll(">3", "<img src=emoji173>").replaceAll(":!:", "<img src=emoji779>").replaceAll(":\\?:", "<img src=emoji780>").replaceAll("\\?\\(", "<img src=emoji782>").replaceAll(":D", "<img src=emoji1>").replaceAll("8o", "<img src=emoji2>").replaceAll(":S", "<img src=emoji37>").replaceAll(":P", "<img src=emoji14>");
    }

    public static String parseXFSmileToEmoji(String paramString) {
        return paramString.replaceAll(":oops:", "<img src=emoji15>").replaceAll("&gt;:\\(", "<img src=emoji35>").replaceAll(">:\\(", "<img src=emoji35>").replaceAll(":@", "<img src=emoji35>").replaceAll(":\\)", "<img src=emoji4>").replaceAll("\\(:", "<img src=emoji4>").replaceAll(":-\\)", "<img src=emoji4>").replaceAll(";\\)", "<img src=emoji6>").replaceAll(":\\(", "<img src=emoji20>").replaceAll(":mad:", "<img src=emoji35>").replaceAll(":confused:", "<img src=emoji53>").replaceAll(":cool:", "<img src=emoji41>").replaceAll("8-\\)", "<img src=emoji41>").replaceAll(":p", "<img src=emoji14>").replaceAll(":P", "<img src=emoji14>").replaceAll(":-p", "<img src=emoji14>").replaceAll(":-P", "<img src=emoji14>").replaceAll(":D", "<img src=emoji1>").replaceAll(":eek:", "<img src=emoji33>").replaceAll(":rolleyes:", "<img src=emoji57>").replaceAll(":o_O:", "<img src=emoji50>").replaceAll(":O.o:", "<img src=emoji50>").replaceAll(":o.O:", "<img src=emoji50>").replaceAll(":O_o:", "<img src=emoji50>").replaceAll(":o", "<img src=emoji33>");
    }

    public static List<BBElement> process(String paramString, ForumStatus paramForumStatus, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {
        System.currentTimeMillis();
        int j = paramInt + 1;
        if (j > 4) {
            localObject1 = new ArrayList();
            return (List<BBElement>) localObject1;
        }
        paramString.replace("\r", "");
        paramString.replace("\n", "");
        Object localObject1 = new Stack();
        LinkedList localLinkedList = new LinkedList();
        Object localObject2 = Pattern.compile(layoutPatternString, 2).matcher(paramString);
        label81:
        ArrayList localArrayList;
        int i;
        if (!((Matcher) localObject2).find()) {
            localArrayList = new ArrayList();
            Collections.sort(localLinkedList, new Comparator() {
                public int compare(BBcodeUtil.BBChunk paramAnonymousBBChunk1, BBcodeUtil.BBChunk paramAnonymousBBChunk2) {
                    return BBcodeUtil.BBChunk.access$2(paramAnonymousBBChunk1) - BBcodeUtil.BBChunk.access$2(paramAnonymousBBChunk2);
                }
            });
            paramInt = 0;
            localObject2 = new BBChunk(0, 0);
            i = 0;
        }
        BBChunk localBBChunk2;
        Object localObject3;
        String str;
        for (; ; ) {
            if (i >= localLinkedList.size()) {
                localObject1 = localArrayList;
                if (paramInt >= paramString.length()) {
                    break;
                }
                localArrayList.add(processNestedTags(paramString.substring(paramInt, paramString.length()), "COMMON", paramForumStatus, paramBoolean1, paramBoolean2, paramBoolean3));
                return localArrayList;
                paramInt = ((Matcher) localObject2).end() - ((Matcher) localObject2).start();
                BBChunk localBBChunk1 = new BBChunk(((Matcher) localObject2).start(), paramInt);
                if ((((Matcher) localObject2).group(openQuoteTagGroup) != null) || (((Matcher) localObject2).group(openSpoilerTagGroup) != null) || (((Matcher) localObject2).group(openSpoilerTagGroup1) != null) || (((Matcher) localObject2).group(openSpoilerTagGroup2) != null) || (((Matcher) localObject2).group(openCodeTagGroup) != null)) {
                    ((Stack) localObject1).push(localBBChunk1);
                    break label81;
                }
                if (((((Matcher) localObject2).group(closeQuoteTagGroup) == null) && (((Matcher) localObject2).group(closeSpoilerTagGroup) == null) && (((Matcher) localObject2).group(closeSpoilerTagGroup1) == null) && (((Matcher) localObject2).group(closeSpoilerTagGroup2) == null) && (((Matcher) localObject2).group(closeCodeTagGroup) == null)) || (((Stack) localObject1).isEmpty())) {
                    break label81;
                }
                try {
                    localBBChunk1 = (BBChunk) ((Stack) localObject1).pop();
                    localBBChunk1.close_start = ((Matcher) localObject2).start();
                    localBBChunk1.close_length = paramInt;
                    localLinkedList.add(localBBChunk1);
                } catch (Exception localException) {
                }
                break label81;
            }
            localBBChunk2 = (BBChunk) localLinkedList.get(i);
            localObject3 = (String) paramString.subSequence(localBBChunk2.start, localBBChunk2.start + localBBChunk2.length);
            localObject1 = localObject3;
            if (((String) localObject3).toLowerCase().contains("quote")) {
                localObject1 = "[quote]";
            }
            localObject3 = localObject1;
            if (((String) localObject1).toLowerCase().contains("code")) {
                localObject3 = "[code]";
            }
            str = paramString.substring(localBBChunk2.start + localBBChunk2.length, localBBChunk2.close_start);
            Matcher localMatcher = Pattern.compile(layoutPatternString, 34).matcher(str);
            if (localBBChunk2.start - paramInt > 0) {
                new BBElement();
                localArrayList.add(processNestedTags(paramString.substring(paramInt, localBBChunk2.start), "COMMON", paramForumStatus, paramBoolean1, paramBoolean2, paramBoolean3));
            }
            if ((localObject2 != null) && (((BBChunk) localObject2).start < localBBChunk2.start)) {
                localObject1 = localObject2;
                if (((BBChunk) localObject2).close_start > localBBChunk2.close_start) {
                }
            } else {
                localObject2 = new BBElement();
                if (!localMatcher.find()) {
                    break label758;
                }
                if (((BBElement) localObject2).content == null) {
                    ((BBElement) localObject2).content = new ArrayList();
                }
                ((BBElement) localObject2).type = "QUOTE";
                ((BBElement) localObject2).setDescription(paramString.substring(localBBChunk2.start, localBBChunk2.start + localBBChunk2.length));
                ((BBElement) localObject2).content.addAll(process(str, paramForumStatus, paramBoolean1, paramBoolean2, true, j));
                localArrayList.add(localObject2);
                paramInt = localBBChunk2.close_start + localBBChunk2.close_length;
                localObject1 = new BBChunk(localBBChunk2.start, localBBChunk2.length);
                ((BBChunk) localObject1).close_start = localBBChunk2.close_start;
                ((BBChunk) localObject1).close_length = localBBChunk2.close_length;
            }
            i += 1;
            localObject2 = localObject1;
        }
        label758:
        if (((String) localObject3).equalsIgnoreCase("[QUOTE]")) {
            localObject1 = processNestedTags(str, "QUOTE", paramForumStatus, paramBoolean1, paramBoolean2, true);
            ((BBElement) localObject1).setDescription(paramString.substring(localBBChunk2.start, localBBChunk2.start + localBBChunk2.length));
        }
        for (; ; ) {
            localArrayList.add(localObject1);
            localObject1 = new BBChunk(localBBChunk2.start, localBBChunk2.length);
            ((BBChunk) localObject1).close_start = localBBChunk2.close_start;
            ((BBChunk) localObject1).close_length = localBBChunk2.close_length;
            paramInt = localBBChunk2.close_start + localBBChunk2.close_length;
            break;
            if (((String) localObject3).equalsIgnoreCase("[SPOILER]")) {
                localObject1 = processNestedTags(str, "SPOIL", paramForumStatus, paramBoolean1, paramBoolean2, paramBoolean3);
            } else if (((String) localObject3).equalsIgnoreCase("[SPOIL]")) {
                localObject1 = processNestedTags(str, "SPOIL", paramForumStatus, paramBoolean1, paramBoolean2, paramBoolean3);
            } else if (((String) localObject3).equalsIgnoreCase("[HIDE]")) {
                localObject1 = processNestedTags(str, "SPOIL", paramForumStatus, paramBoolean1, paramBoolean2, paramBoolean3);
            } else {
                localObject1 = localObject2;
                if (((String) localObject3).equalsIgnoreCase("[CODE]")) {
                    ((BBElement) localObject2).type = "CODE";
                    localObject1 = new ArrayList();
                    localObject3 = new BBElement();
                    ((BBElement) localObject3).setType("TEXT");
                    ((BBElement) localObject3).setValue(str, paramForumStatus);
                    ((ArrayList) localObject1).add(localObject3);
                    ((BBElement) localObject2).content = ((ArrayList) localObject1);
                    localObject1 = localObject2;
                }
            }
        }
    }

    public static BBElement processNestedTags(String paramString1, String paramString2, ForumStatus paramForumStatus, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        Object localObject1 = paramString1.trim();
        localArrayList = new ArrayList();
        localHashMap = new HashMap();
        paramString1 = Pattern.compile("(?i)\\[url=(.*?)\\](\\s)*?\\[img\\](.*?)\\[", 2).matcher((CharSequence) localObject1);
        for (; ; ) {
            if (!paramString1.find()) {
                paramString1 = (String) localObject1;
                if (!paramBoolean2) {
                    paramString1 = StringEscapeUtils.escapeHtml((String) localObject1).replaceAll("\n", "<br />");
                }
                localObject1 = paramString1;
                if (paramString1.contains("dailymotion")) {
                    localObject1 = paramString1.replaceAll("(?i)\\[url=http://www.dailymotion.com/video/(.+?)\\](.+?)\\[\\/url\\]", "[img]http://www.dailymotion.com/thumbnail/video/$1[/img]").replaceAll("(?i)(\\[url(.*?)\\])http://www.dailymotion.com/video/(.+?)\\[\\/url\\]", "[img]http://www.dailymotion.com/thumbnail/video/$3[/img]").replaceAll("(?i)\\[dailymotion(.*?)\\](.+?)\\[\\/dailymotion\\]", "[img]http://www.dailymotion.com/thumbnail/video/$2[/img]");
                }
                paramString1 = (String) localObject1;
                if (((String) localObject1).contains("vimeo")) {
                    paramString1 = ((String) localObject1).replaceAll("(?i)\\[url=http://vimeo.com/(.+?)\\](.+?)\\[\\/url\\]", "[img]pt.tapatalk.com/vimeo.php?id=$1[/img]").replaceAll("(?i)\\[vimeo(.*?)\\](http://vimeo.com/)?(.+?)\\[\\/vimeo\\]", "[img]pt.tapatalk.com/vimeo.php?id=$3[/img]").replaceAll("(?i)\\[vimeo(.*?)\\](?i)\\[url=(.+?)[\\]|?](http://vimeo.com/)?(.+?)\\[\\/url\\]\\[\\/vimeo\\]", "[img]pt.tapatalk.com/vimeo.php?id=$4[/img]").replaceAll("(?i)(\\[url(.*?)\\])?http://(www\\.)?vimeo.com\\/(.+?)\\[\\/url\\]", "[img]pt.tapatalk.com/vimeo.php?id=$4[/img]").replaceAll("(?i)(\\[url(.*?)\\])?https://(www\\.|player\\.)?vimeo.com\\/(.+?)\\[\\/url\\]", "[img]pt.tapatalk.com/vimeo.php?id=$4[/img]");
                }
                localObject1 = paramString1;
                if (paramString1.contains("youtubehd")) {
                    localObject1 = paramString1.replaceAll("youtubehd", "youtube");
                }
                paramString1 = (String) localObject1;
                if (((String) localObject1).contains("yt")) {
                    paramString1 = ((String) localObject1).replaceAll("(?i)\\[yt=(.*?)\\](.*?)\\[\\/yt\\]", "[img]http://img.youtube.com/vi/$1/0.jpg[/img]");
                }
                localObject1 = paramString1;
                if (paramString1.contains("youtube")) {
                    localObject1 = paramString1.replaceAll("(?i)\\[youtube(.*?)\\](http://)(.+?)\\[\\/youtube\\]", "[URL$1\\]$2$3\\[\\/URL\\]").replaceAll("(?i)\\[youtube(.*?)\\](.+?)\\[\\/youtube\\]", "[URL$1\\]http://youtube.com/watch?v=$2\\[\\/URL\\]");
                }
                if (!((String) localObject1).contains("youtube.com")) {
                    paramString1 = (String) localObject1;
                    if (!((String) localObject1).contains("youtu.be")) {
                    }
                } else {
                    paramString1 = ((String) localObject1).replaceAll("(?i)\\[url=(http:\\/\\/)?(www\\.)?youtube.com\\/embed\\/(.+?)[\\]|?](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtube.com\\/embed\\/(.+?)[\\]|?](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtube.com\\/watch\\?.*?v=([^&#]+?)([&|#].*?)?\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url=(https:\\/\\/)?(www\\.)?youtube.com\\/watch\\?.*?v=(.+?)\\](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtu.be\\/watch\\?.*?v=(.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtube.com\\/v\\/(.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url=(http:\\/\\/)?(www\\.)?youtube.com\\/embed\\/(.+?)[\\]|?](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtube.com\\/embed\\/(.+?)[\\]|?](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtu.be\\/v\\/(.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url\\](http:\\/\\/)?(www\\.)?youtu.be\\/(.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url=(http:\\/\\/)?(www\\.)?youtu.be\\/(.+?)](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url=(http:\\/\\/)?(www\\.)?youtube.com\\/watch\\?.*?v=([^&#]+?)([&|#].*?)?[\\]|?](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]").replaceAll("(?i)\\[url=(http:\\/\\/)?(www\\.)?youtube.com\\/v\\/(.+?)[\\]|?](.+?)\\[\\/url\\]", "[img]http://img.youtube.com/vi/$3/0.jpg[/img]");
                }
                localObject1 = paramString1.replaceAll("(?is)\\[url\\](.+?)\\[\\/url\\]", "<a href=\"$1\"\\>$1\\<\\/a\\>").replaceAll("(?is)\\[url(.+?)\\](.+?)\\[\\/url\\]", "<a href$1\\>$2\\<\\/a\\>");
                paramString1 = (String) localObject1;
                if (((String) localObject1).contains("tIMG")) {
                    paramString1 = ((String) localObject1).replaceAll("(?i)\\[tIMG(.*?)\\](.+?)\\[\\/tIMG\\]", "[IMG$1\\]$2\\[\\/IMG\\]");
                }
                paramString1 = paramString1.replaceAll("(?i)\\[IMG(\\d+)(.*?)\\](.+?)\\[\\/IMG(.*?)\\]", "[IMG$2\\]$3\\[\\/IMG\\]").replaceAll("(?i)\\[mention=(.+?)\\](.+?)\\[\\/mention\\]", "<a href=\"tapatalk://uid\\/$1\"\\>@$2\\<\\/a\\>").replaceAll("(?i)\\[user=(.+?)\\](.+?)\\[\\/user\\]", "<a href=\"tapatalk://uid\\/$1\"\\>@$2\\<\\/a\\>").replaceAll("(?i)\\[member=(')?(.+?)(')?\\]", "<a href=\"tapatalk://uid\\/$2\"\\>@$2\\<\\/a\\>").replaceAll("(?i)\\[RIMG(.*?)\\](.+?)\\[\\/RIMG\\]", "[IMG$1\\]$2\\[\\/IMG\\]");
                paramBoolean1 = false;
                if ((paramString2 == "QUOTE") || (paramBoolean3)) {
                    paramBoolean1 = true;
                }
                localObject2 = new Stack();
                localObject3 = new LinkedList();
            }
            try {
                localObject1 = paramString1.replaceAll(closeImgTag + "\\s*" + openImgTag, closeImgTag + openImgTag);
                paramString1 = (String) localObject1;
            } catch (Exception localException) {
                for (; ; ) {
                    System.err.print(localException.toString());
                    continue;
                    int i = localException.end() - localException.start();
                    BBChunk localBBChunk = new BBChunk(localException.start(), i);
                    if ((localException.group(openImgTagGroup) != null) || (localException.group(openUrlTagGroup) != null) || (localException.group(openEmailTagGroup) != null)) {
                        ((Stack) localObject2).push(localBBChunk);
                    } else if (((localException.group(closeImgTagGroup) != null) || (localException.group(closeUrlTagGroup) != null) || ((localException.group(closeEmailTagGroup) != null) && (!((Stack) localObject2).isEmpty()))) && (!((Stack) localObject2).empty())) {
                        localBBChunk = (BBChunk) ((Stack) localObject2).pop();
                        localBBChunk.close_start = localException.start();
                        localBBChunk.close_length = i;
                        ((List) localObject3).add(localBBChunk);
                        continue;
                        localObject2 = (BBChunk) localException.next();
                        if (((BBChunk) localObject2).start - i > 0) {
                            localObject3 = new BBElement();
                            ((BBElement) localObject3).setType("TEXT");
                            ((BBElement) localObject3).setValue((String) paramString1.subSequence(i, ((BBChunk) localObject2).start), paramForumStatus);
                            ((BBElement) localObject3).setQuote(paramBoolean1);
                            localArrayList.add(localObject3);
                        }
                        localObject3 = new BBElement();
                        ((BBElement) localObject3).setType((String) paramString1.subSequence(((BBChunk) localObject2).start, ((BBChunk) localObject2).start + ((BBChunk) localObject2).length));
                        ((BBElement) localObject3).setValue(((String) paramString1.subSequence(((BBChunk) localObject2).start + ((BBChunk) localObject2).length, ((BBChunk) localObject2).close_start)).trim(), paramForumStatus);
                        if ((((BBElement) localObject3).getType().equalsIgnoreCase("img")) && (localHashMap.containsKey(((BBElement) localObject3).getValue()))) {
                            ((BBElement) localObject3).setDescription((String) localHashMap.get(((BBElement) localObject3).getValue()));
                        }
                        ((BBElement) localObject3).setQuote(paramBoolean1);
                        localArrayList.add(localObject3);
                        i = ((BBChunk) localObject2).close_start + ((BBChunk) localObject2).close_length;
                    }
                }
            }
            localObject1 = Pattern.compile(patternString, 2).matcher(paramString1);
            if (((Matcher) localObject1).find()) {
                break;
            }
            Collections.sort((List) localObject3, new Comparator() {
                public int compare(BBcodeUtil.BBChunk paramAnonymousBBChunk1, BBcodeUtil.BBChunk paramAnonymousBBChunk2) {
                    return BBcodeUtil.BBChunk.access$2(paramAnonymousBBChunk1) - BBcodeUtil.BBChunk.access$2(paramAnonymousBBChunk2);
                }
            });
            i = 0;
            localObject1 = ((List) localObject3).iterator();
            if (((Iterator) localObject1).hasNext()) {
                break label921;
            }
            if (i < paramString1.length()) {
                localObject1 = new BBElement();
                ((BBElement) localObject1).setType("TEXT");
                ((BBElement) localObject1).setValue((String) paramString1.subSequence(i, paramString1.length()), paramForumStatus);
                ((BBElement) localObject1).setQuote(paramBoolean1);
                localArrayList.add(localObject1);
            }
            paramString1 = new BBElement();
            paramString1.type = paramString2;
            paramString1.content = localArrayList;
            return paramString1;
            localHashMap.put(paramString1.group(3), paramString1.group(1));
        }
    }

    private static class BBChunk {
        private int close_length;
        private int close_start;
        private int length;
        private int start;

        public BBChunk(int paramInt1, int paramInt2) {
            this.start = paramInt1;
            this.length = paramInt2;
        }
    }

    public static class BBElement {
        public static final String TYPECODE = "CODE";
        public static final String TYPECOMMON = "COMMON";
        public static final String TYPEEMAIL = "EMAIL";
        public static final String TYPEIMG = "IMG";
        public static final String TYPEQUOTE = "QUOTE";
        public static final String TYPESPOIL = "SPOIL";
        public static final String TYPETEXT = "TEXT";
        public static final String TYPEURL = "URL";
        public static final String TYPEYOUTUBE = "YOUTUBE";
        public ArrayList<BBElement> content;
        private String description = null;
        private boolean isQuote;
        private Bitmap mBitmap = null;
        public String type;
        private String value;

        public String getDescription() {
            return this.description;
        }

        public Bitmap getImage() {
            return this.mBitmap;
        }

        public String getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public boolean isQuote() {
            return this.isQuote;
        }

        public void setDescription(String paramString) {
            this.description = paramString;
        }

        public void setQuote(boolean paramBoolean) {
            this.isQuote = paramBoolean;
        }

        public void setType(String paramString) {
            int j = 0;
            int i = paramString.length();
            if (paramString.charAt(paramString.length() - 1) == ']') {
                i = paramString.length() - 1;
            }
            if (paramString.charAt(0) == '[') {
                j = 1;
            }
            this.type = paramString.substring(j, i);
        }

        public void setValue(String paramString, ForumStatus paramForumStatus) {
            if ((this.type.equalsIgnoreCase("URL")) || (this.type.equalsIgnoreCase("EMAIL"))) {
                try {
                    String str2 = paramString.replaceAll("&quot;", "\"");
                    if (str2.charAt(0) == ']') {
                        this.value = str2.substring(1);
                        return;
                    }
                    String str1 = str2.substring(str2.indexOf("=") + 1);
                    paramString = str1;
                    if (str1.charAt(0) == '"') {
                        paramString = str1.substring(1);
                    }
                    int i = paramString.indexOf("]");
                    str1 = paramString;
                    if (i > 0) {
                        str1 = paramString;
                        if (i < paramString.length()) {
                            str1 = paramString.substring(0, i);
                        }
                    }
                    paramString = str1;
                    if (str1.charAt(str1.length() - 1) == '"') {
                        paramString = str1.substring(0, str1.length() - 1);
                    }
                    str1 = paramString;
                    if (!paramString.startsWith("http://")) {
                        str1 = "http://" + paramString;
                    }
                    this.value = str1;
                    setDescription(BBcodeUtil.parseSmile(str2.substring(str2.indexOf("]") + 1), paramForumStatus));
                    return;
                } catch (Exception paramString) {
                    paramString.printStackTrace();
                    return;
                }
            }
            if (this.type.equalsIgnoreCase("IMG")) {
                this.value = paramString.replaceAll("(?i)(\\?)(thumb|thumbnail)=\\w+(&|$)", "$1$3").replaceAll("(?i)(&amp;|&)(thumb|thumbnail)=\\w+(&|$)", "$3");
                return;
            }
            this.value = BBcodeUtil.parseSmile(paramString.replaceAll("&quot;", "\""), paramForumStatus);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/BBcodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */