package com.cerouno.qawadis_api.constant;

public interface AppConstants {

    // Common Messages
    public static final String ERROR_MSG = "An error occurred!";
    public static final String SUCCESS_MSG = "Operation was successful!";
    public static final String INVALID_TOKEN_MSG = "Invalid token provided!";

    // Date format patterns
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    // Lookup tables
    public static final String LT_GENERAL_STATUS_TABLE = "LT001";
    public static final String LT_SPORT_TABLE = "LT002";

    // Status
    public static final Long GSTS_ACTIVE = 1L;
    public static final Long GSTS_INACTIVE = 2L;
    public static final Long GSTS_CANCELED = 3L;
    public static final Long GSTS_CLOSED = 4L;

}
