module me.tjens23.vopcrypto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires junit;


    opens me.tjens23.vopcrypto to javafx.fxml;
    exports me.tjens23.vopcrypto;
}