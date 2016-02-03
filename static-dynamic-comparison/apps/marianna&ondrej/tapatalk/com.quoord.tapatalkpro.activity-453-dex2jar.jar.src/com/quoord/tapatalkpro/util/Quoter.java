package com.quoord.tapatalkpro.util;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quoter {
    public String authorString = new String();
    public String closingTagString = new String();
    public String contentString = new String();
    public boolean isExpanded = true;
    public String openingTagString = new String();
    public String originalString = new String();
    public String postidString = new String();
    public View quoteAreaLayout;
    public ImageView quoteArrow;
    public TextView quoteContent;
    public View quoteExpandButton;
    public EditText quoteTailContent;
    public TextView quoteTitle;
    public boolean shouldExpanded = true;
    public String timestampString = new String();

    public Quoter() {
        this.authorString = null;
        this.postidString = null;
        this.timestampString = null;
        this.contentString = null;
        this.originalString = null;
    }

    public Quoter(String paramString1, String paramString2, String paramString3) {
        this.authorString = paramString1;
        this.postidString = null;
        this.timestampString = null;
        this.contentString = paramString2;
        this.originalString = paramString3;
    }

    public Quoter(String paramString1, String paramString2, String paramString3, String paramString4) {
        this.authorString = paramString1;
        this.postidString = paramString2;
        this.timestampString = null;
        this.contentString = paramString3;
        this.originalString = paramString4;
    }

    public Quoter(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        this.authorString = paramString1;
        this.postidString = paramString2;
        this.timestampString = paramString3;
        this.contentString = paramString4;
        this.originalString = paramString5;
    }

    public Date getData() {
        if (this.timestampString == null) {
            return null;
        }
        return new Date(Long.parseLong(this.timestampString + "000"));
    }

    public String getDataString(String paramString) {
        if (this.timestampString == null) {
        }
        while ((paramString == null) || (paramString.length() == 0)) {
            return null;
        }
        return new SimpleDateFormat(paramString, Locale.getDefault()).format(new Date(Long.parseLong(this.timestampString + "000")));
    }

    public static class QuoterAnalyser {
        private String mAllQuoteString;
        private String mForumVersion;
        public ArrayList<Quoter> quoters = new ArrayList();

        public QuoterAnalyser() {
        }

        public QuoterAnalyser(String paramString1, String paramString2) {
            this.mAllQuoteString = paramString1;
            this.mForumVersion = paramString2;
            analyse();
        }

        private void analyse() {
            if ((this.mForumVersion == null) || (this.mForumVersion.length() == 0)) {
                return;
            }
            new String();
            String str2;
            String str1;
            int i;
            label55:
            Object localObject1;
            Object localObject2;
            ArrayList localArrayList;
            Matcher localMatcher;
            label97:
            label120:
            int j;
            if (this.mForumVersion.startsWith("vb3")) {
                str2 = "\\[QUOTE=(.*?);(.*?)\\]";
                str1 = "\\[/QUOTE\\]";
                i = sequence(1, 2, 0, 3);
                localObject1 = new ArrayList();
                localObject2 = new ArrayList();
                localArrayList = new ArrayList();
                localMatcher = Pattern.compile(str2, 2).matcher(this.mAllQuoteString);
                if (localMatcher.find()) {
                    break label578;
                }
                localMatcher = Pattern.compile(str1, 2).matcher(this.mAllQuoteString);
                if (localMatcher.find()) {
                    break label595;
                }
                localArrayList.add(Integer.valueOf(0));
                j = 0;
                label140:
                if (j < ((ArrayList) localObject1).size() - 1) {
                    break label612;
                }
                localArrayList.add(Integer.valueOf(this.mAllQuoteString.length()));
                j = 0;
                label169:
                if (j < localArrayList.size() - 1) {
                    localObject1 = new Quoter();
                    ((Quoter) localObject1).originalString = this.mAllQuoteString.substring(((Integer) localArrayList.get(j)).intValue(), ((Integer) localArrayList.get(j + 1)).intValue());
                    localObject2 = Pattern.compile(str2, 2).matcher(((Quoter) localObject1).originalString);
                    if (((Matcher) localObject2).find()) {
                        break label665;
                    }
                }
            }
            for (; ; ) {
                j += 1;
                break label169;
                break;
                if (this.mForumVersion.startsWith("vb40")) {
                    str2 = "\\[QUOTE=(.*?);(.*?)\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 2, 0, 3);
                    break label55;
                }
                if (this.mForumVersion.startsWith("ip30")) {
                    str2 = "\\[QUOTE name='(.*?)' timestamp='(.*?)' post='(.*?)'\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 3, 2, 4);
                    break label55;
                }
                if (this.mForumVersion.startsWith("ip34")) {
                    str2 = "\\[QUOTE name=\"(.*?)\" post=\"(.*?)\" timestamp=\"(.*?)\"\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 2, 3, 4);
                    break label55;
                }
                if (this.mForumVersion.startsWith("kn")) {
                    str2 = "\\[QUOTE=\"(.*?)\" post=(.*?)\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 2, 0, 3);
                    break label55;
                }
                if (this.mForumVersion.startsWith("mb")) {
                    str2 = "\\[QUOTE='(.*?)' pid='(.*?)' dateline='(.*?)'\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 2, 3, 4);
                    break label55;
                }
                if (this.mForumVersion.startsWith("pb")) {
                    str2 = "\\[QUOTE=\"(.*?)\"\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 0, 0, 2);
                    break label55;
                }
                if (this.mForumVersion.startsWith("sm")) {
                    str2 = "\\[QUOTE author=(.*?) link=(.*?) date=(.*?)\\]";
                    i = sequence(1, 2, 3, 4);
                    str1 = "\\[/QUOTE\\]";
                    break label55;
                }
                if (this.mForumVersion.startsWith("xf")) {
                    str2 = "\\[QUOTE=\"(.*?), post:(.*?), member:(.*?)\"\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 2, 0, 3);
                    break label55;
                }
                if (this.mForumVersion.startsWith("vn")) {
                    str2 = "\\[QUOTE=\"(.*?)\"\\]";
                    str1 = "\\[/QUOTE\\]";
                    i = sequence(1, 0, 0, 2);
                    break label55;
                }
                if (!this.mForumVersion.startsWith("proboards")) {
                    break;
                }
                str2 = "\\[quote author=\"@(.*?)\" source=\"(.*?)\" timestamp=\"(.*?)\"\\]";
                str1 = "\\[/quote\\]";
                i = sequence(1, 2, 3, 5);
                break label55;
                label578:
                ((ArrayList) localObject1).add(Integer.valueOf(localMatcher.start()));
                break label97;
                label595:
                ((ArrayList) localObject2).add(Integer.valueOf(localMatcher.start()));
                break label120;
                label612:
                if (((Integer) ((ArrayList) localObject1).get(j + 1)).intValue() > ((Integer) ((ArrayList) localObject2).get(j)).intValue()) {
                    localArrayList.add((Integer) ((ArrayList) localObject1).get(j + 1));
                }
                j += 1;
                break label140;
                label665:
                int k = getNamePos(i);
                if (k > 0) {
                    ((Quoter) localObject1).authorString = ((Matcher) localObject2).group(k);
                }
                k = getPostidPos(i);
                if (k > 0) {
                    ((Quoter) localObject1).postidString = ((Matcher) localObject2).group(k);
                }
                k = getTimestampPos(i);
                if (k > 0) {
                    ((Quoter) localObject1).timestampString = ((Matcher) localObject2).group(k);
                }
                ((Quoter) localObject1).openingTagString = ((Matcher) localObject2).group();
                ((Quoter) localObject1).closingTagString = str1.replaceAll("\\\\", "");
                int n = ((Matcher) localObject2).end();
                int m = ((Quoter) localObject1).originalString.lastIndexOf(((Quoter) localObject1).closingTagString);
                k = m;
                if (m < 0) {
                    ((Quoter) localObject1).closingTagString = ((Quoter) localObject1).closingTagString.toLowerCase();
                    k = ((Quoter) localObject1).originalString.lastIndexOf(((Quoter) localObject1).closingTagString);
                }
                ((Quoter) localObject1).contentString = ((Quoter) localObject1).originalString.substring(n, k);
                ((Quoter) localObject1).originalString = ((Quoter) localObject1).originalString.substring(0, ((Quoter) localObject1).closingTagString.length() + k);
                this.quoters.add(localObject1);
            }
        }

        private int getContentPos(int paramInt) {
            return paramInt / 1 % 10;
        }

        private int getNamePos(int paramInt) {
            return paramInt / 1000 % 10;
        }

        private int getPostidPos(int paramInt) {
            return paramInt / 100 % 10;
        }

        private int getTimestampPos(int paramInt) {
            return paramInt / 10 % 10;
        }

        private int sequence(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
            return paramInt1 * 1000 + paramInt2 * 100 + paramInt3 * 10 + paramInt4 * 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/Quoter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */