package com.zerobank.pages;

public class BasePage {

    public int[] dateList(String date){


        String [] listString=date.split("-");
        int [] list=new int[listString.length];
        for (int i=0;i< list.length;i++) {
            list[i]=Integer.parseInt(listString[i]);

        }
        return list;

    }

    public boolean isBetween(String date, String from, String to) {

        Boolean flag=false;

        int yearFrom, monthFrom, dayFrom, yearTo, monthTo, dayTo, year, month, day;
        int[] dayList = dateList(date);
        int[] fromList = dateList(from);
        int[] toList = dateList(to);

        year = dayList[0];
        month = dayList[1];
        day = dayList[2];

        yearFrom = fromList[0];
        monthFrom = fromList[1];
        dayFrom = fromList[2];

        yearTo = toList[0];
        monthTo = toList[1];
        dayTo = toList[2];

        if (yearFrom <= year && year <= yearTo) {

            if (monthFrom <= month && month <= monthTo) {

                if (dayFrom <= day && day <= dayTo) {
                    flag=true;
                }
            }
        }

    return flag;
    }


}
