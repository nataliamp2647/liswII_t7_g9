package co.unicauca.builder;

import co.unicauca.domain.DifficultyLevel;
import co.unicauca.domain.Option;
import co.unicauca.domain.Question;
import co.unicauca.domain.QuestionType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultipleChoiceQuestionBuilder extends QuestionBuilder {

    private static final int MIN_OPTIONS = 2;

    public MultipleChoiceQuestionBuilder() {
        reset();
    }

    @Override
    public void reset() {
        question = new Question();
        question.setType(QuestionType.MULTIPLE_CHOICE);
    }

    @Override
    public void buildStatement(String statement) {
        question.setStatement(statement);
    }

    @Override
    public void buildContext(String context) {
        question.setContext(context);
    }

    @Override
    public void buildDifficulty(DifficultyLevel difficulty) {
        question.setDifficulty(difficulty);
    }

    @Override
    public void buildCategory(String category) {
        question.setCategory(category);
    }

    @Override
    public void buildSubtopic(String subtopic) {
        question.setSubtopic(subtopic);
    }

    @Override
    public void buildCompetence(String competence) {
        question.setCompetence(competence);
    }

    @Override
    public void buildAuthor(String author) {
        question.setAuthor(author);
    }

    @Override
    public void buildJustification(String justification) {
        question.setJustification(justification);
    }

    @Override
    public void buildSource(String source) {
        question.setSource(source);
    }

    @Override
    public void buildAnswers(List<Option> options, String correctAnswer) {
        question.setOptions(options);
        question.setCorrectAnswer(correctAnswer);
    }

    @Override
    public Question build() {
        validateCommon();
        validateSpecific();

        Question result = question;

        reset(); // queda listo para construir otra pregunta

        return result;
    }

    private void validateSpecific() {

        List<Option> options = question.getOptions();

        if (options.size() < MIN_OPTIONS) {
            throw new IllegalStateException(
                    "Una pregunta de seleccion multiple debe tener al menos "
                    + MIN_OPTIONS + " opciones");
        }

        Set<String> labels = new HashSet<>();

        for (Option o : options) {

            if (isBlank(o.getLabel()) || isBlank(o.getText())) {
                throw new IllegalStateException(
                        "Todas las opciones deben tener etiqueta y texto");
            }

            if (!labels.add(o.getLabel().trim().toUpperCase())) {
                throw new IllegalStateException(
                        "Hay opciones con la etiqueta repetida: "
                        + o.getLabel());
            }
        }

        String correct = question.getCorrectAnswer();

        if (isBlank(correct)
                || !labels.contains(correct.trim().toUpperCase())) {

            throw new IllegalStateException(
                    "La respuesta correcta debe corresponder a una de las opciones existentes");
        }
    }
}