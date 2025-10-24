module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    //paquets requis pour la connexion à la base
    requires mysql.connector.java;
    requires java.sql;


    opens sio.d3.javafx.exemples to javafx.fxml;
    opens sio.d3.javafx.climatiseurs to javafx.fxml;
    opens sio.d3.javafx.climatiseurs.tableview to javafx.fxml;
    opens sio.d3.javafx.climatiseurs.bdd to javafx.fxml;


    exports sio.d3.javafx.exemples;
    exports sio.d3.javafx.climatiseurs;
    exports sio.d3.javafx.climatiseurs.tableview;
    exports sio.d3.javafx.climatiseurs.bdd;
    exports sio.d3.javafx.exemples.games;
    opens sio.d3.javafx.exemples.games to javafx.fxml;

}