package com.houssame.mission.config.utilities;





public class JWTUtil {
    public static final String SERCRET = "myHMACPrivateKey";
    public static final String AUTH_HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final String ACCESS_TOKEN = "Access_Token ";
    public static final String REFRESH_TOKEN = "Refresh_Token ";
    public static final long EXPIRE_ACCESS_TOKEN = 15*60*1000;
    public static final long EXPIRE_REFRESH_TOKEN = 10*60*1000;

}
