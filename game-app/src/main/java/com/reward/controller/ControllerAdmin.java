package com.reward.controller;


import com.reward.entity.Premi;
import com.reward.entity.Tasks;
import com.reward.repo.PremiRepo;
import com.reward.repo.TaskRepo;
import com.reward.repo.UtentiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class ControllerAdmin {

    @Autowired
    UtentiRepo utenteRepo;
    @Autowired
    PremiRepo premiRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    ServiceController sv;

    private final int PAGINEN=7;


    @GetMapping("/")
    public String tornaHome(){
        return "index";
    }


    @GetMapping("/visualizzaStat")
    public String visualizza(Model model,  @RequestParam(value = "page",defaultValue = "0") int page){
        Pageable pag= PageRequest.of(page,PAGINEN);
        Page<Tasks> pagu=taskRepo.findAllByCompletatoTrue(pag);
        Page<Premi> pagp=premiRepo.findAllByRiscattatoTrue(pag);
        model.addAttribute("premi", pagp);
        model.addAttribute("tasks", pagu);

        return "admin-visualizza-statistiche";

    }

  /*  @GetMapping("/aggiungiTask")
    public String aggiungiTask(Model model,@RequestParam (value = "page",defaultValue = "0") int page) {
        Tasks t = new Tasks();
        Pageable p = PageRequest.of(page, PAGINEN);
        Page<Tasks> tasks = taskRepo.findAll(p);
        model.addAttribute("task", t);
        model.addAttribute("ts", tasks);
        int totalPages = tasks.getTotalPages();
        model.addAttribute("pageNumbers", totalPages);
        return "tasks";
    }
*/
    @GetMapping("/eliminaTask")
    public String eliminaTask(@RequestParam("id") int id){
        taskRepo.deleteById(id);
        return "redirect:/service/aggiungiTask";
    }


    @PostMapping("/addTask")
    public String addTask(@ModelAttribute ("task") Tasks t, RedirectAttributes redirectAttributes){
        if(t.getId()!=0){
            redirectAttributes.addFlashAttribute("modifica","Modificato con successo");
        }else
            redirectAttributes.addFlashAttribute("modifica", "Inserimento avvenuto");
        taskRepo.save(t);
        return "redirect:/service/aggiungiTask";
    }

    @PostMapping("/addPremio")
    public String addPremio(@ModelAttribute ("premio") Premi p, RedirectAttributes redirectAttributes){

        premiRepo.save(p);
        return "redirect:/service/aggiungiPremio";

    }
    @GetMapping("/eliminaPremio")
    public String eliminaPremio(@RequestParam("id") int id){
        premiRepo.deleteById(id);
        return "redirect:/service/aggiungiPremio";
    }
}
