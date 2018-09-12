package com.prayertimes.azan;

import static com.prayertimes.azan.Constants.KAABA_LATITUDE;
import static com.prayertimes.azan.Constants.KAABA_LONGITUDE;
import static com.prayertimes.azan.Constants.TOTAL_DEGREES;
import static com.prayertimes.azan.util.MathUtil.atan2Deg;
import static com.prayertimes.azan.util.MathUtil.cosDeg;
import static com.prayertimes.azan.util.MathUtil.sinDeg;
import static com.prayertimes.azan.util.MathUtil.tanDeg;

/**
 * Created by AhmedEltaher on 13/11/16.
 */

public class QiblaUtils {
    /**
     * Return qibla direction in degrees from the north (clock-wise).
     *
     * @param latitude  latitude in degrees
     * @param longitude longitude in degrees
     * @return 0 means north, 90 means east, 270 means west, etc
     */
    public static double qibla(double latitude, double longitude) {
        double degrees = atan2Deg(sinDeg(KAABA_LONGITUDE - longitude),
            cosDeg(latitude) * tanDeg(KAABA_LATITUDE)
                - sinDeg(latitude) * cosDeg(KAABA_LONGITUDE - longitude));
        return degrees >= 0 ? degrees : degrees + TOTAL_DEGREES;
    }
}
