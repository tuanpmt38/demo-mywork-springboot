package vn.shippo.demomywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.shippo.demomywork.model.MyWork;
import vn.shippo.demomywork.model.User;
import vn.shippo.demomywork.model.UserPrincipal;
import vn.shippo.demomywork.service.MyWorkService;
import vn.shippo.demomywork.service.UserService;
import vn.shippo.demomywork.validation.MyWorkValidation;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/myworks")
public class MyWorkController {

    private UserService userService;
    private MyWorkService myWorkService;
    @Autowired
    public MyWorkController(MyWorkService myWorkService, UserService userService){
        this.myWorkService = myWorkService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView getAllByUserId(Pageable pageable){

        ModelAndView modelAndView = new ModelAndView("list");
        Iterable<MyWork> myWorks = myWorkService.findAll();
        modelAndView.addObject("mywork", myWorks);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("mywork", new MyWork());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createMyWork(@Valid @ModelAttribute("mywork") MyWork myWork, BindingResult bindingResult){

        ModelAndView modelAndView = new ModelAndView("create");
        new MyWorkValidation(myWorkService).validate(myWork, bindingResult);

        if(bindingResult.hasFieldErrors()){
            return modelAndView;
        }
        myWorkService.save(myWork);
        modelAndView.addObject("mywork", new MyWork());
        modelAndView.addObject("message", "create my work successfully");
        return modelAndView;

    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteForm(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Optional<MyWork> myWork = myWorkService.findById(id);

        if(myWork.isPresent()){
            modelAndView.addObject("mywork", myWork.get());
        }

        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public String deleteMywork(@ModelAttribute("mywork") MyWork myWork){
        myWorkService.delete(myWork.getId());
        return "redirect:/myworks/";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable("id")Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        Optional<MyWork> myWork = myWorkService.findById(id);

        if(myWork.isPresent()){
            modelAndView.addObject("mywork", myWork.get());
        }

        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView editMyWork(@ModelAttribute("mywork") MyWork myWork){
        ModelAndView modelAndView = new ModelAndView("edit");
        myWorkService.save(myWork);
        modelAndView.addObject("mywork", myWork);
        modelAndView.addObject("message","update successfully");
        return modelAndView;
    }

}
