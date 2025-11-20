package com.tecsup.labs;
import java.util.ArrayList;
import java.util.List;
public class UserRegistrationService {
public String lastErrorMessage = "";

private List users = new ArrayList();
// Mala práctica: número mágico [cite: 143, 144]
private static final int MIN_PASSWORD_LENGTH = 8;
// Constructor con lógica innecesaria [cite: 145]
public UserRegistrationService() {
// Comentario engañoso: aquí no se valida nada aún [cite: 147]
System.out.println("Constructor llamado");
if (users == null) { // Esta condición nunca se cumple [cite: 149]
users = new ArrayList();
}
}
/**
 * Registra un nuevo usuario.
 * Retorna true si se registra, false en caso contrario. [cite: 154, 155]
 */
public boolean registerUser(String username, String password, String email) {
// Posible NullPointerException: no se valida si username es null [cite: 158]
if (username.trim().isEmpty()) {
lastErrorMessage = "El nombre de usuario está vacío.";
return false;
}
// Código duplicado: validación de longitud escrita dos veces [cite: 163]
if (password == null) {
lastErrorMessage = "La contraseña es null.";
return false;
}
if (password.length() < MIN_PASSWORD_LENGTH) {
lastErrorMessage = "La contraseña es muy corta.";
return false;
}
if (password.length() < MIN_PASSWORD_LENGTH) { // Duplicado intencional [cite: 172]
System.out.println("Advertencia: contraseña corta.");
}
// Mala lógica: condición incorrecta para validar email [cite: 175]
if (!email.contains("@") && !email.contains(".")) {
lastErrorMessage = "El correo electrónico no parece válido.";
// En realidad, debería ser una condición más estricta [cite: 178]
}
// Manejo de excepciones deficiente [cite: 180]
try {
// Simulación de acceso a base de datos [cite: 182]
saveUser(username, password, email);
} catch (Exception e) {
// Mala práctica: capturar Exception general y no registrar nada [cite: 185]
lastErrorMessage = "Error desconocido al guardar el usuario.";
return false;
}
// Usuarios duplicados no se validan [cite: 189]
System.out.println("Usuario registrado: " + username);
return true;
}
private void saveUser(String username, String password, String email) throws Exception {
// Simula guardar el usuario en una lista [cite: 194]
users.add(username); // Mala práctica: solo se guarda el nombre [cite: 195]
if (username.equals("error")) {
// Excepción artificial para que las herramientas lo detecten [cite: 197]
throw new Exception("Nombre de usuario no permitido.");
}
}
// Método con nombre poco claro y sin comentarios [cite: 201]
public int x(String s) {
if (s == null) {
return -1;
}
// Uso ineficiente de String [cite: 206]
String result = "";
for (int i = 0; i < s.length(); i++) {
result = result + s.charAt(i);
}
return result.length();
}
}