package co.unicauca.director;

import co.unicauca.builder.QuestionBuilder;
import co.unicauca.domain.DifficultyLevel;
import co.unicauca.domain.Option;
import co.unicauca.domain.Question;

import java.util.List;

public class QuestionDirector {

    private QuestionBuilder builder;

    public QuestionDirector(QuestionBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(QuestionBuilder builder) {
        this.builder = builder;
    }

    public Question make(
            String statement,
            String context,
            DifficultyLevel difficulty,
            String category,
            String subtopic,
            String competence,
            String author,
            String justification,
            String source,
            List<Option> options,
            String correctAnswer) {

        return makeQuestion(
                statement,
                context,
                difficulty,
                category,
                subtopic,
                competence,
                author,
                justification,
                source,
                options,
                correctAnswer);
    }

    public Question makeQuestion(
            String statement,
            String context,
            DifficultyLevel difficulty,
            String category,
            String subtopic,
            String competence,
            String author,
            String justification,
            String source,
            List<Option> options,
            String correctAnswer) {

        builder.reset();

        builder.buildStatement(statement);
        builder.buildContext(context);
        builder.buildDifficulty(difficulty);
        builder.buildCategory(category);
        builder.buildSubtopic(subtopic);
        builder.buildCompetence(competence);
        builder.buildAuthor(author);
        builder.buildAnswers(options, correctAnswer);
        builder.buildJustification(justification);
        builder.buildSource(source);

        return builder.build();
    }
}