package security.controllers;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import shop.models.entity.User;
//import shop.models.entity.Product;
//import shop.models.entity.Share;
//import shop.service.UserService;
//import shop.service.ProductService;
//import shop.service.ShareService;
//
//import javax.validation.Valid;
//import java.util.*;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView defaultPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Login Form");
        model.addObject("message", "This is default page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Login Form");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid login and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("login", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }
//
//    private UserService userService;
//
//
//    @Autowired(required = true)
//    @Qualifier(value = "userService")
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//
//
//
//
//
//    @RequestMapping("/")
//    public String start(Model model) {
//
//        return "start";
//    }
//
//    @RequestMapping("/login?error")
//    public String error(Model model) {
//
//        return "error";
//    }
//
//    /*  **********************        USER            ****************************/
//
//    @RequestMapping({"/saveUser","/user/saveUser"})
//    public String save() {
//
//        return "saveUser";
//    }
//
//
//
//    @RequestMapping("/user/save")
//    public ModelAndView saveUser(@ModelAttribute("user") User user, Map<String, Object> model) {
//
//
//
//            this.userService.save(user);
//            user = (User) this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());
//            return  new ModelAndView("cabinetUser", "user", user);
//
//
//
//    }
//
//
//
////    @RequestMapping("/user/login")
////    public ModelAndView loginAdmin(@ModelAttribute("user") User user) {
////
////       user = (User) this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());
////
////        return  new ModelAndView("cabinetUser", "user", user);
////
////    }
//
//
//    /*  Open data User in viewUser.ftl     */
//    @RequestMapping("/user/view")
//    public ModelAndView viewUser(long id) {
//        User user = (User) this.userService.getById(id);
//        return new ModelAndView("viewUser", "user", user);
//    }
//
//    @RequestMapping("/user/cabinet")
//    public ModelAndView cabinetUser(@ModelAttribute("user") User user) {
//
//         user = (User) this.userService.getById(user.getId());
//        return new ModelAndView("cabinetUser", "user", user);
//    }
//
//    @RequestMapping("/user/update")
//    public ModelAndView updateUser(@ModelAttribute("user") User user, long id) {
//        user.setId(id);
//        this.userService.update(user);
//         user = (User) this.userService.getById(id);
//
//        return  new ModelAndView("cabinetUser", "user", user);
//
//    }
//
//
//
//
//
//
//
}
