/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestaodeconultoriomedico;

/**
 *
 * @author isaac
 */
public class SessionManager {
    private static Usuario usuarioLogado; // Substitua "Usuario" pelo seu modelo de usuário

    // Retorna o usuário logado (ou null se não houver sessão)
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    // Define o usuário logado após o login bem-sucedido
    public static void login(Usuario usuario) {
        usuarioLogado = usuario;
    }

    // Limpa a sessão (logout)
    public static void logout() {
        usuarioLogado = null;
    }
}
