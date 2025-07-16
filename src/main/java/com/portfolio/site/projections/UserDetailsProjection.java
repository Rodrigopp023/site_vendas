package com.portfolio.site.projections;

public interface UserDetailsProjection {
    String getUsuario();
    String getSenha();
    Long getRoleId();
    String getAuthority();
}
