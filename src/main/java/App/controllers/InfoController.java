package App.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class InfoController {

    @Autowired
    private Environment environment;

    @Autowired(required = false)
    private Cloud cloud;

    @CrossOrigin
    @RequestMapping(value = "/profiles")
    public String[] profiles() {
        return environment.getActiveProfiles();
    }

    @CrossOrigin
    @RequestMapping(value = "/services")
    public String[] showServiceInfo() {
        if (cloud != null) {
            final List<ServiceInfo> serviceInfos = cloud.getServiceInfos();

            List<String> names = new ArrayList<>();
            for (ServiceInfo serviceInfo : serviceInfos) {
                names.add(serviceInfo.getId());
            }
            return names.toArray(new String[names.size()]);
        } else {
            return new String[]{};
        }
    }

}
