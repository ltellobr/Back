package co.edu.unbosque.ciclo3Back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.ciclo3Back.dao.usuariosDAO;
import co.edu.unbosque.ciclo3Back.model.usuarios;
@RestController //esta es una clase REST
@RequestMapping("usuarios")
public class usuariosAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private usuariosDAO usuariosDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody usuarios usuarios) {
usuariosDAO.save(usuarios);
}
@GetMapping("/listar")
public List<usuarios> listar(){
return usuariosDAO.findAll();
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable("id") Integer id) {
usuariosDAO.deleteById(id);
}
@PutMapping("/actualizar")
public void actualizar(@RequestBody usuarios usuarios) {
usuariosDAO.save(usuarios);
}
}
