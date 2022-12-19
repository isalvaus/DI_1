module com.example.di_ {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.di_1 to javafx.fxml;
    exports com.example.di_1;
}