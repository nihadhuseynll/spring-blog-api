package com.example.springblogapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTagsRequest {

    @NotEmpty(message = "At least one tag name is required")
    @Size(max = 10, message = "Maximum {max} tags allowed")
    private Set<
            @Size(min = 2, max = 30, message = "Tag name must be between {min} and {max} characters")
            @Pattern(regexp = "^[\\w\\s-]+$", message = "Tag name can only contain letters, numbers, spaces and hyphens")
                    String> names;
}
