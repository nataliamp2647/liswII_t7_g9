package co.unicauca;

import co.unicauca.builder.MultipleChoiceQuestionBuilder;
import co.unicauca.builder.OpenQuestionBuilder;
import co.unicauca.builder.QuestionBuilder;
import co.unicauca.builder.TrueFalseQuestionBuilder;
import co.unicauca.director.QuestionDirector;
import co.unicauca.domain.DifficultyLevel;
import co.unicauca.domain.Option;
import co.unicauca.domain.Question;

import java.util.Arrays;

public class ApplicationMain {

    public static void main(String[] args) {

        // Crear los Builders
        QuestionBuilder multipleChoice = new MultipleChoiceQuestionBuilder();
        QuestionBuilder trueFalse = new TrueFalseQuestionBuilder();
        QuestionBuilder open = new OpenQuestionBuilder();

        // Crear el Director
        QuestionDirector director = new QuestionDirector(multipleChoice);

        // Construir pregunta de seleccion multiple
        Question question1 = director.make(
                "Cual de los siguientes es un patron de diseno creacional?",
                "Pregunta relacionada con los patrones de diseno utilizados en Ingenieria de Software.",
                DifficultyLevel.FACIL,
                "Ingenieria de Software",
                "Patrones de diseno",
                "Diseno de software",
                "Nata",
                "Builder permite separar la construccion de un objeto de su representacion.",
                "Design Patterns - Gamma et al.",
                Arrays.asList(
                        new Option("A", "Observer"),
                        new Option("B", "Builder"),
                        new Option("C", "Adapter"),
                        new Option("D", "Facade")
                ),
                "B"
        );

        System.out.println("Pregunta de seleccion multiple:");
        System.out.println(question1);
        System.out.println();

        // Construir pregunta de verdadero/falso
        director.changeBuilder(trueFalse);

        Question question2 = director.make(
                "El patron Builder es un patron creacional.",
                "Pregunta sobre la clasificacion de los patrones de diseno.",
                DifficultyLevel.FACIL,
                "Ingenieria de Software",
                "Patrones creacionales",
                "Reconocimiento de patrones de diseno",
                "Nata",
                "Builder pertenece a los patrones creacionales.",
                "Design Patterns - Gamma et al.",
                null,
                "Verdadero"
        );

        System.out.println("Pregunta de verdadero/falso:");
        System.out.println(question2);
        System.out.println();

        // Construir pregunta abierta
        director.changeBuilder(open);

        Question question3 = director.make(
                "Que problema resuelve el patron Builder?",
                "Pregunta sobre la utilidad del patron Builder en la construccion de objetos complejos.",
                DifficultyLevel.MEDIO,
                "Ingenieria de Software",
                "Patrones creacionales",
                "Analisis de problemas de diseno",
                "Nata",
                "Builder permite construir objetos complejos paso a paso.",
                "Design Patterns - Gamma et al.",
                null,
                "Permite construir objetos complejos paso a paso."
        );

        System.out.println("Pregunta abierta:");
        System.out.println(question3);
    }
}
