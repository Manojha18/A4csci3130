package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    /**
     * @param name,email,business_num,prim_business,address,province
     * declaring string variable for business to business transaction
     */

    public  String uid;
    public  String name;
    public  String email;
    public  String business_num;
    public  String prim_business;
    public  String address;
    public  String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String email, String business_num, String prim_business, String address, String province){
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.business_num = business_num;
        this.prim_business = prim_business;
        this.address = address;
        this.province = province;

    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        result.put("business_num", business_num);
        result.put("prim_business", prim_business);
        result.put("address", address);
        result.put("province", province);

        return result;
    }
}
