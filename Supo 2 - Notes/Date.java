public class Date {
    public int year;
    public int month;
    public int day;

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkDate(int year, int month, int day) {
        if ((day >= 1) && (day <= 31) && (month >= 1) && (month <= 12) && (year >= 0) && (year <= 2026)) { //Large overall check
            //fine tune the check
            if (month == 2) { //is it Feburary
                return ((day <= 28) || (isLeapYear(year) && day==29));
            }
            else { // if its not February
                if (((month <= 7) && ((month & 1) == 1)) || ((month >= 8) && (month & 1) == 0)) { //identifies that the month has 31 days
                    return true;
                } else {
                    return (day <= 30);
                }
            }
        }
        return false;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {return this.year;}
    public int getMonth() {return this.month;}
    public int getDay() {return this.day;}

    public String formatDate() {
        return String.valueOf(this.day) + "/" + String.valueOf(this.month) + "/" + String.valueOf(this.year);
    }
}