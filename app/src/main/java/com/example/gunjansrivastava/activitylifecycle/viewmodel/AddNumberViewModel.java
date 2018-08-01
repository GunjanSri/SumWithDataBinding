package com.example.gunjansrivastava.activitylifecycle.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.gunjansrivastava.activitylifecycle.BR;

public class AddNumberViewModel extends BaseObservable{
    private String firstNumber;
    private String secondNumber;
    private String result;

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }
    private Integer carry =0;

    public void addNumbers(){
        final StringBuilder resultSum = new StringBuilder();
        if(firstNumber.length() > secondNumber.length()){
            swapString();
        }
        int firstNoLength = firstNumber.length() - 1;
        int secondNoLength = secondNumber.length() - 1;
        while(firstNoLength>=0){
            int firstNumberIndex = Integer.parseInt(Character.toString(firstNumber.charAt(firstNoLength)));
            int secondNumberIndex = Integer.parseInt(Character.toString(secondNumber.charAt(secondNoLength)));
            Integer indexSum  = firstNumberIndex + secondNumberIndex + carry;
            checkIfSumHasCarry(indexSum,resultSum);
            firstNoLength--;
            secondNoLength--;
        }
        while (secondNoLength >= 0) {
            int secondNumberIndex = Integer.parseInt(Character.toString(secondNumber.charAt(secondNoLength)));
            Integer indexSum = secondNumberIndex + carry;
            checkIfSumHasCarry(indexSum,resultSum);
            secondNoLength--;
        }
        setResult(resultSum.reverse().toString());
    }

    private void checkIfSumHasCarry(Integer indexSum,StringBuilder resultSum){
        if(indexSum > 9){
            carry = 1;
            indexSum = indexSum - 10;
        }else carry = 0;
        resultSum.append(indexSum.toString());
    }

    private void swapString(){
        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber.substring(0,firstNumber.length()-secondNumber.length());
        firstNumber = firstNumber.substring(secondNumber.length(),firstNumber.length());
    }
}
