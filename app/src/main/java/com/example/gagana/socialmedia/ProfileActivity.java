package com.example.gagana.socialmedia;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.support.v4.view.ViewCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;

import java.text.DateFormat;
import java.util.Calendar;
import android.widget.Toast;
import android.widget.EditText;
import java.util.GregorianCalendar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button dobuser,update;
    private TextView textdob;
    private EditText fname,lname,phone,address,city,sex,dob;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textdob=(TextView)findViewById(R.id.txtdob);
        dobuser=(Button)findViewById(R.id.DOBbtn);
        update=(Button)findViewById(R.id.Updatebtn);
        fname=(EditText)findViewById(R.id.txtfname);
        lname=(EditText)findViewById(R.id.txtlname);
        phone=(EditText)findViewById(R.id.txtphone);
        address=(EditText)findViewById(R.id.txtaddress);
        city=(EditText)findViewById(R.id.txtCity);

    }

    public void setDate(View view)
    {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }
    public  void setDate(final Calendar calendar)
    {
        final DateFormat dateFormat =DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.txtdob)).setText(dateFormat.format(calendar.getTime()));
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal=new GregorianCalendar(year,month,day);
        setDate(cal);
    }

    public static class DatePickerFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            final  Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)
                    getActivity(), year,month,day);

        }

    }
}
