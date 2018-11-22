/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigfx;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ticu
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea txtDesc;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSecondName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtGender;
    @FXML
    private TextField txtFamilyStatus;
    @FXML
    private TextField txtKids;
    @FXML
    private ImageView imgImageProfile;
    @FXML
    private CheckBox chkNewsletter;
    @FXML
    private RadioButton rbtUnemploymentNo;
    @FXML
    private ToggleGroup unemployment;
    @FXML
    private RadioButton rbtUnemploymentYes;
    @FXML
    private Spinner nudCars;
    @FXML
    private ComboBox cboFootbal;
    @FXML
    private ListView lstInterests;
    @FXML
    private Button btnButton;
    @FXML
    private Label lblInvisible;
    @FXML
    private Button btnFakeData;
    public static List<User> userList = new ArrayList<User>();
    Image img1;
    Image img2;
    Image img3;
    Optional<ButtonType> result;
    Alert alert;
    @FXML
    private Button btnExit;
    TextInputDialog inputbox;
    List<Image> ImagesList;
    @FXML
    public ListView<User> lstClients;
    @FXML
    private Button btnViewClients;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inputbox
        inputbox = new TextInputDialog();
        inputbox.setTitle("Close program confirmation");
        inputbox.setHeaderText("Write Yes if you want to close the software");
        inputbox.setContentText("Answer:");
        //Info Alert
        JOptionPane.showMessageDialog(null, "Program will start.", "Status of program:", JOptionPane.INFORMATION_MESSAGE);
        //Alert
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        //Initialize images
        img1 = new Image("/images/1.jpg");
        img2 = new Image("/images/2.jpg");
        img3 = new Image("/images/3.jpg");

        ImagesList = new ArrayList<Image>();

        ImagesList.add(img1);
        ImagesList.add(img2);
        ImagesList.add(img3);

        nudCars.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1));
        //nudCars.getValue().toString()

        cboFootbal.getItems().addAll("Steaua", "Dinamo", "Rapid", "Cluj");
        //cboFootbal.getValue().toString()

        lstInterests.getItems().addAll("Sport", "Footbal", "Sex", "Movies", "Swimming", "Going Out");
        //lstInterests.getSelectionModel().getSelectedItem().toString() for 1 item selected
        lstInterests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //lstInterests.getSelectionModel().getSelectedItems() for multiple selections.

        //for (Object selectedItem : lstInterests.getSelectionModel().getSelectedItems()) {
        //             System.out.println(selectedItem);
        //}
    }

    @FXML
    private void mouse_clicked(MouseEvent event) {
        result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            String Radio = ((RadioButton) unemployment.getSelectedToggle()).getText();
            User t = new User(txtName.getText(), txtSecondName.getText(), Integer.valueOf(txtAge.getText()),
                    txtGender.getText(), txtFamilyStatus.getText(), txtKids.getText(),
                    txtDesc.getText(), imgImageProfile.getImage(), chkNewsletter.isSelected(), Radio,
                    (int) nudCars.getValue(), cboFootbal.getValue().toString(), lstInterests.getSelectionModel().getSelectedItems());
            userList.add(t);
            lstClients.getItems().add(t);
            lstClients.refresh();

        } else {
            System.out.println("Cancel was pressed.");

        }

    }

    @FXML
    private void fake_data(MouseEvent event) {
        txtName.setText("Ticu");
        txtSecondName.setText("Ionut");
        txtAge.setText("29");
        txtGender.setText("Male");
        txtFamilyStatus.setText("Married");
        txtKids.setText("1 Daughter");
        txtDesc.setText("I am a trust worthy person on which u can rely.");
        chkNewsletter.setSelected(true);
        rbtUnemploymentNo.setSelected(true);
        cboFootbal.getSelectionModel().select(0);
    }

    @FXML
    private void change_image(MouseEvent event) {
        Random iRandom = new Random();
        int r1 = iRandom.nextInt(3);
        if (r1 == 0) {
            imgImageProfile.setImage(ImagesList.get(0));
        } else if (r1 == 1) {
            imgImageProfile.setImage(ImagesList.get(1));
        } else {
            imgImageProfile.setImage(ImagesList.get(2));
        }

    }

    @FXML
    private void exit_software(MouseEvent event) {
        String exit = "";
        Optional<String> sResultaat = inputbox.showAndWait();
        sResultaat.ifPresent(sText -> {
            if (sText.toLowerCase().equals("yes")) {
                System.out.println("System closed.");
                System.exit(0);
            }
        });

    }

    private ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private User getUserByName(String name) {
        for (User u : userList) {
            if (u.name.toLowerCase().equals(name.toLowerCase())) {
                return u;
            }
        }
        return null;
    }

    @FXML
    private void view_clients(MouseEvent event) {
        User CurrentUser = lstClients.getSelectionModel().getSelectedItem();

        String InfoClient = "Nume: " + CurrentUser.name + "\n"
                + "Prenume: " + CurrentUser.secondname + "\n"
                + "Varsta: " + CurrentUser.age + "\n"
                + "Gender: " + CurrentUser.gender + "\n"
                + "Status Familial: " + CurrentUser.family_status + "\n"
                + "Copii: " + CurrentUser.kids + "\n"
                + "Description: " + CurrentUser.desc + "\n"
                + "Image: " + CurrentUser.img + "\n"
                + "Newsletter: " + CurrentUser.newsletter + "\n"
                + "Unemployed:" + CurrentUser.unemployment + "\n"
                + "Cars: " + CurrentUser.nrcars + "\n"
                + "Favorite Team: " + CurrentUser.favteam + "\n"
                + "Interests: " + CurrentUser.interests.toString() + "\n"
                + "";

//        https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
//        ImageIcon imageIcon = new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon icon = createImageIcon("/images/jaa.jpg", "a pretty but meaningless splat");
        icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JOptionPane.showMessageDialog(null, InfoClient, "Status of program:", JOptionPane.INFORMATION_MESSAGE, icon);

//        this works if img3 would be declared as kavax.swing.Image
//        img3 = img3.getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT);
//        JOptionPane.showMessageDialog(null, InfoClient, "Status of program:", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img3));
    }

}
