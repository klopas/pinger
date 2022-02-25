package com.fgc.projects.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ServiceDto {

  private String name;

  private String address;

}
