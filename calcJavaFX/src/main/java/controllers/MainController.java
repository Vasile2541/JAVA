package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField displayTextField;

    @FXML
    private Button div;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private TextArea historyTextArea;

    @FXML
    private Button min;

    @FXML
    private Button module;

    @FXML
    private Button mult;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button plus;

    @FXML
    private Button point;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;


    Float number1 = 0f;
    Float number2 = 0f;
    Float result  = 0f;
    Integer operation = -1;
    String operationSign;
    Boolean checkForDot = true;
    Boolean zeroToNinePressedFirst    = false;
    Boolean secondTimePressedAnyOperation = false;

    @FXML
    void button(ActionEvent event) {
        if( event.getSource() == one){
            displayTextField.setText( displayTextField.getText() + '1' );
        }else if( event.getSource() == two){
            displayTextField.setText( displayTextField.getText() + '2' );
        }else if( event.getSource() == three){
            displayTextField.setText( displayTextField.getText() + '3' );
        }else if( event.getSource() == four){
            displayTextField.setText( displayTextField.getText() + '4' );
        }else if( event.getSource() == five){
            displayTextField.setText( displayTextField.getText() + '5' );
        }else if( event.getSource() == six){
            displayTextField.setText( displayTextField.getText() + '6');
        }else if( event.getSource() == seven){
            displayTextField.setText( displayTextField.getText() + '7' );
        }else if( event.getSource() == eight){
            displayTextField.setText( displayTextField.getText() + '8' );
        }else if( event.getSource() == nine){
            displayTextField.setText( displayTextField.getText() + '9' );
        }else if( event.getSource() == zero){
            displayTextField.setText( displayTextField.getText() + '0' );
        }else if( event.getSource() == point){
            if(checkForDot){
                displayTextField.setText( displayTextField.getText() + "." );
                checkForDot = false;
            }
        }
        zeroToNinePressedFirst = true;
    }


    @FXML
    void equals(ActionEvent event) {

        if(zeroToNinePressedFirst) {
            number1 = Float.parseFloat(displayTextField.getText());
            historyTextArea.setText( historyTextArea.getText() + displayTextField.getText() );
            zeroToNinePressedFirst = false;
            checkForDot = true;

            if(secondTimePressedAnyOperation){
                switch (operation) {
                    case 1:
                        result = result / number1;
                        operation = -1;
                        break;
                    case 2:
                        result = result * number1;
                        operation = -1;
                        break;
                    case 3:
                        result = result- number1;
                        operation = -1;
                        break;
                    case 4:
                        result = result + number1;
                        operation = -1;
                        break;
                    default:
                }
                historyTextArea.setText(historyTextArea.getText() +  "\n" + String.format("%.02f", result) + "\n");

            }

            if(!secondTimePressedAnyOperation){
                result = number1;
            }

//            historyTextArea.setText(historyTextArea.getText() +"\n"+ String.format("%.02f", result) + "\n");


            if(  event.getSource() == equal ){
                historyTextArea.setText(  "\n"+"End result: \n"+ String.format("%.02f", result) + "\n ");//historyTextArea.getText() +"\n"+
                displayTextField.setText("");
                secondTimePressedAnyOperation=false;


            }else{
                if (       event.getSource() == div)  {
                    operationSign = " / ";
                    operation = 1;
                } else if (event.getSource() == mult) {
                    operationSign = " * ";
                    operation = 2;
                } else if (event.getSource() == min)  {
                    operationSign = " - ";
                    operation = 3;
                } else if (event.getSource() == plus) {
                    operationSign = " + ";
                    operation = 4;
                }

                secondTimePressedAnyOperation = true;
                historyTextArea.setText(historyTextArea.getText() + operationSign );

                displayTextField.setText("");
            }

        }
    }


    @FXML
    void clear(ActionEvent event) {
        historyTextArea.setText("");
        displayTextField.setText("");
        secondTimePressedAnyOperation = false;
    }
}
