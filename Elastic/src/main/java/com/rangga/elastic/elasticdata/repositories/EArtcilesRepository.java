package com.rangga.elastic.elasticdata.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.rangga.elastic.elasticdata.models.EArticlesModel;

@EnableElasticsearchRepositories
public interface EArtcilesRepository extends ElasticsearchRepository<EArticlesModel, String> {

}
