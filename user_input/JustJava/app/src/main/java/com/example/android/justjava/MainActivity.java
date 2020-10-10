/*
  IMPORTANT: Make sure you are using the correct package name.
  This example uses the package name:
  package com.example.android.justjava
  If you get an error when copying this code into Android studio, update it to match teh package name found
  in the project's AndroidManifest.xml file.
 */
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    /*public void submitOrder(View view) {
        //int numberOfCupOfCofee = 2;
        //display(numberOfCupOfCofee);
        displayMessage(numberOfCupOfCofee*5);
    }*/

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }
    /**
     * This method displays the given price on the screen.
     */
    /*private void displayMessage(int number) {
        String priceMessage = "Total: " + NumberFormat.getCurrencyInstance().format(number) + "\n" + "Thank you!";
        TextView textView = findViewById(R.id.order_summary_text_view);
        textView.setText(priceMessage);
    }*/

    public void increment(View view) {
        displayQuantity(++numberOfCupOfCofee);
        //displayPrice(numberOfCupOfCofee*5);
    }

    public void decrement(View view) {
        if (numberOfCupOfCofee == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        displayQuantity(--numberOfCupOfCofee);
    }
    /*public void decrement(View view) {
        displayQuantity(--numberOfCupOfCofee);
        //displayPrice(numberOfCupOfCofee*5);
    }*/

    public void submitOrder(View view) {
        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice();

        // Display the order summary on the screen
        String message = createOrderSummary(price, hasWhippedCream, hasChocolate);

        displayMessage(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order Summary");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return numberOfCupOfCofee * 5;
    }

    /**
     * Create summary of the order.
     *
     * @param price           of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate    is whether or not to add chocolate to the coffee
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: Lyla the Labyrinth";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + numberOfCupOfCofee;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}