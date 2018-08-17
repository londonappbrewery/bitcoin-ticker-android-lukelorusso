package com.londonappbrewery.bitcointicker.controller;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.londonappbrewery.bitcointicker.R;
import com.londonappbrewery.bitcointicker.model.Ticker;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    // Constants:
    private static final String BASE_URL = "https://apiv2.bitcoinaverage.com/indices/global/ticker/BTC%s";

    // Member Variables:
    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceTextView = findViewById(R.id.priceLabel);
        Spinner spinner = findViewById(R.id.currency_spinner);

        // I prefer it white!
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        // Create an ArrayAdapter using the String array and a spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String currencyCode = "" + parent.getItemAtPosition(position);
                Log.d("Currency", currencyCode);
                makeQuery(currencyCode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Currency", "Nothing selected");
            }
        });

    }

    private void makeQuery(String currencyCode) {
        mPriceTextView.setVisibility(View.INVISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
        String url = String.format(BASE_URL, currencyCode);
        client.get(url, null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                Ticker ticker = Ticker.fromJson(response);
                mPriceTextView.setText(
                        ticker != null
                                ? String.valueOf(ticker.getAsk())
                                : getString(R.string.label_error_text)
                );
                mPriceTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("Network", "Request fail! Status code: " + statusCode);
                Log.e("Network", e.toString());
                Toast.makeText(MainActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
                mPriceTextView.setText(getString(R.string.label_error_text));
                mPriceTextView.setVisibility(View.VISIBLE);
            }
        });


    }


}
