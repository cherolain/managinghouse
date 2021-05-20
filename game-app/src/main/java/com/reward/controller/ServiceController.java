package com.reward.controller;


import com.reward.entity.Premi;
import com.reward.entity.Tasks;
import com.reward.repo.PremiRepo;
import com.reward.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    PremiRepo premiRepo;
    @Autowired
    private TaskRepo taskRepo;
    private final int PAGINEN=7;

    @GetMapping("/aggiungiTask")
    public String aggiungiTask(@ModelAttribute("modifica")Optional<String> modifica,  Model model, @RequestParam(value = "page",defaultValue = "0") int page) {
        Tasks t = new Tasks();
        Pageable p = PageRequest.of(page, PAGINEN);
        Page<Tasks> tasks = taskRepo.findAllByCompletatoFalse(p);
        if(modifica.isPresent()){
            model.addAttribute("modifica",modifica.get());
        }
        model.addAttribute("task", t);
        model.addAttribute("ts", tasks);
        int totalPages = tasks.getTotalPages();
      /*  List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages-1)
                    .boxed()
                    .collect(Collectors.toList());*/
        model.addAttribute("pageNumbers", totalPages);

        return "tasks";
    }

    @GetMapping("/aggiungiPremio")
    public String aggiungiPremio(@ModelAttribute("ins") Optional<String> ins, Model model, @RequestParam(value = "page",defaultValue = "0") int page){
        if(ins.isPresent()){
            model.addAttribute( "ins",ins.get());
            System.out.println(ins);
        }
        Premi p=new Premi();
        Pageable pag = PageRequest.of(page, PAGINEN);
        Page<Premi> premi=premiRepo.findAllByRiscattatoFalse(pag);
        model.addAttribute("premio",p);
        model.addAttribute("premi", premi);
        model.addAttribute("pageNumbers", premi.getTotalPages());
        return "premi";
    }



}
