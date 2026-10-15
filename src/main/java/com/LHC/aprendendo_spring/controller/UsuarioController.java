package com.LHC.aprendendo_spring.controller;

import com.LHC.aprendendo_spring.business.UsuarioService;
import com.LHC.aprendendo_spring.controller.dtos.UsuarioDTO;
import com.LHC.aprendendo_spring.infrastructure.entity.Usuario;
import com.LHC.aprendendo_spring.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {


    public final UsuarioService usuarioService;
    public final AuthenticationManager authenticationManager;
    public final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {

        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));

    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuariodto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuariodto.getEmail(),
                        usuariodto.getSenha())
        );
        return jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email) {
        usuarioService.deletarUsuarioPorEmail(email);
       return ResponseEntity.ok().build();
    }
}
