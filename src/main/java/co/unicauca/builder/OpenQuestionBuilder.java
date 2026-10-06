package co.unicauca.builder;

import co.unicauca.domain.DifficultyLevel;
import co.unicauca.domain.Option;
import co.unicauca.domain.Question;
import co.unicauca.domain.QuestionType;

import java.util.ArrayList;
import java.util.List;

public class OpenQuestionBuilder extends QuestionBuilder {

    public OpenQuestionBuilder() {
        reset();
    }

    @Override
    public void reset() {
        question = new Question();
        question.setType(QuestionType.OPEN);
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

        question.setOptions(new ArrayList<>());
        question.setCorrectAnswer(correctAnswer);
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

        if (isBlank(question.getCorrectAnswer())) {
            throw new IllegalStateException(
                    "Una pregunta abierta debe tener una respuesta esperada");
        }
    }
}