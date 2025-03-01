package utils.helpers;

import utils.RuntimeProperties;
import enums.Environment;
import java.io.IOException;

public class SiteUrl
{

    public static String url(Environment environment) throws IOException
    {
        String url = "";

        if (RuntimeProperties.environment == Environment.TEST) {
            url = "http://automationpractice.com/index.php";
        }
        //we can extend it further for multiple environments
        return url;
    }
}
