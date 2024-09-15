public class Main {
    public static void main(String[] args) {
        // Construir un email con asunto inicial
        Email email = new Email.Builder("Asunto inicial")
                .addDestinatario("destinatario1@example.com")
                .setCuerpo("Contenido inicial del correo.")
                .build();

        System.out.println(email);

        // Modificar el cuerpo del correo
        email.setCuerpo("Contenido modificado del correo.");

        // Agregar un nuevo destinatario
        email.addDestinatario("destinatario2@example.com");

        // Eliminar un destinatario
        email.removeDestinatario("destinatario1@example.com");

        // Cambiar el asunto
        email.setAsunto("Nuevo asunto");

        System.out.println(email);
    }
}
