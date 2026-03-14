package learn.employee.employerprofile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServices {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
}
