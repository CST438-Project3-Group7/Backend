package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.Subject;
import com.csumb.project3Backend.repos.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  // Get all subjects
  public List<Subject> getAllSubjects() {
    return subjectRepository.findAll();
  }

  // Get a subject by ID
  public Optional<Subject> getSubjectById(Long id) {
    return subjectRepository.findById(id);
  }

  // Create a new subject
  public Subject createSubject(Subject subject) {
    return subjectRepository.save(subject);
  }

  // Update an existing subject
  public Subject updateSubject(Long id, Subject updatedSubject) {
    return subjectRepository.findById(id)
        .map(subject -> {
          subject.setTitle(updatedSubject.getTitle());
          subject.setYear(updatedSubject.getYear());
          subject.setType(updatedSubject.getType());
          subject.setFavorites(updatedSubject.getFavorites());
          return subjectRepository.save(subject);
        })
        .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
  }

  // Delete a subject
  public void deleteSubject(Long id) {
    if (!subjectRepository.existsById(id)) {
      throw new RuntimeException("Subject not found with id: " + id);
    }
    subjectRepository.deleteById(id);
  }
}

