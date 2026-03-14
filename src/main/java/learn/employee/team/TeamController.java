package learn.employee.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamServices teamServices;


    @PostMapping
    public ResponseEntity<TeamDto> addTeam(
            @RequestBody TeamDto teamDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teamServices.addTeam(teamDto));
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> GetTeams(){
        return ResponseEntity.ok(teamServices.GetTeams());
    }

}
