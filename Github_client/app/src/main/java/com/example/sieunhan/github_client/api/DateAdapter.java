<<<<<<< HEAD
=======

>>>>>>> rebuilt-version
package com.example.sieunhan.github_client.api;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.ToJson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

<<<<<<< HEAD
/**
 * Created by dannyle on 03/12/2016.
 */

public class DateAdapter {
    private final DateFormat[] formats = new DateFormat[3];


=======
public class DateAdapter {
    private final DateFormat[] formats = new DateFormat[3];

>>>>>>> rebuilt-version
    public DateAdapter() {
        formats[0] = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'");
        formats[1] = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z");
        formats[2] = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss");
        final TimeZone timeZone = TimeZone.getTimeZone("Zulu");
        for (DateFormat format : formats) {
            format.setTimeZone(timeZone);
        }
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    @ToJson
    String toJson(Date date) {
        return formats[0].format(date);
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    @FromJson
    Date fromJson(String date) {
        for (DateFormat format : formats) {
            try {
                return format.parse(date);
            } catch (ParseException e) {
            }
        }

<<<<<<< HEAD

        throw new JsonDataException();
    }
}





=======
        throw new JsonDataException();
    }
}
>>>>>>> rebuilt-version
