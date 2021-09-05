package com.m3832.skipicker.api;

import com.m3832.skipicker.service.SkiLengthsDto;
import com.m3832.skipicker.service.CalculateSkiLengthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkiPickerController {

    final CalculateSkiLengthService calculateSkiLengthService;

    public SkiPickerController(CalculateSkiLengthService calculateSkiLengthService) {
        this.calculateSkiLengthService = calculateSkiLengthService;
    }

    @GetMapping("/skilength")
    public ResponseEntity<GetRecommendedSkiLengthResponse> getRecommendedSkiLength(
            @RequestParam SkiStyleRequestParam skiStyle,
            @RequestParam Integer age,
            @RequestParam Integer height
    ) {
        final SkiLengthsDto skiLengthsDto =
                calculateSkiLengthService.calculateSkiLengths(height, age, skiStyle.name());
        return ResponseEntity.ok(mapToResponse(skiLengthsDto));
    }

    private GetRecommendedSkiLengthResponse mapToResponse(SkiLengthsDto skiLengthsDto) {
        return new GetRecommendedSkiLengthResponse(
                skiLengthsDto.getAbsoluteMinLength(),
                skiLengthsDto.getAbsoluteMaxLength(),
                skiLengthsDto.getRecommendedMinLength(),
                skiLengthsDto.getRecommendedMaxLength()
        );
    }
}
