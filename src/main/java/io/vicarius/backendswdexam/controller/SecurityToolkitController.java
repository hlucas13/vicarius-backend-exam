package io.vicarius.backendswdexam.controller;

import io.vicarius.backendswdexam.model.SecurityToolkit;
import io.vicarius.backendswdexam.repository.SecurityToolkitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.erhlc.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/security-toolkit")
public class SecurityToolkitController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private SecurityToolkitRepository repository;

    @PostMapping("/create-index")
    public ResponseEntity<String> createIndex() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(SecurityToolkit.class);
        String indexName = indexOperations.getIndexCoordinates().getIndexName();

        if (indexOperations.exists()) {
            return new ResponseEntity<>("Index '" + indexName + "' already exists", HttpStatus.OK);
        }

        indexOperations.create();
        return new ResponseEntity<>("Index '" + indexName + "' created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/create-document")
    public ResponseEntity<String> createDocument(@RequestBody SecurityToolkit toolkit) {
        repository.save(toolkit);
        return new ResponseEntity<>("Document created successfully with ID: " + toolkit.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/documents")
    public Iterable<SecurityToolkit> getAllDocuments() {
        return repository.findAll();
    }

    @GetMapping("/document/{id}")
    public ResponseEntity<SecurityToolkit> getDocumentById(@PathVariable String id) {
        Optional<SecurityToolkit> toolkit = repository.findById(id);

        return toolkit.map(document -> new ResponseEntity<>(document, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
