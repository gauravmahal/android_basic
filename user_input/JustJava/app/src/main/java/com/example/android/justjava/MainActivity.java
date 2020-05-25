/*
  IMPORTANT: Make sure you are using the correct package name.
  This example uses the package name:
  package com.example.android.justjava
  If you get an error when copying this code into Android studio, update it to match teh package name found
  in the project's AndroidManifest.xml file.
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCupOfCofee = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //int numberOfCupOfCofee = 2;
        display(numberOfCupOfCofee);
        displayMessage(numberOfCupOfCofee*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(int number) {
        String priceMessage = "Total: " + NumberFormat.getCurrencyInstance().format(number) + "\n";
        priceMessage += "Thank you!";
        TextView textView = findViewById(R.id.price_text_view);
        textView.setText(priceMessage);
    }

    public void increment(View view) {
        display(++numberOfCupOfCofee);
        //displayPrice(numberOfCupOfCofee*5);
    }

    public void decrement(View view) {
        display(--numberOfCupOfCofee);
        //displayPrice(numberOfCupOfCofee*5);
    }
}