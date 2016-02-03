package com.quoord.tapatalkpro.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExternalIpAddressFetcher {
    private String externalIpProviderUrl;
    private String myExternalIpAddress = "";

    public ExternalIpAddressFetcher(String paramString) {
        this.externalIpProviderUrl = paramString;
        try {
            parse(fetchExternalIpProviderHTML(paramString));
            return;
        } catch (Exception paramString) {
        }
    }

    private String fetchExternalIpProviderHTML(String paramString) {
        Object localObject3 = null;
        Object localObject4 = null;
        InputStream localInputStream1 = null;
        String str2 = null;
        String str3 = null;
        String str1 = null;
        InputStream localInputStream2 = localInputStream1;
        Object localObject1 = localObject3;
        Object localObject2 = localObject4;
        for (; ; ) {
            try {
                paramString = (HttpURLConnection) new URL(paramString).openConnection();
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                HttpURLConnection.setFollowRedirects(true);
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                paramString.setRequestMethod("GET");
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                paramString.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                paramString.setRequestProperty("Connection", "Keep-Alive");
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                paramString.setConnectTimeout(7000);
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                paramString.setReadTimeout(7000);
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                paramString.setRequestProperty("Accept-Encoding", "none");
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localObject3;
                str3 = paramString;
                localObject2 = localObject4;
                localInputStream1 = paramString.getInputStream();
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localInputStream1;
                str3 = paramString;
                localObject2 = localInputStream1;
                localObject3 = new byte['Ѐ'];
                i = 0;
                str1 = paramString;
                localInputStream2 = localInputStream1;
                str2 = paramString;
                localObject1 = localInputStream1;
                str3 = paramString;
                localObject2 = localInputStream1;
                if (i < localObject3.length) {
                    str1 = paramString;
                    localInputStream2 = localInputStream1;
                    str2 = paramString;
                    localObject1 = localInputStream1;
                    str3 = paramString;
                    localObject2 = localInputStream1;
                    j = localInputStream1.read((byte[]) localObject3, i, localObject3.length - i);
                    if (j >= 0) {
                    }
                } else {
                    str1 = paramString;
                    localInputStream2 = localInputStream1;
                    str2 = paramString;
                    localObject1 = localInputStream1;
                    str3 = paramString;
                    localObject2 = localInputStream1;
                    localObject3 = new String((byte[]) localObject3, "UTF-8");
                    if (localInputStream1 == null) {
                    }
                }
            } catch (SocketException paramString) {
                int i;
                int j;
                if (localInputStream2 != null) {
                }
                try {
                    localInputStream2.close();
                    str1.disconnect();
                } catch (Exception paramString) {
                    continue;
                }
                return null;
            } catch (Exception paramString) {
                if (localObject1 != null) {
                }
                try {
                    ((InputStream) localObject1).close();
                    str2.disconnect();
                } catch (Exception paramString) {
                }
                continue;
            } finally {
                if (localObject2 != null) {
                }
                try {
                    ((InputStream) localObject2).close();
                    str3.disconnect();
                } catch (Exception localException) {
                    continue;
                }
            }
            try {
                localInputStream1.close();
                paramString.disconnect();
                return (String) localObject3;
            } catch (Exception paramString) {
            }
            i += j;
        }
        return (String) localObject3;
    }

    private void parse(String paramString) {
        Pattern localPattern = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", 2);
        if ((paramString != null) && (paramString.length() > 0)) {
            paramString = localPattern.matcher(paramString);
        }
        for (; ; ) {
            if (!paramString.find()) {
                return;
            }
            this.myExternalIpAddress = paramString.group(0);
        }
    }

    public String getMyExternalIpAddress() {
        return this.myExternalIpAddress;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ExternalIpAddressFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */