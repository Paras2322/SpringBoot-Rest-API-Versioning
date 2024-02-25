package com.projectversioning.controller;

import com.projectversioning.entities.Name;
import com.projectversioning.entities.PersonV1;
import com.projectversioning.entities.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    // 1st Way of Versioning - URI Based Versioning

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Paras Bagga");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Paras", "Bagga"));
    }

//      --------------------------------------------------------------------------------

    // 2nd Way of Versioning - Request Parameter Versioning

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Paras Bagga");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Paras", "Bagga"));
    }

//    ---------------------------------------------------------

    // 3rd Way of Versioning - Custom Header Versioning

    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Paras Bagga");
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Paras", "Bagga"));
    }

//    ---------------------------------------------------------

    // 4th Way of Versioning - Media Type Versioning ( "Content Negotiaiton" or "Accept Header")

    @GetMapping(value = "/person", produces = "application/person.v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Paras Bagga");
    }

    @GetMapping(value = "/person", produces = "application/person.v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Paras", "Bagga"));
    }

}
