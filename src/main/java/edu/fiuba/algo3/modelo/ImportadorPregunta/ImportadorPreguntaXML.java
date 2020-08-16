package edu.fiuba.algo3.modelo.ImportadorPregunta;

import edu.fiuba.algo3.modelo.Exceptions.ArchivoInvalidoException;
import edu.fiuba.algo3.modelo.Exceptions.TipoDePreguntaInvalidoXMLException;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImportadorPreguntaXML {
    public static List<Pregunta> importarPreguntas(String archivo) throws IOException, ArchivoInvalidoException {
        List<Pregunta> preguntas;
        SAXReader reader = new SAXReader();
        try{
            Document doc = reader.read(archivo);
            Element elemPreguntas = doc.getRootElement();
            preguntas = construirPreguntas(elemPreguntas);
        } catch(DocumentException ex) {
            throw new IOException();
        } catch(Exception ex) {
            throw new ArchivoInvalidoException(ex);
        }
        return preguntas;
    }

    private static List<Pregunta> construirPreguntas(Element elemPreguntas) throws TipoDePreguntaInvalidoXMLException{
        List<Pregunta> preguntas = new ArrayList<>();
        Iterator it = elemPreguntas.elementIterator();
        while(it.hasNext()){
            Element elemPregunta = (Element)it.next();
            Pregunta pregunta = construirPregunta(elemPregunta);
            preguntas.add(pregunta);
        }
        return preguntas;
    }

    private static Pregunta construirPregunta(Element elemPregunta) throws TipoDePreguntaInvalidoXMLException {
        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta pregunta;
        String tipoPregunta = elemPregunta.attributeValue("tipoModalidad");
        String textoPregunta = elemPregunta.attributeValue("textoPregunta");
        List<List<Opcion>> opciones;
        switch (tipoPregunta) {
            case "VerdaderoFalsoClasico":
                opciones = construirOpcionesMultipleChoice(elemPregunta);
                pregunta = fabrica.crearVerdaderoFalsoClasico(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "VerdaderoFalsoPenalidad":
                opciones = construirOpcionesMultipleChoice(elemPregunta);
                pregunta = fabrica.crearVerdaderoFalsoPenalidad(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "MultipleChoiceClasico":
                opciones = construirOpcionesMultipleChoice(elemPregunta);
                pregunta = fabrica.crearMultipleChoiceClasico(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "MultipleChoiceParcial":
                opciones = construirOpcionesMultipleChoice(elemPregunta);
                pregunta = fabrica.crearMultipleChoiceParcial(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "MultipleChoicePenalidad":
                opciones = construirOpcionesMultipleChoice(elemPregunta);
                pregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "OrderedChoice":
                opciones = construirOpcionesOrderedChoice(elemPregunta);
                pregunta = fabrica.crearOrderedChoice(textoPregunta, opciones.get(0), opciones.get(0));
                break;
            case "GroupChoice":
                opciones = construirOpcionesGroupChoice(elemPregunta);
                pregunta = fabrica.crearGroupChoice(textoPregunta, opciones.get(0));
                break;
            default:
                throw new TipoDePreguntaInvalidoXMLException("Atributo tipoPregunta inválido: " + tipoPregunta);
        }
        return pregunta;
    }

    private static List<List<Opcion>> construirOpcionesMultipleChoice(Element elemPregunta) throws TipoDePreguntaInvalidoXMLException {
        List<List<Opcion>> parOpciones = new ArrayList<>();
        List<Opcion> opcionesDisponibles = new ArrayList<>();
        List<Opcion> respuestasCorrectas = new ArrayList<>();
        Iterator it = elemPregunta.elementIterator();
        while(it.hasNext()){
            Element elemOpciones = (Element)it.next();
            String textoOpcion = elemOpciones.attributeValue("textoOpcion");
            String esCorrecta = elemOpciones.attributeValue("esCorrecta");
            switch (esCorrecta) {
                case "true":
                    opcionesDisponibles.add(new OpcionSinGrupo(textoOpcion));
                    respuestasCorrectas.add(new OpcionSinGrupo(textoOpcion));
                    break;
                case "false":
                    opcionesDisponibles.add(new OpcionSinGrupo(textoOpcion));
                    break;
                default:
                    throw new TipoDePreguntaInvalidoXMLException("Atributo esCorrecta inválido: " + esCorrecta);
            }
        }
        parOpciones.add(opcionesDisponibles);
        parOpciones.add(respuestasCorrectas);
        return parOpciones;
    }

    private static List<List<Opcion>> construirOpcionesGroupChoice(Element elemPregunta) {
        List<List<Opcion>> parOpciones = new ArrayList<>();
        List<Opcion> opcionesDisponibles = new ArrayList<>();
        Iterator it = elemPregunta.elementIterator();
        while(it.hasNext()){
            Element elemOpciones = (Element)it.next();
            String textoOpcion = elemOpciones.attributeValue("textoOpcion");
            String grupo = elemOpciones.attributeValue("grupo");
            OpcionConGrupo opcion = new OpcionConGrupo(textoOpcion);
            opcion.setGrupo(grupo);
            opcionesDisponibles.add(opcion);
        }
        parOpciones.add(opcionesDisponibles);
        return parOpciones;
    }

    private static List<List<Opcion>> construirOpcionesOrderedChoice(Element elemPregunta) {
        List<List<Opcion>> parOpciones = new ArrayList<>();
        List<Opcion> opcionesDisponibles = new ArrayList<>();
        Iterator it = elemPregunta.elementIterator();
        while(it.hasNext()){
            Element elemOpciones = (Element)it.next();
            String textoOpcion = elemOpciones.attributeValue("textoOpcion");
            opcionesDisponibles.add(new OpcionSinGrupo(textoOpcion));
        }
        parOpciones.add(opcionesDisponibles);
        return parOpciones;
    }
}
