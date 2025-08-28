package org.example.functions;

public class Time {
    public static String TimeByDuration(long totalMinutes){

        final long MINUTES_IN_HOUR = 60;
        final long MINUTES_IN_DAY = 24 * MINUTES_IN_HOUR;
        final long MINUTES_IN_WEEK = 7 * MINUTES_IN_DAY;
        final long MINUTES_IN_MONTH = 30 * MINUTES_IN_DAY;

        long months = totalMinutes / MINUTES_IN_MONTH;
        totalMinutes %= MINUTES_IN_MONTH;

        long weeks = totalMinutes / MINUTES_IN_WEEK;
        totalMinutes %= MINUTES_IN_WEEK;

        long days = totalMinutes / MINUTES_IN_DAY;
        totalMinutes %= MINUTES_IN_DAY;

        long hours = totalMinutes / MINUTES_IN_HOUR;
        totalMinutes %= MINUTES_IN_HOUR;

        long minutes = totalMinutes;

        StringBuilder stringBuilder = new StringBuilder();

        if (months > 0) {
            stringBuilder.append(monthString(months));
        }
        if (weeks > 0){
            stringBuilder.append(weekString(weeks));
        }

        if (days > 0){
            stringBuilder.append(dayString(days));
        }

        if (hours > 0){
            stringBuilder.append(hourString(hours));
        }

        if (minutes > 0){
            stringBuilder.append(minuteString(minutes));
        }

        return stringBuilder.toString();
    }

    private static String monthString(long month){
        if (month == 1){
            return "1 месяц ";
        }
        if (month > 1 && month < 5){
            return month + " месяца";
        }
        if (month >= 5 && month < 10){
            return month + " месяцев ";
        }

        return "null";
    }

    private static String weekString(long weeks){
        if (weeks == 1){
            return "1 неделя ";
        }
        if (weeks > 1 && weeks <= 4){
            return weeks + " недели";
        }
        return "null";
    }

    private static String dayString(long days){
        if (days == 1){
            return "1 день ";
        }
        if (days > 1 && days < 5){
            return days + " дня ";
        }
        if (days >= 5 && days <= 31){
            return days + "дней ";
        }
        return "null";
    }

    private static String hourString(long hours){
        if (hours == 1 || hours == 21){
            return hours + " час ";
        }
        if (hours > 1 && hours <= 4){
            return hours + " часа ";
        }
        if (hours > 4 && hours <= 20){
            return hours + " часов ";
        }
        if (hours > 20 && hours <=24){
            return hours + " часа ";
        }

        return "null";
    }

    private static String minuteString(long minutes){
        return minutes + " минут ";
    }
}
