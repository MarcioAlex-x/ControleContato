package br.com.controlecontato.dto;

import br.com.controlecontato.enums.RoleName;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDTO {

    private String username;
    private String password;
    private List<RoleName> listRole;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setListRole(List<RoleName> listRole) {
        this.listRole = listRole;
    }

}