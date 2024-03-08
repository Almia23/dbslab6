package com.javaguides.javafx.registration;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class RegisterController {
    
    @FXML
    private TextField IDField;
    
    @FXML
    private TextField fullNameField;
    
    @FXML
    private PasswordField buildingField;
    
    @FXML
    private PasswordField budgetField;
    
    @FXML
    private Button submitButton; 	
    
    @FXML
    public void register(ActionEvent event) throws SQLException{
    
    	Window owner = submitButton.getScene().getWindow();
    	
    	System.out.println(IDField.getText());
    	System.out.println(fullNameField.getText());
    	System.out.println(buildingField.getText());
    	System.out.println(budgetField.getText());
    	
    	if(IDField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your ID");
            return;
        }
    	
    	if(fullNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your name");
            return;
        }
    	
    	if(buildingField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your building");
            return;
        }
        if(budgetField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a budget");
            return;
        }
        
        String id = IDField.getText();
    	String fullName = fullNameField.getText();
    	String building = buildingField.getText();
    	String budget = budgetField.getText();
    	
    	JdbcDao jdbcDao = new JdbcDao();
    	jdbcDao.insertRecord(id, fullName, building, budget);
    	
    	showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", 
                "Welcome " + fullNameField.getText());
    }
    
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
