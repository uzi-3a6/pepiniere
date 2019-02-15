/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import services.EvenementService;
import org.apache.commons.io.FileUtils;

       


/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AjouterEvenementFXMLController implements Initializable {

    @FXML
    private TextField nomEvenement;
    @FXML
    private TextField idCategorieEvenement;
    @FXML
    private TextField etat;
    @FXML
    private TextField nbPlace;
    @FXML
    private TextField nbStand;
    @FXML
    private TextField prix;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Button ajouter;
    @FXML
    private Button imagea;
    FileChooser fc = new FileChooser () ;
    File selectedFile ; 
    @FXML
    private TextField image;
    @FXML
    private ImageView images;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    
    
    
    
    @FXML
    private void ActionAjouter(ActionEvent event) throws IOException {
        String nomEvenementS =nomEvenement.getText();
        String idCategorieEvenementS=idCategorieEvenement.getText();
        LocalDate dateDebutS = dateDebut.getValue();
        LocalDate dateFinS = dateFin.getValue();
        String etatS=etat.getText();
        String nbPlaceS=nbPlace.getText();
        String nbStandS=nbStand.getText();
        String prixS=prix.getText();
        String imageS=image.getText();
        
            
        java.sql.Date datedeb = java.sql.Date.valueOf(dateDebutS);
        java.sql.Date datef = java.sql.Date.valueOf(dateFinS);
        Evenement e = new Evenement(nomEvenementS,idCategorieEvenementS,datedeb, datef, etatS,Integer.parseInt(nbPlaceS),Integer.parseInt(nbStandS),Integer.parseInt(nbStandS) ,imageS);
        
         services.EvenementService ev = new EvenementService() ; 
        ev.insererEvenement(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre evenement est ajouter  avec succeeees");
        alert.setHeaderText("Evenement ajouter");
       
        
        alert.showAndWait();
        nomEvenement.setText("");
        idCategorieEvenement.setText("");
        dateDebut.setValue(null);
        dateFin.setValue(null);
        etat.setText("");
        nbPlace.setText("");
        nbStand.setText("");
        prix.setText("");
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
