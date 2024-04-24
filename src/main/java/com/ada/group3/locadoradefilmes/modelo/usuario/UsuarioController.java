package com.ada.group3.locadoradefilmes.modelo.usuario;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.mapping}/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public List<UsuarioDto> listarTodos() {
        return this.service.listarTodos();
    }

    @GetMapping(value = "busca", params = "login")
    public UsuarioDto buscarPorLogin(@RequestParam String login) {
        return this.service.buscarPorLogin(login);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto adicionarUsuario(@RequestBody UsuarioDto usuario) {
        return this.service.adicionarUsuario(usuario);
    }
    @PutMapping("/{login}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable String login,@RequestBody UsuarioDto usuarioAtualizado){
        this.service.atualizar(login,usuarioAtualizado);
    }

    @Transactional
    @DeleteMapping("/{login}")
    public void excluir(@PathVariable String login) {
        this.service.excluir(login);
    }

}






