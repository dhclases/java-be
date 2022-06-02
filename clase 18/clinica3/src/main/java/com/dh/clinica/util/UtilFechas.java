package com.dh.clinica.util;

import org.apache.log4j.Logger;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class UtilFechas {
    final static Logger log = Logger.getLogger(H2Gestor.class);

    public Date convertirStringADate(String fecha) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Americas/Argentina"));

        java.util.Date date = null;
        try {
            date = dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return new java.sql.Date(date.getTime());
    }

    public String convertirDateAString(Date fecha) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(fecha);
    }

}
