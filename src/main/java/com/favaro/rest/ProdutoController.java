package com.favaro.rest;

import com.favaro.model.Produto;
import com.favaro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/produto/{ID}", method = RequestMethod.GET)
    public Produto getPerson(@PathVariable("id") int id) {
        return produtoService.getProduto(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> getProduto() {
        return produtoService.getProduto();
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Integer id) {
        produtoService.delete(id);
    }

    @RequestMapping(value = "/produto", method = {RequestMethod.POST})
    public ResponseEntity<?> addProduto(@RequestBody Produto produto) {
        return save(produto);
    }

    @RequestMapping(value = "/produto", method = {RequestMethod.PUT})
    public ResponseEntity<?> updateProduto(@RequestBody Produto produto) {
        return save(produto);
    }

    private ResponseEntity<?> save(Produto produto) {
        Produto result = produtoService.save(produto);
        final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/directory/{id}").build()
                .expand(produto.getId()).toUri();
        return ResponseEntity.created(location).body(result);
    }
}
