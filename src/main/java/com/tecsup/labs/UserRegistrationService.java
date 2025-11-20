package com.tecsup.labs;
import java.util.ArrayList;
import java.util.List;
/** 
 * Servicio de registro de usuarios mejorado para el laboratorio,
 * cumpliendo con estándares de calidad estática.
 */
public class UserRegistrationService {
    // CORRECCIÓN: campo privado para encapsulación.
    private String lastErrorMessage = ""; 
    // CORRECCIÓN: Lista con genéricos (<String>) y 'final'.
    private final List<String> users = new ArrayList<>(); 
    private static final int MIN_PASSWORD_LENGTH = 8;

    public UserRegistrationService() {
        System.out.println("UserRegistrationService inicializado");
    }

    /**
     * Registra un nuevo usuario.
     * Retorna true si se registra, false en caso contrario.
     */
    public boolean registerUser(String username, String password, String email) {
        // CORRECCIÓN: Validar null antes de usar trim()
        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío o es nulo.";
            return false;
        }

        if (password == null) {
            lastErrorMessage = "La contraseña es nula.";
            return false;
        }
        
        // CORRECCIÓN: Código duplicado eliminado
        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = "La contraseña es muy corta (Mínimo " + MIN_PASSWORD_LENGTH + " caracteres).";
            return false;
        }

        // Lógica de validación de email mejorada
        if (!email.contains("@") || !email.contains(".")) { 
            lastErrorMessage = "El correo electrónico no parece válido (Falta @ o .).";
            return false;
        }
        
        // CORRECCIÓN: Manejo de excepciones adecuado
        try {
            saveUser(username, password, email);
        } catch (IllegalArgumentException e) {
            // Capturar excepción específica
            lastErrorMessage = "Error al guardar: " + e.getMessage();
            return false;
        } catch (Exception e) {
            lastErrorMessage = "Error desconocido al guardar el usuario.";
            return false;
        }
        
        System.out.println("Usuario registrado: " + username);
        return true;
    }
    
    // CORRECCIÓN: Lanza una excepción específica
    private void saveUser(String username, String password, String email) throws IllegalArgumentException {
        // Se añade validación para usuarios duplicados
        if (users.contains(username)) {
            throw new IllegalArgumentException("Usuario ya existe.");
        }
        users.add(username); 
        
        if (username.equals("error")) {
            throw new IllegalArgumentException("Nombre de usuario no permitido.");
        }
    }

    // CORRECCIÓN: Nombre de método mejorado
    public int calculateStringLength(String inputString) {
        if (inputString == null) {
            return -1;
        }
        // Uso eficiente de length()
        return inputString.length(); 
    }
}