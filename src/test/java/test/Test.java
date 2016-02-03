package test;

public class Test {

    String getWeatherUrl() {
        String host = "https://weather.example.com";
        String timeParam;
        if (System.currentTimeMillis() == 0)
            timeParam = "today";
        else
            timeParam = "tomorrow";
        StringBuilder timeQuery = new StringBuilder().append("time=").append(timeParam);
        return String.format(
                "%s?%s,city=%s",
                host, timeQuery, getCity());
    }

    String getCity() {
        return "";
    }
}
