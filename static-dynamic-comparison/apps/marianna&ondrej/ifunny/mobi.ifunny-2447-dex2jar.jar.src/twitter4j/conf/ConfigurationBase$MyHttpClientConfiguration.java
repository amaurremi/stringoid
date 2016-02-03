package twitter4j.conf;

import java.io.Serializable;

import twitter4j.HttpClientConfiguration;

class ConfigurationBase$MyHttpClientConfiguration
        implements Serializable, HttpClientConfiguration {
    private static final long serialVersionUID = 8226866124868861058L;
    private boolean gzipEnabled = true;
    private int httpConnectionTimeout = 20000;
    private String httpProxyHost = null;
    private String httpProxyPassword = null;
    private int httpProxyPort = -1;
    private String httpProxyUser = null;
    private int httpReadTimeout = 120000;
    private boolean prettyDebug = false;

    ConfigurationBase$MyHttpClientConfiguration(ConfigurationBase paramConfigurationBase, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
        this.httpProxyHost = paramString1;
        this.httpProxyUser = paramString2;
        this.httpProxyPassword = paramString3;
        this.httpProxyPort = paramInt1;
        this.httpConnectionTimeout = paramInt2;
        this.httpReadTimeout = paramInt3;
        this.prettyDebug = paramBoolean1;
        this.gzipEnabled = paramBoolean2;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (MyHttpClientConfiguration) paramObject;
            if (this.gzipEnabled != ((MyHttpClientConfiguration) paramObject).gzipEnabled) {
                return false;
            }
            if (this.httpConnectionTimeout != ((MyHttpClientConfiguration) paramObject).httpConnectionTimeout) {
                return false;
            }
            if (this.httpProxyPort != ((MyHttpClientConfiguration) paramObject).httpProxyPort) {
                return false;
            }
            if (this.httpReadTimeout != ((MyHttpClientConfiguration) paramObject).httpReadTimeout) {
                return false;
            }
            if (this.prettyDebug != ((MyHttpClientConfiguration) paramObject).prettyDebug) {
                return false;
            }
            if (this.httpProxyHost != null) {
                if (this.httpProxyHost.equals(((MyHttpClientConfiguration) paramObject).httpProxyHost)) {
                }
            } else {
                while (((MyHttpClientConfiguration) paramObject).httpProxyHost != null) {
                    return false;
                }
            }
            if (this.httpProxyPassword != null) {
                if (this.httpProxyPassword.equals(((MyHttpClientConfiguration) paramObject).httpProxyPassword)) {
                }
            } else {
                while (((MyHttpClientConfiguration) paramObject).httpProxyPassword != null) {
                    return false;
                }
            }
            if (this.httpProxyUser == null) {
                break;
            }
        } while (this.httpProxyUser.equals(((MyHttpClientConfiguration) paramObject).httpProxyUser));
        for (; ; ) {
            return false;
            if (((MyHttpClientConfiguration) paramObject).httpProxyUser == null) {
                break;
            }
        }
    }

    public int getHttpConnectionTimeout() {
        return this.httpConnectionTimeout;
    }

    public String getHttpProxyHost() {
        return this.httpProxyHost;
    }

    public String getHttpProxyPassword() {
        return this.httpProxyPassword;
    }

    public int getHttpProxyPort() {
        return this.httpProxyPort;
    }

    public String getHttpProxyUser() {
        return this.httpProxyUser;
    }

    public int getHttpReadTimeout() {
        return this.httpReadTimeout;
    }

    public int getHttpRetryCount() {
        return ConfigurationBase.access$000(this.this$0);
    }

    public int getHttpRetryIntervalSeconds() {
        return ConfigurationBase.access$100(this.this$0);
    }

    public int hashCode() {
        int n = 1;
        int i;
        int j;
        label33:
        int k;
        label48:
        int i1;
        int i2;
        int i3;
        int m;
        if (this.httpProxyHost != null) {
            i = this.httpProxyHost.hashCode();
            if (this.httpProxyUser == null) {
                break label130;
            }
            j = this.httpProxyUser.hashCode();
            if (this.httpProxyPassword == null) {
                break label135;
            }
            k = this.httpProxyPassword.hashCode();
            i1 = this.httpProxyPort;
            i2 = this.httpConnectionTimeout;
            i3 = this.httpReadTimeout;
            if (!this.prettyDebug) {
                break label140;
            }
            m = 1;
            label76:
            if (!this.gzipEnabled) {
                break label146;
            }
        }
        for (; ; ) {
            return (m + ((((k + (j + i * 31) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + n;
            i = 0;
            break;
            label130:
            j = 0;
            break label33;
            label135:
            k = 0;
            break label48;
            label140:
            m = 0;
            break label76;
            label146:
            n = 0;
        }
    }

    public boolean isGZIPEnabled() {
        return this.gzipEnabled;
    }

    public boolean isPrettyDebugEnabled() {
        return this.prettyDebug;
    }

    public String toString() {
        return "MyHttpClientConfiguration{httpProxyHost='" + this.httpProxyHost + '\'' + ", httpProxyUser='" + this.httpProxyUser + '\'' + ", httpProxyPassword='" + this.httpProxyPassword + '\'' + ", httpProxyPort=" + this.httpProxyPort + ", httpConnectionTimeout=" + this.httpConnectionTimeout + ", httpReadTimeout=" + this.httpReadTimeout + ", prettyDebug=" + this.prettyDebug + ", gzipEnabled=" + this.gzipEnabled + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/conf/ConfigurationBase$MyHttpClientConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */