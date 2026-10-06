package co.unicauca.domain;

/** Opcion de respuesta de una pregunta (por ejemplo "A" - "Patron creacional"). */
public class Option {
    private final String label;
    private final String text;

    public Option(String label, String text) {
        this.label = label;
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return label + ") " + text;
    }
}
