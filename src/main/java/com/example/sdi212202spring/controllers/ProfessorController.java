package com.example.sdi212202spring.controllers;


import com.example.sdi212202spring.entities.Mark;
import com.example.sdi212202spring.entities.Professor;
import com.example.sdi212202spring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired //Inyectar el servicio
    private ProfessorService ProfessorsService;

    @RequestMapping("/professor/list")
    public String getList() {
        return ProfessorsService.getProfessor().toString();
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor Professor) {
        ProfessorsService.addProfessor(Professor);
        return "OK";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return ProfessorsService.getProfessor(id).toString();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        ProfessorsService.deleteProfessor(id);
        return "OK";
    }

    @RequestMapping("/professor/edit")
    public String getEdit(@PathVariable Long id) {
        return ProfessorsService.getProfessor(id).toString();
    }

    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Professor professor, @PathVariable Long id) {
        ProfessorsService.editProfessor(professor);
        return ProfessorsService.getProfessor(id).toString();
    }

}
