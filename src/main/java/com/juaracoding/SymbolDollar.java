package com.juaracoding;

public class SymbolDollar {
    public static void main(String[] args) {
        String price = "$29.99"; //hasil dari getText
        String priceEdit = price.replace("$", "" );
        //ubah ke double
        double priceDouble = Double.parseDouble(priceEdit);
        System.out.println(price);
        System.out.println(priceEdit);
        System.out.println(priceDouble+1); // untuk memastikan ketika ditambah 1
    }
}
