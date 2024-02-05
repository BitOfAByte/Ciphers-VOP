package me.tjens23.vopcrypto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.security.NoSuchAlgorithmException;

public class HelloController {
    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private TextField decrypted_msg;

    @FXML
    private Spinner<Integer> rotFactor;

    @FXML
    private TextField encrypted_msg;


    @FXML
    private TextField MsgToEncrypt;


    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 26, 0);
        rotFactor.setValueFactory(valueFactory);
    }

    @FXML
    public void onDecryptButtonClick(ActionEvent event) {
        Toggle selectedToggle = toggleGroup.getSelectedToggle();
        int selectedRotFactor = rotFactor.getValue();
        if (selectedToggle != null) {
            RadioButton selectedRadioButton = (RadioButton) selectedToggle;
            switch (selectedRadioButton.getText()) {
                case "Caesar":
                    CaesarCipher cipher = new CaesarCipher(selectedRotFactor);
                    String decryptedText = cipher.decrypt(encrypted_msg.getText());
                    decrypted_msg.setText(decryptedText);
                    break;
                case "AtbashCipher":
                    AtbashCipher atbashCipher = new AtbashCipher();
                    String decryptedTextAtbash = atbashCipher.decrypt(encrypted_msg.getText());
                    decrypted_msg.setText(decryptedTextAtbash);
                    break;
                default:
                    System.out.println("Unknown cipher selected ");
                    break;
            }
        }
    }


    @FXML
    public void onEncryptButtonClick(ActionEvent event) {
        Toggle selectedToggle = toggleGroup.getSelectedToggle();
        if (selectedToggle != null) {
            RadioButton selectedRadioButton = (RadioButton) selectedToggle;
            switch (selectedRadioButton.getText()) {
                case "Caesar":
                    CaesarCipher caesarCipher = new CaesarCipher(rotFactor.getValue());
                    String caesarEncryptedText = caesarCipher.encrypt(MsgToEncrypt.getText());
                    encrypted_msg.setText(caesarEncryptedText);
                    break;
                case "AtbashCipher":
                    AtbashCipher atbashCipher = new AtbashCipher();
                    String atbashEncryptedText = atbashCipher.encrypt(MsgToEncrypt.getText());
                    encrypted_msg.setText(atbashEncryptedText);
                    break;
                case "RSA":
                    // RSA case
                    break;
                default:
                    System.out.println("Unknown cipher selected");
                    break;
            }
        }
    }
}