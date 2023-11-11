package io.vicarius.backendswdexam.controller;

import io.vicarius.backendswdexam.model.SecurityToolkit;
import io.vicarius.backendswdexam.repository.SecurityToolkitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.elasticsearch.client.erhlc.ElasticsearchRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SecurityToolkitControllerTest {

    private final String DOCUMENT_ID = "ABCDEF";

    @Mock
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Mock
    private SecurityToolkitRepository repository;

    @InjectMocks
    private SecurityToolkitController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDocument() {
        SecurityToolkit toolkit = new SecurityToolkit();
        toolkit.setId(DOCUMENT_ID);

        when(repository.save(toolkit)).thenReturn(toolkit);

        ResponseEntity<String> response = controller.createDocument(toolkit);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Document created successfully with ID: " + toolkit.getId(), response.getBody());
    }

    @Test
    void testGetAllDocuments() {
        Iterable<SecurityToolkit> mockDocuments = mock(Iterable.class);

        when(repository.findAll()).thenReturn(mockDocuments);

        Iterable<SecurityToolkit> result = controller.getAllDocuments();

        assertEquals(mockDocuments, result);
    }

    @Test
    void testGetDocumentById_DocumentFound() {
        SecurityToolkit mockToolkit = mock(SecurityToolkit.class);

        when(repository.findById(DOCUMENT_ID)).thenReturn(Optional.of(mockToolkit));

        ResponseEntity<SecurityToolkit> response = controller.getDocumentById(DOCUMENT_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockToolkit, response.getBody());
    }

    @Test
    void testGetDocumentById_DocumentNotFound() {
        when(repository.findById(DOCUMENT_ID)).thenReturn(Optional.empty());

        ResponseEntity<SecurityToolkit> response = controller.getDocumentById(DOCUMENT_ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
