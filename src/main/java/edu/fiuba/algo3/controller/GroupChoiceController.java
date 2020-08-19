package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Constants.Constants;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;
import edu.fiuba.algo3.vista.ConstantesVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class GroupChoiceController extends GeneralPreguntaController{

    @FXML
    Label opcionUno, opcionDos, opcionTres, opcionCuatro, opcionCinco, opcionSeis;

    @FXML
    Button opcionUnoGrupoUno, opcionUnoGrupoDos, opcionDosGrupoUno, opcionDosGrupoDos, opcionTresGrupoUno, opcionTresGrupoDos;

    @FXML
    Button opcionCuatroGrupoUno, opcionCuatroGrupoDos, opcionCincoGrupoUno, opcionCincoGrupoDos, opcionSeisGrupoUno, opcionSeisGrupoDos;

    public void setUp(){

        iniciarBotones();
        iniciarLabels();
    }

    public void iniciarBotones(){

        List<Button> botones = new ArrayList<>();
        botones.add(opcionUnoGrupoUno);
        botones.add(opcionUnoGrupoDos);
        botones.add(opcionDosGrupoUno);
        botones.add(opcionDosGrupoDos);
        botones.add(opcionTresGrupoUno);
        botones.add(opcionTresGrupoDos);
        botones.add(opcionCuatroGrupoUno);
        botones.add(opcionCuatroGrupoDos);
        botones.add(opcionCincoGrupoUno);
        botones.add(opcionCincoGrupoDos);
        botones.add(opcionSeisGrupoUno);
        botones.add(opcionSeisGrupoDos);

        List<Opcion> opcionesPregunta = rondaActual.getOpciones();

        for(int i = (2 * opcionesPregunta.size()); i < 2 * Constants.CANTIDAD_MAXIMA_OPCIONES_GROUP_CHOICE; i++)
            botones.get(i).setVisible(false);
    }

    public void iniciarLabels(){
        List<Label> labels = new ArrayList<>();

        labels.add(opcionUno);
        labels.add(opcionDos);
        labels.add(opcionTres);
        labels.add(opcionCuatro);
        labels.add(opcionCinco);
        labels.add(opcionSeis);

        List<Opcion> opcionesPregunta = rondaActual.getOpciones();
        int cantidadOpciones = 0;

        for(Opcion opcion : opcionesPregunta){
            labels.get(cantidadOpciones).setText(opcion.getTexto());
            cantidadOpciones++;
        }

        for (int j = cantidadOpciones; j < Constants.CANTIDAD_MAXIMA_OPCIONES_GROUP_CHOICE; j++) {
            labels.get(j).setVisible(false);
        }

    }

    public void onOpcionUnoGrupoUno(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionUno.getText());
        opcion.setGrupo(opcionUnoGrupoUno.getText());

        opcionesSeleccionadas.add(opcion);
        opcionUnoGrupoUno.setDisable(true);
        opcionUnoGrupoDos.setDisable(true);
    }

    public void onOpcionUnoGrupoDos(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionDos.getText());
        opcion.setGrupo(opcionUnoGrupoDos.getText());

        opcionesSeleccionadas.add(opcion);
        opcionUnoGrupoUno.setDisable(true);
        opcionUnoGrupoDos.setDisable(true);
    }

    public void onOpcionDosGrupoUno(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionDos.getText());
        opcion.setGrupo(opcionDosGrupoUno.getText());

        opcionesSeleccionadas.add(opcion);
        opcionDosGrupoUno.setDisable(true);
        opcionDosGrupoDos.setDisable(true);
    }

    public void onOpcionDosGrupoDos(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionDos.getText());
        opcion.setGrupo(opcionDosGrupoDos.getText());

        opcionesSeleccionadas.add(opcion);
        opcionDosGrupoUno.setDisable(true);
        opcionDosGrupoDos.setDisable(true);
    }

    public void onOpcionTresGrupoUno(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionTres.getText());
        opcion.setGrupo(opcionTresGrupoUno.getText());

        opcionesSeleccionadas.add(opcion);
        opcionTresGrupoUno.setDisable(true);
        opcionTresGrupoDos.setDisable(true);
    }

    public void onOpcionTresGrupoDos(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionTres.getText());
        opcion.setGrupo(opcionTresGrupoDos.getText());

        opcionesSeleccionadas.add(opcion);
        opcionTresGrupoUno.setDisable(true);
        opcionTresGrupoDos.setDisable(true);
    }

    public void onOpcionCuatroGrupoUno(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionCuatro.getText());
        opcion.setGrupo(opcionCuatroGrupoUno.getText());

        opcionesSeleccionadas.add(opcion);
        opcionCuatroGrupoUno.setDisable(true);
        opcionCuatroGrupoDos.setDisable(true);
    }

    public void onOpcionCuatroGrupoDos(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionCuatro.getText());
        opcion.setGrupo(opcionCuatroGrupoDos.getText());

        opcionesSeleccionadas.add(opcion);
        opcionCuatroGrupoUno.setDisable(true);
        opcionCuatroGrupoDos.setDisable(true);
    }

    public void onOpcionCincoGrupoUno(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionCinco.getText());
        opcion.setGrupo(opcionCincoGrupoUno.getText());

        opcionesSeleccionadas.add(opcion);
        opcionCincoGrupoUno.setDisable(true);
        opcionCincoGrupoDos.setDisable(true);
    }

    public void onOpcionCincoGrupoDos(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionCinco.getText());
        opcion.setGrupo(opcionCincoGrupoDos.getText());

        opcionesSeleccionadas.add(opcion);
        opcionCincoGrupoUno.setDisable(true);
        opcionCincoGrupoDos.setDisable(true);
    }

    public void onOpcionSeisGrupoUno(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionSeis.getText());
        opcion.setGrupo(opcionSeisGrupoUno.getText());

        opcionesSeleccionadas.add(opcion);
        opcionSeisGrupoUno.setDisable(true);
        opcionSeisGrupoDos.setDisable(true);
    }

    public void onOpcionSeisGrupoDos(){

        OpcionConGrupo opcion = new OpcionConGrupo(opcionSeis.getText());
        opcion.setGrupo(opcionSeisGrupoDos.getText());

        opcionesSeleccionadas.add(opcion);
        opcionSeisGrupoUno.setDisable(true);
        opcionSeisGrupoDos.setDisable(true);
    }
}
