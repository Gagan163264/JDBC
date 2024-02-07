package com.blueyonder.setup;

public class __setup {
    public static void main(String[] args) {
        __TableOperations tb = new __TableOperations();
        __AuthData ad = new __AuthData();
        tb.init_data();
        ad.init_auth();
    }
}
