module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires dom4j;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vista;
    exports edu.fiuba.algo3.controller;
    opens edu.fiuba.algo3.controller;
    opens edu.fiuba.algo3.modelo.Pregunta;
    opens edu.fiuba.algo3.modelo.Jugador;
}