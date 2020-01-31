package foundation.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class dateFormat {

    public static Date[] sortDateInDifferentFormat(String[] str) throws ParseException {
        SimpleDateFormat sobj = new SimpleDateFormat("MM-dd-yyyy");
        Date[] date = new Date[str.length];
        for(int i = 0; i < str.length; i++) {
            date[i] = sobj.parse(str[i]);
        }
        Arrays.sort(date);
        return date;
    }

    public static void main(String[] args) throws ParseException {
        String[] str = {"2-10-2020", "1-10-2020"};
        Date[] date = sortDateInDifferentFormat(str);
        for (Date d : date) {
            System.out.println(d);
        }
    }
}

