module co.edu.uniquindio.gimnasiouq.gimnasiouq {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens co.edu.uniquindio.gimnasiouq.gimnasiouq to javafx.fxml;
    opens co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller to javafx.fxml;
    opens co.edu.uniquindio.gimnasiouq.gimnasiouq.model to javafx.base;



    exports co.edu.uniquindio.gimnasiouq.gimnasiouq;
    exports co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;
}