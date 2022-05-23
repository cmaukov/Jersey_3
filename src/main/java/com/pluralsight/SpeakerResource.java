package com.pluralsight;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.repository.SpeakerRepositoryStub;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;

import java.util.List;

/* conference-service
 * @created 05/20/2022
 * @author Konstantin Staykov
 */
@Path("speaker")
public class SpeakerResource {

    private SpeakerRepository speakerRepository = new SpeakerRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    @Path("{id}")
    @GET
    public Speaker getSpeaker(@PathParam("id") Long id) {
        return speakerRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker createSpeaker(Speaker speaker) {
        System.out.println("Bound object");
        System.out.println(speaker.getName());
        System.out.println(speaker.getCompany());

       speaker =  speakerRepository.create(speaker);
        return speaker;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker createSpeakerWithParams(MultivaluedMap<String, String> formParams) {
        System.out.println(formParams.getFirst("name"));
        System.out.println(formParams.getFirst("company"));
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker updateSpeaker(Speaker speaker){
        speaker = speakerRepository.update(speaker);
        return speaker;
    }

}
