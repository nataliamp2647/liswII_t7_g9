package co.unicauca.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PRODUCTO del patron Builder: una pregunta del Banco de Preguntas.
 * Se construye paso a paso desde un QuestionBuilder.
 */
public class Question {

    private QuestionType type;

    private String statement;          
    private String context;            
    private DifficultyLevel difficulty;
    private String category;          
    private String subtopic;         
    private String competence;         
    private String author;

    private String justification;     
    private String source;             

    private String status = "BORRADOR";

    private List<Option> options = new ArrayList<>();
    private String correctAnswer;     

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void setOptions(List<Option> options) {
        this.options = (options == null) ? new ArrayList<>() : new ArrayList<>(options);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[").append(type).append("] ").append(statement).append("\n");

        if (context != null) {
            sb.append("  Contexto: ").append(context).append("\n");
        }

        sb.append("  Dificultad: ").append(difficulty)
          .append(" | Categoria: ").append(category)
          .append(" | Subtema: ").append(subtopic).append("\n");

        sb.append("  Competencia: ").append(competence)
          .append(" | Autor: ").append(author).append("\n");

        sb.append("  Estado: ").append(status).append("\n");

        for (Option o : options) {
            sb.append("    ").append(o).append("\n");
        }

        sb.append("  Respuesta correcta: ").append(correctAnswer).append("\n");

        if (justification != null) {
            sb.append("  Justificacion: ").append(justification).append("\n");
        }

        if (source != null) {
            sb.append("  Fuente: ").append(source).append("\n");
        }

        return sb.toString();
    }
}