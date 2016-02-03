package twitter4j.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class TimeSpanConverter
        implements Serializable {
    private static final int AN_HOUR_AGO = 4;
    private static final int A_MINUTE_AGO = 2;
    private static final int NOW = 0;
    private static final int N_HOURS_AGO = 5;
    private static final int N_MINUTES_AGO = 3;
    private static final int N_SECONDS_AGO = 1;
    private static final int ONE_DAY_IN_SECONDS = 86400;
    private static final int ONE_HOUR_IN_SECONDS = 3600;
    private static final int ONE_MONTH_IN_SECONDS = 2592000;
    private static final long serialVersionUID = 3557748591604361946L;
    private final SimpleDateFormat dateMonth;
    private final SimpleDateFormat dateMonthYear;
    private final MessageFormat[] formats = new MessageFormat[6];

    public TimeSpanConverter() {
        this(Locale.getDefault());
    }

    public TimeSpanConverter(Locale paramLocale) {
        String str = paramLocale.getLanguage();
        if ("it".equals(str)) {
            this.formats[0] = new MessageFormat("Ora");
            this.formats[1] = new MessageFormat("{0} secondi fa");
            this.formats[2] = new MessageFormat("1 minuto fa");
            this.formats[3] = new MessageFormat("{0} minuti fa");
            this.formats[4] = new MessageFormat("1 ora fa");
            this.formats[5] = new MessageFormat("{0} ore fa");
            this.dateMonth = new SimpleDateFormat("d MMM", paramLocale);
            this.dateMonthYear = new SimpleDateFormat("d MMM yy", paramLocale);
            return;
        }
        if ("kr".equals(str)) {
            this.formats[0] = new MessageFormat("지금");
            this.formats[1] = new MessageFormat("{0}초 전");
            this.formats[2] = new MessageFormat("1분 전");
            this.formats[3] = new MessageFormat("{0}분 전");
            this.formats[4] = new MessageFormat("1시간 전");
            this.formats[5] = new MessageFormat("{0} ore fa");
            this.dateMonth = new SimpleDateFormat("M월 d일", paramLocale);
            this.dateMonthYear = new SimpleDateFormat("yy년 M월 d일", paramLocale);
            return;
        }
        if ("es".equals(str)) {
            this.formats[0] = new MessageFormat("Ahora");
            this.formats[1] = new MessageFormat("hace {0} segundos");
            this.formats[2] = new MessageFormat("hace 1 munito");
            this.formats[3] = new MessageFormat("hace {0} munitos");
            this.formats[4] = new MessageFormat("hace 1 hora");
            this.formats[5] = new MessageFormat("hace {0} horas");
            this.dateMonth = new SimpleDateFormat("d MMM", paramLocale);
            this.dateMonthYear = new SimpleDateFormat("d MMM yy", paramLocale);
            return;
        }
        if ("fr".equals(str)) {
            this.formats[0] = new MessageFormat("Maintenant");
            this.formats[1] = new MessageFormat("Il y a {0} secondes");
            this.formats[2] = new MessageFormat("Il y a 1 minute");
            this.formats[3] = new MessageFormat("Il y a {0} minutes");
            this.formats[4] = new MessageFormat("Il y a 1 heure");
            this.formats[5] = new MessageFormat("Il y a {0} heures");
            this.dateMonth = new SimpleDateFormat("d MMM", paramLocale);
            this.dateMonthYear = new SimpleDateFormat("d MMM yy", paramLocale);
            return;
        }
        if ("de".equals(str)) {
            this.formats[0] = new MessageFormat("Jetzt");
            this.formats[1] = new MessageFormat("vor {0} Sekunden");
            this.formats[2] = new MessageFormat("vor 1 Minute");
            this.formats[3] = new MessageFormat("vor {0} Minuten");
            this.formats[4] = new MessageFormat("vor 1 Stunde");
            this.formats[5] = new MessageFormat("vor {0} Stunden");
            this.dateMonth = new SimpleDateFormat("d MMM", paramLocale);
            this.dateMonthYear = new SimpleDateFormat("d MMM yy", paramLocale);
            return;
        }
        if ("ja".equals(str)) {
            this.formats[0] = new MessageFormat("今");
            this.formats[1] = new MessageFormat("{0}秒前");
            this.formats[2] = new MessageFormat("1分前");
            this.formats[3] = new MessageFormat("{0}分前");
            this.formats[4] = new MessageFormat("1時間前");
            this.formats[5] = new MessageFormat("{0}時間前");
            this.dateMonth = new SimpleDateFormat("M月d日", paramLocale);
            this.dateMonthYear = new SimpleDateFormat("yy年M月d日", paramLocale);
            return;
        }
        this.formats[0] = new MessageFormat("now");
        this.formats[1] = new MessageFormat("{0} seconds ago");
        this.formats[2] = new MessageFormat("1 minute ago");
        this.formats[3] = new MessageFormat("{0} minutes ago");
        this.formats[4] = new MessageFormat("1 hour ago");
        this.formats[5] = new MessageFormat("{0} hours ago");
        this.dateMonth = new SimpleDateFormat("d MMM", Locale.ENGLISH);
        this.dateMonthYear = new SimpleDateFormat("d MMM yy", Locale.ENGLISH);
    }

    private String toTimeSpanString(int paramInt) {
        if (paramInt <= 1) {
            return this.formats[0].format(null);
        }
        if (paramInt < 60) {
            return this.formats[1].format(new Object[]{Integer.valueOf(paramInt)});
        }
        if (paramInt < 2700) {
            paramInt /= 60;
            if (paramInt == 1) {
                return this.formats[2].format(null);
            }
            return this.formats[3].format(new Object[]{Integer.valueOf(paramInt)});
        }
        if (paramInt < 6300) {
            return this.formats[4].format(null);
        }
        paramInt = (paramInt + 900) / 3600;
        return this.formats[5].format(new Object[]{Integer.valueOf(paramInt)});
    }

    public String toTimeSpanString(long paramLong) {
        int i = (int) ((System.currentTimeMillis() - paramLong) / 1000L);
        if (i >= 86400) {
            if (i >= 2592000) {
                return this.dateMonthYear.format(new Date(paramLong));
            }
            return this.dateMonth.format(new Date(paramLong));
        }
        return toTimeSpanString(i);
    }

    public String toTimeSpanString(Date paramDate) {
        return toTimeSpanString(paramDate.getTime());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/util/TimeSpanConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */