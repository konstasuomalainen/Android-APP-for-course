package com.example.hellojava;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class YTJActivity extends AppCompatActivity {

    RequestQueue requestQueue;

    String results;

    String url;

    private ArrayList<Item> ItemList;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ytjactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            url = "https://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=100&resultsFrom=0&name=xxxx&companyRegistrationFrom=1960-02-28";







            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                return null;
            }

            String value1 = extras.getString("Value1");
            if (value1 != null) {

                url = url.replaceFirst("xxxx", value1);
                Log.d("error", "onCreate: " + url);
                APICall();

            }




            return insets;


        });
    }




    private void APICall()
    {
        requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {

                        ItemList = new ArrayList<>();



                        try {
                            JSONArray resultsArray = response.getJSONArray("results");
                            for (int i = 0; i < resultsArray.length(); i++) {
                                JSONObject result = resultsArray.getJSONObject(i);
                                Item item = new Item();
                                item.setName(result.getString("name"));
                                item.setId(result.getString("businessId"));
                                item.setCompanyForm(result.getString("companyForm"));
                                item.setRegistrationDate(result.getString("registrationDate"));

                                ItemList.add(item);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }

                });



        requestQueue.add(jsonObjectRequest);
        setupView();




    }

    private void setupView() {

    }

}