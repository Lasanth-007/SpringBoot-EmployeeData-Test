package learn.employee.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServices {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
}
