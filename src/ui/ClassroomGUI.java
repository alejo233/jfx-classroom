package ui;


import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {

	    private Classroom classroom;
	    
	    @FXML
	    private Pane pain1;
	    
	    @FXML
	    private Pane pain2;
	    
	    @FXML
	    private Pane pain3;
	    
	    @FXML
	    private Button btCreate;
	    

	    @FXML
	    private Button btSignPane;
	
	   @FXML
	    private TextField txtUsername;

	    @FXML
	    private TextField txtPassword;

	    @FXML
	    private TextField txtUserRegister;

	    @FXML
	    private TextField txtPassRegister;

	    @FXML
	    private TextField txtImageURL;

	    @FXML
	    private CheckBox cbSofwareE;
	    
	    @FXML
	    private ToggleGroup genderGoup;

	   
	    @FXML
	    private CheckBox cbTelematicE;

	    @FXML
	    private CheckBox cbIndustrialE;

	    @FXML
	    private DatePicker dateP;

	    @FXML
	    private ComboBox<String> btBrowser;

	    @FXML
	    private Button  loadSignInRegister;

	    @FXML
	    private Button loadCreateAccount;
	    
	    
	    @FXML
	    private Button btSignUp;
	    
	    
	    @FXML
	    private TableView<UserAccount> tableUser;

	    @FXML
	    private TableColumn<UserAccount, String> tbcUsername;

	    @FXML
	    private TableColumn<UserAccount, String> tbcGender;

	    @FXML
	    private TableColumn<UserAccount, String> tbcCareer;

	    @FXML
	    private TableColumn<UserAccount, String> tbcBirthday;

	    @FXML
	    private TableColumn<UserAccount, String> tbcBrowser;

	    @FXML
	    private Label lbUsername;

	    @FXML
	    private ImageView imgProfile;
	    
	 	public ClassroomGUI(Classroom c) {
		classroom =c;
	}
	    
	    public void initializeTableView() {
	    	ObservableList<UserAccount>userAccount;
	    	userAccount= FXCollections.observableArrayList(classroom.getUserAccount());
	    	
	    
	    	tbcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("Username"));
	    	tbcGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("gender"));
	    	tbcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("career"));
	    	tbcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));
	    	tbcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("browser"));
	    	tableUser.setItems(userAccount);
	    

	    	
	    }


	

	
	public void emptyFieldLogIn() {
		if(txtUsername.getText().isEmpty()|| txtPassword.getText().isEmpty()) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			  alert.setHeaderText("Some fields are incomplete");
			  alert.setTitle("Validation error");
			  alert.setContentText("You must fill in all fields");
			  alert.showAndWait();
			
		}
		
	}
	
	
	public void emptyFieldSignUp() {
		if(txtUserRegister.getText().isEmpty()|| txtPassRegister.getText().isEmpty()||txtImageURL.getText().isEmpty()) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			  alert.setHeaderText("Some fields are incomplete");
			  alert.setTitle("Validation error");
			  alert.setContentText("You must fill in all fields");
			  alert.showAndWait();
			
		}else {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		  alert.setTitle("Account Created");
		  alert.setContentText("The new account has been created");
		  alert.showAndWait();
		}
		
	}
	

	
	
	 @FXML
	 public void loadLogIn(ActionEvent event) throws IOException {
			 if(txtUsername.getText().isEmpty()==false && txtPassword.getText().isEmpty()==false  && classroom.getUserAccount().size()==0   ) {
				  Alert alert=new Alert(Alert.AlertType.ERROR);
				  alert.setHeaderText("User not found");
				  alert.setTitle("ERROR");
				  alert.setContentText("You must sign up");
				  alert.showAndWait();
				  
			  }else {
				  emptyFieldLogIn();
			  }

		 for(int i=0; i<classroom.getUserAccount().size();i++) {
			
			 if(txtUsername.getText().equals(classroom.getUserAccount().get(i).getUsername())&&txtPassword.getText().equals(classroom.getUserAccount().get(i).getPassword())) {
				 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-List.fxml"));
					
					fxmlLoader.setController(this);    	
					Parent root = fxmlLoader.load();
					pain1.getChildren().setAll(root);
				 
			 }else if (!txtUsername.getText().equals(classroom.getUserAccount().get(i).getUsername())||!txtPassword.getText().equals(classroom.getUserAccount().get(i).getPassword())) {
				 Alert alert=new Alert(Alert.AlertType.ERROR);
				  alert.setHeaderText("User incorrect");
				  alert.setTitle("ERROR");
				  alert.setContentText("Check your data");
				  alert.showAndWait();
			 }
		 }				 
		 }

	    

	    @FXML
	    public  void loadSignUp(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
			
			fxmlLoader.setController(this);    	
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			Stage primary= new Stage();
			primary.setScene(scene);
			primary.show();
			Stage stage=(Stage)this.btSignUp.getScene().getWindow();
			stage.close();
		    btBrowser.getItems().addAll("Opera", "Google Chrome", "Safari", "Thor","Edge", "Mozila Firefox");

	    }
	
	
	
	    @FXML
	    public void browseImage(ActionEvent event) {
	    	FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Buscar Imagen");

	        File rute = fileChooser.showOpenDialog(null);
	        
	        txtImageURL.setText(rute.getAbsolutePath());
	    

	   
	    }


	    
	    @FXML
	    public void loadCreateAccount(ActionEvent event) throws IOException {
	    	emptyFieldSignUp();
	    	
	    	String user= txtUserRegister.getText();
	    	String pass=txtPassRegister.getText();
	    	String imgUrl= txtImageURL.getText();
	    	String gender= "dddkakd";
	    System.out.println(gender);
	    	String career= "";
	    	if(cbIndustrialE.isSelected()) {
	    		career=cbIndustrialE.getText()+", ";
	    	} if(cbSofwareE.isSelected()) {
	    		career=cbSofwareE.getText()+", ";
	    	} if(cbTelematicE.isSelected()){
	    		career=cbTelematicE.getText()+", ";
	    	
	    	}
	    	
	    	String ld = ""+dateP.getValue();
			 System.out.println(ld);
			 String browser= btBrowser.getValue();
			 
			 classroom.addUserAccount(user, pass, imgUrl, gender, career, ld, browser);
			 if(txtPassRegister.getText().isEmpty()==false) {
			 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
				
				fxmlLoader.setController(this);    	
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				Stage primary= new Stage();
				primary.setScene(scene);
				primary.show();
				Stage stage=(Stage)this.btCreate.getScene().getWindow();
				stage.close();
			  initializeTableView();

			 }
			
	    }

	    @FXML
	    public void loadSignInRegister(ActionEvent event) throws IOException {
	      	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pain.fxml"));
			
	    			fxmlLoader.setController(this);    	
	    			Parent root = fxmlLoader.load();
	    			Scene scene = new Scene(root);
	    			Stage primary= new Stage();
	    			primary.setScene(scene);
	    			primary.show();
	    			Stage stage=(Stage)this.btSignPane.getScene().getWindow();
	    			stage.close();
	    }
	    
	    @FXML
	   public void loadLogOut(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pain.fxml"));
			
			fxmlLoader.setController(this);    	
			Parent addRegisterPane = fxmlLoader.load();
	    	
			pain3.getChildren().setAll(addRegisterPane);
	    }
	    
	

}
