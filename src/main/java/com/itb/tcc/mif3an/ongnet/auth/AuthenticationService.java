package com.itb.tcc.mif3an.ongnet.auth;

import com.itb.tcc.mif3an.ongnet.config.JwtService;
import com.itb.tcc.mif3an.ongnet.exceptions.BadRequest;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import com.itb.tcc.mif3an.ongnet.model.repository.UsuarioRepository;
import com.itb.tcc.mif3an.ongnet.model.token.Token;
import com.itb.tcc.mif3an.ongnet.model.token.TokenRepository;
import com.itb.tcc.mif3an.ongnet.model.token.TokenType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository repository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UsuarioRepository repository1, TokenRepository tokenRepository1, PasswordEncoder passwordEncoder1, JwtService jwtService1, AuthenticationManager authenticationManager1) {
        this.repository = repository1;
        this.tokenRepository = tokenRepository1;
        this.passwordEncoder = passwordEncoder1;
        this.jwtService = jwtService1;
        this.authenticationManager = authenticationManager1;
    }

    public AuthenticatorResponse register(RegisterRequest request) {

        String nomeClasse = String.valueOf(request.getRole());
        nomeClasse = nomeClasse.toLowerCase();
        if (nomeClasse.equals("representanteong")) {
            nomeClasse = "RepresentanteOng";
        } else {
            char primeiroCharMaiusculo = Character.toUpperCase(nomeClasse.charAt(0));
            nomeClasse = nomeClasse.substring(1);
            nomeClasse = primeiroCharMaiusculo + nomeClasse;
        }
            try{
                Class<?> clazz = Class.forName("com.itb.tcc.mif3an.ongnet.model.entity." + nomeClasse);
                Usuario usuario = (Usuario) clazz.newInstance();
                usuario.setCodStatus(true);
                usuario.setNome(request.getNome());
                usuario.setEmail(request.getEmail());
                usuario.setPassword(passwordEncoder.encode(request.getPassword()));
                usuario.setRole(request.getRole());
                var usuarioDb = repository.findByEmail(request.getEmail());
                if (usuarioDb.isPresent()) {
                    throw new BadRequest("Já existe este email cadastro em noss banco de dados");
                }
                var savedUser = repository.save(usuario);
                var jwtToken = jwtService.generateToken(usuario);
                var refreshToken = jwtService.generateRefreshToken(usuario);
                savedUserToken (savedUser, jwtToken);
                return new AuthenticatorResponse(jwtToken, refreshToken);

            }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }

        }
        private void savedUserToken(Usuario usuario, String jwtToken) {
        var token = new Token();
        token.setUsuario(usuario);
        token.setToken(jwtToken);
        token.setTokenType(TokenType.BEARER);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
        }
    }

