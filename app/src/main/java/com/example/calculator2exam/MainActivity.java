package com.example.calculator2exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private double current_number=0.0;
    private double current_memory=0.0;
    private String current_operation;
    private boolean decimals_pressed = false;
    private boolean firstDecimal = true;
    private boolean equalJustPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }
    public void doButton_1(View view){
        setCurrentNumber("1");
    }
    public void doButton_2(View view){
        setCurrentNumber("2");
    }
    public void doButton_3(View view){
        setCurrentNumber("3");
    }
    public void doButton_4(View view){
        setCurrentNumber("4");
    }
    public void doButton_5(View view){
        setCurrentNumber("5");
    }
    public void doButton_6(View view){
        setCurrentNumber("6");
    }
    public void doButton_7(View view){
        setCurrentNumber("7");
    }
    public void doButton_8(View view){
        setCurrentNumber("8");
    }
    public void doButton_9(View view){
        setCurrentNumber("9");
    }
    public void doButton_0(View view){
        setCurrentNumber("0");
    }
    public void doButton_div(View view){
        resetDecimals();
        equalJustPressed=false;
        saveToMemory();
        current_operation="div";
    }
    public void doButton_x(View view){
        resetDecimals();
        equalJustPressed=false;
        saveToMemory();
        current_operation="x";
    }
    public void doButton_minus(View view){
        resetDecimals();
        equalJustPressed=false;
        saveToMemory();
        current_operation="minus";
    }
    public void doButton_plus(View view){
        if(equalJustPressed==false){
            current_number=current_memory+current_number;
            String resultString = String.valueOf(current_number);
            textView.setText(resultString);

        }
        resetDecimals();
        equalJustPressed=false;
        saveToMemory();
        current_operation="plus";
    }
    public void doButton_dot(View view){
        decimals_pressed=true;
    }
    public void doButton_c(View view){
        resetDecimals();
        equalJustPressed=false;
        current_number=0.0;
        current_memory=0.0;
        textView.setText("0.0");
    }
    public void doButton_equal(View view){
        resetDecimals();
        equalJustPressed=true;
        Double result = 0.0;
        switch(current_operation){
            case "plus":
                result = current_memory+current_number;
                //this current_memory set to 0.0 is what makes able to do an operation after another and see its result without pressing equal
                current_memory=0.0;
                break;
            case "minus":
                result = current_memory-current_number;
                break;
            case "div":
                result = current_memory/current_number;
                break;
            case "x":
                result = current_memory*current_number;
                break;
                default:
                    break;
        }
        current_number = result;
        String resultString = String.valueOf(current_number);
        textView.setText(resultString);
    }
    private void setCurrentNumber(String num){
        if(equalJustPressed==true){
            current_number=0.0;
            equalJustPressed=false;
        }
        String combined="";
        if(current_number==0.0){
            combined = num+".0";
            current_number = Double.valueOf(combined);
        }else{
            if(decimals_pressed==false){
                int numberNoDecimal = (int) current_number;
                combined = String.valueOf(numberNoDecimal)+num+".0";
                current_number = Double.valueOf(combined);
            }else{
                if(firstDecimal==true){
                    int numberNoDecimal = (int) current_number;
                    combined = String.valueOf(numberNoDecimal)+"."+num;
                    current_number = Double.valueOf(combined);
                    firstDecimal=false;
                }else{
                    combined = current_number+num;
                    current_number = Double.valueOf(combined);
                }

            }

        }

        textView.setText(combined);
    }
    private void saveToMemory(){
        current_memory=current_number;
        current_number=0.0;
    }
    private void resetDecimals(){
        decimals_pressed=false;
        firstDecimal=true;
    }
}
