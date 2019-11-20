package com.r7.rad.hhcc;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class ApplicationConstants {
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static  List<Locale> LOCALES = Arrays.asList(new Locale("en"), new Locale("my"))         ;
	public static int PAGE_SIZE = 200;
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String URL_ACCOUNT = "/rest/api/v1/account";
    public static final String URL_DOCTORS = "/rest/api/v1/doctors";
    public static final String URL_SERVICES = "/rest/api/v1/service";
    public static final String URL_LOCATION = "/rest/api/v1/location";


}
