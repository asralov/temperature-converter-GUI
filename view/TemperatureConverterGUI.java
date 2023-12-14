/**
 * Author: Abrorjon Asralov
 * Class: CSC 210 Fall 2023
 * Purpose: This is a program to convert F to C and C to F. By using JavaFX for GUI
 * user can interact and convert measurements
 */

package view;

import model.TemperatureConverter;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TemperatureConverterGUI extends Application {
	private TextField CTextField;
	private TextField FTextField;

	@Override
	public void start(Stage mainWindow) {
		mainWindow.setTitle("CtoF FtoC");

		// Creating a GridPane layout
		GridPane gridPane = new GridPane();

		// Setting the vertical and horizontal gaps between elements
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Creating labels
		Label CLabel = new Label("Celsius");
		Label FLabel = new Label("Fahrenheit");

		// Creating text fields
		CTextField = new TextField();
		FTextField = new TextField();

		// Setting translation for text fields to move them lower
		CTextField.setTranslateY(30);
		FTextField.setTranslateY(30);
		CLabel.setTranslateY(30);
		FLabel.setTranslateY(30);
		CTextField.setTranslateX(20);
		FTextField.setTranslateX(20);
		CLabel.setTranslateX(20);
		FLabel.setTranslateX(20);

		// Adding controls to the grid
		gridPane.add(CLabel, 0, 0);
		gridPane.add(CTextField, 1, 0);
		gridPane.add(FLabel, 0, 1);
		gridPane.add(FTextField, 1, 1);

		// Adding event handlers to text fields
		CTextField.setOnAction(e -> handleCelsiusInput());
		FTextField.setOnAction(e -> handleFahrenheitInput());

		// Adding the event handlers as users clears the field
		clearAsUserEnters(CTextField, FTextField);
		clearAsUserEnters(FTextField, CTextField);

		// Creating the window
		Scene window = new Scene(gridPane, 280, 110);
		mainWindow.setScene(window);

		// Showing the stage
		mainWindow.show();
	}

	private void handleCelsiusInput() {
		try {
			double C = Double.parseDouble(CTextField.getText());
			FTextField.setText(Double.toString(TemperatureConverter.CtoF(C)));
		} catch (NumberFormatException err) {
			FTextField.setText("Please enter a numeric value!");
		}
	}

	private void handleFahrenheitInput() {
		try {
			double F = Double.parseDouble(FTextField.getText());
			CTextField.setText(Double.toString(TemperatureConverter.FtoC(F)));
		} catch (NumberFormatException err) {
			CTextField.setText("Please enter a numeric value!");
		}
	}

	private void clearAsUserEnters(TextField sourceField, TextField targetField) {
		sourceField.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.isEmpty()) {
					targetField.clear();
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
