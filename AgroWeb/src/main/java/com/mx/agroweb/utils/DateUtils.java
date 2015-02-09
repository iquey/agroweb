package com.mx.agroweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateUtils {

	public static void main(String[] args) {

	}

	public static String getUTCTime() {

		int n_utc_time[] = new int[2];
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		DateTime now = new DateTime(DateTimeZone.UTC);

		@SuppressWarnings("deprecation")
		Date datew = new Date(now.getYear(), now.getMonthOfYear(), now.getDayOfYear(), now.getHourOfDay(),
				now.getMinuteOfHour(), now.getSecondOfMinute());

		return null;
	}

	/**
	 * Metodo que valida la vigencia en contra de la hora actual.
	 * @param fechaFinalVigencia
	 * @return
	 */
	public static boolean isVigente(String fechaFinalVigencia) {
		String pattern = "dd-MM-yyyy HH:mm:ss";
//		26-12-2014 00:00:00
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		try {

			Date fechaVigencia = dateFormat.parse(fechaFinalVigencia);
			Date fechaActual = new Date();

			if (fechaActual.compareTo(fechaVigencia) <= 0) {
				return true;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}
