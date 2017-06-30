package com.angelo.locateme.services;

import com.angelo.locateme.model.Devslopes;

import java.util.ArrayList;

/**
 * Created by crumali on 6/28/2017.
 */

public class DataService {
    private static final DataService instance = new DataService();

    public static DataService getInstance() {
        return instance;
    }

    private DataService() {
    }

    public ArrayList<Devslopes>getLocationWithinMiles(int zipcode){
        //pretending we're downloading data from the server

        ArrayList<Devslopes>list=new ArrayList<>();
        list.add(new Devslopes(14.561103,121.026984,"Pacific Star","Pacific Star Building, Makati Avenue, Makati, 1200 Metro Manila","slo"));
        list.add(new Devslopes(14.560380, 121.026005,"Embassy of Argentina in Philippines","104, 8th Floor Liberty Center, H.V. De La Costa Street, Salcedo Village, Makati, 1227 Metro Manila","slo"));
        list.add(new Devslopes(14.560112, 121.026979,"BDO Corporate Center","BDO Corporate Center, 7899 Makati Avenue, Makati City, Makati, Metro Manila","slo"));
        list.add(new Devslopes(14.561658, 121.025702,"Legal Department - Pag-IBIG Fund","40th Floor, Petron Mega Plaza, 358 Sen. Gil J. Puyat Ave, Makati, Metro Manila","slo"));
        list.add(new Devslopes(14.561591, 121.024964,"The Church Of Jesus Christ Of Latter-Day Saints ","Buendia Ave Ext, Makati, Metro Manila","slo"));

        return list;
    }

}
