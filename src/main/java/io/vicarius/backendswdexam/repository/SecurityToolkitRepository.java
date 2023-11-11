package io.vicarius.backendswdexam.repository;

import io.vicarius.backendswdexam.model.SecurityToolkit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SecurityToolkitRepository extends ElasticsearchRepository<SecurityToolkit, String> {
}
