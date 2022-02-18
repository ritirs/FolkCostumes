package ee.bcs.folkcostumes.logIn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log")
public class LoginController {

    @Resource
    private LoginService loginService;

//    @GetMapping("/in")
//    public LoginResponse login (@RequestParam String userName, @RequestParam String password) {
//        return loginService.login(userName, password);
//    }

}
