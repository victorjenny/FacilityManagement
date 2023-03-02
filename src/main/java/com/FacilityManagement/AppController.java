package com.FacilityManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ClassRoomService fservice;
    @Autowired
    private PCRoomService pservice;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        System.out.println("----------------------------------------------------------");
        List<ClassRoom> ft_users = fservice.listAll(); // class room
        List<PCRoom> pt_users = pservice.listAll(); // pc room

        model.addAttribute("ft_users", ft_users); // index page
        model.addAttribute("pt_users", pt_users); // index page
        System.out.println("No of class room: " + ft_users.size());
        System.out.println("No of PC Room: " + pt_users.size());

        return "index"; // home page
    }

    // to add a new class room
    @RequestMapping("/new_classroom")
    public String ShowNewFullTimeUserForm(Model model) {
        Room room = new ClassRoom();
        room.setDtype("Class Room");

        model.addAttribute("room", room);
        return "new_classroom"; // new_classroom form
    }

    // to add a new pc room
    @RequestMapping("/new_pcroom")
    public String ShowNewPartTimeUserForm(Model model) {
        Room room = new PCRoom();
        room.setDtype("PC Room");

        model.addAttribute("room", room);
        return "new_pcroom"; // new_pcroom form
    }

    // to save a new class room to the database
    @RequestMapping(value = "/save_ftuser", method = RequestMethod.POST)
    public String saveFullTimeUser(@ModelAttribute("ftuser") ClassRoom ftuser) {
        fservice.save(ftuser); // save to Room table
        System.out.println("write to the Room  table (class room).");
        return "redirect:/"; // return to index page
    }

    // to save a new pc room to the database
    @RequestMapping(value = "/save_ptuser", method = RequestMethod.POST)
    public String savePartTimeUser(@ModelAttribute("ptuser") PCRoom ptuser) {
        pservice.save(ptuser); // save to Room table
        System.out.println("write to the room table (pc room).");

        return "redirect:/"; // return to index page
    }

    // to update a class room in the database
    @RequestMapping("/edit_classroom/{mode}")
    public ModelAndView showEditFullTimeUserPage(@PathVariable(name = "mode") String mode) {
        ModelAndView mav = new ModelAndView("edit_classroom"); // edit_classroom form
        Room room = fservice.get(mode);
        mav.addObject("ftuser", room);

        return mav;
    }

    // to update a pc room in the database
    @RequestMapping("/edit_pcroom/{mode}")
    public ModelAndView showEditPartTimeUserPage(@PathVariable(name = "mode") String mode) {
        ModelAndView mav = new ModelAndView("edit_pcroom"); // edit_pcroom form
        Room room = pservice.get(mode);
        mav.addObject("ptuser", room);

        return mav;
    }

    // to delete a class room from the database
    @RequestMapping("/delete_classroom/{courseid}")
    public String deleteFullTimeUser(@PathVariable(name = "courseid") String courseid) {
        fservice.delete(courseid); // delete room from room table

        return "redirect:/"; // return to index page
    }

    // to delete a pc room from the database
    @RequestMapping("/delete_pcroom/{courseid}")
    public String deletePartTimeUser(@PathVariable(name = "courseid") String courseid) {
        pservice.delete(courseid); // delete room from room table

        return "redirect:/"; // return to index page
    }
}
