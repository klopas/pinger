package com.fgc.projects.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class PingResponseDto {

  private String name;

  private String address;

  private String status;

}
