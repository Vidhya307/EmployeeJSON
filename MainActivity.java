Parsing JSONArray
package com.example.jsonparsing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView output = findViewById(R.id.textView1);

        String strJson = "{ \"Employee\" :[" +
                "{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"}," +
                "{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";

        String data = "";

        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonRootObject.getJSONArray("Employee");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.getString("id"));
                String name = jsonObject.getString("name");
                float salary = Float.parseFloat(jsonObject.getString("salary"));

                data += "Node " + i + ":\n"
                        + "ID: " + id + "\n"
                        + "Name: " + name + "\n"
                        + "Salary: " + salary + "\n\n";
            }

            output.setText(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
