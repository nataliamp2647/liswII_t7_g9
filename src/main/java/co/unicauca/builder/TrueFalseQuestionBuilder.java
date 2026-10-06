package co.unicauca.builder;

import co.unicauca.domain.DifficultyLevel;
import co.unicauca.domain.Option;
import co.unicauca.domain.Question;
import co.unicauca.domain.QuestionType;

import java.util.Arrays;
import java.util.List;

public class TrueFalseQuestionBuilder extends QuestionBuilder {

    private static final String TRUE_LABEL = "V";
    private static final String FALSE_LABEL = "F";

    public TrueFalseQuestionBuilder() {
        reset();
    }

    @Override
    public void reset() {
        question = new Question();
        question.setType(QuestionType.TRUE_FALSE);
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

        question.setOptions(Arrays.asList(
                new Option(TRUE_LABEL, "Verdadero"),
                new Option(FALSE_LABEL, "Falso")
        ));

        question.setCorrectAnswer(normalize(correctAnswer));
    }

    @Override
    public Question build() {

        validateCommon();
        validateSpecific();

        Question result = question;

        reset();

        return result;
    }

    private void validateSpecific() {

        String correct = question.getCorrectAnswer();

        if (!TRUE_LABEL.equals(correct)
                && !FALSE_LABEL.equals(correct)) {

            throw new IllegalStateException(
                    "La respuesta de una pregunta V/F debe ser Verdadero o Falso");
        }
    }

    private String normalize(String answer) {

        if (answer == null) {
            return null;
        }

        String a = answer.trim().toUpperCase();

        if (a.equals("V") || a.equals("VERDADERO")) {
            return TRUE_LABEL;
        }

        if (a.equals("F") || a.equals("FALSO")) {
            return FALSE_LABEL;
        }

        return answer;
    }
}