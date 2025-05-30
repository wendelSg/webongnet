package com.itb.tcc.mif3an.ongnet.auditing;


//import com.itb.mif3an.pizzaria.model.Usuario;
import com.itb.tcc.mif3an.ongnet.model.entity.Usuario;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken
        ) {
            return Optional.empty();
        }

        Usuario userPrincipal = (Usuario) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getId());
    }
}

