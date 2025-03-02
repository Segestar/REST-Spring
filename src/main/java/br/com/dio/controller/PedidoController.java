package br.com.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.entity.Pedido;
import br.com.dio.service.PedidoService;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping(value = "/pedido") // Mapeia as requisições HTTP para /pedido
public class PedidoController {

    @Autowired // Injeta a dependência do serviço de pedidos
    private PedidoService service;

    @PostMapping(value = "/save") // Mapeia requisições POST para /pedido/save
    public ResponseEntity<Pedido> salvaProduto(@RequestBody Pedido produto) {
        // Salva o pedido recebido no corpo da requisição
        produto = service.save(produto);
        // Retorna uma resposta HTTP 200 OK com o pedido salvo
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/{id}") // Mapeia requisições GET para /pedido/{id}
    public ResponseEntity<Pedido> buscaProduto(@PathVariable Long id) {
        // Busca o pedido pelo ID fornecido na URL
        Pedido pedido = service.findById(id);
        // Retorna uma resposta HTTP 200 OK com o pedido encontrado
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping(value = "/busca-todos") // Mapeia requisições GET para /pedido/busca-todos
    public ResponseEntity<List<Pedido>> buscaTodosProdutos() {
        // Busca todos os pedidos
        List<Pedido> pedidos = service.findAll();
        // Retorna uma resposta HTTP 200 OK com a lista de pedidos encontrados
        return ResponseEntity.ok().body(pedidos);
    }

    }
