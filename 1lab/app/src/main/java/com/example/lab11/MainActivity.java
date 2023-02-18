package com.example.lab11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Boolean isNew = true;
    EditText editText;
    String oldNumber;
    String operator=" ";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void clickNumber(View view) {
        if (isNew)
            editText.setText("");
        isNew=false;
        String number = editText.getText().toString();
        if(number == "Error") {
            number = "0";
        }
        switch (view.getId()){
            case R.id.bu1:

                if(zeroIsFirst(number) && number.length()==1){
                    number="1";
                } else{
                    number =number+"1" ;
                }

                break;
            case R.id.bu2:
                if(zeroIsFirst(number) && number.length()==1){
                    number="2";
                } else{
                    number =number+"2" ;
                }

                break;
            case R.id.bu3:
                if(zeroIsFirst(number) && number.length()==1){
                    number="3";
                } else{
                    number =number+"3" ;
                }

                break;
            case R.id.bu4:
                if(zeroIsFirst(number) && number.length()==1){
                    number="4";
                } else{
                    number =number+"4" ;
                }

                break;
            case R.id.bu5:
                if(zeroIsFirst(number) && number.length()==1){
                    number="5";
                } else{
                    number =number+"5" ;
                }

                break;
            case R.id.bu6:
                if(zeroIsFirst(number) && number.length()==1){
                    number="6";
                } else{
                    number =number+"6" ;
                }

                break;
            case R.id.bu7:
                if(zeroIsFirst(number) && number.length()==1){
                    number="7";
                } else{
                    number =number+"7" ;
                }

                break;
            case R.id.bu8:
                if(zeroIsFirst(number) && number.length()==1){
                    number="8";
                } else{
                    number =number+"8" ;
                }

                break;
            case R.id.bu9:
                if(zeroIsFirst(number) && number.length()==1){
                    number="9";
                } else{
                    number =number+"9" ;
                }

                break;
            case R.id.bu0:
                if(zeroIsFirst(number) && number.length()==1){
                    number ="0" ;
            }else {
                    number =number+"0" ;
                }

            break;

            case R.id.buDot:
                if(dotIsPresent(number))
                {

                }
                else
                {
                    if(zeroIsFirst(number)){
                        number ="0.";
                    }
                    else {
                        number =number+".";
                    }

                }
                break;


            case R.id.buPlusMinus:
                if(numberIsZero(number)){
                    number = "0";
                }else{
                    if(MinusIsPresent(number))
                    {
                        number= number.substring(1);
                    }
                    else
                    {
                        number ="-"+ number ;
                    }
                }

                break;




        }

        editText.setText(number);
    }

    private boolean zeroIsFirst(String number) {
        if(number.equals("")){
            return true;
        }
        if(number.charAt(0) == '0'){
            return true;
        }else {
            return false;
        }
    }


    private boolean numberIsZero(String number) {
        if(number.equals("0") || number.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public void operation(View view) {
        isNew= true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.buMinus: operator= "-" ; break;
            case R.id.buPlus: operator ="+"; break;
            case R.id.buDivide:  operator ="/"; break;
            case R.id.buMultiply:  operator ="*"; break;
        }
    }

    public void clickRes(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        //String resNumber;
        switch (operator){
            case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber) ;

                editText.setText(result+"");break;
            case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);

                editText.setText(result+""); break;
            case "*": result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) ;

                editText.setText(result+""); break;
            case "/":
             if(Double.parseDouble(newNumber) == 0)
             {
                 editText.setText("Error");
             }
             else
             {
                 result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);

                 editText.setText(result+"");

             }
                break;
            case " ":
                editText.setText("0");
                break;
        }
    }

    public void clickAC(View view) {
        editText.setText("0");
        isNew = true;
    }

    public boolean dotIsPresent(String number){

        if (number.indexOf(".")==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean MinusIsPresent(String number){

        if (number.charAt(0) == '-')
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}