package br.com.caiohenriquedev.dao;

import br.com.caiohenriquedev.domain.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void salvar(Usuario usuario);

    void editar(Usuario usuario);

    void excluir(Long id);

    Usuario getById(Long id);

    List<Usuario> getTodos();
}
