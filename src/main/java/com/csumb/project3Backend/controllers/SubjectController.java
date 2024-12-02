package com.csumb.project3Backend.controllers;


import com.csumb.project3Backend.entities.Subject;
import com.csumb.project3Backend.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  // Get all subjects
  @GetMapping
  public List<Subject> getAllSubjects() {
    return subjectService.getAllSubjects();
  }

  // Get a subject by ID
  @GetMapping("/{id}")
  public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
    return subjectService.getSubjectById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Create a new subject
  @PostMapping
  public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
    Subject createdSubject = subjectService.createSubject(subject);
    return ResponseEntity.ok(createdSubject);
  }

  // Update an existing subject
  @PutMapping("/{id}")
  public ResponseEntity<Subject> updateSubject(
      @PathVariable Long id,
      @RequestBody Subject updatedSubject) {
    try {
      Subject subject = subjectService.updateSubject(id, updatedSubject);
      return ResponseEntity.ok(subject);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // Delete a subject
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
    try {
      subjectService.deleteSubject(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

