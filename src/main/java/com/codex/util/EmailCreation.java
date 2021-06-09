package com.codex.util;

import com.codex.entity.Item;

import java.util.List;

public class EmailCreation {

    private static EmailCreation instance;
    private EmailCreation(){
    }

    public static EmailCreation getInstance() {
        if (instance == null){
            instance = new EmailCreation();
        }
        return instance;
    }


    private static final String THANKS = "THANKS FOR PAY";
    private static final String WARN = "WAS UPDATE ITEM IN YOUR BASKET";
    private static final String ENTER = "\n";
    private static final String WAS = "Was";
    private static final String BECAME = "Became";

    public static String getTHANKS() {
        return THANKS;
    }

    public static String getWARN() {
        return WARN;
    }

    public String payEmailMessage(List<Item> items) {
        StringBuilder stringBuffer = new StringBuilder(THANKS);
        stringBuffer.append(ENTER);
        for (Item item : items
        ) {
            stringBuffer.append(item.toString());
            stringBuffer.append(ENTER);
        }
        return stringBuffer.toString();
    }

    public String updateEmailMessage(Item oldItem, Item newItem) {
        return WARN + ENTER +
                WAS +
                ENTER +
                oldItem.toString() +
                ENTER +
                BECAME +
                ENTER +
                newItem.toString();
    }
}
