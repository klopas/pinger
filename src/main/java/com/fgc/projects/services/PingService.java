package com.fgc.projects.services;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fgc.projects.controller.dto.PingResponseDto;
import com.fgc.projects.controller.dto.ServiceDto;
import com.fgc.projects.controller.dto.PingRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PingService {

    public List<PingResponseDto> ping(PingRequestDto pingRequestDto) {
        return pingRequestDto.getServices().stream().map(this::ping).collect(Collectors.toList());
    }

    private PingResponseDto ping(final ServiceDto serviceVO) {
        try (Socket socket = new Socket()) {
            final URL url = new URL(serviceVO.getAddress());
            socket.connect(new InetSocketAddress(url.getHost(), url.getPort()), 3000);
            return PingResponseDto.builder().name(serviceVO.getName()).address(
              serviceVO.getAddress()).status("SUCCESS").build();
        } catch (Exception e) {
            return PingResponseDto.builder().name(serviceVO.getName()).address(
          serviceVO.getAddress()).status("FAILED").build();
        }
    }
}
