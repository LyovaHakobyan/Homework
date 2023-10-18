package homeworks.medicalcenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm");

    static public boolean disturbEachOtherIn30MinDifference(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(Calendar.MINUTE, 30);
        Date updatedDate2 = calendar.getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.MINUTE, 30);
        Date updatedDate1 = c.getTime();
        if ((updatedDate2.after(date1) && date2.after(updatedDate1)) || (updatedDate1.after(date2) && date1.after(updatedDate2))) {
            return false;
        }
        return true;
    }

    public static Date stringToDate(String stringDate) throws ParseException {
        return sdf.parse(stringDate);
    }

    public static String dateTostring(Date date) {
        return sdf.format(date);
    }
}