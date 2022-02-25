package com.fgc.projects.controller.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class PingRequestDto {

  private List<ServiceDto> services;

}
