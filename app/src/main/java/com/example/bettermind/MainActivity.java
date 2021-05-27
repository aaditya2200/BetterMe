package com.example.bettermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void establishConnectionWithDatabase() {
        String connection = "jdbc:postgresql://aaditya:admin/localhost:5432/bettermind";
        try {
            Connection conn = DriverManager.getConnection(connection);
            System.out.println("Connection established!");
            Statement st = conn.createStatement();
            String queryString = "create table if not exists user_info as"
                    .concat("\n")
                    .concat("(id serial primary key,")
                    .concat("\n")
                    .concat("nickname text not null,")
                    .concat("\n")
                    .concat("email_id text not null,")
                    .concat("\n")
                    .concat("p_type text not null, ")
                    .concat("\n")
                    .concat("gender text not null);");
            ResultSet rs = st.executeQuery(queryString);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    class user_info {
        private int id;
        private String nickname;
        private String email_id;
        private String ptype;
        private int age;
    }
}