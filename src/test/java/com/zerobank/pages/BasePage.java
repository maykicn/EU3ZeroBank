package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.it.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public int[] dateList(String date){


        String [] listString=date.split("-");
        int [] list=new int[listString.length];
        for (int i=0;i< list.length;i++) {
            list[i]=Integer.parseInt(listString[i]);

        }
        return list;

    }

    public int year(int[] date){
        return date[0];
    }

    public int month(int[] date){
        return date[1];
    }


    public int day(int[] date){
        return date[2];
    }

    public boolean isBetween(String date, String from, String to) {

        Boolean flag=false;

        int yearFrom, monthFrom, dayFrom, yearTo, monthTo, dayTo, year, month, day;
        int[] dayList = dateList(date);
        int[] fromList = dateList(from);
        int[] toList = dateList(to);

        year = year(dayList);
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

    public String mostRecentDate() throws ParseException {





        return "BU KISIM EKSIK";













        /*int dummy=0;
        int flag;
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        int size=findTransactionsPage.tableRow.size();


        for(int i=1;i<=size;i++){

            WebElement dateColoumn= Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr["+i+"]/td[1]"));
            transactionDateList.add(dateColoumn.getText());
            System.out.println("transactionDateList.get(i-1) = " + transactionDateList.get(i - 1));
        }

        for (int i = 0; i < transactionDateList.size()-1; i++) {
             int first=year(dateList(transactionDateList.get(i)));
             int second=year(dateList(transactionDateList.get(i+1)));
             if(first>=second && first>=dummy){
                 dummy=first;
                 flag=i;
             }else if(second>=first && second>=dummy){
                 dummy=second;
                 flag=i;
             }

        }   */




    }


    public boolean isContain(String date){

        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        int size=findTransactionsPage.tableRow.size();
        ArrayList<String>transactionDateList=new ArrayList<>();
        boolean flag=false;

        int [] exludeDate=dateList(date);


        for(int i=1;i<=size;i++){

            WebElement dateColoumn= Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr["+i+"]/td[1]"));

            int[] tableDate=dateList(dateColoumn.getText());
                if(year(exludeDate)==year(tableDate) && month(exludeDate)==month(tableDate) && day(exludeDate)==day(tableDate)){
                    flag=true;
                    return flag;

                }

        }
        System.out.println("flag = " + flag);
        return flag;










    }





}
