package learn.employee.team;

import jakarta.validation.constraints.NotEmpty;

public record TeamDto(
        @NotEmpty(message = "Team can't be empty")
        String name
) {
}
