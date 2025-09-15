package com.cerouno.qawadis_api.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class DateTimeHelper {

    private static ZoneId appZoneId;

    public DateTimeHelper(@Value("${app.timezone:Asia/Kuala_Lumpur}") String timezone) {
        appZoneId = ZoneId.of(timezone);
    }

    public static LocalDateTime toCurrentTimeZone(LocalDateTime dateTime) {
        if (dateTime == null) return null;

        ZonedDateTime systemZoned = dateTime.atZone(ZoneOffset.UTC);
        ZonedDateTime converted = systemZoned.withZoneSameInstant(appZoneId);

        return converted.toLocalDateTime();
    }

    public static LocalDateTime toUtcTimeZone(LocalDateTime dateTime) {
        if (dateTime == null) return null;

        ZonedDateTime systemZoned = dateTime.atZone(appZoneId);
        ZonedDateTime converted = systemZoned.withZoneSameInstant(ZoneOffset.UTC);

        return converted.toLocalDateTime();
    }

    public static LocalDateTime toCurrentTimeZone(LocalDateTime dateTime, ZoneId fromZone) {
        if (dateTime == null) return null;

        ZonedDateTime zoned = dateTime.atZone(fromZone);
        ZonedDateTime converted = zoned.withZoneSameInstant(appZoneId);

        return converted.toLocalDateTime();
    }

}
