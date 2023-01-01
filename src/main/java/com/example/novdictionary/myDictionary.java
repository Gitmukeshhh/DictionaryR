package com.example.novdictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class myDictionary extends Application {

       int yLine=10;
        TextField wordTextField;
    ListView<String> suggesedWordList;
        Button searchButton;
        Label meaningLabel;
        DicitionaryUsingHashMap dicitionaryUsingHashMap;

      Pane createContent(){
          Pane root=new Pane();
          root.setPrefSize(300,300);



          wordTextField =new TextField();
          wordTextField.setPromptText("Please enter a word");
          wordTextField.setTranslateY(yLine);
          wordTextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
              @Override
              public void handle(KeyEvent keyEvent) {
//                         System.out.print("Event raised");
//                         meaningLabel.setText(wordTextField.getText());
                           String word =wordTextField.getText();
                           if(word.isBlank()==false&&word.length()>=3){
                               String[] suggestion = dicitionaryUsingHashMap.getSuggestion(word);
                               suggesedWordList.getItems().clear();
                               suggesedWordList.getItems().addAll(suggestion);
                           }
              }
          });

          searchButton=new Button("search");
          searchButton.setTranslateY(yLine);
          searchButton.setTranslateX(200);


          meaningLabel=new Label("I am the meaning");
          meaningLabel.setTranslateY(yLine+30);

           dicitionaryUsingHashMap=new DicitionaryUsingHashMap();


          searchButton.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent actionEvent) {
                  String word =wordTextField.getText();
                  if(word.isBlank()){
                      meaningLabel.setText("Please enter a wored!");
                      meaningLabel.setTextFill(Color.RED);
                  }else{
                        meaningLabel.setText(dicitionaryUsingHashMap.findMeaning(word));
                        meaningLabel.setTextFill(Color.RED);
                  }
              }
          });

          suggesedWordList=new ListView<>();
          suggesedWordList.setTranslateY(yLine+70);
          String[]suggestedList={"smart","chief","hate","worship"};
          suggesedWordList.getItems().addAll(suggestedList);
          suggesedWordList.setOnMouseClicked(new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent mouseEvent) {
                  String selectedWord=suggesedWordList.getSelectionModel().getSelectedItem();
                  meaningLabel.setText(selectedWord);
              }
          });






                    root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggesedWordList);




          return root;
      }


    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(myDictionary.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("MYDICTIONARY");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}