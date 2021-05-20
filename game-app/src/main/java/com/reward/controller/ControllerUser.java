package com.reward.controller;


import com.reward.entity.Premi;
import com.reward.entity.Tasks;
import com.reward.entity.Utente;
import com.reward.repo.PremiRepo;
import com.reward.repo.UtentiRepo;
import com.reward.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UtentiRepo utentiRepo;
    @Autowired
    private PremiRepo premiRepo;
    @Autowired
    ServiceController sv;


    @GetMapping("/")
    public String tornaHome(){
        return "index";
    }

    @GetMapping("/completaTask")
    public String visualizza(@RequestParam("id")int id,@AuthenticationPrincipal UserDetails userDetails){
        if (userDetails==null){
            return "redirect:/login";
        }
        Optional<Utente> us= utentiRepo.findByNome(userDetails.getUsername());

        Optional<Tasks> t=taskRepo.findById(id);
        if(t.isPresent()){
            us.get().setTasks(t.get());
            t.get().setCompletato(true);
            utentiRepo.save(us.get());
        }

        return "redirect:/service/aggiungiTask";
    }


    @GetMapping("/visualizzaStat")
    public  String visualizzaStat(@AuthenticationPrincipal UserDetails us, Model model){

        if (us==null){
            return "redirect:/login";
        }
        Optional<Utente> utente= utentiRepo.findByNome(us.getUsername());

        model.addAttribute("utente", utente.get());
        return "statistiche";
    }


    @GetMapping("/riscattaPremio")
    public String riscattaPremio(@RequestParam("id")int id,@AuthenticationPrincipal UserDetails userDetails, RedirectAttributes redirectAttributes){
        if (userDetails==null){
            return "redirect:/login";
        }
        Optional<Utente> us= utentiRepo.findByNome(userDetails.getUsername());
        Optional<Premi> pr= premiRepo.findById(id);
        if(pr.isPresent() && pr.get().getPunti()<= us.get().getPunteggio()){
            us.get().setPremi(pr.get());
            pr.get().setRiscattato(true);
            utentiRepo.save(us.get());
        }else{
           redirectAttributes.addFlashAttribute("ins","non disponi dei punti necessari");

        }
        return "redirect:/service/aggiungiPremio";
    }
}
