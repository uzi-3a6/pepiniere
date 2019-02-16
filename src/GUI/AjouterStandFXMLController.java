/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Stand;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import services.EvenementService;
import services.StandService;


/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AjouterStandFXMLController implements Initializable {

    @FXML
    private TextField numeroStand;
    @FXML
    private TextField idEvenement;
    @FXML
    private TextField idUser;
    @FXML
    private Button ajouter;
    @FXML
    private Button imagea;
    @FXML
    private TextField image;
    
    FileChooser fc = new FileChooser () ;
    File selectedFile ; 
    @FXML
    private ImageView images;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterAction(ActionEvent event) throws SQLException {
        
      String numeroStandS =numeroStand.getText();
        String idEvenementS=idEvenement.getText();
        String idUserS = idUser.getText();
        String imageS=image.getText();
        
            
      
        Stand s= new Stand(Integer.parseInt(numeroStandS ),Integer.parseInt(idEvenementS),Integer.parseInt(idUserS),imageS);
        
          StandService ss =new StandService();
        ss.insererStand(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre stand est ajouter  avec succeeees");
        alert.setHeaderText("Stand ajouter");
       
        
        alert.showAndWait();
        numeroStand.setText("");
        idEvenement.setText("");
        idUser.setText("");
        
        image.setText("");


        
        
        
    }
    
    @FXML
    private void ImageAction(ActionEvent event) throws FileNotFoundException, IOException {
        
        File dest=new File("C:\\wamp\\www\\Images");
        
        fc.setInitialDirectory(new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Gestion_evenement\\Images\\"));
        selectedFile = fc.showOpenDialog(null);
        FileUtils.copyFileToDirectory(selectedFile, dest);
        
        File newFile = new File("C:\\wamp64\\www\\Images\\"+selectedFile.getName());
       
        if (selectedFile!= null ) {
            String a;
            a=(selectedFile.getName());
            System.out.println(a);
            image.setText(a);
             File imageURL = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Gestion_evenement\\Images\\"+a);
    
       

        
          Image ima=  new Image(imageURL.toURI().toString());
        
        images.setImage(ima);
           
            
            
    }
    
}
}
