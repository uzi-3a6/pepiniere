/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.ReservationEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.EvenementService;
import services.ReservationEvenementService;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ConsulterEvenementFXMLController implements Initializable {
public static ConsulterEvenementFXMLController cont;
    @FXML
    private TableView<Evenement> tableView;
    @FXML
    private TableColumn<Evenement, ?> nomEvenement;
    @FXML
    private TableColumn<Evenement, ?> Categorie;
    @FXML
    private TableColumn<Evenement, ?> DateDebut;
    @FXML
    private TableColumn<Evenement, ?> DateFin;
    @FXML
    private TableColumn<Evenement, ?> Etat;
    @FXML
    private TableColumn<Evenement, ?> nbPlace;
    @FXML
    private TableColumn<Evenement, ?> nbStand;
    @FXML
    private TableColumn<Evenement, ?> Prix;
    @FXML
    private TableColumn<Evenement, ?> Image;
    @FXML
    private TextField nbreserver;
    @FXML
    private TextField recherche;
    
    ObservableList<Evenement> listViewEvenement;
    List<Evenement> listEvenement;
    @FXML
    private Button reserverbutton;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        try {
            cont = this;
          
            AfficherDataEve();
            search();
            Verif();
            
            
            
             
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
    
         
       
         //
    }    
    
    private void setCellValueEvenement() throws SQLException {

        nomEvenement.setCellValueFactory(new PropertyValueFactory<>("nomEvenement"));

        Categorie.setCellValueFactory(new PropertyValueFactory<>("idCategorieEvenement"));

        DateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        DateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        Etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        nbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
        nbStand.setCellValueFactory(new PropertyValueFactory<>("nbStand"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        Image.setCellValueFactory(new PropertyValueFactory<>("image"));
    }
    
    
    public void AfficherDataEve() throws SQLException {
        EvenementService hs = new EvenementService();

        listEvenement = new ArrayList<>();

        listEvenement = hs.selectEvenement();

        listViewEvenement = FXCollections.observableArrayList(listEvenement);
        tableView.setItems(listViewEvenement);

        setCellValueEvenement();

    }
    
    public void Verif() throws SQLException 
    {ReservationEvenementService rr =new ReservationEvenementService();
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
        
        
        int indexa = tableView.getSelectionModel().getFocusedIndex();
        int evida = listEvenement.get(indexa).getIdEvenement();
        
           int test=  rr.verifReservationEvenement(evida,1);
           System.out.println(test);
           if (test==1)
           {
               reserverbutton.setDisable(true);
           }
           else
           {
               reserverbutton.setDisable(false);
           }
            }    
    });}
    
    public void search() {
        FilteredList<Evenement> filterdata = new FilteredList<>(listViewEvenement, e -> true);
        recherche.setOnKeyReleased(e -> {
            recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filterdata.setPredicate((Predicate<? super Evenement>) evenement -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    if (((evenement.getNomEvenement().contains(newValue)) || (evenement.getNomEvenement().toLowerCase().contains(newValue)))||((evenement.getEtat().contains(newValue)) || (evenement.getEtat().toLowerCase().contains(newValue)))) {
                        return true;
                    }
                    
                    return false;
                });
            });
            SortedList<Evenement> sorteddata = new SortedList<>(filterdata);
            sorteddata.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sorteddata);
        });
    }
    
    
    @FXML
    private void ReserverEvenement(ActionEvent event) throws SQLException, IOException{
        
        ReservationEvenementService res =new ReservationEvenementService();
        
        int index = tableView.getSelectionModel().getFocusedIndex();
        int evid = listEvenement.get(index).getIdEvenement();
        String nbreserverS=nbreserver.getText();
        
         java.sql.Date date = java.sql.Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
        
         
         ReservationEvenement re = new ReservationEvenement(evid,1,date,Integer.parseInt(nbreserverS));
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int test=res.insererReservationEvenement(re);
        if (test ==0)
        {
        alert.setTitle("Vos Places sont reserver avec succeeees");
        alert.setHeaderText("Reservation ajouter");
        }
        else if(test==1)
        {
        alert.setTitle("l'evenement est complet");
        alert.setHeaderText("l'evenement est complet");
        }
        else if (test==2)
        {
        alert.setTitle("nb place demandee est superieur au nombre diponible");
        alert.setHeaderText("nb place demandee est superieur au nombre diponible");
        }
        
        
        
       
        
        
       
       
        
        alert.showAndWait();
        nbreserver.setText("");
        
        
        
        
        
        
        
    }
    
    
}
