import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String configFilePath = "C:\\Users\\usuario\\Desktop\\config.json"; // Ruta del archivo de configuración JSON

        try {
            // Leer el archivo JSON utilizando Gson
            Gson gson = new Gson();
            FileReader reader = new FileReader(configFilePath);

            // Convertir el archivo JSON en un objeto Java
            databaseConfig config = gson.fromJson(reader, databaseConfig.class);

            // Mostrar la información obtenida del archivo JSON
            System.out.println("Nombre del Servidor: " + config.getServerName());
            System.out.println("Puerto: " + config.getPort());
            System.out.println("Usuario DB: " + config.getDatabase().getUsername());
            System.out.println("Contraseña DB: " + config.getDatabase().getPassword());

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo de configuración no se encontró.");
        } catch (JsonSyntaxException e) {
            System.out.println("Error: El archivo de configuración contiene un formato JSON inválido.");
        } catch (IOException e) {
            System.out.println("Error: Ocurrió un problema al leer el archivo de configuración.");
        }
    }
}
