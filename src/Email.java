import java.util.ArrayList;
import java.util.List;

// Clase Email
public class Email {
    private List<String> destinatarios;
    private String asunto;
    private String cuerpo;

    private Email(Builder builder) {
        this.destinatarios = new ArrayList<>(builder.destinatarios);
        this.asunto = builder.asunto;
        this.cuerpo = builder.cuerpo;
    }

    // Métodos para obtener los atributos
    public List<String> getDestinatarios() {
        return new ArrayList<>(destinatarios); // Retorna una copia para evitar modificaciones externas
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    // Métodos para modificar los atributos
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void addDestinatario(String destinatario) {
        this.destinatarios.add(destinatario);
    }

    public void removeDestinatario(String destinatario) {
        this.destinatarios.remove(destinatario);
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    // Clase Builder interna
    public static class Builder {
        private List<String> destinatarios = new ArrayList<>();
        private String asunto;
        private String cuerpo;

        public Builder(String asunto) {
            this.asunto = asunto;
        }

        public Builder addDestinatario(String destinatario) {
            this.destinatarios.add(destinatario);
            return this;
        }

        public Builder setCuerpo(String cuerpo) {
            this.cuerpo = cuerpo;
            return this;
        }

        public Email build() {
            // Validaciones opcionales
            if (destinatarios.isEmpty()) {
                throw new IllegalStateException("Debe haber al menos un destinatario.");
            }
            if (asunto == null || asunto.trim().isEmpty()) {
                throw new IllegalStateException("El asunto no puede estar vacío.");
            }
            return new Email(this);
        }
    }

    @Override
    public String toString() {
        return "Email{" +
                "destinatarios=" + destinatarios +
                ", asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                '}';
    }
}
