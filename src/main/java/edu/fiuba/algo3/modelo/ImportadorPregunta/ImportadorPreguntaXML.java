package edu.fiuba.algo3.modelo.ImportadorPregunta;

import edu.fiuba.algo3.modelo.Exceptions.TipoDePreguntaInvalidoXMLException;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
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

    public static List<Pregunta> importarPreguntas(String archivo) throws IOException, TipoDePreguntaInvalidoXMLException {
        List<Pregunta> preguntas;
        SAXReader reader = new SAXReader();
        try{
            Document doc = reader.read(archivo);
            Element elemPreguntas = doc.getRootElement();
            preguntas = construirPreguntas(elemPreguntas);
        } catch(DocumentException ex) {
            throw new IOException();
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
        Pregunta pregunta;
        String tipoPregunta = elemPregunta.attributeValue("tipoModalidad");
        String textoPregunta = elemPregunta.attributeValue("textoPregunta");
        List<List<Opcion>> opciones = construirParOpciones(elemPregunta);
        switch (tipoPregunta) {
            case "VerdaderoFalsoClasico":
                pregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "VerdaderoFalsoPenalidad":
                pregunta = Pregunta.crearPreguntaVerdaderoFalsoConPenalidad(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "MultipleChoiceClasico":
                pregunta = Pregunta.crearPreguntaMultipleChoiceClasico(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "MultipleChoiceParcial":
                pregunta = Pregunta.crearPreguntaMultipleChoiceParcial(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "MultipleChoicePenalidad":
                pregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "OrderedChoice":
                pregunta = Pregunta.crearPreguntaOrderedChoice(textoPregunta, opciones.get(0), opciones.get(1));
                break;
            case "GroupChoice":
                pregunta = Pregunta.crearPreguntaGroupChoice(textoPregunta, opciones.get(0));
                break;
            default:
                throw new TipoDePreguntaInvalidoXMLException(tipoPregunta);
        }
        return pregunta;
    }

    private static List<List<Opcion>> construirParOpciones(Element elemPregunta) {
        List<List<Opcion>> parOpciones = new ArrayList<>();
        Iterator it = elemPregunta.elementIterator();
        while(it.hasNext()){
            Element elemOpciones = (Element)it.next();
            List<Opcion> opciones = construirOpciones(elemOpciones);
            parOpciones.add(opciones);
        }
        return parOpciones;
    }

    private static List<Opcion> construirOpciones(Element elemOpciones) {
        // TODO
    }
}
