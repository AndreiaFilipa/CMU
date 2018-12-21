package projeto.estgf.ipp.pt.projeto;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import APIControllers.ControladoresAPI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button temp = (Button) findViewById(R.id.buttonVoo);
        Button temp1 =(Button)findViewById(R.id.buttonVooHotel);
        Button temp2 =(Button) findViewById(R.id.buttonHotel);

        temp.setOnClickListener(this);
        temp1.setOnClickListener(this);
        temp2.setOnClickListener(this);

        ControladoresAPI.x();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonVoo){
            Intent voo = new Intent(this,Main2Activity.class);
            startActivity(voo);
        }else if (v.getId()==R.id.buttonHotel){
            Intent hotel = new Intent(this,HotelActivity.class);
            startActivity(hotel);
        }else if(v.getId()==R.id.buttonVooHotel){
            Intent vooHotel = new Intent(this,VooHotelActivity.class);
            startActivity(vooHotel);
        }
    }
}
