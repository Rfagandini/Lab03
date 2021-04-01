
package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary model;
	ObservableList<String> Languages = FXCollections.observableArrayList("English","Italian");
	
	public void setModel(Dictionary model){
		
		this.model=model;
	
	}
	
	@FXML
	private void initialize(URL url, ResourceBundle rb) {
		
	}
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea AreaofText;

    @FXML
    private TextArea AreaofError;

    @FXML
    private ChoiceBox<String> LangOptions;
    
    @FXML
    private Label TimeLabel;

    @FXML
    private Label ErrorLabel;

    @FXML
    void CheckAction(ActionEvent event) throws IOException {
    	
    	TimeLabel.setDisable(false);
        ErrorLabel.setDisable(false);
        
    	long start = System.currentTimeMillis();
    	
    	String s = LangOptions.getSelectionModel().getSelectedItem();
    	String d = AreaofText.getText();
    	model.loadDictionaryMech(s);
    	model.VerifyWords(d);
    	AreaofError.setText(model.loadwrongwords());
    	ErrorLabel.setText("There were "+model.Errorsfound()+" errors found");
    	
    	long finish = System.currentTimeMillis();
    	long timeElapsed = finish - start;
    	
    	TimeLabel.setText("The software required "+timeElapsed+" milliseconds");
    	
    	
    }

    @FXML
    void ClearAction(ActionEvent event) {
    	
    	TimeLabel.setText("");
        ErrorLabel.setText("");
    	
    	AreaofText.setText("");
    	AreaofError.setText("");
    }

    @FXML
    void initialize() {
    	
        assert AreaofText != null : "fx:id=\"AreaofText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert AreaofError != null : "fx:id=\"AreaofError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert LangOptions != null : "fx:id=\"LangOptions\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TimeLabel != null : "fx:id=\"TimeLabel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ErrorLabel != null : "fx:id=\"ErrorLabel\" was not injected: check your FXML file 'Scene.fxml'.";
        LangOptions.setItems(Languages);
        TimeLabel.setDisable(true);
        ErrorLabel.setDisable(true);
    }
}



