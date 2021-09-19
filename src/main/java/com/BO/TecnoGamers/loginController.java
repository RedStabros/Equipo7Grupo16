package com.BO.TecnoGamers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TecnoGamers.*;
import com.DTO.TecnoGamers.LoginVO;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class loginController {
	
		@RequestMapping("/loginusuario2")		
		public Map<String, Boolean> validarlogin2(String usuario, String clave) 
		{
			ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();
				
			LoginDAO Dao = new LoginDAO(); 
			miusuario = Dao.consultarUsuario(usuario, clave);
		if(miusuario.isEmpty())	{
			return Collections.singletonMap("existe", false);
		}else{
			return Collections.singletonMap("existe", true);
		}
	}
}
