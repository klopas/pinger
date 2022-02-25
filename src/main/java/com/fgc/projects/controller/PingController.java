package com.fgc.projects.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fgc.projects.controller.dto.PingRequestDto;
import com.fgc.projects.controller.dto.PingResponseDto;
import com.fgc.projects.services.PingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PingController {

  private final PingService pingService;

  @PostMapping("/ping")
  public ResponseEntity<List<PingResponseDto>> ping(@RequestBody PingRequestDto pingRequestDto) {
    return ResponseEntity.ok(this.pingService.ping(pingRequestDto));
  }

}
