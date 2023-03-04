package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.NewUserDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {


}
