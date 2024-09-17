package be.vdab.landen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("landen")
public class LandController {
    private final LandService landService;

    LandController(LandService landService) {
        this.landService = landService;
    }

    @GetMapping("aantal")
    public long findAantal(){
        return landService.findAantal();
    }
}
