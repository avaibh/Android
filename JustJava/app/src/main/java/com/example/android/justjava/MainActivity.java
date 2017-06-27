package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity += 1;
        } else {
            Toast.makeText(this, "You cannot have more than 100 cups of coffee", Toast.LENGTH_SHORT).show();
            quantity = 100;
        }
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            display(quantity);
        } else {
            Toast.makeText(this, "You cannot have less than 1 cup of coffee", Toast.LENGTH_SHORT).show();
            quantity = 1;
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText nameEditText = (EditText) findViewById(R.id.customer_name);
        String customerName = nameEditText.getText().toString();

        int price = 5;
        if (hasWhippedCream == true) {
            price += 1;
        }
        if (hasChocolate == true) {
            price += 2;
        }
        price *= quantity;

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, customerName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for" + customerName);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Log.v("MainActivity", priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    private String createOrderSummary(int priceOfOrder, boolean addWhippedCream, boolean addChocolate, String custName) {
        String priceMessage;

        priceMessage =  getString(R.string.name) +": " + custName + "\n"+ getString(R.string.whipped_cream) +"? "  + addWhippedCream + "\n"+ getString(R.string.chocolate) +"? " + addChocolate + "\n"+ getString(R.string.quantity)+ ": " + quantity + "\n" + getString(R.string.total)+": $ " + priceOfOrder + "\n" + getString(R.string.thank_you);
        return priceMessage;
    }
}
