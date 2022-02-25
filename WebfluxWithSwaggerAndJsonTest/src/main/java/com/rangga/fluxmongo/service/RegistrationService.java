package com.rangga.fluxmongo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rangga.fluxmongo.models.StudentModels;
import com.rangga.fluxmongo.repository.RegistrationRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;

	public Flux<StudentModels> getAll() {
		return registrationRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<StudentModels> getById(final String id) {
		return registrationRepository.findById(id);
	}

	public Mono update(final String id, final StudentModels student) {
		return registrationRepository.save(student);
	}

	public Mono save(final StudentModels student) {
		return registrationRepository.save(student);
	}
	
	public Mono delete(final String id) {
		final Mono<StudentModels> dbStudent = getById(id);
		if (Objects.isNull(dbStudent)) {
			return Mono.empty();
		}
		return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(studentToBeDeleted -> registrationRepository
				.delete(studentToBeDeleted).then(Mono.just(studentToBeDeleted)));
	}

}
