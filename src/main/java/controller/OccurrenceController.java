package controller;

import entity.Occurrence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.OccurrenceRepository;

import java.util.List;

@CrossOrigin("*")
@Controller
public class OccurrenceController {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    @RequestMapping(value = "/occurrence", method = RequestMethod.POST)
    @ResponseBody
    public Occurrence save(@RequestBody Occurrence occurrence){

        return occurrenceRepository.save(occurrence);
    }

    @RequestMapping(value = "/occurrence", method = RequestMethod.GET)
    @ResponseBody
    public List<Occurrence> getAll(){

        return (List<Occurrence>) occurrenceRepository.findAll();
    }

}
