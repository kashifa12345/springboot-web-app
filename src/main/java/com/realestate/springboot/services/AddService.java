
package com.realestate.springboot.services;


import com.realestate.springboot.dto.ServiceDto;

import java.util.List;

public interface AddService {

    ServiceDto addService(ServiceDto services);

    ServiceDto updateService(ServiceDto services,Integer serviceId);

    ServiceDto getServiceById(Integer serviceId );

    List<ServiceDto> getAllServices();

    void deleteService(Integer serviceId );
}